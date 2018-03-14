/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    $('#MCOferta').hide();
    $('#retofe').click(function () {
        $('#BuscarParOfSD').css('display', 'block');
        $('#ConsultaTablaOferta').css('display', 'none');
        $('#DocumVenta').focus();
    });
    $('#txtOferta').focus(function () {
        $('#MCOferta').show();
    });
    $('#aceptar').click(function () {
        VerificarDoc();
    });
    $('#txtOferta').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            VerificarDoc();
        }
        patron = /[0-9a-zA-Z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#MCOferta').click(function () {
        $('#msg').html("");
        $('#iconmsg').hide();
        $('#DocumVenta').val('');
        $('#ClaseOf').val('');
        $('#numAcMax').val('500');
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalOfertaSD');
        var ancho = 350;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalOfertaSD");
        Drag.init(theHandle, theRoot);
        $('#DocumVenta').focus();
    });
    $('#CerraMCOferta').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalOfertaSD').hide();
        $('#BuscarParOfSD').css('display', 'block');
        $('#ConsultaTablaOferta').css('display', 'none');
        $('#txtOferta').focus();
    });
    $('#CerraMCOferta2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalOfertaSD').hide();
        $('#BuscarParOfSD').css('display', 'block');
        $('#ConsultaTablaOferta').css('display', 'none');
        $('#txtOferta').focus();
    });
    $('#DocumVenta').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarOfertaMC();
        }
        patron = /[0-9a-zA-Z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#ClaseOf').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarOfertaMC();
        }
        patron = /[0-9a-zA-Z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarOfertaMC();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okOferta').click(function () {
        BuscarOfertaMC();
    });
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#btnocultar').hide();
    $('#divDetailCab').hide();
    $('#btnExped').css({"background": "#007CC0", "color": "#fff"});
    $('#btnmostrar').click(function () {
        $('#btnmostrar').hide();
        $('#btnocultar').show();
        $('#divDetailCab').css('height', '400px');
        $('#contai').css('height', '400px');
        $('#contai').css('margin-bottom', '30px');
        $('#divDetailCab').show();
        ventas();
    });
    $('#btnocultar').click(function () {
        $('#btnmostrar').show();
        $('#btnocultar').hide();
        $('#divDetailCab').hide();
        $('#contai').css('height', '50px');
        $('#contai').css('margin-bottom', '20px');
    });
    $('#btntxts').click(function () {
        $('#btnVent').css({"background": "#fff", "color": "#000"});
        $('#btntxts').css({"background": "#007CC0", "color": "#fff"});
        $('#textosCabecera').show();
        $('#DivVentas').hide();
    });
    $('#btnVent').click(function () {
        ventas();
    });
    function ventas() {
        $('#btntxts').css({"background": "#fff", "color": "#000"});
        $('#btnVent').css({"background": "#007CC0", "color": "#fff"});
        $('#DivVentas').show();
        $('#textosCabecera').hide();
        AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    }
    var arrtabs = [$('#btnExped'), $('#btnCondi'), $('#btnRep'), $('#btnEstatus'), $('#btnTextos')];
    $.each([$('#ContExp'), $('#ContCond'), $('#ContRep'), $('#ContSta'), $('#divtxts')], function (i, v) {
        if (i != 0) {
            v.hide();
        }
        $.each(arrtabs, function (a, f) {
            f.click(function () {
                v.hide();
                if (i == a) {
                    v.show();
                    color(i, f, arrtabs);
                    return;
                }
                switch (a) {
                    case 1:
                        AjustarCabecera('TabHead3', 'TabBody3', 3, 'SecCuerpo3');
                        loadDoubleScroll("DobleSection3", "SecCuerpo3", "DobleContainer3", "TabBody3");
                        break;
                    case 2:
                        AjustarCabecera('TabHead4', 'TabBody4', 3, 'SecCuerpo4');
                        loadDoubleScroll("DobleSection4", "SecCuerpo4", "DobleContainer4", "TabBody4");
                        break;
                }
            });
        });
    });
    function color(i, v, arreglo) {
        $.each(arreglo, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arreglo.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
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
function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }
    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 7 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
}
function loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
    $("#" + DobleSection).scroll(function () {
        $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
    });
    $("#" + SecCuerpo).scroll(function () {
        $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
    });
    document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
}
function BuscarOfertaMC() {
    var acc = "ConsultaMCOferta";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + $('#DocumVenta').val().trim() + "&Clase=" + $('#ClaseOf').val().trim() + "&Ctd=" + $('#numAcMax').val().trim(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosOferta').html(data);
                $('#BuscarParOfSD').css('display', 'none');
                $('#ConsultaTablaOferta').css('display', 'block');
                document.getElementById('table-scrollOferta').onscroll = function () {
                    document.getElementById('fixedYOferta').style.top = document.getElementById('table-scrollOferta').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function VerificarDoc() {
    cleanpos();
    var documento = $('#txtOferta').val().trim();
    if (documento === "") {
        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
    } else {
        var acc = "VerificarDocumento";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarCotizacionSD',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Documento=" + documento,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                }
                CargarCabecera(documento, data);
                CargarPosiciones(documento, data);
            }
        });
    }
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function seleccionar(dato) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalOfertaSD').hide();
    $('#BuscarParOfSD').css('display', 'block');
    $('#ConsultaTablaOferta').css('display', 'none');
    $('#txtOferta').val(dato);
    $('#txtOferta').focus();
}
function CargarCabecera(documento, tipo) {
    var acc = "CargarCabecera";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + documento + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#oferta').val(data[1]);
            $('#Solicitante').val(data[2]);
            $('#DestMcia').val(data[4]);
            $('#PedCliente').val(data[6]);
            $('#valorNeto').val(data[17]);
            $('#Moneda1').val(data[18]);
            $('#TextoInter1').val(data[3]);
            $('#TextoInter2').val(data[5]);
            $('#fechpedido').val(data[7]);
            $('#claseOferta').val(data[0]);
            $('#OrgVentas').val(data[8]);
            $('#CanalDist').val(data[9]);
            $('#Sector').val(data[10]);
            $('#OficinaVentas').val(data[12]);
            $('#DOficinaVentas').val(data[13]);
            $('#GpoVendedores').val(data[14]);
            $('#DGpoVendedores').val(data[15]);
            $('#MotivoPed').val(data[20]);
            $('#Moneda2').val(data[18]);
            $('#fechaDocumento').val(data[16]);
            $('#AreVentas').val(data[11]);
            $('#NombreResp').val(data[19]);
            $('#FechaPrecio').val(data[21]);
            $('#ValidoDe').val(data[24]);
            $('#ValidoA').val(data[25]);
            $('#fech_prefEnt').val(data[22]);
        }
    });
}
function CargarPosiciones(pedido, tipo) {
    var acc = "CargarPosicion";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#SecCuerpo2').html(data);
            AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
            loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
        }
    });

}

