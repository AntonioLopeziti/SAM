/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#iconmsg').hide();
    $('#btnmatch').hide();
    $('#idUbiTec').focus(function () {
        $('#btnmatch').show();
    });
    $('#VisDoo').click(function () {
        if ($("#idUbiTec").val() != "") {
            VisDoc();
        } else {
            ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
        }
    });
    $('#VisVis').click(function () {
        var position = $('#ubtecPosOc').val();
        SendPath(position);
        ocultarVenAv('VenAvv');
    });
    $('#ViGuarAr').click(function () {
        var posit = $('#ubtecPosOc').val();
        SendMod(posit);
        ocultarVenAv('VenAvv');
    });
    $('#btnmatch').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal();
    });
    $('#ubictBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUbicacionTec();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#DesUbiBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUbicacionTec();
        }
    });
    $('#okUbic').click(function () {
        ConsultaUbicacionTec();
    });
    $('#idUbiTec').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargaDatos();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#numAcMax').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaUbicacionTec();
        }
        if (tec == 32) {
            return false;
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tec);
        return patron.test(t);
    });
    $('#aceptar').click(function () {
        CargaDatos();
    });
    $('#retornafiltroubic').click(function () {
        $('#BuscarParamUbi').show();
        $('#ConsultaTabla').hide();
        $('#ubictBus').val("").focus();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });

});


function inval() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $("#iconmsg").show();
    $("#iconmsg").attr('src', 'images/advertencia.PNG');
    msgMatch("funinva");
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function mostrarVentanaModal() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').css({
        position: 'absolute', left: 510, top: 60
    });
    $('#VentanaModal').show();
    $('#ubictBus').val("").focus();
    $('#DesUbiBus').val("");
    $('#numAcMax').val("500");
    $('#msg').html("");
    $('#iconmsg').hide();
}

function ocultarVentana() {
    $('#VentanaModal').hide();
    $('#BuscarParamUbi').show();
    $('#ConsultaTabla').hide();
    $('#idUbiTec').focus();
}

function fnc() {
    document.getElementById('table-scroll').onscroll = function () {
        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}

function ConsultaUbicacionTec() {
    var acc = "ConsultarMatchUbicacion";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloVisualizarUbicacionesTec',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Acc=" + acc + "&Ubi=" + $("#ubictBus").val() + "&DUbi=" + $("#DesUbiBus").val() + "&Ctd=" + $("#numAcMax").val() + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/aceptar.png');
                msgMatch("menValores");
            } else {
                $('#BuscarParamUbi').hide();
                $('#ConsultaTabla').show();
                $('#cargarDatos').html(data);
                fnc();
                borrarmsg();
            }
        }
    });
}

function Select(we) {
    var se = $("#idUbiTec").val(we);
    se.focus();
    ocultarVentana();
}

function CargaDatos() {
    var ubic = $("#idUbiTec").val();
    if (ubic.length < 1) {
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        $("#idUbiTec").focus();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        msgMatch("CampoOb");
        cleandat();
    } else {
        var acc = "CargarDatosUbicaciones";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: "json",
            url: 'peticionModuloVisualizarUbicacionesTec',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Acc=" + acc + "&Ubi=" + $("#idUbiTec").val() + "&Idioma=" + $("#IdioMat").val(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    msgMatch("existeFol");
                    cleandat();
                } else {
                    var a = data;
                    $("#DesUbiTec").val(a[0]);
                    $("#GrupoAutoriz").val(a[1]);
                    $("#CentroPlanif").val(a[2]);
                    $("#CeEmplazam").val(a[3]);
                    $("#Emplazamiento").val(a[4]);
                    $("#Sociedad").val(a[5]);
                    $("#Centro").val(a[6]);
                    $("#AreaEmpresa").val(a[7]);
                    $("#GrupoPlanif").val(a[8]);
                    $("#UbicTecn").val(a[9]);
                    $("#SociedadCC").val(a[10]);
                    $("#PuestoTrabajo").val(a[11]);
                    $("#PtoTbjoResp").val(a[11]);
                    $("#PtoTbjoRespDos").val(a[2]);
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/aceptar.png');
                    msgMatch("OkConsult");
                }
            }
        });
    }
    function cleandat() {
        $("#idUbiTec").val('');
        $("#DesUbiTec").val('');
        $("#GrupoAutoriz").val('');
        $("#CentroPlanif").val('');
        $("#CeEmplazam").val('');
        $("#Emplazamiento").val('');
        $("#Sociedad").val('');
        $("#Centro").val('');
        $("#AreaEmpresa").val('');
        $("#GrupoPlanif").val('');
        $("#UbicTecn").val('');
        $("#SociedadCC").val('');
        $("#PuestoTrabajo").val('');
    }
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
function VisDoc() {
    acc = "matchDocs";
    var UTec = $("#idUbiTec").val().toUpperCase();
    var UtecS = UTec.substring(0, 4);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloVisualizarUbicacionesTec',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Acc=" + acc + "&ubTec=" + UTec + "&centroo=" + UtecS,
        success: function (rs) {
            if (rs == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                blockPropiety('handle3', 'VentanaModalCentroP');
                $('#SecCuerpo').html(rs);
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                fncCentroP();
                //borramsg();
            }
        }
    });
}
function fncCentroP() {
    $('#table-scrollCentroP').scroll(function () {
        $('#fixedYCentroP').css({top: $('#scrollCentroP').scrollTop()});
    });
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function ocultarVentanaa(tipo) {
    switch (tipo) {
        case "CentroP":
            var ventana = $('#VentanaModalCentroP');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function ocultarVenAv(tipo) {
    switch (tipo) {
        case "VenAvv":
            var ventana = $('#VentUbTecAvvv');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function abrVen(c2) {
    $("#ubtecPosOc").val(c2);
    $("#VentanaModalCentroP").hide();
    var ventana = document.getElementById('VentUbTecAvvv');
    abrirVentanaAv(ventana);
    var theHandle = document.getElementById("handleAvvv");
    var theRoot = document.getElementById("VentUbTecAvvv");
    Drag.init(theHandle, theRoot);
}
function abrirVentanaAv(ventana) {
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    //document.getElementById("lbAv").innerHTML = msg;
}
function abrirVentana(ventana) {
    var ancho = 950;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    var iconm = $('#iconmsg');
    var men = $('#msg');
    men.html("");
    iconm.hide();
}
function SendPath(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarRuta(cad);
}
function EnviarRuta(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            }
        }
    };
    xmlhttp.open("GET", "peticionModuloVisualizarEquipos?Action=EnviarSocket&ruta=" + ruta, true);
    xmlhttp.send();
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
    myTableCb.style.width = val + 17 + "px";
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
function SendMod(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarModificar(cad);
}
function EnviarModificar(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            } else {
                document.getElementById("msg").innerHTML = "";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "hidden";
            }
        }
    };
    xmlhttp.open("GET", "peticionModuloVisualizarUbicacionesTec?Acc=EnviarMod&ruta=" + ruta, true);
    xmlhttp.send();
}