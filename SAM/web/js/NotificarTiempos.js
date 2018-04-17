/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    ponerUsuarioDefault();
    startTime();
//    $('#NoPers').css('background-image', 'url(images/necesario.PNG)');
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
    $('#OrdFab').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarStatusOrden();
            verificarContenidoUs();
            validarOrdenLib();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
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
            verificarContenidoUs();
            validarOrdenLib();
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
//        $("#NoPers").css('background-image', 'url(images/necesario.PNG)');
        limpiarCampos();
        desbloquearCampos();
        borrarmsg();
        ponerUsuarioDefault();
    });
    $("#okOrden").click(function () {
        CargarContenidoOrdFab();
    });
//    $('#btnInicio').click(function(){
//       
//    });
});
//Validar si ya existe una notificacion creada con el numero de operacion y el usuario
function verificarContenidoUs() {
    var us = $('#NoPers').val().toUpperCase();
    var orden = $('#OrdFab').val();
    var acc = "validarNotifCread";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + us + "&orden=" + orden,
        success: function (data) {
            if (data == 0) {
            } else {
                revDatos(us, orden);
            }
        }
    });
}
//Validar Cantidades
function validarCantidades() {
    var us = $('#NoPers').val();
    var ord = $('#OrdFab').val();
    var buena = $('#cntBuena').val();
    var mala = $('#cntMala').val();
    var orden = $('#OrdFab').val();
    if (us == "") {
        $('#NoPers').focus();
        $('#NoPers').css('background-image', 'none');
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }else if (ord == "") {
        $('#OrdFab').focus();
        $('#OrdFab').css('background-image', 'none');
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }else if (buena == "") {
        $('#cntBuena').focus();
        $('#cntBuena').css('background-image', 'none');
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }else if (mala == "") {
        $('#cntMala').focus();
        $('#cntMala').css('background-image', 'none');
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }else {
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
//                $('#msg').html("Registro agregado correctamente");
                $('#msg').html("Notificación iniciada correctamente");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/aceptar.png');
                var BE = document.createElement('audio');
                BE.src = 'audio/sapmsg.wav';
                BE.play();
                limpiarCampos();
                ponerUsuarioDefault();
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
                if (data != 0) {
                    $('#msg').html("Se ha grabado la orden con el nro. de documento: " + data);
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/aceptar.png');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/sapmsg.wav';
                    BE.play();
                    limpiarCampos();
                    desbloquearCampos();
                    borrarDatoControl(us, ord);
                    ponerUsuarioDefault();
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
//funcion para borrar el registro del usuario una vez que se inserto en cabecera y posicionn
function borrarDatoControl(usuario, ord) {
    var acc = "borrarRegControl";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + usuario.toUpperCase() + "&orden=" + ord,
        success: function (data) {
            if (data == 0) {
//                $('#msg').html("Error borrar el registro del tabla control");
//                var icon = $('#iconmsg');
//                icon.show();
//                icon.attr('src', 'images/advertencia.PNG');
//                var BE = document.createElement('audio');
//                BE.src = 'audio/saperror.wav';
//                BE.play();
            } else {
//                $('#msg').html("La orden se notificó con éxito");
//                var icon = $('#iconmsg');
//                icon.show();
//                icon.attr('src', 'images/aceptar.png');
//                var BE = document.createElement('audio');
//                BE.src = 'audio/sapmsg.wav';
//                BE.play();
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
                //$('#sectionMostOp').html("<select><option></option></select>");
            } else {
                //$('#sectionMostOp').html(data);
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
function revDatos(usuario, orden) {
    var acc = "revDatosUs";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + usuario + "&orden=" + orden,
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
//                $('#NoOpe').css("visibility", false);
//                $('#selNoOp').css("visibility", false);
//                $('#sectionMostOp').html("<select><option>" + n[6] + "</option></select>");
                //Input Cantidad Buena
                $('#cntBuena').val(n[7]);
                $('#cntBuena').css('background-image', 'none');
                //Input Cantidad Mala
                $('#cntMala').val(n[8]);
                $('#cntMala').css('background-image', 'none');
                $('#btnInicio').prop('disabled', true);
                $('#btnFin').prop('disabled', false);
                $('#btnmatchOrdLib').hide();
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
            }
        }
    });
}
//Validar al blur que solo acepte ordenes con status LIB.
function validarOrdenLib() {
    var acc = "ValidarOrdLibBlur";
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
                //$('#sectionMostOp').html("<select><option></option></select>");
            } else {
                validarOrdFab();
                TextoLargo();
                TextoLargo2();
                ordsta();
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
                //$('#sectionMostOp').html("<select><option></option></select>");
            } else {
                revisarExcesoCant(orden);
//                MostrarOperaciones(orden);
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
                //revDatos(us);
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
    //$('#sectionMostOp').html("<select><option>0010</option></select>");
    $('#cntBuena').val("");
    $('#cntMala').val("");
    $('#sectionMuestraExc').hide();
    $('#sectionVisualExc').show();
    $('#notsta').html("");
    $('#lblTextoLargo').html("");
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
    //$('#NoPers').css('background-image', 'url(images/necesario.PNG)');
    $('#OrdFab').css('background-image', 'url(images/necesario.PNG)');
    $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
    $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
    $('#btnmatchOrdLib').show();
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
            //MostrarOperaciones(obj);
            revisarExcesoCant(obj);
            TextoLargo();
            TextoLargo2();
            ordsta();
            verificarContenidoUs();
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

function TextoLargo() {
    var acc = "TextoLargo";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#lblTextoLargo").text(data.trim());
        }
    });
}
function TextoLargo2() {
    var acc = "TextoLargo2";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#lblTextoLargo2").text(data.trim());
        }
    });
}

