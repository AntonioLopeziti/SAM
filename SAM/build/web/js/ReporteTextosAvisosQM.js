/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    CargarCentros();
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Reportes.jsp');
    });
    var arri = [
        $('#centro'),
        $('#sam1'),
        $('#not1'),
        $('#fechainicio'),
        $('#sam2'),
        $('#not2'),
        $('#fechafin')
    ];
    var arrm = [
        $('#match_A1'),
        $('#match_A2'),
        $('#match_A3'),
        $('#match_A4'),
        $('#match_A5'),
        $('#match_A6')
    ];
    $.each(arrm, function (i, v) {
        v.hide();
        switch(i){
            case 2:
                v.click(function(){
                    OpenCalendario('fechainicio');
                });
                break;
            case 5:
                v.click(function(){
                    OpenCalendario('fechafin');
                });
                break;
        }
    });
    $.each(arri, function(i,v){
        switch(i){
            case 0:
                v.focus(function(){
                    checarPosiMa(-1);
                });
                break;
            case 1:
                v.focus(function(){
                    checarPosiMa(0);
                });
                break;
            case 2:
                v.focus(function(){
                    checarPosiMa(1);
                });
                break;
            case 3:
                v.focus(function(){
                    checarPosiMa(2);
                });
                break;
            case 4:
                v.focus(function(){
                    checarPosiMa(3);
                });
                break;
            case 5:
                v.focus(function(){
                    checarPosiMa(4);
                });
                break;
            case 6:
                v.focus(function(){
                    checarPosiMa(5);
                });
                break;
        }
    });
        function checarPosiMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
     $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
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
function CargarCentros() {
    var acc = "CargarCentros";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReporteTextosAvisosQM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            $('#centro').html(data);
        }
    });
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#IDFecha").val(id);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Calenndar');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handlecalendar");
    var theRoot = document.getElementById("Calenndar");
    Drag.init(theHandle, theRoot);
    $('#datapicker').datepicker().show();
}
function ocultarVentana(id, ventana) {
    $('#' + ventana).css('display', 'none');
    $('#' + id).focus();
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
}
function MostrarVentanaModal(id, handle) {
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
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}