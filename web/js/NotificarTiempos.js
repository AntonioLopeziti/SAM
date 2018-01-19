/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#iconmsg').hide();
    $('#btnmatchOrdLib').hide();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#OrdFab').focus(function () {
        $('#btnmatchOrdLib').show();
    });
//    $('#OrdFab').blur(function () {
//        $('#btnmatchOrdLib').hide();
//    });
    $('#btnmatchOrdLib').click(function () {        
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalOrdenFab");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('VentanaModalOrdenFab', 'handle', '', '');
    });
});
function inval() {
    msgMatch(0, 'images/advertencia.PNG', 'audio/saperror.wav');
}
function MostrarVentanaModal(id, handle, obj, obj2) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borrarmsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
    if (obj != "") {
        $('#' + obj).focus();
        $('#' + obj2).val('500');
    }
}
function ocultarVentana(tipo) {
    switch (tipo) {
        case "OrdFab":
            var ventana = $('#VentanaModalOrdenFab');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
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


