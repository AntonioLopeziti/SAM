/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Drag */

$(document).ready(function () {
    startTime();
    window.onload = function () {
        startTime();
        $("#iconmsg").css("visibility", "hidden");
    };

    $("#btnceor1").click(function () {
        ocultarVentana('Orden');
    });
    $("#btnceor2").click(function () {
        ocultarVentana('Orden');
    });
    $("#btnceub1").click(function () {
        ocultarVentana('Ubicacion');
    });
    $("#btnceub2").click(function () {
        ocultarVentana('Ubicacion');
    });
    $("#btnceeq1").click(function () {
        ocultarVentana('Equipo');
    });
    $("#btnceeq2").click(function () {
        ocultarVentana('Equipo');
    });

    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').hide();
    $('#match_C4').hide();
    $('#not').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#not').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#ord').focus(function () {
        $('#match_C1').show();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();

    });
    $('#ope').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return  false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#subop').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return  false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#ope').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#subop').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#ubte').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#equ').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#ubte').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').show();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#equ').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').show();
        $('#match_C4').hide();
    });
    $('#conta').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#clascap').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#nopar').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
    });
    $('#match_C1').click(function () {
        mostrarVentanaModal("Orden");
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalOrden");
        Drag.init(theHandle, theRoot);
    });
    $('#okorden').click(function () {
        ConsultaOrden();
    });
    $('#NumOrden_Bus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#TextoOrden_Bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#numAcMax').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden();
        }
        t = String.fromCharCode(tec);
        patr = /[0-9]/;
        return patr.test(t);
    });
    $('#match_C2').click(function () {
        mostrarVentanaModal("Ubicacion");
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalUbi");
        Drag.init(theHandle, theRoot);
    });
    $('#okUbi').click(function () {
        ConsultaUbicacion();
    });
    $('#UbicaB').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUbicacion();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#DUbicaB').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaUbicacion();
        }
        t = String.fromCharCode(tec);
        patr = /[0-9]/;
        return patr.test(t);
    });
    $('#match_C3').click(function () {
        mostrarVentanaModal("Equipo");
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
    });
    $('#okEquipo').click(function () {
        ConsultaEquipo();
    });
    $('#equipma3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipo();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#denequ').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo();
        }
    });
    $('#numAcMax3').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaEquipo();
        }
        t = String.fromCharCode(tec);
        patr = /[0-9]/;
        return patr.test(t);
    });
    $("#regresar").click(function () {
        back();
    });
    $
    function back() {
        window.location.href = "Bienvenido.jsp";
    }
    function regresarfiltro(id1, id2) {
        $("#" + id1).css("display", "block");
        $("#" + id2).css("display", "none");
    }
    $("#vemoor").click(function () {
        regresarfiltro('BuscarParamOrden', 'ConsultaTablaOrden');
    });

    $("#vemoub").click(function () {
        regresarfiltro('BuscarParam_u2', 'ConsultaTablaUbicacion');
    });

    $("#vemoeq").click(function () {
        regresarfiltro('BuscarParam_u3', 'ConsultaTabla3');
    });

    function mostrarVentanaModal(tipo) {

        switch (tipo) {
            case 'Orden':
                borrarmsg();
                var ventana = document.getElementById('VentanaModalOrden');
                abrirVentana(ventana);
                $("#NumOrden_Bus").val('');
                $("#NumOrden_Bus").focus();
                $("#TextoOrden_Bus").val('');
                $("#numAcMax").val('500');
                break;
            case 'Ubicacion':
                borrarmsg();
                var ventana2 = document.getElementById('VentanaModalUbi');
                abrirVentana(ventana2);
                $("#UbicaB").focus();
                $("#UbicaB").val('');
                $("#numAcMax2").val('500');
                break;
            case 'Equipo':
                borrarmsg();
                var ventana3 = document.getElementById('VentanaModalEquipo');
                abrirVentana(ventana3);
                $("#denequ").val('');
                $("#numAcMax3").val('500');
                $("#equipma3").focus();
                $("#equipma3").val('');
                break;
        }

    }
    function abrirVentana(ventana) {
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
    }


    function ConsultaOrden() {
        var acc = "ConsultaOrden";
        var Orden = $("#NumOrden_Bus").val();
        var Dorde = $("#TextoOrden_Bus").val();
        var ctd = $("#numAcMax").val();
        var enviar = "&Orden=" + Orden + "&DOrden=" + Dorde + "&Cantidad=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloVisualNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    mensajess(4, "audio/sapmsg.wav", "images/aceptar.png");
                } else {
                    $("#BuscarParamOrden").css("display", "none");
                    $("#ConsultaTablaOrden").css("display", "block");
                    $("#cargarDatosOrden").html(rs);
                    fnc("table-scrollOrden", "fixedYOrden");
                }
            }

        });
    }
    function fnc(scroll, fixe) {
        document.getElementById(scroll).onscroll = function () {
            document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
        };
    }
    function ConsultaUbicacion() {
        var acc = "ConsultaUbicacion";
        var Ubi = $("#UbicaB").val();
        var DUb = $("#DUbicaB").val();
        var ctd = $("#numAcMax2").val();
        var enviar = "&Ubicacion=" + Ubi + "&DUbicacion=" + DUb + "&Cantidad=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloVisualNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    mensajess(4, "audio/sapmsg.wav", "images/aceptar.png");
                } else {
                    $("#BuscarParam_u2").css("display", "none");
                    $("#ConsultaTablaUbicacion").css("display", "block");
                    $("#cargarDatosUbicacionn").html(rs);
                    fnc("table-scrollUbicacion", "fixedYUbicacion");
                }
            }

        });
    }

    function ConsultaEquipo() {
        var acc = "ConsultaEquipo";
        var Equ = $("#equipma3").val();
        var DEq = $("#denequ").val();
        var ctd = $("#numAcMax3").val();
        var enviar = "&Equipo=" + Equ + "&DEquipo=" + DEq + "&Cantidad=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloVisualNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    mensajess(4, "audio/sapmsg.wav", "images/aceptar.png");
                } else {
                    $("#BuscarParam_u3").css("display", "none");
                    $("#ConsultaTabla3").css("display", "block");
                    $("#CargarDatosEquipo").html(rs);
                    fnc("table-scrollEquipo", "fixedYEquipo");
                }
            }

        });
    }


    $("#aceptar").click(function () {
        mostrar1();
    });

    function colorLetra() {
        $("#etNotificacion").css("color", "#0000FF");
        $("#etOrden").css("color", "#0000FF");
        $("#etOperacion").css("color", "#0000FF");
        $("#etSubOperacion").css("color", "#0000FF");
        $("#etUbicTecn").css("color", "#0000FF");
        $("#etEquipo").css("color", "#0000FF");
        $("#etContador").css("color", "#0000FF");
        $("#etClaseCapacidad").css("color", "#0000FF");
        $("#etNParticion").css("color", "#0000FF");
    }
    function mostrar1() {
        var orden = $("#ord").val();
        var opera = $("#ope").val();
        if (orden == null || orden == "") {
            //error
            mensajess(1, "audio/saperror.wav", "images/advertencia.PNG");
            $('#ord').focus();
            colorLetra();
        } else {
            enviaDatos(orden, opera);
        }
    }
    function enviaDatos(orden, opera) {
        var acc = "ValidaOrden";
        var or = orden.toUpperCase();
        var enviar = "&Orden=" + or;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloVisualNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 1) {
                    location.href = "ResumenNotificacionPM.jsp?orden=" + or + "&opera=" + opera;
                } else {
                    mensajess(3, "audio/saperror.wav", "images/advertencia.PNG", or);
                    $('#ord').focus();
                }
            }

        });
    }

    $("#ord").keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            mostrar1();
            return false;
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9A-Za-z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $("#ord").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#ubte").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#equ").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#NumOrden_Bus").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#UbicaB").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#equipma3").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    function borrarmsg() {
        $("#iconmsg").css("visibility", "hidden");
        $("#msg").html("");
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
function seleccionar(dato, tipo) {
    switch (tipo) {
        case "Orden":
            $("#ord").val(dato);
            ocultarVentana("Orden");
            break;
        case "Ubicacion":
            $("#ubte").val(dato);
            ocultarVentana("Ubicacion");
            break;
        case "Equipo":
            $("#equ").val(dato);
            ocultarVentana("Equipo");
            break;
    }
}
function ocultarVentana(tipo) {

    switch (tipo) {
        case 'Orden':
            $("#VentanaModalOrden").css("display", "none");
            $("#BuscarParamOrden").css("display", "block");
            $("#ConsultaTablaOrden").css("display", "none");
            $("#ord").focus();
            break;
        case 'Ubicacion':
            $("#VentanaModalUbi").css("display", "none");
            $("#BuscarParam_u2").css("display", "block");
            $("#ConsultaTablaUbicacion").css("display", "none");
            $("#ubte").focus();
            break;
        case 'Equipo':
            $("#VentanaModalEquipo").css("display", "none");
            $("#BuscarParam_u3").css("display", "block");
            $("#ConsultaTabla3").css("display", "none");
            break;
    }

}


function inval() {
    mensajess(2, "audio/saperror.wav", "images/advertencia.PNG");
}

