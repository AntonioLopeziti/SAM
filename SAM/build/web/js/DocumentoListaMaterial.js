/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#btnAccept').prop('disabled', true);
    $('#btnCancelD').prop('disabled', true);
    $('#btnmatchDoc').hide();
    CheckData();
    startTime();
    $('#btnmatchDoc').click(function () {
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
        $('#ClaseMovi').val("");
        $('#DocMat').val("");
        $('#ClaseMovi').focus();
        $('#numAcMax').val("500");
        borramsg();
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
    });
    $('#retmc').click(function () {
        $('#BuscarParam').css('display', 'block');
        $('#ConsultaTabla').css('display', 'none');
    });
    $('#CerrarMC').click(function () {
        ocultarVentana();
    });
    $('#CerrarMC2').click(function () {
        ocultarVentana();
    });

    $('#ClaseMovi').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarDocumentos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#DocMat').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarDocumentos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[a-z1-9A-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarDocumentos();
        }
        if (tecla == 32) {
            return false;
        }
        patr = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patr.test(te)
    });
    $('#okMC').click(function () {
        ConsultarDocumentos();
    });
    function ConsultarDocumentos() {
        var acc = "ConsultaDocumentos";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarDirecto",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&CLAS=" + $('#ClaseMovi').val() + "&DOC=" + $('#DocMat').val() + "&CANT=" + $('#numAcMax').val(),
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
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
    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo2');
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo2").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo2").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo2").scrollTop());
    });
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
    $('#iconmsg').hide();
    $('#aceptar').prop('disabled', true);
    $('#guardar').prop('disabled', true);
    $('#regresar').click(function () {
        window.history.back();
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#cancelar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });

    //////PRIMER BLOQUE
    $('#tabGen').css({"background": "#007CC0", "color": "#fff"});
    $('#btnmostrar').hide();
    $('#seccionProv').hide();
    var arrb = [
        $('#tabGen'),
        $('#tabProv')
    ];
    var arrt = [
        $('#seccionGnrl'),
        $('#seccionProv')
    ];
    $.each(arrb, function (i, v) {
        $.each(arrt, function (a, b) {
            v.click(function () {
                b.hide();
                if (a == i) {
                    $('#btnmatchDoc').hide();
                    b.show();
                    color(i, v);
                }
            });
        });
    });
    function color(i, v) {
        $.each(arrb, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrt.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
    $('#btnocultar').click(function () {
        $('.pesta1').hide();
        $('.Seccionbtn1').height(30);
        $('#btnocultar').hide();
        $('#btnmostrar').show();
    });
    $('#btnmostrar').click(function () {
        $('.pesta1').show();
        $('.Seccionbtn1').height(140);
        $('#btnocultar').show();
        $('#btnmostrar').hide();
    });
    ///// TERCER BLOQUE
    var arrb2 = [
        $('#tabMat'),
        $('#tabSe'),
        $('#tabLot'),
        $('#tabCtd'),
        $('#tabImp')
    ]
    var arrt2 = [
        $('#seccionMate'),
        $('#seccionSe'),
        $('#seccionLot'),
        $('#seccionCtd'),
        $('#seccionImp'),
    ]
    $('#btnmostrar2').hide();
    $('#tabMat').css({"background": "#007CC0", "color": "#fff"});
    $.each(arrt2, function (i, v) {
        v.hide();
        if (i == 0) {
            v.show();
        }
        $.each(arrb2, function (a, b) {
            b.click(function () {
                v.hide();
                if (i == a) {
                    $('#btnmatchDoc').hide();
                    v.show();
                    color2(a, b);
                }
            });
        });

    });
    function color2(i, v) {
        $.each(arrb2, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrb2.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }
    $('#btnocultar2').click(function () {
        $('.pesta2').hide();
        $('#btnocultar2').hide();
        $('#btnmostrar2').show();
    });
    $('#btnmostrar2').click(function () {
        $('.pesta2').show();
        $('#btnocultar2').show();
        $('#btnmostrar2').hide();
    });
    $('#idDoc').focus(function () {
        $('#btnmatchDoc').show();
    });
    $('#idDoc').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            DataDocument();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#ejeDo').click(function () {
        DataDocument();
    });
    function DataDocument() {
        var i = $("#Secidin :input");
        i.val("");
        var doc = $('#idDoc');
        if (doc.val().length > 0) {
            validaDoc(doc.val());
        } else {
            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            doc.focus();
            $('input').val('');
            CargarTablaDoc("", "");
            CargarListDoc("", "");
            $('#btnAccept').prop('disabled', true);
        }
    }
    $('#SelectPos').change(function () {
        var pos = this.value;
        if (pos.trim().length == 0) {
            var i = $("#Secidin :input");
            i.val("");
        } else {
            CargarPosDoc(pos);
            CargarDatosSAM(document.getElementById('SelectPos').selectedIndex - 1);
        }
    });
    $('#CloMsg').click(function () {
        CerrarMsg();
    });
    $('#CerrarVentanaMsg1').click(function () {
        CerrarMsg();
    });
    $('#btnAccept').click(function () {
        validarMov311('A');
    });
    $('#btnCancelD').click(function () {
        validarMov311("C");
    });
    $('#btnreenvi').click(function () {
        ConsumirWS311();
    });
});
function CerrarMsg() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Windowmsg').css('display', 'none');
}
function CargarDatosSAM(index)
{
    var material = document.getElementById('TabBody').rows[index].cells[6].textContent;
    var centro = document.getElementById('TabBody').rows[index].cells[14].textContent;
    var almacen = document.getElementById('TabBody').rows[index].cells[15].textContent;
    var pedido = document.getElementById('TabBody').rows[index].cells[5].textContent;
    var folio = $('#idDoc').val();
//    $('#pedCod').val($('#SelectPos').val());
    $('#provNoms').val($('#proNo').val());
    $('#provCod').val($('#prov').val());
    $('#pedNom').val(pedido);
    $('#ItprovNom').val($('#proNo').val());
    $('#ItprovCod').val($('#prov').val());
    $.ajax({
        async: false,
        type: "GET",
        dataType: "json",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=getSAM&mat=" + material + "&ctr=" + centro + "&alm=" + almacen + "&Pos=" + $('#SelectPos').val() + "&FOLIO=" + folio,
        success: function (data) {
            $('#grpArt').val(data[0]);
            $('#cenDes').val(data[1]);
            $('#alm').val(data[2]);
            $('#pedCod').val(data[4]);
        }
    });
}

