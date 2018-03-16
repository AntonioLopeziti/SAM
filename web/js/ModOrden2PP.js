$(document).ready(function () {

    var ClOrd = $('#ClOrden');
    var Descr = $('#Descri');
    var Equip = $('#Equipo');
    var UbiTe = $('#UbiTec');
    var CentP = $('#CentPl');
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

    var DatObli = [ClOrd, Descr, Equip, CentP, PtoTj];
    var mtcClOrd = $('#matchClOrd');
    var mtcEquip = $('#matchEqui');
    var mtcUbiTe = $('#matchUbiT');
    var mtcCentP = $('#matchCentP');
    var mtcPtoTj = $('#matchPtoT');
    var mtcCntHR = $('#matchContHR');
    var mtcLstMat = $('#matchLstMat');
    var mtcF1 = $('#matchF1');
    var mtcF2 = $('#matchF2');
    $("#TablaComponentes").find(":text").prop('readonly', true);
    $("#TablaOperaciones").find(":text").prop('readonly', true);
    $('#TablaOperaciones').off('blur', ':text');

    var Matchs = [mtcClOrd, mtcEquip, mtcUbiTe, mtcPtoTj, mtcCntHR, mtcF1, mtcF2];
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
    Equip.blur(function () {
        var xy = UbiTe.val();
        if (Equip.val().length > 0) {
            UbiTe.css('background-image', 'none');
            UbiTe.css("background-color", "#ffffff");
            UbiTe.val(xy);
        } else {
            if (UbiTe.val().length > 0) {
            } else {
//                UbiTe.css({background: 'url(images/necesario.PNG) no-repeat'});
//                UbiTe.css("background-color", "#ffffff");
                UbiTe.val(xy);
            }
        }
    });
    UbiTe.blur(function () {
        var xy = Equip.val();
        if (UbiTe.val().length > 0) {
            Equip.css('background-image', 'none');
            Equip.css("background-color", "#ffffff");
            Equip.val(xy);
        } else {
            if (Equip.val().length > 0) {
                UbiTe.css('background-image', 'none');
                UbiTe.css("background-color", "#ffffff");
            } else {
                Equip.css({background: 'url(images/necesario.PNG) no-repeat'});
                Equip.css("background-color", "#ffffff");
                Equip.val(xy);
            }
        }
    });

    Equip.focus(function () {
        showMatch(1);
    });
    UbiTe.focus(function () {
        showMatch(2);
    });
    PtoTj.focus(function () {
        showMatch(3);
    });
    CntHR.focus(function () {
        showMatch(4);
    });
    FxI.focus(function () {
        showMatch(5);
    });
    FxF.focus(function () {
        showMatch(6);
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
    var matchSsoli = $('#serSoli');
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
        consultaSacre()();
    });
    $("#okNumCM").click(function () {
        consultaSnumCM();
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

    $("#okNumCM2").click(function () {
        consultaSnumCM2();
    });
    $("#cerrarmodalTL").click(function () {
        ocultartexa();
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
    $('#matchEqui').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle1");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Equipo');
    });
    $('#Equipo').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle1");
            var theRoot = document.getElementById("VentanaModalEquipo");
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('Equipo');
        }
    });
    $("#okEquipo").click(function () {
        ConsultarEquipo();
    });
    $('#denEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarEquipo();
        }
    });
    $('#numEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarEquipo();
        }
    });
    $('#numAcMaxEqui').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarEquipo();
        }
    });

    $('#matchUbiT').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalUbiT");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('UbiT');
    });
    $('#UbiTec').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $("BODY").append('<div id="overlay"></div>');
            var theHandle = document.getElementById("handle2");
            var theRoot = document.getElementById("VentanaModalUbiT");
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('UbiT');
        }
    });
    $("#okUbiT").click(function () {
        ConsultarUbiT();
    });
    $('#denUbiT').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUbiT();
        }
    });
    $('#ubiTecM').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUbiT();
        }
    });
    $('#numAcMaxUbiT').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarUbiT();
        }
    });

    $("#matchCentP").click(function () {
        mostrarVentanaModal('CentroP');
    });
    $('#CentPl').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            mostrarVentanaModal('CentroP');
            $('#CentPl').blur();
        }
    });

    $("#matchClOrd").click(function () {
        mostrarVentanaModal('ClaseOr');
    });
    $('#ClOrden').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            mostrarVentanaModal('ClaseOr');
            $('#ClOrden').blur();
        }
    });

    $("#matchContHR").click(function () {
        mostrarVentanaModal('ContaHR');
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
    $('#gpoAtxt').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            consultaSgpoA();
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
        patron = /[0-9]/;
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
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serPrecEst1").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $("#serCant").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9]/;
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
    $('#serClCost').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            var theHandle = document.getElementById("handle18");
            var theRoot = document.getElementById("VentanaModalNumCM2");
            $('#VentanaModalNumCM2').css('z-index', 999999);
            $('#VentanaModalServicios').css('z-index', 1);
            Drag.init(theHandle, theRoot);
            mostrarVentanaModal('NumCM2');
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
    $("#xDescri").click(function () {
        borrarTxtDes();
    });
    $("#okDescri").click(function () {
        guardarDecri();
    });
    $("#okGpoArt").click(function () {
        consultaSgpoA();
    });
});
var posicionT;
var posSta;
var posOrd;
var posMat;
var status;
var contMat;
var rowFullOpe;
var checkAdd = 0;
var checkXd;
var RowPope;
var rowAdO = 0;
var acc;
var idioma = $('#mjIdioma').val();
function noRowSelMsj() {
    var menCam = "No existen columnas seleccionadas";
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
//FUNCIONES CARGAR ORDEN
function CargarClaseOr() {
    acc = "ConsultaMatchClaseOr";
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            $('#ClOrden').html(rs);
        }
    });
}
function CargarCentroP() {
    acc = "ConsultaMatchCentroP";
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (rs) {
            $('#CentPl').html(rs);
        }
    });
}
function cargarPopUp1() {
    var ctdO1 = document.getElementById("serCtdOp1");
    var ctdO2 = document.getElementById("serCtdOp2");
    var preO1 = document.getElementById("serPrec1");
    var preO2 = document.getElementById("serPrec2");
    var gpoA1 = document.getElementById("serGrArt");
    var gpoC1 = document.getElementById("serGrCom1");
    var gpoC2 = document.getElementById("serGrCom2");

    var clC = document.getElementById("serClCos");
    var acre = document.getElementById("serAcre");
    var rowsM = (rowsOfTable("tablaMate") - 1);
    var check = 0;
    var opeM = document.getElementsByName('TMnoOpe');
    for (var i = 0; i < rowsM; i++) {
        if (opeM[i].value == posOrd) {
            ctdO1.value = document.getElementById("TMctdO1" + i).value;
            ctdO2.value = document.getElementById("TMctdO2" + i).value;
            preO1.value = document.getElementById("TMpre1" + i).value;
            preO2.value = document.getElementById("TMpre2" + i).value;
            gpoA1.value = document.getElementById("TMgpoA1" + i).value;
            gpoC1.value = document.getElementById("TMgpoC2" + i).value;
            gpoC2.value = document.getElementById("TMgpoC1" + i).value;
            clC.value = document.getElementById("TMclC" + i).value;
            acre.value = document.getElementById("TMacre" + i).value;
        }
    }
    ctdO2.focus();
    preO1.focus();
    preO2.focus();
    gpoA1.focus();
    gpoC1.focus();
    gpoC2.focus();
    clC.focus();
    ctdO1.focus();
}
function cargarPopUp2() {
    var noSer = document.getElementById("serNoSer");
    var cant = document.getElementById("serCant");
    var precEs1 = document.getElementById("serPrecEst1");
    var precEs2 = document.getElementById("serPrecEst2");
    var gpoA2 = document.getElementById("serGrpArt2");
    var clsC = document.getElementById("serClCost");
    var txtS = document.getElementById("txtServi");
    var umdS = document.getElementById("umdServi");
    var rowsS = (rowsOfTable("tablaServi") - 1);
    var opeS = document.getElementsByName('TSnoOpe');
    for (var i = 0; i < rowsS; i++) {
        if (opeS[i].value == posOrd) {
            noSer.value = document.getElementById("TSnoS" + i).value;
            cant.value = document.getElementById("TScant" + i).value;
            precEs1.value = document.getElementById("TSpreEs1" + i).value;
            precEs2.value = document.getElementById("TSpreEs2" + i).value;
            gpoA2.value = document.getElementById("TSgpoA2" + i).value;
            clsC.value = document.getElementById("TSclsC" + i).value;
            txtS.value = document.getElementById("TStxtS" + i).value;
            umdS.value = document.getElementById("TSumdS" + i).value;

        }
    }

    cant.focus();
    gpoA2.focus();
    clsC.focus();
    noSer.focus();
    noSer.blur();
}
function cargarOrdenCab() {
    var ord = $('#ordenFol').val();
    acc = "modCargarCab";
    var dataSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        dataType: "json",
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            $('#ClOrden').val(rs[0]);
            $('#Descri').val(rs[1]);
            $('#Equipo').val(rs[2]);
            $('#UbiTec').val(rs[3]);
            $('#CentPl').val(rs[4]);
            $('#PtoTjo').val(rs[5]);
            $('#fechIni').val(rs[6]);
            $('#fechFin').val(rs[7]);
            $('#ClOrden').focus();
            $('#Descri').focus();
            $('#Equipo').focus();
            $('#UbiTec').focus();
            $('#CentPl').focus();
            $('#PtoTjo').focus();
            $('#ContHR').focus();
            $('#NumLstMat').focus();
        }
    });
}

function plancharOpe() {
    acc = "modCargarOperaciones";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            $('#cargarDatosTabOpe').html(rs);
            refreshNumAl();
            validarDatTabOpe();
            blockEmptyOpe();
        }
    });
}
function plancharComp() {
    acc = "modCargarMateriales";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
            } else {
                $('#cargarDatosTabComp').html(rs);
                $("[id*=TCmat]").keypress(function (e) {
                    if (e.which == 13 || e.keyCode == 13) {
                        findMat();
                    }
                });
            }
        }
    });
}
function plancharOpe2() {
    acc = "modCargarOperaciones2";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
            } else {
                $('#cargarDatOpe2').html(rs);
                setTimeout(function () {

                }, 300);
                refreshNumAlOpe2();
            }
            plancharServicios();
        }
    });
}
function plancharServicios() {
    acc = "modCargarServicios";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
            } else {
                $('#cargarServiM').html(rs);
                refreshNumAlSer();
            }
        }
    });
}
function plancharTxtDes() {
    acc = "modCargarTxtDes";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;

    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
            } else {
                $('#cargarTxtD').html(rs);
                refreshNumAlTxtDes();
            }
        }
    });
}
function refreshNumAlTxtDes() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var rowsS = (rowsOfTable("tablaTxtsDes") - 1);
    var contO = document.getElementsByName('TOcont');
    var contS = document.getElementsByName('TDcont');
    var opeO = document.getElementsByName('TOope');
    var opeS = document.getElementsByName('TDnumOpe');
    for (var i = 0; i < rowsO; i++) {
        for (var d = 0; d < rowsS; d++) {
            if (opeO[i].value == opeS[d].value) {
                contS[d].value = contO[i].value;
            }
        }
    }
}
function refreshNumAlSer() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var rowsS = (rowsOfTable("tablaServi") - 1);
    var contO = document.getElementsByName('TOcont');
    var contS = document.getElementsByName('TScont');
    var opeO = document.getElementsByName('TOope');
    var opeS = document.getElementsByName('TSnoOpe');
    for (var i = 0; i < rowsO; i++) {
        for (var d = 0; d < rowsS; d++) {
            if (opeO[i].value == opeS[d].value) {
                contS[d].value = contO[i].value;
            }
        }
    }
}
function refreshNumAlOpe2() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var rowsM = (rowsOfTable("tablaMate") - 1);
    var contO = document.getElementsByName('TOcont');
    var opeO = document.getElementsByName('TOope');
    var opeM = document.getElementsByName('TMnoOpe');
    var contM = document.getElementsByName('TMcont');
    for (var i = 0; i < rowsO; i++) {
        for (var d = 0; d < rowsM; d++) {
            if (opeO[i].value == opeM[d].value) {
                contM[d].value = contO[i].value;
            }
        }
    }
}