function ordsta() {
    var acc = "ChecarStatusOrdenOpe";
    var ord = $("#OrdFab").val();
    var oper = $("#NoOpe").val();
    var enviar = "&ord=" + ord + "&oper=" + oper;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            $("#notsta").text(data);
        }
    });
}

function selecoftabPP() {
    var ptr = $("#notsta").text().substring(0, 4);
    var ctn = $("#cntBuena").val();
    var ord = $("#OrdFab").val();
    if (ptr == "CERR" || ptr == "CTEC" || ptr == "ABIE" || ptr == "CERR") {
        $(document).ready(function () {
            mostrarventaavi();
            var theHandle = document.getElementById("handleAv2");
            var theRoot = document.getElementById("ventanaavis");
            Drag.init(theHandle, theRoot);
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            borrarmsg();
        });
    } else if (ord == "") {
        $('#msg').html("Ingrese una orden");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
        $("#OrdFab").focus();
        $('#OrdFab').css('background-image', 'none');
    } else if (ctn == "") {
        $('#msg').html("Cantidad Obligatoria");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
        $("#cntBuena").focus();
        $('#cntBuena').css('background-image', 'none');
    } else {
        var x = document.getElementById("selNoOp").selectedIndex;
        document.getElementById("selClOp").selectedIndex = x;

        if ($("#selClOp").val() == "PP03") {

            pp1prt3FORSAMPP($("#OrdFab").val(), $("#selNoOp").val());
            mostrarventabs("ventaPM01");
            var theHandle = document.getElementById("handlePM01");
            var theRoot = document.getElementById("ventaPM01");
            Drag.init(theHandle, theRoot);
            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpoCld');
            fisrtChild();
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
            sujetoLote();
            obtenerLote();
        } else {
            mostrarventaavi4();
            var theHandle = document.getElementById("handleAv4");
            var theRoot = document.getElementById("ventanaavis3");
            Drag.init(theHandle, theRoot);
        }
    }
}

function mostrarventaavi() {
    var venaviso = document.getElementById("ventanaavis");
    var ancho = 20;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}

