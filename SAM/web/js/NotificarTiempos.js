/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    $('#NoPers').css('background-image', 'url(images/necesario.PNG)');
    $('#OrdFab').css('background-image', 'url(images/necesario.PNG)');
    $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
    $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
    $('#aceptar').prop('disabled', true);
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#btnFin').prop('disabled', true);
    $('#iconmsg').hide();
    $('#btnmatchOrdLib').hide();
    $('#btnmatchUsuarios').hide();
    $('#sectionMuestraExc').hide();
    $('#NoPers').click(function () {
        $('#NoPers').css('background-image', 'none');
    });
    $('#OrdFab').click(function () {
        $('#OrdFab').css('background-image', 'none');
    });
    $('#OrdFab').click(function () {
        $('#OrdFab').css('background-image', 'none');
    });
    $('#cntBuena').click(function () {
        $('#cntBuena').css('background-image', 'none');
    });
    $('#cntMala').click(function () {
        $('#cntMala').css('background-image', 'none');
    });
    $('#NoPers').blur(function () {
        if ($('#NoPers').val().length > 0) {
            $('#NoPers').css('background-image', 'none');
            validarUsuario();
        } else {
            $('#NoPers').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#txtOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarContenidoOrdFab();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#txtBrev').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarContenidoOrdFab();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMaxOrd').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            CargarContenidoOrdFab();
        }
        if (tecla == 32) {
            return false;
        }
    });
    $('#cntBuena').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#cntMala').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#NoPers').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarUsuario();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#OrdFab').blur(function () {
        if ($('#OrdFab').val().length > 0) {
            $('#OrdFab').css('background-image', 'none');
            $('#msg').html("Complete los campos obligatorios");
            validarStatusOrden();
        } else {
            $('#OrdFab').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#cntBuena').blur(function () {
        if ($('#cntBuena').val().length > 0) {
            $('#cntBuena').css('background-image', 'none');
        } else {
            $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#cntMala').blur(function () {
        if ($('#cntMala').val().length > 0) {
            $('#cntMala').css('background-image', 'none');
        } else {
            $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#OrdFab').focus(function () {
        $('#btnmatchOrdLib').show();
    });
    $('#OrdFab').click(function () {
        $('#btnmatchUsuarios').hide();
    });
    $('#NoPers').focus(function () {
        $('#btnmatchUsuarios').show();
    });
    $('#NoPers').click(function () {
        $('#btnmatchOrdLib').hide();
    });
    $('#btnmatchOrdLib').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalOrdenFab");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('VentanaModalOrdenFab', 'handle', 'txtOrd', '');
    });
    $('#btnmatchUsuarios').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalUsuarios");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('VentanaModalUsuarios', 'handle2', '', '');
        CargarContenido();
    });
    $('#LimPantalla').click(function () {
        limpiarCampos();
        desbloquearCampos();
        borrarmsg();
    });
    $("#okOrden").click(function () {
        CargarContenidoOrdFab();
    });
