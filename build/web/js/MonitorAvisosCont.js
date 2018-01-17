/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();

    window.onload = function () {
        startTime();
        MostrarRadio();
        cargarya();
        CArgarMne();
//    bloq();
    };
});

function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    $("#tiempo").html(h + ':' + m + ':' + s);
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

//                    function bloq() {
//                        $("#iconmsg").css("visibility","hidden");
//                        $("#guardar").prop("disabled" , true);
//                    }




function ActualizarMedicion()
{
    var icon = $('#iconmsg');
    var men = $('#msg');
    var valor;
    var can = document.getElementById("Dif").value;
    var radiosM = document.getElementsByName('monitor');
    var radiosMo = document.getElementsByName('monitor2');
    var Cp = Array();
    var val1, val2;
    var horl;
    for (var i = 0; i < radiosM.length; i++)
    {
        if (radiosM[i].checked)
        {
            horl = i;
            var jj = parseInt(radiosMo.length);
            if(jj == 0) { jj++; }
            for (var j = 0; j < jj; j++)
            {
                var g = parseInt(i) + parseInt(j);
                valor = radiosMo[j].value;
                Cp = valor.split(",");
                val1 = Cp[0];
                val2 = Cp[6];
                var enviar = "&val=" + val1 + "&can=" + can;
//                            alert(enviar+"  "+val2);
                if (val2 == "") {

                } else {
                    $.ajax({
                        async: false,
                        beforeSend: function () {
                            $("input:text").prop("disabled", true);
                            $("button").prop("disabled", true);
                            icon.show();
                            icon.attr('src', 'images/load.gif');
                            men.html('Espere un momento por favor');
                        },
                        type: 'GET',
                        url: 'PeticionGuardaMonitor',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: enviar,
                        success: function (data) {
                            if (data > 0)
                            {

                            }
                        }

                    });
                }
            }
            setTimeout("COrreTab(" + horl + ")", 500);
        }
    }
}
function funumeric() {
    $("#Sfi").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        }
        patron = /[1-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
}