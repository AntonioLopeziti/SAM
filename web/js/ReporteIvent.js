/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Reportes.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#ejecutar').click(function () {
        if ($('#materialivent').val().length > 0) {
            if (validarDato("materialivent", "ValidarMaterial", "&mat=" + $('#materialivent').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#materialivent').val().toUpperCase());
                $('#materialivent').val('');
                $('#materialivent').focus();
                return;
            }
        }
        if ($('#almivent').val().length > 0) {
            if (validarDato("almivent", "ValidarAlmacen", "&alm=" + $('#almivent').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#almivent').val().toUpperCase());
                $('#almivent').val('');
                $('#almivent').focus();
                return;
            }
        }
        ValidarQuery();
    });
    function ValidarQuery() {
        var radio = "";
        var r = $('[name = "rb"]');
        for (i = 0; i < r.length; i++) {
            if (r[i].checked) {
                radio = r[i].value;
            }
        }
        var MATE = $('#materialivent').val();
        var ALMA = $('#almivent').val();
        var FEC1 = $('#fechainicio').val();
        var FEC2 = $('#fechafin').val();
        var acc = "ValidarQuery";
        var param = "&MATE=" + MATE + "&ALMA=" + ALMA + "&FEC1=" + FEC1 + "&FEC2=" + FEC2 + "&RADI=" + radio;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteMovimientosIvent',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + param,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    window.location.href = "VisualizarReporteMovimientosIvent.jsp?Accion=CargarTabla" + param;
                }
            }
        });
    }
    var arr = [
        $('#materialivent'),
        $('#almivent'),
        $('#fechainicio'),
        $('#fechafin')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4')
    ];
    $.each(arr, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    posicionm(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("materialivent", "ValidarMaterial", "&mat=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 1:
                v.focus(function () {
                    posicionm(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("almivent", "ValidarAlmacen", "&alm=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    posicionm(2);
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
            case 3:
                v.focus(function () {
                    posicionm(3);
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
        }

    });
    $.each(arrm, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultaMaterialIvent();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaAlmacenIvent();
                });
                break;
            case 2:
                v.click(function () {
                    OpenCalendario("fechainicio");
                });
                break;
            case 3:
                v.click(function () {
                    OpenCalendario("fechafin");
                });
                break;
        }
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    function posicionm(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    function ConsultaMaterialIvent() {
        var acc = "CargarMaterialIvent";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteMovimientosIvent',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
                } else {
                    MostrarVentanaModal('VentanaModalMaterial', 'handle');
                    $('#cargarDatosMaterialIvent').html(data);
                    fnc('table-scrollMI', 'fixedYMI');
                    borramsg();
                }
            }
        });
    }
    function ConsultaAlmacenIvent() {
        var acc = "CargarAlmacenIvent";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteMovimientosIvent',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
                } else {
                    MostrarVentanaModal('VentanaModalAlmacenIvent', 'handle2');
                    $('#cargarDatosalmacen').html(data);
                    fnc('table-scrollAlma', 'fixedYalma');
                    borramsg();
                }
            }
        });
    }
    $('#OCULMI').click(function () {
        ocultarVentana('materialivent', "VentanaModalMaterial");
    });
    $('#OCULAI').click(function () {
        ocultarVentana('almivent', "VentanaModalAlmacenIvent");
    });

});
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionReporteMovimientosIvent',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + param,
            success: function (data) {
                if (data != 0) {
                    ban = true;
                }
            }
        });
    }
    return ban;
}
function MostrarVentanaModal(id, handle) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function ocultarVentana(id, ventana) {
    $('#' + ventana).css('display', 'none');
    $('#' + id).focus();
}

function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
}
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    $('#tiempo').html(h + ":" + m + ":" + s);
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
function Selecdata(dato, id, ven) {
    $('#' + id).val(dato);
    ocultarVentana(id, ven);
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#IDFecha").val(id);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Calenndar');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handlecalendar");
    var theRoot = document.getElementById("Calenndar");
    Drag.init(theHandle, theRoot);
    $('#datapicker').datepicker().show();
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
}