function plancharServi() {
    var url = "peticionModuloModificarOrden";
    var acc = "modCargarServicios";
    var ord = '<%=orden%>';
    var datosSend = "&orden=" + ord;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            res = xmlhttp.responseText;
            if (res == 0) {
            } else {
                document.getElementById("cargarDatosTabComp").innerHTML = res;
                $("[id*=TCmat]").keypress(function (e) {
                    if (e.which == 13 || e.keyCode == 13) {
                        findMat();
                    }
                });
            }

        }
    };
    xmlhttp.open("GET", url + "?acc=" + acc + datosSend, true);
    xmlhttp.send();
}
function findMat() {
    var numMat = $('#TCmat' + posMat).val();
    var centro = $('#CentPl');
    if (numMat == "" || centro.val() == "") {
        var menCam = "Ingrese un Material y/o centro de planificacion";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
    } else {
        borrarmsg();
        acc = "cargarMaterial";
        var dataSend = "&numMat=" + numMat + "&Idioma=" + idioma;
        $.ajax({
            async: false,
            type: 'GET',
            dataType: "json",
            url: 'peticionModuloCrearOrden',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + dataSend,
            success: function (rs) {
                if (rs == "x") {
                    var menCam = "No existen entradas para el material - " + numMat;
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    $('#msg').html(menCam);

                } else {
                    $('#TCtxtB' + posMat).val(rs[1]);
                    $('#TCtxtB' + posMat).prop('readonly', true);
                    $('#TCcant' + posMat).val("");
                    $('#TCumc' + posMat).val(rs[2]);
                    $('#TCcent' + posMat).val(centro.val());
                    $('#TCcent' + posMat).prop('readonly', true);
                    $('#TCalm' + posMat).val('M100');
                    $('#TCalm' + posMat).prop('readonly', true);
                    $('#TCsolp' + posMat).val("");
                    $('#TCitsol' + posMat).val("");
                }
            }
        });
    }
}
// FUNCIONES TABLA MATCH OPERACIONES
function BtnShowTO(pos, type) {
    switch (type) {
        case 'match_TOptoTr':
            var rows = rowsOfTable('TablaOperaciones');
            $('.btnservicios').prop("disabled", true);
            $('#match_TOptoTr' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TOcent' + i).hide();
                    $('#match_TOsta' + i).hide();
                    $('#match_TOumd' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TOptoTr' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TOcent':
            var rows = rowsOfTable('TablaOperaciones');
            $('#btnservicios').prop("disabled", true);
            $('#match_TOcent' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TOptoTr' + i).hide();
                    $('#match_TOsta' + i).hide();
                    $('#match_TOumd' + i).hide();
                    if (i != pos) {
                        $('#match_TOcent' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TOsta':
            posSta = pos;
            $('#btnservicios').prop("disabled", false);
            var rows = rowsOfTable('TablaOperaciones');
            $('#match_TOsta' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TOptoTr' + i).hide();
                    $('#match_TOcent' + i).hide();
                    $('#match_TOumd' + i).hide();
                    if (i != pos) {
                        $('#match_TOsta' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TOumd':
            var rows = rowsOfTable('TablaOperaciones');
            $('#btnservicios').prop("disabled", true);
            $('#match_TOumd' + pos).show();
            for (i = 0; i < rows; i++) {
                try {
                    $('#match_TOptoTr' + i).hide();
                    $('#match_TOcent' + i).hide();
                    $('#match_TOsta' + i).hide();
                    if (i != pos) {
                        $('#match_TOumd' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TOdesOpe':
            posSta = pos;
            var rows = rowsOfTable('TablaOperaciones');
            $('#btnservicios').prop("disabled", true);
            $('#match_TOdesOpe' + pos).show();
            for (i = 0; i < rows; i++) {
                try {
                    $('#match_TOptoTr' + i).hide();
                    $('#match_TOcent' + i).hide();
                    $('#match_TOsta' + i).hide();
                    $('#match_TOumd' + i).hide();
                    if (i != pos) {
                        $('#match_TOdesOpe' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
    }
}
function BtnHideTO() {
    var rows = rowsOfTable('TablaOperaciones');
    $('#btnservicios').prop("disabled", true);
    var mTr = $("input[name^='match_TOptoTr']");
    var mCe = $("input[name^='match_TOcent']");
    var mSt = $("input[name^='match_TOsta']");
    var mUm = $("input[name^='match_TOumd']");

    for (i = 0; i < rows; i++) {
        try {
            mTr[i].hide();
            mCe[i].hide();
            mSt[i].hide();
            mUm[i].hide();
        } catch (e) {
        }
    }
}
function matchTOPtoTr(pos) {
    acc = "matchTOPtoTr";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + "&pos=" + pos,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle4', 'VentanaModalPtoTr');
                $('#BuscarParamPtoTr').hide();
                $('#ConsultaTablaPtoTr').show();
                $('#cargarDatosPtoTr').html(rs);
                fncPtoTr();
                borrarmsg();
            }
        }
    });
}
function matchTOCent(pos) {
    acc = "matchTOCent";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + "&pos=" + pos,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle23', 'VentanaModalCentroP');
                $('#cargarDatosCentroP').html(rs);
                fncCentroP();
                borrarmsg();
            }
        }
    });
}
function matchTOSta(pos) {
    acc = "matchTOSta";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + "&pos=" + pos,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle21', 'VentanaModalClaveCtrl');
                $('#cargarDatosClaveCtrl').html(rs);
                fncCentroP();
                borrarmsg();
            }
        }
    });
}
function matchTOUMD(pos) {
    acc = "matchTOUMD";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + "&pos=" + pos,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle8', 'VentanaModalUMD');
                $('#cargarDatosUMD').html(rs);
                fncUMD();
                borrarmsg();
            }
        }
    });
}
function selectMatchTO(type, pos, data) {
    switch (type) {
        case 'PtoTr':
            ocultarVentana('PtoTr');
            var pto = $("input[name^='TOptoTr']");
            pto[pos].value = data;
            pto[pos].focus();
            $('#overlay').remove();
            break;
        case 'CentroP':
            ocultarVentana('CentroP');
            var cen = $("input[name^='TOcent']");
            cen[pos].value = data;
            cen[pos].focus();
            $('#overlay').remove();
            break;
        case 'ClaseOr':
            ocultarVentana('ClaseOr');
            var clO = $("input[name^='TOsta']");
            clO[pos].value = data;
            clO[pos].focus();
            $('#overlay').remove();
            break;
        case 'ClaveCtrl':
            var clO = $("input[name^='TOsta']");
            clO[pos].value = data;
            clO[pos].focus();
            $('#overlay').remove();
            ocultarVentana('ClaveCtrl');
            break;
        case 'UMD':
            ocultarVentana('UMD');
            var umD = $("input[name^='TOumd']");
            umD[pos].value = data;
            umD[pos].focus();
            $('#overlay').remove();
            break;
    }
}



//FUNCIONES TABLA MATCH COMPONENTES
var rowComp;
var rowAdC = rowsOfTable("TablaComponentes");

function giveDataComp(pos) {
    var data = "";
    data = data + checkEmpty($('#TCmat' + pos).val());
    data = data + checkEmpty($('#TCtxtB' + pos).val());
    data = data + checkEmpty($('#TCcant' + pos).val());
    data = data + checkEmpty($('#TCumc' + pos).val());
    data = data + checkEmpty($('#TCcent' + pos).val());
    data = data + checkEmpty($('#TCalm' + pos).val());
    data = data + checkEmpty($('#TCope' + pos).val());
    return data;
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
function checkDBDatComp() {
    var row = "";
    var noRows = rowComp;
    for (var i = 0; i < noRows; i++) {
        row = checkRowDbComp(i);
        if (row == "0000") {
            return 1;
        } else if (row == "1111") {
            return 1;
        } else {
            if (row.substr(0, 1).toString() == 0) {
                invalidCell("TCmat", i);
                return 2;
            } else if (row.substr(1, 1).toString() == 0) {
                invalidCell("TCumc", i);
                return 2;
            } else if (row.substr(2, 1).toString() == 0) {
                invalidCell("TCcent", i);
                return 2;
            } else if (row.substr(3, 1).toString() == 0) {
                invalidCell("TCalm", i);
                return 2;
            }
        }
    }
    return 1;
}
function checkRowDbComp(pos) {
    var mat = $('#TCmat' + pos).val();
    var umc = $('#TCumc' + pos).val();
    var cent = $('#TCcent' + pos).val();
    var alm = $('#TCalm' + pos).val();
    var acc = "checkRowComp";
    var dataSend = "&rowCmat=" + mat +
            "&rowCumc=" + umc +
            "&rowCcent=" + cent +
            "&rowCalm=" + alm;
    var rowP;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            rowP = data;
        }
    });
    return rowP;

}
function checkCellEmptyComp(pos, row) {
    if (row.substr(0, 1).toString() == 0) {
        $('#TCmat' + pos).focus();
    } else if (row.substr(1, 1).toString() == 0) {
        $('#TCtxtB' + pos).focus();
    } else if (row.substr(2, 1).toString() == 0) {
        $('#TCcant' + pos).focus();
    } else if (row.substr(3, 1).toString() == 0) {
        $('#TCumc' + pos).focus();
    } else if (row.substr(4, 1).toString() == 0) {
        $('#TCcent' + pos).focus();
    } else if (row.substr(5, 1).toString() == 0) {
        $('#TCalm' + pos).focus();
    } else if (row.substr(6, 1).toString() == 0) {
        $('#TCope' + pos).focus();
    }

}



function matchTCmat(posi) {
    mostrarVentanaModal('Mat');
    posicionT = posi;
}

function matchTCMatOk() {
    acc = "matchTCMat";
    var txtDes = $('#txtMatMatch').val();
    var mat = $('#matMatch').val();
    var centro = $('#centroMatch').val();
    var cntM = $('#numAcMaxMat').val();
    var numPz = $('#numPzFabMatch').val();
    var data = "&txtmat=" + txtDes + "&matNum=" + mat + "&centmat=" + centro + "&cntMmat=" + cntM + "&numPz=" + numPz;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + data + "&Idioma=" + idioma + "&pos=" + posicionT,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamMat').hide();
                $('#ConsultaTablaMat').show();
                $('#cargarDatosMat').html(rs);
                fncMat();
                borrarmsg();
            }
        }
    });
}
function matchTCUMC(pos) {
    acc = "matchTCUMC";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + "&pos=" + pos,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle8', 'VentanaModalUMD');
                $('#cargarDatosUMD').html(rs);
                fncUMD()();
                borrarmsg();
            }
        }
    });
}
function BtnShowTC(pos, type) {
    switch (type) {
        case 'match_TCmat':
            posMat = pos;
            var rows = rowsOfTable('TablaComponentes');
            $('#match_TCmat' + pos).show();
            for (var i = 0; i < rows; i++) {
                try {
                    $('#match_TCumc' + i).hide();
                    $('#match_TCcent' + i).hide();
                    $('#match_TCalm' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TCmat' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TCumc':
            var rows = rowsOfTable('TablaComponentes');
            $('#match_TCumc' + pos).show();
            for (i = 0; i < rows; i++) {
                try {
                    $('#match_TCmat' + i).hide();
                    $('#match_TCcent' + i).hide();
                    $('#match_TCalm' + i).hide();
                    if (i != pos)
                    {
                        $('#match_TCumc' + i).hide();
                    }
                } catch (e) {
                }
            }
            break;
        case 'match_TCcent':
            BtnHideTC();
            break;
        case 'match_TCalm':
            BtnHideTC();
            break;
        case 'match_TClot':
            BtnHideTC();
            break;
    }
}
function BtnHideTC() {
    var rows = rowsOfTable('TablaComponentes');
    for (i = 0; i < rows; i++) {
        $('#match_TCmat' + i).hide();
        $('#match_TCumc' + i).hide();
        $('#match_TCcent' + i).hide();
        $('#match_TCalm' + i).hide();
    }
}
function selectMatchTC(type, pos, data) {
    switch (type) {
        case 'Mat':
            ocultarVentana('Mat');
            var mat = $('#TCmat' + pos);
            mat.val(data);
            mat.focus();
            findMat(data);
            break;
        case 'UMC':
            ocultarVentana('UMD');
            var umc = $('#TCumc' + pos);
            umc.val(data);
            umc.focus();
            break;
    }
}

//FUNCIONES SERVICIOS
var rowMate = 0;
function getExisAcre(acre) {
    var type;
    var dataSend = "&fieldAcre=" + acre;
    var acc = "validarAcre";
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
function countOpeMate() {
    var rowsM = (rowsOfTable("tablaMate") - 1);
    var opeM = document.getElementsByName('TMnoOpe');
    var check = 0;
    for (var i = 0; i < rowsM; i++) {
        if (opeM[i].value.length > 0) {
            check++;
        } else {
            break;
        }
    }
    return check;
}
function guardarMate() {
    var rowsM = (rowsOfTable("tablaMate") - 1);
    var check = 0;
    posOrd = $('#TOope' + posSta).val();
    var opeM = document.getElementsByName('TMnoOpe');
    for (var i = 0; i < rowsM; i++) {
        if (opeM[i].value == posOrd) {
            check++;
        }
    }
    rowMate = countOpeMate();
    var ctdO1 = $('#serCtdOp1').val();
    var ctdO2 = $('#serCtdOp2').val();
    var preO1 = $('#serPrec1').val();
    var preO2 = $('#serPrec2').val();
    var gpoA1 = $('#serGrArt').val();
    var gpoC1 = $('#serGrCom1').val();
    var gpoC2 = $('#serGrCom2').val();
    var soli = $('#serSoli').val();
    var clC = $('#serClCos').val();
    var acre = $('#serAcre').val();

    var nOp = document.getElementsByName('TMnoOpe');
    var ct1 = document.getElementsByName('TMctdO1');
    var ct2 = document.getElementsByName('TMctdO2');
    var pr1 = document.getElementsByName('TMpre1');
    var pr2 = document.getElementsByName('TMpre2');
    var gra = document.getElementsByName('TMgpoA1');
    var gc1 = document.getElementsByName('TMgpoC1');
    var gc2 = document.getElementsByName('TMgpoC2');
    var sol = document.getElementsByName('TMsoli');
    var cl = document.getElementsByName('TMclC');
    var acr = document.getElementsByName('TMacre');
    var con = document.getElementsByName('TMcont');




    if (check == 0) {
        nOp[rowMate].value = posOrd;
        ct1[rowMate].value = ctdO1;
        ct2[rowMate].value = ctdO2;
        pr1[rowMate].value = preO1;
        pr2[rowMate].value = preO2;
        gra[rowMate].value = gpoA1;
        gc1[rowMate].value = gpoC1;
        gc2[rowMate].value = gpoC2;
        sol[rowMate].value = soli;
        cl[rowMate].value = clC;
        acr[rowMate].value = acre;
        con[rowMate].value = contMat;
        rowMate++;
    } else {
        var opeM = document.getElementsByName('TMnoOpe');
        for (var i = 0; i < rowsM; i++) {
            if (opeM[(i + 1)].value == posOrd) {
                nOp[(i + 1)].value = posOrd;
                ct1[(i + 1)].value = ctdO1;
                ct2[(i + 1)].value = ctdO2;
                pr1[(i + 1)].value = preO1;
                pr2[(i + 1)].value = preO2;
                gra[(i + 1)].value = gpoA1;
                gc1[(i + 1)].value = gpoC1;
                gc2[(i + 1)].value = gpoC2;
                sol[(i + 1)].value = soli;
                cl[(i + 1)].value = clC;
                acr[(i + 1)].value = acre;
                con[(i + 1)].value = contMat;
            }
        }
    }

}
var rowServi = 0;
function guardarServi() {
    var rowsS = (rowsOfTable("tablaServi") - 1);
    var check = 0;
    var opeS = document.getElementsByName('TSnoOpe');
    for (var i = 0; i < rowsS; i++) {
        if (opeS[i].value == posOrd) {
            check++;
        }
    }
    var noSer = $('#serNoSer').val();
    var cant = $('#serCant').val();
    var precEs1 = $('#serPrecEst1').val();
    var precEs2 = $('#serPrecEst2').val();
    var gpoA2 = $('#serGrpArt2').val();
    var clsC = $('#serClCost').val();
    var txtS = $('#txtServi').val();
    var umdS = $('#umdServi').val();
    if (check == 0) {
        $('#TSnoOpe' + rowServi).val(posOrd);
        $('#TSnoS' + rowServi).val(noSer);
        $('#TScant' + rowServi).val(cant);
        $('#TSpreEs1' + rowServi).val(precEs1);
        $('#TSpreEs2' + rowServi).val(precEs2);
        $('#TSgpoA2' + rowServi).val(gpoA2);
        $('#TSclsC' + rowServi).val(clsC);
        $('#TStxtS' + rowServi).val(txtS);
        $('#TSumdS' + rowServi).val(umdS);
        $('#TScont' + rowServi).val(contMat);
        rowServi++;
    } else {
        var opeS = document.getElementsByName('TSnoOpe');
        for (var i = 0; i < rowsS; i++) {
            if (opeS[i].value == posOrd) {
                $('#TSnoOpe' + rowServi).val(posOrd);
                $('#TSnoS' + rowServi).val(noSer);
                $('#TScant' + rowServi).val(cant);
                $('#TSpreEs1' + rowServi).val(precEs1);
                $('#TSpreEs2' + rowServi).val(precEs2);
                $('#TSgpoA2' + rowServi).val(gpoA2);
                $('#TSclsC' + rowServi).val(clsC);
                $('#TStxtS' + rowServi).val(txtS);
                $('#TSumdS' + rowServi).val(umdS);
                $('#TScont' + rowServi).val(contMat);
            }
        }

    }
}
function consultaSacre() {
    acc = "matchSacred";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#VentanaModalAcreedor').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                blockPropiety('handle22', 'VentanaModalAcreedor');
                $('#cargarDatosAcreedor').html(rs);
                borrarmsg();
            }
        }
    });

}
function consultaSclvM() {
    acc = "matchSclvM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('VentanaModalClvM').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                blockPropiety('handle19', 'VentanaModalClvM');
                $('#cargarDatosClvM').html(rs);
                fncClvM();
                borrarmsg();
            }
        }
    });
}
function consultaSctd() {
    acc = "matchSctd";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('VentanaModalUMD').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                blockPropiety('handle8', 'VentanaModalUMD');
                $('#cargarDatosUMD').html(rs);
                fncUMD();
                borrarmsg();
            }
        }
    });
}
function consultaSgpoA() {
    acc = "matchSgpoA";
    var gpoAr = $("#gpoAtxt");
    var grDen = $("#gpoAden");
    var grDes = $("#gpoAdes");
    var noGpo = $("#numAcMaxGpoA");
    var dataSend = "&txtmat=" + gpoAr.val()
            + "&matNum=" + grDen.val()
            + "&centmat=" + grDes.val()
            + "&cntMmat=" + noGpo.val()
            + "&Idioma=" + idioma;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#VentanaModalGpoA').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                $('#BuscarParamGpoArt').hide();
                $('#ConsultaTablaGpoA').show();
                $('#cargarDatosGpoA').html(rs);
                fncGpoA();
                borrarmsg();
            }
        }
    });
}
function consultaSgpoC1() {
    acc = "matchSgpoC1";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#VentanaModalGpoC').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                blockPropiety('handle14', 'VentanaModalGpoC');
                $('#cargarDatosGpoC').html(rs);
                fncGpoC();
                borrarmsg();
            }
        }
    });
}
function consultaSgpoC2() {
    acc = "matchSgpoC2";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#VentanaModalGpoC2').css('z-index', 999999);
                $('#VentanaModalServicios').css('z-index', 1);
                blockPropiety('handle15', 'VentanaModalGpoC2');
                $('#cargarDatosGpoC2').html(rs);
                fncGpoC2();
                borrarmsg();
            }
        }
    });

}
function consultaSnumCM() {
    acc = "matchSnumCM";
    var clC = $('#matchClCoste').val();
    var txtC = $('#matchTxtCl').val();
    var numX = $('#numAcMaxNumCM').val();
    var dataSend = "&clCM=" + clC + "&txtCM=" + txtC + "&numCM=" + numX;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + dataSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamNumCM').hide();
                $('#ConsultaTablaNumCM').show();
                $('#cargarDatosNumCM').html(rs);
                fncNumCM();
                borrarmsg();
            }
        }
    });
}

