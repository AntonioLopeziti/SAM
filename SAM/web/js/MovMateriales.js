//prueba
$(document).ready(function () {
    GetIp();
    LimpiarPpal("LimpiarPpal");
    $('#BorrarFilas301').click(function () {
        EliminarFilas301();
    });
    $('#AgregarFilas301').click(function () {
        AgregarFilasTabla301();
    });
    $('#CerrarMCCenDesNuevo').click(function () {
        var clam = $('#bxClase').val();
        ocultarVentanaNuevo('VentanaModalCentroDesNuevo', '', '', 'tdCentr', clam);
    });
    $('#CerrarMCAlmDesNuevo').click(function () {
        var clam = $('#bxClase').val();
        ocultarVentanaNuevo('VentanaModalAlmacenDesNuevo', '', '', 'tdAlmac', clam);
    });
    $('#CerrarMCLoteStockE').click(function () {
        var clam = $('#bxClase').val();
        ocultarVentanaNuevo('VentanaModalLoteStockE', '', '', 'tdLotes', clam);
    });
    $('#btnPnMaterialNuevo').click(function () {
        $('#BuscarParaMaterialNuevo').css('display', 'block');
        $('#ConsultaTablaMaterialNuevo').css('display', 'none');
    });
    $('#busMatNuevo').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterialesNBuevo();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDesMatNuevo').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterialesNBuevo();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAciertosNuevo').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterialesNBuevo();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okMaterialNuevo').click(function () {
        ConsultaMaterialesNBuevo();
    });
    $('#CerrarMCMatNuevo').click(function () {
        var clam = $('#bxClase').val();
        ocultarVentanaNuevo('VentanaModalMaterialNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', 'tdMater', clam);
    });
    $('#CerrarMCMatNuevo2').click(function () {
        var clam = $('#bxClase').val();
        ocultarVentanaNuevo('VentanaModalMaterialNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', 'tdMater', clam);
    });
    $('#aceptar').click(function () {

    });
    $("#DobleSection").scroll(function () {
        $("#SecCuerpoCld").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpoCld").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpoCld").scrollTop());
    });


    $("#DobleSectionN").scroll(function () {
        $("#SecCuerpoCld2").scrollTop($("#DobleSectionN").scrollTop());
    });
    $("#SecCuerpoCld2").scroll(function () {
        $("#DobleSectionN").scrollTop($("#SecCuerpoCld2").scrollTop());
    });

    $('#btnCancelar').click(function () {
        MovimientosMO();
        ocultarVentana('VentanaModalMsgAddFile', '');
    });
    $('#btnMatchhClInf').hide();
    $('.bxsmall').css('background-image', 'url(images/necesario.PNG)');
    $('.bxmiddles').css('background-image', 'url(images/necesario.PNG)');
    $('.bxlong').css('background-image', 'url(images/necesario.PNG)');
    $('.bxlongs').css('background-image', 'url(images/necesario.PNG)');
    $('#bxPedido').css('background-image', 'url(images/necesario.PNG)');
    $('#bxMaterial201').css('background-image', 'url(images/necesario.PNG)');
    $('#bxcnt201').css('background-image', 'url(images/necesario.PNG)');
    $('#bxUM201').css('background-image', 'url(images/necesario.PNG)');
    $('#bxccs201').css('background-image', 'url(images/necesario.PNG)');
    $('#bxDocMat').css('background-image', 'url(images/necesario.PNG)');
    $('#bxPosDoc').css('background-image', 'url(images/necesario.PNG)');
    $('#bxNota').css('background-image', 'none');

    $('#btnCentro').hide();
    $('#btnAlmacen').hide();
    $('#btnClase').hide();
    $('#btnPedido').hide();
    $('#btnMat201').hide();
    $('#btnLot201').hide();
    $('#btnCcs201').hide();
    $('#btnPov201').hide();
    $('#btnDocMat').hide();
    $('#btnfechaD').hide();
    $('#bxFecha').focus(function () {
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnPedido').hide();
        $('#btnMat201').hide();
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
        $('#btnDocMat').hide();
        $('#btnfechaD').show();
        $('#btnMacthreserv').hide();
    });
    $('#btnfechaD').click(function () {
        $("#bxFecha").focus();
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
        var theHandle = document.getElementById("handlecalendar");
        var theRoot = document.getElementById("Calenndar");
        Drag.init(theHandle, theRoot);
        $('#datapicker').datepicker().show();
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#bxFecha').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            e.preventDefault();
        }
        patron = /^\d{4}\-\d{2}\\d{2}$/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#bxPosc').focus(function () {
        $('#btnPedido').hide();
    });
    $('#bxPosc').focus(function () {
        $('#btnPedido').hide();
    });

    $('#bxPedido').focus(function () {
        $('#bxPedido').css('background-image', 'none');
        $('#btnPedido').show();
    });
    $('#bxPedido').blur(function () {
        if ($('#bxPedido').val().length > 0) {
            $('#bxPedido').css('background-image', 'none');
        } else {
            $('#bxPedido').css('background-image', 'url(images/necesario.PNG)');
        }
    });


    $('#bxPosDoc').focus(function () {
        $('#bxPosDoc').css('background-image', 'none');
        $('#btnDocMat').hide();
    });
    $('#bxPosDoc').blur(function () {
        if ($('#bxPosDoc').val().length > 0) {
            $('#bxPosDoc').css('background-image', 'none');
        } else {
            $('#bxPosDoc').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxDocMat').focus(function () {
        $('#bxDocMat').css('background-image', 'none');
        $('#btnDocMat').show();
    });
    $('#bxDocMat').blur(function () {
        if ($('#bxDocMat').val().length > 0) {
            $('#bxDocMat').css('background-image', 'none');
        } else {
            $('#bxDocMat').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#Cer1101').click(function () {
        ocultarVentana('VentanaModal101', 'btnAdd', 'm');
        LimpiarPpal("LimpiarPpal");
    });

    $('#bxpov201').focus(function () {
        $('#btnMat201').hide();
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').show();
    });

    $('#bxccs201').focus(function () {
        $('#bxccs201').css('background-image', 'none');
        $('#btnMat201').hide();
        $('#btnLot201').hide();
        $('#btnCcs201').show();
        $('#btnPov201').hide();
    });
    $('#bxccs201').blur(function () {
        if ($('#bxccs201').val().length > 0) {
            $('#bxccs201').css('background-image', 'none');
        } else {
            $('#bxccs201').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxLote201').blur(function () {
        if ($('#bxLote201').val().length > 0) {
            $('#bxLote201').css('background-image', 'none');
        } else {
            $('#bxLote201').css('background-image', 'url(images/necesario.PNG)');
        }
    });

    $('#bxLote201').focus(function () {
        $('#bxLote201').css('background-image', 'none');
        $('#btnMat201').hide();
        $('#btnLot201').show();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
    });
    $('#bxstk201').focus(function () {
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
        $('#btnMat201').hide();
    });
    $('#bxUM201').focus(function () {
        $('#bxUM201').css('background-image', 'none');
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
        $('#btnMat201').hide();
    });
    $('#bxUM201').blur(function () {
        if ($('#bxUM201').val().length > 0) {
            $('#bxUM201').css('background-image', 'none');
        } else {
            $('#bxUM201').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxcnt201').focus(function () {
        $('#bxcnt201').css('background-image', 'none');
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
        $('#btnMat201').hide();
    });
    $('#bxcnt201').blur(function () {
        if ($('#bxcnt201').val().length > 0) {
            $('#bxcnt201').css('background-image', 'none');
        } else {
            $('#bxcnt201').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxMaterial201').focus(function () {
        $('#bxMaterial201').css('background-image', 'none');
        $('#btnMat201').show();
        $('#btnLot201').hide();
        $('#btnCcs201').hide();
        $('#btnPov201').hide();
    });
    $('#bxMaterial201').blur(function () {
        if ($('#bxMaterial201').val().length > 0) {
            obtenerMaterialDatos();
        }
    });

    $('#bxCentro').focus(function () {
        $('#bxCentro').css('background-image', 'none');
        $('#btnCentro').show();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
    $('#bxCentro').blur(function () {
        if ($('#bxCentro').val().length > 0) {
            $('#bxCentro').css('background-image', 'none');
        } else {
            $('#bxCentro').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxCentro').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });


    $('#bxAlmacen').focus(function () {
        $('#bxAlmacen').css('background-image', 'none');
        $('#btnCentro').hide();
        $('#btnAlmacen').show();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
    $('#bxAlmacen').blur(function () {
        if ($('#bxAlmacen').val().length > 0) {
            $('#bxAlmacen').css('background-image', 'none');
        } else {
            $('#bxAlmacen').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#bxAlmacen').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });

    $('#bxClase').focus(function () {
        $('#bxClase').css('background-image', 'none');
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').show();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
    $('#bxClase').blur(function () {
        if ($('#bxClase').val().length > 0) {
            $('#bxClase').css('background-image', 'none');
            var r = $('#bxClase').val();
            switch (r)
            {
                case '101':
                case '102':
                    if ($('#bxTexto').val().length > 0)
                        $('#bxTexto').css('background-image', 'none');
                    else
                        $('#bxTexto').css('background-image', 'url(images/necesario.PNG)');

                    if ($('#bxCarta').val().length > 0)
                        $('#bxCarta').css('background-image', 'none');
                    else
                        $('#bxCarta').css('background-image', 'url(images/necesario.PNG)');
                    break;
                case '201':
                case '202':
                case '261':
                case '262':
                case '301':
                case '303':
                case '305':
                case '311':
                case '312':
                case '313':
                case '315':
                    if ($('#bxTexto').val().length > 0)
                        $('#bxTexto').css('background-image', 'none');
                    else
                        $('#bxTexto').css('background-image', 'url(images/necesario.PNG)');

                    $('#bxCarta').css('background-image', 'none');
                    break;
            }
        } else {
            $('#bxClase').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#bxTexto').focus(function () {
        $('#bxTexto').css('background-image', 'none');
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
    $('#bxTexto').blur(function () {
        if ($('#bxTexto').val().length > 0) {
            $('#bxTexto').css('background-image', 'none');
        } else {
            $('#bxTexto').css('background-image', 'url(images/necesario.PNG)');
        }
    });

    $('#bxNota').focus(function () {
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
//    $('#bxNota').blur(function () {
//        if ($('#bxNota').val().length > 0) {
//            $('#bxNota').css('background-image', 'none');
//        } else {
//            $('#bxNota').css('background-image', 'url(images/necesario.PNG)');
//        }
//    });
    $('#bxCarta').focus(function () {
        $('#bxCarta').css('background-image', 'none');
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        $('#btnfechaD').hide();
    });
    $('#bxCarta').blur(function () {
        if ($('#bxCarta').val().length > 0) {
            $('#bxCarta').css('background-image', 'none');
        } else {
            if ($('#bxClase').val() === "101" || $('#bxClase').val() === "102" || $('#bxClase').val() === "")
                $('#bxCarta').css('background-image', 'url(images/necesario.PNG)');
            else
                $('#bxCarta').css('background-image', 'none');
        }
    });

    $('#btnGrabarR').click(function () {
        validarTabRes();
    });
    $('#btnCentro').click(function () {
        mostrarVentana('VentanaModalCentro');
        var theHandle = document.getElementById('handle');
        var theRoot = document.getElementById('VentanaModalCentro');
        Drag.init(theHandle, theRoot);

    });
    $('#btnAlmacen').click(function () {
        mostrarVentana('VentanaModalAlmacen');
        var theHandle = document.getElementById('handle2');
        var theRoot = document.getElementById('VentanaModalAlmacen');
        Drag.init(theHandle, theRoot);

    });
    $('#btnClase').click(function () {
        mostrarVentana('VentanaModalClase');
        var theHandle = document.getElementById('handle3');
        var theRoot = document.getElementById('VentanaModalClase');
        Drag.init(theHandle, theRoot);

    });
    $('#btnLot201').click(function () {
        LoteGet();
//        mostrarVentana('VentanaModalLote');
//        peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '');
//        var theHandle = document.getElementById('handle6');
//        var theRoot = document.getElementById('VentanaModalLote');
//        Drag.init(theHandle, theRoot);

    });
    $('#btnDocMat').click(function () {
        mostrarVentana('VentanaModalDoc');
        peticiones('PeticionMovMateriales', 'cargarDatosDoc', 'VentanaModalDoc', 'Doc', '');
        var theHandle = document.getElementById('handle17');
        var theRoot = document.getElementById('VentanaModalDoc');
        Drag.init(theHandle, theRoot);

    });
    $('#cl303').click(function ()
    {
        ocultarVentana('VentanaModal303', 'btnAdd', 'm');
    });
    $('#cl305').click(function ()
    {
        ocultarVentana('VentanaModal305', 'btnAdd', 'm');
    });
    $('#btnAdd').click(function () {
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        clickParaGenteDesesperada();
        TitulosVentanas();
        AgregarPosicion();
        document.getElementById('SecRG').innerHTML = "";
        var clase = document.getElementById('bxClase').value;
        switch (clase)
        {
            case "101":
            case "102":
                var theHandle = document.getElementById('handle101');
                var theRoot = document.getElementById('VentanaModal101');
                Drag.init(theHandle, theRoot);
                break;
            case "201":
            case "202":
                var theHandle = document.getElementById('handle201');
                var theRoot = document.getElementById('VentanaModal201');
                Drag.init(theHandle, theRoot);
                break;
            case "261":
            case "262":
                if (document.getElementsByName('reserv1').length < 1) {
                    Limpia260();
                }
                var theHandle = document.getElementById('handle11');
                var theRoot = document.getElementById('VentanaModal261');
                Drag.init(theHandle, theRoot);
                break;
            case "305":
                var theHandle = document.getElementById('handle15');
                var theRoot = document.getElementById('VentanaModal305');
                Drag.init(theHandle, theRoot);
                break;
            case "303":
                var theHandle = document.getElementById('handle13');
                var theRoot = document.getElementById('VentanaModal303');
                Drag.init(theHandle, theRoot);
                break;
//            case "311":
            case "312":
                if (document.getElementsByName('reserv1').length < 1) {
                    Limpia310();
                }
                var theHandle = document.getElementById('handle16');
                var theRoot = document.getElementById('VentanaModal311');
                Drag.init(theHandle, theRoot);
                break;
            case "301":
            case "313":
            case "315":
            case "311":
                var theHandle = document.getElementById('hanlde301');
                var theRoot = document.getElementById('VentanaModal301');
                Drag.init(theHandle, theRoot);
                if (clase === "315") {
                    $("#btnBarCode").show();
                } else if (clase === "301") {
                    $("#btnBarCode").show();
                } else if (clase === "313") {
                    $("#btnBarCode").show();
                } else if (clase === "311") {
                    $("#btnBarCode").show();
                } else {
                    $("#btnBarCode").hide();
                }
                break;
        }

    });

    $('#btnPnProv').click(function () {
        $('#BuscarParamProv').show();
        $('#ConsultaTablaProv').hide();
    });
    $('#okProv').click(function () {
        $('#BuscarParamProv').hide();
        $('#ConsultaTablaProv').show();
        peticiones('PeticionMovMateriales', 'cargarDatosProv', 'VentanaModalProv', 'Prov');
    });
    $('#btnPov201').click(function () {
        $('#BuscarParamProv').show();
        $('#ConsultaTablaProv').hide();
        LimpiarPantalla('VentanaModalProv');
        mostrarVentana('VentanaModalProv');
        document.getElementById('bxnom').focus();
        var theHandle = document.getElementById('handle10');
        var theRoot = document.getElementById('VentanaModalProv');
        Drag.init(theHandle, theRoot);

    });


    $('#btnPnCC').click(function () {
        $('#BuscarParamCC').show();
        $('#ConsultaTablaCC').hide();
    });
    $('#okCC').click(function () {
        CeCosGet();
//        $('#BuscarParamCC').hide();
//        $('#ConsultaTablaCC').show();
//        peticiones('PeticionMovMateriales', 'cargarDatosCC', 'VentanaModalCC', 'CC');
    });
    $('#btnCcs201').click(function () {
        $('#BuscarParamCC').show();
        $('#ConsultaTablaCC').hide();
        $('#bxcc').val("");
        $('#bxtxc').val("");
        $('#bxsc').val("");
        $('#bxtxc2').val("");
        $('#numAcMaxCeco').val("500");
        var ven = document.getElementById("VentanaModalCC");
        abrirVentana(ven);
        document.getElementById('bxtxtm').focus();
        var theHandle = document.getElementById('handlecc');
        var theRoot = document.getElementById('VentanaModalCC');
        Drag.init(theHandle, theRoot);
        $('#bxcc').focus();
//        $('#BuscarParamCC').show();
//        $('#ConsultaTablaCC').hide();
//        LimpiarPantalla('VentanaModalCC');
//        mostrarVentana('VentanaModalCC');
//        document.getElementById('bxcc').focus();
//        var theHandle = document.getElementById('handle9');
//        var theRoot = document.getElementById('VentanaModalCC');
//        Drag.init(theHandle, theRoot);

    });


    $('#btnMat201').click(function () {
        $('#BuscarParamMaterial').show();
        $('#ConsultaTablaMaterial').hide();
        $('#bxtxtm').val("");
        $('#bxclim').val($('#bxclim2').val());
        $('#bxmatm').val("");
        $('#bxcnmm').val("500");
        var ven = document.getElementById("VentanaModalMaterial");
        abrirVentana(ven);
        document.getElementById('bxtxtm').focus();
        var theHandle = document.getElementById('handle8');
        var theRoot = document.getElementById('VentanaModalMaterial');
        Drag.init(theHandle, theRoot);
    });
    $('#btnPnMaterial').click(function () {
        $('#BuscarParamMaterial').show();
        $('#ConsultaTablaMaterial').hide();
    });
    $('#btnPnMaterial303').click(function () {
        $('#BuscarParamMaterial303').show();
        $('#ConsultaTablaMaterial303').hide();
    });
    $('#okMaterial').click(function () {
        MaterialesGet();
    });
    $('#okStockT').click(function () {
        $('#BuscarParamStockT').hide();
        $('#ConsultaTablaStockT').show();
        peticiones('PeticionMovMateriales', 'cargarDatosStockT', 'VentanaModalStockT', 'StockT');
    });
    $('#btnPnStockT').click(function () {
        $('#BuscarParamStockT').show();
        $('#ConsultaTablaStockT').hide();
        $('#bxTxtS').focus();
    });
    $('#btnPedido').click(function () {
        $('#BuscarParamPedido').show();
        $('#ConsultaTablaPedido').hide();
        LimpiarPantalla('VentanaModalPedido');
        mostrarVentana('VentanaModalPedido');
        document.getElementById('bxDC').focus();
        var theHandle = document.getElementById('handle5');
        var theRoot = document.getElementById('VentanaModalPedido');
        Drag.init(theHandle, theRoot);

    });
    $('#btnPnPedido').click(function () {
        $('#BuscarParamPedido').show();
        $('#ConsultaTablaPedido').hide();
    });
    $('#okPedido').click(function () {
        $('#BuscarParamPedido').hide();
        $('#ConsultaTablaPedido').show();
        peticiones('PeticionMovMateriales', 'cargarDatosPedido', 'VentanaModalPedido', 'Pedido');
    });
    $('#ok101').click(function () {
        ObtenerDatos101();
    });
    $('#btnTomar').click(function () {
        CantidadPedido();
    });
    $('#okAv').click(function () {
        ocultarVentana('VentanaModalAv', 'bxPedido');
    });
    $('#BorrarFila').click(function ()
    {
        VerificarRegistros();
    });
    $('#okRG').click(function () {
        ShowMsg(1, "images/load.gif", "audio/sapmsg.wav");
        GuardarMovimientos("VaciarTemporal", "");
        LimpiarPpal("LimpiarPpal");
        setTimeout("TomarDatosR(0);", 2000);
    });
    $('#ok201').click(function () {
//        if ($('#bxMaterial201').val().length > 0) {
//            ValidaMaterialHabilitado($('#bxMaterial201').val());
//            if (habl === 1) {
//                TomarDatos200("ValidaUM");
//            } else {
//                var iconm = $('iconmsg');
//                iconm.style.display = "inline";
//                iconm.style.visibility = "visible";
//                iconm.src = "images/advertencia.PNG";
//                var men = document.getElementById("msg");
//                men.innerHTML = "Material inhabilitado";
//                $('#bxMaterial201').focus();
//            }
//        } else {
        TomarDatos200("ValidaUM");
//        }
    });
    $('#ok303').click(function () {
        TomarDatos300("ValidaUM");
    });
    $('#ok305').click(function () {
        var iconm = document.getElementById("iconmsg");
        iconm.style.display = "inline";
        iconm.style.visibility = "visible";
        iconm.src = "images/load.gif";
        var men = document.getElementById("msg");
        men.innerHTML = "Cargando posiciones.....";
        setTimeout("TomarDatos305(0, 'ValidaCntST');", 2000);
    });
    $('#ok311').click(function () {
        if ($('#bxMaterial311').val().length > 0) {
//            ValidaMaterialHabilitado($('#bxMaterial311').val());
//            if (habl === 1) {
            TomarDatos310("ValidaUM");
//            } else {
//                var iconm = document.getElementById("iconmsg");
//                iconm.style.display = "inline";
//                iconm.style.visibility = "visible";
//                iconm.src = "images/advertencia.PNG";
//                var men = document.getElementById("msg");
//                men.innerHTML = "Material inhabilitado";
//                $('#bxMaterial311').focus();
//            }
        } else {
            TomarDatos310("ValidaUM");
        }
    });
    $('#okMaterial303').click(function () {
        match303MatOk();
    });
    $('#btnGrabarD').click(function () {
        validaDefectos(0);
    });
    $('#okTexto').click(function () {
        $('#Textlib' + $('#bxTextoL').val()).val($('#Textlib').val());
        ocultarVentana('VentanaModalTexto', '');
    });

    $('#guardar').click(function () {
//        var theHandle = document.getElementById('handle22');
//        var theRoot = document.getElementById('VentanaModalCalidad');
//        Drag.init(theHandle, theRoot);
//        abrirVentanaCalidad(document.getElementById('VentanaModalCalidad'));
//        cargarCabeceraCalidad("10001665");
//        TablaCaracteristicas("10001665", "6.000");
//        TablaDefectos();
//        obtenerMov();
        if (document.getElementsByName("Pedidos").length > 0)
        {
            if (document.getElementById('bxClase').value === "101" || document.getElementById('bxClase').value === "305") {
                PosicionesCld();
            } else {
                dataxxxx();
            }
        } else {
            var ven = document.getElementById('VentanaModalAv');
            msgWindo123(ven, 1);
            return;
        }
    });
    $('#okCalidad').click(function () {
        if (document.getElementById('btnGrabarR').disabled === false)
        {
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Sin defectos guardados";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            return;
        }
        PosicionesCld();
    });
//    $('#bxMaterial201').focus(function ()//NuevoLalo
//    {
//        $('#bxLote201').css('background-image', 'none');
//    });
//    $('#bxMaterial201').blur(function ()//NuevoLalo
//    {
//        ObtenerMaterial200();
//        ObtenerLoteD();
//    });
    $('#bxMaterial305').blur(function ()//NuevoLalo
    {
        ObtenerMaterialN3();
        ObtenerLoteD();
    });
    $('#bxMaterial303').blur(function ()//NuevoLalo
    {
        ObtenerMaterialN("303");
        ObtenerLoteD();
    });
    $('#bxMaterial201').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            if ($('#bxMaterial201').val().length > 0) {
                obtenerMaterialDatos();
            }
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#bxMaterial305').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ObtenerMaterialN3();
            ObtenerLoteD();
        }
    });
    $('#okBC').click(function () {
        ocultarVentana('VentanaModalBarCode', '');
//        var bc = $("#bxBC").val();
//        var arr = new Array();
//        arr = bc.split("'");
//        var ar1 = arr[0];
//        var ar2 = arr[1];
//        var ar3 = arr[2];
//
//        var claseD = document.getElementById("bxClase").value;
//
//        if (claseD === "315") {
//            var mate = document.getElementsByName('315MaterTD');
//            var lote = document.getElementsByName('315LotesTD');
//            var cnt = document.getElementsByName('315CantiTD');
//            var doc = document.getElementsByName('315DocTD');
//            var pos = document.getElementsByName('315PosTD');
//            for (var i = 0; i < mate.length; i++) {
//                if (mate[i].value === "") {
//                    mate[i].value = ar1;
//                    lote[i].value = ar2;
//                    cnt[i].value = ar3;
//                    ocultarVentana('VentanaModalBarCode', '');
//                    mate[i].focus();
//                    pedidoPos(ar2, doc[i], pos[i]);
//                    return;
//                }
//            }
//        } else if (claseD === "301") {
//            var mate = document.getElementsByName('301MaterTD');
//            var lote = document.getElementsByName('301LotesTD');
//            var cnt = document.getElementsByName('301CantiTD');
//            var doc = document.getElementsByName('301DocTD');
//            var pos = document.getElementsByName('301PosTD');
//            for (var i = 0; i < mate.length; i++) {
//                if (mate[i].value === "") {
//                    mate[i].value = ar1;
//                    lote[i].value = ar2;
//                    cnt[i].value = ar3;
//                    ocultarVentana('VentanaModalBarCode', '');
//                    mate[i].focus();
//                    pedidoPos(ar2, doc[i], pos[i]);
//                    return;
//                }
//            }
//        } else if (claseD === "313") {
//            var mate = document.getElementsByName('313MaterTD');
//            var lote = document.getElementsByName('313LotesTD');
//            var cnt = document.getElementsByName('313CantiTD');
//            var doc = document.getElementsByName('313DocTD');
//            var pos = document.getElementsByName('313PosTD');
//            for (var i = 0; i < mate.length; i++) {
//                if (mate[i].value === "") {
//                    mate[i].value = ar1;
//                    lote[i].value = ar2;
//                    cnt[i].value = ar3;
//                    ocultarVentana('VentanaModalBarCode', '');
//                    mate[i].focus();
//                    pedidoPos(ar2, doc[i], pos[i]);
//                    return;
//                }
//            }
//        } else if (claseD === "311") {
//            var mate = document.getElementsByName('311MaterTD');
//            var lote = document.getElementsByName('311LotesTD');
//            var cnt = document.getElementsByName('311CantiTD');
//            var doc = document.getElementsByName('311DocTD');
//            var pos = document.getElementsByName('311PosTD');
//            for (var i = 0; i < mate.length; i++) {
//                if (mate[i].value === "") {
//                    mate[i].value = ar1;
//                    lote[i].value = ar2;
//                    cnt[i].value = ar3;
//                    ocultarVentana('VentanaModalBarCode', '');
//                    mate[i].focus();
//                    pedidoPos(ar2, doc[i], pos[i]);
//                    return;
//                }
//            }
//        }
    });
    $('#313tdAlmacPP').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#311tdAlmacPP').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#301tdCentrPP').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#bxBC').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            borrarmsg();
            var bc = $("#bxBC").val();
            var arr = new Array();
            arr = bc.split("'");
            var ar1 = arr[0];
            var ar2 = arr[1];
            var ar3 = arr[2];

            var claseD = document.getElementById("bxClase").value;

            if (claseD === "315") {
                var mate = document.getElementsByName('315MaterTD');
                var lote = document.getElementsByName('315LotesTD');
                var cnt = document.getElementsByName('315CantiTD');
                var doc = document.getElementsByName('315DocTD');
                var pos = document.getElementsByName('315PosTD');
                var ckck = document.getElementsByName('315chkbox');
                for (var i = 0; i < mate.length; i++) {
                    if (mate[i].value === "") {
                        mate[i].value = ar1;
                        lote[i].value = ar2;
                        cnt[i].value = ar3;
//                        ocultarVentana('VentanaModalBarCode', '');
//                        mate[i].focus();
                        pedidoPos(ar2, doc[i], pos[i]);
                        GetinfoMat($('#315tdMater' + ckck[i].value).val(), "315", ckck[i].value);
                        $("#bxBC").val("");
                        return;
                    }
                }
                AgregarFilasTablaScanner(ar1, ar2, ar3, "", "315", doc, pos, "");
            } else if (claseD === "301") {
                var mate = document.getElementsByName('301MaterTD');
                var lote = document.getElementsByName('301LotesTD');
                var cnt = document.getElementsByName('301CantiTD');
                var doc = document.getElementsByName('301DocTD');
                var pos = document.getElementsByName('301PosTD');
                var cen = document.getElementsByName('301CentrTD');
                var ckck = document.getElementsByName('301chkbox');
                if ($('#301tdCentrPP').val().trim().length == 0) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#bxBC').val("");
                    $('#301tdCentrPP').focus();
                    return;
                }
                for (var i = 0; i < mate.length; i++) {
                    if (mate[i].value === "") {
                        mate[i].value = ar1;
                        lote[i].value = ar2;
                        cnt[i].value = ar3;
                        cen[i].value = $("#301tdCentrPP").val();
//                        ocultarVentana('VentanaModalBarCode', '');
//                        mate[i].focus();
                        pedidoPos(ar2, doc[i], pos[i]);
                        GetinfoMat($('#301tdMater' + ckck[i].value).val(), "301", ckck[i].value);
                        $("#bxBC").val("");
                        return;
                    }
                }
                AgregarFilasTablaScanner(ar1, ar2, ar3, "", "301", doc, pos, $("#301tdCentrPP").val());
            } else if (claseD === "313") {
                var mate = document.getElementsByName('313MaterTD');
                var lote = document.getElementsByName('313LotesTD');
                var cnt = document.getElementsByName('313CantiTD');
                var doc = document.getElementsByName('313DocTD');
                var pos = document.getElementsByName('313PosTD');
                var alm = document.getElementsByName('313AlmacTD');
                var ckck = document.getElementsByName('313chkbox');
                var cont313 = mate.length;
                var i = 0;
                if ($('#313tdAlmacPP').val().trim().length == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#bxBC').val("");
                    $('#313tdAlmacPP').focus();
                    return;
                }
                for (i; i < cont313; i++) {
                    if (mate[i].value === "") {
                        mate[i].value = ar1;
                        lote[i].value = ar2;
                        cnt[i].value = ar3;
                        alm[i].value = $("#313tdAlmacPP").val();
//                        ocultarVentana('VentanaModalBarCode', '');
//                        mate[i].focus();
                        pedidoPos(ar2, doc[i], pos[i]);
                        GetinfoMat($('#313tdMater' + ckck[i].value).val(), "313", ckck[i].value);
                        $("#bxBC").val("");
                        return;
                    }
                }
                AgregarFilasTablaScanner(ar1, ar2, ar3, $("#313tdAlmacPP").val(), "313", doc, pos, "");

            } else if (claseD === "311") {
                var mate = document.getElementsByName('311MaterTD');
                var lote = document.getElementsByName('311LotesTD');
                var cnt = document.getElementsByName('311CantiTD');
                var doc = document.getElementsByName('311DocTD');
                var pos = document.getElementsByName('311PosTD');
                var alm = document.getElementsByName('311AlmacTD');
                var ckck = document.getElementsByName('311chkbox');
                if ($('#311tdAlmacPP').val().trim().length == 0) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#bxBC').val("");
                    $('#311tdAlmacPP').focus();
                    return;
                }
                for (var i = 0; i < mate.length; i++) {
                    if (mate[i].value === "") {
                        mate[i].value = ar1;
                        lote[i].value = ar2;
                        cnt[i].value = ar3;
                        alm[i].value = $("#311tdAlmacPP").val();
//                        ocultarVentana('VentanaModalBarCode', '');
//                        mate[i].focus();
                        pedidoPos(ar2, doc[i], pos[i]);
                        GetinfoMat($('#311tdMater' + ckck[i].value).val(), "311", ckck[i].value);
                        $("#bxBC").val("");
                        return;
                    }
                }
                AgregarFilasTablaScanner(ar1, ar2, ar3, $("#311tdAlmacPP").val(), "311", doc, pos, "");
            }

        }
    });
    function AgregarFilasTablaScanner(material, lote, cantidad, almacen, ClaseM, doc, pos, centroo) {
        var ckck;
        var Ctro = centroo;
        var Value = almacen;
        var dis = "";
        var dis2 = "";
        var dis3 = "";
        $('#TempRod').remove();
        var Centro = $('#bxCentro').val().trim();
        var nam12 = ClaseM + 'chkbox';
        var ch = document.getElementsByName(nam12);
        var valor = ch[ch.length - 1].value;
        var i = parseInt(valor) + 1;
        if (ClaseM === "301") {
            Value = "1800";
            dis = "disabled";
            ckck = document.getElementsByName('301chkbox');
        }
        if (ClaseM === "311") {
            dis2 = "disabled";
            Ctro = Centro;
            ckck = document.getElementsByName('311chkbox');
        }
        if (ClaseM === "313") {
            Ctro = Centro;
            dis2 = "disabled";
            ckck = document.getElementsByName('313chkbox');
        }
        if (ClaseM === "315") {
            dis = "disabled";
            dis2 = "disabled";
            dis3 = "";
            ckck = document.getElementsByName('315chkbox');
        }
        var newfiladata
                = "<tr>"
                + "<td><input type=\"checkbox\" name=\"" + ClaseM + "chkbox\" value=\"" + i + "\"/></td>"
                + "<td><input type=\"text\" class=\"tdCMatch\" value=\"" + material + "\" id=\"" + ClaseM + "tdMater" + i + "\" name=\"" + ClaseM + "MaterTD\" onfocus=\"MostrarMatch('tdMater', 'MCMaterial', '" + i + "')\" maxlength=\"40\" style=\"text-transform: uppercase\"/><button id=\"" + ClaseM + "MCMaterial" + i + "\" onclick=\"AbrirMatchElemtnosGrid('VentanaModalMaterialNuevo', 'handleMatNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', '" + i + "', 'busMatNuevo', 'BusDesMatNuevo', 'numAciertosNuevo')\" name=\"" + ClaseM + "matchMaterial\" class='BtnMatchIconGrid'></button></td>"
                + "<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdDescr" + i + "\" name=\"" + ClaseM + "DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
                + "<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdUmedi" + i + "\" name=\"" + ClaseM + "UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
                + "<td><input type=\"text\" class=\"tdSMatch\" value=\"" + cantidad + "\" id=\"" + ClaseM + "tdCanti" + i + "\" name=\"" + ClaseM + "CantiTD\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>"
                + "<td><input type=\"text\" class=\"tdCMatch\" value=\"" + lote + "\" id=\"" + ClaseM + "tdLotes" + i + "\" name=\"" + ClaseM + "LotesTD\" onfocus=\"MostrarMatch('tdLotes', 'MCLote', '" + i + "')\" maxlength=\"10\" style=\"text-transform: uppercase\" " + dis3 + "/><input hidden type=\"text\" id=\"" + ClaseM + "tdDoc" + i + "\" name=\"" + ClaseM + "DocTD\"/><input hidden type=\"text\" id=\"" + ClaseM + "tdPos" + i + "\" name=\"" + ClaseM + "PosTD\"/><button id=\"" + ClaseM + "MCLote" + i + "\" onclick=\"ConsultaLotesNBuevo('" + i + "');\" name=\"" + ClaseM + "matchLote\" class='BtnMatchIconGrid'></button></td>"
                + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdCentr" + i + "\" name=\"" + ClaseM + "CentrTD\" onfocus=\"MostrarMatch('tdCentr', 'MCCen', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Ctro + "\" " + dis2 + "/><button id=\"" + ClaseM + "MCCen" + i + "\" onclick=\"ConsultaCentroNuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>"
                + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdAlmac" + i + "\" name=\"" + ClaseM + "AlmacTD\" onfocus=\"MostrarMatch('tdAlmac', 'MCAlm', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Value + "\" " + dis + "/><button id=\"" + ClaseM + "MCAlm" + i + "\" onclick=\"ConsultaAlmaNBuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>"
                + "</tr>";
        var tempro = "<tr id=\"TempRod\" class=\"ocultar\"><td>0000</td><td>000000000000000</td><td>000000000000000000000000000000</td><td>0000000</td><td>00000000000000</td><td>000000000000000</td><td>00000000000000000</td><td>0000000000000000</td></tr>";
        $('#TabBody301').append(newfiladata);
        $('#TabBody301').append(tempro);
        $("#bxBC").val("");
        GetinfoMat(material.trim(), ClaseM, ckck[i].value);
        pedidoPos(lote, doc[i], pos[i]);
        loadDoubleScroll("DobleSection301", "SecCuerpo301", "DobleContainer301", "TabBody301");
    }
    $('#bxMaterial311').blur(function ()//NuevoLalo
    {
        ObtenerMaterialN('311');
        ObtenerLoteD();
    });
    $('#bxMaterial311').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ObtenerMaterialN('311');
            ObtenerLoteD();
        }
    });
    $('#bxMaterial303').blur(function ()//NuevoLalo
    {
        ObtenerMaterialN('303');
        ObtenerLoteD();
    });
    $('#bxMaterial303').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ObtenerMaterialN('303');
            ObtenerLoteD();
        }
    });
    $('#bxLote303').blur(function ()//NuevoLalo
    {
        var btnS = document.getElementById('bxClase').value;
        if (btnS == "305")
        {
            ObtenerCantidadD();
        }
    });
    $('#txtMat303').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamMaterial303').hide();
            $('#ConsultaTablaMaterial303').show();
            match303MatOk();
        }
    });
    $('#idio303').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamMaterial303').hide();
            $('#ConsultaTablaMaterial303').show();
            match303MatOk();
        }
    });
    $('#mat303').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamMaterial303').hide();
            $('#ConsultaTablaMaterial303').show();
            match303MatOk();
        }
    });
    $('#numAcMaxMat303').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamMaterial303').hide();
            $('#ConsultaTablaMaterial303').show();
            match303MatOk();
        }
    });


    //Match Material
    $('#bxtxtm').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return true;
        }
        if (te == 13) {
            MaterialesGet();
        }
        t = String.fromCharCode(te);
        patron = /[0-9a-zA-Z]/;
        return patron.test(t);
    });
    $('#bxclim').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        if (te == 13) {
            MaterialesGet();
        }
        t = String.fromCharCode(te);
        patron = /[0-9a-zA-Z]/;
        return patron.test(t);
    });
    $('#bxmatm').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        if (te == 13) {
            MaterialesGet();
        }
        t = String.fromCharCode(te);
        patron = /[0-9a-zA-Z]/;
        return patron.test(t);
    });
    $('#bxcnmm').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        if (te == 13) {
            MaterialesGet();
        }
        t = String.fromCharCode(te);
        patron = /[0-9]/;
        return patron.test(t);
    });

    //Match Centro Coste
    $('#bxcc').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CeCosGet();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#bxsc').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CeCosGet();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#bxtxc').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CeCosGet();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#bxtxc2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CeCosGet();
        }
        if (tecla == 32) {
            return true;
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMaxCeco').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CeCosGet();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    //Match Proveedor
    $('#bxnom').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamProv').hide();
            $('#ConsultaTablaProv').show();
            peticiones('PeticionMovMateriales', 'cargarDatosProv', 'VentanaModalProv', 'Prov');
        }
    });
    $('#bxacc').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamProv').hide();
            $('#ConsultaTablaProv').show();
            peticiones('PeticionMovMateriales', 'cargarDatosProv', 'VentanaModalProv', 'Prov');
        }
    });
    //  Match pedidos
    $('#bxDC').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamPedido').hide();
            $('#ConsultaTablaPedido').show();
            peticiones('PeticionMovMateriales', 'cargarDatosPedido', 'VentanaModalPedido', 'Pedido');
        }
    });
    $('#bxSolp').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamPedido').hide();
            $('#ConsultaTablaPedido').show();
            peticiones('PeticionMovMateriales', 'cargarDatosPedido', 'VentanaModalPedido', 'Pedido');
        }
    });
    $('#bxCnM').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamPedido').hide();
            $('#ConsultaTablaPedido').show();
            peticiones('PeticionMovMateriales', 'cargarDatosPedido', 'VentanaModalPedido', 'Pedido');
        }
    });
    //  Match stock - traslado
    $('#bxTxtS').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamStockT').hide();
            $('#ConsultaTablaStockT').show();
            peticiones('PeticionMovMateriales', 'cargarDatosStockT', 'VentanaModalStockT', 'StockT');
        }
    });
    $('#bxCliS').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamStockT').hide();
            $('#ConsultaTablaStockT').show();
            peticiones('PeticionMovMateriales', 'cargarDatosStockT', 'VentanaModalStockT', 'StockT');
        }
    });
    $('#bxMatS').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamStockT').hide();
            $('#ConsultaTablaStockT').show();
            peticiones('PeticionMovMateriales', 'cargarDatosStockT', 'VentanaModalStockT', 'StockT');
        }
    });
    $('#bxCnmS').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $('#BuscarParamStockT').hide();
            $('#ConsultaTablaStockT').show();
            peticiones('PeticionMovMateriales', 'cargarDatosStockT', 'VentanaModalStockT', 'StockT');
        }
    });
    $('#bxClsInf').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultarClsInf();
        }
    });



    //---------**Unidad de Medida------------//
    var um201 = $('#bxMaterial201');
    var um261 = $('#bxMaterial261');
    var um303 = $('#bxMaterial303');
    var um305 = $('#bxMaterial305');
    var um311 = $('#bxMaterial311');

    var arrBlur = [
        um201,
        um261,
        um303,
        um305,
        um311
    ];
    $.each(arrBlur, function (i, v)
    {
        v.blur(function ()
        {
            switch (i)
            {
                case 0:
//                    d_um("201");
//                    $('#bxUM201').css('background-image', 'none');
                    break;
                case 1:
                    d_um("261");
                    break;
                case 2:
                    d_um("303");
                    $('#bxUM303').css('background-image', 'none');
                    break;
                case 3:
                    d_umT("305");
                    break;
                case 4:
                    d_um("311");
                    $('#bxUM311').css('background-image', 'none');
                    break;
            }
        });
    });
    $.each(arrBlur, function (i, v)
    {
        v.keypress(function (e)
        {
            if (e.which == 13 || e.keyCode == 13) {
                switch (i)
                {
                    case 0:
//                        d_um("201");
//                        $('#bxUM201').css('background-image', 'none');
                        break;
                    case 1:
                        d_um("261");
                        break;
                    case 2:
                        d_um("303");
                        $('#bxUM311').css('background-image', 'none');
                        break;
                    case 3:
                        d_umT("305");
                        break;
                    case 4:
                        d_um("311");
                        $('#bxUM311').css('background-image', 'none');
                        break;
                }
            }
        });
    });

    //---------**Ventana303**------------//

    //inputs
    var mat303 = $('#bxMaterial303');
    var cnt303 = $('#bxcnt303');
    var UM303 = $('#bxUM303');
    var lote303 = $('#bxLote303');
    var ctr303 = $('#bxCentro303');

    var arr303 = [
        mat303,
        cnt303,
        UM303,
        lote303,
        ctr303
    ];

    //Buttons
    var BtnMat303 = $('#btnMat303');
    var BtnLot303 = $('#btnLot303');
    var btnCtr303 = $('#btnCtr303');

    var arrBT303 = [
        BtnMat303,
        BtnLot303,
        btnCtr303
    ];

    //Forech
    $.each(arr303, function (i, v)
    {
        if (i < 5)
        {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function ()
        {
            v.css('background-image', 'none');
            $.each(arrBT303, function (t, y)
            {
                switch (i)
                {
                    case 0:
                        if (t == 0) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 3:
                        if (t == 1) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 4:
                        if (t == 2) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;

                    default:
                        y.hide();
                        break
                }
            }
            );
        }
        );
        v.blur(function ()
        {
            if (i < 5)
            {
                if (v.val().length > 0)
                {
                    v.css('background-image', 'none');
                } else
                {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
        }
        );
        v.keypress(function (e) {
            l = (document).all ? e.keyCode : e.which;
            if (i === 1)
            {
                patron = /[0-9.]/;
                pat = String.fromCharCode(l);
                return (patron.test(pat));
            }
        });
    }
    );
    $.each(arrBT303, function (i, v)
    {
        v.hide();
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#BuscarParamMaterial').show();
                    $('#ConsultaTablaMaterial').hide();
                    LimpiarPantalla('VentanaModalMaterial');
                    mostrarVentana + ('VentanaModalMaterial');
                    document.getElementById('bxtxtm').focus();
                    var theHandle = document.getElementById('handle8');
                    var theRoot = document.getElementById('VentanaModalMaterial');
                    Drag.init(theHandle, theRoot);
                    break;
                case 1:
                    mostrarVentana('VentanaModalLote');
                    peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '');
                    var theHandle = document.getElementById('handle6');
                    var theRoot = document.getElementById('VentanaModalLote');
                    Drag.init(theHandle, theRoot);
                    break;
                case 2:
                    mostrarVentana('VentanaModalCentroA');
                    var theHandle = document.getElementById('handle');
                    var theRoot = document.getElementById('VentanaModalCentro');
                    Drag.init(theHandle, theRoot);
                    break;
            }
        });
    });

    //---------**Ventana305**------------//

    var arr305 = [
        $('#bxMaterial305'),
        $('#bxcnt305'),
        $('#bxUM305'),
        $('#bxLote305')
    ];

    var arrBT305 = [
        $('#btnMat305'),
        $('#btnLot305')
    ];

    $.each(arr305, function (i, v)
    {
        if (i < 4)
        {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function ()
        {
            v.css('background-image', 'none');
            $.each(arrBT305, function (t, y)
            {
                switch (i)
                {
                    case 0:
                        if (t == 0) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 3:
                        if (t == 1) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    default:
                        y.hide();
                        break
                }
            }
            );
        }
        );
        v.blur(function ()
        {
            if (i < 4)
            {
                if (v.val().length > 0)
                {
                    v.css('background-image', 'none');
                } else
                {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
        }
        );
        v.keypress(function (e) {
            l = (document).all ? e.keyCode : e.which;
            if (i === 1)
            {
                patron = /[0-9.]/;
                pat = String.fromCharCode(l);
                return (patron.test(pat));
            }
        });
    });
    $.each(arrBT305, function (i, v)
    {
        v.hide();
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#BuscarParamStockT').show();
                    $('#ConsultaTablaStockT').hide();
                    LimpiarPantalla('VentanaModalStockT');
                    mostrarVentana('VentanaModalStockT');
                    document.getElementById('bxTxtS').focus();
                    var theHandle = document.getElementById('handle19');
                    var theRoot = document.getElementById('VentanaModalStockT');
                    Drag.init(theHandle, theRoot);
                    break;
                case 1:
                    mostrarVentana('VentanaModalLote');
                    peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '');
                    var theHandle = document.getElementById('handle6');
                    var theRoot = document.getElementById('VentanaModalLote');
                    Drag.init(theHandle, theRoot);
                    break;
            }
        });
    });

    //---------**Ventana311-312**------------//

    //inputs
    var mat311 = $('#bxMaterial311');
    var cnt311 = $('#bxcnt311');
    var UM311 = $('#bxUM311');
    var lote311 = $('#bxLote311');
    var alm311 = $('#bxAlmacen311');

    var stc311 = $('#bxstk311');
    var pro311 = $('#bxpov311');

    var arr311 = [
        mat311,
        cnt311,
        UM311,
        lote311,
        alm311,
        stc311,
        pro311
    ];
    //Buttons
    var BtnMat311 = $('#btnMat311');
    var BtnLot311 = $('#btnLot311');
    var BtnPov311 = $('#btnPov311');
    var BtnAlm311 = $('#btnAlmacen311');

    var arrBT311 = [
        BtnMat311,
        BtnLot311,
        BtnAlm311,
        BtnPov311
    ];

    $.each(arr311, function (i, v)
    {
        if (i < 5)
        {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function ()
        {
            v.css('background-image', 'none');
            $.each(arrBT311, function (t, y)
            {
                switch (i)
                {
                    case 0:
                        if (t == 0) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 3:
                        if (t == 1) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 4:
                        if (t == 2) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    case 6:
                        if (t == 3) {
                            y.show();
                        } else {
                            y.hide();
                        }
                        break;
                    default:
                        y.hide();
                        break
                }
            }
            );
        }
        );
        v.blur(function ()
        {
            if (i < 5)
            {
                if (v.val().length > 0)
                {
                    v.css('background-image', 'none');
                } else
                {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
        }
        );
    }
    );
    $.each(arrBT311, function (i, v)
    {
        v.hide();
        v.click(function ()
        {
            switch (i)
            {
                case 0:
                    $('#BuscarParamMaterial').show();
                    $('#ConsultaTablaMaterial').hide();
                    LimpiarPantalla('VentanaModalMaterial');
                    mostrarVentana('VentanaModalMaterial');
                    document.getElementById('bxtxtm').focus();
                    var theHandle = document.getElementById('handle8');
                    var theRoot = document.getElementById('VentanaModalMaterial');
                    Drag.init(theHandle, theRoot);
                    break;
                case 1:
                    ConsultaLotesNBuevo("");
                    break;
                case 2:
                    mostrarVentana('VentanaModalAlmacenA');
                    var theHandle = document.getElementById('handle2');
                    var theRoot = document.getElementById('VentanaModalAlmacen');
                    Drag.init(theHandle, theRoot);
                    break;
                case 3:
                    $('#BuscarParamProv').show();
                    $('#ConsultaTablaProv').hide();
                    LimpiarPantalla('VentanaModalProv');
                    mostrarVentana('VentanaModalProv');
                    document.getElementById('bxnom').focus();
                    var theHandle = document.getElementById('handle10');
                    var theRoot = document.getElementById('VentanaModalProv');
                    Drag.init(theHandle, theRoot);
                    break;
            }
        });
    }
    );

    ////// input's 
    var mat261 = $('#bxMaterial261');
    var can261 = $('#bxcnt261');
    var unm261 = $('#bxUM261');
    var lot261 = $('#bxLote261');
    var ord261 = $('#bxord261');
    var sto261 = $('#bxstk261');
    var pro261 = $('#bxpov201261');

    var arrinput = [
        mat261,
        can261,
        unm261,
        lot261,
        ord261,
        sto261,
        pro261
    ];
    //// button's
    var btnMat261 = $('#btnMat261');
    var btnLot261 = $('#btnLot261');
    var btnOrd261 = $('#btnOrd261');
    var btnPro261 = $('#btnPov261');
    var arrbutton = [
        btnMat261,
        btnLot261,
        btnOrd261,
        btnPro261
    ];

    ///// arreglo para input's 
    $.each([$('#bxcnt261'), $('#bxcnmor'), $('#bxtxtOrd'), $('#bxOrden'), $('#okOrd')], function (i, v) {

        v.keypress(function (e) {
            tec = (document).all ? e.keyCode : e.which;
            if (i < 2) {
                patron = /[0-9.]/;
                tecfin = String.fromCharCode(tec);
                return patron.test(tecfin);
            }
            if (i == 1 || i == 2 || i == 3) {
                if (tec == 13) {
                    peticionOrden();
                }
            }
        });
        v.click(function () {
            if (i == 4) {
                peticionOrden();
            }
        });
    });

    $.each(arrinput, function (i, v) {
        if (i < 5) {
            v.css('background-image', 'url(images/necesario.PNG)');
        }
        v.focus(function () {
            v.css('background-image', 'none');
            $.each(arrbutton, function (iN, vA) {
                switch (i) {
                    case 0:
                        if (iN == 0) {
                            vA.show();
                        } else {
                            vA.hide();
                        }
                        break;
                    case 3:
                        if (iN == 1) {
                            vA.show();
                        } else {
                            vA.hide();
                        }
                        break;
                    case 4:
                        if (iN == 2) {
                            vA.show();
                        } else {
                            vA.hide();
                        }
                        break;
                    case 6:
                        if (iN == 3) {
                            vA.show();
                        } else {
                            vA.hide();
                        }
                        break;
                    default:
                        vA.hide();
                        break;
                }
            });
        });
        v.blur(function () {
            if (i < 5) {
                if (v.val().length > 0) {
                    v.css('background-image', 'none');
                } else {
                    v.css('background-image', 'url(images/necesario.PNG)');
                }
            }
            if (i == 0) {
                if (v.val().length > 0) {
                    ObtenerMaterialN('261');
                    ObtenerLoteD();
                }
            }
        });
        v.keypress(function (e) {
            tc = (document).all ? e.keyCode : e.which;
            if (tc == 13) {
                ObtenerMaterialN('261');
                ObtenerLoteD();
            }
        });
    });
    $.each(arrbutton, function (i, v) {
        v.hide();
        v.click(function () {
            switch (i) {
                case 0:
                    $('#BuscarParamMaterial').show();
                    $('#ConsultaTablaMaterial').hide();
                    LimpiarPantalla('VentanaModalMaterial');
                    mostrarVentana('VentanaModalMaterial');
                    document.getElementById('bxtxtm').focus();
                    var theHandle = document.getElementById('handle8');
                    var theRoot = document.getElementById('VentanaModalMaterial');
                    Drag.init(theHandle, theRoot);
                    break;
                case 1:
                    ConsultaLotesNBuevo("");
//                    mostrarVentana('VentanaModalLote');
//                    peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '');
//                    var theHandle = document.getElementById('handle6');
//                    var theRoot = document.getElementById('VentanaModalLote');
//                    Drag.init(theHandle, theRoot);
                    break;
                case 2:
                    $('#BuscarParamOrd').show();
                    $('#ConsultaTablaOrden').hide();
                    LimpiarPantalla('VentanaModalOrden');
                    mostrarVentana('VentanaModalOrden');
                    document.getElementById('bxOrden').focus();
                    var theHandle = document.getElementById('handle12');
                    var theRoot = document.getElementById('VentanaModalOrden');
                    Drag.init(theHandle, theRoot);
                    break;
                case 3:
                    $('#BuscarParamProv').show();
                    $('#ConsultaTablaProv').hide();
                    LimpiarPantalla('VentanaModalProv');
                    mostrarVentana('VentanaModalProv');
                    document.getElementById('bxnom').focus();
                    var theHandle = document.getElementById('handle10');
                    var theRoot = document.getElementById('VentanaModalProv');
                    Drag.init(theHandle, theRoot);
                    break;
            }
        });
    });
    $('#ok261').click(function () {
        if ($('#bxMaterial261').val().length > 0) {
//            ValidaMaterialHabilitado($('#bxMaterial261').val());
//            if (habl === 1) {
//                TomarDatos260('ValidaUM');
//            } else {
            TomarDatos260('ValidaUM');
//            }
        } else {
            var iconm = document.getElementById("iconmsg");
            iconm.style.display = "inline";
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = "Material Obligatorio";
            $('#bxMaterial261').focus();
        }
    });

    function peticionOrden() {
        $('#BuscarParamOrd').hide();
        $('#ConsultaTablaOrden').show();
        peticiones('PeticionMovMateriales', 'cargarDatosOrd', 'VentanaModalOrden', 'Orden', '');
    }
    function peticionReserva() {
        $('#BuscarParamReserva').hide();
        $('#ConsultaTablaReserva').show();
        peticiones('PeticionMovMateriales', 'cargarDatosReserva', 'VentanaModalReserva', 'Reserva', '');
    }

    /////// reservas
    $('#btnMacthreserv').hide();
    $('#bxReserva').focus(function () {
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').show();
        $('#btnfechaD').hide();
    });
    $('#bxReserva').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 32) {
            return false;
        }
        t = String.fromCharCode(te);
        patron = /[ÑñA-Za-z0-9\s]/;
        return patron.test(t);
    });

    $('#btnMacthreserv').click(function () {
        mostrarVentana('VentanaModalReserva');
        $('#BuscarParamReserva').show();
        $('#ConsultaTablaReserva').hide();
        var theHandle = document.getElementById('handle14');
        var theRoot = document.getElementById('VentanaModalReserva');
        Drag.init(theHandle, theRoot);
    });
    $('#btnPnRese').click(function () {
        mostrarVentana('VentanaModalReserva');
        $('#BuscarParamReserva').show();
        $('#ConsultaTablaReserva').hide();
        var theHandle = document.getElementById('handle14');
        var theRoot = document.getElementById('VentanaModalReserva');
        Drag.init(theHandle, theRoot);
    });
    $.each([$('#SReserva'), $('#SPosicion'), $('#SCMov'), $('#SMaterial'), $('#STMaterial'), $('#SCentro'), $('#SAlmacen'), $('#SUsuario'), $('#CtdAccmax')], function (i, v) {
        v.keypress(function (e) {
            var te = (document).all ? e.keyCode : e.which;
            if (te == 13) {
                peticionReserva();
            }
            if (i == 8) {
                patron = /[0-9]/;
                tec = String.fromCharCode(te);
                return patron.test(tec);
            }
        });
    });
    $('#okReser').click(function () {
        peticionReserva();
    });
    $('#btnReserva').click(function () {
        $('#btnCentro').hide();
        $('#btnAlmacen').hide();
        $('#btnClase').hide();
        $('#btnMacthreserv').hide();
        tratarReserva();
    });

    $('#clo311').click(function () {
        Aumentar();
        ocultarVentana('VentanaModal311', 'btnAdd', 'm');
    });
    $('#clo261').click(function () {
        Aumentar();
        ocultarVentana('VentanaModal261', 'btnAdd', 'm');
    });
    $('#close201').click(function ()
    {
        Aumentar();
        ocultarVentana('VentanaModal201', 'btnAdd', 'm');
    });
    $('#bxPedido').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#bxPosc').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#bxClase').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#bxcnt201').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        patron = /[0-9.]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#bxcnt311').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        patron = /[0-9.]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
