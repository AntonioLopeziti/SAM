/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    ReporteEtiquetas();
    $('#iconmsg').css('visibility', false);
    $('#regresar').on('click', function () {
        window.location.href = "ReporteEtiquetas.jsp";
    });
    $('#finalizar').on('click', function () {
        window.location.href = "Bienvenido.jsp";
    });
    $('#cancelar').on('click', function () {
        window.location.href = "Bienvenido.jsp";
    });
    $('#imprimir').click(function () {
        ImprimirEtiqueta();
    });
});
function ImprimirEtiqueta() {
    var chk = document.getElementsByName("tdChb");
    var tdord = document.getElementsByName("tdOrden");
    var tdsam = document.getElementsByName("tdSAM");
    var tdpto = document.getElementsByName("tdPuesto");
    var tdcli = document.getElementsByName("tdCliente");
    var tdfec = document.getElementsByName("tdfecha");
    var tdhor = document.getElementsByName("tdhora");
    var tdmat = document.getElementsByName("tdmaterial");
    var tddes = document.getElementsByName("tddesc");
    var tdlot = document.getElementsByName("tdtdlote");
    var tdcan = document.getElementsByName("tdcanti");
    var tdume = document.getElementsByName("tdume");
    var tdanc = document.getElementsByName("tdancho");
    var tdrut = document.getElementsByName("tdruta");
    var tdsto = document.getElementsByName("tdstock");
    for (i = 0; i < chk.length; i++) {
        if (chk[i].checked) {
            var envio = "&ORD=" + tdord[i].textContent 
                      + "&FSA=" + tdsam[i].textContent
                      + "&PTO=" + tdpto[i].textContent
                      + "&CLI=" + tdcli[i].textContent
                      + "&FEC=" + tdfec[i].textContent
                      + "&HOR=" + tdhor[i].textContent
                      + "&MAT=" + tdmat[i].textContent
                      + "&DES=" + tddes[i].textContent
                      + "&LOT=" + tdlot[i].textContent
                      + "&CAN=" + tdcan[i].textContent
                      + "&UME=" + tdume[i].textContent
                      + "&ANC=" + tdanc[i].textContent
                      + "&RUT=" + tdrut[i].textContent
                      + "&STO=" + tdsto[i].textContent;
              SendPrint(envio);
        }
    }
}
function SendPrint(send){
     var acc = 'Imprimir';
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReporteEtiquetas',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + send,
            success: function (data) {
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
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


