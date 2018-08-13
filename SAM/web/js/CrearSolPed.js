
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    setTimeout(obtenerip(),0001);
    AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
    CargarTipoSolped();
    verificaCentPorUsuario();
    CargarOrgCompra();
    CargarTipoImputacion();
    CargarTipoPosicion();
    startTime();
    setTimeout(LimpiarTemporal,4000);
    
    $('#ctaMayor').prop('disabled', true);
    $('#CenCosto').prop('disabled', true);
    $('#Orde').prop('disabled', true);
    $('#iconmsg').hide();
    var CDO = $('#ClaseDoc');
    var OCO = $('#OrgCompras');
    var GCO = $('#GpoCompras');
    var TCA = $('#TextCabecera_SP');
    var DIS = $('#Distribucion_SP');
    var TIM = $('#TipoImputacion');
    var TPO = $('#TipoPosicion');
    var MAT = $('#Material');
    var CAN = $('#Cantidad');
    var FCE = $('#FecEntrega');
    var CEN = $('#Centro');
    var ALM = $('#Almacen');
    var TBR = $('#Txtbrve');
    var UME = $('#unidamedida');
    var GAR = $('#GpoArticulo');
    var SOL = $('#solicitante');
    var CTM = $('#ctaMayor');
    var CCO = $('#CenCosto');
    var ORD = $('#Orde');
    var TXP = $('#TextPosicion_SP');
    var INPUTARR = [
        CDO,
        OCO,
        GCO,
        TCA,
        DIS,
        TIM,
        TPO,
        MAT,
        CAN,
        FCE,
        CEN,
        ALM,
        TBR,
        UME,
        GAR,
        SOL,
        CTM,
        CCO,
        ORD,
        TXP
    ];
    var MGCO = $('#matchGrupoCompra');
    var MMAT = $('#matchMaterial');
    var MFEC = $('#btnfecha');
    var MCEN = $('#matchCentro');
    var MALM = $('#matchAlmacen');
    var MUME = $('#matchUM');
    var MGAR = $('#matchGpoArticulo');
    var MCMA = $('#matchCtaMayor');
    var MCCO = $('#matchCCosto');
    var MORD = $('#matchOrden');

    var MATCHARR = [
        MGCO,
        MMAT,
        MFEC,
        MCEN,
        MALM,
        MUME,
        MGAR,
        MCMA,
        MCCO,
        MORD
    ];
    var BADDP = $('#btnAddPos');
    var BMODP = $('#btnModPos');
    var BSERV = $('#btnservicios');
    BSERV.prop('disabled', true);
    BMODP.prop('disabled', true);
    $.each(INPUTARR, function (i, v) {
        switch (i) {
            case 0: ///////  Clase de Documento
                v.focus(function () {
                    checarPosiMa(-1);
                });
                v.change(function () {
                    if (TPO.val().length == 0 || TPO.val().length == null) {
                        MAT.val('');
                        TBR.val('');
                        UME.val('');
                        GAR.val('');
                        MAT.css('background-image', 'url(images/necesario.PNG)');
                        TBR.css('background-image', 'url(images/necesario.PNG)');
                        UME.css('background-image', 'url(images/necesario.PNG)');
                        GAR.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
                break;
            case 1:  /////  Org. Compras
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 2: /////  Gpo Compras
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
                    var paraGC = "&GCompras=" + v.val();
                    validarDato('GpoCompras', 'ValidarGCompras', paraGC, 7);
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        var paraGC = "&GCompras=" + v.val();
                        validarDato('GpoCompras', 'ValidarGCompras', paraGC, 7);
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 3: /////  Texto Cabecera
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 4: ////  posiciones
                v.focus(function () {
                    checarPosiMa(-1);
                });
                v.change(function () {
                    var pos = v.val();
                    if (pos == null || pos == '') {
                        ResetPosicion();
                    } else {
                        CargarDatosPosicio(pos);
                        BADDP.prop('disabled', true);
                        BMODP.prop('disabled', false);
                    }
                });
                break;
            case 5: ////  Tipo Imputacion
                v.focus(function () {
                    checarPosiMa(-1);
                });
                v.change(function () {
                    var lengthsele = $('#TipoImputacion > option').length;
                    if (lengthsele > 0) {
                        t1 = TIM.val().toUpperCase();
                        t2 = TPO.val().toUpperCase();
                        if (t1 == "K") {
                            CTM.prop('disabled', false);
                            CCO.prop('disabled', false);
                            ALM.prop('disabled', true);
                            ORD.prop('disabled', true);
                            ORD.val("");
                            ALM.val("");
                            if (CTM.val().length > 0) {
                                CTM.css('background-image', 'none');
                            } else {
                                CTM.css('background-image', 'url(images/necesario.PNG)');

                            }
                            if (CCO.val().length > 0) {
                                CCO.css('background-image', 'none');
                            } else {
                                CCO.css('background-image', 'url(images/necesario.PNG)');
                            }
                        } else {
                            ALM.prop('disabled', false);
                            CCO.css('background-image', 'none');
                            CCO.val("");
                        }
                        if (t2 == "F") {
                            MAT.prop('disabled', true);
                            MAT.val("");
                            MAT.css('background-image', 'none');
                        }
                        if (t1 == "F") {
                            CTM.prop('disabled', false);
                            CCO.prop('disabled', true);
                            ORD.prop('disabled', false);
                            if (ORD.val().length < 1) {
                                ORD.css('background-image', 'url(images/necesario.PNG)');
                            }
                            if (CTM.val().length < 1) {
                                CTM.css('background-image', 'url(images/necesario.PNG)');
                            }
                        } else {
                            ORD.css('background-image', 'none');
                            ORD.val("");
                        }
                        if (t1 == "") {
                            CTM.prop('disabled', true);
                            CCO.prop('disabled', true);
                            ORD.prop('disabled', true);
                            CTM.css('background-image', 'none');
                            CTM.val("");
                        }
                        var t = v.val();
                        if (t === "k" || t === "K") {
                            ALM.prop("disabled", true);
                            ALM.val("");
                        } else {
                            ALM.prop("disabled", false);
                        }
                    }
                });
                break;
            case 6: /////  Tipo Posicion
                v.focus(function () {
                    checarPosiMa(-1);
                });
                v.change(function () {
                    var lengthsele = $('#TipoImputacion > option').length;
                    if (lengthsele > 0) {
                        t1 = TIM.val().toUpperCase();
                        t2 = TPO.val().toUpperCase();
                        if (t2 === "F") {
                            MAT.prop('disabled', true);
                            MAT.val("");
                            MAT.css('background-image', 'none');
                            BADDP.prop("disabled", true);
                            BSERV.prop("disabled", false);
                            $('#btnModPos').prop('disabled', true);
                            if (TBR.val().length < 1) {
                                TBR.css('background-image', 'url(images/necesario.PNG)');
                            }
                        } else {
                            BSERV.prop("disabled", true);
                            TBR.css('background-image', 'none');
                            MAT.prop('disabled', false);
                            if (MAT.val().length < 1) {
                                MAT.css('background-image', 'url(images/necesario.PNG)');
                            }
                            if ($('#Distribucion_SP').val() === null || $('#Distribucion_SP').val() === "") {
                                $('#btnModPos').prop('disabled', true);
                                BADDP.prop("disabled", false);

                            } else {
                                $('#btnModPos').prop('disabled', false);
                            }
                        }
                    }
                });
                break;
            case 7: ///// Input Material
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(1);
                });
                v.blur(function () {
                    var lengthsele = $('#TipoImputacion > option').length;
                    if (lengthsele > 0) {
                        var t1 = TIM.val().toUpperCase();
                        if (v.val().length > 0) {
                            v.css('background-image', 'none');
                            validarMateri();
                        } else {
                            if (t1 === "K" || t1 == "F") {
                                $('#ctaMayor').prop('disabled', false);
                            }
                            if (!(v.val().length > 0)) {
                                v.css('background-image', 'url(images/necesario.PNG)');
                            }
                        }
                    }
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        if (MAT.val().length > 0) {
                            validarMateri();
                        }
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 8: /////  Cantidad
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(-1);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        this.value = checkDec(this.value, 3);
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /[0-9.]/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
            case 9: ///// Fecha Entrega
                v.prop('readonly', true);
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(2);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                        validarFecha(this.value);
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
            case 10: ///// Centro
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
                    var paramCE = "&CentroSP=" + v.val();
                    validarDato('Centro', 'ValidarCentro', paramCE, 9);
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        var paramCE = "&CentroSP=" + v.val();
                        validarDato('Centro', 'ValidarCentro', paramCE, 9);
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 11: ///// Almacen
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.blur(function () {
                    var paramAL = "&Almacen=" + v.val();
                    validarDato('Almacen', 'ValidarAlmacen', paramAL, 10);
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        var paramAL = "&Almacen=" + v.val();
                        validarDato('Almacen', 'ValidarAlmacen', paramAL, 10);
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 12: ///// texto brv
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    checarPosiMa(-1);
                    v.css('background-image', 'none');
                });
                v.blur(function () {
//                    var tposi = $('#TipoPosicion > option').length;
//                    if (tposi > 0) {
//                        t2 = TPO.val().toUpperCase();
                    if (v.val().length < 1) {

                        v.css('background-image', 'url(images/necesario.PNG)');
                    } else {
                        v.css('background-image', 'none');
                    }
//                        }

                });
                break;
            case 13: ///// UM
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
                    var paramUM = "&UM=" + encodeURIComponent(v.val());
                    validarDato('unidamedida', 'ValidarUMedida', paramUM, 11);
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        var paramUM = "&UM=" + encodeURIComponent(v.val());
                        validarDato('unidamedida', 'ValidarUMedida', paramUM, 11);
                    }
                    if (te == 32) {
                        return false;
                    }
                });
                break;
            case 14: ///// Gpo Articulo
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
                    var paramGA = "&GArt=" + v.val();
                    validarDato('GpoArticulo', 'ValidarGArticulo', paramGA, 12);
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        var paramGA = "&GArt=" + v.val();
                        validarDato('GpoArticulo', 'ValidarGArticulo', paramGA, 12);
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 15: ///// Solicitante
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 16: ///// Cuenta Mayor
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(7);
                });
                v.keypress(function (e) {
                    var tecl = (document).all ? e.keycode : e.which;
                    patron = /[0-9]/;
                    if (e.which == 13 || e.keycode == 13) {
                        if (CTM.val().length > 0) {
                            if (validarCMayor(this.value) == false) {
                                ShowMsgWindow(0, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                                v.val('');
                                v.css('background-image', 'url(images/necesario.PNG)');
                            } else {
                                borramsg();
                            }
                        }
                    }
                    var tcf = String.fromCharCode(tecl);
                    return patron.test(tcf);
                });
                v.blur(function () {
                    if (CTM.val().length > 0) {
                        v.css('background-image', 'none');
                        if (validarCMayor(this.value) == false) {
                            ShowMsgWindow(0, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                            v.val('');
                            v.css('background-image', 'url(images/necesario.PNG)');
                        }
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 17: ///// Centro Costo
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(8);
                });
                v.blur(function () {
                    if (CCO.val().length > 0) {
                        CCO.css('background-image', 'none');
                        if (validarCCosto(this.value) == false) {
                            ShowMsgWindow(1, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                            v.val('');
                            CCO.css('background-image', 'url(images/necesario.PNG)');
                        }
                    } else {
                        CCO.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        if (v.val().length > 0) {
                            if (validarCCosto(this.value) == false) {
                                ShowMsgWindow(1, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                                v.val('');
                            }
                        }
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 18: ///// Orden
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(9);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        if (validarOrden(this.value) == false) {
                            ShowMsgWindow(2, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                            v.val('');
                        }
                    }
                    var imputlen = $('#TipoImputacion > option').length;
                    if (imputlen > 0) {
                        var t1 = TIM.val().toUpperCase();
                        if (t1 == "F") {
                            if (v.val().length > 0) {
                                v.css('background-image', 'none');
                            } else {
                                v.css('background-image', 'url(images/necesario.PNG)');
                                $('#OrdSAM').val("");
                            }
                        }
                    }
                });
                v.keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    if (te == 13) {
                        if (v.val().length > 0) {
                            if (validarOrden(this.value) == false) {
                                ShowMsgWindow(2, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
                                v.val();
                            }
                        }
                    }
                    if (te == 32) {
                        return false;
                    }
                    t = String.fromCharCode(te);
                    patron = /[ÑñA-Za-z0-9\s]/;
                    return patron.test(t);
                });
                break;
            case 19: /// texto posicion
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(-1);
                });
                break;
        }

    });
    $.each(MATCHARR, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalGCompras', 'handle2', 'BusGCompras');
                });
                break;
            case 1:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalMateriales', 'handle5', 'BusMaterial');
                });
                break;
            case 2:
                v.click(function () {
                    OpenCalendario();
                });
                break;
            case 3:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalCentro', 'handle6', 'BusCentro');
                });
                break;
            case 4:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalAlmacen', 'handle7', 'BusAlmacen');
                });
                break;
            case 5:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalUM', 'handle8', 'BusUM');
                });
                break;
            case 6:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalGArticulos', 'handle9', 'BusGArtiulos');
                });
                break;
            case 7:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalCuentaMayor', 'handle10', 'BusNCuenta');
                });
                break;
            case 8:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalCentroCosto', 'handle11', 'BusCCosto');
                });
                break;
            case 9:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalOrden', 'handle12', 'BusClaseOrd');
                });
                break;
        }
    });

    function checarPosiMa(index) {
        $.each(MATCHARR, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }

    function validarCMayor(cu) {
        var resp = false;
        var acc = "validarCMayor";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&NCuenta=" + cu,
            success: function (data) {
                if (data == 1) {
                    resp = true;
                } else {
                    resp = false;
                }
            }
        });
        return resp;
    }
    function validarCCosto(cc) {
        var resp = false;
        var acc = "validarCCosto";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&CCosto=" + cc,
            success: function (data) {
                if (data == 1) {
                    resp = true;
                } else {
                    resp = false;
                }
            }
        });
        return resp;
    }
    function validarOrden(or) {
        var resp = false;
        var acc = "validarOrden";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Orden=" + or.toUpperCase(),
            success: function (data) {
                if (data == 2) {
                    resp = false;
                } else {
                    var a = new Array();
                    a = data.split(",");
                    if (a[0].length > 0) {
                        $('#Orde').val(a[0]);
                        $('#OrdSAM').val(a[1]);
                    } else {
                        $('#Orde').val(a[1]);
                        $('#OrdSAM').val('');
                    }
                    resp = true;
                }
            }
        });
        return resp;
    }
    //////Cargar Datos campos
    /// --- Organizacion de Compras ---
    function CargarTipoSolped() {
        var acc = "ConusltarTipoSolped";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Centro=" + $('#Centro').val().trim(),
            success: function (data) {
                $('#ClaseDoc').html(data);
            }
        });
    }
    function CargarOrgCompra() {
        var acc = "ConsultarOCompras";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                $('#OrgCompras').html(data);
            }
        });
    }
    /// --- Grupo Compras ---
    $('#CerrarMCOrg1').click(function () {
        ocultarVentana('VentanaModalGCompras', 'BuscarParamGCompras_SP', 'ConsultaTablaGCompras', 'GpoCompras');
    });
    $('#CerrarMCOrg2').click(function () {
        ocultarVentana('VentanaModalGCompras', 'BuscarParamGCompras_SP', 'ConsultaTablaGCompras', 'GpoCompras');
    });
    $('#BusGCompras').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarGpoCompra();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    $('#BusDenGCompras').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarGpoCompra();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarGpoCompra();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okGCompras').click(function () {
        CargarGpoCompra();
    });
    $('#retgcom').click(function () {
        $('#BuscarParamGCompras_SP').css('display', 'block');
        $('#ConsultaTablaGCompras').css('display', 'none');
    });
    function CargarGpoCompra() {
        var acc = "ConsultarGCompras";
        var ctd = $('#numAcMax2').val();
        if (ctd.length == 0) {
            ctd = "0";
        }
        var datos = "&GCompras=" + $('#BusGCompras').val() + "&DenGCompras=" + encodeURIComponent($('#BusDenGCompras').val().trim()) + "&Ctd=" + ctd;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatoGCompras').html(data);
                    $('#BuscarParamGCompras_SP').css('display', 'none');
                    $('#ConsultaTablaGCompras').css('display', 'block');
                    document.getElementById('table-scrollGCompras').onscroll = function () {
                        document.getElementById('fixedYGCompras').style.top = document.getElementById('table-scrollGCompras').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Tipo Imputacion ---
    function CargarTipoImputacion() {
        var acc = "ConsultarTipoImputacion";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                $('#TipoImputacion').html(data);
            }
        });
    }
    /// --- Tipo de Posicion ---
    function CargarTipoPosicion() {
        var acc = "ConsultarTipoPosicion";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                $('#TipoPosicion').html(data);
            }
        });
    }
    /// ---  Materiales ---
    $('#CerraMCMate1').click(function () {
        ocultarVentana('VentanaModalMateriales', 'BuscarParamMateriales_SP', 'ConsultaTablaMaterial', 'Material');
    });
    $('#CerraMCMate2').click(function () {
        ocultarVentana('VentanaModalMateriales', 'BuscarParamMateriales_SP', 'ConsultaTablaMaterial', 'Material');
    });
    $('#retmate').click(function () {
        $('#BuscarParamMateriales_SP').css('display', 'block');
        $('#ConsultaTablaMaterial').css('display', 'none');
    });
    $('#BusMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusTextoMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
    });
    $('#BusCentroMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusTipoMat').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax5').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okMaterial').click(function () {
        ConsultaMaterial();
    });
    function ConsultaMaterial() {
        var acc = "ConsultarMateriales";
        var ctd = $('#numAcMax5').val();
        var datos = "&Material=" + $('#BusMaterial').val() + "&TextoMat=" + encodeURIComponent($('#BusTextoMaterial').val().trim()) + "&Centro=" + $('#BusCentroMaterial').val() + "&Tipo=" + $('#BusTipoMat').val() + "&Ctd=" + ctd + "&tipoSolp=" + $('#ClaseDoc').val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatosMateriales').html(data);
                    $('#BuscarParamMateriales_SP').css('display', 'none');
                    $('#ConsultaTablaMaterial').css('display', 'block');
                    document.getElementById('table-scrollMaterial').onscroll = function () {
                        document.getElementById('fixedYMaterial').style.top = document.getElementById('table-scrollMaterial').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Fecha Entrega ---
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    /// --- Centro ---
    $('#CerrarMCCentro1').click(function () {
        ocultarVentana('VentanaModalCentro', 'BuscarParamCentro_SP', 'ConsultaTablaCentro', 'Centro');
    });
    $('#CerrarMCCentro2').click(function () {
        ocultarVentana('VentanaModalCentro', 'BuscarParamCentro_SP', 'ConsultaTablaCentro', 'Centro');
    });
    $('#retcentro').click(function () {
        $('#BuscarParamCentro_SP').css('display', 'block');
        $('#ConsultaTablaCentro').css('display', 'none');
    });
    $('#BusCentro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesCentro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
    });
    $('#numAcMax6').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCentro();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCentro').click(function () {
        ConsultaCentro();
    });
    function ConsultaCentro() {
        var acc = "ConsultarCentro";
        var ctd = $('#numAcMax6').val();
        if (ctd.length == 0) {
            ctd = "0";
        }
        var datos = "&CentroSP=" + $('#BusCentro').val() + "&CentroNomSP=" + encodeURIComponent($('#BusDesCentro').val().trim()) + "&Ctd=" + ctd;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatoCentro').html(data);
                    $('#BuscarParamCentro_SP').css('display', 'none');
                    $('#ConsultaTablaCentro').css('display', 'block');
                    document.getElementById('table-scrollCentro').onscroll = function () {
                        document.getElementById('fixedYCentro').style.top = document.getElementById('table-scrollCentro').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Almacen ---
    $('#CerrarMCAlmacen1').click(function () {
        ocultarVentana('VentanaModalAlmacen', 'BuscarParamAlmacen_SP', 'ConsultaTablaAlmacen', 'Almacen');
    });
    $('#CerrarMCAlmacen2').click(function () {
        ocultarVentana('VentanaModalAlmacen', 'BuscarParamAlmacen_SP', 'ConsultaTablaAlmacen', 'Almacen');
    });
    $('#retAlmacen').click(function () {
        $('#BuscarParamAlmacen_SP').css('display', 'block');
        $('#ConsultaTablaAlmacen').css('display', 'none');
    });
    $('#BusDenAlm').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaAlmacen();
        }
    });
    $('#BusAlmacen').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaAlmacen();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusCentroAlmacen').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaAlmacen();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax7').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaAlmacen();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okAlmacen').click(function () {
        ConsultaAlmacen();
    });
    function ConsultaAlmacen() {
        var acc = "ConsultarAlmacen";
        var datos = "&DenAlm=" + encodeURIComponent($('#BusDenAlm').val().trim()) + "&Almacen=" + $('#BusAlmacen').val() + "&CentroSP=" + $('#BusCentroAlmacen').val() + "&Ctd=" + $('#numAcMax7').val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatoAlmacen').html(data);
                    $('#BuscarParamAlmacen_SP').css('display', 'none');
                    $('#ConsultaTablaAlmacen').css('display', 'block');
                    document.getElementById('table-scrollAlmacen').onscroll = function () {
                        document.getElementById('fixedYAlmacen').style.top = document.getElementById('table-scrollAlmacen').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Unidad Medida---
    $('#CerrarMCUMedida1').click(function () {
        ocultarVentana('VentanaModalUM', 'BuscarParamUM_SP', 'ConsultaTablaUM', 'unidamedida');
    });
    $('#CerrarMCUMedida2').click(function () {
        ocultarVentana('VentanaModalUM', 'BuscarParamUM_SP', 'ConsultaTablaUM', 'unidamedida');
    });
    $('#retUMedida').click(function () {
        $('#BuscarParamUM_SP').css('display', 'block');
        $('#ConsultaTablaUM').css('display', 'none');
    });
    $('#BusUM').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUM();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#BusTextoUM').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUM();
        }
    });
    $('#numAcMax8').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUM();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[1-8]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okUnidadMedida').click(function () {
        ConsultaUM();
    });
    function ConsultaUM() {
        var acc = "ConsultarUM";
        var datos = "&UM=" + encodeURIComponent($('#BusUM').val()) + "&TextoUM=" + encodeURIComponent($('#BusTextoUM').val().trim()) + "&Ctd=" + $('#numAcMax8').val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatosUM').html(data);
                    $('#BuscarParamUM_SP').css('display', 'none');
                    $('#ConsultaTablaUM').css('display', 'block');
                    document.getElementById('table-scrollUM').onscroll = function () {
                        document.getElementById('fixedYUM').style.top = document.getElementById('table-scrollUM').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Grupo Articulos ---
    $('#CerrarMCGArticulo1').click(function () {
        ocultarVentana('VentanaModalGArticulos', 'BuscarParamGArticulos_SP', 'ConsultaTablaGArticulos', 'GpoArticulo');
    });
    $('#CerrarMCGArticulo2').click(function () {
        ocultarVentana('VentanaModalGArticulos', 'BuscarParamGArticulos_SP', 'ConsultaTablaGArticulos', 'GpoArticulo');
    });
    $('#retGArticulo').click(function () {
        $('#BuscarParamGArticulos_SP').css('display', 'block');
        $('#ConsultaTablaGArticulos').css('display', 'none');
    });
    $('#BusGArtiulos').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGArticulos();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDenGArt').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGArticulos();
        }
    });
    $('#BusDesGArt').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGArticulos();
        }
    });
    $('#numAcMax9').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGArticulos();
        }
        if (tecla == 32) {
            return  false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okGArticulos').click(function () {
        ConsultaGArticulos();
    });

    function ConsultaGArticulos() {
        var acc = "ConsultarGArticulos";
        var datos = "&GArt=" + $('#BusGArtiulos').val() + "&DGArt=" + encodeURIComponent($('#BusDenGArt').val().trim()) + "&DSGArt=" + encodeURIComponent($('#BusDesGArt').val().trim()) + "&Ctd=" + $('#numAcMax9').val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatoGArticulos').html(data);
                    $('#BuscarParamGArticulos_SP').css('display', 'none');
                    $('#ConsultaTablaGArticulos').css('display', 'block');
                    document.getElementById('table-scrollGArticulos').onscroll = function () {
                        document.getElementById('fixedYGArticulos').style.top = document.getElementById('table-scrollGArticulos').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Cuenta Mayor ---
    $('#CerraMCCMayor1').click(function () {
        ocultarVentana('VentanaModalCuentaMayor', 'BuscarParamCuentaMayor', 'ConsultaTablaCMayor', 'ctaMayor');
    });
    $('#CerraMCCMayor2  ').click(function () {
        ocultarVentana('VentanaModalCuentaMayor', 'BuscarParamCuentaMayor', 'ConsultaTablaCMayor', 'ctaMayor');
    });
    $('#retCMayor').click(function () {
        $('#BuscarParamCuentaMayor').css('display', 'block');
        $('#ConsultaTablaCMayor').css('display', 'none');
    });
    $('#BusNCuenta').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCMayor();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesNCuenta').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCMayor();
        }
    });
    $('#numAcMax10').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCMayor();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCMayor').click(function () {
        ConsultaCMayor();
    });
    function ConsultaCMayor() {
        var acc = "ConsultarCMayor";
        var ctd = $('#numAcMax10').val();
        if (ctd.length == 0) {
            ctd = "0";
        }
        var datos = "&NCuenta=" + $('#BusNCuenta').val() + "&DNCuenta=" + encodeURIComponent($('#BusDesNCuenta').val().trim()) + "&Ctd=" + ctd;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatoCMayor').html(data);
                    $('#BuscarParamCuentaMayor').css('display', 'none');
                    $('#ConsultaTablaCMayor').css('display', 'block');
                    document.getElementById('table-scrollCMayor').onscroll = function () {
                        document.getElementById('fixedYCMayor').style.top = document.getElementById('table-scrollCMayor').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// -- Centro Costo ---
    $('#CerrarMcCCosto1').click(function () {
        ocultarVentana('VentanaModalCentroCosto', 'BuscarParamCCosto', 'ConsultaTablaCCosto', 'CenCosto');
    });
    $('#CerrarMcCCosto2').click(function () {
        ocultarVentana('VentanaModalCentroCosto', 'BuscarParamCCosto', 'ConsultaTablaCCosto', 'CenCosto');
    });
    $('#retCCosto').click(function () {
        $('#BuscarParamCCosto').css('display', 'block');
        $('#ConsultaTablaCCosto').css('display', 'none');
    });
    $('#BusCCosto').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDemCCosto').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
        }
    });
    $('#Sociedad').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax11').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaCCosto();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okCCcosto').click(function () {
        ConsultaCCosto();
    });
    function ConsultaCCosto() {
        var acc = "ConsultarCCosto";
        var ctd = $('#numAcMax11').val();
        if (ctd.length == 0) {
            ctd = "0";
        }
        var datos = "&CCosto=" + $('#BusCCosto').val() + "&DCCos=" + encodeURIComponent($('#BusDemCCosto').val().trim()) + "&Sociedad=" + $('#BusSoc').val() + "&Ctd=" + ctd;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatosCCosto').html(data);
                    $('#BuscarParamCCosto').css('display', 'none');
                    $('#ConsultaTablaCCosto').css('display', 'block');
                    document.getElementById('table-scrollCCosto').onscroll = function () {
                        document.getElementById('fixedYCCosto').style.top = document.getElementById('table-scrollCCosto').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    /// --- Orden ---
    $('#CerrarMCOrden1').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParamOrden', 'ConsultaTablaOrden', 'Orde');
    });
    $('#CerrarMCOrden2').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParamOrden', 'ConsultaTablaOrden', 'Orde');
    });
    $('#retOrden').click(function () {
        $('#BuscarParamOrden').css('display', 'block');
        $('#ConsultaTablaOrden').css('display', 'none');
    });
    $('#BusClaseOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusNumOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BustxtOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
    });
    $('#numAcMax12').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okOrden').click(function () {
        ConsultaOrden();
    });
    function ConsultaOrden() {
        var acc = "ConsultarOrden";
        var ctd = $('#numAcMax12').val();
        if (ctd.length == 0) {
            ctd = "0";
        }
        var datos = "&ClaseOrden=" + $('#BusClaseOrd').val() + "&Orden=" + encodeURIComponent($('#BusNumOrd').val().trim()) + "&DOrd=" + $('#BustxtOrd').val() + "&Ctd=" + ctd;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatosOrden').html(data);
                    $('#BuscarParamOrden').css('display', 'none');
                    $('#ConsultaTablaOrden').css('display', 'block');
                    document.getElementById('table-scrollOrden').onscroll = function () {
                        document.getElementById('fixedYOrden').style.top = document.getElementById('table-scrollOrden').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }

    $('#CerrarVentanaMsg1').click(function () {
        CerrarMsg();
    });
    $('#CloMsg').click(function () {
        CerrarMsg();
    });
    BADDP.click(function () {
        if (CDO.val().length == 0 || CDO.val() == null) {
            CDO.focus();
            ShowMsg(38, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            if (GCO.val().length > 0) {
                if ($('#TipoImputacion').val( ) == null || $('#TipoImputacion').val() == '') {
                    DatosObligatoriosImpVacio('ADD');
                }
                var t1 = TIM.val().toUpperCase();
                if (t1 == 'F') {
                    DatosObligatoriosImpF('ADD');
                }
                if (t1 == 'K') {
                    DatosObligatoriosImpK('ADD');
                }
            } else {
                GCO.focus();
                ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
            }
        }
    });
    BMODP.click(function () {
        if (CDO.val().length == 0 || CDO.val() == null) {
            CDO.focus();
            ShowMsg(38, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            if (GCO.val().length > 0) {
                if ($('#TipoImputacion').val( ) == null || $('#TipoImputacion').val() == '') {
                    DatosObligatoriosImpVacio('UPD');
                }
                var t1 = TIM.val().toUpperCase();
                if (t1 == 'F') {
                    DatosObligatoriosImpF('UPD');
                }
                if (t1 == 'K') {
                    DatosObligatoriosImpK('UPD');
                }
            } else {
                GCO.focus();
                ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
            }
        }
    });
    function DatosObligatoriosImpVacio(acc) {
        if (MAT.val().length == 0) {
            ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
            MAT.focus();
            return;
        }
        if (CAN.val().length == 0) {
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (parseFloat(CAN.val()) == 0.000) {
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (FCE.val().length == 0) {
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            FCE.focus();
            return;
        }
        if (CEN.val().length == 0) {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            CEN.focus();
            return;
        }
        if (UME.val().length == 0) {
            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (GAR.val().length == 0) {
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            GAR.focus();
            return;
        }
        validarMateri();
        var ficant = GetCantend(CAN.val(), UME.val());
        if (ficant.length == 0) {
            ShowMsg(39, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (ficant == "0.000") {
            ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        AgregarPosicionTemp(acc);
    }
    function DatosObligatoriosImpF(acc) {
        if (CAN.val().length == 0) {
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (parseFloat(CAN.val()) == 0.000) {
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (FCE.val().length == 0) {
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            FCE.focus();
            return;
        }
        if (CEN.val().length == 0) {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            CEN.focus();
            return;
        }
        if (TBR.val().length == 0) {
            ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
            TBR.focus();
            return;
        }
        if (UME.val().length == 0) {
            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (GAR.val().length == 0) {
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            GAR.focus();
            return;
        }
        if (CTM.val().length == 0) {
            ShowMsg(23, "images/advertencia.PNG", "audio/saperror.wav");
            CTM.focus();
            return;
        }
        if (ORD.val().length == 0) {
            ShowMsg(24, "images/advertencia.PNG", "audio/saperror.wav");
            ORD.focus();
            return;
        }
        if (MAT.val().length > 0) {
            validarMateri();
        }
        var ficant = GetCantend(CAN.val(), UME.val());
        if (ficant.length == 0) {
            ShowMsg(39, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (ficant == "0.000") {
            ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        AgregarPosicionTemp(acc);
    }
    function DatosObligatoriosImpFF() {
        if (CAN.val().length == 0) {
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (parseFloat(CAN.val()) == 0.000) {
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (FCE.val().length == 0) {
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            FCE.focus();
            return;
        }
        if (CEN.val().length == 0) {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            CEN.focus();
            return;
        }
        if (TBR.val().length == 0) {
            ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
            TBR.focus();
            return;
        }
        if (UME.val().length == 0) {
            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (GAR.val().length == 0) {
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            GAR.focus();
            return;
        }
        if (CTM.val().length == 0) {
            ShowMsg(23, "images/advertencia.PNG", "audio/saperror.wav");
            CTM.focus();
            return;
        }
        if (ORD.val().length == 0) {
            ShowMsg(24, "images/advertencia.PNG", "audio/saperror.wav");
            ORD.focus();
            return;
        }
        if (MAT.val().length > 0) {
            validarMateri();
        }
        var ficant = GetCantend(CAN.val(), UME.val());
        if (ficant.length == 0) {
            ShowMsg(39, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (ficant == "0.000") {
            ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        abrirSerVal();
    }
    function DatosObligatoriosImpK(acc) {
        if (CAN.val().length == 0) {
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (parseFloat(CAN.val()) == 0.000) {
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (FCE.val().length == 0) {
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            FCE.focus();
            return;
        }
        if (CEN.val().length == 0) {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            CEN.focus();
            return;
        }
        if (TBR.val().length == 0) {
            ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
            TBR.focus();
            return;
        }
        if (UME.val().length == 0) {
            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (GAR.val().length == 0) {
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            GAR.focus();
            return;
        }
        if (CTM.val().length == 0) {
            ShowMsg(23, "images/advertencia.PNG", "audio/saperror.wav");
            CTM.focus();
            return;
        }
        if (CCO.val().length == 0) {
            ShowMsg(25, "images/advertencia.PNG", "audio/saperror.wav");
            CCO.focus();
            return;
        }
        if (MAT.val().length > 0) {
            validarMateri();
        }
        var ficant = GetCantend(CAN.val(), UME.val());
        if (ficant.length == 0) {
            ShowMsg(39, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (ficant == "0.000") {
            ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (!(ValidarCombinacionCCCM(CTM.val(), CCO.val()))) {
            ShowMsgWindow(4, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
            return;
        }
        AgregarPosicionTemp(acc);

    }
    function DatosObligatoriosImpFK() {
        if (CAN.val().length == 0) {
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (parseFloat(CAN.val()) == 0.000) {
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (FCE.val().length == 0) {
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            FCE.focus();
            return;
        }
        if (CEN.val().length == 0) {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            CEN.focus();
            return;
        }
        if (TBR.val().length == 0) {
            ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
            TBR.focus();
            return;
        }
        if (UME.val().length == 0) {
            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (GAR.val().length == 0) {
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            GAR.focus();
            return;
        }
        if (CTM.val().length == 0) {
            ShowMsg(23, "images/advertencia.PNG", "audio/saperror.wav");
            CTM.focus();
            return;
        }
        if (CCO.val().length == 0) {
            ShowMsg(25, "images/advertencia.PNG", "audio/saperror.wav");
            CCO.focus();
            return;
        }
        if (MAT.val().length > 0) {
            validarMateri();
        }
        var ficant = GetCantend(CAN.val(), UME.val());
        if (ficant.length == 0) {
            ShowMsg(39, "images/advertencia.PNG", "audio/saperror.wav");
            UME.focus();
            return;
        }
        if (ficant == "0.000") {
            ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
            CAN.focus();
            return;
        }
        if (!(ValidarCombinacionCCCM(CTM.val(), CCO.val()))) {
            ShowMsgWindow(4, "images/infoicono.PNG", "audio/sapsnd05.wav", this.value);
            return;
        }
        abrirSerVal();
    }
    function AgregarPosicionTemp(acc) {
        var val = "";
        var po = $('#Distribucion_SP > option').length;
        
        if (po > 0) {
            if (acc == "ADD") {
                val = po;
            } else {
                val = DIS.val();
            }
        }
//        alert(DIS.val());
        if (DIS.val() == null || DIS.val() == null) {
            val = parseInt(po) + 1;
        }
//        alert(po+"  "+acc+" "+val);
        var ips = folioIP();
        var datos = "&PO=" + val + "&CD=" + CDO.val() + "&OC=" + OCO.val().toUpperCase() + "&GC=" + GCO.val().toUpperCase() + "&TI=" + TIM.val().toUpperCase() +
                "&TP=" + TPO.val().toUpperCase() + "&MA=" + MAT.val() + "&TB=" + encodeURIComponent(TBR.val()) + "&UM=" + UME.val().toUpperCase() +
                "&GA=" + GAR.val().toUpperCase() + "&CA=" + GetCantend(CAN.val(), UME.val()) + "&FE=" + checkFecha(FCE.val()) + "&CE=" + CEN.val().toUpperCase() +
                "&AL=" + ALM.val().toUpperCase() + "&SO=" + SOL.val().toUpperCase() + "&CM=" + CTM.val() + "&CC=" + CCO.val() + "&OR=" + ORD.val()+"&ipsf="+ips;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 1) {
                    ShowMsg(26, "images/advertencia.PNG", "audio/saperror.wav");
                    LimpiarTabla();
                } else if (data == 2) {
                    ShowMsg(27, "images/advertencia.PNG", "audio/saperror.wav");
                    LimpiarTabla();
                } else {
                    $('#TabBody').html(data);
                    var cen = $('.tdCentro');
                    if (cen.length > 0) {
                        CEN.prop('disabled', true);
                        CDO.prop('disabled', true);
                        $('#BusCentroMaterial').val(CEN.val());
                        $('#BusCentroAlmacen').val(CEN.val());
                        $('#BusCentroMaterial').prop('disabled', true);
                        $('#BusCentroAlmacen').prop('disabled', true);

                    }
                    if (acc == "UPD") {
                        DelPosText(val);
                    }
                    if (TXP.val().length > 0) {
                        textPosic(val, TXP.val());
                    }
                    $("#DobleSection").scroll(function () {
                        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                    });
                    $("#SecCuerpo").scroll(function () {
                        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                    });
                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                    ResetPosicion();
                    DIS.focus();
                    CargarListPos();
                }
            }
        });
    }
    function ResetPosicion() {
        BADDP.prop('disabled', false);
        BMODP.prop('disabled', true);
        $.each(INPUTARR, function (i, v) {
            if (i == 0 || i == 2 || i == 3 || i == 10 || i == 15) {
            } else {
                v.val('');
                $('#OrdSAM').val('');
            }
        });
        MAT.prop('disabled', false);
        MAT.css('background-image', 'url(images/necesario.PNG)');
        CAN.css('background-image', 'url(images/necesario.PNG)');
        FCE.css('background-image', 'url(images/necesario.PNG)');
        UME.css('background-image', 'url(images/necesario.PNG)');
        GAR.css('background-image', 'url(images/necesario.PNG)');
        ALM.prop('disabled', false);
        CTM.prop('disabled', true);
        CCO.prop('disabled', true);
        ORD.prop('disabled', true);
        BSERV.prop('disabled', true);
        $('#OrdSAM').val('');
        DIS.focus();
    }
    function LimpiarTemporal() {
        var ips = folioIP();      
        acc = "Limpiartemporal";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc+"&ipsf="+ips,
            success: function (data) {
            }
        });
    }
    function LimpiarTabla() {
        acc = "Limpiartabla";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                $('#TabBody').html(data);
            }
        });
    }
    function CargarListPos() {
        var ips = folioIP(); 
         acc = "CargarListaPos";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc+"&ipsf="+ips, 
            success: function (data) {
                DIS.html(data);
            }
        });
    }
    var texit = '';
    $('#finalizar').click(function () {
        var tab = $("input[name=DelPos]").length;
        if (tab < 1) {
            $(location).attr('href', 'Bienvenido.jsp');
        } else {
            Exit(2, "audio/sapmsg.wav");
            texit = 'FIN';
        }

    });
    $('#cancelar').click(function () {
        var tab = $("input[name=DelPos]").length;
        if (tab < 1) {
            $(location).attr('href', 'Bienvenido.jsp');
        } else {
            Exit(1, "audio/sapmsg.wav");
            texit = 'CAN';
        }
    });
    $('#FinalizarSIDoc').click(function () {
        if (texit === "FIN") {
            $(location).attr('href', 'Bienvenido.jsp');
        } else {
            location.reload();
        }
    });
    $('#FinalizarNODoc').click(function () {
        CerrarMensajeSalirModulo();
    });
    function CargarDatosPosicio(pos) {
        var ips = folioIP();
//        alert("hola "+ips);
        var acc = "CargarDatosPosicion";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&dato=" + pos+"&ipsf="+ips,
            success: function (data) {
                MAT.val(data[0]);
                MAT.css('background-image', 'none');
                CAN.val(data[1]);
                CAN.css('background-image', 'none');
                FCE.val(data[2]);
                FCE.css('background-image', 'none');
                CEN.val(data[3]);
                ALM.val(data[4]);
                TBR.val(data[5]);
                UME.val(data[6]);
                UME.css('background-image', 'none');
                GAR.val(data[7]);
                GAR.css('background-image', 'none');
                CTM.val(data[8]);
                CCO.val(data[9]);
                ORD.val(data[10]);
                var im = data[11];
                var tpo = data[12];
                TIM.val(im);
                TPO.val(tpo);
                if (im == "K") {
                    ALM.prop('disabled', true);
                    CTM.prop('disabled', false);
                    CCO.prop('disabled', false);
                    ORD.prop('disabled', true);
                }
                if (im == "F") {
                    CTM.prop('disabled', false);
                    CCO.prop('disabled', true);
                    ORD.prop('disabled', false);
                }
                if (tpo == "F") {
                    BSERV.prop('disabled', false);
                    MAT.prop('disabled', true);
                } else {
                    MAT.prop('disabled', false);
                }
                CargarTxtPosiion(pos,ips);
            }
        });
    }
    function CargarTxtPosiion(pos,ips) {
//        alert(ips)
        var acc = "CargartTxtPos";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&dato=" + pos+"&ipsf="+ips,
            success: function (data) {
                TXP.val(data[0]);
            }

        });
    }

    function DelPosText(vlor) {
        var ips = folioIP();
        var acc = "DElTEXTPos";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&PO=" + vlor+"&ipsf="+ips,
            success: function (data) {
            }
        });
    }
    
    function ActFol() {
        var ips = folioIP();
        var acc = "FolioAct";
        var dat = "&ipsf="+ips;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc+dat,
            success: function (data) {
//                alert(''+data);
             ShowMsg(29, "images/aceptar.png", "audio/sapmsg.wav", data);
            }

        });
    }
    function textPosic(pos, txtPos) {
        var txtPo = txtPos.replace(/'/g, "´");
        var tamCar = txtPo.length;
        var lim = tamCar / 132;
        var ips = folioIP();
        var l = Math.ceil(lim);
        for (var i = 0; i < l; i++) {
            var d = i * 132;
            no = txtPo.substr(d, 132);
            var acc = "SAVETEX";
            var fila = i + 1;
            var enviar = "&fila=" + fila + "&texps=" + encodeURIComponent(no) + "&PO=" + pos+"&ipsf="+ips;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionSolPed',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + enviar,
                success: function (data) {
                }
            });
        }
    }
    function folioIP() {
    var name = $('#NombreUser').val();    
    var ip = document.getElementById("ipss").value ;
    var n = ip + "" + name;
    return n;
}
    $('#guardar').click(function () {
        var ips = folioIP();
        GuardarDatosSolped(ips);
    });
    
    function GuardarDatosSolped(ips) {
        var tab = $("input[name=DelPos]").length;
        if (tab <= 0) {
            ShowMsg(28, "images/advertencia.PNG", "audio/saperror.wav");
        } else {            
                var folio = Getfolio();
                if (folio == 0) {
                    ShowMsg(25, "images/advertencia.PNG", "audio/saperror.wav");
                } else if (folio == 1) {
                    setTimeout(function () {
                        GuardarDatosSolped();
                    }, 2000);
                } else {
                    GuardarSolped(folio,ips);
        } 
        }
    }
    
    function Getfolio() {
    var folio;
    acc = "RevisarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            folio = data;

        }
    });
    return folio;
}
    
    function GuardarSolped(folio,ips) {
        var acc = "GuardarSolped";
        var dat = "&fsp=" + folio+"&ipsf="+ips;
        $.ajax({
            async: false, 
            type: 'GET',
            dataType: 'json',
            url: 'PeticionSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + dat,
            success: function (data) {
                if (data[0] == 0) {
                    var tc = $('#TextCabecera_SP');
                    if (tc.val().length > 0) {
                        textCabece(tc.val(), ips);
                    }
                    verificaCentPorUsuario();
                    ResetPosicion();
                    LimpiarTabla();
                    OCO.val('');
                    GCO.val('');
                    TCA.val('');
                    CDO.prop('disabled', false);
                    MAT.prop('disabled', false);
                    CargarListPos();
                    ActFol();
                    $("#DobleSection").scroll(function () {
                        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                    });
                    $("#SecCuerpo").scroll(function () {
                        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                    });
                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
//                    ShowMsg(29, "images/aceptar.png", "audio/sapmsg.wav", data[1]);
                } else {
                    ShowMsg(30, "images/advertencia.PNG", "audio/saperror.wav");

                }
            }

        });
    }

    function textCabece(txtCa, fol) {
        var txtO = txtCa.replace(/'/g, "´");
        var tam = txtO.length;
        var lim = tam / 132;
        var l = Math.ceil(lim);
        for (var i = 0; i < l; i++) {
            var d = i * 132;
            no = txtO.substr(d, 132);
            var acc = "SAVETEXTCAB";
            var fila = i + 1;
            var enviar = "&fila=" + fila + "&texps=" + encodeURIComponent(no) + "&ipsf=" + fol;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionSolPed',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + enviar,
                success: function (data) {
                }

            });
        }
    }
    BSERV.click(function () {
        if (CDO.val().length == 0 || CDO.val() == null) {
            CDO.focus();
            ShowMsg(38, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            if (GCO.val().length > 0) {
                if ($('#TipoImputacion').val( ) == null || $('#TipoImputacion').val() == '') {
                    ShowMsg(31, "images/advertencia.PNG", "audio/saperror.wav");
                }
                var t1 = TIM.val().toUpperCase();
                if (t1 == 'F') {
                    DatosObligatoriosImpFF();
                }
                if (t1 == 'K') {

                    DatosObligatoriosImpFK();
                }
            } else {
                GCO.focus();
                ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
            }
        }
    });

    function abrirSerVal() {
        DIS.prop('disabled', true);
        $('#guardar').prop('disabled', true);
        OpenServices();
    }
    function OpenServices() {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ancho = 500;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        var ventana = $('#WindowService');
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        var theHandle = document.getElementById("handleSer");
        var theRoot = document.getElementById("WindowService");
        document.getElementById("sevad").focus();
        Drag.init(theHandle, theRoot);
        borramsg();
        CargarDatosServices();
    }
    $('#CloseServi').click(function () {
        CerrarServices();
    });
    $('#RetSerma').click(function () {
        $('#BuscarParamServicio').css('display', 'block');
        $('#ConsultaTablaServicios').css('display', 'none');
    });
    function CerrarServices() {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#WindowService').css('display', 'none');
        DIS.prop('disabled', false);
        $('#guardar').prop('disabled', false);
    }
    function CargarDatosServices() {
        $('#ctaMayorSer').val(CTM.val());
        $('#ImputacionSer').val(TIM.val());
        $('#MaterialSer').val(MAT.val());
        $('#CantidadSer').val(CAN.val());
        $('#FentregaSer').val(FCE.val());
        $('#CentroSer').val(CEN.val().toUpperCase());
        $('#AlmacenSer').val(ALM.val().toUpperCase());
        $('#TipoPosicionSer').val(TPO.val());
        $('#CentroCostoSer').val(CCO.val());
        $('#TxtbrveSer').val(TBR.val());
        $('#UnidadMediaSer').val(UME.val().toUpperCase());
        $('#GArticuloSer').val(GAR.val().toUpperCase());
        $('#SolicitanteSer').val(SOL.val());
        $('#OrdenSer').val(ORD.val().toUpperCase());
        cargarserviciosposi();
    }
    function cargarserviciosposi() {
        var ips = folioIP();
        var pos = '';
        if (DIS.val() == null || DIS.val() == '') {
            pos = '';
        } else {
            pos = DIS.val();
        }
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCargarServiciosPosicion',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "posicion=" + pos+"&ipsf="+ips,
            success: function (data) {
                $('#glob').html(data);
            }
        });
    }
    $('#BorrarFilaServicios').click(function () {
        VerificarServiciosEliminar();
    });
    $('#AgregarFilaServicios').click(function () {
        AgregarFilaTablaServicios();
    });
    $('#BusNumServicio').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaServicios();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesServicio').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaServicios();
        }
    });
    $('#okdSer').click(function () {
        ConsultaServicios();
    });
    function ConsultaServicios() {
        var acc = "ConsultarServicios";
        var datos = "&Servicio=" + $('#BusNumServicio').val() + "&DServicio=" + $('#BusDesServicio').val().trim() + "&Ctd=" + $('#numAcMax13').val();
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(6, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#cargarDatosServicios').html(data);
                    $('#BuscarParamServicio').css('display', 'none');
                    $('#ConsultaTablaServicios').css('display', 'block');
                    document.getElementById('table-scrollServicios').onscroll = function () {
                        document.getElementById('fixedYServicios').style.top = document.getElementById('table-scrollServicios').scrollTop + 'px';
                    };
                    borramsg();
                }
            }
        });
    }
    $('#CloseMCSer1').click(function () {
        ocultarVentana('VentanaModalServicios', 'BuscarParamServicio', 'ConsultaTablaServicios');
    });
    $('#CloseMCSer2').click(function () {
        ocultarVentana('VentanaModalServicios', 'BuscarParamServicio', 'ConsultaTablaServicios');
    });
    $('#sevad').click(function () {
        VerificatDataser();
    });
    function VerificatDataser() {
        var ser = document.getElementsByName("Sevic");
        var can = document.getElementsByName("Cant");
        var unm = document.getElementsByName("unim");
        var prp = document.getElementsByName("precpor");
        var des = document.getElementsByName("des");
        for (a = 0; a < ser.length; a++) {
            if (ser[0].value == "") {
                ShowMsg(33, "images/aceptar.png", "audio/sapmsg.wav");
                ser[0].focus();
                return;
            }
            if (ser[a].value != "") {
                if (can[a].value == "" || parseInt(can[a].value) == 0) {
                    ShowMsg(34, "images/aceptar.png", "audio/sapmsg.wav");
                    can[a].focus();
                    return;
                }
            }
        }
        GuardarServicio();
    }
    function Posiservi(n) {
        if (n < 10) {
            return "000" + n + "0";
        }
        if (n >= 10 && n < 100) {
            return "00" + n + "0";
        }
        if (n >= 100 && n < 1000) {
            return "0" + n + "0";
        }
        return n;
    }
    function GuardarServicio() {
        var vl = $('#Distribucion_SP').val();
        if (vl == null || vl == '') {
        } else {
            deletedataservicio(vl);
        }
        ///Columnas
        var se = document.getElementsByName("Sevic");
        var ca = document.getElementsByName("Cant");
        var un = document.getElementsByName("unim");
        var de = document.getElementsByName("des");
        var ch = document.getElementsByName("DelPos");
        if (ch.length == null || ch.length == 'undefined') {
            ch.length = 0;
        }
        /// Datos
        var ga = document.getElementById("GArticuloSer").value;
        var cm = document.getElementById("ctaMayorSer").value;
        var cc = document.getElementById("CentroCostoSer").value;
        var or = document.getElementById("OrdenSer").value;
        var cmsele = document.getElementById("ctaMayor").value
        var acci = "GuardaServicio";
        var posN = document.getElementById("Distribucion_SP").value;
        var accIT = 'UPD';
        if (posN == null || posN == "") {
            po = parseInt(ch.length) + 1;
            posN = Posiservi(po);
            accIT = 'ADD';
        }
        for (l = 0; l < se.length; l++) {
            if (se[l].value != "") {
                var ext = "&v1=" + se[l].value + "&v2=" + ca[l].value +
                        "&v3=" + un[l].value + "&v4=0.00" +
                        "&v5=" + encodeURIComponent(de[l].value) + "&v6=" + ga +
                        "&v7=" + cm + "&v8=" + cc + "&v9=" + or + "&v10=" + Posiservi(parseInt(l) + 1);
                GuardarServiciosPosicio(acci, posN, ext);
            }
        }
        AgregarPosicionTemp(accIT);
        CerrarServices();
        borramsg();
    }
    function GuardarServiciosPosicio(action, pos, extras)
    {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPedV',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + action + "&PosN=" + pos + extras,
            success: function (data) {
            }
        });
    }
    function deletedataservicio(vlor) {
        var acc = "DElTEXTSERV";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPedV',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Pos=" + vlor,
            success: function (data) {
            }
        });
    }
    $('#btnEliPos').click(function () {
        DelPOS();
    });
    function DelPOS() {
        var n = "";
        $("input[name=DelPos]").each(function (i, v) {
            if (this.checked)
            {
                n = $('#posValoSo' + i).val();
            }
        });
        if (n == "") {
            ShowMsg(37, "images/adver.PNG", "audio/saperror.wav");
        } else {
            var acc = "DeletePos";
             var ips = folioIP();
            var enviar = "&Accion=" + acc + "&PO=" + n+"&ipsf="+ips;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionSolPed',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    $("#TabBody").html(data);
                    ReasicnarPos(0);
                }

            });

        }
    }

    function ReasicnarPos(i) {
        var po = $("input[name=DelPos]");
        var ips = folioIP();
        var acc = "Reasic";
        if (i < po.length) {
            var enviar = "&Accion=" + acc + "&NewPos=" + i+"&ipsf="+ips ;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionSolPed',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    var res = data;
                    if (res == 1) {
                        Sigpos(i);
                    }
                }

            });
        } else {
            cargarNuevoPosionFol();
        }

    }
    function  Sigpos(i) {
        ReasicnarPos(i + 1);
    }
    function cargarNuevoPosionFol() {
        var ips = folioIP();
        var acc = "CargarNuevaPosi";
        var enviar = "&Accion=" + acc+"&ipsf="+ips;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var res = data;
                $("#TabBody").html(res);
                $("#DobleSection").scroll(function () {
                    $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                });
                $("#SecCuerpo").scroll(function () {
                    $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                });
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                CargarListPos();
                var po = $("input[name=DelPos]").length;
                if (po <= 0) {
                    CDO.prop('disabled', false);
                    verificaCentPorUsuario();
                }
            }

        });
    }
    VerificarFolioExcedido();
    
    function obtenerip(){
                  window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
           var pc = new RTCPeerConnection({iceServers:[]}), noop = function(){};      
           pc.createDataChannel("");    
           pc.createOffer(pc.setLocalDescription.bind(pc), noop);    
           pc.onicecandidate = function(ice){  
                if(!ice || !ice.candidate || !ice.candidate.candidate)  return;
                var myIP = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/.exec(ice.candidate.candidate)[1];
                pc.onicecandidate = noop;
                $("#ipss").val(myIP);
//                 alert(myIP);
           };        

}
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
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function CerrarMsg() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Windowmsg').css('display', 'none');
}
function VerificarFolioExcedido() {
    var acc = "VerificarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 1) {
                $('input').css('background-image', 'none');
                $('input').prop('disabled', true);
                $('button').prop('disabled', true);
                $('select').prop('disabled', true);
                $('textarea').prop('disabled', true);
                $('#CloMsg').prop('disabled', false);
                $('#finalizar').prop('disabled', false);
                ShowMsgWindow(3, "images/infoicono.PNG", "audio/sapsnd05.wav");
            }
        }
    });
}

