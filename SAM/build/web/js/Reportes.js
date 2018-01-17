
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var centro = $('#centro');
    var sam1 = $('#sam1');
    var sam2 = $('#sam2');
    var sap1 = $('#sap1');
    var sap2 = $('#sap2');
    var fe1 = $('#fecha_inicio');
    var fe2 = $('#fecha_fin');
    $('#centro');
    $('#sam1');
    $('#sam2');
    $('#sap1');
    $('#sap2');
    $('#fecha_inicio');
    $('#fecha_fin');
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    $('#match_A4').hide();
    $('#match_A5').hide();
    $('#match_A6').hide();
    $('#match_F1').hide();
    $('#match_F2').hide();
    /*Function mostrar ventana modal SAP*/
    $('#centro').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sam1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAM*/
    $('#sam2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sap1').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    /*Function mostrar ventana modal SAP*/
    $('#sap2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').show();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').hide();
    });
    $('#fecha_inicio').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').show();
        $('#match_F2').hide();
    });
    $('#fecha_fin').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_F1').hide();
        $('#match_F2').show();
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
    /*Match folio SAM*/
    $('#matchFolioSAM_SP').click(function () {
        mostrarVentanaModal('sam');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAM");
        Drag.init(theHandle, theRoot);
    });
    /*Match fecha 1 Reservas*/
    $('#match_F1').click(function () {
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
    /*Match fecha 2 Reservas*/
    $('#match_F2').click(function () {
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
            validarsam1();
        }
    });
    sam1.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsam1();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sam2.blur(function () {
        validarsam2();
    });
    sam2.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsam2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sap1.blur(function () {
        validarsap();
    });
    sap1.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsap();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    sap2.blur(function () {
        validarsap2();
    });
    sap2.keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarsap2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
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