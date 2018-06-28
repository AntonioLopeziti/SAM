/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    $('#match_A4').hide();
    $('#match_A5').hide();
    $('#match_A6').hide();
    $('#match_F1').hide();
    $('#match_F2').hide();
    /*Function mostrar ventana modal Solicitante*/
    $('#solicitante').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal Solicitante2*/
    $('#solicitante2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').show();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal Pedido Venta*/
    $('#pedVenta').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal Pedido Venta 2*/
    $('#pedVenta2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal Material*/
    $('#material').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal Material2*/
    $('#material2').focus(function () {
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
    //Cliente
    $('#match_A1').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCliente");
        Drag.init(theHandle, theRoot);
        mosVenMod('Cliente');
    });
    //Cliente 2
    $('#match_A6').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalCliente2");
        Drag.init(theHandle, theRoot);
        mosVenMod('Cliente2');
    });
    //Pedido
    $('#match_A2').click(function () {
        ConsultaPedidos();
    });
    //Pedido 2
    $('#match_A4').click(function () {
        ConsultaPedidos2();
    });
    // Materiales
    $('#match_A3').click(function () {
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalMateriales");
        Drag.init(theHandle, theRoot);
        mosVenMod('Materiales');
    });
    // Materiales 2
    $('#match_A5').click(function () {
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalMateriales2");
        Drag.init(theHandle, theRoot);
        mosVenMod('Materiales2');
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
    
    // Eventos inputs
    $('#BusCliente').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesCliente').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCliente').click(function () {
        ConsultaCliente();
    });
    $('#BusCliente2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesCliente2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCliente2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCliente2').click(function () {
        ConsultaCliente2();
    });

    // Material
    
    $('#BusMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
     $('#okMateriales').click(function () {
        ConsultaMateriales();
    });
    // Material2
    
    $('#BusMaterial2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDMaterial2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax4').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
     $('#okMateriales2').click(function () {
        ConsultaMateriales2();
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
function ValidarFD() {
    ValidarQuery();
}
function ValidarQuery() {
    var centro = $('#solicitante').val();
    var centro2 = $('#solicitante2').val();
    var sam1 = $('#pedVenta').val();
    var sam2 = $('#pedVenta2').val();
    var sap1 = $('#material').val();
    var sap2 = $('#material2').val();
    var fecha1 = $('#fecha_inicio').val();
    var fecha2 = $('#fecha_fin').val();
    var acc = "ValidarQuery";
    var enviar = "&centro=" + centro + "&centro2=" + centro2 + "&sam=" + sam1 + "&sam2=" + sam2 + "&sap=" + sap1 + "&sap2=" + sap2 + "&fecha1=" + fecha1 + "&fecha2=" + fecha2;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
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
        var centro = $('#solicitante').val();
        var centro2 = $('#solicitante2').val();
        var sam1 = $('#pedVenta').val();
        var sam2 = $('#pedVenta2').val();
        var sap1 = $('#material').val();
        var sap2 = $('#material2').val();
        var fecha1 = $('#fecha_inicio').val();
        var fecha2 = $('#fecha_fin').val();
        enviarDatos(centro, centro2, sam1, sam2, sap1, sap2, fecha1, fecha2);
    }
}
function enviarDatos(centro, centro2, sam1, sam2, sap1, sap2, fecha1, fecha2) {
    var enviar = "&centro=" + centro + "&centro2=" + centro2 + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            location.href = "VisualizarFlujoDocumentos.jsp?" + enviar;
        }
    });
}

function mosVenMod(tipo) {
    switch (tipo) {
        case "Cliente":
            var ventana = document.getElementById('VentanaModalCliente');
            abrirVentana(ventana);
            $("#BusCliente").focus();
            $("#BusCliente").val('');
            $("#BusDesCliente").val('');
            $("#numAcMax").val('500');
            $('#BuscarPCliente').show();
            $('#ConsultaTablaCliente').hide();
            break;
        case "Cliente2":
            var ventana = document.getElementById('VentanaModalCliente2');
            abrirVentana(ventana);
            $("#BusCliente2").focus();
            $("#BusCliente2").val('');
            $("#BusDesCliente2").val('');
            $("#numAcMax2").val('500');
            $('#BuscarPCliente2').show();
            $('#ConsultaTablaCliente2').hide();
            break;
        case "Materiales":
            var ventana = document.getElementById('VentanaModalMateriales');
            abrirVentana(ventana);
            $("#BusMaterial").focus();
            $("#BusMaterial").val('');
            $("#BusDMaterial").val('');
            $("#numAcMax3").val('500');
            $('#BuscarPMateriales').show();
            $('#ConsultaTablaMateriales').hide();
            break;
        case "Materiales2":
            var ventana = document.getElementById('VentanaModalMateriales2');
            abrirVentana(ventana);
            $("#BusMaterial2").focus();
            $("#BusMaterial2").val('');
            $("#BusDMaterial2").val('');
            $("#numAcMax4").val('500');
            $('#BuscarPMateriales2').show();
            $('#ConsultaTablaMateriales2').hide();
            break;
    }
}
function retornPCliente() {
    $('#BuscarPCliente').show();
    $('#ConsultaTablaCliente').hide();
    $('#BusCliente').focus();
}
function retornPCliente2() {
    $('#BuscarPCliente2').show();
    $('#ConsultaTablaCliente2').hide();
    $('#BusCliente2').focus();
}
function retornPMateriales() {
    $('#BuscarPMateriales').show();
    $('#ConsultaTablaMateriales').hide();
    $('#BusMaterial').focus();
}
function retornPMateriales2() {
    $('#BuscarPMateriales2').show();
    $('#ConsultaTablaMateriales2').hide();
    $('#BusMaterial2').focus();
}
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "Cliente":
            $('#VentanaModalCliente').hide();
            $('#solicitante').focus();
            borramsg();
            break;
        case "Cliente2":
            $('#VentanaModalCliente2').hide();
            $('#solicitante2').focus();
            borramsg();
            break;
        case "Pedido":
            $('#VentanaModalPedidos').hide();
            $('#pedVenta').focus();
            borramsg();
            break;
        case "Pedido2":
            $('#VentanaModalPedidos2').hide();
            $('#pedVenta2').focus();
            borramsg();
            break;
        case "Materiales":
            $('#VentanaModalMateriales').hide();
            $('#material').focus();
            borramsg();
            break;
        case "Materiales2":
            $('#VentanaModalMateriales2').hide();
            $('#material2').focus();
            borramsg();
            break;
    }

}
function borramsg() {
    var iconm = $('#iconmsg');
    iconm.hide();
    $('#msg').html("");
}