function mostrarVentanaModal(id, handle, tipo)
{
    switch (tipo) {
        case "BusGCompras":
            $('#numAcMax2').val('500');
            $('#BusDenGCompras').val('');
            $('#BusGCompras').val('');
            break;
        case "BusMaterial":
            $('#BusMaterial').val('');
            $('#BusTextoMaterial').val('');
            $('#BusTipoMat').val('');
            $('#numAcMax5').val('500');
            break;
        case "BusCentro":
            $('#BusCentro').val('');
            $('#BusDesCentro').val('');
            $('#numAcMax6').val('500');
            break;
        case "BusAlmacen":
            $('#BusAlmacen').val('');
            $('#BusDenAlm').val('');
            $('#numAcMax7').val('500');
            break;
        case "BusUM":
            $('#BusUM').val('');
            $('#BusTextoUM').val('');
            $('#numAcMax8').val('500');
            break;
        case "BusGArtiulos":
            $('#BusGArtiulos').val('');
            $('#BusDenGArt').val('');
            $('#BusDesGArt').val('');
            $('#numAcMax9').val('500');
            break;
        case "BusNCuenta":
            $('#BusNCuenta').val('');
            $('#BusDesNCuenta').val('');
            $('#numAcMax10').val('500');
            break;
        case "BusCCosto":
            $('#BusCCosto').val('');
            $('#BusDemCCosto').val('');
            $('#BusSoc').val('');
            $('#numAcMax11').val('500');
            break;
        case "BusClaseOrd":
            $('#BusClaseOrd').val('');
            $('#BusNumOrd').val('');
            $('#BustxtOrd').val('');
            $('#numAcMax12').val('500');
            break;
        case "BusNumServicio":
            $('#BusNumServicio').val('');
            $('#numAcMax13').val('500');
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
    $('#' + tipo).focus();
}
function ocultarVentana(id, bp, ct, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + bp).css('display', 'block');
    $('#' + ct).css('display', 'none');
    $('#' + obj).focus();
}
function OpenCalendario() {
    $("#FecEntrega").focus();
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
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
    $('#FecEntrega').focus();
}
function SelectData(dato, idv, bp, ct, obj) {
    $('#' + obj).val(dato);
    ocultarVentana(idv, bp, ct, obj);
}
function SelectMaterial(mat, des, um, gpoArt, cen, cuma) {
    $('#Material').val(mat);
    $('#Txtbrve').val(des);
    $('#Txtbrve').css("background-image", "none");
    $('#unidamedida').val(um);
    $('#unidamedida').css("background-image", "none");
    $('#GpoArticulo').val(gpoArt);
    $('#GpoArticulo').css("background-image", "none");
    $('#Centro').val(cen);
    $('#Centro').css("background-image", "none");
    ocultarVentana('VentanaModalMateriales', 'BuscarParamMateriales_SP', 'ConsultaTablaMaterial', 'Material');
}
function SelectOrden(SAP, SAM) {
    if (SAP.length > 0) {
        $('#Orde').val(SAP);
        $('#OrdSAM').val(SAM);
    } else {
        $('#Orde').val(SAM);
        $('#OrdSAM').val('');
    }
    ocultarVentana('VentanaModalOrden', 'BuscarParamOrden', 'ConsultaTablaOrden', 'Orde');
}
function validarDato(id, acc, param, msge) {
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + param,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(msge, "images/advertencia.PNG", "audio/saperror.wav");
                    campo.val('');
                    campo.focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function validarMateri() {
    var mate = $('#Material');
    var cent = $('#Centro');
    var acc = "ValidarMate";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionCrearSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Material=" + mate.val() + "&Centro=" + cent.val() + "&tipoSolp=" + $('#ClaseDoc').val(),
        success: function (data) {
            if (data == 1) {
                ShowMsg(8, "images/advertencia.PNG", "audio/saperorwav", this.value);
                mate.val('');
                mate.focus();
            } else {
                $('#Material').val(data[0]);
                $('#Material').css("background-image", "none");
                $('#Centro').val(data[1]);
                $('#Centro').css("background-image", "none");
                $('#Txtbrve').val(data[2]);
                $('#Txtbrve').css("background-image", "none");
                $('#unidamedida').val(data[3]);
                $('#unidamedida').css("background-image", "none");
                $('#GpoArticulo').val(data[4]);
                $('#GpoArticulo').css("background-image", "none");
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
function GetCantend(C, U) {
    var findata = "";
    var umc = parseInt(CheckUnidaMed(U));
    if (umc == 0) {
        findata = Math.floor(C);
        findata += ".000";
    }
    if (umc == 3) {
        findata = cantconvert(C.toString());
    }
    return findata;
}
function CheckUnidaMed(valor)
{
    var resp = "";
    var acc = "umed";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&UM=" + valor,
        success: function (data) {
            resp = data;
        }
    });
    return resp;
}
function cantconvert(valor) {
    if (valor.indexOf(".") != -1) {
        va = valor.split(".");
        v0 = va[0];
        v1 = va[1];
        if (v1.length == 1) {
            var valorfinal = v0 + "." + v1 + "00";
            return valorfinal;
        } else if (v1.length == 2) {
            var valorfinal = v0 + "." + v1 + "0";
            return valorfinal;
        } else {
            return valor;
        }

    } else {
        valor = valor + ".000";
        return valor
    }
    return val;
}
function ValidarCombinacionCCCM(c1, c2) {
    var res = false;
    var acc = "ValidarCentroCuenta";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionCrearSolPed',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&NCuenta=" + c1 + "&CCosto=" + c2,
        success: function (data) {
            if (data == 1) {
                res = true;
            }
        }
    });
    return res;
}
function checkFecha(valor) {
    if (valor.indexOf(".") != -1) {
        var f = valor.split(".");
        var d = f[0];
        var m = f[1];
        var y = f[2];
        var fe = y + "-" + m + "-" + d;
        return fe;
    }
    return valor;
}
function CerrarMensajeSalirModulo() {
    var ventana = $('#MensajeSalirModulo');
    ventana.css('display', 'none');
}
function VerMCServicios(nu) {
    var btmco = document.getElementsByName("butoservice");
    for (i = 0; i < btmco.length; i++) {
        btmco[i].style.display = "none";
    }
    document.getElementById("btnservi" + nu).style.display = "inline";
    $('#Ser' + nu).keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarserId(nu);
        }
    });
    $('#Ser' + nu).blur(function () {
        validarserId(nu);
    });
}
function validarserId(i) {
    var Ser = $('#Ser' + i).val();
    var acc = "ValidarServiciopos";
    if (Ser.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionCrearSolPed',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Servicio=" + Ser,
            success: function (data) {
                if (data == 2) {
                    ShowMsg(32, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#Ser' + i).focus();
                    $('#Ser' + i).val("");
                    $('#SerCan' + i).val("");
                    $('#SerUM' + i).val('');
                    $('#SerDes' + i).val('');
                } else {
                    var n = data;
                    $('#SerDes' + i).val(n[1]);
                    $('#SerUM' + i).val(n[2]);
                    $('#SerUM' + i).prop('readOnly', true);
                }
            }
        });
    } else {
        $('#Ser' + i).val("");
        $('#SerCan' + i).val("");
        $('#SerUM' + i).val('');
        $('#SerDes' + i).val('');
    }
}
function QuitarMC(i) {
    $('#btnservi' + i).css('display', 'none');
    $('#SerCan' + i).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        patrn = /[0-9]/;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
    $('#SerPrec' + i).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        patrn = /[0-9.]/g;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
    $('#SercCanP' + i).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        patrn = /[0-9]/;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
}
function AceptOnlyNum(e) {
    var tec = (document).all ? e.keyCode : e.which;
    patrn = /[0-9]/;
    t = String.fromCharCode(tec);
    return patrn.test(t);
}