function GetItemP(pedido, pos, tipo) {
    $('#posci').val(parseInt(pos));
    CargarPosExpedicion(pedido, pos, tipo);
    CargarPosCampos(pedido, pos, tipo);
    CargarTablaCaondiciones(pedido, pos, tipo);
    CargarPosRepartos(pedido, pos, tipo);

}
function CargarPosExpedicion(pedido, pos, tipo) {
    var acc = "CargarPosExpedicion";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#Centro').val(data[0]);
            $('#DenominacionCentro').val(data[1]);
            $('#PrioridadEntrega').val(data[2]);
            $('#DenPrioEntrega').val(data[3]);
            $('#Almacen').val(data[4]);
            $('#DenAlma').val(data[5]);
            $('#PtoExp').val(data[6]);
            $('#DenPtoExp').val(data[7]);
            $('#Ruta').val(data[8]);
            $('#DenRuta').val(data[9]);
            $('#PesosNeto').val(data[10]);
            $('#UnidadPeso').val(data[11]);
            $('#PesoBruto').val(data[12]);
        }
    });
}
function CargarPosCampos(pedido, pos, tipo) {
    var acc = "CargarPosCampos";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#Catd1').val(data[0]);
            $('#UMv1').val(data[1]);
            $('#Neto').val(data[2]);
            $('#mone').val(data[3]);
            $('#importe').val(data[4]);
            $('#statusglobal').val(data[5]);
            $('#MotivoRech').val(data[6]);
            $('#statusEnt').val(data[7]);
        }
    });
}
function  CargarTablaCaondiciones(pedido, pos, tipo) {
    var acc = "CargarTablaCondiciones";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#SecCuerpo3').html(data);
            AjustarCabecera('TabHead3', 'TabBody3', 3, 'SecCuerpo3');
            loadDoubleScroll("DobleSection3", "SecCuerpo3", "DobleContainer3", "TabBody3");
        }
    });
}
function CargarPosRepartos(pedido, pos, tipo) {
    var acc = "GetRepartos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#SecCuerpo4').html(data);
            AjustarCabecera('TabHead4', 'TabBody4', 3, 'SecCuerpo4');
            loadDoubleScroll("DobleSection4", "SecCuerpo4", "DobleContainer4", "TabBody4");
            CargarDatosPosRep(pedido, pos, tipo);
        }
    });
}
function CargarDatosPosRep(pedido, pos, tipo) {
    var acc = "CabRep";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionVisualizarCotizacionSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#PlazEnt').val(data[0]);
            $('#CantPed').val(data[1]);
            $('#UMedi').val(data[2]);
            $('#Cantentrg').val(data[3]);
        }
    });
}
function cleanpos() {
    $('#posci').val("");
    CargarCabecera("", "0");
    CargarPosiciones("", "0");
    CargarPosExpedicion("", "", "0");
    CargarPosCampos("", "", "0");
    CargarTablaCaondiciones("", "", "0");
}