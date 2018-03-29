/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#notor').focus(function () {
        $('#match_N1').show();
    });
    $('#match_N1').blur(function () {
        $('#match_N1').hide();
    });
    $('#match_N1').click(function () {
        mostrarVentanaModal("VentanaModal");
        $('#ordmatvm').focus();
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
            cargar();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#okAv').click(function () {
        ocultarVentana('VentanaModalAv', 'bxPedido');
    });
});
function enterMat(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 13) {
        cargar();
    }
}
function cargar() {

    var env1vm = $("#env1vm").val();
    var ordmatvm = $("#ordmatvm").val();
    var txtbrvm = $("#txtbrvm").val();
    var env5vm = $("#env5vm").val();
    var enviar = "&env1vm=" + env1vm + "&ordmatvm=" + ordmatvm + "&txtbrvm=" + txtbrvm + "&env5vm=" + env5vm;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionesOrdenesCrearNotiPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            var res = data;
            if (res == 0) {
//                alert("no hay datos por mostrar");
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
function mostrarPP(e, r) {
    tecla = (document.all) ? e.keyCode : e.which;
    $("#ivreq").html("d");
    var acc = "checarOrdenPP";
    if (tecla == 13) {
        if (r == null || r == "") {
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            msgMatch("NPMCamOrOb");
        } else {
            borrarmsg();
            var enviar = "&ord=" + r;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionNotificacionesOrdenesSAMPP',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + enviar,
                success: function (data) {
                    var res = data;
                    if (res == 0) {
                        ponercentro();
                        ordsta();
                        tabmax();
                    } else if (res == 2) {
                        tabmaxPASAM();
                        CargaTabEQSAM();
//                                            CargarEQUI();
                    } else {
                        $('#notsta').val("");
                        $("#iconmsg").css("visibility", "visible");
                        $("#iconmsg").attr("src", "images/advertencia.PNG");
                        msgMatch("NPMOrNoExx2");
                    }
//                    tabCar();
                }
            });
        }
    }
}
function ponercentro() {
    var ord = $("#notor").val();
    var acc = "PonerCentro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificacionesOrdenesSAMPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&ord=" + ord,
        success: function (data) {
            $("#cennot").val(data);
        }
    });
}
function mostrar1PP() {
    $("#divreq").html("d");
    var ord = $("#notor").val();
    var acc = "checarOrdenPP";
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
            url: 'PeticionNotificacionesOrdenesSAMPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                var res = data;
                if (res == 0) {
                    //Funcion para oner el centro de la orden
                    ponercentro();
                    //Funcion para poner el status de la orden
//                    ordsta();
                    //Cargar tabla inferior
                    tabmax();
                } else if (res == 2) {
                    tabmaxPASAMPP();
//                    Cargar seccion de equipo solo status
                    CargaTabEQSAMPP();
                } else {
                    $('#notsta').val("");
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    msgMatch("NPMOrNoExx2");
                }
//                tabCar();
            }
        });
    }
}
function CargaTabEQSAMPP() {
    var ord = $("#notor").val();
    var acc = "CarEQORDPP";
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
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
function tabmaxPASAMPP() {
    var ord = $("#notor").val();
    var ope = $("#notope").val();
    var acc = "CarTAbUNPP";
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#bodyc").html(res);
        }

    });
}
function ordsta() {
    var acc = "ChecarStatusOrdenOpe";
    var ord = $("#notor").val();
    var oper = $("#notope").val();
    var enviar = "&ord=" + ord + "&oper=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#divoc").html(res);
            ponerStat();
        }

    });

}
function ponerStat() {
    var sta2 = $("#nosta").val();
    var sta1 = $("#notsta").val(sta2);
}
function tabmax() {
    var acc = "LlenarTabMax";
    var ord = $("#notor").val();
    var ope = $("#notope").val();
    var enviar = "&ord=" + ord + "&ope=" + ope;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            var res = data;
            $("#bodyc").html(res);
        }
    });

}

