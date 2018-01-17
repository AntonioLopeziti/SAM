/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    startTime();
    
    $('#regresar').click( function(){
       back(); 
    });
    
    function back(){
        window.location.href = "Bienvenido.jsp";
    }
    $('#guardar').click(function () {
        ValidarDatos();
    });
    var INFO = $('#info_IR') ;
    var MATERIAL = $('#material_IR');
    var PROVEEDOR = $('#proveedor_IR');
    var ORGCOMP = $('#orgCompras_IR');
    var INFOTIPO = $('#Infotipo_IR');
    var CENTRO = $('#centro_IR');
    var GPOARTS = $('#GrupoArticulos_IR');
    var GPOCOMPS = $('#GrupoCompras_IR');
    var PLAZAENT = $('#PlazaEntr_IR');
    var NUMARPRO = $('#NumMatPro_IR');
    var CANTSTAND = $('#CantidadStandar_IR');
    var CANTMAX = $('#CantidadMaxima_IR');
    var SINTEXT = $('#SinText_IR');
    var INDOBL = $('#IndObl_IR');
    var TOLSUMIM = $('#TolSumImc_IR');
    var TOLECSUM = $('#TolecSum_IR');
    var CANTUNP = $('#CantUniMedPed_IR');
    var CANTUMP2 = $('#CantUniMedPed2_IR');
    var CANTUMB = $('#CantUniMedBase_IR');
    var CANTUMB2 = $('#CantUniMedBase2_IR');
    var PRECIONET = $('#PrecioNeto_IR');
    var CLAVEMON = $('#ClaveMoneda_IR');
    var CNTBASE = $('#CntBase_IR');
    var CNTBASE2 = $('#CntBase2_IR');
    var IVA = $('#IVA_IR');
    
    var arrayDAT = [
        INFO,
        MATERIAL,
        PROVEEDOR,
        ORGCOMP,
        INFOTIPO,
        CENTRO,
        GPOARTS,
        GPOCOMPS,
        PLAZAENT,
        NUMARPRO,
        CANTSTAND,
        CANTMAX,
        SINTEXT,
        INDOBL,
        TOLSUMIM,
        TOLECSUM,
        CANTUNP,
        CANTUMP2,
        CANTUMB,
        CANTUMB2,
        PRECIONET,
        CLAVEMON,
        CNTBASE,
        CNTBASE2,
        IVA        
    ];
    function ValidarDatos() {
        var temp = new Array();
        temp[0] = INFO;
        temp[1] = MATERIAL;
        temp[2] = PROVEEDOR;
        temp[3] = ORGCOMP;
        temp[4] = INFOTIPO;
        temp[5] = CENTRO;
        temp[6] = GPOARTS;
        temp[7] = GPOCOMPS;
        temp[8] = PLAZAENT;
        temp[9] = NUMARPRO;
        temp[10] = CANTSTAND;
        temp[11] = CANTMAX;
        temp[12] = SINTEXT;
        temp[13] = INDOBL;
        temp[14] = TOLSUMIM;
        temp[15] = TOLECSUM;
        temp[16] = CANTUNP;
        temp[17] = CANTUMP2;
        temp[18] = CANTUMB;
        temp[19] = CANTUMB2;
        temp[20] = PRECIONET;
        temp[21] = CLAVEMON;
        temp[22] = CNTBASE;
        temp[23] = CNTBASE2;
        temp[24] = IVA;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        if (INFO.val().length <= 10) {
            validarInfoRec(INFO.val());
        }
    }
    $.each(arrayDAT, function (i, v) {
        v.css('background-image', 'url(images/necesario.PNG)');
        v.focus(function () {
            v.css('background-image', 'none');
        });
        v.blur(function () {
            if (v.val() == '') {
                v.css('background-image', 'url(images/necesario.PNG)');
            } else {
                v.css('background-image', 'none');
            }
//            if (i == 0) {
//                if (v.val().length > 0) {
//                    var n = validarInfoRec(v.val());
//                    if (n === true) {
//                        borramsg();
//                    } else {
//                        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
//                        v.val("");
//                        v.focus();
//                    }
//                }
//            }
            if (i == 5){                
                if (v.val().length > 0) {
                    var n = validarCentro(v.val());                   
                    if (n === true) {
                        borramsg();
                    }else{
                        ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                        v.val("");
                        v.focus();
                    }
                }
                
            }
        });
    });
    function validarInfoRec(inf){
        var resp = false;
        var acc = "ValidarInfoRe";
        i = inf.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloCreaInfoRecords",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&infoRe=" + i,
            success: function (data) {                
                if (data != 1) {                    
                    GuardarDatosInfRec();
                } else {                    
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
        return resp;
    }
    function validarCentro(centro) {
        var resp = false;
        var acc = "ValidarCentro";
        c = centro.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloCreaInfoRecords",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&centro=" + c,
            success: function (data) {                
                if (data == 1) {
                    resp = true;
                }
            }
        });
        return resp;
    }
    function GuardarDatosInfRec(){
        var acc = "GuardarDatos";
        var par = "&infoRe=" + INFO.val() + "&material=" + MATERIAL.val() + "&proveedor=" + PROVEEDOR.val() + "&orgComp=" + ORGCOMP.val() + "&infoTipo=" + INFOTIPO.val() + "&centro=" + CENTRO.val().toUpperCase() + "&gpoArts=" + GPOARTS.val() + "&gpoComps=" + GPOCOMPS.val() + "&plazaEnt=" + PLAZAENT.val() + "&numArPro=" + NUMARPRO.val() + "&cantStand=" + CANTSTAND.val() + "&cantMax=" + CANTMAX.val() + "&sinText=" + SINTEXT.val() + "&inDobl=" + INDOBL.val() + "&tolSumim=" + TOLSUMIM.val() + "&tolecSum=" + TOLECSUM.val() + "&cantUNP=" + CANTUNP.val() + "&cantUMP2=" + CANTUMP2.val() + "&cantUMB=" + CANTUMB.val() + "&cantUMB2=" + CANTUMB2.val() + "&precioNet=" + PRECIONET.val() + "&claveMon=" + CLAVEMON.val() + "&cntBase=" + CNTBASE.val() + "&cntBase2=" + CNTBASE2.val() + "&iva=" + IVA.val();1
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "PeticionModuloCreaInfoRecords",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                if (data == 5) {
                    ShowMsg(4, "images/aceptar.png", "audio/sapmsg.wav");
                    limpiar();
//                    reiniDatOb();                    
                }
                if (data == 6) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
//                    reiniDatOb();
                    limpiar();

                }
            }
        });
    }
    function limpiar() {
        $.each(arrayDAT, function (i, v) {
            v.val("");
        });
    }
    function borramsg() {
        $('#iconmsg').hide();
        $('#msg').html("");
    }
});