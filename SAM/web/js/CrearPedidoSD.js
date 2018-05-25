$(document).ready(function () {
    CargarVendedorInicial();
    $('#iconmsg').hide();
    MostrarFolio();
    $('#fechaPrecio').val(GetfechaActual());
    $('#textoventasMat').hide();
    startTime();
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#cancelar').click(function () {
        location.reload();
    });
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
    var inputs = [
        $('#pedido'),
        $('#solicitante'),
        $('#destinatario'),
        $('#orgVentas'),
        $('#CanalDis'),
        $('#Sector'),
        $('#refcliente'),
        $('#CreadoPor'),
        $('#fechaEntrega'),
        $('#ClasePedido'),
        $('#txtClasePedido'),
        $('#txtSolicitante'),
        $('#txtDestMcia'),
        $('#txtAreaVentas'),
        $('#OficinaVentas'),
        $('#txtOficinaVentas'),
        $('#GpoVendedores'),
        $('#txtGpoVended'),
        $('#fechaPrecio'),
        $('#textoCabec')
    ];
    var matchs = [
        $('#matchSolicitante'),
        $('#matchDestMecia'),
        $('#matchOrgVentas'),
        $('#matchcanalDis'),
        $('#matchSector'),
        $('#matchFechaentrega'),
        $('#matchClasePedido'),
        $('#matchpoficinaVentas'),
        $('#matchGpoVendedores')
    ];
    $.each(inputs, function (i, v) {
        switch (i) {
            case 0:     ///// Pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 1:    ///// Solicitante
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(0);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            CargarCliente(v.val().trim());
                            CargarDesRelac(v.val());
                        } else {
                            $('#solicitante').val("");
                            $('#solicitante').css('background-image', 'url(images/necesario.PNG)');
                            $('#destinatario').css('background-image', 'url(images/necesario.PNG)');
                            $('#destinatario').val("");
                            $('#txtDestMcia').val("");
                            $('#txtSolicitante').val("");
                            $('#orgVentas').val("");
                            $('#CanalDis').val("");
                            $('#Sector').val("");
                            $('#txtAreaVentas').val("");
                            $('#pedido').focus();
                        }
                    }
                    if (tecla == 8) {
                        return false;
                    }
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 2:   ///// Destinatario Mcia.
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(1);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        $('#txtDestMcia').val("");
                        if ($('#solicitante').val().length > 0) {
                            if (v.val().length > 0) {
                                var n = new Array();
                                n = validarInterlocutores();
                                if (n[0] == null || n[0] == "") {
                                    $('#destinatario').val("");
                                    $('#txtDestMcia').val("");
                                    ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
                                } else {
                                    $('#destinatario').val(n[0]);
                                    $('#txtDestMcia').val(n[1]);
                                    borramsg();
                                }
                                //ObtenerDescripcion(v.val().trim(), 'C', 'destinatario', 'txtDestMcia');
                            }
                        } else {
                            $('#solicitante').focus();
                            ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
                            v.val("");
                        }
                    }
                    if (tecla == 8) {
                        return false;
                    }
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 3:   ///// Org Ventas
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(2);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 4:   ///// Canal Dist.
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(3);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 5:   ///// Sector
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(4);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 6:  ///// Ref Cliente
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(-1);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                break;
            case 7:  ///// Creado por
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 8:  ///// Fecha entrega
                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(5);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
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
            case 9:  ///// Clase pedido
