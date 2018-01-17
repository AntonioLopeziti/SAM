/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Drag */

$(document).ready(function () {
    $('#btnAdjuntarCalidad').click(function () {
        mostrarVentanaModal("VentanaModalAddFileCalidad");
        var theHandle = document.getElementById("handle21");
        var theRoot = document.getElementById("VentanaModalAddFileCalidad");
        Drag.init(theHandle, theRoot);
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
    $("#btnDE1").click(function () {
        $("#pnlDE1").show();
        $("#pnlDE2").hide();
    });
    $("#btnDE2").click(function () {
        $("#pnlDE2").show();
        $("#pnlDE1").hide();
    });
    $("#DobleSection").scroll(function () {
        $("#SecCuerpoCld").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpoCld").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpoCld").scrollTop());
    });


    $("#DobleSection3").scroll(function () {
        $("#SecCuerpo3").scrollTop($("#DobleSection3").scrollTop());
    });
    $("#SecCuerpo3").scroll(function () {
        $("#DobleSection3").scrollTop($("#SecCuerpo3").scrollTop());
    });



    $('#okTexto').click(function () {
        $('#Textlib' + $('#bxTextoL').val()).val($('#Textlib').val());
        ocultarVentana('VentanaModalTexto', '');
    });
    $('#okTexto2').click(function () {
        $('#TextlibNota' + $('#bxTextoLNota').val()).val($('#Textlib').val());
        ocultarVentana('VentanaModalTexto', '');
    });
    $("#bxCodn").focus(function () {
        $("#btnCod00").hide();
    });
    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    var meses2 = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
    var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
    var f = new Date();
    var mes = meses2[f.getMonth()];
    var dia = f.getDate();
    if (dia <= 9) {
        dita = "0" + dia;
    } else {
        dita = dia;
    }
    //alert(mes + "-" + dia);
    if (mes <= 9) {
        mesito = mes;
    } else {
        mesito = mes;
    }
    var fnoti = f.getFullYear() + "-" + mesito + "-" + dita;
    var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
    $('#fecha').html(fechaActual);
    $("#fenot").val(fnoti);
    startTime();
    $('#ord').css("background-image", "url(images/necesario.PNG)");
    $('#ubte').css("background-image", "url(images/necesario.PNG)");
    $('#equ').css("background-image", "url(images/necesario.PNG)");
    $('#clascap').css("background-image", "url(images/necesario.PNG)");

    $('#durp1').css("background-image", "url(images/necesario.PNG)");

    $("#match_N22").click(function () {

        mostrarVentanaModal("VentanaModalLoteEQ");
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalLoteEQ");
        Drag.init(theHandle, theRoot);
        COnsultarLotes2("VentanaModalLoteEQ");
    });

    $('#nofip1').click(function () {
        $('#nofip1').css("background-image", "none");
        if ($('#durp1').val().length < 1) {
            $('#durp1').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#trrep1').val().length < 1) {

        }
    });
    $('#durp1').click(function () {
        $('#durp1').css("background-image", "none");
        if ($('#nofip1').val().length < 1) {

        }
        if ($('#trrep1').val().length < 1) {

        }
    });



    $('#durp1').keyup(function () {
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        } else {
            this.value = (this.value + '').replace(/[^0-9]/g, '');
        }
    });



    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_Nope').hide();
    $('#ord').focus(function () {
        $('#ord').css("background-image", "none");
        $('#match_C1').show();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
        if ($('#ubte').val().length < 1) {
            $('#ubte').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#equ').val().length < 1) {
            $('#equ').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#clascap').val().length < 1) {
            $('#clascap').css("background-image", "url(images/necesario.PNG)");
        }

    });

    $('#ubte').focus(function () {
        $('#ubte').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').show();
        $('#match_C3').hide();
        $('#match_C4').hide();

        if ($('#ord').val().length < 1) {
            $('#ord').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#equ').val().length < 1) {
            $('#equ').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#clascap').val().length < 1) {
            $('#clascap').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#equ').focus(function () {
        $('#equ').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').show();
        $('#match_C4').hide();

        if ($('#ord').val().length < 1) {
            $('#ord').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ubte').val().length < 1) {
            $('#ubte').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#clascap').val().length < 1) {
            $('#clascap').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#clascap').focus(function () {
        $('#clascap').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').show();

        if ($('#ord').val().length < 1) {
            $('#ord').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ubte').val().length < 1) {
            $('#ubte').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#equ').val().length < 1) {
            $('#equ').css("background-image", "url(images/necesario.PNG)");
        }
    });





    $('#match_C1').click(function () {
        mostrarVentanaModal("VentanaModal");
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
    });
    $('#match_C2').click(function () {
        mostrarVentanaModal("VentanaModal2");
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModal2");
        Drag.init(theHandle, theRoot);
    });

    $('#match_C3').click(function () {
        mostrarVentanaModal("VentanaModal3");
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModal3");
        Drag.init(theHandle, theRoot);
    });

    $('#match_C4').click(function () {
        mostrarVentanaModal("VentanaModal4");
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModal4");
        Drag.init(theHandle, theRoot);
    });

    $('#match_Nope').click(function () {
        mostrarVentanaModal("VentanaModalUSU");
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalUSU");
        Drag.init(theHandle, theRoot);
    });

    $('#notor').focus(function () {
        $('#match_N1').show();
    });
    $('#match_N1').blur(function () {
        $('#match_N1').hide();
    });

    $('#match_N1').click(function () {

        mostrarVentanaModal("VentanaModal");
        $('#env1vm').focus();
        $('#env1vm').val('');
        $('#ordmatvm').val('');
        $('#txtbrvm').val('');
        $('#env5vm').val('500');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
    });
    $('#env5vm').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            cargar('peticionesOrdenesCrearNoti');
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });

    $(':checkbox').on('change', function () {
        var th = $(this), name = th.prop('name');
        if (th.is(':checked')) {

            $(':checkbox[name="' + name + '"]').not($(this)).prop('checked', false);

        }

    });
    $('#SecTab table tbody tr').each(function (a, b) {
        $(b).click(function () {
            $('#SecTab table tbody tr').css('background', '#E6EBEB');
            $(this).css('background', '#C9E1ED');
        });
    });

    $('#ventanaavis').click(function () {

        var theHandle = document.getElementById("handleAv2");
        var theRoot = document.getElementById("ventanaavis");
        Drag.init(theHandle, theRoot);
    });
//     $('#btntab').click(function(){
//         mostrarventabs("ventaQM01");
//        // ventaPM01
//         var theHandle = document.getElementById("handlePM01");
//         var theRoot = document.getElementById("ventaPM01");
//         Drag.init(theHandle,theRoot);
//     });
    $("#guaresqm01").click(function () {
        ValidaReservQM();
    });

    $('#btnCancelar').click(function () {
        ConsumiriFOL();
        OcultarMensajeFile('VentanaModalMsgAddFile');
    });
    $('#btnGrabarR').click(function () {
        validarTabRes();
    });
    $('#okAv').click(function () {
        ocultarVentana('VentanaModalAv', 'bxPedido');
    });
    $('#okLMNC').click(function () {
        ckListaMat();
    });
    $('#okHoras').click(function () {
        ActualizaMedicion();
        cerraventabs('VentanaModalHoras');
    });
    $('#cnlHrs').click(function () {
        desmonta();
        cerraventabs('VentanaModalHoras');
    });
    $('#okFr').click(function () {
        var val = document.getElementsByName('cld8');
        var CheckBx = document.getElementsByName('forzar');
        var pos = $('#lblpos').text();
        for (var i = 0; i < CheckBx.length; i++) {
            if (CheckBx[i].checked)
            {
                $('#bxcld70' + pos).val(CheckBx[i].value);
                val[pos].innerHTML = CheckBx[i].value;
            }
        }
        ocultarVentana('VentanaModalForzar', '');
    });
    $('#okCalidad').click(function () {
        if (document.getElementById('btnGrabarR').disabled === false)
        {
            var ven = document.getElementById('VentanaModalAv');
            var msg = "No se han guardado cambios";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            return;
        }
        if (document.getElementById('bxCod00').disabled === false) {
            if ($("#bxCod00").val() == "") {
                $("#pnlDE1").show();
                $("#pnlDE2").hide();
                var ven = document.getElementById('VentanaModalAv');
                var msg = "Código DE obligatorio";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
                return;
            }
        }
//        if (document.getElementById('bxCod002').disabled === false) {
//            if ($("#bxCod002").val() == "") {
//                $("#pnlDE1").hide();
//                $("#pnlDE2").show();
//                var ven = document.getElementById('VentanaModalAv');
//                var msg = "Código DE obligatorio";
//                abrirVentanaAv(ven, msg);
//                var theHandle = document.getElementById("handleAV");
//                var theRoot = document.getElementById("VentanaModalAv");
//                Drag.init(theHandle, theRoot);
//                return;
//            }
//        }
        if (document.getElementById('bxCodnn2').value != "") {
            insertarDecisionEmpleoCap();
            actualizaConjunto2();
        }
        if ($("#Textlib0").val() != "") {
            dividirTexto132Char();
        }
        if (document.getElementById('bxCod00').disabled === false) {
            insertarDecisionEmpleo();
            actualizaConjunto();
            insertarCabLotInsp();
            insertarPosLotIns();
            dividirTexto132CharResultados();
            setTimeout("ActualizaFolio();", 1000);
        }
        cerraventabs('VentanaModalCalidad');
        $("#btnCancelCld").show();
    });

});
function ActualizaFolio()
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
        }
    };
    xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=ActualizarFolioPM", true);
    xmlhttp.send();
}

function checkDec(num, tam) {
    var limit;
    var FINC;
    if (tam == 3) {
        limit = 9999999.999;
        FINC = "Formato Incorecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
    } else {
        limit = 99999999.99;
        FINC = "Formato Incorecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
    }
    if (num.length > 0) {
        if (parseFloat(limit) >= parseFloat(num)) {
            va = num.split(".");
            v01 = va[0];
            if (v01.length == 0) {
                v01 = "0";
            }
            v0 = parseInt(v01);
            v1 = va[1];
            if (num.indexOf(".") != -1) {
                if (v1.length > tam) {
                    var da = v1.substr(0, tam);
                    borrarmsg();
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    borrarmsg();
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                borrarmsg();
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
            mensajesValidacionInco(FINC);
            return "";
        }
    } else {
        borrarmsg();
        return "";
    }

}

function rowsOfTable(table) {
    var rows = $('#' + table + ' >tbody >tr').length;
    return rows;
}
function borrarmsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
}
function checkRowDbResul(pos) {
    var cual = $('#cldn' + pos).text();
    if (cual == "01")
    {
        var res = $('#bxcld7' + pos).val();
        $('#bxcld7' + pos).val(checkDec(res, '3'));
    }
    if (cual == "03")
    {
        var res = parseInt($('#bxcld7' + pos).val());
        var ins = parseInt($('#bxcld6' + pos).val());

        $('#bxcld7' + pos).val(res);
        if (res < 0)
        {
            res = res * -1;
            $('#bxcld7' + pos).val(res);
        }
        $('#bxcld6' + pos).val(ins);
        if (ins < 0)
        {
            ins = ins * -1;
            $('#bxcld6' + pos).val(ins);
        }
    }
    if (!$("#bxCod" + pos).prop('disabled')) {
        var check = getCodigoTrue($("#bxCod" + pos).val(), $("#bxCodn" + pos).val());
        if (check == 0) {
            return 1;
        }
    } else {
        var res = parseFloat($('#bxcld7' + pos).val());
        var insp = parseInt($("#bxcld6" + pos).val());
        var aInsp = parseFloat($('#cld5' + pos).text());
        if (!(insp <= aInsp)) {
            return 2;
        }

        if (res > insp) {
            if (cual == "03") {
                return 4;
            }
        }
        if (insp == 0) {
            return 2;
        }
        if (insp < aInsp && res == 0) {
            if ($("#bxcld70" + pos).val() == "") {
                return 3;
            } else {
                return 0;
            }
        }
        return 0;
    }
    return 0;
}

function checkRowEmptyResul(i) {
    var cual = $('#cldn' + i).text();
    var check = 0;
    if (cual == "01") {
        if ($("#bxcld7" + i).val().length < 1) {
            check = 2;
        }
    } else if (cual == "02") {
        if ($("#bxCod" + i).val().length < 1) {
            check = 3;
        }
//        else if ($("#cld12" + i).val().length < 1) {
//            check = 4;
//        }
    } else if (cual == "03") {
        if ($("#bxcld6" + i).val().length < 1) {
            check = 1;
        } else if ($("#bxcld7" + i).val().length < 1) {
            check = 2;
        }
//        else if ($("#cld12" + i).val().length < 1) {
//            check = 4;
//        }
    }
    return check;
}

function selectRowDbResult(type, pos) {
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Codigo invalido";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxCod" + pos).focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Cantidad no valida";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxcld6" + pos).focus();
            break;
        case 3:
            if ($("#bxcld70" + pos).val() == "")
            {
                mostrarvenFr('VentanaModalForzar');
                var theHandle = document.getElementById("handleAV1");
                var theRoot = document.getElementById("VentanaModalForzar");
                Drag.init(theHandle, theRoot);
                $("#bxcld6" + pos).focus();
                var v1 = $('#ccld1' + pos).text();
                var v2 = $('#cld2' + pos).text();
                $("#lblCar").html(v1);
                $("#lbltxb").html(v2);
                $("#lblpos").html(pos);
            }
            break;
        case 4:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Cantidad no valida";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxcld7" + pos).focus();
            break;
    }
}

