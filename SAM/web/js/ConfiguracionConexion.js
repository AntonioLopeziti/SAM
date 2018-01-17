/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    loadDoc();
    $('#iconmsg').hide();
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
    $('#guardarWS').click(function () {
        GuardarWS();
    });
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
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            }
        }
    });
}
function SalirConf() {
    window.location.href = "Logout";
}