/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    CargartablaFolios();
    $('#iconmsg').hide();
    $('#match_FO').hide();
    $('#guardar').prop('disabled', true);
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
        if (i == 3) {
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
                    } else if (v.val().length == 8 && v.val() < "99999999") {
                        var fact = $('#FolioInicialFO').val();
                        var faa = parseInt(fact) + 1;
                        $('#FolActualFO').val(faa);
                    } else {
                        $('#FolActualFO').val('');
                    }
                }
            }
        });
        v.keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (i == 3) {
                if (tecla == 13) {
                    CargaDatos();
                }
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
    function ConsulPref() {
        var idioma = $('#ClIdio').val();
        var pre = $('#Pref_Fol').val();
        var des = $('#Des_Fol').val();
        var ctd = $('#numAcMax').val();
        var acc = "ConsultarMatchPrefijos";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModificarFolio',
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
        location.reload();
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
    $('#aceptar').click(function () {
        CargaDatos();
    });
    function CargaDatos() {
        var fol = $('#prefijoFO').val();
        var fo = fol.toUpperCase();
        if (fo.length < 1) {
            ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
//            cleandt();
            pf.focus();
        } else {
            var acc = "ValidarDatos";
            $.ajax({
                async: false,
                type: 'GET',
                dataType: "json",
                url: 'peticionModificarFolio',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + "&prefijo=" + pf.val().toUpperCase(),
                success: function (data) {
                    if (data == 0) {
                        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        pf.val([data[0]]);
                        fi.val([data[1]]);
                        ff.val([data[2]]);
                        fa.val([data[3]]);
                        ShowMsg(8, "images/aceptar.png", "audio/sapmsg.wav");
                        $('#guardar').prop('disabled', false);
                        $('#aceptar').prop('disabled', true);
                        pf.prop('disabled', true);
                        $('#match_FO').hide();
                        fi.prop('disabled', false);
                        ff.prop('disabled', false);
                    }
                }
            });
        }
    }
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
        var fac = parseInt(fi.val()) + 1;
        enviaData(pf.val(), fi.val(), fac, ff.val());
    }
    function enviaData(pre, fin, fac, ffi) {
        var acc = "ActualzarDatos";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModificarFolio',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + "&prefijo=" + pre + "&FolioInicial=" + fin + "&folioFinal=" + ffi + "&folioActual=" + fac,
            success: function (data) {
                if (data == 1) {
                    ShowMsg(9, "images/aceptar.png", "audio/sapmsg.wav", pre.toUpperCase());
                    $('#guardar').prop('disabled', true);
                    $('#aceptar').prop('disabled', false);
                    $('input').val('');
                    pf.prop('disabled', false);
                    pf.css('background-image', "url(images/necesario.PNG)");
                    fi.prop('disabled', true);
                    ff.prop('disabled', true);
                    CargartablaFolios();
                } else if (data == 0) {
                    ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#guardar').prop('disabled', true);
                    $('#aceptar').prop('disabled', false);
                    $('input').val('');
                    pf.prop('disabled', false);
                    pf.css('background-image', "url(images/necesario.PNG)");
                    fi.prop('disabled', true);
                    ff.prop('disabled', true);
                }
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
//    var MPF = $('#match_FOM');
//    var PF = $('#prefijoFO_M');
//    var FI = $('#FolioInicialFO_M');
//    var FF = $('#FolioFinalFO_M');
//    var FA = $('#FolActualFO_M');
//    var AFO = [
//        FI,
//        FF
//    ];
//    MPF.hide();
//    $.each(AFO, function (i, v) {
//        v.blur(function () {
//            if (v.val().length < 1) {
//                v.css('background-image', 'url(images/necesario.PNG)');
//            } else {
//                v.css('background-image', 'none');
//            }
//        });
//        v.focus(function () {
//            MPF.hide();
//            v.css('background-image', 'none');
//        });
//
//    });
//    MPF.hide();
//    PF.keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            CargaFolio();
//        }
//    });
//    PF.css('background-image', 'url(images/necesario.PNG)');
//    PF.focus(function () {
//        MPF.show();
//        PF.css('background-image', 'none');
//    });
//    PF.blur(function () {
//        if (PF.val().length < 1) {
//            PF.css('background-image', 'url(images/necesario.PNG)');
//        } else
//        {
//            PF.css('background-image', 'none');
//        }
//    });
//    MPF.click(function () {
//        mostrarVentanaModal();
//        var theHandle = document.getElementById("handle");
//        var theRoot = document.getElementById("VentanaModal");
//        Drag.init(theHandle, theRoot);
//    });
//    $('#Pref_Fol_M').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultarPrefijos();
//        }
//    });
//    $('#Des_Fol_M').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultarPrefijos();
//        }
//    });
//    $('#MoFolio').click(function () {
//        ConsultarPrefijos();
//    });
//    $('#regresar').click(function () {
//        if ($('#prefijoFO_M').val().length > 0 || $('#FolioFinalFO_M').val().length > 0) {
//            MensajeSalirModulo();
//            var theHandle = document.getElementById("handleDoc");
//            var theRoot = document.getElementById("MensajeSalirModulo");
//            Drag.init(theHandle, theRoot);
//            $('#FinalizarSIDoc').focus();
//        } else {
//            $(location).attr('href', 'Bienvenido.jsp');
//
//        }
//    });
//    $('#finalizar').click(function () {
//        if ($('#prefijoFO_M').val().length > 0 || $('#FolioFinalFO_M').val().length > 0) {
//            MensajeSalirModulo();
//            var theHandle = document.getElementById("handleDoc");
//            var theRoot = document.getElementById("MensajeSalirModulo");
//            Drag.init(theHandle, theRoot);
//            $('#FinalizarSIDoc').focus();
//        } else {
//            $(location).attr('href', 'Bienvenido.jsp');
//
//        }
//    });
//
//    $('#FinalizarSIDoc').click(function () {
//        $(location).attr('href', 'Bienvenido.jsp');
//    });
//    $('#FinalizarNODoc').click(function () {
//        CerrarMensajeSalirModulo();
//    });
//    $('#btnmodFo').click(function () {
//        document.getElementById("BuscarParam_fo").style.display = "block";
//        document.getElementById("ConsultaTabla").style.display = "none";
//    });
//    $('#numAcMax').keypress(function (e) {
//        var tecla = (document).all ? e.keyCode : e.which;
//        if (tecla == 13) {
//            ConsultarPrefijos();
//        }
//        patron = /[0-9]/;
//        var t = String.fromCharCode(tecla);
//        return patron.test(t);
//    });
//});
//
//function cancelamod() {
//    var x = document.getElementById("FolioFinalFO_M").readOnly;
//    if (x == false) {
//        limpiar();
//        DesHabilitar();
//        var BE = document.createElement('audio');
//        BE.src = "audio/sapmsg.wav";
//        BE.play();
//        var iconm = document.getElementById("iconmsg");
//        iconm.style.visibility = "visible";
//        iconm.src = "images/advertencia.PNG";
//        msjMatch("processCancell");
//    } else {
//        var iconm = document.getElementById("iconmsg");
//        iconm.style.visibility = "hidden";
//        $('#msg').html("");
//        //var men = document.getElementById("msg");
//        //men.innerHTML = "";
//    }
//}
//
//function MensajeSalirModulo() {
//    var BE = document.createElement('audio');
//    BE.src = "audio/sapsnd05.wav";
//    BE.play();
//    var ventana = document.getElementById('MensajeSalirModulo');
//    var ancho = 350;
//    var alto = 650;
//    var x = (screen.width / 2) - (ancho / 2);
//    var y = (screen.height / 2) - (alto / 2);
//    ventana.style.left = x + "px";
//    ventana.style.top = y + "px";
//    ventana.style.display = 'block';
//}
//
//function CerrarMensajeSalirModulo() {
//    var BE = document.createElement('audio');
//    BE.src = "audio/sapsnd05.wav";
//    BE.play();
//    var ventana = document.getElementById('MensajeSalirModulo');
//    ventana.style.display = 'none';
//}
//
//function inval() {
//    var BE = document.createElement('audio');
//    BE.src = "audio/saperror.wav";
//    BE.play();
//    var iconm = document.getElementById("iconmsg");
//    iconm.style.visibility = "visible";
//    iconm.src = "images/advertencia.PNG";
//    msjMatch("funcioninv");
//}
//
//function back() {
//    window.location.href = "Bienvenido.jsp";
//}
//
//function CargaFolio() {
//    var pr = document.getElementById("prefijoFO_M").value;
//    var pre = pr.toUpperCase();
//    var acc = "ValidarDatos";
//    if (pre.length < 1) {
//        var BE = document.createElement('audio');
//        BE.src = "audio/saperror.wav";
//        BE.play();
//        var iconm = document.getElementById("iconmsg");
//        iconm.style.visibility = "visible";
//        iconm.src = "images/advertencia.PNG";
//        msjMatch("mens");
//        document.getElementById("prefijoFO_M").focus();
//    } else {
//        $.ajax({
//            async: false,
//            type: 'GET',
//            url: 'peticionModificarFolio',
//            contentType: "application/x-www-form-urlencoded",
//            processData: true,
//            data: "acc=" + acc + "&prefijo=" + pre,
//            success: function (data) {
//                if (data == 0) {
//                    limpiar();
//                    var BE = document.createElement('audio');
//                    BE.src = "audio/saperror.wav";
//                    BE.play();
//                    document.getElementById("prefijoFO_M").focus();
//                    var iconm = document.getElementById("iconmsg");
//                    iconm.style.visibility = "visible";
//                    iconm.src = "images/advertencia.PNG";
//                    msjTotal("mensno", pre, pr);
//                } else {
//                    var BE = document.createElement('audio');
//                    BE.src = "audio/sapmsg.wav";
//                    BE.play();
//                    cargarDatosMVC(data);
//                    var iconm = document.getElementById("iconmsg");
//                    iconm.style.visibility = "visible";
//                    iconm.src = "images/aceptar.png";
//                    msjMatch("menok");
//                }
//            }
//        });
//    }
//}
//
//function Habilitar() {
//    
//    document.getElementById("guardar").disabled = false;
//    document.getElementById("aceptar").disabled = true;
//    document.getElementById('FolioInicialFO_M').disabled = false;
//    document.getElementById('FolioFinalFO_M').disabled = false;
//}
//function DesHabilitar() {
//    document.getElementById("guardar").disabled = true;
//    document.getElementById("aceptar").disabled = false;
//    document.getElementById('FolioInicialFO_M').disabled = true;
//    document.getElementById('FolioFinalFO_M').disabled = true;
//}
//
//function cargarDatosMVC(rs) {
//    var r = new Array();
//    r = rs.split(",");
//    $('#prefijoFO_M').val(r[0]);
//    $('#FolioInicialFO_M').val(r[1]);
//    $('#FolActualFO_M').val(r[2]);
//    $('#FolioFinalFO_M').val(r[3]);
//    Habilitar();
//}
//
//function Update() {
//    var pre = $('#prefijoFO_M').val();
//    var fi = $('#FolioInicialFO_M').val();
//    var ff = $('#FolioFinalFO_M').val();
//    var fa = parseInt(fi) + 1;
//    if (dtafocus()) {
//        if (checarlongitud()) {
//            if (valNum(fi, ff)) {
//                if (validaMaximNum()) {
//                    Editar(pre, fi, ff, fa);
//                    delmsg();
//                }
//            }
//        }
//    }
//}
//
//function msgData(msg) {
//    var BE = document.createElement('audio');
//    BE.src = "audio/saperror.wav";
//    BE.play();
//    var iconm = document.getElementById("iconmsg");
//    iconm.style.visibility = "visible";
//    iconm.src = "images/advertencia.PNG";
//    $('#msg').html(msg);
//}
//
//function validaMaximNum() {
//    var bol = true;
//    var fi = document.getElementById("FolioInicialFO_M").value;
//    var ff = document.getElementById("FolioFinalFO_M").value;
//    var d1 = parseInt(fi.substring(0, 1));
//    var d2 = parseInt(ff.substring(0, 1));
//    if (d1 != d2) {
//        msjMatch("FoCoin");
//        document.getElementById("FolioFinalFO_M").focus();
//        bol = false;
//    }
//    return bol;
//}
//
//function valNum(fi, ff) {
//    var f = parseInt(fi) + 1;
//    var valor = true;
//    if (ff <= f) {
//        msjMatch("FoMay");
//        document.getElementById("FolioFinalFO_M").focus();
//        valor = false;
//    }
//    return valor;
//}
//
//function checarlongitud() {
//    var bol = true;
//    var temp = new Array();
//    temp[1] = document.getElementById("FolioInicialFO_M");
//    temp[0] = document.getElementById("FolioFinalFO_M");
//    for (i = 0; i < temp.length; i++)
//    {
//        if (temp[i].value.length < 8)
//        {
//            temp[i].focus();
//            msgMatch("LongFolO");
//            bol = false;
//        }
//    }
//    return bol;
//}
//
//function dtafocus() {
//    var bol = true;
//    var temp = new Array();
//    temp[2] = document.getElementById("prefijoFO_M");
//    temp[1] = document.getElementById("FolioInicialFO_M");
//    temp[0] = document.getElementById("FolioFinalFO_M");
//    for (i = 0; i < temp.length; i++)
//    {
//        if (temp[i].value.length === 0)
//        {
//            temp[i].focus();
//            msgMatch("CamOblig");
//            bol = false;
//        }
//    }
//    return bol;
//}
//
//function delmsg() {
//    var iconm = document.getElementById("iconmsg");
//    var men = document.getElementById("msg");
//    men.innerHTML = "";
//    iconm.style.visibility = "hidden";
//}
//
//function Editar(pre, fi, ff, fa) {
//    var acc = "ActualzarDatos";
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'peticionModificarFolio',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "acc=" + acc + "&prefijo=" + pre + "&FolioInicial=" + fi + "&folioFinal=" + ff + "&folioActual=" + fa,
//        success: function (data) {
//            alert(data);
//            if (data == 1) {
//                DesHabilitar();
//                var BE = document.createElement('audio');
//                BE.src = "audio/sapmsg.wav";
//                BE.play();
//                var iconm = document.getElementById("iconmsg");
//                iconm.style.visibility = "visible";
//                iconm.src = "images/aceptar.png";
//                alert("DS");
//                msjTotal("menedi", pre, fa);
//                CargartablaFolios();
//                limpiar();
//                $('#prefijoFO_M').css('background-image', "url(images/necesario.PNG)");
//            } else if (data == 0) {
//                DesHabilitar();
//                msjMatch("menedice");
//                limpiar();
//                $('#prefijoFO_M').css('background-image', "url(images/necesario.PNG)");
//            }
//        }
//    });
//}
//
//function mostrarVentanaModal() {
//    var ventana = document.getElementById('VentanaModal');
//    var ancho = 350;
//    var alto = 650;
//    var x = (screen.width / 2) - (ancho / 2);
//    var y = (screen.height / 2) - (alto / 2);
//    ventana.style.left = x + "px";
//    ventana.style.top = y + "px";
//    ventana.style.display = 'block';
//    var iconm = document.getElementById("iconmsg");
//    iconm.style.visibility = "hidden";
//    var men = document.getElementById("msg");
//    men.innerHTML = "";
//    var pr = document.getElementById('Pref_Fol_M');
//    var d = document.getElementById('Des_Fol_M');
//    var c = document.getElementById('numAcMax');
//    pr.focus();
//    pr.value = '';
//    d.value = '';
//    c.value = "500";
//}
//
//function ocultarVentana() {
//    var ventana = document.getElementById('VentanaModal');
//    ventana.style.display = 'none';
//    document.getElementById("BuscarParam_fo").style.display = "block";
//    document.getElementById("ConsultaTabla").style.display = "none";
//    document.getElementById("prefijoFO_M").focus();
//}
//function borrarmsg() {
//    var iconm = document.getElementById("iconmsg");
//    iconm.style.visibility = "hidden";
//    var men = document.getElementById("msg");
//    men.innerHTML = "";
//}
//

//
//function fnc() {
//    document.getElementById('table-scroll').onscroll = function () {
//        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
//    };
//}
//
//function seleccionar(obj) {
//    var f = document.getElementById("prefijoFO_M");
//    f.focus();
//    f.value = obj;
//    ocultarVentana();
//}
//
//function CargartablaFolios() {
//    var acc = "CargarTablafolios";
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'peticionCrearFolio',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "acc=" + acc,
//        success: function (data) {
//            document.getElementById("SecTab").innerHTML = data;
//        }
//    });
//}
//function limpiar() {
//    var pre = document.getElementById('prefijoFO_M');
//    var fin = document.getElementById("FolioInicialFO_M");
//    var ffi = document.getElementById('FolioFinalFO_M');
//    var fac = document.getElementById('FolActualFO_M');
//    pre.value = "";
//    ffi.value = "";
//    fin.value = "";
//    fac.value = "";
//}
//
//function startTime() {
//    today = new Date();
//    n = today.getHours();
//    m = today.getMinutes();
//    s = today.getSeconds();
//    h = checkTime(n);
//    m = checkTime(m);
//    s = checkTime(s);
//    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
//    t = setTimeout('startTime()', 500);
//}
//function checkTime(i)
//{
//    if (i < 10) {
//        i = "0" + i;
//    }
//    return i;
//}
//window.onload = function () {
//    startTime();
//    CargartablaFolios();
//    bloq();
//};
//
//function bloq() {
//    document.getElementById('iconmsg').style.visibility = "hidden";
//    document.getElementById("guardar").disabled = true;
//}