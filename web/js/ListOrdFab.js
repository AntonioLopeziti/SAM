/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#centro').focus();
    var centro = $('#centro');
    var sam1 = $('#sam1');
    var sap1 = $('#sap1');
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    /*Function mostrar ventana modal SAP*/
    $('#centro').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sam1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sap1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
    });
    $('#match_A1').click(function () {
        //Centro
//        mostrarVentanaModal('centro');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        mosVenMod('Centro');
    });
    $('#match_A2').click(function () {
        //Folio SAM         
//        mostrarVentanaModal('sam1');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSAM1");
        Drag.init(theHandle, theRoot);
        mosVenMod('sam1');
    });
    $('#match_A3').click(function () {
        //Material        
//        mostrarVentanaModal('sap1');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalSAP1");
        Drag.init(theHandle, theRoot);
        mosVenMod('sap1');
    });
    //////VALIDAR CAMPOS
    centro.blur(function () {
        if (centro.val().length > 0) {
            validarCentro();
        }
    });
    centro.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (centro.val().length > 0) {
                validarCentro();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sam1.blur(function () {
        if (sam1.val().length > 0) {
            validarsam1();
        }
    });
    sam1.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsam1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sap1.blur(function () {
        validarsap();
    });
    sap1.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsap();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCentro').click(function () {
        ConsultaCentro();
    });
    $('#okOrden1').click(function () {
        ConsultaFolioSAM1();
    });
    $('#okMate').click(function () {
        ConsultaFolioSAP1();
    });
    //Match centro 
    $('#BusCentro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesCentro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    //Match Folio
    $('#BusFolio').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#CenFolio').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMaxFolio').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    //Match Material
    $('#BusMate').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAP1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });    
    $('#CenMate').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAP1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMaxMate').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAP1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#centro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarEO();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });  
    $('#sam1').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarEO();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });  
    $('#sap1').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarEO();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });  
});
function back() {
    window.location.href = "Bienvenido.jsp";
}
function fin() {
    window.location.href = "Bienvenido.jsp";
}
function ValidarEO() {
    verificar();
}
function verificar() {
    var centro = $('#centro').val();
    var folio = $('#sam1').val();
    var orden = $('#sap1').val();
    //Si los 3 input van vacios 
    if (centro == '' && folio == '' && orden == '') {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTodaTabla";
            }
        });
    }
    //Si sólo va lleno el centro
    if (centro != '' && folio == '' && orden == '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaCentro" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
    //So sólo va lleno el folio
    if (centro == '' && folio != '' && orden == '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaFolio" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
    //So sólo va lleno el material
    if (centro == '' && folio == '' && orden != '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaMaterial" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
    //Si se combinan centro y folio
    if (centro != '' && folio != '' && orden == '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaCenFol" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
    //Si se combinan centro y material
    if (centro != '' && folio == '' && orden != '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaCenMat" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
    //Si se combinan folio y material
    if (centro == '' && folio != '' && orden != '') {
        var enviar = "&centro=" + centro + "&sam1=" + folio + "&sap1=" + orden
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionListadoOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                location.href = "MonitorPP.jsp?Accion=CargaTablaFolMat" + enviar;
//                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        });
    }
}
function ValidarQuery() {
    var centro = $('#centro').val();
    var sam1 = $('#sam1').val();
    var sap1 = $('#sap1').val();
    var acc = "ValidarQuery";
    var enviar = "&centro=" + centro + "&sam=" + sam1 + "&sap=" + sap1;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarListaOrdFabPP',
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
        var sap1 = $('#sap1').val();
        enviarDatos(centro, sam1, sap1);
    }
}
function enviarDatos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2) {
    var enviar = "&centro=" + centro + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizaReporteStaOrdPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            location.href = "VisualizarStatusOrdenesPP.jsp";
        }
    });
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
        url: 'PeticionVisualizarListaOrdFabPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamCentro_SP").css("display", "none");
                $("#ConsultaTablaOCompras").css("display", "block");
                $("#cargarDatosCentro").html(data);
                borramsg();
