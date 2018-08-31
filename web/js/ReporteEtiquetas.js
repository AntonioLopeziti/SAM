/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#iconmsg').hide();
    var inp = [
        $('#ORDEN'),
        $('#SAM'),
        $('#PTO'),
        $('#Fecha')
    ];
    var btn = [
        $('#match_Orden'),
        $('#match_SAM'),
        $('#match_PTO'),
        $('#match_Fecha')
    ];
    $.each(btn, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultaFolioOrden();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaFolioSAM();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultaPuesto();
                });
                break;
            case 3:
                v.click(function () {
                    OpenCalendario("Fecha");
                });
                break;
        }

    });
    $.each(inp, function (i, v) {
        patron = /[0-9a-zA-Z]/;
        switch (i) {
            case 0:
                v.focus(function () {
                    posicionm(0);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("ORDEN", "ORD", "&Var=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                            v.val('');
                            v.focus();
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 1:
                v.focus(function () {
                    posicionm(1);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("SAM", "SAM", "&Var=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                            v.val('');
                            v.focus();
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
                    posicionm(2);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("PTO", "PTO", "&Var=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                            v.val('');
                            v.focus();
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
    function posicionm(index) {
        $.each(btn, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#OCULORD').click(function () {
        ocultarVentana("VentanaModalOrden", ORDEN);
    });
    $('#OCUlSAM').click(function () {
        ocultarVentana("VentanaModalSAM", SAM);
    });
    $('#OCULPTO').click(function () {
        ocultarVentana("VentanaModalPuesto", PTO);
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#ejecutar').click(function () {
        if ($('#ORDEN').val().length > 0) {
            if (validarDato("ORDEN", "ORD", "&Var=" + $('#ORDEN').val().toUpperCase()) == false) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", $('#ORDEN').val().toUpperCase());
                $('#ORDEN').val('');
                $('#ORDEN').focus();
                return;
            }
        }
        if ($('#SAM').val().length > 0) {
            if (validarDato("SAM", "SAM", "&Var=" + $('#SAM').val().toUpperCase()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", $('#SAM').val().toUpperCase());
                $('#SAM').val('');
                $('#SAM').focus();
                return;
            }
        }
        if ($('#PTO').val().length > 0) {
            if (validarDato("PTO", "PTO", "&Var=" + $('#PTO').val().toUpperCase()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#PTO').val().toUpperCase());
                $('#PTO').val('');
                $('#PTO').focus();
                return;
            }
        }
        ValidarQuery();
    });
});
function ValidarQuery() {
    var acc = "ValidarQuery";
    var param = "&Orden=" + $('#ORDEN').val() 
            + "&SAM=" + $('#SAM').val()
            + "&Puesto=" + $('#PTO').val()
            + "&Fecha=" + $('#Fecha').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteEtiquetas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + param,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizarReporteEtiquetas.jsp?Action=CargarTabla" + param;
            }
        }
    });
}
function validarDato(id, va, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionReporteEtiquetas',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=ValidarDatos&Tipo=" + va + param,
            success: function (data) {
                if (data != 0) {
                    ban = true;
                }
            }
        });
    }
    return ban;
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ConsultaFolioOrden() {
    var acc = "ConsultaOrden";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteEtiquetas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalOrden').get(0);
                mostrarVentanaModal($ventana1, 'handle', 'VentanaModalOrden');
                $('#cargarDatosOrden').html(data);
                fnc("table-Orden", "fixedYOrden");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM() {
    var acc = "Consultasam";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteEtiquetas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSAM').get(0);
                mostrarVentanaModal($ventana1, 'handle2', 'VentanaModalSAM');
                $('#cargarDatosSAM').html(data);
                fnc("table-SAM", "fixedYSAM");
                borramsg();
            }
        }
    });
}
function ConsultaPuesto() {
    var acc = "ConsultaPuesto";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteEtiquetas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalPuesto').get(0);
                mostrarVentanaModal($ventana1, 'handle3', 'VentanaModalPuesto');
                $('#cargarDatosPueston').html(data);
                fnc("table-Puesto", "fixedYPuesto");
                borramsg();
            }
        }
    });
}

function mostrarVentanaModal(ventana, handle, ven) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var $ancho = 350;
    var $alto = 650;
    var $x = (screen.width / 2) - ($ancho / 2);
    var $y = (screen.height / 2) - ($alto / 2);
    ventana.style.left = $x + "px";
    ventana.style.top = $y + "px";
    ventana.style.display = 'block';
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ven);
    Drag.init(theHandle, theRoot);
}
function fnc(scroll, fixe) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function ocultarVentana(ven, id) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + ven).hide();
    $(id).focus();
}

function Select(dato, tipo) {
    switch (tipo) {
        case "ORDEN":
            $("#ORDEN").val(dato);
            ocultarVentana("VentanaModalOrden", "#ORDEN");
            break;
        case "SAM":
            $("#SAM").val(dato);
            ocultarVentana("VentanaModalSAM", "#SAM");
            break;
        case "PTO":
            $("#PTO").val(dato);
            ocultarVentana("VentanaModalPuesto", "#PTO");
            break;

    }
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
