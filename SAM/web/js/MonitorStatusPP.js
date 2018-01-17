/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    window.onload = function () {
        startTime();
        bloq();
    };
    var teclalfanu = /[0-9a-zA-ZñÑ]/;
    var teclanum = /[0-9]/;
    $('#Ctro').css('background-image', 'url(images/necesario.PNG)');
    $('#Mte').css('background-image', 'url(images/necesario.PNG)');
    $('#Mte2').css('background-image', 'url(images/necesario.PNG)');
    $('#btnmat1').hide();
    $('#btnmat2').hide();
    $('#btnmat3').hide();
    $('#btnpto').hide();
    $('#btnmat31').hide();
    $('#Ctro').focus(function () {
        $('#Ctro').css('background-image', 'none');
        $('#btnmat1').show();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnpto').hide();
        $('#btnmat31').hide();
    });
    $('#Mte').focus(function () {
        $('#Mte').css('background-image', 'none');
        $('#btnmat1').show();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnpto').hide();
        $('#btnmat31').hide();
    });
    $('#Mte2').focus(function () {
        $('#Mte2').css('background-image', 'none');
        $('#btnmat1').show();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnpto').hide();
        $('#btnmat31').hide();
    });
    $('#Ctro').blur(function () {
        if ($('#Ctro').val().length > 0) {
            
            $('#Ctro').css('background-image', 'none');
        } else {
            $('#Ctro').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#Mte').blur(function () {
        if ($('#Mte').val().length > 0) {
            $('#Mte').css('background-image', 'none');
        } else {
            $('#Mte').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#Mte2').blur(function () {
        if ($('#Mte2').val().length > 0) {
            $('#Mte2').css('background-image', 'none');
        } else {
            $('#Mte2').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#btnmat1').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Centro');
    });
    $('#btnpto').click(function () {
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalPuesto");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Puesto');
    });
    $('#btnmat2').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalUbiTecn");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Ubicacion');
    });
    $('#btnmat3').click(function () {
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Equipo');
        InsertarID('Mte');
    });
    $('#btnmat31').click(function () {
        1
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Equipo');
        InsertarID('Mte2');
    });
    $('#BusDesCentro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });
    $('#BusCentro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });
    $('#okCentro').click(function () {
        ConsultaCentro();
    });
    $('#Ubic').focus(function () {
        $('#btnmat1').hide();
        $('#btnmat2').show();
        $('#btnmat3').hide();
        $('#btnpto').hide();
        $('#btnmat31').hide();
    });

    $('#ubictBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    $('#DesUbiBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    
    $('#okUbic').click(function () {
        ConsultaUbicacion();
    });
    $('#Mte').focus(function () {
        $('#btnmat1').hide();
        $('#btnmat2').hide();
        $('#btnpto').hide();
        $('#btnmat31').hide();
        $('#btnmat3').show();
    });
    $('#Mte2').focus(function () {
        $('#btnmat1').hide();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnpto').hide();
        $('#btnmat31').show();
    });
    $('#PtoTjo').focus(function () {
        $('#btnmat1').hide();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnpto').show();
        $('#btnmat31').hide();
    });
    $('#PtoTjo').keypress(function (e) {
        if (e.which == 32 || e.keyCode == 32) {
            return false;
        }
    });
    $('#equBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMate();
        }
    });
    $('#denEqBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMate();
        }
    });
    $('#okMate').click(function () {
        ConsultaMate();
    });
    $('#numAcMax').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaCentro();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tec);
        return patron.test(t);
    });
    $('#numAcMax2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaUbicacion();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tec);
        return patron.test(t);
    });
    $('#numAcMax3').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaMate();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tec);
        return patron.test(t);
    });
    $("#Ctro").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#Ubic").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#Mte").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#ubictBus").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#BusCentro").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#equBus").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $('#puestp').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarPuesto();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#Ptexto_mate').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarPuesto();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax6').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarPuesto();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okPuesto').click(function () {
        ConsultarPuesto();
    });

    function InsertarID(va) {
        $("#idEQ").val(va);
    }

    $("#ejecutar").click(function () {
        ChecarEjecucion();
    });

    function ChecarEjecucion()
    {
        var radiosE = document.getElementsByName('Ejecucion');
        for (var i = 0; i < radiosE.length; i++)
        {
            if (radiosE[i].checked)
            {
                switch (radiosE[i].value)
                {
//                    case 'Ubicacion':
//                        if ($("#Ctro").val() === "")
//                        {
//                            mensajess(0, 'audio/saperror.wav', 'images/advertencia.PNG');
//                            $("#Ctro").focus();
//                            $("#Ctro").select();
//                        } else if ($("#Ubic").val() === "")
//                        {
//                            mensajess(0, 'audio/saperror.wav', 'images/advertencia.PNG');
//                            $("#Ubic").focus();
//                            $("#Ubic").select();
//                        } else
//                        {
//                            alert("Ubi");
//                            checarStatus(1);
//                        }
//                        break;
                    case 'Material':
                        if ($("#Ctro").val() === "")
                        {
                            mensajess(0, 'audio/saperror.wav', 'images/advertencia.PNG');
                            $("#Ctro").focus();
                            $("#Ctro").select();
                        }
                        if ($("#Mte").value === "")
                        {
                            mensajess(0, 'audio/saperror.wav', 'images/advertencia.PNG');
                            $("#Mte").focus();
                            $("#Mte").select();
                        } else
                        {
                            checarStatus(1);
                        }
                        break;
                }
            }
        }
    }
    function checarStatus(modo)
    {
        if ($('#PtoTjo').val().length > 0) {
            if (validarDato("PtoTjo", "ValidarPuesto", "&Puesto=" + $('#PtoTjo').val()) == false) {
                mensajess(2, "audio/saperror.wav", "images/advertencia.PNG");
                $('#PtoTjo').focus();
                return;
            }
        }
        var requt;
        var ctr = $("#Ctro").val();        
        var mte = $("#Mte").val();
        var mte2 = $("#Mte2").val();
        var temp = new Array();
        var enviar = "&ctr=" + ctr.toUpperCase() + "&mte=" + mte + "&mte2=" + mte2;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionMonStatusPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                requt = data;
                temp = requt.split(",");
                var ectr = temp[0];                
                var eequ = temp[1];
                var eeq2 = temp[2];

                if (modo == 0)
                {
                    EnviarMensaje(ectr, eubi, eequ, eeq2);
                }
                if (parseInt(modo) == 1)
                {
                    if (EnviarMensaje(ectr, eubi, eequ))
                    {                        
                        borramsg();
                        Conttabla();
                    }
                }
            }

        });

    }
    
    function EnviarMensaje(ctr, ubi, equ, eeq2)
    {
        var radiosE = document.getElementsByName('Ejecucion');
        for (var i = 0; i < radiosE.length; i++)
        {
            if (radiosE[i].checked)
            {
                switch (radiosE[i].value)
                {
                    case 'Equipo':
                        if (parseInt(equ) == 0 || parseInt(ctr) == 0 || parseInt(eeq2) == 0)
                        {

                            //error
                            mensajess(1, 'audio/saperror.wav', 'images/advertencia.PNG');
                            if (parseInt(ctr) == 0)
                            {
                                $("#Ctro").focus();
                                $("#Ctro").select();
                            } else if (parseInt(equ) == 0 || (parseInt(ctr) == 0 && parseInt(equ) == 0))
                            {
                                $("#Eqpo").focus();
                                $("#Eqpo").select();
                            } else if (parseInt(eeq2) == 0 || (parseInt(ctr) == 0 && parseInt(eeq2) == 0))
                            {
                                $("#Eqpo31").focus();
                                $("#Eqpo31").select();
                            }

                            return false;
                        } else
                        {
                            return true;
                        }
                        break;
                }
            }
        }
    }

    function ModoEjc()
    {
        var radiosE = document.getElementsByName('Ejecucion');
        for (var i = 0; i < radiosE.length; i++)
        {
            if (radiosE[i].checked)
            {
                switch (radiosE[i].value)
                {
                    case 'Ubicacion':
                        $("#Ubic").prop("disabled", false);
                        $("#Eqpo").prop("disabled", true);
                        $("#Eqpo31").prop("disabled", true);
                        $("#Ubic").val("");
                        $("#Eqpo").val("");
                        $("#Eqpo31").val("");
                        break;
                    case 'Equipo':
                        $("#Ubic").prop("disabled", true);
                        $("#Eqpo").prop("disabled", false);
                        $("#Eqpo31").prop("disabled", false);
                        $("#Ubic").val("");
                        $("#Eqpo").val("");
                        $("#Eqpo31").val("");
                        break;
                }
            }
        }
    }
});

