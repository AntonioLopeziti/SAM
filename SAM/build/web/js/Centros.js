/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    startTime();
    window.onload = function () {
        startTime();
        bloq();
        MostrarTabla("SecTab", "Centros");
        MostrarTabla("SecTab303", "Centros303");
        $("#Ctro").focus;

    };


    $("#regresar").click(function () {
        back();
    });
    $("#guardar").click(function () {
        ValidarCentros();
    });


    function back() {
        window.location.href = "Bienvenido.jsp";
    }

    function MostrarTabla(id, action)
    {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionCrearCentro',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "action=" + action,
            success: function (data) {
                $("#" + id).html(data);
            }

        });
    }


    function  ValidarCentros()
    {

        var v1 = 0, v2 = 0;
        var ctr = $("#Ctro").val();
        var des = $("#Desc").val();
        var ctr3 = $("#bxCtro").val();
        var des3 = $("#bxDesc").val();

        if (ctr !== "" || des !== "") {
            v1 = 1;
        }
        if (ctr !== "" && des !== "") {
            v1 = 0;
        }

        if (ctr3 !== "" || des3 !== "") {
            v2 = 1;
        }
        if (ctr3 !== "" && des3 !== "") {
            v2 = 0;
        }

        if (ctr === "" && des === "" && ctr3 === "" && des3 === "") {
            v1 = 1;
        }

        if (v1 === 1)
        {
            mensajess(1, "");
            dataFocus();
            return;
        }
        if (v2 === 1)
        {
            mensajess(1, "");
            dataFocus303();
            return;
        }
        var enviar = "&ctr=" + ctr + "&ctr3=" + ctr3;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionValidarCreaCentros',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                var arr = new Array();
                arr = data.split(",");

                if (arr[0] == 1)
                {
                    mensajess(1, "Ctro");
                    return;
                }
                if (arr[1] == 1)
                {
                    mensajess(1, "bxCtro");
                    return;
                }
                GuardarCentro();
            }

        });
    }

    function dataFocus() {

        mensajess(0, "");
        var temp = new Array();
        temp[0] = document.getElementById("Ctro");
        temp[1] = document.getElementById("Desc");

        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].value.length === 0)
            {
                temp[i].focus();
                return;
            }
        }
    }
    function dataFocus303() {
        mensajess(0, "");

        var temp3 = new Array();
        temp3[0] = document.getElementById("bxCtro");
        temp3[1] = document.getElementById("bxDesc");

        for (i = 0; i < temp3.length; i++)
        {
            if (temp3[i].value.length === 0)
            {
                temp3[i].focus();
                return;
            }
        }
    }


    function GuardarCentro()
    {
        var cen2 = document.getElementsByName("centros");
        if (cen2.length > 0) {
            mensajess(5, "");
            return;
        }
        var ctr = $("#Ctro").val();
        var des = $("#Desc").val();
        var ctr3 = $("#bxCtro").val();
        var des3 = $("#bxDesc").val();
        var enviar = "&ctr=" + ctr + "&des=" + des + "&ctr3=" + ctr3 + "&des3=" + des3;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardarCrearCentro',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                if (data == 1) {
                    MostrarTabla("SecTab", "Centros");
                    MostrarTabla("SecTab303", "Centros303");
                    $("#Ctro").val("");
                    $("#Desc").val("");
                    $("#bxCtro").val("");
                    $("#bxDesc").val("");
                    $("#Ctro").focus();
                    mensajess(2, "");
                } else {
                    mensajess(3, "");
                }
            }

        });
    }

    $("#cancelarn").click(function () {
        VerificarRegistros();
    });
    function VerificarRegistros()
    {
        var CheckBx = $("input[name$='centros']");
        for (var i = 0; i < CheckBx.length; i++)
        {
            if (CheckBx[i].checked)
            {
                EliminarRegistro(CheckBx[i].value, "SecTab", "Centros", "elimina");
            }
        }
    }


    $("#cancelar303").click(function () {
        VerificarRegistros303();
    });

    function VerificarRegistros303()
    {
        var CheckBx = $("input[name$='centros303']");
        for (var i = 0; i < CheckBx.length; i++)
        {
            if (CheckBx[i].checked)
            {
                EliminarRegistro(CheckBx[i].value, "SecTab303", "Centros303", "elimina303");
            }
        }
    }

    function EliminarRegistro(val, id, act, action)
    {
        var enviar = "&val=" + val;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionEliminarCentro',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "action=" + action + enviar,
            success: function (data) {
                mensajess(4, "");
                MostrarTabla(id, act);
            }

        });
    }
    $("#Ctro").blur(function () {
        aMayusculas('Ctro');
    });
    $("#Desc").blur(function () {
        aMayusculas('Desc');
    });
    $("#bxCtro").blur(function () {
        aMayusculas('bxCtro');
    });
    $("#bxDesc").blur(function () {
        aMayusculas('bxDesc');
    });

    function aMayusculas(id)
    {
        var lt = $("#" + id).val().toUpperCase();
        $("#" + id).val(lt);
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
function bloq()
{
    $("#iconmsg").css("visibility", "hidden");
}