//                v.css('background-image', 'url(images/necesario.PNG)');
                v.focus(function () {
                    v.css('background-image', 'none');
                    checarPosiMa(6);
                });
                v.blur(function () {
                    if (v.val().length > 0) {
                        v.css('background-image', 'none');
                    } else {
                        v.css('background-image', 'url(images/necesario.PNG)');
                    }
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            ObtenerDescripcion(v.val().trim(), 'P', 'ClasePedido', 'txtClasePedido');
                        }
                    }
                    if (tecla == 8) {
                        return false;
                    }
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 10:  ///// Texto Clase pedido
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 11:  ///// Texto Solicitante
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 12:  ///// Texto Dest. Mcia.
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 13:  ///// Texto Area Ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 14:  ///// Oficina Ventas
                v.focus(function () {
                    checarPosiMa(7);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            ObtenerDescripcion(v.val().trim(), 'O', 'OficinaVentas', 'txtOficinaVentas');
                        }
                    }
                    if (tecla == 8) {
                        return false;
                    }
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 15:  ///// Texto Oficina Ventas
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 16:  ///// Gpo Vendedores
                v.focus(function () {
                    checarPosiMa(8);
                });
                v.keypress(function (e) {
                    var tecla = (document).all ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (v.val().length > 0) {
                            ObtenerDescripcion(v.val().trim(), 'G', 'GpoVendedores', 'txtGpoVended');
                        }
                    }
                    if (tecla == 8) {
                        return false;
                    }
                    patron = /[0-9a-zA-ZñÑ]/;
                    te = String.fromCharCode(tecla);
                    return patron.test(te);
                });
                break;
            case 17:  ///// Txt Gpo Vendedores
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 18:  ///// fecha Precio
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;
            case 19:  ///// Texto Cabecera
                v.focus(function () {
                    checarPosiMa(-1);
                });
                break;

        }
    });
    $.each(matchs, function (i, v) {
        v.hide();
        switch (i) {
            case 0:
                v.click(function () {
                    $('#Tipodeudor').val('solicitante');
                    $('#BusCliente').val("");
                    $('#BusCliente').prop('disabled', false);
                    mostrarVentanaModal('VentanaModalCliente', 'handle9', 'BusCliente');
                });
                break;
            case 1:
                v.click(function () {
                    var soli = $('#solicitante');
                    if (soli.val().trim().length > 0) {
                        $('#Tipodeudor').val('destinatario');
                        $('#BusCliente').val(soli.val().trim());
                        $('#BusCliente').prop('disabled', true);
                        mostrarVentanaModal('VentanaModalCliente', 'handle9', 'BusCliente');
                    } else {
                        ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
                        soli.focus();
                    }
                });
                break;
            case 2:
                v.click(function () {
                    ConsultaOrgVentas();
                });
                break;
            case 3:
                v.click(function () {
                    ConsultaCanalDis();
                });
                break;
            case 4:
                v.click(function () {
                    ConsultaSector();
                });
                break;
            case 5:
                v.click(function () {
                    CerrarCalendario();
                    OpenCalendario("fechaEntrega");
                });
                break;
            case 6:
                v.click(function () {
                    ConsultaClasePedido();
                });
                break;
            case 7:
                v.click(function () {
                    ConsultaOficinaVentas();
                });
                break;
            case 8:
                v.click(function () {
                    mostrarVentanaModal('VentanaModalGrpoVend', 'handle7', 'Busgpovend');
                });
                break;
        }

    });
    function checarPosiMa(index) {
        $.each(matchs, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
    $('#CerraMCMateriales').click(function () {
        var pos = $('#postextpos').val();
        var idElem = 'tdMater' + pos;
        ocultarVentanaSimple('VentanaModalMateriales', idElem);
    });
    $('#CerraMCMateriales2').click(function () {
        var pos = $('#postextpos').val();
        var idElem = 'tdMater' + pos;
        ocultarVentanaSimple('VentanaModalMateriales', idElem);
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#CerraMCPedido').click(function () {
        ocultarVentanaSimple('VentanaModalClasePedido', 'ClasePedido');
    });
    $('#CerrarMCOrgVenta').click(function () {
        ocultarVentanaSimple('VentanaModalOrgVentas', 'orgVentas');
    });
    $('#CerrarMCCanalDist').click(function () {
        ocultarVentanaSimple('VentanaModalCanalDist', 'CanalDis');
    });
    $('#CerrarMCSector').click(function () {
        ocultarVentanaSimple('VentanaModalSector', 'Sector');
    });
    $('#CerrarMCOficinaVentas').click(function () {
        ocultarVentanaSimple('VentanaModalOficinaVentas', 'OficinaVentas');
    });
    $('#CerraMCGpoVendedores').click(function () {
        ocultarVentana('VentanaModalGrpoVend', 'BuscarParGpovend', 'ConsultaTablaGpoVend', 'GpoVendedores');
    });
    $('#CerraMCGpoVendedores2').click(function () {
        ocultarVentana('VentanaModalGrpoVend', 'BuscarParGpovend', 'ConsultaTablaGpoVend', 'GpoVendedores');
    });
    $('#CerraMCDeudores').click(function () {
        var IdDeudor = $('#Tipodeudor').val();
        ocultarVentana('VentanaModalCliente', 'BuscarParDeudores', 'ConsultaTablaDeudores', IdDeudor);
    });
    $('#CerraMCDeudores2').click(function () {
        var IdDeudor = $('#Tipodeudor').val();
        ocultarVentana('VentanaModalCliente', 'BuscarParDeudores', 'ConsultaTablaDeudores', IdDeudor);
    });
    $('#cerrarmodaTxtCab').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextli').hide();
    });
    $('#cerrarmodaTxtCab2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#textoCabecera').val('');
        $('#VentanaModalTextli').hide();
    });
    $('#cerrarmodaTxtPos').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextPos').hide();
    });
    $('#cerrarmodaTxtPos2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var pos = $('#postextpos').val();
        $('#textoposTemp' + pos).val('');
        $('#VentanaModalTextPos').hide();
    });
    $('#Cerraok').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextli').hide();
    });
    $('#CerraokPos').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalTextPos').hide();
        var pos = $('#postextpos').val();
        var tex1t = $('#textoPos').val();
        $('#textoposTemp' + pos).val(tex1t);


    });

    ///// Match clientes

    $('#BusCliente').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaClientes();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusNombre').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaClientes();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax9').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaClientes();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    $('#retClien').click(function () {
        $('#BuscarParDeudores').css('display', 'block');
        $('#ConsultaTablaDeudores').css('display', 'none');
    });

    $('#OkDeuudores').click(function () {
        ConsultaClientes();
    });


    ///// Match Materiales

    $('#BusMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#BusdesMaterial').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax8').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMateriales();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    $('#reMateri').click(function () {
        $('#BuscarParMateriales').css('display', 'block');
        $('#ConsultaTablaMateriales').css('display', 'none');
    });
    $('#OkMateriales').click(function () {
        ConsultaMateriales();
    });

    ///// Match Grupo vendedores

    $('#Busgpovend').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#Busdenomgvend').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        patron = /[0-9a-zA-ZÑñ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax7').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaGpoVendedores();
        }
        if (tecla == 8) {
            return false;
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#retGpoVend').click(function () {
        $('#BuscarParGpovend').css('display', 'block');
        $('#ConsultaTablaGpoVend').css('display', 'none');
    });
    $('#OkGpoVendedor').click(function () {
        ConsultaGpoVendedores();
    });
    $('#matchDescCabecera').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalTextli');
        var ancho = 600;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handleTxtCab");
        var theRoot = document.getElementById("VentanaModalTextli");
        Drag.init(theHandle, theRoot);
    });
    $('#CerrarMCUnidadMedida').click(function () {
        ocultarVentanaSimpleGrid('VentanaModalUMedida', 'tdUmedi');
    });
    $('#SelectTipoTexto').change(function () {
        var optiontext = $('#SelectTipoTexto').val();
        if (optiontext == '0') {
            $('#textoventasMat').show();
            $('#textoEmbarqu').hide();
        }
        if (optiontext == '1') {
            $('#textoventasMat').hide();
            $('#textoEmbarqu').show();
        }

    });
    $('#AgregarFilas').click(function () {
        AgregarFilaTabla();
    });
    $('#BorrarFilas').click(function () {
        EliminarFilas();
    });
    $('#guardar').click(function () {
        borramsg();
        var clase = $('#ClasePedido').val();
        if (clase.length == 0) {
            ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
            $('#ClasePedido').focus();
            return;
        }
        if ($('#solicitante').val().length == 0) {
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
            $('#solicitante').focus();
            return;
        }
        if ($('#destinatario').val().length == 0) {
            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            $('#destinatario').focus();
            return;
        }
        if ($('#refcliente').val().length == 0) {
            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
            $('#refcliente').focus();
            return;
        }
        if ($('#fechaEntrega').val().length == 0) {
            ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
            $('#fechaEntrega').focus();
            return;
        }
        if ($('#orgVentas').val().length == 0 && $('#CanalDis').val().length == 0 && $('#Sector').val().length == 0) {
            ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
            $('#solicitante').focus();
            return;
        }
        var n = new Array();
        n = validarInterlocutores();
        if (n[0] == null || n[0] == "") {
            $('#destinatario').val("");
            $('#txtDestMcia').val("");
            ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        $('#destinatario').val(n[0]);
        $('#txtDestMcia').val(n[1]);
//        var n = validarInterlocutores();
//        if (n[0] === "") {
//            $('#destinatario').focus();
//            ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav");
//            return;
//        }
        if (clase.length > 0) {
            ObtenerDescripcion(clase.trim(), 'P', 'ClasePedido', 'txtClasePedido');
        }
        if ($('#txtClasePedido').val().length == 0) {
            $('#ClasePedido').focus();
            ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if ($('#OficinaVentas').val().length > 0) {
            ObtenerDescripcion($('#OficinaVentas').val().trim(), 'O', 'OficinaVentas', 'txtOficinaVentas');
        }
        if ($('#txtOficinaVentas').val().length == 0 && $('#OficinaVentas').val().length > 0) {
            $('#OficinaVentas').focus();
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if ($('#GpoVendedores').val().length > 0) {
            ObtenerDescripcion($('#GpoVendedores').val().trim(), 'G', 'GpoVendedores', 'txtGpoVended');
        }
        if ($('#txtGpoVended').val().length == 0 && $('#GpoVendedores').val().length > 0) {
            $('#GpoVendedores').focus();
            ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        Mats = document.getElementsByName("MaterTD");
        var a = 0;
        for (i = 0; i < Mats.length; i++) {
            if (!(Mats[i].value == null || Mats[i].value == "")) {
                a += 1;
            }
        }
        var cab = $('#textoCabecera').val();
        if (cab.length > 0) {
            GuardarTextoCab();
        }

        if (a > 0) {
            GuardarPosiciones();
        } else {
            GuardarCabecera();
        }

    });

});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
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
    myTableCb.style.width = val + 7 + "px";
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
function loadDoubleScroll(DobleSection, SecCuerpo, DobleContainer, TabBody) {
    $("#" + DobleSection).scroll(function () {
        $("#" + SecCuerpo).scrollTop($("#" + DobleSection).scrollTop());
    });
    $("#" + SecCuerpo).scroll(function () {
        $("#" + DobleSection).scrollTop($("#" + SecCuerpo).scrollTop());
    });
    document.getElementById(DobleContainer).style.height = document.getElementById(TabBody).offsetHeight + "px";
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}
function OpenCalendario(id) {
    $("#" + id).focus();
    $("#idDataFeee").val(id);
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
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function GetfechaActual() {
    var date = new Date();
    var mes = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
    var fecha = date.getDate() + "." + mes[date.getMonth()] + "." + date.getFullYear();
    return fecha;
}
function mostrarVentanaModal(id, handle, tipo)
{
    switch (tipo) {
        case "BusClaPed":
            $('#numAcMax5').val('500');
            $('#BusCPedDesc').val('');
            $('#BusClaPed').val('');
            break;
        case "Busgpovend":
            $('#numAcMax7').val('500');
            $('#Busdenomgvend').val('');
            $('#Busgpovend').val('');
            break;
        case "BusCliente":
            $('#numAcMax9').val('500');
            $('#BusNombre').val('');
            break;
    }
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
    if (tipo != "0") {
        $('#' + tipo).focus();
    }
}
function MostratVentanaModalSimple(ventana1, CargarDatos, data, tableScroll, fixedscroll, handle) {
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#' + ventana1);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventana1);
    Drag.init(theHandle, theRoot);
    $('#' + CargarDatos).html(data);
    document.getElementById(tableScroll).onscroll = function () {
        document.getElementById(fixedscroll).style.top = document.getElementById(tableScroll).scrollTop + 'px';
    };


}
function ocultarVentana(id, bp, ct, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    if (bp != "0") {
        $('#' + bp).css('display', 'block');
        $('#' + ct).css('display', 'none');
    }
    $('#' + obj).focus();
}
function ocultarVentanaSimple(id, obj)
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj).focus();
}
function SeleccionarData(dato, ventanamodal, obj, dato2, obj2)
{
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj).val(dato);
    $('#' + obj2).val(dato2);
    ocultarVentanaSimple(ventanamodal, obj);
}
function SeleccionarDataGrid(dato, ventanamodal, obj)
{
    var pos = $('#postextpos').val();
    borramsg();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + obj + pos).val(dato);
    ocultarVentanaSimple(ventanamodal, obj);
}
function SelectData(dato, idv, bp, ct, obj, des, um) {
    if (obj == "tdMater") {
        var pos = $('#postextpos').val();
        obj = "tdMater" + pos;
        $('#tdDescr' + pos).val(des);
        $('#tdUmedi' + pos).val(um);
    }
    borramsg();
    $('#' + obj).val(dato);
    ocultarVentana(idv, bp, ct, obj);
}
function SelectDataCli(dato, idv, bp, ct, obj) {
    if (obj == "tdMater") {
        var pos = $('#postextpos').val();
        obj = "tdMater" + pos;
    }
    if (obj == "solicitante") {
        $('#' + obj).val(dato);
        CargarCliente(dato);
        $('#BusCliente').prop('disabled', false);

    }
    if (obj == "destinatario") {
        $('#' + obj).val(dato);
        ObtenerDescripcion(dato, 'C', 'destinatario', 'txtDestMcia');
        $('#BusCliente').prop('disabled', false);
    }
    ocultarVentana(idv, bp, ct, obj);
}
function ConsultaOrgVentas() {
    var acc = "ConsultarOrgVentas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalOrgVentas', 'cargarDatosOrgVentas', data, 'table-scrollorgVentas', 'fixedYorgVentas', 'handle2');
            }
        }
    });
}
function ConsultaCanalDis() {
    var acc = "ConsultarCanalDis";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalCanalDist', 'cargarDatosCanalDist', data, 'table-scrollCanalDis', 'fixedYCanalDis', 'handle3');
            }
        }
    });
}
function ConsultaSector() {
    var acc = "ConsultarSector";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalSector', 'cargarDatosSector', data, 'table-scrollSector', 'fixedYSector', 'handle4');
            }
        }
    });
}
function ConsultaClasePedido() {
    var acc = "ConsultarClasePedido";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalClasePedido', 'cargarDatosClasePedido', data, 'table-scrollClaPed', 'fixedYClasPed', 'handle5');
            }
        }
    });
}

