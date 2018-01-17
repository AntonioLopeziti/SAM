
$(document).ready(function () {
    $('#Match_O1').hide();
    $('#ord').css("background-image", "url(images/necesario.PNG)");

    ////// Cabecera
    $('#aceptar').click(function () {
        validar();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#cancelar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#ord').focus(function () {
        $('#ord').css("background-image", "none");
        $('#Match_O1').show();
    });
    $('#ord').blur(function () {
        if ($('#ord').val().length < 1) {
            $('#ord').css("background-image", "url(images/necesario.PNG)");
        } else {
            $('#ord').css("background-image", "none");
        }
    });
    $('#ord').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#Match_O1').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal();
    });
    $('#okorden').click(function () {
        ConsultaOrden();
    });
    $('#NumOrden_Bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#TextoOrden_Bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaOrden();
        }
    });
    $('#numAcMax').keypress(function (e) {
        tecl = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        if (tecl == 13) {
            ConsultaOrden();
        }
        if (tecl == 8) {
            return false;
        }
        tecFinal = String.fromCharCode(tecl);
        return patron.test(tecFinal);
    });

});

function back() {
    window.location.href = "Bienvenido.jsp";
}
function inval() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    var funinva = $('#mjfuncInv').val();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(funinva);
}

function mostrarVentanaModal() {
    ///abrir ventanas
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();

    var ventana = $('#VentanaModal');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css("left", x);
    ventana.css("top", y);
    $('#VentanaModal').css('display', 'block');
    $('#TextoOrden_Bus').val("");
    $('#numAcMax').val('500');
    $('#NumOrden_Bus').focus();
    $('#NumOrden_Bus').val("");
}
function ocultarVentana()
{
    var ventana = $('#VentanaModal');
    ventana.hide();
    $('#BuscarParam_OR').show();
    $('#ConsultaTabla').hide();
    $('#NumOrden_Bus').val("");
    $('#TextoOrden_Bus').val("");
    $('#overlay').remove();
}
function ConsultaOrden() {
    var acc = "ConsultarOrdenes";
    var orden = $('#NumOrden_Bus').val();
    var texto = $('#TextoOrden_Bus').val();
    var ctd = $('#numAcMax').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrdenes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&ord=" + orden + "&texto=" + texto + "&ctd=" + ctd,
        success: function (rs) {
            if (rs == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                var okcon = $('#mjMenValores').val();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(okcon);
            } else {
                $('#BuscarParam_OR').hide();
                $('#ConsultaTabla').show();
                $('#cargarDatos').html(rs);
                fnc();
            }
        }
    });


}

function fnc() {
    $('#table-scroll').scroll(function () {
        $('#fixedY').css({top: $('#table-scroll').scrollTop()});
    });
}
function seleccionar(orden, foliosam) {
    var nuo = $('#NumOrden_Bus').val("");
    var txtb = $('#TextoOrden_Bus').val("");
    var or = $('#ord');
    if (orden.length > 0) {
        or.val(orden);
        or.focus();
        nuo;
        txtb;
        ocultarVentana();
    } else {
        or.val(foliosam);
        or.focus();
        nuo;
        txtb;
        ocultarVentana();
    }
}
function validar() {
    var ord = $('#ord');
    if (ord.val() == "" || ord.val() == 0) {
        //error
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        var mensj = $('#mjMens').val();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(mensj);
    } else
    {
        enviarDatos(ord.val());
    }
}
function enviarDatos(ord) {
    Acc = "ValidarOrden";
    petVis = "peticionVisualizarOrdenes";
    petCre = "peticionVisualizarCreaOrdenes";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizaOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + Acc + "&ord=" + ord,
        success: function (rs) {
            if (rs == 1) {
                window.location.href = "VisualizarOrdenes2PP.jsp?ord=" + ord + "&peticion=" + petVis + "&tipo=" + rs;
            } else if (rs == 2) {
                window.location.href = "VisualizarOrdenes2PP.jsp?ord=" + ord + "&peticion=" + petCre + "&tipo=" + rs;
            } else {
                //error
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                var msj = $('#mjNoExis').val();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(msj + " " + ord);
            }
        }
    });
}
function regresafilOrd() {
    $('#BuscarParam_OR').show();
    $('#ConsultaTabla').hide();
}


