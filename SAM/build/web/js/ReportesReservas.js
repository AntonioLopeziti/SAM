
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
    /*Function mostrar ventana modal Centro*/
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
    /*Function mostrar ventana modal Reserva Izq*/
    $('#reserva').focus(function () {
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
    $('#reserva').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
       /*Function mostrar ventana modal Resera Der */
    $('#reserva2').focus(function () {
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
    $('#reserva2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal Posicion Izq*/
    $('#posicion').focus(function () {
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
    $('#posicion').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
        /*Function mostrar ventana modal Posiocion Der*/
    $('#posicion2').focus(function () {
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
    $('#posicion2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal Clase*/
    $('#clase').focus(function () {
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
    $('#clase').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
    /*Function mostrar ventana modal Numero de material*/
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
    $('#match_AA7').show();
    $('#match_AA8').hide();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#material').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
        /*Function mostrar ventana modal Numero de Almacen*/
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
    $('#match_AA7').hide();
    $('#match_AA8').show();
    $('#match_AA9').hide();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    $('#almacen').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
  /*Function mostrar ventana modal Numero de Operacion*/
    $('#usuario').focus(function () {
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
    });
    $('#usuario').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            val();
        }
    });
 //matcha numero de orden
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
    $('#match_AA9').show();
    $('#match_AA10').hide();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
    });
    //match centro coste
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
    $('#match_AA10').show();
    $('#match_AA11').hide();
    $('#match_AA12').hide();
    $('#match_AA13').hide();
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
        mostrarVentanaModal('reserva');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalReserva");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A3').click(function () {
        mostrarVentanaModal('posicion');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalPosicion");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A4').click(function () {
        mostrarVentanaModal('reserva2');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalReserva ");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_A5').click(function () {
        mostrarVentanaModal('posicion2');
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalPosicion2");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    });
    $('#match_AA6').click(function () {
        mostrarVentanaModal('clase');
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalClase");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
$('#match_AA7').click(function () {
        mostrarVentanaModal('material');
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalMaterial");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
$('#match_AA8').click(function () {
        mostrarVentanaModal('almacen');
        var theHandle = document.getElementById("handle8");
        var theRoot = document.getElementById("VentanaModalAlmacen");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 

$('#match_AA9').click(function () {
        mostrarVentanaModal('orden');
        var theHandle = document.getElementById("handle9");
        var theRoot = document.getElementById("VentanaModalOrden");
        Drag.init(theHandle, theRoot);
        $("BODY").append('<div id="overlay"></div>');
    }); 
 $('#match_AA10').click(function () {
        mostrarVentanaModal('coste');
        var theHandle = document.getElementById("handle10");
        var theRoot = document.getElementById("VentanaModalCoste");
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
  
});