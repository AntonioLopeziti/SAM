//
///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
$(document).ready(function () {
    startTime();
    ConsultaCentro();
    $('#iconmsg').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    var cen = $('#centro');
    var sam1 = $('#sami');
    var sap1 = $('#sapi');
    var fech1 = $('#fechainicio');
    var solic = $('#solicitante');
    var almac = $('#almacen');
    var mater = $('#material');
    var posic = $('#posicion');
    var imput = $('#imputacion');
    var sam2 = $('#samf');
    var sap2 = $('#sapf');
    var fechf = $('#fechafin');
    var arrimp = [
        cen,
        sam1,
        sap1,
        fech1,
        solic,
        almac,
        mater,
        posic,
        imput,
        sam2,
        sap2,
        fechf
    ];
    var arrma = [
        $('#match1'),
        $('#match2'),
        $('#match3'),
        $('#match4'),
        $('#match5'),
        $('#match6'),
        $('#match7'),
        $('#match8'),
        $('#match9'),
        $('#match10'),
        $('#match11')
    ];
    $.each(arrimp, function (i, v) {
        patron = /[0-9a-zA-Z]/;
        switch (i) {
            case 0:
                v.focus(function () {
                    posicionm(-1);
                });
                break;
            case 1:
                v.focus(function () {
                    posicionm(0);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("sami", "ValidarSAM", "&SAM=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
                    posicionm(1);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("sapi", "ValidarSAP", "&SAP=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
                    posicionm(9);
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
                    posicionm(2);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("solicitante", "ValidarSolicitate", "&SOL=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 5:
                v.focus(function () {
                    posicionm(3);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("almacen", "ValidarAlmacen", "&ALM=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 6:
                v.focus(function () {
                    posicionm(4);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("material", "ValidarMaterial", "&MAT=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 7:
                v.focus(function () {
                    posicionm(5);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        validarPosicion();
                    }
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("posicion", "ValidarTPos", "&TPO=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 8:
                v.focus(function () {
                    posicionm(6);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("imputacion", "ValidarTIM", "&TIM=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 9:
                v.focus(function () {
                    posicionm(7);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("samf", "ValidarSAP", "&SAM=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 10:
                v.focus(function () {
                    posicionm(8);
                });
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (validarDato("sapf", "ValidarSAP", "&SAP=" + v.val().toUpperCase()) == true) {
                            borramsg();
                        } else {
                            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
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
            case 11:
                v.focus(function () {
                    posicionm(10);
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
        $.each(arrma, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#ejecutar').click(function () {
        if (sam1.val().length > 0) {
            if (validarDato("sami", "ValidarSAM", "&SAM=" + sam1.val().toUpperCase()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam1.val().toUpperCase());
                sam1.val('');
                sam1.focus();
                return;
            }
        }
        if (sam2.val().length > 0) {
            if (validarDato("samf", "ValidarSAM", "&SAM=" + sam2.val().toUpperCase()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam2.val().toUpperCase());
                sam2.val('');
                sam2.focus();
                return;
            }
        }
        if (sap1.val().length > 0) {
            if (validarDato("sapi", "ValidarSAP", "&SAP=" + sap1.val().toUpperCase()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap1.val().toUpperCase());
                sap1.val('');
                sap1.focus();
                return;
            }
        }
        if (sap2.val().length > 0) {
            if (validarDato("sapf", "ValidarSAP", "&SAP=" + sap2.val().toUpperCase()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap2.val().toUpperCase());
                sap2.val('');
                sap2.focus();
                return;
            }
        }
        if (solic.val().length > 0) {
            if (validarDato("solicitante", "ValidarSolicitate", "&SOL=" + solic.val().toUpperCase()) == false) {
                ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav", solic.val().toUpperCase());
                solic.val('');
                solic.focus();
                return;
            }
        }
        if (almac.val().length > 0) {
            if (validarDato("almacen", "ValidarAlmacen", "&ALM=" + almac.val().toUpperCase()) == false) {
                ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav", almac.val().toUpperCase());
                almac.val('');
                almac.focus();
                return;
            }
        }
        if (mater.val().length > 0) {
            if (validarDato("material", "ValidarMaterial", "&MAT=" + mater.val().toUpperCase()) == false) {
                ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav", mater.val().toUpperCase());
                mater.val('');
                mater.focus();
                return;
            }
        }
        if (imput.val().length > 0) {
            if (validarDato("imputacion", "ValidarTIM", "&TIM=" + imput.val().toUpperCase()) == false) {
                ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav", imput.val().toUpperCase());
                imput.val('');
                imput.focus();
                return;
            }
        }
        ValidarQuery();
    });
    function ValidarQuery() {
        var acc = "ValidarQuery";
        var param = "&SM1=" + sam1.val() + "&SM2=" + sam2.val() + "&SP1=" + sap1.val() + "&SP2=" + sap2.val() + "&FC1=" + fech1.val() + "&FC2=" + fechf.val();
        var par = param + "&SLC=" + solic.val() + "&AMC=" + almac.val() + "&MTL=" + mater.val() + "&POS=" + posic.val() + "&IMT=" + imput.val() + "&CEN=" + cen.val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaSolped',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    window.location.href = "VisualizarReporteSolicitudPedido.jsp?Action=CargarTabla" + par;
                }
            }
        });
    }
    $.each(arrma, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultaFolioSAM1();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaFolioSAP1();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultaSolicitante();
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaAlmacen();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaMaterial();
                });
                break;
            case 5:
                v.click(function () {
                    ConsultaPosicion();
                });
                break;
            case 6:
                v.click(function () {
                    ConsultaImputacion();
                });
                break;
            case 7:
                v.click(function () {
                    ConsultaFolioSAM2();
                });
                break;
            case 8:
                v.click(function () {
                    ConsultaFolioSAP2();
                });
                break;
            case 9:
                v.click(function () {
                    OpenCalendario("fechainicio");
                });
                break;
            case 10:
                v.click(function () {
                    OpenCalendario("fechafin");
                });
                break;
        }

    });
    $('#closeSAM').click(function () {
        ocultarVentana("VentanaModalSAM1", sam1);
    });
    $('#closeSAM2').click(function () {
        ocultarVentana("VentanaModalSAM2", sam2);
    });
    $('#closeSAP').click(function () {
        ocultarVentana("VentanaModalSAP1", sap1);
    });
    $('#closeSAP2').click(function () {
        ocultarVentana("VentanaModalSAP2", sap2);
    });
    $('#closeSOL').click(function () {
        ocultarVentana("VentanaModalSolicitante", solic);
    });
    $('#closeAlma').click(function () {
        ocultarVentana("VentanaModalAlmacen", almac);
    });
    $('#closeMate').click(function () {
        ocultarVentana("VentanaModalMaterial", mater);
    });
    $('#closePos').click(function () {
        ocultarVentana("VentanaModalPosicion", posic);
    });
    $('#closeimpu').click(function () {
        ocultarVentana("VentanaModalImputacion", imput);
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });

});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function ConsultaCentro() {
    var acc = "CargarCentro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#centro').html(data);
            }
        }
    });
}
function ConsultaFolioSAM1() {
    var acc = "CargarSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSAM1').get(0);
                mostrarVentanaModal($ventana1, 'handle', 'VentanaModalSAM1');
                $('#cargarDatosFolioSAM1').html(data);
                fnc("table-scrollSAM1", "fixedYSAM1");
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
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSAM2').get(0);
                mostrarVentanaModal($ventana1, 'handle2', 'VentanaModalSAM2');
                $('#cargarDatosFolioSAM2').html(data);
                fnc("table-scrollSAM2", "fixedYSAM2");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP1() {
    var acc = "CargarSAP";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSAP1').get(0);
                mostrarVentanaModal($ventana1, 'handle3', 'VentanaModalSAP1');
                $('#cargarDatosFolioSAP1').html(data);
                fnc("table-scrollSAP", "fixedYSAP");
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
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSAP2').get(0);
                mostrarVentanaModal($ventana1, 'handle4', 'VentanaModalSAP2');
                $('#cargarDatosFolioSAP2').html(data);
                fnc("table-scrollSAP2", "fixedYSAP2");
                borramsg();
            }
        }
    });
}
function ConsultaSolicitante() {
    var acc = "CargarSolicitante";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalSolicitante').get(0);
                mostrarVentanaModal($ventana1, 'handle5', 'VentanaModalSolicitante');
                $('#cargarDatosSolicitante').html(data);
                fnc("table-scrollSolic", "fixedYSoli");
                borramsg();
            }
        }
    });
}
function ConsultaAlmacen() {
    var acc = "CargarAlmacen";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalAlmacen').get(0);
                mostrarVentanaModal($ventana1, 'handle6', 'VentanaModalAlmacen');
                $('#cargarDatosAlmacen').html(data);
                fnc("table-scrollAlma", "fixedYAlma");
                borramsg();
            }
        }
    });
}
function ConsultaMaterial() {
    var acc = "CargarMaterial";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalMaterial').get(0);
                mostrarVentanaModal($ventana1, 'handle7', 'VentanaModalMaterial');
                $('#cargarDatosMaterial').html(data);
                fnc("table-scrollMate", "fixedYMate");
                borramsg();
            }
        }
    });
}



