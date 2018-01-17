/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    patron = /[0-9a-zA-Z]/;
    CargarCentros();
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
        $('#sap1'),
        $('#fecha_inicio'),
        $('#sam2'),
        $('#sap2'),
        $('#fecha_fin')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6')
    ];
    $('#ejecutar').click(function () {
        if ($('#sam1').val().length > 0) {
            if (validarDato("sam1", "ValidarSAM", "&sam=" + $('#sam1').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#sam1').val().toUpperCase());
                $('#sam1').val('');
                $('#sam1').focus();
                return;
            }
        }
        if ($('#sam2').val().length > 0) {
            if (validarDato("sam2", "ValidarSAM", "&sam=" + $('#sam2').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#sam2').val().toUpperCase());
                $('#sam2').val('');
                $('#sam2').focus();
                return;
            }
        }
        if ($('#sap1').val().length > 0) {
            if (validarDato("sap1", "ValidarSAP", "&sap=" + $('#sap1').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sap1').val().toUpperCase());
                $('#sap1').val('');
                $('#sap1').focus();
                return;
            }
        }
        if ($('#sap2').val().length > 0) {
            if (validarDato("sap2", "ValidarSAP", "&sap=" + $('#sap2').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sap2').val().toUpperCase());
                $('#sap2').val('');
                $('#sap2').focus();
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
        var SAP1 = $('#sap1').val();
        var SAP2 = $('#sap2').val();
        var FEC1 = $('#fecha_inicio').val();
        var FEC2 = $('#fecha_fin').val();
        var acc = "ValidarQuery";
        var param = "&cen=" + CENT + "&sam=" + SAM1 + "&sam2=" + SAM2 + "&sap=" + SAP1 + "&sap2=" + SAP2;
        var par = param + "&fec=" + FEC1 + "&fec2=" + FEC2 + "&radio="+radio;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesEntradas',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $(location).attr('href','VisualizarReporteEntradas.jsp?Accion=CargarTabla' + par);
                }
            }
        });
    }
    $.each(arrm, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultarSAM();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultarSAP();
                });
                break;
            case 2:
                v.click(function () {
                    OpenCalendario("fecha_inicio");
                });
                break;
            case 3:
                v.click(function () {
                    ConsultarSAM2();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultarSAP2();
                });
                break;
            case 5:
                v.click(function () {
                    OpenCalendario("fecha_fin");
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
                            if (validarDato("sam1", "ValidarSAM", "&sam=" + v.val()) == true) {
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
            case 2:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sap1", "ValidarSAP", "&sap=" + v.val()) == true) {
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
                            if (validarDato("sam2", "ValidarSAM", "&sam=" + v.val()) == true) {
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
            case 5:
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sap2", "ValidarSAP", "&sap=" + v.val()) == true) {
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
    $('#CerrarMCENSAM').click(function () {
        ocultarVentana('sam1', 'VentanaModalSAM1');
    });
    $('#CerrarMCENSAM2').click(function () {
        ocultarVentana('sam2', 'VentanaModalSAM2');
    });
    $('#CerrarMCSAPE').click(function () {
        ocultarVentana('sap1', 'VentanaModalSAP1');
    });
    $('#CerrarMCSAPE2').click(function () {
        ocultarVentana('sap2', 'VentanaModalSAP2');
    });
});
function ConsultarSAM() {
    var acc = "ConsultaSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEntradas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarVentanaModal("VentanaModalSAM1", "handle");
                $('#cargarDatosFolioSAM1').html(data);
                fnc("table-scrollSAME1", "fixedYSAME1");
                borramsg();
            }
        }
    });
}
function ConsultarSAM2() {
    var acc = "ConsultaSAM2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEntradas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarVentanaModal("VentanaModalSAM2", "handle2");
                $('#cargarDatosFolioSAM2').html(data);
                fnc("table-scrollSAME2", "fixedYSAME2");
                borramsg();
            }
        }
    });
}
function ConsultarSAP() {
    var acc = "ConsultaSAP";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEntradas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarVentanaModal("VentanaModalSAP1", "handle3");
                $('#cargarDatosFolioSAP1').html(data);
                fnc("table-scrollSAP1", "fixedYSAP1");
                borramsg();
            }
        }
    });
}
function ConsultarSAP2() {
    var acc = "ConsultaSAP2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEntradas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarVentanaModal("VentanaModalSAP2", "handle4");
                $('#cargarDatosFolioSAP2').html(data);
                fnc("table-scrollSAP2", "fixedYSAP2");
                borramsg();
            }
        }
    });
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
function seleccionar(dato, id) {
    switch (id) {
        case "SAM":
            $('#sam1').val(dato);
            ocultarVentana('sam1', 'VentanaModalSAM1');
            break;
        case "SAM2":
            $('#sam2').val(dato);
            ocultarVentana('sam2', 'VentanaModalSAM2');
            break;
        case "SAP":
            $('#sap1').val(dato);
            ocultarVentana('sap1', 'VentanaModalSAP1');
            break;
        case "SAP2":
            $('#sap2').val(dato);
            ocultarVentana('sap2', 'VentanaModalSAP2');
            break;
    }
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
function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEntradas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#centro').html(data);
        }
    });
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
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'PeticionVisualizarReportesEntradas',
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
