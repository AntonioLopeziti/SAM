/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("body").mousemove(function () {
        resetTime();
    });
    $(document).on('click', 'body *', function () {
        resetTime();
    });
});
var minutos = 0;
function Check() {
    if (minutos >= 9) {
        Destruir();
    } else {
        minutos++;
    }
}
function resetTime() {
    minutos = 0;
}
function Destruir() {
    var acc = "destroy";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'DestruirSesion',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (data) {

        }
    });
}

function Sesion() {
    var url = "DestruirSesion";
    var acc = "ConsultaSesion";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var rs = xmlhttp.responseText;
            // alert(rs);
            if (rs == 1) {
            } else {
                var ventana = window.self;
                ventana.opener = window.self;
                ventana.close();
                window.self;
                window.location.href = "index.jsp";
            }
        }
    };
    xmlhttp.open("GET", url + "?acc=" + acc, true);
    xmlhttp.send();
}
setInterval(Sesion, 2000);
setInterval(Check, 60000);