/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#btnmatch').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#aceptar').click(function () {
        ValidarDato();
    });
    $('#NotifiPM').focus(function () {
        $('#btnmatch').show();
    });
    $('#btnmatch').click(function () {
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
        $('#ClaseAvisoMAA').val("");
        $('#ClaseAvisoMAA').focus();
        $('#NotifiMAA').val("");
        $('#DescripMAA').val("");
        $('#numAcMax').val("500");
        borramsg();
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
    });
    $('#CerrarVentanaNo').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModal').hide();
        $('#BuscarParamNot').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
        $('#NotifiPM').focus();
    });
    $('#CerrarVentanaNo2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModal').hide();
        $('#BuscarParamNot').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
        $('#NotifiPM').focus();
    });
    $('#ClaseAvisoMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13)
        {
            ConsultarAvisos();
        }
        if (tecla == 32) {
            return false;
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#NotifiMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13)
        {
            ConsultarAvisos();
        }
        if (tecla == 32) {
            return false;
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#DescripMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13)
        {
            ConsultarAvisos();
        }
        if (tecla == 32) {
            return false;
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13)
        {
            ConsultarAvisos();
        }
        if (tecla == 32) {
            return false;
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9]/;
        return patron.test(te);
    });
    $('#okAviso').click(function () {
        ConsultarAvisos();
    });
    $('#NotifiPM').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarDato();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function retronarsiltromatch(id1, id2) {
    $('#' + id1).css('display', 'block');
    $('#' + id2).css('display', 'none');
}
function ValidarDato() {
    if ($('#NotifiPM').val().length > 0) {
        var acc = "ValidarAviso";
        var aviso = $('#NotifiPM').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Aviso=" + aviso,
            success: function (dato) {
                if (dato == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $(location).attr('href', 'Avisos.jsp?Aviso=' + aviso + "&Tipo=" + dato);
                }
            }
        });
    } else {
        $('#NotifiPM').focus();
        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
    }
}
function ConsultarAvisos() {
    var acc = "ConsultaMatchAvisos";
    var datos = "&Clase=" + $('#ClaseAvisoMAA').val() + "&Aviso=" + $('#NotifiMAA').val() + "&Texto=" + $('#DescripMAA').val() + "&Ctd=" + $('#numAcMax').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#BuscarParamNot').css('display', 'none');
                $('#ConsultaTabla').css('display', 'block');
                $('#cargarDatosN').html(data);
                fnc('table-scroll', 'fixedY');
                borramsg();
            }
        }
    });
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function seleccionar(sap, sam) {
    if (sap.length > 0) {
        $('#NotifiPM').val(sap);
    } else {
        $('#NotifiPM').val(sam);
    }
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParamNot').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#NotifiPM').focus();
}