function consultaSnumS() {
    acc = "matchSnumS";
    var txtS = $('#numStxtB').val();
    var numS = $('#numSnum').val();
    var ctdS = $('#numAcMaxNumServicio').val();
    var dataSend = "&txtNS=" + txtS + "&numNS=" + numS + "&ctdNS=" + ctdS;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + dataSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamNumS').hide();
                $('#ConsultaTablaNumS').show();
                $('#cargarDatosNumS').html(rs);
                fncNumS();
                borrarmsg();
            }
        }
    });

}


function giveDataServi(pos) {
    var data = '';
    data = data + checkEmpty($('#TSnoOpe' + pos).val());
    data = data + checkEmpty($('#TSctdO1' + pos).val());
    data = data + checkEmpty($('#TSctdO2' + pos).val());
    data = data + checkEmpty($('#TSpre1' + pos).val());
    data = data + checkEmpty($('#TSpre2' + pos).val());
    data = data + checkEmpty($('#TSgpoA1' + pos).val());
    data = data + checkEmpty($('#TSgpoC1' + pos).val());
    data = data + checkEmpty($('#TSgpoC2' + pos).val());
    data = data + checkEmpty($('#TScontr1' + pos).val());
    data = data + checkEmpty($('#TScontr2' + pos).val());
    data = data + checkEmpty($('#TSdest' + pos).val());
    data = data + checkEmpty($('#TSsoli' + pos).val());
    data = data + checkEmpty($('#TSplzE' + pos).val());
    data = data + checkEmpty($('#TSsubC' + pos).checked);
    data = data + checkEmpty($('#TSclvCl' + pos).val());
    data = data + checkEmpty($('#TSpor' + pos).val());
    data = data + checkEmpty($('#TSclC' + pos).val());
    data = data + checkEmpty($('#TSacre' + pos).val());
    data = data + checkEmpty($('#TSregI' + pos).val());
    data = data + checkEmpty($('#TSptoD' + pos).val());
    data = data + checkEmpty($('#TSnoN' + pos).val());
    data = data + checkEmpty($('#TSpedM1' + pos).val());
    data = data + checkEmpty($('#TSpedM2' + pos).val());
    data = data + checkEmpty($('#TSnoS' + pos).val());
    data = data + checkEmpty($('#TScant' + pos).val());
    data = data + checkEmpty($('#TSpreEs1' + pos).val());
    data = data + checkEmpty($('#TSpreEs2' + pos).val());
    data = data + checkEmpty($('#TSgpoA2' + pos).val());
    data = data + checkEmpty($('#TSclsC' + pos).val());
    return data;
}

function checkEmptyTableServi() {
    var rows = rowsOfTable('tablaServi');
    var row, rowFull = 0;
    for (var i = 0; i < rows; i++) {
        row = $('#TSnoOpe' + i).val();
        if (row.length < 1) {
            if (rowFull < 1) {//sin datos
                return 0;
            } else {// con datos
                return 1;
            }
        } else {
            rowFull++;
        }
    }
}
function checkEmptyTableMate() {
    var rows = rowsOfTable('tablaMate');
    var noOpe = document.getElementsByName('TMnoOpe');
    var row, rowFull = 0;
    try {
        for (var i = 0; i < rows; i++) {
            row = noOpe[i].value;
            if (row.length < 1) {
                if (rowFull < 1) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                rowFull++;
            }
        }
    } catch (e) {

    }
}

// FUNCIONES MATCH CABECERA
function CargarClaseOr() {
    acc = "ConsultaMatchClaseOr";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma,
        success: function (rs) {
            $('#ClOrden').html(rs);
        }
    });
}
function ConsultarEquipo() {
    acc = "ConsultaMatchEquipo";
    var denE = $('#denEqui').val();
    var numE = $('#numEqui').val();
    var cant = $('#numAcMaxEqui').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&denE=" + denE + "&numE=" + numE + "&ctdE=" + cant + "&Idioma=" + idioma,
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
function ConsultarUbiT() {
    acc = "ConsultaMatchUbiT";
    var denUT = $('#denUbiT').val();
    var ubiT = $('#ubiTecM').val();
    var cant = $('#numAcMaxUbiT').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&denUT=" + denUT + "&ubiT=" + ubiT + "&ctdUt=" + cant + "&Idioma=" + idioma,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamUbiT').hide();
                $('#ConsultaTablaUbiT').show();
                $('#cargarDatosUbiT').html(rs);
                fncUbiT();
                borrarmsg();
            }
        }
    });
}
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
function CargarCentroP() {
    acc = "ConsultaMatchCentroP";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (rs) {
            $('#CentPl').html(rs);
        }
    });
}

function ConsultarContaHR() {
    acc = "ConsultaMatchContaHR";
    var equi = $("#Equipo");
    var dataSend = "&equi=" + equi.val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
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
function ConsultarLstMat() {
    acc = "ConsultaMatchLstMat";
    var equi = $("#Equipo");
    var dataSend = "&equi=" + equi.val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle7', 'VentanaModalLstMat');
                $('#cargarDatosLstMat').html(rs);
                fncLstMat();
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
        async: false,
        type: 'GET',
        dataType: "json",
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&equi=" + equi,
        success: function (rs) {
            var n = rs;
            if (rs == "x") {
                $('#UbiTec').val("");
                $('#CentPl').val("");
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
    var Equip = $('#Equipo');
    var UbiTe = $('#UbiTec');
    var CentP = $('#CentPl');
    var PtoTj = $('#PtoTjo');
    var DatObli = [ClOrd, Descr, Equip, CentP, PtoTj];
    $.each(DatObli, function (i, v) {
        if (v.val().length > 0) {
            v.css('background-image', 'none');
            v.css("background-color", "#ffffff");
        } else {
            v.css({background: 'url(images/necesario.PNG) no-repeat'});
            v.css("background-color", "#ffffff");
        }
    });
}


// FUNCIONES Boton Tomar Hojas de Ruta


function validarCamposOpe() {
    var clsO = $('#ClOrden');
    var descri = $('#Descri');
    var cont = $('#ContHR');
    var num = $('#NumHR');
    var CentP = $('#CentPl');
    var DatObli = [clsO, descri, num, cont];
    for (var i = 0; i < DatObli.length; i++) {
        if (DatObli[i].val().length < 1) {
            DatObli[i].focus();
            var msj = 'Faltan Datos Obligatorios';
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#msg').html(msj);
            return;
        }
    }
    var datosSend = "&clOr=" + clsO.val() + "&numHR=" + num.val() + "&contHR=" + cont.val() + "&centP=" + CentP.val();
    acc = "cargarDataOpe";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
                $('#ClOrden').focus();
                var menCam = "Clase de Orden Invalida";
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(menCam);
            } else if (rs == 1) {
                var msj = "Entradas no existentes para Cont/Num de Hoja de Ruta";
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(msj);
            } else {
                $('#cargarDatosTabOpe').html(rs);
                refreshNumAl();
                validarDatTabOpe();
                blockEmptyOpe();
                borrarmsg();
            }
        }
    });
}

// FUNCIONES Boton Tomar Lista de Materiales
function validarCamposComp() {
    var equi = $('#Equipo');
    var centroP = $('#CentPl');
    var DatObli = [equi, centroP];
    for (var i = 0; i < DatObli.length; i++) {
        if (DatObli[i].val().length < 1) {
            DatObli[i].focus();
            var msj = 'Faltan Datos Obligatorios';
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            var men = $('#msg');
            men.html(msj);
            return;
        }
    }
    var check = checkPMope();
    if (check == 0) {
        var menCam = "No existen operaciones validas";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        var men = document.getElementById("msg");
        men.innerHTML = menCam;
    } else {
        var check = getExisNumEqui(equi.val());
        if (check == 1) {
            consultarMateByBomM();
        } else if (check == 0) {
            invalidEquip();
        }
    }
}

function consultarMateByBomM() {
    var equi = $('#Equipo');
    var centroP = $('#CentPl');
    var datosSend = "&equi=" + equi.val() +
            "&centPto=" + centroP.val() +
            "&Idioma=" + idioma;
    acc = "ConsultaMatchLstMat";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 0) {
                datosincorrectos();
            } else {
                blockPropiety('handle7', 'VentanaModalLstMat');
                $('#cargarDatosLstMat').html(rs);
                fncLstMat();
                borrarmsg();
            }
        }
    });
}

function checkPMope() {
    var rows = rowsOfTable("TablaOperaciones");
    var clvO = $("input[name^='TOsta']");
    var pms = 0;
    for (var i = 0; i < rows; i++) {
        try {
            if (clvO[i].value == "PM01") {
                pms++;
            } else {
            }
        } catch (e) {
        }
    }
    return pms;
}
function checkMatSel() {
    var check = 0;
    var pos = document.getElementsByName('TLpos');
    for (var i = 0; i < pos.length; i++) {
        if (pos[i].checked) {
            check++;
        }
    }
    return check;
}
function checkMatLstM() {
//    var pos = $("input[name^='TLnumM']");
    var pos = document.getElementsByName('TLpos');
    var numM = document.getElementsByName('TLnumM');
    var numP = document.getElementsByName('TLnumPz');
    var des = document.getElementsByName('TLdes');
    var umd = document.getElementsByName('TLumd');

    var Mmat = document.getElementsByName('TCmat');
    var Mtxt = document.getElementsByName('TCtxtB');
    var Mctd = document.getElementsByName('TCcant');
    var Mumc = document.getElementsByName('TCumc');
    var Mcen = document.getElementsByName('TCcent');
    var Malm = document.getElementsByName('TCalm');

    var check = checkMatSel();
    if (check < 1) {
        var menCam = "No es posible la operacion";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
    } else {
        check = 0;
        for (var i = 0; i < pos.length; i++) {
            if (pos[i].checked) {
                Mmat[check].value = numM[i].innerHTML;
                Mtxt[check].value = des[i].innerHTML;
                Mctd[check].value = "1";
                Mumc[check].value = umd[i].innerHTML;
                Mcen[check].value = "BAJA";
                Malm[check].value = "M100";
                check++;
            }
        }
        ocultarVentana('LstMat');
    }
}

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
        case "Acreedor":
            var ventana = $('#VentanaModalAcreedor');
            ventana.hide();
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
        case "Equipo":
            var ventana = $('#VentanaModalEquipo');
            ventana.hide();
            $('#BuscarParamEquipo').show();
            $('#ConsultaTablaEquipo').hide();
            $('#Equipo').focus();
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
            var cl = $('#serGrArt');
            cl.focus();
            break;
        case "Equipo":
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
        case "LstMat":
            validarLstMat();
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
        case "Equipo":
            ocultarVentana('Equipo');
            var eq = $('#Equipo');
            eq.val(obj);
            eq.focus();
            cargarEqui();
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

//FUNCIONES VALIDAR 
function validarNumEquiHR() {
    var equi = $("#Equipo");
    if (equi.val().length < 1) {
        datosFaltantes();
        equi.focus();
    } else {
        var check = getExisNumEqui(equi.val());
        if (check == 1) {
            ConsultarContaHR();
        } else if (check == 0) {
            invalidEquip();
        }

    }
}
function validarLstMat() {
    var equi = $("#Equipo");
    if (equi.val().length < 1) {
        datosFaltantes();
        equi.focus();
    } else {
        var check = getExisNumEqui(equi.val());
        if (check == 1) {
            ConsultarLstMat();
        } else if (check == 0) {
            invalidEquip();
        }

    }
}
function validarSer1() {
    var matchSctd1 = $('#serCtdOp1');
    var matchSctd2 = $('#serCtdOp2');
    var matchSprec1 = $('#serPrec1');
    var matchSprec2 = $('#serPrec2');
    var matchSgrA = $('#serGrArt');
    var matchSser = $('#serGrCom1');
    var matchSgrC = $('#serGrCom2');
    var matchSsoli = $('#serSoli');
    var matchSclC = $('#serClCos');
    var DatObliServi = [matchSctd1, matchSctd2, matchSprec1, matchSprec2, matchSgrA, matchSser, matchSgrC, matchSsoli, matchSclC];
    for (var i = 0; i < DatObliServi.length; i++) {
        if (DatObliServi[i].val() == "") {
            DatObliServi[i].focus();
            return;
        }
    }
    if ($("#serAcre").val().length > 0) {
        var check = getExisAcre($("#serAcre").val());
        if (check == 0) {
            $("#serAcre").focus();
            return;
        }
    }
    validarSer1db();
}



