/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    startTime();
    validaUsuarioVis();
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
    $('#VisDoo').click(function () {
        if ($("#equ").val() != "") {
            VisDoc();
        } else {
            ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
        }
    });
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
    $('#retmc').click(function () {
        $('#BuscarParam').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#CerrarMCEqupos').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCEqupos2').click(function () {
        ocultarVentana();
    });
    $('#equBus').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            cargar();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#denEqBus').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            cargar();
        }
    });
    $('#numAcMax').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            cargar();
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#okEquipo').click(function () {
        cargar();
    });
    $('#equ').keypress(function (e) {
        tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargaDatos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[-ÑñAa-zA-Z0-9\s]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#aceptar').click(function () {
        CargaDatos();
    });
    function cargar() {
        var acc = "CargarMatchEquipos";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionModuloVisualizarEquipos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Ctd=" + $('#numAcMax').val() + "&Equipo=" + $('#equBus').val() + "&DEquipo=" + $('#denEqBus').val(),
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    borramsg();
                    $('#cargarDatos').html(data);
                    $('#BuscarParam').css('display', 'none');
                    $('#ConsultaTabla').css('display', 'block');
                    document.getElementById('table-scroll').onscroll = function () {
                        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                    };
                }
            }
        });
    }
    function  CargaDatos() {
        var eq = $('#equ');
        if (eq.val().length < 1) {
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
            eq.focus();
            $('input').val("");
            $('#peso').val("0,000");
        } else {
            var acc = "CargarDatosEquipos";
            $.ajax({
                async: false,
                type: "GET",
                url: "peticionModuloVisualizarEquipos",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&Equipo=" + eq.val().toUpperCase(),
                success: function (data) {
                    if (data == 0) {
                        $('input').val("");
                        $('#peso').val("0,000");
                        ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        var e = data;
                        $('#deq').val(e[0]);
                        $('#grupAuto').val(e[1]);
                        $('#fab_eq').val(e[2]);
                        $('#denom_eq').val(e[3]);
                        $('#pieza_eq').val(e[4]);
                        $('#serie_eq').val(e[5]);
                        $('#pais_eq').val(e[6]);
                        $('#year_eq').val(e[7]);
                        $('#month_eq').val(e[8]);
                        $('#ceemp_eq').val(e[9]);
                        $('#emp_eq').val(e[10]);
                        $('#empre_eq').val(e[11]);
                        $('#indica_eq').val(e[12]);
                        $('#soc_eq').val(e[13]);
                        $('#coste_eq').val(e[14]);
                        $('#coste2_eq').val(e[15]);
                        $('#cenp_eq').val(e[16]);
                        $('#grpop_eq').val(e[17]);
                        $('#ptr_eq').val(e[18]);
                        $('#ubc_eq').val(e[19]);
                        $('#equs_eq').val(e[20]);
                        $('#mat_eq').val(e[21]);
                        $('#desmatequ').val(e[22]);
                        $('#numser_eq').val(e[23]);
                        $('#tipo_eq').val(e[24]);
                        $('#tipoStock_eq').val(e[25]);
                        $('#centro_eq').val(e[26]);
                        $('#alma_eq').val(e[27]);
                        $('#lote_eq').val(e[28]);
                        $('#StockEsp_eq').val(e[29]);
                        $('#cliente_eq').val(e[30]);
                        $('#lotemaes_eq').val(e[31]);
                        $('#fchaUt_eq').val(e[32]);
                        $('#prov_eq').val(e[33]);
                        ShowMsg(5, "images/aceptar.png", "audio/sapmsg.wav");
                    }
                }
            });
        }
    }
});
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
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function VisDoc() {
    acc = "matchDocs";
    var equi = $("#equ").val();
    var eqS = equi.substring(0, 4);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloVisualizarEquipos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&equi=" + equi + "&centroo=" + eqS,
        success: function (rs) {
            if (rs == 0) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                blockPropiety('handle3', 'VentanaModalCentroP');
                $('#SecCuerpo').html(rs);
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                fncCentroP();
                borramsg();
            }
        }
    });
}
function fncCentroP() {
    $('#table-scrollCentroP').scroll(function () {
        $('#fixedYCentroP').css({top: $('#scrollCentroP').scrollTop()});
    });
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function ocultarVentanaa(tipo) {
    switch (tipo) {
        case "CentroP":
            var ventana = $('#VentanaModalCentroP');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function abrirVentana(ventana) {
    var ancho = 950;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    var iconm = $('#iconmsg');
    var men = $('#msg');
    men.html("");
    iconm.hide();
}
function ocultarVenAv(tipo) {
    switch (tipo) {
        case "VenAvv":
            var ventana = $('#VentUbTecAvvv');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function abrVen(c2) {
    $("#ubtecPosOc").val(c2);
    $("#VentanaModalCentroP").hide();
    var ventana = document.getElementById('VentUbTecAvvv');
    abrirVentanaAv(ventana);
    var theHandle = document.getElementById("handleAvvv");
    var theRoot = document.getElementById("VentUbTecAvvv");
    Drag.init(theHandle, theRoot);
}
function abrirVentanaAv(ventana) {
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    //document.getElementById("lbAv").innerHTML = msg;
}
function SendPath(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarRuta(cad);
}
function EnviarRuta(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            }
        }
    };
    xmlhttp.open("GET", "peticionModuloVisualizarEquipos?Action=EnviarSocket&ruta=" + ruta, true);
    xmlhttp.send();
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
function SendMod(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarModificar(cad);
}
function EnviarModificar(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            } else {
                document.getElementById("msg").innerHTML = "";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "hidden";
            }
        }
    };
    xmlhttp.open("GET", "peticionModuloVisualizarEquipos?Action=EnviarMod&ruta=" + ruta, true);
    xmlhttp.send();
}