var tipMo = "";
var iddoc = "";
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

function validaDoc(id) {
    var acc = "ValidarDoc";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + id,
        success: function (data) {
            var tem = data.split(",");
            var SAP = tem[0];
            var SAM = tem[1];
            var nr = "";
            if (SAP == 1) {
                nr = "P"
            } else if (SAM == 1) {
                nr = "M";
            } else {
                $('input').val('');
                $('#idDoc').val('');
                $('#idDoc').focus();
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            }
            CargarDatosDoc(id, nr);
            CargarTablaDoc(id, nr);
            CargarListDoc(id, nr);
            if ($('#prov').val() == "") {
                CargarDatosProv();
            }
            tipMo = nr;
            iddoc = id;
        }
    });
}
function CargarDatosProv()
{
    var pedido = document.getElementById('TabBody').rows[0].cells[5].textContent;
    if (pedido === "") {
        return;
    }
    $.ajax({
        async: false,
        type: "GET",
        dataType: "json",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=getProv&pedido=" + pedido,
        success: function (data) {
            $('#prov').val(data[0]);
            $('#proNo').val(data[1]);
        }
    });
}
function CargarDatosDoc(id, tipo) {
    var acc = "DatosCabeceraCrea";
    $.ajax({
        async: false,
        type: "GET",
        dataType: "json",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + id + "&Tipo=" + tipo,
        success: function (data) {
            $('#SAPDATA').val(data[0]);
            $('#SAMDATA').val(data[1]);
            if (data[0] != "") {
                $('#idDoc').val(data[0]);
            }
            $('#ejerdoc').val(data[2]);
            $('#fechDoc').val(data[3]);
            $('#fechCont').val(data[4]);
            $('#notEnt').val(data[5]);
            $('#cartPort').val(data[6]);
            $('#txtCab').val(data[7]);
            $('#prov').val(data[8]);
            $('#proNo').val(data[9]);
            validarAceptacion311();
        }
    });
}
function CargarTablaDoc(id, tipo) {
    var acc = "DatostablaDoc";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + id + "&Tipo=" + tipo,
        success: function (data) {
            $('#SecCuerpo2').html(data);
        }
    });
}
function validarAceptacion311() {
    $('#btnmatchDoc').hide();
    var folio = "";
    var SAP = $('#SAPDATA').val();
    var SAM = $('#SAMDATA').val();
    if (SAP.length > 0) {
        folio = SAP;
    } else {
        folio = SAM;
    }
    var acc = "Verificar311";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + folio,
        success: function (datas) {
            if (datas == 1) {
                $('#btnAccept').prop('disabled', false);
                $('#btnCancelD').prop('disabled', false);
            } else {
                $('#btnAccept').prop('disabled', true);
                $('#btnCancelD').prop('disabled', true);
            }
        }
    });
}

