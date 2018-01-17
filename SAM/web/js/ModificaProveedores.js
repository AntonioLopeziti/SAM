/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#Acreed').css("background-image", "url(images/necesario.PNG)");
    $('#sociedad').css("background-image", "url(images/necesario.PNG)");
    $('#org_compras').css("background-image", "url(images/necesario.PNG)");
    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').hide();
    $('#Acreed').focus(function () {
        $('#Acreed').css("background-image", "none");
        if ($('#sociedad').val().length < 1) {
            $('#sociedad').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#org_compras').val().length < 1) {
            $('#org_compras').css("background-image", "url(images/necesario.PNG)");
        }
        $('#match_C1').show();
        $('#match_C2').hide();
        $('#match_C3').hide();
    });
    $('#sociedad').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').show();
        $('#match_C3').hide();
        if ($('#Acreed').val().length < 1) {
            $('#Acreed').css("background-image", "url(images/necesario.PNG)");
        }
        $('#sociedad').css("background-image", "none");
        if ($('#org_compras').val().length < 1) {
            $('#org_compras').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#org_compras').focus(function () {
        if ($('#Acreed').val().length < 1) {
            $('#Acreed').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#sociedad').val().length < 1) {
            $('#sociedad').css("background-image", "url(images/necesario.PNG)");
        }
        $('#org_compras').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').show();
    });
    $('#match_C1').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('proveedor');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalProveedor");
        Drag.init(theHandle, theRoot);
    });
    $('#match_C2').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('sociedad');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSociedad");
        Drag.init(theHandle, theRoot);
    });
    $('#match_C3').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('compras');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalOrgCompras");
        Drag.init(theHandle, theRoot);
    });
    $('#nomProv_ProvBusc').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13)
            ConsultaProveedor();
    });
    $('#Idrov_RpvBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13)
            ConsultaProveedor();
    });
    $('#numAcMax').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec === 8) {
            return false;
        }
        if (tec === 13) {
            ConsultaProveedor();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tec);
        return patron.test(te);
    });
    $('#okProveedor').click(function () {
        ConsultaProveedor();
    });
    $('#Soc_CLbus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#nomSoc_CLBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#PoblaciSoc_CLBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#ClvMone_CLBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec === 8) {
            return false;
        }
        if (tec === 13) {
            ConsultaSociedad();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tec);
        return patron.test(te);
    });
    $('#OkSociedad').click(function () {
        ConsultaSociedad();
    });
    $('#OrgaCom_Pro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrgCompras();
        }
    });
    $('#Denom_Pro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrgCompras();
        }
    });
    $('#okOrgaCom').click(function () {
        ConsultaOrgCompras();
    });
    $('#numAcMax3').keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec === 8) {
            return false;
        }
        if (tec === 13) {
            ConsultaOrgCompras();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tec);
        return patron.test(te);
    });
    $('#aceptar').click(function () {
        ValidarDatos();
    });
    $('#Acreed').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ValidarDatos();
        }
    });
    $('#sociedad').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ValidarDatos();
        }
    });
    $('#org_compras').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ValidarDatos();
        }
    });
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
