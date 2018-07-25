
$(document).ready(function () {
    startTime();
    CargarEdicion();
    $("#iconmsg").css("visibility", "hidden");
    $('#regresar1').click(function (){
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'ModificarAvisoAcceso.jsp');
    });
    $('#finalizar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#cietec').click(function () {
        var st = $('#statusSis').val();
        if ($('#menser').val().length > 0) {
            ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (st === "MECE") {
            ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
        } else {
            var Aviso = $('#Notificacion_CA').val();
            var acc = "ConsultarCierreTecnico";
            $.ajax({
                async: false,
                type: "GET",
                url: "PeticionModuloModificarAvisos",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + "&Aviso=" + Aviso,
                success: function (datas) {
                    if (datas == 1) {
                        ShowMsg(6, "images/advertencia.PNG", "audio/saperror.wav");
                    } else {
                        MostarVentanaModal("VentanaModalCANTEC", "handleCTEC");
                        today = new Date();
                        di = today.getDate();
                        me = today.getMonth();
                        an = today.getFullYear();
                        n = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        h = checkTime(n);
                        m = checkTime(m);
                        s = checkTime(s);
                        dia = checkTime(di);
                        $('#hora_conc').val(h + ":" + m + ":" + s);
                        $('#fecha_conc').val(di + "." + obtenermes(me) + "." + an);
                    }
                }
            });
        }
    });
    $('#CerrarCETEC').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalCANTEC').hide();
        $('#fecha_conc').val("");
        $('#hora_conc').val("");
        $('#matcfechaCetec').css('display', 'none');
        $('#matchoraCetec').css('display', 'none');
    });
    $('#CerrarVenatCetec').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalCANTEC').hide();
        $('#fecha_conc').val("");
        $('#hora_conc').val("");
        $('#matcfechaCetec').css('display', 'none');
    });
    $('#fecha_conc').focus(function () {
        $('#matcfechaCetec').css('display', 'inline-block');
    });
    $('#fecha_conc').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 13) {
            return false;
        }
        if (tecla == 46) {
            return false;
        }
        if (tecla == 32) {
            return false;
        }
        patron = /^\d{4}\-\d{2}\\d{2}$/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
    $('#hora_conc').focus(function () {
        $('#matcfechaCetec').css('display', 'none');
    });
    $('#matcfechaCetec').click(function () {
        OpenCalendario("fecha_conc");
    });
    $('#matchoraCetec').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ancho = 500;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        var ventana = $('#VentHora');
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handleho");
        var theRoot = document.getElementById("VentHora");
        Drag.init(theHandle, theRoot);
    });
    $('#CerraCalendar1').click(function () {
        CerrarCalendario();
    });
    $('#calenimg').click(function () {
        CerrarCalendario();
    });
    $('#BUorav').click(function () {
        if ($('#menser').val().length > 0) {
            ShowMsg(10, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        $('#IVOclo').val("CPM1");
        MostarVentanaModal("VentanaModalORDenAV", "handleOrdenAV");
        $('#okORDAV').focus();
        $('#IVOcp').val($('#CentroPlaninificacion_CA').val());
        $('#IVOptr').val($('#puestotrabajo_CA').val());
        $('#IVOctr').val($('#puestotrabajo2_CA').val());
    });
    $('#okCONAVI').click(function () {
        var fecha = $('#fecha_conc');
        var hora = $('#hora_conc');
        if (validarFecha(fecha.val()) == false) {
            ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (fecha.val().length == 0) {
            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
            fecha.focus();
            return;
        }
        if (fecha.val().length < 10) {
            ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
            fecha.focus();
            return;
        }
        if (hora.val().length == 0) {
            ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
            hora.focus();
            return;
        }
        var Aviso = $('#Notificacion_CA').val();
        var acc = "InsertarCierreTecnico";
        var tip = $('#TipoAviso').val();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + tip + "&FechaCT=" + fecha.val() + "&HoraCT=" + hora.val(),
            success: function (datas) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                $('#VentanaModalCANTEC').hide();
                $('#matcfechaCetec').css('display', 'none');
                $('#matchoraCetec').css('display', 'none');
                CerrarCalendario();
                if (datas == 1) {
                    if (tip === "2") {
                        $('#statusSis').val("MECE");
                    }
                    ShowMsgWindow(0, "images/infoicono.PNG", "audio/sapsnd05.wav");
                } else {
                    ShowMsgWindow(1, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    });
    $('#CerrarVentanaMsg1').click(function () {
        location.reload();
    });
    $('#CloMsg').click(function () {
        location.reload();
    });
    ///////ORDEN
    $('#CerrarVentaOrd2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalORDenAV').hide();
        $('#IVOclo').val("");
        $('#IVOcp').val("");
        $('#IVOdi').val("");
        $('#IVOptr').val("");
        $('#IVOctr').val("");
        $('#BVOclo').css('display', 'none');
        $('#BVOcp').css('display', 'none');
    });
    $('#CerrarVentaOrd').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        $('#VentanaModalORDenAV').hide();
        $('#IVOclo').val("");
        $('#IVOcp').val("");
        $('#IVOdi').val("");
        $('#IVOptr').val("");
        $('#IVOctr').val("");
        $('#BVOclo').css('display', 'none');
        $('#BVOcp').css('display', 'none');
    });
    $('#IVOclo').focus(function () {
        $('#BVOclo').css('display', 'inline-block');
        $('#BVOcp').css('display', 'none');
        $('#BVPto').css('display', 'none');
    });
    $('#IVOclo').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#IVOclo').val().length > 0) {
                if (validarDato("IVOclo", "CL")) {
                    borramsg();
                } else {
                    $('#IVOclo').val("");
                    ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-ZñÑ]/;
        return patro.test(te);
    });
    $('#IVOcp').focus(function () {
        $('#BVOclo').css('display', 'none');
        $('#BVPto').css('display', 'none');
        $('#BVOcp').css('display', 'inline-block');
    });
    $('#IVOcp').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#IVOcp').val().length > 0) {
                if (validarDato("IVOcp", "CE")) {
                    borramsg();
                } else {
                    $('#IVOcp').val("");
                    ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-ZñÑ]/;
        return patro.test(te);
    });
    $('#IVOdi').focus(function () {
        $('#BVOclo').css('display', 'none');
        $('#BVPto').css('display', 'none');
        $('#BVOcp').css('display', 'none');
    });
    $('#IVOdi').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-ZñÑ]/;
        return patro.test(te);
    });
    $('#IVOptr').focus(function () {
        $('#BVOclo').css('display', 'none');
        $('#BVPto').css('display', 'inline-block');
        $('#BVOcp').css('display', 'none');
    });
    $('#IVOptr').blur(function () {
        CargarNombresData("Q", $('#IVOptr').val());
    });
    $('#IVOptr').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#IVOptr').val().length > 0) {
                if (validarDato("IVOptr", "PT")) {
                    borramsg();
                } else {
                    $('#IVOptr').val("");
                    ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-ZñÑ]/;
        return patro.test(te);
    });
    $('#CerraClaseMC').click(function () {
        $('#VentanaModalCLase').css('display', 'none');
        $('#IVOclo').focus();
    });
    $('#CerraCentroMC').click(function () {
        $('#VentanaModalCentro').css('display', 'none');
        $('#IVOcp').focus();
    });
    $('#CerraPtoOrdMC').click(function () {
        $('#VentanaModalPuestoOrd').css('display', 'none');
        $('#IVOptr').focus();
    });
    $('#BVOclo').click(function () {
        var acc = "ConsultaClaseOrden";
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (datas) {
                if (datas == 0) {
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostarVentanaModal("VentanaModalCLase", "handle2");
                    $('#DatosCLasOR').html(datas);
                    fnc('table-scrollClase', 'fixedYClase');
                    borramsg();
                }
            }
        });
    });
    $('#BVOcp').click(function () {
        var acc = "ConsultaCentro";
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (datas) {
                if (datas == 0) {
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostarVentanaModal("VentanaModalCentro", "handle3");
                    $('#DatosCentro').html(datas);
                    fnc('table-scrollCentro', 'fixedYCentro');
                    borramsg();
                }
            }
        });
    });
    $('#BVPto').click(function () {
        var acc = "ConsultaPuestoOrd";
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (datas) {
                if (datas == 0) {
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostarVentanaModal("VentanaModalPuestoOrd", "handle4");
                    $('#DatosPtoOrd').html(datas);
                    fnc('table-scrollPuestOrd', 'fixedYPuestOrd');
                    borramsg();
                }
            }
        });
    });
    $('#okORDAV').click(function () {
        var Clase = $("#IVOclo");
        var Centr = $("#IVOcp");
        var Puest = $("#IVOptr");
        var equip = $("#equipo_CA").val();
        var ubtec = $("#ubictec_CA").val();
        var folio = $("#Notificacion_CA").val();
        var tipAv = $("#TipoAviso").val();
        if (Clase.val().length > 0) {
            if (validarDato("IVOclo", "CL")) {
                borramsg();
            } else {
                Clase.val("");
                Clase.focus();
                ShowMsg(12, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        } else {
            Clase.focus();
            ShowMsg(15, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (Centr.val().length > 0) {
            if (validarDato("IVOcp", "CE")) {
                borramsg();
            } else {
                Centr.val("");
                Centr.focus();
                ShowMsg(13, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        } else {
            Centr.focus();
            ShowMsg(16, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (Puest.val().length > 0) {
            if (validarDato("IVOptr", "PT")) {
                borramsg();
            } else {
                Puest.val("");
                Puest.focus();
                ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
                return;
            }
        } else {
            Puest.focus();
            ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
        if (Clase.val().trim() == "CPM1" || Clase.val().trim() == "CPM2" || Clase.val().trim() == "CPM3" || Clase.val().trim() == "CPM4" || Clase.val().trim() == "CPM5" || Clase.val().trim() == "CPM6" || Clase.val().trim() == "CPM7" || Clase.val().trim() == "CPM8") {
            $(location).attr('href', 'CrearOrden.jsp?ClasO=' + Clase.val() + '&CenPl=' + Centr.val() + '&PueTr=' + Puest.val() + "&equipe=" + equip + "&ubicate=" + ubtec + "&folSA=" + folio + "&Tipo=" + tipAv);
        } else {
            ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
            return;
        }
    });
    $('#descripcionnotificacion_CA').focus(function () {
        $('#match_A1').css('display', 'none');
        $('#match_A2').css('display', 'none');
        $('#match_A3').css('display', 'none');
        $('#match_A4').css('display', 'none');
        $('#match_A5').css('display', 'none');
    });
    $('#ubictec_CA').focus(function () {
        $('#match_A1').css('display', 'inline-block');
        $('#match_A2').css('display', 'none');
        $('#match_A3').css('display', 'none');
        $('#match_A4').css('display', 'none');
        $('#match_A5').css('display', 'none');
    });
    $('#equipo_CA').focus(function () {
        $('#match_A1').css('display', 'none');
        $('#match_A2').css('display', 'inline-block');
        $('#match_A3').css('display', 'none');
        $('#match_A4').css('display', 'none');
        $('#match_A5').css('display', 'none');
    });
    $('#conjunto_CA').focus(function () {
        $('#match_A1').css('display', 'none');
        $('#match_A2').css('display', 'none');
        $('#match_A3').css('display', 'inline-block');
        $('#match_A4').css('display', 'none');
        $('#match_A5').css('display', 'none');
    });
    $('#GrpPlanificacion_CA').focus(function () {
        $('#match_A1').css('display', 'none');
        $('#match_A2').css('display', 'none');
        $('#match_A3').css('display', 'none');
        $('#match_A4').css('display', 'inline-block');
        $('#match_A5').css('display', 'none');
    });
    $('#puestotrabajo_CA').focus(function () {
        $('#match_A1').css('display', 'none');
        $('#match_A2').css('display', 'none');
        $('#match_A3').css('display', 'none');
        $('#match_A4').css('display', 'none');
        $('#match_A5').css('display', 'inline-block');
    });
    $('#GrpPlanificacion_CA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#GrpPlanificacion_CA').val().length > 0) {
                if (validarDato("GrpPlanificacion_CA", "GP")) {
                    borramsg();
                    CargarNombresData("G", $('#GrpPlanificacion_CA').val());
                } else {
                    $('#GrpPlanificacion_CA').val("");
                    $('#DenominacionGplan').html("");
                    ShowMsg(22, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                $('#GrpPlanificacion_CA').val("");
                $('#DenominacionGplan').html("");
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-Z]/;
        return patro.test(te);
    });
    $('#puestotrabajo_CA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#puestotrabajo_CA').val().length > 0) {
                if (validarDato("puestotrabajo_CA", "PT")) {
                    borramsg();
                    CargarNombresData("P", $('#puestotrabajo_CA').val());
                } else {
                    $('#puestotrabajo_CA').val("");
                    $('#DenominacionPuestoTrabajo_MAA').html("");
                    ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                $('#puestotrabajo_CA').val("");
                $('#DenominacionPuestoTrabajo_MAA').html("");
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-Z]/;
        return patro.test(te);
    });
    $('#ubictec_CA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#ubictec_CA').val().length > 0) {
                if (validarDato("ubictec_CA", "UB")) {
                    borramsg();
                    CargarNombresData("U", $('#ubictec_CA').val());
                } else {
                    $('#ubictec_CA').val("");
                    $('#DenominacionUbitec_MAA').val("");
                    ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                $('#DenominacionUbitec_MAA').val("");
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-Z]/;
        return patro.test(te);
    });
    $('#equipo_CA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#equipo_CA').val().length > 0) {
                if (validarDato("equipo_CA", "EQ")) {
                    borramsg();
                    CargarNombresData("E", $('#equipo_CA').val());
                    CargarDatosMaestroEquipo($('#equipo_CA').val());
                } else {
                    $('#equipo_CA').val("");
                    $('#DenominacionEquipo_MAA').val("");
                    ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                $('#DenominacionEquipo_MAA').val("");
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-Z]/;
        return patro.test(te);
    });
    $('#conjunto_CA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            if ($('#conjunto_CA').val().length > 0) {
                if (validarDato("conjunto_CA", "CO")) {
                    borramsg();
                    CargarNombresData("C", $('#conjunto_CA').val());
                } else {
                    $('#conjunto_CA').val("");
                    $('#DenominacionConjunto_MAA').val("");
                    ShowMsg(21, "images/advertencia.PNG", "audio/saperror.wav");
                }
            } else {
                $('#DenominacionConjunto_MAA').val("");
                borramsg();
            }
        }
        te = String.fromCharCode(tecla);
        patro = /[0-9a-zA-Z]/;
        return patro.test(te);
    });
    $('#match_A1').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalUbitec');
        var ancho = 600;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalUbitec");
        Drag.init(theHandle, theRoot);
        $('#BuscarParamUbi').show();
        $('#ConsultaTablaUbi').hide();
        $('#numAcMax').val("500");
        $('#Sociedad_MAA').val("");
        $('#Denominacion_MAA').val("");
        $('#ubitec_MAA').val("");
        $('#ubitec_MAA').focus();
    });
    $('#match_A2').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalEquipos');
        var ancho = 600;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalEquipos");
        Drag.init(theHandle, theRoot);
        $('#BuscarParamEquipo').show();
        $('#ConsultaTablaEquipo').hide();
        $('#numAcMax2').val("500");
        $('#DenominacionEquipoMatch_MAA').val("");
        $('#EquipoMatch_MAA').val("");
        $('#EquipoMatch_MAA').focus();
    });
    $('#match_A3').click(function () {
        var BE = document.createElement('audio');
        BE.src = "audio/sapsnd05.wav";
        BE.play();
        var ventana = $('#VentanaModalConjunto');
        var ancho = 600;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.css({top: y + "px", left: x + "px"});
        ventana.css('display', 'block');
        borramsg();
        var theHandle = document.getElementById("handle7");
        var theRoot = document.getElementById("VentanaModalConjunto");
        Drag.init(theHandle, theRoot);
        $('#BuscarParamConjutno').show();
        $('#ConsultaTablaConj').hide();
        $('#numAcMax3').val("500");
        $('#DenominacionEquipoMatch_MAA').val("");
        $('#MaterialDes_bus').val("");
        $('#Material_bus').focus();
    });
    $('#match_A4').click(function () {
        var acc = "ConsultaGrupoPlanificacion";
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (datas) {
                if (datas == 0) {
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostarVentanaModal("VentanaModalGrupoPlan", "handle8");
                    $('#CargarDatoGPla').html(datas);
                    fnc('table-scrollGPlan', 'fixedYGPlan');
                    borramsg();
                }
            }
        });
    });
    $('#match_A5').click(function () {
        var acc = "ConsultaPuesto";
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloModificarAvisos",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc,
            success: function (datas) {
                if (datas == 0) {
                    ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
                } else {
                    MostarVentanaModal("VentanaModalPuesto", "handle9");
                    $('#DatosPto').html(datas);
                    fnc('table-scrollPuest', 'fixedYPuest');
                    borramsg();
                }
            }
        });
    });
    $('#CerraPtoMC').click(function () {
        $('#VentanaModalPuesto').css('display', 'none');
    });
    $('#CerrarConjuntoMC').click(function () {
        $('#VentanaModalConjunto').css('display', 'none');
    });
    $('#CerrarConjuntoMC2').click(function () {
        $('#VentanaModalConjunto').css('display', 'none');
    });
    $('#CerrarUTecMC').click(function () {
        $('#VentanaModalUbitec').css('display', 'none');
    });
    $('#CerrarUTecMC2').click(function () {
        $('#VentanaModalUbitec').css('display', 'none');
    });
    $('#CerrarEquipoMC').click(function () {
        $('#VentanaModalEquipos').css('display', 'none');
    });
    $('#CerrarEquipoMC2').click(function () {
        $('#VentanaModalEquipos').css('display', 'none');
    });
    $('#CerraGPlaMC').click(function () {
        $('#VentanaModalGrupoPlan').css('display', 'none');
    });
    $('#CerrarMCGC').click(function () {
        $('#VentanaModalGrupoCodigos').css('display', 'none');
    });
    $('#EquipoMatch_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaEquipos();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#DenominacionEquipoMatch_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return true;
        }
        if (tecla == 13) {
            ConsultaEquipos();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaEquipos();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9]/;
        return patron.test(te);
    });
    $('#OKEquipo').click(function () {
        ConsultaEquipos();
    });
    $('#ubitec_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaUbicaciones();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#Denominacion_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return true;
        }
        if (tecla == 13) {
            ConsultaUbicaciones();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#Sociedad_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaUbicaciones();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaUbicaciones();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9]/;
        return patron.test(te);
    });
    $('#OkUbiTec').click(function () {
        ConsultaUbicaciones();
    });
    $('#Material_bus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaConjunto();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#MaterialDes_bus').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return true;
        }
        if (tecla == 13) {
            ConsultaConjunto();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9a-zA-Z]/;
        return patron.test(te);
    });
    $('#numAcMax3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        if (tecla == 13) {
            ConsultaConjunto();
        }
        te = String.fromCharCode(tecla);
        patron = /[0-9]/;
        return patron.test(te);
    });
    $('#OKConjunto').click(function () {
        ConsultaConjunto();
    });
    $('#retubi').click(function () {
        $("#ConsultaTablaUbi").css("display", "none");
        $("#BuscarParamUbi").css("display", "block");
    });
    $('#RetErui').click(function () {
        $("#ConsultaTablaEquipo").css("display", "none");
        $("#BuscarParamEquipo").css("display", "block");
    });
    $('#retconj').click(function () {
        $("#ConsultaTablaConj").css("display", "none");
        $("#BuscarParamConjutno").css("display", "block");
    });
    $('#AgregarFilaAvisos').click(function () {
        var tipo = $('#TipoAviso').val();
        if (tipo == 2) {
            AgregarFilaTablaActividades();
        }
        if (tipo == 1) {
            AgregarFilaTablaActividadesSAP();
        }
    });
    $('#BorrarFilaAvisos').click(function () {
        var tipo = $('#TipoAviso').val();
        if (tipo == 2) {
            VerificarActividadesEliminar();
        }
        if (tipo == 1) {
            VerificarActividadesEliminar();
        }
    });
    $('#guardar').click(function () {
        var tipo = $('#TipoAviso').val();
        if (tipo == 1) {
            GuardarSAP();
        }
        if (tipo == 2) {
            GuardarSAM();
        }
    });
});
function GuardarSAM() {
    var equipo = $('#equipo_CA');
    var grpopl = $('#GrpPlanificacion_CA');
    var puesto = $('#puestotrabajo_CA');
    if (equipo.val().length == 0) {
        ShowMsg(23, "images/advertencia.PNG", "audio/saperror.wav");
        equipo.focus();
        return;
    }
    if (grpopl.val().length == 0) {
        ShowMsg(24, "images/advertencia.PNG", "audio/saperror.wav");
        grpopl.focus();
        return;
    }
    if (puesto.val().length == 0) {
        ShowMsg(25, "images/advertencia.PNG", "audio/saperror.wav");
        puesto.focus();
        return;
    }
    if (validarDato("equipo_CA", "EQ") == false) {
        equipo.focus();
        ShowMsg(20, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (validarDato("GrpPlanificacion_CA", "GP") == false) {
        grpopl.focus();
        ShowMsg(26, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    if (validarDato("puestotrabajo_CA", "PT") == false) {
        puesto.focus();
        ShowMsg(14, "images/advertencia.PNG", "audio/saperror.wav");
        return;
    }
    var filadel = document.getElementsByName("DelActi");
    var gcodigo = document.getElementsByName("NameGCodigos");
    var codigos = document.getElementsByName("NameCodigos");
    var txtcodi = document.getElementsByName("NameCodigosTexts");
    var txtacci = document.getElementsByName("NameTextsAcc");
//    var factor = document.getElementsByName("NameFactor");
    var finici = document.getElementsByName("NameFInicio");
    var hinici = document.getElementsByName("NameHInicio");
    var fefin = document.getElementsByName("NameFFin");
    var hofin = document.getElementsByName("NameHFin");
    var trDel = document.getElementsByName("NameDele");
    for (i = 0; i < filadel.length; i++) {
        if (trDel[i].value.length == 0) {
            if (gcodigo[i].value.length > 0) {
                if (validarDato2(gcodigo[i].value, "GC") == false) {
                    gcodigo[i].focus();
                    ShowMsg(35, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (codigos[i].value.length == 0) {
                    ShowMsg(27, "images/advertencia.PNG", "audio/saperror.wav");
                    codigos[i].focus();
                    return;
                }
                if (validarDato2(codigos[i].value, "CD") == false) {
                    codigos[i].focus();
                    ShowMsg(36, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (txtcodi[i].value.length == 0) {
                    ShowMsg(28, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (txtacci[i].value.length == 0) {
                    ShowMsg(29, "images/advertencia.PNG", "audio/saperror.wav");
                    txtacci[i].focus();
                    return;
                }
//                if (factor[i].value.length == 0) {
//                    ShowMsg(30, "images/advertencia.PNG", "audio/saperror.wav");
//                    factor[i].focus();
//                    return;
//                }
                if (finici[i].value.length == 0) {
                    ShowMsg(31, "images/advertencia.PNG", "audio/saperror.wav");
                    finici[i].focus();
                    return;
                }
                if (hinici[i].value.length == 0) {
                    ShowMsg(32, "images/advertencia.PNG", "audio/saperror.wav");
                    hinici[i].focus();
                    return;
                }
                if (fefin[i].value.length == 0) {
                    ShowMsg(33, "images/advertencia.PNG", "audio/saperror.wav");
                    fefin[i].focus();
                    return;
                }
                if (hofin[i].value.length == 0) {
                    ShowMsg(34, "images/advertencia.PNG", "audio/saperror.wav");
                    hofin[i].focus();
                    return;
                }
                if (valDateData(finici[i].value, fefin[i].value)) {
                    ShowMsg(37, "images/advertencia.PNG", "audio/saperror.wav");
                    fefin[i].focus();
                    return;
                }


            }
        }
    }
    $('#guardar').prop('disabled', true);
    $('input').prop('disabled', true);
    $('#TexareaCircunstancia_CA').prop('disabled', true);
    var acc = "GuardarCabeceraAvisoSAM";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FSAM=" + $('#Notificacion_CA').val() + "&textobreve=" + $('#descripcionnotificacion_CA').val() +
                "&ubicaci=" + $('#ubictec_CA').val() + "&nummequipo=" + $('#equipo_CA').val() + "&conjun=" + $('#conjunto_CA').val() +
                "&grupoplan=" + $('#GrpPlanificacion_CA').val() + "&puestotra=" + $('#puestotrabajo_CA').val() + "&texto2=" + $('#DescripcionCircunstancias_CA').val(),
        success: function (datas) {
        }
    });

    DelAvisoActc();
    textCircuns();
    GuardarActividadesSAM();
}
function textCircuns() {
    var folio = $("#Notificacion_CA").val();
    var nota1 = $("#TexareaCircunstancia_CA").val();
    var nota2 = nota1.replace(/'/g, "´");
    var tam = nota2.length;
    var lim = tam / 132;
    var l = Math.ceil(lim);
    for (var i = 0; i < l; i++) {
        var d = i * 132;
        no = nota2.substr(d, 132);
        var acc = "GuardaTEXTos";
        var fila = i + 1;
        var enviar = "&fila=" + fila + "&linea=" + encodeURIComponent(no) + "&foli=" + folio;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {

                if (data == 0) {
                }
            }

        });

    }
}

function GuardarSAP() {
    var filadel = document.getElementsByName("DelActi");
    var gcodigo = document.getElementsByName("NameGCodigos");
    var codigos = document.getElementsByName("NameCodigos");
    var txtcodi = document.getElementsByName("NameCodigosTexts");
    var txtacci = document.getElementsByName("NameTextsAcc");
//    var factor = document.getElementsByName("NameFactor");
    var finici = document.getElementsByName("NameFInicio");
    var hinici = document.getElementsByName("NameHInicio");
    var fefin = document.getElementsByName("NameFFin");
    var hofin = document.getElementsByName("NameHFin");
    var trDel = document.getElementsByName("NameDele");
    for (i = 0; i < filadel.length; i++) {
        if (trDel[i].value.length == 0) {
            if (gcodigo[i].value.length > 0) {
                if (validarDato2(gcodigo[i].value, "GC") == false) {
                    gcodigo[i].focus();
                    ShowMsg(35, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (codigos[i].value.length == 0) {
                    ShowMsg(27, "images/advertencia.PNG", "audio/saperror.wav");
                    codigos[i].focus();
                    return;
                }
                if (validarDato2(codigos[i].value, "CD") == false) {
                    codigos[i].focus();
                    ShowMsg(36, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (txtcodi[i].value.length == 0) {
                    ShowMsg(28, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                if (txtacci[i].value.length == 0) {
                    ShowMsg(29, "images/advertencia.PNG", "audio/saperror.wav");
                    txtacci[i].focus();
                    return;
                }
//                if (factor[i].value.length == 0) {
//                    ShowMsg(30, "images/advertencia.PNG", "audio/saperror.wav");
//                    factor[i].focus();
//                    return;
//                }
                if (finici[i].value.length == 0) {
                    ShowMsg(31, "images/advertencia.PNG", "audio/saperror.wav");
                    finici[i].focus();
                    return;
                }
                if (hinici[i].value.length == 0) {
                    ShowMsg(32, "images/advertencia.PNG", "audio/saperror.wav");
                    hinici[i].focus();
                    return;
                }
                if (fefin[i].value.length == 0) {
                    ShowMsg(33, "images/advertencia.PNG", "audio/saperror.wav");
                    fefin[i].focus();
                    return;
                }
                if (hofin[i].value.length == 0) {
                    ShowMsg(34, "images/advertencia.PNG", "audio/saperror.wav");
                    hofin[i].focus();
                    return;
                }
                if (valDateData(finici[i].value, fefin[i].value)) {
                    ShowMsg(37, "images/advertencia.PNG", "audio/saperror.wav");
                    fefin[i].focus();
                    return;
                }
            }
        }
    }
    $('#guardar').prop('disabled', true);
    $('input').prop('disabled', true);
    var acc = "GuardarCabeceraAvisoSAP";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&FoliSAP=" + $('#Notificacion_CA').val(),
        success: function (datas) {
        }
    });
    GuardarActividadesSAP();

}
function valDateData(fec1, fec2) {
    var ban = false;
    var fe1 = new Date(fec1);
    var fe2 = new Date(fec2);
    if (fe2 < fe1) {
        ban = true;
    }
    return ban;
}

function GuardarActividadesSAM() {
    var folioSAM = $('#Notificacion_CA').val();
    var filadel = document.getElementsByName("DelActi");
    var gcodigo = document.getElementsByName("NameGCodigos");
    var codigos = document.getElementsByName("NameCodigos");
    var txtcodi = document.getElementsByName("NameCodigosTexts");
    var txtacci = document.getElementsByName("NameTextsAcc");
//    var factor = document.getElementsByName("NameFactor");
    var finici = document.getElementsByName("NameFInicio");
    var hinici = document.getElementsByName("NameHInicio");
    var fefin = document.getElementsByName("NameFFin");
    var hofin = document.getElementsByName("NameHFin");
//    var activ = document.getElementsByName("NameActi");
    var trDel = document.getElementsByName("NameDele");
    var fechacreada = document.getElementsByName("Namefechacreada");
    var HoraCreada = document.getElementsByName("Namehoracreada");
    var autor = document.getElementsByName("NameAutor");
    var posi = 1;
    for (i = 0; i < filadel.length; i++) {
        if (trDel[i].value.length == 0) {
            if (gcodigo[i].value.length > 0) {
                var extras = "&GCodigo=" + gcodigo[i].value.toUpperCase() + "&Codigo=" + codigos[i].value.toUpperCase() + "&TxtCodigo=" + txtcodi[i].value +
                        "&TxtAcci=" + txtacci[i].value + "&Factor=0" + "&FInicio=" + finici[i].value +
                        "&HInicio=" + hinici[i].value + "&FFin=" + fefin[i].value + "&HFin=" + hofin[i].value + "&Activid=0" +
                        "&FCreada=" + fechacreada[i].value + "&HCreada=" + HoraCreada[i].value + "&Autor=" + autor[i].value + "&PosiSAM=" + posi;
                posi++;
                GuardarActPosicioSAM(folioSAM, extras);
            }
        }
    }
    $('#CloMsg').prop('disabled', false);
    ShowMsgWindow(2, "images/infoicono.PNG", "audio/sapsnd05.wav");
}
function GuardarActPosicioSAM(folioSAM, extras)
{
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=GuardarACSAM" + extras + "&FolSAM=" + folioSAM,
        success: function (data) {
        }
    });
}
function GuardarActPosicioSAP(folio, extras)
{
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=GuardarACSSAP" + extras + "&Foli=" + folio,
        success: function (data) {
        }
    });
}
function DelAvisoActc()
{
    var av = $('#Notificacion_CA').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=DELDATAACT&Aviso=" + av,
        success: function (data) {
        }
    });
}
function DelAvisoActcSAP()
{
    var av = $('#Notificacion_CA').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=DELDATAACTSAP&Aviso=" + av,
        success: function (data) {
        }
    });
}
function GuardarActividadesSAP() {
    var folio = $('#Notificacion_CA').val();
    var filadel = document.getElementsByName("DelActi");
    var tdpos = document.getElementsByName("TDPosicionAct");
    var gcodigo = document.getElementsByName("NameGCodigos");
    var codigos = document.getElementsByName("NameCodigos");
    var txtcodi = document.getElementsByName("NameCodigosTexts");
    var txtacci = document.getElementsByName("NameTextsAcc");
//    var factor = document.getElementsByName("NameFactor");
    var finici = document.getElementsByName("NameFInicio");
    var hinici = document.getElementsByName("NameHInicio");
    var fefin = document.getElementsByName("NameFFin");
    var hofin = document.getElementsByName("NameHFin");
//    var activ = document.getElementsByName("NameActi");
    var trDel = document.getElementsByName("NameDele");
    for (i = 0; i < filadel.length; i++) {
        var valopos = parseInt(tdpos[i].value);
        var inborr = "";
        if (valopos == 0) {
            valopos = i + 1;
        }
        if (trDel[i].value.length > 0) {
            inborr = "X";
        }
        if (gcodigo[i].value.length > 0) {
            var extras = "&GCodigo=" + gcodigo[i].value + "&Codigo=" + codigos[i].value + "&TxtCodigo=" + txtcodi[i].value +
                    "&TxtAcci=" + txtacci[i].value + "&Factor=0" + "&FInicio=" + finici[i].value +
                    "&HInicio=" + hinici[i].value + "&FFin=" + fefin[i].value + "&HFin=" + hofin[i].value + "&Activid=0" + "&posiSAP=" + valopos + "&indBor=" + inborr;
            GuardarActPosicioSAP(folio, extras);
        }
    }
    ActFol();
    $('#CloMsg').prop('disabled', false);
    ShowMsgWindow(2, "images/infoicono.PNG", "audio/sapsnd05.wav");
}
function ActFol() {
    var acc = "FolioAct";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc,
        success: function (data) {

        }

    });
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
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
function CargarCabecera(Aviso, Tipo) {
    var acc = "CargarAviso";
    $.ajax({
        async: false,
        dataType: "JSON",
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + Tipo,
        success: function (datas) {
            $('#Notificacion_CA').val(datas[0]);
            $('#Claseaviso_CA').val(datas[1]);
            $('#descripcionnotificacion_CA').val(datas[2]);
            $('#statusSis').val(datas[3]);
            $('#statusOrden_CA').val(datas[4]);
            $('#ubictec_CA').val(datas[5]);
            $('#equipo_CA').val(datas[6]);
            $('#conjunto_CA').val(datas[7]);
            $('#GrpPlanificacion_CA').val(datas[8]);
            $('#CentroPlaninificacion_CA').val(datas[9]);
            $('#puestotrabajo_CA').val(datas[10]);
            $('#puestotrabajo2_CA').val(datas[9]);
            $('#autorAviso_CA').val(datas[11]);
            $('#theDate').val(datas[12]);
            $('#Time').val(datas[13]);
            $('#statusOrden_CA').val(datas[19]);
            $('#DescripcionCircunstancias_CA').val(datas[14]);
            if ($('#ubictec_CA').val().length > 0) {
                CargarNombresData("U", $('#ubictec_CA').val());
            }
            if ($('#equipo_CA').val().length > 0) {
                CargarNombresData("E", $('#equipo_CA').val());
            }
            if ($('#conjunto_CA').val().length > 0) {
                CargarNombresData("C", $('#conjunto_CA').val());
            }
            if ($('#puestotrabajo_CA').val().length > 0) {
                CargarNombresData("P", $('#puestotrabajo_CA').val());
            }
            if ($('#GrpPlanificacion_CA').val().length > 0) {
                CargarNombresData("G", $('#GrpPlanificacion_CA').val());
            }
            if ($('#CentroPlaninificacion_CA').val().length > 0) {
                CargarNombresData("B", $('#CentroPlaninificacion_CA').val());
            }
            if (datas[19].length > 0) {
                $('#BUorav').prop('disabled', true);
            }
            if (datas[3] === "MECE") {
                CargarActividadesVisual(Aviso, Tipo);
            } else {
                if (Tipo == 1) {
                    var acc = "ConsultarCierreTecnico";
                    $.ajax({
                        async: false,
                        type: "GET",
                        url: "PeticionModuloModificarAvisos",
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Accion=" + acc + "&Aviso=" + Aviso,
                        success: function (datas) {
                            if (datas == 1) {
                                CargarActividadesVisual(Aviso, Tipo);
                            } else {
                                CargarActividadesEdicionSAP(Aviso);
                            }
                        }
                    });
                } else {
                    var recib = datas[15];
                    var proce = datas[16];
                    var error = datas[17];
                    var modif = datas[18];
                    if (recib.length == 0 && proce.length == 0 && error.length == 0 && modif.length == 0) {
                        CargarActividadesSAM(Aviso, error);
                    } else if (error.length > 0 && recib.length > 0 && proce.length > 0) {
                        CargarActividadesSAM(Aviso, error);
                    } else if (error.length == 0 && recib.length == 0 && proce.length == 0 && modif.length > 0) {
                        CargarActividadesSAM(Aviso, error);
                    } else {
                        CargarActividadesVisual(Aviso, Tipo);
                    }
                }
            }
        }
    });

}
function CargarActividadesEdicionSAP(Aviso) {
    $('#BorrarFilaAvisos').hide();
    $('#guardar').prop('disabled', false);
    var acc = "CargarActividadesSAP";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso,
        success: function (datas) {
            $('#TablaAct').html(datas);
        }
    });
}
function CargarActividadesSAM(Aviso, Error) {
    $('#guardar').prop('disabled', false);
    if (Error.length > 0) {
        $('#MensajeErorAviso').css('display', 'block');
        $('#menser').val(Error);
    }
    $('#descripcionnotificacion_CA').prop('disabled', false);
    $('#ubictec_CA').prop('disabled', false);
    $('#equipo_CA').prop('disabled', false);
    $('#conjunto_CA').prop('disabled', false);
    $('#conjunto_CA').prop('disabled', false);
    $('#GrpPlanificacion_CA').prop('disabled', false);
    $('#puestotrabajo_CA').prop('disabled', false);
    $('#DescripcionCircunstancias_CA').prop('disabled', false);
    $('#TexareaCircunstancia_CA').prop('disabled', false);
    $('#AgregarFilaAvisos').prop('disabled', false);
    $('#BorrarFilaAvisos').prop('disabled', false);
    var acc = "CargarActividadesSAMEdicion";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso,
        success: function (datas) {
            $('#TablaAct').html(datas);
        }
    });
}
function CargarActividadesVisual(Aviso, Tipo) {
    $('#AgregarFilaAvisos').hide();
    $('#BorrarFilaAvisos').hide();
    var acc = "CargarActividadesVisual";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + Tipo,
        success: function (datas) {
            $('#TablaAct').html(datas);
        }
    });
}
function CargarDatosMaestroEquipo(Equipo) {
    var acc = "CargarDatosMaestroEquipo";
    $.ajax({
        async: false,
        dataType: 'json',
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Parametro9=" + Equipo,
        success: function (datas) {
            $('#ubictec_CA').val(datas[0]);
            CargarNombresData("U", datas[0]);
            $('#GrpPlanificacion_CA').val(datas[1]);
            CargarNombresData("G", datas[1]);
            $('#puestotrabajo_CA').val(datas[2]);
            CargarNombresData("P", datas[2]);
        }
    });
}

