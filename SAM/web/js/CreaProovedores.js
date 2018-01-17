/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    startTime();

    $("#regresar").click(function () {
        back();
    });
    function back() {
        window.location.href = "Bienvenido.jsp";
    }
    var ACREED = $('#Acreed');
    var SOCIED = $('#sociedad');
    var ORGCOMP = $('#org_compras');
    var NOMPROV = $('#nomProv');
//    var NOM2PROV = $('#nombre2_pro');
//    var NOM4PROV = $('#nombre4_pro');
    var POBLAC = $('#poblacion_pro');
    var RECID = $('#residencia_pro');
    var CALLE = $('#calle_pro');
    var DISTRITO = $('#distrito_pro');
    var EDIFICIO = $('#edificio_pro');
    var NIF = $('#nif_pro');
    var PAGO = $('#pago_pro');
    var ABC = $('#ABC_pro');
    var GPOCUENT = $('#grupocuentas_pro');
    var CUENTASO = $('#cuentaaso_pro');
    var MONEDA = $('#moneda_pro');
    var VALOR = $('#valor_pro');
    var ICO1 = $('#ico1_pro');
    var ICO2 = $('#ico2_pro');
    var CONFIR = $('#confir_pro');
    var GPOCOMP = $('#grupocompras_pro');
    //** Checkbox **
    var PETBOR = $('#petBor_pro');
    var BLOQCONTA = ('#bloqConta_pro');
    var PETBORCE = $('#petBorCe_pro');

    var arrayDAT = [
        ACREED,
        SOCIED,
        ORGCOMP,
        NOMPROV,
        POBLAC,
        RECID,
        CALLE,
        DISTRITO,
        EDIFICIO,
        NIF,
        PAGO,
        ABC,
        GPOCUENT,
        CUENTASO,
        MONEDA,
        VALOR,
        ICO1,
        ICO2,
        CONFIR,
        GPOCOMP
    ];
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
        });
    });
