/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Modulo de Crear Folios */
$(document).ready(function () {
    startTime();
    CargartablaFolios();
    $('#iconmsg').hide();
    $('#match_FO').hide();
    $('#aceptar').prop('disabled', true);
    var pf = $('#prefijoFO');
    var fi = $('#FolioInicialFO');
    var ff = $('#FolioFinalFO');
    var fa = $('#FolActualFO');
    var arr = [
        fa,
        ff,
        fi,
        pf
    ];
    $.each(arr, function (i, v) {
        if (i != 0) {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function () {
            $('#match_FO').hide();
            v.css('background-image', 'none');
            if (i == 3) {
                $('#match_FO').show();
            }
        });
        v.blur(function () {
            if (i != 0) {
                if (v.val().length == 0) {
                    v.css('background-image', 'url(images/necesario.PNG)');

                } else {
                    v.css('background-image', 'none');
                }

                if (i == 2) {
                    if (v.val().length == 0) {
                        $('#FolActualFO').val('');
                    } else if(v.val().length == 8 && v.val() < "99999999" ) {
                        var fact = $('#FolioInicialFO').val();
                        var faa = parseInt(fact) + 1;
                        $('#FolActualFO').val(faa);
                    }else{
                        $('#FolActualFO').val('');
                    }
                }
            }
        });
        v.keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (i == 3) {
                if (tecla == 32) {
                    return false;
                }
                patron = /[a-zA-ZñÑ]/;
                tec = String.fromCharCode(tecla);
                return patron.test(tec);
            }
            if (i < 3) {
                if (tecla == 32) {
                    return false;
                }
                patron = /[0-9]/;
                tec = String.fromCharCode(tecla);
                return patron.test(tec);
            }
        });
    });
    $('#match_FO').click(function () {
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
    ///// Mensaje Finalizar documentos
    $('#regresar').click(function () {
        if ($('#prefijoFO').val().length > 0 || $('#FolioFinalFO').val().length > 0) {
            var theHandle = document.getElementById("handleDoc");
            var theRoot = document.getElementById("MensajeSalirModulo");
            Drag.init(theHandle, theRoot);
            MensajeSalirModulo();
            $('#FinalizarSIDoc').focus();
        } else {
            $(location).attr('href', 'Bienvenido.jsp');

        }
    });
    $('#cancelar').click(function () {
        if ($('#prefijoFO').val().length > 0 || $('#FolioFinalFO').val().length > 0) {
            var theHandle = document.getElementById("handleDoc");
            var theRoot = document.getElementById("MensajeSalirModulo");
            Drag.init(theHandle, theRoot);
            MensajeSalirModulo();
            $('#FinalizarSIDoc').focus();
        } else {
            $(location).attr('href', 'Bienvenido.jsp');

        }
    });
    $('#finalizar').click(function () {
        if ($('#prefijoFO').val().length > 0 || $('#FolioFinalFO').val().length > 0) {
            var theHandle = document.getElementById("handleDoc");
            var theRoot = document.getElementById("MensajeSalirModulo");
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
    $('#btnbuf').click(function () {
        document.getElementById("BuscarParam_fo").style.display = "block";
        document.getElementById("ConsultaTabla").style.display = "none";
    });
    $('#guardar').click(function () {
        Save();
    });
    function Save() {
        var temp = new Array();
        temp[0] = pf;
        temp[1] = fi;
        temp[2] = ff;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        for (i = 1; i < temp.length; i++)
        {
            if (temp[i].val().trim().length < 8)
            {
                temp[i].focus();
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        }
        var f = parseInt(fi.val()) + 1;
        if (parseInt(ff.val()) <= f) {
            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            ff.focus();
            return;
        }
        var d1 = parseInt(fi.val().substring(0, 1));
        var d2 = parseInt(ff.val().substring(0, 1));
        if (d1 != d2) {
            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
            ff.focus();
            return;
        }
        var fac = parseInt(fi.val())+1;
        enviaData(pf.val(), fi.val(), fac, ff.val());
    }
    function enviaData(pre, fin, fac, ffi) {
        var acc = "GuardarDatos";
        var p = pre.toUpperCase();
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionCrearFolio',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + "&Prefij=" + p + "&folioInicial=" + fin + "&folioActual=" + fac + "&folioFinal=" + ffi,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav", p);
                } else if (data == 1) {
                    ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav", p);
                    msgSave("ErrDos", pre);
                } else if (data == 2) {
                    ShowMsg(8, "images/aceptar.png", "audio/sapmsg.wav", p);
                    CargartablaFolios();
                    cleandata();
                } else if (data == 3) {
                    ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav", p);
                    cleandata();
                } 
                pf.focus();
            }
        });
    }
    function cleandata() {
        $.each(arr, function (i, v) {
            v.val('');
            if (i != 0) {
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ConsulPref() {
    var acc = "ConsultarMatchPrefijos";
    var idioma = $('#ClIdio').val();
    var pre = $('#Pref_Fol').val();
    var des = $('#Des_Fol').val();
    var ctd = $('#numAcMax').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearFolio',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&prefijo=" + pre + "&descripcion=" + des + "&ctd=" + ctd + "&idioma=" + idioma,
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
function seleccionar(obj) {
    var f = $('#prefijoFO');
    f.focus();
    f.val(obj);
    ocultarVentana();
}

function MensajeSalirModulo() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#MensajeSalirModulo');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
}

function CerrarMensajeSalirModulo() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#MensajeSalirModulo');
    ventana.css('display', 'none');
}