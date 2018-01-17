$(document).ready(function () {
    startTime();
    $('#iconmsg').hide();
    var clOrdL = $('#clOrdL');
    var OrdeL = $('#OrdeL');
    var SAMOrden = $('#SAMOrden');
    var txtbrvord = $('#txtbrvord');
    var ubitl = $('#ubitl');
    var equiL = $('#equiL');
    var ptol = $('#ptol');
    var fechaord = $('#fechaord');
    var clOrdL2 = $('#clOrdL2');
    var OrdeL2 = $('#OrdeL2');
    var SAMOrden2 = $('#SAMOrden2');
    var txtbrvord2 = $('#txtbrvord2');
    var ubitl2 = $('#ubitl2');
    var equiL2 = $('#equiL2');
    var ptol2 = $('#ptol2');
    var fechaord2 = $('#fechaord2');

    var b1 = $('#btnmat1');
    var b2 = $('#btnmat2');
    var b3 = $('#btnmat3');
    var b4 = $('#btnmat4');
    var b5 = $('#btnmat5');
    var b6 = $('#btnmat6');
    var b7 = $('#btnmat7');
    var b8 = $('#btnmat8');
    var b9 = $('#btnmat9');
    var b10 = $('#btnmat10');
    var b11 = $('#btnmat11');
    var b12 = $('#btnmat12');
    var b13 = $('#btnmat13');
    var b14 = $('#btnmat14');
    var btn = [
        b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14
    ];
    var inp = [clOrdL, OrdeL, SAMOrden, txtbrvord, ubitl, equiL, ptol, fechaord,
        clOrdL2, OrdeL2, SAMOrden2, txtbrvord2, ubitl2, equiL2, ptol2, fechaord2];
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });

    /////  INICIO -  CLASE ORDEN
    $('#CerraClaOd').click(function () {
        ocultarVentana('VentanaModalClaseOrden', 'BuscarParamCOr', 'ConsultaTablaClaseOrden', 'clOrdL');
    });
    $('#CerraClaOd2').click(function () {
        ocultarVentana('VentanaModalClaseOrden', 'BuscarParamCOr', 'ConsultaTablaClaseOrden', 'clOrdL');
    });
    $('#retbtncl').click(function () {
        $('#BuscarParamCOr').show();
        $('#ConsultaTablaClaseOrden').hide();
    });
    $('#CClaseOrden').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#Ctextobreve').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okClaseOrden').click(function () {
        ConsultarClaseorden();
    });
    /////////// FIN
    //  
    //
    ///// INICIO NUMERO ORDEN

    $('#CerraOrdmtc').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParam_OR', 'ConsultaTablaOrden', 'OrdeL');
    });
    $('#CerraOrdmtc2').click(function () {
        ocultarVentana('VentanaModalOrden', 'BuscarParam_OR', 'ConsultaTablaOrden', 'OrdeL');
    });
    $('#retord1').click(function () {
        $('#BuscarParam_OR').show();
        $('#ConsultaTablaOrden').hide();
    });
    $('#NumOrden_Bus').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#TextoOrden_Bus').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okorden').click(function () {
        ConsultaOrden();
    });

    //////// FIN
    //
    //
    ///// INICIO SAM

    $('#CerraSAMMC').click(function () {
        ocultarVentana('VentanaModalSAM', 'BuscarParam_SAM', 'ConsultaTablaSAM', 'SAMOrden');
    });
    $('#CerraSAMMC2').click(function () {
        ocultarVentana('VentanaModalSAM', 'BuscarParam_SAM', 'ConsultaTablaSAM', 'SAMOrden');
    });
    $('#retSAM').click(function () {
        $('#BuscarParam_SAM').show();
        $('#ConsultaTablaSAM').hide();
    });
    $('#FoliSAM_ord').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#TextoSAM_ord').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax3').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okSAM').click(function () {
        ConsultaSAM();
    });

    //////// FIN    
    //
    //
    /////// INICIO EQUIPO

    $('#cerareq').click(function () {
        ocultarVentana('VentanaModalEquipos', 'BuscarParamE', 'ConsultaTablaEquipo', 'equiL');
    });
    $('#cerareq2').click(function () {
        ocultarVentana('VentanaModalEquipos', 'BuscarParamE', 'ConsultaTablaEquipo', 'equiL');
    });
    $('#retequi').click(function () {
        $('#BuscarParamE').show();
        $('#ConsultaTablaEquipo').hide();
    });
    $('#equBus').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanuu.test(te);
    });
    $('#denEqBus').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax5').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okEquipo').click(function () {
        ConsultarEquipo();
    });

    /////// FIN
    //
    //    
    /////  INICIO -  CLASE ORDEN 2
    $('#CerraClaOd222').click(function () {
        ocultarVentana('VentanaModalClaseOrden2', 'BuscarParamCOr2', 'ConsultaTablaClaseOrden2', 'clOrdL2');
    });
    $('#CerraClaOd22').click(function () {
        ocultarVentana('VentanaModalClaseOrden2', 'BuscarParamCOr2', 'ConsultaTablaClaseOrden2', 'clOrdL2');
    });
    $('#retbtncl2').click(function () {
        $('#BuscarParamCOr2').show();
        $('#ConsultaTablaClaseOrden2').hide();
    });
    $('#CClaseOrden2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#Ctextobreve2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden2();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax7').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarClaseorden2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okClaseOrden2').click(function () {
        ConsultarClaseorden2();
    });

    /////////// FIN

    ///// INICIO NUMERO ORDEN

    $('#CerraOrdmtc22').click(function () {
        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
    });
    $('#CerraOrdmtc222').click(function () {
        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
    });
    $('#retord12').click(function () {
        $('#BuscarParam_OR2').show();
        $('#ConsultaTablaOrden2').hide();
    });
    $('#NumOrden_Bus2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#TextoOrden_Bus2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden2();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax8').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaOrden2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okorden2').click(function () {
        ConsultaOrden();
    });

    //////// FIN
    //
    //
    ///// INICIO SAM

    $('#CerraSAMMC22').click(function () {
        ocultarVentana('VentanaModalSAM2', 'BuscarParam_SAM2', 'ConsultaTablaSAM2', 'SAMOrden2');
    });
    $('#CerraSAMMC222').click(function () {
        ocultarVentana('VentanaModalSAM2', 'BuscarParam_SAM2', 'ConsultaTablaSAM2', 'SAMOrden2');
    });
    $('#retSAM2').click(function () {
        $('#BuscarParam_SAM2').show();
        $('#ConsultaTablaSAM2').hide();
    });
    $('#FoliSAM_ord2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#TextoSAM_ord2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM2();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax9').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultaSAM2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okSAM2').click(function () {
        ConsultaSAM();
    });

    //////// FIN
    //
    //
    /////// INICIO EQUIPO

    $('#cerareq22').click(function () {
        ocultarVentana('VentanaModalEquipos2', 'BuscarParamE2', 'ConsultaTablaEquipo2', 'equiL2');
    });
    $('#cerareq222').click(function () {
        ocultarVentana('VentanaModalEquipos2', 'BuscarParamE2', 'ConsultaTablaEquipo2', 'equiL2');
    });
    $('#retequi2').click(function () {
        $('#BuscarParamE2').show();
        $('#ConsultaTablaEquipo2').hide();
    });
    $('#equBus2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclalfanuu.test(te);
    });
    $('#denEqBus2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo2();
        }
        if (tec == 32) {
            return true;
        }
        te = String.fromCharCode(tec);
        return teclalfanu.test(te);
    });
    $('#numAcMax11').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 13) {
            ConsultarEquipo2();
        }
        if (tec == 32) {
            return false;
        }
        te = String.fromCharCode(tec);
        return teclanum.test(te);
    });
    $('#okEquipo2').click(function () {
        ConsultarEquipo2();
    });
    /////// FIN

    $('#ejecutar').click(function () {
        if ($('#clOrdL').val().length < 0) {
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
            $('#clOrdL').val('');
            $('#clOrdL').focus();
            return;
        }
        if ($('#clOrdL2').val().length < 0) {
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
            $('#clOrdL2').val('');
            $('#clOrdL2').focus();
            return;
        }
        if ($('#OrdeL').val().length < 0) {
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            $('#OrdeL').val('');
            $('#OrdeL').focus();
            return;
        }
        if ($('#OrdeL2').val().length < 0) {
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            $('#OrdeL2').val('');
            $('#OrdeL2').focus();
            return;
        }
        if ($('#SAMOrden').val().length < 0) {
            ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
            $('#SAMOrden').val('');
            $('#SAMOrden').focus();
            return;
        }
        if ($('#SAMOrden2').val().length < 0) {
            ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
            $('#SAMOrden2').val('');
            $('#SAMOrden2').focus();
            return;
        }
//        if ($('#ubitl').val().length < 0) {
//            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
//            $('#ubitl').val('');
//            $('#ubitl').focus();
//            return;
//        }
//        if ($('#ubitl2').val().length < 0) {
//            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
//            $('#ubitl2').val('');
//            $('#ubitl2').focus();
//            return;
//        }
        if ($('#equiL').val().length < 0) {
            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
            $('#equiL').val('');
            $('#equiL').focus();
            return;
        }
        if ($('#equiL2').val().length < 0) {
            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
            $('#equiL2').val('');
            $('#equiL2').focus();
            return;
        }
//        if ($('#ptol').val().length < 0) {
//            ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
//            $('#ptol').val('');
//            $('#ptol').focus();
//            return;
//        }
//        if ($('#ptol2').val().length < 0) {
//            ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
//            $('#ptol2').val('');
//            $('#ptol2').focus();
//            return;
//        }
        ValidarQuery();
    });
    function ValidarQuery() {
        var abi = $('#abie');
        var lib = $('#lib');
        var ctec = $('#ctec');
        if (!(abi.prop('checked') || lib.prop('checked') || ctec.prop('checked'))) {
            ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            var ab = "";
            var li = "";
            var ct = "";
            var hi = "";
            if (abi.prop('checked')) {
                ab = abi.val();
            }
            if (lib.prop('checked')) {
                li = lib.val();
            }
            if (ctec.prop('checked')) {
                ct = ctec.val();
            }
            var acc = "ValidarQuery";
            var par = "&cl1=" + clOrdL.val() + "&cl2=" + clOrdL2.val() + "&or1=" + OrdeL.val() + "&or2=" + clOrdL2.val() +
                      "&sa1=" + SAMOrden.val() + "&sa2=" + SAMOrden2.val() + "&tb1=" + txtbrvord.val() + "&tb2=" + txtbrvord2.val() +
                      "&ep1=" + equiL.val() + "&ep2=" + equiL2.val() + "&fc1=" + fechaord.val() + "&fc2=" + fechaord2.val() +
                      "&abi=" + ab + "&lib=" + li + "&cte=" + ct;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionModuloListaOrdenesPP',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + par,
                success: function (data) {                    
                    if (data == 0) {
                        ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        window.location.href = "ListaOrdenes2PP.jsp?acc=CargarTabla" + par;
                    }
                }
            });
        }
    }
    $.each(btn, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalClaseOrden', 'handle', 'CClaseOrden');
                });
                break;
            case 1:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalOrden', 'handle2', 'NumOrden_Bus');
                });
                break;
            case 2:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalSAM', 'handle3', 'FoliSAM_ord');
                });
                break;
            case 3:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalUbiTec', 'handle4', 'UbitteBus');
                });
                break;
            case 4:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalEquipos', 'handle5', 'equBus');
                });
                break;
            case 5:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalPuesto', 'handle6', 'puestp');
                });
                break;
            case 6:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalClaseOrden2', 'handle7', 'CClaseOrden2');
                });
                break;
            case 7:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalOrden2', 'handle8', 'NumOrden_Bus2');
                });
                break;
            case 8:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalSAM2', 'handle9', 'FoliSAM_ord2');
                });
                break;
            case 9:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalUbiTec2', 'handle10', 'UbitteBus2');
                });
                break;
            case 10:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalEquipos2', 'handle11', 'equBus2');
                });
                break;
            case 11:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalPuesto2', 'handle12', 'puestp2');
                });
                break;
            case 12:
                v.click(function () {
                    OpenCalendario("fechaord");
                });
                break;
            case 13:
                v.click(function () {
                    OpenCalendario("fechaord2");
                });
                break;
        }
    });

    $.each(inp, function (i, v) {
        switch (i) {
            case 0: /////// Clase Orden
                v.focus(function () {
                    posicionm(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        ValidarClase("clOrdL");
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return teclalfanu.test(te);
                });
                break;
            case 1: //////// Numero de Orden
                v.focus(function () {
                    posicionm(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        ValidarOrden("OrdeL");
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return teclalfanu.test(te);
                });
                break;
            case 2: ////// Folio SAM
                v.focus(function () {
                    posicionm(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        ValidarSAM('SAMOrden');
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return teclalfanu.test(te);
                });
                break;
            case 3: //// Texto Breve
                v.focus(function () {
                    posicionm(-1);
                });
                break;
            case 4: ////// Ubicacion Tecnica
                v.focus(function () {
                    posicionm(3);
                });
                break;
            case 5: //////// Equipo
                v.focus(function () {
                    posicionm(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        ValidarEquipo('equiL');
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    return teclalfanuu.test(te);
                });
                break;
            case 6: ///// Puesto de Trabajo
                v.focus(function () {
                    posicionm(5);
                });
                break;
            case 7: ////// Fecha
                v.focus(function () {
                    posicionm(12);
                });
                break;
            case 8: //////  Clase Orden
                v.focus(function () {
                    posicionm(6);
                });
                break;
            case 9: /////// Numero de orden
                v.focus(function () {
                    posicionm(7);
                });
                break;
            case 10: ////// Folio SAM
                v.focus(function () {
                    posicionm(8);
                });
                break;
            case 11: //// Texto Breve
                v.focus(function () {
                    posicionm(-1);
                });
                break;
            case 12: /////// Ubicacion Tecnica
                v.focus(function () {
                    posicionm(9);
                });
                break;
            case 13: ///// Equipo
                v.focus(function () {
                    posicionm(10);
                });
                break;
            case 14: ///// Puesto
                v.focus(function () {
                    posicionm(11);
                });
                break;
            case 15: //// Fecha
                v.focus(function () {
                    posicionm(13);
                });
                break;

        }
    });
    function posicionm(index) {
        $.each(btn, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
//    $('#CerraClaOd').click(function () {
//        ocultarVentana('VentanaModalClaseOrden', 'BuscarParamCOr', 'ConsultaTablaClaseOrden', 'clOrdL');
//    });
//    $('#CerraClaOd2').click(function () {
//        ocultarVentana('VentanaModalClaseOrden', 'BuscarParamCOr', 'ConsultaTablaClaseOrden', 'clOrdL');
//    });
//    $('#CerraOrdmtc22').click(function () {
//        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
//    });
//    $('#CerraOrdmtc222').click(function () {
//        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
//    });
//    $('#CerraOrdmtc').click(function () {
//        ocultarVentana('VentanaModalOrden', 'BuscarParam_OR', 'ConsultaTablaOrden', 'OrdeL');
//    });
//    $('#CerraOrdmtc2').click(function () {
//        ocultarVentana('VentanaModalOrden', 'BuscarParam_OR', 'ConsultaTablaOrden', 'OrdeL');
//    });
//    $('#CerraSAMMC').click(function () {
//        ocultarVentana('VentanaModalSAM', 'BuscarParam_SAM', 'ConsultaTablaSAM', 'SAMOrden');
//    });
//    $('#CerraSAMMC2').click(function () {
//        ocultarVentana('VentanaModalSAM', 'BuscarParam_SAM', 'ConsultaTablaSAM', 'SAMOrden');
//    });
//    $('#Cerrarubute').click(function () {
//        ocultarVentana('VentanaModalUbiTec', 'BuscarParamUbi', 'ConsultaTablaUbicacion', 'ubitl');
//    });
//    $('#Cerrarubute2').click(function () {
//        ocultarVentana('VentanaModalUbiTec', 'BuscarParamUbi', 'ConsultaTablaUbicacion', 'ubitl');
//    });
//    $('#cerareq').click(function () {
//        ocultarVentana('VentanaModalEquipos', 'BuscarParamE', 'ConsultaTablaEquipo', 'equiL');
//    });
//    $('#cerareq2').click(function () {
//        ocultarVentana('VentanaModalEquipos', 'BuscarParamE', 'ConsultaTablaEquipo', 'equiL');
//    });
//    $('#Cerrapueto').click(function () {
//        ocultarVentana('VentanaModalPuesto', 'BuscarParamPt', 'ConsultaTablaPuesto', 'ptol');
//    });
//    $('#Cerrapueto2').click(function () {
//        ocultarVentana('VentanaModalPuesto', 'BuscarParamPt', 'ConsultaTablaPuesto', 'ptol');
//    });
//    $('#CerraClaOd222').click(function () {
//        ocultarVentana('VentanaModalClaseOrden2', 'BuscarParamCOr2', 'ConsultaTablaClaseOrden2', 'clOrdL2');
//    });
//    $('#CerraClaOd22').click(function () {
//        ocultarVentana('VentanaModalClaseOrden2', 'BuscarParamCOr2', 'ConsultaTablaClaseOrden2', 'clOrdL2');
//    });
//    $('#CerraOrdmtc22').click(function () {
//        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
//    });
//    $('#CerraOrdmtc222').click(function () {
//        ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
//    });
//    $('#CerraSAMMC22').click(function () {
//        ocultarVentana('VentanaModalSAM2', 'BuscarParam_SAM2', 'ConsultaTablaSAM2', 'SAMOrden2');
//    });
//    $('#CerraSAMMC222').click(function () {
//        ocultarVentana('VentanaModalSAM2', 'BuscarParam_SAM2', 'ConsultaTablaSAM2', 'SAMOrden2');
//    });
//    $('#Cerrarubute22').click(function () {
//        ocultarVentana('VentanaModalUbiTec2', 'BuscarParamUbi2', 'ConsultaTablaUbicacion2', 'ubitl2');
//    });
//    $('#Cerrarubute222').click(function () {
//        ocultarVentana('VentanaModalUbiTec2', 'BuscarParamUbi2', 'ConsultaTablaUbicacion2', 'ubitl2');
//    });
//    $('#cerareq22').click(function () {
//        ocultarVentana('VentanaModalEquipos2', 'BuscarParamE2', 'ConsultaTablaEquipo2', 'equiL2');
//    });
//    $('#cerareq222').click(function () {
//        ocultarVentana('VentanaModalEquipos2', 'BuscarParamE2', 'ConsultaTablaEquipo2', 'equiL2');
//    });
//    $('#Cerrapueto22').click(function () {
//        ocultarVentana('VentanaModalPuesto2', 'BuscarParamPt2', 'ConsultaTablaPuesto2', 'ptol2');
//    });
//    $('#Cerrapueto222').click(function () {
//        ocultarVentana('VentanaModalPuesto2', 'BuscarParamPt2', 'ConsultaTablaPuesto2', 'ptol2');
//    });    
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
});
//VALIDACIONES DE INPUTS
function ValidarClase(id) {
    var acc = "ValidarClase";
    var ord = $('#' + id).val().toUpperCase();
    var enviar = "&ClaseOrden=" + ord;
    if (ord.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloListaOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#' + id).val('');
                    $('#' + id).focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function ValidarOrden(id) {
    var acc = "ValidarOrden";
    var ord = $('#' + id).val().toUpperCase();
    var enviar = "&ord=" + ord;
    if (ord.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloListaOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#' + id).val('');
                    $('#' + id).focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function ValidarSAM(id) {
    var acc = "ValidarSAM";
    var sam = $('#' + id).val().toUpperCase();
    var enviar = "&sam=" + sam;
    if (sam.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloListaOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#' + id).val('');
                    $('#' + id).focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
function ValidarEquipo(id) {
    var acc = "ValidarEquipo";
    var ord = $('#' + id).val().toUpperCase();
    var enviar = "&Equipo=" + ord;
    if (ord.length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloListaOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#' + id).val('');
                    $('#' + id).focus();
                } else {
                    borramsg();
                }
            }
        });
    }
}
//CONSULTAS MATCH
function ConsultarClaseorden() {
    var acc = "ConsultaMatchClaseOrden";
    var idioma = $('#Idioma').val();
    var ClaseO = $('#CClaseOrden').val();
    var texto = $('#Ctextobreve').val();
    var cant = $('#numAcMax').val();
    var datos = "&ClaseOrden=" + ClaseO + "&TextoBreve=" + texto + "&ctd=" + cant + "&Idioma=" + idioma;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloListaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#BuscarParamCOr').hide();
                $('#ConsultaTablaClaseOrden').show();
                $('#cargarDatosClaseOrden').html(data);
                fnc('table-scrollClaseOrden', 'fixedYClaseOrden');
                borramsg();
            }
        }
    });
}
function ConsultaOrden() {
    var acc = "ConsultarOrdenes";
    var orden = $('#NumOrden_Bus').val();
    var texto = $('#TextoOrden_Bus').val();
    var ctd = $('#numAcMax2').val();
    var enviar = "&ord=" + orden + "&texto=" + texto + "&ctd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloListaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#BuscarParam_OR').hide();
                $('#ConsultaTablaOrden').show();
                $('#cargarDatosOrden').html(data);
                fnc('table-scrollord', 'fixedYord');
                borramsg();
            }
        }
    });
}
function ConsultaSAM() {
    var acc = "ConsultarOrdenessam";
    var orden = $('#FoliSAM_ord').val();
    var texto = $('#TextoSAM_ord').val();
    var ctd = $('#numAcMax3').val();
    var enviar = "&sam=" + orden + "&DSAM=" + texto + "&ctd=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloListaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#BuscarParam_SAM').hide();
                $('#ConsultaTablaSAM').show();
                $('#cargarDatosSAM').html(data);
                fnc('table-scrollordscrollSAM', 'fixedSAM');
                borramsg();
            }
        }
    });
}
//NUEVA PETICION PARA MATCH MATERIAL (ANTES EQUIPO)
function ConsultarEquipo() {
    var acc = "ConsultaMatchMaterial";
    var idioma = $('#Idioma').val();
    var eq = $('#equBus').val();
    var Deq = $('#denEqBus').val();
    var cant = $('#numAcMax5').val();
    var datos = "&Mate=" + eq + "&DenMate=" + Deq + "&ctd=" + cant + "&Idioma=" + idioma;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloListaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#BuscarParamE').hide();
                $('#ConsultaTablaEquipo').show();
                $('#cargarDatosEquipo').html(data);
                fnc('table-scrollEquipo', 'fixedYEquipo');
                borramsg();
            }
        }
    });
}
function ConsultarClaseorden2() {
    var acc = "ConsultaMatchClaseOrden2";
    var idioma = $('#Idioma').val();
    var ClaseO = $('#CClaseOrden2').val();
    var texto = $('#Ctextobreve2').val();
    var cant = $('#numAcMax7').val();
    var datos = "&ClaseOrden=" + ClaseO + "&TextoBreve=" + texto + "&ctd=" + cant + "&Idioma=" + idioma;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloListaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#BuscarParamCOr2').hide();
                $('#ConsultaTablaClaseOrden2').show();
                $('#cargarDatosClaseOrden2').html(data);
                fnc('table-scrollClaseOrden2', 'fixedYClaseOrden2');
                borramsg();
            }
        }
    });
}
//NUEVA PETICION PARA MATCH MATERIAL 2 (ANTES EQUIPO 2)
function ConsultarEquipo2() {
        var acc = "ConsultaMatchMate2";
        var idioma = $('#Idioma').val();
        var eq = $('#equBus2').val();
        var Deq = $('#denEqBus2').val();
        var cant = $('#numAcMax11').val();
        var datos = "&Equipo=" + eq + "&DEquipo=" + Deq + "&ctd=" + cant + "&Idioma=" + idioma;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloListaOrdenesPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + datos,
            success: function (data) {
                if (data == 0) {
                    ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    $('#BuscarParamE2').hide();
                    $('#ConsultaTablaEquipo2').show();
                    $('#cargarDatosEquipo2').html(data);
                    fnc('table-scrollEquipo2', 'fixedYEquipo2');
                    borramsg();
                }
            }
        });
    }