function mostrarVentanaModal(tipo)
{
    switch (tipo) {
        case "Centro":
            var ventana = document.getElementById('VentanaModalCentro');
            abrirVentana(ventana);
            $("#BusCentro").focus();
            $("#BusCentro").val('');
            $("#BusCentro").val('');
            $("#numAcMax").val('500');
            break;
        case "Ubicacion":
            var ventana2 = document.getElementById('VentanaModalUbiTecn');
            abrirVentana(ventana2);
            $("#ubictBus").focus();
            $("#ubictBus").val('');
            $("#DesUbiBus").val('');
            $("#numAcMax2").val('500');
            break;
        case "Equipo":
            var ventana3 = document.getElementById('VentanaModalEquipo');
            abrirVentana(ventana3);
            $("#equBus").focus();
            $("#equBus").val('');
            $("#denEqBus").val('');
            $("#numAcMax3").val('500');
            break;
        case "Puesto":
            var ventana3 = document.getElementById('VentanaModalPuesto');
            abrirVentana(ventana3);
            $("#puestp").focus();
            $("#puestp").val('');
            $("#Ptexto_mate").val('');
            $("#numAcMax6").val('500');
            break;
    }

}
function abrirVentana(ventana) {

    ///abrir ventanas
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();

    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    borramsg();
}
function ConsultaCentro() {
    var acc = "ConsultarCentro";
    var Cen = $("#BusCentro").val();
    var Nom = $("#BusDesCentro").val();
    var ctd = $("#numAcMax").val();
    var enviar = "&Centro=" + Cen + "&CentroNom=" + Nom + "&Ctd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloMonitorStatusContadoresPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            $("input").prop("disabled", false);
            $("button").prop("disabled", false);
            var ck = document.getElementsByName('Ejecucion');
            if (ck[0].checked) {
                $("#Eqpo").prop("disabled", true);
                $("#Eqpo31").prop("disabled", true);
            }
            if (ck[1].checked) {
                $("#Ubic").prop("disabled", true);
            }
            var rs = data;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                $("#BuscarParamCentro_SP").css("display", "none");
                $("#ConsultaTablaCentro").css("display", "block");
                $("#cargarDatoCentro").html(rs);
                borramsg();
            }
        }

    });
}
function ConsultarPuesto() {
    var acc = "ConsultaMatchPuesto";
    var idioma = $('#Idioma').val();
    var pue = $('#puestp').val();
    var Den = $('#Ptexto_mate').val();
    var cant = $('#numAcMax6').val();
    var datos = "&Puesto=" + pue + "&DPuesto=" + Den + "&ctd=" + cant + "&Idioma=" + idioma;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloMonitorStatusContadoresPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            $("button").prop("disabled", false);
            $("input").prop("disabled", false);
            var ck = document.getElementsByName('Ejecucion');
            if (ck[0].checked) {
                $("#Eqpo").prop("disabled", true);
                $("#Eqpo31").prop("disabled", true);
            }
            if (ck[1].checked) {
                $("#Ubic").prop("disabled", true);
            }
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $('#BuscarParamPt').hide();
                $('#ConsultaTablaPuesto').show();
                $('#CargarDatosPuesto').html(data);
                fnc('table-scrollPuesto', 'fixedYPuesto');
                borramsg();
            }
        }
    });
}
function ConsultaUbicacion() {
    var acc = "ConsultarUbicacion";
    var Cen = $("#ubictBus").val();
    var Nom = $("#DesUbiBus").val();
    var ctd = $("#numAcMax2").val();
    var enviar = "&Ubicacion=" + Cen + "&DUbicacion=" + Nom + "&Ctd=" + ctd;

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloMonitorStatusContadoresPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            $("button").prop("disabled", false);
            $("input").prop("disabled", false);
            var ck = document.getElementsByName('Ejecucion');
            if (ck[0].checked) {
                $("#Eqpo").prop("disabled", true);
                $("#Eqpo31").prop("disabled", true);
            }

            var rs = data;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                $("#BuscarParamUbi").css("display", "none");
                $("#ConsultaTablaubitec").css("display", "block");
                $("#cargarDatosUbitec").html(rs);
                fnc('table-scrollUbitec', 'fixedYUbitec');
                borramsg();
            }
        }

    });
}
function ConsultaMate(){
    var acc = "ConsultaMate";
    var mat = $('#equBus').val();
    var denMat = $('#denEqBus').val();
    var ctdMat = $('#numAcMax3').val();
    var idEQ = $('#idEQ').val();
    var enviar = "&mate=" + mat + "&denMat=" + denMat + "&ctdMat="+ ctdMat + "&idEQ=" + idEQ;
    alert(enviar);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloMonitorStatusContadoresPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function(data){            
            $("input").prop("disabled", false);
            $("button").prop("disabled", false);
            var ch = document.getElementsByName('Ejecucion');
            if( ch[0].checked){
                $("#Mte").prop("disabled", true);
                $("#Mte2").prop("disabled", true);
            }
            var rs = data;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                $("#BuscarParamEquipo").css("display", "none");
                $("#ConsultaTablaEquipo").css("display", "block");
                $("#cargarDatosEquipo").html(rs);
                borramsg();
            }
        }
    });
}
function Conttabla()
{
    var valor;
    var radiosC = document.getElementsByName('Mensaje');
    for (var i = 0; i < radiosC.length; i++)
    {
        if (radiosC[i].checked)
        {
            valor = radiosC[i].value;
        }
    }
    var centro = $("#Ctro").val();    
    var mte = $("#Mte").val();
    var mte2 = $("#Mte2").val();
    var pues = $("#PtoTjo").val();

    var radiosV = document.getElementsByName('Visualizacion');
    for (var i = 0; i < radiosV.length; i++)
    {
        if (radiosV[i].checked)
        {
            switch (radiosV[i].value)
            {
                case 'Medidas':
//                            alert(valor);
                    window.location.href = "MonitorStatusContPP.jsp?valor=" + valor + "&centro=" + centro.toUpperCase() + "&mte=" + mte + "&mte2=" + mte2 + "&puesto=" + pues;
                    cleanfield();
                    break;
                case 'Mantenimiento':
                    window.location.href = "MonitorStatusCont2PP.jsp?valor=" + valor + "&centro=" + centro.toUpperCase() + "&mte=" + mte + "&mte2=" + mte + "&puesto=" + pues;
                    cleanfield();
                    break;
            }
        }
    }
}
function cleanfield() {
    $("#Ctro").val("");
    $("#Ubic").val("");
    $("#Eqpo").val("");
    $("#Eqpo31").val("");
}
function ocultarVentana(tipo)
{
    switch (tipo) {
        case "Mte":
            var ventanaMte = document.getElementById('VentanaModalEquipo');           
            ventanaMte.style.display = 'none';
            $("#BuscarParamEquipo").css("display", "block");
            $("#ConsultaTablaEquipo").css("display", "none");
            $("#Mte").focus();
        break;
        case "Mte2":
            var ventanaMtee = document.getElementById('VentanaModalEquipo');           
            ventanaMtee.style.display = 'none';
            $("#BuscarParamEquipo").css("display", "block");
            $("#ConsultaTablaEquipo").css("display", "none");
            $("#Mte2").focus();
        break;
        case "Centro":
            var ventana = document.getElementById('VentanaModalCentro');
            ventana.style.display = 'none';
            $("#BuscarParamCentro_SP").css("display", "block");
            $("#ConsultaTablaCentro").css("display", "none");
            $("#Ctro").focus();
            break;
        case "Ubicacion":
            var ventana2 = document.getElementById('VentanaModalUbiTecn');
            ventana2.style.display = 'none';
            $("#BuscarParamUbi").css("display", "block");
            $("#ConsultaTablaubitec").css("display", "none");
            $("#Ubic").focus();
            break;
        case "Equipo":
            var ventana2 = document.getElementById('VentanaModalEquipo');
            ventana2.style.display = 'none';
            $("#BuscarParamEquipo").css("display", "block");
            $("#ConsultaTablaEquipo").css("display", "none");
            $("#Eqpo").focus();
            break;
        case "Puesto":
            var ventana2 = document.getElementById('VentanaModalPuesto');
            ventana2.style.display = 'none';
            $("#BuscarParamPt").css("display", "block");
            $("#ConsultaTablaPuesto").css("display", "none");
            $("#PtoTjo").focus();
            break;
    }
}
function Select(obj, tipo) {
    switch (tipo) {
        case "Mte":
            document.getElementById("Mte").value = obj;
            ocultarVentana(tipo);
        break;
        case "Mte2":
            document.getElementById("Mte2").value = obj;
            ocultarVentana(tipo);
        break;
        case "Centro":
            document.getElementById("Ctro").value = obj;
            ocultarVentana(tipo);
            break;
        case "Ubicacion":
            document.getElementById("Ubic").value = obj;
            ocultarVentana(tipo);
            break;
        case "Equipo":
            document.getElementById("Eqpo").value = obj;
            ocultarVentana(tipo);
            break;
        case "Eqpo":
            document.getElementById("Eqpo").value = obj;
            ocultarVentana('Equipo');
            break;
        case "Eqpo31":
            document.getElementById("Eqpo31").value = obj;
            ocultarVentana('Equipo');
            break;
        case "Puesto":
            document.getElementById("PtoTjo").value = obj;
            ocultarVentana('Puesto');
            break;
    }
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function borramsg() {
    $("#iconmsg").css("visibility", "hidden");
    $("#msg").html("");
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

function bloq() {
    $("#iconmsg").css("visibility", "hidden");
    $("#guardar").prop("disabled", true);
}
