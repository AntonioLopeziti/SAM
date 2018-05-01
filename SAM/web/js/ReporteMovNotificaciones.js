/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    $('#match_A4').hide();
    $('#match_A5').hide();
    $('#match_A6').hide();
    $('#match_F1').hide();
    $('#match_F2').hide();
    /*Function mostrar ventana modal SAP*/
    $('#centro').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sam1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sam2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sap1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sap2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').show();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    $('#fecha_inicio').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').show();
        $('#match_F2').hide();
    });
    $('#fecha_fin').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').show();
    });
    //Centro
    $('#match_A1').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        mosVenMod('Centro');
    });
    //SAM1
    $('#match_A2').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalSAM2");
        Drag.init(theHandle, theRoot);
        mosVenMod('SAM2');
    });
    //SAM2
    $('#match_A4').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSAM1");
        Drag.init(theHandle, theRoot);
        mosVenMod('SAM2');
    });
    //SAP1 No Orden
    $('#match_A3').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalSAP1");
        Drag.init(theHandle, theRoot);
        mosVenMod('SAP1');
    });
    //SAP2 No Orden
    $('#match_A5').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAP2");
        Drag.init(theHandle, theRoot);
        mosVenMod('SAP2');
    });
    /*Match fecha 1 Reservas*/
    $('#match_F1').click(function () {
        OpenCalendario("fecha_inicio");
        $('#fecha_inicio').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    /*Match fecha 2 Reservas*/
    $('#match_F2').click(function () {
        OpenCalendario("fecha_fin");
        $('#fecha_fin').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#okCentro').click(function () {
        ConsultaCentro();
    });
    $('#okFolio').click(function () {
        ConsultaFolioSAM1();
    });
    $('#okFolio2').click(function () {
        ConsultaFolioSAM2();
    });
    $('#okOrden1').click(function () {
        ConsultaFolioSAP1();
    });
    $('#okOrden2').click(function () {
        ConsultaFolioSAP2();
    });
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function back() {
    window.location.href = "Bienvenido.jsp";
}
function fin() {
    window.location.href = "Bienvenido.jsp";
}
function ValidarMN() {
    ValidarQuery();
}
function ValidarQuery() {
    var centro = $('#centro').val();
    var sam1 = $('#sam1').val();
    var sam2 = $('#sam2').val();
    var sap1 = $('#sap1').val();
    var sap2 = $('#sap2').val();
    var fecha1 = $('#fecha_inicio').val();
    var fecha2 = $('#fecha_fin').val();
    var acc = "ValidarQuery";
    var enviar = "&centro=" + centro + "&sam=" + sam1 + "&sam2=" + sam2 + "&sap=" + sap1 + "&sap2=" + sap2 + "&fecha1=" + fecha1 + "&fecha2=" + fecha2;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                vali();
            }
        }
    });
}
function vali() {
    var imagen = $('#iconmsg');
    if (imagen.is(":visible")) {
        setTimeout(borramsg, 2000);
    } else {
        var centro = $('#centro').val();
        var sam1 = $('#sam1').val();
        var sam2 = $('#sam2').val();
        var sap1 = $('#sap1').val();
        var sap2 = $('#sap2').val();
        var fecha1 = $('#fecha_inicio').val();
        var fecha2 = $('#fecha_fin').val();
        enviarDatos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2);
    }
}
function enviarDatos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2) {
    var enviar = "&centro=" + centro + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizaReporteMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            location.href = "VisualizarMovNotOrdenes.jsp";
        }
    });
}
$("#vemoce").click(function () {
    BacMain('BuscarParamCentro_SP', 'ConsultaTablaCentro')
});
function BacMain(di1, di2) {
    $("#" + di1).css("display", "block");
    $("#" + di2).css("display", "none");
}
function mosVenMod(tipo) {
    switch (tipo) {
        case "Centro":
            var ventana = document.getElementById('VentanaModalCentro');
            abrirVentana(ventana);
            $("#BusCentro").focus();
            $("#BusCentro").val('');
            $("#BusCentro").val('');
            $("#numAcMax").val('500');
            $('#ConsultaTablaOCompras').hide();
            break;
        case "SAM1":
            var ventana = document.getElementById('VentanaModalSAM1');
            abrirVentana(ventana);
            $("#BusFolio").focus();
            $("#BusFolio").val('');
            $("#CenFolio").val('');
            $("#numAcMaxFolio").val('500');
            $('#ConsultaTablaFolioSAM1').hide();
            break;
        case "SAM2":
            var ventana = document.getElementById('VentanaModalSAM2');
            abrirVentana(ventana);
            $("#BusFolio2").focus();
            $("#BusFolio2").val('');
            $("#CenFolio2").val('');
            $("#numAcMaxFolio2").val('500');
            $('#ConsultaTablaFolioSAM2').hide();
            break;
        case "SAP1":
            var ventana = document.getElementById('VentanaModalSAP1');
            abrirVentana(ventana);
            $("#BusNumOrd").focus();
            $("#BusNumOrd").val('');
            $("#CenNumOrd").val('');
            $("#numAcMaxNumOrd").val('500');
            $('#ConsultaTablaFolioSAP1').hide();
            break;
        case "SAP2":
            var ventana = document.getElementById('VentanaModalSAP2');
            abrirVentana(ventana);
            $("#BusNumOrd2").focus();
            $("#BusNumOrd2").val('');
            $("#CenNumOrd2").val('');
            $("#numAcMaxNumOrd2").val('500');
            $('#ConsultaTablaFolioSAP2').hide();
            break;
    }
}
//function mostrarVentanaModal(tipo) {
//    var BE = document.createElement('audio');
//    BE.src = "audio/sapsnd05.wav";
//    BE.play();
//    switch (tipo) {
//        case "centro":
//            ConsultaCentro();
//            break;
//        case "sam1":
//            ConsultaFolioSAM1();
//            break;
//        case "sam2":
//            ConsultaFolioSAM2();
//            break;
//        case "sap1":
//            ConsultaFolioSAP1();
//            break;
//        case "sap2":
//            ConsultaFolioSAP2();
//            break;
//    }
//}
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            var ventana1 = $('#VentanaModalCentro');
            ventana1.hide();
            $('#centro').focus();
            borramsg();
            break;
        case "sam1":
            var ventana2 = $('#VentanaModalSAM1');
            ventana2.hide();
            $('#sam1').focus();
            borramsg();
            break;
        case "sam2":
            var ventana3 = $('#VentanaModalSAM2');
            ventana3.hide();
            $('#sam2').focus();
            borramsg();
            break;
        case "sap1":
            var ventana4 = $('#VentanaModalSAP1');
            ventana4.hide();
            $('#sap1').focus();
            borramsg();
            break;
        case "sap2":
            var ventana5 = $('#VentanaModalSAP2');
            ventana5.hide();
            $('#sap2').focus();
            borramsg();
            break;
    }

}
function borramsg() {
    var iconm = $('#iconmsg');
    iconm.hide();
    $('#msg').html("");
}