function CargarNombresData(Tipo, dato) {
    var acc = "GetNameData";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Dato=" + dato + "&Par=" + Tipo,
        success: function (datas) {
            if (Tipo == "U") {
                $('#DenominacionUbitec_MAA').val(datas);
            }
            if (Tipo == "E") {
                $('#DenominacionEquipo_MAA').val(datas);
            }
            if (Tipo == "C") {
                $('#DenominacionConjunto_MAA').val(datas);
            }
            if (Tipo == "P") {
                $('#DenominacionPuestoTrabajo_MAA').html(datas);
            }
            if (Tipo == "G") {
                $('#DenominacionGplan').html(datas);
            }
            if (Tipo == "B") {
                $('#DenominacionCentro').html(datas);
                $('#DenCentroP').html(datas);
            }
            if (Tipo == "Q") {
                $('#IVOctr').val(datas);
            }
        }
    });
}
function CargarTextos(Aviso, Tipo) {
    var acc = "CargarAvisoTexto";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Aviso=" + Aviso + "&Tipo=" + Tipo,
        success: function (datas) {
            $('#TexareaCircunstancia_CA').val(datas);
        }
    });
}
function MostarVentanaModal(ven, handle) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#' + ven);
    var ancho = 600;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ven);
    Drag.init(theHandle, theRoot);
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
    $('#fecha_conc').focus();
}
function obtenermes(i) {
    i = i + 1;
    if (i < 11) {
        i = "0" + i;
    }
    return i;
}
function seleccionar(obj, tipo) {
    switch (tipo) {
        case 'ubitec':
            $('#ubictec_CA').val(obj);
            $('#VentanaModalUbitec').css('display', 'none');
            $('#ubictec_CA').focus();
            CargarNombresData("U", obj);
            break;
        case 'equipo':
            $('#equipo_CA').val(obj);
            $('#VentanaModalEquipos').css('display', 'none');
            $('#equipo_CA').focus();
            CargarNombresData("E", obj);
            CargarDatosMaestroEquipo(obj);
            break;
        case 'GPlan':
            var a = new Array();
            a = obj.split("-");
            $('#GrpPlanificacion_CA').val(a[0]);
            $('#CentroPlaninificacion_CA').val(a[1]);
            $('#DenominacionGplan').html(a[2]);
            $('#VentanaModalGrupoPlan').css('display', 'none');
            $('#GrpPlanificacion_CA').focus();
            CargarNombresData("B", a[1]);
            break;
        case 'Puesto':
            var a = new Array();
            a = obj.split("-");
            $('#puestotrabajo_CA').val(a[0]);
            $('#VentanaModalPuesto').css('display', 'none');
            $('#puestotrabajo_CA').focus();
            CargarNombresData("P", a[0]);
            break;
        case 'conjunto':
            $('#conjunto_CA').val(obj);
            $('#VentanaModalConjunto').css('display', 'none');
            $('#conjunto_CA').focus();
            CargarNombresData("C", obj);
            break;
        case 'CLasOR':
            $('#IVOclo').val(obj);
            $('#VentanaModalCLase').css('display', 'none');
            $('#IVOclo').focus();
            break;
        case 'Centro':
            $('#IVOcp').val(obj);
            $('#VentanaModalCentro').css('display', 'none');
            $('#IVOcp').focus();
            break;
        case 'PuestoOrden':
            var a = new Array();
            a = obj.split("-");
            $('#IVOptr').val(a[0]);
            $('#IVOctr').val(a[1]);
            $('#VentanaModalPuestoOrd').css('display', 'none');
            $('#IVOptr').focus();
            break;
        case 'GrupCodigo':
            var a = new Array();
            a = obj.split("|");
            var gco = a[0];
            var cod = a[1];
            var text = a[2];
            var num = a[3];
            $('#txtGCod' + num).val(gco);
            $('#txtCod' + num).val(cod);
            $('#txtCodtext' + num).val(text);
            $('#VentanaModalGrupoCodigos').css('display', 'none');
            $('#txtGCod' + num).focus();
            break;
    }
}
function validarDato(id, cat) {
    var ban = false;
    var campo = $('#' + id);
    if (campo.val().length > 0) {
        $.ajax({
            type: 'GET',
            async: false,
            url: 'PeticionModuloModificarAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=ValidarDatos" + "&Dato=" + campo.val() + "&Cate=" + cat,
            success: function (data) {
                if (data != 0) {
                    ban = true;
                }
            }
        });
    }
    return ban;
}
function validarDato2(dato, cat) {
    var ban = false;
    $.ajax({
        type: 'GET',
        async: false,
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=ValidarDatos" + "&Dato=" + dato + "&Cate=" + cat,
        success: function (data) {
            if (data != 0) {
                ban = true;
            }
        }
    });
    return ban;
}
function ConsultaUbicaciones() {
    var acc = "ConsultaUbitec";
    var ubitec = $("#ubitec_MAA").val();
    var denominacion = $("#Denominacion_MAA").val();
    var sociedad = $("#Sociedad_MAA").val();
    var ctd = $("#numAcMax").val();
    var enviar = "&Parametro8=" + ubitec + "&Parametro6=" + denominacion + "&Parametro7=" + sociedad + "&Parametro4=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            var rs = data;
            if (rs == 0) {
                ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamUbi").css("display", "none");
                $("#ConsultaTablaUbi").css("display", "block");
                $("#cargarDatosUbi").html(rs);
                borramsg();
                fnc('table-scrollubi', 'fixedYUbi');
            }

        }
    });
}
function ConsultaEquipos() {
    var acc = "ConsultaEquipos";
    var equipo = $("#EquipoMatch_MAA").val();
    var denominacion = $("#DenominacionEquipoMatch_MAA").val();
    var ctd = $("#numAcMax2").val();
    var enviar = "&Parametro10=" + denominacion + "&Parametro9=" + equipo + "&Parametro4=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            var rs = data;
            if (rs == 0) {
                ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamEquipo").css("display", "none");
                $("#ConsultaTablaEquipo").css("display", "block");
                $("#cargarDatosEquipo").html(rs);
                borramsg();
                fnc('table-scrollEquipo', 'fixedYEquipo');
            }

        }

    });
}
function ConsultaConjunto() {
    var acc = "ConsultaMateriales";
    var mat = $("#Material_bus").val();
    var texto = $("#MaterialDes_bus").val();
    var ctd = $("#numAcMax3").val();
    var enviar = "&Parametro5=" + mat + "&Parametro2=" + texto + "&Parametro4=" + ctd;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloModificarAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + enviar,
        success: function (data) {
            var rs = data;
            if (rs == 0) {
                ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                $("#BuscarParamConjutno").css("display", "none");
                $("#ConsultaTablaConj").css("display", "block");
                $("#cargarDatosConj").html(rs);
                fnc('table-scrollConj', 'fixedYConj');
                borramsg();
            }

        }

    });
}
function VerMCCodigos(nu) {
    var btmco = document.getElementsByName("btnGcodigos");
    for (i = 0; i < btmco.length; i++) {
        btmco[i].style.display = "none";
    }
    document.getElementById("btnGcodigo" + nu).style.display = "inline";
    $('#txtGCod' + nu).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 32) {
            return false;
        }
        patrn = /[0-9a-zA-Z]/;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
}
function VerMCFechaIn(nu) {
    $('#btnGcodigo' + nu).css('display', 'none');
    $('#btnFFin' + nu).css('display', 'none');
    var btmco = document.getElementsByName("btnFInicio");
    for (i = 0; i < btmco.length; i++) {
        btmco[i].style.display = "none";
    }
    document.getElementById("btnFInicio" + nu).style.display = "inline";
}
function VerMCFechaFin(nu) {
    $('#btnGcodigo' + nu).css('display', 'none');
    $('#btnFInicio' + nu).css('display', 'none');
    var btmco = document.getElementsByName("btnFFin");
    for (i = 0; i < btmco.length; i++) {
        btmco[i].style.display = "none";
    }
    document.getElementById("btnFFin" + nu).style.display = "inline";
}
function VerMCCodigos(nu) {
    $('#btnFInicio' + nu).css('display', 'none');
    $('#btnFFin' + nu).css('display', 'none');
    var btmco = document.getElementsByName("btnGcodigos");
    for (i = 0; i < btmco.length; i++) {
        btmco[i].style.display = "none";
    }
    document.getElementById("btnGcodigo" + nu).style.display = "inline";
    $('#txtGCod' + nu).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 32) {
            return false;
        }
        patrn = /[0-9a-zA-Z]/;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
}
function QuitarMC(i) {
    $('#btnGcodigo' + i).css('display', 'none');
    $('#btnFInicio' + i).css('display', 'none');
    $('#btnFFin' + i).css('display', 'none');
//    $('#TDFactor' + i).keypress(function (e) {
//        var tec = (document).all ? e.keyCode : e.which;
//        if (tec == 32) {
//            return false;
//        }
//        patrn = /[0-9]/;
//        t = String.fromCharCode(tec);
//        return patrn.test(t);
//    });
    $('#txtCod' + i).keypress(function (e) {
        var tec = (document).all ? e.keyCode : e.which;
        if (tec == 32) {
            return false;
        }
        if (tec == 13) {
            CargarNombreCodigoAct($('#txtCod' + i).val(), 'N', i);
        }
        patrn = /[0-9a-zA-Z]/;
        t = String.fromCharCode(tec);
        return patrn.test(t);
    });
    $('#txtCod' + i).blur(function () {
        CargarNombreCodigoAct($('#txtCod' + i).val(), 'N', i);
    });
}
function CargarNombreCodigoAct(dato, tipo, num) {
    var acc = "GetNameData";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloVisualAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Dato=" + dato + "&Par=" + tipo,
        success: function (datas) {
            $('#txtCodtext' + num).val(datas);
        }
    });
}
function AbrirGcodigos(n) {
    var acc = "ConsultaGCodigos";
    $.ajax({
        async: false,
        type: "GET",
        url: "PeticionModuloModificarAvisos",
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&IdInput=" + n,
        success: function (datas) {
            if (datas == 0) {
                ShowMsg(11, "images/aceptar.png", "audio/sapmsg.wav");
            } else {
                MostarVentanaModal("VentanaModalGrupoCodigos", "handle10");
                $('#CargarDatosGCodigo').html(datas);
                fnc('table-scrollGCodig', 'fixedYGodigo');
                borramsg();
            }
        }
    });
}
function AgregarFilaTablaActividades() {
    var cont = document.getElementsByName("DelActi").length;
    var i = cont;
    var newfiladata = "<tr id=\"trFilaAviso" + i + "\">>"
            + "<td><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>"
            + "<td><input type=\"text\" name=\"TDPosicionAct\" readOnly hidden value=\"0\" class=\"TDACT2\" style=\"background: none\"/></td>"
            + "<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + i + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + i + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + i + "')\" id=\"btnGcodigo" + i + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>"
            + "<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\"  style=\"text-transform: uppercase;\" id=\"txtCod" + i + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + i + "\" onfocus=\"QuitarMC(" + i + ");\" style=\"background: none\"/></td>"
            + "<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + i + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + i + ");\"  /></td>"
            + "<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>"
