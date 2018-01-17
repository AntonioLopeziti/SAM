/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#info_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I1').hide();
    $('#material_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I2').hide();
    $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I3').hide();
    $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I4').hide();
    $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I5').hide();
    $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
    $('#Match_I6').hide();
    $('#info_IR').focus(function () {
        $('#Match_I2').hide();
        $('#Match_I3').hide();
        $('#Match_I4').hide();
        $('#Match_I5').hide();
        $('#Match_I6').hide();
        $('#info_IR').css("background-image", "none");
        $('#Match_I1').show();
        if ($('#material_IR').val().length < 1) {
            $('#material_IR').css("background-image", "url(images/necesario.PNG)");
        }
        ('#Match_I1').show();
        if ($('#proveedor_IR').val().length < 1) {
            $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#orgCompras_IR').val().length < 1) {
            $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Infotipo_IR').val().length < 1) {
            $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro_IR').val().length < 1) {
            $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#material_IR').focus(function () {
        $('#Match_I3').hide();
        $('#Match_I4').hide();
        $('#Match_I5').hide();
        $('#Match_I6').hide();
        $('#Match_I1').hide();
        $('#material_IR').css("background-image", "none");
        $('#Match_I2').show();
        if ($('#info_IR').val().length < 1) {
            $('#info_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#proveedor_IR').val().length < 1) {
            $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#orgCompras_IR').val().length < 1) {
            $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Infotipo_IR').val().length < 1) {
            $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro_IR').val().length < 1) {
            $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#proveedor_IR').focus(function () {
        $('#Match_I4').hide();
        $('#Match_I5').hide();
        $('#Match_I6').hide();
        $('#Match_I1').hide();
        $('#Match_I2').hide();
        $('#proveedor_IR').css("background-image", "none");
        $('#Match_I3').show();
        if ($('#info_IR').val().length < 1) {
            $('#info_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#material_IR').val().length < 1) {
            $('#material_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#orgCompras_IR').val().length < 1) {
            $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)")
        }
        if ($('#Infotipo_IR').val().length < 1) {
            $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro_IR').val().length < 1) {
            $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#orgCompras_IR').focus(function () {
        $('#Match_I5').hide();
        $('#Match_I6').hide();
        $('#Match_I1').hide();
        $('#Match_I2').hide();
        $('#Match_I3').hide();
        $('#orgCompras_IR').css("background-image", "none");
        $('#Match_I4').show();
        if ($('#info_IR').val().length < 1) {
            $('#info_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#material_IR').val().length < 1) {
            $('#material_IR').css("background-image", "url(images/necesario.PNG");
        }
        if ($('#proveedor_IR').val().length < 1) {
            $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Infotipo_IR').val().length < 1) {
            $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)")
        }
        if ($('#centro_IR').val().length < 1) {
            $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#Infotipo_IR').focus(function () {
        $('#Match_I6').hide();
        $('#Match_I1').hide();
        $('#Match_I2').hide();
        $('#Match_I3').hide();
        $('#Match_I4').hide();
        $('#Infotipo_IR').css("background-image", "none");
        $('#Match_I5').show();
        if ($('#info_IR').val().length < 1) {
            $('#info_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#material_IR').val().length < 1) {
            $('#material_IR').css("background-image", "url(images/necesario.PNG");
        }
        if ($('#proveedor_IR').val().length < 1) {
            $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#orgCompras_IR').val().length < 1) {
            $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)")
        }
        if ($('#centro_IR').val().length < 1) {
            $('#centro_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#centro_IR').focus(function () {
        $('#Match_I1').hide();
        $('#Match_I2').hide();
        $('#Match_I3').hide();
        $('#Match_I4').hide();
        $('#Match_I5').hide();
        $('#centro_IR').css("background-image", "none");
        $('#Match_I6').show();
        if ($('#info_IR').val().length < 1) {
            $('#info_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#material_IR').val().length < 1) {
            $('#material_IR').css("background-image", "url(images/necesario.PNG");
        }
        if ($('#proveedor_IR').val().length < 1) {
            $('#proveedor_IR').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#orgCompras_IR').val().length < 1) {
            $('#orgCompras_IR').css("background-image", "url(images/necesario.PNG)")
        }
        if ($('#Infotipo_IR').val().length < 1) {
            $('#Infotipo_IR').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#Match_I1').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("registroinfo");
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalRegistro");
        Drag.init(theHandle, theRoot);
    });
    $('#registro1_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#Proveedor1_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#Material1_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#TipoReg1_reg').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#OrgCompre1_reg').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#Centroeg1_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfo();
        }
    });
    $('#okregistroinfo').click(function () {
        ConsultarInfo();
    });
    $('#info_IR').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#Match_I2').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("Material");
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalMaterial");
        Drag.init(theHandle, theRoot);
    });
    $('#MaterialMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#textoMateMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#okMaterial').click(function () {
        ConsultarMaterial();
    });
    $('#Match_I3').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("proveedor");
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalProveedor");
        Drag.init(theHandle, theRoot);
    });
    $('#NombreproveedorMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarProveedor();
        }
    });
    $('#ProveedorMacth_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarProveedor();
        }
    });
    $('#okProveedor').click(function () {
        ConsultarProveedor();
    });
    $('#Match_I4').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("compras");
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalOrgCompras");
        Drag.init(theHandle, theRoot);
    });
    $('#OrgComMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarOrganizacion();
        }
    });
    $('#DenomOrgMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarOrganizacion();
        }
    });
    $('#okOrgaCom').click(function () {
        ConsultarOrganizacion();
    });
    $('#Match_I5').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("infotipo");
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalInfoTipo");
        Drag.init(theHandle, theRoot);
    });
    $('#infotipoMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfoTipo();
        }
    });
    $('#DesTipoinfoMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarInfoTipo();
        }
    });
    $('#okInfoTipo').click(function () {
        ConsultarInfoTipo();
    });
    $('#Match_I6').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal("centro");
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
    });
    $('#CentroMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarCentro();
        }
    });
    $('#NCentroMatch_reg').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarCentro();
        }
    });
    $('#okCentro').click(function () {
        ConsultarCentro();
    });
    $('#retornfiltoinfo').click(function () {
        document.getElementById("BuscarParamIR_reg").style.display = 'block';
        document.getElementById("ConsultaTabla").style.display = 'none';
    });
    $.each([$('#numAcMax'), $('#numAcMax2'), $('#numAcMax3'), $('#numAcMax4'), $('#numAcMax5'), $('#numAcMax6')], function (i, v) {
        v.keypress(function (e) {
            var te = (document).all ? e.keyCode : e.which;
            if (te === 8) {
                return false;
            }
            if (te === 13) {
                switch (i) {
                    case 0:
                        ConsultarInfo();
                        break;
                    case 1:
                        ConsultarMaterial();
                        break;
                    case 2:
                        ConsultarProveedor();
                        break;
                    case 3:
                        ConsultarOrganizacion();
                        break;
                    case 4:
                        ConsultarInfoTipo();
                        break;
                    case 5:
                        ConsultarCentro();
                        break;
                }
            }
            patron = /[0-9]/;
            t = String.fromCharCode(te);
            return patron.test(t);
        });
    });
    $('#retornmateinfo').click(function () {
        document.getElementById("BuscarParamMate_reg").style.display = 'block';
        document.getElementById("ConsultaTabla2").style.display = 'none';
    });
    $('#retornfiltprovin').click(function () {
        document.getElementById("BuscarParam_Prov").style.display = 'block';
        document.getElementById("ConsultaTabla3").style.display = 'none';
    });
    $('#retornorgcin').click(function () {
        document.getElementById("BuscarParam_OC").style.display = 'block';
        document.getElementById("ConsultaTabla4").style.display = 'none';
    });
    $('#retornarinfotipo').click(function () {
        document.getElementById("BuscarParam_InfoTipo").style.display = 'block';
        document.getElementById("ConsultaTabla5").style.display = 'none';
    });
    $('#retorncenin').click(function () {
        document.getElementById("BuscarParam_Centro").style.display = 'block';
        document.getElementById("ConsultaTabla6").style.display = 'none';
    });
});