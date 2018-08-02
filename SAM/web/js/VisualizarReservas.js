/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    CargarUsarioBusqueda();
    AjustarCabecera('TabHead', 'TabBody', 2, 'SecCuerpo');
    $('#Match_Reser').hide();
    $('#iconmsg').hide();
    $('#guardaOFF').prop('disabled', true);
    $('#NReserva').focus(function () {
        $('#Match_Reser').show();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    //// EVENTOS MC
    $('#Match_Reser').click(function () {
        mostrarVentanaModal();
    });
    $('#CerraMCR').click(function () {
        ocultarVentana();
    });
    $('#CerraMCR2').click(function () {
        ocultarVentana();
    });
    $.each([$('#ReservaBus'), $('#numAcMax'), $('#OkReserva'), $('#Usubus')], function (i, v) {

        if (i == 0) {
            v.keypress(function (e) {
                var tecla = (document).all ? e.keyCode : e.which;
                if (tecla == 13) {
                    ConsultaMCReserva();
                }
                if (tecla == 32) {
                    return false;
                }
                patron = /[a-zA-Z0-9]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            });
        }
        if (i == 1) {
            v.keypress(function (e) {
                var tecla = (document).all ? e.keyCode : e.which;
                if (tecla == 13) {
                    ConsultaMCReserva();
                }
                if (tecla == 32) {
                    return false;
                }
                patron = /[0-9]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            });
        }
        if (i == 2) {
            v.click(function () {
                ConsultaMCReserva();
            });
        }
        if (i == 3) {
            v.keypress(function (e) {
                var tecla = (document).all ? e.keyCode : e.which;
                if (tecla == 13) {
                    ConsultaMCReserva();
                }
                if (tecla == 32) {
                    return false;
                }
                patron = /[a-zA-Z0-9]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            });
        }
    });
    function ConsultaMCReserva() {
        var acc = "ConsultarReserva";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&NReserva=" + $('#ReservaBus').val() + "&Cantidad=" + $('#numAcMax').val() + "&UsuarioReserva=" + $('#Usubus').val(),
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    $('#CargarDatos').html(data);
                    $('#BuscarParamReserva').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    document.getElementById('table-scroll').onscroll = function () {
                        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                    };
                }
            }
        });
    }
    $('#retorMCR').click(function () {
        $('#BuscarParamReserva').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });

    $('#aceptar').click(function () {
        validarReserva();
    });
    $('#NReserva').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarReserva();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    var iconm = $('#ICONAD');
    function validarReserva() {
        iconm.css('visibility', 'hidden');
        cargartablaReserva('', '');
        var NRes = $('#NReserva');
        if (NRes.val().length == 0) {
            NRes.focus();
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            $('input').val('');
        } else {
            var acc = "ValidarReserva";
            $.ajax({
                async: false,
                type: "GET",
                url: "peticionVisualizarReservas",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&NReserva=" + NRes.val(),
                success: function (data) {
                    var n = new Array();
                    n = data.split(",");
                    var SAP = n[0];
                    var SAM = n[1];
                    var nr;
                    if (SAP == 1) {
                        nr = "P";
                    } else if (SAM == 1) {
                        nr = "M";
                    } else {
                        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav", NRes.val());
                        $('input').val('');
                    }
                    cargartablaReserva(NRes.val(), nr);
                    cargarDatosReserv(NRes.val(), nr);
                }
            });
        }
    }
    function cargarDatosReserv(NRes, tipo) {
        var acc = "CargarCabecera";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: "json",
            url: "peticionVisualizarReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&NReserva=" + NRes + "&Tipo=" + tipo,
            success: function (data) {
                var r = data;
                $('#centro').val(r[0]);
                $('#Almacen').val(r[1]);
                $('#ClaseMov').val(r[2]);
                $('#centroco').val(r[3]);
                $('#orden').val(r[4]);
                $('#Arece').val(r[6]);
                $('#NReserva').val(r[7]);
                $('#ReserSAM').val(r[8]);
                var ms = r[5];
                $('#mensgesolped').val(ms);
                if (ms.length > 0) {
                    iconm.css('visibility', 'visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                }
            }
        });
    }
    function cargartablaReserva(nr, tipo) {
        var acc = "CargarTablaReserva";
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionVisualizarReservas",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&NReserva=" + nr + "&Tipo=" + tipo,
            success: function (data) {
               $('#SecCuerpo').html(data);
            }
        });
    }
});
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
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
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalMReserva');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#ReservaBus').val("");
    $('#ReservaBus').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModalMReserva");
    Drag.init(theHandle, theRoot);
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModalMReserva').hide();
    $('#BuscarParamReserva').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#NReserva').focus();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function Seleccionar(sap, sam) {
    if (sap.length > 0) {
        $('#NReserva').val(sap);
    } else {
        $('#NReserva').val(sam);
        document.getElementById("NReserva").value = sam;
    }
    ocultarVentana();
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
function CargarUsarioBusqueda(){
   var usuario = $('#UsuRes').val();
    if(usuario === "ADMIN"){
        $('#Usubus').val('');
        $('#Usubus').prop('readonly',false);
    }else{
        $('#Usubus').val(usuario);
        $('#Usubus').prop('readonly',true);
    }
}