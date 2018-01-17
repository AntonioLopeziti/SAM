/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    CargarCentros();
    $('#iconmsg').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Reportes.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#ejecutar').click(function () {
        if ($('#sami').val().length > 0) {
            if (validarDato("sami", "ValidarSAM", "&sam=" + $('#sami').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#sami').val().toUpperCase());
                $('#sami').val('');
                $('#sami').focus();
                return;
            }
        }
        if ($('#samf').val().length > 0) {
            if (validarDato("samf", "ValidarSAM", "&sam=" + $('#samf').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#samf').val().toUpperCase());
                $('#samf').val('');
                $('#samf').focus();
                return;
            }
        }
        if ($('#sapi').val().length > 0) {
            if (validarDato("sapi", "ValidarSAP", "&sap=" + $('#sapi').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sapi').val().toUpperCase());
                $('#sapi').val('');
                $('#sapi').focus();
                return;
            }
        }
        if ($('#sapf').val().length > 0) {
            if (validarDato("sapf", "ValidarSAP", "&sap=" + $('#sapf').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sapf').val().toUpperCase());
                $('#sapf').val('');
                $('#sapf').focus();
                return;
            }
        }
        ValidarQuery();
    });
    function ValidarQuery() {
        var check = "0";
        var radio = "";
        if ($('#ch1').is(':checked')) {
            check = "1";
        }
        var r = $('[name = "rb"]');
        for (i = 0; i < r.length; i++) {
            if (r[i].checked) {
                radio = r[i].value;
            }
        }
        var CENT = $('#centro').val();
        var SAM1 = $('#sami').val();
        var SAM2 = $('#samf').val();
        var SAP1 = $('#sapi').val();
        var SAP2 = $('#sapf').val();
        var FEC1 = $('#fechainicio').val();
        var FEC2 = $('#fechafin').val();
        var acc = "ValidarQuery";
        var param = "&CENT=" + CENT + "&SAM1=" + SAM1 + "&SAM2=" + SAM2 + "&SAP1=" + SAP1 + "&SAP2=" + SAP2;
        var par = param + "&FEC1=" + FEC1 + "&FEC2=" + FEC2 + "&RADI=" + radio + "&CHEK=" + check;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteSolPedidos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    window.location.href = "VisualizarReporteSolPed.jsp?Accion=CargarTabla" + par;
                }
            }
        });
    }
    var arr = [
        $('#centro'),
        $('#sami'),
        $('#samf'),
        $('#sapi'),
        $('#sapf'),
        $('#fechainicio'),
        $('#fechafin')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6')
    ];
    $.each(arr, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 1:
                v.focus(function () {
                    checarPosiMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sami", "ValidarSAM", "&sam=" + v.val()) == true) {
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
            case 2:
                v.focus(function () {
                    checarPosiMa(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("samf", "ValidarSAM", "&sam=" + v.val()) == true) {
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
            case 3:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sapi", "ValidarSAP", "&sap=" + v.val()) == true) {
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
            case 4:
                v.focus(function () {
                    checarPosiMa(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sapf", "ValidarSAP", "&sap=" + v.val()) == true) {
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
            case 5:
                v.focus(function () {
                    checarPosiMa(4);
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
            case 6:
                v.focus(function () {
                    checarPosiMa(5);
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
                    ConsultaFolioSAM();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaFolioSAP();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultaFolioSAM2();
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaFolioSAP2();
                });
                break;
            case 4:
                v.click(function () {
                    OpenCalendario("fechainicio");
                });
                break;
            case 5:
                v.click(function () {
                    OpenCalendario("fechafin");
                });
                break;
        }
    });
    function checarPosiMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    ///////
    $('#OCUMatchFSAM').click(function () {
        ocultarVentana('sami', "VentanaModalSAM");
    });
    $('#OCUMatchFSAM2').click(function () {
        ocultarVentana('samf', "VentanaModalSAM2");
    });
    $('#OCUMatchFSAP1').click(function () {
        ocultarVentana('sapi', "VentanaModalSAP");
    });
    $('#OCUMatchFSAP2').click(function () {
        ocultarVentana('sapf', "VentanaModalSAP2");
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
});
function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteSolPedidos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#centro').html(data);
        }
    });
}

function ConsultaFolioSAM() {
    var acc = "CargarSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteSolPedidos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM', 'handle');
                $('#cargarDatosFolioSAM').html(data);
                fnc('table-scrollS', 'fixedYS');
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM2() {
    var acc = "CargarSAM2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteSolPedidos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM2', 'handle2');
                $('#cargarDatosFolioSAM2').html(data);
                fnc('table-scrollS2', 'fixedYS2');
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP() {
    var acc = "CargarSAP";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteSolPedidos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAP', 'handle3');
                $('#cargarDatosFolioSAP').html(data);
                fnc('table-scrollSP', 'fixedYSP');
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP2() {
    var acc = "CargarSAP2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteSolPedidos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAP2', 'handle4');
                $('#cargarDatosFolioSAP2').html(data);
                fnc('table-scrollSP2', 'fixedYSP2');
                borramsg();
            }
        }
    });
}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionReporteSolPedidos',
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
function ocultarVentana(id, ventana) {
    $('#' + ventana).css('display', 'none');
    $('#' + id).focus();
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
