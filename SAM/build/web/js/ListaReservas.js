/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    checkPermisoPag();
    CheckResolucion();
    startTime();
    CargarCentros();
    $('#iconmsg').hide();
    $('#regresar').click(function () {
        window.location.href = "Bienvenido.jsp";
    });
    $('#finalizar').click(function () {
        window.location.href = "Bienvenido.jsp";
    });
    /////// Cerrar MC
    $('#OCUMatchRes').click(function () {
        ocultarVentana("VentanaModalReserva", "reserva");
    });
    $('#OCUMatchRes2').click(function () {
        ocultarVentana("VentanaModalReserva2", "reserva2");
    });
    $('#OCUMatchSAM').click(function () {
        ocultarVentana("VentanaModalSAM", "Sam");
    });
    $('#OCUMatchSAM2').click(function () {
        ocultarVentana("VentanaModalSAM2", "Sam2");
    });
    $('#OCUMatchClase').click(function () {
        ocultarVentana("VentanaModalClase", "clase");
    });
    $('#OCUMatchsolic').click(function () {
        ocultarVentana("VentanaModalSolicitante", "solicitante");
    });
    $('#OCUMatchMate').click(function () {
        ocultarVentana("VentanaModalMaterial", "material");
    });
    var arrda = [
        $('#SelectCentros'),
        $('#reserva'),
        $('#Sam'),
        $('#fechainicio'),
        $('#clase'),
        $('#solicitante'),
        $('#material'),
        $('#reserva2'),
        $('#Sam2'),
        $('#fechafin')
    ];
    var arrm = [
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6'),
        $('#match_A7'),
        $('#match_A8'),
        $('#match_A9'),
        $('#match_A10')
    ];
    $.each(arrm, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultaReserva();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaSAM();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultaCMov();
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaSolicitante();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaMaterial();
                });
                break;
            case 5:
                v.click(function () {
                    ConsultaReserva2();
                });
                break;
            case 6:
                v.click(function () {
                    ConsultaSAM2();
                });
                break;
            case 7:
                v.click(function () {
                    OpenCalendario("fechainicio");
                });
                break;
            case 8:
                v.click(function () {
                    OpenCalendario("fechafin");
                });
                break;
        }
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });

    $.each(arrda, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 1:
                v.focus(function () {
                    checarPosiMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("reserva", "ValidarReserva", "&Reserva=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Sam", "ValidarReservaSAM", "&Sam=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 3:
                v.focus(function () {
                    checarPosiMa(7);
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
            case 4:
                v.focus(function () {
                    checarPosiMa(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("clase", "ValidarReservaClase", "&Clase=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", v.val());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 5:
                v.focus(function () {
                    checarPosiMa(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("solicitante", "ValidarReservaSolicitante", "&Sol=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 6:
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("material", "ValidarReservaMaterial", "&Mat=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 7:
                v.focus(function () {
                    checarPosiMa(5);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("reserva2", "ValidarReserva", "&Reserva=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 8:
                v.focus(function () {
                    checarPosiMa(6);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 32) {
                        return false;
                    }
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Sam2", "ValidarReservaSAM", "&Sam2=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 9:
                v.focus(function () {
                    checarPosiMa(8);
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;

        }
    });
    function checarPosiMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#ejecutar').click(function () {
        if ($('#reserva').val().length > 0) {
            if (validarDato("reserva", "ValidarReserva", "&Reserva=" + $('#reserva').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                $('#reserva').val('');
                $('#reserva').focus();
                return;
            }
        }
        if ($('#reserva2').val().length > 0) {
            if (validarDato("reserva2", "ValidarReserva", "&Reserva=" + $('#reserva2').val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                $('#reserva2').val('');
                $('#reserva2').focus();
                return;
            }
        }
        if ($('#Sam').val().length > 0) {
            if (validarDato("Sam", "ValidarReservaSAM", "&Sam=" + $('#Sam').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                $('#Sam').val('');
                $('#Sam').focus();
                return;
            }
        }
        if ($('#Sam2').val().length > 0) {
            if (validarDato("Sam2", "ValidarReservaSAM", "&Sam=" + $('#Sam2').val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                $('#Sam2').val('');
                $('#Sam2').focus();
                return;
            }
        }
        if ($('#clase').val().length > 0) {
            if (validarDato("clase", "ValidarReservaClase", "&Clase=" + $('#clase').val()) == false) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                $('#clase').val('');
                $('#clase').focus();
                return;
            }
        }
        if ($('#solicitante').val().length > 0) {
            if (validarDato("solicitante", "ValidarReservaSolicitante", "&Sol=" + $('#solicitante').val()) == false) {
                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                $('#solicitante').val('');
                $('#solicitante').focus();
                return;
            }
        }
        if ($('#material').val().length > 0) {
            if (validarDato("material", "ValidarReservaMaterial", "&Mat=" + $('#material').val()) == false) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                $('#material').val('');
                $('#material').focus();
                return;
            }
        }
        ValidarQuery();
    });
});
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionListaReservas',
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
function ConsultaReserva() {
    var acc = "CargarReservas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalReserva', 'handle2');
                $('#cargarDatosReserva').html(data);
                fnc('table-scrollResNum', 'fixedYResNum');
                borramsg();
            }
        }
    });
}
function ConsultaReserva2() {
    var acc = "CargarReservas2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalReserva2', 'handle3');
                $('#cargarDatosReserva2').html(data);
                fnc('table-scrollResNum2', 'fixedYResNum2');
                borramsg();
            }
        }
    });
}
function ConsultaSAM() {
    var acc = "CargarSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM', 'handle4');
                $('#cargarDatosFolioSAM').html(data);
                fnc('table-scrollCS', 'fixedYCS');
                borramsg();
            }
        }
    });
}
function ConsultaSAM2() {
    var acc = "CargarSAM2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSAM2', 'handle5');
                $('#cargarDatosFolioSAM2').html(data);
                fnc('table-scrollCS2', 'fixedYCS2');
                borramsg();
            }
        }
    });
}
function ConsultaCMov() {
    var acc = "CargarCMov";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalClase', 'handle6');
                $('#cargarDatosClase').html(data);
                fnc('table-scrollClasM', 'fixedYClaM');
                borramsg();
            }
        }
    });
}
function ConsultaSolicitante() {
    var acc = "CargarSolicitante";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalSolicitante', 'handle7');
                $('#cargarDatosSolicitante').html(data);
                fnc('table-scrollSol', 'fixedYSol');
                borramsg();
            }
        }
    });
}
function ConsultaMaterial() {
    var acc = "CargarMaterial";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalMaterial', 'handle8');
                $('#cargarDatosMaterial').html(data);
                fnc('table-scrollMat', 'fixedYMat');
                borramsg();
            }
        }
    });
}
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function MostrarVentanaModal(id, handle) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
}
function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#SelectCentros').html(data);
        }
    });
}


