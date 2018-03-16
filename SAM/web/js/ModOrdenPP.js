$(document).ready(function () {
    $('#matchOrden').hide();
    $('#ord').focus(function () {
        $('#ord').css('background-image', 'none');
        $('#ord').css("background-color", "#ffffff");
        $('#matchOrden').show();
    });
    $('#matchOrden').click(function () {
        $("BODY").append('<div id="overlay"></div>');
        var theHandle = document.getElementById("handle1");
        var theRoot = document.getElementById("VentanaModalOrden");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('Orden');
    });
    $("#okOrden").click(function () {
        consultaOrden();
    });
    $("#aceptar").click(function () {
        validarOrden();
    });
});
function back() {
    window.location.href = "Bienvenido.jsp";
}
function validarOrden() {
    var ord = $('#ord').val();
    if (ord.length < 1) {
        var msj = "Introduce una orden";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
    } else {
        borrarmsg();
        validarDBOrd();
    }
}
function validarDBOrd() {
    acc = "validarOrdenPP";
    var ord = $('#ord').val();
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloModificarOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&ordVal=" + ord,
        success: function (rs) {
            if (rs == 0) {
                var msj = "No se encuentran entradas para " + ord;
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(msj);
            } else {
                checkStatus();
            }
        }
    });
}
function checkStatus() {
    acc = "cargarKeysPP";
    var ord = $('#ord').val();
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloModificarOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&orden=" + ord,
        success: function (rs) {
            statusFinal(rs);
        }
    });
}
function statusFinal(type) {
    var ord = document.getElementById("ord").value;
    if (type.substr(0, 1).toString() == 1 & type.substr(1, 1).toString() == 0 & type.substr(2, 1).toString() == 0 & type.substr(3, 1).toString() == 0) {
        var msj = "Orden Recibida No Modificable";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
    } else if (type.substr(0, 1).toString() == 0 & type.substr(1, 1).toString() == 0 & type.substr(2, 1).toString() == 0 & type.substr(3, 1).toString() == 1) {
        var msj = "Orden Modificada ";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
    } else if (type.substr(0, 1).toString() == 1 & type.substr(2, 1).toString() == 1) {
        var msj = "Recibido con Error ";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        $('#msg').html(msj);
        window.location.href = "ModificarOrden2PP.jsp?orden=" + ord + "&error=true";
    } else if (type.substr(0, 1).toString() == 0 & type.substr(1, 1).toString() == 0 & type.substr(2, 1).toString() == 0 & type.substr(3, 1).toString() == 0) {
        var msj = "Modificar Orden";
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/aceptar.PNG');
        $('#msg').html(msj);
        window.location.href = "ModificarOrden2PP.jsp?orden=" + ord + "&error=false";
    }
}
function consultaOrden() {
    acc = "ConsultaModOrdenPP";
    var plM = $('#txtPlPr').val();
    var ord = $('#txtOrd').val();
    var txt = $('#txtBrev').val();
    var nAc = $('#numAcMaxOrd').val();
    var dataSend = "&modPlm=" + plM +
            "&modOrd=" + ord +
            "&modTxtB=" + txt +
            "&modAcO=" + nAc;
    $.ajax({
        async: true,
        type: 'GET',
        url: 'PeticionModuloModificarOrdenesPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (rs) {
            
            if (rs == 0) {
                datosincorrectos();
            } else {
                $('#BuscarParamOrden').hide();
                $('#ConsultaTablaOrden').show();
                $('#cargarDatosOrden').html(rs);
                fncOrden();
                borrarmsg();
            }
        }
    });
}
function fncOrden() {
    $('#table-scrollOrden').scroll(function () {
        $('#fixedYOrden').css({top: $('table-scrollOrden').scrollTop()});
    });
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function mostrarVentanaModal(tipo) {
    switch (tipo) {
        case "Orden":
            blockPropiety('handle1', 'VentanaModalOrden');
            $('#txtPlPr').focus();
            break;
    }
}
function select(type, data) {
    switch (type) {
        case 'Orden':
            ocultarVentana("Orden");
            $('#ord').val(data);
            $('#ord').focus();
            break;
    }
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function abrirVentana(ventana) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ocultarVentana(tipo) {
    switch (tipo) {
        case "Orden":
            $('#VentanaModalOrden').hide();
            $('#BuscarParamOrden').show();
            $('#ConsultaTablaOrden').hide();
            $('#ord').focus();
            $('#overlay').remove();
            break;
    }
}