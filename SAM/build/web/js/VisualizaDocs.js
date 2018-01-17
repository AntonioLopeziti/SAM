/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
    $('#ejecutar').click(function () {
        var equipo = $('#bxEquipo');
        var ubte = $('#bxUbic');
        var av = $('#bxAviso');
        var li = $('#bxNoticaQM');
        var cm = $('#bxMovMer');

        if ($('#rbEquipo').is(':checked')) {
            if (equipo.val() == "") {
                msgMatch(0, "images/advertencia.PNG", "audio/saperror.wav", equipo.val().toUpperCase());
                equipo.val('');
                equipo.focus();
            } else {
                enviarDatos();
            }
        } else if ($('#rbUbic').is(':checked')) {
            if (ubte.val() == "") {
                msgMatch(1, "images/advertencia.PNG", "audio/saperror.wav", ubte.val().toUpperCase());
                ubte.val('');
                ubte.focus();
            } else {
                envDatoss();
            }
        } else if($('#rbAviso').is(':checked')){

            if (av.val() == "") {
                msgMatch(5, "images/advertencia.PNG", "audio/saperror.wav", av.val().toUpperCase());
                av.val('');
                av.focus();
            } else {
                envDatosAV();
            }
        } else if($('#rbNotificaQM').is(':checked')){
            if (li.val() == "") {
                msgMatch(7, "images/advertencia.PNG", "audio/saperror.wav", li.val().toUpperCase());
                li.val('');
                li.focus();
            } else {
                envDatosLI();
            }
            
        }else if($('#rbMov').is(':checked')){
            if (cm.val() == "") {
                msgMatch(8, "images/advertencia.PNG", "audio/saperror.wav", cm.val().toUpperCase());
                cm.val('');
                cm.focus();
            } else {
                envDatosCM();
            }
            
        }else{
        }



    });