//    $('#bxcnt311').blur(function () {
//        if ($('#bxcnt311').val().length > 0)
//        {
//            var cnt = $('#bxcnt311').val();
//            var c = 0, cc = 0;
//            var nn;
//            for (var i = 0; i < cnt.length; i++) {
//                if (cnt[i] === ".")
//                {
//                    if (c === 2)
//                    {
//                        nn = cnt.substring(0, cnt.indexOf(".") + 1);
//                        $('#bxcnt311').val(nn + ".");
//                        if (nn.indexOf(".") === 0) {
//                            nn = "0" + nn;
//                        }
//                        if (nn.indexOf(".") > 0)
//                        {
//                            for (i = 0; i <= 3; i++)
//                            {
//                                nn += "0";
//                            }
//                            var nnn = nn.substring(0, (nn.indexOf(".") + 4));
//                            $('#bxcnt311').val(nnn);
//                        }
//                        return;
//                    }
//                    c++;
//                }
//                cc++;
//            }
//            if (c < 2) {
//                if (cnt.indexOf(".") === -1) {
//                    cnt = cnt + ".000";
//                }
//                if (cnt.indexOf(".") > 0)
//                {
//                    for (i = 0; i <= 3; i++)
//                    {
//                        cnt += "0";
//                    }
//                    nn = cnt.substring(0, (cnt.indexOf(".") + 4));
//                    $('#bxcnt311').val(nn);
//                }
//            }
//            UnidadMedidaMO();
//        }
//    });
    $("[id*=TCmat]").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            checkMate();
        }
    });
});

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


