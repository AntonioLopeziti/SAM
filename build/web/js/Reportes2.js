
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var centro = $('#centro');
    var sam1 = $('#sami');
    var sam2 = $('#samf');
    var sap1 = $('#sapi');
    var sap2 = $('#sapf');
    var ord1 = $('#ord');
    var ord2 = $('#ord2');
    var ope1 = $('#ope');
    var ope2 = $('#ope2');
    var fe1 = $('#fechainicio');
    var fe2 = $('#fechafin');
    $('#centro');
    $('#sami');
    $('#samf');
    $('#sapi');
    $('#sapf');
    $('#ord');
    $('#ord2');
    $('#ope');
    $('#ope2');
    $('#fechainicio');
    $('#fechafin');
    $('#fecha_inicio');
    $('#fecha_fin');
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    $('#match_A4').hide();
    $('#match_A5').hide();
    $('#match_A6').hide();
    $('#match_A7').hide();
    $('#match_A8').hide();
    $('#match_A9').hide();
    $('#match_A10').hide();
    $('#match_F1').hide();
    $('#match_F2').hide();
    $('#match_F1A').hide();
    $('#match_F2A').hide();
    /*Function mostrar ventana modal SAP*/
    $('#centro').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sami').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#samf').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sapi').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sapf').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').show();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal Numero de Orden*/
    $('#ord').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').show();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal Numero de Operacion*/
    $('#ope').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').show();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal Numero de Orden*/
    $('#ord2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').show();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    /*Function mostrar ventana modal Numero de Operacion*/
    $('#ope2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').show();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    $('#fechainicio').focus(function(){
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').show();
        $('#match_F2').hide();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    $('#fechafin').focus(function(){
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').show();
        $('#match_F1A').hide();
    $('#match_F2A').hide();
    });
    $('#fecha_inicio').focus(function(){
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
        $('#match_F1A').show();
    $('#match_F2A').hide();
    });
    $('#fecha_fin').focus(function(){
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_F1').hide();
        $('#match_F2').show();
        $('#match_F1A').hide();
    $('#match_F2A').show();
    });
/////////// Eventos de los match
////// Match de Centro
    $('#match_A1').click(function () {
        mostrarVentanaModal('centro');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A2').click(function () {
        mostrarVentanaModal('sam1');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSAM1");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A3').click(function () {
        mostrarVentanaModal('sap1');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalSAP1");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A4').click(function () {
        mostrarVentanaModal('sam2');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalSAM2");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A5').click(function () {
        mostrarVentanaModal('sap2');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAP2");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A6').click(function () {
        mostrarVentanaModal('ord1');
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalORD1");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A8').click(function () {
        mostrarVentanaModal('ord2');
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalORD2");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A7').click(function () {
        mostrarVentanaModal('ope1');
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalOPE1");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A9').click(function () {
        mostrarVentanaModal('ope2');
        var theHandle = document.getElementById("handle9");
        var theRoot = document.getElementById("VentanaModalOPE2");
        Drag.init(theHandle, theRoot);
    });
    /*Match folio SAM*/
    $('#matchFolioSAM_SP').click(function () {
        mostrarVentanaModal('sam');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAM");
        Drag.init(theHandle, theRoot);
    });    
    /*Match fecha 1*/
    $('#match_F1').click(function () {
        OpenCalendario("fechainicio");
        $('#fechainicio').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    /*Match fecha 2*/
    $('#match_F2').click(function () {
        OpenCalendario("fechafin");
        $('#fechafin').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    /*Match fecha 1 Avisos*/
    $('#match_F1A').click(function () {
        OpenCalendario("fecha_inicio");
        $('#fecha_inicio').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    /*Match fecha 2 Avisos*/
    $('#match_F2A').click(function () {
        OpenCalendario("fecha_fin");
        $('#fecha_fin').keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
    });
    /// Funcion match Folio sap
    $('#BuscarfoliosapSP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaFolioSAP();
        }
    });
    $('#okSAP').click(function () {
        ConsultaFolioSAP();
    });

    /// Funcion match Folio sam
    $('#BuscarFoliosam').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#okSAM').click(function () {
        ConsultaFolioSAM();
    });

    //////VALIDAR CAMPOS
    centro.blur(function () {
        if (centro.val().length > 0) {
            validarCentro();
        }
    });
    centro.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (centro.val().length > 0) {
                validarCentro();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sam1.blur(function () {
        if (sam1.val().length > 0) {
            validarsam();
        }
    });
    sam1.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (sam1.val().length > 0) {
                validarsam();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sam2.blur(function () {
        if (sam2.val().length > 0) {
            validarsam2();
        }
    });
    sam2.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (sam2.val().length > 0) {
                validarsam2();
            }
        }
        if (tecla == 32) {
            return false;
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sap1.blur(function () {
        if (sap1.val().length > 0) {
            validarsap();
        }
    });
    sap1.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (sap1.val().length > 0) {
                validarsap();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sap2.blur(function () {
        if (sap2.val().length > 0) {
            validarsap2();
        }
    });
    sap2.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (sap2.val().length > 0) {
                validarsap2();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    ord1.blur(function () {
        if (ord1.val().length > 0) {
            validarorden();
        }
    });
    ord1.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (ord1.val().length > 0) {
                validarorden();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    ord2.blur(function () {
        if (ord2.val().length > 0) {
            validarorden2();
        }
    });
    ord2.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (ord2.val().length > 0) {
                validarorden2();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    ope1.blur(function () {
        if (ope1.val().length > 0) {
            validaroperacion();
        }
    });
    ope1.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (ope1.val().length > 0) {
                validaroperacion();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    ope2.blur(function () {
        if (ope2.val().length > 0) {
            validaroperacion2();
        }
    });
    ope2.keypress(function (e) {
        var tecla = (document).all ? e.keycode : e.which;
        if (tecla == 13) {
            if (ope2.val().length > 0) {
                validaroperacion2();
            }
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
});
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