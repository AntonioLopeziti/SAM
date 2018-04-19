$(document).ready(function () {
    $('#fechaPrecio').val(GetfechaActual());
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    var inputs = [
        $('#pedido'),
        $('#solicitante'),
        $('#destinatario'),
        $('#orgVentas'),
        $('#CanalDis'),
        $('#Sector'),
        $('#refcliente'),
        $('#CreadoPor'),
        $('#fechaEntrega'),
        $('#ClasePedido'),
        $('#txtClasePedido'),
        $('#txtSolicitante'),
        $('#txtDestMcia'),
        $('#txtAreaVentas'),
        $('#OficinaVentas'),
        $('#txtOficinaVentas'),
        $('#GpoVendedores'),
        $('#txtGpoVended'),
        $('#fechaPrecio'),
        $('#textoCabec')
    ];
    var matchs = [
        $('#matchSolicitante'),
        $('#matchDestMecia'),
        $('#matchOrgVentas'),
        $('#matchcanalDis'),
        $('#matchSector'),
        $('#matchFechaentrega'),
        $('#matchClasePedido'),
        $('#matchpoficinaVentas'),
        $('#matchGpoVendedores')
    ];
    $.each(inputs, function (i, v) {
        switch (i) {
            case 0:     ///// Pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 1:    ///// Solicitante
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(0);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 2:   ///// Destinatario Mcia.
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(1);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 3:   ///// Org Ventas
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(2);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 4:   ///// Canal Dist.
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(3);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 5:   ///// Sector
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(4);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 6:  ///// Ref Cliente
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(-1);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 7:  ///// Creado por
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 8:  ///// Fecha entrega
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(5);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
            case 9:  ///// Clase pedido
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(6);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 10:  ///// Texto Clase pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 11:  ///// Texto Solicitante
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 12:  ///// Texto Dest. Mcia.
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 13:  ///// Texto Area Ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 14:  ///// Oficina Ventas
                v.focus(function () {
                    checarPosiMa(7);
                });
                break;
            case 15:  ///// Texto Oficina Ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 16:  ///// Gpo Vendedores
                v.focus(function () {
                    checarPosiMa(8);
                });
                break;
            case 17:  ///// Txt Gpo Vendedores
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 18:  ///// fecha Precio
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 19:  ///// Texto Cabecera
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;

        }
    });
    $.each(matchs, function (i, v) {
        v.hide();
        switch (i) {
            case 2:
                v.click(function () {
                    ConsultaOrgVentas();
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaCanalDis();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaSector();
                });
                break;
            case 5:
                v.click(function () {
                    CerrarCalendario();
                    OpenCalendario("fechaEntrega");
                });
                break;
            case 6:
                v.click(function () {
                    ConsultaClasePedido();
                });
                break;
            case 7:
                v.click(function () {
                    ConsultaOficinaVentas();
                });
                break;
            case 8:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalGrpoVend', 'handle7', 'Busgpovend');
                });
                break;
        }

    });
    function checarPosiMa(index) {
        $.each(matchs, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#CerraMCPedido').click(function () {
        ocultarVentanaSimple('VentanaModalClasePedido', 'ClasePedido');
    });
    $('#CerrarMCOrgVenta').click(function () {
        ocultarVentanaSimple('VentanaModalOrgVentas', 'orgVentas');
    });
    $('#CerrarMCCanalDist').click(function () {
        ocultarVentanaSimple('VentanaModalCanalDist', 'CanalDis');
    });
    $('#CerrarMCSector').click(function () {
        ocultarVentanaSimple('VentanaModalSector', 'Sector');
    });
    $('#CerrarMCOficinaVentas').click(function () {
        ocultarVentanaSimple('VentanaModalOficinaVentas', 'OficinaVentas');
    });
    $('#CerraMCGpoVendedores').click(function () {
        ocultarVentana('VentanaModalGrpoVend', 'BuscarParGpovend', 'ConsultaTablaGpoVend', 'GpoVendedores');
    });
    $('#CerraMCGpoVendedores2').click(function () {
        ocultarVentana('VentanaModalGrpoVend', 'BuscarParGpovend', 'ConsultaTablaGpoVend', 'GpoVendedores');
    });
    $('#cerrarmodaTxtCab').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextli').hide();
    });
    $('#cerrarmodaTxtCab2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#textoCabecera').val('');
        $('#VentanaModalTextli').hide();
    });
    $('#cerrarmodaTxtPos').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextPos').hide();
    });
    $('#cerrarmodaTxtPos2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var pos = $('#postextpos').val();
        $('#textoposTemp' + pos).val('');
        $('#VentanaModalTextPos').hide();
    });
    $('#Cerraok').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextli').hide();
    });
    $('#CerraokPos').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextPos').hide();
        var pos = $('#postextpos').val();
        var tex1t = $('#textoPos').val();
        $('#textoposTemp' + pos).val(tex1t);


    });

    ///// Match Grupo vendedores

    $('#Busgpovend').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#Busdenomgvend').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax7').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#retGpoVend').click(function () {
        $('#BuscarParGpovend').css('display', 'block');
        $('#ConsultaTablaGpoVend').css('display', 'none');
    });
    $('#OkGpoVendedor').click(function () {
        ConsultaGpoVendedores();
    });
    $('#matchDescCabecera').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalTextli');
        var ancho = 600;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalTextli");
        Drag.init(theHandle, theRoot);
    });
    $('#CerrarMCUnidadMedida').click(function () {
        ocultarVentanaSimpleGrid('VentanaModalUMedida', 'tdUmedi');
    });

});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
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
}
function loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
    $("#" + DobleSection).scroll(function () {
        $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
    });
    $("#" + SecCuerpo).scroll(function () {
        $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
    });
    document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#idDataFeee").val(id);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Calenndar');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handlecalendar");
    var theRoot = document.getElementById("Calenndar");
    Drag.init(theHandle, theRoot);
    $('#datapicker').datepicker().show();
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function GetfechaActual() {
    var date = new Date();
    var mes = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
    var fecha = date.getDate() + "." + mes[date.getMonth()] + "." + date.getFullYear();
    return fecha;
}
function mostrarVentanaModal(id, handle, tipo)
{
    switch (tipo) {
        case "BusClaPed":
            $('#numAcMax5').val('500');
            $('#BusCPedDesc').val('');
            $('#BusClaPed').val('');
            break;
        case "Busgpovend":
            $('#numAcMax7').val('500');
            $('#Busdenomgvend').val('');
            $('#Busgpovend').val('');
            break;
    }
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
    if (tipo != "0") {
        $('#' + tipo).focus();
    }
}
function MostratVentanaModalSimple(ventana1, CargarDatos, data, tableScroll, fixedscroll, handle) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#' + ventana1);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(hadle);
    var theRoot = document.getElementById(ventana1);
    Drag.init(theHandle, theRoot);
    $('#' + CargarDatos).html(data);
    document.getElementById(tableScroll).onscroll = function () {
        document.getElementById(fixedscroll).style.top = document.getElementById(tableScroll).scrollTop + 'px';
    };


}
function ocultarVentana(id, bp, ct, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    if (bp != "0") {
        $('#' + bp).css('display', 'block');
        $('#' + ct).css('display', 'none');
    }
    $('#' + obj).focus();
}
function ocultarVentanaSimple(id, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj).focus();
}
function SeleccionarData(dato, ventanamodal, obj)
{
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj).val(dato);
    ocultarVentanaSimple(ventanamodal, obj);
}
function SeleccionarDataGrid(dato, ventanamodal, obj)
{
    var pos = $('#postextpos').val();
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj + pos).val(dato);
    ocultarVentanaSimple(ventanamodal, obj);
}
function SelectData(dato, idv, bp, ct, obj) {
    borramsg();
    $('#' + obj).val(dato);
    ocultarVentana(idv, bp, ct, obj);
}
function ConsultaOrgVentas() {
    var acc = "ConsultarOrgVentas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalOrgVentas', 'cargarDatosOrgVentas', data, 'table-scrollorgVentas', 'fixedYorgVentas', 'handle2');
            }
        }
    });
}
function ConsultaCanalDis() {
    var acc = "ConsultarCanalDis";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalCanalDist', 'cargarDatosCanalDist', data, 'table-scrollCanalDis', 'fixedYCanalDis', 'handle3');
            }
        }
    });
}
function ConsultaSector() {
    var acc = "ConsultarSector";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalSector', 'cargarDatosSector', data, 'table-scrollSector', 'fixedYSector', 'handle4');
            }
        }
    });
}
function ConsultaClasePedido() {
    var acc = "ConsultarClasePedido";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalClasePedido', 'cargarDatosClasePedido', data, 'table-scrollClaPed', 'fixedYClasPed', 'handle5');
            }
        }
    });
}

