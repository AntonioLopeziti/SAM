$(document).ready(function () {

    var Descr = $('#Descri');
    var Mate = $('#Material');
//    var UbiTe = $('#UbiTec');
    var PtoTj = $('#PtoTjo');
    var CntHR = $('#ContHR');
    var FxI = $('#fechIni');
    var FxF = $('#fechFin');    
    $('#matchF1').hide();
    $('#matchF2').hide();
    
    $('#matchF1').click(function () {
        OpenCalendario("fechIni");
    });

    $('#matchF2').click(function () {
        OpenCalendario("fechFin");
    });    
    $('#CerraCalendar1').click(function (e) {
        CerrarCalendario();
    });
    $('#calenimg').click(function (e) {
        CerrarCalendario();
    });
    
    var DatObli = [Descr, Mate, PtoTj];
    var mtcClOrd = $('#matchClOrd');
    var mtcEquipMate = $('#matchMate');
//    var mtcUbiTe = $('#matchUbiT');
    var mtcPtoTj = $('#matchPtoT');
    var mtcCntHR = $('#matchContHR');
    var mtcF1 = $('#matchF1');
    var mtcF2 = $('#matchF2');
    $('#matchF1').hide();
    $('#matchF2').hide();
    
    var divSeccionDatosRecibo = document.getElementById("capaTabs");
    var elemDatoRecibo = divSeccionDatosRecibo.getElementsByTagName("input");

    for (var j = 0; j < elemDatoRecibo.length; j++) {
        elemDatoRecibo[j].disabled = true;
    }
    divSeccionDatosRecibo.disabled = true;
    $("#tabOpe").prop("disabled", false);
    $("#tabComp").prop("disabled", false);
    
    var Matchs = [mtcClOrd, mtcEquipMate, mtcPtoTj, mtcCntHR, mtcF1, mtcF2];
    $.each(Matchs, function (ind, va) {
        va.hide();
    });
    $.each(DatObli, function (ind, va) {
        va.css("background-color", "#ffffff");
        va.css({background: 'url(images/necesario.PNG) no-repeat'});

    });
    $.each(DatObli, function (ind2, va2) {
        va2.focus(function () {
            va2.css('background-image', 'none');
            va2.css("background-color", "#ffffff");
        });
    });
    $.each(DatObli, function (i, v) {
        v.blur(function () {
            if (v.val().length > 0) {
                v.css('background-image', 'none');
                v.css("background-color", "#ffffff");
            } else {
                v.css({background: 'url(images/necesario.PNG) no-repeat'});
                v.css("background-color", "#ffffff");
            }
        });
    });
//    Mate.blur(function () {
//        var xy = UbiTe.val();
//        if (Mate.val().length > 0) {
//            UbiTe.css('background-image', 'none');
//            UbiTe.css("background-color", "#ffffff");
//            UbiTe.val(xy);
//        } else {
//            if (UbiTe.val().length > 0) {
//            } else {
//                UbiTe.css({background: 'url(images/necesario.PNG) no-repeat'});
//                UbiTe.css("background-color", "#ffffff");
//                UbiTe.val(xy);
//            }
//        }
//    });
//    UbiTe.blur(function () {
//        var xy = Equip.val();
//        if (UbiTe.val().length > 0) {
//            Equip.css('background-image', 'none');
//            Equip.css("background-color", "#ffffff");
//            Equip.val(xy);
//        } else {
//            if (Equip.val().length > 0) {
//                UbiTe.css('background-image', 'none');
//                UbiTe.css("background-color", "#ffffff");
//            } else {
//                Equip.css({background: 'url(images/necesario.PNG) no-repeat'});
//                Equip.css("background-color", "#ffffff");
//                Equip.val(xy);
//            }
//        }
//    });
    Mate.focus(function () {
        showMatch(1);
    });
//    UbiTe.focus(function () {
//        showMatch(2);
//    });
    PtoTj.focus(function () {
        showMatch(2);
    });
    CntHR.focus(function () {
        showMatch(3);
    });
    FxI.focus(function () {
        showMatch(4);
    });
    FxF.focus(function () {
        showMatch(5);
    });
    function showMatch(index) {
        $.each(Matchs, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    var matchSctd1 = $('#serCtdOp1');
    var matchSctd2 = $('#serCtdOp2');
    var matchSprec1 = $('#serPrec1');
    var matchSprec2 = $('#serPrec2');
    var matchSgrA = $('#serGrArt');
    var matchSser = $('#serGrCom1');
    var matchSgrC = $('#serGrCom2');
    var matchSclC = $('#serClCos');
    var DatObliServi = [matchSctd1, matchSctd2, matchSprec1, matchSprec2, matchSgrA, matchSser, matchSgrC, matchSclC];
    $.each(DatObliServi, function (ind, va) {
        va.css({background: 'url(images/necesario.PNG) no-repeat'});
    });
    $.each(DatObliServi, function (ind2, va2) {
        va2.focus(function () {
            va2.css('background-image', 'none');
        });
    });
    $.each(DatObliServi, function (i, v) {
        v.blur(function () {
            if (v.val().length > 0) {
                v.css('background-image', 'none');
            } else {
                v.css({background: 'url(images/necesario.PNG) no-repeat'});
            }
        });
    });
    
    var matchSnoS = $('#serNoSer');
    var matchScant = $('#serCant');
    var matchSgrpAr = $('#serGrpArt2');
    var matchSclCost = $('#serClCost');
    var DatObliServi2 = [matchSnoS, matchScant, matchSgrpAr, matchSclCost];
    $.each(DatObliServi2, function (ind, va) {
        va.css({background: 'url(images/necesario.PNG) no-repeat'});
    });
    $.each(DatObliServi2, function (ind2, va2) {
        va2.focus(function () {
            va2.css('background-image', 'none');
        });
    });
    $.each(DatObliServi2, function (i, v) {
        v.blur(function () {
            if (v.val().length > 0) {
                v.css('background-image', 'none');
            } else {
                v.css({background: 'url(images/necesario.PNG) no-repeat'});
            }
        });
    });
    
    var matchSctd = $('#matchSctd');
    var matchSpre = $('#matchSpre');
    var matchSgpoA = $('#matchSgpoA');
    var matchSgpoC1 = $('#matchSgpoC1');
    var matchSgpoC2 = $('#matchSgpoC2');
    var matchSclC = $('#matchSclC');
    var matchSacre = $('#matchSacre');


    var MatchsS1 = [matchSctd, matchSpre, matchSgpoA, matchSgpoC1, matchSgpoC2, matchSclC, matchSacre];
    $.each(MatchsS1, function (ind, va) {
        va.hide();
    });
    
    var s1ctd = $('#serCtdOp2');
    var s1pre = $('#serPrec2');
    var s1grA = $('#serGrArt');
    var s1grC1 = $('#serGrCom1');
    var s1grC2 = $('#serGrCom2');
    var s1clC = $('#serClCos');
    var s1acre = $('#serAcre');
    s1ctd.focus(function () {
        showMatchS1(0);
    });
    s1pre.focus(function () {
        showMatchS1(1);
    });
    s1grA.focus(function () {
        showMatchS1(2);
    });
    s1grC1.focus(function () {
        showMatchS1(3);
    });
    s1grC2.focus(function () {
        showMatchS1(4);
    });
    s1clC.focus(function () {
        showMatchS1(5);
    });
    s1acre.focus(function () {
        showMatchS1(6);
    });
    function showMatchS1(index) {
        $.each(MatchsS1, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    
    var matchSnoS = $('#matchSnoS');
    var matchSgrAr = $('#matchSgrAr2');
    var matchSclCs = $('#matchSclCs');
    var MatchsS2 = [matchSnoS, matchSgrAr, matchSclCs];
    $.each(MatchsS2, function (ind, va) {
        va.hide();
    });

    var s2noS = $('#serNoSer');
    var s2grA = $('#serGrpArt2');
    var s2clC = $('#serClCost');
    s2noS.focus(function () {
        showMatchS2(0);
    });
    s2grA.focus(function () {
        showMatchS2(1);
    });
    s2clC.focus(function () {
        showMatchS2(2);
    });
    function showMatchS2(index) {
        $.each(MatchsS2, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#matchSclC').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle16");
        var theRoot = document.getElementById("VentanaModalNumCM");
        $('#VentanaModalNumCM').css('z-index', 999999);
        $('#VentanaModalServicios').css('z-index', 1);
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('NumCM');
    });
    $('#matchSgpoA').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle13");
        var theRoot = document.getElementById("VentanaModalGpoA");
        $('#VentanaModalGpoA').css('z-index', 999999);
        $('#VentanaModalServicios').css('z-index', 1);
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('GpoArt');
    });
    $("#matchSacre").click(function () {
        consultaSacre();
    });
    $('#serAcre').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSacre();
        }
    });
    $('#gpoAtxt').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSgpoA();
        }
    });
    $("#okNumCM").click(function () {
        consultaSnumCM();
    });
    $("#okGpoArt").click(function () {
        consultaSgpoA();
    });
    $("#cerrarmodalTL").click(function () {
        ocultartexa();
    });
    $("#xDescri").click(function () {
        borrarTxtDes();
    });
    $("#okDescri").click(function () {
        guardarDecri();
    });
    $('#matchSclCs').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle18");
        var theRoot = document.getElementById("VentanaModalNumCM2");
        $('#VentanaModalNumCM2').css('z-index', 999999);
        $('#VentanaModalServicios').css('z-index', 1);
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('NumCM2');
    });

    $('#matchSnoS').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle17");
        var theRoot = document.getElementById("VentanaModalNumS");
        $('#VentanaModalNumS').css('z-index', 999999);
        $('#VentanaModalServicios').css('z-index', 1);
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('NumS');
    });

    $("#okNumS").click(function () {
        consultaSnumS();
    });
    $('#matchMate').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle1");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Material');
    });
    $('#Material').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle1");
            var theRoot = document.getElementById("VentanaModalEquipo");
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('Material');
        }
    });
    $("#okEquipo").click(function () {
        ConsultarMate();
    });
    $('#denEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarMate();
        }
    });
    $('#numEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarMate();
        }
    });
    $('#numAcMaxEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarMate();
        }
    });
    
    $("#matchClOrd").click(function () {
        mostrarVentanaModal('ClaseOr');
    });
    
    $("#matchContHR").click(function () {
        mostrarVentanaModal("ContaHR");
    });
    $('#ContHR').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            mostrarVentanaModal('ContaHR');
            $('#ContHR').blur();
        }
    });
    $('#NumHR').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            mostrarVentanaModal('ContaHR');
            $('#NumHR').blur();
        }
    });
    $("#matchLstMat").click(function () {
        mostrarVentanaModal('LstMat');
    });
    $('#NumLstMat').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            mostrarVentanaModal('LstMat');
            $('#NumLstMat').blur();
        }
    });

    $('#matchPtoT').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalPtoTr");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('PtoTr');
    });
    $('#PtoTjo').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle4");
            var theRoot = document.getElementById("VentanaModalPtoTr");
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('PtoTr');
        }
    });
    $('#serNoSer').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle17");
            var theRoot = document.getElementById("VentanaModalNumS");
            $('#VentanaModalNumS').css('z-index', 999999);
            $('#VentanaModalServicios').css('z-index', 1);
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('NumS');
        }
    });

    $("#okPtoTr").click(function () {
        ConsultarPtoTr();
    });
    $('#clasePto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarPtoTr();
        }
    });
    $('#centroPto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarPtoTr();
        }
    });
    $('#ptoTrM').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarPtoTr();
        }
    });
    $('#descriPto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarPtoTr();
        }
    });
    $('#numAcMaxPto').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarPtoTr();
        }
    });



    $("#okMat").click(function () {
        matchTCMatOk();

    });

    $("[id*=TCcant]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("[id*=TOcant]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });

    $("[id*=TOdura]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serCtdOp1").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serPrecEst1").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serCant").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serPrec1").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serPrecEst1").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });

    $("#btnTomOpe").click(function () {
        validarCamposOpe();
    });
    $("#btnTomComp").click(function () {
        validarCamposComp();
    });


    $("[id*=TOsta]").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            popUpSta();
        }
    });
    $("[id*=TCmat]").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            findMat();
        }
    });

    $('#serCtdOp2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSctd();
        }
    });
    $('#serGrArt').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle13");
            var theRoot = document.getElementById("VentanaModalGpoA");
            $('#VentanaModalGpoA').css('z-index', 999999);
            $('#VentanaModalServicios').css('z-index', 1);
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('GpoArt');
        }
    });
    $('#serGrCom1').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSgpoC1();
        }
    });
    $('#serGrCom2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSgpoC2();
        }
    });
    $('#serPrec2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSclvM();
        }
    });
    $('#matchClCoste').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumCM();
        }
    });
    $('#matchTxtCl').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumCM();
        }
    });
    $('#numAcMaxNumCM').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumCM();
        }
    });
    $('#numStxtB').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumS();
        }
    });
    $('#numSnum').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumS();
        }
    });
    $('#numAcMaxNumServicio').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSnumS();
        }
    });
    $('#serClCos').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle16");
            var theRoot = document.getElementById("VentanaModalNumCM");
            $('#VentanaModalNumCM').css('z-index', 999999);
            $('#VentanaModalServicios').css('z-index', 1);
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('NumCM');
        }
    });
    $('#serClCost').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            var theHandle = $('#handle18');
            var theRoot = $('#VentanaModalNumCM2');
            $('#VentanaModalNumCM2').css('z-index', 999999);
            $('#VentanaModalServicios').css('z-index', 1);
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('NumCM2');
        }
    });

    $('#btnDeleteTO').click(function () {
        checkBoxsFull();
    });
    $('#EliminarOpeY').click(function () {
        checarDelRowOpe();
        CerrarMensajeEliminarOperacion();
    });
    $('#EliminarOpeN').click(function () {
        CerrarMensajeEliminarOperacion();
    });
  
});
var idioma = $('#mjIdioma').val();
var url, acc;
var iconm = $('#iconmsg');
var RowPope;
var rowAdO = 0;
var posicionT;
var posSta;
var posOrd;
var posMat;
var status;
var contMat;
var rowFullOpe;
var checkAdd = 0;
var checkXd;
var addRowNope = 0;
var numerosAparecidos = [];
var rowMate = 0;
var rowComp;
var rowAdC = 0;
var rowServi = 0;
var insCab;
var insOpe;
function noRowSelMsj() {
    var menCam = "Sin datos en la tabla para eliminar";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}
