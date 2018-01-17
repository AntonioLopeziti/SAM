/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    CargarModulo();
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#regresar').click(function () {
        event.preventDefault();
        history.back(1);
    });
});
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
function CargarCabecera(Aviso, tipo) {
    var acc = "CargarAviso";
    $.ajax({
        async: false,
        dataType: "JSON",
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + tipo,
        success: function (datas) {
            $('#num_aviso').val(datas[0]);
            $('#Num_ClaseAviso').val(datas[1]);
            $('#Des_Aviso').val(datas[2]);
            $('#status_mensaje').val(datas[3]);
            $('#ubitecnica').val(datas[4]);
            $('#num_equipo').val(datas[5]);
            $('#conjunto').val(datas[6]);
            $('#GrupoPlanificacion').val(datas[7]);
            $('#GrupoPlanificacion2').val(datas[8]);
            $('#PtoTrabResp').val(datas[9]);
            $('#CentroEmplaza').val(datas[8]);
            $('#AutorAviso').val(datas[10]);
            $('#fechaaviso').val(datas[11]);
            $('#horaaviso').val(datas[12]);
            $('#inic_ord').val(datas[13]);
            $('#statusOrden_CA').val(datas[17]);
            if ($('#ubitecnica').val().length > 0) {
                CargarNombresData("U", $('#ubitecnica').val());
            }
            if ($('#num_equipo').val().length > 0) {
                CargarNombresData("E", $('#num_equipo').val());
            }
            if ($('#conjunto').val().length > 0) {
                CargarNombresData("C", $('#conjunto').val());
            }
            if ($('#PtoTrabResp').val().length > 0) {
                CargarNombresData("P", $('#PtoTrabResp').val());
            }
            if ($('#GrupoPlanificacion').val().length > 0) {
                CargarNombresData("G", $('#GrupoPlanificacion').val());
            }
            if ($('#GrupoPlanificacion2').val().length > 0) {
                CargarNombresData("B", $('#GrupoPlanificacion2').val());
            }
            if (datas[16].length > 0) {
                $('#MensajeErorAviso').css('display', 'block');
                $('#menser').val(datas[16]);
            } else {
                $('#MensajeErorAviso').css('display', 'none');
                $('#menser').val("");
            }
        }
    });
}
function CargarNombresData(Tipo, dato) {
    var acc = "GetNameData";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Dato=" + dato + "&Par=" + Tipo,
        success: function (datas) {
            if (Tipo == "U") {
                $('#DesUbic').val(datas);
            }
            if (Tipo == "E") {
                $('#DesEqu').val(datas);
            }
            if (Tipo == "C") {
                $('#DesConj').val(datas);
            }
            if (Tipo == "P") {
                $('#DesPue').html(datas);
            }
            if (Tipo == "G") {
                $('#DenoGplan').html(datas);
            }
            if (Tipo == "B") {
                $('#DesCen').html(datas);
                $('#DesCenP').html(datas);
            }
        }
    });
}
function CargarTextos(Aviso, tipo) {
    var acc = "CargarAvisoTexto";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + tipo,
        success: function (datas) {
            $('#TexareaCircunstancia_CA').val(datas);
        }
    });
}
function CargarActividades(Aviso, tipo) {
    var acc = "CargarActividades";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + tipo,
        success: function (datas) {
            $('#SecCuerpo').html(datas);
            AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
            ConsuOK();
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