//ABRIR VENTANAS MODALES NOTIFICACIONES PP
var cenOpe;
function selecoftabPP() {
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
            //Si el status de la orden pertenece a algun status de arriba no se abrirá
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
                    if (v1 == "PP03") {
                        pp1prt3FORSAMPP(ord, v2);
                        mostrarventabs("ventaPM01");
                        var theHandle = document.getElementById("handlePM01");
                        var theRoot = document.getElementById("ventaPM01");
                        Drag.init(theHandle, theRoot);
                        AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpoCld');
                        document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                    }
//                    else if (v1 == "PP03") {
//                        if (ord.length == 10) {
//                            pp3prt1FORSAMPP(ord, v2);
//                            pp3prt2FORSAMPP(ord, v2);
//                            pp3prt3FORSAMPP(ord, v2);
//                            //      $("BODY").append('<div id="overlayve"></div>');
//                            mostrarventabs("ventatabdes");
//                            var theHandle = document.getElementById("handleDes");
//                            var theRoot = document.getElementById("ventatabdes");
//                            Drag.init(theHandle, theRoot);
//                        } else {
//                            pp3prt1PP(ord, v2);
//                            pp3prt2PP(ord, v2);
//                            pp3prt3PP(ord, v2);
//                            pp3prt4PP(ord, v2);
//                            //     $("BODY").append('<div id="overlayve"></div>');
//                            mostrarventabs("ventatabdes");
//                            var theHandle = document.getElementById("handleDes");
//                            var theRoot = document.getElementById("ventatabdes");
//                            Drag.init(theHandle, theRoot);
//                        }
//                    } else if (v1 == "PP02") {
//                        if (ord.length == 10) {
//
//                            pp3prt1FORSAMPP(ord, v2);
//                            pp3prt2FORSAMPP(ord, v2);
//                            pp3prt3FORSAMPP(ord, v2);
//                            //     $("BODY").append('<div id="overlayve"></div>');
//                            mostrarventabs("ventatabdes");
//                            var theHandle = document.getElementById("handleDes");
//                            var theRoot = document.getElementById("ventatabdes");
//                            Drag.init(theHandle, theRoot);
//                        } else {
//                            pp3prt1PP(ord, v2);
//                            pp3prt2PP(ord, v2);
//                            pp3prt3PP(ord, v2);
//                            pp3prt4PP(ord, v2);
//                            //       $("BODY").append('<div id="overlayve"></div>');
//                            mostrarventabs("ventatabdes");
//                            var theHandle = document.getElementById("handleDes");
//                            var theRoot = document.getElementById("ventatabdes");
//                            Drag.init(theHandle, theRoot);
//                        }
//
//                    } 
                    else {
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
//TRAER SAM PP01//
function pp1prt1FORSAMPP(ord, oper) {
    var acc = "CabePP1";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm11").html(data);
            ponerpp1();
        }
    });
}
function ponerpp1() {
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
function pp1prt3FORSAMPP(ord, oper) {
    var acc = "TablasPP01MAtPP";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            document.getElementById('SecCuerpoCld').innerHTML = data;
        }
    });
}
//TRAER SAP PP01//
function pp1prt1PP(ord, oper) {
    var acc = "pp1prt1PP";
    var enviar = "&ord=" + ord + "&oper=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm11").html(data);
            ponerpp1();
        }
    });
}
function pp1prt3PP(ord, ope) {
    var acc = "pp1prt3PP";
    var enviar = "&ord=" + ord + "&ope=" + ope + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#tabp1").html(data);
            ponerpp1();
        }

    });
}
//TRAER SAM PP03//
function pp3prt1FORSAMPP(ord, oper) {
    var acc = "POn1P3SAMPP";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm13").html(data);
            pp13();
        }
    });
}
function pp13() {
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
function pp3prt2FORSAMPP(ord, oper) {
    var acc = "POn2P3SAMPP";
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt1").html(data);
        }

    });
}
function pp3prt3FORSAMPP(ord, oper) {
    var acc = "POn3P3SAMPP";
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt2").html(data);
//				poner();
        }
    });
}
//Traer SAP PP03//
function pp3prt1PP(ord, oper) {
    var acc = "pp3prt1PP";
    var enviar = "&ord=" + ord + "&oper=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#divpm13").html(data);
            pm13();
        }
    });
}

