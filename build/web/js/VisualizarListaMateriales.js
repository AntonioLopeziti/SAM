/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#equipo').css("background-image", "url(images/necesario.PNG)");
    $('#centro').css("background-image", "url(images/necesario.PNG)");
    $('#utilizacion').css("background-image", "url(images/necesario.PNG)");
    $('#btnmat1').hide();
    $('#btnmat2').hide();
    $('#btnmat3').hide();
    $('#btnmat4').hide();
    $('#equipo').focus(function () {
        $('#equipo').css("background-image", "none");
        $('#btnmat1').show();
        $('#btnmat2').hide();
        $('#btnmat3').hide();
        $('#btnmat3').hide();
    });
    $('#equipo').blur(function () {
        if ($('#equipo').val().length > 0) {
            $('#equipo').css("background-image", "none");
        } else {
            $('#equipo').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#centro').focus(function () {
        $('#centro').css("background-image", "none");
        $('#btnmat1').hide();
        $('#btnmat2').show();
        $('#btnmat3').hide();
        $('#btnmat4').hide();
    });
    $('#centro').blur(function () {
        if ($('#centro').val().length > 0) {
            $('#centro').css("background-image", "none");
        } else {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#utilizacion').focus(function () {
        $('#utilizacion').css("background-image", "none");
        $('#btnmat1').hide();
        $('#btnmat2').hide();
        $('#btnmat3').show();
        $('#btnmat4').hide();
    });
    $('#utilizacion').blur(function () {
        if ($('#utilizacion').val().length > 0) {
            $('#utilizacion').css("background-image", "none");
        } else {
            $('#utilizacion').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#btnmat1').click(function () {
        mostrarVentanaModal('Equipo');
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalEquipo");
        Drag.init(theHandle, theRoot);
    });
    $('#okEquipo').click(function () {
        ConsultarEquipos();
    });
    $('#EquipoBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarEquipos();
        }
    });
    $('#DenEquipoBus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultarEquipos();
        }
    });
     $('#btnmat2').click(function () {
        mostrarVentanaModal('Centro');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
    });
    $('#okCentro').click(function(){
        ConsultarCentros();
    });
    $('#CentroBus').keypress(function(e){
        if(e.which == 13 || e.keyCode == 13){
          ConsultarCentros();
        }
    });
    $('#NCentroBus').keypress(function(e){
        if(e.which == 13 || e.keyCode == 13){
            ConsultarCentros();
        }
    });

});