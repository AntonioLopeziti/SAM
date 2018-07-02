/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    checbrowser();
    $('#iconmsg').hide();
    $('#header').prop('disabled', true);
    $('#guardar').prop('disabled', true);
    $('#regresar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#Usuario').css('background-image', 'url(images/necesario.PNG)');
    startTime();
    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
    var f = new Date();
    var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
    $('#fecha').html(fechaActual);
    $('#Usuario').focus(function () {
        $('#Usuario').css('background-image', 'none');
    });
    $('#Usuario').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            Validar();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#Usuario').blur(function () {
        if ($('#Usuario').val().length > 0) {
            $('#Usuario').css('background-image', 'none');
        } else {
            $('#Usuario').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#Password').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            Validar();
        }
    });
    $('#idiom').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            Validar();
        }
    });
    $('#aceptar').click(function () {
        Validar();
    });
    $('#Cerrarventana').click(function () {
        cerrarVentana();
    });
    $('#Cerrarventana2').click(function () {
        cerrarVentana();
    });
    $('#okUser').click(function () {
        var BE = document.createElement("audio");
        BE.src = "audio/saperror.wav";
        var img = $('#iconmsg');
        img.attr('src', 'images/advertencia.PNG');
        var men = $('#msg');
        var pwdn1 = $('#pwdnueva');
        var pwdn2 = $('#pwdnueva2');
        if (pwdn1.val().length == 0) {
            BE.play();
            img.show();
            men.html("Clave obligatoria");
            pwdn1.focus();
            return;
        }
        if (pwdn1.val().length < 8) {
            BE.play();
            img.show();
            men.html("La clave de contener como minimo 8 caracteres");
            pwdn1.focus();
            return;
        }
        if (pwdn2.val().length == 0) {
            BE.play();
            img.show();
            men.html("Repita la Clave, campo obligatorio");
            pwdn2.focus();
            return;
        }
        if (pwdn2.val().length < 8) {
            BE.play();
            img.show();
            men.html("La clave debe contener 8 caracteres minimo");
            pwdn2.focus();
            return;
        }
        if (pwdn1.val() != pwdn2.val()) {
            BE.play();
            img.show();
            men.html("Las claves no coinciden");
            pwdn2.focus();
            return;
        }
        var acc = "ModificarClaveDefault";
        user = $('#userclave').html();
        us = user.toUpperCase().trim();
        pwd = hash = calcSHA1(pwdn1.val());
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionModuloCrearUsuario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Usuario=" + us + "&Password=" + encodeURIComponent(pwd),
            success: function (data) {
                if (data == 1) {
                    BE.play();
                    img.attr('src', 'images/aceptar.png');
                    img.show();
                    men.html("Clave de acceso modificada");
                    $('#Usuario').val(us);
                    cerrarVentana();
                } else {
                    BE.play();
                    img.show();
                    men.html("Ocurrio un problema interno al modificar la clave de acceso");
                    cerrarVentana();
                }
            }
        });
    });
});
function Validar()
{
    var user = $('#Usuario');
    var pwd = $('#Password');
    var lan = $('#idiom');
    if (user.val().length <= 0 || pwd.val().length <= 0 || lan.val().length <= 0)
    {
        var BE = document.createElement("audio");
        BE.src = "audio/saperror.wav";
        BE.play();
        var img = $('#iconmsg');
        img.attr('src', 'images/advertencia.PNG');
        img.show();
        var men = $('#msg');
        men.html("Complete todos los campos vacios");
        dtaFocus();
    } else
    {
        ValidatioLAN(user.val(), hash = calcSHA1(pwd.val()), lan.val().toUpperCase());
    }
}

