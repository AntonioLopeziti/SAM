/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    $('#regresar').click(function(){
         $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#botonnotificacion').click(function () {
        $(location).attr('href', 'ReporteNotificaciones.jsp');
    });
    $('#botonsolped').click(function () {
        $(location).attr('href', 'ReporteSolPed.jsp');
    });
    $('#botonmovimientos').click(function () {
        $(location).attr('href', 'ReporteMovimientos.jsp');
    });
    $('#botonentradas').click(function () {
        $(location).attr('href', 'ReporteEntradas.jsp');
    });
    $('#botonivent').click(function () {
        $(location).attr('href', 'ReporteIvent.jsp');
    });
    $('#botonLotesInp').click(function () {
        $(location).attr('href', 'ReporteLotesInpeccionPM.jsp');
    });
    $('#botonActAvisosSAP').click(function () {
        $(location).attr('href', 'ReportesActividadesAvisosModificadas.jsp');
    });
    $('#botonDMS').click(function () {
        $(location).attr('href', 'ReporteDMS.jsp');
    });
    $('#botonCalidaTxtAv').click(function () {
        $(location).attr('href', 'ReporteTextoAvisosQM.jsp');
    });
    $('#botonMovNot').click(function () {        
        $(location).attr('href', 'ReporteMovNotificaciones.jsp');
    });
    $('#botonStatOrd').click(function () {        
        $(location).attr('href', 'ReporteStatusOrdenesPP.jsp');
    });
    $('#botonPedidosSD').click(function () {        
        $(location).attr('href', 'ReportePedidosSD.jsp');
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