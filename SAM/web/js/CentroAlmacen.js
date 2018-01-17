/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    window.onload = function () {
        startTime();
        MostrarTabla();
        $("#iconmsg").hide();
        $("#Ctro").focus();
    };

    function MostrarTabla()
    {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionCentroAlmacen',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "action=",
            success: function (data) {
                $("#SecTab").html(data);
            }

        });
    }
    

    $("#regresar").click(function () {
        back();
    });

    function back() {
        window.location.href = "Bienvenido.jsp";
    }


});
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    $("#tiempo").html(h + ":" + m + ":" + s);
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