function ValidarQuery() {
    var NumR = $('#reserva').val().trim();
    var NumR2 = $('#reserva2').val().trim();
    var SAM = $('#Sam').val().trim();
    var SAM2 = $('#Sam2').val().trim();
    var Fec1 = $('#fechainicio').val().trim();
    var Fec2 = $('#fechafin').val().trim();
    var Clas = $('#clase').val().trim();
    var Sol = $('#solicitante').val().trim();
    var Mat = $('#material').val().trim();
    var Cen = $('#SelectCentros').val().trim();
    var acc = "ValidarQuery";
    var param = "&R1=" + NumR + "&R2=" + NumR2 + "&S1=" + SAM + "&S2=" + SAM2 + "&F1=" + Fec1 + "&F2=" + Fec2;
    var par = param + "&Cl=" + Clas + "&Sl=" + Sol + "&Mat=" + Mat + "&Ce=" + Cen;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionListaReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + par,
        success: function (data) {
            if (data == 0) {
                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                window.location.href = "VisualizarReporteReservas2.jsp?Accion=CargarTabla" + par;
            }
        }
    });
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
function Select(dato, id, ven) {
    $('#' + id).val(dato);
    ocultarVentana(ven, id);
}
function ocultarVentana(id, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj).focus();
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#IDFecha").val(id);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Calenndar');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handlecalendar");
    var theRoot = document.getElementById("Calenndar");
    Drag.init(theHandle, theRoot);
    $('#datapicker').datepicker().show();
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}