function checkBoxsFull() {
    var i = 0;
    $("#TablaOperaciones input[type=checkbox]:checked").each(function () {
        i++;
    });
    if (i == 0) {
        noRowSelMsj();
    } else {
        blockPropiety('handleDocMod', 'MensajeSalirModulo');
        MensajeEliminarOpe();
    }
    return i;
}
// FUNCIONES AUXILIARES PARA MATCH'S


function ocultarVentana(tipo) {
    switch (tipo) {
        case "NumS":
            var ventana = $('#VentanaModalNumS');
            ventana.hide();
            $('#BuscarParamNumS').show();
            $('#ConsultaTablaNumS').hide();
            $('#serNoSer').focus();
            $('#overlay').remove();
            break;
        case "NumCM2":
            var ventana = $('#VentanaModalNumCM2');
            ventana.hide();
            $('#BuscarParamNumCM2').show();
            $('#ConsultaTablaNumCM2').hide();
            $('#serClCost').focus();
            $('#overlay').remove();
            break;
        case "NumCM":
            var ventana = $('#VentanaModalNumCM');
            ventana.hide();
            $('#BuscarParamNumCM').show();
            $('#ConsultaTablaNumCM').hide();
            $('#serClCos').focus();
            $('#overlay').remove();
            break;
        case "GpoArt":
            var ventana = $('#VentanaModalGpoA');
            ventana.hide();
            $('#BuscarParamGpoArt').show();
            $('#ConsultaTablaGpoA').hide();
            $('#serClCos').focus();
            $('#overlay').remove();
            break;
        case "Material":
            var ventana = $('#VentanaModalEquipo');
            ventana.hide();
            $('#BuscarParamEquipo').show();
            $('#ConsultaTablaEquipo').hide();
            $('#Material').focus();
            $('#overlay').remove();
            break;
        case "UbiT":
            var ventana = $('#VentanaModalUbiT');
            ventana.hide();
            $('#BuscarParamUbiT').show();
            $('#ConsultaTablaUbiT').hide();
            $('#UbiTec').focus();
            $('#overlay').remove();
            break;
        case "CentroP":
            var ventana = $('#VentanaModalCentroP');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "ClaveCtrl":
            var ventana = $('#VentanaModalClaveCtrl');
            ventana.hide();
            ventana = $('#VentanaModalCentroP');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "Centro":
            var ventana = $('#VentanaModalCentro');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "lote":
            var ventana = $('#VentanaModalLote');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "ClaseOr":
            var ventana = $('#VentanaModalClaseOr');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "ContaHR":
            var ventana = $('#VentanaModalContaHR');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "LstMat":
            var ventana = $('#VentanaModalLstMat');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "UMD":
            var ventana = $('#VentanaModalUMD');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "Almacen":
            var ventana = $('#VentanaModalAlmacen');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "GpoA":
            var ventana = $('#VentanaModalGpoA');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "Acreedor":
            var ventana = $('#VentanaModalAcreedor');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "GpoC":
            var ventana = $('#VentanaModalGpoC');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "sClvM":
            var ventana = $('#VentanaModalClvM');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "GpoC2":
            var ventana = $('#VentanaModalGpoC2');
            ventana.hide();
            $('#overlay').remove();
            break;
        case "PtoTr":
            var ventana = $('#VentanaModalPtoTr');
            ventana.hide();
            $('#BuscarParamPtoTr').show();
            $('#ConsultaTablaPtoTr').hide();
            $('#overlay').remove();
            break;
        case "Mat":
            var ventana = $('#VentanaModalMat');
            ventana.hide();
            $('#BuscarParamMat').show();
            $('#ConsultaTablaMat').hide();
            $('#overlay').remove();
            break;
        case "Servi":
            var ventana = $('#VentanaModalServicios');
            ventana.hide();
            $('#ParamServi1').show();
            $('#ParamServi2').hide();
            $('#overlay').remove();
            break;
    }
}
function mostrarVentanaModal(tipo) {
    switch (tipo) {
        case "NumS":
            blockPropiety('handle17', 'VentanaModalNumS');
            var cl = $('#numStxtB');
            cl.focus();
            break;
        case "NumCM2":
            blockPropiety('handle18', 'VentanaModalNumCM2');
            var cl = $('#matchClCoste2');
            cl.focus();
            break;
        case "NumCM":
            blockPropiety('handle16', 'VentanaModalNumCM');
            var cl = $('#matchClCoste');
            cl.focus();
            break;
        case "GpoArt":
            returnRestri('BuscarParamGpoArt', 'ConsultaTablaGpoA', 'gpoAtxt');
            blockPropiety('handle13', 'VentanaModalGpoA');
            var cl = $('#gpoAtxt');
            cl.focus();
            break;
        case "Material":
            blockPropiety('handle1', 'VentanaModalEquipo');
            var equipo = $('#denEqui');
            equipo.focus();
            break;
        case "UbiT":
            blockPropiety('handle2', 'VentanaModalUbiT');
            var ut = $('#denUbiT');
            ut.focus();
            break;
        case "ClaseOr":
            ConsultarClaseOr();
            break;
        case "ContaHR":
            validarNumEquiHR();
            break;
        case "PtoTr":
            blockPropiety('handle4', 'VentanaModalPtoTr');
            var denT = $('#clasePto');
            denT.focus();
            break;
        case "Mat":
            blockPropiety('handle9', 'VentanaModalMat');
            var txtm = $('#txtMatMatch');
            txtm.focus();
            break;
    }
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

function Select(obj, tipo) {
    switch (tipo) {
        case "sClvM":
            ocultarVentana('sClvM');
            var vl = $('#serPrec2');
            vl.val(obj);
            vl.focus();
            break;
        case "sNumS":
            ocultarVentana('NumS');
            var vl = $('#serNoSer');
            vl.val(obj);
            vl.focus();
            break;
        case "sNumCM2":
            ocultarVentana('NumCM2');
            var vl = $('#serClCost');
            vl.val(obj);
            vl.focus();
            break;
        case "sNumCM":
            ocultarVentana('NumCM');
            var vl = $('#serClCos');
            vl.val(obj);
            vl.focus();
            break;
        case "sGpoC2":
            ocultarVentana('GpoC2');
            var vl = $('#serGrCom2');
            vl.val(obj);
            vl.focus();
            break;
        case "sGpoC1":
            ocultarVentana('GpoC');
            var vl = $('#serGrCom1');
            vl.val(obj);
            vl.focus();
            break;
        case "sGpoA2":
            ocultarVentana('GpoA');
            var vl = $('#serGrpArt2');
            vl.val(obj);
            vl.focus();
            break;
        case "sGpoA":
            ocultarVentana('GpoA');
            var vl = $('#serGrArt');
            vl.val(obj);
            vl.focus();
            break;
        case "sAcre":
            ocultarVentana('Acreedor');
            var vl = $('#serAcre');
            vl.val(obj);
            vl.focus();
            break;
        case "sUMC":
            ocultarVentana('UMD');
            var vl = $('#serCtdOp2');
            vl.val(obj);
            vl.focus();
            break;
        case "Material":
            ocultarVentana('Material');
            var eq = $('#Material');
            eq.val(obj);
            eq.focus();
//            Esta funcionalidad queda pendiente por el proceso con las tablas
//            cargarEqui();
            break;
        case "UbiT":
            ocultarVentana('UbiT');
            var ub = $('#UbiTec');
            ub.val(obj);
            ub.focus();
            break;
        case "PtoTr":
            ocultarVentana('PtoTr');
            var pt = $('#PtoTjo');
            pt.val(obj);
            pt.focus();
            break;
        case "ContaHR":
            ocultarVentana('ContaHR');
            var cont = $('#ContHR');
            cont.val(obj);
            cont.focus();
            break;
        case "LstMat":
            ocultarVentana('LstMat');
            var lstM = $('#NumLstMat');
            lstM.val(obj);
            lstM.focus();
            break;
    }
}
function Select2(obj, tipo) {
    switch (tipo) {
        case "ContaHR":
            ocultarVentana('ContaHR');
            var cont = $('#NumHR');
            cont.val(obj);
            cont.focus();
            break;
        case "txtS":
            var cont = $('#txtServi');            
            cont.val(obj);
            break;
        case "LstMat":
            var alt = $('#altMat');
            alt.val(obj);
            break;
    }
}
function Select3(obj, tipo) {
    switch (tipo) {
        case "umdS":
            var cont = $('#umdServi');
            cont.val(obj);
            cont.focus();
            break;
    }
}
function giveHora() {
    var fecha = new Date();
    var hora = fecha.getHours();
    var minuto = fecha.getMinutes();
    var segundo = fecha.getSeconds();

    if (hora < 10) {
        hora = "0" + hora;
    }
    if (minuto < 10) {
        minuto = "0" + minuto;
    }
    if (segundo < 10) {
        segundo = "0" + segundo;
    }
    var horita = hora + ":" + minuto + ":" + segundo;
    return horita;
}
function giveHoy() {
    var hoy = new Date();
    var dd = hoy.getDate();
    var mm = hoy.getMonth() + 1;
    var yyyy = hoy.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    hoy = dd + '.' + mm + '.' + yyyy;
    return hoy;
}

function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function datosincorrectos() {
    var menCam = $('#mjDatosIncorrectos').val();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}
function unidadInvalida() {
    var menCam = $('#mjUmdInv').val();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}
function datosFaltantes() {
    var msj = 'Faltan Datos Obligatorios';
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(msj);
}
function invalidMate() {
    var msj = 'Material Invalido';
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(msj);
}

// CONSULTAS Match's
function CargarClaseOrPP() {
    acc = "ConsultaMatchClaseOr";
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            $('#ClOrden').html(rs);
        }
    });
}
//Nueva Funcion Consultar Material (Antes Equipo)
function ConsultarMate() {
    acc = "ConsultaMatchMate";
    var denomMat = $('#denEqui').val();
    var numMat = $('#numEqui').val();
    var ctdMat = $('#numAcMaxEqui').val();
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&denMat=" + denomMat + "&numMat=" + numMat + "&ctdMat=" + ctdMat + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamEquipo').hide();
                $('#ConsultaTablaEquipo').show();
                $('#cargarDatosEquipo').html(rs);
                fncEquipo();
                borrarmsg();
            }
        }
    });
}
//No se ocupa Ubicacion Tecnica
//function ConsultarUbiT() {
//    acc = "ConsultaMatchUbiT";
//    var denUT = $('#denUbiT').val();
//    var ubiT = $('#ubiTecM').val();
//    var cant = $('#numAcMaxUbiT').val();
//    $.ajax({
//        async: false,
//        type: 'GET',
//        url: 'peticionModuloCrearOrden',
//        contentType: "application/x-www-form-urlencoded",
//        processData: true,
//        data: "acc=" + acc + "&denUT=" + denUT + "&ubiT=" + ubiT + "&ctdUt=" + cant + "&Idioma=" + idioma,
//        success: function (rs) {
//            if (rs == 0) {
//                datosincorrectos();
//            } else {
//                $('#BuscarParamUbiT').hide();
//                $('#ConsultaTablaUbiT').show();
//                $('#cargarDatosUbiT').html(rs);
//                fncUbiT();
//                borrarmsg();
//            }
//        }
//    });
//}
function ConsultarPtoTr() {
    acc = "ConsultaMatchPtoTr";
    var clasPto = $('#clasePto').val();
    var centP = $('#centroPto').val();
    var ptoTr = $('#ptoTrM').val();
    var desPtoT = $('#descriPto').val();
    var ctd = $('#numAcMaxPto').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&clPtoTr=" + clasPto + "&centPto=" + centP + "&ptoTrM=" + ptoTr + "&desPto=" + desPtoT + "&ctdPto=" + ctd + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamPtoTr').hide();
                $('#ConsultaTablaPtoTr').show();
                $('#cargarDatosPtoTr').html(rs);
                fncPtoTr();
                borrarmsg();
            }
        }
    });
}
function CargarCentroPPP() {
    acc = "ConsultaMatchCentroP";
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (rs) {            
            $('#CentPl').html(rs);
            getCentroActualPP();
        }
    });
}
function ConsultarContaHRPP() {
    acc = "ConsultaMatchContaHR";
    var equi = $("#Equipo");
    var dataSend = "&equi=BAJA10500101";
//    var dataSend = "&equi=" + equi.val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle6', 'VentanaModalContaHR');
                $('#cargarDatosContaHR').html(rs);
                fncContaHR();
                borrarmsg();
            }
        }
    });
}
//FUNCIONES Ajustar Tamaño Match's
function fncCentro() {
    $('#table-scrollCentro').scroll(function () {
        $('#fixedYCentro').css({top: $('#scrollCentro').scrollTop()});
    });
}
function fncLstMat() {
    $('#table-scrollLstMat').scroll(function () {
        $('#fixedYLstMat').css({top: $('#scrollLstMat').scrollTop()});
    });
}
function fncCentroP() {
    $('#table-scrollCentroP').scroll(function () {
        $('#fixedYCentroP').css({top: $('#scrollCentroP').scrollTop()});
    });
}
function fncContaHR() {
    $('#table-scrollContaHR').scroll(function () {
        $('#fixedYContaHR').css({top: $('#table-scrollContaHR').scrollTop()});
    });
}
function fncClaseOr() {
    $('#table-scrollClaseOr').scroll(function () {
        $('#fixedYClaseOr').css({top: $('#table-scrollClaseOr').scrollTop()});
    });
}
function fncPtoTr() {
    $('#table-scrollPtoTr').scroll(function () {
        $('#fixedYPtoTr').css({top: $('#table-scrollPtoTr').scrollTop()});
    });
}
function fncEquipo() {
    $('#table-scrollEquipo').scroll(function () {
        $('#fixedYEquipo').css({top: $('#table-scrollEquipo').scrollTop()});
    });
}
function fncUbiT() {
    $('#table-scrollUbiT').scroll(function () {
        $('#fixedYUbiT').css({top: $('#table-scrollUbiT').scrollTop()});
    });
}
function fncUMD() {
    $('#table-scrollUMD').scroll(function () {
        $('#fixedYUMD').css({top: $('#table-scrollUMD').scrollTop()});
    });
}
function fncClvM() {
    $('#table-scrollClvM').scroll(function () {
        $('#fixedYClvM').css({top: $('#table-scrollClvM').scrollTop()});
    });
}
function fncLot() {
    $('#table-scrollLot').scroll(function () {
        $('#fixedYLot').css({top: $('#table-scrollLot').scrollTop()});
    });
}
function fncMat() {
    $('#table-scrollMat').scroll(function () {
        $('#fixedYMat').css({top: $('#table-scrollMat').scrollTop()});
    });
}
function fncGpoA() {
    $('#table-scrollGpoA').scroll(function () {
        $('#fixedYGpoA').css({top: $('#table-scrollGpoA').scrollTop()});
    });
}
function fncGpoC() {
    $('#table-scrollGpoC').scroll(function () {
        $('#fixedYGpoC').css({top: $('#table-scrollGpoC').scrollTop()});
    });
}
function fncGpoC2() {
    $('#table-scrollGpoC2').scroll(function () {
        $('#fixedYGpoC2').css({top: $('#table-scrollGpoC2').scrollTop()});
    });
}
function fncNumCM() {
    $('#table-scrollNumCM').scroll(function () {
        $('#fixedYNumCM').css({top: $('#table-scrollNumCM').scrollTop()});
    });
}
function fncNumCM2() {
    $('#table-scrollNumCM2').scroll(function () {
        $('#fixedYNumCM2').css({top: $('#table-scrollNumCM2').scrollTop()});
    });
}
function fncNumS() {
    $('#table-scrollNumS').scroll(function () {
        $('#fixedYNumS').css({top: $('#table-scrollNumS').scrollTop()});
    });
}