function selectRowEmptyResul(type, pos) {
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxcld6" + pos).focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxcld7" + pos).focus();
            break;
        case 3:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#bxCod" + pos).focus();
            break;
        case 4:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById("handleAV");
            var theRoot = document.getElementById("VentanaModalAv");
            Drag.init(theHandle, theRoot);
            $("#cld12" + pos).focus();
            break;
    }
}

function getCodigoTrue(cod, grp) {
    var type;
    var dataSend = "&cod=" + cod + "&v3=" + grp;
    var acc = "validarCodigo";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}

function validarTabRes() {
    var rows = rowsOfTable('TabBody2');
    var row;
    for (var i = 0; i < (rows - 1); i++) {
        row = checkRowEmptyResul(i);
        if (row == 0) {
            row = checkRowDbResul(i);
            if (row == 0) {

            } else {
                selectRowDbResult(row, i);
                return;
            }
        } else {
            selectRowEmptyResul(row, i);
            return;
        }
    }
    $("#btnCancelCld").hide();
    $("#btnGrabarR").prop("disabled", true);
    $("#SecCuerpoCld").find(":text").prop('disabled', true);
    var iconm = document.getElementById("iconmsg");
    iconm.style.display = "inline";
    iconm.style.visibility = "visible";
    iconm.src = "images/aceptar.png";
    var men = document.getElementById("msg");
    men.innerHTML = "Se han grabado los resultados para la operación " + $("#lbloper").text();
//    abrirVentanaMsgAddFileCalidad();
}

function actualizaConjunto() {
    var acc = "ActualizaConjunto";
    try {
        var dataSend = "&v1=" + $('#lblOrdCld').text();

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function actualizaConjunto2() {
    var acc = "ActualizaConjunto2";
    try {
        var dataSend = "&v1=" + $('#lblOrdCld').text();

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function insertarCabLotInsp() {
    var acc = "CabeceraCalidadPM";
    try {
        var dataSend = "&v1=" + $('#lblLoteICld').text()
                + "&v2=" + $('#lblOrdCld').text()
                + "&v3=" + $('#lbloper').text()
                + "&v4=" + $('#lblTxtCld').text()
                + "&v5=" + $('#lblCtrCld').text()
                + "&v6=" + $('#lblCreadoCld').text()
                + "&v7=" + $('#lblFchCCld').text()
                + "&v8=" + $('#lblHrCld').text()
                + "&v9=" + $('#lblModificadoCld').text()
                + "&v10=" + $('#lblFchMCld').text()
                + "&v11=" + $('#lblHr2Cld').text()
                + "&v12=" + $('#lblUsrCld').text();

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function dividirTexto132Char() {
    var txt = document.getElementById('Textlib0');
    var c = 132;
    var cc = 1;
    for (var x = 0; x < txt.value.length; x += 132)
    {
        var txtArr = new Array();
        txtArr[0] = cc;
        txtArr[1] = txt.value.substring(x, c);
        grabaTextoDefectos(txtArr);
        c += 132;
        cc++;
    }
}
function dividirTexto132CharResultados() {
    var pos = document.getElementsByName('cld1');
    for (var i = 0; i < pos.length; i++) {
        var c = 132;
        var cc = 1;
        var txt = document.getElementById("TextlibNota" + i);
        for (var x = 0; x < txt.value.length; x += 132)
        {
            var txtArr = new Array();
            txtArr[0] = cc;
            txtArr[1] = txt.value.substring(x, c);
            txtArr[2] = pos[i].textContent;
            grabaTextoLibreResultados(txtArr);
            c += 132;
            cc++;
        }
    }
}
function grabaTextoDefectos(txtA) {
    var acc = "TextoDecisionEmpleo";
    try {
        var dataSend = "&v1=" + txtA[0]
                + "&v2=" + txtA[1];

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function grabaTextoLibreResultados(txtA) {
    var lotins = document.getElementById('lblLoteICld').innerHTML;
    var acc = "TextoLibreResultados";
    try {
        var dataSend = "&v1=" + lotins
                + "&v2=" + txtA[2]
                + "&v3=" + txtA[0]
                + "&v4=" + txtA[1];

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function insertarDecisionEmpleo() {
    var acc = "DecisionEmpleo";
    try {
        var dataSend = "&v1=" + $('#lblLoteICld').text()
                + "&v2=" + $('#lblCtrCld').text()
                + "&v3=" + $('#lblOrdCld').text()
                + "&v4=" + $('#bxCod00').val()
                + "&v5=" + $('#bxCodn').val()
                + "&v6=" + $('#lblTxtDE').text()//pendiente
                + "&v7=" + $('#lblCreadoCld').text();//pendiente

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function insertarDecisionEmpleoCap() {
    var acc = "DecisionEmpleoCap";
    try {
        var dataSend = "&v1=" + $('#lblLoteICld').text()
                + "&v2=" + $('#lblCtrCld').text()
                + "&v3=" + $('#lblOrdCld').text()
                + "&v4=" + $('#bxCod002').val()
                + "&v5=" + $('#bxCodnn2').val()
                + "&v6=" + $('#lblTxtDE2').text()
                + "&v7=" + $('#lblCreadoCld').text();

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + dataSend,
            success: function (data) {
            }
        });
    } catch (e) {
//        alert(e);
    }
}
function insertarPosLotIns() {
    var acc = "PosicionesCalidadPM";
    var rows = rowsOfTable('TabBody2');

    try {
        for (var i = 0; i < (rows - 1); i++) {
            var dataSend = "&v1=" + $('#lblLoteICld').text()
                    + "&v2=" + $('#ccld1' + i).text()
                    + "&v3=" + $('#cld2' + i).text()
                    + "&v4=" + $('#cld3' + i).text()
                    + "&v5=" + 0
                    + "&v6=" + $('#bxcld7' + i).val()
                    + "&v7=" + $('#bxcld70' + i).val()
                    + "&v8=" + $('#bxCod' + i).val()
                    + "&v9=" + $('#cld12' + i).val()
                    + "&v10=" + $('#cldn' + i).text()
                    + "&v11=" + $('#bxcld6' + i).val()
                    + "&v12=" + ck_ValoracionI(i, $('#cldn' + i).text());
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionGuardaMovMateriales',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + dataSend,
                success: function (data) {
                }
            });
        }
    } catch (e) {
//        alert(e);
    }
}

function ck_ValoracionI(p, tp){
    switch(tp){
        case "03":
            var vl = document.getElementsByName('cld8');
            if(vl[p].textContent == ""){
//                if(parseFloat($('#bxcld6' + p).val()) == parseFloat($('#cld5' + p).text()) && parseFloat($('#bxcld7' + p).val()) == 0){
//                    return "A";
//                }
                if(parseFloat($('#bxcld7' + p).val()) > 0){
                    return "R";
                }else{
                    return "A";
                }
            }else { 
                return vl[p].textContent; 
            }
            break;
        case "01":
            //Limite inferior
            if($('#cldrg3' + p).text() == "X" && $('#cldrg4' + p).text() == ""){
                if(parseFloat($('#bxcld7' + p).val()) >= parseFloat($('#cldrg1' + p).text())){
                    return "A";
                }else{ return "R"; }
            }
            //Limite superior
            if($('#cldrg3' + p).text() == "" && $('#cldrg4' + p).text() == "X"){
                if(parseFloat($('#bxcld7' + p).val()) <= parseFloat($('#cldrg2' + p).text())){
                    return "A";
                }else{ return "R"; }
            }
            //Entre rangos
            if($('#cldrg3' + p).text() == "X" && $('#cldrg4' + p).text() == "X"){
                if(parseFloat(parseFloat($('#bxcld7' + p).val()) >= parseFloat($('#cldrg1' + p).text()) && $('#bxcld7' + p).val()) <= parseFloat($('#cldrg2' + p).text())){
                    return "A";
                }else{ return "R"; }
            }
            //Sin limite
            if($('#cldrg3' + p).text() == "" && $('#cldrg4' + p).text() == ""){
                return "A";
            }
            break;
        case "02":
            return $('#cldrg5' + p).text();
            break;
        default:
            return "";
            break;
    }
}

function abrirVentanaAv(ventana, msg)
{
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    document.getElementById("lbAv").innerHTML = msg;
}

function selectMatchCod(type, pos, data, valoracion) {
    switch (type) {
        case 'codInsp':
            $("#bxCod" + pos).val(data);
            $("#cldrg5" + pos).html(valoracion);
            ocultarVentana('VentanaModalInspCod', '');
            break;
    }
    matchInspCod2();
}

function cargarDataCodInd(pos, gpoCod) {
    acc = "consultaCodigos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=" + acc + "&conjS=" + gpoCod + "&pos=" + pos + "&idi=" + idioma,
        success: function (rs) {
            var temp = new Array();
            temp = rs.split(",");
            if (temp[0] == 0) {
                ocultarVentana(temp[1], temp[2]);
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "No hay valores por mostrar";
            } else {
                $("#cargarDatosInspCod").html(rs);
                mostrarVentana('VentanaModalInspCod');
                var theHandle = document.getElementById('handle24');
                var theRoot = document.getElementById('VentanaModalInspCod');
                Drag.init(theHandle, theRoot);
            }
        }
    });
}
function mostrarVentana(t)
{
    var ven = document.getElementById(t);
    abrirVentanaModalClsInf(ven);
//    $("#" + t).css('z-index', 11);

}
function abrirVentanaModalClsInf(ventana) {
    var ancho = 350;
    var alto = 650;
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
function matchInspCod2() {
    if ($("#bxCod00").val() != "") {
        getDataCod();
    }
    if ($("#bxCod002").val() != "") {
        getDataCod2();
    }
}
function getDataCod() {
    var cod = $("#bxCod00").val();
    var cli = $("#clidi").val();
    var acc = "getDataCod";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PatecionNotificacionesCmb',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&v1=" + cod + "&v2=" + cli,
        success: function (rs) {
            $("#lblTxtDE").html(rs[1]);
            $("#bxCodn").val(rs[0]);
        }
    });
}
function getDataCod2() {
    var cod = $("#bxCod002").val();
    var cli = $("#clidi").val();
    var acc = "getDataCod";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PatecionNotificacionesCmb',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&v1=" + cod + "&v2=" + cli,
        success: function (rs) {
            $("#lblTxtDE2").html(rs[1]);
            $("#bxCodnn2").val(rs[0]);
        }
    });
}
function matchInspCod(pos, gpoCod, catGpo) {
    acc = "consultarGpoCod";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=" + acc + "&conjS=" + gpoCod,
        success: function (rs) {
//            $("#catInsCod").html(catGpo);
            $("#conjInsCod").html(gpoCod);
            $("#gpoCodInsCod").html(rs);
            cargarDataCodInd(pos, gpoCod);
        }
    });
}

function CodBtnShow(val)
{
    var CheckBx = document.getElementsByName('cld10');
    var CheckBx2 = document.getElementsByName('cld14');
    document.getElementById("btnCod" + val).style.display = "inline";
    for (var i = 0; i < CheckBx.length; i++)
    {
        if (CheckBx[i] != document.getElementById("btnCod" + val))
        {
            CheckBx[i].style.display = "none";
        }
        try {
            CheckBx2[i].style.display = "none";
        } catch (e) {
        }
    }
}
function CodBtnShowNota(val)
{
    var CheckBx = document.getElementsByName('cld10');
    var CheckBx2 = document.getElementsByName('cld14');
    document.getElementById("btCodNota" + val).style.display = "inline";
    for (var i = 0; i < CheckBx2.length; i++)
    {
        if (CheckBx2[i] != document.getElementById("btCodNota" + val))
        {
            CheckBx2[i].style.display = "none";
        }
        try {
            CheckBx[i].style.display = "none";
        } catch (e) {
        }
    }
}


function TablaCaracteristicas(val, cnt) {
    val = $("#notor").val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=Notificaciones&v1=" + val + "&v2=" + cnt,
        success: function (data) {
            $("#btnGrabarR").show();
            $("#btnGrabarR").prop("disabled", false);
            document.getElementById('SecCuerpoCld').innerHTML = data;
            AjustarCabecera('TabHead2', 'TabBody2', 8, 'SecCuerpoCld');
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody2").offsetHeight + "px";
//            bloquearCamposResul();
        }
    });
}
function TablaCaracteristicasConjunto(nlote, orden) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=Notificaciones2&v1=" + nlote.trim() + "&v2=" + orden.trim(),
        success: function (data) {
            $("#btnGrabarR").hide();
            $("#btnGrabarR").prop("disabled", true);
            document.getElementById('SecCuerpoCld').innerHTML = data;
            AjustarCabecera('TabHead2', 'TabBody2', 8, 'SecCuerpoCld');
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody2").offsetHeight + "px";
//            bloquearCamposResul();
        }
    });
}

