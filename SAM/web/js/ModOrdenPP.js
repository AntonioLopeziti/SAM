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
});
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