///////////////////////// FUNCIONES 303
var pos303;
function rowsOfTable(table) {
    var rows = $('#' + table + ' >tbody >tr').length;
    return rows;
}
function BtnShowTC(pos, type) {
    switch (type) {
        case 'match_TCmat':
            pos303 = pos;
            var rows = rowsOfTable('Tabla303');
            $('#match_TCmat' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TClot' + i).hide();
                    $('#match_TCcent' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TCmat' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TClot':
            pos303 = pos;
            var rows = rowsOfTable('Tabla303');
            $('#match_TClot' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TCmat' + i).hide();
                    $('#match_TCcent' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TClot' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TCcent':
            pos303 = pos;
            var rows = rowsOfTable('Tabla303');
            $('#match_TCcent' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TCmat' + i).hide();
                    $('#match_TClot' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TCcent' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TCumc':
            BtnHideTC();
            break;
    }
}
function BtnHideTC() {
    var rows = rowsOfTable('Tabla303');
    for (i = 0; i < rows; i++) {
        $('#match_TCmat' + i).hide();
        $('#match_TClot' + i).hide();
        $('#match_TCcent' + i).hide();
    }
}
function match303mat(pos) {
    $('#BuscarParamStockT').show();
    $('#ConsultaTablaStockT').hide();
    mostrarVentana('VentanaModalMaterial303');
    pos303 = pos;
}
function datosincorrectos() {
    var menCam = "No existen entradas";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}
function match303MatOk() {
    acc = "match303Mat";
    var txtDes = $('#txtMat303').val();
    var idoma = $('#idio303').val();
    var material = $('#mat303').val();
    var cntM = $('#numAcMaxMat303').val();
    var data = "&v1=" + txtDes + "&v2=" + idoma + "&v3=" + material + "&v4=" + cntM + "&v5=" + pos303;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + data,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamMaterial303').hide();
                $('#ConsultaTablaMaterial303').show();
                $('#cargarDatosMaterial303').html(rs);
                borrarmsg();
            }
        }
    });
}
function match303cent(i) {
    acc = "match303Cent";
    var data = "&v1=" + i;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + data,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                mostrarVentana('VentanaModalCentro303');
                $('#cargarDatosCentro303').html(rs);
                borrarmsg();
            }
        }
    });
}
function match303lot(i) {
    var mat = document.getElementsByName('TCmat');
    if (mat[i].value.length < 1) {
        var ven = document.getElementById('VentanaModalAv');
        var msg = "Ingresar un Material";
        abrirVentanaAv(ven, msg);
        var theHandle = document.getElementById('handleAV');
        var theRoot = document.getElementById('VentanaModalAv');
        Drag.init(theHandle, theRoot);
        mat[i].focus();
    } else {
        var check = getExisMat(mat[i].value);
        if (check == 0) {
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Material " + mat[i].value + " no existente en centro destino";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            mat[i].focus();
        } else {
            acc = "match303Lot";
            var data = "&v1=" + i + "&v2=" + mat[i].value;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionMovMateriales',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + data,
                success: function (rs) {
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        mostrarVentana('VentanaModalLote303');
                        $('#cargarDatosLote303').html(rs);
                        borrarmsg();
                    }
                }
            });
        }
    }
}
function checkMate() {
    var mat = document.getElementsByName('TCmat');
    var check = getExisMat(mat[pos303].value);
    if (check == 0) {
    } else {
        findMat(mat[pos303].value);
    }
}
function selectMatch303(type, pos, data) {
    switch (type) {
        case 'Mat303':
            ocultarVentanaM('mat303');
            var mat = $('#TCmat' + pos);
            mat.val(data);
            mat.focus();
            pos303 = pos;
            findMat(data);
            break;
        case 'Lote':
            ocultarVentanaM('lot303');
            var umc = $('#TClot' + pos);
            umc.val(data);
            umc.focus();
            break;
        case 'Centro':
            ocultarVentanaM('Centro');
            var umc = $('#TCcent' + pos);
            umc.val(data);
            umc.focus();
            break;
        case 'ClsInf':
            hideMatch('VentanaModalClsInf');
            $("#" + pos).val(data);
            $("#" + pos).focus();
            break;
    }
}
function ocultarVentanaM(tipo) {
    switch (tipo) {
        case "mat303":
            var ventana = $('#VentanaModalMaterial303');
            ventana.hide();
            $('#BuscarParamMaterial303').show();
            $('#ConsultaTablaMaterial303').hide();
            $('#overlay').remove();
            break;
        case "lot303":
            var ventana = $('#VentanaModalLote303');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "Centro":
            var ventana = $('#VentanaModalCentro303');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function findMat(material) {
    borrarmsg();
    acc = "cargarMaterial";
    var idoma = $('#idio303').val();
    var dataSend = "&v1=" + material + "&v2=" + idoma;
    var check;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (rs) {
            if (rs == "x") {
                var menCam = "No existen entradas para el material - " + material;
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(menCam);
            } else {
                $('#TCtxtB' + pos303).val(rs[0]);
                $('#TCtxtB' + pos303).prop('readonly', true);
                $('#TCumc' + pos303).val(rs[1]);
                $('#TCumc' + pos303).prop('readonly', true);
                check = getValSujLot(material);
                if (check == 0) {
                    $('#TClot' + pos303).prop('disabled', true);
                    $('#TClot' + pos303).val("");
                } else if (check == 1) {
                    $('#TClot' + pos303).prop('disabled', false);
                }
            }
        }
    });
}