function ConsultaCliente() {
    var acc = "CargarSolicitante";
    var Cli = $("#BusCliente").val();
    var Nom = $("#BusDesCliente").val();
    var ctd = $("#numAcMax").val();
    var tipo = "Cliente";
    var enviar = "&Cliente=" + Cli + "&DCliente=" + Nom + "&Cantidad=" + ctd + "&tipo=" + tipo;
    ;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarPCliente").css("display", "none");
                $("#ConsultaTablaCliente").css("display", "block");
                $("#cargarDatosClientes").html(data);
                fnc("table-scrollCliente", "fixedYCliente");
                borramsg();
            }
        }
    });
}
function ConsultaCliente2() {
    var acc = "CargarSolicitante";
    var Cli = $("#BusCliente2").val();
    var Nom = $("#BusDesCliente2").val();
    var ctd = $("#numAcMax2").val();
    var tipo = "Cliente2";
    var enviar = "&Cliente=" + Cli + "&DCliente=" + Nom + "&Cantidad=" + ctd + "&tipo=" + tipo;
    ;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarPCliente2").css("display", "none");
                $("#ConsultaTablaCliente2").css("display", "block");
                $("#cargarDatosClientes2").html(data);
                fnc("table-scrollCliente2", "fixedYCliente2");
                borramsg();
            }
        }
    });
}

function  ConsultaPedidos() {
    var acc = "CargarPedidos";
    var tipo = "Pedido";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana = document.getElementById('VentanaModalPedidos');
                abrirVentana(ventana);
                $("#cargarDatosPedido").html(data);
                var theHandle = document.getElementById("handle3");
                var theRoot = document.getElementById("VentanaModalPedidos");
                Drag.init(theHandle, theRoot);
                fnc("table-scrollPedido", "fixedYPedido");
                borramsg();
            }
        }
    });
}
function  ConsultaPedidos2() {
    var acc = "CargarPedidos";
    var tipo = "Pedido2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana = document.getElementById('VentanaModalPedidos2');
                abrirVentana(ventana);
                $("#cargarDatosPedido2").html(data);
                var theHandle = document.getElementById("handle4");
                var theRoot = document.getElementById("VentanaModalPedidos2");
                Drag.init(theHandle, theRoot);
                fnc("table-scrollPedido2", "fixedYPedido2");
                borramsg();
            }
        }
    });
}

function ConsultaMateriales() {
    var acc = "CargarMateriales";
    var Mater = $("#BusMaterial").val();
    var Descr = $("#BusDMaterial").val();
    var ctd = $("#numAcMax3").val();
    var tipo = "Materiales";
    var enviar = "&tipo=" + tipo + "&Material=" + Mater + "&DMaterial=" + Descr + "&Cantidad=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarPMateriales").css("display", "none");
                $("#ConsultaTablaMateriales").css("display", "block");
                $("#cargarDatosMateriales").html(data);
                fnc("table-scrollMateriales", "fixedYMateriales");
                borramsg();
            }
        }
    });
}
function ConsultaMateriales2() {
    var acc = "CargarMateriales";
    var Mater = $("#BusMaterial2").val();
    var Descr = $("#BusDMaterial2").val();
    var ctd = $("#numAcMax4").val();
    var tipo = "Materiales2";
    var enviar = "&tipo=" + tipo + "&Material=" + Mater + "&DMaterial=" + Descr + "&Cantidad=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesFlujoDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarPMateriales2").css("display", "none");
                $("#ConsultaTablaMateriales2").css("display", "block");
                $("#cargarDatosMateriales2").html(data);
                fnc("table-scrollMateriales2", "fixedYMateriales2");
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
        case "Cliente":
            $("#solicitante").val(dato);
            ocultarVentana(tipo);
            break;
        case "Cliente2":
            $("#solicitante2").val(dato);
            ocultarVentana(tipo);
            break;
        case "Pedido":
            $("#pedVenta").val(dato);
            ocultarVentana(tipo);
            break;
        case "Pedido2":
            $("#pedVenta2").val(dato);
            ocultarVentana(tipo);
            break;
        case "Materiales":
            $("#material").val(dato);
            ocultarVentana(tipo);
            break;
        case "Materiales2":
            $("#material2").val(dato);
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