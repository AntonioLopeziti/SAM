/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#MCPedidos').hide();
    $('#txtPedido').focus(function () {
        $('#MCPedidos').show();
    });
    $('#MCPedidos').click(function () {
        $('#msg').html("");
        $('#iconmsg').hide();
        $('#DocumVenta').val('');
        $('#ClasePedid').val('');
        $('#numAcMax').val('500');
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalPedidosSD');
        var ancho = 350;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalPedidosSD");
        Drag.init(theHandle, theRoot);
        $('#DocumVenta').focus();

    });
    $('#retPed').click(function () {
        $('#BuscarParPedSD').css('display', 'block');
        $('#ConsultaTablaPedidos').css('display', 'none');
        $('#DocumVenta').focus();
    });
    $('#CerraMCPed').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalPedidosSD').hide();
        $('#BuscarParPedSD').css('display', 'block');
        $('#ConsultaTablaPedidos').css('display', 'none');
        $('#txtPedido').focus();
    });
    $('#CerraMCPed2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalPedidosSD').hide();
        $('#BuscarParPedSD').css('display', 'block');
        $('#ConsultaTablaPedidos').css('display', 'none');
        $('#txtPedido').focus();
    });
    $('#DocumVenta').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 13) {
            BuscarPedMC();
        }
        if (tecla == 8) {
            return true;
        }

        patron = /[0-9a-zA-z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#FSAM').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 13) {
            BuscarPedMC();
        }
        if (tecla == 8) {
            return true;
        }

        patron = /[0-9a-zA-z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#ClasePedid').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarPedMC();
        }
        patron = /[0-9a-zA-z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okPedido').click(function () {
        BuscarPedMC();
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarPedMC();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    $('#iconmsg').hide();
    startTime();
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
//          loadDoubleScroll("DobleSection", "SecCuerpo3", "DobleContainer3", "TabBody3");
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
                    color(i, f);
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
    function color(i, v) {
        $.each(arrtabs, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrtabs.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
    $('#txtPedido').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            GetData();
        }
        patron = /[0-9a-zA-Z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#aceptar').click(function () {
        GetData();
    });
});

function loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
    $("#" + DobleSection).scroll(function () {
        $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
    });
    $("#" + SecCuerpo).scroll(function () {
        $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
    });
    document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
}

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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function BuscarPedMC() {
    var acc = "ConsultaMCPedido";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + $('#DocumVenta').val().trim() + "&FolioSAM=" + $('#FSAM').val().trim() + "&Clase=" + $('#ClasePedid').val().trim() + "&Ctd=" + $('#numAcMax').val().trim(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosPedidos').html(data);
                $('#BuscarParPedSD').css('display', 'none');
                $('#ConsultaTablaPedidos').css('display', 'block');
                document.getElementById('table-scrollpedido').onscroll = function () {
                    document.getElementById('fixedYPedidoSd').style.top = document.getElementById('table-scrollpedido').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function seleccionar(dato) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalPedidosSD').hide();
    $('#BuscarParPedSD').css('display', 'block');
    $('#ConsultaTablaPedidos').css('display', 'none');
    $('#txtPedido').val(dato);
    $('#txtPedido').focus();
}
function GetData() {
    cleanDatosCab();
    cleanDatospos();
    var tipo = "0";
    var ped = $('#txtPedido');
    if (ped.val().trim() === "") {
        ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
        ped.focus();
    } else {
        var acc = "ConsultaDocumentoTipo";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarPedidosSD',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Documento=" + ped.val().trim(),
            success: function (data) {
                tipo = data.trim();
                if (data.trim() === "0") {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                    var data2 = "";
                    $('#Pedido').val(data2);
                    $('#Solicitante').val(data2);
                    $('#DestMcia').val(data2);
                    $('#PedCliente').val(data2);
                    $('#TextoInter1').val(data2);
                    $('#TextoInter2').val(data2);
                    $('#fechpedido').val(data2);
                    $('#clasePedido').val(data2);
                    $('#OrgVentas').val(data2);
                    $('#CanalDist').val(data2);
                    $('#Sector').val(data2);
                    $('#OficinaVentas').val(data2);
                    $('#DOficinaVentas').val(data2);
                    $('#GpoVendedores').val(data2);
                    $('#DGpoVendedores').val(data2);
                    $('#fechaDocumento').val(data2);
                    $('#AreVentas').val(data2);
                    $('#NombreResp').val(data2);
                    $('#FechaPrecio').val(data2);
                    $('#Moneda1').val(data2);
                    $('#Moneda2').val(data2);
                    $('#valorNeto').val(data2);
                    $('#fech_prefEnt').val(data2);
                    $('#FolioSAM').val(data2);
                } else {
                    var acc = "ConsultaPedidoCab";
                    $.ajax({
                        async: false,
                        dataType: 'json',
                        type: 'GET',
                        url: 'peticionVisualizarPedidosSD',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Accion=" + acc + "&Documento=" + ped.val().trim() + "&TipoConsulta=" + data,
                        success: function (data) {
                            $('#Pedido').val(data[0]);
                            $('#txtPedido').val(data[0]);
                            $('#Solicitante').val(data[1]);
                            $('#DestMcia').val(data[2]);
                            $('#PedCliente').val(data[3]);
                            $('#TextoInter1').val(data[4]);
                            $('#TextoInter2').val(data[5]);
                            $('#fechpedido').val(data[6]);
                            $('#clasePedido').val(data[7]);
                            $('#OrgVentas').val(data[8]);
                            $('#CanalDist').val(data[9]);
                            $('#Sector').val(data[10]);
                            $('#OficinaVentas').val(data[11]);
                            $('#DOficinaVentas').val(data[12]);
                            $('#GpoVendedores').val(data[13]);
                            $('#DGpoVendedores').val(data[14]);
//                            $('#MotivoPed').append('<option id=\"opcion1\">' + data[15] + '</option>');
                            $('#fechaDocumento').val(data[16]);
                            $('#AreVentas').val(data[17]);
                            $('#NombreResp').val(data[18]);
                            $('#FechaPrecio').val(data[19]);
                            $('#Moneda1').val(data[20]);
                            $('#Moneda2').val(data[21]);
                            $('#valorNeto').val(data[22]);
                            $('#fech_prefEnt').val(data[23]);
                            $('#FolioSAM').val(data[24]);
                        }
                    });
                }
            }
        });
    }
    CargarInterlocutores(ped.val().trim());
    CargarTxtCabecera(ped.val().trim());
    CargarPosiciones(ped.val().trim(), tipo);
}
function  CargarInterlocutores(pedido) {
    var acc = "CargarTablaInterlocutores";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido,
        success: function (data) {
            $('#SecCuerpo').html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            loadDoubleScroll("DobleSection", "SecCuerpo", "DobleContainer", "TabBody");
        }
    });

}
function CargarTxtCabecera(pedido) {
    var acc = "CargarCabeceraTexto";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido,
        success: function (data) {
            $('#TextCabece').val(data);
        }
    });

}
function CargarPosTextos(pedido, pos) {
    var acc = "CargarPosicionTexto";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos,
        success: function (data) {
            $('#TextPosicion_SP').val(data);
        }
    });

}
function CargarPosiciones(pedido, tipo) {
    var acc = "CargarPosicionesTabla";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
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
    CargarPosTextos(pedido, pos);

}
function CargarPosExpedicion(pedido, pos, tipo) {
    var acc = "CargarPosExpedicion";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
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
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + pedido + "&Posicion=" + pos + "&TipoConsulta=" + tipo,
        success: function (data) {
            $('#opcion2').remove();
            $('#Catd1').val(data[0]);
            $('#UMv1').val(data[1]);
            $('#Neto').val(data[2]);
            $('#mone').val(data[3]);
            $('#importe').val(data[4]);
            $('#statusglobal').val(data[5]);
            $('#MotivoRech').append('<option id=\"opcion2\">' + data[6] + '</option>');
            $('#statusEnt').val(data[7]);
        }
    });
}
function  CargarTablaCaondiciones(pedido, pos, tipo) {
    var acc = "CargarTablaCondiciones";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
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
        url: 'peticionVisualizarPedidosSD',
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
        url: 'peticionVisualizarPedidosSD',
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
function cleanDatosCab() {
    $('#Pedido').val("");
    $('#FolioSAM').val("");
    $('#Solicitante').val("");
    $('#DestMcia').val("");
    $('#PedCliente').val("");
    $('#TextoInter1').val("");
    $('#TextoInter2').val("");
    $('#fechpedido').val("");
    $('#clasePedido').val("");
    $('#OrgVentas').val("");
    $('#CanalDist').val("");
    $('#Sector').val("");
    $('#OficinaVentas').val("");
    $('#DOficinaVentas').val("");
    $('#GpoVendedores').val("");
    $('#DGpoVendedores').val("");
//    $('#MotivoPed').remove();
    $('#fechaDocumento').val("");
    $('#AreVentas').val("");
    $('#NombreResp').val("");
    $('#FechaPrecio').val("");
    $('#Moneda1').val("");
    $('#Moneda2').val("");
    $('#valorNeto').val("");
    $('#fech_prefEnt').val("");
}
function cleanDatospos() {
    $('#Centro').val("");
    $('#DenominacionCentro').val("");
    $('#PrioridadEntrega').val("");
    $('#DenPrioEntrega').val("");
    $('#Almacen').val("");
    $('#DenAlma').val("");
    $('#PtoExp').val("");
    $('#DenPtoExp').val("");
    $('#Ruta').val("");
    $('#DenRuta').val("");
    $('#PesosNeto').val("");
    $('#UnidadPeso').val("");
    $('#PesoBruto').val("");
    $('#Catd1').val("");
    $('#UMv1').val("");
    $('#Neto').val("");
    $('#mone').val("");
    $('#importe').val("");
    $('#statusglobal').val("");
    $('#statusEnt').val("");
    $('#TextPosicion_SP').val("");
    $('#msg').html("");
    $('#iconmsg').hide();
    CargarPosRepartos("", "", "0");
    CargarTablaCaondiciones('', '', '0');
    $('#posci').val("");
    $('#opcion1').remove();
    $('#opcion2').remove();
}