//    $('#btnInicio').click(function(){
//       
//    });
});
//Validar Cantidades
function validarCantidades() {
    var us = $('#NoPers').val();
    var ord = $('#OrdFab').val();
    var buena = $('#cntBuena').val();
    var mala = $('#cntMala').val();
    var orden = $('#OrdFab').val();
    if (us == "" || ord == "" || buena == "" || mala == "") {
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    } else {
        if ($('#checkCntExceso').prop('checked')) {
            validarDatos();
        } else {
            var acc = "validarCant";
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionNotificarTiemposPP',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + "&buena=" + buena + "&mala=" + mala + "&orden=" + orden,
                success: function (data) {
                    if (data == 0) {
                        $('#msg').html("Las cantidades sobrepasan la cantidad total de la orden");
                        var icon = $('#iconmsg');
                        icon.show();
                        icon.attr('src', 'images/advertencia.PNG');
                        var BE = document.createElement('audio');
                        BE.src = 'audio/saperror.wav';
                        BE.play();
                    } else {
                        validarDatos();
                    }
                }
            });
        }
    }
}
//Insertar datos a tabla interna
function validarDatos() {
    var acc = "insertarDatos";
    var pers = $('#NoPers').val();
    var orden = $('#OrdFab').val();
    var op = $('#selNoOp').val();
    var par = $('#NotParcial');
    var fin = $('#NotFinal');
    var aut = $('#NotFinalAu');
    var res = $('#CompRes');
    var pa = "";
    var fi = "";
    var au = "";
    var re = "";
    var cntBuena = $('#cntBuena').val();
    var cntMala = $('#cntMala').val();
    if (par.prop('checked')) {
        pa = par.val();
    }
    if (fin.prop('checked')) {
        fi = fin.val();
    }
    if (aut.prop('checked')) {
        au = aut.val();
    }
    if (res.prop('checked')) {
        re = res.val();
    }
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + pers.toUpperCase() + "&orden=" + orden + "&oper=" + op + "&buena=" + cntBuena + "&mala=" + cntMala + "&parcial=" + pa + "&final=" + fi + "&autom=" + au + "&reserv=" + re,
        success: function (data) {
            if (data == 0) {
                $('#msg').html("El registro no se agregó");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                var BE = document.createElement('audio');
                BE.src = 'audio/saperror.wav';
                BE.play();
            } else {
                $('#msg').html("Registro agregado correctamente");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/aceptar.png');
                var BE = document.createElement('audio');
                BE.src = 'audio/sapmsg.wav';
                BE.play();
                limpiarCampos();
            }
        }
    });
}
function validarLlenado() {    
    var acc = "LlenarTablas";
    var us = $('#NoPers').val();
    var ord = $('#OrdFab').val();
    var buena = $('#cntBuena').val();
    var mala = $('#cntMala').val();
    var orden = $('#OrdFab').val();
    if (us == "" || ord == "" || buena == "" || mala == "") {
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    } else {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionNotificarTiemposPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + acc + "&usuario=" + us + "&orden=" + ord,
            success: function (data) {
                if (data == 1) {
                    $('#msg').html("La orden se notificó con éxito");
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/aceptar.png');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/sapmsg.wav';
                    BE.play();
                    limpiarCampos();
                    desbloquearCampos();
                    borrarDatoControl(us);
                    $('#btnInicio').prop('disabled', false);
                    $('#btnFin').prop('disabled', true);
                } else {
                    $('#msg').html("Error al notificar la orden");
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/advertencia.PNG');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/saperror.wav';
                    BE.play();
                }
            }
        });
    }
}
//funcion para borrar el registro del usuario una vez que se inserto en cabecera y posicion
function borrarDatoControl(usuario) {
    var acc = "borrarRegControl";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + usuario.toUpperCase(),
        success: function (data) {
            if (data == 0) {
                $('#msg').html("Error borrar el registro del tabla control");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                var BE = document.createElement('audio');
                BE.src = 'audio/saperror.wav';
                BE.play();
            } else {
                $('#msg').html("La orden se notificó con éxito");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/aceptar.png');
                var BE = document.createElement('audio');
                BE.src = 'audio/sapmsg.wav';
                BE.play();
            }
        }
    })
}
//Carga Contenido del Match Usuarios
function CargarContenido() {
    var acc = "ConsultaUsuarios";
    $.ajax({
        beforeSend: function () {
            var iconm = document.getElementById("iconmsg");
            iconm.style.display = "inline";
            iconm.style.visibility = "visible";
            iconm.src = "images/load.gif";
            var men = document.getElementById("msg");
            men.innerHTML = "Espere un momento por favor......";
        },
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $("#ConsultaTablaUsu").css("display", "block");
                $("#cargarDatosUsuarios").html(data);
                borrarmsg();
            }
        }
    });
}
//Consultar Orden de Fabricación Por Match
function CargarContenidoOrdFab() {
    var acc = "ConsultarOrdenesFab";
    var ord = $('#txtOrd').val();
    var txt = $('#txtBrev').val();
    var nAc = $('#numAcMaxOrd').val();
    var dataSend = "&modOrd=" + ord +
            "&modTxtB=" + txt +
            "&modAcO=" + nAc;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + dataSend,
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $('#BuscarParamOrden').hide();
                $('#ConsultaTablaOrFa').show();
                $('#cargarDatosOrdenFab').html(data);
//                $("#ConsultaTablaOrFa").css("display", "block");
                borrarmsg();
            }
        }
    });
}
//Cargar automaticamente las operaciones al seleccionar un numero de orden de fabricación
function MostrarOperaciones(orden) {
    var acc = "MostrarOperaciones";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&orden=" + orden,
        success: function (data) {
            if (data == 0) {
//                ErrorBusquedaMatch();
                $('#sectionMostOp').html("<select><option></option></select>");
            } else {
                $('#sectionMostOp').html(data);
                $('#NoOpe').css("visibility", false);
                borrarmsg();
                revisarExcesoCant(orden);
            }
        }
    });
}
function revisarExcesoCant(orden) {
    var acc = "revisarExcesoCant";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&orden=" + orden,
        success: function (data) {
            if (data == 0) {
                //La orden no trae estatus de exceso de cantidades                
            } else {
                $('#sectionVisualExc').hide();
                $('#sectionMuestraExc').show();
                $('#sectionMuestraExc').html(data);
                borrarmsg();
            }
        }
    });
}
function revDatos(usuario) {
    var acc = "revDatosUs";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + usuario,
        success: function (data) {
            if (data == 0) {
//                limpiarCampos();  
                document.getElementById("NotParcial").checked = true;
                document.getElementById("NotFinal").checked = false;
                document.getElementById("NotFinalAu").checked = false;
                document.getElementById("CompRes").checked = false;
                $('#OrdFab').val("");
                $('#sectionMostOp').html("<select><option>0010</option></select>");
                $('#cntBuena').val("");
                $('#cntMala').val("");
                desbloquearCampos();
            } else {
                var n = data;
                //No Personal
                $("#NoPers").html(n[0]);
                //Radio button Notificación Parcial
                if (n[1] == "X") {
                    document.getElementById("NotParcial").checked = true;
                }
                //Radio Button Notificación Final
                if (n[2] == "X") {
                    document.getElementById("NotFinal").checked = true;
                }
                //Radio Button Notificacion Final Automatica
                if (n[3] == "X") {
                    document.getElementById("NotFinalAu").checked = true;
                }
                //Check box Compensar Reserva
                if (n[4] == "X") {
                    $('#CompRes').prop("checked", true);
                }
                //Orden de Fabricación
                $('#OrdFab').val(n[5]);
                $('#OrdFab').css('background-image', 'none');
                //Select Número de Operacion
                $('#NoOpe').css("visibility", false);
                $('#sectionMostOp').html("<select><option>" + n[6] + "</option></select>");
                //Input Cantidad Buena
                $('#cntBuena').val(n[7]);
                $('#cntBuena').css('background-image', 'none');
                //Input Cantidad Mala
                $('#cntMala').val(n[8]);
                $('#cntMala').css('background-image', 'none');
                $('#btnInicio').prop('disabled', true);
                $('#btnFin').prop('disabled', false);
                bloquearCampos();
            }
        }
    });
}
//Validar Status de la Orden
function validarStatusOrden() {
    var acc = "ValidarStatusOrden";
    var orden = $('#OrdFab').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&orden=" + orden,
        success: function (data) {
            if (data == 1) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#msg').html("Número de orden incorrecto");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#OrdFab').val("");
            } else {
                validarOrdFab();
            }
        }
    });
}
//Validaciones de Inputs
function validarOrdFab() {
    var acc = "validarOrdFab";
    var orden = $('#OrdFab').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&orden=" + orden,
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#msg').html("Número de orden incorrecto");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#OrdFab').val("");
                $('#sectionMostOp').html("<select><option></option></select>");
            } else {
                MostrarOperaciones(orden);
            }
        }
    });
}
function validarUsuario() {
    var acc = "validarUsuario";
    var us = $('#NoPers').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + us.toUpperCase(),
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#msg').html("No de personal incorrecto");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#NoPers').val("");
                limpiarCampos();
                desbloquearCampos();
            } else {
                borrarmsg();
                revDatos(us);
            }
        }
    });
}
//FUNCIONES AUXILIARES
function inval() {
    msgMatch(0, 'images/advertencia.PNG', 'audio/saperror.wav');
}
function ErrorBusquedaMatch() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapmsg.wav";
    BE.play();
    $('#msg').html("No hay registros por mostrar");
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
}
function limpiarCampos() {
    $('#NoPers').val("");
    document.getElementById("NotParcial").checked = true;
    document.getElementById("NotFinal").checked = false;
    document.getElementById("NotFinalAu").checked = false;
    document.getElementById("CompRes").checked = false;
    $('#OrdFab').val("");
    $('#sectionMostOp').html("<select><option>0010</option></select>");
    $('#cntBuena').val("");
    $('#cntMala').val("");
    $('#sectionMuestraExc').hide();
    $('#sectionVisualExc').show();
}
function bloquearCampos() {
    $('#OrdFab').prop("disabled", true);
    $('#NotParcial').prop("disabled", true);
    $('#NotFinal').prop("disabled", true);
    $('#NotFinalAu').prop("disabled", true);
    $('#CompRes').prop("disabled", true);
    $('#cntBuena').prop("disabled", true);
    $('#cntMala').prop("disabled", true);
    $('#btnInicio').prop("disabled", true);
}
function desbloquearCampos() {
    $('#OrdFab').prop("disabled", false);
    $('#NotParcial').prop("disabled", false);
    $('#NotFinal').prop("disabled", false);
    $('#NotFinalAu').prop("disabled", false);
    $('#CompRes').prop("disabled", false);
    $('#cntBuena').prop("disabled", false);
    $('#cntMala').prop("disabled", false);
    $('#btnInicio').prop('disabled', false);
    $('#btnFin').prop('disabled', true);
}