function ConsultaPosicion() {
    var acc = "CargarTPosicion";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalPosicion').get(0);
                mostrarVentanaModal($ventana1, 'handle8', 'VentanaModalPosicion');
                $('#cargarDatosPosicion').html(data);
                fnc("table-scrollPos", "fixedYPos");
                borramsg();
            }
        }
    });
}
function ConsultaImputacion() {
    var acc = "CargarTImputacion";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaSolped',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var $ventana1 = $('#VentanaModalImputacion').get(0);
                mostrarVentanaModal($ventana1, 'handle9', 'VentanaModalImputacion');
                $('#cargarDatosImputacion').html(data);
                fnc("table-scrollimp", "fixedYimp");
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
            url: 'peticionListaSolped',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + param,
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
function Select(dato, tipo) {
    switch (tipo) {
        case "sam1":
            $("#sami").val(dato);
            ocultarVentana("VentanaModalSAM1", "#sami");
            break;
        case "sam2":
            $("#samf").val(dato);
            ocultarVentana("VentanaModalSAM2", "#samf");
            break;
        case "sap1":
            $("#sapi").val(dato);
            ocultarVentana("VentanaModalSAP1", "#sapi");
            break;
        case "sap2":
            $("#sapf").val(dato);
            ocultarVentana("VentanaModalSAP2", "#sapf");
            break;
        case "solicitante":
            $("#solicitante").val(dato);
            ocultarVentana("VentanaModalSolicitante", "#solicitante");
            break;
        case "almacen":
            $("#almacen").val(dato);
            ocultarVentana("VentanaModalAlmacen", "#almacen");
            break;
        case "material":
            $("#material").val(dato);
            ocultarVentana("VentanaModalMaterial", "#material");
            break;
        case "posicion":
            $("#posicion").val(dato);
            ocultarVentana("VentanaModalPosicion", "#posicion");
            break;
        case "imputacion":
            $("#imputacion").val(dato);
            ocultarVentana("VentanaModalImputacion", "#imputacion");
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
