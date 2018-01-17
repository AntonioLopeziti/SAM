/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//////////////////// REPORTE RESERVAS //////////////////////
function back() {
    $(location).attr('href', 'Reportes.jsp');
}
function fin() {
    $(location).attr('href', 'Bienvenido.jsp');
}
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}

function Validar() {
    ValidarQuery();
}
function ValidarQuery() {
    var sam = $('#sam1').val();
    var sap = $('#sap1').val();
    var fecha1 = $('#fecha_inicio').val();
    var sam2 = $('#sam2').val();
    var sap2 = $('#sap2').val();
    var fecha2 = $('#fecha_fin').val();
    var centro = $('#centro').val();
    var elementos = document.getElementsByName("rb");
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            var valor = elementos[i].value;

        }
    }
    var acc = "ValidarQuery";
    var enviar = "&centro=" + centro + "&sam=" + sam + "&sam2=" + sam2 + "&sap=" + sap + "&sap2=" + sap2 + "&fecha1=" + fecha1 + "&fecha2=" + fecha2 + "&valor=" + valor;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
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
function ErrorBusqueda() {
    msgMatch("NoDatos");
    $('#iconmsg').css('visibility', 'visible').attr('src', 'images/aceptar.png');
}
function vali() {
    var imagen = $('#iconmsg');
    if (imagen.is(":visible")) {
        setTimeout(borramsg, 2000);
    } else {

        var $sam = $('#sam1').val();
        var $sap = $('#sap1').val();
        var $fecha1 = $('#fecha_inicio').val();
        var $sam2 = $('#sam2').val();
        var $sap2 = $('#sap2').val();
        var $fecha2 = $('#fecha_fin').val();
        var $centro = $('#centro').val();
        var elementos = document.getElementsByName("rb");
        for (var i = 0; i < elementos.length; i++) {
            if (elementos[i].checked) {
                var valor = elementos[i].value;

            }
        }
        enviarDatos($sam, $sap, $fecha1, $sam2, $sap2, $fecha2, $centro, valor);
    }
}
function enviarDatos($sam, $sap, $fecha1, $sam2, $sap2, $fecha2, $centro, valor) {
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesEnt",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "centro=" + $centro + "&sam1=" + $sam + "&sam2=" + $sam2 + "&sap1=" + $sap + "&sap2=" + $sap2 + "&Fecha1=" + $fecha1 + "&Fecha2=" + $fecha2 + "&Error=" + valor + "&Idioma=" + $idioma,
        success: function (data) {
            $(location).attr('href', 'VisualizarReporteReservas.jsp');
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
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#overlay').remove();
    switch (tipo) {
        case "centro":
            $('#VentanaModalCentro').hide();
            $("#centro").focus();
            break;
        case "sam1":
            $('#VentanaModalSAM1').hide();
            break;
        case "sam2":
            $('#VentanaModalSAM2').hide();
            break;
        case "sap1":
            $('#VentanaModalSAP1').hide();
            break;
        case "sap2":
            $('#VentanaModalSAP2').hide();
    }
}
function ConsultaCentro() {
    var acc = "CentroReservaa";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesReservas",
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
                fnc("table-scrollCentroOrd", "fixedYCenOrd");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM1() {
    var acc = "SAMreserva";
    var tipo = "sam1";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesReservas",
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
                $('#cargarDatosFolioSAM1').html(data);
                fnc("table-scrollSAM1", "fixedYSAM1");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAM2() {
    var acc = "SAMreserva";
    var tipo = "sam2";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesReservas",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&tipo=" + tipo + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAM2').show();
                $('#VentanaModalSAM2').css({
                    position: 'absolute', left: 510, top: 60
                });
                $('#cargarDatosFolioSAM2').html(data);
                fnc("table-scrollSAM2", "fixedYSAM2");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP1() {
    var acc = "SAPreserva";
    var tipo = "sap1";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesReservas",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&tipo=" + tipo + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAP1').show();
                $('#VentanaModalSAP1').css({
                    position: 'absolute', left: 510, top: 60
                });
                $('#cargarDatosFolioSAP1').html(data);
                fnc("table-scrollSAP", "fixedYSAP");
                borramsg();
            }
        }
    });
}
function ConsultaFolioSAP2() {
    var acc = "SAPreserva";
    var tipo = "sap2";
    var $idioma = $('#IdioMat').val();
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionVisualizarReportesReservas",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&tipo=" + tipo + "&Idioma=" + $idioma,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#VentanaModalSAP2').show();
                $('#VentanaModalSAP2').css({
                    position: 'absolute', left: 510, top: 60
                });
                $('#cargarDatosFolioSAP2').html(data);
                fnc("table-scrollSAP2", "fixedYSAP2");
                borramsg();
            }
        }
    });
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function fnc(scroll, fixe) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixe).style.top = document.getElementById(scroll).scrollTop + 'px';
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
            $("#sam1").val(dato);
            ocultarVentana(tipo);
            break;
        case "sam2":
            $("#sam2").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap1":
            $("#sap1").val(dato);
            ocultarVentana(tipo);
            break;
        case "sap2":
            $("#sap2").val(dato);
            ocultarVentana(tipo);
            break;
    }
}
function validarCentro() {
    var acc = "ValidarCentroo";
    var centro = document.getElementById("centro");
    var idioma = document.getElementById("IdioMat");
    var c = centro.value;
    if (c.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&centro=" + c + "&Idioma=" + idioma,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", c.toUpperCase());
                    $("#centro").val("");
                    $("#centro").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsam1() {
    var acc = "ValidarSAMRES";
    var sam = $('#sam1').val().toUpperCase();
    var env = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam.toUpperCase());
                    $("#sam1").val("");
                    $("#sam1").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsam2() {
    var acc = "ValidarSAMRES";
    var sam = $('#sam2').val().toUpperCase();
    var env = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam.toUpperCase());
                    $("#sam2").val("");
                    $("#sam2").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsap() {
    var acc = "ValidarSAPRES";
    var sap = $('#sap1').val().toUpperCase();
    var env = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap.toUpperCase());
                    $("#sap1").val("");
                    $("#sap1").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function validarsap2() {
    var acc = "ValidarSAPRES";
    var sap = $('#sap2').val().toUpperCase();
    var env = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap.toUpperCase());
                    $("#sap2").val("");
                    $("#sap2").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
/////////// VISUALIZAR REPORTE RESERVAS ////////
function retorn() {
    $(location).attr('href', 'ReporteReservas.jsp');
}

//Consulta Vacia
function Vacio() {
    var acc = "ConsultaVacia";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
//Consulta Centro
function Centro() {
    var acc = "ConsultaCentro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
//Consulta SAM1 (Izquierdo)
function SAM1() {
    var acc = "ConsultaSAM1";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
//Consulta SAM2 (Derecho - Rango SAM)
function SAM() {
    var acc = "RangoSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
// Consulta SAP1 (Izquierdo)
function SAP1() {
    var acc = "ConsultaSAP1";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
//Consulta SAP2 (Derecho - Rango SAP)
function SAP() {
    var acc = "RangosSAP";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
//Consulta Fecha1 (Izquierda)
function FECHA1() {
    var acc = "ConsultaFECHA1";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
        }
    });
}
function FECHA() {
    var acc = "RangosFECHAS";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
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
window.onload = function () {
    startTime();
    bloq();
};
function bloq() {
    $("#iconmsg").hide();
    $('#guardar').attr('disabled', 'disabled');
}

function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }
    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 7 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
}