var cont = 9;
function AgregarFilaTablaServicios() {
    var i = cont + 1;
    var newfiladata = "<tr>"
            + "<td><input type=\"checkbox\" class=\"TDSER1\" name=\"ServicesDel\"/></td>"
            + "<td><input type=\"text\" class=\"TDSER2\" readOnly style=\"background:none;\" name=\"tsPosSol\"/></td>"
            + "<td><input type=\"text\" class=\"TDSER3\" readOnly style=\"background:none;\" name=\"POS\"></td>"
            + "<td><div style=\"width:110px;\"><input type=\"text\" class=\"TDSER4\" maxlength=\"18\" id=\"Ser" + i + "\" name=\"Sevic\" onfocus=\"VerMCServicios('" + i + "')\"/><button  style=\"display : none;\" onclick=\"AbrirServicios('" + i + "')\" id=\"btnservi" + i + "\" class=\"BtnMatchIcon\" name=\"butoservice\"s></button></div></td>"
            + "<td><input type=\"text\" class=\"TDSER5\" maxlength=\"7\" id=\"SerCan" + i + "\"  name=\"Cant\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><input type=\"text\" class=\"TDSER6\" maxlength=\"3\" id=\"SerUM" + i + "\" style=\"text-transform: uppercase;\" name=\"unim\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><input type=\"text\" class=\"TDSER8\" maxlength=\"40\" id=\"SerDes" + i + "\" name=\"des\" disabled onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "</tr>";
    $('#tabSolpedSer').append(newfiladata);
    cont++;
}