function cargarCabeceraCalidad() {
    var orden = $("#notor").val();
    var usuario = $("#usua").val();
    acc = "CabeceraCalidad";
//    var folLotIns = parseInt(getQMactual());
//    $("#lotI").val(folLotIns);
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PeticionNotificacionesCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&orden=" + orden,
        success: function (rs) {
            $("#lblOrdCld").html(orden);
            $("#lblLoteICld").html(rs[0]);
            $("#lblCreadoCld").html(rs[1]);
            $("#lblModificadoCld").html(rs[2]);
            $("#lblTxtCld").html(rs[3]);
            $("#lblCtrCld").html(rs[4]);
            $("#lblFchCCld").html(rs[5]);
            $("#lblFchMCld").html(rs[6]);
            $("#lblFchCCld3").html(formato(rs[5]));//Visual
            $("#lblFchMCld3").html(formato(rs[6]));//Visual
            $("#lblHrCld").html(rs[7]);
            $("#lblHr2Cld").html(rs[8]);
            $("#lblUsrCld").html(usuario);
        }
    });
}

function formato(texto){
  return texto.replace(/^(\d{4})-(\d{2})-(\d{2})$/g,'$3.$2.$1');
}

function getQMactual() {
    var acc = "getCurrentQM";
    var check;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=" + acc,
        success: function (data) {
            check = data;
        }
    });
    return check;
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
    $('#honot').val(h + ":" + m + ":00");
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}


function backto() {
    var re = $("#bt").val();
    if (re.length > 0) {
        history.back();
    } else {
        back();
    }
}


function back() {
    window.location.href = "Bienvenido.jsp";
}
function mostrar(e, r) {
    tecla = (document.all) ? e.keyCode : e.which;
    $("#ivreq").html("d");
    var acc = "checarOrden";
    if (tecla == 13) {
        if (r == null || r == "") {
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            msgMatch("NPMCamOrOb");

        } else {
            borrarmsg();
            var enviar = "&ord=" + r;
            var eq = $('#nteq').val();
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionNotificacionesOrdenesSAM',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + enviar,
                success: function (data) {
                    var res = data;
                    if (res == 0) {
                        ordsta();
                        ordequ();
                        tabmax();
                        if (eq == '')
                        {
                            $("#VisDoo").prop("disabled", false);
                            $('#VisDoo').click(function () {
                                if ($("#nteq").val() != "") {
                                    VisDoc();
                                } else {
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Campo equipo vacio";
                                }

                            });
                        } else {
                            $("#VisDoo").prop("disabled", true);
                        }

                    } else if (res == 2) {
                        tabmaxPASAM();
                        CargaTabEQSAM();
//                                            CargarEQUI();
                    } else {
                        $("#iconmsg").css("visibility", "visible");
                        $("#iconmsg").attr("src", "images/advertencia.PNG");
                        msgMatch("NPMOrNoExx2");
                    }
                    tabCar();
                },
            });
        }
    }

}
function mostrar1() {
    $("#divreq").html("d");
    var ord = $("#notor").val();
    var acc = "checarOrden";
    var eq = $('#nteq').val();
    if (ord == "" || ord == null) {
        $("#iconmsg").css("visibility", "visible");
        $("#iconmsg").attr("src", "images/advertencia.PNG");
        msgMatch("NPMCamOrOb");
    } else {
        borrarmsg();
        var enviar = "&ord=" + ord;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionNotificacionesOrdenesSAM',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                var res = data;
                if (res == 0) {
                    ordsta();
                    ordequ();
                    tabmax();
                    if (eq == '')
                    {
                        $("#VisDoo").prop("disabled", false);
                        $('#VisDoo').click(function () {
                            if ($("#nteq").val() != "") {
                                VisDoc();
                            } else {
                                var men = document.getElementById("msg");
                                men.innerHTML = "Campo equipo vacio";
                            }

                        });
                    } else {
                        $("#VisDoo").prop("disabled", true);
                    }
                } else if (res == 2) {
                    tabmaxPASAM();
                    CargaTabEQSAM();
                } else {
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    msgMatch("NPMOrNoExx2");
                }
                tabCar();
            }
        });
    }
}
function tabCar() {
    var mat = $("#notmat").val();
    var lot = $("#notlote").val();
    if (mat == "" || lot == "") {
        $("#tdl1").html("&nbsp;");
        $("#tdl2").html("&nbsp;");
        $("#tdl3").html("&nbsp;");
        $("#tdl4").html("&nbsp;");
        $("#tdl5").html("&nbsp;");
        $("#tdl6").html("&nbsp;");
        $("#tdr1").html("&nbsp;");
        $("#tdr2").html("&nbsp;");
        $("#tdr3").html("&nbsp;");
        $("#tdr4").html("&nbsp;");
        $("#tdr5").html("&nbsp;");
        $("#tdr6").html("&nbsp;");
        return;
    }
    var acc = "getDataEQ";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PatecionNotificacionesCmb',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&v1=" + mat + "&v2=" + lot,
        success: function (rs) {
            $("#tdl1").text("STATUS MONTAJE");
            $("#tdl2").text("NúmeroEquipo");
            $("#tdl3").text("FECHA MONTAJE");
            $("#tdl4").text("FECHA DESMONTAJE");
            $("#tdl5").text("ULTIMA MEDICIÓN");
            $("#tdl6").text("ULTIMO OVERHOLLING");

            $("#tdr1").text(rs[0]);
            $("#tdr2").text(rs[1]);
            $("#tdr3").text(rs[2]);
            $("#tdr4").text(rs[3]);
            $("#tdr5").text(rs[4]);
            $("#tdr6").text(rs[5]);
        }

    });
}
function ordsta() {
    var ord = $("#notor").val();
    var oper = $("#notope").val();
    var enviar = "&ord=" + ord + "&oper=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionNotificCabOrde",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            $("#divoc").html(res);
            poner();
        }

    });

}


function CargaTabEQSAM() {
    var ord = $("#notor").val();
    var acc = "CarEQORD";
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "act=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#divreq").html(res);
            colcequ2();
        }

    });

}
function colcequ2() {
    var almno = $("#almno").val();
    $("#notalm").val(almno);
    var cenno = $("#cenno").val();
    $("#notcent").val(cenno);
    var eqsuno = $("#eqsuno").val();
    $("#notesp").val(eqsuno);
    var lotno = $("#lotno").val();
    $("#notlote").val(lotno);
    var matno = $("#matno").val();
    $("#notmat").val(matno);
    var neqno = $("#neqno").val();
    $("#nteq").val(neqno);
    var seno = $("#seno").val();
    var desne = $("#desne").val();
    $("#ntdeseq").val(desne);
    var est = $("#Statusor").val();
    $("#notsta").val(est);
    $("#nteqch").prop("checked", false);
    $("#desmo").attr("disabled", true);
    $("#desmo2").attr("disabled", true);
}
function ordequ() {
    var ord = $("#notor").val();
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionEquiposNotPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            $("#divreq").html(res);
            colcequ();
        }

    });

}
function tabmax() {
    var ord = $("#notor").val();
    var ope = $("#notope").val();
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTabGrand",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            $("#bodyc").html(res);
        }

    });

}

function tabmaxPASAM() {
    var ord = $("#notor").val();
    var ope = $("#notope").val();
    var acc = "CarTAbUN";
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "act=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#bodyc").html(res);
        }

    });
}

function poner() {
    var sta2 = $("#nosta").val();
    var sta1 = $("#notsta").val(sta2);
}

function colcequ() {
    var eqmonodes = $("#eqmonodes").val();
    var almno = $("#almno").val();
    $("#notalm").val(almno);
    var cenno = $("#cenno").val();
    $("#notcent").val(cenno);
    var eqsuno = $("#eqsuno").val();
    $("#notesp").val(eqsuno);
    var lotno = $("#lotno").val();
    $("#notlote").val(lotno);
    var matno = $("#matno").val();
    $("#notmat").val(matno);
    var neqno = $("#neqno").val();
    $("#nteq").val(neqno);
    var seno = $("#seno").val();
    var desne = $("#desne").val();
    $("#ntdeseq").val(desne);
    var dessue = $("#dessue").val();
    $("#notdesesp").val(dessue);

    $("#desmo").prop("disabled", false);
    $("#desmo2").prop("disabled", false);

    if (eqmonodes == "M") {
        $("#nteqch").prop("checked", true);
    } else if (eqmonodes == "D") {
        $("#nteqch").prop("checked", false);
    }

}



function CargarEQUI() {

    $("#notsta").val("LIB.");
    $("#notalm").val("");
    $("#notcent").val("");
    $("#notesp").val("");
    $("#notmat").val("");
    $("#nteq").val("");
    $("#ntdeseq").val("");
    $("#notdesesp").val("");
    $("#notlote").val("");
    $("#nteqch").prop("checked", false);
    $("#desmo").attr("disabled", true);
    $("#desmo2").attr("disabled", true);

}
function libbot() {
    if ($('#notor').val().length === 0) {
        var ven = document.getElementById('VentanaModalAv');
        var msg = "Número de orden obligatorio";
        abrirVentanaAv(ven, msg);
        var theHandle = document.getElementById("handleAV");
        var theRoot = document.getElementById("VentanaModalAv");
        Drag.init(theHandle, theRoot);
        return;
    }
    var usu = $("#usua").val();
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);
    var ord = $("#notor").val();
    var fenot = $("#fenot").val();
    var honot = $("#honot").val();

    if (ptr == "LIB." || ptr == "" || ptr == "CTEC" || ptr == "CERR") {
        $(document).ready(function () {
//                         $("BODY").append('<div id="overlay"></div>');
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else if (ptr == 'ABIE') {
        var t1 = sta,
                patron = /ABIE/g,
                nuevoValor = "LIB.",
                nuevaCadena1 = t1.replace(patron, nuevoValor);
        sta = $("#notsta").val(nuevaCadena1);
        var action;
        if (ord.length == 12) {
            action = "DatosCab";
        } else {
            action = "DatosCabSAM";
        }
        var stat = "L";
        var enviar = "&ord=" + ord + "&ope=" + nuevaCadena1 + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
            }

        });
    }

}






function solatarMat(id) {
    var mate = document.getElementById("matab1" + id).value;
    var arr = new Array();
    var acc = "CarMatInv";
    var r1, r2, r3, r4, r5;
    var enviar = "&mate=" + mate.toUpperCase();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionNotificacionesOrdenesSAM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            arr = data.split(",");
            r1 = arr[0];
            r2 = arr[1];
            r3 = arr[2];
            r4 = arr[3];
            r5 = arr[4];
//               alert(id+" , "+r1+" , "+r2+" , "+r3+" , "+r4+" , "+r5);
            if (r1 == 1) {
                $("#cein" + id).html(r2);
                $("#unmin" + id).html(r3);
                $("#almin" + id).html('M100');
                $("#Texde" + id).html(r5);
                if (r4 === "" || r4 === null) {
                    $("#lotabp1" + id).prop("disabled", true);
                } else {
                    $("#lotabp1" + id).prop("disabled", false);
                }
            } else {
                $("#cein" + id).html("");
                $("#unmin" + id).html("");
                $("#almin" + id).html("");
                $("#lotabp1" + id).prop("disabled", false);
                $("#Texde" + id).html("");

            }
        }

    });
}
function inpufunci(ids) {
    $("#matab1" + ids).blur(function () {
        solatarMat(ids);
    });

//                     $('#matab1'+ ids).keypress(function (e) {
//                            var te = (document).all ? e.keyCode : e.which;
//                            if (te == 13) {
//                                alert("hola "+ids);
//                            }
//                        });
}