//FUNCIONES DE VENTANAS MODALES
function MostrarVentanaModal(id, handle, obj, obj2) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + id);
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borrarmsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(id);
    Drag.init(theHandle, theRoot);
    if (obj != "") {
        $('#' + obj).focus();
        $('#' + obj2).val('500');
    }
}
function ocultarVentanaMatch(tipo) {
    switch (tipo) {
        case "OrdFab":
            var ventana = $('#VentanaModalOrdenFab');
            ventana.hide();
            $('#txtOrd').val("");
            $('#txtBrev').val("");
            cambiarMath();
            borrarmsg();
            break;
        case "NoPer":
            var ventana = $('#VentanaModalUsuarios');
            ventana.hide();
            break;
    }
}
function Select(obj, tipo) {
    switch (tipo) {
        case "Usuario":
            document.getElementById("NoPers").value = obj;
            ocultarVentanaMatch("NoPer");
            $('#btnmatchUsuarios').hide();
            $('#NoPers').css('background-image', 'none');
            validarUsuario();
            break;
    }
}
function SelectOrd(obj, tipo, des) {
    switch (tipo) {
        case "Orden":
            document.getElementById("OrdFab").value = obj;
            ocultarVentanaMatch("OrdFab");
            $('#btnmatchOrdLib').hide();
            $('#OrdFab').css('background-image', 'none');
            $('#DescripOrd').html(des);
            MostrarOperaciones(obj);
            break;
    }
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function cambiarMath() {
    $('#BuscarParamOrden').show();
    $('#ConsultaTablaOrFa').hide();
}
//Tiempo
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    $('#tiempo').html(h + ":" + m + ":" + s);
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}


