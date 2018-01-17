/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    CargartablaFolios();
    borramsg();
    $('#btnmat1').hide();
    var pf = $('#prefijoFO');
    var fi = $('#FolioInicialFO');
    var ff = $('#FolioFinalFO');
    var fa = $('#FolActualFO');
    pf.css('background-image', 'url(images/necesario.PNG)');
    pf.focus(function () {
        $('#btnmat1').show();
        pf.css('background-image', 'none');
    });
    pf.blur(function () {
        if (pf.val().length > 0) {
            pf.css('background-image', 'none');
        } else {
            pf.css('background-image', 'url(images/necesario.PNG)');
        }
    });
    pf.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargaDatos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[a-zA-ZnÑ]/;
        tec = String.fromCharCode(tecla);
        return patron.test(tec);
    });
    $('#btnmat1').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCFolio').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCFolio2').click(function () {
        ocultarVentana();
    });
    $.each([$('#Pref_Fol'), $('#Des_Fol'), $('#numAcMax'), $('#okFolio')], function (i, v) {
        if (i < 3) {
            v.keypress(function (e) {
                var tecla = (document).all ? e.keyCode : e.which;
                if (tecla == 13) {
                    ConsulPref();
                }
                if (i == 0) {
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[a-zA-ZñÑ]/;
                    tec = String.fromCharCode(tecla);
                    return patron.test(tec);
                }
                if (i == 2) {
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9]/;
                    tec = String.fromCharCode(tecla);
                    return patron.test(tec);
                }
            });
        }
        if (i == 3) {
            v.click(function () {
                ConsulPref();
            });
        }
    });
    $('#btnbuf').click(function () {
        $('#BuscarParam_fo').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    function ConsulPref() {
        var acc = "CargarMatchFolios";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionConsultarFolio',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Acc=" + acc + "&Folio=" + $('#Pref_Fol').val() + "&des=" + $('#Pref_Fol').val() + "&CtdAcc=" + $('#numAcMax').val() + "&idioma=" + $('#ClIdio').val(),
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParam_fo').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    $('#cargarDatos').html(data);
                    document.getElementById('table-scroll').onscroll = function () {
                        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    $('#regresar').click(function(){
        $(location).attr('href','Bienvenido.jsp');
    });
    $('#aceptar').click(function () {
        CargaDatos();
    });
    function CargaDatos() {
        var fol = $('#prefijoFO').val();
        var fo = fol.toUpperCase();
        if (fo.length < 1) {
            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            cleandt();
            pf.focus();
        } else {
            var acc = "CargarDatosFolios";
            $.ajax({
                async: false,
                type: 'GET',
                dataType: "json",
                url: 'peticionConsultarFolio',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Acc=" + acc + "&Folio=" + fo,
                success: function (data) {
                    if (data == 0) {
                        cleandt();
                        ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        pf.val([data[0]]);
                        fi.val([data[1]]);
                        ff.val([data[2]]);
                        fa.val([data[3]]);
                        ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
                    }
                }
            });
        }
    }
    function cleandt() {
        fi.val('');
        fi.focus();
        ff.val('');
        ff.focus();
        fa.val('');
        fa.focus();
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
function CargartablaFolios() {
    var acc = "CargarTablafolios";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearFolio',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (data) {
            $('#SecTab').html(data);
        }
    });
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
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
    $('#Pref_Fol').val("");
    $('#Des_Fol').val("");
    $('#Pref_Fol').focus();
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
    $('#BuscarParam_fo').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#prefijoFO').focus();
}
function seleccionar(we) {
    $('#prefijoFO').val(we).focus();
    ocultarVentana();
}