function mostrarVentanaModal(id, handle, tipo)
{
    switch (tipo) {
        case "CClaseOrden":
            $('#numAcMax').val('500');
            $('#Ctextobreve').val('');
            $('#' + tipo).val('');
            break;
        case "NumOrden_Bus":
            $('#numAcMax2').val('500');
            $('#TextoOrden_Bus').val('');
            $('#' + tipo).val('');
            break;
        case "FoliSAM_ord":
            $('#numAcMax3').val('500');
            $('#TextoSAM_ord').val('');
            $('#' + tipo).val('');
            break;
//        case "UbitteBus":
//            $('#numAcMax4').val('500');
//            $('#DUbitectBus').val('');
//            $('#' + tipo).val('');
//            break;
        case "equBus":
            $('#numAcMax5').val('500');
            $('#denEqBus').val('');
            $('#' + tipo).val('');
            break;
//        case "puestp":
//            $('#numAcMax6').val('500');
//            $('#Ptexto_mate').val('');
//            $('#' + tipo).val('');
//            break;
        case "CClaseOrden2":
            $('#numAcMax7').val('500');
            $('#Ctextobreve2').val('');
            $('#' + tipo).val('');
            break;
        case "NumOrden_Bus2":
            $('#numAcMax8').val('500');
            $('#TextoOrden_Bus2').val('');
            $('#' + tipo).val('');
            break;
        case "FoliSAM_ord2":
            $('#numAcMax9').val('500');
            $('#TextoSAM_ord2').val('');
            $('#' + tipo).val('');
            break;
//        case "UbitteBus2":
//            $('#numAcMax10').val('500');
//            $('#DUbitectBus2').val('');
//            $('#' + tipo).val('');
//            break;
        case "equBus2":
            $('#numAcMax11').val('500');
            $('#denEqBus2').val('');
            $('#' + tipo).val('');
            break;
//        case "puestp2":
//            $('#numAcMax12').val('500');
//            $('#Ptexto_mate2').val('');
//            $('#' + tipo).val('');
//            break;

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
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#IDFecha").val(id);
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
}
function seleccionar(obj, tipo) {
    switch (tipo) {
        case "ClaseOrden":
            $('#clOrdL').val(obj);
            ocultarVentana('VentanaModalClaseOrden', 'BuscarParamCOr', 'ConsultaTablaClaseOrden', 'clOrdL');
            break;
        case "ClaseOrden2":
            $('#clOrdL2').val(obj);
            ocultarVentana('VentanaModalClaseOrden2', 'BuscarParamCOr2', 'ConsultaTablaClaseOrden2', 'clOrdL2');
            break;
        case "Orden":
            $('#OrdeL').val(obj);
            ocultarVentana('VentanaModalOrden', 'BuscarParam_OR', 'ConsultaTablaOrden', 'OrdeL');
            break;
        case "SAM":
            $('#SAMOrden').val(obj);
            ocultarVentana('VentanaModalSAM', 'BuscarParam_SAM', 'ConsultaTablaSAM', 'SAMOrden');
            break;
        case "UbicacionTec":
            $('#ubitl').val(obj);
            ocultarVentana('VentanaModalUbiTec', 'BuscarParamUbi', 'ConsultaTablaUbicacion', 'ubitl');
            break;
        case "Equipo":
            $('#equiL').val(obj);
            ocultarVentana('VentanaModalEquipos', 'BuscarParamE', 'ConsultaTablaEquipo', 'equiL');
            break;
        case "Puesto":
            $('#ptol').val(obj);
            ocultarVentana('VentanaModalPuesto', 'BuscarParamPt', 'ConsultaTablaPuesto', 'ptol');
            break;
        case "Orden2":
            $('#OrdeL2').val(obj);
            ocultarVentana('VentanaModalOrden2', 'BuscarParam_OR2', 'ConsultaTablaOrden2', 'OrdeL2');
            break;
        case "SAM2":
            $('#SAMOrden2').val(obj);
            ocultarVentana('VentanaModalSAM2', 'BuscarParam_SAM2', 'ConsultaTablaSAM2', 'SAMOrden2');
            break;
        case "UbicacionTec2":
            $('#ubitl2').val(obj);
            ocultarVentana('VentanaModalUbiTec2', 'BuscarParamUbi2', 'ConsultaTablaUbicacion2', 'ubitl2');
            break;
        case "Equipo2":
            $('#equiL2').val(obj);
            ocultarVentana('VentanaModalEquipos2', 'BuscarParamE2', 'ConsultaTablaEquipo2', 'equiL2');
            break;
        case "Puesto2":
            $('#ptol2').val(obj);
            ocultarVentana('VentanaModalPuesto2', 'BuscarParamPt2', 'ConsultaTablaPuesto2', 'ptol2');
            break;
    }
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

function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
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