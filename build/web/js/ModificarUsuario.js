/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#guardar').prop('disabled', true);
    $('#btnmatch').hide();
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
        v.focus(function () {
            v.css('background-image', 'none');
            if (i == 16) {
                $('#btnmatch').show();
            }
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
                        ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
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
                            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                            v.val("");
                            v.focus();
                        }
                    }
                }
            }

        });
    });
    $('#aceptar').click(function () {
        validar();
    });
    $('#cancelar').click(function () {
        location.reload();
    });
    $('#guardar').click(function () {
        ValidarDatos();
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
                    $.each(arrinp, function (i, v) {
                        v.prop('disabled', false);
                        if (i == 16) {
                            v.prop('disabled', true);
                        }
                    });
                    $('#btnmatch').hide();
                    $('#CheckPass').prop('disabled', false);
                    $('#Hablitado_U').prop('disabled', false);
                    $('#aceptar').prop('disabled', true);
                    $('#guardar').prop('disabled', false);
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
                $('#Habilitado_U').prop('checked', VerificarCheck(ar[15]));
                $('#Habilitado_U').prop('disabled', false);
                $('#tree3').show();
                ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
            }
        });
    }

    function ValidarDatos() {
        var temp = new Array();
        var check = $("#CheckPass").is(':checked') ? 1 : 0;
        if (check == 1) {
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
        } else {
            temp[0] = USER;
            temp[1] = NOMB;
            temp[2] = APPA;
            temp[3] = APMA;
            temp[4] = RFC;
            temp[5] = MAIL;
            temp[6] = TEL1;
            temp[7] = CALL;
            temp[8] = NUME;
            temp[9] = COLO;
            temp[10] = POBL;
            temp[11] = ESTA;
            temp[12] = PAIS;
        }
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        if (check == 1) {
            if (PWD1.val().length >= 6) {
                if (PWD1.val() == PWD2.val()) {
                    validarUsuarioExistente(USER.val());
                } else {
                    PWD1.focus();
                    ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav");
            }
        } else {
            borramsg();
            validarUsuarioExistente(USER.val());
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
                if (data == 1) {
                    ModificarUser();
                } else {
                    ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    }
    function ModificarUser() {
        var hab = $("#Habilitado_U").is(':checked') ? 1 : 0;
        var Permisos = test();
        var acc = "ModificarDatosWP";
        var pwd;
        if (PWD1.val().length > 0) {
            pwd = calcSHA1(PWD1.val());
        } else {
            pwd = "";
        }
        var DatosPerson = "&Nombre=" + NOMB.val().toUpperCase() + "&APP=" + APPA.val().toUpperCase() + "&APM=" + APMA.val().toUpperCase() + "&RFC=" + RFC.val().toUpperCase() + "&Email=" + MAIL.val() + "&Tel1=" + TEL1.val() + "&Tel2=" + TEL2.val();
        var DatosDirecc = "&Calle=" + CALL.val().toUpperCase() + "&NumInt=" + NUMI.val() + "&NumExt=" + NUME.val() + "&Colonia=" + COLO.val().toUpperCase() + "&Poblacion=" + POBL.val().toUpperCase() + "&Estado=" + ESTA.val().toUpperCase() + "&Pais=" + PAIS.val().toUpperCase() + "&Permisos=" + Permisos + "&hab=" + hab + "&Centro=" + CENT.val().toUpperCase();
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
                    limpiar();
                    DesHabilitar();
                    ShowMsg(10, "images/aceptar.png", "audio/sapmsg.wav");
                    var tree = $("#tree3").dynatree("getTree");
                    tree.reload();
                }
                if (data == 6) {
                    limpiar();
                    DesHabilitar();
                    ShowMsg(11, "images/advertencia.PNG", "audio/saperror.wav");
                    var tree = $("#tree3").dynatree("getTree");
                    tree.reload();
                }
            }

        });
    }
    function limpiar() {
        $.each(arrinp, function (i, v) {
            v.val("");
        });
    }
    function DesHabilitar() {
        $.each(arrinp, function (i, v) {
            v.prop('disabled', true);
        })
        $('#User_U').prop('disabled', false);
        $('#Habilitado_U').prop('disabled', true);
        $('#Habilitado_U').prop('checked', false);
        $('#Habilitado_U').prop('disabled', true);
        $('#CheckPass').prop('disabled', true);
        $('#CheckPass').prop('checked', false);
        $('#contentHide').hide();
        $('#aceptar').prop('disabled', false);
        $('#guardar').prop('disabled', true);
        $('#tree3').hide();
    }

    /////Eventos Match
    $('#btnmatch').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal();
    });
    $('#btnbuuser').click(function () {
        $('#BuscarParam_u').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#CerrarMCUser').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCUser2').click(function () {
        ocultarVentana();
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
    $('#CheckPass').change(function () {
        var cond = $('#CheckPass').is(':checked');
        if (cond) {
            //   alert("checada");
            $('#contentHide').toggle('swing');
            $('#Pwd1_U').css('background-image', 'url(images/necesario.PNG)');
            $('#Pwd1_U').focus(function () {
                $('#Pwd1_U').css('background-image', 'none');
            });
            $('#Pwd1_U').blur(function () {
                if ($('#Pwd1_U').val().length < 1) {
                    $('#Pwd1_U').css('background-image', 'url(images/necesario.PNG)');
                }
            });
            $('#pwd2_U').css('background-image', 'url(images/necesario.PNG)');
            $('#pwd2_U').focus(function () {
                $('#pwd2_U').css('background-image', 'none');
            });
            $('#pwd2_U').blur(function () {
                if ($('#pwd2_U').val().length < 1) {
                    $('#pwd2_U').css('background-image', 'url(images/necesario.PNG)');
                }
            });


        } else {
            // alert("deschecada");
            $('#contentHide').toggle('swing');

        }

    });
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
    $('#FinalizarSIDoc').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');

    });
    $('#FinalizarNODoc').click(function () {
        CerrarMensajeSalirModulo();
    });
});
function seleccionar(user) {
    var u = $('#User_U');
    u.focus();
    u.val(user);
    ocultarVentana();
}
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
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
function mostrarVentanaModal() {
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


function getCheckPermission(id) {
    var tree = $("#tree3").dynatree("getTree");
    var node = tree.getNodeByKey(id);
    var x = node.hasSubSel;
    var p;
    if (x) {
        p = "1";
    } else if (node.isSelected()) {
        p = "1";
    } else {
        p = "0";
    }
    return p;

}