function ConsultaOficinaVentas() {
    var acc = "ConsultarOficinaVentas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostratVentanaModalSimple('VentanaModalOficinaVentas', 'cargarDatosOficinaVentas', data, 'table-scrollOficinaVentas', 'fixedYOficinaVentas', 'handle6');
            }
        }
    });
}
function ConsultaUnidadMedida(vm, h, p) {
    var acc = "ConsultarUnidadMedida";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostrarMatchGrid(vm, h, p);
                borramsg();
                var theHandle = document.getElementById(h);
                var theRoot = document.getElementById(vm);
                Drag.init(theHandle, theRoot);
                $('#cargarDatosUnidadMedida').html(data);
                document.getElementById("table-scrollOUnidadMedida").onscroll = function () {
                    document.getElementById("fixedYUnidadMedida").style.top = document.getElementById("table-scrollOUnidadMedida").scrollTop + 'px';
                };

            }
        }
    });
}
function ConsultaGpoVendedores() {
    var acc = "ConsultarGpoVendedores";
    var datos = "&GpoV=" + $('#Busgpovend').val() + "&DescripcionCPedido=" + encodeURIComponent($('#Busdenomgvend').val().trim()) + "&Ctd=" + $('#numAcMax7').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosGpoVendedor').html(data);
                $('#BuscarParGpovend').css('display', 'none');
                $('#ConsultaTablaGpoVend').css('display', 'block');
                document.getElementById('table-scrollGpoVendedor').onscroll = function () {
                    document.getElementById('fixedYGpoVendedor').style.top = document.getElementById('table-scrollGpoVendedor').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaClientes() {
    var tipodeu = $('#Tipodeudor').val();
    var vend = $('#GpoVendedores').val();
    var acc = "ConsultarClientes";
    var datos = "&Cliente=" + $('#BusCliente').val() + "&Nombre=" + encodeURIComponent($('#BusNombre').val().trim()) + "&Ctd=" + $('#numAcMax9').val() + "&tipo=" + tipodeu + "&Vendedor=" + vend;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosDeudodres').html(data);
                $('#BuscarParDeudores').css('display', 'none');
                $('#ConsultaTablaDeudores').css('display', 'block');
                document.getElementById('table-scrollDeudores').onscroll = function () {
                    document.getElementById('fixedYDeudores').style.top = document.getElementById('table-scrollDeudores').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function ConsultaMateriales() {
    var cli = $('#solicitante').val();
    var org = $('#orgVentas').val();
    var can = $('#CanalDis').val();
    var acc = "ConsultarMateriales";
    var datos = "&Material=" + $('#BusMaterial').val() + "&DescripcionCPedido=" + encodeURIComponent($('#BusdesMaterial').val().trim()) + "&Ctd=" + $('#numAcMax8').val() + "&Cliente=" + cli + "&org=" + org + "&canal=" + can;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $('#cargarDatosMateriales').html(data);
                $('#BuscarParMateriales').css('display', 'none');
                $('#ConsultaTablaMateriales').css('display', 'block');
                document.getElementById('table-scrollMateriales').onscroll = function () {
                    document.getElementById('fixedYMateriales').style.top = document.getElementById('table-scrollMateriales').scrollTop + 'px';
                };
                borramsg();
            }
        }
    });
}
function MostrarMatch(id, match, pos) {
    QuitarMatch();
    $('#' + id + pos).css('width', '80%');
    $('#' + match + pos).css('display', 'inline-block');
    if (id == 'tdMater') {
        $('#' + id + pos).keypress(function (e) {
            var tecla = (document).all ? e.keyCode : e.which;
            if (tecla == 13) {

                if ($('#' + id + pos).val().length > 0) {
                    ValidarMAterial($('#' + id + pos).val(), pos);
                }
            }
            patron = /[0-9a-zA-ZÑñ]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        });
    }
}

