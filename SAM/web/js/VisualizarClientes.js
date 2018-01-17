/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#Cliente_C').css("background-image", "url(images/necesario.PNG)");
    $('#Sociedad_C').css("background-image", "url(images/necesario.PNG)");
    $('#OrgVentas_C').css("background-image", "url(images/necesario.PNG)");
    $('#CanalDist_C').css("background-image", "url(images/necesario.PNG)");
    $('#Sector_C').css("background-image", "url(images/necesario.PNG)");
    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').css("display", "none");
    $('#match_C4').css("display", "none");
    $('#match_C5').css("display", "none");
    $('#Cliente_C').focus(function () {
        $('#match_C1').show();
        $('#match_C2').hide();
        $('#match_C3').css("display", "none");
        $('#match_C4').css("display", "none");
        $('#match_C5').css("display", "none");
        $('#Cliente_C').css("background-image", "none");
        if ($('#Sociedad_C').val().length < 1) {
            $('#Sociedad_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#OrgVentas_C').val().length < 1) {
            $('#OrgVentas_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#CanalDist_C').val().length < 1) {
            $('#CanalDist_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sector_C').val().length < 1) {
            $('#Sector_C').css("background-image", "url(images/necesario.PNG)");
        }

    });
    $('#Cliente_C').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });

    $('#Sociedad_C').focus(function () {
        $('#Sociedad_C').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').show();
        $('#match_C3').hide();
        $('#match_C4').hide();
        $('#match_C5').hide();
        if ($('#Cliente_C').val().length < 1) {
            $('#Cliente_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#OrgVentas_C').val().length < 1) {
            $('#OrgVentas_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#CanalDist_C').val().length < 1) {
            $('#CanalDist_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sector_C').val().length < 1) {
            $('#Sector_C').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#Sociedad_C').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $("#OrgVentas_C").focus(function () {
        $('#OrgVentas_C').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').css("display", "inline-block");
        $('#match_C4').css("display", "none");
        $('#match_C5').css("display", "none");
        if ($('#Cliente_C').val().length < 1) {
            $('#Cliente_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sociedad_C').val().length < 1) {
            $('#Sociedad_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#CanalDist_C').val().length < 1) {
            $('#CanalDist_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sector_C').val().length < 1) {
            $('#Sector_C').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $("#OrgVentas_C").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13)
        {
            validar();
        }
    });
    $('#CanalDist_C').focus(function () {
        $('#CanalDist_C').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').css("display", "none");
        $('#match_C4').css("display", "inline-block");
        $('#match_C5').css("display", "none");
        if ($('#Cliente_C').val().length < 1) {
            $('#Cliente_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sociedad_C').val().length < 1) {
            $('#Sociedad_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#OrgVentas_C').val().length < 1) {
            $('#OrgVentas_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sector_C').val().length < 1) {
            $('#Sector_C').css("background-image", "url(images/necesario.PNG)");
        }

    });
    $('#CanalDist_C').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#Sector_C').focus(function () {
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').css("display", "none");
        $('#match_C4').css("display", "none");
        $('#match_C5').css("display", "inline-block");
        $('#Sector_C').css("background-image", "none");
        if ($('#Cliente_C').val().length < 1) {
            $('#Cliente_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Sociedad_C').val().length < 1) {
            $('#Sociedad_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#OrgVentas_C').val().length < 1) {
            $('#OrgVentas_C').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#CanalDist_C').val().length < 1) {
            $('#CanalDist_C').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#Sector_C').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
/////////// Eventos de los match
////// Match de Cliente
    $('#match_C1').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('cliente');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCliente");
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
        mostrarVentanaModal('ventas');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalOrgVentas");
        Drag.init(theHandle, theRoot);
    });
    $('#match_C4').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('canal');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalCanalDist");
        Drag.init(theHandle, theRoot);
    });
    $('#match_C5').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentanaModal('sector');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSector");
        Drag.init(theHandle, theRoot);
    });
    /// Funcion match cliente
    $('#okCliente').click(function () {
        ConsultaCliente();
    });

    $('#Clien_CliBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCliente();
        }
    });

    $('#nomCl_CliBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCliente();
        }
    });

    ///// match Sociedades
    $('#Soc_CLbus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#nomSoc_CLBus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#PoblaciSoc_CLBus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#ClvMone_CLBus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaSociedad();
        }
    });
    $('#OkSociedad').click(function () {
        ConsultaSociedad();
    });

    ///// match  organizacion
    $('#OrgaVen_CL').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaOrgVentas();
        }
    });
    $('#Denom_CL').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaOrgVentas();
        }
    });
    $('#okOrga').click(function () {
        ConsultaOrgVentas();
    });

    //// funcion match Canal distribucion
    $('#CanalD_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCnalDis();
        }
    });
    $('#DenomCanal_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCnalDis();
        }
    });
    $('#okCanal').click(function () {
        ConsultaCnalDis();
    });

    //// macth para sector
    $('#Sector_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode.ENTER) {
            ConsultaSector();
        }
    });
    $('#DenomSecto_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode.ENTER) {
            ConsultaSector();
        }
    });
    $('#okSector').click(function () {
        ConsultaSector();
    });
    $('#retornfiltrocliente').click(function () {
        document.getElementById("BuscarParam_u").style.display = "block";
        document.getElementById("ConsultaTabla").style.display = "none";
    });
    $('#retornsocc').click(function () {
        document.getElementById("BuscarParamSoc_u").style.display = "block";
        document.getElementById("ConsultaTabla2").style.display = "none";
    });
    $('#retonarfiltrovent').click(function () {
        document.getElementById("BuscarParam_OV").style.display = "block";
        document.getElementById("ConsultaTabla3").style.display = "none"
    });
    $('#retornarcanalin').click(function () {
        document.getElementById("BuscarParam_Can").style.display = "block";
        document.getElementById("ConsultaTabla4").style.display = "none";
    });
    $('#retornarfiltrosec').click(function () {
        document.getElementById("BuscarParam_Sec").style.display = "block";
        document.getElementById("ConsultaTabla5").style.display = "none";
    });
    $.each([$('#numAcMax'), $('#numAcMax2'), $('#numAcMax3'), $('#numAcMax4'), $('#numAcMax5')], function (i, v) {
        v.keypress(function (e) {
            var tec = (document).all ? e.keyCode : e.which;
            if (tec === 8) {
                return false;
            }
            if (tec == 13) {
                switch (i) {
                    case 0:
                        ConsultaCliente();
                        break;
                    case 1:
                        ConsultaSociedad();
                        break;
                    case 2:
                        ConsultaOrgVentas();
                        break;
                    case 3:
                        ConsultaCnalDis();
                        break;
                    case 4:
                        ConsultaSector();
                        break;
                }
            }
            patron = /[0-9]/;
            te = String.fromCharCode(tec);
            return patron.test(te);
        });
    });
});

