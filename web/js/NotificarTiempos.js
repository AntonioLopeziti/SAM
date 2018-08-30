/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    ponerUsuarioDefault();
    getCtrUsr();
    AjustarCabecera('TabHeadOpe', 'TabBodyOpe', 3, 'SecCuerpoOpe');
    startTime();
//    $('#NoPers').css('background-image', 'url(images/necesario.PNG)');
    $('#OrdFab').css('background-image', 'url(images/necesario.PNG)');
    $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
//    $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
    $('#aceptar').prop('disabled', true);
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
//    $('#btnFin').prop('disabled', true);
    $('#iconmsg').hide();
    $('#btnmatchOrdLib').hide();
    $('#btnmatchUsuarios').hide();
    $('#sectionMuestraExc').hide();
    $('#NoPers').click(function () {
        $('#NoPers').css('background-image', 'none');
    });
    $('#OrdFab').focus(function () {
        $('#OrdFab').css('background-image', 'none');
    });
    $('#cntBuena').click(function () {
        $('#cntBuena').css('background-image', 'none');
    });
//    $('#cntMala').click(function () {
//        $('#cntMala').css('background-image', 'none');
//    });
    $('#NoPers').blur(function () {
        if ($('#NoPers').val().length > 0) {
            $('#NoPers').css('background-image', 'none');
        } else {
            $('#NoPers').css('background-image', 'url(images/necesario.PNG)');
        }
    });
    $('#OrdFab').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarStatusOrden();
//            verificarContenidoUs();
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
//    $('#cntMala').keypress(function (e) {
//        var tecla = (document).all ? e.keyCode : e.which;
//        patron = /[0-9]/;
//        te = String.fromCharCode(tecla);
//        return patron.test(te);
//    });
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
//            validarStatusOrden();
//            verificarContenidoUs();
//            validarOrdenLib();
//            tabOpePP($('#OrdFab').val());
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
//    $('#cntMala').blur(function () {
//        if ($('#cntMala').val().length > 0) {
//            $('#cntMala').css('background-image', 'none');
//        } else {
//            $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
//        }
//    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#OrdFab').focus(function () {
        $('#btnmatchOrdLib').show();
        $('#OrdFab').css('background-image', 'none');
    });
    $('#cntBuena').focus(function () {
        $('#cntBuena').css('background-image', 'none');
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
        tabOpePP("");
        getCtrUsr();
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
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (i = 0; i < ckOpe.length; i++) {
//        document.getElementById("TabBodyOpe").rows[ckOpe[i].value].style.backgroundColor = "#E6EBEB";
        if (ckOpe[i].checked) {
            op = $("#opeNumOpe" + ckOpe[i].value).text();
//            document.getElementById("TabBodyOpe").rows[ckOpe[i].value].style.backgroundColor = "#86C3FF";
        }
    }

    var acc = "validarNotifCread";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + us + "&orden=" + orden + "&oper=" + op,
        success: function (data) {
            if (data == 0) {
                $('#OrdFab').prop('disabled', false);
                $('#cntBuena').prop('disabled', false);
//                $('#cntMala').prop('disabled', false);
                $('#btnInicio').prop('disabled', false);
                $('#cntBuena').val($("#cntHID").val());
            } else {
                revDatos(us, orden, op);
            }
        }
    });
}
//Validar Cantidades
function validarCantidades() {
    var us = $('#NoPers').val();
    var ord = $('#OrdFab').val();
    var buena = $('#cntBuena').val();
    var restante = $('#cntHID').val();
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
    } else if (ord == "") {
        $('#OrdFab').focus();
        $('#OrdFab').css('background-image', 'none');
        $('#msg').html("Complete los campos obligatorios");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }
    var ckOpe = document.getElementsByName("ckOperPP");
    var bxSts = document.getElementsByName("bxStOrd");
    var bxSts2 = document.getElementsByName("bxStOrd2");
    var clSts = document.getElementsByClassName("clStOrd2");
    var st = "NOTP";
    var st2 = "";
    var st3 = "";
    var operacion = "";
    var operacion2 = "";
    var op = "";
    var ops = "";
    var bn = false;
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            op = $("#opeClavCon" + parseInt(ckOpe[i].value)).text();
            ops = $("#opeClavCon" + parseInt(ckOpe[i].value - 1)).text();
            bn = true;            
            if (op !== "PP02") {
                if (i > 0) {
                    st = bxSts[parseInt(ckOpe[i].value) - 1].value;
                    st2 = bxSts2[parseInt(ckOpe[i].value) - 1].value;
                    st3 = $(".clStOrd2").val();                   
//                    st3 = clSts[parseInt(ckOpe[i].value - 2)].value;
                    operacion = $("#opeNumOpe" + parseInt(ckOpe[i].value - 1)).text();
                    operacion2 = $("#opeNumOpe" + parseInt(ckOpe[i].value - 2)).text();                 
                }
            }
        }
    }
    if (!bn) {
        $('#msg').html("Seleccione una Operación");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
        return;
    }
    if (op !== "PP02") {
        if (st2 !== "") {
            if (st2 !== "INIC" && ops !== "PP02" || st3 !== "INIC") {                
                if (ops == "PP02")
                {
                    $('#msg').html("Debe iniciar la operación " + operacion2);
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/advertencia.PNG');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/saperror.wav';
                    BE.play();
                    return;
                } else
                {
                    $('#msg').html("Debe iniciar la operación " + operacion);
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/advertencia.PNG');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/saperror.wav';
                    BE.play();
                    return;
                }
            }
        }
    }
