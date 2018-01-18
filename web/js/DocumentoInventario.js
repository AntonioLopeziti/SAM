/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#bxCentro').css('background-image', 'url(images/necesario.PNG)');

    $('#aceptar').click(function () {
        ValidaCampos();
    });

    var arrBtns = [
        $('#btnFch1'),
        $('#btnFch2'),
        $('#btnCentro'),
        $('#btnAlmacen'),
        $('#btnStockEsp'),
        $('#btnAgrp')
    ];

    var arrInpt = [
        $('#bxFch1'),
        $('#bxFch2'),
        $('#bxCentro'),
        $('#bxAlmacen'),
        $('#bxStockEsp'),
        $('#bxNInvt'),
        $('#bxRinvt'),
        $('#bxAgrp'),
        $('#bxDenm')
    ];

    $.each(arrInpt, function (i, v) {
        v.keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (tecla == 13) {
                ValidaCampos();
            }
        });
        v.focus(function () {
            $.each(arrBtns, function (ii, vv) {
                vv.hide();
            });
            switch (i) {
                case 0:
                    arrBtns[i].show();
                    break;
                case 1:
                    arrBtns[i].show();
                    break;
                case 2:
                    arrBtns[i].show();
                    v.css('background-image', 'none');
                    break;
                case 3:
                    arrBtns[i].show();
                    break;
                case 4:
                    arrBtns[i].show();
                    break;
                case 7:
                    arrBtns[5].show();
                    break;
            }
        });
        v.blur(function () {
            if (i == 2) {
                if (v.val().length > 0)
                    v.css('background-image', 'none');
                else
                    v.css('background-image', 'url(images/necesario.PNG)');
            }
        });
    });

    $.each(arrBtns, function (i, v) {
        v.hide();
        v.click(function () {
            switch (i) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:
                    mostrarVentana('VentanaModalCentro');
                    var theHandle = document.getElementById('handle');
                    var theRoot = document.getElementById('VentanaModalCentro');
                    Drag.init(theHandle, theRoot);
                    break;
                case 3:
                    mostrarVentana('VentanaModalAlmacen');
                    var theHandle = document.getElementById('handle2');
                    var theRoot = document.getElementById('VentanaModalAlmacen');
                    Drag.init(theHandle, theRoot);
                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        });
    });

});

function mostrarVentana(t) {
    var ven = document.getElementById(t);
    abrirVentana(ven);
    switch (t) {
        case "VentanaModalCentro":
            peticiones('PeticionMovMateriales', 'cargarDatosCentro', t, 'Centro');
            break;
        case "VentanaModalAlmacen":
            peticiones('PeticionMovMateriales', 'cargarDatosAlmacen', t, 'Almacen');
            break;
    }
}

function abrirVentana(ventana)
{
    var ancho = 600;
    var alto = 550;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    document.getElementById('aceptar').focus();
}
function ocultarVentana(ven, id)
{
    var ventana = document.getElementById(ven);
    ventana.style.display = 'none';
    document.getElementById("msg").innerHTML = "";
    document.getElementById("iconmsg").style.visibility = "hidden";
    try {
        var txt = document.getElementById(id);
        txt.focus();
    } catch (e) {
    }
}

function fnc(f) {
    document.getElementById('table-scroll' + f).onscroll = function () {
        document.getElementById('fixedY' + f).style.top = document.getElementById('table-scroll' + f).scrollTop + 'px';
    };
}

function selecciona(val, id, ven)
{
    document.getElementById(id).value = val;
    ocultarVentana(ven, id);
}

function ValidaCampos() {
    borrarmsg();
    if (!ValidaLLenaCampos()) {
        return;
    }
    acc = "ValidaCampos";
    var centro = $('#bxCentro');
    var almacen = $('#bxAlmacen');
    var dataSend = "&v1=" + centro.val().toUpperCase() + "&v2=" + almacen.val().toUpperCase();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PeticionDocumentoInventario',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + dataSend,
        success: function (rs) {
            if (rs[0] == 0) {
                MostrarMsgAdventencia("No hay valores para esta sección");
                centro.focus();
                return;
            }
            if (rs[1] == 0 && almacen.val().length > 0) {
                MostrarMsgAdventencia("No hay valores para esta sección");
                almacen.focus();
                return;
            }
            enviaListado();
        }
    });
}

function enviaListado() {
    window.location.href = "CrearDocumentoInventarioPos.jsp?centro=" + $('#bxCentro').val().toUpperCase() + "&almacen=" + $('#bxAlmacen').val().toUpperCase();
}

function ValidaLLenaCampos() {
    var centro = $('#bxCentro');
    var almacen = $('#bxAlmacen');
    if (centro.val().length < 1) {
        MostrarMsgAdventencia("Completa los campos obligatorios");
        centro.focus();
        return false;
    }
    if (almacen.val().length < 1) {
        MostrarMsgAdventencia("Ingrese un almacén");
        almacen.focus();
        return false;
    }
    return true;
}

function MostrarMsgAdventencia(msg) {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/advertencia.PNG";
    var men = document.getElementById("msg");
    men.innerHTML = msg;
}

function borrarmsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
}