//FUNCIONES Cargar Datos del input Equipo
function cargarEqui() {
    acc = "cargarDataEquipo";
    var equi = $('#Equipo').val();
    $.ajax({
        async: true,
        type: 'GET',
        dataType: "json",
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&equi=" + equi,
        success: function (rs) {
            var n = rs;
//            alert(rs);
            if (n[0] == "x") {
                $('#UbiTec').val("");
                $('#PtoTjo').val("");
                $('#NumHR').val("");
                $('#ContHR').val("");
                $('#NumLstMat').val("");
                $('#altMat').val("");
                camposEqui();
            } else {
                $('#UbiTec').val(checkNull(n[0]));
                $('#CentPl').val(checkNull(n[1]));
                $('#PtoTjo').val(checkNull(n[2]));
                $('#NumHR').val(checkNull(n[3]));
                $('#ContHR').val(checkNull(n[4]));
                $('#NumLstMat').val(checkNull(n[5]));
                $('#altMat').val(checkNull(n[6]));
                camposEqui();
            }
        }
    });
}
function checkNull(data) {
    if (data == "null") {
        data = "";
    } else {

    }
    return data;
}
function camposEqui() {
    var ClOrd = $('#ClOrden');
    var Descr = $('#Descri');
    var Equip = $('#Material');    
    var CentP = $('#CentPl');
    var PtoTj = $('#PtoTjo');
    var DatObli = [ClOrd, Descr, Equip, CentP, PtoTj];
    $.each(DatObli, function (i, v) {
        if (v.val().length > 0) {
//            Equip
            v.css('background-image', 'none');
            v.css("background-color", "#ffffff");
        } else {
            v.css({background: 'url(images/necesario.PNG) no-repeat'});
            v.css("background-color", "#ffffff");
        }
    });
}
function tabOpe() {
    var check1 = checkEmptyTableComp();
    if (check1 == 2) {

        var menCam = "Complete las Operaciones";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        var men = $('#msg');
        men.html(menCam);
        checkEmptyTableComp();
    } else {
        borrarmsg();

        $(this).css({backgroundColor: 'red'});
        $(this).css('color', 'red');

        $('#seccionOpe').show();
        $('#tabOpe').css({backgroundColor: '#007CC0'});
        $('#tabOpe').css('color', '#fff');
        $('#seccionComp').hide();
        $('#tabComp').css({backgroundColor: '#fff'});
        $('#tabComp').css('color', '#000');
    }
}