function mosbot(ids) {
    inpufunci(ids);
    for (var i = 0; i < 51; i++) {
        if (ids != i) {
            $("#matmat1" + i).css("display", "none");
        } else {
            $("#matmat1" + ids).css("display", "inline");
        }
    }

}
function selecoftab2() {
    var ord = $("#notor").val();
    var ja = document.getElementsByName("checkbo");
    var eja = document.getElementsByName("che");
    var fs = new Array();
    var v1;
    var v2;
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);

    for (var i = 0; i < ja.length; i++) {
        if (ja[i].checked) {
            if (eja[i].checked) {
                var vanf = eja[i].value;
                var val = ja[i].value;

                fs = val.split(",");
                v1 = fs[0];
                v2 = fs[1];

                if (v1 == "PM01") {
                    if (ord.length <= 10) {
                        cerravisos2();
                        pm1prt1FORSAM(ord, v2);
                        pm1prt3FORSAM(ord, v2);
                        //         $("BODY").append('<div id="overlayve"></div>');
                        mostrarventabs("ventaPM01");
                        var theHandle = document.getElementById("handlePM01");
                        var theRoot = document.getElementById("ventaPM01");
                        Drag.init(theHandle, theRoot);
                    } else {
                        cerravisos2();
                        pm1prt1(ord, v2);
                        pm1prt3(ord, v2);
                        //       $("BODY").append('<div id="overlayve"></div>');
                        mostrarventabs("ventaPM01");
                        var theHandle = document.getElementById("handlePM01");
                        var theRoot = document.getElementById("ventaPM01");
                        Drag.init(theHandle, theRoot);
                    }
                } else if (v1 == "QM01") {
                    cerravisos2()
                    qm1prt1(ord);
                    qm1prt2(ord, v2);
                    qm1prt3(ord);
                    qm1prt4(ord);
                    //        $("BODY").append('<div id="overlayve"></div>');
                    mostrarventabs("ventaQM01");                    
                } else if (v1 == "PM03") {
                    if (ord.length == 10) {
                        cerravisos2();
                        pm3prt1FORSAM(ord, v2);
                        pm3prt2FORSAM(ord, v2);
                        pm3prt3FORSAM(ord, v2);
                    } else {
                        cerravisos2();
                        pm3prt1(ord, v2);
                        pm3prt2(ord, v2);
                        pm3prt3(ord, v2);
                        pm3prt4(ord, v2);
                    }
                    //          $("BODY").append('<div id="overlayve"></div>');
                    mostrarventabs("ventatabdes");
                    var theHandle = document.getElementById("handleDes");
                    var theRoot = document.getElementById("ventatabdes");
                    Drag.init(theHandle, theRoot);
                } else if (v1 == "PM02") {
                    if (ord.length == 10) {
                        cerravisos2();
                        pm3prt1FORSAM(ord, v2);
                        pm3prt2FORSAM(ord, v2);
                        pm3prt3FORSAM(ord, v2);
                    } else {
                        cerravisos2();
                        pm3prt1(ord, v2);
                        pm3prt2(ord, v2);
                        pm3prt3(ord, v2);
                        pm3prt4(ord, v2);
                    }
                    //          $("BODY").append('<div id="overlayve"></div>');
                    mostrarventabs("ventatabdes");
                    var theHandle = document.getElementById("handleDes");
                    var theRoot = document.getElementById("ventatabdes");
                    Drag.init(theHandle, theRoot);
                } else {
                    $(document).ready(function () {
                        //                        $("BODY").append('<div id="overlay"></div>');
                        mostrarventaavi();
                        var theHandle = document.getElementById("handleAv2");
                        var theRoot = document.getElementById("ventanaavis");
                        Drag.init(theHandle, theRoot);
                    });
                }
            }
        }
    }

}
var cenOpe;
function selecoftab() {
    var ord = $("#notor").val();
    var ja = document.getElementsByName("checkbo");
    var eja = document.getElementsByName("che");
    var fs = new Array();
    var v1;
    var v2;
    var v3;
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);

    if (ptr == "CERR" || ptr == "CTEC" || ptr == "" || ptr == "ABIE" || ptr == "CERR") {
        $(document).ready(function () {
            //                         $("BODY").append('<div id="overlay"></div>');
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else {
        for (var i = 0; i < ja.length; i++) {
            if (ja[i].checked) {
                if (eja[i].checked) {

                    $(document).ready(function () {
//                                $("BODY").append('<div id="overlay"></div>');
                        msgMatch('NOTSTfin');
                        mostrarventaavi2();
                        var theHandle = document.getElementById("handleAv3");
                        var theRoot = document.getElementById("ventanaavis2");
                        Drag.init(theHandle, theRoot);
                    });
                } else {

                    var val = ja[i].value;

                    fs = val.split(",");
                    v1 = fs[0];
                    v2 = fs[1];
                    v3 = fs[2];
                    cenOpe = v3;
                    if (v1 == "PM01") {
                        if (ord.length <= 10) {
                            pm1prt1FORSAM(ord, v2);
                            pm1prt3FORSAM(ord, v2);
                            //  $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventaPM01");
                            var theHandle = document.getElementById("handlePM01");
                            var theRoot = document.getElementById("ventaPM01");
                            Drag.init(theHandle, theRoot);
                        } else {
                            pm1prt1(ord, v2);
                            pm1prt3(ord, v2);
                            // $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventaPM01");
                            var theHandle = document.getElementById("handlePM01");
                            var theRoot = document.getElementById("ventaPM01");
                            Drag.init(theHandle, theRoot);
                        }
                    } else if (v1 == "QM01") {
                        $("#bxCod00").val("");
                        $("#bxCodn").val("");
                        $("#lblTxtDE").html("");
                        $("#bxCod002").val("");
                        $("#bxCodnn2").val("");
                        $("#lblTxtDE2").html("");
                        $("#Textlib0").val("");
                        qm1prt1(ord);
//                            qm1prt2(ord, v2);
                        $("#lbloper").text(v2);
                        qm1prt3(ord);
                        qm1prt4(ord);
                        //  $("BODY").append('<div id="overlayve"></div>');
                        mostrarventabs2("VentanaModalCalidad");
                        cargarCabeceraCalidad();
                        $("#lblTxtEQ").text($("#nteq").val());
                        verificaOrdenConjunto();
                        var theHandle = document.getElementById('handle22');
                        var theRoot = document.getElementById('VentanaModalCalidad');
                        Drag.init(theHandle, theRoot);
                    } else if (v1 == "PM03") {
                        if (ord.length == 10) {

                            pm3prt1FORSAM(ord, v2);
                            pm3prt2FORSAM(ord, v2);
                            pm3prt3FORSAM(ord, v2);
                            //      $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventatabdes");
                            var theHandle = document.getElementById("handleDes");
                            var theRoot = document.getElementById("ventatabdes");
                            Drag.init(theHandle, theRoot);
                        } else {
                            pm3prt1(ord, v2);
                            pm3prt2(ord, v2);
                            pm3prt3(ord, v2);
                            pm3prt4(ord, v2);
                            //     $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventatabdes");
                            var theHandle = document.getElementById("handleDes");
                            var theRoot = document.getElementById("ventatabdes");
                            Drag.init(theHandle, theRoot);
                        }
                    } else if (v1 == "PM02") {
                        if (ord.length == 10) {

                            pm3prt1FORSAM(ord, v2);
                            pm3prt2FORSAM(ord, v2);
                            pm3prt3FORSAM(ord, v2);
                            //     $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventatabdes");
                            var theHandle = document.getElementById("handleDes");
                            var theRoot = document.getElementById("ventatabdes");
                            Drag.init(theHandle, theRoot);
                        } else {
                            pm3prt1(ord, v2);
                            pm3prt2(ord, v2);
                            pm3prt3(ord, v2);
                            pm3prt4(ord, v2);
                            //       $("BODY").append('<div id="overlayve"></div>');
                            mostrarventabs("ventatabdes");
                            var theHandle = document.getElementById("handleDes");
                            var theRoot = document.getElementById("ventatabdes");
                            Drag.init(theHandle, theRoot);
                        }

                    } else {
                        $(document).ready(function () {
                            //                        $("BODY").append('<div id="overlay"></div>');
                            mostrarventaavi();
                            var theHandle = document.getElementById("handleAv2");
                            var theRoot = document.getElementById("ventanaavis");
                            Drag.init(theHandle, theRoot);
                        });
                    }
                }
            }
        }
    }
}
function verificaUsuarioDE() {
    var enviar = "&accion=ValidaUserDE&v1=" + $("#usua").val();
    $.ajax({
        async: false,
        type: 'GET',
        url: "PatecionNotificacionesCmb",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data == 1) {
                $("#bxCod002").prop("disabled", false);
                $("#btnCod002").show();
                $("#btCod30").show();
            } else {
                $("#bxCod002").prop("disabled", true);
                $("#btnCod002").hide();
                $("#btCod30").hide();
            }
        }
    });
}
function verificaOrdenConjunto() {
    var enviar = "&accion=ValidaOrdenCon&v1=" + $("#notor").val();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: "PatecionNotificacionesCmb",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data[0] == 1) {
                TablaCaracteristicasConjunto($("#lblLoteICld").text(), $("#lblOrdCld").text());
                $("#bxCod00").prop("disabled", true);
                $("#btnCod00").hide();
                getDataDE();
                verificaUsuarioDE();
                $("#SecCuerpoCld").find(":text").prop('disabled', true);
            } else {
                TablaCaracteristicas('', '');
                verificaUsuarioDE();
                $("#bxCod00").prop("disabled", false);
                $("#btnCod00").show();
            }
            if (data[1] == 1) {
                //LLamar metodo para llenar
                $("#bxCod002").prop("disabled", true);
                $("#btnCod002").hide();
                $("#btCod30").hide();
                getDataDECap();
            } else {
                $("#bxCod002").prop("disabled", false);
                $("#btnCod002").show();
                $("#btCod30").show();
                $("#bxCod002").val("");
                $("#bxCodnn2").val("");
                verificaUsuarioDE();
            }
        }
    });
}
function getDataDE() {

    var acc = "getDataDE";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PatecionNotificacionesCmb',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&v1=" + $("#lblLoteICld").text(),
        success: function (rs) {
            $("#bxCod00").val(rs[0]);
            $("#bxCodn").val(rs[1]);
            $("#lblTxtDE").html(rs[2]);
        }
    });
}
function getDataDECap() {

    var acc = "getDataDEcap";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PatecionNotificacionesCmb',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "accion=" + acc + "&v1=" + $("#lblLoteICld").text(),
        success: function (rs) {
            $("#bxCod002").val(rs[0]);
            $("#bxCodnn2").val(rs[1]);
            $("#lblTxtDE2").html(rs[2]);
        }
    });
}
function pm3prt1(ord, oper) {
    var enviar = "&ord=" + ord + "&oper=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionMatcPM03P1",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm13").html(data);
            pm13();
        }
    });
}
function pm3prt1FORSAM(ord, oper) {
    var acc = "POn1P3SAM";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&act=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm13").html(data);
            pm13();
        }

    });
}
function pm13() {
    var nspp32 = $("#nspp32").val();
    $("#nspp31").val(nspp32);
    var npspp32 = $("#npspp32").val();
    $("#npspp31").val(npspp32);
    var prep32 = $("#prep32").val();
    $("#prep31").val(prep32);
    var clmop32 = $("#clmop32").val();
    $("#clmop31").val(clmop32);
    var cabap32 = $("#cabap32").val();
    $("#cabap31").val(cabap32);
    var grarp32 = $("#grarp32").val();
    $("#grarp31").val(grarp32);
    var gcate32 = $("#gcate32").val();
    $("#gcate31").val(gcate32);
    var ocop32 = $("#ocop32").val();
    $("#ocop31").val(ocop32);
    var provp32 = $("#provp32").val();
    $("#provp31").val(provp32);
    var solp32 = $("#solp32").val();
    $("#solp31").val(solp32);
}
function pm3prt2(ord, oper) {
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTabpm03_1_notificaciones",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt1").html(data);
        }

    });
}
function pm3prt2FORSAM(ord, oper) {
    var acc = "POn2P3SAM";
    var enviar = "&ord=" + ord + "&act=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt1").html(data);
        }

    });
}
function pm3prt3(ord, oper) {
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTab2pm03_2_notificaciones",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt2").html(data);
        }

    });
}

function pm3prt3FORSAM(ord, oper) {
    var acc = "POn3P3SAM";
    var enviar = "&ord=" + ord + "&act=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt2").html(data);
//				poner();
        }

    });
}
function pm3prt4(ord, oper) {
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTan3pm03_3_notificaciones",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt3").html(data);
//				poner();
        }

    });
}

function pm1prt1(ord, oper) {
    var enviar = "&ord=" + ord + "&oper=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticioncabPM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm11").html(data);
            ponerp1();
        }

    });

}


function pm1prt3(ord, ope) {
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTabPM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tabp1").html(data);
            ponerp1();
        }

    });
}


function pm1prt3_1(ord, ope) {
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionTabPM01',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tabp1").html(data);
        }

    });
}

function pm1prt3FORSAM(ord, oper) {
    var acc = "TablasPM01MAt";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&act=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tabp1").html(data);
            ponerp1();
        }

    });
}

function qm1prt1(ord) {
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionCabQM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divqm11").html(data);
            cadaqm1();
        }

    });
}

function cadaqm1() {

    var nuoqm12 = $("#nuoqm12").val();
    $("#nuoqm11").val(nuoqm12);
    var nliqm12 = $("#nliqm12").val();
    $("#nliqm11").val(nliqm12);
    var crdqm12 = $("#crdqm12").val();
    $("#crdqm11").val(crdqm12);
    var umrqm12 = $("#umrqm12").val();
    $("#umrqm11").val(umrqm12);
    var txbqm12 = $("#txbqm12").val();
    $("#txbqm11").val(txbqm12);
    var cenqm12 = $("#cenqm12").val();
    $("#cenqm11").val(cenqm12);
    var fclqm12 = $("#fclqm12").val();
    $("#fclqm11").val(fclqm12);
    var fmrqm12 = $("#fmrqm12").val();
    $("#fmrqm11").val(fmrqm12);
    var hclqm12 = $("#hclqm12").val();
    $("#hclqm11").val(hclqm12);
    var hmlqm12 = $("#hmlqm12").val();
    $("#hmlqm11").val(hmlqm12);

}

function qm1prt2(ord, v2) {
    var enviar = "&ord=" + ord + "&oper=" + v2;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTab1QM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tab1q1").html(data);
            ponerp1();
        }

    });
}

function qm1prt4(ord) {
    ;
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTab3QM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tab4q1").html(data);
        }

    });
}

function qm1prt3(ord) {
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionTab2QM01",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tab2q1").html(data);
        }

    });
}


function seleccionar(we, ids, ven) {

    $("#" + ids).val(we);
    $("#" + ids).focus();
    ocultarVentana(ven);
}


function mostrarventaavi2() {

    var venaviso = document.getElementById("ventanaavis2");
    var ancho = 20;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}


function mostrarventaavi() {

    var venaviso = document.getElementById("ventanaavis");
    var ancho = 20;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}
function mostrarventabs(ven) {
    var venaviso = document.getElementById(ven);
    var ancho = 1000;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}
function mostrarventabs2(ven) {
    var venaviso = document.getElementById(ven);
    var ancho = 1300;
    var alto = 800;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}
