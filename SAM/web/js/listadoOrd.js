/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
});




function tablaListadoOrdenesPP(){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListado",
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

