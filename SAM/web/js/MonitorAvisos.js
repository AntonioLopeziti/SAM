/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {
    $('#btnubte').hide();
    $('#btnubte2').hide();
    $('#btnmoneq').hide();
    $('#btnmoneq2').hide();
    $('#btnmate').hide();
    $('#btnmate2').hide();
    $('#btnmonor').hide();
    $('#btnmonor2').hide();
    $('#btnmonor').hide();
    $('#btnmonor2').hide();
    $('#btnnotcrepo').hide();
    $('#btnnotcrepo2').hide();



    $('#ubite').css('background-image', 'url(images/necesario.PNG)');
    $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
    $('#moneq').css('background-image', 'url(images/necesario.PNG)');
    $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
    $('#mate').css('background-image', 'url(images/necesario.PNG)');
    $('#mate2').css('background-image', 'url(images/necesario.PNG)');
    $('#monor').css('background-image', 'url(images/necesario.PNG)');
    $('#monor2').css('background-image', 'url(images/necesario.PNG)');
    $('#notcrepo').css('background-image', 'none');
    $('#notcrepo2').css('background-image', 'none');


    $('#ubite').click(function () {
        $('#btnubte').show();
        $('#btnubte2').hide();
        $('#btnmoneq').hide();
        $('#btnmoneq2').hide();
        $('#btnmate').hide();
        $('#btnmate2').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();

        $('#ubite').css('background-image', 'none');

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#ubite2').click(function () {
        $('#btnubte2').show();
        $('#btnubte').hide();
        $('#btnmoneq').hide();
        $('#btnmoneq2').hide();
        $('#btnmate').hide();
        $('#btnmate2').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();

        $('#ubite2').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#moneq').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq').show();
        $('#btnmoneq2').hide();
        $('#btnmate').hide();
        $('#btnmate2').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();


        $('#moneq').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#moneq2').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').show();
        $('#btnmoneq').hide();
        $('#btnmate').hide();
        $('#btnmate2').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();

        $('#moneq2').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });


    $('#mate').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate').show();
        $('#btnmate2').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();


        $('#mate').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#mate2').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate2').show();
        $('#btnmate').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();

        $('#mate2').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#monor').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate2').hide();
        $('#btnmate').hide();
        $('#btnmonor').show();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();


        $('#monor').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });

    $('#monor2').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate2').hide();
        $('#btnmate').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').show();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();


        $('#monor2').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }

    });


    $('#notcrepo').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate2').hide();
        $('#btnmate').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo').hide();
        $('#btnnotcrepo2').hide();


        $('#notcrepo').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });


    $('#notcrepo2').click(function () {
        $('#btnubte2').hide();
        $('#btnubte').hide();
        $('#btnmoneq2').hide();
        $('#btnmoneq').hide();
        $('#btnmate2').hide();
        $('#btnmate').hide();
        $('#btnmonor').hide();
        $('#btnmonor2').hide();
        $('#btnnotcrepo2').hide();
        $('#btnnotcrepo').hide();


        $('#notcrepo2').css('background-image', 'none');

        if ($('#ubite').val().length < 1) {
            $('#ubite').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#ubite2').val().length < 1) {
            $('#ubite2').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq').val().length < 1) {
            $('#moneq').css('background-image', 'url(images/necesario.PNG)');
        }

        if ($('#moneq2').val().length < 1) {
            $('#moneq2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate').val().length < 1) {
            $('#mate').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#mate2').val().length < 1) {
            $('#mate2').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor').val().length < 1) {
            $('#monor').css('background-image', 'url(images/necesario.PNG)');
        }
        if ($('#monor2').val().length < 1) {
            $('#monor2').css('background-image', 'url(images/necesario.PNG)');
        }

    });
















    $('#ejecutar').click(function () {
        var eq1 = $('#moneq').val();
        var eq2 = $('#moneq2').val();
        var ub2 = $('#ubite2').val();
        var ub1 = $('#ubite').val();
        var ma2 = $('#mate2').val();
        var ma1 = $('#mate').val();
        var or1 = $('#monor').val();
        var or2 = $('#monor2').val();
        var fec1 = $('#fec1').val();
        var fec2 = $('#fec2').val();

        var t1 = fec1,
                patron = /-/g,
                nuevoValor = "",
                nuevaCadena1 = t1.replace(patron, nuevoValor);
        var t2 = fec2,
                patron = /-/g,
                nuevoValor = "",
                nuevaCadena2 = t2.replace(patron, nuevoValor);


        if ((nuevaCadena1 <= nuevaCadena2) || (nuevaCadena1 != "" && nuevaCadena2 == "")) {
            if (((eq1.length <= eq2.length) || (eq1 != "" && eq2 == "")) && ((ub1.length <= ub2.length) || (ub1 != "" && ub2 == "")) && ((or1 <= or2) || (or1 != "" && or2 == "")) && ((ma1 <= ma2) || (ma1 != "" && ma2 == ""))) {
                window.location.href = "listasdeavisos.jsp?equ1=" + eq1 + "&equ2=" + eq2 + "&ub2=" + ub2 + "&ub1=" + ub1 + "&ma1=" + ma1 + "&ma2=" + ma2 + "&or1=" + or1 + "&or2=" + or2 + "&fec1=" + fec1 + "&fec2=" + fec2;
            } else {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "Límite inferior mayor al límite superior";
                setTimeout(function () {
                    men.innerHTML = "";
                    iconm.style.visibility = "hidden";
                }, 8000);
            }
        } else {
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = "Evento de inicio " + t1 + " no puede ser posterior al evento final " + t2;
            setTimeout(function () {
                men.innerHTML = "";
                iconm.style.visibility = "hidden";
            }, 8000);
        }

    });

    ///////////

    $('#btnubte').click(function () {
        mostrarVentana('Ubicacion');
        var theHandle = document.getElementById('handle');
        var theRoot = document.getElementById('Ventanaubtec');
        Drag.init(theHandle, theRoot);
    });
    $('#okUbi').click(function () {
        ConsultaUbicacion();
    });
    $('#MAUbic').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    $('#MAUtxtbrv').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    $('#MAUCenpla').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion();
        }
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUbicacion();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });

    $('#btnubte2').click(function () {
        mostrarVentana('Ubicacion2');
        var theHandle = document.getElementById('handle2');
        var theRoot = document.getElementById('Ventanaubtec2');
        Drag.init(theHandle, theRoot);
    });
    $('#okUbi2').click(function () {
        ConsultaUbicacion2();
    });
    $('#MAUbic2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion2();
        }
    });
    $('#MAUtxtbrv2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion2();
        }
    });
    $('#MAUCenpla2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaUbicacion2();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaUbicacion2();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
   
    $('#btnmoneq').click(function () {
        mostrarVentana("Equipo");
        var theHandle = document.getElementById('handle3');
        var theRoot = document.getElementById('Ventanaequip');
        Drag.init(theHandle, theRoot);
    });
    $('#okEquipo').click(function () {
        ConsultaEquipo();
    });
    $('#meequ').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo();
        }
    });
    $('#metxtbrvm').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo();
        }
    });
    $('#meubte').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo();
        }
    });
     $('#numAcMax3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipo();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#btnmoneq2').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        mostrarVentana("Equipo2");
        var theHandle = document.getElementById('handle4');
        var theRoot = document.getElementById('Ventanaequip2');
        Drag.init(theHandle, theRoot);
    });
    $('#okEquipo2').click(function () {
        ConsultaEquipo2();
    });
    $('#meequ2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo2();
        }
    });
    $('#metxtbrvm2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo2();
        }
    });
    $('#meubte2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaEquipo2();
        }
    });
     $('#numAcMax4').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipo2();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#btnmate').click(function () {
        mostrarVentana("Material");
        var theHandle = document.getElementById('handle5');
        var theRoot = document.getElementById('VentanaMat');
        Drag.init(theHandle, theRoot);
    });
    $('#okMaterial').click(function () {
        ConsultaMaterial();
    });
    $('#MAMat').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#MAMtxtbrv').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#MAMCen').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial();
        }
    });
    $('#numAcMax5').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
   
    $('#btnmate2').click(function () {
        mostrarVentana("Material2");
        var theHandle = document.getElementById('handle6');
        var theRoot = document.getElementById('VentanaMat2');
        Drag.init(theHandle, theRoot);

    });
    $('#okMaterial2').click(function () {
        ConsultaMaterial2();
    });
    $('#MAMat2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial2();
        }
    });
    $('#MAMtxtbrv2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial2();
        }
    });
    $('#MAMCen2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaMaterial2();
        }
    });
     $('#numAcMax6').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMaterial2();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#btnmonor').click(function () {
        mostrarVentana("Orden");
        var theHandle = document.getElementById('handle7');
        var theRoot = document.getElementById('Ventanaorden');
        Drag.init(theHandle, theRoot);

    });
    $('#okOrden').click(function () {
        ConsultaOrden();
    });
    $('#MAOrd').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#MAOtxtbrv').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
     $('#numAcMax7').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });

    $('#btnmonor2').click(function () {
        mostrarVentana("Orden2");
        var theHandle = document.getElementById('handle8');
        var theRoot = document.getElementById('VentanaOrden2');
        Drag.init(theHandle, theRoot);

    });
    $('#okOrden2').click(function () {
        ConsultaOrden2();
    });
    $('#MAOrd2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden2();
        }
    });
    $('#MAOtxtbrv2').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden2();
        }
    });
    $('#numAcMax8').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaOrden2();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });

});