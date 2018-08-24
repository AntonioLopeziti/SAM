///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
// 
$(document).ready(function () {
    $('#iconmsg').hide();
    startTime();
    var material = $('#material');
    var almacen = $('#almacen');
    var centro = $('#centro');
    var arr = [
        material,
        almacen,
        centro
    ];
    $('#ejecutar').click(function () {
        if (material.val().length > 0) {
            if (validarDato("material", "ValidarMaterial", "&material=" + material.val()) == false) {
                msgMatch(2, "images/advertencia.PNG", "audio/saperror.wav", material.val().toUpperCase());
                material.val('');
                material.focus();
                return;
            }
        }
        if (almacen.val().length > 0) {
            if (validarDato("almacen", "ValidarAlmacen", "&almacen=" + almacen.val()) == false) {
                msgMatch(5, "images/advertencia.PNG", "audio/saperror.wav", almacen.val().toUpperCase());
                almacen.val('');
                almacen.focus();
                return;
            }
        }
        if (centro.val().length > 0) {
            if (validarDato("centro", "ValidarCentro", "&centro=" + centro.val()) == false) {
                msgMatch(6, "images/advertencia.PNG", "audio/saperror.wav", centro.val().toUpperCase());
                centro.val('');
                centro.focus();
                return;
            }
        }
         ValidarQuery();
    });
    function ValidarQuery() {
        var par = "&material=" + material.val() + "&almacen=" + almacen.val() + "&centro=" + centro.val();
        var acc = "ValidarQuery";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionReporteStock',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    msgMatch(8, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    window.location.href = "VistaStockMaterial.jsp?Accion=CargarTablaReserva" + par;
                }
            }
        });
    }
    var arrm = [
        $('#match1'),
        $('#match3'),
        $('#match4')
    ];
    $.each(arr, function (i, v) {
        switch (i) {
            case 0:
                v.click(function () {
                    VerPosMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("material", "ValidarMaterial", "&material=" + v.val()) == true) {
                                borrarmsg();
                            } else {
                                msgMatch(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZÑñ]/;
                    return patron.test(te);
                });
                break;
            case 1:
                v.click(function () {
                    VerPosMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("almacen", "ValidarAlmacen", "&almacen=" + v.val()) == true) {
                                borrarmsg();
                            } else {
                                msgMatch(5, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZÑñ]/;
                    return patron.test(te);
                });
                break;
            case 2:
                v.click(function () {
                    VerPosMa(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("centro", "ValidarCentro", "&centro=" + v.val()) == true) {
                                borrarmsg();
                            } else {
                                msgMatch(6, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZÑñ]/;
                    return patron.test(te);
                });
                break;
        }
    });
    $.each(arrm, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    MostrarVentanaModal('VentanaModalMaterial', 'handle', 'materialbus', 'numAcMax1');
                });
                break;
            case 1:
                v.click(function () {
                    ConsultarAlmacen();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultarCentro();
                });
                break;
        }
    });
    function VerPosMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
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
    $('#materialbus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#DescripcionBus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
    });
    $('#numAcMax1').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okMaterial').click(function () {
        ConsultaMateriales();
    });
    $('#BusGArtiulos').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGarticulo();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusDenGArt').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGarticulo();
        }

    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGarticulo();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okgarticulo').click(function () {
        ConsultaGarticulo();
    });
    $('#btnRegresaMaterial').click(function () {
        $('#BuscarParamMaterial').show();
        $('#ConsultaTablaMaterial').hide();
    });
    $('#retoGArt').click(function () {
        $('#BuscarParamGrupoArticulo').show();
        $('#ConsultaTablaGArticulo').hide();
    });
    $('#OCULMat').click(function () {
        ocultarVentana("material", "VentanaModalMaterial", "BuscarParamMaterial", "ConsultaTablaMaterial", 'namemate');
    });
    $('#OCULMat2').click(function () {
        ocultarVentana("material", "VentanaModalMaterial", "BuscarParamMaterial", "ConsultaTablaMaterial", 'namemate');
    });
    $('#OCULGArt').click(function () {
        ocultarVentana("grupoarticulo", "VentanaModalGrupoArticulo", "BuscarParamGrupoArticulo", "ConsultaTablaGArticulo", 'namegart');
    });
    $('#OCULGArt2').click(function () {
        ocultarVentana("grupoarticulo", "VentanaModalGrupoArticulo", "BuscarParamGrupoArticulo", "ConsultaTablaGArticulo", 'namegart');
    });
    $('#OCULAlmac').click(function () {
        ocultarVentana("almacen", "VentanaModalAlmacen", "", "", '');
    });
    $('#OCULCentro').click(function () {
        ocultarVentana("centro", "VentanaModalCentro", "", "", '');
    });
    $('#OCULLote').click(function () {
        ocultarVentana("lote", "VentanaModalLote", "", "", '');
    });
    function ConsultaMateriales() {
        var acc = "ConsultaMateriales";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&v1=" + $('#materialbus').val() + "&v2=" + $('#DescripcionBus').val() + "&v3=" + $('#numAcMax1').val(),
            success: function (data) {
                if (data == 0) {
                    msgMatch(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParamMaterial').hide();
                    $('#ConsultaTablaMaterial').show();
                    $('#CargarDatos').html(data);
                    fnc('table-scrollMaterial', 'fixedYMaterial');
                    borrarmsg();
                }
            }
        });
    }
    function ConsultarAlmacen() {
        var acc = "ConsultarAlmacen";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    msgMatch(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostrarVentanaModal('VentanaModalAlmacen', 'handle3', '', '');
                    $('#cargarDatoAlmacen').html(data);
                    fnc('table-scrollAlm', 'fixedYAlm');
                    borrarmsg();
                }
            }
        });
    }
    function ConsultarCentro() {
        var acc = "ConsultarCentro";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    msgMatch(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostrarVentanaModal('VentanaModalCentro', 'handle4', '', '');
                    $('#CargarDatosCentro').html(data);
                    fnc('table-scrollcentro', 'fixedYcentro');
                    borrarmsg();
                }
            }
        });
    }
    function validarDato(id, acc, param) {
        var ban = false;
        var campo = $('#' + id);
        if (campo.val().length > 0) {
            $.ajax({
                type: 'GET',
                async: false,
                url: 'peticionInventario',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + param,
                success: function (data) {
                    if (data != 0) {
                        ban = true;
                    }
                }
            });
        }
        return ban;
    }

});
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
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function Select(dato, id, ven, b, c, name) {
    $('#' + id).val(dato);
    ocultarVentana(id, ven, b, c, name);
}
function ocultarVentana(id, ven, b, c, name) {
    $('#' + ven).css('display', 'none');
    $('#' + id).focus();
    if (b != "") {
        $('#' + b).show();
        $('#' + c).hide();
        var na = document.getElementsByName(name);
        for (i = 0; i < na.length; i++) {
            na[i].value = "";
        }
    }
}
function inval() {
    msgMatch(0, 'images/advertencia.PNG', 'audio/saperror.wav');
}