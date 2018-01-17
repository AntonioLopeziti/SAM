/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#btnmatch').hide();
    $('#usrAv').css('background-image', 'url(images/necesario.PNG)');


    $('#TextlibMod').focus(function () {
        $('#btnmatch').hide();
    });
    $('#usrAv').focus(function () {
        $('#usrAv').css('background-image', 'none');
        $('#btnmatch').show();
    });
    $('#usrAv').blur(function () {
        if ($('#usrAv').val().length > 0) {
            $('#usrAv').css('background-image', 'none');
        } else {
            $('#usrAv').css('background-image', 'url(images/necesario.PNG)');
        }
    });

    $('#btnGuardar').click(function () {
        ValidaUser();
        CargarTablaUsr();
    });
    $('#cietec').click(function () {
        ocultarVentana('VentanaModalTexto');
        ActualizaStatus();
        CargarTablaUsr();
    });
    $('#btnmatch').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCUser').click(function () {
        ocultarVentanaUSR();
    });
    $('#CerrarMCUser2').click(function () {
        ocultarVentanaUSR();
    });
    $('#btnbuuser').click(function () {
        $('#BuscarParam_u').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#okUs').click(function () {
        ConsultarUser();
    });
    $('#usuariio_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUser();
        }
    });
    $('#nombre_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUser();
        }
    });
    $('#numAcMax').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUser();
        }
    });
    
});

var posicion;

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
    myTableCb.style.width = val + 17 + "px";
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
function abrirVentana(r)
{
    var ventana = document.getElementById(r);
    var ancho = 800;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}
