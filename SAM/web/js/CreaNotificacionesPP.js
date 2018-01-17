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
                alert("no hay datos por mostrar");
//                mesajess(0, "images/aceptar.png");

            } else {
                $("#BuscarParam_u1").css("display", "none");
                $("#ConsultaTabla1").css("display", "block");
                $("#nofixedX1").html(res);
                fnc();
            }
        }

    });
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
            url: 'PeticionNotificacionesOrdenesSAMPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + enviar,
            success: function (data) {
                var res = data;            
                if (res == 0) {
                    ordsta();
                    //ordequ();
                    tabmax();
                } else if (res == 2) {
                    tabmaxPASAM();
                    CargaTabEQSAM();
                } else {
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    msgMatch("NPMOrNoExx2");
                }
//                tabCar();
            }
        });
    }
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
                    if (v1 == "PP01") {
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
                    } else if (v1 == "PP03") {
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
                    } else if (v1 == "PP02") {
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

function pm1prt1(ord, oper) {
    var enviar = "&orden=" + ord + "&opera=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionCabPP01PP",
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

function seleccionar(we, ids, ven) {
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