function mostrarvenFr(ven) {
    var venaviso = document.getElementById(ven);
    var ancho = 850;
    var alto = 450;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}
function cerraventabs(id) {
    var venavisos = document.getElementById(id);
    venavisos.style.display = "none";
}
function mostrarVentanaModal(id)
{

    var ventana = document.getElementById(id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';

}
function mostrarVentanaModalH(id)
{

    var ventana = document.getElementById(id);
    var ancho = 900;
    var alto = 200;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';

}
function cerravisos2() {
    $("#ventanaavis2").css("display", "none");
}
function ocultarVentana(ids)
{
    var ventana = document.getElementById(ids);
    ventana.style.display = 'none';
    $("#BuscarParam_u1").css("display", "block");
    $("#ConsultaTabla1").css("display", "none");
    $("#BuscarParam_u2").css("display", "block");
    $("#ConsultaTabla2").css("display", "none");
}
function enterMat(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 13) {
        cargar('peticionesOrdenesCrearNoti');
    }
}
function cargar(url) {

    var env1vm = $("#env1vm").val();
    var ordmatvm = $("#ordmatvm").val();
    var txtbrvm = $("#txtbrvm").val();
    var env5vm = $("#env5vm").val();
    var enviar = "&env1vm=" + env1vm + "&ordmatvm=" + ordmatvm + "&txtbrvm=" + txtbrvm + "&env5vm=" + env5vm;
    $.ajax({
        async: false,
        type: 'GET',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            if (res == 0) {
                mesajess(0, "images/aceptar.png");

            } else {
                $("#BuscarParam_u1").css("display", "none");
                $("#ConsultaTabla1").css("display", "block");
                $("#nofixedX1").html(res);
                fnc();
            }
        }

    });
}




function MandarMat(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 13) {
        LoadMat('peticionMatMatNotPM');
    }
}

function LoadMat(url) {

    var mmmat = $("#mmmat").val();
    var mmid = $("#mmid").val();
    var mmtxtbr = $("#mmtxtbr").val();
    var env5vmat = $("#env5vmat").val();
    var mmtipMat = $("#mmtipMatt").val();
    var enviar = "&mmmat=" + mmmat + "&mmid=" + mmid + "&mmtxtbr=" + mmtxtbr + "&env5vmat=" + env5vmat + "&mmtipM=" + mmtipMat;
    $.ajax({
        async: false,
        type: 'GET',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            if (res == 0) {
                mesajess(0, "images/aceptar.png");
                setTimeout(function () {
                    $("#msg").html("");
                    $("#iconmsg").css("visibility", "hidden");
                }, 8000);
            } else {
                $("#BuscarParam_u2").css("display", "none");
                $("#ConsultaTabla2").css("display", "block");
                $("#nofixedX2").html(res);
                fnc();
            }
        }

    });
}

function fnc() {
    document.getElementById('table-scroll').onscroll = function () {

        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}

function marcacolor(color) {
    if (color.checked) {

    }
}



function vaciarCAMps() {

    $("#durp1").val("");
    $("#nofip1").val("");
    $("#nfpm1").prop("checked", false);
}
function VentModalmat(esd) {
    document.getElementById("mmid").value = esd;
    $(document).ready(function () {

        mostrarVentanaModal("VentModalmat");
        var theHandle = document.getElementById("handle11");
        var theRoot = document.getElementById("VentModalmat");
        Drag.init(theHandle, theRoot);
    });
}

function ConsMat() {

    var cc = 0;
    for (var o = 0; o < 50; o++)
    {
        var nmat = document.getElementById("matab1" + o);


        if (nmat.value == "") {
            cc++;
        }

        if (o == 49) {
            if (cc == 50)
            {
                $("#matab10").focus();
                msgMatch('NPMSinMatVaCon');
                mostrarventaavi();
            } else {
                for (var i = 0; i < 50; i++) {

                    var matab = $("#matab1" + i).val();
                    var lotabp = $("#lotabp1" + i).val();
                    var cumtabp = $("#cumtabp1" + i).val();

//                                        if (matab != "" && lotabp == "") {
//                                            document.getElementById("etav").innerHTML = "Lote es Obligatorio para Material - Centro. : " + matab;
//                                            mostrarventaavi();
//                                            break;
//                                        } else {
                    if (matab != "" && cumtabp == "") {
                        msgMatch('NPMCantRequi');
                        mostrarventaavi();
                        break;
                    } else {
                        if (i == 49) {
                            ValidarMAte(0);
                            //ValidarLotedeMAte(0);
                        }
                    }
//                                        }
                }
            }

        }

    }

}



function ValidarLotedeMAte(i) {

    var acc = "valotote";
    if (i == 50) {
        CAbecePM1();
    } else {
        while (i < 50) {

            var matab = $("#matab1" + i).val();
            var lotabp = $("#lotabp1" + i).val();
            var cumtabp = $("#cumtabp1" + i).val();
            var actida = parseInt(cumtabp);

            if (matab != "") {
                if (actida > 0) {
                    var enviar = "&matab=" + matab + "&lottabp=" + lotabp + "&acc=" + acc;
                    $.ajax({
                        async: false,
                        type: 'GET',
                        url: 'peticionNotificacionesOrdenesSAM',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: enviar,
                        success: function (data) {
                            var res = data;
                            if (res == 2) {
                                ValidarLotedeMAte(i + 1);
                            } else if (res == 0) {
                                $("#lotabp1" + i).val("");
                                ValidarLotedeMAte(i + 1);
                            } else {
                                msgMatch("NPMCanReqMC" + matab);
                                mostrarventaavi();
//                                                break;
                            }
                        }

                    });
                    break;
                } else {
                    if (i == 49) {
                        CAbecePM1();
                        break;
                    } else {
                        ValidarLotedeMAte(i + 1);
                        break;
                    }
                }
            } else {
                if (i == 49) {
                    CAbecePM1();
                    break;
                } else {
                    ValidarLotedeMAte(i + 1);
                    break;
                }
            }
        }
    }
}





function ValidarMAte(i) {

    if (i == 50) {
        ValidarLotedeMAte(0);
    } else {
        while (i < 50) {

            var lotabp = $("#lotabp1" + i).val();
            var matab = $("#matab1" + i).val();
            var cumtabp = $("#cumtabp1" + i).val();
            var actida = parseInt(cumtabp);
            if (matab != "") {

                if (actida > 0) {
                    var enviar = "&matab=" + matab + "&cumtabp=" + cumtabp + "&lotabp=" + lotabp;
                    $.ajax({
                        async: false,
                        type: 'GET',
                        url: 'peticionValidarMateNotPM',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: enviar,
                        success: function (data) {
                            var res = data;

                            if (res == 0) {
                                msgMatch('NPMSinMatVaCon');
                                mostrarventaavi();
                            } else if (res == 1) {
                                msgMatch('NPMCanLotAlNoSu');
                                mostrarventaavi();


                            } else if (res == 2) {
                                ValidarMAte(i + 1);
                            }
                        }

                    });
                    break;
                } else {
                    if (i == 49) {
                        ValidarLotedeMAte(0);
                        break;
                    } else {
                        ValidarMAte(i + 1);
                        break;
                    }
                }
            } else {
                if (i == 49) {
                    ValidarLotedeMAte(0);
                    break;
                } else {
                    ValidarMAte(i + 1);
                    break;
                }
            }
        }
    }
}
function ConsumiriFOL(rutas) {

    var acc = "CambiFol";
    var rs;
    var resp = new Array();
    var r1, r2;
    var enviar = "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionNotificacionesOrdenesSAM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            rs = data;
//                                    alert(rs);
            resp = rs.split(",");
            r1 = resp[0];
            r2 = resp[1];
            folT = "CO" + r2;
            try {
                insertDataFiles(rutas);
            } catch (err) {
            }
            if (r1 == 1) {
                $("#iconmsg").css("visibility", "visible");
                $("#iconmsg").attr("src", "images/aceptar.png");
                $("#folasmov").val(+r2);
                msgMatch("NPMMatCree");
                setTimeout(function () {
                    $("#msg").html("");
                    $("#iconmsg").css("visibility", "hidden");
                }, 8000);
                pm1prt3_1("", "");
                LiberarStatus();
            }
        }

    });
}
function CAbecePM1() {

    var numco = document.getElementsByName("cumtabp1");
    var usu = $("#usua").val();
    var i = 0;
    var p = 0;
//                        for(var i = 0; i < numco.length; i++){
    while (i < numco.length) {
        var comnu = parseInt(numco[i].value);

        if (comnu > 0) {
            var p = 1;
            break;
        } else {
            i++;
        }
    }
    if (p == 1) {
        var orden = $("#nspp11").val();
        var ope = $("#npspp11").val();
        var fecha = $("#fenot").val();
        var hora = $("#honot").val();
        var acc;
        if (orden.length == 12) {
            acc = "GuardCabec";
        } else {
            acc = "GuardCabecORD";
        }
        var enviar = "&orden=" + orden + "&ope=" + ope + "&fecha=" + fecha + "&hora=" + hora + "&usu=" + usu + "&acc=" + acc;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionNotificacionesOrdenesSAM',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                var res = data;
                if (res == 1) {
                    GuardarDAtPM1(0);
                } else {
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    msgMatch('NPMMovNoCree');
                    setTimeout(function () {
                        $("#msg").html("");
                        $("#iconmsg").css("visibility", "hidden");
                    }, 8000);


                }
            }

        });
    } else {
        $("#matab10").focus();
        msgMatch('NPMSinMatVaCon');
        mostrarventaavi();
    }
}
function GuardarDAtPM1(i) {
    if (i == 50) {
        abrirVentanaMsgAddFile();
    } else {
        while (i < 50) {
            var matab = $("#matab1" + i).val();
            var lotabp = $("#lotabp1" + i).val();
            var cumtabp = $("#cumtabp1" + i).val();
            var fecha = $("#fenot").val();
            var hora = $("#honot").val();
            var usu = $("#usua").val();
            var orden = $("#nspp11").val();
            var ope = $("#npspp11").val();
            var acc;
            if (orden.length == 12) {
                acc = "uardarDAt";
            } else {
                acc = "uardarDAtOR";
            }

            var actida = parseInt(cumtabp);

            if (matab != "") {
                if (actida > 0) {
                    var enviar = "&matab=" + matab + "&cumtabp=" + cumtabp + "&lotabp=" + lotabp + "&orden=" + orden + "&ope=" + ope + "&fecha=" + fecha + "&hora=" + hora + "&usu=" + usu + "&accion=" + acc;
                    $.ajax({
                        async: false,
                        type: 'GET',
                        url: 'peticionSaveMovimientosNotifPM',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: enviar,
                        success: function (data) {
                            var res = data;
                            if (res == 0) {

                                GuardarDAtPM1(i + 1);

                            } else {
                                $("#iconmsg").css("visibility", "visible");
                                $("#iconmsg").attr("src", "images/advertencia.PNG");
                                msgMatch('NPMMovNoCree');
                                setTimeout(function () {
                                    $("#msg").html("");
                                    $("#iconmsg").css("visibility", "hidden");
                                }, 8000);
                            }
                        }

                    });
                    break;
                } else {
                    if (i == 49) {
                        abrirVentanaMsgAddFile();
                        break;
                    } else {
                        GuardarDAtPM1(i + 1);
                        break;
                    }
                }
            } else {
                if (i == 49) {
                    abrirVentanaMsgAddFile();
                    break;
                } else {
                    GuardarDAtPM1(i + 1);
                    break;
                }
            }
        }
    }
}
function LlamarFunc() {
    setTimeout('ConsMat()', 2000);
    valnotiemP01();
}

function mosbotLot(id) {
    solatarMat(id);
    for (var i = 0; i < 51; i++) {
        if (id != i) {
            $("#matlot1" + i).css("display", "none");
        } else {
            $("#matlot1" + id).css("display", "inline");
        }
    }
}

function VentModalLote(esd) {
    var lot = "lotabp1" + esd;
    var mate = $("#matab1" + esd).val();
    var acc = "CarLotes2";
    var enviar = "&ord=" + lot + "&act=" + acc + "&mate=" + mate;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionSAMNotificacionesPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
//                                alert(data);    
            if (data == 1) {
                llamarVentModalLote(esd);
            } else {
                mensajess(0, "images/advertencia.PNG");
                setTimeout(function () {
                    $("#msg").html("");
                    $("#iconmsg").css("visibility", "hidden");
                }, 8000);
            }
        }

    });
}
function llamarVentModalLote(esd) {
    $(document).ready(function () {

        mostrarVentanaModal("VentanaModalLote");
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalLote");
        Drag.init(theHandle, theRoot);
        COnsultarLotes(esd, "VentanaModalLote");
    });
}


function  COnsultarLotes2(ven) {
    var lot = "notlote22";
    var mate = $("#notmat2").val();
    var acc = "CarLotesEQ";
    var enviar = "&ord=" + lot + "&ope=" + ven + "&act=" + acc + "&mate=" + mate;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionSAMNotificacionesPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos8").html(data);
        }

    });
}


function  COnsultarLotes(esd, ven) {
    var lot = "lotabp1" + esd;
    var mate = $("#matab1" + esd).val();
    var acc = "CarLotes";
    var enviar = "&ord=" + lot + "&ope=" + ven + "&act=" + acc + "&mate=" + mate;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionSAMNotificacionesPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos6").html(data);
        }

    });
}


