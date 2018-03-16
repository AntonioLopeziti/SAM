/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    $('#iconmsg').hide();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#btnmatch').hide();
    $('#btnmatch2').hide();
    var equ = $('#EquipoHR');
    var cen = $('#CentroHR');
    var alt = $('#AltHR');
    var arr = [
        equ,
        cen,
        alt
    ];
    $.each(arr, function (i, v) {
        if (i < 2) {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function () {
            v.css('background-image', 'none')
            if (i == 0) {
                $('#btnmatch').show();
                $('#btnmatch2').hide();
            }
            if (i == 1) {
                $('#btnmatch').hide();
                $('#btnmatch2').show();
            }
            if (i == 2) {
                $('#btnmatch').hide();
                $('#btnmatch2').hide();
            }
        });
        v.blur(function () {
            if (i == 0) {
                if (v.val().length == 0) {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
            if (i == 1) {
                if (v.val().length == 0) {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
        });
        switch (i) {
            case 0:
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        CargaDatos();
                    }
                    patron = /[-0-9a-zA-Z]/;
                    t = String.fromCharCode(tecla);
                    return patron.test(t);
                });
                break;
            case 1:
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        CargaDatos();
                    }
                    patron = /[0-9a-zA-Z]/;
                    t = String.fromCharCode(tecla);
                    return patron.test(t);
                });
                break;
            case 2:
                v.keypress(function (e) {
                    tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        CargaDatos();
                    }
                    patron = /[0-9a-zA-Z]/;
                    t = String.fromCharCode(tecla);
                    return patron.test(t);
                });
                break;
        }
    });
    ///// Match Equipos
    $('#btnmatch').click(function () {
        mostrarVentanaModal("VentanaModal", "handle", "equiBus", "dnEquBus", "numAcMax");
    });
    $.each([$('#CerraMCEqu'), $('#CerraMCEqu2')], function (i, v) {
        v.click(function () {
            ocultarVentana("VentanaModal", "BuscarParam", "ConsultaTabla", equ);
        });
    });
    $('#equiBus').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-0-9a-zA-Z]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#dnEquBus').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipos();
        }
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipos();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okEquipo').click(function () {        
        ConsultaEquipos();
    });
    function ConsultaEquipos() {        
        var acc = "ConsultaMatchEquipos";
        var datos = "&Equipo=" + $('#equiBus').val() + "&DEquipo=" + $('#dnEquBus').val() + "&Ctd=" + $('#numAcMax').val();        
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloHojaRutaPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + datos,
            success: function (data) {                
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParam').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    $('#cargarDatos').html(data);
                    fnc('table-scroll', 'fixedY');
                    borramsg();
                }
            }
        });
    }
    $('#retmcequipo').click(function () {
        retronarsiltromatch('BuscarParam', 'ConsultaTabla');
    });
    /// Match Cebtro
    // ///// Match Cebtro
    $('#btnmatch2').click(function () {
        mostrarVentanaModal("VentanaModal2", "handle2", "CenBus", "CNombreBus", "numAcMax2");
    });
    $.each([$('#CerrarVen1'), $('#CerrarVen2')], function (i, v) {
        v.click(function () {
            ocultarVentana("VentanaModal2", "BuscarParam2", "ConsultaTabla2", cen);
        });
    });
    $('#CenBus').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentros();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#NCentro').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentros();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentros();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okCentro').click(function () {
        ConsultaCentros();
    });
    function ConsultaCentros() {
        var acc = "ConsultaMatchCentros";
        var datos = "&Centro=" + $('#CenBus').val() + "&NCentro=" + $('#CNombreBus').val() + "&Ctd=" + $('#numAcMax2').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloHojaRutaPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParam2').css('display', 'none');
                    $('#ConsultaTabla2').css('display', 'block');
                    $('#cargarDatos2').html(data);
                    fnc('table-scroll2', 'fixedY2');
                    borramsg();
                }
            }
        });
    }
    $('#RetcentroBoom').click(function () {
        retronarsiltromatch('BuscarParam2', 'ConsultaTabla2');
    });
    $('#aceptar').click(function () {
        CargaDatos();
    });
    function  CargaDatos() {
        if (equ.val().length == 0) {
            equ.focus();
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (cen.val().length == 0) {
            cen.focus();
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        cargarData();
    }
    function cargarData() {
        var acc = "CargarDatosHR";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloHojaRutaPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Mater=" + equ.val() + "&Centro=" + cen.val() + "&Alter=" + alt.val(),
            success: function (data) {                
                if (data == 1) {
                    CleanTable();
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    ObtenerDescr(equ.val());
                    $('#SecCuerpo').html(data);
                    ShowMsg(4, "images/aceptar.png", "audio/sapmsg.wav");
                }
            }
        });
    }
    function ObtenerDescr(eq) {
        var acc = "ObtenerDescripcionEquipo";
        $.ajax({
            type: 'GET',
            url: 'peticionModuloHojaRuta',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Equipo=" + eq,
            success: function (datas) {
                $('#DesEquiHR').val(datas);
            }
        });
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
function mostrarVentanaModal(idVen, handle, id1, id2, id3)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + idVen);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#' + id1).val("");
    $('#' + id1).focus();
    $('#' + id2).val("");
    $('#' + id3).val("500");
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(idVen);
    Drag.init(theHandle, theRoot);
}
function ocultarVentana(idven, id1, id2, id3)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + idven).hide();
    $('#' + id1).css('display', 'block');
    $('#' + id2).css('display', 'none');
    $(id3).focus();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function fnc(tableScr, fixed) {
    document.getElementById(tableScr).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}
function retronarsiltromatch(id1, id2) {
    $('#' + id1).css('display', 'block');
    $('#' + id2).css('display', 'none');
}
function CleanTable() {
    var acc = "cleantable";
    $.ajax({
        type: 'GET',
        url: 'peticionModuloHojaRuta',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (datas) {
            $('#SecCuerpo').html(datas);
        }
    });
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
