/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    var cen = $('#centro');
    var mat = $('#material');
    var gh = $('#grupohoja');
    $('#material').css("background-image", "url(images/necesario.PNG)");
    $('#centro').css("background-image", "url(images/necesario.PNG");
    $('#grupohoja').css("background-image", "url(images/necesario.PNG");
    $('#match_Material').hide();
    $('#match_Centro').hide();
    $('#match_Grupo').hide();

    $('#material').focus(function () {
        $('#match_Material').show();
        $('#match_Centro').hide();
        $('#match_Grupo').hide();
        $('#material').css("background-image", "none");
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#grupohoja').val().length < 1) {
            $('#grupohoja').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#centro').focus(function () {
        $('#match_Centro').show();
        $('#match_Material').hide();
        $('#match_Grupo').hide();
        $('#centro').css("background-image", "none");
        if ($('#material').val().length < 1) {
            $('#material').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#grupohoja').val().length < 1) {
            $('#grupohoja').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#grupohoja').focus(function () {
        $('#match_Grupo').show();
        $('#match_Material').hide();
        $('#match_Centro').hide();
        $('#grupohoja').css("background-image", "none");
        if ($('#material').val().length < 1) {
            $('#material').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#match_Material').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('material');
    });
    $('#OkMaterial').click(function () {
        ConsultarMaterial();
    });
    $('#material_ma').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#texto_mate').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#centrito').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#retornfiltro').click(function () {
        document.getElementById("BuscarParam_m").style.display = "block";
        document.getElementById("ConsultaTabla").style.display = "none";
    });
    $('#match_Centro').click(function () {
        ConsultaMatchCentro();
    });
    $('#match_Grupo').click(function () {
        ConsultaMatchGrupoHoja();
    });
    mat.blur(function () {
        ValidarMaterial();
    });
    mat.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ValidarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    cen.blur(function () {
        ValidarCentro();
    });
    cen.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            ValidarCentro();
        }
    });
    gh.blur(function () {
        ValidarGrupoHoja();
    });
    gh.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            ValidarGrupoHoja();
        }
    });
});
//************************************** PLANES INSPECCION ******************************************//
function back() {
    $(location).attr('href', 'Bienvenido.jsp');
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
    //document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
window.onload = function () {
    startTime();
    bloq();
};
function bloq() {
    $('#iconmsg').hide();
    $('#guardar').attr("disabled", true);
//    document.getElementById('iconmsg').style.visibility = "hidden";
//    document.getElementById('guardar').disabled = true;
}
function inval() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    msgMatch("MenVal");
}
function MostrarVentanaModal(tipo)
{
    switch (tipo) {
        case 'material':
            borrarmsg();
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#VentanaModal').show();
            $('#VentanaModal').css({
                position: 'absolute', left: 510, top: 60
            });
            $('#texto_mate').val("");
            $('#centrito').val("");
            $('#material_ma').focus();
            $('#material_ma').val("");
            $('#numAcMax').val('500');
            break;
        case 'centro':
            borrarmsg();
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#VentanaModalCentro').show();
            $('#VentanaModalCentro').css({
                position: 'absolute', left: 510, top: 60
            });
            break;
        case 'grupo':
            borrarmsg();
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#VentanaModalGrupoHoja').show();
            $('#VentanaModalGrupoHoja').css({
                position: 'absolute', left: 510, top: 60
            });
            break;
    }
}

