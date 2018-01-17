/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#ejecutar').click(function () {
        if ($('#material').val().length > 0) {
            if (validarDato("material", "ValidarMaterial", "&material=" + $('#material').val()) == false) {
                mensajesValidacionInco(2, "images/advertencia.PNG", "audio/saperror.wav", $('#material').val().toUpperCase());
                $('#material').val('');
                $('#material').focus();
                return;
            }
        }
        if ($('#material2').val().length > 0) {
            if (validarDato("material2", "ValidarMaterial", "&material=" + $('#material2').val()) == false) {
                mensajesValidacionInco(2, "images/advertencia.PNG", "audio/saperror.wav", $('#material2').val().toUpperCase());
                $('#material2').val('');
                $('#material2').focus();
                return;
            }
        }
        if ($('#centro').val().length > 0) {
            if (validarDato("centro", "ValidarCentro", "&centro=" + $('#centro').val()) == false) {
                mensajesValidacionInco(3, "images/advertencia.PNG", "audio/saperror.wav", $('#centro').val().toUpperCase());
                $('#centro').val('');
                $('#centro').focus();
                return;
            }
        }
        if ($('#almacen').val().length > 0) {
            if (validarDato("almacen", "ValidarAlmacen", "&almacen=" + $('#almacen').val()) == false) {
                mensajesValidacionInco(4, "images/advertencia.PNG", "audio/saperror.wav", $('#almacen').val().toUpperCase());
                $('#almacen').val('');
                $('#almacen').focus();
                return;
            }
        }
        if ($('#proveedor').val().length > 0) {
            if (validarDato("proveedor", "ValidarProveedor", "&proveedor=" + $('#proveedor').val()) == false) {
                mensajesValidacionInco(5, "images/advertencia.PNG", "audio/saperror.wav", $('#proveedor').val().toUpperCase());
                $('#proveedor').val('');
                $('#proveedor').focus();
                return;
            }
        }
        if ($('#clase').val().length > 0) {
            if (validarDato("clase", "ValidarClase", "&clase=" + $('#clase').val()) == false) {
                mensajesValidacionInco(6, "images/advertencia.PNG", "audio/saperror.wav", $('#clase').val().toUpperCase());
                $('#clase').val('');
                $('#clase').focus();
                return;
            }
        }
        ValidarQuery();
    });
    function ValidarQuery() {
        var mat = $('#material').val().trim();
        var mat2 = $('#material2').val().trim();
        var cen = $('#centro').val().trim();
        var alm = $('#almacen').val().trim();
        var cla = $('#clase').val().trim();
        var pro = $('#proveedor').val().trim();
        var fecha = $('#fecCon').val().trim();
        var acc = "ValidarQuery";
        var param = "&material=" + mat + "&material2=" + mat2 + "&centro=" + cen;
        var par = param + "&almacen=" + alm + "&proveedor=" + pro + "&clase=" + cla + "&fecha=" + fecha;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(7, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    window.location.href = "VisualizarAllDocumentosLstMaterial.jsp?Accion=CargarTabla" + par;
                }
            }
        });
    }
    $('#iconmsg').hide();
    var arr = [
        $('#material'),
        $('#centro'),
        $('#almacen'),
        $('#proveedor'),
        $('#clase'),
        $('#fecCon'),
        $('#numAcMax'),
        $('#material2')
    ];
    var arrm = [
        $('#match1'),
        $('#match2'),
        $('#match3'),
        $('#match4'),
        $('#match5'),
        $('#match6'),
        $('#match7')
    ];
    $.each(arr, function (i, v) {
        switch (i) {
            case 0:
                v.focus(function () {
                    checarPosiMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("material", "ValidarMaterial", "&material=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZñÑ]/;
                    return patron.test(te);
                });
                break;
            case 1:
                v.focus(function () {
                    checarPosiMa(1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("centro", "ValidarCentro", "&centro=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(3, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZñÑ]/;
                    return patron.test(te);
                });
                break;
            case 2:
                v.focus(function () {
                    checarPosiMa(2);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("almacen", "ValidarAlmacen", "&almacen=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(4, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }

                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZñÑ]/;
                    return patron.test(te);
                });
                break;
            case 3:
                v.focus(function () {
                    checarPosiMa(3);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("proveedor", "ValidarProveedor", "&proveedor=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(5, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZñÑ]/;
                    return patron.test(te);
                });
                break;
            case 4:
                v.focus(function () {
                    checarPosiMa(4);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("clase", "ValidarClase", "&clase=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(6, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9]/;
                    return patron.test(te);
                });
                break;
            case 5:
                v.focus(function () {
                    checarPosiMa(6);
                });
                v.keypress(function (e) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 8) {
                        return true;
                    }
                    patron = /^\d{4}\-\d{2}\\d{2}$/;
                    tecla_final = String.fromCharCode(tecla);
                    return patron.test(tecla_final);
                });
                break;
            case 6:
                v.focus(function () {
                    checarPosiMa(-1);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9]/;
                    return patron.test(te);
                });
                break;
            case 7:
                v.focus(function () {
                    checarPosiMa(5);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            if (validarDato("material", "ValidarMaterial", "&material=" + v.val()) == true) {
                                borramsg();
                            } else {
                                mensajesValidacionInco(2, "images/advertencia.PNG", "audio/saperror.wav", v.val().toUpperCase());
                                v.val('');
                                v.focus();
                            }
                        }
                    }
                    if (tecla == 32) {
                        return false;
                    }
                    te = String.fromCharCode(tecla);
                    patron = /[0-9a-zA-ZñÑ]/;
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
                    MostrarVentanaModal('VentanaModalMaterial', 'handle', 'SearchMaterial', 'numAcMax1');
                });
                break;
            case 1:
                v.click(function () {
                    ConsultarCentro();
                });
                break;
            case 2:
                v.click(function () {
                    ConsultarAlmacen();
                });
                break;
            case 3:
                v.click(function () {
                    MostrarVentanaModal('VentanaModalProveedor', 'handle5', 'searchPAcre', 'numAcMaxP');
                });
                break;
            case 4:
                v.click(function () {
                    ConsultarClase();
                });
                break;
            case 5:
                v.click(function () {
                    MostrarVentanaModal('VentanaModalMaterial2', 'handle2', 'SearchMaterial2', 'numAcMax2');
                });
                break;
            case 6:
                v.click(function () {
                    $("#fecCon").focus();
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapsnd05.wav";
                    BE.play();
                    var ancho = 500;
                    var alto = 750;
                    var x = (screen.width / 2) - (ancho / 2);
                    var y = (screen.height / 2) - (alto / 2);
                    var ventana = $('#Calenndar');
                    ventana.css({top: y + "px", left: x + "px"});
                    ventana.css('display', 'block');
                    borramsg();
                    var theHandle = document.getElementById("handlecalendar");
                    var theRoot = document.getElementById("Calenndar");
                    Drag.init(theHandle, theRoot);
                    $('#datapicker').datepicker().show();
                });
                break;
        }
    });
    function checarPosiMa(index) {
        $.each(arrm, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#SearchMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#searchTMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
    });
    $('#numAcMax1').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okMaterial').click(function () {
        ConsultarMaterial();
    });
    $('#SearchMaterial2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#searchTMaterial2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial2();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial2();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okMaterial2').click(function () {
        ConsultarMaterial2();
    });
    $('#searchPAcre').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarProverdor();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#SearchPNombre').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarProverdor();
        }
    });
    $('#numAcMaxP').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarProverdor();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#okProveedor').click(function () {
        ConsultarProverdor();
    });

    function ConsultarMaterial() {
        var acc = "ConsultarMateriales";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&v1=" + $('#SearchMaterial').val() + "&v2=" + $('#searchTMaterial').val() + "&v3=" + $('#numAcMax1').val(),
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParamMaterial').hide();
                    $('#ConsultaTablaMaterial').show();
                    $('#cargarDatosMaterial').html(data);
                    fnc('table-scrollMaterial', 'fixedYMaterial');
                    borramsg();
                }
            }
        });
    }
    function ConsultarMaterial2() {
        var acc = "ConsultarMateriales2";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&v1=" + $('#SearchMaterial2').val() + "&v2=" + $('#searchTMaterial2').val() + "&v3=" + $('#numAcMax2').val(),
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParamMaterial2').hide();
                    $('#ConsultaTablaMaterial2').show();
                    $('#cargarDatosMaterial2').html(data);
                    fnc('table-scrollMaterial2', 'fixedYMaterial2');
                    borramsg();
                }
            }
        });
    }
    function ConsultarCentro() {
        var acc = "ConsultarCentro";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostrarVentanaModal('VentanaModalCentro', 'handle3', '', '');
                    $('#cargarDatosCentro').html(data);
                    fnc('table-scrollCentro', 'fixedYCentro');
                    borramsg();
                }
            }
        });
    }
    function ConsultarAlmacen() {
        var acc = "ConsultarAlmacen";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostrarVentanaModal('VentanaModalAlmacen', 'handle4', '', '');
                    $('#cargarDatosAlmacen').html(data);
                    fnc('table-scrollAlmacen', 'fixedYAlmacen');
                    borramsg();
                }
            }
        });
    }
    function ConsultarProverdor() {
        var acc = "ConsultarProveedor";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&v1=" + $('#searchPAcre').val() + "&v2=" + $('#SearchPNombre').val() + "&v3=" + $('#numAcMaxP').val(),
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    $('#BuscarParamProveedor').hide();
                    $('#ConsultaTablaProveedor').show();
                    $('#cargarDatosProveedor').html(data);
                    fnc('table-scrollProveedor', 'fixedYProveedor');
                    borramsg();
                }
            }
        });
    }
    function ConsultarClase() {
        var acc = "ConsultarClase";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (data) {
                if (data == 0) {
                    mensajesValidacionInco(1, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostrarVentanaModal('VentanaModalClaseM', 'handle6', '', '');
                    $('#cargarDatosClaseM').html(data);
                    fnc('table-scrollClaseM', 'fixedYClaseM');
                    borramsg();
                }
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
        borramsg();
        var theHandle = document.getElementById(handle);
        var theRoot = document.getElementById(id);
        Drag.init(theHandle, theRoot);
        if (obj != "") {
            $('#' + obj).focus();
            $('#' + obj2).val('500');
        }
    }
    $('#retorMat').click(function () {
        $('#BuscarParamMaterial').show();
        $('#ConsultaTablaMaterial').hide();
    });
    $('#retorMat2').click(function () {
        $('#BuscarParamMaterial2').show();
        $('#ConsultaTablaMaterial2').hide();
    });
    $('#RetProv').click(function () {
        $('#BuscarParamProveedor').show();
        $('#ConsultaTablaProveedor').hide();
    });

    $('#OCUMaterial1').click(function () {
        ocultarVentana('material', 'VentanaModalMaterial', 'BuscarParamMaterial', 'ConsultaTablaMaterial', 'matename');
    });
    $('#OCUMaterial2').click(function () {
        ocultarVentana('material', 'VentanaModalMaterial', 'BuscarParamMaterial', 'ConsultaTablaMaterial', 'matename');
    });
    $('#OCUMaterial3').click(function () {
        ocultarVentana('material2', 'VentanaModalMaterial2', 'BuscarParamMaterial2', 'ConsultaTablaMaterial2', 'matename2');
    });
    $('#OCUMaterial4').click(function () {
        ocultarVentana('material2', 'VentanaModalMaterial2', 'BuscarParamMaterial2', 'ConsultaTablaMaterial2', 'matename2');
    });
    $('#OCULProv').click(function () {
        ocultarVentana('proveedor', 'VentanaModalProveedor', 'BuscarParamProveedor', 'ConsultaTablaProveedor', 'nameprov');
    });
    $('#OCULProv2').click(function () {
        ocultarVentana('proveedor', 'VentanaModalProveedor', 'BuscarParamProveedor', 'ConsultaTablaProveedor', 'nameprov');
    });
    $('#OCULCentro').click(function () {
        ocultarVentana('centro', 'VentanaModalCentro', '', '', '');
    });
    $('#OCULAlmac').click(function () {
        ocultarVentana('almacen', 'VentanaModalAlmacen', '', '', '');
    });
    $('#OCULClase').click(function () {
        ocultarVentana('clase', 'VentanaModalClaseM', '', '', '');
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
}
function validarDato(id, acc, param) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'peticionListaMateriales',
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
function borramsg() {
    $("#iconmsg").hide();
    $("#msg").html("");
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
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
function SelectData(dato, id, ven, b, c, name) {
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
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
    $('#fecCon').focus();
}
