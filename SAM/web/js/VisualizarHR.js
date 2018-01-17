/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('#matchAlt').hide();
    $('#matchEqui').hide();
    $('#boxEqui').css('background-image', 'url(images/necesario.PNG)');
    $('#boxEqui').focus(function () {
        $('#boxEqui').css('background-image', 'none');
        $('#matchEqui').show();
        $('#matchCen').hide();

    });
    $('#boxEqui').blur(function () {
        if ($('#boxEqui').val().length < 1) {
            $('#boxEqui').css('background-image', 'url(images/necesario.PNG)');
        }
    });

    $('#matchCen').hide();
    $('#boxCen').css('background-image', 'url(images/necesario.PNG)');
    $('#boxCen').focus(function () {
        $('#boxCen').css('background-image', 'none');
        $('#matchCen').show();
        $('#matchEqui').hide();

    });
    $('#boxCen').blur(function () {
        if ($('#boxCen').val().length < 1) {
            $('#boxCen').css('background-image', 'url(images/necesario.PNG)');
            $('#matchCen').show();

        }

    });



});