function cambiarDura(dura) {
    //Dato de sap
    var durr = $('#udnp11');
    //dato que selecciona
    var sss = $('#durp2');
    var Dhm = $("#aynp11").val();
    var nuOrd = $("#notor").val();
    var acc = "ACtuadurTra";
    if (durr.val() == 'MIN' && sss.val() == 'H')
    {
        var dhm = parseFloat(Dhm) + (parseInt(dura * 60));
    } else
    {
        var dhm = parseFloat(Dhm) + parseInt(dura);
    }
    var enviar = "&dhm=" + dhm + "&nuOrd=" + nuOrd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionNotificacionesOrdenesSAM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            if (data == 1) {
                $("#aynp11").val(dhm);
            }
        },
    });


}
function retornaFiltroBus(id1, id2) {
    $("#" + id1).css("display", "block");
    $("#" + id2).css("display", "none");
}





function pm1prt1FORSAM(ord, oper) {
    var acc = "CabePM1";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&act=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionSAMNotificacionesPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm11").html(data);
            ponerp1();
        }

    });
}
function ponerp1() {
    var ivptp12 = $("#ivptp12").val();
    if (ivptp12 == "X") {
        $("#ivptp11").prop("checked", true);
    } else if (ivptp12 == "") {
        $("#ivptp11").prop("checked", false);
    }
    var nspp12 = $("#nspp12").val();
    $("#nspp11").val(nspp12);
    var npspp12 = $("#npspp12").val();
    $("#npspp11").val(npspp12);
    var txbp12 = $("#txbp12").val();
    $("#txbp11").val(txbp12);
    var canbap12 = $("#canbap12").val();
    $("#canbap11").val(canbap12);
    var umpp12 = $("#umpp12").val();
    $("#umpp11").val(umpp12);
    var donp12 = $("#donp12").val();
    $("#donp11").val(donp12);
    var udnp12 = $("#udnp12").val();
    $("#udnp11").val(udnp12);
    var top12 = $("#top12").val();
    $("#top11").val(top12);
    var utp12 = $("#utp12").val();
    $("#utp11").val(utp12);
    var aynp12 = $("#aynp12").val();
    $("#aynp11").val(aynp12);

    var usea = $("#usua").val();
    $("#trrep1").val(usea);

}
var folT;
function valnotiemP01() {
    var durp1 = $("#durp1").val();
    var durp2 = $("#durp2").val();
    var trrep1 = $("#trrep1").val();
    var usu = $("#usua").val();
    var nfpm1 = document.getElementById("nfpm1");
    var nofip1 = $("#nofip1").val();
    var ord = $("#nspp11").val();
    var ope = $("#npspp11").val();
    var fenot = $("#fenot").val();
    var honot = $("#honot").val();
    var resp = new Array();
    var r1, r2;
    if (durp1 == "" || durp1 == null) {
        msgMatch('NPMDurReOb');
        mostrarventaavi();
    } else {
        if (trrep1 == "" || trrep1 == null) {
            msgMatch('nopecaob');
            mostrarventaavi();
        } else {
            var nf;
            if (nfpm1.checked) {
                nf = "X";
            } else {
                nf = "";
            }
            var enviar = "&ord=" + ord + "&ope=" + ope + "&nf=" + nf + "&fenot=" + fenot + "&honot=" + honot + "&durp1=" + durp1 + "&durp2=" + durp2 + "&trrep1=" + trrep1 + "&nofip1=" + nofip1 + "&usu=" + usu;

            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionNOTFTiempos',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    var res = data;
                    resp = res.split(",");
                    r1 = resp[0];
                    r2 = resp[1];
                    if (r1 == 0) {
                        $("#iconmsg").css("visibility", "visible");
                        $("#iconmsg").attr("src", "images/aceptar.png");
                        msgMatch2(ord, r2.substring(0, 10));
                        vaciarCAMps();
                        setTimeout(function () {
                            $("#msg").html("");
                            $("#iconmsg").css("visibility", "hidden");
                        }, 8000);
                        tabmax();
                        LiberarStatus();
                        cambiarDura(durp1);
                        abrirVentanaMsgAddFileT('VentanaModalMsgAddFileT', 'handleFileT');
                        folT = r2;
                    } else {

                    }
                }

            });
        }

    }
}
function canbot() {
    if ($('#notor').val().length === 0) {
        var ven = document.getElementById('VentanaModalAv');
        var msg = "Número de orden obligatorio";
        abrirVentanaAv(ven, msg);
        var theHandle = document.getElementById("handleAV");
        var theRoot = document.getElementById("VentanaModalAv");
        Drag.init(theHandle, theRoot);
        return;
    }
    var acc = "ValidaOrdenesQM01";
    var or = $('#notor').val();
    var dataSend = "&ord=" + or;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionStatusNotifiPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "caso=" + acc + dataSend,
        success: function (data) {
            if (data == 0) {
                var ven = document.getElementById('VentanaModalAv');
                var msg = "Notificaciones incompletas en operación QM01";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
            }
            if (data == 1) {
                canbotv2();
            }
        }
    });
}

function canbotv2() {
    var usu = $("#usua").val();
    var sta = $("#notsta").val();
    var ord = $("#notor").val();
    var fenot = $("#fenot").val();
    var honot = $("#honot").val();
    var ptr = sta.substring(0, 4);
    if (ptr == "ABIE" || ptr == "" || ptr == "CTEC" || ptr == "CERR") {
        $(document).ready(function () {
//                        $("BODY").append('<div id="overlay"></div>');
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else if (ptr == 'LIB.') {

        var t1 = sta,
                patron = /LIB./g,
                nuevoValor = "CTEC",
                nuevaCadena1 = t1.replace(patron, nuevoValor);
        sta = $("#notsta").val(nuevaCadena1);
        var action;
        if (ord.length == 12) {
            action = "DatosCab";
        } else {
            action = "DatosCabSAM";
        }
        var stat = "C";
        var enviar = "&ord=" + ord + "&ope=" + nuevaCadena1 + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
            }

        });
    }
}

function LiberarStatus() {
    var usu = $("#usua").val();
    var sta = $("#notsta").val();
    var ord = $("#notor").val();
    var fenot = $("#fenot").val();
    var honot = $("#honot").val();
    var ptr = sta.substring(0, 4);
    var action;
    if (ord.length == 12) {
        action = "DatosCab";
    } else {
        action = "DatosCabSAM";
    }

    if (ptr == 'LIB.') {

        var t1 = sta,
                patron = /LIB./g,
                nuevoValor = "LIB.",
                nuevaCadena1 = t1.replace(patron, nuevoValor);
        sta = $("#notsta").val(nuevaCadena1);

        var stat = "L";
        var enviar = "&ord=" + ord + "&ope=" + nuevaCadena1 + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
            }

        });
    }

}

function cciebot() {
    if ($('#notor').val().length === 0) {
        var ven = document.getElementById('VentanaModalAv');
        var msg = "Número de orden obligatorio";
        abrirVentanaAv(ven, msg);
        var theHandle = document.getElementById("handleAV");
        var theRoot = document.getElementById("VentanaModalAv");
        Drag.init(theHandle, theRoot);
        return;
    }
    var usu = $("#usua").val();
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);
    var ord = $("#notor").val();
    var fenot = $("#fenot").val();
    var honot = $("#honot").val();

    if (ptr == "LIB." || ptr == "" || ptr == "ABIE" || ptr == "CERR") {
        $(document).ready(function () {
//                         $("BODY").append('<div id="overlay"></div>');
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else if (ptr == 'CTEC') {

        var t1 = sta,
                patron = /CTEC/g,
                nuevoValor = "LIB.",
                nuevaCadena1 = t1.replace(patron, nuevoValor);
        sta = $("#notsta").val(nuevaCadena1);
        var action;
        if (ord.length == 12) {
            action = "DatosCab";
        } else {
            action = "DatosCabSAM";
        }
        var stat = "A";
        var enviar = "&ord=" + ord + "&ope=" + nuevaCadena1 + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
            }

        });
    }
}
function monta() {
    var usu = $("#usua").val();
    var mon = document.getElementById("nteqch");
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);

    if (ptr == "CTEC" || ptr == "" || ptr == "ABIE" || ptr == "CERR") {
        $(document).ready(function () {
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else {
        $("#etav").html("Sólo posible con Equipos desmontados");
        if (mon.checked) {
            $(document).ready(function () {
                mostrarventaavi();
                var theHandle = document.getElementById("handleAv2");
                var theRoot = document.getElementById("ventanaavis");
                Drag.init(theHandle, theRoot);
            });
        } else {
            var nteq = $("#nteq").val();
            $("#nteq2").val(nteq);

            var ntdeseq = $("#ntdeseq").val();
            $("#ntdeseq2").val(ntdeseq);

            var notesp = $("#notesp").val();
            $("#notesp2").val(notesp);

            var notdesesp = $("#notdesesp").val();
            $("#notdesesp2").val(notdesesp);

            var notcent = $("#notcent").val();
            $("#notcent2").val(notcent);

            var notalm = $("#notalm2").val();
            $("#notalm2").val(notalm);

            var notmat = $("#notmat").val();
            $("#notmat2").val(notmat);
            var notlote = $("#notlote").val();
            $("#notlote2").val(notlote);

            mostrarVentanaModal("VenMontEq");
            var theHandle = document.getElementById("handleEQ");
            var theRoot = document.getElementById("VenMontEq");
            Drag.init(theHandle, theRoot);

        }
    }

}
function actualizaMonitor() {
    var acc = "ActualizaRelacionNoti";
    var eq = $("#nteq").val();
    var ctr = $("#notcent").val();
    var lot = $("#notlote").val();
    var ulm = $("#tdr5").text();
    if (ulm === "") {
        ulm = "0";
    }
    var enviar = "&eq=" + eq + "&centr=" + ctr + "&lot=" + lot + "&ulm=" + ulm + ".000&caso=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
        }

    });
}

function desmonta() {
    var usu = $("#usua").val();
    var mon = document.getElementById("nteqch");
    var sta = $("#notsta").val();
    var ptr = sta.substring(0, 4);
    if (ptr == "CTEC" || ptr == "" || ptr == "ABIE" || ptr == "CERR") {
        $(document).ready(function () {
//                         $("BODY").append('<div id="overlay"></div>');
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
        });
    } else {
        msgMatch('NPMSolPoEqMon');
        if (mon.checked) {
            var ord = $("#notor").val();
            var fenot = $("#fenot").val();
            var honot = $("#honot").val();
            var notlote22 = $("#notlote22").val();
            var centr = $("#notcent").val();
            mon.checked = 0;
            var action = "DatosEqu";
            var stat = "D";
            var enviar = "&ord=" + ord + "&ope=" + stat + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu + "&notlote22=" + notlote22 + "&centr=" + centr;
            $.ajax({
                async: false,
                type: 'GET',
                url: "peticionStatusNotifiPM",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    actualizaM200();
                    if (data == 1) {
                        InsertaINVEEQ();
                    }
                }

            });
        } else {
            $(document).ready(function () {
//                         $("BODY").append('<div id="overlay"></div>');
                mostrarventaavi();
                var theHandle = document.getElementById("handleAv2");
                var theRoot = document.getElementById("ventanaavis");

                Drag.init(theHandle, theRoot);
            });

        }
    }
}
function actualizaM200() {
    var acc = "ActualizaM200";
    var mat = $("#notmat").val();
    var lot = $("#notlote").val();
    var enviar = "&mat=" + mat + "&lot=" + lot + "&caso=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
        }

    });
}
function ValidaReservQM() {
    var ja = document.getElementsByName("tab2qm");
    var jas = ja.length;
    var i;
    var cant = 0;
    for (i = 0; i < jas; i++) {
        var numdef1 = $("#numdef1" + i).val();
        var resu1 = $("#resu1" + i).val();
        var valo1 = $("#valo1" + i).val();
        var codi1 = $("#codi1" + i).val();
        var cta1 = $("#cta1" + i).val();

        if (cta1 == "01") {
            if (resu1 == "" || resu1 == "0") {

            } else {
                cant++;
            }

        }
        if (cta1 == "02") {
            if (numdef1 == "" || numdef1 == "0" || valo1 == "") {

            } else {
                cant++;
            }
        }
        if (cta1 == "03") {
            if (numdef1 == "" || numdef1 == "0" || codi1 == "" || resu1 == "" || resu1 == "0") {

            } else {
                cant++;
            }
        }
    }
    if (cant > 0) {
        SaveReservasCabQM();
    } else {
        $("#etav").html("Sin resultados a grabar.");
        mostrarventaavi();
    }

}

function SaveReservasCabQM() {
    var ord = $("#notor").val();
    var ope = $("#opqm1").val();
    var caso = "GuaCAb";
    var usu = $("#usua").val();
    var creapor = $("#crdqm11").val();
    var lotins = $("#nliqm11").val();
    var txtbr = $("#txbqm11").val();
    var cent = $("#cenqm11").val();
    var ultmod = $("#umrqm11").val();
    var fecc = $("#fclqm11").val();
    var fecm = $("#fmrqm11").val();
    var horc = $("#hclqm12").val();
    var horm = $("#hmlqm12").val();
    var enviar = "&ord=" + ord + "&ope=" + ope + "&caso=" + caso + "&usu=" + usu + "&creapor=" + creapor + "&lotins=" + lotins + "&txtbr=" + txtbr + "&cent=" + cent + "&ultmod=" + ultmod + "&fecc=" + fecc + "&fecm=" + fecm + "&horc=" + horc + "&horm=" + horm;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionGuardarDatosQMNOT",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data == 1) {
                SaveReservasQM();
            }
        }

    });
}