function QuitarMatch() {
    var inMat = document.getElementsByName("MaterTD");
    var inFec = document.getElementsByName("FecEnTD");
    var matchMat = document.getElementsByName('matchMaterial');
    var matchFec = document.getElementsByName('matchFecEnt');
    for (i = 0; i < inFec.length; i++) {
        inFec[i].style.width = '100%';
    }
    for (i = 0; i < inMat.length; i++) {
        inMat[i].style.width = '100%';
    }
    for (i = 0; i < matchMat.length; i++) {
        matchMat[i].style.display = 'none';
    }
    for (i = 0; i < matchFec.length; i++) {
        matchFec[i].style.display = 'none';
    }
}
function mostrarVentanaTextoPos(pos) {
    $('#postextpos').val(pos);
    QuitarMatch();
    if ($('#ClasePedido').val().length == 0) {
        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
        $('#ClasePedido').focus();
        return;
    }
    if ($('#solicitante').val().length == 0) {
        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
        $('#solicitante').focus();
        return;
    }
    if ($('#destinatario').val().length == 0) {
        ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
        $('#destinatario').focus();
        return;
    }
    if ($('#refcliente').val().length == 0) {
        ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
        $('#refcliente').focus();
        return;
    }
    if ($('#fechaEntrega').val().length == 0) {
        ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
        $('#fechaEntrega').focus();
        return;
    }
    if ($('#orgVentas').val().length == 0 && $('#CanalDis').val().length == 0 && $('#Sector').val().length == 0) {
        ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    var mater = $('#tdMater' + pos).val();
    if (mater == null || mater == "") {
        $('#tdMater' + pos).focus();
        ShowMsg(11, "images/advertencia.PNG", "audio/saperror.wav");
    } else {
        validarMaterial(pos);
    }
}

function MostrarMatchGridMateriales(VM, handle, pos) {
    CerrarCalendario();
    var clp = $('#ClasePedido');
    var cli = $('#solicitante');
    var ref = $('#refcliente');
    var fec = $('#fechaEntrega');
    var org = $('#orgVentas');
    var can = $('#CanalDis');
    if (clp.val().length == 0) {
        clp.focus();
        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (cli.val().length == 0) {
        cli.focus();
        ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (org.val().length == 0 && can.val().length == 0) {
        cli.focus();
        ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (ref.val().length == 0) {
        ref.focus();
        ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (fec.val().length == 0) {
        fec.focus();
        ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + VM);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    $('#BuscarParMateriales').css('display', 'block');
    $('#ConsultaTablaMateriales').css('display', 'none');
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(VM);
    Drag.init(theHandle, theRoot);
    $('#postextpos').val(pos);
    $('#numAcMax8').val('500');
    $('#BusMaterial').val('');
    $('#BusMaterial').focus();
    $('#BusdesMaterial').val('');

}
function MostrarMatchGrid(VM, handle, pos) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + VM);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(VM);
    Drag.init(theHandle, theRoot);
    $('#postextpos').val(pos);
}
function ocultarVentanaSimpleGrid(id, obj)
{
    var pos = $('#postextpos').val();
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#' + id).hide();
    $('#' + obj + pos).focus();
}
function CargarCliente(sol) {
    var acc = "CargarCliente";
    var vend = $('#GpoVendedores').val();
    var datos = "&Cliente=" + sol + "&Vendedor=" + vend;
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                $('#solicitante').val("");
                $('#solicitante').css('background-image', 'url(images/necesario.PNG)');
                $('#destinatario').css('background-image', 'url(images/necesario.PNG)');
                $('#destinatario').val("");
                $('#txtDestMcia').val("");
                $('#txtSolicitante').val("");
                $('#orgVentas').val("");
                $('#CanalDis').val("");
                $('#Sector').val("");
                $('#txtAreaVentas').val("");
                $('#pedido').focus();
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                $('#solicitante').css('background-image', 'none');
                $('#txtSolicitante').val(data[1]);
                $('#orgVentas').val(data[2]);
                $('#CanalDis').val(data[3]);
                $('#Sector').val(data[4]);
                $('#txtAreaVentas').val(data[5]);
                CargarDesRelac(sol);
            }
        }
    });
}
function ObtenerDescripcion(variable, tipo, id1, id2) {
    var acc = "Cargardenominacion";
    var datos = "&variable=" + variable + "&tipo=" + tipo;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == null || data == "") {
                $('#' + id1).val("");
                $('#' + id2).val("");
            } else {
                $('#' + id2).val(data);
            }
        }
    });
}
function ValidarMAterial(material, pos) {
    if ($('#ClasePedido').val().length == 0) {
        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
        $('#ClasePedido').focus();
        return;
    }
    if ($('#solicitante').val().length == 0) {
        ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
        $('#solicitante').focus();
        return;
    }
    if ($('#destinatario').val().length == 0) {
        ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
        $('#destinatario').focus();
        return;
    }
    if ($('#refcliente').val().length == 0) {
        ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
        $('#refcliente').focus();
        return;
    }
    if ($('#fechaEntrega').val().length == 0) {
        ShowMsg(7, "images/advertencia.PNG", "audio/saperror.wav");
        $('#fechaEntrega').focus();
        return;
    }
    if ($('#orgVentas').val().length == 0 && $('#CanalDis').val().length == 0 && $('#Sector').val().length == 0) {
        ShowMsg(9, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    var clie = $('#solicitante').val();
    var org = $('#orgVentas').val();
    var can = $('#CanalDis').val();
    var sec = $('#Sector').val();
    var acc = "ValidarMaterial";
    var datos = "&Material=" + material + "&org=" + org + "&canal=" + can + "&Cliente=" + clie;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                $('#tdDescr' + pos).focus();
                $('#tdDescr' + pos).val("");
                $('#tdUmedi' + pos).val("");
                ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav", '', material, org, can);
            } else {
                //  CargartextoEmbarque(material, org, sec, pos);
                $('#tdDescr' + pos).val(data[1]);
                $('#tdUmedi' + pos).val(data[2]);
                $('#tdCanti' + pos).focus();
                borramsg();
                return;
            }
        }
    });
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
                    borramsg();
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    borramsg();
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                borramsg();
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
            mensajesValidacionInco(FINC);
            return "";
        }
    } else {
        borramsg();
        return "";
    }

}
function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode;
    patron = /[0-9.]/;
    te = String.fromCharCode(key);
    return patron.test(te);
}
function validarMaterial(pos) {
    var material = $('#tdMater' + pos).val();
    var clie = $('#solicitante').val();
    var org = $('#orgVentas').val();
    var can = $('#CanalDis').val();
    var sec = $('#Sector').val();
    var acc = "ValidarMaterial";
    var datos = "&Material=" + material + "&org=" + org + "&canal=" + can + "&Cliente=" + clie;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data == 0) {
                $('#tdDescr' + pos).focus();
                $('#tdDescr' + pos).val("");
                $('#tdUmedi' + pos).val("");
                ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav", '', material, org, can);
            } else {
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                var ventana = $('#VentanaModalTextPos');
                var ancho = 600;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                borramsg();
                var theHandle = document.getElementById("handleTxtPos");
                var theRoot = document.getElementById("VentanaModalTextPos");
                Drag.init(theHandle, theRoot);
                var valorpostext = $('#textoposTemp' + pos).val();
                $('#textoPos').val(valorpostext);
                $('#textoEmbarqu').val("");
                CargartextoEmbarque(material, org, sec, pos);
                borramsg();
                return;
            }
        }
    });
}
function CargartextoEmbarque(material, org, sec, pos) {
    var acc = "ObtenerTextoEmba";
    var datos = "&Material=" + material + "&org=" + org + "&sector=" + sec;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            $('#textoposEmbaTemp' + pos).val(data);
            $('#textoEmbarq').val(data);
//            $('#tdDescr' + pos).val(data);
        }
    });

}
function CargarDesRelac(soli) {
    var acc = "CargarDesRelac";
    var datos = "&Cliente=" + soli;
    $.ajax({
        async: false,
        dataType: 'json',
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            $('#destinatario').val(data[0]);
            $('#destinatario').css('background-image', 'none');
            $('#txtDestMcia').val(data[1]);
        }
    });

}


