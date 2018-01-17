/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#aceptar').prop('disabled', true);
    //// VARIABLES GLOBALES
    //// INPUT'S
    var CENT = $('#Centro_U');
    var USER = $('#User_U');
    var PWD1 = $('#Pwd1_U');
    var PWD2 = $('#pwd2_U');
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
        PWD2,
        PWD1,
        USER,
        CENT
    ];
    $.each(arrinp, function (i, v) {
        if (!(i == 5) && !(i == 7) && !(i == 17)) {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function () {
            v.css('background-image', 'none');
        });
        v.blur(function () {
            if (!(i == 5) && !(i == 7) && !(i == 17)) {
                if (v.val().trim().length <= 0) {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
            if (i == 17) {
                if (v.val().length > 0) {
                    var n = validarCentro(v.val());
                    if (n === true) {
                        borramsg();
                    } else {
                        ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                        v.val("");
                        v.focus();
                    }
                }
            }
            if (i == 9) {
                if (v.val().length > 0) {
                    if (v.val().indexOf('@', 0) == -1 || v.val().indexOf(".", 0) == -1) {
                        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                        v.val("");
                        v.focus();
                    } else {
                        borramsg();
                    }
                }
            }
        });

        v.keypress(function (e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (i > 3 && i != 6) {
                if (tecla == 32) {
                    return false;
                }
            }
            if (i == 4 || i == 5 || i == 7 || i == 8) {
                patron = /[0-9]/;
                tecla_final = String.fromCharCode(tecla);
                return patron.test(tecla_final);

            }
            if (i == 9) {
                patron = /[ÑñA-Za-z0-9@.\s]/;
                tecla_final = String.fromCharCode(tecla);
                return patron.test(tecla_final);
            } else {
                patron = /[ÑñA-Za-z0-9\s]/;
                tecla_final = String.fromCharCode(tecla);
                return patron.test(tecla_final);
            }
            if (i == 17) {
                if (tecla == 13) {
                    if (v.val().length > 0) {
                        var n = validarCentro(v.val());
                        if (n === true) {
                            borramsg();
                        } else {
                            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                            v.val("");
                            v.focus();
                        }
                    }
                }
            }

        });

    });
    $('#guardar').click(function () {
        ValidarDatos();
    });
    $('#regresar').click(function () {
        var check = CheckEntradas();
        if (check) {
            var theHandle = document.getElementById('handleDoc');
            var theRoot = document.getElementById('MensajeSalirModulo');
            Drag.init(theHandle, theRoot);
            MensajeSalirModulo();
            $('#FinalizarSIDoc').focus();
        } else {
            $(location).attr('href', 'Bienvenido.jsp');
        }

    });
    $('#finalizar').click(function () {
        var check = CheckEntradas();
        if (check) {
            var theHandle = document.getElementById('handleDoc');
            var theRoot = document.getElementById('MensajeSalirModulo');
            Drag.init(theHandle, theRoot);
            MensajeSalirModulo();
            $('#FinalizarSIDoc').focus();
        } else {
            $(location).attr('href', 'Bienvenido.jsp');

        }
    });
    $('#cancelar').click(function () {
        var check = CheckEntradas();
        if (check) {
            var theHandle = document.getElementById('handleDoc');
            var theRoot = document.getElementById('MensajeSalirModulo');
            Drag.init(theHandle, theRoot);
            MensajeSalirModulo();
            $('#FinalizarSIDoc').focus();
        } else {
            $(location).attr('href', 'Bienvenido.jsp');

        }
    });
    $('#FinalizarSIDoc').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');

    });
    $('#FinalizarNODoc').click(function () {
        CerrarMensajeSalirModulo();
    });
    function validarCentro(centro) {
        var resp = false;
        var acc = "ValidarCentro";
        c = centro.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloCrearUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Centro=" + c,
            success: function (data) {
                if (data == 1) {
                    resp = true;
                }
            }
        });
        return resp;
    }
    function  CheckEntradas() {
        if (PAIS.val().length > 0 ||
                ESTA.val().length > 0 ||
                POBL.val().length > 0 ||
                COLO.val().length > 0 ||
                NUME.val().length > 0 ||
                NUMI.val().length > 0 ||
                CALL.val().length > 0 ||
                TEL2.val().length > 0 ||
                TEL1.val().length > 0 ||
                MAIL.val().length > 0 ||
                RFC.val().length > 0 ||
                APMA.val().length > 0 ||
                APPA.val().length > 0 ||
                NOMB.val().length > 0 ||
                PWD2.val().length > 0 ||
                PWD1.val().length > 0 ||
                USER.val().length > 0 ||
                CENT.val().length > 0
                ) {
            return true;
        } else {
            return false;
        }
    }
    function ValidarDatos() {
        var temp = new Array();
        temp[0] = USER;
        temp[1] = PWD1;
        temp[2] = PWD2;
        temp[3] = NOMB;
        temp[4] = APPA;
        temp[5] = APMA;
        temp[6] = RFC;
        temp[7] = MAIL;
        temp[8] = TEL1;
        temp[9] = CALL;
        temp[10] = NUME;
        temp[11] = COLO;
        temp[12] = POBL;
        temp[13] = ESTA;
        temp[14] = PAIS;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        if (PWD1.val().length >= 8) {
            if (PWD1.val() == PWD2.val()) {
                validarUsuarioExistente(USER.val());
            } else {
                PWD1.focus();
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            }
        } else {
            PWD1.focus();
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
        }
    }
    function validarUsuarioExistente(user) {
        var acc = "ValidarUsuario";
        var us = user.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloCrearUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Usuario=" + us,
            success: function (data) {
                if (data != 1) {
                    GuardarDatosUser();
                } else {
                    ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    }
    function GuardarDatosUser() {
        var acc = "GuardarDatos";
        var pwd = calcSHA1(PWD1.val());
        var Permisos = test();
        var DatosPerson = "&Nombre=" + NOMB.val().toUpperCase() + "&APP=" + APPA.val().toUpperCase() + "&APM=" + APMA.val().toUpperCase() + "&RFC=" + RFC.val().toUpperCase() + "&Email=" + MAIL.val() + "&Tel1=" + TEL1.val() + "&Tel2=" + TEL2.val();
        var DatosDirecc = "&Calle=" + CALL.val().toUpperCase().trim() + "&NumInt=" + NUMI.val() + "&NumExt=" + NUME.val() + "&Colonia=" + COLO.val().toUpperCase().trim() + "&Poblacion=" + POBL.val().toUpperCase().trim() + "&Estado=" + ESTA.val().toUpperCase().trim() + "&Pais=" + PAIS.val().toUpperCase().trim() + "&Permisos=" + Permisos + "&Centro=" + CENT.val().toUpperCase();
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "peticionModuloCrearUsuario",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Usuario=" + USER.val().toUpperCase() + "&Password=" + pwd + DatosPerson + DatosDirecc,
            success: function (data) {
                $('#guardar').prop("disabled", false);
                if (data == 5) {
                    ShowMsg(8, "images/aceptar.png", "audio/sapmsg.wav");
                    limpiar();
                    reiniDatOb();
                    var tree = $("#tree3").dynatree("getTree");
                    tree.reload();
                }
                if (data == 6) {
                    ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
                    reiniDatOb();
                    limpiar();
                    var tree = $("#tree3").dynatree("getTree");
                    tree.reload();
                }
            },
            error: function (xhr, status) {
                alert("Error de respuesta");
            }

        });
    }
    function limpiar() {
        $.each(arrinp, function (i, v) {
            v.val("");
        });
    }
    function reiniDatOb() {
        $.each(arrinp, function (i, v) {
            if (!(i == 5) && !(i == 7) && !(i == 17)) {
                v.css('background-image', 'url(images/necesario.PNG)');
            }
        });
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
function MensajeSalirModulo()
{
    var ventana = $('#MensajeSalirModulo');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
}
function CerrarMensajeSalirModulo()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#MensajeSalirModulo');
    ventana.css('display', 'none');
}