function validarSer1db() {
    acc = "validarServi1";
    var matchSctd2 = $('#serCtdOp2').val();
    var matchSprec2 = $('#serPrec2').val();
    var matchSgrA = $('#serGrArt').val();
    var matchSser = $('#serGrCom1').val();
    var matchSgrC = $('#serGrCom2').val();
    var matchSclC = $('#serClCos').val();
    var datosSend = "&vSerCtd2=" + matchSctd2 +
            "&vSerPre2=" + matchSprec2 +
            "&vSerGpoA=" + matchSgrA +
            "&vSerGcom1=" + matchSser +
            "&vSerGcom2=" + matchSgrC +
            "&vSerClsC=" + matchSclC;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Idioma=" + idioma + datosSend,
        success: function (rs) {
            if (rs == 111111) {
                if (status == "PM02") {
                    copyDataServ();
                    mostrarStatus2();
                } else if (status == "PM03") {
                    borrarmsg();
                    guardarMate();
                    ocultarVentana("Servi");
                    return;
                }
            } else {
                checkCellDbSer1(rs);
            }
        }
    });
}
function copyDataServ() {
    $("#serCant").val($("#serCtdOp1").val());
    $("#serCant2").text($("#serCtdOp2").val());

    $("#serPrecEst1").val($("#serPrec1").val());
    $("#serPrecEst2").val($("#serPrec2").val());
    $("#serGrpArt2").val($("#serGrArt").val());
    $("#serClCost").val($("#serClCos").val());

    var matchScant = $('#serCant');
    var matchSgrpAr = $('#serGrpArt2');
    var matchSclCost = $('#serClCost');
    var matchPre1 = $('#serPrecEst1');
    var matchPre2 = $('#serPrecEst2');
    var DatObliServi2 = [matchPre1, matchPre2, matchScant, matchSgrpAr, matchSclCost];
    $.each(DatObliServi2, function (i, v) {
        v.css('background-image', 'none');
        v.prop("disabled", true);
    });
}
function checkCellDbSer1(campo) {
    if (campo.substr(0, 1).toString() == "0") {
        $('#serCtdOp2').focus();
        var matchSctd2 = $('#serCtdOp2').val();
        var menCam = "No existe la Unidad - " + matchSctd2;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    } else if (campo.substr(1, 1).toString() == "0") {
        $('#serPrec2').focus();
        var matchSprec2 = $('#serPrec2').val();
        var menCam = "No existe la Clave de Moneda - " + matchSprec2;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    } else if (campo.substr(2, 1).toString() == "0") {
        $('#serGrArt').focus();
        var matchSgrA = $('#serGrArt').val();
        var menCam = "No existe el Grupo de Articulo - " + matchSgrA;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    } else if (campo.substr(3, 1).toString() == "0") {
        $('#serGrCom1').focus();
        var matchSser = $('#serGrCom1').val();
        var menCam = "No existe el Grupo de Compras - " + matchSser;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    } else if (campo.substr(4, 1).toString() == "0") {
        $('#serGrCom2').focus();
        var matchSgrC = $('#serGrCom2').val();
        var menCam = "No existe la Organizacion de Compras - " + matchSgrC;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    } else if (campo.substr(5, 1).toString() == "0") {
        $('#serClCos').focus();
        var matchSclC = $('#serClCos').val();
        var menCam = "No existe la Clase de Coste - " + matchSclC;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    }
}
function validarSer2() {
    var noS = $('#serNoSer');
    var DatObliServi = [noS];
    for (var i = 0; i < DatObliServi.length; i++) {
        if (DatObliServi[i].val() == "") {
            DatObliServi[i].focus();
            return;
        }
    }
    validarSerDb2();
}
function validarSerDb2() {
    acc = "validarServi2";
    var noS = $('#serNoSer').val();
    var datosSend = "&vSer2noS=" + noS;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs == 1) {
                borrarmsg();
                guardarMate();
                guardarServi();
                ocultarVentana("Servi");
                return;
            } else {
                checkCellDbServi2(rs);
            }
        }
    });
}

function checkCellDbServi2(campo) {
    if (campo.substr(0, 1).toString() == "0") {
        $('#serNoSer').focus();
        var matchSprec2 = $('#serNoSer').val();
        var menCam = "No existe el Servicio - " + matchSprec2;
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        return;
    }
}
function mostrarStatus2() {
    var rowsS = (rowsOfTable("tablaServi") - 1);
    var check = 0;
    var opeS = document.getElementsByName('TSnoOpe');
    for (var i = 0; i < rowsS; i++) {
        if (opeS[i].value == posOrd) {
            check++;
        }
    }
    if (check == 0) {
        $('#ParamServi1').hide();
        $('#ParamServi2').show();
    } else {
        $('#ParamServi1').hide();
        $('#ParamServi2').show();
        cargarPopUp2();
    }
}


function loadDataPM03() {

    var ope = $('#TOope' + posSta).val();
    var ctd1 = document.getElementsByName('TMctdO1');
    var ctd2 = document.getElementsByName('TMctdO2');
    var pre1 = document.getElementsByName('TMpre1');
    var pre2 = document.getElementsByName('TMpre2');
    var gpoA = document.getElementsByName('TMgpoA1');
    var gpoC1 = document.getElementsByName('TMgpoC1');
    var gpoC2 = document.getElementsByName('TMgpoC2');
    var clsC = document.getElementsByName('TMclC');
    var acre = document.getElementsByName('TMacre');

    var numO = document.getElementsByName('TMnoOpe');
    var rows = rowsOfTable('tablaMate');
    for (var i = 0; i < rows; i++) {
        if (numO[i].value == ope) {
            $('#serCtdOp1').val(ctd1[i].value);
            $('#serCtdOp2').val(ctd2[i].value);
            $('#serPrec1').val(pre1[i].value);
            $('#serPrec2').val(pre2[i].value);
            $('#serGrArt').val(gpoA[i].value);
            $('#serGrCom1').val(gpoC1[i].value);
            $('#serGrCom2').val(gpoC2[i].value);
            $('#serClCos').val(clsC[i].value);
            $('#serAcre').val(acre[i].value);
            break;
        }
    }
}
function checkPM03() {
    var ctd1 = $('#serCtdOp1');
    var cdt2 = $('#serCtdOp2');
    var pre1 = $('#serPrec1');
    var pre2 = $('#serPrec2');
    var gpoA = $('#serGrArt');
    var gpoC1 = $('#serGrCom1');
    var gpoC2 = $('#serGrCom2');
    var clsC = $('#serClCos');

    var DatObli = [ctd1, cdt2, pre1, pre2, gpoA, gpoC1, gpoC2, clsC];

    setTimeout(function () {
        $.each(DatObli, function (i, v) {
            if (v.val().length > 0) {
                v.css('background-image', 'none');
                v.css("background-color", "#ffffff");
            } else {
                v.css({background: 'url(images/necesario.PNG) no-repeat'});
                v.css("background-color", "#ffffff");
            }
        });
    }, 200);
}

function checkTypeStatus(status) {
    limpiarSer();
    if (status == "PM02") {
        $("#serAcre").prop("disabled", false);
        loadDataPM03();
        checkPM03();
    } else if (status == "PM03") {
        loadDataPM03();
        checkPM03();
//        $("#serAcre").prop("disabled", true);
    }
}
function popUpSta() {
    var sta = $('#TOsta' + posSta).val();
    status = sta;
    posOrd = $('#TOope' + posSta).val();
    contMat = $('#TOcont' + posSta).val();

    if (posOrd == "") {
        var msj = "Se requiere No Operacion";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
    } else {
        if (sta == "PM02" || sta == "PM03") {
            borrarmsg();
            var rowsM = (rowsOfTable("tablaMate") - 1);
            var check = 0;
            var opeM = document.getElementsByName('TMnoOpe');
            for (var i = 0; i < rowsM; i++) {
                if (opeM[i].value == posOrd) {
                    check++;
                }
            }
            if (check == 0) {
                document.getElementById("TOsta" + posSta).blur();
                borrarmsg();
                blockPropiety('handle12', 'VentanaModalServicios');
                checkTypeStatus(sta);
            } else {
                document.getElementById("TOsta" + posSta).blur();
                borrarmsg();
                blockPropiety('handle12', 'VentanaModalServicios');
                checkTypeStatus(sta);
                cargarPopUp1();
            }
        } else {
            var msj = "Status invalido";
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#msg').html(msj);
        }
    }
}
function checharEquiUbi() {
    var equi = $('#Equipo').val();
    var ubiTec = $('#UbiTec').val();
    var check;
    if (equi.length < 1 & ubiTec.length < 1) {
        check = "";
    } else if (equi.length > 0 & ubiTec.length < 1) {
        check = "equi";
    } else if (equi.length < 1 & ubiTec.length > 0) {
        check = "ubiT";
    } else if (equi.length > 0 & ubiTec.length > 0) {
        check = "dos";
    }
    return check;
}
function datosObligatorios() {
    var claseOr = $('#ClOrden').val();
    var descri = $('#Descri').val();
    var check2 = checharEquiUbi();
    var centP = $('#CentPl').val();
    var ptoRes = $('#PtoTjo').val();
    if (claseOr.length < 1 || descri.length < 1 || check2.length < 1 || centP.length < 1 || ptoRes.length < 1) {
        dataFocusPrincipal();
    } else {
        borrarmsg();
        validarDatosDBPrincipal();
    }
}
function validarDatosDBPrincipal() {
    var claseOr = $('#ClOrden').val();
    var equi = $('#Equipo').val();
    var ubiTec = $('#UbiTec').val();
    var centP = $('#CentPl').val();
    var ptoRes = $('#PtoTjo').val();
    var datosSend = "&clOr=" + claseOr + "&equi=" + equi + "&ubiT=" + ubiTec + "&centP=" + centP + "&ptoT=" + ptoRes;
    acc = "validarDatosPri";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs.substr(0, 1).toString() == "0") {
                $('#ClOrden').focus();
                var menCam = "No existe la clase de orden - " + claseOr;
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(menCam);
                return;
            } else if (rs.substr(3, 1).toString() == "0") {
                $('#CentPl').focus();
                var menCam = "No existe el centro de planificacion - " + centP;
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(menCam);
                return;
            } else if (rs.substr(4, 1).toString() == "0") {
                $('#PtoTjo').focus();
                var menCam = "No existe el puesto de trabajo - " + ptoRes;
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(menCam);
                return;
            } else {
                var check = checharEquiUbi();
                if (check == "dos") {
                    if (rs.substr(1, 1).toString() == "0") {
                        $('#Equipo').focus();
                        var menCam = "No existe el equipo - " + equi;
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        $('#msg').html(menCam);
                        return;
                    } else if (rs.substr(2, 1).toString() == "0") {
                        $('#UbiTec').focus();
                        var menCam = "No existe la ubicacion tecnica - " + ubiTec;
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        $('#msg').html(menCam);
                        return;
                    } else {
                        checkDate();
                    }
                } else if (check == "equi") {
                    if (rs.substr(1, 1).toString() == "0") {
                        $('#Equipo').focus();
                        var menCam = "No existe el equipo - " + equi;
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        $('#msg').html(menCam);
                        return;
                    } else {
                        checkDate();
                    }
                } else if (check == "ubiT") {
                    if (rs.substr(2, 1).toString() == "0") {
                        $('#UbiTec').focus();
                        var menCam = "No existe la ubicacion tecnica - " + ubiTec;
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        $('#msg').html(menCam);
                        return;
                    } else {
                        checkDate();
                    }
                }
            }
        }
    });
}


function checkDate() {
    var ini = $('#fechIni').val();
    var fin = $('#fechFin').val();
    if (fin == "") {
        var msj = "Introduce una fecha valida";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
        $('fechFin').focus();
    } else {
        if (validate_fechaMayorQue(ini, fin)) {
            borrarmsg();
            checkEmptyTableOp();
        } else {
            var msj = "Intriduce una fecha valida";
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#msg').html(msj);
            $('fechFin').focus();
        }
    }
}


function validate_fechaMayorQue(fechaInicial, fechaFinal) {
    var primera = Date.parse(fechaInicial);
    var segunda = Date.parse(fechaFinal);
    if (primera == segunda) {
        return false;
    } else if (primera > segunda) {
        return false;
    } else {
        return true;
    }
}
function dataFocusPrincipal() {
    errorDataIncomplet();
    var temp = new Array();
    temp[0] = $('#ClOrden');
    temp[1] = $('#Descri');
    temp[2] = $('#Equipo');
    temp[3] = $('#UbiTec');
    temp[4] = $('#CentPl');
    temp[5] = $('#PtoTjo');
    temp[6] = $('#fechFin');
    temp[7] = $('#fechIni');
    for (i = 0; i < temp.length; i++) {
        if (temp[i].val() == "") {
            temp[i].focus();
            break;
        }
    }
}
function checkEmpty(val) {
    if (val.length <= 0) {
        return 0;
    } else {
        return 1;
    }
}
function checkPM(status) {
    if (status.length < 1) {
        return 0;
    } else {
        if (status === "PM02" || status === "PM03") {
            return 2;
        } else {
            return 1;
        }
    }

}
function NumDecimalCheck(e, field) {
    key = e.keyCode ? e.keyCode : e.which;
    if (key == 8)
        return true
    if (key > 47 && key < 58) {
        if (field.value == "")
            return true;
        regexp = /.[0-9]{2}$/;
        return !(regexp.test(field.value));
    }
    if (key == 46) {
        if (field.value == "")
            return false
        regexp = /^[0-9]+$/;
        return regexp.test(field.value);
    }
    return false;
}



function checkCellEmptyOpe(pos, row) {
    tabOpe();
    if (row.substr(0, 1).toString() == 0) {
        invalidCellObli("TOope", pos);
    } else if (row.substr(1, 1).toString() == 0) {
        invalidCellObli("TOptoTr", pos);
    } else if (row.substr(2, 1).toString() == 0) {
        invalidCellObli("TOcent", pos);
    } else if (row.substr(3, 1).toString() == 0) {
        invalidCellObli("TOsta", pos);
    } else if (row.substr(4, 1).toString() == 0) {
        invalidCellObli("TOdesOpe", pos);
    } else if (row.substr(5, 1).toString() == 0) {
        invalidCellObli("TOcant", pos);
    } else if (row.substr(6, 1).toString() == 0) {
        invalidCellObli("TOdura", pos);
    } else if (row.substr(7, 1).toString() == 0) {
        invalidCellObli("TOumd", pos);
    }
}
function checkCellEmptyOpeSta(pos, row) {
    if (row.substr(0, 1).toString() == 0) {
        invalidCellObli("TOope", pos);
    } else if (row.substr(1, 1).toString() == 0) {
        invalidCellObli("TOptoTr", pos);
    } else if (row.substr(2, 1).toString() == 0) {
        invalidCellObli("TOcent", pos);
    } else if (row.substr(3, 1).toString() == 0) {
        invalidCellObli("TOsta", pos);
    } else if (row.substr(4, 1).toString() == 0) {
        invalidCellObli("TOdesOpe", pos);
    }
}
function checkOpeComp() {
    var rowsOpe = rowsOfTable("TablaOperaciones");
    var rowsComp = rowsOfTable("TablaComponentes");
    var noOpeComp = $("input[name^='TCope']");
    var noOpeOpe = $("input[name^='TOope']");
    var clvO = $("input[name^='TOsta']");
    var check = 0;
    var exis = 0;
    for (var i = 0; i < (rowsComp - 1); i++) {
        exis = 0;
        for (var d = 0; d < rowsOpe; d++) {
            try {
                if (noOpeComp[i].value.length < 1) {
                    exis++;
                } else {
                    if (noOpeComp[i].value === noOpeOpe[d].value) {
                        if (clvO[d].value === "PM01") {
                            exis++;
                        } else {
                            check++;
                            invalidOpe(noOpeComp[i].value);
                            tabComp();
                            focusElement(noOpeComp[i]);
                        }
                    } else {
                    }
                }
            } catch (e) {
            }
        }
        if (exis == 0) {
            invalidOpe(noOpeComp[i].value);
            tabComp();
            check = -1;
            focusElement(noOpeComp[i]);
            break;
        }
    }
    return check;
}
function invalidOpe(val) {
    var menCam = "Numero de operacion " + val + " No Valido";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    var men = $('#msg');
    men.html(menCam);
}
function invalidOpeSer(val) {
    var menCam = "Operacion " + val + " requiere servicio";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    var men = $('#msg');
    men.html(menCam);
}
function invalidOpeMat(val) {
    var menCam = "Operacion " + val + " requiere datos obligatorios";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    var men = $('#msg');
    men.html(menCam);
}
function checkInserccionFull() {
    var check1 = checkEmptyTableComp();
    var check3 = checkDBDatComp();
    var valOpeComp = checkOpeComp();

    var valOpeSer = checkOpeServ();
    var valOpeMate = checkOpeMate();

    if (check1 == 2) {
        var menCam = "Complete todos los campos";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        tabComp();
        checkEmptyTableComp();
        return;
    }
    if (check3 == 2) {
        var menCam = "Elemento no encontrado";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(menCam);
        tabComp();
        checkDBDatComp();
        return;
    }
    if (valOpeSer == -1) {
        checkOpeServ();
        return;
    }
    if (valOpeMate == -1) {
        checkOpeMate();
        return;
    }

    if (valOpeComp == -1) {
        checkOpeComp();
        return;
    } else if (valOpeComp != 0) {
        checkOpeComp();
        return;
    }
    eliminarOrden();

}
function checkOpeServ() {
    var rowsOpe = rowsOfTable("TablaOperaciones");
    var rowsSer = rowsOfTable("tablaServi");


    var noOpeSer = $("input[name^='TSnoOpe']");
    var noOpeOpe = $("input[name^='TOope']");
    var clvO = $("input[name^='TOsta']");
    var check = 0;
    var exis = 0;
    for (var i = 0; i < (rowsOpe - 1); i++) {
        if (noOpeOpe[i].value.length > 0) {
            exis = 0;
            if (clvO[i].value === "PM02") {
                for (var d = 0; d < (rowsSer - 1); d++) {
                    if (noOpeOpe[i].value == noOpeSer[d].value) {
                        exis++;
                    }
                }
            } else {
                exis++;
            }
            if (exis == 0) {
                tabOpe();
                invalidOpeSer(noOpeOpe[i].value);
                check = -1;
                focusElement(noOpeOpe[i]);
                break;
            }
        } else {
            break;
        }
    }
    return check;

}
function checkOpeMate() {
    var rowsOpe = rowsOfTable("TablaOperaciones");
    var rowsSer = rowsOfTable("tablaMate");


    var noOpeSer = $("input[name^='TMnoOpe']");
    var noOpeOpe = $("input[name^='TOope']");
    var clvO = $("input[name^='TOsta']");
    var check = 0;
    var exis = 0;
    for (var i = 0; i < (rowsOpe - 1); i++) {
        if (noOpeOpe[i].value.length > 0) {
            exis = 0;
            if (clvO[i].value === "PM03") {
                for (var d = 0; d < (rowsSer - 1); d++) {
                    if (noOpeOpe[i].value == noOpeSer[d].value) {
                        exis++;
                    }
                }
            } else {
                exis++;
            }
            if (exis == 0) {
                tabOpe();
                invalidOpeMat(noOpeOpe[i].value);
                check = -1;
                focusElement(noOpeOpe[i]);
                break;
            }
        } else {
            break;
        }
    }
    return check;

}

