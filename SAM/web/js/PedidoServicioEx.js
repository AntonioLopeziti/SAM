/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    VerificarFolioExcedido();
    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
    startTime();
    $('#CaliServ').css('background-image', 'url(images/necesario.PNG)');
    $('#PlazServ').css('background-image', 'url(images/necesario.PNG)');
    $('#guardar').prop('disabled', true);
    $('#iconmsg').hide();
    $('#match_C1').hide();
    $('#match_C1').click(function () {
        mostrarVentanaModal();
    });
    $("#textlib").click(function () {
        mostrarVentanaModalib();
    });
    $.each([$('#txtPedidoMM'), $('#PosIten')], function (i, v) {

        v.focus(function () {
            if (i == 0) {
                $('#match_C1').show();
            } else {
                $('#match_C1').hide();
            }
        });
    });
    $.each([$('#cerrarmodalPS'), $('#cerrarmodalPS2'), $('#retronafiltroped')], function (i, v) {
        v.click(function () {
            if (i < 2) {
                ocultarVentana();
            } else {
                $('#BuscarParamPedidoMM').css('display', 'block');
                $('#ConsultaTablaClasePedidoMM').css('display', 'none');
            }
        });

    });
    $("#cerrarmodalTL").click(function () {
        ocultartexa();
    });
    $("#cerrarmodalCL").click(function () {
        ocultartexa();
    });
    $("#cerrarmodalOK").click(function () {
        ocultartexaOK();
    });
    $('#CaliServ').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#CaliServ').focus(function () {
        $('#CaliServ').css('background-image', 'none');
    });
    $('#CaliServ').blur(function () {
        this.value = AllowData10($('#CaliServ').val());
        if (this.value.length > 0) {
            $('#CaliServ').css('background-image', 'none');
        } else {
            $('#CaliServ').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#PlazServ').focus(function () {
        $('#PlazServ').css('background-image', 'none');
    });
    $('#PlazServ').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#PlazServ').blur(function () {
        this.value = AllowData10($('#PlazServ').val());
        if (this.value.length > 0) {
            $('#PlazServ').css('background-image', 'none');
        } else {
            $('#PlazServ').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    function AllowData10(val) {
        if (!(val >= 10) || !(val <= 100)) {
            return "";
        }
        var n = val.substr(1, 2);
        if (n != 0) {
            return "";
        }
        return val;
    }
    function ocultartexaOK() {
        $("#VentanaModalTextli").hide();
    }
    function ocultartexa() {
        $("#VentanaModalTextli").hide();
        $("#Textlib_pse").val("");
    }


    $.each([$('#regresar'), $('#finalizar')], function (i, v) {
        v.click(function () {
            $(location).attr('href', 'Bienvenido.jsp');
        });
    });
    $('#cancelar').click(function () {
        location.reload();
    });
    $.each([$('#DocComp'), $('#fechadoc'), $('#numAcMax')], function (i, v) {
        v.keypress(function (e) {
            tecla = (document).all ? e.keyCode : e.which;
            if (tecla == 13) {
                ConsultaPedidoMM();
            }
            if (i == 2) {
                patron = /[0-9]/;
                t = String.fromCharCode(tecla);
                return patron.test(t);
            }
        });
    });
    $('#okPedidoMM').click(function () {
        ConsultaPedidoMM();
    });
    function ConsultaPedidoMM() {
        var acc = "ConsultaMatchPedidoMM";
        var datos = "&DocCom=" + $('#DocComp').val() + "&FechaDoc=" + $('#fechadoc').val() + "&Ctd=" + $('#numAcMax').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPedidoServicio",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    document.getElementById('table-scrollPedidoMM').onscroll = function () {
                        document.getElementById('fixedYPedidoMM').style.top = document.getElementById('table-scrollPedidoMM').scrollTop + 'px';
                    };
                    $('#BuscarParamPedidoMM').css('display', 'none');
                    $('#ConsultaTablaClasePedidoMM').css('display', 'block');
                    $('#cargarDatosPedidoMM').html(data);
                }
            }
        });
    }
    $('#txtPedidoMM').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        t = String.fromCharCode(te);
        return patron.test(t);

    });
    $('#PosIten').keypress(function (e) {
        var te = (document).all ? e.which : e.keyCode;
        if (te == 32) {
            return false;
        }
        patron = /[0-9]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#LeerServicios').click(function () {
        MuestraDatosTabla();
    });
    function MuestraDatosTabla() {
        var ped = $('#txtPedidoMM');
        if (ped.val().length > 0) {
            ValidaPedido(ped.val());
        } else {
            ShowMsg(2, "images/adver.PNG", "audio/saperror.wav");
            CleanTable();
        }
    }
    function ValidaPedido(pedido) {
        var acc = "ValidaPedidoMM";
        var datos = "&DocCom=" + pedido + "&PosItem=" + $('#PosIten').val().trim();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPedidoServicio",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + datos,
            success: function (data) {
                if (data == 1) {
                    ShowMsg(3, "images/adver.PNG", "audio/saperror.wav");
                } else if (data == 2) {
                    ShowMsg(4, "images/adver.PNG", "audio/saperror.wav");
                } else {
                    $('#SecCuerpo').html(data);
                    var lon = $("input[name=checkbo]").length;
                    if (lon == 0) {
                        ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
                    }
                    $('#match_C1').hide();
                    $('#guardar').prop('disabled', false);
                    $("#DobleSection").scroll(function () {
                        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                    });
                    $("#SecCuerpo").scroll(function () {
                        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                    });
                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                }
            }
        });
    }
    $('#guardar').click(function () {
        validarGuarda();
    });
    $('#btnCancelar').click(function () {
        OcultarMensajeFile('VentanaModalMsgAddFile');
        guardardata();
    });
});
function VerificarFolioExcedido() {
    var acc = "VerificarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionPedidoServicio',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            if (data == 1) {
                $('input').prop('disabled', true);
                $('#LeerServicios').prop('disabled', true);
                abrirVentanaAv($('#VentanaModalAv'), "No hay folios SAM disponibles, Consulte a su Administrador");
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
            }
        }
    });
    $('#okAv').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
}
function CleanTable() {
    var acc = "CleanTable";
    $.ajax({
        type: 'GET',
        url: 'PeticionPedidoServicio',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (datas) {
            $('#SecCuerpo').html(datas);
            $('#txtPedidoMM').val('');
            $('#txtPedidoMM').focus();
            $('#PosIten').val('');
            $("#refpse").val('');
            $("#tedcpse").val('');
            $("#texbrpse").val('');
            $("#Textlib_pse").val('');
            $("#CaliServ").val('');
            $("#PlazServ").val('');
            $("#PlazServ").css('background-image', 'url(images/necesario.PNG)');
            $("#CaliServ").css('background-image', 'url(images/necesario.PNG)');
        }
    });
}
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
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalPedidoMM');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#DocComp').val("");
    $('#fechadoc').val("");
    $('#DocComp').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModalPedidoMM");
    Drag.init(theHandle, theRoot);
}
function mostrarVentanaModalib() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalTextli');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handle3");
    var theRoot = document.getElementById("VentanaModalTextli");
    Drag.init(theHandle, theRoot);
}
function abrirVentanaAv(ventana, msg)
{
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#lbAv').html(msg);
    $('#okAv').focus();
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalPedidoMM').hide();
    $('#BuscarParamPedidoMM').css('display', 'block');
    $('#ConsultaTablaClasePedidoMM').css('display', 'none');
    $('#txtPedidoMM').focus();
}

function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function guardarTexarea(n) {
    var Textlib_pse = $("#Textlib_pse").val();
    var PosD = $('#etnumlinea' + n).text();
    var nota2 = Textlib_pse.replace(/'/g, "´");
    var tam = nota2.length;
    var lim = tam / 132;
    var l = Math.ceil(lim);
    var fo = "";
    for (var i = 0; i < l; i++) {
        var d = i * 132;
        no = nota2.substr(d, 132);
        var acc = "GuardaTEXTos";
        var fila = i + 1;
        var enviar = "&fila=" + fila + "&lineas=" + encodeURIComponent(no) + "&foliD=" + PosD;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionPedidoServicio',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data != 0) {
                    fo = data;
                }
            }

        });
    }
    CONSUMIRFOLI();
}

function CONSUMIRFOLI() {
    var confole = 'confole';
    var enviar = "&Action=" + confole;

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionPedidoServicio',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            VerificarFolioExcedido();
            ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav", data);
        }

    });
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
}