function ocultarVentana(tipo)
{
    $('#overlay').remove();
    switch (tipo)
    {
        case 'material':
            $('#VentanaModal').hide();
            $('#material').focus();
            break;
        case 'centro':
            $('#VentanaModalCentro').hide();
            $('#centro').focus();
            break;
        case 'grupo':
            $('#VentanaModalGrupoHoja').hide();
            $('#grupohoja').focus();
            break;
    }
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function seleccionar(obj, tipo) {
    switch (tipo) {
        case 'material':
            $('#material').focus();
            $('#material').val(obj);
            ocultarVentana(tipo);
            break;
        case 'centro':
            $('#centro').focus();
            $('#centro').val(obj);
            ocultarVentana(tipo);
            break;
        case 'grupo':
            $('#grupohoja').focus();
            $('#grupohoja').val(obj);
            ocultarVentana(tipo);
            break;
    }
}
function fnc() {
    document.getElementById('table-scroll').onscroll = function () {
        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}
function fnc1() {
    document.getElementById('table-scrollC').onscroll = function () {
        document.getElementById('fixedYC').style.top = document.getElementById('table-scrollC').scrollTop + 'px';
    };
}
function fnc2() {
    document.getElementById('table-scrollG').onscroll = function () {
        document.getElementById('fixedYG').style.top = document.getElementById('table-scrollG').scrollTop + 'px';
    };
}
function ConsultarMaterial() {
    var acc = "ConsultaMaterial";
    var idioma = $('#IdioMat').val();
    var mate = $('#material_ma').val();
    var des = $('#texto_mate').val();
    var cen = $('#centrito').val();
    var ctdmax = $('#numAcMax').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionPlanesInspeccion",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MaterialMatch=" + mate + "&DescripMatch=" + des + "&CentroMatch=" + cen + "&CantidadMatch=" + ctdmax + "&Idioma=" + idioma,
        success: function (data) {
            //alert(data);
            var rs = data;
            if (rs == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                msgMatch("menValores");
            } else {
                $('#BuscarParam_m').hide();
                $('#ConsultaTabla').show();
                $('#CargarDatosM').html(data);
                fnc();
                borrarmsg();
            }
        }
    });
}
function ConsultaMatchCentro() {
    var $idioma = $('#IdioMat').val();
    var acc = "ConsultaMatchCentroQM";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionPlanesInspeccion",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                msgMatch("menValores");
            } else {
                var theHandle = document.getElementById("handle2");
                var theRoot = document.getElementById("VentanaModalCentro");
                Drag.init(theHandle, theRoot);
                MostrarVentanaModal('centro');
                $('#CargarDatosC').html(data);
                fnc1();
            }
        }
    });
}
function ConsultaMatchGrupoHoja() {
    var $idioma = $('#IdioMat').val();
    var acc = "ConsultaMatchGrupoHoja";
    var matgr = $('#material').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionPlanesInspeccion",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MaterialGrupo=" + matgr,
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                msgMatch("menValores");
            } else {
                var theHandle = document.getElementById("handle3");
                var theRoot = document.getElementById("VentanaModalGrupoHoja");
                Drag.init(theHandle, theRoot);
                MostrarVentanaModal('grupo');
                $('#CargarDatosG').html(data);
                fnc2();
            }
        }
    });
}
function mensajesValidacionInco(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $("#iconmsg").show();
    $("#iconmsg").attr('src', 'images/advertencia.PNG');
    $('#msg').html(msg);
}
function ValidarMaterial() {
    var acc = "ValidarMaterial";
    var $idioma = $('#IdioMat').val();
    var cen = document.getElementById("material");
    var c = cen.value;
    if (c.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPlanesInspeccion",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&MAT=" + c + "&Idioma=" + $idioma,
            success: function (data) {
                //alert(data);
                if (data == 0) {
                    var msg = "No se encuentra en el Sistema el Material: " + c.toUpperCase();
                    mensajesValidacionInco(msg);
                    $('#material').val("");
                    $('#material').focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function ValidarCentro() {
    var acc = "ValidarCentro";
    var $idioma = $('#IdioMat').val();
    var cen = document.getElementById("centro");
    var c = cen.value;
    if (c.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPlanesInspeccion",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&CEN=" + c + "&Idioma=" + $idioma,
            success: function (data) {
                if (data == 0) {
                    var msg = "No se encuentra en el Sistema el Centro: " + c.toUpperCase();
                    mensajesValidacionInco(msg);
                    $('#centro').val("");
                    $('#centro').focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function ValidarGrupoHoja() {
    var acc = "ValidarGrupo";
    var $idioma = $('#IdioMat').val();
    var grp = document.getElementById("grupohoja");
    var g = grp.value;
    if (g.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPlanesInspeccion",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&GRP=" + g + "&Idioma=" + $idioma,
            success: function (data) {
                if (data == 0) {
                    var msg = "No se encuentra en el Sistema el Valor: " + g.toUpperCase();
                    mensajesValidacionInco(msg);
                    $('#grupohoja').val("");
                    $('#grupohoja').focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function Cargar() {
    var mat = $('#material');
    var cen = $('#centro');
    var grp = $('#grupohoja');
    if (mat.val().length == 0) {
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        msgMatch("CampOb");
        mat.focus();
        limpiar();
        return;
    }
    if (cen.val().length == 0) {
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        msgMatch("CampOb");
        7
        cen.focus();
        limpiar();
        return;
    }
    if (grp.val().length == 0) {
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        msgMatch("CampOb");
        grp.focus();
        limpiar();
        return;
    }
    limpiatablasXXX();
    EnviarDatos(mat.val(), cen.val(), grp.val());
}
function EnviarDatos(mat, cen, grp) {
    var $idioma = $('#IdioMat').val();
    var acc = "CargarDatos";
    $.ajax({
        async: false,
        type: "GET",
        dataType: "json",
        url: "PeticionPlanesInspeccion",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MaterialCarga=" + mat + "&CentroCarga=" + cen + "&GrupoHojaCarga=" + grp + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                msgMatch("errocon");
            } else {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                cargar(data);
                cargartablaop(mat, cen, grp);
                msgMatch("okcons");

            }
        }
    });
}
function cargartablacarac(op) {
    var acc = "CargarTablaCaracteristicas";
    var mat = document.getElementById("material").value;
    var cen = document.getElementById("centro").value;
    var grp = document.getElementById("grupohoja").value;
    var enviar = "Action=" + acc + "&MATERICA=" + mat + "&CENTROO=" + cen + "&GPOHR=" + grp + "&OPERACIONN=" + op;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionPlanesInspeccion",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#SecCuerpo2").html(data);
        }
    });
}
function cargar(n) {
    $('#descripcionj').val(n[0]);
    $('#hojaruta').val(n[1]);
    $('#Contghr').val(n[2]);
    $('#Contcad').val(n[3]);
    $('#contador').val(n[4]);
}
function cargartablaop(mat, cen, grp) {
    var acc = "CargarTablaOperaciones";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionPlanesInspeccion',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc  + "&MaterialCarga=" + mat + "&CentroCarga=" + cen + "&GrupoHojaCarga=" + grp  + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
        }
    });
}function limpiatablasXXX() {
    var acc = "LimpiarTablaCarac";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionPlanesInspeccion',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            $("#SecCuerpo2").html(data);
        }
    });
}

//function cargartablacarac(mat) {
//    var acc = "CargarTablaCaracteristicas";
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'PeticionPlanesInspeccion',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "Action=" + acc + "&MATERICA=" + mat + "&Idioma=" + $("#IdioMat").val(),
//        success: function (data) {
//            $("#Caracteristicas").html(data); 
//        }
//    });
//}
function limpiar() {
    $('#descripcionj').val("");
    $('#hojaruta').val("");
    $('#grupohoja').val("");
    $('#Contghr').val("");
    $('#Contcad').val("");
    $('#contador').val("");
}
function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }
    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 7 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
}