//                var ventana1 = $('#VentanaModalCentro');
//                abrirVentana(ventana1);
//                $('#cargarDatosCentro').html(data);
//                fnc("table-scrollCentro", "fixedYCentro");

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
    var enviar = "&tipo=" + tipo + "&folOrd=" + fol + "&CentroOrd=" + centro + "&CtdOrd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarListaOrdFabPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamFolioSAP_SP").css("display", "none");
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
function ConsultaFolioSAP1() {
    var acc = "SapStatus";
    var fol = $("#BusMate").val();
    var centro = $("#CenMate").val();
    var ctd = $("#numAcMaxMate").val();
    var tipo = "sap1";
    var enviar = "&tipo=" + tipo + "&folMate=" + fol + "&CentroMate=" + centro + "&CtdMate=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarListaOrdFabPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamMate_SP").css("display", "none");
                $("#ConsultaTablaFolioSAP1").css("display", "block");
                $("#cargarDatosFolioSAP1").html(data);
                borramsg();
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
            url: 'PeticionVisualizarListaOrdFabPP',
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
            url: 'PeticionVisualizarListaOrdFabPP',
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
function validarsap() {
    var acc = "ValidarSAP22";
    var sap = $('#sap1').val().toUpperCase();
    var enviar = "&sap=" + sap;

    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarListaOrdFabPP',
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
function mosVenMod(tipo) {
    switch (tipo) {
        case "Centro":
            var ventana = document.getElementById('VentanaModalCentro');
            abrirVentana(ventana);
            $("#BusCentro").focus();
            $("#BusCentro").val('');
            $("#BusCentro").val('');
            $("#numAcMax").val('500');
            $("#BuscarParamCentro_SP").show();
            $('#ConsultaTablaOCompras').hide();
            break;
        case "sam1":
            var ventana = document.getElementById('VentanaModalSAM1');
            abrirVentana(ventana);
            $("#BusFolio").focus();
            $("#BusFolio").val('');
            $("#CenFolio").val('');
            $("#numAcMaxFolio").val('500');
            $('#BuscarParamFolioSAP_SP').show();
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
        case "sap1":
            var ventana = document.getElementById('VentanaModalSAP1');
            abrirVentana(ventana);
            $("#BusMate").focus();
            $("#BusMate").val('');
            $("#CenMate").val('');
            $("#numAcMaxMate").val('500');
            $('#BuscarParamMate_SP').show();
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
function mostrarVentanaModal(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            ConsultaCentro();
            break;
        case "sam1":
            ConsultaFolioSAM1();
            break;
            break;
        case "sap1":
            ConsultaFolioSAP1();
            break;
    }
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
//var BE = document.createElement('audio');
//    BE.src = "audio/sapsnd05.wav";
//    BE.play();
//    var ventana = $('#' + id);
//    var ancho = 350;
//    var alto = 650;
//    var x = (screen.width / 2) - (ancho / 2);
//    var y = (screen.height / 2) - (alto / 2);
//    ventana.css({top: y + "px", left: x + "px"});
//    ventana.css('display', 'block');
//    borrarmsg();
//    var theHandle = document.getElementById(handle);
//    var theRoot = document.getElementById(id);
//    Drag.init(theHandle, theRoot);
function cambiarMatchCentro() {
    $('#BuscarParamCentro_SP').show();
    $('#ConsultaTablaOCompras').hide();
}
function cambiarMatchFolio() {
    $('#BuscarParamFolioSAP_SP').show();
    $('#ConsultaTablaFolioSAM1').hide();
}
function cambiarMatchMaterial() {
    $('#BuscarParamMate_SP').show();
    $('#ConsultaTablaFolioSAP1').hide();
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
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = 'audio/sapsnd05.wav';
    BE.play();
    switch (tipo) {
        case "centro":
            var ventana1 = $('#VentanaModalCentro').get(0);
            ventana1.style.display = 'none';
            $("#BuscarParamOCompras_SP").hide();
//            $("#ConsultaTablaOCompras").hide();
            $("#OrgCompras").focus();
            borramsg();
            break;
        case "sam1":
            var ventana2 = $('#VentanaModalSAM1').get(0);
            ventana2.style.display = 'none';
            $("#BuscarFoliosam1").hide();
//            $("#ConsultaTablaFolioSAM1").hide();
            $("#sam1").focus();
            borramsg();
            break;
        case "sam2":
            var ventana3 = $('#VentanaModalSAM2').get(0);
            ventana3.style.display = 'none';
            $("#BuscarFoliosam2").hide();
//            $("#ConsultaTablaFolioSAM2").hide();
            $("#sam2").focus();
            borramsg();
            break;
        case "sap1":
            var ventana4 = $('#VentanaModalSAP1').get(0);
            ventana4.style.display = 'none';
            $("#BuscarFoliosap1").hide();
//            $("#ConsultaTablaFolioSAP1").hide();
            $("#sap1").focus();
            borramsg();
            break;
        case "sap2":
            var ventana5 = $('#VentanaModalSAP2').get(0);
            ventana5.style.display = 'none';
            $("#BuscarFoliosap2").hide();
//            $("#ConsultaTablaFolioSAP2").hide();
            $("#sap2").focus();
            borramsg();
            break;
    }
}
function borramsg() {
    var iconm = $('#iconmsg');
    iconm.css('visibility', 'hidden');
    $('#msg').html("");
}
function fnc(scroll, fixe) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function fnc1() {
    document.getElementById('table-scroll1').onscroll = function () {
        document.getElementById('fixedY1').style.top = document.getElementById('table-scroll1').scrollTop + 'px';
    };
}
