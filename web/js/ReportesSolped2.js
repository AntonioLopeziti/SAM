
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var centro = $('#centro');
    var sam1 = $('#sami');
    var sam2 = $('#samf');
    var sap1 = $('#sapi');
    var sap2 = $('#sapf');
    var ord1 = $('#ord');
    var ord2 = $('#ord2');
    var ope1 = $('#ope');
    var ope2 = $('#ope2');
    $('#centro');
    $('#sami');
    $('#samf');
    $('#sapi');
    $('#sapf');
    $('#ord');
    $('#ord2');
    $('#ope');
    $('#ope2');
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').hide();
    $('#match_A4').hide();
    $('#match_A5').hide();
    $('#match_A6').hide();
    $('#match_A7').hide();
    $('#match_A8').hide();
    $('#match_A9').hide();
    $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    /*Function mostrar ventana modal SAP*/
    $('#centro').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#centro').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    /*Function mostrar ventana modal SAM*/
    $('#sami').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#sami').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
       /*Function mostrar ventana modal SAM*/
    $('#samf').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#samf').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal SAP*/
    $('#sapi').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#sapi').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
        /*Function mostrar ventana modal SAP*/
    $('#sapf').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').show();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#sapf').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal Numero de Orden*/
    $('#ord').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').show();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#ord').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal Numero de Operacion*/
    $('#ope').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').show();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#ope').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
        /*Function mostrar ventana modal Numero de Orden*/
    $('#ord2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').show();
        $('#match_A9').hide();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#ord2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
  /*Function mostrar ventana modal Numero de Operacion*/
    $('#ope2').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').show();
        $('#match_A10').hide();
        $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#ope2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
 ////MATCH FILTROS
  $('#solicitante').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').show();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    
     $('#almacen').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').show();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });

 $('#material').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').show();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#posicion').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').show();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    
       $('#imputacion').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').show();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });

  $('#coste').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').show();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    
     $('#orden').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').show();
    $('#match_AA13').hide();
    });

$('#servicio').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
        $('#match_A6').hide();
        $('#match_A7').hide();
        $('#match_A8').hide();
        $('#match_A9').hide();
        $('#match_A10').hide();
    $('#match_AA6').hide();
    $('#match_AA7').hide();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').show();
    });

    
    
    
    
/////////// Eventos de los match
////// Match de Centro
    $('#match_A1').click(function () {
        mostrarVentanaModal('centro');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A2').click(function () {
        mostrarVentanaModal('sam1');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalSAM1");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A3').click(function () {
        mostrarVentanaModal('sap1');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalSAP1");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A4').click(function () {
        mostrarVentanaModal('sam2');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalSAM2");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A5').click(function () {
        mostrarVentanaModal('sap2');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAP2");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A6').click(function () {
        mostrarVentanaModal('ord1');
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalORD1");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A8').click(function () {
        mostrarVentanaModal('ord2');
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalORD2");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
     $('#match_A7').click(function () {
        mostrarVentanaModal('ope1');
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalOPE1");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
     $('#match_A9').click(function () {
        mostrarVentanaModal('ope2');
        var theHandle = document.getElementById("handle9");
        var theRoot = document.getElementById("VentanaModalOPE2");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#matchFolioSAM_SP').click(function () {
        mostrarVentanaModal('sam');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalSAM");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_AA6').click(function () {
        mostrarVentanaModal('solicitante');
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalSolicitante");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
$('#match_AA7').click(function () {
        mostrarVentanaModal('almacen');
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalMaterial");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
$('#match_AA8').click(function () {
        mostrarVentanaModal('material');
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalMaterial");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 

$('#match_AA9').click(function () {
        mostrarVentanaModal('posicion');
        var theHandle = document.getElementById("handle9");
        var theRoot = document.getElementById("VentanaModalPosicion");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
 $('#match_AA10').click(function () {
        mostrarVentanaModal('imputacion');
        var theHandle = document.getElementById("handle10");
        var theRoot = document.getElementById("VentanaModalImputacion");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });     
$('#match_AA11').click(function () {
        mostrarVentanaModal('coste');
        var theHandle = document.getElementById("handle11");
        var theRoot = document.getElementById("VentanaModalCoste");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
}); 
$('#match_AA12').click(function () {
        mostrarVentanaModal('orden');
        var theHandle = document.getElementById("handle12");
        var theRoot = document.getElementById("VentanaModalOrden");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
$('#match_AA13').click(function () {
        mostrarVentanaModal('servicio');
        var theHandle = document.getElementById("handle13");
        var theRoot = document.getElementById("VentanaModalServicio");
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
    
    //////VALIDAR CAMPOS
    centro.blur(function () {
        validarCentro();
    });
    centro.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarCentro();
        }
    });
    sam1.blur(function () {
        validarsam();
    });
    sam1.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarsam();
        }
    });
    sam2.blur(function () {
        validarsam2();
    });
    sam2.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarsam2();
        }
    });
    sap1.blur(function () {
        validarsap();
    });
    sap1.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarsap();
        }
    });
    sap2.blur(function () {
        validarsap2();
    });
    sap2.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarsap2();
        }
    });
    ord1.blur(function () {
        validarorden();
    });
    ord1.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarorden();
        }
    });
    ord2.blur(function () {
        validarorden2();
    });
    ord2.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarorden2();
        }
    });
    ope1.blur(function () {
        validaroperacion();
    });
    ope1.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validaroperacion();
        }
    });
    ope2.blur(function () {
        validaroperacion2();
    });
    ope2.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validaroperacion2();
        }
    });
});