function enableRow303(i) {
    var pos = $("input[name^='TCpos']");
    var mat = $("input[name^='TCmat']");
    var txb = $("input[name^='TCtxtB']");
    var ctd = $("input[name^='TCcant']");
    var um = $("input[name^='TCumc']");
    var lot = $("input[name^='TClot']");
    var cen = $("input[name^='TCcent']");
    pos[i].disabled = false;
    mat[i].disabled = false;
    txb[i].disabled = false;
    cen[i].disabled = false;
    ctd[i].disabled = false;
    um[i].disabled = false;
    lot[i].disabled = false;
}
function checkFirstRow303() {
    var divSeccionDatosRecibo = document.getElementById("Tabla303");
    var elemDatoRecibo = divSeccionDatosRecibo.getElementsByTagName("input");
    for (var j = 0; j < elemDatoRecibo.length; j++) {
        elemDatoRecibo[j].disabled = true;
    }
    enableRow303(0);
}

function checkRowEmpty303(i) {
    var mat = $("input[name^='TCmat']");
    var txt = $("input[name^='TCtxtB']");
    var ctd = $("input[name^='TCcant']");
    var um = $("input[name^='TCumc']");
    var lot = $("input[name^='TClot']");
    var cent = $("input[name^='TCcent']");
    var check = 0;
    if (mat[i].value.length < 1) {
        return 1;
    } else if (txt[i].value.length < 1) {
        return 2;
    } else if (ctd[i].value.length < 1) {
        return 3;
    } else if (um[i].value.length < 1) {
        return 4;
    } else if (lot[i].disabled == false) {
        if (lot[i].value.length < 1) {
            return 5;
        } else if (cent[i].value.length < 1) {
            return 6;
        }
    } else if (cent[i].value.length < 1) {
        return 6;
    }
    return check;
}
function checkRow303() {
    var rows = rowsOfTable('Tabla303');
    var pos = $("input[name^='TCpos']");
    var row;
    for (var i = 0; i < rows; i++) {
        if (pos[i].disabled == true) {
            enableRow303(i++);
            break;
        } else {
            row = checkRowEmpty303(i);
            if (row == 0) {
                row = checkRowDb303(i);
                if (row == 0) {

                } else {
                    seelctDbRow303(row, i);
                    return;
                }
            } else {
                selectCellEmpty(row, i);
                return;
            }
        }
    }
}
function validar303() {
    var rows = rowsOfTable('Tabla303');
    var pos = $("input[name^='TCpos']");
    var row;
    for (var i = 0; i < rows; i++) {
        if (pos[i].disabled == true) {
            insertar303();
            break;
        } else {
            row = checkRowEmpty303(i);
            if (row == 0) {
                row = checkRowDb303(i);
                if (row == 0) {

                } else {
                    seelctDbRow303(row, i);
                    return;
                }
            } else {
                selectCellEmpty(row, i);
                return;
            }
        }
    }
}
function insertar303() {
    var rows = rowsOfTable('Tabla303');
    var pos = document.getElementsByName('TCpos');
    var mat = document.getElementsByName('TCmat');
    var txt = document.getElementsByName('TCtxtB');
    var ctd = document.getElementsByName('TCcant');
    var um = document.getElementsByName('TCumc');
    var lot = document.getElementsByName('TClot');
    var cent = document.getElementsByName('TCcent');
    var centro = document.getElementById('bxCentro').value.toUpperCase();
    var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
    var movimiento = document.getElementById('bxClase').value;
    var clas = document.getElementById('bxClase').value;
    var numDoc = "";
    var posDoc = "";
    for (var i = 0; i < rows; i++) {
        if (pos[i].disabled == true) {
            ocultarVentana('VentanaModal303', 'btnAdd', 'm');
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Posiciones añadidas correctamente";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            break;
        } else {
            var extr = "&v1=" + mat[i].value + "&v2=" + ctd[i].value +
                    "&v3=" + um[i].value + "&v4=" + lot[i].value +
                    "&v5=" + txt[i].value + "&CDestino=" + cent[i].value +
                    "&v7=" + centro + "&clase=" + clas +
                    "&v8=" + i + "&v9=" + movimiento +
                    "&v10=" + numDoc + "&v11=" + posDoc;
            Tabla200('VentanaModal303', extr);
        }
    }
}
function seelctDbRow303(type, pos) {
    var mat = $("input[name^='TCmat']");
    var ctd = $("input[name^='TCcant']");
    var um = $("input[name^='TCumc']");
    var lot = $("input[name^='TClot']");
    var cent = $("input[name^='TCcent']");
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Material " + mat[pos].value + " no existente en el centro destino";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            mat[pos].focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Unidad de Medida " + um[pos].value + " no existente";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            um[pos].focus();
            break;
        case 3:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "El lote " + lot[pos].value + " no corresponde al material";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            lot[pos].focus();
            break;
        case 4:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Centro " + cent[pos].value + " invalido";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            cent[pos].focus();
            break;
        case 5:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Cantidad superada en inventario";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            ctd[pos].focus();
            break;
        case 6:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Material " + mat[pos].value + " no existente";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            mat[pos].focus();
            break;
    }
}
function checkRowDb303(i) {
    var mat = $("input[name^='TCmat']");
    var ctd = $("input[name^='TCcant']");
    var um = $("input[name^='TCumc']");
    var lot = $("input[name^='TClot']");
    var cent = $("input[name^='TCcent']");
    var alm = $("#bxAlmacen").val();
    var check = getExisMat303(mat[i].value);
    var sj = getValSujLot(mat[i].value);
    ValidaMaterialHabilitado(mat[i].value);
    if (habl === 0) {
        var iconm = document.getElementById("iconmsg");
        iconm.style.display = "inline";
        iconm.style.visibility = "visible";
        iconm.src = "images/advertencia.PNG";
        var men = document.getElementById("msg");
        men.innerHTML = "Material inhabilitado";
        mat[i].focus();
        return;
    }

    if (check == 0) {
        return 1;
    }
    check = getExisUMD(um[i].value);
    if (check == 0) {
        return 2;
    }

    check = getExisCent(cent[i].value);
    if (check == 0) {
        return 4;
    }
    check = getExisMtl(mat[i].value);
    if (check == 0) {
        return 6;
    }

    if (sj == 1) {
        check = getSujLoteTrue(mat[i].value, lot[i].value);
        if (check == 0) {
            return 3;
        }

        check = getStockLibreTrue(mat[i].value, alm, lot[i].value, ctd[i].value);
        if (check == 0) {
            return 5;
        }

        return 0;
    }
    return 0;
}
function getSujLoteTrue(mat, lot) {
    var type;
    var dataSend = "&v1=" + mat + "&v2=" + lot;
    var acc = "validarSujLote";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getStockLibreTrue(mat, alm, lot, ctd) {
    var type;
    var dataSend = "&v1=" + mat + "&v2=" + alm + "&v3=" + lot + "&v4=" + ctd;
    var acc = "validarStockLibre";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getValSujLot(mat) {
    var type;
    var dataSend = "&v1=" + mat;
    var acc = "checkSujLotV";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getExisMat(mat) {
    var type;
    var dataSend = "&v1=" + mat;
    var acc = "validarMate";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getExisMat303(mat) {
    var type;
    var dataSend = "&v1=" + mat;
    var acc = "validarMate303";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getExisCent(cent) {
    var type;
    var dataSend = "&v1=" + cent;
    var acc = "validarCent303";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getExisMtl(mat) {
    var type;
    var dataSend = "&v1=" + mat;
    var acc = "validarMtl303";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function getExisUMD(umd) {
    var type;
    var dataSend = "&umd=" + umd;
    var acc = "validarUMD";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}
function selectCellEmpty(type, pos) {
    var mat = $("input[name^='TCmat']");
    var txt = $("input[name^='TCtxtB']");
    var ctd = $("input[name^='TCcant']");
    var um = $("input[name^='TCumc']");
    var lot = $("input[name^='TClot']");
    var cent = $("input[name^='TCcent']");
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Material Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            mat[pos].focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Descripcion Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            txt[pos].focus();
            break;
        case 3:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Cantidad Obligatoria";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            ctd[pos].focus();
            break;
        case 4:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Unidad de medida Obligatoria";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            um[pos].focus();
            break;
        case 5:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Lote Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            lot[pos].focus();
            break;
        case 6:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Centro destino Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            cent[pos].focus();
            break;
    }
}
function deleteRow(tableID) {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    for (var i = 0; i < rowCount; i++) {
        try {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        } catch (e) {
        }
    }
    actualizarIds303();
}

function actualizarIds303() {
    var rows = (rowsOfTable("Tabla303") - 1);
    var mat = document.getElementsByName('TCmat');
    var txt = document.getElementsByName('TCtxtB');
    var ctd = document.getElementsByName('TCcant');
    var um = document.getElementsByName('TCumc');
    var lot = document.getElementsByName('TClot');
    var cent = document.getElementsByName('TCcent');
    var mMat = document.getElementsByName('match_TCmat');
    var mLot = document.getElementsByName('match_TClot');
    var mCent = document.getElementsByName('match_TCcent');
    {
        var SmatchMat = function (x) {
            BtnShowTC(x, 'match_TCmat');
        };
        var SmatchLot = function (x) {
            BtnShowTC(x, 'match_TClot');
        };
        var SmatchCent = function (x) {
            BtnShowTC(x, 'match_TCcent');
        };
        var matchMat = function (x) {
            match303mat(x);
        };
        var matchLot = function (x) {
            match303lot(x);
        };
        var matchCent = function (x) {
            match303cent(x);
        };
    }
    for (var d = 0; d < rows; d++) {

        try {

            mat[(d)].setAttribute('id', 'TCmat' + d);
            mat[(d)].addEventListener('focus', SmatchMat.bind(this, d));
            txt[(d)].setAttribute('id', 'TCtxtB' + d);
            ctd[(d)].setAttribute('id', 'TCcant' + d);
            um[(d)].setAttribute('id', 'TCumc' + d);
            lot[(d)].setAttribute('id', 'TClot' + d);
            lot[(d)].addEventListener('focus', SmatchLot.bind(this, d));
            cent[(d)].setAttribute('id', 'TCcent' + d);
            cent[(d)].addEventListener('focus', SmatchCent.bind(this, d));
            mMat[(d)].setAttribute('id', 'match_TCmat' + d);
            mMat[(d)].addEventListener('click', matchMat.bind(this, d));
            mLot[(d)].setAttribute('id', 'match_TClot' + d);
            mLot[(d)].addEventListener('click', matchLot.bind(this, d));
            mCent[(d)].setAttribute('id', 'match_TCcent' + d);
            mCent[(d)].addEventListener('click', matchCent.bind(this, d));
        } catch (e) {
        }
    }
}

function matVen300(ind)
{
    $('#BuscarParamStockT').show();
    $('#ConsultaTablaStockT').hide();
    LimpiarPantalla('VentanaModalStockT');
    mostrarVentana('VentanaModalStockT');
    document.getElementById('bxTxtS').focus();
    document.getElementById('idxM').value = ind;
    var theHandle = document.getElementById('handle21');
    var theRoot = document.getElementById('VentanaModalStockT');
    Drag.init(theHandle, theRoot);
}





///////////////////////////// MODAL CALIDAD PET

function cargarCabeceraCalidad(material) {
    var centro = $("#bxCentro").val();
    acc = "cargarCabMate";
    var folLotIns = parseInt(getQMactual());


    $.ajax({
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&v1=" + material,
        success: function (rs) {
            $("#numInsp").html(usuario);
            $("#lblCtrC").html(centro.toUpperCase());
            $("#bxMatC").val(rs[0]);
            $('#bxMatC').prop("readonly", true);
            $("#lblMatC").html(rs[1]);
            $("#bxLoteInspCal").val(folLotIns);
            $('#bxLoteInspCal').prop("readonly", true);

        }
    });
}
function showMatch(id) {
    $('#' + id).show();
}
function hideMatch(id) {
    setTimeout(function () {
        $('#' + id).hide();
    }, 200);
}
function openWinClsInf() {
    mostrarVentana('VentanaModalClsInf');
    acc = "consultarClsInf";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (rs) {
            $("#cargarDatosClsInf").html(rs);
        }
    });
}
function consultarClsInf() {
    var cls = $("#bxClsInf");
    if (cls.val().length < 1) {

    } else {
        acc = "cargarDataClsInf";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: "json",
            url: 'PeticionMovMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&v1=" + cls.val(),
            success: function (rs) {
                if (rs[0] == "x") {
                    $("#bxPerfilC").val("");
                    $("#lblClsInf").html("");
                    $("#lblPerCat").html("");
                } else {
                    $("#bxClsInf").prop("readonly", true);
                    $("#bxPerfilC").val(rs[3]);
                    $("#bxPerfilC").prop("readonly", true);
                    $("#lblClsInf").html(rs[1]);
                    $("#lblPerCat").html(rs[2]);
                }
            }
        });
    }

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
            $("#catInsCod").html(catGpo);
            $("#conjInsCod").html(gpoCod);
            $("#gpoCodInsCod").html(rs);
            cargarDataCodInd(pos, gpoCod);
        }
    });
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
            }
        }
    });
}
function selectMatchCod(type, pos, data) {
    switch (type) {
        case 'codInsp':
            $("#bxCod" + pos).val(data);
            ocultarVentana('VentanaModalInspCod', '');
            break;
    }
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
    guardarPosLotIns();
    guardarCabLotInsp();
    $("#btnGrabarR").prop("disabled", true);
    $("#SecCuerpoCld").find(":text").prop('disabled', true);

}
function selectRowDbResult(type, pos) {
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Codigo invalido";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            $("#bxCod" + pos).focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Cantidad no valida";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            $("#bxcld6" + pos).focus();
            break;


    }
}


