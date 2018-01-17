///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    var a1 = $('#Aviso1');
    var a2 = $('#Aviso2');
    var a3 = $('#Aviso3');
    var a4 = $('#Aviso4');
    var a5 = $('#Aviso5');
    var a6 = $('#Aviso6');
    var a7 = $('#Aviso7');
    var a8 = $('#Aviso8');
    var a9 = $('#Aviso9');
    var a10 = $('#Aviso10');
    var a11 = $('#Aviso11');
    var a12 = $('#Aviso12');
    var a13 = $('#Aviso13');
    var a14 = $('#Aviso14');
    var a15 = $('#Aviso15');
    var a16 = $('#Aviso16');
    var bt1 = $('#btn1');
    var bt2 = $('#btn2');
    var bt3 = $('#btn3');
    var bt4 = $('#btn4');
    var bt5 = $('#btn5');
    var bt6 = $('#btn6');
    var bt7 = $('#btn7');
    var bt8 = $('#btn8');
    var bt9 = $('#btn9');
    var bt10 = $('#btn10');
    var bt11 = $('#btn11');
    var bt12 = $('#btn12');
    var bt13 = $('#btn13');
    var bt14 = $('#btn14');
    var bt15 = $('#btn15');
    var bt16 = $('#btn16');
    var arri = [
        a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16
    ];
    var arrb = [
        bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16
    ];
    $.each(arrb, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalNoti1", "handle", "NNotbus", "NotTxtBus", "numAcMax");
                });
                break;
            case 1:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalSAM", "handle3", "SAMbus", "txtSAM", "numAcMax3");
                });
                break;
            case 2:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalUbicacion", "handle7", "Ubicacbus", "txtUbi", "numAcMax5");
                });
                break;
            case 3:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalEquipo", "handle9", "EquipoBus", "TxtEqui", "numAcMax7");
                });
                break;
            case 4:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalOrden", "handle11", "OrdenBus", "TxtOrd", "numAcMax9");
                });
                break;
            case 5:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalPuesto", "handle13", "PuestoBus", "txtPuesto", "numAcMax11");
                });
                break;
            case 6:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalNoti2", "handle2", "NNotbus2", "NotTxtBus2", "numAcMax2");
                });
                break;
            case 7:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalSAM2", "handle4", "SAMbus2", "txtSAM2", "numAcMax4");
                });
                break;
            case 8:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalUbicacion2", "handle8", "Ubicacbus2", "txtUbi2", "numAcMax6");
                });
                break;
            case 9:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalEquipo2", "handle10", "EquipoBus2", "TxtEqui2", "numAcMax8");
                });
                break;
            case 10:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalOrden2", "handle12", "OrdenBus2", "TxtOrd2", "numAcMax10");
                });
                break;
            case 11:
                v.click(function () {
                    mostrarVentanaModal("VentanaModalPuesto2", "handle14", "PuestoBus2", "txtPuesto2", "numAcMax12");
                });
                break;
            case 12:
                v.click(function () {
                    ConsultarClase();
                });
                break;
            case 13:
                v.click(function () {
                    ConsultarClase2();
                });
                break;
            case 14:
                v.click(function () {
                    OpenCalendario("Aviso7");
                });
                break;
            case 15:
                v.click(function () {
                    OpenCalendario("Aviso14");
                });
                break;
        }
    });
    $.each(arri, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    posicionm(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso1", "ValidarNotificacion", "&Notificacion=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 1:
                v.focus(function () {
                    posicionm(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso2", "ValidarSAM", "&SAM=" + v.val()) == true) {
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
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    posicionm(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso3", "ValidarUbicacion", "&Ubicacion=" + v.val()) == true) {
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
                    patron = /[-0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 3:
                v.focus(function () {
                    posicionm(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso4", "ValidarEquipo", "&Equipo=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[-0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 4:
                v.focus(function () {
                    posicionm(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso5", "ValidarOrden", "&Orden=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 5:
                v.focus(function () {
                    posicionm(5);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso6", "ValidarPuesto", "&Puesto=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 6:
                v.focus(function () {
                    posicionm(14);
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
                    posicionm(6);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso8", "ValidarNotificacion", "&Notificacion=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 8:
                v.focus(function () {
                    posicionm(7);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso9", "ValidarSAM", "&SAM=" + v.val()) == true) {
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
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 9:
                v.focus(function () {
                    posicionm(8);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso10", "ValidarUbicacion", "&Ubicacion=" + v.val()) == true) {
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
                    patron = /[-0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 10:
                v.focus(function () {
                    posicionm(9);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso11", "ValidarEquipo", "&Equipo=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[-0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 11:
                v.focus(function () {
                    posicionm(10);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso12", "ValidarOrden", "&Orden=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 12:
                v.focus(function () {
                    posicionm(11);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso13", "ValidarPuesto", "&Puesto=" + v.val()) == true) {
                                borramsg();
                            } else {
                                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 13:
                v.focus(function () {
                    posicionm(15);
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
            case 14:
                v.focus(function () {
                    posicionm(12);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso15", "ValidarClase", "&Clase=" + v.val()) == true) {
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
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 15:
                v.focus(function () {
                    posicionm(13);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("Aviso16", "ValidarClase", "&Clase=" + v.val()) == true) {
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
                    patron = /[0-9a-zA-Z]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
        }
    });
    function posicionm(index) {
        $.each(arrb, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#ejecutar').click(function () {
        if (a1.val().length > 0) {
            if (validarDato("Aviso1", "ValidarNotificacion", "&Notificacion=" + a1.val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                a1.val('');
                a1.focus();
                return;
            }
        }
        if (a2.val().length > 0) {
            if (validarDato("Aviso2", "ValidarSAM", "&SAM=" + a2.val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                a2.val('');
                a2.focus();
                return;
            }
        }
        if (a15.val().length > 0) {
            if (validarDato("Aviso15", "ValidarClase", "&Clase=" + a15.val()) == false) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                a15.val('');
                a15.focus();
                return;
            }
        }
        if (a3.val().length > 0) {
            if (validarDato("Aviso3", "ValidarUbicacion", "&Ubicacion=" + a3.val()) == false) {
                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                a3.val('');
                a3.focus();
                return;
            }
        }
        if (a4.val().length > 0) {
            if (validarDato("Aviso4", "ValidarEquipo", "&Equipo=" + a4.val()) == false) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                a4.val('');
                a4.focus();
                return;
            }
        }
        if (a5.val().length > 0) {
            if (validarDato("Aviso5", "ValidarOrden", "&Orden=" + a5.val()) == false) {
                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
                a5.val('');
                a5.focus();
                return;
            }
        }
        if (a6.val().length > 0) {
            if (validarDato("Aviso6", "ValidarPuesto", "&Puesto=" + a6.val()) == false) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                a6.val('');
                a6.focus();
                return;
            }
        }
        if (a8.val().length > 0) {
            if (validarDato("Aviso8", "ValidarNotificacion", "&Notificacion=" + a8.val()) == false) {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                a8.val('');
                a8.focus();
                return;
            }
        }
        if (a9.val().length > 0) {
            if (validarDato("Aviso9", "ValidarSAM", "&SAM=" + a9.val()) == false) {
                ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                a9.val('');
                a9.focus();
                return;
            }
        }
        if (a16.val().length > 0) {
            if (validarDato("Aviso16", "ValidarClase", "&Clase=" + a16.val()) == false) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                a16.val('');
                a16.focus();
                return;
            }
        }
        if (a10.val().length > 0) {
            if (validarDato("Aviso10", "ValidarUbicacion", "&Ubicacion=" + a10.val()) == false) {
                ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                a10.val('');
                a10.focus();
                return;
            }
        }
        if (a11.val().length > 0) {
            if (validarDato("Aviso11", "ValidarEquipo", "&Equipo=" + a11.val()) == false) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                a11.val('');
                a11.focus();
                return;
            }
        }
        if (a12.val().length > 0) {
            if (validarDato("Aviso12", "ValidarOrden", "&Orden=" + a12.val()) == false) {
                ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
                a12.val('');
                a12.focus();
                return;
            }
        }
        if (a13.val().length > 0) {
            if (validarDato("Aviso13", "ValidarPuesto", "&Puesto=" + a13.val()) == false) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                a13.val('');
                a13.focus();
                return;
            }
        }
        var pen = $('#pend');
        var pos = $('#posp');
        var tra = $('#trat');
        var con = $('#conc');
        if (!(pen.prop('checked') || pos.prop('checked') || tra.prop('checked') || con.prop('checked'))) {
            ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            ValidarQuery();
        }
    });
    function ValidarQuery() {
        var acc = "ValidarQuery";
        var pend = "";
        var posp = "";
        var trat = "";
        var conc = "";
        if ($('#pend').prop('checked')) {
            pend = $('#pend').val();
        }
        if ($('#posp').prop('checked')) {
            posp = $('#posp').val();
        }
        if ($('#trat').prop('checked')) {
            trat = $('#trat').val();
        }
        if ($('#conc').prop('checked')) {
            conc = $('#conc').val();
        }
        var par = "&N1=" + a1.val() + "&N2=" + a8.val() + "&S1=" + a2.val() + "&S2=" + a9.val() + "&C1=" + a15.val() + "&C2=" + a16.val() +
                "&U1=" + a3.val() + "&U2=" + a10.val() + "&E1=" + a4.val() + "&E2=" + a11.val() + "&O1=" + a5.val() + "&O2=" + a12.val() +
                "&P1=" + a6.val() + "&P2=" + a13.val() + "&F1=" + a7.val() + "&F2=" + a14.val() + "&PEND=" + pend + "&POSP=" + posp +
                "&TRAT=" + trat + "&CONC=" + conc;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $(location).attr('href', 'listasdeavisos.jsp?Accion=CargarTabla' + par);
                }
            }
        });
    }
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    ////////// AVISOS SAP
    $('#CerrarNoti').click(function () {
        ocultarVentana('VentanaModalNoti1', 'BuscarParamNot1', 'ConsultaTablaNot1', 'Aviso1');
    });
    $('#CerrarNoti2').click(function () {
        ocultarVentana('VentanaModalNoti1', 'BuscarParamNot1', 'ConsultaTablaNot1', 'Aviso1');
    });
    $('#mosnot').click(function () {
        $('#BuscarParamNot1').show();
        $('#ConsultaTablaNot1').hide();
    });
    $('#NNotbus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#NotTxtBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okNotificacion').click(function () {
        ConsultarNotificacion();
    });
    //////////////////////////
    $('#CerrarNotif2').click(function () {
        ocultarVentana('VentanaModalNoti2', 'BuscarParamNot2', 'ConsultaTablaNot2', 'Aviso8');
    });
    $('#CerrarNoti22').click(function () {
        ocultarVentana('VentanaModalNoti2', 'BuscarParamNot2', 'ConsultaTablaNot2', 'Aviso8');
    });
    $('#mosnot2').click(function () {
        $('#BuscarParamNot2').show();
        $('#ConsultaTablaNot2').hide();
    });
    $('#NNotbus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#NotTxtBus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarNotificacion2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okNotificacion2').click(function () {
        ConsultarNotificacion2();
    });
    //////////////////////////
    $('#CerrarSAM').click(function () {
        ocultarVentana('VentanaModalSAM', 'BuscarParamSAM', 'ConsultaTablaSAM', 'Aviso2');
    });
    $('#CerrarSAMM').click(function () {
        ocultarVentana('VentanaModalSAM', 'BuscarParamSAM', 'ConsultaTablaSAM', 'Aviso2');
    });
    $('#retsam').click(function () {
        $('#BuscarParamSAM').show();
        $('#ConsultaTablaSAM').hide();
    });
    $('#SAMbus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtSAM').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okSAM').click(function () {
        ConsultarSAM();
    });
    //////////////////////////
    $('#CerrarSAM2').click(function () {
        ocultarVentana('VentanaModalSAM2', 'BuscarParamSAM2', 'ConsultaTablaSAM2', 'Aviso9');
    });
    $('#CerrarSAMM').click(function () {
        ocultarVentana('VentanaModalSAM2', 'BuscarParamSAM2', 'ConsultaTablaSAM2', 'Aviso9');
    });
    $('#retsam2').click(function () {
        $('#BuscarParamSAM2').show();
        $('#ConsultaTablaSAM2').hide();
    });
    $('#SAMbus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtSAM2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax4').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarSAM2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okSAM2').click(function () {
        ConsultarSAM2();
    });
    ////////////////////////
    $('#CerrarClase').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalClase').hide();
        $('#Aviso15').focus();
    });
    $('#CerrarClase2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalClase2').hide();
        $('#Aviso16').focus();
    });
    //////////////////////////
    $('#CerrarUbic').click(function () {
        ocultarVentana('VentanaModalUbicacion', 'BuscarParamUbicacion', 'ConsultaTablaUbicacion', 'Aviso3');
    });
    $('#CerrarUbicc').click(function () {
        ocultarVentana('VentanaModalUbicacion', 'BuscarParamUbicacion', 'ConsultaTablaUbicacion', 'Aviso3');
    });
    $('#retubi').click(function () {
        $('#BuscarParamUbicacion').show();
        $('#ConsultaTablaUbicacion').hide();
    });
    $('#Ubicacbus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtUbi').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax5').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okUbi').click(function () {
        ConsultarUbicacion();
    });
    //////////////////////////
    $('#CerrarUbic2').click(function () {
        ocultarVentana('VentanaModalUbicacion2', 'BuscarParamUbicacion2', 'ConsultaTablaUbicacion2', 'Aviso10');
    });
    $('#CerrarUbicc2').click(function () {
        ocultarVentana('VentanaModalUbicacion2', 'BuscarParamUbicacion2', 'ConsultaTablaUbicacion2', 'Aviso10');
    });
    $('#retubi2').click(function () {
        $('#BuscarParamUbicacion2').show();
        $('#ConsultaTablaUbicacion2').hide();
    });
    $('#Ubicacbus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtUbi2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax6').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarUbicacion2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okUbi2').click(function () {
        ConsultarUbicacion2();
    });
    //////////////////////////
    $('#CerrarEquipo').click(function () {
        ocultarVentana('VentanaModalEquipo', 'BuscarParamEquipo', 'ConsultaTablaEquipo', 'Aviso4');
    });
    $('#CerrarEquipoo').click(function () {
        ocultarVentana('VentanaModalEquipo', 'BuscarParamEquipo', 'ConsultaTablaEquipo', 'Aviso4');
    });
    $('#retequ').click(function () {
        $('#BuscarParamEquipo').show();
        $('#ConsultaTablaEquipo').hide();
    });
    $('#EquipoBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#TxtEqui').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax7').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okEquipo').click(function () {
        ConsultarEquipo();
    });
    //////////////////////////
    $('#CerrarEquipo2').click(function () {
        ocultarVentana('VentanaModalEquipo2', 'BuscarParamEquipo2', 'ConsultaTablaEquipo2', 'Aviso11');
    });
    $('#CerrarEquipoo2').click(function () {
        ocultarVentana('VentanaModalEquipo2', 'BuscarParamEquipo2', 'ConsultaTablaEquipo2', 'Aviso11');
    });
    $('#retequ2').click(function () {
        $('#BuscarParamEquipo2').show();
        $('#ConsultaTablaEquipo2').hide();
    });
    $('#EquipoBus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#TxtEqui2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax8').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarEquipo2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okEquipo2').click(function () {
        ConsultarEquipo2();
    });
    //////////////////////////
    $('#CerrarOrden').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParamOrden', 'ConsultaTablaOrden', 'Aviso5');
    });
    $('#CerrarOrdenn').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParamOrden', 'ConsultaTablaOrden', 'Aviso5');
    });
    $('#retorde').click(function () {
        $('#BuscarParamOrden').show();
        $('#ConsultaTablaOrden').hide();
    });
    $('#OrdenBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#TxtOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax9').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okOrden').click(function () {
        ConsultarOrden();
    });
    //////////////////////////
    $('#CerrarOrden2').click(function () {
        ocultarVentana('VentanaModalOrden2', 'BuscarParamOrden2', 'ConsultaTablaOrden2', 'Aviso12');
    });
    $('#CerrarOrdenn').click(function () {
        ocultarVentana('VentanaModalOrden2', 'BuscarParamOrden2', 'ConsultaTablaOrden2', 'Aviso12');
    });
    $('#retorde2').click(function () {
        $('#BuscarParamOrden2').show();
        $('#ConsultaTablaOrden2').hide();
    });
    $('#OrdenBus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#TxtOrd2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax10').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarOrden2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okOrden2').click(function () {
        ConsultarOrden2();
    });
    //////////////////////////
    $('#CerrarPuesto').click(function () {
        ocultarVentana('VentanaModalPuesto', 'BuscarParamPuesto', 'ConsultaTablaPuesto', 'Aviso6');
    });
    $('#CerrarPuestoo').click(function () {
        ocultarVentana('VentanaModalPuesto', 'BuscarParamPuesto', 'ConsultaTablaPuesto', 'Aviso6');
    });
    $('#retpto').click(function () {
        $('#BuscarParamPuesto').show();
        $('#ConsultaTablaPuesto').hide();
    });
    $('#PuestoBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtPuesto').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax11').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okPuesto').click(function () {
        ConsultarPuesto();
    });
    //////////////////////////
    $('#CerrarPuesto2').click(function () {
        ocultarVentana('VentanaModalPuesto2', 'BuscarParamPuesto2', 'ConsultaTablaPuesto2', 'Aviso13');
    });
    $('#CerrarPuestoo2').click(function () {
        ocultarVentana('VentanaModalPuesto2', 'BuscarParamPuesto2', 'ConsultaTablaPuesto2', 'Aviso13');
    });
    $('#retpto2').click(function () {
        $('#BuscarParamPuesto2').show();
        $('#ConsultaTablaPuesto2').hide();
    });
    $('#PuestoBus2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtPuesto2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto2();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax12').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarPuesto2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okPuesto2').click(function () {
        ConsultarPuesto2();
    });
    function ConsultarNotificacion() {
        var acc = "ConsultarNotificacion";
        var not = $('#NNotbus').val();
        var Dno = $('#NotTxtBus').val();
        var cant = $('#numAcMax').val();
        var datos = "&Notificacion=" + not + "&TNotificacion=" + Dno + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamNot1').hide();
                    $('#ConsultaTablaNot1').show();
                    $('#cuerpoDatosNotificaciones1').html(data);
                    fnc('table-scrollNot1', 'fixedYNot1');
                    borramsg();
                }
            }
        });
    }
    function ConsultarNotificacion2() {
        var acc = "ConsultarNotificacion2";
        var not = $('#NNotbus2').val();
        var Dno = $('#NotTxtBus2').val();
        var cant = $('#numAcMax2').val();
        var datos = "&Notificacion=" + not + "&TNotificacion=" + Dno + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamNot2').hide();
                    $('#ConsultaTablaNot2').show();
                    $('#cuerpoDatosNotificaciones2').html(data);
                    fnc('table-scrollNot2', 'fixedYNot2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarSAM() {
        var acc = "ConsultarSAM";
        var v1 = $('#SAMbus').val();
        var v2 = $('#txtSAM').val();
        var cant = $('#numAcMax3').val();
        var datos = "&SAM=" + v1 + "&TSAM=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamSAM').hide();
                    $('#ConsultaTablaSAM').show();
                    $('#cuerpoDatosSAM').html(data);
                    fnc('table-scrollSAM', 'fixedYSAM');
                    borramsg();
                }
            }
        });
    }
    function ConsultarSAM2() {
        var acc = "ConsultarSAM2";
        var v1 = $('#SAMbus2').val();
        var v2 = $('#txtSAM2').val();
        var cant = $('#numAcMax4').val();
        var datos = "&SAM=" + v1 + "&TSAM=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamSAM2').hide();
                    $('#ConsultaTablaSAM2').show();
                    $('#cuerpoDatosSAM2').html(data);
                    fnc('table-scrollSAM2', 'fixedYSAM2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarClase() {
        var acc = "ConsultarClase";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapsnd05.wav";
                    BE.play();
                    var ventana = $('#VentanaModalClase');
                    var ancho = 350;
                    var alto = 650;
                    var x = (screen.width / 2) - (ancho / 2);
                    var y = (screen.height / 2) - (alto / 2);
                    ventana.css({top: y + "px", left: x + "px"});
                    ventana.css('display', 'block');
                    borramsg();
                    var theHandle = document.getElementById("handle5");
                    var theRoot = document.getElementById("VentanaModalClase");
                    Drag.init(theHandle, theRoot);
                    $('#cuerpoDatosClase').html(data);
                    fnc('table-scrollClase', 'fixedYClase');
                }
            }
        });
    }
    function ConsultarClase2() {
        var acc = "ConsultarClase2";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapsnd05.wav";
                    BE.play();
                    var ventana = $('#VentanaModalClase2');
                    var ancho = 350;
                    var alto = 650;
                    var x = (screen.width / 2) - (ancho / 2);
                    var y = (screen.height / 2) - (alto / 2);
                    ventana.css({top: y + "px", left: x + "px"});
                    ventana.css('display', 'block');
                    borramsg();
                    var theHandle = document.getElementById("handle6");
                    var theRoot = document.getElementById("VentanaModalClase2");
                    Drag.init(theHandle, theRoot);
                    $('#cuerpoDatosClase2').html(data);
                    fnc('table-scrollClase2', 'fixedYClase2');
                }
            }
        });
    }
    function ConsultarUbicacion() {
        var acc = "ConsultarUbicacion";
        var v1 = $('#Ubicacbus').val();
        var v2 = $('#txtUbi').val();
        var cant = $('#numAcMax5').val();
        var datos = "&Ubicacion=" + v1 + "&TUbica=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamUbicacion').hide();
                    $('#ConsultaTablaUbicacion').show();
                    $('#cuerpoDatosUbic').html(data);
                    fnc('table-scrollUbic', 'fixedYUbic');
                    borramsg();
                }
            }
        });
    }
    function ConsultarUbicacion2() {
        var acc = "ConsultarUbicacion2";
        var v1 = $('#Ubicacbus2').val();
        var v2 = $('#txtUbi2').val();
        var cant = $('#numAcMax6').val();
        var datos = "&Ubicacion=" + v1 + "&TUbica=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamUbicacion2').hide();
                    $('#ConsultaTablaUbicacion2').show();
                    $('#cuerpoDatosUbic2').html(data);
                    fnc('table-scrollUbic2', 'fixedYUbic2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarEquipo() {
        var acc = "ConsultarEquipo";
        var v1 = $('#EquipoBus').val();
        var v2 = $('#TxtEqui').val();
        var cant = $('#numAcMax7').val();
        var datos = "&Equipo=" + v1 + "&DEqui=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamEquipo').hide();
                    $('#ConsultaTablaEquipo').show();
                    $('#cuerpoDatosEquipo').html(data);
                    fnc('table-scrollEquipo', 'fixedYEquipo');
                    borramsg();
                }
            }
        });
    }
    function ConsultarEquipo2() {
        var acc = "ConsultarEquipo2";
        var v1 = $('#EquipoBus2').val();
        var v2 = $('#TxtEqui2').val();
        var cant = $('#numAcMax8').val();
        var datos = "&Equipo=" + v1 + "&DEqui=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamEquipo2').hide();
                    $('#ConsultaTablaEquipo2').show();
                    $('#cuerpoDatosEquipo2').html(data);
                    fnc('table-scrollEquipo2', 'fixedYEquipo2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarOrden() {
        var acc = "ConsultarOrden";
        var v1 = $('#OrdenBus').val();
        var v2 = $('#TxtOrd').val();
        var cant = $('#numAcMax9').val();
        var datos = "&Orden=" + v1 + "&DOrden=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamOrden').hide();
                    $('#ConsultaTablaOrden').show();
                    $('#cuerpoDatosOrden').html(data);
                    fnc('table-scrollOrden', 'fixedYOrden');
                    borramsg();
                }
            }
        });
    }
    function ConsultarOrden2() {
        var acc = "ConsultarOrden2";
        var v1 = $('#OrdenBus2').val();
        var v2 = $('#TxtOrd2').val();
        var cant = $('#numAcMax10').val();
        var datos = "&Orden=" + v1 + "&DOrden=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamOrden2').hide();
                    $('#ConsultaTablaOrden2').show();
                    $('#cuerpoDatosOrden2').html(data);
                    fnc('table-scrollOrden2', 'fixedYOrden2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarPuesto() {
        var acc = "ConsultarPuesto";
        var v1 = $('#PuestoBus').val();
        var v2 = $('#txtPuesto').val();
        var cant = $('#numAcMax11').val();
        var datos = "&Puesto=" + v1 + "&DPuesto=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamPuesto').hide();
                    $('#ConsultaTablaPuesto').show();
                    $('#cuerpoDatosPuesto').html(data);
                    fnc('table-scrollPuesto', 'fixedYPuesto');
                    borramsg();
                }
            }
        });
    }
    function ConsultarPuesto2() {
        var acc = "ConsultarPuesto2";
        var v1 = $('#PuestoBus2').val();
        var v2 = $('#txtPuesto2').val();
        var cant = $('#numAcMax12').val();
        var datos = "&Puesto=" + v1 + "&DPuesto=" + v2 + "&Cantidad=" + cant;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionMonitorAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamPuesto2').hide();
                    $('#ConsultaTablaPuesto2').show();
                    $('#cuerpoDatosPuesto2').html(data);
                    fnc('table-scrollPuesto2', 'fixedYPuesto2');
                    borramsg();
                }
            }
        });
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
function mostrarVentanaModal(id, handle, tipo, des, aci)
{
    $('#' + aci).val('500');
    $('#' + des).val('');
    $('#' + tipo).val('');
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
    $('#' + tipo).focus();
}
function ocultarVentana(id, bp, ct, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + bp).css('display', 'block');
    $('#' + ct).css('display', 'none');
    $('#' + obj).focus();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function seleccionar(tipo, dato) {
    switch (tipo) {
        case "Notificacion":
            $('#Aviso1').val(dato);
            ocultarVentana("VentanaModalNoti1", "BuscarParamNot1", "ConsultaTablaNot1", "Aviso1");
            break;
        case "Notificacion2":
            $('#Aviso8').val(dato);
            ocultarVentana("VentanaModalNoti2", "BuscarParamNot2", "ConsultaTablaNot2", "Aviso8");
            break;
        case "SAM":
            $('#Aviso2').val(dato);
            ocultarVentana("VentanaModalSAM", "BuscarParamSAM", "ConsultaTablaSAM", "Aviso2");
            break;
        case "SAM2":
            $('#Aviso9').val(dato);
            ocultarVentana("VentanaModalSAM2", "BuscarParamSAM2", "ConsultaTablaSAM2", "Aviso9");
            break;
        case "Clase":
            $('#Aviso15').val(dato);
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#VentanaModalClase').hide();
            $('#Aviso15').focus();
            break;
        case "Clase2":
            $('#Aviso16').val(dato);
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#VentanaModalClase2').hide();
            $('#Aviso16').focus();
            break;
        case "Ubicacion":
            $('#Aviso3').val(dato);
            ocultarVentana("VentanaModalUbicacion", "BuscarParamUbicacion", "ConsultaTablaUbicacion", "Aviso3");
            break;
        case "Ubicacion2":
            $('#Aviso10').val(dato);
            ocultarVentana("VentanaModalUbicacion2", "BuscarParamUbicacion2", "ConsultaTablaUbicacion2", "Aviso10");
            break;
        case "Equipo":
            $('#Aviso4').val(dato);
            ocultarVentana("VentanaModalEquipo", "BuscarParamEquipo", "ConsultaTablaEquipo", "Aviso4");
            break;
        case "Equipo2":
            $('#Aviso11').val(dato);
            ocultarVentana("VentanaModalEquipo2", "BuscarParamEquipo2", "ConsultaTablaEquipo2", "Aviso11");
            break;
        case "Puesto":
            $('#Aviso6').val(dato);
            ocultarVentana("VentanaModalPuesto", "BuscarParamPuesto", "ConsultaTablaPuesto", "Aviso6");
            break;
        case "Puesto2":
            $('#Aviso13').val(dato);
            ocultarVentana("VentanaModalPuesto2", "BuscarParamPuesto2", "ConsultaTablaPuesto2", "Aviso13");
            break;
    }
}
function seleccionarOrden(sap, sam, t, id) {
    if (sap.length > 0) {
        $('#' + id).val(sap);
    } else {
        $('#' + id).val(sam);
    }
    switch (t) {
        case "Orden":
            ocultarVentana("VentanaModalOrden", "BuscarParamOrden", "ConsultaTablaOrden", id);
            break;
        case "Orden2":
            ocultarVentana("VentanaModalOrden2", "BuscarParamOrden2", "ConsultaTablaOrden2", id);
            break;
    }

}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionMonitorAvisos',
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
function OpenCalendario(id) {
    $("#"+id).focus();
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