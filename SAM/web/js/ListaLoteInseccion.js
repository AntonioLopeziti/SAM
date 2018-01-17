/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    var arr = [
        $('#btn1'),
        $('#btn2'),
        $('#btn3')
    ];
    var ar2 = [
        $('#loteInp'),
        $('#UsuLI'),
        $('#loteInp2')
    ];
    $.each(arr, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    var acc = "CargarLotes";
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "peticionListaLotesInpeccion",
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Accion=" + acc,
                        success: function (datas) {
                            if (datas == 0) {
                                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                            } else {
                                MostarVentanaModal("VentanaModalLote1", "handle");
                                $('#DatosLote').html(datas);
                                fnc('table-scrollLote1', 'fixedYLote1');
                                borramsg();
                            }
                        }
                    });
                });
                break;
            case 1:
                v.click(function () {
                    var acc = "CargarUsuarios";
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "peticionListaLotesInpeccion",
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Accion=" + acc,
                        success: function (datas) {
                            if (datas == 0) {
                                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                            } else {
                                MostarVentanaModal("VentanaModalUsuario", "handle3");
                                $('#DatosUsuario').html(datas);
                                fnc('table-scrollUsuario', 'fixedYUsaurio');
                                borramsg();
                            }
                        }
                    });
                });
                break;
            case 2:
                v.click(function () {
                    var acc = "CargarLotes2";
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "peticionListaLotesInpeccion",
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Accion=" + acc,
                        success: function (datas) {
                            if (datas == 0) {
                                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                            } else {
                                MostarVentanaModal("VentanaModalLote2", "handle2");
                                $('#DatosLote2').html(datas);
                                fnc('table-scrollLote2', 'fixedYLote2');
                                borramsg();
                            }
                        }
                    });
                });
                break;
        }
    });
    $.each(ar2, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    checarPosiMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("loteInp", "ValidarLote", "&lote=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-Z]/;
                    return patron.test(te);
                });
                break;
            case 1:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("UsuLI", "ValidarUsuario", "&usuario=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-Z]/;
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    checarPosiMa(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("loteInp2", "ValidarLote", "&lote=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-Z]/;
                    return patron.test(te);
                });
                break;
        }
    });
    function checarPosiMa(index) {
        $.each(arr, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#CerraMCLote1').click(function () {
        ocultaventana("VentanaModalLote1", "loteInp");
    });
    $('#CerraMCLote2').click(function () {
        ocultaventana("VentanaModalLote2", "loteInp2");
    });
    $('#CerraMCUsuario').click(function () {
        ocultaventana("VentanaModalUsuario", "UsuLI");
    });
    $('#ejecutar').click(function () {
        if ($('#loteInp').val().length > 0) {
            if (validarDato("loteInp", "ValidarLote", "&lote=" + $('#loteInp').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                $('#loteInp').val('');
                $('#loteInp').focus();
                return;
            }
        }
        if ($('#UsuLI').val().length > 0) {
            if (validarDato("UsuLI", "ValidarUsuario", "&usuario=" + $('#UsuLI').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                $('#UsuLI').val('');
                $('#UsuLI').focus();
                return;
            }
        }
         if ($('#loteInp2').val().length > 0) {
            if (validarDato("loteInp2", "ValidarLote", "&lote=" + $('#loteInp2').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                $('#loteInp2').val('');
                $('#loteInp2').focus();
                return;
            }
        }
        ValidarQuery();
    });
});
function ValidarQuery() {
    var lote1 = $('#loteInp').val().trim();
    var lote2 = $('#loteInp2').val().trim();
    var users = $('#UsuLI').val().trim();
    var acc = "ValidarQuery";
    var par = "&lote=" + lote1 + "&lote2=" + lote2 + "&usuario=" + users;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaLotesInpeccion',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + par,
        success: function (data) {
            if (data == 0) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $(location).attr('href','VisualizarLotesInpseccion.jsp?Accion=CargarTabla'+par);
            }
        }
    });
}
function ocultaventana(id, id2) {
    $('#' + id).hide();
    $('#' + id2).focus();
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
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
function MostarVentanaModal(ven, handle) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + ven);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ven);
    Drag.init(theHandle, theRoot);
}
function seleccionar(obj, t)
{
    switch (t) {
        case "lotes":
            $('#loteInp').val(obj);
            $('#loteInp').focus();
            ocultaventana("VentanaModalLote1", "loteInp");
            break;
        case "lotes2":
            $('#loteInp2').val(obj);
            $('#loteInp2').focus();
            ocultaventana("VentanaModalLote2", "loteInp2");
            break;
        case "usuarios":
            $('#UsuLI').val(obj);
            $('#UsuLI').focus();
            ocultaventana("VentanaModalUsuario", "UsuLI");
            break;
    }
}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionListaLotesInpeccion',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + param,
            success: function (data) {
                if (data != 0) {
                    ban = true;
                }
            }
        });
    }
    return ban;
}