function validarMov311(opc) {
    var SAM = $('#SAMDATA').val();
    var acc = "VerificarMov311";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + SAM,
        success: function (datas) {
            if (datas == 1) {
                ///////Nuevo tantto para aceptar y rechazar
                validarPosMov311(opc);

            } else {
                MensajesAce(opc);
            }
        }
    });
}
function MensajesAce(opc) {
    var SAM = $('#SAMDATA').val();
    var acc = "Verificarmensaj";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + SAM,
        success: function (datas) {
            if (datas > 0) {
                if (opc === "A") {
                    VerifcarWSSS();
                } else {
                    ShowMsgWindow(4, "images/infoicono.PNG", "audio/sapsnd05.wav");
                }
            } else {
                ShowMsgWindow(0, "images/infoicono.PNG", "audio/sapsnd05.wav");
            }

        }
    });
}

function validarPosMov311(opc) {
    var SAM = $('#SAMDATA').val();
    var acc = "ValPosMov311";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + SAM,
        success: function (datas) {
            if (datas == 1) {
                ShowMsgWindow(1, "images/infoicono.PNG", "audio/sapsnd05.wav");
            } else {
                if (opc == "A") {
                    GuardarCabecera();
                } else {
                    GuardarCabecera2();
                }
            }
        }
    });
}
function GuardarCabecera2() {
    $('#btnCancelD').prop('disabled', true);
    $('#btnAccept').prop('disabled', true);
    var folio = $('#SAMDATA').val();
    var FecCont = $('#fechCont').val();
    var Nota = $('#notEnt').val();
    var Carta = $('#cartPort').val();
    var txtca = $('#txtCab').val();
    var tdCen = document.getElementsByName('tdCentro');
    var tdAlm = document.getElementsByName('tdAlmacen');
    var acc = "GuardarCabecera312";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&v1=" + FecCont + "&v3=" + tdCen[0].textContent + "&v4=" + tdAlm[0].textContent + "&v5=" + txtca + "&v6=" + Nota + "&v7=" + Carta + "&FOLIO=" + folio,
        success: function (datas) {
            GuardarPosiciones312();
        }
    });
}
function GuardarPosiciones312() {
    var tdPos = document.getElementsByName('tdPosicion');
    var tdCla = document.getElementsByName('tdClase');
    var tdlot = document.getElementsByName('tdLote');
    var tdUME = document.getElementsByName('tdUM');
    var tdCan = document.getElementsByName('tdCantidad');
    var tdAlm = document.getElementsByName('tdAlmacen');
    var tdDes = document.getElementsByName('tdDescripcion');
    var tdMat = document.getElementsByName('tdMaterial');
    var tdRes = document.getElementsByName('tdReserva');
    var tdPoR = document.getElementsByName('tdPosReserva');
    var tdAlD = document.getElementsByName('tdAlmacenD');
    var tdCen = document.getElementsByName('tdCentro');
    for (i = 0; i < tdPos.length; i++) {
        var para = "&v2=" + tdPos[i].textContent + "&v12=" + tdCla[i].textContent + "&v13=" + tdlot[i].textContent +
                "&v11=" + tdUME[i].textContent + "&v10=" + tdCan[i].textContent + "&v4=" + tdAlm[i].textContent +
                "&v9=" + tdDes[i].textContent + "&v8=" + tdMat[i].textContent + "&v14=" + tdRes[i].textContent +
                "&v15=" + tdPoR[i].textContent + "&v16=" + tdAlD[i].textContent + "&v3=" + tdCen[i].textContent;
        var acc = "GuardarPosiciones312";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarDirecto",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + para,
            success: function (datas) {
            }
        });
    }
    ActualizaFolio();
    $('#btnCancelD').prop('disabled', false);
    $('#btnAccept').prop('disabled', false);
    ShowMsgWindow(3, "images/infoicono.PNG", "audio/sapsnd05.wav");
}

