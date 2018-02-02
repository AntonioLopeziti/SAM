/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#MCPedidos').hide();
    $('#txtPedido').focus(function () {
        $('#MCPedidos').show();
    });
    $('#MCPedidos').click(function () {
        $('#DocumVenta').val('');
        $('#ClasePedid').val('');
        $('#numAcMax').val('500');
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalPedidosSD');
        var ancho = 350;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalPedidosSD");
        Drag.init(theHandle, theRoot);
        $('#DocumVenta').focus();

    });
    $('#CerraMCPed').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalPedidosSD').hide();
        $('#BuscarParPedSD').css('display', 'block');
        $('#ConsultaTablaPedidos').css('display', 'none');
        $('#txtPedido').focus();
    });
    $('#CerraMCPed2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalPedidosSD').hide();
        $('#BuscarParPedSD').css('display', 'block');
        $('#ConsultaTablaPedidos').css('display', 'none');
        $('#txtPedido').focus();
    });
    $('#DocumVenta').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 13) {
            BuscarPedMC();
        }
        if (tecla == 8) {
            return true;
        }

        patron = /[0-9a-zA-z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#ClasePedid').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarPedMC();
        }
        patron = /[0-9a-zA-z]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okPedido').click(function () {
        BuscarPedMC();
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (tecla == 13) {
            BuscarPedMC();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#btnocultar').hide();
    $('#divDetailCab').hide();
    $('#btnExped').css({"background": "#007CC0", "color": "#fff"});
    $('#btnmostrar').click(function () {
        $('#btnmostrar').hide();
        $('#btnocultar').show();
        $('#divDetailCab').css('height', '400px');
        $('#contai').css('height', '400px');
        $('#contai').css('margin-bottom', '30px');
        $('#divDetailCab').show();
        AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    });
    $('#btnocultar').click(function () {
        $('#btnmostrar').show();
        $('#btnocultar').hide();
        $('#divDetailCab').hide();
        $('#contai').css('height', '50px');
        $('#contai').css('margin-bottom', '20px');
    });
    var arrtabs = [$('#btnExped'), $('#btnCondi'), $('#btnRep'), $('#btnEstatus')];
    $.each([$('#ContExp'), $('#ContCond'), $('#ContRep'), $('#ContSta')], function (i, v) {
        if (i != 0) {
            v.hide();
        }
        $.each(arrtabs, function (a, f) {
            f.click(function () {
                v.hide();
                if (i == a) {
                    v.show();
                    color(i, f);
                    return;
                }
                switch (a) {
                    case 1:
                        AjustarCabecera('TabHead3', 'TabBody3', 3, 'SecCuerpo3');
                        loadDoubleScroll("DobleSection3", "SecCuerpo3", "DobleContainer3", "TabBody3");
                        break;
                    case 2:
                        AjustarCabecera('TabHead4', 'TabBody4', 3, 'SecCuerpo4');
                        loadDoubleScroll("DobleSection4", "SecCuerpo4", "DobleContainer4", "TabBody4");
                        break;
                }
            });
        });
    });
    function color(i, v) {
        $.each(arrtabs, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrtabs.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
});

function loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
    $("#" + DobleSection).scroll(function () {
        $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
    });
    $("#" + SecCuerpo).scroll(function () {
        $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
    });
    document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function BuscarPedMC() {
    var acc = "ConsultaMCPedido";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarPedidosSD',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Documento=" + $('#DocumVenta').val().trim() + "&Clase=" + $('#ClasePedid').val().trim() + "&Ctd=" + $('#numAcMax').val().trim(),
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosPedidos').html(data);
                $('#BuscarParPedSD').css('display', 'none');
                $('#ConsultaTablaPedidos').css('display', 'block');
                document.getElementById('table-scrollpedido').onscroll = function () {
                    document.getElementById('fixedYPedidoSd').style.top = document.getElementById('table-scrollpedido').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}