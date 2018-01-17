$(document).ready(function () {
    startTime();
    CargarTabla();
    $('#regresar').click(function () {
        $(location).attr('href', 'ListaOrdenes.jsp')
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp')
    });
    $('#CerrarVentanaMsg1').click(function () {
        var ventana = $('#Windowmsg');
        ventana.css('display', 'none');
    });
    $('#btnVis').click(function () {
        var acc = "Checksap";
        var send = $('#numordenmsg').html();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionPlanOrden",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&orden=" + send,
            success: function (data) {
                if (data == 1) {
                    window.location.href = "VisualizarOrdenes2.jsp?ord=" + send + "&peticion=peticionVisualizarOrdenes&tipo=1";
                } else {
                    window.location.href = "VisualizarOrdenes2.jsp?ord=" + send + "&peticion=peticionVisualizarCreaOrdenes&tipo=2";
                }
            }
        });
    });
    $('#btnNot').click(function () {
        var send = $('#numordenmsg').html();
        window.location.href = "CrearNotificacionesPM.jsp?orden=" + send;
    });
});
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
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
    myTableCb.style.width = val + 7 + "px";
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
//    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
}
function seleccionarOrden(orden, sam) {
    var ancho = 450;
    var alto = 500;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Windowmsg');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    var theHandle = document.getElementById("handleMsg");
    var theRoot = document.getElementById("Windowmsg");
    Drag.init(theHandle, theRoot);
    var send;
    if (orden.length > 0) {
        send = orden;
    } else {
        send = sam;
    }
    $('#numordenmsg').html(send);
}