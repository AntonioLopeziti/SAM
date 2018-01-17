/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//$(document).ready(function () {
//alert("System.err.println(error mdd )");
//});
function bloq() {
    $('#iconmsg').hide();
    $('#guardar').prop('disabled', true);
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
    var sam = $('#sami').val();
    var sam2 = $('#samf').val();
    var sap = $('#sapi').val();
    var ord = $('#ord').val();
    var ord2 = $('#ord2').val();
    var ope = $('#ope').val();
    var ope2 = $('#ope2').val();
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            var valor = elementos[i].value;
        }
    }
    if (centro.length < 1 && sam.length < 1 && sam2.length < 1 && ord.length < 1 && ord2.length < 1 && ope.length < 1 && ope2.length < 1 && sap.length > 1) {
        ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
    } else {
        enviarDatos(sam, sam2, sap, ord, ord2, ope, ope2, centro, valor);   
    }  
    } 
}
function enviarDatos(sam, sam2, sap, ord, ord2, ope, ope2, centro, valor) {
    var enviar = "sam=" + sam + "&sam2=" + sam2 + "&sap=" + sap + "&ord=" + ord + "&ord2=" + ord2 + "&ope=" + ope + "&ope2=" + ope2 + "&centro=" + centro + "&valor=" + valor;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNot',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
         location.href = "VisualizarReporteNotificaciones.jsp";
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
        case "ord1":
            ConsultaFolioORD1();
            break;
        case "ord2":
            ConsultaFolioORD2();
            break;
        case "ope1":
            ConsultaOPE();
            break;
        case "ope2":
            ConsultaFolioOPE2();
            break;

    }
}
function abrirVentana(ventana) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
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
            $('#sami').focus();
            borramsg();
            break;
        case "sam2":
            var ventana3 = $('#VentanaModalSAM2');
            ventana3.hide();
            $('#samf').focus();
            borramsg();
            break;
        case "sap1":
            var ventana4 = $('#VentanaModalSAP1');
            ventana4.hide();
            $('#sapi').focus();
            borramsg();
            break;
        case "ord1":
            var ventana6 = $('#VentanaModalORD1');
            ventana6.hide();
            $('#ord').focus();
            borramsg();
            break;
        case "ord2":
            var ventana7 = $('#VentanaModalORD2');
            ventana7.hide();
            $('#ord2').focus();
            borramsg();
            break;
        case "ope1":
            var ventana8 = $('#VentanaModalOPE1');
            ventana8.hide();
            $('#ope').focus();
            borramsg();
            break;
        case "ope2":
            var ventana9 = $('#VentanaModalOPE2');
            ventana9.hide();
            $('#ope2').focus();
            borramsg();
            break;
    }

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
                var ventana1 = $('#VentanaModalCentro');
                abrirVentana(ventana1);
                $('#cargarDatosOCompras').html(data);
                document.getElementById('table-scrollCenNot').onscroll = function () {
                    document.getElementById('fixedYCenNot').style.top = document.getElementById('table-scrollCenNot').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM1() {
    var acc = "SAMnotificaciones";
    var tipo = "sam1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana2 = $('#VentanaModalSAM1');
                abrirVentana(ventana2);
                $('#cargarDatosFolioSAM1').html(data);
                document.getElementById('table-scroll1SAM1').onscroll = function () {
                    document.getElementById('fixedY1SAM1').style.top = document.getElementById('table-scroll1SAM1').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM2() {
    var acc = "SAMnotificaciones";
    var tipo = "sam2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana3 = $('#VentanaModalSAM2');
                abrirVentana(ventana3);
                $('#cargarDatosFolioSAM2').html(data);
                document.getElementById('table-scroll1SAM2').onscroll = function () {
                    document.getElementById('fixedY1SAM2').style.top = document.getElementById('table-scroll1SAM2').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}

function ConsultaFolioSAP1() {
    var acc = "SAPnotificaciones";
    var tipo = "sap1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana4 = $('#VentanaModalSAP1');
                abrirVentana(ventana4);
                $('#cargarDatosFolioSAP1').html(data);
                document.getElementById('table-scroll1SAP1').onscroll = function () {
                    document.getElementById('fixedY1SAP1').style.top = document.getElementById('table-scroll1SAP1').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaFolioORD1() {
    var acc = "NotificacionesOrden";
    var tipo = "ord1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNotificaciones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana6 = $('#VentanaModalORD1');
                abrirVentana(ventana6);
                $('#cargarDatosFolioORD1').html(data);
                document.getElementById('table-scroll1ORD1').onscroll = function () {
                    document.getElementById('fixedY1ORD1').style.top = document.getElementById('table-scroll1ORD1').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaFolioORD2() {
    var acc = "NotificacionesOrden";
    var tipo = "ord2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNotificaciones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana7 = $('#VentanaModalORD2');
                abrirVentana(ventana7);
                $('#cargarDatosFolioORD2').html(data);
                document.getElementById('table-scroll1ORD2').onscroll = function () {
                    document.getElementById('fixedY1ORD2').style.top = document.getElementById('table-scroll1ORD2').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaFolioOPE2() {
    var acc = "NotificacionesOperacion";
    var tipo = "ope2";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNotificaciones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana9 = $('#VentanaModalOPE2');
                abrirVentana(ventana9);
                $('#cargarDatosFolioOPE2').html(data);
                document.getElementById('table-scroll1OP2').onscroll = function () {
                    document.getElementById('fixedY1OP2').style.top = document.getElementById('table-scroll1OP2').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaOPE() {
    var acc = "NotificacionesOperacion";
    var tipo = "ope1";
    var enviar = "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNotificaciones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var ventana8 = $('#VentanaModalOPE1');
                abrirVentana(ventana8);
                $('#cargarDatosFolioOPE1').html(data);
                document.getElementById('table-scroll1OP1').onscroll = function () {
                    document.getElementById('fixedY1OP1').style.top = document.getElementById('table-scroll1OP1').scrollTop + 'px';
                };
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
function fnc() {
    document.getElementById('table-scrollOCompras').onscroll = function () {
        document.getElementById('fixedYOCompras').style.top = document.getElementById('table-scrollOCompras').scrollTop + 'px';
    };
}
function fnc1() {
    document.getElementById('table-scroll1').onscroll = function () {
        document.getElementById('fixedY1').style.top = document.getElementById('table-scroll1').scrollTop + 'px';
    };
}
function Select(dato, tipo) {
    switch (tipo) {
        case "centro":
            $("#centro").val(dato);
            ocultarVentana(tipo);
            break;
        case "sam1":
            $("#sami").val(dato);
            ocultarVentana(tipo);
            break;
        case "sam2":
            $("#samf").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap1":
            $("#sapi").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap2":
            $("#sapf").val(dato);
            ocultarVentana(tipo);
            break;
        case "ord1":
            $('#ord').val(dato);
            ocultarVentana(tipo);
            break;
        case "ord2":
            $('#ord2').val(dato);
            ocultarVentana(tipo);
            break;
        case "ope1":
            $('#ope').val(dato);
            ocultarVentana(tipo);
            break;
        case "ope2":
            $('#ope2').val(dato);
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
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
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
function validarsam() {
    var acc = "ValidarSAM";
    var sam = $('#sami').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam);
                    $('#sami').val('');
                    $('#sami').focus();
                } else {
                    borramsg();
                }
            }
        });
    }

}

function validarsam2() {
    var acc = "ValidarSAM";
    var sam = $('#samf').val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam);
                    $('#samf').val('');
                    $('#samf').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsap() {
    var acc = "ValidarSAP";
    var sap = $('#sapi').val().toUpperCase();
    var enviar = "&sap=" + sap;

    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap);
                    $('#sapi').val('');
                    $('#sapi').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validarsap2() {
    var acc = "ValidarSAP";
    var sap = $('#sapf').val().toUpperCase();
    var enviar = "&sap=" + sap;

    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap);
                    $('#sapf').val('');
                    $('#sapf').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}

function validaroperacion() {

    var acc = "ValidarOPERACION";
    var ope = $('#ope').val().toUpperCase();
    var enviar = "&ope=" + ope;
    if (ope.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", ope);
                    $('#ope').val('');
                    $('#ope').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validaroperacion2() {
    var acc = "ValidarOPERACION";
    var ope = $('#ope2').val().toUpperCase();
    var enviar = "&ope=" + ope;
    if (ope.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav", ope);
                    $('#ope2').val('');
                    $('#ope2').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarorden() {
    var acc = "ValidarORDEN";
    var ord = $('#ord').val().toUpperCase();
    var enviar = "&ord=" + ord;
    if (ord.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav", ord);
                    $('#ord').val('');
                    $('#ord').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarorden2() {
    var acc = "ValidarORDEN";
    var ord = $('#ord2').val().toUpperCase();
    var enviar = "&ord=" + ord;
    if (ord.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionVisualizarReportesNotificaciones',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav", ord);
                    $('#ord2').val('');
                    $('#ord2').focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function ValidarQuery() {
    var centro = $('#centro').val();
    var sam = $('#sami').val();
    var sam2 = $('#samf').val();
    var sap = $('#sapi').val();
    var ord = $('#ord').val();
    var ord2 = $('#ord2').val();
    var ope = $('#ope').val();
    var ope2 = $('#ope2').val();
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            var valor = elementos[i].value;
        }
    }
    var enviar = "&sam=" + sam + "&sam2=" + sam2 + "&sap=" + sap + "&ord=" + ord + "&ord2=" + ord2 + "&ope=" + ope + "&ope2=" + ope2 + "&centro=" + centro + "&valo=" + valor;
    var acc = "ValidarQuery";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesNotificaciones',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                vali();
            }
        }
    });
}