/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    loadDoc();
    $('#iconmsg').hide();
    $('#matchusercf').hide();
    $('#USeCf').focus(function () {
        $('#matchusercf').show();
    });
    $('#USeCf').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#matchusercf').click(function () {
        ConsultaUsers();
    });
    $('#CerrarMCUsuario').click(function () {
        var u = $('#USeCf');
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalUsuario').hide();
        u.focus();
    });
    $('#RestSAM').click(function () {
        ResetClave();
    });
    /////Fields SAM
    var Usuario = $("#UserCnx");
    var Password = $("#PwdCnx");
    var Server = $("#SerCnx");
    var Port = $("#portCnx");
    var DataBase = $("#DBCnx");
    var pcnxSAM = $("#pcnxSAM");
    var Save = $("#guardar");
    var end = $("#finalizar");
    Server.focus(function () {
        Server.css('background-image', 'none');
    });
    Server.blur(function () {
        if (Server.val().length < 1) {
            Server.css('background-image', 'url(images/necesario.PNG)');
        } else {
            Server.css('background-image', 'none');
        }
    });
    Port.focus(function () {
        Port.css('background-image', 'none');
    });
    Port.blur(function () {
        if (Port.val().length < 1) {
            Port.css('background-image', 'url(images/necesario.PNG)');
        } else {
            Port.css('background-image', 'none');
        }
    });
    DataBase.focus(function () {
        DataBase.css('background-image', 'none');
    });
    DataBase.blur(function () {
        if (DataBase.val().length < 1) {
            DataBase.css('background-image', 'url(images/necesario.PNG)');
        } else {
            DataBase.css('background-image', 'none');
        }
    });
    pcnxSAM.click(function () {
        ProbarConexionSAM();
    });
    Save.click(function () {
        GuardarConexion();
    });
//    $('#guardarWS').click(function () {
//        GuardarWS();
//    });
    end.click(function () {
        SalirConf();
    });
    function ProbarConexionSAM() {
        var temp = new Array();
        temp[0] = Server;
        temp[1] = Port;
        temp[2] = DataBase;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().length === 0)
            {
                temp[i].focus();
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        }
        acc = "ConexionSAM";
        $.ajax({
            beforeSend: function () {
                $("input:text").prop("disabled", true);
                $("button").prop("disabled", true);
                ShowMsg(2, "images/load.gif", "audio/sapmsg.wav");
            },
            type: 'GET',
            url: 'Conexiones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&User=" + Usuario.val() + "&Pwd=" + Password.val() + "&Server=" + Server.val() + "&Port=" + Port.val() + "&DB=" + DataBase.val(),
            success: function (data) {
                $("button").prop("disabled", false);
                $("input:text").prop("disabled", false);
                if (data == 1) {
                    ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    }
    function GuardarWS() {
        var acc = "SaveWS";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'Conexiones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&WS=" + $('#URLCnx').val(),
            success: function (data) {
                if (data == 1) {
                    ShowMsg(5, "images/aceptar.png", "audio/sapmsg.wav");
                }
            }
        });
    }

    function GuardarConexion() {
        var temp = new Array();
        temp[0] = Server;
        temp[1] = Port;
        temp[2] = DataBase;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().length === 0)
            {
                temp[i].focus();
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        }
        acc = "SaveConexion";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'Conexiones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&User=" + Usuario.val() + "&Pwd=" + Password.val() + "&Server=" + Server.val() + "&Port=" + Port.val() + "&DB=" + DataBase.val(),
            success: function (data) {
                if (data == 1) {
                    ShowMsg(5, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                }
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
    $("#tiempo").html(h + ":" + m + ":" + s);
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
function loadDoc() {
    acc = "CargarDatosServidor";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'Conexiones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data != 0) {
                $('#UserCnx').val(data[0]);
                $('#PwdCnx').val(data[1]);
                $('#SerCnx').val(data[2]);
                $('#portCnx').val(data[3]);
                $('#DBCnx').val(data[4]);
                $('#URLCnx').val(data[5]);
                if (data[2].length == 0) {
                    $('#SerCnx').css('background-image', 'url(images/necesario.PNG)');
                }
                if (data[3].length == 0) {
                    $('#portCnx').css('background-image', 'url(images/necesario.PNG)');
                }
                if (data[4].length == 0) {
                    $('#DBCnx').css('background-image', 'url(images/necesario.PNG)');
                }
            } else {
                ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            }
        }
    });
}
function SalirConf() {
    window.location.href = "Logout";
}
function ConsultaUsers() {
    var acc = "ConsultarUsuario";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'Conexiones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else if (data == 1) {
                ShowMsg(9, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ancho = 350;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                var ventana = $('#VentanaModalUsuario');
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                borramsg();
                var theHandle = document.getElementById("handle");
                var theRoot = document.getElementById("VentanaModalUsuario");
                Drag.init(theHandle, theRoot);
                $('#cargarDatosUsuario').html(data);
                document.getElementById("table-scrollUsuario").onscroll = function () {
                    document.getElementById("fixedYUsuario").style.top = document.getElementById("table-scrollUsuario").scrollTop + 'px';
                };
            }

        }
    });
}
function seleccionar(user, nombre) {
    var u = $('#USeCf');
    $('#txtdesc').val(nombre);
    u.val(user);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalUsuario').hide();
    u.focus();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ResetClave() {
    var clave = $('#USeCf');
    if (clave.val().length > 0) {
        var acc = "ResetClave";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'Conexiones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Usuario=" + $('#USeCf').val(),
            success: function (data) {
                if (data == 1) {
                    clave.val("");
                    $('#txtdesc').val("");
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    } else {
        clave.focus();
        ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav");
    }
}