function checkDBDatOpeSta(noRows) {

    var row = "";
    row = checkRowDbOpeSta(noRows);

    if (row == "111") {
        return 1;
    } else {
        if (row.substr(0, 1).toString() == 0) {
            invalidCell("TOptoTr", noRows);
            return 0;
        } else if (row.substr(1, 1).toString() == 0) {
            invalidCell("TOcent", noRows);
            return 0;
        } else if (row.substr(2, 1).toString() == 0) {
            invalidCell("TOsta", noRows);
            return 0;
        }
    }
    return 1;
}
function checkAddDBDatOpe(noRows) {
    var row = "";
    var clv = $("input[name^='TOsta']");
    var status;
    var check;
    for (var i = 0; i < noRows; i++) {
        row = checkRowDbOpe(i);
        status = clv[i].value;
        if (status == "PM02" || status == "PM03") {
            check = checkDBDatOpeSta(i);
            if (check == 1) {
            } else if (check == 0) {
                checkDBDatOpeSta(i);
                setCheckAdd(0);
                return;
            }
        } else {
            if (row == "1111") {

            } else {
                if (row.substr(0, 1).toString() == 0) {
                    invalidCell("TOptoTr", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(1, 1).toString() == 0) {
                    invalidCell("TOcent", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(2, 1).toString() == 0) {
                    invalidCell("TOsta", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(3, 1).toString() == 0) {
                    invalidCell("TOumd", i);
                    setCheckAdd(0);
                    return;
                }
            }
        }
    }
    setCheckAdd(1);
}
function checkEmpty(val) {
    if (val.length <= 0) {
        return 0;
    } else {
        return 1;
    }
}
function checkPM(status) {
    if (status.length < 1) {
        return 0;
    } else {
        if (status === "PM02" || status === "PM03") {
            return 2;
        } else {
            return 1;
        }
    }

}
function giveDataOp(pos) {
    var data = "";
    data = data + checkEmpty($('#TOope' + pos).val());
    data = data + checkEmpty($('#TOptoTr' + pos).val());
    data = data + checkEmpty($('#TOcent' + pos).val());
    data = data + checkEmpty($('#TOsta' + pos).val());
    data = data + checkEmpty($('#TOdesOpe' + pos).val());
    data = data + checkEmpty($('#TOcant' + pos).val());
    data = data + checkEmpty($('#TOdura' + pos).val());
    data = data + checkEmpty($('#TOumd' + pos).val());
    return data;
}
function giveDataOpSta(pos) {
    var data = '';
    data = data + checkEmpty($('#TOope' + pos).val());
    data = data + checkEmpty($('#TOptoTr' + pos).val());
    data = data + checkEmpty($('#TOcent' + pos).val());
    data = data + checkEmpty($('#TOsta' + pos).val());
    data = data + checkEmpty($('#TOdesOpe' + pos).val());
    return data;
}
function checkEmptyTableOp() {
    var rows = rowsOfTable('TablaOperaciones');
    var clv = $("input[name^='TOsta']");
    var row, rowFull = 0;
    var status;
    for (var i = 0; i < rows; i++) {
        row = giveDataOp(i);
        status = clv[i].value;
        if (status == "PM02" || status == "PM03") {
            row = giveDataOpSta(i);
            if (row == "11111") {
                rowFull++;
            } else if (row == "00000") {
                if (rowFull > 0) {
                    borrarmsg();
                    checkDBDatOpe(rowFull);
                    RowPope = rowFull;
                } else {
                    var menCam = "inserte una operacion";
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    $('#msg').html(menCam);
                    $('#TOope' + i).focus();
                    return;
                }
            } else {
                checkCellEmptyOpeSta(i, row);
                return;
            }
        } else {
            if (row == "11111111") {
                rowFull++;
            } else if (row == "00000000") {
                if (rowFull > 0) {
                    borrarmsg();
                    checkDBDatOpe(rowFull);
                    RowPope = rowFull;
                    break;
                } else {
                    var menCam = "inserte una operacion";
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    $('#msg').html(menCam);
                    $('#TOope' + i).focus();
                    return;
                }
            } else {
                checkCellEmptyOpe(i, row);
                return;
            }
        }
    }
}
function checkAddEmptyTableOp() {
    var rows = rowsOfTable('TablaOperaciones');
    var clv = $("input[name^='TOsta']");
    var row, rowFull = 0;
    var status;
    for (var i = 0; i < rows; i++) {
        row = giveDataOp(i);
        status = clv[i].value;
        if (status == "PM02" || status == "PM03") {
            row = giveDataOpSta(i);
            if (row == "11111") {
                rowFull++;
            } else if (row == "00000") {
                if (rowFull > 0) {
                    borrarmsg();
                    checkAddDBDatOpe(rowFull);
                    RowPope = rowFull;
                } else {
                    var menCam = "inserte una operacion";
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    var men = $('#msg');
                    men.html(menCam);
                    $('#TOope' + i).focus();
                    return 0;
                }
            } else {
                checkCellEmptyOpeSta(i, row);
                return 0;
            }
        } else {
            if (row == "11111111") {
                rowFull++;
            } else if (row == "00000000") {
                if (rowFull > 0) {
                    borrarmsg();
                    checkAddDBDatOpe(rowFull);
                    RowPope = rowFull;
                    return 1;
                } else {
                    var menCam = "inserte una operacion";
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    var men = $('#msg');
                    men.html(menCam);
                    $('#TOope' + i).focus();
                    return 0;
                }
            } else {
                setCheckAdd(0);
                checkCellEmptyOpe(i, row);
                return 0;
            }
        }
    }
}

function checkRowDbOpe(pos) {
    var ptoT = $('#TOptoTr' + pos).val();
    var cent = $('#TOcent' + pos).val();
    var cls = $('#TOsta' + pos).val();
    var umd = $('#TOumd' + pos).val();
    var acc = "checkRowOpe";
    var dataSend = "&rowOPto=" + ptoT + "&rowOCent=" + cent + "&rowOCls=" + cls + "&rowOUmd=" + umd;
    var rowP;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            rowP = data;
        }
    });
    return rowP;
}
function checkRowDbOpeSta(pos) {
    var ptoT = $('#TOptoTr' + pos).val();
    var cent = $('#TOcent' + pos).val();
    var cls = $('#TOsta' + pos).val();
    var acc = "checkRowOpeSta";
    var dataSend = "&rowOPto=" + ptoT + "&rowOCent=" + cent + "&rowOCls=" + cls;
    var rowP;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            rowP = data;
        }
    });
    return rowP;
}
function checkAddDBDatOpe(noRows) {
    var row = "";
    var clv = $("input[name^='TOsta']");
    var status;
    var check;
    for (var i = 0; i < noRows; i++) {
        row = checkRowDbOpe(i);
        status = clv[i].value;
        if (status == "PM02" || status == "PM03") {
            check = checkDBDatOpeSta(i);
            if (check == 1) {
            } else if (check == 0) {
                checkDBDatOpeSta(i);
                setCheckAdd(0);
                return;
            }
        } else {
            if (row == "1111") {

            } else {
                if (row.substr(0, 1).toString() == 0) {
                    invalidCell("TOptoTr", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(1, 1).toString() == 0) {
                    invalidCell("TOcent", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(2, 1).toString() == 0) {
                    invalidCell("TOsta", i);
                    setCheckAdd(0);
                    return;
                } else if (row.substr(3, 1).toString() == 0) {
                    invalidCell("TOumd", i);
                    setCheckAdd(0);
                    return;
                }
            }
        }
    }
    setCheckAdd(1);
}
function checkDBDatOpe(noRows) {
    var row = "";
    var clv = $("input[name^='TOsta']");
    var status;
    var check;
    for (var i = 0; i < noRows; i++) {
        row = checkRowDbOpe(i);
        status = clv[i].value;
        if (status == "PM02" || status == "PM03") {

            check = checkDBDatOpeSta(i);
            if (check == 1) {

            } else if (check == 0) {
                checkDBDatOpeSta(i);
                return;
            }
        } else {
            if (row == "1111") {

            } else {
                tabOpe();
                if (row.substr(0, 1).toString() == 0) {
                    invalidCell("TOptoTr", i);
                    return;
                } else if (row.substr(1, 1).toString() == 0) {
                    invalidCell("TOcent", i);
                    return;
                } else if (row.substr(2, 1).toString() == 0) {
                    invalidCell("TOsta", i);
                    return;
                } else if (row.substr(3, 1).toString() == 0) {
                    invalidCell("TOumd", i);
                    return;
                }
            }
        }
    }
    checkInserccionFull();
}

//FUNCIONES INSERTAR DB
function guardarOpe(fol) {
    acc = "insertarOperacion";
    var rows = rowsOfTable("TablaOperaciones");
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var sta = $("input[name^='TOsta']");
    var des = $("input[name^='TOdesOpe']");
    var cant = $("input[name^='TOcant']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var hora = giveHora();
    var fecha = giveHoy();
    var dataSend = "";
    var fuckVariable;
    for (var i = 0; i < rows; i++) {
        fuckVariable = des[i].value;
        fuckVariable = fuckVariable.replace(/'/g, "´");
        dataSend = "&cellOpe=" + ope[i].value + "&cellPto=" + pto[i].value + "&cellCen=" + cen[i].value + "&cellSta=" + sta[i].value + "&cellDes=" + encodeURIComponent(fuckVariable) + "&cellCant=" + cant[i].value + "&cellDur=" + dur[i].value + "&cellUmd=" + umd[i].value + "&folio=" + fol + "&hora=" + hora + "&fecha=" + fecha;
        if (ope[i].value == "") {
            break;
        }
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloCrearOrden',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + dataSend,
            success: function (rs) {
                if (rs) {
                    insOpe = true;
                    //  alert("inserccion Fallida");
                } else {
                    insOpe = false;
                    // alert("inserccion Exitosa");
                }
            }
        });
    }
    var check3 = checkEmptyTableMate();
    if (check3 == 1) {
        insertarOpe(fol);
    }
}
function insertarOpe(fol) {
    acc = "insertarOpe2";
    var rows = rowsOfTable("tablaMate");
    var ope = $("input[name^='TMnoOpe']");
    var ctd1 = $("input[name^='TMctdO1']");
    var ctd2 = $("input[name^='TMctdO2']");
    var pre1 = $("input[name^='TMpre1']");
    var pre2 = $("input[name^='TMpre2']");
    var gpoA = $("input[name^='TMgpoA1']");
    var gpoC1 = $("input[name^='TMgpoC1']");
    var gpoC2 = $("input[name^='TMgpoC2']");
    var soli = $("input[name^='TMsoli']");
    var clC = $("input[name^='TMclC']");
    var acre = $("input[name^='TMacre']");

    var ctd;
    var campos = "";
    for (var i = 0; i < rows; i++) {
        //                ctd1[i].value = checkDecCant2(ctd1[i].value,ctd2[i].value);
        ctd = checkDecCant2(ctd1[i].value, ctd2[i].value);
        campos = "&fieldUndT=" + ctd2[i].value +
                "&fieldCtdO=" + ctd +
                "&fieldOrgC=" + gpoC2[i].value +
                "&fieldGpoC=" + gpoC1[i].value +
                "&fieldGpoA=" + gpoA[i].value +
                "&fieldprecio=" + pre1[i].value +
                "&fieldClvM=" + pre2[i].value +
                "&fieldClsC=" + clC[i].value +
                "&fieldSol=" + soli[i].value +
                "&fieldNumO=" + ope[i].value +
                "&fieldFolS=" + fol +
                "&fieldAcre=" + checkValNull(acre[i].value);
        if (ope[i].value == "") {
            break;
        }
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloCrearOrden',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + campos,
            success: function (rs) {

            }
        });
    }

}
function checkValNull(val) {
    if (val == null) {
        val == "";
    }
    return val;
}
function guardarComp(fol) {
    acc = "insertarMaterial";
    var rows = rowsOfTable("TablaComponentes");
    var mat = $("input[name^='TCmat']");
    var lot = $("input[name^='TClot']");
    var txtB = $("input[name^='TCtxtB']");
    var cant = $("input[name^='TCcant']");
    var umc = $("input[name^='TCumc']");
    var cent = $("input[name^='TCcent']");
    var alm = $("input[name^='TCalm']");
    var ope = $("input[name^='TCope']");
    var hora = giveHora();
    var fecha = giveHoy();
    var dataSend = "";
    var culo;
    for (var i = 0; i < rows; i++) {
        culo = txtB[i].value;
        culo = culo.replace(/'/g, "´");
        dataSend = "&compMat=" + mat[i].value + "&compLot=" + lot[i].value + "&compTxt=" + encodeURIComponent(culo) + "&compCant=" + cant[i].value + "&compUmc=" + umc[i].value + "&compCent=" + cent[i].value + "&compAlm=" + alm[i].value + "&compOpe=" + ope[i].value + "&folio=" + fol + "&hora=" + hora + "&fecha=" + fecha;
        if (ope[i].value == "") {
            break;
        }
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloCrearOrden',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + dataSend,
            success: function (rs) {
                if (rs) {
//                      alert("inserccion Fallida");
                } else {
//                     alert("inserccion Exitosa");
                }
            }
        });

    }
}
function insertarSer(fol) {
    acc = "insertarServicio";
    var rows = rowsOfTable("tablaServi");
    var noOpe = $("input[name^='TSnoOpe']");
    var noS = $("input[name^='TSnoS']");
    var cant = $("input[name^='TScant']");
    var preEs1 = $("input[name^='TSpreEs1']");
    var preEs2 = $("input[name^='TSpreEs2']");
    var gpoA2 = $("input[name^='TSgpoA2']");
    var clsC = $("input[name^='TSclsC']");
    var txtS = $("input[name^='TStxtS']");
    var umdS = $("input[name^='TSumdS']");
    var dataSend = "";
    for (var i = 0; i < rows; i++) {
        dataSend = "&serNoOpe=" + noOpe[i].value + "&serNoS=" + noS[i].value +
                "&serCant=" + cant[i].value +
                "&serPreEs1=" + preEs1[i].value + "&serPreEs2=" + preEs2[i].value +
                "&serGpoA2=" + gpoA2[i].value +
                "&serClsC=" + clsC[i].value +
                "&serClsC=" + clsC[i].value +
                "&serTxtS=" + txtS[i].value +
                "&serUmdS=" + umdS[i].value +
                "&folio=" + fol;
        if (noOpe[i].value == "") {
            break;
        }
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionModuloCrearOrden',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + dataSend,
            success: function (rs) {

            }
        });
    }
}
function insertarDatCab(fol) {
    acc = "insertCabecera";
    var claseOr = $('#ClOrden').val();
    var descri = $('#Descri').val();
    var equi = $('#Equipo').val();
    var ubiTec = $('#UbiTec').val();
    var centP = $('#CentPl').val();
    var ptoRes = $('#PtoTjo').val();
    var ini = $('#fechIni').val();
    var fin = $('#fechFin').val();
    var hora = giveHora();
    var fecha = giveHoy();
    var description = descri.replace(/'/g, "´");
    var datosSend = "&cabClo=" + claseOr + "&cabDes=" + encodeURIComponent(description) + "&cabEqui=" + equi + "&cabUbiT=" + ubiTec + "&cabCentP=" + centP + "&cabPtoR=" + ptoRes + "&cabHor=" + hora + "&cabFech=" + fecha + "&cabFechIni=" + ini + "&cabFechFin=" + fin + "&folio=" + fol + "&cabUs=" + uXname;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            if (rs) {
                insCab = true;
                //                alert("inserccion Exitosa");
            } else {
                insCab = false;
                //                alert("inserccion Fallida");
            }
        }
    });
}
function insercionMasiva() {
    var check1 = checkEmptyTableComp();
    var check2 = checkEmptyTableServi();
    var fol = $('#ordenFol').val();


    if (check1 == 1) {
        guardarComp(fol);
    }
    if (check2 == 1) {
        insertarSer(fol);
    }

    insertarTxtsD(fol);
    guardarOpe(fol);
    insertarDatCab(fol);

    limpiarPrn();
    limpiarSer();
    limpiarTabComp();
    limpiarTabOpe();
    limpiarTabServi();
    limpiarTabMate();
    var menCam = "Orden Modificada - " + fol;
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/aceptar.png";
    var men = document.getElementById("msg");
    men.innerHTML = menCam;
    rowAdO = 0;
    rowMate = 0;
    rowServi = 0;
    rowComp = 0;
    window.location.href = "ModificarOrden.jsp";
}
function insertarTxtsD(fol) {
    acc = "insertTxtsD";
    var rows = rowsOfTable("tablaTxtsDes");
    var ope = document.getElementsByName('TDnumOpe');
    var txts = document.getElementsByName('TDtxtD');
    var ind, dataSend;
    for (var i = 0; i < rows; i++) {
        if (ope[i].value.length < 1) {
            return;
        } else if (txts[i].value.length < 1) {

        } else if (txts[i].value.length > 0) {
            var x = 1;
            ind = Math.ceil((txts[i].value.length) / 132);
            while (x <= ind) {
                var inicio = (x - 1) * 132;
                var fin = 132 * x;
                var txt = txts[(i)].value.replace(/'/g, "´");
                var tx = txt.substr(inicio, fin);
                dataSend = "&folio=" + fol +
                        "&cellOpe=" + ope[(i)].value +
                        "&indice=" + x +
                        "&cabDes=" + encodeURIComponent(tx);
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'peticionModuloCrearOrden',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "acc=" + acc + dataSend,
                    success: function (rs) {
                        if (rs) {
                            //                            alert("inserccion Fallida");
                        } else {
                            //                            alert("inserccion Exitosa");
                        }
                    }
                });
                x++;
            }
        }
    }
}
function eliminarOrden() {
    acc = "truncateOrden";
    var ord = $('#ordenFol').val();
    var datosSend = "&orden=" + ord;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + datosSend,
        success: function (rs) {
            insercionMasiva();
        }
    });
}