function mostrarventaavi4() {
    var venaviso = document.getElementById("ventanaavis3");
    var ancho = 20;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}

function ocultarVentana(ids)
{
    var ventana = document.getElementById(ids);
    ventana.style.display = 'none';
    $("#BuscarParam_u1").css("display", "block");
    $("#ConsultaTabla1").css("display", "none");
    $("#BuscarParam_u2").css("display", "block");
    $("#ConsultaTabla2").css("display", "none");
}

function pp1prt3FORSAMPP(ord, oper) {
    var acc = "TablasPP01MAtPP";
    var enviar = "&ord=" + ord + "&ope=" + oper + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            document.getElementById('SecCuerpoCld').innerHTML = data;
        }
    });
}

function mostrarventabs(ven) {
    var venaviso = document.getElementById(ven);
    var ancho = 1000;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    venaviso.style.left = x + "px";
    venaviso.style.top = y + "px";
    venaviso.style.display = 'block';
}
function cerraventabs(id) {
    var venavisos = document.getElementById(id);
    venavisos.style.display = "none";
}
function fisrtChild() {
    if ($("#tdCmov0").text() == "101") {
        document.getElementById("TabBody").rows[0].style.backgroundColor = "red";
    }
}
function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }

    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 17 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
}

function sujetoLote() {
    var mat = document.getElementsByName("btnShowLot");
    var acc = "SujetoLote";

    for (i = 0; i < mat.length; i++) {

        var enviar = "&v1=" + $("#tdCtr" + i).text() + "&v2=" + $("#tdMat" + i).text() + "&acc=" + acc;
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                if (data == 0) {
                    $('#bxLote' + i).prop('disabled', true);
                }
            }
        });
    }
}
function obtenerLote() {
    var mat = document.getElementsByName("btnShowLot");
    var acc = "obtenerLote";

    for (i = 0; i < mat.length; i++) {

        var enviar = "&v1=" + $("#tdCtr" + i).text() + "&v2=" + $("#tdMat" + i).text() + "&acc=" + acc + "&v3=" + $("#bxcnt" + i).val();
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: enviar,
            success: function (data) {
                $("#bxLote" + i).val(data);
            }
        });
    }
}
function EliminaFila()
{
    var CheckBx = document.getElementsByName('ckMovMer');
    if (CheckBx.length > 1) {
        for (var i = 0; i < CheckBx.length; i++)
        {
            if (CheckBx[i].checked)
            {
                document.getElementById("TabBody").deleteRow(i);
                EliminaFila();
            }
        }
    }
}

function btnloteHide() {
    var btn = document.getElementsByName("btnShowLot");
    for (i = 0; i < btn.length; i++) {
        $("#btnLot" + i).hide();
    }
}