function SaveReservasQM() {
    var lotins = $("#nliqm11").val();
    var caso = "GuaPosQM";
    var ja = document.getElementsByName("tab2qm");
    var jas = ja.length;
    var i;
    for (i = 0; i < jas; i++) {
        var numdef1 = $("#numdef1" + i).val();
        var resu1 = $("#resu1" + i).val();
        var valo1 = $("#valo1" + i).val();
        var codi1 = $("#codi1" + i).val();
        var note1 = $("#note1" + i).val();
        var cta1 = $("#cta1" + i).val();
        var nucain = $("#nuci1" + i).val();
        var texbre = $("#tbci1" + i).val();
        var destex = $("#dbcs" + i).val();
        var Entraca = $("#eccs1" + i).val();
        var unimed1 = $("#unimed1" + i).val();
        var cata1 = $("#cata1" + i).val();
        var enviar = "";
        if (cta1 == "01") {
            if (resu1 == "" || resu1 == "0") {

            } else {
                enviar = "&nucain=" + nucain + "&texbre=" + texbre + "&destex=" + destex + "&Entraca=" + Entraca + "&unimed1=" + unimed1 + "&cata1=" + cata1 + "&lotins=" + lotins + "&resu1=" + resu1 + "&note1=" + note1 + "&numdef1=&valo1=&codi1=" + "&caso=" + caso;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: "peticionGuardarDatosQMNOT",
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: enviar,
                    success: function (data) {
//                               alert(data);     
                    }

                });
            }

        }
        if (cta1 == "02") {
            if (numdef1 == "" || numdef1 == "0" || valo1 == "") {

            } else {
                enviar = "&nucain=" + nucain + "&texbre=" + texbre + "&destex=" + destex + "&Entraca=" + Entraca + "&unimed1=" + unimed1 + "&cata1=" + cata1 + "&lotins=" + lotins + "&resu1=&note1=" + note1 + "&numdef1=" + numdef1 + "&valo1=" + valo1 + "&codi1=" + "&caso=" + caso;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: "peticionGuardarDatosQMNOT",
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: enviar,
                    success: function (data) {
//                               alert(data);     
                    }

                });
            }
        }
        if (cta1 == "03") {
            if (numdef1 == "" || numdef1 == "0" || codi1 == "" || resu1 == "" || resu1 == "0") {

            } else {
                enviar = "&nucain=" + nucain + "&texbre=" + texbre + "&destex=" + destex + "&Entraca=" + Entraca + "&unimed1=" + unimed1 + "&cata1=" + cata1 + "&lotins=" + lotins + "&resu1=" + resu1 + "&note1=" + note1 + "&numdef1=" + numdef1 + "&valo1=&codi1=" + codi1 + "&caso=" + caso;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: "peticionGuardarDatosQMNOT",
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: enviar,
                    success: function (data) {
//                               alert(data);     
                    }

                });
            }
        }
    }
    ConsumiFolQM();
}


function ConsumiFolQM() {
    var caso = 'CONfol';
    var enviar = "&caso=" + caso;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionGuardarDatosQMNOT",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
//                               alert(data);     
        }

    });
}


function checarPosiMa(ind) {

    $.each($("button[name='btval1']"), function (i, v) {

        if (ind != v.value) {
            $("#btval1" + v.value).css("display", "none");
        } else {
            $("#btval1" + ind).css("display", "inline");
        }

    });

}

function checarPosiMa2(ind) {

    $.each($("button[name='btcod1']"), function (i, v) {

        if (ind != v.value) {
            $("#btcod1" + v.value).css("display", "none");
        } else {
            $("#btcod1" + ind).css("display", "inline");
        }

    });

}

function matchqmval(i) {
    mostrarVentanaModal("VentanaModalValora");
    var theHandle = document.getElementById("handle9");
    var theRoot = document.getElementById("VentanaModalValora");
    Drag.init(theHandle, theRoot);
    cargarValQM(i);
}

function matchqmcod(i) {
    mostrarVentanaModal("VentanaModalCodig");
    var theHandle = document.getElementById("handle10");
    var theRoot = document.getElementById("VentanaModalCodig");
    Drag.init(theHandle, theRoot);
    cargarCodQM(i);
}

function cargarValQM(i) {
    var caso = 'DatMatcVa';
    var enviar = "&caso=" + caso + "&ids=" + i;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionGuardarDatosQMNOT",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos9").html(data);
        }
    });
}

function cargarCodQM(i) {
    var caso = 'DatMatcCo';
    var enviar = "&caso=" + caso + "&ids=" + i;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionGuardarDatosQMNOT",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos10").html(data);
        }
    });
}

function nonum() {

    $("input[name='numdef']").keypress(function (e) {
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
    $("input[name='resut']").keypress(function (e) {
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

function mostbotmatus() {
    $("#match_Nope").show();
//     $("#trrep1").blur(function(){
//       $("#match_Nope").hide();  
//     });

}

function ConsultaUSU() {
    var cant = $("#numAcMax7no").val();
    var usu = $("#NOpernot").val();
    var acc = "accConsusu";
    var enviar = "&cant=" + cant + "&usu=" + usu + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionNotificacionesOrdenesSAM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#BuscarParam_GrupoPu").css("display", "none");
            $("#ConsultaTabla7").css("display", "block");
            $("#cargarDatos7").html(res);
        },
    });
}


function Statmonta() {
    var lo1 = $("#notlote2").val();
    var lo2 = $("#notlote22").val();
    var nteq2 = $("#nteq2").val();
    var notlote22 = $("#notlote2").val();
    if (lo1 === lo2) {
        var usu = $("#usua").val();
        var ord = $("#notor").val();
        var fenot = $("#fenot").val();
        var honot = document.getElementById("honot").value;
        var mon = document.getElementById("nteqch");
        mon.checked = 1;
        var action = "DatosEqu"
        var stat = "M";
        var centr = $("#notcent2").val();
        var enviar = "&ord=" + ord + "&ope=" + stat + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu + "&notlote22=" + notlote22 + "&centr=" + centr;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                DesCOntarINvent();
            }

        });
    } else {
        var matw = $("#notmat2").val();
        var action2 = "ValLOt";
        var enviar = "&caso=" + action2 + "&usu=" + usu + "&notlote22=" + lo2 + "&matw=" + matw;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                if (data == 1) {
                    cambiarStatusMon();
                } else {
                    mensajess(0, "images/advertencia.PNG");
                    setTimeout(function () {
                        $("#msg").html("");
                        $("#iconmsg").css("visibility", "hidden");
                    }, 8000);
                }
            }

        });
    }
    actualizaMonitor();
}



function InsertaINVEEQ() {
//    alert("entroInsInv");
    var matw = $("#notmat2").val();
    var ord = $("#notor").val();
    var action2 = "INSinv";
    var lo2 = $("#notlote2").val();
    var nteq2 = $("#nteq2").val();
    var enviar = "&caso=" + action2 + "&notlote22=" + lo2 + "&matw=" + matw + "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data == 1) {
                $("#etav").html("Desmontaje correcto de Equipo " + nteq2);
                $(document).ready(function () {
                    mostrarventaavi();
                    var theHandle = document.getElementById("handleAv2");
                    var theRoot = document.getElementById("ventanaavis");
                    Drag.init(theHandle, theRoot);
                });
                ocultarVentana('VenMontEq');
                mensajess(1, "images/aceptar.png");
            } else {
                mensajess(0, "images/advertencia.PNG");
                setTimeout(function () {
                    $("#msg").html("");
                    $("#ñiconmsg").css("visibility", "hidden");
                }, 8000);
            }
        }

    });
}



function cambiarStatusMon() {
    var usu = $("#usua").val();
    var ord = $("#notor").val();
    var fenot = $("#fenot").val();
    var honot = document.getElementById("honot").value;
    var mon = document.getElementById("nteqch");
    mon.checked = 1;
    var action = "DatosEqu";
    var stat = "M";
    var lo2 = $("#notlote22").val();
    var centr = $("#notcent2").val();
    var enviar = "&ord=" + ord + "&ope=" + stat + "&hora=" + honot + "&fecha=" + fenot + "&caso=" + action + "&stat=" + stat + "&usu=" + usu + "&notlote22=" + lo2 + "&centr=" + centr;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            DesCOntarINvent();
            ActLot();
        }

    });
}
function ActLot() {
    var action = "ActLot";
    var ord = $("#notor").val();
    var lo2 = $("#notlote22").val();
    var enviar = "&ord=" + ord + "&caso=" + action + "&notlote22=" + lo2;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data == 1) {
                mostrar1();
            }
        }
    });
}
function DesCOntarINvent() {
    var ord = $("#notor").val();
    var action = "ACTUEqu";
    var matw = $("#notmat2").val();
    var lo2 = $("#notlote22").val();
    var nteq2 = $("#nteq2").val();
    var enviar = "&ord=" + ord + "&caso=" + action + "&notlote22=" + lo2 + "&matw=" + matw;
    $.ajax({
        async: false,
        type: 'GET',
        url: "peticionStatusNotifiPM",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            if (data == 1) {
                $("#etav").html("Montaje correcto de Equipo " + nteq2);
                $(document).ready(function () {
                    mostrarventaavi();
                    var theHandle = document.getElementById("handleAv2");
                    var theRoot = document.getElementById("ventanaavis");
                    Drag.init(theHandle, theRoot);
                });
                ocultarVentana('VenMontEq');
                setTimeout(function () {
                    mensajess(1, "images/aceptar.png");
                }, 8000);
            } else {
                mensajess(0, "images/advertencia.PNG");
                setTimeout(function () {
                    $("#msg").html("");
                    $("#iconmsg").css("visibility", "hidden");
                }, 8000);
            }
        }

    });

}
function abrirVentanaMsgAddFileCalidad() {
    var theHandle = document.getElementById('handleFileCalidad');
    var theRoot = document.getElementById('VentanaModalMsgAddFileCalidad');
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById('VentanaModalMsgAddFileCalidad');
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function abrirVentanaMsgAddFile() {
    var theHandle = document.getElementById('handleFile');
    var theRoot = document.getElementById('VentanaModalMsgAddFile');
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById('VentanaModalMsgAddFile');
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function AbrirVentanaAddFile() {
    OcultarMensajeFile('VentanaModalMsgAddFile');
    var theHandle = document.getElementById('handleFileAdd');
    var theRoot = document.getElementById('VentanaModalAddFile');
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById('VentanaModalAddFile');
    var ancho = 800;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function OcultarMensajeFile(window) {
    var ventana = document.getElementById(window);
    ventana.style.display = 'none';

}
var output = [];
function uploadFiles() {
    var Formdata = new FormData($('#FormCreateC')[0]);
    for (var i = 0; i < output.length; i++) {
        Formdata.append('file[]', output[i]);
    }
    Formdata.append(cenOpe, 'x');
    $.ajax({
        url: 'peticionSaveFilesNotT',
        type: 'POST',
        data: Formdata,
        dataType: "json",
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data[0] == "0") {
            } else {
                OcultarMensajeFile('VentanaModalAddFile');
                ConsumiriFOL(data);
                $("#FormCreateC").load("CrearNotificacionesPM.jsp #FormCreateC");
                output = [];
            }

        }

    });
    return false;
}

function insertDataFiles(d) {
    var acc = "insertarDataFileT";
    for (var i = 0; i < d.length; i++) {
//                            rut = d[i].replace(/'/g, "´");
        var datosSend = "&v1=" + (i + 1) +
                "&v2=" + (getExtension(d[i])).toUpperCase() +
                "&v3=" + "EVS" +
                "&v4=" + getNameFile(d[i]) +
                "&v5=" + usuario +
                "&v6=" + encodeURIComponent(d[i]) +
                "&v7=" + folT;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionGuardarFile',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + datosSend,
            success: function (rs) {
//                                    alert(rs);
            }
        });
    }


}

var outputCalidad = [];
function uploadFilesCalidad() {
    validarTabRes();
    var Formdata = new FormData($('#FormCreateCali')[0]);
    for (var i = 0; i < outputCalidad.length; i++) {
        Formdata.append('fileCali[]', outputCalidad[i]);
    }
    $.ajax({
        url: 'ArchivosNotificacionesCalidad',
        type: 'POST',
        data: Formdata,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data == 1) {
                OcultarMensajeFile('VentanaModalAddFileCalidad');
            }
        }

    });
    return false;
}

