/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
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

    var inputs = [
        $('#oferta'),
        $('#Solicitante'),
        $('#DestMcia'),
        $('#PedCliente'),
        $('#valorNeto'),
        $('#Moneda1'),
        $('#TextoInter1'),
        $('#TextoInter2'),
        $('#fechpedido'),
        $('#claseOferta'),
        $('#DenomiacionOfer'),
        $('#OrgVentas'),
        $('#CanalDist'),
        $('#Sector'),
        $('#OficinaVentas'),
        $('#DOficinaVentas'),
        $('#GpoVendedores'),
        $('#DGpoVendedores'),
        $('#MotivoPed'),
        $('#Moneda2'),
        $('#Zonaventas'),
        $('#DenominacionZonaVentas'),
        $('#fechaDocumento'),
        $('#AreVentas'),
        $('#NombreResp'),
        $('#FechaPrecio'),
        $('#LisPrecio'),
        $('#GpoPrecio'),
        $('#TextCabece'),
        $('#ValidoDe'),
        $('#fech_prefEnt'),
        $('#ValidoA'),
        $('#Centro'),
        $('#DenominacionCentro'),
        $('#PrioridadEntrega'),
        $('#DenPrioEntrega'),
        $('#Almacen'),
        $('#DenAlma'),
        $('#PtoExp'),
        $('#DenPtoExp'),
        $('#Ruta'),
        $('#DenRuta'),
        $('#PesosNeto'),
        $('#UnidadPeso'),
        $('#PesoBruto'),
        $('#Catd1'),
        $('#UMv1'),
        $('#Neto'),
        $('#mone'),
        $('#importe'),
        $('#PlazEnt'),
        $('#CantPed'),
        $('#UMedi'),
        $('#Cantentrg'),
        $('#statusglobal'),
        $('#MotivoRech'),
        $('#statusEnt'),
        $('#TextPosicion_SP')

    ];
    var butoMc = [
        $('#matchSolic'),
        $('#matchDestMerc'),
        $('#matchMoDoc'),
        $('#matchFechPedido'),
        $('#matchClaseOferta'),
        $('#matchOrgVentas'),
        $('#matchCnalDis'),
        $('#matchSector'),
        $('#matchOficina'),
        $('#matchGpoVend'),
        $('#matchMn2'),
        $('#matchZonaVentas'),
        $('#matchFecDoc'),
        $('#matchCreado'),
        $('#matchFecgPreci'),
        $('#matchValidoDe'),
        $('#matchPrefEnt'),
        $('#matchValidoA'),
        $('#matchAlmacen'),
        $('#matchptoExp'),
        $('#matchRuta'),
        $('#matchUPeso'),
        $('#matchmoncat'),
        $('#matchNetoUM'),
        $('#matchMnUM')
    ];
    $.each(inputs, function (i, v) {
        switch (i) {
            case 0:  //////// Pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 1: ////////// Solicitante
                v.focus(function () {
                    checarPosiMa(0);
                });
                break;
            case 2: /////////// Dest. Mcia.
                v.focus(function () {
                    checarPosiMa(1);
                });
                break;
            case 3: /////////// Pedido Cliente 
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 4: /////////// Valor Neto 
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 5: /////////// Moneda Doc
                v.focus(function () {
                    checarPosiMa(2);
                });
                break;
            case 6: /////////// Texto Solictante
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 7: /////////// Texto Dest Mcia
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 8: ///////////  Fecha Pedidp
                v.focus(function () {
                    checarPosiMa(3);
                });
                break;
            case 9: ///////////  Clase Oferta
                v.focus(function () {
                    checarPosiMa(4);
                });
                break;
            case 10: ///////////  Txt Oferta
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 11: ///////////  Org Ventas
                v.focus(function () {
                    checarPosiMa(5);
                });
                break;
            case 12: ///////////  Canal Dis
                v.focus(function () {
                    checarPosiMa(6);
                });
                break;
            case 13: ///////////  Sector
                v.focus(function () {
                    checarPosiMa(7);
                });
                break;
            case 14: ///////////  Oficina ventas
                v.focus(function () {
                    checarPosiMa(8);
                });
                break;
            case 15: ///////////  txt Oficina ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 16: ///////////  Gpo vendedores
                v.focus(function () {
                    checarPosiMa(9);
                });
                break;
            case 17: ///////////   txt Gpo vendedores
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 18: ///////////   Motivo pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 19: ///////////   Moneda documento
                v.focus(function () {
                    checarPosiMa(10);
                });
                break;
            case 20: ///////////   Zona de ventas
                v.focus(function () {
                    checarPosiMa(11);
                });
                break;
            case 21: ///////////   txt xona de ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 22: ///////////   fecha de documento
                v.focus(function () {
                    checarPosiMa(12);
                });
                break;
            case 23: ///////////   Area Ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 24: ///////////   Creado por
                v.focus(function () {
                    checarPosiMa(13);
                });
                break;
            case 25: ///////////   Fecha precio
                v.focus(function () {
                    checarPosiMa(14);
                });
                break;
            case 26: ///////////   Lista precio
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 27: ///////////   Gpo precio
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 28: ///////////   Texto Cabecera
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 29: ///////////  Valido A
                v.focus(function () {
                    checarPosiMa(15);
                });
                break;
            case 30: ///////////  Fecha pref
                v.focus(function () {
                    checarPosiMa(16);
                });
                break;
            case 31: ///////////  Valido De
                v.focus(function () {
                    checarPosiMa(17);
                });
                break;
            case 32: ///////////  Centro
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 33: /////////// txt Centro
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 34: /////////// Prio entrega
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 35: /////////// txt Prio entrega
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 36: ///////////  Almacen
                v.focus(function () {
                    checarPosiMa(18);
                });
                break;
            case 37: ///////////  txt Almacen
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 38: ///////////  Pto  expedicion
                v.focus(function () {
                    checarPosiMa(19);
                });
                break;
            case 39: /////////// txt Pto  expedicion
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 40: /////////// Ruta
                v.focus(function () {
                    checarPosiMa(20);
                });
                break;
            case 41: /////////// txt Ruta
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 42: /////////// peso neto
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 43: /////////// unidad med peso neto
                v.focus(function () {
                    checarPosiMa(21);
                });
                break;
            case 44: ///////////  peso bruto
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 45: ///////////  Cantidad
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 46: ///////////  Cantidad um
                v.focus(function () {
                    checarPosiMa(22);
                });
                break;
            case 47: ///////////  Neto
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 48: ///////////  Neto
                v.focus(function () {
                    checarPosiMa(23);
                });
                break;
            case 49: ///////////  Importe
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 50: ///////////  Plazo  entrega
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 51: ///////////  Cant pedida
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;

            case 52: ///////////  Cant pedida um
                v.focus(function () {
                    checarPosiMa(24);
                });
                break;
            case 53: ///////////  Cant entregada
                v.focus(function () {
                    checarPosiMa(25);
                });
                break;
            case 54: ///////////  status global
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 55: ///////////  motivo rechazo
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 56: ///////////  status ent
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 57: ///////////  text pos
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
        }
    });
    $.each(butoMc, function (i, v) {
        v.hide();
        v.click(function () {
            switch (i) {
                case 0:
                    mostrarVentanaModal('VentanaModalSolicitante', 'handle', 'BusSolic');
                    break;
                case 1:
                    mostrarVentanaModal('VentanaModalDesMer', 'handle2', 'BusDest');
                    break;
                case 2:
                    mostrarVentanaModal('VentanaModalMoneda', 'handle3', '0');
                    break;
                case 3:
                    alert("");
//                    OpenCalendario("fechpedido");
                    break;
                case 4:
                    alert("");
                    break;
                case 12:
                    
                    alert();
//                    OpenCalendario("fechaDocumento");
                    break;
            }
        });
    });

    function checarPosiMa(index) {
        $.each(butoMc, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }

    function mostrarVentanaModal(id, handle, tipo)
    {
        switch (tipo) {
            case "BusSolic":
                $('#numAcMax').val('500');
                $('#BusSolic').val('');
                $('#BusNomb').val('');
                break;
            case "BusDest":
                $('#numAcMax2').val('500');
                $('#BusDest').val('');
                break;
        }
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
        if (tipo != "0") {
            $('#' + tipo).focus();
        }
    }
    $('#CerraMCSol').click(function () {
        ocultarVentana('VentanaModalSolicitante', 'BuscarParSol', 'ConsultaTablaSolic', 'Solicitante');
    });
    $('#CerraMCSol2').click(function () {
        ocultarVentana('VentanaModalSolicitante', 'BuscarParSol', 'ConsultaTablaSolic', 'Solicitante');
    });
    $('#CerraMCDesMcia').click(function () {
        ocultarVentana('VentanaModalDesMer', 'BuscarParDesMcia', 'ConsultaTablaDestMcia', 'DestMcia');
    });
    $('#CerraMCDesMcia2').click(function () {
        ocultarVentana('VentanaModalDesMer', 'BuscarParDesMcia', 'ConsultaTablaDestMcia', 'DestMcia');
    });
    $('#CerraMCMon').click(function () {
        ocultarVentana('VentanaModalMoneda', '0', '0', 'Moneda1');
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ocultarVentana(id, bp, ct, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    if (bp != "0") {
        $('#' + bp).css('display', 'block');
        $('#' + ct).css('display', 'none');
    }
    $('#' + obj).focus();
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function OpenCalendario(id) {
    alert();
    $("#" + id).focus();
    $("#idDataFeee").val(id);
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