function AgregarFilaTabla() {
    $('#temporalro').remove();
    var ch = document.getElementsByName("Cehckbx");
    var valor = ch[ch.length - 1].value;
    var i = parseInt(valor) + 1;
    var newfiladata = "<tr id=\"tr" + i + "\">"
            + "<td><input type=\"checkbox\" name=\"Cehckbx\" value=\"" + i + "\"/></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"tdPosic" + i + "\" name=\"PosicTD\" onfocus=\"QuitarMatch()\" readonly/></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"tdMater" + i + "\" name=\"MaterTD\" onfocus=\"MostrarMatch('tdMater', 'matchtdmaterial', '" + i + "')\" maxlength=\"40\"/><button id=\"matchtdmaterial" + i + "\" onclick=\"MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '" + i + "');\" name=\"matchMaterial\" class=\"BtnMatchIconGrid\"></button></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"tdDescr" + i + "\" name=\"DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "<td><input type=\"text\" class=\"tdSMatch\" id=\"tdCanti" + i + "\" name=\"CantiTD\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"tdFecEn" + i + "\" name=\"FecEnTD\" onfocus=\"MostrarMatch('tdFecEn', 'matchtdFecEntre', '" + i + "')\" readOnly/><button id=\"matchtdFecEntre" + i + "\" onclick=\"MostrarCalendarioGrid('tdFecEn" + i + "')\" name=\"matchFecEnt\" class='BtnMatchIconGrid'></button></td>"
            + "<td><input type=\"text\" class=\"tdCMatch\" id=\"tdUmedi" + i + "\" name=\"UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>"
            + "<td><button id=\"textoPosicion" + i + "\" name=\"matchTxtPos\" class=\"BtnMatchIconDescri\" onclick=\"mostrarVentanaTextoPos(" + i + ")\"></button><textarea hidden style=\"resize: none;\" id=\"textoposTemp" + i + "\"></textarea><textarea hidden style=\"resize: none;\" id=\"textoposEmbaTemp" + i + "\"></textarea></td>"
            + "</tr>";
    var tempro = "<tr class=\"ocultar\" id=\"temporalro\"><td>00</td><td>00000000</td><td>0000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000</td><td>00000000000000000000000000</td><td>000000000000000000</td><td>0000000000000</td><td>000000000000</td></tr>"

    $('#TabBody2').append(newfiladata);
    $('#TabBody2').append(tempro);
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
}