function VerificarServiciosEliminar() {
    var table = document.getElementById("tabSolpedSer");
    var chk = document.getElementsByName("ServicesDel");
    var tam = chk.length;
    var i = tam;
    while (i >= 0) {
        if (i == 0) {
            break;
        } else {
            var o = parseInt(i) - 1;
            if (chk[o].checked)
            {
                table.deleteRow(i);
                i--;
            } else {
                i--;
            }

        }
    }
}
function AbrirServicios(n) {
    SaveSessio(n);
    mostrarVentanaModal('VentanaModalServicios', 'handle13', 'BusNumServicio');
}
function SaveSessio(n) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
        }
    };
    xmlhttp.open("GET", "peticionCargarServiciosPosicion?ValorFila=" + n, true);
    xmlhttp.send();
}
function SelectServicio(Ser, Des, Um, v) {
    $('#Ser' + v).val(Ser);
    $('#SerUM' + v).val(Um);
    $('#SerUM' + v).prop('readonly', true);
    $('#SerDes' + v).val(Des);
    ocultarVentana('VentanaModalServicios', 'BuscarParamServicio', 'ConsultaTablaServicios', 'Ser' + v);
}
function checkDec(num, tam) {
    var limit;
    var MSGF;
    if (tam == 3) {
        limit = 9999999.999;
        MSGF = 3;
    } else {
        limit = 99999999.99;
        MSGF = 4;
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
                    borramsg();
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    borramsg();
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                borramsg();
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
            ShowMsg(MSGF, "images/advertencia.PNG", "audio/saperror.wav");
            return "";
        }
    } else {
        borramsg();
        return "";
    }
}