function ConsultaOficinaVentas() {
    var acc = "ConsultarOficinaVentas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalOficinaVentas', 'cargarDatosOficinaVentas', data, 'table-scrollOficinaVentas', 'fixedYOficinaVentas', 'handle6');
            }
        }
    });
}
function ConsultaUnidadMedida(vm, h, p) {
    var acc = "ConsultarUnidadMedida";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarMatchGrid(vm, h, p);
                borramsg();
                var theHandle = document.getElementById(h);
                var theRoot = document.getElementById(vm);
                Drag.init(theHandle, theRoot);
                $('#cargarDatosUnidadMedida').html(data);
                document.getElementById("table-scrollOUnidadMedida").onscroll = function () {
                    document.getElementById("fixedYUnidadMedida").style.top = document.getElementById("table-scrollOUnidadMedida").scrollTop + 'px';
                };

            }
        }
    });
}
function ConsultaGpoVendedores() {
    var acc = "ConsultarGpoVendedores";
    var datos = "&GpoV=" + $('#Busgpovend').val() + "&DescripcionCPedido=" + encodeURIComponent($('#Busdenomgvend').val().trim()) + "&Ctd=" + $('#numAcMax7').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosGpoVendedor').html(data);
                $('#BuscarParGpovend').css('display', 'none');
                $('#ConsultaTablaGpoVend').css('display', 'block');
                document.getElementById('table-scrollGpoVendedor').onscroll = function () {
                    document.getElementById('fixedYGpoVendedor').style.top = document.getElementById('table-scrollGpoVendedor').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function MostrarMatch(id, match, pos) {
    QuitarMatch();
    $('#' + id + pos).css('width', '80%');
    $('#' + match + pos).css('display', 'inline-block');
}

function QuitarMatch() {
    var inMat = document.getElementsByName("MaterTD");
    var inUme = document.getElementsByName("UMediTD");
    var inCen = document.getElementsByName("CentrTD");
    var inAlm = document.getElementsByName("AlmacTD");
    for (i = 0; i < inMat.length; i++) {
        inMat[i].style.width = '100%';
    }
    for (i = 0; i < inUme.length; i++) {
        inUme[i].style.width = '100%';
    }
    for (i = 0; i < inCen.length; i++) {
        inCen[i].style.width = '100%';
    }
    for (i = 0; i < inAlm.length; i++) {
        inAlm[i].style.width = '100%';
    }

    var matchMat = document.getElementsByName('matchMaterial');
    var matchUme = document.getElementsByName('matchUnMedida');
    var matchCen = document.getElementsByName('matchcentro');
    var matchAlm = document.getElementsByName('matchAlamcen');

    for (i = 0; i < matchMat.length; i++) {
        matchMat[i].style.display = 'none';
    }
    for (i = 0; i < matchUme.length; i++) {
        matchUme[i].style.display = 'none';
    }
    for (i = 0; i < matchCen.length; i++) {
        matchCen[i].style.display = 'none';
    }
    for (i = 0; i < matchAlm.length; i++) {
        matchAlm[i].style.display = 'none';
    }
}
function mostrarVentanaTextoPos(pos) {
    QuitarMatch();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalTextPos');
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handleTxtPos");
    var theRoot = document.getElementById("VentanaModalTextPos");
    Drag.init(theHandle, theRoot);
    var valorpostext = $('#textoposTemp' + pos).val();
    $('#textoPos').val(valorpostext);
    $('#postextpos').val(pos);
}

function MostrarMatchGrid(VM, handle, pos) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + VM);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(VM);
    Drag.init(theHandle, theRoot);
    $('#postextpos').val(pos);
}
function ocultarVentanaSimpleGrid(id, obj)
{
    var pos = $('#postextpos').val();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj + pos).focus();
}