function pp3prt2PP(ord, oper) {
    var acc = "pp3prt2PP";
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt1").html(data);
        }

    });
}
function pp3prt3PP(ord, oper) {
    var acc = "pp3prt3PP";
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt2").html(data);
        }

    });
}
function pp3prt4PP(ord, oper) {
    var acc = "pp3prt4PP"
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#bpmt3").html(data);
//				poner();
        }

    });
}
var folT;
function valNotTiemPP01() {
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
    // durp1 - Input duracion
    if (durp1 == "" || durp1 == null) {
        msgMatch('NPMDurReOb');
        mostrarventaavi();
    } else {
        //trrepl - No Personal
        if (trrep1 == "" || trrep1 == null) {
            msgMatch('nopecaob');
            mostrarventaavi();
        } else {
            var nf;
            //nfpm1 - Notificacion Final
            if (nfpm1.checked) {
                nf = "X";
            } else {
                nf = "";
            }
            var enviar = "&ord=" + ord + "&ope=" + ope + "&nf=" + nf + "&fenot=" + fenot + "&honot=" + honot + "&durp1=" + durp1 + "&durp2=" + durp2 + "&trrep1=" + trrep1 + "&nofip1=" + nofip1 + "&usu=" + usu;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionNotifiTiemPP',
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
                        vaciarCampos();
                        setTimeout(function () {
                            $("#msg").html("");
                            $("#iconmsg").css("visibility", "hidden");
                        }, 8000);
                        tabmax();
                        LiberarStatusPP();
//                        alert(durp1);
                        cambiarDuracionPP(durp1);
//                        abrirVentanaMsgAddFileT('VentanaModalMsgAddFileT', 'handleFileT');
                        folT = r2;
                    } else {

                    }
                }

            });
        }
    }
}
function vaciarCampos() {
    $("#durp1").val("");
    $("#nofip1").val("");
    $("#nfpm1").prop("checked", false);
}
function LiberarStatusPP() {
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
        var enviar = "&ord=" + ord + "&ope=" + nuevaCadena1 + "&hora=" + honot + "&fecha=" + fenot + "&acc=" + action + "&stat=" + stat + "&usu=" + usu;
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
            }
        });
    }
}
function cambiarDuracionPP(dura) {
    //Min - Hora de sap
    var durr = $('#udnp11');
    //Min - Hora que se selecciona
    var sss = $('#durp2');
    //Dato notificado hasta el momento 
    var Dhm = $("#aynp11").val();
    //No Orden
    var nuOrd = $("#notor").val();
    //Accion a realizar 
    var acc = "ACtuadurTraPP";
//    alert(dura, durr, sss, Dhm, nuOrd);
    if (durr.val() == 'MIN' && sss.val() == 'H')
    {
        var dhmin = parseFloat(Dhm) + (parseInt(dura * 60));
//        alert("uno, "+dhmin);
    } else
    {
        var dhmin = parseFloat(Dhm) + parseInt(dura);
//        alert("dos,"+ dhmin);
    }
    var enviar = "&dhm=" + dhmin + "&nuOrd=" + nuOrd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificacionesOrdenesSAMPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            if (data == 1) {
                $("#aynp11").val(dhmin);
            }
        },
    });


}
function mosboton(ids) {
    inpufuncion(ids);
    for (var i = 0; i < 51; i++) {
        if (ids != i) {
            $("#matmat1" + i).css("display", "none");
        } else {
            $("#matmat1" + ids).css("display", "inline");
        }
    }
}
function inpufuncion(ids) {
    $("#matab1" + ids).blur(function () {
        solatarMatePP(ids);
    });
}
function solatarMatePP(id) {
    var mate = document.getElementById("matab1" + id).value;
//    var mate = document.getElementById("matab1").value;
//    alert("mate: "+mate);
    var arr = new Array();
    var acc = "CarMatInvPP";
    var r1, r2, r3, r4, r5;
    var enviar = "&mate=" + mate.toUpperCase();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificacionesOrdenesSAMPP',
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
function VentModalmat(esd) {
    document.getElementById("mmid").value = esd;
    $(document).ready(function () {

        mostrarVentanaModal("VentModalmat");
        var theHandle = document.getElementById("handle11");
        var theRoot = document.getElementById("VentModalmat");
        Drag.init(theHandle, theRoot);
    });
}
function LoadMaters(url) {
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
function seleccionar(we, ids, ven) {
    $("#" + ids).val(we);
    $("#" + ids).focus();
    ocultarVentana(ven);
}
function seleccionarMate(we, ids, ven, cent) {
    $('#cennot').val(cent);
    $("#" + ids).val(we);
    $("#" + ids).focus();
    ocultarVentana(ven);
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
function retornaFiltroBus(id1, id2) {
    $("#" + id1).css("display", "block");
    $("#" + id2).css("display", "none");
}
function ListaMateriales() {
    mostrarVentanaModal('VentanaModalListaMat');
    var theHandle = document.getElementById('handle23');
    var theRoot = document.getElementById('VentanaModalListaMat');
    Drag.init(theHandle, theRoot);
    TablaLM();
}
function TablaLM() {
    var eq = $("#nteq").val();
    var lg = $("#clidi").val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificacionesOrdenesSAMPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=ListaMaterialNotificacionesC&v1=" + eq + "&v2=" + lg,
        success: function (data) {
            document.getElementById('SecCuerpo3').innerHTML = data;
            AjustarCabecera('TabHead3', 'TabBody3', 8, 'SecCuerpo3');
            document.getElementById('DobleContainer3').style.height = document.getElementById("TabBody3").offsetHeight + "px";
//            bloquearCamposResul();
        }
    });
}
//Consumir Material
function ConsMaterial() {

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
function fnc() {
    document.getElementById('table-scroll').onscroll = function () {

        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
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
function ocultarVentana(ids)
{
    var ventana = document.getElementById(ids);
    ventana.style.display = 'none';
    $("#BuscarParam_u1").css("display", "block");
    $("#ConsultaTabla1").css("display", "none");
    $("#BuscarParam_u2").css("display", "block");
    $("#ConsultaTabla2").css("display", "none");
}
function cerraventabs(id) {
    var venavisos = document.getElementById(id);
    venavisos.style.display = "none";
}

function libbotPP() {
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
    } else {
        EnviaStatusOrden("LIB.", "L");
    }
}

function EnviaStatusOrden(stat, ope) {
    var norden = $("#notor").val();
//    var centro = $("#cennot").val();
    var centro = "";
    var folsam = "";

    var send = "&v1=" + folsam +
            "&v2=" + norden +
            "&v3=" + centro +
            "&v4=" + ope + //Operación
            "&v5=" + usuario +
            "&v6=" + stat;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionListadoOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "action=guardaStatusNoti" + send,
        success: function (data) {
            var iconm = document.getElementById("iconmsg");
            iconm.style.display = "inline";
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = "Se ha grabado la orden con el número " + data;
            var stt = document.getElementById("notsta");
            var msj = stt.value;
            var sub = msj.substring(0, 4);
            var res = msj.replace(sub, stat);
            stt.value = res;
        }
    });
}

function canbotPP() {
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
    } else {
        EnviaStatusOrden("CTEC", "C");
    }
}
function cciebotPP() {
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
    } else {
        EnviaStatusOrden("LIB.", "A");
    }
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
function borrarmsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
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

function mensajesValidacionInco(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/advertencia.PNG";
    var men = document.getElementById("msg");
    men.innerHTML = msg;
}

function btnloteShow(){
    document.getElementsByName("");
}