function ConsultaCentro() {
    var acc = "CentroStatus";
    var Cen = $("#BusCentro").val();
    var Nom = $("#BusDesCentro").val();
    var ctd = $("#numAcMax").val();
    var enviar = "&Centro=" + Cen + "&CentroNom=" + Nom + "&Ctd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamCentro_SP").css("display", "none");
                $("#ConsultaTablaOCompras").css("display", "block");
                $("#cargarDatosOCompras").html(data);
//                var ventana1 = $('#VentanaModalCentro');
//                abrirVentana(ventana1);
//                $('#cargarDatosOCompras').html(data);
//                fnc("table-scrollCentro", "fixedYCentro");
                borramsg();
            }
        }
    });
}
function  ConsultaFolioSAM1() {
    var acc = "SamStatuss";
    var fol = $("#BusFolio").val();
    var centro = $("#CenFolio").val();
    var ctd = $("#numAcMaxFolio").val();    
    var tipo = "sam1";
    var enviar = "&tipo=" + tipo + "&folSAM=" + fol + "&CentroFol=" + centro + "&CtdFol=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamFolio_SP").css("display", "none");
                $("#ConsultaTablaFolioSAM1").css("display", "block");
                $("#cargarDatosFolioSAM1").html(data);
                borramsg();
//                $('#VentanaModalSAM1').show();
//                $('#VentanaModalSAM1').css({
//                    position: 'absolute', left: 510, top: 60
//                });
//                $("#cargarDatosFolioSAM1").html(data);
//                fnc("table-scrollSAM", "fixedYSAM");
//                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM2() {
    var acc = "SamStatuss";
    var fol = $("#BusFolio2").val();
    var centro = $("#CenFolio2").val();
    var ctd = $("#numAcMaxFolio2").val();    
    var tipo = "sam2";
    var enviar = "&tipo=" + tipo + "&folSAM=" + fol + "&CentroFol=" + centro + "&CtdFol=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamFolio2_SP").css("display", "none");
                $("#ConsultaTablaFolioSAM2").css("display", "block");
                $("#cargarDatosFolioSAM2").html(data);
                borramsg();
