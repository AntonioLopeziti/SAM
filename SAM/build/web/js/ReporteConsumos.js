/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    startTime();
    $('#iconmsg').hide();
};

function back() {
    window.location.href = "Reportes.jsp";
}
function fin() {
    window.location.href = "Bienvenido.jsp";
}
function Validar() {
    ValidarQuery();
}
function ValidarQuery(){
    var centro = $('#centro').val();
    var sam1 = $('#sam1').val();
    var sam2 = $('#sam2').val();
    var sap1 = $('#sap1').val();
    var sap2 = $('#sap2').val();
    var fecha1 = $('#fecha_inicio').val();
    var fecha2 = $('#fecha_fin').val();
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            var valor = elementos[i].value;
        }
    }
    var enviar = "&centro="+centro+"&sam="+sam1+"&sam2="+sam2+"&sap="+sap1+"&sap2="+sap2+"&fecha1="+fecha1+"&fecha2="+fecha2+"&valor="+valor;
    var acc = "ValidarQuery";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if(data == 0){
                    ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    vali();
                      
                }
            }
        });
}
function vali() {
    var imagen = $('#iconmsg');
    if (imagen.is(":visible")){
     setTimeout(borramsg,2000);    
    } else {
    var centro = $('#centro').val();
    var sam1 = $('#sam1').val();
    var sam2 = $('#sam2').val();
    var sap1 = $('#sap1').val();
    var sap2 = $('#sap2').val();
    var fecha1 = $('#fecha_inicio').val();
    var fecha2 = $('#fecha_fin').val();
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            var valor = elementos[i].value;
        }
    }
    enviarDatos(centro, sam1, sam2, fecha1, sap1, sap2, fecha2, valor);   
    }
}
function enviarDatos(centro, sam1, sam2, fecha1, sap1, sap2, fecha2, valor) {
    var enviar = "centro=" + centro + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2 + "&Error=" + valor;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesEnt',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            location.href = "VisualizarReporteConsumos.jsp";
        }
    });
}
function mostrarVentanaModal(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            ConsultaCentro();
            break;
        case "sam1":
            ConsultaFolioSAM1();
            break;
        case "sam2":
            ConsultaFolioSAM2();
            break;
        case "sap1":
            ConsultaFolioSAP1();
            break;
        case "sap2":
            ConsultaFolioSAP2();
            break;
    }
}
function abrirVentana(ventana) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            var ventana1 = $('#VentanaModalCentro');
            ventana1.hide();
            $('#centro').focus();
            borramsg();
            break;
        case "sam1":
            var ventana2 = $('#VentanaModalSAM1');
            ventana2.hide();
            $('#sam1').focus();
            borramsg();
            break;
        case "sam2":
            var ventana3 = $('#VentanaModalSAM2');
            ventana3.hide();
            $('#sam2').focus();
            borramsg();
            break;
        case "sap1":
            var ventana4 = $('#VentanaModalSAP1');
            ventana4.hide();
            $('#sap1').focus();
            borramsg();
            break;
        case "sap2":
            var ventana5 = $('#VentanaModalSAP2');
            ventana5.hide();
            $('#sap2').focus();
            borramsg();
            break;
    }
}
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}

function ConsultaCentro() {
    var acc = "CentroReserva";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana1 = document.getElementById('VentanaModalCentro');
                abrirVentana(ventana1);
                $('#cargarDatosCen').html(data);
                fnc("table-scrollCenCon", "fixedYCenCon");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM1() {
    var acc = "SAMconsumos";
    var tipo = "sam1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarReportesConsumos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana2 = document.getElementById('VentanaModalSAM1');
                abrirVentana(ventana2);
                $('#cargarDatosFolioSAM1').html(data);
                fnc("table-scrollSAM1", "fixedYSAM1");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM2() {
    var acc = "SAMconsumos";
    var tipo = "sam2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarReportesConsumos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosFolioSAM2').html(data);
                var ventana3 = document.getElementById('VentanaModalSAM2');
                abrirVentana(ventana3);
                fnc("table-scrollSAM2", "fixedYSAM2");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP1() {
    var acc = "SAPconsumos";
    var tipo = "sap1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarReportesConsumos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana4 = document.getElementById('VentanaModalSAP1');
                abrirVentana(ventana4);
                $('#cargarDatosFolioSAP1').html(data);
                fnc("table-scrollSAP1", "fixedYSAP1");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP2() {
    var acc = "SAPconsumos";
    var tipo = "sap2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarReportesConsumos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana5 = document.getElementById('VentanaModalSAP2');
                abrirVentana(ventana5);
                $('#cargarDatosFolioSAP2').html(data);
                fnc("table-scrollSAP2", "fixedYSAP2");
                borramsg();
            }
        }
    });
}
function borramsg() {
    var iconm = $('#iconmsg');
    iconm.hide();
    $('#msg').html("");
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}

function Select(dato, tipo) {
    switch (tipo) {
        case "centro":
            $('#centro').val(dato);
            ocultarVentana(tipo);
            break;
        case "sam1":
            $('#sam1').val(dato);
            ocultarVentana(tipo);
            break;
        case "sam2":
            $('#sam2').val(dato);
            ocultarVentana(tipo);
            break;
        case "sap1":
            $('#sap1').val(dato);
            ocultarVentana(tipo);
            break;
        case "sap2":
            $('#sap2').val(dato);
            ocultarVentana(tipo);
            break;
    }
}

function validarCentro() {
    var acc = "ValidarCentro";
    var centro = $('#centro').val().toUpperCase();
    var enviar = "&centro=" + centro;
    if (centro.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", centro);
                    $('#centro').val('');
                    $('#centro').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsam1() {
    var acc = "ValidarSAM";
    var sam = $('#sam1').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam);
                    $('#sam1').val('');
                    $('#sam1').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsam2() {
    var acc = "ValidarSAM";
    var sam = $('#sam2').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam);
                    $('#sam2').val('');
                    $('#sam2').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsap() {
    var acc = "ValidarSAP";
    var sap = $('#sap1').val().toUpperCase();
    var enviar = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap);
                    $('#sap1').val('');
                    $('#sap1').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsap2() {
    var acc = "ValidarSAP";
    var sap = $('#sap2').val().toUpperCase();
    var enviar = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarReportesConsumos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap);
                    $('#sap2').val('');
                    $('#sap2').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}