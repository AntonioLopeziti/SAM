/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    CargarCentros();
    startTime();
    $('#regresar').click(function(){
        $(location).attr('href','Reportes.jsp');
    });
    $('#finalizar').click(function(){
        $(location).attr('href','Bienvenido.jsp');
    });
    patron = /[0-9a-zA-ZñÑ]/;
    $('#iconmsg').hide();
    var arri = [
        $('#centro'),
        $('#sam1'),
        $('#sam2'),
        $('#doc1'),
        $('#doc2'),
        $('#fec1'),
        $('#fec2'),
        $('#cdoc')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6'),
        $('#match_A7')
    ];
    $('#ejecutar').click(function () {
        if ($('#sam1').val().length > 0) {
            if (validarDato("sam1", "ValidarDato", "&var1=" + $('#sam1').val() + "&var2=FOL") == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sam1').val().toUpperCase());
                $('#sam1').val('');
                $('#sam1').focus();
                return;
            }
        }
        if ($('#sam2').val().length > 0) {
            if (validarDato("sam2", "ValidarDato", "&var1=" + $('#sam2').val() + "&var2=FOL") == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", $('#sam2').val().toUpperCase());
                $('#sam2').val('');
                $('#sam2').focus();
                return;
            }
        }
        if ($('#doc1').val().length > 0) {
            if (validarDato("doc1", "ValidarDato", "&var1=" + $('#doc1').val() + "&var2=DOC") == false) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", $('#doc1').val().toUpperCase());
                $('#doc1').val('');
                $('#doc1').focus();
                return;
            }
        }
        if ($('#doc2').val().length > 0) {
            if (validarDato("doc2", "ValidarDato", "&var1=" + $('#doc2').val() + "&var2=DOC") == false) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", $('#doc2').val().toUpperCase());
                $('#doc2').val('');
                $('#doc2').focus();
                return;
            }
        }
        if ($('#cdoc').val().length > 0) {
            if (validarDato("cdoc", "ValidarDato", "&var1=" + $('#cdoc').val() + "&var2=CLA") == false) {
                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav", $('#cdoc').val().toUpperCase());
                $('#cdoc').val('');
                $('#cdoc').focus();
                return;
            }
        }
       ValidarQuery();
    });
      function ValidarQuery() {
        var radio = "";
        var r = $('[name = "rb"]');
        for (i = 0; i < r.length; i++) {
            if (r[i].checked) {
                radio = r[i].value;
            }
        }
        var CENT = $('#centro').val();
        var SAM1 = $('#sam1').val();
        var SAM2 = $('#sam2').val();
        var DOC1 = $('#doc1').val();
        var DOC2 = $('#doc2').val();
        var FEC1 = $('#fec1').val();
        var FEC2 = $('#fec2').val();
        var CDOC = $('#cdoc').val();
        var acc = "ValidarQuery";
        var param = "&CENT=" + CENT + "&SAM1=" + SAM1 + "&SAM2=" + SAM2 + "&DOC1=" + DOC1 + "&DOC2=" + DOC2;
        var par = param + "&FEC1=" + FEC1 + "&FEC2=" + FEC2 + "&RADI=" + radio + "&CDOC=" + CDOC;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteDMS',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $(location).attr('href','VisualizarReporteDMS.jsp?Accion=CargarTabla'+par);
                }
            }
        });
    }
    $.each(arrm, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    ConsultaFolioDMS();
                });
                break;
            case 1:
                v.click(function () {
                    ConsultaDocumentos();
                });
                break;
            case 2:
                v.click(function () {
                    OpenCalendario('fec1');
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaClaseDocumentos();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaFolioDMS2();
                });
                break;
            case 5:
                v.click(function () {
                    ConsultaDocumentos2();
                });
                break;
            case 6:
                v.click(function () {
                    OpenCalendario('fec2');
                });
                break;
        }
    });
    $.each(arri, function (i, v) {
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
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sam1", "ValidarDato", "&var1=" + v.val() + "&var2=FOL") == true) {
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
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sam2", "ValidarDato", "&var1=" + v.val() + "&var2=FOL") == true) {
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
                    return patron.test(te);
                });
                break;
            case 3:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("doc1", "ValidarDato", "&var1=" + v.val() + "&var2=DOC") == true) {
                                borramsg();
                            } else {
                                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 4:
                v.focus(function () {
                    checarPosiMa(5);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("doc2", "ValidarDato", "&var1=" + v.val() + "&var2=DOC") == true) {
                                borramsg();
                            } else {
                                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 5:
                v.focus(function () {
                    checarPosiMa(2);
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
            case 6:
                v.focus(function () {
                    checarPosiMa(6);
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
            case 7:
                v.focus(function () {
                    checarPosiMa(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("sam2", "ValidarDato", "&var1=" + v.val() + "&var2=CLA") == true) {
                                borramsg();
                            } else {
                                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
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
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#OCULDMS').click(function () {
        ocultarVentana('sam1', 'VentanaModalDMS');
    });
    $('#OCULDMS2').click(function () {
        ocultarVentana('sam2', 'VentanaModalDMS2');
    });
    $('#OCULDOC').click(function () {
        ocultarVentana('doc1', 'VentanaModalDoc');
    });
    $('#OCULDOC2').click(function () {
        ocultarVentana('doc2', 'VentanaModalDoc2');
    });
    $('#OCULClA').click(function () {
        ocultarVentana('cdoc', 'VentanaModalClaseDoc');
    });
});
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#centro').html(data);
        }
    });
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
function ocultarVentana(id, ventana) {
    $('#' + ventana).css('display', 'none');
    $('#' + id).focus();
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
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
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function seleccionar(dato, id) {
    switch (id) {
        case "dms":
            $('#sam1').val(dato);
            ocultarVentana("sam1", "VentanaModalDMS");
            break;
        case "dms2":
            $('#sam2').val(dato);
            ocultarVentana("sam2", "VentanaModalDMS2");
            break;
        case "doc":
            $('#doc1').val(dato);
            ocultarVentana("doc1", "VentanaModalDoc");
            break;
        case "doc2":
            $('#doc2').val(dato);
            ocultarVentana("doc2", "VentanaModalDoc2");
            break;
        case "cla":
            $('#cdoc').val(dato);
            ocultarVentana("cdoc", "VentanaModalClaseDoc");
            break;

    }
}
function ConsultaFolioDMS() {
    var acc = "CargarDMS";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(2, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalDMS', 'handle');
                $('#cargarDatosFolioDMS').html(data);
                fnc('table-scrollDMS', 'fixedYDMS');
                borramsg();
            }
        }
    });
}
function ConsultaFolioDMS2() {
    var acc = "CargarDMS2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(2, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalDMS2', 'handle2');
                $('#cargarDatosFolioDMS2').html(data);
                fnc('table-scrollDMS2', 'fixedYDMS2');
                borramsg();
            }
        }
    });
}
function ConsultaDocumentos() {
    var acc = "CargarDoc";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(2, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalDoc', 'handle3');
                $('#cargarDatosDoc').html(data);
                fnc('table-scrollDoc', 'fixedYDoc');
                borramsg();
            }
        }
    });
}
function ConsultaDocumentos2() {
    var acc = "CargarDoc2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(2, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalDoc2', 'handle4');
                $('#cargarDatosDoc2').html(data);
                fnc('table-scrollDoc2', 'fixedYDoc2');
                borramsg();
            }
        }
    });
}
function ConsultaClaseDocumentos() {
    var acc = "CargarClase";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteDMS',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(2, "images/aceptar.png", "audio/saperror.wav");
            } else {
                MostrarVentanaModal('VentanaModalClaseDoc', 'handle5');
                $('#cargarDatosClaseDoc').html(data);
                fnc('table-scrollClaseDoc', 'fixedYClaseDoc');
                borramsg();
            }
        }
    });
}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionReporteDMS',
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