function datosCalidad() {
    var archivos = document.getElementById('archivosCalidad').files;
    for (var i = 0; i < archivos.length; i++) {
        outputCalidad.push(archivos[i]);
    }

    for (var i = 0; i < outputCalidad.length; i++) {
        var name = outputCalidad[i].name;
        var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
        var size = outputCalidad[i].size / 1024 / 1024;
        var tamano = size.toFixed(2);
        var peso = "";
        if (tamano >= 1) {
            peso = tamano + " mb";
        } else {
            peso = tamano + " kb";
        }
        var fila = '<tr><td><input type="checkbox" id="rb' + i + '" name="rb" value="' + i + '"</td>\n\
                                            <td><label id="nombre' + i + '">' + name + '</label></td>\n\
                                            <td><label id="tipo' + i + '">' + ext + '</label></td>\n\
                                            <td><label id="tamaño' + i + '">' + peso + '</label></td></tr>';

        $('#tableCalidad > tbody').append(fila);
    }
}
function datos() {
    var archivos = document.getElementById('archivos').files;
    for (var i = 0; i < archivos.length; i++) {
        output.push(archivos[i]);
    }

    for (var i = 0; i < output.length; i++) {
        var name = output[i].name;
        var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
        var size = output[i].size / 1024 / 1024;
        var tamano = size.toFixed(2);
        var peso = "";
        if (tamano >= 1) {
            peso = tamano + " mb";
        } else {
            peso = tamano + " kb";
        }
        var fila = '<tr><td><input type="checkbox" id="rb' + i + '" name="rb" value="' + i + '"</td>\n\
                                            <td><label id="nombre' + i + '">' + name + '</label></td>\n\
                                            <td><label id="tipo' + i + '">' + ext + '</label></td>\n\
                                            <td><label id="tamaño' + i + '">' + peso + '</label></td></tr>';

        $('#table12 > tbody').append(fila);
    }
}

function DatosArchivosCalidad() {
    var trs = $("#tableCalidad tr").length;
    var final = trs - 1;
    if (final >= 1) {
        for (var i = 0; i < final; i++) {
            $("#tableCalidad tr:last").remove();
        }
        datosCalidad();
    } else if (final >= 2) {
        for (var i = 0; i < final; i++) {
            $("#tableCalidad").remove();
        }
        datosCalidad();
    } else {
        datosCalidad();
    }
}
function DatosArchivos() {
    var trs = $("#table12 tr").length;
    var final = trs - 1;
    if (final >= 1) {
        for (var i = 0; i < final; i++) {
            $("#table12 tr:last").remove();
        }
        datos();
    } else if (final >= 2) {
        for (var i = 0; i < final; i++) {
            $("#table12").remove();
        }
        datos();
    } else {
        datos();
    }
}

function DeleteFile() {
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < output.length; i++) {
        if (elementos[i].checked) {
            output.splice(i, 1);
            $('#table12').find('input[name="rb"]').each(function () {
                if ($(this).is(":checked")) {
                    $(this).parents("tr").remove();
                }
            });
        }
    }
}
function DeleteFileCalidad() {
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < outputCalidad.length; i++) {
        if (elementos[i].checked) {
            outputCalidad.splice(i, 1);
            $('#tableCalidad').find('input[name="rb"]').each(function () {
                if ($(this).is(":checked")) {
                    $(this).parents("tr").remove();
                }
            });
        }
    }
}
function MatchTexto(v)
{
    mostrarVentana('VentanaModalTexto');
    document.getElementById('Textlib').value = document.getElementById("Textlib" + v).value;
    document.getElementById('bxTextoL').value = v;
    var theHandle = document.getElementById('handle27');
    var theRoot = document.getElementById('VentanaModalTexto');
    Drag.init(theHandle, theRoot);
    document.getElementById('Textlib').focus();
    $('#okTexto').show();
    $('#okTexto2').hide();
}
function MatchTextoV2(v)
{
    mostrarVentana('VentanaModalTexto');
    document.getElementById('Textlib').value = document.getElementById("TextlibNota" + v).value;
    document.getElementById('bxTextoLNota').value = v;
    var theHandle = document.getElementById('handle27');
    var theRoot = document.getElementById('VentanaModalTexto');
    Drag.init(theHandle, theRoot);
    document.getElementById('Textlib').focus();
    $('#okTexto2').show();
    $('#okTexto').hide();
}
//matchqmcod "input[name='numdef']")
function ListaMateriales() {
    mostrarVentanaModal('VentanaModalListaMat');
    var theHandle = document.getElementById('handle23');
    var theRoot = document.getElementById('VentanaModalListaMat');
    Drag.init(theHandle, theRoot);
    TablaLM();
}
function HorasT() {
    mostrarVentanaModalH('VentanaModalHoras');
    var theHandle = document.getElementById('handle25');
    var theRoot = document.getElementById('VentanaModalHoras');
    Drag.init(theHandle, theRoot);
}
function TablaLM() {
    var eq = $("#nteq").val();
    var lg = $("#clidi").val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=ListaMaterialNotificacionesC&v1=" + eq + "&v2=" + lg,
        success: function (data) {
            document.getElementById('SecCuerpo3').innerHTML = data;
            AjustarCabecera('TabHead3', 'TabBody3', 8, 'SecCuerpo3');
            document.getElementById('DobleContainer3').style.height = document.getElementById("TabBody3").offsetHeight + "px";
//            bloquearCamposResul();
        }
    });
}

//Funcion para Visualizar documentos ligados al equipo
function VisDoc() {
    acc = "matchDocs";
    var equi = $("#nteq").val();
    var eqS = equi.substring(0, 4);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionStatusNotifiPM',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "caso=" + acc + "&equi=" + equi + "&centroo=" + eqS,
        success: function (rs) {
            if (rs == 0) {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "No hay archivos por mostrar";
            } else {
                blockPropiety('handle3', 'VentanaModalCentroP');
                $('#cargarDatosCentroP').html(rs);

                AjustarCabecera('TabHeadN', 'TabBody', 8, 'VentanaModalCentroP');
                fncCentroP();
                borrarmsg();
            }
        }
    });
}
function fncCentroP() {
    $('#table-scrollCentroP').scroll(function () {
        $('#fixedYCentroP').css({top: $('#scrollCentroP').scrollTop()});
    });
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

//Funcion para enviar ip y ruta para visualizar el documento
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
    xmlhttp.open("GET", "peticionStatusNotifiPM?caso=EnviarSocket&ruta=" + ruta, true);
    xmlhttp.send();
}

function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function abrirVentana(ventana) {
    var ancho = 350;
    var alto = 650;
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
function abrirVentanaa(ventana) {
    var ancho = 1300;
    var alto = 550;
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
function SendPath(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarRuta(cad);
}
function ckListaMat() {
    var ck = document.getElementsByName('CKlmNotiC');
    var c = 0;
    for (var i = 0; i < ck.length; i++) {
        if (ck[i].checked) {
            $('#matab1' + c).val($('#ll1' + i).text());
            $('#lotabp1' + c).val($('#ll4' + i).text());
            $('#cein' + c).html($('#ll7' + i).text());
            $('#almin' + c).html($('#ll8' + i).text());
            $('#unmin' + c).html($('#ll6' + i).text());
            $('#Texde' + c).html($('#ll3' + i).text());
            c++;
        }
    }
    cerraventabs('VentanaModalListaMat');
}
function valida(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 8) {
        return true;
    }
    patron = /[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}
function ActualizaMedicion() {
    var acc = "ActualizaRelacionMA";
    var hrs = $('#bxHT').val();
    var ctr = $('#notcent').val();
    var eq = $('#nteq').val();
    if (hrs === "") {
        document.getElementById("msg").innerHTML = "Ingresa Horas Trabajadas";
        var iconm = document.getElementById("iconmsg");
        iconm.style.visibility = "visible";
        iconm.src = "images/advertencia.PNG";
    } else {
        document.getElementById("msg").innerHTML = "";
        var iconm = document.getElementById("iconmsg");
        iconm.style.visibility = "hidden";
        desmonta();

        var enviar = "&eq=" + eq + "&centr=" + ctr + "&ulm=" + hrs + ".000&caso=" + acc;
        $.ajax({
            async: false,
            type: 'GET',
            url: "peticionStatusNotifiPM",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                document.getElementById("msg").innerHTML = "Documento " + data + " creado";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
            }
        });
    }
}


function cargarOpe() {
    mostrar1();
    $('input[name=checkbo]:first').prop('checked', true);
    libbot();

    setTimeout(function () {
        selecoftab();
    }, 800);

//valnotiemP01();
}

///////////////////// VENTANA TIEMPO
var TIoutput = [];


function uploadFilesT() {
    var Formdata = new FormData($('#FormCreateT')[0]);
    for (var i = 0; i < TIoutput.length; i++) {
        Formdata.append('fileT', TIoutput[i]);
    }
    Formdata.append(cenOpe, 'x');
    $.ajax({
        url: 'peticionSaveFilesNotT',
        type: 'POST',
        data: Formdata,
        dataType: "json",
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data[0] == "0") {
            } else {

                insertDataFilesT(data);
                OcultarMensajeFile('VentanaModalAddFileT');
                $("#FormCreateT").load("CrearNotificacionesPM.jsp #FormCreateT");
                TIoutput = [];
            }
        }

    });
    return false;
}

function insertDataFilesT(d) {
    var acc = "insertarDataFileT";
    for (var i = 0; i < d.length; i++) {
//                            rut = d[i].replace(/'/g, "´");
        var datosSend = "&v1=" + (i + 1) +
                "&v2=" + (getExtension(d[i])).toUpperCase() +
                "&v3=" + "EVS" +
                "&v4=" + getNameFile(d[i]) +
                "&v5=" + usuario +
                "&v6=" + encodeURIComponent(d[i]) +
                "&v7=" + folT;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionGuardarFile',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + datosSend,
            success: function (rs) {
//                                    alert(rs);
            }
        });
    }


}
function datosT(table, input, type) {
    switch (type) {
        case "T":
            var archivos = document.getElementById(input).files;
            for (var i = 0; i < archivos.length; i++) {
                TIoutput.push(archivos[i]);
            }

            for (var i = 0; i < TIoutput.length; i++) {
                var name = TIoutput[i].name;
                var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                var size = TIoutput[i].size / 1024 / 1024;
                var tamano = size.toFixed(2);
                var peso = "";
                if (tamano >= 1) {
                    peso = tamano + " mb";
                } else {
                    peso = tamano + " kb";
                }
                var fila = '<tr><td><input type="checkbox" id="rb' + i + '" name="rb" value="' + i + '"</td>\n\
                                            <td><label id="nombre' + i + '">' + name + '</label></td>\n\
                                            <td><label id="tipo' + i + '">' + ext + '</label></td>\n\
                                            <td><label id="tamaño' + i + '">' + peso + '</label></td></tr>';

                $('#' + table + ' > tbody').append(fila);
            }
            break;


    }



}

function DatosArchivosT(table, input) {
    var trs = $("#" + table + " tr").length;
    var final = trs - 1;
    if (final >= 1) {
        for (var i = 0; i < final; i++) {
            $("#" + table + " tr:last").remove();
        }
        datosT(table, input, 'T');
    } else if (final >= 2) {
        for (var i = 0; i < final; i++) {
            $("#" + table).remove();
        }
        datosT(table, input, 'T');
    } else {
        datosT(table, input, 'T');
    }
}

function DeleteFileT(table) {
    var elementos = $('[name = "rb"]');
    for (var i = 0; i < TIoutput.length; i++) {
        if (elementos[i].checked) {
            TIoutput.splice(i, 1);
            $('#' + table).find('input[name="rb"]').each(function () {
                if ($(this).is(":checked")) {
                    $(this).parents("tr").remove();
                }
            });
        }
    }
}
function getExtension(filename) {
    var index = filename.lastIndexOf('.');
    if (index == -1) {
        return "";
    } else {
        return filename.substring(index + 1);
    }
}
function getNameFile(filename) {
    var index = filename.lastIndexOf('\\');
    if (index == -1) {
        return "";
    } else {
        return filename.substring(index + 1);
    }
}
function OcultarMensajeFile(window) {
    var ventana = document.getElementById(window);
    ventana.style.display = 'none';

}
function abrirVentanaMsgAddFileT(window, handle) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(window);
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById(window);
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function AbrirVentanaAddFileT(window, handle, windowCl) {
    OcultarMensajeFile(windowCl);
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(window);
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById(window);
    var ancho = 800;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function AbrirVentanaAddFileCalidad(window, handle, windowCl) {
    OcultarMensajeFile(windowCl);
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(window);
    Drag.init(theHandle, theRoot);
    var ven = document.getElementById(window);
    var ancho = 800;
    var alto = 600;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ven.style.left = x + "px";
    ven.style.top = y + "px";
    ven.style.display = 'block';
}
function ocultarVentanaT(ven, id, M)
{
    if (M === "m") {
        actcm();
    }
    var ventana = document.getElementById(ven);
    ventana.style.display = 'none';
    document.getElementById("msg").innerHTML = "";
    document.getElementById("iconmsg").style.visibility = "hidden";
    try {
        var txt = document.getElementById(id);
        txt.focus();
    } catch (e) {
    }
}
///////////////////// VENTANA CONSUMO
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

function FlechasDir(name, ix, e) {
    var ar = document.getElementsByName(name);
    var tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 38) {
        if (ix != 0) {
            ar[ix - 1].focus();
        }
    }
    if (tecla == 40) {
        if (parseInt(ix) < ar.length - 1) {
            ar[parseInt(ix) + 1].focus();
        }
    }
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
    abrirVentanaAvv(ventana);
    var theHandle = document.getElementById("handleAvvv");
    var theRoot = document.getElementById("VentUbTecAvvv");
    Drag.init(theHandle, theRoot);
}
function abrirVentanaAvv(ventana) {
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    //document.getElementById("lbAv").innerHTML = msg;
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
    xmlhttp.open("GET", "peticionStatusNotifiPM?caso=EnviarMod&ruta=" + ruta, true);
    xmlhttp.send();
}
function inval() {
    msgMatch("invv");
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
}