function checkRowDbResul(pos) {
    if (!$("#bxCod" + pos).prop('disabled')) {
        var check = getCodigoTrue($("#bxCod" + pos).val(), $("#bxCodn" + pos).val());
        if (check == 0) {
            return 1;
        }
    } else {
        var insp = parseInt($("#bxcld6" + pos).val());
        var aInsp = parseFloat($('#cld5' + pos).text());
        if (!(insp <= aInsp)) {
            return 2;
        }
        return 0;
    }
    return 0;
}
function selectRowEmptyResul(type, pos) {
    switch (type) {
        case 1:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            $("#bxcld6" + pos).focus();
            break;
        case 2:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            $("#bxcld7" + pos).focus();
            break;
        case 3:
            var ven = document.getElementById('VentanaModalAv');
            var msg = "Campo Obligatorio";
            abrirVentanaAv(ven, msg);
            var theHandle = document.getElementById('handleAV');
            var theRoot = document.getElementById('VentanaModalAv');
            Drag.init(theHandle, theRoot);
            $("#bxCod" + pos).focus();
            break;
//        case 4:
//            var ven = document.getElementById('VentanaModalAv');
//            var msg = "Campo Obligatorio";
//            abrirVentanaAv(ven, msg);
////            $("#cld12" + pos).focus();
//            break;
    }
}
function checkRowEmptyResul(i) {
    var cual = $('#cldn' + i).text();
    var check = 0;
    if (cual == "1") {
        if ($("#bxcld7" + i).val().length < 1) {
            check = 2;
        }
//        else if ($("#cld12" + i).val().length < 1) {
//            check = 4;
//        }
    } else if (cual == "2") {
        if ($("#bxCod" + i).val().length < 1) {
            check = 3;
        }
    } else if (cual == "3") {
        if ($("#bxcld6" + i).val().length < 1) {
            check = 1;
        } else if ($("#bxcld7" + i).val().length < 1) {
            check = 2;
        }
    }
    return check;
}
function bloquearCamposResul() {
    $("[id*=bxcld7]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9-.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("[id*=bxcld6]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9-]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
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
var rowCabLot = 0;
var rowPosLot = 0;
function guardarCabLotInsp() {

    var x = rowCabLot;
    var fol = $('#bxLoteInspCal').val();
    var mat = $('#bxMatC').val();
    var txtBm = $('#lblMatC').text();
    var numDocC = $('#bxDocComC').val();
    var centro = $('#lblCtrC').text();
    $("#TLIfol" + rowCabLot).val(fol);
    $("#TLImat" + rowCabLot).val(mat);
    $("#TLItxtB" + rowCabLot).val(txtBm);
    $("#TLInumD" + rowCabLot).val(numDocC);
    $("#TLIcent" + rowCabLot).val(centro);
    $("#TLIuser" + rowCabLot).val(usuario);
    rowCabLot++;
}
var lastFol;
function insertarCabLotInsp() {
    var acc = "insertarCabCalidad";
    var rows = rowsOfTable('tablaPosLotIns');
    try {
        for (var i = 0; i < (rows - 1); i++) {
            if ($('#TLIfol' + i).val().length < 1) {
                var iconm = document.getElementById("iconmsg");
                iconm.style.display = "inline";
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = "Se han grabado los resultados para la operación 0010";
                break;
            } else {
                var fol = $('#TLIfol' + i).val();
                var mat = $('#TLImat' + i).val();
                var txtBm = $('#TLItxtB' + i).val();
                var numDocC = $('#TLInumD' + i).val();
                var centro = $('#TLIcent' + i).val();

                var dataSend = "&fol=" + fol
                        + "&mat=" + mat
                        + "&txtb=" + txtBm
                        + "&nDoc=" + numDocC
                        + "&cent=" + centro
                        + "&us=" + usuario;

                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'MovimientosCalidad',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "action=" + acc + dataSend,
                    success: function (data) {
                    }
                });
            }

        }
    } catch (e) {
//        alert(e);
    }



}
function checkUndefined(val) {
    if (val === 'undefined' || val === undefined) {
        val = "";
    }
    return val;
}
function guardarPosLotIns() {
    var rows = rowsOfTable('TabBody2');
    var folLotIns = $('#bxLoteInspCal').val();
    try {
        for (var i = 0; i < (rows - 1); i++) {
            var nC = $('#cld1' + i).text();
            var tC = $('#cld2' + i).text();
            var desC = $('#cld3' + i).text();
            var cual = $('#cld4' + i).text();
            var tam = $('#cld5' + i).text();
            var numU = $('#bxcld6' + i).val();
            var val = $('#bxcld7' + i).val();
            var cod = $('#bxCod' + i).val();
            var unM = $('#cld6' + i).text();
            var txt = $('#cld12' + i).val();
            var cat = $('#cld13' + i).text();
            $("#TLIPfol" + rowPosLot).val(folLotIns);
            $("#TLIPnumCaract" + rowPosLot).val(nC);
            $("#TLIPtxtBCarInsp" + rowPosLot).val(tC);
            $("#TLIPdesBConj" + rowPosLot).val(desC);
            $("#TLIPentCat" + rowPosLot).val(cual);
            $("#TLIPtamMues" + rowPosLot).val(tam);
            $("#TLIPnumUn" + rowPosLot).val(numU);
            $("#TLIPvalOrg" + rowPosLot).val(val);
            $("#TLIPcod" + rowPosLot).val(cod);
            $("#TLIPundMe" + rowPosLot).val(unM);
            $("#TLIPtxtB" + rowPosLot).val(txt);
            $("#TLIPcatal" + rowPosLot).val(cat);
            $("#TLIPuser" + rowPosLot).val(usuario);
            rowPosLot++;
        }
    } catch (e) {
//        alert(e);
    }
}
function insertarPosLotIns() {
    var acc = "insertarPosMatCalidad";
    var rows = rowsOfTable('tablaPosLotIns');

    try {
        for (var i = 0; i < (rows - 1); i++) {
            if ($('#TLIPfol' + i).val().length < 1) {
                break;
            } else {
                var fol = $('#TLIPfol' + i).val();
                var nC = $('#TLIPnumCaract' + i).val();
                var tC = $('#TLIPtxtBCarInsp' + i).val();
                var desC = $('#TLIPdesBConj' + i).val();
                var cual = $('#TLIPentCat' + i).val();
                var tam = $('#TLIPtamMues' + i).val();
                var numU = $('#TLIPnumUn' + i).val();
                var val = $('#TLIPvalOrg' + i).val();
                var cod = $('#TLIPcod' + i).val();
                var unM = $('#TLIPundMe' + i).val();
                var txt = $('#TLIPtxtB' + i).val();
                var cat = $('#TLIPcatal' + i).val();
                var dataSend = "&fol=" + fol
                        + "&numC=" + nC
                        + "&txtCt=" + tC
                        + "&desB=" + desC
                        + "&entC=" + cual
                        + "&tamMs=" + tam
                        + "&numU=" + numU
                        + "&valOg=" + checkUndefined(val)
                        + "&cod=" + cod
                        + "&undM=" + unM
                        + "&txtb=" + txt
                        + "&catl=" + cat
                        + "&us=" + usuario;
                lastFol = fol;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'MovimientosCalidad',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "action=" + acc + dataSend,
                    success: function (data) {
                    }
                });
            }

        }
    } catch (e) {
//        alert(e);
    }
}
function updateFolioQM() {
    var acc = "ActualizarFolioQM";

    $.ajax({
        async: false,
        type: 'GET',
        url: 'MovimientosCalidad',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=" + acc + "&fol=" + lastFol,
        success: function (data) {
        }
    });
}
function almacenDestino311() {
    var mov = $("#bxClase").val();
    if (mov === "311") {
        var almDes = document.getElementsByName('mmalm');
        if (almDes.length > 0) {
            $("#bxAlmacen311").val(almDes[0].textContent);
            $('#bxAlmacen311').css('background-image', 'none');
            $('#btnAlmacen311').hide();
            $('#bxAlmacen311').prop('disabled', true);
        } else {
            $("#bxAlmacen311").val("");
            $('#bxAlmacen311').prop('disabled', false);
        }
    }
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
    $('#FecEntrega').focus();
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
function MostrarMatch(id, match, pos) {
    QuitarMatch();
    var cm = $('#bxClase').val();
    $('#' + cm + id + pos).css('width', '80%');
    $('#' + cm + match + pos).css('display', 'inline-block');
    if (id == 'tdMater') {
        $('#' + cm + id + pos).keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (tecla == 13) {
                if ($('#' + cm + id + pos).val().length > 0) {
                    if (cm == "315") {
                        GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
                    }
                    if (cm == "301") {
                        GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
                    }
                    if (cm == "313") {
                        GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
                    }
                    if (cm == "311") {
                        GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
                    }
                }
            }
            patron = /[0-9a-zA-ZÑñ]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        });
        $('#' + cm + id + pos).blur(function () {
            if ($('#' + cm + id + pos).val().length > 0) {
                if (cm == "315") {
                    GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
//                    ObtenerStockTransferencia($('#' + cm + id + pos).val(), cm, pos);
                } else {
                    if (ValidarSujLoteNuevo($('#' + cm + id + pos).val(), cm) == 0) {
                        $('#' + cm + "tdLotes" + pos).val("");
                        $('#' + cm + "tdLotes" + pos).prop('disabled', true);
                    } else {
                        $('#' + cm + "tdLotes" + pos).prop('disabled', false);
                        $('#' + cm + "tdLotes" + pos).prop('disabled', false);
                    }
                    GetinfoMat($('#' + cm + id + pos).val(), cm, pos);
                }
            } else {
                $('#' + clm + "tdDescr" + pos).val("");
                $('#' + clm + "tdUmedi" + pos).val("");
                if (cm != "315") {
                    $('#' + cm + "tdLotes" + pos).prop('disabled', false);
                }
            }
        });
    }
}
function QuitarMatch() {
    clm = $('#bxClase').val();
    var inMat = document.getElementsByName(clm + "MaterTD");
    var inlot = document.getElementsByName(clm + "LotesTD");
    var inCen = document.getElementsByName(clm + "CentrTD");
    var inalm = document.getElementsByName(clm + "AlmacTD");
    var matchMat = document.getElementsByName(clm + 'matchMaterial');
    var matchlot = document.getElementsByName(clm + 'matchLote');
    var matchCen = document.getElementsByName(clm + 'matchCen');
    var matchAlm = document.getElementsByName(clm + 'matchAlma');

    for (i = 0; i < inMat.length; i++) {
        inMat[i].style.width = '100%';
    }
    for (i = 0; i < inlot.length; i++) {
        inlot[i].style.width = '100%';
    }
    for (i = 0; i < inCen.length; i++) {
        inCen[i].style.width = '100%';
    }
    for (i = 0; i < inalm.length; i++) {
        inalm[i].style.width = '100%';
    }
    for (i = 0; i < matchMat.length; i++) {
        matchMat[i].style.display = 'none';
    }
    for (i = 0; i < matchlot.length; i++) {
        matchlot[i].style.display = 'none';
    }
    for (i = 0; i < matchCen.length; i++) {
        matchCen[i].style.display = 'none';
    }
    for (i = 0; i < matchAlm.length; i++) {
        matchAlm[i].style.display = 'none';
    }
}
function AbrirMatchElemtnosGrid(VM, handle, bp, ct, pos, bus1, bus2, bus3) {
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
    $('#' + bp).css('display', 'block');
    $('#' + ct).css('display', 'none');
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(VM);
    Drag.init(theHandle, theRoot);
    $('#posGrid').val(pos);
    $('#' + bus3).val('500');
    $('#' + bus1).val('');
    $('#' + bus2).val('');
    $('#' + bus1).focus();

}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ConsultaMaterialesNBuevo() {
    var acc = "ConsultaMaterial";
    var datos = "&Material=" + $('#busMatNuevo').val()
            + "&Descripcion=" + encodeURIComponent($('#BusDesMatNuevo').val().trim())
            + "&Cantidad=" + $('#numAciertosNuevo').val()
            + "&ClaseMov=" + $('#bxClase').val() + "&Centro=" + $('#bxCentro').val() + "&Almacen=" + $('#bxAlmacen').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosMaterialNuevo').html(data);
                $('#BuscarParaMaterialNuevo').css('display', 'none');
                $('#ConsultaTablaMaterialNuevo').css('display', 'block');
                document.getElementById('table-scrollMaterialNuevo').onscroll = function () {
                    document.getElementById('fixedYMaterialNuevo').style.top = document.getElementById('table-scrollMaterialNuevo').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ocultarVentanaNuevo(id, bp, ct, obj, clm)
{
    var pos = $('#posGrid').val();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    if (bp != "0") {
        $('#' + bp).css('display', 'block');
        $('#' + ct).css('display', 'none');
    }
    var campo = clm + obj + pos;
    $('#' + campo).focus();

}
function seleccionarMCNuevo(mat, descr, um, clm) {
    var pos = $('#posGrid').val();
//    if (clm == "315") {
//        //ObtenerStockTransferencia(mat, clm, pos);
//    } else {
    $('#' + clm + 'tdMater' + pos).val(mat);
    $('#' + clm + 'tdDescr' + pos).val(descr);
    $('#' + clm + 'tdUmedi' + pos).val(um);
    ocultarVentanaNuevo('VentanaModalMaterialNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', 'tdMater', clm);
}
function seleccionarMCLoteNuevo(lote, doc, posidoc, clm, can) {
    if (clm == "NADA") {//Poner "311" si se quiere regresar a la pantalla que antes se tenia del mov. 311
        $('#bxLote311').val(lote);
        $('#bxDoc311').val(doc);
        $('#bxDocPos311').val(posidoc);
        ocultarVentanaNuevo('VentanaModalLoteStockE', '', '', '', clm);
        $('#bxLote311').focus();
    } else if (clm == "261" || clm == "262") {
        $('#bxLote261').val(lote);
        $('#bxDocLote261').val(doc);
        $('#bxDocPosLote261').val(posidoc);
        $('#bxLote261').focus();
        ocultarVentanaNuevo('VentanaModalLoteStockE', '', '', '', clm);

    } else if (clm == "315") {
        var pos = $('#posGrid').val();
        $('#' + clm + 'tdLotes' + pos).val(lote);
        $('#' + clm + 'tdCanti' + pos).val(can);
        $('#' + clm + 'tdDoc' + pos).val(doc);
        $('#' + clm + 'tdPos' + pos).val(posidoc);
        ocultarVentanaNuevo('VentanaModalLoteStockE', '', '', 'tdCanti', clm);
    } else {
        var pos = $('#posGrid').val();
        $('#' + clm + 'tdLotes' + pos).val(lote);
        $('#' + clm + 'tdDoc' + pos).val(doc);
        $('#' + clm + 'tdPos' + pos).val(posidoc);
        ocultarVentanaNuevo('VentanaModalLoteStockE', '', '', 'tdLotes', clm);
    }
}
function seleccionarMCAlmNuevo(alm, clm) {
    var pos = $('#posGrid').val();
    $('#' + clm + 'tdAlmac' + pos).val(alm);
    ocultarVentanaNuevo('VentanaModalAlmacenDesNuevo', '', '', 'tdAlmac', clm);
}
function seleccionarMCCentroNuevo(cen, clm) {
    var pos = $('#posGrid').val();
    $('#' + clm + 'tdCentr' + pos).val(cen);
    ocultarVentanaNuevo('VentanaModalCentroDesNuevo', '', '', 'tdCentr', clm);
}
function ConsultaLotesNBuevo(pos) {
    $('#posGrid').val(pos);
    var clm = $('#bxClase').val();
    var acc = "ConsultaLotes";
    switch (clm) {
        case "261":
        case "262":
            if ($('#bxMaterial261').val().trim().length == 0) {
                $('#bxMaterial261').focus();
                mensajesNuevo(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                var datos = "&Material=" + $('#bxMaterial261').val()
                        + "&Centro=" + $('#bxCentro').val()
                        + "&Almacen=" + $('#bxAlmacen').val()
                        + "&ClaseMov=" + clm;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'peticionMovMateriales2',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Accion=" + acc + datos,
                    success: function (data) {
                        if (data == 0) {
                            mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
                        } else {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapsnd05.wav";
                            BE.play();
                            var ventana = $('#VentanaModalLoteStockE');
                            var ancho = 600;
                            var alto = 650;
                            var x = (screen.width / 2) - (ancho / 2);
                            var y = (screen.height / 2) - (alto / 2);
                            ventana.css({top: y + "px", left: x + "px"});
                            ventana.css('display', 'block');
                            borramsg();
                            var theHandle = document.getElementById("handleLotStockE");
                            var theRoot = document.getElementById("VentanaModalLoteStockE");
                            Drag.init(theHandle, theRoot);
                            $('#cargarDatosLoteStockE').html(data);
                            document.getElementById('table-scrollLotStokE').onscroll = function () {
                                document.getElementById('fixedYLoteE').style.top = document.getElementById('table-scrollLotStokE').scrollTop + 'px';
                            };
                        }
                    }
                });
            }
            break;
//        case "311":
        case "NADA"://Quitar este case si se quiere regresar a la validacion anterior del 311
            if ($('#bxMaterial311').val().trim().length == 0) {
                $('#bxMaterial311').focus();
                mensajesNuevo(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                var datos = "&Material=" + $('#bxMaterial311').val()
                        + "&Centro=" + $('#bxCentro').val()
                        + "&Almacen=" + $('#bxAlmacen').val()
                        + "&ClaseMov=" + clm;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'peticionMovMateriales2',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Accion=" + acc + datos,
                    success: function (data) {
                        if (data == 0) {
                            mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
                        } else {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapsnd05.wav";
                            BE.play();
                            var ventana = $('#VentanaModalLoteStockE');
                            var ancho = 600;
                            var alto = 650;
                            var x = (screen.width / 2) - (ancho / 2);
                            var y = (screen.height / 2) - (alto / 2);
                            ventana.css({top: y + "px", left: x + "px"});
                            ventana.css('display', 'block');
                            borramsg();
                            var theHandle = document.getElementById("handleLotStockE");
                            var theRoot = document.getElementById("VentanaModalLoteStockE");
                            Drag.init(theHandle, theRoot);
                            $('#cargarDatosLoteStockE').html(data);
                            document.getElementById('table-scrollLotStokE').onscroll = function () {
                                document.getElementById('fixedYLoteE').style.top = document.getElementById('table-scrollLotStokE').scrollTop + 'px';
                            };
                        }
                    }
                });
            }
            break;
        case "301":
        case "311":
        case "313":
        case "315":
            var mater = $('#' + clm + 'tdMater' + pos);
            if (mater.val().length == 0) {
                mater.focus();
                mensajesNuevo(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                var acc = "ConsultaLotes";
                var datos = "&Material=" + $('#' + clm + 'tdMater' + pos).val()
                        + "&Centro=" + $('#bxCentro').val()
                        + "&Almacen=" + $('#bxAlmacen').val()
                        + "&ClaseMov=" + clm;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'peticionMovMateriales2',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Accion=" + acc + datos,
                    success: function (data) {
                        if (data == 0) {
                            mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
                        } else {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapsnd05.wav";
                            BE.play();
                            var ventana = $('#VentanaModalLoteStockE');
                            var ancho = 600;
                            var alto = 650;
                            var x = (screen.width / 2) - (ancho / 2);
                            var y = (screen.height / 2) - (alto / 2);
                            ventana.css({top: y + "px", left: x + "px"});
                            ventana.css('display', 'block');
                            borramsg();
                            var theHandle = document.getElementById("handleLotStockE");
                            var theRoot = document.getElementById("VentanaModalLoteStockE");
                            Drag.init(theHandle, theRoot);
                            $('#cargarDatosLoteStockE').html(data);
                            document.getElementById('table-scrollLotStokE').onscroll = function () {
                                document.getElementById('fixedYLoteE').style.top = document.getElementById('table-scrollLotStokE').scrollTop + 'px';
                            };
                        }
                    }
                });
            }
            break;
    }
}
function ConsultaAlmaNBuevo(pos) {
    $('#posGrid').val(pos);
    var clm = $('#bxClase').val();
    var cen = $('#bxCentro').val();
    var acc = "ConsultaAlmacen";
    var datos = "&ClaseMov=" + clm + "&Centro=" + cen;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                var ventana = $('#VentanaModalAlmacenDesNuevo');
                var ancho = 600;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                borramsg();
                var theHandle = document.getElementById("handleAlmDes");
                var theRoot = document.getElementById("VentanaModalAlmacenDesNuevo");
                Drag.init(theHandle, theRoot);
                $('#cargarDatosAlmacenDesNuevo').html(data);
                document.getElementById('table-scrollAlmacenDesnuevo').onscroll = function () {
                    document.getElementById('fixedYAlmacenDesNuevo').style.top = document.getElementById('table-scrollAlmacenDesnuevo').scrollTop + 'px';
                };
            }
        }
    });
}
function ConsultaCentroNuevo(pos) {
    $('#posGrid').val(pos);
    var clm = $('#bxClase').val();
    var acc = "ConsultaCentro";
    var datos = "&ClaseMov=" + clm;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                var ventana = $('#VentanaModalCentroDesNuevo');
                var ancho = 600;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                borramsg();
                var theHandle = document.getElementById("handleCentDes");
                var theRoot = document.getElementById("VentanaModalCentroDesNuevo");
                Drag.init(theHandle, theRoot);
                $('#cargarDatosCentroDesNuevo').html(data);
                document.getElementById('table-scrollCenDesuevo').onscroll = function () {
                    document.getElementById('fixedYCenDesNuevo').style.top = document.getElementById('table-scrollCenDesuevo').scrollTop + 'px';
                };
            }
        }
    });
}
function CargarTablaMovss() {
    var centro = $('#bxCentro').val();
    var clm = $('#bxClase').val();
    var acc = "CargarTablaMovs";
    var datos = "&Centro=" + centro + "&ClaseMov=" + clm;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            $('#SecCuerpo301').html(data);
        }
    });
}
function AgregarFilasTabla301() {
    var Ctro = "";
    var Value = "";
    var dis = "";
    var dis2 = "";
    var dis3 = "";
    $('#TempRod').remove();
    var ClaseM = $('#bxClase').val().trim();
    var Centro = $('#bxCentro').val().trim();
    var nam12 = ClaseM + 'chkbox';
    var ch = document.getElementsByName(nam12);
    var valor = ch[ch.length - 1].value;
    var i = parseInt(valor) + 1;
    if (ClaseM === "301") {
        Value = "1800";
        dis = "disabled";
    }
    if (ClaseM === "311") {
        dis2 = "disabled";
        Ctro = Centro;
    }
    if (ClaseM === "313") {
        Ctro = Centro;
        dis2 = "disabled";
    }
    if (ClaseM === "315") {
        dis = "disabled";
        dis2 = "disabled";
        dis3 = "";
    }
    var newfiladata
            = "<tr>"
            + "<td><input type=\"checkbox\" name=\"" + ClaseM + "chkbox\" value=\"" + i + "\"/></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdMater" + i + "\" name=\"" + ClaseM + "MaterTD\" onfocus=\"MostrarMatch('tdMater', 'MCMaterial', '" + i + "')\" maxlength=\"40\" style=\"text-transform: uppercase\"/><button id=\"" + ClaseM + "MCMaterial" + i + "\" onclick=\"AbrirMatchElemtnosGrid('VentanaModalMaterialNuevo', 'handleMatNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', '" + i + "', 'busMatNuevo', 'BusDesMatNuevo', 'numAciertosNuevo')\" name=\"" + ClaseM + "matchMaterial\" class='BtnMatchIconGrid'></button></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdDescr" + i + "\" name=\"" + ClaseM + "DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdUmedi" + i + "\" name=\"" + ClaseM + "UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdCanti" + i + "\" name=\"" + ClaseM + "CantiTD\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdLotes" + i + "\" name=\"" + ClaseM + "LotesTD\" onfocus=\"MostrarMatch('tdLotes', 'MCLote', '" + i + "')\" maxlength=\"10\" style=\"text-transform: uppercase\" " + dis3 + "/><input hidden type=\"text\" id=\"" + ClaseM + "tdDoc" + i + "\" name=\"" + ClaseM + "DocTD\"/><input hidden type=\"text\" id=\"" + ClaseM + "tdPos" + i + "\" name=\"" + ClaseM + "PosTD\"/><button id=\"" + ClaseM + "MCLote" + i + "\" onclick=\"ConsultaLotesNBuevo('" + i + "');\" name=\"" + ClaseM + "matchLote\" class='BtnMatchIconGrid'></button></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdCentr" + i + "\" name=\"" + ClaseM + "CentrTD\" onfocus=\"MostrarMatch('tdCentr', 'MCCen', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Ctro + "\" " + dis2 + "/><button id=\"" + ClaseM + "MCCen" + i + "\" onclick=\"ConsultaCentroNuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdAlmac" + i + "\" name=\"" + ClaseM + "AlmacTD\" onfocus=\"MostrarMatch('tdAlmac', 'MCAlm', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Value + "\" " + dis + "/><button id=\"" + ClaseM + "MCAlm" + i + "\" onclick=\"ConsultaAlmaNBuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>"
            + "</tr>";
    var tempro = "<tr id=\"TempRod\" class=\"ocultar\"><td>0000</td><td>000000000000000</td><td>000000000000000000000000000000</td><td>0000000</td><td>00000000000000</td><td>000000000000000</td><td>00000000000000000</td><td>0000000000000000</td></tr>";
    $('#TabBody301').append(newfiladata);
    $('#TabBody301').append(tempro);
    loadDoubleScroll("DobleSection301", "SecCuerpo301", "DobleContainer301", "TabBody301");
}
function EliminarFilas301() {
    var table = document.getElementById("TabBody301");
    var ClaseM = $('#bxClase').val().trim();
    var nam12 = ClaseM + 'chkbox';
    var chk = document.getElementsByName(nam12);
    var tam = chk.length;
    var i = tam;
    while (i >= 0) {
        if (i == 0) {
            break;
        } else {
            var o = parseInt(i) - 1;
            if (chk[o].checked)
            {
                table.deleteRow(o);
                i--;
            } else {
                i--;
            }

        }
    }
}
function Validarmovis() {
    var ClaseM = $('#bxClase').val().trim();
    var Centro = $('#bxCentro').val().trim();
    var Almace = $('#bxAlmacen').val().trim();
    var Materi = document.getElementsByName(ClaseM + 'MaterTD');
    var Descri = document.getElementsByName(ClaseM + 'DesciTD');
    var UnidMe = document.getElementsByName(ClaseM + 'UMediTD');
    var Lote = document.getElementsByName(ClaseM + 'LotesTD');
    var Canti = document.getElementsByName(ClaseM + 'CantiTD');
    var Centr = document.getElementsByName(ClaseM + 'CentrTD');
    var Almac = document.getElementsByName(ClaseM + 'AlmacTD');
    var Docum = document.getElementsByName(ClaseM + 'DocTD');
    var Posic = document.getElementsByName(ClaseM + 'PosTD');
    var Centgrid = document.getElementsByName('mmCentro');
    var Almgrid = document.getElementsByName('mmAlmace');
//    switch (ClaseM) {
//        case "301":
    var lon = 0;
    for (i = 0; i < Materi.length; i++) {
        if (Materi[i].value.length != 0) {
            lon = lon + 1;
        }
        if (lon == 0) {
            mensajesNuevo(2, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        for (j = 0; j < Almac.length; j++) {
            if (Almac[i].value.length > 0) {
                if (Almac[j].value.length > 0) {
                    if (Almac[i].value !== Almac[j].value) {
                        mensajesNuevo(16, "images/advertencia.PNG", "audio/saperror.wav");
                        return;
                    }
                }
            }
        }
        if (Materi[i].value.length > 0) {
            if (ClaseM == "315") {
                if (Canti[i].value.length == 0 || Canti[i].value == '0.000') {
                    mensajesNuevo(5, "images/advertencia.PNG", "audio/saperror.wav");
                    Canti[i].focus();
                    return;
                }
                if (Lote[i].value.length == 0) {
                    mensajesNuevo(14, "images/advertencia.PNG", "audio/saperror.wav");
                    Lote[i].focus();
                    return;
                }
                if (validarCantiExcedida(Materi[i].value, Centro, Almace, Lote[i].value, Canti[i].value, Docum[i].value, Posic[i].value)) {
                    mensajesNuevo(8, "images/advertencia.PNG", "audio/saperror.wav");
                    Canti[i].focus();
                    return;
                }
            } else {
                if (Almac[i].value === Almace) {
                    mensajesNuevo(15, "images/advertencia.PNG", "audio/saperror.wav");
                    Almac[i].focus();
                    return;
                }
                if (Canti[i].value.length == 0 || Canti[i].value == '0.000') {
                    mensajesNuevo(5, "images/advertencia.PNG", "audio/saperror.wav");
                    Canti[i].focus();
                    return;
                }
                if (ValidarSujLoteNuevo(Materi[i].value, ClaseM) == 1 && Lote[i].value.length == 0) {
                    mensajesNuevo(4, "images/advertencia.PNG", "audio/saperror.wav");
                    Lote[i].focus();
                    return;
                }
                if (ClaseM === "301") {
                    if (Centr[i].value.length == 0) {
                        mensajesNuevo(6, "images/advertencia.PNG", "audio/saperror.wav");
                        Centr[i].focus();
                        return;
                    }
                    if (Centr[i].value === Centro) {
                        mensajesNuevo(13, "images/advertencia.PNG", "audio/saperror.wav");
                        Centr[i].focus();
                        return;
                    }
                }
                if (ClaseM === "313") {
                    if (Almac[i].value.length == 0) {
                        mensajesNuevo(9, "images/advertencia.PNG", "audio/saperror.wav");
                        Almac[i].focus();
                        return;
                    }

                    if (Almgrid.length > 0) {
                        if (Almgrid[Almgrid.length - 1].textContent !== Almac[i].value) {
                            mensajesNuevo(16, "images/advertencia.PNG", "audio/saperror.wav");
                            Almac[i].focus();
                            return;
                        }
                    }

                }
                var resu = ValidarExistenciasMatenuevo(Materi[i].value, Centro, Almace, Lote[i].value.trim(), Docum[i].value.trim(), Posic[i].value.trim(), Canti[i].value.trim(), ClaseM);
                if (resu == 0) {
                    mensajesNuevo(7, "images/advertencia.PNG", "audio/saperror.wav");
                    Canti[i].focus();
                    return;
                }
                if (resu == 1) {
                    mensajesNuevo(8, "images/advertencia.PNG", "audio/saperror.wav");
                    Canti[i].focus();
                    return;
                }
                if (ValidamaterialDes(Materi[i].value, Centr[i].value, Almac[i].value, ClaseM) == 0) {
                    mensajesNuevo(11, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
            }
        }
    }
    ShowMsg(1, "images/load.gif", "audio/sapmsg.wav");
    $('#guardar').prop("disabled", true);
    setTimeout(function () {
        GuardarTempMovs();
    }, 4000);
}
function GetinfoMat(mat, clm, pos) {
    var acc = "CargarInfoMaterial";
    var datos = "&Material=" + mat + "&ClaseMov=" + clm;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                $('#' + clm + "tdMater" + pos).val("");
                $('#' + clm + "tdDescr" + pos).val("");
                $('#' + clm + "tdUmedi" + pos).val("");
                $('#' + clm + "tdMater" + pos).focus();
                mensajesNuevo(3, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#' + clm + "tdDescr" + pos).val(data[1]);
                $('#' + clm + "tdUmedi" + pos).val(data[2]);
            }
        }
    });
}
function ValidarSujLoteNuevo(mat, clm) {
    var rt = 0;
    var acc = "ValidarSujetoLote";
    var datos = "&Material=" + mat + "&ClaseMov=" + clm;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 1) {
                rt = 1;
            }
        }
    });
    return rt;

}
function ValidarExistenciasMatenuevo(mat, cen, alm, lot, doc, pos, can, clm) {
    var res = 0;
    var acc = "ValidarExistencia";
    var datos = "&Material=" + mat + "&ClaseMov=" + clm
            + "&Centro=" + cen + "&Almacen=" + alm
            + "&Lote=" + lot + "&Documento=" + doc
            + "&Posicion=" + pos + "&CantidadGrid=" + can;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data != 0) {
                var v1 = parseFloat(can);
                var v2 = parseFloat(data);
                if (v1 > v2) {
                    res = 1;
                } else {
                    res = 2;
                }
            }
        }
    });
    return res;
}
function ValidamaterialDes(mat, cen, alm, clm) {
    var rt = 0;
    var acc = "ExistenciaDestino";
    var datos = "&Material=" + mat + "&ClaseMov=" + clm
            + "&Centro=" + cen + "&Almacen=" + alm;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 1) {
                rt = 1;
            }
        }
    });
    return rt;

}
function InserMovsNuevosTemp(action, extras)
{
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + action + extras,
        success: function (data) {
            $('#SecTabPpal').html(data);
        }
    });
}
function ObtenerStockTransferencia(mat, clm, pos) {
    var centro = $('#bxCentro').val();
    var almace = $('#bxAlmacen').val();
    var action = "CargarStockTransferencia";
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + action + "&Material=" + mat + "&Centro=" + centro + "&Almacen=" + almace,
        success: function (data) {
            if (data[0] == "") {
                $('#' + clm + "tdMater" + pos).val("");
                $('#' + clm + "tdDescr" + pos).val("");
                $('#' + clm + "tdUmedi" + pos).val("");
                $('#' + clm + "tdCanti" + pos).val("");
                $('#' + clm + "tdLotes" + pos).val("");
                $('#' + clm + "tdMater" + pos).focus();
                mensajesNuevo(12, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#' + clm + "tdMater" + pos).val(data[0]);
                $('#' + clm + "tdDescr" + pos).val(data[1]);
                $('#' + clm + "tdUmedi" + pos).val(data[2]);
                $('#' + clm + "tdLotes" + pos).val(data[3]);
                $('#' + clm + "tdCanti" + pos).val(data[4]);
            }
        }
    });
}
function validarCantiExcedida(mat, centro, alm, lote, cant, doc, pos) {
//    alert("Material: " + mat + "\n\
//           Centro: " + centro + "\n\
//           Almacen: " + alm + "\n\
//           Lote: " + lote + "\n\
//           Cantidad: " + cant + "\n\
//           Documento: " + doc + "\n\
//           Posicion:" + pos);
    var x = true;
    var action = "ValidarCantidMaterial315";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + action + "&Material=" + mat + "&Centro=" + centro + "&Almacen=" + alm + "&Lote=" + lote + "&Documento=" + doc + "&Posicion=" + pos,
        success: function (data) {
//            alert(data);
            if (data != "X") {
                var can2 = parseFloat(data);
                var can1 = parseFloat(cant);
                if (can1 <= can2) {
                    x = false;
                }
            } else {
                x = true
            }
        }
    });
    return x;
}
function BarCode() {
    var theHandle = document.getElementById('handleBC');
    var theRoot = document.getElementById('VentanaModalBarCode');
    Drag.init(theHandle, theRoot);
    mostrarVentana('VentanaModalBarCode');
    $("#bxBC").val("");
    $("#313tdAlmacPP").val("");
    $("#311tdAlmacPP").val("");
    $("#301tdCentrPP").val("");
    ////
    var cl = document.getElementById("bxClase").value;
    switch (cl) {
        case "315":
            $("#secAlmDesBC").hide();
            $("#secAlmDesBC2").hide();
            $("#secCenDesBC").hide();
            $("#bxBC").focus();
            break;
        case "313":
            $("#secAlmDesBC").show();
            $("#secAlmDesBC2").hide();
            $("#secCenDesBC").hide();
//            $("#bxBCAlmacenD").focus();
            $("#313tdAlmacPP").focus();
            break;
        case "311":
            $("#secAlmDesBC").hide();
            $("#secAlmDesBC2").show();
            $("#secCenDesBC").hide();
            $("#bxBCAlmacenD").focus();
            break;
        case "301":
            $("#secAlmDesBC").hide();
            $("#secAlmDesBC2").hide();
            $("#secCenDesBC").show();
            $("#301tdCentrPP").focus();
            break;
    }
}
function pedidoPos(lote, doc, pos) {
    var action = "PedidoPos";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionMovMateriales2',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + action + "&Lote=" + lote,
        success: function (data) {
            doc.value = data[0];
            pos.value = data[1];
        }
    });
}
function soloNumeros(e, v) {
    var key = window.Event ? e.which : e.keyCode;
    patron = /[0-9.]/;
    te = String.fromCharCode(key);
    return patron.test(te);
}
function GetIp() {
    window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;   //compatibility for firefox and chrome
    var pc = new RTCPeerConnection({iceServers: []}), noop = function () {};
    pc.createDataChannel("");    //create a bogus data channel
    pc.createOffer(pc.setLocalDescription.bind(pc), noop);    // create offer and set local description
    pc.onicecandidate = function (ice) {  //listen for candidate events
        if (!ice || !ice.candidate || !ice.candidate.candidate)
            return;
        var myIP = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/.exec(ice.candidate.candidate)[1];
        pc.onicecandidate = noop;
        $('#IpData').val(myIP);
    };
}
function ObtenerFolioRandom() {
    var name = $('#NombreUser').val();
    var ip = $('#IpData').val();
    var n = ip + "" + name;
    return n;
}
function inv() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