function validarNumEquiHR() {
    var mt = $("#Material");
    if (mt.val().length < 1) {
        datosFaltantes();
        mt.focus();
    } else {
        var check = getExisNumMate(mt.val());
        if (check == 1) {
            ConsultarContaHRPP();
        } else if (check == 0) {
            invalidMate();
        }
    }
}
function checkEmptyTableComp() {
    var rows = rowsOfTable('TablaComponentes');
    var row, rowFull = 0;
    try {
        for (var i = 0; i < rows; i++) {
            row = giveDataComp(i);
            if (row == "1111111") {
                rowFull++;
                rowComp = rowFull;
            } else if (row == "0000000") {
                if (rowFull > 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                checkCellEmptyComp(i, row);
                return 2;
            }
        }
    } catch (e) {
    }
}
function rowsOfTable(table) {
    var rows = $('#' + table + ' >tbody >tr').length;
    return rows;
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function datosincorrectos() {
    var menCam = $('#mjDatosIncorrectos').val();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}
function bloq() {
    $('#iconmsg').hide();
    $('#aceptar').prop("disabled", true);
}

function getExisNumMate(mater) {
    var type;
    var dataSend = "&mater=" + mater;
    var acc = "validarNumMat";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            type = data;
        }
    });
    return type;
}


function getCentroActualPP() {
    var acc = "consultarCentroAct";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloCrearOrdenPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (data) {            
            $('#CentPl').val(data);
        }
    });

}