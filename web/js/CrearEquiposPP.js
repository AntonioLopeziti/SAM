$(document).ready(function () {
    startTime();    
    $('#iconmsg').hide();
    $('#btnmatch').hide();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#equ').focus(function () {
        $('#btnmatch').show();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#btnmatch').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCEqupos').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCEqupos2').click(function () {
        ocultarVentana();
    });
});
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModal');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#equBus').val("");
    $('#denEqBus').val("");
    $('#equBus').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModal");
    Drag.init(theHandle, theRoot);
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParam').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#equ').focus();
}
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
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