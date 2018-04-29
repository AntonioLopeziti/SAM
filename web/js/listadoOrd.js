/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });

    $("#guardar").click(function () {
        var ckBox = document.getElementsByName('habilitado');
        TruncaControl();
        for (x = 0; x < ckBox.length; x++) {
            if (!ckBox[x].checked) {
                GuardaHabilitado(ckBox[x].value);
            }
        }
        var iconm = document.getElementById("iconmsg");
        iconm.style.display = "inline";
        iconm.style.visibility = "visible";
        iconm.src = "images/aceptar.png";
        var men = document.getElementById("msg");
        men.innerHTML = "Se han grabado los cambios";
        setTimeout(function () {
            tablaListadoOrdenesPP();
        }, 1000);
    });

    $("#imgLib").click(function () {
        var radiosPP = document.getElementsByName('gender');

        for (i = 0; i < radiosPP.length; i++) {
            if (radiosPP[i].checked) {
                var stat = $("#tdPP6" + radiosPP[i].value).text().substring(0, 4);
                if (stat !== "ABIE") {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.display = "inline";
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "No se puede aplicar el status a la orden";
                } else {
                    EnviaStatusOrden(radiosPP[i].value, "LIB.", "L");
                    return;
                }
            }
        }
    });

    $("#imgCie").click(function () {
        var radiosPP = document.getElementsByName('gender');

        for (i = 0; i < radiosPP.length; i++) {
            if (radiosPP[i].checked) {
                var stat = $("#tdPP6" + radiosPP[i].value).text().substring(0, 4);
                if (stat !== "LIB.") {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.display = "inline";
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "No se puede aplicar el status a la orden";
                } else {
                    EnviaStatusOrden(radiosPP[i].value, "CTEC", "C");
                    return;
                }
            }
        }
    });

    $("#imgCan").click(function () {
        var radiosPP = document.getElementsByName('gender');

        for (i = 0; i < radiosPP.length; i++) {
            if (radiosPP[i].checked) {
                var stat = $("#tdPP6" + radiosPP[i].value).text().substring(0, 4);
                if (stat !== "CTEC") {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.display = "inline";
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "No se puede aplicar el status a la orden";
                } else {
                    EnviaStatusOrden(radiosPP[i].value, "LIB.", "A");
                    return;
                }
            }
        }
    });
});

function TruncaControl() {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=truncarControl",
        success: function (data) {
        }
    });
}
function GuardaHabilitado(pos) {

    var send = "&v1=" + $("#tdPP2" + pos).text() + //Nro. Orden
            "&v2=" + $("#tdPP3" + pos).text() + //Fol. SAM
            "&v3=" + $("#tdPP1" + pos).text() + //Clase Orden
            "&v4=" + $("#tdPP6" + pos).text() + //Status
            "&v5=" + $("#tdPC3" + pos).text() + //Centro
            "&v6=" + $("#tdPP4" + pos).text();     //Num. Material
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=guardaHabilitado" + send,
        success: function (data) {
        }
    });
}

function EnviaStatusOrden(pos, stat, ope) {
    var norden = $("#tdPP2" + pos).text();
    var folsam = $("#tdPP3" + pos).text();

    var send = "&v1=" + folsam +
            "&v2=" + norden +
            "&v3=" + $("#tdPC3" + pos).text() + //Centro
            "&v4=" + ope + //Operación
            "&v5=" + usuario +
            "&v6=" + stat;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=guardaStatus" + send,
        success: function (data) {
            var iconm = document.getElementById("iconmsg");
            iconm.style.display = "inline";
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = "Se ha grabado la orden con el número " + data;
            tablaListadoOrdenesPP(pos);
        }
    });
}

function tablaListadoOrdenesPP(pos) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListado",
        success: function (data) {
            document.getElementById('SecCuerpo').innerHTML = data;
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
            try {
                document.getElementsByName('gender')[pos].checked = true;
            } catch (e) {
            }
        }
    });
}
function tablaListadoOrdenesPorCentro(cnt) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoCentro&centro=" + cnt,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}
function tablaListadoOrdenesPorFolio (fol){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoFolio&folio=" + fol,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}
function tablaListadoOrdenesPorMaterial (mat){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoMaterial&material=" + mat,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}
function tablaListadoOrdenesPorCenFol (centro, folio){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoCenFol&centro=" + centro + "&folio=" + folio,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
                ShowMsg(9, "images/advertencia.PNG", "audio/sapmsg.wav", "");
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}
function tablaListadoOrdenesPorCenMate (centro, mate){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoCenMat&centro=" + centro + "&material=" + mate,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}
function tablaListadoOrdenesPorFolMate (folio, mate){
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=tablaListadoFolMat&folio=" + folio + "&material=" + mate,
        success: function (data) {            
            if (data == 0) {
                location.href = "ListadoOrdFab.jsp";
            } else {
                document.getElementById('SecCuerpo').innerHTML = data;
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                try {
                    document.getElementsByName('gender')[pos].checked = true;
                } catch (e) {
                }
            }
        }
    });
}

function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }
    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 17 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
}