////// Movimiento 101 guardar temporal


function ObtenerDatos101()
{
    var movimiento = document.getElementById('bxClase').value;
    var porrc = document.getElementsByName('bx101Prb');
    var lote = document.getElementsByName('bx101Lote');
    var uean = document.getElementsByName('bx101UEAN');//Unidad Medida
    var prov = document.getElementsByName('bx101Prov');
    var cnr = document.getElementsByName('tdCR');//Cantidad Recepcionada
    var cnp = document.getElementsByName('tdCP');//Cantidad
    var ped = document.getElementsByName('tdPedido');
    var pos = document.getElementsByName('tdPos');
    var mat = document.getElementsByName('tdMaterial');
    var alm = document.getElementsByName('tdAlmacen');
    var doc = document.getElementsByName('tdDocCom');
    var cls = document.getElementsByName('tdClase');
    var pro = document.getElementsByName('tdProveedor');
    var txt = document.getElementsByName('tdtxt');
    var ulc = document.getElementsByName('tdulc');
    var cec = document.getElementsByName('tdCeCo');
    var ord = document.getElementsByName('tdOrder');
    var clc = document.getElementsByName('tdClCoste');
    var tim = document.getElementsByName("tdTImp"); ////// Imputacion
    var n1 = 0;
    var n2 = 0;
    var registros = 0;
    switch (movimiento)
    {
        case "101":
            for (i = 0; i < porrc.length; i++)
            {
                n1 = parseFloat(porrc[i].value);
                n2 += n1;
            }
            if (n2 <= 0.000) {
                var ven = document.getElementById('VentanaModalAv');
                var msg = "No existen posiciones listas para su recepción";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
                return;
            }
            for (i = 0; i < porrc.length; i++)
            {
                if (porrc[i].value.length < 1) {
                    porrc[i].focus();
                    invalido("Cantidad Obligatoria no puede ir vacio");
                    return;
                }
            }
            for (i = 0; i < porrc.length; i++)
            {
                if (uean[i].value == "") {
                    uean[i].focus();
                    invalido("Unidad de Medida Obligatorio");
                    return;
                }
            }
            for (i = 0; i < porrc.length; i++)
            {
                if (!(porrc[i].value == "0")) {
                    var tole = GetCantFinal(cnp[i].textContent, uean[i].value, ped[i].textContent, pos[i].textContent);
                    var pr2 = parseFloat(cnp[i].textContent) + parseFloat(tole);
                    var ccc = parseFloat(porrc[i].value) + parseFloat(cnr[i].textContent);
                    if (ccc > pr2) {
                        var ven = document.getElementById('VentanaModalAv');
                        var msg = "El Material" + " " + mat[i].textContent + " excede la cantidad de pedido aplicada con tolerancia";
                        abrirVentanaAv(ven, msg);
                        var theHandle = document.getElementById("handleAV");
                        var theRoot = document.getElementById("VentanaModalAv");
                        Drag.init(theHandle, theRoot);
                        return;
                    }
                }
            }
            for (i = 0; i < lote.length; i++)
            {
                if (tim[i].textContent == "" && !(mat[i].textContent == "")) {
                    var isDisabled = $('#bxLote' + i).prop('disabled');
                    if (parseInt(porrc[i].value) !== 0) {
                        if (isDisabled === false) {
                            if (lote[i].value === "")
                            {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "El Material" + " " + mat[i].textContent + " esta sujeto a Lote  <br> el campo lote es obligatorio";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                    }
                }
            }
            ShowMsg(1, "images/load.gif", "audio/sapmsg.wav");
            $('#guardar').prop("disabled", true);
            var random = ObtenerFolioRandom();
            setTimeout(function () {
                GuardaTem101();
            }, 4000);
            break;
        case "102":
            var porrec = document.getElementsByName("bx102Prb");
            var claspe = "";
            var lotepr = "";
            var tdmateri = document.getElementsByName("tdMaterial102");
            var tdtxtmat = document.getElementsByName("tdtxt102");
            var tdalmace = document.getElementsByName("tdAlmacen102");
            var tdlote = document.getElementsByName("tdLote102");
            var tdccance = document.getElementsByName("tdCantCa102");
            var tdccanen = document.getElementsByName("tdCanEnt102");
            var tdunme = document.getElementsByName("tdUME102");
            var tdcentr = document.getElementsByName("tdCentro102");
            var tdfecha = document.getElementsByName("tdFecEnt102");
            var tdprove = document.getElementsByName("tdNumProv102");
            var tddocco = document.getElementsByName("tdNumDocCom102");
            var tdposco = document.getElementsByName("tdPosDoc102");
            var tdceco = document.getElementsByName("tdCeCo102");
            var tdorden = document.getElementsByName("tdOrd102");
            var tdclaco = document.getElementsByName("tdClaCos102");
            var tdmovim = document.getElementsByName("tdnumMov");
            var n1 = 0;
            var n2 = 0;
            for (i = 0; i < porrec.length; i++) {
                n1 = parseInt(porrec[i].value);
                n2 += n1
            }

            if (n2 === 0)
            {
                var ven = document.getElementById('VentanaModalAv');
                var msg = "No existen posiciones listas para su recepción";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
                return;
            }
            for (i = 0; i < porrec.length; i++) {
                if (porrec[i].value.length == 0) {
                    var ven = document.getElementById('VentanaModalAv');
                    var msg = "La cantidad no puede ir vacia, ingrese una cantidad";
                    abrirVentanaAv(ven, msg);
                    var theHandle = document.getElementById("handleAV");
                    var theRoot = document.getElementById("VentanaModalAv");
                    Drag.init(theHandle, theRoot);
                    return;
                }
                if (!(parseInt(porrec[i].value) == 0)) {
                    var cf = (parseFloat(tdccance[i].textContent)) + (parseFloat(porrec[i].value));
                    if (cf > parseFloat(tdccanen[i].textContent)) {
                        var ven = document.getElementById('VentanaModalAv');
                        var msg = "Cantidad Por Devolver mas Cantidad Cancelada, supera <br> a cantidad Entrante  en posición " + tdposco[i].textContent;
                        abrirVentanaAv(ven, msg);
                        var theHandle = document.getElementById("handleAV");
                        var theRoot = document.getElementById("VentanaModalAv");
                        Drag.init(theHandle, theRoot);
                        return;
                    }
                }
            }
            ShowMsg(1, "images/load.gif", "audio/sapmsg.wav");
            $('#guardar').prop("disabled", true);
            var random = ObtenerFolioRandom();
            setTimeout(function () {
                GuardaTem102();
            }, 4000);
            break;
    }

}
function GuardaTem101() {
    var ipda = ObtenerFolioRandom();
    var movimiento = document.getElementById('bxClase').value;
    var porrc = document.getElementsByName('bx101Prb');
    var lote = document.getElementsByName('bx101Lote');
    var uean = document.getElementsByName('bx101UEAN');//Unidad Medida
    var prov = document.getElementsByName('bx101Prov');
    var cnr = document.getElementsByName('tdCR');//Cantidad Recepcionada
    var cnp = document.getElementsByName('tdCP');//Cantidad
    var ped = document.getElementsByName('tdPedido');
    var pos = document.getElementsByName('tdPos');
    var mat = document.getElementsByName('tdMaterial');
    var alm = document.getElementsByName('tdAlmacen');
    var doc = document.getElementsByName('tdDocCom');
    var cls = document.getElementsByName('tdClase');
    var pro = document.getElementsByName('tdProveedor');
    var txt = document.getElementsByName('tdtxt');
    var ulc = document.getElementsByName('tdulc');
    var cec = document.getElementsByName('tdCeCo');
    var ord = document.getElementsByName('tdOrder');
    var clc = document.getElementsByName('tdClCoste');
    var tim = document.getElementsByName("tdTImp"); ////// Imputacion
    var registros = 0;
    for (i = 0; i < lote.length; i++)
    {
        var pr = parseFloat(porrc[i].value);
        var tolera = GetCantend(porrc[i].value, uean[i].value);
        if (pr > 0.000) {
            registros++;
            var extras = "";
            if (tim[i].textContent == "K") {
                extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                        "&v3=&v4=" +
                        "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                        "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                        "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                        "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                        "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                        "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                        "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=" + "" + "&ipFolio=" + ipda;
            } else if (tim[i].textContent == "F") {
                extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                        "&v3=&v4=" +
                        "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                        "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                        "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                        "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                        "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                        "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                        "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=" + "" + "&ipFolio=" + ipda;
            } else {
                extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                        "&v3=&v4=" +
                        "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                        "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                        "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                        "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                        "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                        "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                        "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=" + "" + "&ipFolio=" + ipda;
            }
            ActualizaTemp('ActualizaTemporal', extras);
        }
    }
    setTimeout(function () {
        verificarRegistros101('VerificarRegistros', registros, movimiento, ipda);
    }, 2000);
}
function verificarRegistros101(action, cantidad, movimiento, ipd)
{
    $('#guardar').prop("disabled", false);
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 0) {
                GuardarMovimientos("VaciarTemporal", "");
                var ven = document.getElementById('VentanaModalAv');
                var msg = "Error de conexión";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
                LimpiarPpal("LimpiarPpal");
                borramsg();
            } else {
                borramsg();
                var ven = document.getElementById('VentanaModalAv');
                var msg = "Lineas adoptadas para su recepción";
                abrirVentanaAv(ven, msg);
                var theHandle = document.getElementById("handleAV");
                var theRoot = document.getElementById("VentanaModalAv");
                Drag.init(theHandle, theRoot);
                ocultarVentana('VentanaModal101', 'btnAdd');
            }
        }
    };
    xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + "&v1=" + cantidad + "&v2=" + movimiento + "&ipFolio=" + ipd, true);
    xmlhttp.send();
}
function LimpiarPpal(accion)
{
    var ipsdf = ObtenerFolioRandom();
    var clase = document.getElementById('bxClase').value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            document.getElementById("SecTabPpal").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", "PeticionTablasMovMateriales?Action=" + accion + "&clase=" + clase + "&ipFolio=" + ipsdf, true);
    xmlhttp.send();
}
function dataxxxx() {
    document.getElementById('VentanaModalCalidad').style.display = 'none';
//                        if (document.getElementById('bxClase').value === "101" || document.getElementById('bxClase').value === "303") {
//                            abrirVentanaMsgAddFile();
//    
//                                            } else {
    ShowMsg(3, "images/load.gif", "audio/sapmsg.wav");
    $('#guardar').prop("disabled", true);
    setTimeout(function () {
        MovimientosMO();
    }, 2000);

}

