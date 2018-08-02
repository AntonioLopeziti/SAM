/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    CargarTipoSolped();
    CargarUsuarioBusqueda();
    AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
    startTime();
    $('#iconmsg').hide();
    $('#ICONAD').hide();
    $('#btnservicios').prop('disabled', true);
    $('#matchFolSolped').hide();
    $('#Numsoli').focus(function () {
        $('#matchFolSolped').show();
    });
    $('#matchFolSolped').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCSolped').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCSolped2').click(function () {
        ocultarVentana();
    });
    $('#retornafiltrosolped').click(function () {
        $('#BuscarParamsolped').css('display', 'block');
        $('#ConsultaTablaSolped').css('display', 'none');
    });
    $('#BusSolpedSAP').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaSolped();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#fechasol').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaSolped();
        }
    });
    $('#UsuarioSPBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaSolped();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaSolped();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#oksolp').click(function () {
        ConsultaSolped();
    });
    function ConsultaSolped() {
        var acc = "ConsultaSolpeds";
        var datos = "Accion=" + acc + "&NumSol=" + $('#BusSolpedSAP').val() + "&Ctd=" + $('#numAcMax').val() + "&FECHS=" + $('#fechasol').val() + "&UsuarioSP=" + $('#UsuarioSPBus').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    $('#cargarDatosSolped').html(data);
                    $('#BuscarParamsolped').css('display', 'none');
                    $('#ConsultaTablaSolped').css('display', 'block');
                    document.getElementById('table-scrollSolped').onscroll = function () {
                        document.getElementById('fixedYSolped').style.top = document.getElementById('table-scrollSolped').scrollTop + 'px';
                    };
                }
            }
        });
    }
    $('#Numsoli').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarSolped();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#aceptar').click(function () {
        ValidarSolped();
    });
    var TipoSolped = "";
    var NumSolped = "";
    function ValidarSolped() {
        var sol = $('#Numsoli');
        if (sol.val().length == 0) {
            sol.focus();
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            CargarTablaSolped('0', '');
            CargarCabeceraSolped('0', '');
            CargarListaPosiciones('');
            LimpiardatosPosiion();
        } else {
            var acc = "ValidarSolped";
            datos = "Accion=" + acc + "&NumSol=" + sol.val();
            $.ajax({
                async: false,
                type: "GET",
                url: "peticionVisualizarSolped",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: datos,
                success: function (data) {
                    var nr = "";
                    var n = new Array();
                    n = data.split(",");
                    if (n[0] == 1) {
                        nr = "P";
                    } else if (n[1] == 1) {
                        nr = "M";
                    } else {
                        sol.focus();
                        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                    }
                    TipoSolped = nr;
                    NumSolped = sol.val();
                    CargarTablaSolped(sol.val(), nr);
                    CargarCabeceraSolped(sol.val(), nr);
                    CargarListaPosiciones(nr);
                }
            });
        }
    }
    function CargarCabeceraSolped(sol, tipo) {
        $('#ICONAD').hide();
        $('#mensgesolped').val('');
        acc = "CargarCabecera";
        datos = "Accion=" + acc + "&NumSol=" + sol + "&Tipo=" + tipo;
        $.ajax({
            async: false,
            type: "GET",
            dataType: "json",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#ClaseDoc').val(data[0]);
                $('#TextCabecera_SP').val(data[1]);
                $('#Numsoli').val(data[2]);
                $('#necesidad').val(data[3]);
                $('#OrgCompras').val(data[4]);
                $('#GpoCompras').val(data[5]);
                var msger = data[6];
                if (msger.length > 0) {
                    $('#mensgesolped').val(data[6]);
                    $('#ICONAD').show();
                    $('#ICONAD').attr('src', 'images/advertencia.PNG');
                }
            }
        });
        CargarTxtCabecera(sol, tipo);
    }
    function CargarTxtCabecera(sol, tipo) {
        var acc = "CargarTxtCabecera";
        datos = "Accion=" + acc + "&NumSol=" + sol + "&Tipo=" + tipo;
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#TextCabecera_SP').val(data);
            }
        });
    }
    function CargarTablaSolped(sol, tipo) {
        acc = "CargarTabla";
        datos = "Accion=" + acc + "&NumSol=" + sol + "&Tipo=" + tipo;
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#TabBody').html(data);
                $("#DobleSection").scroll(function () {
                    $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                });
                $("#SecCuerpo").scroll(function () {
                    $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                });
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
            }
        });
    }
    function CargarListaPosiciones(tipo) {
        LimpiardatosPosiion();
        acc = "CargarListaPosiciones";
        datos = "Accion=" + acc + "&NumSol=" + NumSolped + "&Tipo=" + tipo;
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#Distribucion_SP').html(data);
            }
        });
    }
    $('#Distribucion_SP').change(function () {
        var pos = $('#Distribucion_SP').val();
        if (pos.length == 0) {
            LimpiardatosPosiion();
        } else {
            acc = "CargarPosicion";
            datos = "Accion=" + acc + "&NumSol=" + NumSolped + "&Tipo=" + TipoSolped + "&Pos=" + pos;
            $.ajax({
                async: false,
                type: "GET",
                dataType: "json",
                url: "peticionVisualizarSolped",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: datos,
                success: function (data) {
                    var tpos = data[1];
                    if (tpos.trim() === "F") {
                        $('#btnservicios').prop('disabled', false);
                        cargarDatosServ(data);
                        cargarTablaServ(pos);
                    } else {
                        $('#btnservicios').prop('disabled', true);
                    }
                    $('#TipoImputacion').val(data[0]);
                    $('#TipoPosicion').val(tpos);
                    $('#Material').val(data[2]);
                    $('#Cantidad').val(data[3]);
                    $('#FecEntrega').val(data[4]);
                    $('#Centro').val(data[5]);
                    $('#Almacen').val(data[6]);
                    $('#Txtbrve').val(data[7]);
                    $('#unidamedida').val(data[8]);
                    $('#GpoArticulo').val(data[9]);
                    $('#solicitante').val(data[10]);
                    $('#ctaMayor').val(data[11]);
                    $('#CenCosto').val(data[12]);
                    $('#Orde').val(data[13]);
                    $('#TextPosicion_SP').val(data[14]);
                    $('#E1').val(data[15]);
                    $('#E2').val(data[16]);
                    $('#E3').val(data[17]);
                }
            });
            CargarTxtPosiciones(pos, TipoSolped);
        }
    });
    function CargarTxtPosiciones(pos, tips) {
        var acc = "CargarTxtPosiciones";
        datos = "Accion=" + acc + "&NumSol=" + NumSolped + "&Pos=" + pos + "&Tipo=" + tips;
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#TextPosicion_SP').val(data);
            }
        });
    }
    function cargarDatosServ(a) {
        $('#ctaMayorSer').val(a[11]);
        $('#ImputacionSer').val(a[0]);
        $('#MaterialSer').val(a[2]);
        $('#CantidadSer').val(a[3]);
        $('#FentregaSer').val(a[4]);
        $('#CentroSer').val(a[5]);
        $('#AlmacenSer').val(a[6]);
        $('#TipoPosicionSer').val(a[1]);
        $('#CentroCostoSer').val(a[12]);
        $('#TxtbrveSer').val(a[7]);
        $('#UnidadMediaSer').val(a[8]);
        $('#GArticuloSer').val(a[9]);
        $('#SolicitanteSer').val(a[10]);
        $('#OrdenSer').val(a[13]);
    }
    function cargarTablaServ(pos) {
        var acc = "CargarServicioPosicion";
        datos = "Accion=" + acc + "&NumSol=" + NumSolped + "&Pos=" + pos + "&Tipo=" + TipoSolped;
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarSolped",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: datos,
            success: function (data) {
                $('#gloSer').html(data);
            }
        });
    }
    $('#btnservicios').click(function () {
        OpenServices();
    });
    $('#Cerrarservicios').click(function () {
        CerrarServices();
    });
    function LimpiardatosPosiion() {
        var i = $("#divimpu :input");
        i.val("");
        var ni = $("#divim :input");
        ni.val("");
        var sini = $("#WindowService :input");
        sini.val("");
        $('#TextPosicion_SP').val("");
        $('#btnservicios').prop('disabled', true);
        CerrarServices();
    }

    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    function CargarTipoSolped() {
        var acc = "ConusltarTipoSolped";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Centro=" + $('#Centro').val().trim(),
            success: function (data) {
                $('#ClaseDoc').html(data);
            }
        });
    }
});
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
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
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalFolioSolped');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#BusSolpedSAP').val("");
    $('#fechasol').val("");
    $('#BusSolpedSAP').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModalFolioSolped");
    Drag.init(theHandle, theRoot);
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalFolioSolped').hide();
    $('#BuscarParamsolped').css('display', 'block');
    $('#ConsultaTablaSolped').css('display', 'none');
    $('#Numsoli').focus();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function seleccionar(sap, sam) {
    if (sap.length > 0) {
        $('#Numsoli').val(sap);
        ocultarVentana();
    } else {
        $('#Numsoli').val(sam);
        ocultarVentana();
    }
}
function OpenServices() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#WindowService');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
}
function CerrarServices() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#WindowService').css('display', 'none');
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
function CargarUsuarioBusqueda() {
    var usuario = $('#UsuarioSolpedV').val();
    if(usuario === "ADMIN"){
        $('#UsuarioSPBus').val('');
        $('#UsuarioSPBus').prop('readonly',false);
    }else{
        $('#UsuarioSPBus').val(usuario);
        $('#UsuarioSPBus').prop('readonly',true);
    }
}