//FUNCIONES INSERTAR FILA
function defaultRowOpe(i, ope) {
    var centP = $('#CentPl').val();
    var ptoRes = $('#PtoTjo').val();
    $('#TOope' + i).val(ope);
    $('#TOcont' + i).val(numAleatorioSinRepetir());
    $('#TOptoTr' + i).val(ptoRes);
    $('#TOcent' + i).val(centP);
    $('#TOsta' + i).val("PM01");
    $('#TOtiemReal' + i).val("0.000");
}
function checkOblData() {
    var claseOr = $('#ClOrden').val();
    var descri = $('#Descri').val();
    var check2 = checharEquiUbi();
    var centP = $('#CentPl').val();
    var ptoRes = $('#PtoTjo').val();
    if (claseOr.length < 1 || descri.length < 1 || check2.length < 1 || centP.length < 1 || ptoRes.length < 1) {
        return 0;
    } else {
        return 1;
    }
}
function addOpe() {
    var chk = checkOblData();
    if (chk == 0) {
        dataFocusPrincipal();
        return;
    }
    var rows = rowsOfTable('TablaOperaciones');
    var row, rowN = 0, rowT = "";
    var aux;
    for (var i = 0; i <= rowAdO; i++) {
        try {
            row = $('#TOope' + i).val();

        } catch (e) {
        }
        aux = i + 1;
        if (aux == rows) {
            addRowOpe(i);
            addOpe();
            enableRowOpe(i);
            return;
        } else if (row.length < 1) {
            if (rowAdO == 0) {
                enableRowOpe(i);
                defaultRowOpe(i, "0010");

                rowAdO++;
                return;
            } else {
                checkAddEmptyTableOp();
                var con = getCheckAdd();
                if (con == 0) {
                    checkAddEmptyTableOp();
                    return;
                }
                rowN = (rowAdO + 1) * 10;
                enableRowOpe(i);
                defaultRowOpe(i, rowT);
                rowAdO++;
                if (rowN < 100) {

                    rowT = "00" + rowN;
                    enableRowOpe(i);
                    defaultRowOpe(i, rowT);

                    return;
                } else if (rowN < 1000) {
                    rowT = "0" + rowN;
                    enableRowOpe(i);
                    defaultRowOpe(i, rowT);
                    return;
                } else {
                    enableRowOpe(i);
                    defaultRowOpe(i, rowN);
                    return;
                }
            }
        } else if (row.length > 0) {
        }
    }
}

//FUNCIONES GENERALES
function valBol(val) {
    if (val) {
        return 1;
    } else {
        return 0;
    }
}
function rowFullOpe() {
    var rows = rowsOfTable('TablaOperaciones');
    var row, rowFull = 0;
    for (var i = 0; i < rows; i++) {
        row = giveDataOp(i);
        if (row == "11111111") {
            rowFull++;
        }
    }
    return rowFull;
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
    hoy = yyyy + '-' + mm + '-' + dd;
    return hoy;
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
function errorDataIncomplet() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    var msj = "Faltan Datos Obligatorios";
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/advertencia.PNG";
    var men = document.getElementById("msg");
    men.innerHTML = msj;
}
function ValidarMaximo(id, num) {
    if (num < 1) {
        document.getElementById(id).value = 100;
    }
}
function MensajeSalirModulo()
{
    var ventana = document.getElementById('MensajeSalirModulo');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}
function CerrarMensajeSalirModulo()
{
    var ventana = document.getElementById('MensajeSalirModulo');
    ventana.style.display = 'none';
}
//function inval() {
//    var mein = '<%=funcioninv%>';
//    var iconm = document.getElementById("iconmsg");
//    iconm.style.visibility = "visible";
//    iconm.src = "images/advertencia.PNG";
//    var men = document.getElementById("msg");
//    men.innerHTML = mein;
//}





function blockPropiety(handle, ventanaM) {
    // $("BODY").append('<div id="overlay"></div>');
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}

function borrarmsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
}
function datosincorrectos() {
    var menCam = $("#mjDatosIncorrectos").val();
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/aceptar.png";
    var men = document.getElementById("msg");
    men.innerHTML = menCam;
}
function bloq() {
    $('#iconmsg').hide();
    $('#aceptar').prop("disabled", true);
}
function getTypeUMD(umd) {
    var type;
    var dataSend = "&umd=" + umd;
    var acc = "obtenerDecimalesUM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloCrearOrden',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            // alert(data);
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
            // alert(data);
            type = data;
        }
    });
    return type;
}
function getExisNumEqui(equi) {
    var type;
    var dataSend = "&equi=" + equi;
    var acc = "validarNumEqui";
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
function checkDec(num, tam) {
    if (num > 99999999) {
    } else if (num.length < 1) {
        num = 0;
    }
    var d = parseFloat(num).toFixed(tam);
    return d;
}
function checkDecCant1(num, tam, input) {
    var d;
    var umd;
    if (num.length > 0) {
        umd = document.getElementById(input).value;
        if (umd.length < 1) {
            document.getElementById(input).focus();
            return num;
        } else {
            var exisU = getExisUMD(umd);
            if (exisU == 1) {
                var type = getTypeUMD(umd);
                if (type == 0) {
                    num = Math.round(num);
                    d = parseFloat(num).toFixed(tam);
                    return d;
                } else if (type == 3) {
                    var a2 = Math.floor(num * 1000) / 1000;
                    num = parseFloat(a2).toFixed(tam);
                    return num;
                }
            } else {
                document.getElementById(input).focus();
                return num;
            }
        }
    } else if (num.length < 1) {
        return "";
    }
}
function checkDecCant2(inp1, inp2) {
    var cant = inp1;
    var umd = inp2;
    var exisU = getExisUMD(umd);
    if (exisU == 1) {
        var type = getTypeUMD(umd);
        if (type == 0) {
            var d = Math.round(cant);
            var a2 = Math.floor(d * 1000) / 1000;
            var numR = parseFloat(a2).toFixed(3);
            return numR;
        } else if (type == 3) {
            var numY = cant;
            var numX = Math.floor(numY * 1000) / 1000;
            var x = parseFloat(numX).toFixed(3);
            return x;
        }
    } else {
    }
}
function check99(num, max, tam) {
    var numEn = num.toFixed(num);
    if (numEn <= max) {
        return num;
    } else {
        var numMod = num.substring(0, tam) + "" + num.substring((tam + 1), num.length);
        return numMod;
    }
}
function returnRestri(buscarP, consultaTab, input) {
    $('#' + buscarP).show();
    $('#' + consultaTab).hide();
    $('#' + input).focus();
}
function blockEmptyOpe() {
    var rows = rowsOfTable('TablaOperaciones');
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var clv = $("input[name^='TOsta']");
    var sta = $("input[name^='TOclvOpe']");

    var des = $("input[name^='TOdesOpe']");
    var can = $("input[name^='TOcant']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var valOpe;
    for (var i = 0; i < rows; i++) {
        valOpe = ope[i].value;
        sta.disabled = true;
        if (valOpe.length < 1) {
            ope[i].disabled = true;
            pto[i].disabled = true;
            cen[i].disabled = true;
            clv[i].disabled = true;
            des[i].disabled = true;
            can[i].disabled = true;
            dur[i].disabled = true;
            umd[i].disabled = true;
        }
    }
}

function validarDatTabOpe() {

    $("[id*=TOdesOpe]").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        patron = /[0-9 A-Z a-z]/;
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
    $("[id*=TOsta]").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            popUpSta();
        }
    });

}
function refreshNumAl() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var contO = $("input[name^='TOcont']");
    var opeO = $("input[name^='TOope']");
    for (var i = 0; i < rowsO; i++) {
        if (opeO[i].value.length > 1) {
            contO[i].value = numAleatorioSinRepetir();
            rowAdO++;
        }
    }
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
function tabComp() {
    var check = checkPMope();
    if (check == 0) {
        var menCam = "No existen operaciones validas";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        var men = document.getElementById("msg");
        men.innerHTML = menCam;
    } else {
        $('#seccionOpe').hide();
        $('#tabOpe').css({backgroundColor: '#fff'});
        $('#tabOpe').css('color', '#000');
        $('#seccionComp').show();
        $('#tabComp').css({backgroundColor: '#007CC0'});
        $('#tabComp').css('color', '#fff');
        var rows = rowsOfTable('TablaComponentes');

        var pos = $("input[name^='TCpos']");
        var mat = $("input[name^='TCmat']");
        var lot = $("input[name^='TClot']");
        var txtB = $("input[name^='TCtxtB']");
        var cant = $("input[name^='TCcant']");
        var umc = $("input[name^='TCumc']");
        var cent = $("input[name^='TCcent']");
        var alm = $("input[name^='TCalm']");
        var ope = $("input[name^='TCope']");
        var sol = $("input[name^='TCsolp']");
        var ite = $("input[name^='TCitsol']");
        for (var i = 0; i < rows; i++) {
            pos[i].disabled = false;
            mat[i].disabled = false;
            lot[i].disabled = false;
            txtB[i].disabled = false;
            cant[i].disabled = false;
            umc[i].disabled = false;
            cent[i].disabled = false;
            alm[i].disabled = false;
            ope[i].disabled = false;
            sol[i].disabled = true;
            ite[i].disabled = true;
        }
    }
}
function CheckResolucion() {
    if (screen.width <= 500) {
        var msgResolucion = '<%=reso%>';
        alert(msgResolucion);
        window.location.href = "Bienvenido.jsp";
    }
}


function rowsOfTable(table) {
    var rows = $('#' + table + ' >tbody >tr').length;
    return rows;
}
function invalidCell(type, pos) {
    var obj = $('#' + type + pos);
    obj.focus();
    var sentence = setType(type);
    var menCam = sentence + " " + obj.val() + " no encontrado";
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(menCam);
}

