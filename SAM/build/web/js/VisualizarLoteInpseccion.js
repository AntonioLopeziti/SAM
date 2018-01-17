/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'ListaLotesInpseccion.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#CloMsg').click(function(){
        $('#Windowmsg').hide();
    });
    $('#CerrarVentanaMsg1').click(function(){
        $('#Windowmsg').hide();
    });
    CargarTabla();
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
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
//    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
}
function seleccinarlote(semaforo, orden) {
    if (semaforo === "@08QStatus@") {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ancho = 600;
        var alto = 500;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        var ventana = $('#Windowmsg');
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        var icon = $('#iocnomsgso');
        icon.show();
        icon.attr('src', "images/infoicono.PNG");
        var theHandle = document.getElementById("handleMsg");
        var theRoot = document.getElementById("Windowmsg");
        document.getElementById("CloMsg").focus();
        Drag.init(theHandle, theRoot);

    } else {
        $(location).attr('href', 'CrearNotificacionesPM.jsp?orden=' + orden);
    }
}