function GuardaTem102() {
    var ipda = ObtenerFolioRandom();
    var movimiento = document.getElementById('bxClase').value;
    var porrec = document.getElementsByName("bx102Prb");
    var claspe = "";
    var lotepr = "";
    var tdmateri = document.getElementsByName("tdMaterial102");
    var tdtxtmat = document.getElementsByName("tdtxt102");
    var tdalmace = document.getElementsByName("tdAlmacen102");
    var tdlote = document.getElementsByName("tdLote102");
    var tdccance = document.getElementsByName("tdCantCa102");
    var tdccanen = document.getElementsByName("tdCanEnt102");
    var tdunme = document.getElementsByName("tdUME102");
    var tdcentr = document.getElementsByName("tdCentro102");
    var tdfecha = document.getElementsByName("tdFecEnt102");
    var tdprove = document.getElementsByName("tdNumProv102");
    var tddocco = document.getElementsByName("tdNumDocCom102");
    var tdposco = document.getElementsByName("tdPosDoc102");
    var tdceco = document.getElementsByName("tdCeCo102");
    var tdorden = document.getElementsByName("tdOrd102");
    var tdclaco = document.getElementsByName("tdClaCos102");
    var tdmovim = document.getElementsByName("tdnumMov");
    var n1 = 0;
    var n2 = 0;
    var registros = 0;
    for (i = 0; i < porrec.length; i++) {
        n1 = parseInt(porrec[i].value);
        n2 += n1
    }
    for (i = 0; i < tddocco.length; i++) {
        var pr = parseInt(porrec[i].value);
        if (pr !== 0) {
            registros++;
            var extras = "";
            if (tdorden[i].textContent.lentgh > 0 || tdceco[i].textContent.length > 0) {
                extras = "&v7=" + tdmateri[i].textContent + "&v12=" + tdtxtmat[i].textContent +
                        "&v8=" + tdalmace[i].textContent + "&v2=" + tdlote[i].textContent +
                        "&v1=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v14=" + tdccanen[i].textContent +
                        "&v5=" + tdunme[i].textContent + "&v22=" + tdcentr[i].textContent +
                        "&v13=" + tdccance[i].textContent + "&v3=" + tdmovim[i].textContent +
                        "&v21=" + tdfecha[i].textContent + "&v16=" + movimiento + "&v9=" + "&v11=" + tdprove[i].textContent + "&ped=" + tddocco[i].textContent +
                        "&pos=" + tdposco[i].textContent + "&v17=" + tdceco[i].textContent +
                        "&v19=" + tdorden[i].textContent + "&v18=" + tdclaco[i].textContent + "&v20=" + "&v15=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v6=" + lotepr + "&v10=" + claspe + "&ipFolio=" + ipda;
            } else {
                extras = "&v7=" + tdmateri[i].textContent + "&v12=" + tdtxtmat[i].textContent +
                        "&v8=" + tdalmace[i].textContent + "&v2=" + tdlote[i].textContent +
                        "&v1=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v14=" + tdccanen[i].textContent +
                        "&v5=" + tdunme[i].textContent + "&v22=" + tdcentr[i].textContent +
                        "&v13=" + tdccance[i].textContent + "&v3=" + tdmovim[i].textContent +
                        "&v21=" + tdfecha[i].textContent + "&v16=" + movimiento + "&v9=" + "&v11=" + tdprove[i].textContent + "&ped=" + tddocco[i].textContent +
                        "&pos=" + tdposco[i].textContent + "&v17=" + tdceco[i].textContent +
                        "&v19=" + tdorden[i].textContent + "&v18=" + tdclaco[i].textContent + "&v20=V" + "&v15=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v6=" + lotepr + "&v10=" + claspe + "&ipFolio=" + ipda;
            }
            ActualizaTemp('ActualizaTemporal', extras);
        }
    }
    setTimeout(function () {
        verificarRegistros101('VerificarRegistros', registros, movimiento, ipda);
    }, 2000);
}
function GuardarTempMovs() {
    var random = ObtenerFolioRandom();
    var ClaseM = $('#bxClase').val().trim();
    var Centro = $('#bxCentro').val().trim();
    var Almace = $('#bxAlmacen').val().trim();
    var Materi = document.getElementsByName(ClaseM + 'MaterTD');
    var Descri = document.getElementsByName(ClaseM + 'DesciTD');
    var UnidMe = document.getElementsByName(ClaseM + 'UMediTD');
    var Lote = document.getElementsByName(ClaseM + 'LotesTD');
    var Canti = document.getElementsByName(ClaseM + 'CantiTD');
    var Centr = document.getElementsByName(ClaseM + 'CentrTD');
    var Almac = document.getElementsByName(ClaseM + 'AlmacTD');
    var Docum = document.getElementsByName(ClaseM + 'DocTD');
    var Posic = document.getElementsByName(ClaseM + 'PosTD');
    var Centgrid = document.getElementsByName('mmCentro');
    var Almgrid = document.getElementsByName('mmAlmace');
    var kk = 0;
    try {
        var ix = document.getElementsByName('Pedidos');
        kk = ix[ix.length - 1].value;
//        alert(kk);
    } catch (e) {
    }
    var ii = kk;
    for (i = 0; i < Materi.length; i++) {
        if (Materi[i].value.length != 0) {
            var nnn = parseInt(ii) + (1);
            var extr = "&Material=" + Materi[i].value + "&Descripcion=" + Descri[i].value +
                    "&UnidadMedida=" + UnidMe[i].value + "&Centro=" + Centr[i].value +
                    "&Almacen=" + Almac[i].value + "&Cantidad=" + Canti[i].value + "&Lote=" + Lote[i].value +
                    "&Documento=" + Docum[i].value + "&Posicion=" + Posic[i].value +
                    "&ClaseMov=" + ClaseM + "&Indice=" + nnn + "&IpData=" + random;
            InserMovsNuevosTemp('VentanaModalMovsnuevos', extr);
            ii++;
        }
    }
    $('#guardar').prop('disabled', false);
    $('#iconmsg').hide();
    var men = document.getElementById("msg");
    men.innerHTML = "";
    var ven = document.getElementById('VentanaModalAv');
    var msg = "Posicion(s) cargada correctamente";
    abrirVentanaAv(ven, msg);
    var theHandle = document.getElementById("handleAV");
    var theRoot = document.getElementById("VentanaModalAv");
    Drag.init(theHandle, theRoot);
    ocultarVentana('VentanaModal301', 'btnAdd');
}
function MaterialesGet() {
    var acc = "ConsultaMaterial";
    var datos = "&v2=" + $('#bxclim').val()
            + "&v1=" + encodeURIComponent($('#bxtxtm').val().trim())
            + "&v3=" + $('#bxmatm').val()
            + "&v5=" + $('#bxClase').val() + "&v4=" + $('#bxcnmm').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosMaterial').html(data);
                $('#BuscarParamMaterial').css('display', 'none');
                $('#ConsultaTablaMaterial').css('display', 'block');
                document.getElementById('table-scrollMaterial').onscroll = function () {
                    document.getElementById('fixedYMaterial').style.top = document.getElementById('table-scrollMaterial').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function CeCosGet() {
    var acc = "ConsultaCeCos";
    var datos = "&v1=" + $('#bxcc').val()
            + "&v3=" + encodeURIComponent($('#bxtxc').val().trim())
            + "&v2=" + $('#bxsc').val()
            + "&v4=" + encodeURIComponent($('#bxtxc2').val().trim())
            + "&v5=" + $('#numAcMaxCeco').val()
            + "&v6=" + $('#bxClase').val();
    
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosCC').html(data);
                $('#BuscarParamCC').css('display', 'none');
                $('#ConsultaTablaCC').css('display', 'block');
                document.getElementById('table-scrollCC').onscroll = function () {
                    document.getElementById('fixedYCC').style.top = document.getElementById('table-scrollCC').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function LoteGet() {
    var clas = $('#bxClase').val();
    var acc = "ConsultaLote";
    var datos = "&v1=" + $('#bxCentro').val()
            + "&v2=" + $('#bxMaterial' + clas).val()
            + "&v3=" + clas + "&v4=" + $('#bxAlmacen').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                mensajesNuevo(0, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosLote').html(data);
                document.getElementById('table-scrollLote').onscroll = function () {
                    document.getElementById('fixedYLote').style.top = document.getElementById('table-scrollLote').scrollTop + 'px';
                };
                borramsg();
                var ven = document.getElementById("VentanaModalLote");
                abrirVentanaLote(ven);
                var theHandle = document.getElementById('handle6');
                var theRoot = document.getElementById('VentanaModalLote');
                Drag.init(theHandle, theRoot);
            }
        }
    });
}
function seleccionarMatok(mat, des, um, clase) {
    var id = "";
    if (clase == "202") {
        clase = "201";
        id = $('#bxMaterial' + clase);
    }
    $('#bxMaterial' + clase).val(mat);
    $('#bxMaterial' + clase).focus();
    $('#bxTxtMaterial' + clase).val(des);
    $('#bxUM' + clase).val(um);
    $('#bxUM' + clase).css('background-image', 'none');
    $('#bxcnt' + clase).focus();
    ocultarVentana("VentanaModalMaterial", id);
}
function obtenerMaterialDatos() {
    var acc = "ObtenerDatosMateriales";
    var clm = $('#bxClase').val();
    if (clm == "202") {
        clm = "201";
    }
    var datos = "&v1=" + $('#bxMaterial' + clm).val();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                $('#bxMaterial' + clm).val("");
                $('#bxTxtMaterial' + clm).val("");
                $('#bxUM' + clm).val("");
                $('#bxUM' + clm).css('background-image', 'url(images/necesario.PNG)');
                $('#bxLote' + clm).css('background-image', 'none');
                $('#bxLote' + clm).prop('disabled', true);
                $('#bxLote' + clm).val("");
            } else {
                $('#bxMaterial' + clm).val(data[0]);
                $('#bxTxtMaterial' + clm).val(data[1]);
                $('#bxUM' + clm).val(data[2]);
                $('#bxUM' + clm).css('background-image', 'none');

                if (data[3].length > 0) {
                    $('#bxLote' + clm).prop('disabled', false);
                    $('#bxLote' + clm).css('background-image', 'url(images/necesario.PNG)');
                } else {
                    $('#bxLote' + clm).css('background-image', 'none');
                    $('#bxLote' + clm).prop('disabled', true);
                }
                if ($('#bxLote' + clm).val().length > 0) {
                    $('#bxLote' + clm).css('background-image', 'none');
                }

            }
        }
    });
}
function SelecLoteM(lote, clase) {
    var id = "";
    if (clase == "202") {
        clase = "201";
        id = $('#bxLote' + clase);
    }
    $('#bxLote' + clase).val(lote);
    $('#bxLote' + clase).css('background-image', 'none');
    $('#bxLote' + clase).focus();
    ocultarVentana("VentanaModalLote", id);
}
function seleccionarCCosto(valor, clase) {
    alert(valor + " - " + clase);
    var id = "";
    if (clase == "202") {
        clase = "201";
        id = $('#bxMaterial' + clase);
    }
    $('#bxccs' + clase).val(valor);
    $('#bxccs' + clase).focus();
    $('#bxccs' + clase).css('background-image', 'none');
    ocultarVentana("VentanaModalCC", id);
}