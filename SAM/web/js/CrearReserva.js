/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    GetIp();
    $('#AgregarFilas').click(function () {
        AgregarFilaTabla();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#BorrarFilas').click(function () {
        EliminarFilas();
    });
    $('#guardar').click(function () {
        var Centro = $('#Centro');
        var Almacen = $('#Almacen');
        var CentroCoste = $('#CentroCoste');
        var Orden = $('#Orden');
        var movi = $("#ListTipMov").val();
        var mov = movi.substr(0, 3);
        if (Centro.val().length == 0) {
            ShowMsg(3, "images/advertencia.PNG", "audio/sapmsg.wav");
            Centro.focus();
            return;
        }
        if (ValidarDatos('CEN', Centro.val(), '', '') == false) {
            ShowMsg(10, "images/advertencia.PNG", "audio/sapmsg.wav");
            Centro.focus();
            return;
        }
        if (Almacen.val().length == 0) {
            ShowMsg(4, "images/advertencia.PNG", "audio/sapmsg.wav");
            Almacen.focus();
            return
        }
        if (ValidarDatos('ALM', Almacen.val(), Centro.val(), '') == false) {
            ShowMsg(11, "images/advertencia.PNG", "audio/sapmsg.wav");
            Almacen.focus();
            return;
        }
        switch (mov) {
            case "201":
                if (CentroCoste.val().length == 0) {
                    ShowMsg(8, "images/advertencia.PNG", "audio/sapmsg.wav");
                    CentroCoste.focus();
                    return;
                }
                if (ValidarDatos('CCO', CentroCoste.val(), '', '') == false) {
                    ShowMsg(12, "images/advertencia.PNG", "audio/sapmsg.wav");
                    CentroCoste.focus();
                    return;
                }
                ValidarTabla(Centro.val(), Almacen.val(), '201', CentroCoste.val(), '');
                break;
            case "261":
                if (Orden.val().length == 0) {
                    ShowMsg(9, "images/advertencia.PNG", "audio/sapmsg.wav");
                    Orden.focus();
                    return;
                }
                if (ValidarDatos('ORD', Orden.val(), '', '') == false) {
                    ShowMsg(13, "images/advertencia.PNG", "audio/sapmsg.wav");
                    Orden.focus();
                    return;
                }
                ValidarTabla(Centro.val(), Almacen.val(), '261', '', Orden.val());
                break;
            default:
                ShowMsg(7, "images/advertencia.PNG", "audio/sapmsg.wav");
                $("#ListTipMov").focus();
                break;
        }
    });
    $('#iconmsg').hide();
    startTime();
    CargarTablaPosiciones();
    ConsultaTipoMovimientos();
    var cjs = [
        $('#Centro'),
        $('#Almacen'),
        $('#ListTipMov'),
        $('#CentroCoste'),
        $('#Orden'),
        $('#AlmacenDes')
    ];
    var match = [
        $('#matchCentro'),
        $('#MatchAlmacen'),
        $('#MatchCenCosto'),
        $('#MatchOrden')
//        $('#MatchAlmDes')
    ];
    $.each(match, function (i, v) {
        v.hide();
        switch (i) {

            case 0:
                v.click(function () {
                    ConsultaCentro();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaAlmacen();
                });
                break;
            case 2:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalCCosto', 'handle4', 'BusCcosto', 'BuscarParCCosto', 'ConsultaTablaCCosto');
                });
                break;
            case 3:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalOrden', 'handle5', 'BusOrden', 'BuscarParOrden', 'ConsultaTablaOrden');
                });
                break;
        }
    });
    $.each(cjs, function (i, v) {
        switch (i) {
            case 0:  //// Centro
                v.css("background-image", "url(images/necesario.PNG)");
                v.focus(function () {
                    QuitarMatch();
                    checarPosiMa(0);
                    v.css("background-image", "none");
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                v.blur(function () {
                    if (v.val().trim().length == 0) {
                        v.css("background-image", "url(images/necesario.PNG)");
                    } else {
                        v.css("background-image", "none");
                    }
                });
                break;
            case 1: ////// Almacen
                v.css("background-image", "url(images/necesario.PNG)");
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                v.focus(function () {
                    QuitarMatch();
                    v.css("background-image", "none");
                    checarPosiMa(1);
                });
                v.blur(function () {
                    if (v.val().trim().length == 0) {
                        v.css("background-image", "url(images/necesario.PNG)");
                    } else {
                        v.css("background-image", "none");
                    }
                });
                break;
            case 2: ///// Tipo Movimiento
                v.focus(function () {
                    $('#VentanaModalCCosto').hide();
                    $('#VentanaModalOrden').hide();
                    QuitarMatch();
                });
                v.change(function () {
                    var movi = $("#ListTipMov").val();
                    var mov = movi.substr(0, 3);
                    switch (mov) {
                        case "201":
                            $('#CentroCoste').css("background-image", "url(images/necesario.PNG)");
                            $('#CentroCoste').prop('disabled', false);
                            $('#Orden').prop('disabled', true);
                            $('#Orden').css("background-image", "none");
                            $('#Orden').val('');
                            break;
                        case "261":
                            $('#Orden').css("background-image", "url(images/necesario.PNG)");
                            $('#Orden').prop('disabled', false);
                            $('#CentroCoste').prop('disabled', true);
                            $('#CentroCoste').css("background-image", "none");
                            $('#CentroCoste').val('');
                            break;
                        case "311":
                            break;
                        default:
                            $('#CentroCoste').css("background-image", "none");
                            $('#CentroCoste').prop('disabled', true);
                            $('#CentroCoste').val('');
                            $('#Orden').prop('disabled', true);
                            $('#Orden').css("background-image", "none");
                            $('#Orden').val('');
                            break;
                    }
                });
                break;
            case 3:  ///////  Centro Costo
                v.prop('disabled', true);
                v.focus(function () {
                    QuitarMatch();
                    checarPosiMa(2);
                    v.css("background-image", "none");
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                v.blur(function () {
                    if (v.val().trim().length == 0) {
                        v.css("background-image", "url(images/necesario.PNG)");
                    } else {
                        v.css("background-image", "none");
                    }
                });
                break;
            case 4:  //// Orden
                v.prop('disabled', true);
                v.focus(function () {
                    QuitarMatch();
                    checarPosiMa(3);
                    v.css("background-image", "none");
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                v.blur(function () {
                    if (v.val().trim().length == 0) {
                        v.css("background-image", "url(images/necesario.PNG)");
                    } else {
                        v.css("background-image", "none");
                    }
                });
                break;
            case 5:
//                v.focus(function () {
//                    checarPosiMa(4);
//                });
                break;
        }
    });
    function checarPosiMa(index) {
        $.each(match, function (ind, va) {
            if (ind == index) {
                va.show();
                return;
            } else {
                va.hide();
                return;
            }
        });
    }
    $('#CerrarMCCentro').click(function () {
        ocultarVentanaSimple("VentanaModalCentro", "Centro");
    });
    $('#CerrarMCAlmacen').click(function () {
        ocultarVentanaSimple("VentanaModalAlmacen", "Almacen");
    });
    $('#CerraMCCCosto').click(function () {
        ocultarVentanaSimple("VentanaModalCCosto", "CentroCoste");
    });
    $('#CerraMCCCosto2').click(function () {
        ocultarVentanaSimple("VentanaModalCCosto", "CentroCoste");
    });
    $('#CerraMCOrden').click(function () {
        ocultarVentanaSimple("VentanaModalOrden", "Orden");
    });
    $('#CerraMCOrden2').click(function () {
        ocultarVentanaSimple("VentanaModalOrden", "Orden");
    });
    $('#CerraMCMaterial').click(function () {
        ocultarVentanaSimple("VentanaModalMateriales", "0");
        var pos = $('#postextpos').val();
        $('#tdMater' + pos).focus();
    });
    $('#CerraMCMaterial2').click(function () {
        ocultarVentanaSimple("VentanaModalMateriales", "0");
        var pos = $('#postextpos').val();
        $('#tdMater' + pos).focus();
    });
    $('#BusCcosto').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusdenCCosto').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
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
            ConsultaCCosto();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#OkCosto').click(function () {
        ConsultaCCosto();
    });
    $('#retCCosto').click(function () {
        $('#ConsultaTablaCCosto').hide();
        $('#BuscarParCCosto').show();
    });
    $('#BusOrden').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusdenOrden').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
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
            ConsultaOrden();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#OkOrden').click(function () {
        ConsultaOrden();
    });
    $('#retOrden').click(function () {
        $('#ConsultaTablaOrden').hide();
        $('#BuscarParOrden').show();
    });
    $('#BusMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusdenMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
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
            ConsultaMaterial();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#OkMaterial').click(function () {
        ConsultaMaterial();
    });
    $('#retMaterial').click(function () {
        $('#ConsultaTablaMaterial').hide();
        $('#BuscarParMaterial').show();
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
function ConsultaCentro() {
    var acc = "ConsultarCentro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalCentro', 'cargarDatosCentro', data, 'table-scrollCentro', 'fixedYCentro', 'handle');
            }
        }
    });
}
function ConsultaAlmacen() {
    var acc = "ConsultarAlmacen";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Centro=" + $('#Centro').val(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalAlmacen', 'cargarDatosAlmacen', data, 'table-scrollAlmacen', 'fixedYAlmacen', 'handle2');
            }
        }
    });
}
function ConsultaTipoMovimientos() {
    var acc = "ConsultaTipoMovimientos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#ListTipMov').html(data);
        }
    });
}