function GuardarCabecera() {
    $('#btnAccept').prop('disabled', true);
    $('#btnCancelD').prop('disabled', true);
    var folio = $('#SAMDATA').val();
    var FecCont = $('#fechCont').val();
    var Nota = $('#notEnt').val();
    var Carta = $('#cartPort').val();
    var txtca = $('#txtCab').val();
    var tdCen = document.getElementsByName('tdCentro');
    var tdAlm = document.getElementsByName('tdAlmacen');
    var acc = "GuardarCabecera311";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&v1=" + FecCont + "&v3=" + tdCen[0].textContent + "&v4=" + tdAlm[0].textContent + "&v5=" + txtca + "&v6=" + Nota + "&v7=" + Carta + "&FOLIO=" + folio,
        success: function (datas) {
            GuardarPosiciones();
        }
    });
}
function GuardarPosiciones() {
    var tdPos = document.getElementsByName('tdPosicion');
    var tdCla = document.getElementsByName('tdClase');
    var tdlot = document.getElementsByName('tdLote');
    var tdUME = document.getElementsByName('tdUM');
    var tdCan = document.getElementsByName('tdCantidad');
    var tdAlm = document.getElementsByName('tdAlmacen');
    var tdDes = document.getElementsByName('tdDescripcion');
    var tdMat = document.getElementsByName('tdMaterial');
    var tdRes = document.getElementsByName('tdReserva');
    var tdPoR = document.getElementsByName('tdPosReserva');
    var tdAlD = document.getElementsByName('tdAlmacenD');
    var tdCen = document.getElementsByName('tdCentro');
    for (i = 0; i < tdPos.length; i++) {
        var para = "&v2=" + tdPos[i].textContent + "&v12=" + tdCla[i].textContent + "&v13=" + tdlot[i].textContent +
                "&v11=" + tdUME[i].textContent + "&v10=" + tdCan[i].textContent + "&v4=" + tdAlm[i].textContent +
                "&v9=" + tdDes[i].textContent + "&v8=" + tdMat[i].textContent + "&v14=" + tdRes[i].textContent +
                "&v15=" + tdPoR[i].textContent + "&v16=" + tdAlD[i].textContent + "&v3=" + tdCen[i].textContent;
        var acc = "GuardarPosiciones311";
        $.ajax({
            async: false,
            type: "GET",
            url: "peticionVisualizarDirecto",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + para,
            success: function (datas) {
            }
        });
    }
    ActualizaFolio();
    ConsumirWS311();
}
function ConsumirWS311() {
    ShowMsg(5, "images/load.gif", "audio/saperror.wav");
    setTimeout("ConsumirWS311dta();", 2000);
}
function ConsumirWS311dta() {
    var tdCen = document.getElementsByName('tdCentro');
    var cent = tdCen[0].textContent;
    var folio = $('#SAMDATA').val();
    var acc = "ConsumirWS311";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&v3=" + cent + "&FOLIO=" + folio,
        success: function (datas) {
        }
    });
    VerifcarWSSS();
}
//function VerifcarWS12() {
//    var folio = $('#SAMDATA').val();
//    var acc = "ChecarEnvio";
//    $.ajax({
//        async: false,
//        type: "GET",
//        url: "peticionVisualizarDirecto",
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "Accion=" + acc + "&FOLIO=" + folio,
//        success: function (datas) {
//            if (datas > 0) {
//                VerifcarWSSS();
//            } else {
//                GuardarCabecera();
//            }
//        }
//    });
//}
function  VerifcarWSSS() {
    var folio = $('#SAMDATA').val();
    var acc = "ChecarPosiWS";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + folio,
        success: function (datas) {
            if (datas != 0) {
                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                $('#ejeDo').prop('disabled', true);
                $('#idDoc').prop('disabled', true);
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                var ventana = $('#VentanaModalIvent');
                var ancho = 650;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                var theHandle = document.getElementById("handle22");
                var theRoot = document.getElementById("VentanaModalIvent");
                Drag.init(theHandle, theRoot);
                $('#cargarDatosWSE').html(datas);
            } else {
                var ventana = $('#VentanaModalIvent');
                ventana.css('display', 'none');
                borramsg();
                $('#ejeDo').prop('disabled', false);
                $('#idDoc').prop('disabled', false);
                $('#btnAccept').prop('disabled', true);
                ShowMsgWindow(2, "images/infoicono.PNG", "audio/sapsnd05.wav");
            }
        }
    });
}
function ActualizaFolio()
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
        }
    };
    xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=ActualizarFolio", true);
    xmlhttp.send();
}
function ReenviarDatosWS() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalIvent');
    var ancho = 750;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handle22");
    var theRoot = document.getElementById("VentanaModalIvent");
    Drag.init(theHandle, theRoot);
}
function CargarListDoc(id, tipo) {
    var acc = "ListPos";
    $.ajax({
        async: false,
        type: "GET",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + id + "&Tipo=" + tipo,
        success: function (data) {
            $('#SelectPos').html(data);
        }
    });
}
function CargarPosDoc(Pos) {
    var acc = "CargarPos";
    $.ajax({
        async: false,
        type: "GET",
        dataType: "json",
        url: "peticionVisualizarDirecto",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FOLIO=" + iddoc + "&Tipo=" + tipMo + "&Pos=" + Pos,
        success: function (data) {
            $('#numMat').val(data[0]);
            $('#matNom').val(data[1]);
            $('#noMatProv').val(data[2]);
            $('#grpArt').val(data[3]);
            $('#clsMov').val(data[4]);
            $('#indE').val(data[5]);
            $('#inddebe').val(data[6]);
            $('#provCod').val(data[7]);
            $('#centroCod').val(data[8]);
            $('#cenDes').val(data[9]);
            $('#almCod').val(data[10]);
            $('#alm').val(data[11]);
            $('#almDes').val(data[12]);
            $('#ptoDes').val(data[13]);
            $('#pedNom').val(data[14]);
            $('#numLot').val(data[15]);
            $('#ItprovCod').val(data[7]);
            $('#ItprovRCod').val(data[16]);
            $('#numLotProv').val(data[17]);
            $('#ItprovNom').val(data[18]);
            $('#ItprovRNom').val(data[19]);
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function seleccionar(sap, sam) {
    if (sap.length > 0) {
        $('#idDoc').val(sap);
    } else {
        $('#idDoc').val(sam);
    }
    ocultarVentana();
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParam').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#idDoc').focus();
}


