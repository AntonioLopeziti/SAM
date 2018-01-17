/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//******************* REPORTE ORDENES ******************************

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
    var sam = $('#sami').val();
    var sap = $('#sapi').val();
    var fecha1 = $('#fechainicio').val();
    var sam2 = $('#samf').val();
    var sap2 = $('#sapf').val();
    var fecha2 = $('#fechafin').val();
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
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                vali();
                ;
            }
        }
    });
}
function vali() {
    var imagen = $('#iconmsg');
    if (imagen.is(":visible")) {
        setTimeout(borramsg, 2000);
    } else {
        var $sam = $('#sami').val();
        var $sap = $('#sapi').val();
        var $fecha1 = $('#fechainicio').val();
        var $sam2 = $('#samf').val();
        var $sap2 = $('#sapf').val();
        var $fecha2 = $('#fechafin').val();
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
        url: "PeticionVisualizarReportesOrd",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "SAMINI=" + $sam + "&SAPINI=" + $sap + "&FECHAINI=" + $fecha1 + "&SAMFI=" + $sam2 + "&SAPFI=" + $sap2 + "&FECHAFI=" + $fecha2 + "&CENTRO=" + $centro + "&VALOR=" + valor + "&Idioma=" + $idioma,
        success: function (data) {
            $(location).attr('href', 'VisualizarReporteOrdenes.jsp')
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
    switch (tipo) {
        case "centro":
            $('#VentanaModalCentro').hide();
            $("#centro").focus();
            break;
        case "sam1":
            $('#VentanaModalSAM1').hide();
            $("#sami").focus();
            break;
        case "sam2":
            $('#VentanaModalSAM2').hide();
            $("#samf").focus();
            break;
        case "sap1":
            $('#VentanaModalSAP1').hide();
            $("#sapi").focus();
            break;
        case "sap2":
            $('#VentanaModalSAP2').hide();
            $("#sapf").focus();
    }

}
function ConsultaCentro() {
    var acc = "CentroReserva";
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
    var acc = "SAMordenes";
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
    var acc = "SAMordenes";
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
    var acc = "SAPordenes";
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
    var acc = "SAPordenes";
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
function validarCentro() {
    var acc = "ValidarCentroo";
    var centro = $('#centro').val().toUpperCase();
    var enviar = "&centro=" + centro;
    if (centro.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesOrdenes",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav", centro);
                    $("#centro").val("");
                    $("#centro").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarsam() {
    var acc = "ValidarSAM";
    var sam = $('#sami').val();
    var env = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesOrdenes",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam.toUpperCase());
                    $("#sami").val("");
                    $("#sami").focus();
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
    var env = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesOrdenes",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav", sam.toUpperCase());
                    $("#samf").val("");
                    $("#samf").focus();
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
    var env = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesOrdenes",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap.toUpperCase());
                    $("#sapi").val("");
                    $("#sapi").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}
function validarsap2() {
    var acc = "ValidarSAP";
    var sap = $('#sapf').val().toUpperCase();
    var env = "&sap=" + sap;
    if (sap.length > 0) {
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionVisualizarReportesOrdenes",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + env,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", sap.toUpperCase());
                    $("#sapf").val("");
                    $("#sapf").focus();
                } else {
                    borramsg();
                }
            }
        });
    }
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
    }
}

//************ VISUALIZAR REPORTE ORDENES ********************
function retorn() {
    $(location).attr('href', 'ReporteOrdenes.jsp');
}
function back() {
    $(location).attr('href', 'Reportes.jsp');
}
function Vacio() {
    var acc = "ConsultaVacia";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAMDerecho() {
    var acc = "ConsultaSamDerecha";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAMIzquierdo() {
    var acc = "ConsultaSamIzquierda";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAMDOS() {
    var acc = "ConsultaSamDos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAPDerecho() {
    var acc = "ConsultaSapDerecho";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAPIzquierdo() {
    var acc = "ConsultaSapIzquierdo";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function SAPDOS() {
    var acc = "ConsultaSapDos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function FECHAIZQUIERDA() {
    var acc = "ConsultaFechaIzquierda";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function FECHADERECHA() {
    var acc = "ConsultaFechaDerecha";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function FECHADOS() {
    var acc = "ConsultaFechaDos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
        }
    });
}
function Centro() {
    var acc = "Centro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportesOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            $("#SecCuerpo").html(data);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/aceptar.png');
            msgMatchD("ConsEx");
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