function checkDec(num, tam) {
    var limit;
    var FINC;
    if (tam == 3) {
        limit = 9999999.999;
        FINC = "Formato Incorecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
    } else {
        limit = 99999999.99;
        FINC = "Formato Incorecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
    }
    if (num.length > 0) {
        if (parseFloat(limit) >= parseFloat(num)) {
            va = num.split(".");
            v01 = va[0];
            if (v01.length == 0) {
                v01 = "0";
            }
            v0 = parseInt(v01);
            v1 = va[1];
            if (num.indexOf(".") != -1) {
                if (v1.length > tam) {
                    var da = v1.substr(0, tam);
                    borrarmsg();
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    borrarmsg();
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                borrarmsg();
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
            mensajesValidacionInco(FINC);
            return "";
        }
    } else {
        borrarmsg();
        return "";
    }
}

function mensajesValidacionInco(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    var icon = $('#iconmsg');
    icon.show();
    icon.attr('src', 'images/advertencia.PNG');
    var men = document.getElementById("msg");
    men.innerHTML = msg;
}

function btnloteShow(pos) {
    var btn = document.getElementsByName("btnShowLot");
    for (i = 0; i < btn.length; i++) {
        if (i === pos) {
            if ($("#tdCmov" + pos).text() != "101") {
                $("#btnLot" + pos).show();
            }
        } else {
            $("#btnLot" + i).hide();
        }
    }
}

var posit = 0;

function btnLoteMatch(pos) {
    posit = pos;
    mostrarVentana('VentanaModalLote');
    peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '', pos);
    var theHandle = document.getElementById('handle6');
    var theRoot = document.getElementById('VentanaModalLote');
    Drag.init(theHandle, theRoot);
}

function mostrarVentana(t)
{
    switch (t) {
        case "VentanaModalLote":
            var ven = document.getElementById(t);
            abrirVentanaLote(ven);
            break;
    }
}

function abrirVentanaLote(ventana)
{
    var ancho = 1050;
    var alto = 600;
    if (screen.width <= 1100) {
        ancho = 1000;
    }
    if (screen.width <= 650) {
        ancho = 550;
    }
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}

function peticiones(url, id, accion, f, lote, pos)
{
    var centro = $("#tdCtr" + pos).text();
    var extras = "";
    var v1;

    switch (accion)
    {
        case "VentanaModalLote":
            v1 = $("#tdMat" + pos).text();
            extras = "&v1=" + v1 + "&v2=101&v3=1400";

            break;
    }
    var lang = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            var temp = new Array();
            temp = xmlhttp.responseText.split(",");
            if (temp[0] == 0) {
                ocultarVentana(temp[1], temp[2]);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                var men = document.getElementById("msg");
                men.innerHTML = "No hay valores por mostrar";
            } else {
                document.getElementById(id).innerHTML = xmlhttp.responseText;
//                fnc(f);
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + accion + "&lang=" + lang + extras + "&lote=" + lote + "&ctr=" + centro, true);
    xmlhttp.send();
}
//function fnc() {
//    document.getElementById('table-scroll').onscroll = function () {
//
//        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
//    };
//}

function seleccionar(val, id, ven)
{
    document.getElementById("bxLote" + posit).value = val;
    ocultarVentana(ven, "bxLote" + posit);
}
function msjError(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    var icon = $('#iconmsg');
    icon.show();
    icon.attr('src', 'images/advertencia.PNG');
    var men = document.getElementById("msg");
    men.innerHTML = msg;
}

function ConsMaterial() {
    var mat = document.getElementsByName("tdMaterial");
    var cant = document.getElementsByName("bxcantidad");
    var lote = document.getElementsByName("bxlote");

    for (var i = 0; i < mat.length; i++) {
        if (cant[i].value == "") {
            msjError("Cantidad Obligatoria");
            cant[i].focus();
            return;
        } else {
            borrarmsg();
        }
        if (lote[i].value == "") {
            if (lote[i].disabled == false) {
                msjError("Lote es Obligatorio");
                lote[i].focus();
                return;
            }
        } else {
            borrarmsg();
        }
    }
    validacnt101();
}
function validacnt101() {
    var acc = "validaDatos101";
    var lote = document.getElementsByName("bxlote");
    var cant = document.getElementsByName("bxcantidad");
    var mat = document.getElementsByName("tdMaterial");
    var cl = document.getElementsByName("tdClaseM");

    if (cl[0].textContent == "101") {
        var send = "&v1=" + $("#OrdFab").val() + "&v2=" + cant[0].value + "&acc=" + acc + "&v3=" + mat[0].textContent + "&v4=" + lote[0].value;
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
                if (data == 0) {
                    msjError("Cantidad no valida");
                    cant[0].focus();
                    cant[0].value = "";
                } else {
                    validacnt261();
                }
            }
        });
    } else {
        validacnt261();
    }

}
function validacnt261() {
    var acc = "validaDatos261";
    var lote = document.getElementsByName("bxlote");
    var cant = document.getElementsByName("bxcantidad");
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");

    if (cl[0].textContent == "261") {
        for (i = 1; i < mat.length; i++) {
            var send = "&v2=" + cant[i].value + "&acc=" + acc + "&v3=" + mat[i].textContent + "&v4=" + lote[i].value + "&v1=" + centro[i].textContent;
            $.ajax({
                async: false,
                type: 'GET',
                url: "PeticionNotificacionesOrdenesSAMPP",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: send,
                success: function (data) {
                    var temp = new Array();
                    temp = data.split(",");

                    if (temp[1] == 0) {
                        msjError("Material no existe para el lote Almacén-Centro");
                        lote[i].focus();
                        lote[i].value = "";
                        return;
                    } else if (temp[0] == 0) {
                        msjError("Cantidad no valida");
                        cant[i].focus();
                        cant[i].value = "";
                        return;
                    } else {
                        if (i == mat.length - 1) {
                            guardaCabecera();
                        }
                    }
                }
            });
        }
        if (mat.length == 1) {
            guardaCabecera();
        }
    } else {
        guardaCabecera();
    }
}