//    $('#bxEquipo').keypress(function (e) {
//        var te = (document).all ? e.keyCode : e.which;
//        if (te == 32) {
//            return false;
//        }
//        t = String.fromCharCode(te);
//        patron = /[0-9.-]/;
//        return patron.test(t);
//    });
    $('#bxEquipo').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s-]/;
        return patron.test(t);
    });
    $('#bxUbic').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s-]/;
        return patron.test(t);
    });
    $('#bxAviso').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });
    $('#bxNoticaPM').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });
    $('#bxNoticaQM').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });
    $('#bxMovMer').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });
    $('.carpeta').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });
    $('.numero').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[0-9\s]/;
        return patron.test(t);
    });

    var equipo = $('#bxEquipo');
    var ubic = $('#bxUbic');
    var aviso = $('#bxAviso');
    var notificaMP = $('#bxNoticaPM');
    var notificaQP = $('#bxNoticaQM');
    var MovMer = $('#bxMovMer');

    var arrBx = [
        equipo,
        ubic,
        aviso,
        notificaMP,
        notificaQP,
        MovMer
    ];
    var bequipo = $('#btnEquipo');
    var bubic = $('#btnUbic');
    var baviso = $('#btnAviso');
    var bnotificaMP = $('#btnNoficaPM');
    var bnotificaQP = $('#btnNotificaQM');
    var bMovMer = $('#btnMovMer');

    var arrBtn = [
        bequipo,
        bubic,
        baviso,
        bnotificaMP,
        bnotificaQP,
        bMovMer
    ];

    var values = [
        $('#rbEquipo'),
        $('#rbUbic'),
        $('#rbAviso'),
        $('#rbNotificaPM'),
        $('#rbNotificaQM'),
        $('#rbMov')
    ];

    var arrOk = [
        $('#okEquipo'),
        $('#okUbicacion'),
        $('#okAviso'),
        $('#okNotiPM'),
        $('#okNotiQM'),
        $('#okMovimientos'),
    ];

    var arrPest = [
        $('#btnEquipoM'),
        $('#btnUbicacionM'),
        $('#btnAvisosM'),
        $('#btnNotiPMM'),
        $('#btnNotiQMM'),
        $('#btnMovimientosM')
    ];

    $.each(values, function (c, o)
    {
        o.click(function ()
        {
            $.each(arrBx, function (i, v)
            {
                switch (c)
                {
                    case 0:
                        if (i === 0)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                    case 1:
                        if (i === 1)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                    case 2:
                        if (i === 2)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                    case 3:
                        if (i === 3)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                    case 4:
                        if (i === 4)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                    case 5:
                        if (i === 5)
                        {
                            v.prop('disabled', false);
                            v.focus();
                            $.each(arrBtn, function (f, r)
                            {
                                r.hide();
                            });
                            arrBtn[i].show();
                        } else
                        {
                            v.prop('disabled', true);
                            v.val("");
                        }
                        break;
                }
            });
        });
    });

    $.each(arrBtn, function (i, v)
    {
        v.hide();
        v.click(function () {
            switch (i)
            {
                case 0:
                    $('#BuscarParamEquipo').show();
                    $('#ConsultaTablaEquipo').hide();
                    LimpiarPantalla('VentanaModalEquipo');
                    mostrarVentana('VentanaModalEquipo');
                    document.getElementById('bxEqE').focus();
                    var theHandle = document.getElementById('handle');
                    var theRoot = document.getElementById('VentanaModalEquipo');
                    Drag.init(theHandle, theRoot);
                    break;
                case 1:
                    $('#BuscarParamUbicacion').show();
                    $('#ConsultaTablaUbicacion').hide();
                    LimpiarPantalla('VentanaModalUbicacion');
                    mostrarVentana('VentanaModalUbicacion');
                    document.getElementById('ubictBus').focus();
                    var theHandle = document.getElementById('handle1');
                    var theRoot = document.getElementById('VentanaModalUbicacion');
                    Drag.init(theHandle, theRoot);
                    break;
                case 2:
                    $('#BuscarParamAvisos').show();
                    $('#ConsultaTablaAvisos').hide();
                    LimpiarPantalla('VentanaModalAvisos');
                    mostrarVentana('VentanaModalAvisos');
                    document.getElementById('bxAvMtch').focus();
                    var theHandle = document.getElementById('handle2');
                    var theRoot = document.getElementById('VentanaModalAvisos');
                    Drag.init(theHandle, theRoot);
                    break;
                case 3:
                    $('#BuscarParamNotiPM').show();
                    $('#ConsultaTablaNotiPM').hide();
                    LimpiarPantalla('VentanaModalNotiPM');
                    mostrarVentana('VentanaModalNotiPM');
                    document.getElementById('bxNPMMtch').focus();
                    var theHandle = document.getElementById('handle3');
                    var theRoot = document.getElementById('VentanaModalNotiPM');
                    Drag.init(theHandle, theRoot);
                    break;
                case 4:
                    $('#BuscarParamNotiQM').show();
                    $('#ConsultaTablaNotiQM').hide();
                    LimpiarPantalla('VentanaModalNotiQM');
                    mostrarVentana('VentanaModalNotiQM');
                    document.getElementById('bxNQMMtch').focus();
                    var theHandle = document.getElementById('handle4');
                    var theRoot = document.getElementById('VentanaModalNotiQM');
                    Drag.init(theHandle, theRoot);
                    break;
                case 5:
                    $('#BuscarParamMovimientos').show();
                    $('#ConsultaTablaMovimientos').hide();
                    LimpiarPantalla('VentanaModalMovimientos');
                    mostrarVentana('VentanaModalMovimientos');
                    document.getElementById('bxMovMtch').focus();
                    var theHandle = document.getElementById('handle5');
                    var theRoot = document.getElementById('VentanaModalMovimientos');
                    Drag.init(theHandle, theRoot);
                    break;
            }
        });
    });

    $.each(arrPest, function (i, v)
    {
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#BuscarParamEquipo').show();
                    $('#ConsultaTablaEquipo').hide();
                    break;
                case 1:
                    $('#BuscarParamUbicacion').show();
                    $('#ConsultaTablaUbicacion').hide();
                    break;
                case 2:
                    $('#BuscarParamAvisos').show();
                    $('#ConsultaTablaAvisos').hide();
                    break;
                case 3:
                    $('#BuscarParamNotiPM').show();
                    $('#ConsultaTablaNotiPM').hide();
                    break;
                case 4:
                    $('#BuscarParamNotiQM').show();
                    $('#ConsultaTablaNotiQM').hide();
                    break;
                case 5:
                    $('#BuscarParamMovimientos').show();
                    $('#ConsultaTablaMovimientos').hide();
                    break;
            }
        });
    });

    $.each(arrOk, function (i, v)
    {
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#BuscarParamEquipo').hide();
                    $('#ConsultaTablaEquipo').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosEquipo', 'VentanaModalEquipo', 'Equipo');
                    break;
                case 1:
                    $('#BuscarParamUbicacion').hide();
                    $('#ConsultaTablaUbicacion').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosUbicacion', 'VentanaModalUbicacion', 'Ubicacion');
                    break;
                case 2:
                    $('#BuscarParamAvisos').hide();
                    $('#ConsultaTablaAvisos').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosAvisos', 'VentanaModalAvisos', 'Avisos');
                    break;
                case 3:
                    $('#BuscarParamNotiPM').hide();
                    $('#ConsultaTablaNotiPM').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosNotiPM', 'VentanaModalNotiPM', 'NotiPM');
                    break;
                case 4:
                    $('#BuscarParamNotiQM').hide();
                    $('#ConsultaTablaNotiQM').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosNotiQM', 'VentanaModalNotiQM', 'NotiQM');
                    break;
                case 5:
                    $('#BuscarParamMovimientos').hide();
                    $('#ConsultaTablaMovimientos').show();
                    peticiones('PeticionVisualizarDocs', 'cargarDatosMovimientos', 'VentanaModalMovimientos', 'Movimientos');
                    break;
            }
        });
    });

    $.each(arrBx, function (i, v)
    {
        v.focus(function ()
        {
            $.each(arrBtn, function (c, o)
            {
                switch (i)
                {
                    case 0:
                        if (c === 0) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                    case 1:
                        if (c === 1) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                    case 2:
                        if (c === 2) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                    case 3:
                        if (c === 3) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                    case 4:
                        if (c === 4) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                    case 5:
                        if (c === 5) {
                            o.show();
                        } else {
                            o.hide();
                        }
                        break;
                }
            });
        });
    });

    //------ Matchs KeyPress----------
    var arrMatchEq = [
        $('#bxEqE'),
        $('#bxMaxE'),
        $('#ubictBus'),
        $('#bxnumAcMax'),
        $('#bxAvMtch'),
        $('#bxMaxAv'),
        $('#bxNPMMtch'),
        $('#bxMaxNM'),
        $('#bxNQMMtch'),
        $('#bxMaxNQM'),
        $('#bxMovMtch'),
        $('#bxMaxMov')

    ];
    $.each(arrMatchEq, function (i, v)
    {
        v.keypress(function (e)
        {
            switch (i)
            {
                case 0:
                case 1:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okEquipo").trigger("click");
                    }
                    break;
                case 2:
                case 3:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okUbicacion").trigger("click");
                    }
                    break;
                case 4:
                case 5:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okAviso").trigger("click");
                    }
                    break;
                case 6:
                case 7:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okNotiPM").trigger("click");
                    }
                    break;
                case 8:
                case 9:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okNotiQM").trigger("click");
                    }
                    break;
                case 10:
                case 11:
                    if (e.which == 13 || e.keyCode == 13)
                    {
                        $("#okMovimientos").trigger("click");
                    }
                    break;
            }
        });
    });
});