function setType(type) {
    switch (type) {
        case "TCalm":
            return "Almacen";
            break;
        case "TCcent":
            return "Centro";
            break;
        case "TCumc":
            return "UMC";
            break;
        case "TClot":
            return "Lote";
            break;
        case "TCmat":
            return "Material";
            break;
        case "TOptoTr":
            return "puesto de trabajo";
            break;
        case "TOcent":
            return "centro";
            break;
        case "TOsta":
            return "status";
            break;
        case "TOumd":
            return "umd";
            break;
    }
}
function limpiarPrn() {
    $('#ClOrden').val("");
    $('#Descri').val("");
    $('#Equipo').val("");
    $('#UbiTec').val("");
    $('#CentPl').val("");
    $('#PtoTjo').val("");
    $('#fechIni').val(giveHoy());
    $('#fechFin').val("");
    $('#NumHR').val("");
    $('#ContHR').val("");
    $('#NumLstMat').val("");
    $('#altMat').val("");
    var ClOrd = $('#ClOrden');
    var Descr = $('#Descri');
    var Equip = $('#Equipo');
    var UbiTe = $('#UbiTec');
    var CentP = $('#CentPl');
    var PtoTj = $('#PtoTjo');

    var DatObli = [ClOrd, Descr, Equip, UbiTe, CentP, PtoTj];
    $.each(DatObli, function (i, v) {
        if (v.val().length > 0) {
            v.css('background-image', 'none');
            v.css("background-color", "#ffffff");
        } else {
            v.css({background: 'url(images/necesario.PNG) no-repeat'});
            v.css("background-color", "#ffffff");
        }
    });
}
function limpiarSer() {
    $('#serNoSer').val("");
    $('#serCant').val("");
    $('#serPrecEst1').val("");
    $('#serPrecEst2').val("");
    $('#serGrpArt2').val("");
    $('#serClCost').val("");
    $('#serCtdOp1').val("");
    $('#serCtdOp2').val("");
    $('#serPrec1').val("");
    $('#serPrec2').val("");
    $('#serGrArt').val("");
    $('#serGrCom1').val("");
    $('#serGrCom2').val("");
    $('#serContr1').val("");
    $('#serContr2').val("");
    $('#serDest').val("");
    $('#serPlzEnt').val("");
    $('#serClvCl').val("");
    $('#serPor').val("");
    $('#serClCos').val("");
    $('#serAcre').val("");
    $('#serRegInf').val("");
    $('#serPtoDes').val("");
    $('#serNoNes').val("");
    $('#serPedMar1').val("");
    $('#serPedMar2').val("");
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
    var matchSnoS = $('#serNoSer');
    var matchScant = $('#serCant');
    var matchSgrpAr = $('#serGrpArt2');
    var matchSclCost = $('#serClCost');
    var DatObliServi2 = [matchSnoS, matchScant, matchSgrpAr, matchSclCost];
    $.each(DatObliServi2, function (ind, va) {
        va.css({background: 'url(images/necesario.PNG) no-repeat'});
    });
}
function limpiarTabOpe() {
    var rows = rowsOfTable("TablaOperaciones");
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var sta = $("input[name^='TOsta']");
    var des = $("input[name^='TOdesOpe']");
    var cant = $("input[name^='TOcant']");
    var timR = $("input[name^='TOtiemReal']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var cont = $("input[name^='TOcont']");
    var divSeccionDatosRecibo = $('#capaTabs');
    var elemDatoRecibo = $('#capaTabs :text');
    for (var j = 0; j < elemDatoRecibo.length; j++) {
        elemDatoRecibo[j].disabled = true;
    }
    divSeccionDatosRecibo.disabled = true;
    for (var i = 0; i < rows; i++) {
        try {
            ope[i].value = "";
            pto[i].value = "";
            cen[i].value = "";
            sta[i].value = "";
            des[i].value = "";
            cant[i].value = "";
            dur[i].value = "";
            umd[i].value = "";
            cont[i].value = "";
            timR[i].value = "";
        } catch (e) {
        }
    }
}
function limpiarTabComp() {
    var rows = rowsOfTable("TablaComponentes");
    var mat = $("input[name^='TCmat']");
    var lot = $("input[name^='TClot']");
    var txtB = $("input[name^='TCtxtB']");
    var cant = $("input[name^='TCcant']");
    var umc = $("input[name^='TCumc']");
    var cent = $("input[name^='TCcent']");
    var alm = $("input[name^='TCalm']");
    var ope = $("input[name^='TCope']");
    for (var i = 0; i < rows; i++) {
        try {
            mat[i].value = "";
            lot[i].value = "";
            txtB[i].value = "";
            cant[i].value = "";
            umc[i].value = "";
            cent[i].value = "";
            alm[i].value = "";
            ope[i].value = "";
        } catch (e) {
        }
    }
}
function limpiarTabMate() {
    var rows = rowsOfTable("tablaMate");

    var ope = $("input[name^='TMnoOpe']");
    var ctd1 = $("input[name^='TMctdO1']");
    var ctd2 = $("input[name^='TMctdO2']");
    var pre1 = $("input[name^='TMpre1']");
    var pre2 = $("input[name^='TMpre2']");
    var gpoA = $("input[name^='TMgpoA1']");
    var gpoC1 = $("input[name^='TMgpoC1']");
    var gpoC2 = $("input[name^='TMgpoC2']");
    var contr1 = $("input[name^='TMcontr1']");
    var contr2 = $("input[name^='TMcontr2']");
    var dest = $("input[name^='TMdest']");
    var soli = $("input[name^='TMsoli']");
    var plzE = $("input[name^='TMplzE']");
    var subC = $("input[name^='TMsubC']");
    var clvCl = $("input[name^='TMclvCl']");
    var clvCX = $("input[name^='TMpor']");
    var clC = $("input[name^='TMclC']");
    var acre = $("input[name^='TMacre']");
    var regI = $("input[name^='TMregI']");
    var ptoD = $("input[name^='TMptoD']");
    var noN = $("input[name^='TMnoN']");
    var pedM1 = $("input[name^='TMpedM1']");
    var pedM2 = $("input[name^='TMpedM2']");
    var cont = $("input[name^='TMcont']");

    for (var i = 0; i < rows; i++) {
        try {
            ope[i].value = "";
            ctd1[i].value = "";
            ctd2[i].value = "";
            pre1[i].value = "";
            pre2[i].value = "";
            gpoA[i].value = "";
            gpoC1[i].value = "";
            gpoC2[i].value = "";
            contr1[i].value = "";
            contr2[i].value = "";
            dest[i].value = "";
            soli[i].value = "";
            plzE[i].value = "";
            subC[i].value = "";
            clvCl[i].value = "";
            clvCX[i].value = "";
            clC[i].value = "";
            acre[i].value = "";
            regI[i].value = "";
            ptoD[i].value = "";
            noN[i].value = "";
            pedM1[i].value = "";
            pedM2[i].value = "";
            cont[i].value = "";
        } catch (e) {
        }
    }
}
function limpiarTabServi() {
    var rows = rowsOfTable("tablaServi");

    var noOpe = $("input[name^='TSnoOpe']");
    var noS = $("input[name^='TSnoS']");
    var cant = $("input[name^='TScant']");
    var preEs1 = $("input[name^='TSpreEs1']");
    var preEs2 = $("input[name^='TSpreEs2']");
    var gpoA2 = $("input[name^='TSgpoA2']");
    var clsC = $("input[name^='TSclsC']");
    var txtS = $("input[name^='TStxtS']");
    var umdS = $("input[name^='TSumdS']");
    var cont = $("input[name^='TScont']");

    for (var i = 0; i < rows; i++) {
        try {
            noOpe[i].value = "";
            noS[i].value = "";
            cant[i].value = "";
            preEs1[i].value = "";
            preEs2[i].value = "";
            gpoA2[i].value = "";
            clsC[i].value = "";
            cont[i].value = "";
            txtS[i].value = "";
            umdS[i].value = "";
            cont[i].value = "";
        } catch (e) {
        }
    }
}

function setCheckAdd(valor) {
    checkAdd = valor;
}
function getCheckAdd() {
    return checkAdd;
}
CheckResolucion();


function back() {
    window.location.href = "ModificarOrden.jsp";
}
function backW() {
    window.location.href = "Bienvenido.jsp";
}

function enableRowOpe(i) {
    var pos = $("input[name^='TOpos']");
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var clv = $("input[name^='TOclvOpe']");
    var sta = $("input[name^='TOsta']");
    var des = $("input[name^='TOdesOpe']");
    var can = $("input[name^='TOcant']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var cont = $("input[name^='TOcont']");
    pos[i].disabled = false;
    ope[i].disabled = false;
    pto[i].disabled = false;
    cen[i].disabled = false;
    clv[i].disabled = true;
    sta[i].disabled = false;
    des[i].disabled = false;
    can[i].disabled = false;
    dur[i].disabled = false;
    can[i].disabled = false;
    umd[i].disabled = false;
    cont[i].disabled = false;
}
function checarTabs() {
    var clOr = $('#ClOrden').val();
    var des = $('#Descri').val();
    if (clOr.length < 1 || des.length < 1) {
        $("#TablaOperaciones").find(":text").prop('readonly', true);
        $("#TablaComponentes").find(":text").prop('readonly', true);
    } else {
        $("#TablaOperaciones").find(":text").prop('readonly', false);
        $("#TablaComponentes").find(":text").prop('readonly', false);
    }
}

function MensajeEliminarOpe() {
    var ventana = document.getElementById('MensajeSalirModulo');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}
function CerrarMensajeEliminarOperacion() {
    var ventana = $('#MensajeSalirModulo');
    ventana.hide();
}





var addRowNope = 0;
function addRowOpe(tam) {
    var nRow = tam + addRowNope;
    var fila = "<tr>\n"
            + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TOpos\" value=" + nRow + "></td>\n"
            + "                <td><input type=\"text\" name=\"TOope\" id=\"TOope" + nRow + "\" onfocus=\"BtnHideTO()\" style=\"width: 55px;\"></td>\n"
            + "                <td><input type=\"text\" name=\"TOptoTr\" id=\"TOptoTr" + nRow + "\" onfocus=\"BtnShowTO('" + nRow + "','match_TOptoTr')\" style=\"width: 105px;\" onKeyUp=\"this.value = this.value.toUpperCase();\">     <button id=\"match_TOptoTr" + nRow + "\" name=\"match_TOptoTr\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTOPtoTr('" + nRow + "')\"></button> </td>\n"
            + "                <td><input type=\"text\" name=\"TOcent\" id=\"TOcent" + nRow + "\" onfocus=\"BtnShowTO('" + nRow + "','match_TOcent')\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\">       <button id=\"match_TOcent" + nRow + "\" name=\"match_TOcent\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOCent('" + nRow + "')\"></button></td>\n"
            + "                <td><input type=\"text\" name=\"TOsta\" id=\"TOsta" + nRow + "\" onfocus=\"BtnShowTO('" + nRow + "','match_TOsta')\" value=\"\" style=\"width: 75px;\" onKeyUp=\"this.value = this.value.toUpperCase();\">         <button id=\"match_TOsta" + nRow + "\" name=\"match_TOsta\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOSta('" + nRow + "')\"></button></td>\n"
            + "                <td><input type=\"text\" name=\"TOclvOpe\" id=\"TOclvOpe" + nRow + "\" onfocus=\"BtnHideTO()\"style=\"width: 120px;\" disabled></td>\n"
            + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + nRow + "\" onfocus=\"BtnHideTO()\"style=\"width: 280px;\"></td>\n"
            + "                <td><input type=\"text\" name=\"TOtiemReal\" id=\"TOtiemReal" + nRow + "\" onfocus=\"BtnHideTO()\" style=\"width: 150px;\" disabled></td>\n"
            + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + nRow + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\"></td>\n"
            + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + nRow + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\"></td>\n"
            + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + nRow + "\" onfocus=\"BtnShowTO('" + nRow + "','match_TOumd')\" style=\"width: 65px;\">     <button id=\"match_TOumd" + nRow + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + nRow + "')\"></button></td>\n"
            + "                <td style=\"visibility: hidden;\"><input type=\"text\" name=\"TOcont\" id=\"TOcont" + nRow + "\">     </td>\n"
            + "           </tr>";
    $('#TablaOperaciones').append(fila);
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
                alert(document.getElementById("TOope" + i).value);
                rowCount--;
                i--;
            }
        } catch (e) {
        }
    }
    actualizarOpe();
    actualizarIds();


}

function checarDelRowOpe() {
    var rows = rowsOfTable("TablaOperaciones");
    var ope = document.getElementsByName('TOope');
    var check = document.getElementsByName('TOpos');
    var banServi = false;
    var banMate = false;
    var banOpe = false;
    var banDes = false;
    for (var i = 0; i <= rows; i++) {
        var conti = i + 1;
        try {
            if (check[i].checked)
            {
                try {
                    delRowServi(ope[(i)].value);
                    delRowMate(ope[(i)].value);
                    delRowDescri(ope[(i)].value);
                    delRowOpe(conti);
                    banMate = true;
                    banOpe = true;
                    banServi = true;
                    banDes = true;
                    rows = (rowsOfTable("TablaOperaciones") - 1);
                    i--;
                } catch (e) {
                }
            } else {
                rows = (rowsOfTable("TablaOperaciones") - 1);
            }
        } catch (e) {
        }
    }
    if (banOpe) {
        actualizarOpe();
        actualizarIds();
    }
    if (banServi) {
        actualizarServicios();
    }
    if (banMate) {
        actualizarMateriales();
    }
    if (banDes) {
        refreshNumOpeDescri();
    }
}


function delRowDescri(opeO) {
    var rows = rowsOfTable("tablaTxtsDes");
    var table = document.getElementById("tablaTxtsDes");
    var opeM = document.getElementsByName('TDnumOpe');
    for (var i = 0; i < rows; i++) {
        try {
            if (opeM[i].value == "") {
                return;
            } else {
                if (opeM[i].value == opeO) {
                    table.deleteRow((i + 1));
                }
            }
        } catch (e) {
        }
    }

}
function refreshNumOpeDescri() {
    var rowsD = rowsOfTable("tablaTxtsDes");
    var rowsOpe = rowsOfTable("TablaOperaciones");

    var opeOp = document.getElementsByName('TOope');
    var opeDes = document.getElementsByName('TDnumOpe');


    var contD = document.getElementsByName('TDcont');
    var opeCont = document.getElementsByName('TOcont');
    var table = document.getElementById("tablaTxtsDes");
    for (var i = 0; i < rowsD; i++) {
        try {
            if (opeDes[i].value.length < 1) {
                return;
            }
            for (var d = 0; d < rowsOpe; d++) {
                if (opeCont[d].value == contD[i].value) {
                    opeDes[i].value = opeOp[d].value;
                }
            }
        } catch (e) {
        }
    }
}

function actualizarServicios() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var rowsS = (rowsOfTable("tablaServi") - 1);
    var contO = document.getElementsByName('TOcont');
    var contS = document.getElementsByName('TScont');
    var opeS = document.getElementsByName('TSnoOpe');
    var opeO = document.getElementsByName('TOope');
    for (var i = 0; i < rowsO; i++) {
        for (var d = 0; d < rowsS; d++) {
            if (contS[d].value.length > 1) {
                if (contO[i].value == contS[d].value) {
                    opeS[d].value = opeO[i].value;
                }
            }
        }
    }
}
function delRowServi(opeO) {
    var rows = rowsOfTable("tablaServi");
    var table = document.getElementById("tablaServi");
    var opeS = document.getElementsByName('TSnoOpe');
    for (var i = 0; i < rows; i++) {
        try {
            if (opeO == "") {
            } else {
                if (opeS[i].value == opeO) {
                    table.deleteRow((i + 1));
                    rowServi--;
                }
            }
        } catch (e) {
        }
    }
}