//                $('#VentanaModalSAM2').show();
//                $('#VentanaModalSAM2').css({
//                    position: 'absolute', left: 510, top: 60
//                });
//                $("#cargarDatosFolioSAM2").html(data);
//                fnc("table-scrollSAM2", "fixedYSAM2");
//                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP1() {
    var acc = "SapStatus";
    var fol = $("#BusNumOrd").val();
    var centro = $("#CenNumOrd").val();
    var ctd = $("#numAcMaxNumOrd").val();    
    var tipo = "sap1";
    var enviar = "&tipo=" + tipo + "&folOrd=" + fol + "&CentroOrd=" + centro + "&CtdOrd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamFolioSAP_SP").css("display", "none");
                $("#ConsultaTablaFolioSAP1").css("display", "block");
                $("#cargarDatosFolioSAP1").html(data);
                borramsg();
//                $('#VentanaModalSAP1').show();
//                $('#VentanaModalSAP1').css({
//                    position: 'absolute', left: 510, top: 60
//                });
//                $("#cargarDatosFolioSAP1").html(data);
//                fnc("table-scrollSAP", "fixedYSAP");
//                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP2() {
    var acc = "SapStatus";
    var fol = $("#BusNumOrd2").val();
    var centro = $("#CenNumOrd2").val();
    var ctd = $("#numAcMaxNumOrd2").val();    
    var tipo = "sap2";
    var enviar = "&tipo=" + tipo+ "&folOrd=" + fol + "&CentroOrd=" + centro + "&CtdOrd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesMovNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamFolioSAP2_SP").css("display", "none");
                $("#ConsultaTablaFolioSAP2").css("display", "block");
                $("#cargarDatosFolioSAP2").html(data);
                borramsg();
//                $('#VentanaModalSAP2').show();
//                $('#VentanaModalSAP2').css({
//                    position: 'absolute', left: 510, top: 60
//                });
//                $("#cargarDatosFolioSAP2").html(data);
//                fnc("table-scrollSAP2", "fixedYSAP2");
//                borramsg();
            }
        }
    });
}
function validarCentro() {
    var acc = "ValidarCentroo";
    var centro = $('#centro').val().toUpperCase();
    var enviar = "&centro=" + centro;
    if (centro.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesMovNot',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/sapmsg.wav", centro);
                    $("#centro").val("");
                    $("#centro").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsam1() {
    var acc = "ValidarSAM22";
    var sam = $('#sam1').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesMovNot',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/sapmsg.wav", sam.toUpperCase());
                    $("#sam1").val("");
                    $("#sam1").focus();
                } else {
                    borramsg();
                }
            }
        });
    }

}

function validarsam2() {
    var acc = "ValidarSAM22";
    var sam = $('#sam2').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesMovNot',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/sapmsg.wav", sam.toUpperCase());
                    $("#sam2").val("");
                    $("#sam2").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsap() {
    var acc = "ValidarSAP22";
    var sap = $('#sap1').val().toUpperCase();
    var enviar = "&sap=" + sap;

    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesMovNot',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/sapmsg.wav", sap.toUpperCase());
                    $("#sap1").val("");
                    $("#sap1").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsap2() {
    var acc = "ValidarSAP22";
    var sap = $('#sap2').val().toUpperCase();
    var enviar = "&sap=" + sap;

    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesMovNot',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/sapmsg.wav", sap.toUpperCase());
                    $("#sap2").val("");
                    $("#sap2").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function abrirVentana(ventana) {
    ///abrir ventanas
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();

    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    borramsg();
}
function fnc(scroll, fixe) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function Select(dato, tipo) {
    switch (tipo) {
        case "centro":
            $("#centro").val(dato);
            ocultarVentana(tipo);
            break;
        case "sam1":            
            $("#sam1").val(dato);
            ocultarVentana(tipo);
            break;
        case "sam2":            
            $("#sam2").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap1":
            $("#sap1").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap2":
            $("#sap2").val(dato);
            ocultarVentana(tipo);
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