function seleccionarr(eq) {
    var se = $('#bxEquipo');
    se.val(eq);
    se.focus();
    ocultarVentana('VentanaModalEquipo', 'bxEquipo')
}
function seleccionarub(ub) {
    var se = $('#bxUbic');
    se.val(ub);
    se.focus();
    ocultarVentana('VentanaModalUbicacion', 'bxUbic');
}
function seleccionarAV(av) {
    var se = $('#bxAviso');
    se.val(av);
    se.focus();
    ocultarVentana('VentanaModalAvisos', 'bxAviso');
}
function seleccionarLI(li) {
    var se = $('#bxNoticaQM');
    se.val(li);
    se.focus();
    ocultarVentana('VentanaModalNotiQM', 'bxNoticaQM');
}
function seleccionarCD(cd) {
    var se = $('#bxMovMer');
    se.val(cd);
    se.focus();
    ocultarVentana('VentanaModalMovimientos', 'bxMovMer');
}

function enviarDatos() {
    var equipoBuen = $('#bxEquipo').val();
    var eqS = equipoBuen.substring(0, 4);
    var par = "&equip=" + equipoBuen + "&centroo=" + eqS  +"&msgg=Equipos&valeq="+equipoBuen;
    var acc = "EqQuery";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(3, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla" + par;

            }
        }
    });
}
function envDatoss() {
    var ubteBuen = $('#bxUbic').val();
    var unS = getCtrDMS();
    var par = "&ubte=" + ubteBuen + "&centroo=" + unS + "&msgg=Ubicacion Tecnica&valeq="+ubteBuen;
    var acc = "EjecutarQ";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(0, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla2" + par;

            }
        }
    });
}
function envDatosAV() {
    var avBuen = $('#bxAviso').val();
//    var unS = avBuen.substring(0, 4);
    var avS = getCtrDMS();
    var par = "&avi=" + avBuen + "&centroo=" + avS 
    var avManMss = "Avisos de Mantenimieno";
    var acc = "EjecutarQAV";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(0, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla3" + par +"&msgg=" + avManMss;

            }
        }
    });
}
function envDatosLI() {
    var liBuen = $('#bxNoticaQM').val();
//    var unS = avBuen.substring(0, 4);
    var avS = getCtrDMS();
    var par = "&loi=" + liBuen + "&centroo=" + avS
    var acc = "EjecutarQLI";
    var LoInMss = "Lotes de Inspección";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(0, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla4" + par +"&msgg=" + LoInMss;
            }
        }
    });
}
function envDatosCM() {
    var cmBuen = $('#bxMovMer').val();
    var cmS= getCtrDMS();
    var par = "&cmv=" + cmBuen + "&centroo=" + cmS;
    var MsgCDD = "Clase de Documento";
    var acc = "EjecutarQCM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(0, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla5" + par +"&msgg=" + MsgCDD;
            }
        }
    });
}
function getCtrDMS() {
    var type;
    var acc = "getCtr";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarDocs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            type = data;
        }
    });
    return type;
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
//function envDatoss() {
//    var ubteBuen = $('#bxUbic').val();
//    var unS = ubteBuen.substring(0, 4);
//    var par = "&ubte=" + ubteBuen + "&centroo=" + unS
//    var acc = "EjecutarQ";
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'PeticionVisualizarDocs',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "Action=" + acc + par,
//        success: function (data) {
//            if (data == 0) {
//                msgMatch(8, "images/advertencia.PNG", "audio/saperror.wav");
//            } else {
//                window.location.href = "VisualizaDocumentoDatos.jsp?Action=CargaTabla2" + par;
//
//            }
//        }
//    });
//}
function ValidarQuery() {
    var check = "0";
    if ($('#chsum').is(':checked')) {
        check = "1";
    }
    if ($('#chtras').is(':checked')) {
        check = "2";
    }
    var par = "&material=" + material.val() + "&garticulo=" + garticulo.val() + "&almacen=" + almacen.val() + "&centro=" + centro.val() + "&lote=" + lote.val() + "&tipo=" + check
    var acc = "ValidarQuery";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionInventario',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + par,
        success: function (data) {
            if (data == 0) {
                msgMatch(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VistaAllStockMaterial.jsp?Accion=CargarTabla" + par;
            }
        }
    });
}
function ocultarVentana(ven, id)
{
    var ventana = document.getElementById(ven);
    ventana.style.display = 'none';
    var txt = document.getElementById(id);
    txt.focus();
    document.getElementById("msg").innerHTML = "";
    document.getElementById("iconmsg").style.visibility = "hidden";
}

