/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
    AjustarCabecera('TabHead2', 'TabBody2', 8, 'SecCuerpo2');
    AjustarCabecera('TabHead3', 'TabBody3', 8, 'SecCuerpo3');
    loadDoubleScroll("DobleSection", "SecCuerpo", "DobleContainer", "TabBody");
    $('#iconmsg').hide();
    $('#match_C2').hide();
    ////// Menu   
    $('#guardar').prop('disabled', true);
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    ///// PrimerBloque
    $('#btnocultar').hide();
    $('#Cabecera').hide();
    $('.botton1Ped').height(30);
    var arrbt = [$('#btnText'), $('#btnDatOrg'), $('#btnEstLib')];
    $.each([$('#divcon'), $('#TabDatOrg'), $('#TabLiberacio')], function (i, v) {
        v.hide();
        $.each(arrbt, function (a, f) {
            f.click(function () {
                v.hide();
                if (i == a) {
                    v.show();
                    color(i, f);
                    return;
                }
            });

        });

    });
    $('#btnmostrar').click(function () {
        $('#btnText').css({"background": "#007CC0", "color": "#fff"});
        $('#btnocultar').show();
        $('#btnmostrar').hide();
        $('#Cabecera').show();
        $('.botton1Ped').height(200);
        $.each(arrbt, function (i, v) {
            if (i != 0) {
                v.css({"background": "#fff", "color": "#000"});
            }
        });
        $.each([$('#divcon'), $('#TabDatOrg'), $('#TabLiberacio')], function (i, v) {
            v.hide();
            if (i == 0) {
                v.show();
            }
        });
    });
    $('#btnocultar').click(function () {
        $('#btnocultar').hide();
        $('#btnmostrar').show();
        $('#Cabecera').hide();
        $('.botton1Ped').height(30);
    });
    //// ///// Segundo bloque
    $('#btnmostrarDiv2').hide();
    $('#btnmostrarDiv2').click(function () {
        $('#btnocultarDiv2').show();
        $('#btnmostrarDiv2').hide();
        $('#div2').show();

    });
    $('#btnocultarDiv2').click(function () {
        $('#btnocultarDiv2').hide();
        $('#btnmostrarDiv2').show();
        $('#div2').hide();
    });
    //////// Tercer Bloque
    var arrb3 = [
        $('#btnServices'),
        $('#btnDatosMaters'),
        $('#btnhistori'),
        $('#btntxtmatp'),
        $('#btnimputacion')
    ];
    $('#div3').hide();
    $('#btnocultarDiv3').hide();
    $('#btnServices').hide();
    $('#btnmostrarDiv3').click(function () {
        $('#btnocultarDiv3').show();
        $('#btnmostrarDiv3').hide();
        $('#div3').show();
        $('#btnDatosMaters').css({"background": "#007CC0", "color": "#fff"});
        $.each(arrb3, function (i, v) {
            if (i != 1) {
                v.css({"background": "#fff", "color": "#000"});
            }
        });
        $.each([$('#DivServic'), $('#Tab2DatosMate'), $('#Tab3HisPed'), $('#Tab4Textos'), $('#Tab5Imputacion')], function (i, v) {
            v.hide();
            if (i == 1) {
                v.show();
            }
        });
    });
    $('#btnocultarDiv3').click(function () {
        $('#btnocultarDiv3').hide();
        $('#btnmostrarDiv3').show();
        $('#div3').hide();
    });

    $.each([$('#DivServic'), $('#Tab2DatosMate'), $('#Tab3HisPed'), $('#Tab4Textos'), $('#Tab5Imputacion')], function (i, v) {
        v.hide();
        $.each(arrb3, function (a, f) {
            f.click(function () {
                v.hide();
                if (i == a) {
                    v.show();
                    color2(i, f);
                    return;
                }
            });

        });

    });


    function color(i, v) {
        $.each(arrbt, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrbt.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
    function color2(i, v) {
        $.each(arrb3, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrb3.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
    $('#pedido').focus(function () {
        $('#match_C2').show();
    });
    $('#match_C2').click(function () {
        mostrarVentanaModal();
    });


//MATCH EVENTOS
    $('#pedidBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            cargarDatosPedidos();
        }
    });
    $('#SolpedBus').keypress(function (e) {
        tecla = (document.all) ? e.which : e.keyCode;
        if (tecla == 13) {
            cargarDatosPedidos();
        }
    });
    $('#SolpedSAM').keypress(function (e) {
        tecla = (document.all) ? e.which : e.keyCode;
        if (tecla == 13) {
            cargarDatosPedidos();
        }
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document.all) ? e.which : e.keyCode;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            cargarDatosPedidos();
        }
        patron = /[0-9]/;
        tec = String.fromCharCode(tecla);
        return patron.test(tec);
    });
    $('#okPedidos').click(function () {
        cargarDatosPedidos();
    });

    function cargarDatosPedidos() {
        var acc = "CargarMatchPedidos";
        var datos = "&Pedidos=" + $('#pedidBus').val() + "&Solped=" + $('#SolpedBus').val() + "&SOLSAM=" + $('#SolpedSAM').val() + "&CtdAcc=" + $('#numAcMax').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    $('#cargarDatos').html(data);
                    $('#BuscarParam_fo').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    document.getElementById('table-scroll').onscroll = function () {
                        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                    };
                }
            }
        });
    }
    $('#retornpedidmat').click(function () {
        $('#BuscarParam_fo').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#pedido').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarCargarDatos();
        }
    });
    $('#aceptar').click(function () {
        ValidarCargarDatos();
    });
    $('#pospedidos').change(function () {
        var p = $('#pospedidos').val();
        var po = p.split(",");
        var pos = po[0];
        var ped = po[1];
        if (pos === null || pos === "") {
            var i = $("#div3 :input");
            i.val("");
            CargarPosServicio('', '');
            CargarHistorialPedi('0', '0');
        } else {
            var acc = "CargarPosicionePedi";
            $.ajax({
                async: false,
                type: "GET",
                dataType: "json",
                url: "peticionModuloPedidos",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&Pedidos=" + ped + "&Posicion=" + pos,
                success: function (data) {
                    var l = data;
                    $('#GpoArtic').val(l[0]);
                    $('#NumMatpro').val(l[1]);
                    $('#CodigoE').val(l[2]);
                    $('#Lotepro').val(l[3]);
                    $('#TextPosici').val(l[4]);
                    $('#tipoimputa').val(l[5]);
                    $('#ctamayor').val(l[6]);
                    $('#socie').val(l[7]);
                    $('#ordenor').val(l[8]);
                    $('#centrocos').val(l[9]);
                    CargarPosServicio(ped, pos);
                    CargarHistorialPedi(ped, pos);
                }
            });
        }
    });
    function CargarPosServicio(ped, pos) {
        acc = "CargarPosServicio";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pedidos=" + ped + "&Posicion=" + pos,
            success: function (data) {
                $('#SecCuerpo3').html(data);
            }
        });
    }
    function CargarHistorialPedi(ped, pos) {
        acc = "CargarHistorial";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pedidos=" + ped + "&Posicion=" + pos,
            success: function (data) {
                $('#SecCuerpo2').html(data);
            }
        });
    }
    function ValidarCargarDatos() {
        var pedido = $('#pedido');
        if (pedido.val().length < 1) {
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            pedido.focus();
            Limpiar();
            $('#createdby').html('');
            CleanTable('cleantablepedido', 'SecCuerpo');
            CargarListaPos("0");
            VerificarPedidoServicio('');
            CargarPosServicio('', '');
            CargarHistorialPedi('', '');
        } else {
            CargarHistorialPedi('', '');
            acc = "CargarDatosTablaPedidos";
            $.ajax({
                async: false,
                type: "GET",
                url: "peticionModuloPedidos",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&Pedidos=" + pedido.val(),
                success: function (data) {
                    if (data == 1) {
                        Limpiar();
                        $('#createdby').html('');
                        CleanTable('cleantablepedido', 'SecCuerpo');
                        CargarListaPos("0");
                        VerificarPedidoServicio('');
                        CargarPosServicio('', '');
                        CargarHistorialPedi('', '');
                        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        var i = $("#div3 :input");
                        i.val("");
                        $('#SecCuerpo').html(data);
                        loadDoubleScroll("DobleSection", "SecCuerpo", "DobleContainer", "TabBody");
                        CargarDatosCab(pedido.val());
                        CargarListaPos(pedido.val());
                        VerificarPedidoServicio(pedido.val());
                    }
                }
            });
        }
    }
    function 
    loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
        $("#" + DobleSection).scroll(function () {
            $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
        });
        $("#" + SecCuerpo).scroll(function () {
            $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
        });
        document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
    }
    function CleanTable(acc, id) {
        $.ajax({
            type: 'GET',
            url: 'peticionModuloPedidos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc,
            success: function (datas) {
                $('#' + id).html(datas);
                loadDoubleScroll("DobleSection", id, "DobleContainer", "TabBody");
                $('#pedido').val('');
                $('#pedido').focus();
            }
        });
    }
    function CargarDatosCab(ped) {
        acc = "CargarDatosCab";
        $.ajax({
            async: false,
            type: "GET",
            dataType: "json",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pedidos=" + ped,
            success: function (data) {
                var n = data;
                $('#tipodoc').text(n[0]);
                $('#proveedor').val(n[1] + " " + n[2]);
                $('#fechadoc').val(n[3]);
                $('#TextCabecera').val(n[4]);
                $('#txtOrgCompras').val(n[5]);
                $('#DOrgCompPED').val(n[6]);
                $('#txtGrupoCompras').val(n[7]);
                $('#DGpoCompr').val(n[8]);
                $('#txtSociedad').val(n[9]);
                $('#DScoeidad').val(n[10]);
                $('#txtgrupoLib').val(n[11]);
                $('#txtEstrategiaLib').val(n[12]);
                $('#txtindLiberaci').val(n[13]);
                ShowMsg(4, "images/aceptar.png", "audio/sapmsg.wav", ped, n[14]);
            }
        });
    }
    function VerificarPedidoServicio(ped) {
        acc = "VerificarExistPoServicio";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pedidos=" + ped,
            success: function (data) {
                if (data == 1) {
                    $('#btnServices').show();
                } else {
                    $.each(arrb3, function (i, v) {
                        v.css({"background": "#fff", "color": "#000"});
                        if (i == 0) {
                            v.hide();
                        }
                        if (i == 1) {
                            v.css({"background": "#007CC0", "color": "#fff"});
                        }
                    });
                    $.each([$('#DivServic'), $('#Tab2DatosMate'), $('#Tab3HisPed'), $('#Tab4Textos'), $('#Tab5Imputacion')], function (i, v) {
                        v.hide();
                        if (i == 1) {
                            v.show();
                        }
                    });
                }
            }
        });
    }
    function CargarListaPos(ped) {
        acc = "CargarPosicionesPedidos";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloPedidos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pedidos=" + ped,
            success: function (data) {
                $('#pospedidos').html(data);
            }
        });
    }
    function Limpiar() {
        $('input').val("");
        $('#TextCabecera').val('');
        $('#btnocultarDiv3').hide();
        $('#btnmostrarDiv3').show();
        $('#div3').hide();
    }


});
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
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModal');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#SolpedBus').val("");
    $('#SolpedSAM').val("");
    $('#pedidBus').val("");
    $('#pedidBus').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModal");
    Drag.init(theHandle, theRoot);
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParam_fo').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#pedido').focus();
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