function actualizarMateriales() {
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var rowsM = (rowsOfTable("tablaMate") - 1);
    var contO = document.getElementsByName('TOcont');
    var contM = document.getElementsByName('TMcont');
    var opeM = document.getElementsByName('TMnoOpe');
    var opeO = document.getElementsByName('TOope');
    for (var i = 0; i < rowsO; i++) {
        for (var d = 0; d < rowsM; d++) {
            if (contM[d].value.length > 1) {
                if (contO[i].value == contM[d].value) {
                    opeM[d].value = opeO[i].value;
                }
            }
        }
    }
}
function actualizarIds() {
    var rows = (rowsOfTable("TablaOperaciones") - 1);
    var ope = document.getElementsByName('TOope');
    var pto = document.getElementsByName('TOptoTr');
    var cen = document.getElementsByName('TOcent');
    var sta = document.getElementsByName('TOsta');
    var des = document.getElementsByName('TOdesOpe');
    var cant = document.getElementsByName('TOcant');
    var dur = document.getElementsByName('TOdura');
    var umd = document.getElementsByName('TOumd');

    var mPto = document.getElementsByName('match_TOptoTr');
    var mCent = document.getElementsByName('match_TOcent');
    var mUmd = document.getElementsByName('match_TOumd');
    var mSta = document.getElementsByName('match_TOsta');
    var mDes = document.getElementsByName('match_TOdesOpe');
    var cont = document.getElementsByName('TOcont');
    {
        var SmatchPto = function (x) {
            BtnShowTO(x, 'match_TOptoTr');
        };
        var SmatchCent = function (x) {
            BtnShowTO(x, 'match_TOcent');
        };
        var SmatchUmd = function (x) {
            BtnShowTO(x, 'match_TOumd');
        };
        var SmatchSta = function (x) {
            BtnShowTO(x, 'match_TOsta');
        };
        var SmatchDes = function (x) {
            BtnShowTO(x, 'match_TOdesOpe');
        };
        var matchSta = function (x) {
            matchTOSta(x);
        };
        var matchPto = function (x) {
            matchTOPtoTr(x);
        };
        var matchCent = function (x) {
            matchTOCent(x);
        };
        var matchUmd = function (x) {
            matchTOUMD(x);
        };

    }
    for (var d = 0; d < rows; d++) {

        try {
            ope[(d)].setAttribute('id', 'TOope' + d);

            pto[(d)].setAttribute('id', 'TOptoTr' + d);
            pto[(d)].addEventListener('focus', SmatchPto.bind(this, d));

            cen[(d)].setAttribute('id', 'TOcent' + d);
            cen[(d)].addEventListener('focus', SmatchCent.bind(this, d));

            sta[(d)].setAttribute('id', 'TOsta' + d);
            sta[(d)].addEventListener('focus', SmatchSta.bind(this, d));

            des[(d)].setAttribute('id', 'TOdesOpe' + d);
            des[(d)].addEventListener('focus', SmatchDes.bind(this, d));

            cant[(d)].setAttribute('id', 'TOcant' + d);
            dur[(d)].setAttribute('id', 'TOdura' + d);

            cont[(d)].setAttribute('id', 'TOcont' + d);
            umd[(d)].setAttribute('id', 'TOumd' + d);
            umd[(d)].addEventListener('focus', SmatchUmd.bind(this, d));

            mPto[(d)].setAttribute('id', 'match_TOptoTr' + d);
            mPto[(d)].addEventListener('click', matchPto.bind(this, d));

            mSta[(d)].setAttribute('id', 'match_TOsta' + d);
            mSta[(d)].addEventListener('click', matchSta.bind(this, d));

            mCent[(d)].setAttribute('id', 'match_TOcent' + d);
            mCent[(d)].addEventListener('click', matchCent.bind(this, d));

            mUmd[(d)].setAttribute('id', 'match_TOumd' + d);
            mUmd[(d)].addEventListener('click', matchUmd.bind(this, d));

            mDes[(d)].setAttribute('id', 'match_TOdesOpe' + d);
        } catch (e) {
        }
    }
}
function actualizarOpe() {
    var ope = document.getElementsByName('TOope');
    var rows = (rowsOfTable('TablaOperaciones') - 1);
    var rowN = 0, rowT = "";
    for (var i = 0; i <= rows; i++) {
        try {
            if (ope[i].value.length < 1) {
                break;
            } else {
                if (i == 0) {
                    ope[i].value = "0010";
                } else {
                    rowN = (i + 1) * 10;
                    if (rowN < 100) {
                        rowT = "00" + rowN;
                        ope[i].value = rowT;
                    } else if (rowN < 1000) {
                        rowT = "0" + rowN;
                        ope[i].value = rowT;
                    } else {
                        rowT = "" + (rowN + 10);
                        ope[i].value = rowN;
                    }
                }
            }
        } catch (e) {
        }
    }
}
function delRowOpe(cn) {
    var table = document.getElementById('TablaOperaciones');
    table.deleteRow(cn);
    rowAdO--;
}
function delRowMate(opeO) {
    var rows = rowsOfTable("tablaMate");
    var table = document.getElementById("tablaMate");
    var opeM = document.getElementsByName('TMnoOpe');
    for (var i = 0; i < rows; i++) {
        try {
            if (opeO == "") {

            } else {
                if (opeM[i].value == opeO) {
                    table.deleteRow((i + 1));
                    rowMate--;
                }
            }

        } catch (e) {
        }
    }
}



var numerosAparecidos = [];
function numAleatorioSinRepetir() {
    var minimo = 0;
    var maximo = 1000;
    var i;
    if (minimo == "reset") {
        if (!this.minimo || !this.maximo)
            return;
        for (i = this.minimo; i <= this.maximo; i++)
            this.numerosAparecidos.push(i);
        return;
    }
    if (isNaN(minimo) || isNaN(maximo))
        return;
    if (minimo != this.minimo || maximo != this.maximo) {
        if (minimo > maximo) {
            i = minimo;
            minimo = maximo;
            maximo = i;
        }
        this.minimo = minimo;
        this.maximo = maximo;
        this.numerosAparecidos = [];
        for (i = minimo; i <= maximo; i++)
            this.numerosAparecidos.push(i);
    }
    var random = Math.floor(Math.random() * this.numerosAparecidos.length);
    var numero = this.numerosAparecidos[random];
    this.numerosAparecidos.splice(random, 1);
    return numero;
}
function deleteRowComp(tableID) {
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

    actualizarIdsComp();

}
function actualizarIdsComp() {
    var rows = (rowsOfTable("TablaComponentes") - 1);
    var pos = document.getElementsByName('TCpos');
    var mat = document.getElementsByName('TCmat');
    var lot = document.getElementsByName('TClot');
    var txt = document.getElementsByName('TCtxtB');
    var can = document.getElementsByName('TCcant');
    var umc = document.getElementsByName('TCumc');
    var cen = document.getElementsByName('TCcent');
    var alm = document.getElementsByName('TCalm');
    var ope = document.getElementsByName('TCope');
    var mMat = document.getElementsByName('match_TCmat');
    var mUmc = document.getElementsByName('match_TCumc');
    var mCen = document.getElementsByName('match_TCcent');
    var mAlm = document.getElementsByName('match_TCalm');
    try {
        var newArray = new Array(mat);

        $("input:text[name=TCmat]").each(function () {
            newArray.off();
        });
    } catch (e) {
    }
    {
        var SmatchMat = function (x) {
            BtnShowTC(x, 'match_TCmat');
        };
        var SmatchUMC = function (x) {
            BtnShowTC(x, 'match_TCumc');
        };
        var SmatchCent = function (x) {
            BtnShowTC(x, 'match_TCcent');
        };
        var SmatchAlm = function (x) {
            BtnShowTC(x, 'match_TCalm');
        };


        var matchMatX = function (x) {
            matchTCmat(x);
        };
        var matchUMCX = function (x) {
            matchTCUMC(x);
        };
        var matchCentX = function (x) {
            matchTCcent(x);
        };
        var matchAlmX = function (x) {
            matchTCalm(x);
        };

    }
    for (var d = 0; d < rows; d++) {

        try {
            pos[(d)].setAttribute('id', 'TCpos' + d);
            mat[(d)].setAttribute('id', 'TCmat' + d);
            mat[(d)].addEventListener('focus', SmatchMat.bind(this, d));
            lot[(d)].setAttribute('id', 'TClot' + d);
            txt[(d)].setAttribute('id', 'TCtxtB' + d);
            can[(d)].setAttribute('id', 'TCcant' + d);
            umc[(d)].setAttribute('id', 'TCumc' + d);
            umc[(d)].addEventListener('focus', SmatchUMC.bind(this, d));
            cen[(d)].setAttribute('id', 'TCcent' + d);
            cen[(d)].addEventListener('focus', SmatchCent.bind(this, d));
            alm[(d)].setAttribute('id', 'TCalm' + d);
            alm[(d)].addEventListener('focus', SmatchAlm.bind(this, d));
            ope[(d)].setAttribute('id', 'TCope' + d);

            mMat[(d)].setAttribute('id', 'match_TCmat' + d);
            mMat[(d)].removeEventListener('click', matchTCmat);
            mMat[(d)].addEventListener('click', matchMatX.bind(this, d));

            mUmc[(d)].setAttribute('id', 'match_TCumc' + d);
            mUmc[(d)].addEventListener('click', matchUMCX.bind(this, d));

            mCen[(d)].setAttribute('id', 'match_TCcent' + d);
            mCen[(d)].addEventListener('click', matchCentX.bind(this, d));

            mAlm[(d)].setAttribute('id', 'match_TCalm' + d);
            mAlm[(d)].addEventListener('click', matchAlmX.bind(this, d));
        } catch (e) {
        }
    }
}



function checkError() {
    var ord = $('#ordenFol').val();
    var error = $('#errorOrd').val();
    if (error == "true") {
        acc = "cargarError";
        $.ajax({
            async: true,
            type: 'GET',
            url: 'peticionModificarOrdenKey',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + "&orden=" + ord,
            success: function (rs) {
                $('#DivDatosBasicos3').show();
                $('#errorTxt').html(rs);
            }
        });
    } else if (error == "false") {
        $('#DivDatosBasicos3').hide();
    }
}


function mostrarVentanaModalib() {
    var opeOp = document.getElementsByName('TOope');
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalTextli');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borrarmsg();
    var theHandle = document.getElementById("handle3");
    var theRoot = document.getElementById("VentanaModalTextli");
    Drag.init(theHandle, theRoot);
    $('#opCurrent').html(opeOp[posSta].value);
    cargarTxtDes(opeOp[posSta].value);

}
function cargarTxtDes(ope) {
    var txtD = document.getElementsByName('TDtxtD');
    var txtArea = document.getElementById('Textlib');
    var numO = document.getElementsByName('TDnumOpe');
    var rows = rowsOfTable('tablaTxtsDes');
    for (var i = 0; i < rows; i++) {
        if (numO[i].value == ope) {
            txtArea.value = txtD[i].value;
            break;
        }
    }
}
function ocultartexa() {
    $("#VentanaModalTextli").hide();
    $("#Textlib").val("");
}
function borrarTxtDes() {
    ocultartexa();
    var opeOp = document.getElementsByName('TOope');
    var opeActO = opeOp[posSta].value;
    var numO = document.getElementsByName('TDnumOpe');
    var rows = rowsOfTable('tablaTxtsDes');
    var txtD = document.getElementsByName('TDtxtD');
    for (var i = 0; i < rows; i++) {
        if (numO[i].value == opeActO) {
            txtD[i].value = "";
            break;
        }
    }
}
function guardarDecri() {
    var opeOp = document.getElementsByName('TOope');
    var opeCont = document.getElementsByName('TOcont');
    var numO = document.getElementsByName('TDnumOpe');
    var txtD = document.getElementsByName('TDtxtD');
    var contD = document.getElementsByName('TDcont');
    var txtArea = document.getElementById('Textlib');
    var rows = rowsOfTable('tablaTxtsDes');
    var opeD;
    for (var i = 0; i < rows; i++) {
        opeD = numO[i].value;
        if (opeD.length < 1) {
            txtD[i].value = txtArea.value;
            numO[i].value = opeOp[posSta].value;
            numO[i].value = opeOp[posSta].value;
            contD[i].value = opeCont[posSta].value;
            break;
        } else if (opeD == opeOp[posSta].value) {
            txtD[i].value = txtArea.value;
            numO[i].value = opeOp[posSta].value;
            contD[i].value = opeCont[posSta].value;
            break;
        }
    }
    ocultartexa();
}
function bloqCab() {
    $("input").prop('disabled', true);
    $("select").prop('disabled', true);

    $("button").prop('disabled', true);
    $("#EditS").prop('disabled', false);
    $("#cancelar").prop('disabled', false);
    $("#regresar").prop('disabled', false);
    $("#finalizar").prop('disabled', false);
}
function checkUser() {
    acc = "validarUser";
    var dataSend = "&orden=" + uXname;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'peticionModuloModificarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            if (rs == 1) {
                enableScreen();
            } else if (rs == 0) {
                var menCam = "Usuario no asignado a orden";
                $('#iconmsg').prop('src', 'images/Editar.png');
                $('#iconmsg').show();
                $('#msg').html(menCam);
            }
        }
    });
}
function enableScreen() {
    $("input").prop('disabled', false);
    $("select").prop('disabled', false);
    $("button").prop('disabled', false);
    $("#btnservicios").prop('disabled', true);
    var rowsO = (rowsOfTable("TablaOperaciones") - 1);
    var opeO = document.getElementsByName('TOope');

    for (var i = 0; i < rowsO; i++) {

        if (opeO[i].value == "") {
            blockRowOpe(i);
        } else {
            blockRowOpe2(i);
        }
    }
}
function blockRowOpe(i) {
    var pos = $("input[name^='TOpos']");
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var clv = $("input[name^='TOclvOpe']");
    var sta = $("input[name^='TOsta']");
    var des = $("input[name^='TOdesOpe']");
    var can = $("input[name^='TOcant']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var cont = $("input[name^='TOcont']");
    pos[i].disabled = true;
    ope[i].disabled = true;
    pto[i].disabled = true;
    cen[i].disabled = true;
    clv[i].disabled = true;
    sta[i].disabled = true;
    des[i].disabled = true;
    can[i].disabled = true;
    dur[i].disabled = true;
    can[i].disabled = true;
    umd[i].disabled = true;
    cont[i].disabled = false;
}
function blockRowOpe2(i) {
    var pos = $("input[name^='TOpos']");
    var ope = $("input[name^='TOope']");
    var pto = $("input[name^='TOptoTr']");
    var cen = $("input[name^='TOcent']");
    var clv = $("input[name^='TOclvOpe']");
    var sta = $("input[name^='TOsta']");
    var des = $("input[name^='TOdesOpe']");
    var can = $("input[name^='TOcant']");
    var dur = $("input[name^='TOdura']");
    var umd = $("input[name^='TOumd']");
    var cont = $("input[name^='TOcont']");
    pos[i].disabled = false;
    ope[i].disabled = false;
    pto[i].disabled = false;
    cen[i].disabled = false;
    clv[i].disabled = true;
    sta[i].disabled = false;
    des[i].disabled = false;
    can[i].disabled = false;
    dur[i].disabled = false;
    can[i].disabled = false;
    umd[i].disabled = false;
    cont[i].disabled = false;
}


