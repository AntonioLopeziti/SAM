/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });

    $('#guardar').click(function () {
        borrarmsg();
        var arrCK = document.getElementsByName('ckCreaDoc');
        var nArCK = new Array();
        for (var i = 0; i < arrCK.length; i++) {
            if (arrCK[i].checked) {
                nArCK.push(arrCK[i].value);
            }
        }
        if (nArCK.length > 0) {
            DocumentoCabecera();
            for (var i = 0; i < nArCK.length; i++) {
                DocumentoPosiciones(nArCK[i], i);
            }
            ActualizarFolio();
        } else {
            MostrarMsgAdventencia("Sin materiales seleccionados para crear el documento de recuento de inventario");
        }
    });
});

function DocumentoCabecera() {
    var acc = "GuardaDocumentoCabecera";
    var ctr = $('#bxCentro').val().toUpperCase();
    var alm = $('#bxAlmacen').val().toUpperCase();
    try {
        var dataSend = "&v1=" + ctr + "&v2=" + alm + "&v3=" + usr;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionDocumentoInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "accion=" + acc + dataSend,
            success: function (data) {
                //respuesta
            }
        });
    } catch (e) {
    }
}

function DocumentoPosiciones(material, pos) {
    var p = parseInt(pos) + 1;
    var acc = "GuardaDocumentoPosiciones";
    var ctr = $('#bxCentro').val().toUpperCase();
    var alm = $('#bxAlmacen').val().toUpperCase();
    try {
        var dataSend = "&v1=" + ctr + "&v2=" + alm + "&v3=" + usr + "&v4=" + material + "&v5=" + p;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionDocumentoInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "accion=" + acc + dataSend,
            success: function (data) {
                //respuesta
            }
        });
    } catch (e) {
    }
}

function ActualizarFolio() {
    var acc = "ActualizarFolio";
    try {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionDocumentoInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "accion=" + acc,
            success: function (data) {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = "Se creo el documento de recuento de inventario DI" + data;
            }
        });
    } catch (e) {
    }
}

function borrarmsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
}

function MostrarMsgAdventencia(msg) {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/advertencia.PNG";
    var men = document.getElementById("msg");
    men.innerHTML = msg;
}

function TablaListadoMat() {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=CreaDocInventario&v1=" + centro + "&v2=" + almacen,
        success: function (data) {
            document.getElementById('SecCuerpo').innerHTML = data;
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
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

