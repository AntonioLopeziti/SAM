/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
    $('#VisVis').click(function () {
        var position = $('#ubtecPosOc').val();
        SendPath(position);
        ocultarVenAv('VenAvv');
    });
    $('#ViGuarAr').click(function () {
        var posit = $('#ubtecPosOc').val();
        SendMod(posit);
        ocultarVenAv('VenAvv');
    });
    $("#DobleSection").scroll(function () {
        $("#SecCuerpoN").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpoN").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpoN").scrollTop());
    });


    $("#DobleObj").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleObj").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleObj").scrollTop($("#SecCuerpo").scrollTop());
    });




    $('#btnDatosDoc').css("background-color", "#007CC0");
    $('#btnObjSAP').css("background-color", "#007CC0");

    $('#cancelar').click(function ()
    {
        $('#FrameContainer').hide();
        $('#ContentBk').show();
    });
    var arrPnl = [
        $('#btnDatosDoc'),
        $('#btnEnlacesObj')
    ];

    $.each(arrPnl, function (i, v)
    {
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#secTree').show();
                    $('#TableNotfi').hide();
                    $('#btnDatosDoc').css("background-color", "#007CC0");
                    $('#btnEnlacesObj').css("background-color", "#fff");
                    break;
                case 1:
                    $('#secTree').hide();
                    $('#TableNotfi').css('display', 'inline-block');
                    $('#btnDatosDoc').css("background-color", "#fff");
                    $('#btnEnlacesObj').css("background-color", "#007CC0");
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    break;
            }
        });
    });
});

//function SendPath(c)
//{
//    var ficheros = document.getElementsByName('tdFch');
//    var path = ficheros[c].textContent;
//    var carpets = path.split("\\");
//    var file = carpets[carpets.length-1];
//    EnviarRuta(file);
//}
function SendPath(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarRuta(cad);
}
function SendMod(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarModificar(cad);
}

function PathFile(ext, c, name)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var fl = path.replace("C:\\", "Filess\\");
    fl = fl.replace("." + ext, "");
    name = name.replace("." + ext, "");
    switch (ext)
    {
        case "txt":
            $('#FrameContainer').show();
            $('#ContentBk').hide();
            document.getElementById("FrameContainer").innerHTML = "<iframe src=\"Filess/" + name + ".html\" ></iframe>";
            break;
        case "xlsx":
            $('#FrameContainer').show();
            $('#ContentBk').hide();
            document.getElementById("FrameContainer").innerHTML = "<iframe src=\"Filess/" + name + ".htm\" ></iframe>";
            break;
        case "pdf":
        case "docx":
            $('#FrameContainer').show();
            $('#ContentBk').hide();
            document.getElementById("FrameContainer").innerHTML = "<iframe style=\"margin-top: -60px;\" src=\"Filess/" + name + ".pdf\"></iframe>";
            break;
    }
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
function ocultarVenAv(tipo){
    switch (tipo) {
        case "VenAvv":
            var ventana = $('#VentUbTecAvvv');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function abrVen(c2){
    $("#ubtecPosOc").val(c2);
    $("#VentanaModalCentroP").hide();
    var ventana = document.getElementById('VentUbTecAvvv');
    abrirVentanaAv(ventana);
    var theHandle = document.getElementById("handleAvvv");
    var theRoot = document.getElementById("VentUbTecAvvv");
    Drag.init(theHandle, theRoot);
}
function abrirVentanaAv(ventana){
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    //document.getElementById("lbAv").innerHTML = msg;
}