function ConsultaAlmacenDes() {
    var acc = "ConsultarAlmacenDes";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Centro=" + $('#Centro').val(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalAlmDes', 'cargarDatosAlmDes', data, 'table-scrollAlmDes', 'fixedYCAlmDes', 'handle4');
            }
        }
    });
}
function ConsultaCCosto() {
    var acc = "ConsultarCentroCosto";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&CCossto=" + $('#BusCcosto').val() + "&Descripcion=" + $('#BusdenCCosto').val() + "&Cantidad=" + $('#numAcMax').val(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosCCosto').html(data);
                $('#BuscarParCCosto').css('display', 'none');
                $('#ConsultaTablaCCosto').css('display', 'block');
                document.getElementById('table-scrollCCosto').onscroll = function () {
                    document.getElementById('fixedYCCosto').style.top = document.getElementById('table-scrollCCosto').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaOrden() {
    var acc = "ConsultarOrden";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Orden=" + $('#BusOrden').val() + "&Descripcion=" + $('#BusdenOrden').val() + "&Cantidad=" + $('#numAcMax2').val(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosOrden').html(data);
                $('#BuscarParOrden').css('display', 'none');
                $('#ConsultaTablaOrden').css('display', 'block');
                document.getElementById('table-scrollOrden').onscroll = function () {
                    document.getElementById('fixedYOrden').style.top = document.getElementById('table-scrollOrden').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaMaterial() {
    var acc = "ConsultarMaterial";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Material=" + $('#BusMaterial').val() + "&Descripcion=" + $('#BusdenMaterial').val() + "&Cantidad=" + $('#numAcMax3').val() + "&Posicion=" + $('#postextpos').val() + "&Centro=" + $('#Centro').val() + "&Almacen=" + $('#Almacen').val(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosMaterial').html(data);
                $('#BuscarParMaterial').css('display', 'none');
                $('#ConsultaTablaMaterial').css('display', 'block');
                document.getElementById('table-scrollMaterial').onscroll = function () {
                    document.getElementById('fixedYMaterial').style.top = document.getElementById('table-scrollMaterial').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}

function MostratVentanaModalSimple(ventana1, CargarDatos, data, tableScroll, fixedscroll, handle) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#' + ventana1);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventana1);
    Drag.init(theHandle, theRoot);
    $('#' + CargarDatos).html(data);
    document.getElementById(tableScroll).onscroll = function () {
        document.getElementById(fixedscroll).style.top = document.getElementById(tableScroll).scrollTop + 'px';
    };
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function SeleccionarData(dato, ventanamodal, obj, dato2, obj2)
{
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj).val(dato);
    $('#' + obj2).val(dato2);
    ocultarVentanaSimple(ventanamodal, obj);
}
function ocultarVentanaSimple(id, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj).focus();
}
function seleccionar(dato, ventanamodal, obj)
{
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj).val(dato);
    ocultarVentanaSimple(ventanamodal, obj);
}
function mostrarVentanaModal(id, handle, tipo, pb, ct)
{
    switch (tipo) {
        case "BusCcosto":
            $('#numAcMax').val('500');
            $('#BusCcosto').val('');
            $('#BusdenCCosto').val('');
            break;
        case "BusOrden":
            $('#numAcMax2').val('500');
            $('#BusOrden').val('');
            $('#BusdenOrden').val('');
            break;

    }
    $('#' + pb).show();
    $('#' + ct).hide();
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
function MostrarMatch(id, match, pos) {
    QuitarMatch();
    $('#' + id + pos).css('width', '80%');
    $('#' + match + pos).css('display', 'inline-block');
    if (id == 'tdMater') {
        $('#' + id + pos).keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (tecla == 13) {
                CargarMaterial($('#tdMater' + pos).val(), pos);
            }
            patron = /[0-9a-zA-ZÑñ]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        });
        $('#' + id + pos).blur(function () {
            if ($('#' + id + pos).val().length > 0) {
                CargarMaterial($('#tdMater' + pos).val(), pos);
            }
        });
    }
}
function QuitarMatch() {
    $('#matchCentro').hide();
    $('#MatchAlmacen').hide();
    $('#MatchCenCosto').hide();
    $('#MatchOrden').hide();
    $('#MatchAlmDes').hide();
    var inMat = document.getElementsByName("MaterTD");
    var matchMat = document.getElementsByName('matchMaterial');
    for (i = 0; i < inMat.length; i++) {
        inMat[i].style.width = '100%';
    }
    for (i = 0; i < matchMat.length; i++) {
        matchMat[i].style.display = 'none';
    }
}
function MostrarMatchGridMateriales(VM, handle, pos) {
    var cen = $('#Centro');
    var alm = $('#Almacen');
    if (cen.val().trim().length == 0) {
        ShowMsg(3, "images/advertencia.PNG", "audio/sapmsg.wav");
        cen.focus();
        return;
    }
    if (alm.val().trim().length == 0) {
        ShowMsg(4, "images/advertencia.PNG", "audio/sapmsg.wav");
        alm.focus();
        return;
    }
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + VM);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    $('#BuscarParMaterial').css('display', 'Block');
    $('#ConsultaTablaMaterial').css('display', 'none')
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(VM);
    Drag.init(theHandle, theRoot);
    $('#postextpos').val(pos);
    $('#numAcMax3').val('500');
    $('#BusMaterial').val('');
    $('#BusMaterial').focus();
    $('#BusdenMaterial').val('');


}
function seleccionarMate(mat, des, um, pos, vm) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + vm).hide();
    $('#tdMater' + pos).val(mat);
    $('#tdUmedi' + pos).val(um);
    $('#tdDescr' + pos).val(des);
    $('#tdCanti' + pos).focus();
}
function checkDec(num, tam, pos) {
    var limit;
    var FINC;
    if (tam == 3) {
        limit = 9999999.999;
        FINC = "Formato Incorecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
    } else {
        limit = 99999999.99;
        FINC = "Formato Incorecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
    }
    if (num.length > 0) {
        if (parseFloat(limit) >= parseFloat(num)) {
            va = num.split(".");
            v01 = va[0];
            if (v01.length == 0) {
                v01 = "0";
            }
            v0 = parseInt(v01);
            v1 = va[1];
            if (num.indexOf(".") != -1) {
                if (v1.length > tam) {
                    var da = v1.substr(0, tam);
                    borramsg();
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    borramsg();
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                borramsg();
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
//            mensajesValidacionInco(FINC);
            return "";
        }
    } else {
        borramsg();
        return "";
    }

}
function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode;
    patron = /[0-9.]/;
    te = String.fromCharCode(key);
    return patron.test(te);
}
function GetCantend(C, U) {
    var findata = "";
    var umc = parseInt(CheckUnidaMed(U));
    if (umc == 0) {
        findata = Math.floor(C);
        findata += ".000";
    }
    if (umc == 3) {
        findata = cantconvert(C.toString());
    }
    return findata;
}
function CheckUnidaMed(valor)
{
    var resp = "";
    var acc = "umed";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&UM=" + valor,
        success: function (data) {
            resp = data;
        }
    });
    return resp;
}
function cantconvert(valor) {
    if (valor.indexOf(".") != -1) {
        va = valor.split(".");
        v0 = va[0];
        v1 = va[1];
        if (v1.length == 1) {
            var valorfinal = v0 + "." + v1 + "00";
            return valorfinal;
        } else if (v1.length == 2) {
            var valorfinal = v0 + "." + v1 + "0";
            return valorfinal;
        } else {
            return valor;
        }

    } else {
        valor = valor + ".000";
        return valor
    }
    return val;
}
function CargarTablaPosiciones() {
    var acc = "CargarTablaPos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#SecCuerpo2').html(data);
            loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
            AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
        }
    });
}
function AgregarFilaTabla() {
    $('#temporalro').remove();
    var ch = document.getElementsByName("Cehckbx");
    var valor = ch[ch.length - 1].value;
    var i = parseInt(valor) + 1;
    var newfiladata = "<tr id=\"tr" + i + "\">"
            + "<td><input type=\"checkbox\" name=\"Cehckbx\" value=\"" + i + "\"/></td>"
            + "<td><input type=\"text\" class='tdCMatch' id=\"tdMater" + i + "\" name=\"MaterTD\" onfocus=\"MostrarMatch('tdMater', 'matchtdmaterial', '" + i + "')\" maxlength=\"40\"/><button id=\"matchtdmaterial" + i + "\" onclick=\"MostrarMatchGridMateriales('VentanaModalMateriales', 'handle6', '" + i + "');\" name=\"matchMaterial\" class='BtnMatchIconGrid'></button></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"tdCanti" + i + "\" name=\"CantiTD\" onblur=\"this.value = checkDec(this.value, 3,'" + i + "')\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"tdUmedi" + i + "\" name=\"UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "<td><input type=\"text\" class='tdSMatch' id=\"tdDescr" + i + "\" name=\"DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "</tr>";
    var tempro = "<tr class=\"ocultar\" id=\"temporalro\"><td>00</td><td>0000000000000000000000</td><td>0000000000000000000000000</td><td>000000000000000000000</td><td>0000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>";

    $('#TabBody2').append(newfiladata);
    $('#TabBody2').append(tempro);
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
}
function EliminarFilas() {
    var table = document.getElementById("TabBody2");
    var chk = document.getElementsByName("Cehckbx");
    var tam = chk.length;
    var i = tam;
    while (i >= 0) {
        if (i == 0) {
            break;
        } else {
            var o = parseInt(i) - 1;
            if (chk[o].checked)
            {
                table.deleteRow(o);
                i--;
            } else {
                i--;
            }

        }
    }
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    VerificarDatosBl();
}
function CargarMaterial(material, pos) {
    var cen = $('#Centro');
    var alm = $('#Almacen');
    if (cen.val().trim().length == 0) {
        ShowMsg(3, "images/advertencia.PNG", "audio/sapmsg.wav");
        cen.focus();
        return;
    }
    if (alm.val().trim().length == 0) {
        ShowMsg(4, "images/advertencia.PNG", "audio/sapmsg.wav");
        alm.focus();
        return;
    }
    var acc = "CargarMaterial";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Material=" + material + "&Centro=" + cen.val() + "&Almacen=" + alm.val(),
        success: function (data) {
            if (data[0] == "") {
                ShowMsg(5, "images/advertencia.PNG", "audio/sapmsg.wav");
                $('#tdMater' + pos).val("");
                $('#tdUmedi' + pos).val("");
                $('#tdDescr' + pos).val("");
                $('#tdCanti' + pos).val("");
            } else {
                $('#tdMater' + pos).val(data[0]);
                $('#tdUmedi' + pos).val(data[2]);
                $('#tdDescr' + pos).val(data[1]);
//                $('#tdCanti' + pos).focus();
            }
        }
    });
}
function ValidarDatos(tipo, valor, valor2, valor3) {
    var resp = false;
    var acc = "ValidarDato";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Tipo=" + tipo + "&Valor1=" + valor + "&Valor2=" + valor2 + "&Valor3=" + valor3,
        success: function (data) {
            if (data == 1) {
                resp = true;
            }
        }
    });
    return resp;
}
function ValidarTabla(Centro, Almacen, TipoMov, CCosto, Orden) {
    var Mats = document.getElementsByName("MaterTD");
    var Cant = document.getElementsByName("CantiTD");
    var Umed = document.getElementsByName("UMediTD");
    var ch = document.getElementsByName("Cehckbx");
    var a = 0;
    for (i = 0; i < Mats.length; i++) {
        if (!(Mats[i].value == null || Mats[i].value == "")) {
            a += 1;
        }
    }
    if (a < 1) {
        ShowMsg(14, "images/advertencia.PNG", "audio/sapmsg.wav");
    } else {
        for (i = 0; i < ch.length; i++) {
            if (Mats[i].value.length > 0) {
                if (ValidarDatos('MAT', Mats[i].value, Centro, Almacen) == false) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/sapmsg.wav");
                    Mats[i].focus();
                    return;
                }
                if (Cant[i].value.length == 0) {
                    Cant[i].focus();
                    ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (Cant[i].value == "0.000") {
                    Cant[i].focus();
                    ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (Umed[i].value.length == 0) {
                    Umed[i].focus();
                    ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }

            }
        }
        ShowMsg(18, "images/load.gif", "audio/sapmsg.wav");
        $('#guardar').prop("disabled", true);
        SaveDataFolio(Centro, Almacen, TipoMov, CCosto, Orden);
    }
}
function SaveDataFolio(Centro, Almacen, TipoMov, CCosto, Orden) {
//    var folio = Getfolio();
//    if (folio == 0) {
//        ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
//    } else if (folio == 1) {
//        cont = 1;
//        if (cont == 50) {
//            var time = Randomtime();
//            setTimeout(function () {
//                SaveDataFolio(Centro, Almacen, TipoMov, CCosto, Orden);
//            }, time);
//        } else {
//            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
//        }
//        cont = cont + 1;
//    } else {
//      
//    }

    var random = ObtenerFolioRandom();
    GuardarCabecera(Centro, Almacen, TipoMov, CCosto, Orden, random);
}
function ObtenerFolioRandom() {
    var name = $('#NombreUser').val();
    var ip = $('#IpData').val();
    var n = ip + "" + name;
    return n;
}
function Randomtime() {
    var number = Math.random() * 10000;
    return number;
}

//function Getfolio() {
//    var folio;
//    acc = "RevisarFolio";
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'peticionCrearReserva',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "Accion=" + acc,
//        success: function (data) {
//            folio = data;
//        }
//    });
//    return folio;
//}
function GuardarCabecera(Centro, Almacen, TipoMov, CCosto, Orden,  random) {
    var datos = "&Centro=" + Centro + "&Almacen=" + Almacen + "&TipoMov=" + TipoMov + "&CCossto=" + CCosto + "&Orden=" + Orden + "&Random=" + random;
    var acc = "Guardarcabacera";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            GuardarPosiciones(Centro, Almacen, TipoMov, CCosto, Orden, random);
        }
    });
}
function GuardarPosiciones(Centro, Almacen, TipoMov, CCosto, Orden, random) {
    var ch = document.getElementsByName("Cehckbx");
    var Mats = document.getElementsByName("MaterTD");
    var Cant = document.getElementsByName("CantiTD");
    var Umed = document.getElementsByName("UMediTD");
    var Desc = document.getElementsByName("DesciTD");
    var pos = 0;
    for (i = 0; i < ch.length; i++) {
        if (Mats[i].value.length > 0) {
            savePos(random, i, Mats[i].value, Centro, Almacen, Cant[i].value, Umed[i].value, CCosto, Orden, TipoMov, Desc[i].value);
            pos = pos + 1;
        }
    }
    ActualizaFolio(random);
}
function savePos(folio, i, mat, cen, alm, can, ume, cco, ord, tmo, txt) {
    var posi = (i) + 1;
    var acc = "GuardarItems";
    var datos = "&FolioF=" + folio + "&PosicionItem=" + posi + "&Material=" + mat + "&Centro=" + cen + "&Almacen=" + alm + "&CantidadNecesaria=" + GetCantend(can, ume) + "&UnidadMedida=" + ume + "&CCossto=" + cco + "&Orden=" + ord + "&TipoMov=" + tmo + "&Descripcion=" + encodeURIComponent(txt);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
        }
    });
}
function ActualizaFolio(random)
{
    var acc = "ActualizarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc  + "&Random=" + random,
        success: function (data) {
            $('#guardar').prop("disabled", false);
            LoadItems();
            ShowMsg(20, "images/aceptar.png", "audio/sapmsg.wav", data);
        }
    });
}
function LoadItems() {
    CargarTablaPosiciones();
    ConsultaTipoMovimientos();
    $('#Centro').val('');
    $('#Centro').css("background-image", "url(images/necesario.PNG)");
    $('#Almacen').val('');
    $('#Almacen').css("background-image", "url(images/necesario.PNG)");
    $('#CentroCoste').val('');
    $('#CentroCoste').prop('disabled', true);
    $('#CentroCoste').css("background-image", "none)");
    $('#Orden').val('');
    $('#Orden').prop('disabled', true);
    $('#Orden').css("background-image", "none)");
}
function GetIp() {
    window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;   //compatibility for firefox and chrome
    var pc = new RTCPeerConnection({iceServers: []}), noop = function () {};
    pc.createDataChannel("");    //create a bogus data channel
    pc.createOffer(pc.setLocalDescription.bind(pc), noop);    // create offer and set local description
    pc.onicecandidate = function (ice) {  //listen for candidate events
        if (!ice || !ice.candidate || !ice.candidate.candidate)
            return;
        var myIP = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/.exec(ice.candidate.candidate)[1];
        pc.onicecandidate = noop;
        $('#IpData').val(myIP);
    };
}