function LimpiarPantalla(ventana)
{
    switch (ventana)
    {
        case "VentanaModalEquipo":
            document.getElementById("bxEqE").value = "";
            document.getElementById("bxMaxE").value = "500";
            break;
        case "VentanaModalUbicacion":
            document.getElementById("ubictBus").value = "";
            document.getElementById("bxnumAcMax").value = "500";
            break;
        case "VentanaModalAvisos":
            document.getElementById("bxAvMtch").value = "";
            document.getElementById("bxMaxAv").value = "500";
            break;
        case "VentanaModalNotiPM":
            document.getElementById("bxNPMMtch").value = "";
            document.getElementById("bxMaxNPM").value = "500";
            break;
        case "s":
            document.getElementById("bxNQMMtch").value = "";
            document.getElementById("bxMaxNQM").value = "500";
            break;
        case "VentanaModalMovimientos":
            document.getElementById("bxMovMtch").value = "";
            document.getElementById("bxMaxMov").value = "500";
            break;
    }
}

function mostrarVentana(t)
{
    switch (t) {
        case "VentanaModalEquipo":
        case "VentanaModalUbicacion":
        case "VentanaModalAvisos":
        case "VentanaModalNotiPM":
        case "VentanaModalNotiQM":
        case "VentanaModalMovimientos":
            var ven = document.getElementById(t);
            abrirVentana(ven);
            break;
    }
}

function abrirVentana(ventana)
{
    var ancho = 1100;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    document.getElementById('aceptar').focus();
}
function fnc(f) {
    document.getElementById('table-scroll' + f).onscroll = function () {
        document.getElementById('fixedY' + f).style.top = document.getElementById('table-scroll' + f).scrollTop + 'px';
    };
}

function seleccionar(val, id, ven)
{
    document.getElementById(id).value = val;
    ocultarVentana(ven, id);
}

function inval(funinva)
{
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/advertencia.PNG";
    var men = document.getElementById("msg");
    men.innerHTML = funinva;
}
function ChecarEjecucion() {

}

function VisDoc() {
    acc = "matchDocs";
    var equi = $("#equ").val();
    var eqS = equi.substring(0, 4);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloVisualizarEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&equi=" + equi + "&centroo=" + eqS,
        success: function (rs) {
            if (rs == 0) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                blockPropiety('handle3', 'VentanaModalCentroP');
                $('#SecCuerpo').html(rs);
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                fncCentroP();
                borramsg();
            }
        }
    });
}