//    else if (st !== "NOTP") {
//        $('#msg').html("Complete la Operación " + operacion);
//        var icon = $('#iconmsg');
//        icon.show();
//        icon.attr('src', 'images/advertencia.PNG');
//        var BE = document.createElement('audio');
//        BE.src = 'audio/saperror.wav';
//        BE.play();
//    }
//    else {
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            switch ($("#opeClavCon" + ckOpe[i].value).text()) {
                case "PP03":
                    if (buena == "") {
                        $('#cntBuena').focus();
                        $('#cntBuena').css('background-image', 'none');
                        $('#msg').html("Complete los campos obligatorios");
                        var icon = $('#iconmsg');
                        icon.show();
                        icon.attr('src', 'images/advertencia.PNG');
                        var BE = document.createElement('audio');
                        BE.src = 'audio/saperror.wav';
                        BE.play();
                    } else if (mala == "") {
                        $('#cntMala').val("0.000");
//                            $('#cntMala').focus();
//                            $('#cntMala').css('background-image', 'none');
//                            $('#msg').html("Complete los campos obligatorios");
//                            var icon = $('#iconmsg');
//                            icon.show();
//                            icon.attr('src', 'images/advertencia.PNG');
//                            var BE = document.createElement('audio');
//                            BE.src = 'audio/saperror.wav';
//                            BE.play();
                    } else if (parseInt(restante) == 0) {
                        $('#OrdFab').focus();
                        $('#OrdFab').css('background-image', 'none');
                        $('#msg').html("Orden notificada");
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
                                        $("#cntBuena").focus();
                                    } else {
                                        validarDatos();
                                    }
                                }
                            });
                        }
                    }
                    break;
                case "PP01":
                    validarDatos2();
                    break;
                case "PP02":
                    mostrarVentanaAviPP02();
                    var theHandle = document.getElementById('handleAv5');
                    var theRoot = document.getElementById('ventanaAvisoPP02');
                    Drag.init(theHandle, theRoot);

                    break;
            }
        }
