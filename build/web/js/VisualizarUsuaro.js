/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#guardar').prop("disabled", true);
    $('#btnmatch').hide();
    //// VARIABLES GLOBALES
    //// INPUT'S
    var CENT = $('#Centro_U');
    var USER = $('#User_U');
    var NOMB = $('#Nombre_U');
    var APPA = $('#APP_U');
    var APMA = $('#APM_U');
    var RFC = $('#RFC_U');
    var MAIL = $('#Email_U');
    var TEL1 = $('#Tel1_U');
    var TEL2 = $('#Tel2_U');
    var CALL = $('#Calle_U');
    var NUMI = $('#NumInt_U');
    var NUME = $('#NumExt_U');
    var COLO = $('#Colonia_U');
    var POBL = $('#Poblacion_U');
    var ESTA = $('#Estado_U');
    var PAIS = $('#Pais_U');

    var arrinp = [
        PAIS,
        ESTA,
        POBL,
        COLO,
        NUME,
        NUMI,
        CALL,
        TEL2,
        TEL1,
        MAIL,
        RFC,
        APMA,
        APPA,
        NOMB,
        USER,
        CENT
    ];
    $('#aceptar').click(function () {
        validar();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    USER.focus(function () {
        $('#btnmatch').show();
    });
    USER.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validar();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[ÑñA-Za-z0-9\s]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });

    function validar() {
        if (USER.val().trim().length == 0)
        {
            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            limpiar();
            USER.focus();
        } else
        {
            enviarDatos(USER.val().trim().toUpperCase());
        }
    }
    function ConsultarUser() {
        var acc = "ConsultaUsuario";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloVisualUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Parametro1=" + $('#usuariio_bus').val() + "&Parametro2=" + $('#numAcMax').val(),
            success: function (data) {
                if (data == 0) {
                    ShowMsg(4, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    $('#cargarDatos').html(data);
                    $('#BuscarParam_u').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    document.getElementById('table-scroll').onscroll = function () {
                        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                    };
                }
            }
        });
    }
    $('#btnmatch').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCUser').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCUser2').click(function () {
        ocultarVentana();
    });
    $('#btnbuuser').click(function () {
        $('#BuscarParam_u').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#usuariio_bus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUser();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[ÑñA-Za-z0-9\s]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUser();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okUs').click(function () {
        ConsultarUser();
    });
    function enviarDatos(user) {
        var acc = "ValidarUsuario";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloVisualUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Parametro1=" + user,
            success: function (data) {
                if (data == 1) {
                    borramsg();
                    cargarDatos(user);
                    CargarPemisos(user);
                    $('#tree3').show();
                } else {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                    limpiar();
                }
            }
        });
    }
    function cargarDatos(user) {
        var acc = "CargarUsuario";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloVisualUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Parametro1=" + user,
            success: function (data) {
                var ar = new Array();
                ar = data.split(",");
                CENT.val(ar[0]);
                NOMB.val(ar[1]);
                APPA.val(ar[2]);
                APMA.val(ar[3]);
                RFC.val(ar[4]);
                MAIL.val(ar[5]);
                TEL1.val(ar[6]);
                TEL2.val(ar[7]);
                CALL.val(ar[8]);
                NUMI.val(ar[9]);
                NUME.val(ar[10]);
                COLO.val(ar[11]);
                POBL.val(ar[12]);
                ESTA.val(ar[13]);
                PAIS.val(ar[14]);
                $('#Habilitado_U').prop('checked', VerificarCheck(ar[15]))
                ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
            }
        });
    }
    function limpiar() {
        $.each(arrinp, function (i, v) {
            v.val("");
        });
        $('#Habilitado_U').prop("checked", false);
        $('#tree3').hide();
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
function VerificarCheck(valor) {
    if (valor == 1 || valor == "1") {
        return true;
    } else {
        return false;
    }
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
    $('#usuariio_bus').val("");
    $('#usuariio_bus').focus();
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
    $('#BuscarParam_u').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#User_U').focus();
}
function seleccionar(user) {
    var u = $('#User_U');
    u.focus();
    u.val(user);
    ocultarVentana();
}
function getPermission(id, p) {
    var tree = $("#tree3").dynatree("getTree");
    var node = tree.getNodeByKey(id);

    if (p == "1") {
        if (node.isSelected()) {
        } else {
            node.toggleSelect();
        }
    } else if (p == "0") {
        if (node.isSelected()) {
            node.toggleSelect();
        } else {

        }

    }
}