//            + "<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + i + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + i + ");\" /></td>"
            + "<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + i + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + i + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + i + "')\" id=\"btnFInicio" + i + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>"
            + "<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + i + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + i + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + i + "')\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + i + "')\" id=\"btnFFin" + i + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>"
            + "<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + i + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
//            + "<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + i + "\" readOnly  style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namefechacreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namehoracreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"NameAutor\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "</tr>";
    $('#tabAct').append(newfiladata);
    cont++;
}
function AgregarFilaTablaActividadesSAP() {
    var cont = document.getElementsByName("DelActi").length;
    var i = cont;
    var newfiladata = "<tr id=\"trFilaAviso" + i + "\">>"
            + "<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>"
            + "<td  style=\"display:none\"><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>"
            + "<td><input type=\"text\" name=\"TDPosicionAct\" readOnly hidden value=\"0\" class=\"TDACT2\" style=\"background: none\"/></td>"
            + "<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + i + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + i + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + i + "')\" id=\"btnGcodigo" + i + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>"
            + "<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\"  style=\"text-transform: uppercase;\" id=\"txtCod" + i + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + i + "\" onfocus=\"QuitarMC(" + i + ");\" style=\"background: none\"/></td>"
            + "<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + i + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + i + ");\"  /></td>"
            + "<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>"