//        }
    }
}
//Insertar datos a tabla interna
function validarDatos() {
    var acc = "insertarDatos";
    var pers = $('#NoPers').val();
    var orden = $('#OrdFab').val();
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            op = $("#opeNumOpe" + ckOpe[i].value).text();
        }
    }
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
                tabOpePP("");
                ponerUsuarioDefault();
                getCtrUsr();
            }
        }
    });
}
function validarDatos2() {
    var acc = "insertarDatos";
    var pers = $('#NoPers').val();
    var orden = $('#OrdFab').val();
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            op = $("#opeNumOpe" + ckOpe[i].value).text();
        }
    }
    var par = $('#NotParcial');
    var fin = $('#NotFinal');
    var aut = $('#NotFinalAu');
    var res = $('#CompRes');
    var pa = "";
    var fi = "";
    var au = "";
    var re = "";
    var cntBuena = $("#cntHID").val();
    var cntMala = "0.000";
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
                tabOpePP("");
                ponerUsuarioDefault();
                getCtrUsr();
            }
        }
    });
}
function validarLlenado() {
    var acc = "LlenarTablas";
    var us = $('#NoPers').val();
    var ord = $('#OrdFab').val();
    var buena;
    var mala = $('#cntMala').val();
    var orden = $('#OrdFab').val();
    var cadena, v1 = "", v2 = "", v3 = "", v4 = "", v5 = "", v6 = "";
    var f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "";
    var s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "";
    var motivo = "";
    if (parseFloat(mala) > 0) {
        var ckRechaz = document.getElementsByName("ckRechazoIT");
        for (j = 0; j < ckRechaz.length; j++) {
            if (ckRechaz[j].checked) {
                motivo = ckRechaz[j].value;
            }
        }
    }
    var cc;
    var cl;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (var tt = 0; tt < ckOpe.length; tt++) {
        if (ckOpe[tt].checked) {
            cc = $("#opeClavCon" + ckOpe[tt].value).text();
            cl = $("#opeClavCon" + ckOpe[tt].value).text();
        }
    }
    if (cl === "PP03") {
        buena = $('#bxcnt0').val();
    } else {
        buena = $('#cntBuena').val();
    }

    f1 = $("#bxAct1").val();
    f2 = $("#bxAct2").val();
    f3 = $("#bxAct3").val();
    f4 = $("#bxAct4").val();
    f5 = $("#bxAct5").val();
    f6 = $("#bxAct6").val();
    s1 = $("#bxActUM1").val();
    s2 = $("#bxActUM2").val();
    s3 = $("#bxActUM3").val();
    s4 = $("#bxActUM4").val();
    s5 = $("#bxActUM5").val();
    s6 = $("#bxActUM6").val();

    if ($("#bxAct1").val().length > 0) {
        v1 = "X";
    } else {
        f1 = "0";
        s1 = "0";
        v1 = "0";
    }
    if ($("#bxAct2").val().length > 0) {
        v2 = "X";
    } else {
        f2 = "0";
        s2 = "0";
        v2 = "0";
    }
    if ($("#bxAct3").val().length > 0) {
        v3 = "X";
    } else {
        f3 = "0";
        s3 = "0";
        v3 = "0";
    }
    if ($("#bxAct4").val().length > 0) {
        v4 = "X";
    } else {
        f4 = "0";
        s4 = "0";
        v4 = "0";
    }
    if ($("#bxAct5").val().length > 0) {
        v5 = "X";
    } else {
        f5 = "0";
        s5 = "0";
        v5 = "0";
    }
    if ($("#bxAct6").val().length > 0) {
        v6 = "X";
    } else {
        f6 = "0";
        s6 = "0";
        v6 = "0";
    }
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (k = 0; k < ckOpe.length; k++) {
        if (ckOpe[k].checked) {
            op = $("#opeNumOpe" + ckOpe[k].value).text();
        }
    }

    cadena = "&v1=" + buena
            + "&v2=" + mala
            + "&v3=" + f1
            + "&v4=" + s1
            + "&v5=" + v1
            + "&v6=" + f2
            + "&v7=" + s2
            + "&v8=" + v2
            + "&v9=" + f3
            + "&v10=" + s3
            + "&v11=" + v3
            + "&v12=" + f4
            + "&v13=" + s4
            + "&v14=" + v4
            + "&v15=" + f5
            + "&v16=" + s5
            + "&v17=" + v5
            + "&v18=" + f6
            + "&v19=" + s6
            + "&v20=" + v6
            + "&v21=" + op
            + "&v22=" + motivo
            + "&v23=" + cc;

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
            data: "acc=" + acc + "&usuario=" + us + "&orden=" + ord + cadena,
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
                    ocultarVentana('VentanaModalActividades', '');
                    tabOpePP("");
                    getCtrUsr();
//                    $('#btnFin').prop('disabled', true);
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
                document.getElementById("table-scrollUsuarios").onscroll = function () {
                    document.getElementById("fixedYUsuario").style.top = document.getElementById("table-scrollUsuarios").scrollTop + 'px';
                };
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
    var ctr = $('#centroUsr').val();
    var dataSend = "&modOrd=" + ord +
            "&modTxtB=" + txt +
            "&modAcO=" + nAc +
            "&v1=" + ctr;
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
                document.getElementById("table-scrollOrdFab").onscroll = function () {
                    document.getElementById("fixedYOrdFab").style.top = document.getElementById("table-scrollOrdFab").scrollTop + 'px';
                };
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
//                $('#sectionMostOp').html("<select><option></option></select>");
            } else {
//                $('#sectionMostOp').html(data);
//                $('#NoOpe').css("visibility", false);
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
function revDatos(usuario, orden, op) {
    var acc = "revDatosUs";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&usuario=" + usuario + "&orden=" + orden + "&oper=" + op,
        success: function (data) {
            if (data == 0) {
//                limpiarCampos();  
                document.getElementById("NotParcial").checked = true;
                document.getElementById("NotFinal").checked = false;
                document.getElementById("NotFinalAu").checked = false;
                document.getElementById("CompRes").checked = false;
                $('#OrdFab').val("");
//                $('#sectionMostOp').html("<select><option>0010</option></select>");
                $('#cntBuena').val("");
//                $('#cntMala').val("");
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
//                $('#btnFin').prop('disabled', false);
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
                borrarmsg();
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
        data: "acc=" + acc + "&orden=" + orden + "&v1=" + $('#centroUsr').val(),
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#msg').html("Número de orden incorrecto");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#OrdFab').val("");
                $('#cntBuena').val("");
//                $('#cntMala').val("");
                $('#OrdFab').prop("disabled", false);
                $('#cntBuena').prop("disabled", false);
//                $('#cntMala').prop("disabled", false);
                $('#OrdFab').focus();
                $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
                limpiarCampos();
                desbloquearCampos();
                ponerUsuarioDefault();
                tabOpePP("");
                getCtrUsr();
//                $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
//                $('#sectionMostOp').html("<select><option></option></select>");
            } else {
                validarOrdFab();
                TextoLargo();
                TextoLargo2();
                TextoLargo3();
                cantidadPT();
                ordsta();
                ordMaterial();
                tabOpePP($('#OrdFab').val());
                getUmOpe();
                borrarmsg();
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
//                $('#sectionMostOp').html("<select><option></option></select>");
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
                limpiarCampos();
                desbloquearCampos();
                tabOpePP("");
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
//    $('#sectionMostOp').html("<select><option>0010</option></select>");
    $('#cntBuena').val("");
    $('#cntMala').val("0.000");
    $('#sectionMuestraExc').hide();
    $('#sectionVisualExc').show();
    $('#notsta').html("");
    $('#lblTextoLargo').html("");
    $('#cntNN').html("");
    $('#cntRR').html("");
    $('#lblUM').html("");
    $('#MaterialPP').html("");
    $("#secMala").hide();
}
function bloquearCampos() {
    $('#OrdFab').prop("disabled", true);
    $('#NotParcial').prop("disabled", true);
    $('#NotFinal').prop("disabled", true);
    $('#NotFinalAu').prop("disabled", true);
    $('#CompRes').prop("disabled", true);
    $('#cntBuena').prop("disabled", true);
//    $('#cntMala').prop("disabled", true);
    $('#btnInicio').prop("disabled", true);
}
function desbloquearCampos() {
    $('#OrdFab').prop("disabled", false);
    $('#NotParcial').prop("disabled", false);
    $('#NotFinal').prop("disabled", false);
    $('#NotFinalAu').prop("disabled", false);
    $('#CompRes').prop("disabled", false);
    $('#cntBuena').prop("disabled", false);
//    $('#cntMala').prop("disabled", false);
    $('#btnInicio').prop('disabled', false);
//    $('#btnFin').prop('disabled', true);
    //$('#NoPers').css('background-image', 'url(images/necesario.PNG)');
    $('#OrdFab').css('background-image', 'url(images/necesario.PNG)');
    $('#cntBuena').css('background-image', 'url(images/necesario.PNG)');
//    $('#cntMala').css('background-image', 'url(images/necesario.PNG)');
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
            validarUsuario();
            document.getElementById("NoPers").value = obj;
            ocultarVentanaMatch("NoPer");
            $('#btnmatchUsuarios').hide();
            $('#NoPers').css('background-image', 'none');
            getCtrUsr();
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
            revisarExcesoCant(obj);
            TextoLargo();
            TextoLargo2();
            TextoLargo3();
            cantidadPT();
            ordsta();
            ordMaterial();
            verificarContenidoUs();
            tabOpePP($('#OrdFab').val());
            getUmOpe();
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

function TextoLargo3() {
    var acc = "TextoLargo3";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#lblTextoLargo3").text(data.trim());
        }
    });
}

function ordMaterial() {
    var acc = "ChecarMaterialOp";
    var ord = $("#OrdFab").val();
    var enviar = "&ord=" + ord;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + enviar,
        success: function (data) {
            $("#MaterialPP").text(data);
//            ordCliente();
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
//            ordCliente();
        }
    });
}
function ordCliente() {
    var acc = "ChecarClienteOrden";
    var ord = $("#OrdFab").val();
    var oper = $("#NoOpe").val();
    var enviar = "&ord=" + ord;
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
    } else if (document.getElementById("OrdFab").disabled == false) {
        $('#msg').html("No ha iniciado ninguna actividad para esta orden");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
        $("#OrdFab").focus();
    } else {
        var ckOpe = document.getElementsByName("ckOperPP");
        for (x = 0; x < ckOpe.length; x++) {
            if (ckOpe[x].checked) {
                var claveOp = $("#opeClavCon" + ckOpe[x].value).text();
                mostrarventabs("VentanaModalActividades");
                var theHandle = document.getElementById("handle4");
                var theRoot = document.getElementById("VentanaModalActividades");
                Drag.init(theHandle, theRoot);
                getFechaInicio(ckOpe[x].value);
                getActividades($("#opeTrabOpe" + ckOpe[x].value).text(), ckOpe[x].value);
                borrarmsg();
//                switch ($("#opeClavCon" + ckOpe[x].value).text()) {
//                    case "PP03":
//                        pp1prt3FORSAMPP($("#OrdFab").val());
//                        mostrarventabs("ventaPM01");
//                        var theHandle = document.getElementById("handlePM01");
//                        var theRoot = document.getElementById("ventaPM01");
//                        Drag.init(theHandle, theRoot);
//                        AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpoCld');
//                        fisrtChild();
//                        ajustaCantidades(0);
//                        document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
//                        sujetoLote();
//                        obtenerLote();
//                        break;
//                    case "PP01":
//                        mostrarventabs("VentanaModalActividades");
//                        var theHandle = document.getElementById("handle4");
//                        var theRoot = document.getElementById("VentanaModalActividades");
//                        Drag.init(theHandle, theRoot);
//                        getFechaInicio(ckOpe[x].value);
//                        getActividades($("#opeTrabOpe" + ckOpe[x].value).text(), ckOpe[x].value);
//                        borrarmsg();
//                        break;
//                }
            }
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

function mostrarVentanaAviPP02() {
    var venaviso = document.getElementById("ventanaAvisoPP02");
    var ancho = 400;
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

function pp1prt3FORSAMPP(ord) {
    var acc = "TablasPP01MAtPP";
    var enviar = "&ord=" + ord + "&acc=" + acc + "&v1=" + $("#cntBuena").val();
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
function tabOpePP(ord) {
    var acc = "TabOperacionesPP";
    var enviar = "&ord=" + ord + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            document.getElementById('SecCuerpoOpe').innerHTML = data;
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
    var acc;

    for (i = 1; i < mat.length; i++) {
        acc = ($("#bxEE" + i).val() == "E") ? "obtenerLoteE" : "obtenerLote";
        var enviar = "&v1=" + $("#tdCtr" + i).text() + "&v2=" + $("#tdMat" + i).text() + "&acc=" + acc + "&v3=" + $("#bxcnt" + i).val() + "&v4=" + $("#bxNped" + i).val() + "&v5=" + $("#bxNpos" + i).val();
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
function ajustaCantidades(pos) {
    var cnt = document.getElementById("bxcnt0").value;
    var cants = document.getElementsByName("bxcantidad");
    var cants2 = document.getElementsByName("bxcantidadT");
    if ($("#tdCmov" + pos).text() == "101") {
        var x = document.getElementById("bxcntT0").value;
        for (i = 1; i < cants.length; i++) {
            var y = cants2[i].value;
            var res = parseFloat(cnt) * parseFloat(y);
            var tx = res / parseFloat(x) + "";
            var tx2 = res / parseFloat(x);
            cants[i].value = tx2.toFixed(3);
            if (cnt == "") {
                cants[i].value = "";
            }
        }
    }
}
function checkDecc(num, tam) {
    var limit;
    var FINC;
    if (tam == 3) {
        limit = 9999999.999;
        FINC = "Formato corecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
    } else {
        limit = 99999999.99;
        FINC = "Formato corecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
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
    var ck = document.getElementsByName("ckMovMer");
    for (var i = 0; i < btn.length; i++) {
        if (parseInt(pos) === parseInt(ck[i].value)) {
            if ($("#tdCmov" + pos).text() != "101") {
                $("#btnLot" + pos).show();
            }
        } else {
            $("#btnLot" + ck[i].value).hide();
        }
    }
}

var posit = 0;

function btnLoteMatch(pos) {
    posit = pos;
    mostrarVentana('VentanaModalLote');
    peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', '', pos, $("#bxEE" + pos).val());
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
        case "VentanaModalRechazo":
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

function peticiones(url, id, accion, f, lote, pos, ee)
{
    var centro = $("#tdCtr" + pos).text();
    var extras = "";
    var v1, v2, v3;
    var acc = accion + ee;
    switch (acc)
    {
        case "VentanaModalLote":
            v1 = $("#tdMat" + pos).text();
            extras = "&v1=" + v1 + "&v2=101&v3=1400";

            break;
        case "VentanaModalLoteE":
            v1 = $("#tdMat" + pos).text();
            v2 = $("#bxNped" + pos).val();
            v3 = $("#bxNpos" + pos).val();
            extras = "&v1=" + v1 + "&v2=101&v3=1400&v4=" + v2 + "&v5=" + v3;

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
    xmlhttp.open("GET", url + "?Action=" + acc + "&lang=" + lang + extras + "&lote=" + lote + "&ctr=" + centro, true);
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
    var anch = document.getElementsByName("bxancho");
    var centro = document.getElementsByName("tdCentro");

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
//        if (anch[i].value == "") {
//            if (anch[i].disabled == false) {
//                if (centro[i].textContent != "3000") {
//                    msjError("Ancho es Obligatorio");
//                    anch[i].focus();
//                    return;
//                }
//            }
//        } else {
//            borrarmsg();
//        }
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
    var accion = "validaDatos261";
    var lote = document.getElementsByName("bxlote");
    var cant = document.getElementsByName("bxcantidad");
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");
    var ee = document.getElementsByName("bxinvEE");
    var ped = document.getElementsByName("bxNped");
    var pos = document.getElementsByName("bxNpos");

    var acc = "";

    for (i = 0; i < mat.length; i++) {

        acc = accion + ee[i].value;
        var send = "&v2=" + cant[i].value + "&acc=" + acc + "&v3=" + mat[i].textContent + "&v4=" + lote[i].value + "&v1=" + centro[i].textContent + "&v5=" + ped[i].value + "&v6=" + pos[i].value + "&v7=" + cl[i].textContent;
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
                    msjError("Material " + mat[i].textContent + " no existe para el lote Almacén-Centro");
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
}
function cantidadPT() {
    var acc = "DatosOrdenCnt";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc;
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
            $("#cntNN").text(temp[0]);
            $("#cntRR").text(temp[2]);
            $("#cntHID").val(temp[1]);
            if (document.getElementById("OrdFab").disabled == false) {
                $("#cntBuena").val(temp[1]);
                $('#cntBuena').css('background-image', 'none');
            }
        }
    });
}

var folio101 = "";
function guardaCabecera() {
    var mat = document.getElementsByName("tdMaterial");
    var centro = document.getElementsByName("tdCentro");
    var cl = document.getElementsByName("tdClaseM");
    var buena = document.getElementById("cntBuena").value;
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            op = $("#opeNumOpe" + ckOpe[i].value).text();
        }
    }

//    if (cl[0].textContent == "101") {
    var acc = "guardaCabecera";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + mat[0].textContent + "&v3=" + centro[0].textContent + "&v4=" + cl[0].textContent + "&v5=" + $("#NoPers").val() + "&v6=" + op + "&v7=" + buena;
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
//    } else {
//        guardaPos();
//    }
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
    var lm = document.getElementsByName("bxlistaM");
    var ancho = document.getElementsByName("bxancho");

    var ee = document.getElementsByName("bxinvEE");
    var ped = document.getElementsByName("bxNped");
    var pos = document.getElementsByName("bxNpos");

    var tabix = 0;
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (z = 0; z < ckOpe.length; z++) {
        if (ckOpe[z].checked) {
            op = $("#opeNumOpe" + ckOpe[z].value).text();
        }
    }

    for (i = 0; i < mat.length; i++) {
//        tabix = parseInt(i);
//        if (i == 0) {
        tabix = parseInt(i + 1);
//        }
        var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + tabix + "&v3=" + mat[i].textContent + "&v4=" + cant[i].value + "&v5=" + um[i].textContent + "&v6=" + lote[i].value.toUpperCase() + "&v7=" + centro[i].textContent + "&v8=" + cl[i].textContent + "&v9=" + lm[i].value + "&v10=" + ee[i].value + "&v11=" + ped[i].value + "&v12=" + pos[i].value + "&v13=" + ancho[i].value + "&v14=" + op;
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
                if (i == mat.length - 1) {
//                    guardaCabecera2();
                    Print_PT();
                    ocultarVentana('ventaPM01', '');
//                    $('#LimPantalla').trigger('click');
//                    updateFolio();
                    validarLlenado();
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
        var send = "&ORDEN=" + $("#OrdFab").val() 
                + "&acc=" + acc 
                + "&MATERIAL=" + $("#tdMat0").text() 
                + "&DESCRIPCION=" + encodeURIComponent($("#tdDes0").text()) 
                + "&LOTE=" + $("#bxLote0").val().toUpperCase()
                + "&CLIENTE=" + $('#lblTextoLargo3').html()
                + "&CANTIDAD=" + $("#bxcnt0").val() 
                + "&OPERACION=" + $("#tdOpr0").text() 
                + "&SAM=" + folio101 
                + "&CENTRO=" + $("#tdCtr0").text() 
                + "&UM=" + $("#tdUM0").text()
                + "&ANCHO=" + $("#bxanc0").val().replace("+", "%2b");
        $.ajax({
            async: false,
            type: 'GET',
            url: "PeticionNotificacionesOrdenesSAMPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: send,
            success: function (data) {
                alert(data);
            }
        });
    }
}
function motivoRechazo() {
    if (document.getElementById("OrdFab").disabled == true) {
        var ckOpe = document.getElementsByName("ckOperPP");
        for (i = 0; i < ckOpe.length; i++) {
            if (ckOpe[i].checked) {
                if ($("#opeClavCon" + ckOpe[i].value).text() == "PP03") {
                    mostrarVentana('VentanaModalRechazo');
                    var theHandle = document.getElementById('handle3');
                    var theRoot = document.getElementById('VentanaModalRechazo');
                    Drag.init(theHandle, theRoot);
                    getMotivosRC();
                } else {
                    $('#msg').html("Operación no valida");
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', 'images/advertencia.PNG');
                    var BE = document.createElement('audio');
                    BE.src = 'audio/saperror.wav';
                    BE.play();
                }
            }
        }

    } else {
        $('#OrdFab').focus();
        $('#OrdFab').css('background-image', 'none');
        $('#msg').html("No se ha iniciado ninguna actividad");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }
}

function addPos() {
    var CheckBx = document.getElementsByName('ckMovMer');
    if (CheckBx.length > 1) {
        for (var i = 0; i < CheckBx.length; i++)
        {
            if (CheckBx[i].checked)
            {
                AgregaPos(CheckBx[i].value);
            }
        }
    }
//    var table = document.getElementById("TabBody");
//
//    var rowCount = table.rows.length;
//    var row = table.insertRow(rowCount-1);
//
//    var colCount = table.rows[0].cells.length;
//
//    for (var i = 0; i < colCount; i++) {
//
//        var newcell = row.insertCell(i);
//
//        newcell.innerHTML = table.rows[0].cells[i].innerHTML;
//        
//    }
//    table.rows[rowCount-1].cells[1].style.display = "none";
}

function AgregaPos(pos)
{
    var descripcion = document.getElementById("tdDes" + pos).textContent;
    var numoper = document.getElementById("tdOpr" + pos).textContent;
    var material = document.getElementById("tdMat" + pos).textContent;
    var txtmat = document.getElementById("tddmt" + pos).textContent;
    var cantidad2 = document.getElementById("bxcnt" + pos).value;
    var cantidad = document.getElementById("bxcntT" + pos).value;
    var poslista = document.getElementById("bxposM" + pos).value;
    var stockesp = document.getElementById("bxEE" + pos).value;
    var pedido = document.getElementById("bxNped" + pos).value;
    var posicion = document.getElementById("bxNpos" + pos).value;
    var unidadM = document.getElementById("tdUM" + pos).textContent;
    var centro = document.getElementById("tdCtr" + pos).textContent;
    var clmov = document.getElementById("tdCmov" + pos).textContent;

    if (clmov != "101")
    {
        var r1 = document.getElementsByName('ckMovMer');
        var ck = r1.length;
        var no = parseInt(ck) - 1;
        var i = parseInt(r1[no].value) + 1;

        var table = document.getElementById("TabBody");
        var row = table.insertRow(r1.length);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);
        var cell9 = row.insertCell(8);
        var cell10 = row.insertCell(9);
        var cell11 = row.insertCell(10);
        var cell12 = row.insertCell(11);
        var cell13 = row.insertCell(12);

        cell1.innerHTML = "<td><input type=\"checkbox\" name=\"ckMovMer\" value=\"" + i + "\"></td>";
        cell2.innerHTML = "<label id=\"tdDes" + i + "\">" + descripcion + "</label>";
        cell3.innerHTML = "<label id=\"tdOpr" + i + "\">" + numoper + "</label>";
        cell4.innerHTML = "<label name=\"tdMaterial\" id=\"tdMat" + i + "\">" + material + "</label>";
        cell5.innerHTML = "<label id=\"tddmt" + i + "\">" + txtmat + "</label>";
        cell6.innerHTML = "<input type=\"text\" class=\"bxMed\" id=\"bxcnt" + i + "\" name=\"bxcantidad\" maxlength=\"11\" onfocus=\"btnloteHide()\" onblur=\"this.value = checkDecc(this.value, 3);ajustaCantidades(" + i + ");\" value=\"" + cantidad2 + "\">"
                + "<input hidden type=\"text\" id=\"bxcntT" + i + "\" name=\"bxcantidadT\" value=\"" + cantidad + "\">"
                + "<input hidden type=\"text\" id=\"bxposM" + i + "\" name=\"bxlistaM\" value=\"" + poslista + "\">"
                + "<input hidden type=\"text\" id=\"bxEE" + i + "\" name=\"bxinvEE\" value=\"" + stockesp + "\">"
                + "<input hidden type=\"text\" id=\"bxNped" + i + "\" name=\"bxNped\" value=\"" + pedido + "\">"
                + "<input hidden type=\"text\" id=\"bxNpos" + i + "\" name=\"bxNpos\" value=\"" + posicion + "\"></td>";
        cell7.innerHTML = "<label name=\"tdUnM\" id=\"tdUM" + i + "\">" + unidadM + "</label>";
        cell8.innerHTML = "<label name=\"tdCentro\" id=\"tdCtr" + i + "\">" + centro + "</label>";
        cell9.innerHTML = "1400";
        cell10.innerHTML = "<input type=\"text\" class=\"bxMed\" id=\"bxLote" + i + "\" name=\"bxlote\" style=\"text-transform: uppercase;\" maxlength=\"10\" onfocus=\"btnloteShow(" + i + ")\">";
        cell11.innerHTML = "<button id=\"btnLot" + i + "\" class='BtnMatchIcon' name=\"btnShowLot\" onclick=\"btnLoteMatch(" + i + ")\"  hidden></button>";
        cell12.innerHTML = "<input type=\"text\" class=\"bxMed\" id=\"bxanc" + i + "\" disabled name=\"bxancho\" maxlength=\"10\" onfocus=\"btnloteHide()\">";
        cell13.innerHTML = "<label name=\"tdClaseM\" id=\"tdCmov" + i + "\">" + clmov + "</label>";
        table.rows[r1.length - 1].cells[1].style.display = "none";
        sujetoLote();
    }
}

function ValidaRechazo() {
    if ($("#bxcntRechazo").val() == "") {
        $("#bxcntRechazo").focus();
        $('#msg').html("Cantidad obligatoria");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
        return;
    }
    var ban = false;
    var ckOpe = document.getElementsByName("ckRechazoIT");
    for (i = 0; i < ckOpe.length; i++) {
        if (ckOpe[i].checked) {
            ban = true;
            if (parseFloat(document.getElementById("bxcntRechazo").value) < parseFloat(document.getElementById("cntBuena").value)) {
                var tx1 = parseFloat($("#cntMala").val()) + parseFloat($("#bxcntRechazo").val());
                var tx2 = parseFloat($("#cntBuena").val()) - parseFloat($("#bxcntRechazo").val());
                $("#cntBuena").val(tx2.toFixed(3));
                $("#cntMala").val(tx1.toFixed(3));
                ocultarVentana('VentanaModalRechazo', '');
                $("#secMala").show();
            } else {
                $("#bxcntRechazo").focus();
                $('#msg').html("Cantidad no valida");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', 'images/advertencia.PNG');
                var BE = document.createElement('audio');
                BE.src = 'audio/saperror.wav';
                BE.play();
            }
        }
    }
    if (!ban) {
        $('#msg').html("Seleccione una opción");
        var icon = $('#iconmsg');
        icon.show();
        icon.attr('src', 'images/advertencia.PNG');
        var BE = document.createElement('audio');
        BE.src = 'audio/saperror.wav';
        BE.play();
    }
}
function getFechaInicio(pos) {
    var acc = "getFechaI";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc + "&v2=" + $("#opeNumOpe" + pos).text();
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#bxFechaInicio").val(data);
        }
    });
}
function getActividades(puesto, pos) {
    var acc = "getActividades";
    var fechaInicio = $("#bxFechaInicio").val();
    var f = new Date();
    var fechaFin = f.getHours() + ":" + f.getMinutes() + ":" + f.getSeconds();

    var startTime = moment(fechaInicio, "HH:mm:ss");
    var endTime = moment(fechaFin, "HH:mm:ss");

    var result = endTime.diff(startTime, 'minutes') / 60;



    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionNotificarTiemposPP',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&v1=" + puesto,
        success: function (data) {
            var n = data;
            $("#lblAct1").html(n[0]);
            $("#lblAct2").html(n[1]);
            $("#lblAct3").html(n[2]);
            $("#lblAct4").html(n[3]);
            $("#lblAct5").html(n[4]);
            $("#lblAct6").html(n[5]);
            if (n[6] == "X") {
                $('#bxAct1').prop('disabled', true);
                $('#bxAct1').val("");
                $('#bxActUM1').val("");
            } else {
                $('#bxAct1').prop('disabled', false);
                $('#bxAct1').val($("#opeCantrc" + pos).text());
                $('#bxActUM1').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct1').prop('disabled', true);
                    $('#bxAct1').val(result.toFixed(3));
                }
            }
            if (n[7] == "X") {
                $('#bxAct2').prop('disabled', true);
                $('#bxAct2').val("");
                $('#bxActUM2').val("");
            } else {
                $('#bxAct2').prop('disabled', false);
                $('#bxAct2').val($("#opeCantrc" + pos).text());
                $('#bxActUM2').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct2').prop('disabled', true);
                    $('#bxAct2').val(result.toFixed(3));
                }
            }
            if (n[8] == "X") {
                $('#bxAct3').prop('disabled', true);
                $('#bxAct3').val("");
                $('#bxActUM3').val("");
            } else {
                $('#bxAct3').prop('disabled', false);
                $('#bxAct3').val($("#opeCantrc" + pos).text());
                $('#bxActUM3').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct3').prop('disabled', true);
                    $('#bxAct3').val(result.toFixed(3));
                }
            }
            if (n[9] == "X") {
                $('#bxAct4').prop('disabled', true);
                $('#bxAct4').val("");
                $('#bxActUM4').val("");
            } else {
                $('#bxAct4').prop('disabled', false);
                $('#bxAct4').val($("#opeCantrc" + pos).text());
                $('#bxActUM4').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct4').prop('disabled', true);
                    $('#bxAct4').val(result.toFixed(3));
                }
            }
            if (n[10] == "X") {
                $('#bxAct5').prop('disabled', true);
                $('#bxAct5').val("");
                $('#bxActUM5').val("");
            } else {
                $('#bxAct5').prop('disabled', false);
                $('#bxAct5').val($("#opeCantrc" + pos).text());
                $('#bxActUM5').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct5').prop('disabled', true);
                    $('#bxAct5').val(result.toFixed(3));
                }
            }
            if (n[11] == "X") {
                $('#bxAct6').prop('disabled', true);
                $('#bxAct6').val("");
                $('#bxActUM6').val("");
            } else {
                $('#bxAct6').prop('disabled', false);
                $('#bxAct6').val($("#opeCantrc" + pos).text());
                $('#bxActUM6').val($("#opeUMrc" + pos).text());
                if ($("#opeCtr" + pos).text() == "1000") {
                    $('#bxAct6').prop('disabled', true);
                    $('#bxAct6').val(result.toFixed(3));
                }
            }
        }
    });
}
function finTiempos() {
    if (document.getElementById("bxAct1").disabled == false) {
        if (document.getElementById("bxAct1").value.length < 1) {
            $('#bxAct1').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    if (document.getElementById("bxAct2").disabled == false) {
        if (document.getElementById("bxAct2").value.length < 1) {
            $('#bxAct2').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    if (document.getElementById("bxAct3").disabled == false) {
        if (document.getElementById("bxAct3").value.length < 1) {
            $('#bxAct3').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    if (document.getElementById("bxAct4").disabled == false) {
        if (document.getElementById("bxAct4").value.length < 1) {
            $('#bxAct4').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    if (document.getElementById("bxAct5").disabled == false) {
        if (document.getElementById("bxAct5").value.length < 1) {
            $('#bxAct5').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    if (document.getElementById("bxAct6").disabled == false) {
        if (document.getElementById("bxAct6").value.length < 1) {
            $('#bxAct6').focus();
            $('#msg').html("Cantidad obligatoria");
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', 'images/advertencia.PNG');
            var BE = document.createElement('audio');
            BE.src = 'audio/saperror.wav';
            BE.play();
            return;
        }
    }
    var ckOpe = document.getElementsByName("ckOperPP");
    for (x = 0; x < ckOpe.length; x++) {
        if (ckOpe[x].checked) {
            switch ($("#opeClavCon" + ckOpe[x].value).text()) {
                case "PP03":
                    ocultarVentana('VentanaModalActividades', '');
                    pp1prt3FORSAMPP($("#OrdFab").val());
                    mostrarventabs("ventaPM01");
                    var theHandle = document.getElementById("handlePM01");
                    var theRoot = document.getElementById("ventaPM01");
                    Drag.init(theHandle, theRoot);
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpoCld');
                    fisrtChild();
//                        ajustaCantidades(0);
                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                    sujetoLote();
                    obtenerLote();
                    break;
                case "PP01":
                    validarLlenado();
                    break;
            }
        }
    }

}
function getUmOpe() {
    var acc = "getUMoper";

    var send = "&v1=" + $("#OrdFab").val() + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#lblUM").text(data);
        }
    });
}
function getMotivosRC() {
    var acc = "getMotivosRC";
    var op;
    var ckOpe = document.getElementsByName("ckOperPP");
    for (w = 0; w < ckOpe.length; w++) {
        if (ckOpe[w].checked) {
            op = $("#opeCtr" + ckOpe[w].value).text();
        }
    }
    var send = "&v1=" + op + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificarTiemposPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#bkRechazos").html(data);
        }
    });
}

function getCtrUsr() {
    var acc = "getCentroUsr";
    var send = "&v1=" + $("#NoPers").val() + "&acc=" + acc;
    $.ajax({
        async: false,
        type: 'GET',
        url: "PeticionNotificacionesOrdenesSAMPP",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: send,
        success: function (data) {
            $("#centroUsr").val(data);
        }
    });
}