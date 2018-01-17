
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#folioSAP_SP').css("background-image", "url(images/necesario.PNG)");
    $('#folioSAM_SP').css("background-image", "url(images/necesario.PNG)");
    $('#matchFolioSAP_SP').hide();
    $('#matchFolioSAM_SP').hide();
    /*Function mostrar ventana modal SAP*/
    $('#folioSAP_SP').focus(function () {
        $('#matchFolioSAP_SP').show();
        $('#matchFolioSAM_SP').hide();
        $('#folioSAP_SP').css("background-image", "none");
        if ($('#folioSAM_SP').val().length < 1) {
            $('#folioSAM_SP').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#folioSAP_SP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    /*Function mostrar ventana modal SAM*/
    $('#folioSAM_SP').focus(function () {
        $('#folioSAM_SP').css("background-image", "none");
        $('#matchFolioSAP_SP').hide();
        $('#matchFolioSAM_SP').show();
        if ($('#folioSAP_SP').val().length < 1) {
            $('#folioSAP_SP').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#folioSAM_SP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    
/////////// Eventos de los match
////// Match de Centro
    $('#matchFolioSAP_SP').click(function () {
        mostrarVentanaModal('sap');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalSAP");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    /*Match folio SAM*/
    $('#matchFolioSAM_SP').click(function () {
        mostrarVentanaModal('sam');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSAM");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });

    /// Funcion match Folio sap
    $('#BuscarfoliosapSP').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaFolioSAP();
        }
    });
     $('#okSAP').click(function () {
        ConsultaFolioSAP();
    });

    /// Funcion match Folio sam
    $('#BuscarFoliosam').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#okSAM').click(function () {
            ConsultaFolioSAM();
    });
});