function ValidatioLAN(user, pass, lan)
{
    if (lan == "EN" || lan == "ES") {
        enviarDatos(user, pass, lan);
    } else {
        var BE = document.createElement("audio");
        BE.src = "audio/saperror.wav";
        BE.play();
        var img = $('#iconmsg');
        img.attr('src', 'images/advertencia.PNG');
        img.show();
        var men = $('#msg');
        men.html("El idioma " + lan + " no existe en el sistema");
        dtaFocus();
    }
}
function inval()
{
    var BE = document.createElement("audio");
    BE.src = "audio/saperror.wav";
    BE.play();
    var img = $('#iconmsg');
    img.attr('src', 'images/advertencia.PNG');
    img.show();
    var men = $('#msg');
    men.html("Función Invalida");
}
function dtaFocus()
{
    var temp = new Array();
    temp[0] = $('#Usuario');
    temp[1] = $('#Password');
    temp[2] = $('#idiom');
    for (i = 0; i < temp.length; i++)
    {
        if (temp[i].val().length === 0)
        {
            temp[i].focus();
            return;
        }
    }
}
function enviarDatos(use, pwd, lan)
{
    var icon = $('#iconmsg');
    var men = $('#msg');
    var BE = document.createElement('audio');
    user = use.toUpperCase();
    $.ajax({
        beforeSend: function () {
            $("input:text").prop("disabled", true);
            $("button").prop("disabled", true);
            icon.show();
            icon.attr('src', 'images/load.gif');
            men.html('Espere un momento por favor');
        },
        type: 'GET',
        url: 'AutenticarT',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Usuario=" + user + "&Password=" + pwd + "&Idioma=" + lan,
        success: function (data) {
            $("button").prop("disabled", false);
            $("input:text").prop("disabled", false);
            if (data == 1) {
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                location.href = "Bienvenido.jsp";
            }
            if (data == 2) {
                BE.play();
                $('#Usuario').val("");
                $('#Password').val("");
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                men.html("Problemas de Conexion");
            }
            if (data == 3) {
                BE.src = "audio/saperror.wav";
                BE.play();
                $('#Usuario').val("");
                $('#Password').val("");
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                men.html("El usuario " + user + " no éxiste en el sistema o se encuentra deshabilitado");
                dtaFocus();
            }
            if (data == 4) {
                window.location.href = "ConfiguracionServidor.jsp";
            }
            if (data == 5) {
                BE.src = "audio/saperror.wav";
                BE.play();
                $('#Usuario').val("");
                $('#Password').val("");
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                dtaFocus();
                men.html("Nombre o clave de acceso incorrectos (repita la entrada al sistema)");
            }
            if (data == 6) {
                ChangePassword(user);
                $('#Usuario').val("");
                $('#Password').val("");
                icon.hide();
                men.html('');

            }

        },
        error: function (xhr, status) {
            BE.src = "audio/saperror.wav";
            BE.play();
            $('#Usuario').val("");
            $('#Password').val("");
            men.html("Error de respuesta");
            dtaFocus();
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
        }
    });
}
function ChangePassword(user) {
    $('#userclave').html(user);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 800;
    var alto = 400;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#VentanaModalInicio');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#pwdnueva').val("");
    $('#pwdnueva2').val("");
    $('#Usuario').prop('disabled', true);
    $('#Password').prop('disabled', true);
    $('#idiom').prop('disabled', true);
    $('#aceptar').prop('disabled', true);
    var theHandle = document.getElementById("handlelo");
    var theRoot = document.getElementById("VentanaModalInicio");
    Drag.init(theHandle, theRoot);
    $('#pwdnueva').focus();
}

function cerrarVentana() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalInicio').css('display', 'none');
    $('#Usuario').prop('disabled', false);
    $('#Password').prop('disabled', false);
    $('#idiom').prop('disabled', false);
    $('#aceptar').prop('disabled', false);
    $('#Usuario').focus();
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
function checbrowser() {
    var isChrome = window.chrome;
    if (!(isChrome)) {
        alert("Navegador no  soportado, debe usar Google Chrome para accesar al sistema ");
        window.location.href = "http://www.google.com";
    }
}
function MIE() {
    var rv = -1; // Return value assumes failure.

    if (navigator.appName == 'Microsoft Internet Explorer') {

        var ua = navigator.userAgent,
                re = new RegExp("MSIE ([0-9]{1,}[\\.0-9]{0,})");

        if (re.exec(ua) !== null) {
            rv = parseFloat(RegExp.$1);
        }
    } else if (navigator.appName == "Netscape") {
        if (navigator.appVersion.indexOf('Trident') === -1)
            rv = 12;
        else
            rv = 11;
    }

    return rv;
}
