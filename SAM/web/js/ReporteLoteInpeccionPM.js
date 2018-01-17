/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    CargarCentros();
    patron = /[0-9a-zA-ZñÑ]/;
    $('#iconmsg').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Reportes.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    var arri = [
        $('#centro'),
        $('#sam1'),
        $('#lote1'),
        $('#fechainicio'),
        $('#usuario'),
        $('#sam2'),
        $('#lote2'),
        $('#fechafin')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6'),
        $('#match_A7')
    ];
    $('#ejecutar').click(function () {
        if ($('#sam1').val().length > 0) {
            if (validarDato("sam1", "ValidaDato", "&var1=" + $('#sam1').val() + "&var2=SAM") == false) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", $('#sam1').val().toUpperCase());
                $('#sam1').val('');
                $('#sam1').focus();
                return;
            }
        }
        if ($('#sam2').val().length > 0) {
            if (validarDato("sam2", "ValidaDato", "&var1=" + $('#sam2').val() + "&var2=SAM") == false) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", $('#sam2').val().toUpperCase());
                $('#sam2').val('');
                $('#sam2').focus();
                return;
            }
        }
        if ($('#lote1').val().length > 0) {
            if (validarDato("lote1", "ValidaDato", "&var1=" + $('#lote1').val() + "&var2=LOT") == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#lote1').val().toUpperCase());
                $('#lote1').val('');
                $('#lote1').focus();
                return;
            }
        }
        if ($('#lote2').val().length > 0) {
            if (validarDato("lote2", "ValidaDato", "&var1=" + $('#lote2').val() + "&var2=LOT") == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#lote2').val().toUpperCase());
                $('#lote2').val('');
                $('#lote2').focus();
                return;
            }
        }
        if ($('#usuario').val().length > 0) {
            if (validarDato("usuario", "ValidaDato", "&var1=" + $('#usuario').val() + "&var2=USU") == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#usuario').val().toUpperCase());
                $('#usuario').val('');
                $('#usuario').focus();
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
        var CENT = $('#centro').val();
        var SAM1 = $('#sam1').val();
        var SAM2 = $('#sam2').val();
        var LOT1 = $('#lote1').val();
        var LOT2 = $('#lote2').val();
        var FEC1 = $('#fechainicio').val();
        var FEC2 = $('#fechafin').val();
        var USUA = $('#usuario').val();
        var acc = "ValidarQuery";
        var param = "&CENT=" + CENT + "&SAM1=" + SAM1 + "&SAM2=" + SAM2 + "&LOT1=" + LOT1 + "&LOT2=" + LOT2;
        var par = param + "&FEC1=" + FEC1 + "&FEC2=" + FEC2 + "&RADI=" + radio + "&USUA=" + USUA ;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteLotesInspeccionPM',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $(location).attr('href','VisualizarReporteLotesInspeccionPM.jsp?Accion=CargarTabla'+par);
                }
            }
        });
    }
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
                    ConsultaLotePM();
                });
                break;
            case 2:
                v.click(function () {
                    OpenCalendario('fechainicio');
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaUSSer();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaFolioSAM2();
                });
                break;
            case 5:
                v.click(function () {
                    ConsultaLotePM2();
                });
                break;
            case 6:
                v.click(function () {
                    OpenCalendario('fechafin');
                });
                break;
        }
    });
    $.each(arri, function (i, v) {
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
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sam1", "ValidaDato", "&var1=" + v.val() + "&var2=SAM") == true) {
                                borramsg();
                            } else {
                                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("lote1", "ValidaDato", "&var1=" + v.val() + "&var2=LOT") == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 3:
                v.focus(function () {
                    checarPosiMa(2);
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
            case 4:
                v.focus(function () {
                    checarPosiMa(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("usuario", "ValidaDato", "&var1=" + v.val() + "&var2=USU") == true) {
                                borramsg();
                            } else {
                                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 5:
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sam2", "ValidaDato", "&var1=" + v.val() + "&var2=SAM") == true) {
                                borramsg();
                            } else {
                                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }

                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 6:
                v.focus(function () {
                    checarPosiMa(5);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("lote2", "ValidaDato", "&var1=" + v.val() + "&var2=LOT") == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 7:
                v.focus(function () {
                    checarPosiMa(6);
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
    function checarPosiMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#OCULSAM').click(function () {
        ocultarVentana('sam1', "VentanaModalSAM");
    });
    $('#OCULSAM2').click(function () {
        ocultarVentana('sam2', "VentanaModalSAM2");
    });
    $('#OCULLOTEPM').click(function () {
        ocultarVentana('lote1', "VentanaModalLotePM");
    });
    $('#OCULLOTEPM2').click(function () {
        ocultarVentana('lote2', "VentanaModalLotePM2");
    });
    $('#OCULUsuario').click(function () {
        ocultarVentana('usuario', "VentanaModalUsuario");
    });
});
function ConsultaFolioSAM() {
    var acc = "CargarSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM', 'handle');
                $('#cargarDatosFolioSAM').html(data);
                fnc('table-scrollSAM', 'fixedYSAM');
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
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM2', 'handle2');
                $('#cargarDatosFolioSAM2').html(data);
                fnc('table-scrollSAM2', 'fixedYSAM2');
                borramsg();
            }
        }
    });
}
function ConsultaLotePM() {
    var acc = "CargarLotePM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalLotePM', 'handle3');
                $('#cargarDatosLotePM').html(data);
                fnc('table-scrollLotePM', 'fixedYLotePM');
                borramsg();
            }
        }
    });
}
function ConsultaLotePM2() {
    var acc = "CargarLotePM2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalLotePM2', 'handle4');
                $('#cargarDatosLotePM2').html(data);
                fnc('table-scrollLotePM2', 'fixedYLotePM2');
                borramsg();
            }
        }
    });
}
function ConsultaUSSer() {
    var acc = "CargarUsuarios";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalUsuario', 'handle5');
                $('#cargarDatosUsuario').html(data);
                fnc('table-scrollUsuario', 'fixedYUsuario');
                borramsg();
            }
        }
    });
}

function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteLotesInspeccionPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#centro').html(data);
        }
    });
}
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
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
function ocultarVentana(id, ventana) {
    $('#' + ventana).css('display', 'none');
    $('#' + id).focus();
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
function seleccionar(dato, id) {
    switch (id) {
        case "sam":
            $('#sam1').val(dato);
            ocultarVentana("sam1", "VentanaModalSAM");
            break;
        case "sam2":
            $('#sam2').val(dato);
            ocultarVentana("sam2", "VentanaModalSAM2");
            break;
        case "lote":
            $('#lote1').val(dato);
            ocultarVentana("lote1", "VentanaModalLotePM");
            break;
        case "lote2":
            $('#lote2').val(dato);
            ocultarVentana("lote2", "VentanaModalLotePM2");
            break;
        case "usser":
            $('#usuario').val(dato);
            ocultarVentana("usuario", "VentanaModalUsuario");
            break;
    }
}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionReporteLotesInspeccionPM',
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