function AbrirVentanaTexto(i) {
    $('#TextlibMod').val("");
    var aviso = document.getElementsByName('cld1');
    var ncorr = document.getElementsByName('cld2');
    var nclas = document.getElementsByName('cld3');
    var fcini = document.getElementsByName('cld9n');
    var hrini = document.getElementsByName('cld10n');

    abrirVentana('VentanaModalTexto');
    var theHandle = document.getElementById('handleCali');
    var theRoot = document.getElementById('VentanaModalTexto');
    Drag.init(theHandle, theRoot);
    $('#avisoid').val(aviso[i].textContent);
    $('#inPrev').val(fcini[i].textContent);
    $('#hrPrev').val(hrini[i].textContent);
    DatosAvisoQM(aviso[i].textContent, ncorr[i].textContent, nclas[i].textContent);
    getTxtQM(i);
    posicion = i;
}
function ocultarVentana(ven)
{
    var ventana = document.getElementById(ven);
    ventana.style.display = 'none';
    document.getElementById("msg").innerHTML = "";
    document.getElementById("iconmsg").style.visibility = "hidden";
}
function ocultarVentanaUSR()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParam_u').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#User_U').focus();
}
function DatosAvisoQM(aviso, ncorr, nclas) {
    var acc = "getDataAvisoQM";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PeticionAvisosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&v1=" + aviso + "&v2=" + ncorr + "&v3=" + nclas,
        success: function (rs) {
            $("#codMedId").val(rs[0]);
            $("#txtMedId").val(rs[1]);
            $("#statusid").val(rs[2]);
        }
    });
}
function getTxtQM(i) {
    var acc = "GetTxtQM";
    var aviso = document.getElementsByName('cld1');
    var ncorr = document.getElementsByName('cld2');
    var nclas = document.getElementsByName('cld3');

    var datosSend = "&v1=" + aviso[i].textContent +
            "&v2=" + ncorr[i].textContent +
            "&v3=" + nclas[i].textContent;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionAvisosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datosSend,
        success: function (rs) {
            $('#Textlib').val(rs);
        }
    });
}
function ingresaCabeceraQM() {
    var acc = "cabeceraQM";
    var aviso = document.getElementsByName('cld1');
    var ncorr = document.getElementsByName('cld2');
    var nclas = document.getElementsByName('cld3');

    var datosSend = "&v1=" + aviso[posicion].textContent +
            "&v2=" + ncorr[posicion].textContent +
            "&v3=" +
            "&v5=" + nclas[posicion].textContent +
            "&v6=" + usuario +
            "&v4=" + $('#usrAv').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionAvisosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datosSend,
        success: function (rs) {
            dividirTexto132Char();
        }
    });
}
function dividirTexto132Char() {
    var txt = document.getElementById('TextlibMod');
    var c = 132;
    var cc = 1;
    for (var x = 0; x < txt.value.length; x += 132)
    {
        var txtArr = new Array();
        txtArr[0] = cc;
        txtArr[1] = txt.value.substring(x, c);
        grabaTextoDefectos(txtArr);
        c += 132;
        cc++;
    }
}
function grabaTextoDefectos(txtA) {
    var acc = "posicionesQM";
    var aviso = document.getElementsByName('cld1');
    var ncorr = document.getElementsByName('cld2');
    var nclas = document.getElementsByName('cld3');
    try {
        var dataSend = "&v1=" + txtA[0]
                + "&v2=" + aviso[posicion].textContent
                + "&v3=" + ncorr[posicion].textContent
                + "&v4=" + nclas[posicion].textContent
                + "&v5=" + txtA[1];

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionAvisosCalidad',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
                ActualizaFolioQM();
            }
        });
    } catch (e) {
    }
}
function ActualizaFolioQM() {
    var acc = "ActualizarFolio";
    try {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionAvisosCalidad',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc,
            success: function (data) {
                var iconm = document.getElementById("iconmsg");
                iconm.style.display = "inline";
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = "Documento " + data + " creado";
                setTimeout(function () {
                    iconm.style.display = "none";
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                }, 4000);
            }
        });
    } catch (e) {
    }
}
function ActualizaStatus() {
    var acc = "ActualizaStatus";
    var aviso = document.getElementsByName('cld1');
    var ncorr = document.getElementsByName('cld2');
    var nclas = document.getElementsByName('cld3');
    try {
        var dataSend = "&v1=" + aviso[posicion].textContent
                + "&v2=" + ncorr[posicion].textContent
                + "&v3=" + nclas[posicion].textContent
                + "&v4=" + usuario;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionAvisosCalidad',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {

            }
        });
    } catch (e) {
    }
}
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModal');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#usuariio_bus').val("");
    $('#nombre_bus').val("");
    $('#usuariio_bus').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModal");
    Drag.init(theHandle, theRoot);
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ConsultarUser() {
    var acc = "ConsultaUsuario";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionAvisosCalidad",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&v1=" + $('#usuariio_bus').val() + "&v2=" + $('#nombre_bus').val() + "&v3=" + $('#numAcMax').val(),
        success: function (data) {
            if (data == 0) {
                ocultarVentanaUSR();
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.style.display = "inline";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "No hay valores por mostrar";
                setTimeout(function () {
                    iconm.style.display = "none";
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                }, 4000);
            } else {
                borramsg();
                $('#cargarDatos').html(data);
                $('#BuscarParam_u').css('display', 'none');
                $('#ConsultaTabla').css('display', 'block');
                document.getElementById('table-scroll').onscroll = function () {
                    document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                };
            }
        }
    });
}
function ValidaUser() {
    var acc = "ValidaUsuario";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionAvisosCalidad",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&v1=" + $('#usrAv').val(),
        success: function (data) {
            if (data == 1) {
                if ($('#TextlibMod').val().trim().length > 0) {
                    ocultarVentana('VentanaModalTexto');
                    ingresaCabeceraQM();
                }
            } else {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.style.display = "inline";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "Usuario Invalido";
                $('#usrAv').focus();
                setTimeout(function () {
                    iconm.style.display = "none";
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                }, 4000);
            }
        }
    });
}
function seleccionar(user) {
    var u = $('#usrAv');
    u.focus();
    u.val(user);
    ocultarVentanaUSR();
}
    