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
    $('#OrdFab').blur(function () {
        $('#btnmatchOrdLib').hide();
    });
});
function inval() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $("#iconmsg").show();
    $("#iconmsg").attr('src', 'images/advertencia.PNG');
    msgMatch("funinva");
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


