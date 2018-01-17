/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    startTime();
    bloq();
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
};

function bloq() {
    $('#iconmsg').hide();
    document.getElementById('guardar').disabled = true;
}
function back() {
    window.location.href = "Reportes.jsp";
}
function fin() {
    window.location.href = "Bienvenido.jsp";
}
function Validar() {
    ValidarQuery();
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
        url: 'PeticionVisualizarReportesContadorEquiposCE',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            location.href = "VisualizarReporteContadorEquipos.jsp";
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
            $('#BuscarParamOCompras_SP').hide();
            $('#ConsultaTablaOCompras').show();
            $('#centro').focus();
            borramsg();
            break;
        case "sam1":
            var ventana2 = $('#VentanaModalSAM1');
            ventana2.hide();
            $('#BuscarFoliosam1').hide();
            $('#ConsultaTablaFolioSAM1').show();
            $('#sam1').focus();
            borramsg();
            break;
        case "sam2":
            var ventana3 = $('#VentanaModalSAM2');
            ventana3.hide();
            $('#BuscarFoliosam2').hide();
            $('#ConsultaTablaFolioSAM2').show();
            $('#sam2').focus();
            borramsg();
            break;
        case "sap1":
            var ventana4 = $('#VentanaModalSAP1');
            ventana4.hide();
            $('#BuscarFoliosap1').hide();
            $('#ConsultaTablaFolioSAP1').show();
            $('#sap1').focus();
            borramsg();
            break;
        case "sap2":
            var ventana5 = $('#VentanaModalSAP2');
            ventana5.hide();
            $('#BuscarFoliosap2').hide();
            $('#ConsultaTablaFolioSAP2').show();
            $('#sap2').focus();
            borramsg();
            break;
    }
}
function ConsultaCentro() {
    var acc = "CentroReserva";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesContadorEquipos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalCentro').show();
                $('#VentanaModalCentro').css({
                    position: 'absolute', left: 510, top: 60
                });
                $('#cargarDatosOCompras').html(data);
                fnc("table-scrollCentro", "fixedYCentro");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM1() {
    var acc = "SAMconsumos";
    var tipo = "sam1";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesContadorEquipos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&tipo=" + tipo + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAM1').show();
                $('#VentanaModalSAM1').css({
                    position: 'absolute', left: 510, top: 60
                });
                $("#cargarDatosFolioSAM1").html(data);
                fnc("table-scrollSAM", "fixedYSAM");
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
        url: 'PeticionVisualizarReportesContadorEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAM2').show();
                $('#VentanaModalSAM2').css({
                    position: 'absolute', left: 510, top: 60
                });
                $("#cargarDatosFolioSAM2").html(data);
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
        url: 'PeticionVisualizarReportesContadorEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAP1').show();
                $('#VentanaModalSAP1').css({
                    position: 'absolute', left: 510, top: 60
                });
                $("#cargarDatosFolioSAP1").html(data);
                fnc("table-scrollSAP", "fixedYSAP");
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
        url: 'PeticionVisualizarReportesContadorEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAP2').show();
                $('#VentanaModalSAP2').css({
                    position: 'absolute', left: 510, top: 60
                });
                $("#cargarDatosFolioSAP2").html(data);
                fnc("table-scrollSAP2", "fixedYSAP2");
                borramsg();
            }
        }
    });
}
function borramsg() {
    var iconm = $('#iconmsg');
    iconm.css('visibility', 'hidden');
    $('#msg').html("");
}
function fnc(scroll, fixe) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
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
            url: 'PeticionVisualizarReportesContadorEquipos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    var okcon = "No se encuentra en el Sistema el centro : " + centro;
                    var iconm = $('#iconmsg');
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                    $('#msg').html(okcon);
                    $('#centro').val("");
                    $('#centro').focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function validarsam1() {
    var url = "";
    var acc = "ValidarSAM";
    var sam = $('#sam1').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesContadorEquipos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sam : " + sam;
                    var iconm = $('#iconmsg');
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                    $('#msg').html(okcon);
                    $('#sam1').val("");
                    $('#sam1').focus();
                } else {
                    borrarmsg();
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
            url: 'PeticionVisualizarReportesContadorEquipos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sam : " + sam;
                    var iconm = $('#iconmsg');
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                    $('#msg').html(okcon);
                    $('#sam2').val("");
                    $('#sam2').focus();
                } else {
                    borrarmsg();
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
            url: 'PeticionVisualizarReportesContadorEquipos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sap : " + sap;
                    var iconm = $('#iconmsg');
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                    $('#msg').html(okcon);
                    $('#sap1').val("");
                    $('#sap1').focus();
                } else {
                    borrarmsg();
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
            url: 'PeticionVisualizarReportesContadorEquipos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sap : " + sap;
                    var iconm = $('#iconmsg');
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                    $('#msg').html(okcon);
                    $('#sap2').val("");
                    $('#sap2').focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function borrarmsg() {
    var iconm = $('#iconmsg');
    iconm.css('visibility', 'hidden');
    $('#msg').val("");
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
    var acc = "ValidarQuery";
    var enviar = "&centro="+centro+"&sam="+sam1+"&sam2="+sam2+"&sap="+sap1+"&sap2="+sap2+"&fecha1="+fecha1+"&fecha2="+fecha2+"&valor="+valor;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesContadorEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) { 
            if (data == 0) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                vali();
            }    
        }     
    });
}