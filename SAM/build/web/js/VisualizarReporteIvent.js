/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
window.onload = function () {
    startTime();
    bloq();
    Correr();
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
};

function bloq() {
    $('#iconmsg').css('visibility', 'hidden');
    $('#guardar').attr('disabled', true);
}
function retorn() {
    window.location.href = "ReporteIvent.jsp";
}
function back() {
    window.location.href = "Bienvenido.jsp";
}
function Correr() {
    var acc = "ReporteIvent";
    var ventana = document.getElementById('general');
    var ancho = 750;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReporteIvent',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            $('#global').html(data);
            var okcon = 'Consulta aplicada con exito';
            var iconm = $('#iconmsg');
            iconm.css('visibility', 'visible');
            iconm.attr('src', 'images/aceptar.png');
            $('#msg').html(okcon);
        }
    });
}