var folio101 = "";
function guardaCabecera() {
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");

    if (cl[0].textContent == "101") {
        var acc = "guardaCabecera";

        var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + mat[0].textContent + "&v3=" + centro[0].textContent + "&v4=" + cl[0].textContent + "&v5=" + $("#NoPers").val();
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
                folio101 = data;
                guardaPos();
            }
        });
    } else {
        guardaPos();
    }
}
function guardaCabecera2() {
    var acc = "guardaCabecera";
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");

    if (cl[0].textContent == "261") {
        var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + mat[0].textContent + "&v3=" + centro[0].textContent + "&v4=" + cl[0].textContent + "&v5=" + $("#NoPers").val();
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
            }
        });
    } else {
        if (mat.length > 1) {
            var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + mat[0].textContent + "&v3=" + centro[0].textContent + "&v4=" + cl[1].textContent + "&v5=" + $("#NoPers").val();
            $.ajax({
                async: false,
                type: 'GET',
                url: "PeticionNotificacionesOrdenesSAMPP",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: send,
                success: function (data) {
                }
            });
        }
    }
}

function guardaPos() {
    var acc = "guardaPos";
    var lote = document.getElementsByName("bxlote");
    var cant = document.getElementsByName("bxcantidad");
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");
    var um = document.getElementsByName("tdUnM");


    var tabix = 0;

    for (i = 0; i < mat.length; i++) {
        tabix = parseInt(i);
        if (i == 0) {
            tabix = parseInt(i + 1);
        }
        var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + tabix + "&v3=" + mat[i].textContent + "&v4=" + cant[i].value + "&v5=" + um[i].textContent + "&v6=" + lote[i].value.toUpperCase() + "&v7=" + centro[i].textContent + "&v8=" + cl[i].textContent;
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
                if (i == mat.length - 1) {
                    guardaCabecera2();
                    updateFolio();
                    Print_PT();
                    ocultarVentana('ventaPM01', '');
                }
            }
        });
    }
}

function updateFolio() {
    var acc = "ActualizarFolioPP";

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificacionesOrdenesSAMPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc,
        success: function (data) {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/aceptar.png');
            var men = document.getElementById("msg");
//            men.innerHTML = "Se ha grabado la notificación con el número de documento " + data;
            men.innerHTML = "Notificación grabada, movimientos mercancía ";
        }
    });
}

function Print_PT() {
    var acc = "imprimePT";

    if ($("#tdCmov0").text() == "101") {
        var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + $("#tdMat0").text() + "&v3=" + $("#tdDes0").text() + "&v4=" + $("#bxLote0").val().toUpperCase() + "&v5=" + $("#bxcnt0").val() + "&v6=" + $("#tdOpr0").text() + "&v7=" + folio101 + "&v8=" + $("#tdCtr0").text() + "&v9=" + $("#tdUM0").text();
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
            }
        });
    }
}