function EliminarFilas() {
    var table = document.getElementById("TabBody2");
    var chk = document.getElementsByName("Cehckbx");
    var tam = chk.length;
    var i = tam;
    while (i >= 0) {
        if (i == 0) {
            break;
        } else {
            var o = parseInt(i) - 1;
            if (chk[o].checked)
            {
                table.deleteRow(o);
                i--;
            } else {
                i--;
            }

        }
    }
    loadDoubleScroll("DobleSection2", "SecCuerpo2", "DobleContainer2", "TabBody2");
    AjustarCabecera('TabHead2', 'TabBody2', 3, 'SecCuerpo2');
}

function validarInterlocutores() {
    var retu = new Array();
    var acc = "ValidarInterlocutor";
    var datos = "&solicitante=" + $('#solicitante').val() + "&destinatario=" + $('#destinatario').val().trim();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            retu = data;
        }
    });
    return retu;
}
function GuardarCabecera() {
    var clasePedi = $('#ClasePedido').val();
    var orgVentas = $('#orgVentas').val();
    var canalDist = $('#CanalDis').val();
    var sector = $('#Sector').val();
    var grupoVend = $('#GpoVendedores').val();
    var oficinaVe = $('#OficinaVentas').val();
    var fechaEntr = $('#fechaEntrega').val();
    var fechaPrec = $('#fechaPrecio').val();
    var refClient = $('#refcliente').val();
    var usuario = $('#CreadoPor').val();
    var solicitante = $('#solicitante').val();
    var destinatario = $('#destinatario').val();
    var datos = "&CLASE=" + clasePedi.toUpperCase() + "&ORGVE=" + orgVentas + "&CANAL=" + canalDist + "&SECTO=" + sector + "&GRUPV=" + grupoVend + "&OFICV=" + oficinaVe + "&FECHE=" + fechaEntr + "&FECHP=" + fechaPrec + "&REFCL=" + refClient + "&USUAR=" + usuario + "&SOLIC=" + solicitante + "&DESTI=" + destinatario;
    var acc = "Guardarcabacera";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            ActualizaFolio();
        }
    });
}
function ValidateMate(material, org, can, sec) {
    var clie = $('#solicitante').val();
    var ret = "0";
    var acc = "ValidarMaterial";
    var datos = "&Material=" + material + "&org=" + org + "&canal=" + can + "&Cliente=" + clie;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
            if (data != 0) {
                ret = "1";
            }
        }
    });
    return ret;
}
function GuardarPosiciones() {
    var org = $('#orgVentas').val();
    var cadi = $('#CanalDis').val();
    var sec = $('#Sector').val();
    var ch = document.getElementsByName("Cehckbx");
    var mat = document.getElementsByName("MaterTD");
    var des = document.getElementsByName("DesciTD");
    var ume = document.getElementsByName("UMediTD");
    var can = document.getElementsByName("CantiTD");
    var fec = document.getElementsByName("FecEnTD");
    var pos = 0;
    for (i = 0; i < ch.length; i++) {
        if (mat[i].value.length > 0) {
            var d = ValidateMate(mat[i].value, org, can, sec);
            if (d == "0") {
                ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav", '', mat[i].value, org, cadi);
                mat[i].focus();
                return;
            }
            if (ume[i].value.length == 0) {
                ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
                mat[i].focus();
                return;
            }
            if (can[i].value == "0.000" || can[i].value.length == 0  ) {
                can[i].focus();
                ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
            if (fec[i].value.length == 0) {
                fec[i].focus();
                ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
            savePos(mat[i].value, des[i].value, ume[i].value, can[i].value, pos,fec[i].value);
            GuardarTextoPos(pos, i);
            pos = pos + 1;
        }
    }
    $('#guardar').prop("disabled", true);
    GuardarCabecera();
}

function savePos(mat, des, um, can, i, fe) {
    var usuario = $('#CreadoPor').val();
    var acc = "GuardarPosiciones";
    var datos = "&MATER=" + mat + "&DESCR=" + des + "&UNIDA=" + um + "&CANTI=" + can + "&POSIC=" + i + "&USUAR=" + usuario + "&FECEP=" + fe;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + datos,
        success: function (data) {
        }
    });
}
function ActualizaFolio()
{
    var acc = "ActaulizarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionPedidoSDCrear',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {
            window.location.href = "CrearPedidoSD.jsp?FolioPV=" + data;
        }
    });
}
function GuardarTextoCab() {
    var usuario = $('#CreadoPor').val();
    var txtCa = $('#textoCabecera').val();
    var txtO = txtCa.replace(/'/g, "´");
    var tam = txtO.length;
    var lim = tam / 132;
    var l = Math.ceil(lim);
    for (var i = 0; i < l; i++) {
        var d = i * 132;
        no = txtO.substr(d, 132);
        var acc = "GuardarTextCab";
        var fila = i + 1;
        var enviar = "&FILA=" + fila + "&TEXTOCAB=" + encodeURIComponent(no) + "&USUAR=" + usuario;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionPedidoSDCrear',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
            }

        });
    }
}
function GuardarTextoPos(pos, a) {
    var usuario = $('#CreadoPor').val();
    var txtpos = $('#textoposTemp' + a).val();
    var txtO = txtpos.replace(/'/g, "´");
    var tam = txtO.length;
    var lim = tam / 132;
    var l = Math.ceil(lim);
    for (var i = 0; i < l; i++) {
        var d = i * 132;
        no = txtO.substr(d, 132);
        var acc = "GuardarTextPos";
        var fila = i + 1;
        var enviar = "&POS=" + pos + "&FILA=" + fila + "&TEXTPOS=" + encodeURIComponent(no) + "&USUAR=" + usuario;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionPedidoSDCrear',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + enviar,
            success: function (data) {
            }

        });
    }
}
function MostrarCalendarioGrid(id) {
    ocultarVentanaSimple('VentanaModalMateriales', "");
    QuitarMatch();
    $("#" + id).focus();
    $("#idDataFeee").val(id);
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
}