//            + "<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + i + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + i + ");\" /></td>"
            + "<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + i + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + i + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + i + "')\" id=\"btnFInicio" + i + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>"
            + "<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + i + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
            + "<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + i + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + i + "')\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + i + "')\" id=\"btnFFin" + i + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>"
            + "<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + i + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
//            + "<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + i + "\" readOnly  style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namefechacreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namehoracreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "<td style=\"display:none\"><input type=\"text\" readOnly name=\"NameAutor\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>"
            + "</tr>";
    $('#tabAct').append(newfiladata);
    cont++;
}
function VerificarActividadesEliminar() {
    var chk = document.getElementsByName("DelActi");
    var tam = chk.length;
    for (i = 0; i < tam; i++) {
        if (chk[i].checked) {
            chk[i].checked = false;
            document.getElementById("trFilaAviso" + i).style.display = 'none';
            document.getElementById("TDFilaEl" + i).value = "X";
        }
    }
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
function validarFecha(fecha) {
    var f = fecha.split(".");
    var d = f[0];
    var m = f[1];
    var y = f[2];
    var f1 = new Date(y, m, d);
    var date = new Date();
    var d1 = checkTime(date.getDate());
    var m1 = checkTime(date.getMonth() + 1);
    var y1 = date.getFullYear();
    var f2 = new Date(y1, m1, d1);
    if (f2 > f1) {
        return false;
    } else {
        return true;
    }
}
function AbrirFInci(n) {
    OpenCalendario("TDFecIn" + n);
}
function AbrirFFin(n) {
    OpenCalendario("TDFechFin" + n);
}