//    $('#Acreed').css("background-image", "url(images/necesario.PNG)");
//    $('#sociedad').css("background-image", "url(images/necesario.PNG)");
//    $('#org_compras').css("background-image", "url(images/necesario.PNG)");
//    $('#match_C1').hide();
//    $('#match_C2').hide();
//    $('#match_C3').hide();
//    $('#Acreed').focus(function () {
//        $('#Acreed').css("background-image", "none");
//        if ($('#sociedad').val().length < 1) {
//            $('#sociedad').css("background-image", "url(images/necesario.PNG)");
//        }
//        if ($('#org_compras').val().length < 1) {
//            $('#org_compras').css("background-image", "url(images/necesario.PNG)");
//        }
//        $('#match_C1').show();
//        $('#match_C2').hide();
//        $('#match_C3').hide();
//    });
//    $('#sociedad').focus(function () {
//        $('#match_C1').hide();
//        $('#match_C2').show();
//        $('#match_C3').hide();
//        if ($('#Acreed').val().length < 1) {
//            $('#Acreed').css("background-image", "url(images/necesario.PNG)");
//        }
//        $('#sociedad').css("background-image", "none");
//        if ($('#org_compras').val().length < 1) {
//            $('#org_compras').css("background-image", "url(images/necesario.PNG)");
//        }
//    });
//    $('#org_compras').focus(function () {
//        if ($('#Acreed').val().length < 1) {
//            $('#Acreed').css("background-image", "url(images/necesario.PNG)");
//        }
//        if ($('#sociedad').val().length < 1) {
//            $('#sociedad').css("background-image", "url(images/necesario.PNG)");
//        }
//        $('#org_compras').css("background-image", "none");
//        $('#match_C1').hide();
//        $('#match_C2').hide();
//        $('#match_C3').show();
//    });
//    $('#match_C1').click(function () {
//        $("BODY").append('<div id="overlay"></div>');
//        mostrarVentanaModal('proveedor');
//        var theHandle = document.getElementById("handle");
//        var theRoot = document.getElementById("VentanaModalProveedor");
//        Drag.init(theHandle, theRoot);
//    });
//    $('#match_C2').click(function () {
//        $("BODY").append('<div id="overlay"></div>');
//        mostrarVentanaModal('sociedad');
//        var theHandle = document.getElementById("handle2");
//        var theRoot = document.getElementById("VentanaModalSociedad");
//        Drag.init(theHandle, theRoot);
//    });
//    $('#match_C3').click(function () {
//        $("BODY").append('<div id="overlay"></div>');
//        mostrarVentanaModal('compras');
//        var theHandle = document.getElementById("handle3");
//        var theRoot = document.getElementById("VentanaModalOrgCompras");
//        Drag.init(theHandle, theRoot);
//    });
//    $('#nomProv_ProvBusc').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13)
//            ConsultaProveedor();
//    });
//    $('#Idrov_RpvBus').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13)
//            ConsultaProveedor();
//    });
//    $('#numAcMax').keypress(function (e) {
//        var tec = (document).all ? e.keyCode : e.which;
//        if (tec === 8) {
//            return false;
//        }
//        if (tec === 13) {
//            ConsultaProveedor();
//        }
//        patron = /[0-9]/;
//        te = String.fromCharCode(tec);
//        return patron.test(te);
//    });
//    $('#okProveedor').click(function () {
//        ConsultaProveedor();
//    });
//    $('#Soc_CLbus').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaSociedad();
//        }
//    });
//    $('#nomSoc_CLBus').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaSociedad();
//        }
//    });
//    $('#PoblaciSoc_CLBus').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaSociedad();
//        }
//    });
//    $('#ClvMone_CLBus').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaSociedad();
//        }
//    });
//    $('#numAcMax2').keypress(function (e) {
//        var tec = (document).all ? e.keyCode : e.which;
//        if (tec === 8) {
//            return false;
//        }
//        if (tec === 13) {
//            ConsultaSociedad();
//        }
//        patron = /[0-9]/;
//        te = String.fromCharCode(tec);
//        return patron.test(te);
//    });
//    $('#OkSociedad').click(function () {
//        ConsultaSociedad();
//    });
//    $('#OrgaCom_Pro').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaOrgCompras();
//        }
//    });
//    $('#Denom_Pro').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ConsultaOrgCompras();
//        }
//    });
//    $('#okOrgaCom').click(function () {
//        ConsultaOrgCompras();
//    });
//    $('#numAcMax3').keypress(function (e) {
//        var tec = (document).all ? e.keyCode : e.which;
//        if (tec === 8) {
//            return false;
//        }
//        if (tec === 13) {
//            ConsultaOrgCompras();
//        }
//        patron = /[0-9]/;
//        te = String.fromCharCode(tec);
//        return patron.test(te);
//    });    
//    $('#Acreed').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ValidarDatos();
//        }
//    });
//    $('#sociedad').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ValidarDatos();
//        }
//    });
//    $('#org_compras').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            ValidarDatos();
//        }
//    });    
    $('#guardar').click(function () {
        ValidarDatos();
    });
    function ValidarDatos() {      
        var temp = new Array();
        temp[0] = ACREED;
        temp[1] = SOCIED;
        temp[2] = ORGCOMP;
        temp[3] = NOMPROV;
//        NOM2PROV,
//        NOM4PROV,
        temp[4] = POBLAC;
        temp[5] = RECID;
        temp[6] = CALLE;
        temp[7] = DISTRITO;
        temp[8] = EDIFICIO;
        temp[9] = NIF;
        temp[10] = PAGO;
        temp[11] = ABC;
        temp[12] = GPOCUENT;
        temp[13] = CUENTASO;
        temp[14] = MONEDA;
        temp[15] = VALOR;
        temp[16] = ICO1;
        temp[17] = ICO2;
        temp[18] = CONFIR;
        temp[19] = GPOCOMP;
//        temp[20] = PETBOR;
//        temp[21] = BLOQCONTA;
//        temp[22] = PETBORCE;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        GuardarDatosProv();
    }
    function GuardarDatosProv() {
        var check = "0";
        if ($('#petBor_pro').is(':checked')) {
            check = "1";
        }
        if ($('#bloqConta_pro').is(':checked')) {
            check = "2";
        }
        if ($('#petBorCe_pro').is(':checked')) {
            check = "3";
        }
        var acc = "GuardarDatos";
        var par = "&acreedor=" + ACREED.val() + "&sociedad=" + SOCIED.val() + "&orgComp=" + ORGCOMP.val() + "&nomProv=" + NOMPROV.val() + "&poblacion=" + POBLAC.val() + "&recidencia=" + RECID.val() + "&calle=" + CALLE.val() + "&distrito=" + DISTRITO.val() + "&edificio=" + EDIFICIO.val() + "&nif=" + NIF.val() + "&pago=" + PAGO.val() + "&abc=" + ABC.val() + "&gpoCuenta=" + GPOCUENT.val() + "&cuentaSo=" + CUENTASO.val() + "&moneda=" + MONEDA.val() + "&valor=" + VALOR.val() + "&ico1=" + ICO1.val() + "&ico2=" + ICO2.val() + "&config=" + CONFIR.val() + "&gpoComp=" + GPOCOMP.val() + "&tipChek=" + check;
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "PeticionModuloCreaProveedores",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                if (data == 5) {
                    ShowMsg(3, "images/aceptar.png", "audio/sapmsg.wav");
                    limpiar();
//                    reiniDatOb();                    
                }
                if (data == 6) {
                    ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
//                    reiniDatOb();
                    limpiar();

                }
            }
        });

    }
    function limpiar() {
        $.each(arrinp, function (i, v) {
            v.val("");
        });
    }
    $('#retornfiltprov').click(function () {
        document.getElementById("BuscarParam_Prov").style.display = "block";
        document.getElementById("ConsultaTabla").style.display = "none";
    });
    $('#retornfiltrosoc').click(function () {
        document.getElementById("BuscarParamSoc_u").style.display = "block";
        document.getElementById("ConsultaTabla2").style.display = "none";
    });
    $('#retornfiltorgco').click(function () {
        document.getElementById("BuscarParam_OC").style.display = "block";
        document.getElementById("ConsultaTabla3").style.display = "none";
    });

});
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
