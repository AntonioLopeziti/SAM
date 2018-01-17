
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    ////// CAMPOS OBLIGATORIOS
    var OC = $('#OrgCompras');
    var GC = $('#GpoCompras');
    var MAT = $('#Material');
    var CAN = $('#Cantidad');
    var FE = $('#FecEntrega');
    var CEN = $('#Centro');
    var ALM = $('#Almacen');
    var TB = $('#Txtbrve');
    var UM = $('#unidamedida');
    var GA = $('#GpoArticulo');
    var SOL = $('#solicitante');
    var PV = $('#preciovalor');
    var CM = $('#clvmoneda');
    ////// CAMPOS 

    var TC = $('#TextCabecera_SP');
    var CD = $('#ClaseDoc');
    var TI = $('#TipoImputacion');
    var TP = $('#TipoPosicion');
    var CTM = $('#ctaMayor');
    var CC = $('#CenCosto');
    var OR = $('#Orde');
    var TXP = $('#TextPosicion_SP');
    /////// MATCHCODE   
    var MOC = $('#matchOrgCompra');
    var MGC = $('#matchGrupoCompra');
    var MTI = $('#matchTImputacion');
    var MTP = $('#matchTPosicion');
    var MMA = $('#matchMaterial');
    var BTF = $('#btnfecha');
    var MCE = $('#matchCentro');
    var MAL = $('#matchAlmacen');
    var MUM = $('#matchUM');
    var MGA = $('#matchGpoArticulo');
    var MCM = $('#matchCtaMayor');
    var MCC = $('#matchCCosto');
    var MOR = $('#matchOrden');
    /// BUTTON
    var BADDP = $('#btnAddPos');
    var BSERV = $('#btnservicios');
    var BMODAGR = $('#btnAgregaPos');
    var MATCH = [
        MOC,
        MGC,
        MTI,
        MTP,
        MMA,
        BTF,
        MCE,
        MAL,
        MUM,
        MGA,
        MCM,
        MCC,
        MOR
    ];
    $.each(MATCH, function (ind, va) {
        va.hide();
    });
    var AREB = [
        OC,
        GC,
        MAT,
        CAN,
        FE,
        CEN,
        ALM,
        TB,
        UM,
        GA,
        PV,
        CM
    ];


    $.each(AREB, function (ind, va) {
        va.css('background-image', 'none');
    });
    $.each(AREB, function (ind2, va2) {
        va2.focus(function () {
            va2.css('background-image', 'none');
        });
    });
    $.each(AREB, function (i, v) {
        v.blur(function () {
            if (v.val().length > 0) {
                v.css('background-image', 'none');
            } else {
                v.css('background-image', 'none');
            }
        });
    });
    CD.focus(function () {
        checarPosiMa(-1);
    });
    OC.focus(function () {
        checarPosiMa(0);
    });
    OC.blur(function () {
        validarOCompras();
    });
    OC.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarOCompras();
        }
    });
    GC.focus(function () {
        checarPosiMa(1);
    });
    GC.blur(function () {
        validarGCompras();
    });
    GC.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarGCompras();
        }
    });
    TC.focus(function () {
        checarPosiMa(-1);
    });
    TI.focus(function () {
        checarPosiMa(2);
    });
    TP.focus(function () {
        checarPosiMa(3);
    });
    MAT.focus(function () {
        checarPosiMa(4);
    });
    CEN.focus(function () {
        checarPosiMa(6);
    });
    CAN.focus(function () {
        checarPosiMa(-1);
    });
    CAN.keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    FE.focus(function () {
        checarPosiMa(5);
    });
    FE.blur(function () {
        validarFecha();
    });
    FE.keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /^\d{4}\-\d{2}\\d{2}$/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    ALM.focus(function () {
        checarPosiMa(7);
    });
    TB.focus(function () {
        checarPosiMa(-1);
    });
    UM.focus(function () {
        checarPosiMa(8);
    });
    GA.focus(function () {
        checarPosiMa(9);
    });
    SOL.focus(function () {
        checarPosiMa(-1);
    });
    PV.focus(function () {
        checarPosiMa(-1);
    });

    
    $('#numAcMax').keypress(function (){
       tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    
    $('#numAcMax2').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax3').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $("#numAcMax4").keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax5').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax6').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax7').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax8').keypress(function(){
       tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);  
    });
    
    $('#numAcMax9').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax10').keypress(function(){
       tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final); 
    });
    
    $('#numAcMax11').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    $('#numAcMax12').keypress(function(){
       tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final); 
    });
    
    $('#numAcMax13').keypress(function(){
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    
    CM.focus(function () {
        checarPosiMa(-1);
    });
    CTM.focus(function () {
        checarPosiMa(10);
    });
    CTM.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            if (CTM.val().length > 0) {
                $("BODY").append('<div id="overlay"></div>');
                if (validarCMayor() == false) {
                    OpenWindowMsg("CM");
                    var theHandle = document.getElementById("handleMsg");
                    var theRoot = document.getElementById("Windowmsg");
                    Drag.init(theHandle, theRoot);
                } else {
                    borramsg();
                }
            }
        }
    });
    CTM.blur(function () {
        if (CTM.val().length > 0) {
            if (validarCMayor() == false) {
                $("BODY").append('<div id="overlay"></div>');
                OpenWindowMsg("CM");
                var theHandle = document.getElementById("handleMsg");
                var theRoot = document.getElementById("Windowmsg");
                Drag.init(theHandle, theRoot);
            }
        }
    });
    CC.focus(function () {
        checarPosiMa(11);
    });
    CC.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            if (CC.val().length > 0) {
                if (validarCCosto() == false) {
                    $("BODY").append('<div id="overlay"></div>');
                    OpenWindowMsg("CC");
                    var theHandle = document.getElementById("handleMsg");
                    var theRoot = document.getElementById("Windowmsg");
                    Drag.init(theHandle, theRoot);
                }
            }
        }
    });
    CC.blur(function () {
        if (CC.val().length > 0) {
            if (validarCCosto() == false) {
                $("BODY").append('<div id="overlay"></div>');
                OpenWindowMsg("CC");
                var theHandle = document.getElementById("handleMsg");
                var theRoot = document.getElementById("Windowmsg");
                Drag.init(theHandle, theRoot);
            }
        }
    });
    OR.focus(function () {
        checarPosiMa(12);
    });
    OR.blur(function () {
        if (OR.val().length > 0) {
            if (validarOrden() == false) {
                $("BODY").append('<div id="overlay"></div>');
                OpenWindowMsg("OR");
                var theHandle = document.getElementById("handleMsg");
                var theRoot = document.getElementById("Windowmsg");
                Drag.init(theHandle, theRoot);
            }
        }
    });
    OR.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            if (CC.val().length > 0) {
                if (validarOrden() == false) {
                    $("BODY").append('<div id="overlay"></div>');
                    OpenWindowMsg("OR");
                    var theHandle = document.getElementById("handleMsg");
                    var theRoot = document.getElementById("Windowmsg");
                    Drag.init(theHandle, theRoot);
                }
            }
        }
    });
    TXP.focus(function () {
        checarPosiMa(-1);
    });
    function checarPosiMa(index) {
        $.each(MATCH, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }

    MOC.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('OCompras');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalOrgCompras");
        Drag.init(theHandle, theRoot);
    });
    $('#BusOComprasSP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOCompras();
        }
    });
    $('#BusDenOComSP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOCompras();
        }
    });
    $('#okOCompras').click(function () {
        ConsultaOCompras();
    });
    MGC.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('GCompras');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalGCompras");
        Drag.init(theHandle, theRoot);
    });
    $('#BusGCompras').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaGCompras();
        }
    });
    $('#BusDenGCompras').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaGCompras();
        }
    });
    $('#okGCompras').click(function () {
        ConsultaGCompras();
    });
    MTI.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('Imputacion');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalImputacion");
        Drag.init(theHandle, theRoot);
    });
    $('#BusTipoImputacion').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaImputacion();
        }
    });
    $('#BusDenImputacion').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaImputacion();
        }
    });
    $('#okImputacion').click(function () {
        ConsultaImputacion();
    });
    MTP.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('TipoPosicion');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalTipoPosicion");
        Drag.init(theHandle, theRoot);
    });
    $('#BusTipoPosicion').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaTipoPosicion();
        }
    });
    $('#BusTextoTipoPosicion').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaTipoPosicion();
        }
    });
    $('#okPosicion').click(function () {
        ConsultaTipoPosicion();
    });
    MMA.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('Material');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalMateriales");
        Drag.init(theHandle, theRoot);
    });
    $('#BusMaterial').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#BusTextoMaterial').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#BusCentroMaterial').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#okMaterial').click(function () {
        ConsultaMaterial();
    });
    MCE.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('Centro');
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
    });
    $('#BusCentro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });
    $('#BusDesCentro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });
    $('#okCentro').click(function () {
        ConsultaCentro();
    });
    MAL.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('Almacen');
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalAlmacen");
        Drag.init(theHandle, theRoot);
    });
    $('#BusDenAlm').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    $('#BusAlmacen').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    $('#BusCentroAlmacen').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    $('#okAlmacen').click(function () {
        ConsultaAlmacen();
    });
    MUM.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('UM');
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalUM");
        Drag.init(theHandle, theRoot);
    });
    $('#BusUM').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUM();
        }
    });
    $('#okUnidadMedida').click(function () {
        ConsultaUM();
    });
    MGA.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('GArticulos');
        var theHandle = document.getElementById("handle9");
        var theRoot = document.getElementById("VentanaModalGArticulos");
        Drag.init(theHandle, theRoot);
    });
    $('#BusGArtiulos').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaGArticulos();
        }
    });
    $('#BusDenGArt').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaGArticulos();
        }
    });
    $('#BusDesGArt').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaGArticulos();
        }
    });
    $('#okGArticulos').click(function () {
        ConsultaGArticulos();
    });
    SOL.blur(function () {
        if (SOL.val().length > 0) {
            SOL.css('background-image', 'none');
        } else {
            SOL.css('background-image', 'none');
        }
    });
    SOL.focus(function () {
        SOL.css('background-image', 'none');
    });
    MCM.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('CMayor');
        var theHandle = document.getElementById("handle10");
        var theRoot = document.getElementById("VentanaModalCuentaMayor");
        Drag.init(theHandle, theRoot);
    });
    $('#BusNCuenta').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCMayor();
        }
    });
    $('#BusDesNCuenta').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCMayor();
        }
    });
    $('#BusPlanCuenta').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCMayor();
        }
    });
    $('#okCMayor').click(function () {
        ConsultaCMayor();
    });
    MCC.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('CCosto');
        var theHandle = document.getElementById("handle11");
        var theRoot = document.getElementById("VentanaModalCentroCosto");
        Drag.init(theHandle, theRoot);
    });
    $('#BusCCosto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCCosto();
        }
    });
    $('#BusDemCCosto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCCosto();
        }
    });
    $('#BusSoc').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCCosto();
        }
    });
    $('#okCCcosto').click(function () {
        ConsultaCCosto();
    });
    MOR.click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('Orden');
        var theHandle = document.getElementById("handle12");
        var theRoot = document.getElementById("VentanaModalOrden");
        Drag.init(theHandle, theRoot);
    });
    $('#BusClaseOrd').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#BusNumOrd').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#BustxtOrd').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#okOrden').click(function () {
        ConsultaOrden();
    });
    BSERV.click(function () {
        TIMP = TI.val().toUpperCase();
        TPOS = TP.val().toUpperCase();
        var dob = DatosObligatoriosCab();
        var f = validarTipoPosicion();
        var TIK = DatosObKF();
        var TIF = DatosObFF();
        //alert(tif);
        if (dob != false) {
            if (f == true) {
                switch (TIMP) {
                    case "K":
                        if (TIK == true) {
                            if (validarDatosOb2() == true) {
                                $("BODY").append('<div id="overlay"></div>');
                                OpenServices();
                                var theHandle = document.getElementById("handleSer");
                                var theRoot = document.getElementById("WindowService");
                                Drag.init(theHandle, theRoot);
                            }
                        } else {
                            $("BODY").append('<div id="overlay"></div>');
                            OpenWindowMsg("TIK");
                            var theHandle = document.getElementById("handleMsg");
                            var theRoot = document.getElementById("Windowmsg");
                            Drag.init(theHandle, theRoot);
                        }
                        break;
                    case "F":
                        if (TIF == true) {
                            if (validarDatosOb() == true) {
                                $("BODY").append('<div id="overlay"></div>');
                                OpenServices();
                                var theHandle = document.getElementById("handleSer");
                                var theRoot = document.getElementById("WindowService");
                                Drag.init(theHandle, theRoot);
                            }
                        } else {
                            $("BODY").append('<div id="overlay"></div>');
                            OpenWindowMsg("TIF");
                            var theHandle = document.getElementById("handleMsg");
                            var theRoot = document.getElementById("Windowmsg");
                            Drag.init(theHandle, theRoot);
                        }
                        break;
                    default:
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TPKFF");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                        break;
                }

            } else {
                $("BODY").append('<div id="overlay"></div>');
                OpenWindowMsg("TPKFF");
                var theHandle = document.getElementById("handleMsg");
                var theRoot = document.getElementById("Windowmsg");
                Drag.init(theHandle, theRoot);
            }
        }

    });
    BADDP.click(function () {
        
        var doc = DatosObligatoriosCab();
        var dok = DatosObK();
        var dof = DatosObF();
        var dov = DatosObVacio();
        var f = validarTipoPosicion();
        var TIMP = TI.val().toUpperCase();
        if (doc != false) {
            if (f != true) {
            switch (TIMP) {
                case "":
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }
                    }
                    break;
                case "K":
                    if (dok == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }
                    }
                    break;
                case "F":
                    if (dof == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }

                    }
                    break;
                default:
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }
                    }

                    break;
            }
          }
          else{
              switch (TIMP) {
                case "":
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }
                    }
                    break;
                case "K":
                    if (dok == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb2() == true) {
                            agregarDatosPosi();
                        }
                    }
                    break;
                case "F":
                    if (dof == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }

                    }
                    break;
                default:
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosPosi();
                        }
                    }

                    break;
            }
          }
        }
    });
    function DatosObligatoriosCab() {
        var correct = true;
        var DataCab = [
            GC,
            OC
        ];
        $.each(DataCab, function (i, v) {
            if (v.val().length < 1) {
                msgDataObli();
                v.focus();
                correct = false;
            }
        });
        return correct;
    }
    function TImputaionF() {
        TPOS = TP.val().toUpperCase();
        if (TPOS === "F") {
            return true;
        } else {
            return false;
        }
    }
    $('#finalizar').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handleDoc");
        var theRoot = document.getElementById("MensajeSalirModulo");
        Drag.init(theHandle, theRoot);
        MensajeSalirModulo();

    });
    $('#cancelar').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handleDoc");
        var theRoot = document.getElementById("MensajeSalirModulo");
        Drag.init(theHandle, theRoot);
        MensajeSalirModulo();

    });
    $('#FinalizarSIDoc').click(function () {
        CancelarSolped();
    });
    $('#FinalizarNODoc').click(function () {
        CerrarMensajeSalirModulo();
    });

    $('#okdSer').click(function () {
        ConsultaServicios();
    });
 $('#aceptar').click(function () {
        CheckdataSolped();
    });
    $('#Numsoli').keypress(function (e) {
        if(e.which == 13 || e.keyCode == 13){
            CheckdataSolped();
        }
    });
    
   
    BMODAGR.click(function(){
      
        var doc = DatosObligatoriosCab();
        var dok = DatosObK();
        var dof = DatosObF();
        var dov = DatosObVacio();
        var TIMP = TI.val().toUpperCase();
        if (doc != false) {
            switch (TIMP) {
                case "":
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosMOdPosi();
                        }
                    }
                    break;
                case "K":
                    if (dok == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosMOdPosi();
                        }
                    }
                    break;
                case "F":
                    if (dof == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                           agregarDatosMOdPosi();
                        }
                        
                    }
                    break;
                default:
                    if (dov == false) {
                        $("BODY").append('<div id="overlay"></div>');
                        OpenWindowMsg("TIKP");
                        var theHandle = document.getElementById("handleMsg");
                        var theRoot = document.getElementById("Windowmsg");
                        Drag.init(theHandle, theRoot);
                    } else {
                        if (validarDatosOb() == true) {
                            agregarDatosMOdPosi();
                        }
                    }

                    break;
            }
        }
        
    });

    PV.keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        }
        patron = /[0-9\.{1}]/g;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    PV.blur(function () {
        var valor = PV.val();
        var RE = /^\d+(?:\.\d{0,2})$/;
        if (valor.indexOf(".") != -1) {
            if (!(RE.test(valor))) {
                PV.val("");
                PV.focus();
                mensajesValidacionInco("Formato incorrecto de precio valor");
            } else {
                borrarmsg();
            }
        }

    });
    
    TC.keypress(function (e) {
        tecla = (document.all) ? e.which : e.keyCode;
        if (tecla == 8) {
            return true;
        }
        patron = /[áéíóúÁÉÍÓÚÑñA-Za-z0-9\s]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    TXP.keypress(function (e) {
        tecla = (document.all) ? e.which : e.keyCode;
        if (tecla == 8) {
            return true;
        }
        patron = /[áéíóúÁÉÍÓÚÑñA-Za-z0-9\s]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
});




