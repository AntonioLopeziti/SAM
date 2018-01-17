/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        function back() {
            window.location.href = "Reportes.jsp";
        }
        function fin() {
            window.location.href = "Bienvenido.jsp";
        }   
         function Validar() {
            vali();
            location.href = "VisualizarReporteEstatusOrdenes.jsp";
         }
        function ErrorBusqueda() {
            var okcon = "No existen datos";
            var iconm = $('#iconmsg');
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = $('#msg');
            men.innerHTML = okcon;
        }
        function vali() {
            var centro = $('#centro').val();
            var sam1 = $('#sam1').val();
            var sam2 = $('#sam2').val();
            var sap1 = $('#sap1').val();
            var sap2 = $('#sap2').val();
            var fecha1 = $('#fecha_inicio').val();
            var fecha2 = $('#fecha_fin').val();
            var elementos = $('[name = "rb"]');
            for (var i = 0; i < elementos.length; i++) {
                if (elementos[i].checked) {
                    var valor = elementos[i].value;
                }
            }
            if (centro.length < 1 && sam1.length < 1 && sam2.length < 1 && sap1.length < 1 && sap2.length < 1 && fecha1.length < 1 && fecha2.length > 1) {
                var okcon = "Campo de orden obligatorio";
                var iconm = $('#iconmsg');
                    iconm.css('visibility','visible');
                    iconm.attr('src', 'images/advertencia.PNG');
                     $('#msg').html(okcon);
               var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
            } else {
                    enviarDatos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2, valor);
                    location.href = "peticionVisualizarReportesEstatusOrdenes.jsp";
            }
        } 
         function enviarDatos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2, valor) {
            var enviar = "&centro=" + centro + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2 + "&Error=" + valor;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionVisualizarReportesEnt',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                 var rs = data;
                    var men = $("#msg").get(0);
                    if (rs == 1) {
                        location.href = "VisualizarReporteEstatusOrdenes.jsp";
                    } else {
                        $("#msg").val = "";
                        var iconm = $("#iconmsg").get(0);
                        setTimeout(function () {

                        }, 8000);
                    }
                }
            });
        }
        function mostrarVentanaModal(tipo) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            switch (tipo) {
                case "centro":
                    var ventana1 = $('#VentanaModalCentro').get(0);
                    abrirVentana(ventana1);
                    ConsultaCentro();
                    break;
                case "sam1":
                    var ventana2 = $('#VentanaModalSAM1').get(0);
                    abrirVentana(ventana2);
                    ConsultaFolioSAM1();
                    break;
                case "sam2":
                    var ventana3 = $('#VentanaModalSAM2').get(0);
                    abrirVentana(ventana3);
                    ConsultaFolioSAM2();
                    break;
                case "sap1":
                    var ventana4 = $('#VentanaModalSAP1').get(0);
                    abrirVentana(ventana4);
                    ConsultaFolioSAP1();
                    break;
                case "sap2":
                    var ventana5 = $('#VentanaModalSAP2').get(0);
                    abrirVentana(ventana5);
                    ConsultaFolioSAP2();
                    break;
            } 
        }
        function abrirVentana(ventana) {
            var ancho = 350;
            var alto = 650;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
        }
        function ocultarVentana(tipo) {
           var BE = document.createElement('audio');
 //          var BE = $('<audio type="text"/>');
            BE.src = 'audio/sapsnd05.wav';
           BE.play();
//            $('#overlay').remove();
            switch (tipo) {
                case "centro":
                    var ventana1 = $('#VentanaModalCentro').get(0);
                    ventana1.style.display = 'none';
                    $("#BuscarParamOCompras_SP").hide();
                    $("#ConsultaTablaOCompras").hide();
                    $("#OrgCompras").focus();
                    borramsg();
                    break;
                case "sam1":
                    var ventana2 = $('#VentanaModalSAM1').get(0);
                    ventana2.style.display = 'none';
                    $("#BuscarFoliosam1").hide();
                    $("#ConsultaTablaFolioSAM1").hide();
                    $("#sam1").focus();
                    borramsg();
                    break;
                case "sam2":
                    var ventana3 = $('#VentanaModalSAM2').get(0);
                    ventana3.style.display = 'none';
                    $("#BuscarFoliosam2").hide();
                    $("#ConsultaTablaFolioSAM2").hide();
                    $("#sam2").focus();
                    borramsg();
                    break;
                case "sap1":
                    var ventana4 = $('#VentanaModalSAP1').get(0);
                    ventana4.style.display = 'none';
                    $("#BuscarFoliosap1").hide();
                    $("#ConsultaTablaFolioSAP1").hide();
                    $("#sap1").focus();
                    borramsg();
                    break;
                case "sap2":
                    var ventana5 = $('#VentanaModalSAP2').get(0);
                    ventana5.style.display = 'none';
                    $("#BuscarFoliosap2").hide();
                    $("#ConsultaTablaFolioSAP2").hide();
                    $("#sap2").focus();
                    borramsg();
                    break;
            }
        }
        function ConsultaCentro(){
            var dato = "";
            var acc = "CentroStatus";
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc,
                success: function (data) {
                    if (data == 0){
                        ErrorBusquedaMatch();
                    } else {
                        borramsg();
                        dato = data;                     
                        $('#cargarDatosOCompras').html(dato);
                        $('#BuscarParamOCompras_SP').css('display','none');
                        $('#ConsultaTablaOCompras').ccs('display','block');
                         fnc();
                         borramsg();
                    }
                }
            });    
        }
        function ConsultaFolioSAM1() {
            var acc = "SamStatus";
            var tipo = "sam1";
            var enviar = "&tipo="+tipo;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        $('#BuscarFoliosam1').css('display','none');
                        $('#ConsultaTablaFolioSAM1').css('display','block');
                        $('#cargarDatosFolioSAM1').html(data);
                        fnc1();
                        borramsg();
                    }
                }
            });
        }
        function ConsultaFolioSAM2() {
            var acc = "SamStatus";
            var tipo = "sam2";
            var enviar = "&tipo="+tipo;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        $('#BuscarParamOCompras_SP').css('display','none');
                        $('#ConsultaTablaFolioSAM2').css('display','block');
                        $('#cargarDatosFolioSAM2').html(data);
                        fnc1();
                        borramsg();
                    }
                }
            });
        }    
        function ConsultaFolioSAP1() {
            var acc = "SapStatus";
            var tipo = "sap1";
            var enviar = "&tipo="+tipo;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        $('#BuscarParamOCompras_SP').css('display','none');
                        $('#ConsultaTablaFolioSAP1').css('display','block');
                        $('#cargarDatosFolioSAP1').html(data);
                        fnc1();
                        borramsg();
                    }
                }
            });
        }
        function ConsultaFolioSAP2() {
            var acc = "SapStatus";
            var tipo = "sap2";
            var enviar = "&tipo="+tipo;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        $('#BuscarParamOCompras_SP').css('display','none');
                        $('#ConsultaTablaFolioSAP2').css('display','block');
                        $('#cargarDatosFolioSAP2').html(data);
                        fnc1();
                        borramsg();
                    }
                }
            });
        }
        function borramsg() {
            var iconm = $('#iconmsg');
            iconm.css('visibility','hidden');
            $('#msg').html("");
        }
        function fnc() {
            document.getElementById('table-scrollOCompras').onscroll = function () {
                document.getElementById('fixedYOCompras').style.top = document.getElementById('table-scrollOCompras').scrollTop + 'px';
            };
        }
        function fnc1() {
            document.getElementById('table-scroll1').onscroll = function () {
                document.getElementById('fixedY1').style.top = document.getElementById('table-scroll1').scrollTop + 'px';
            };
        }
        
        function Select(dato, tipo) {
            switch (tipo) {
                case "centro":
                    $("#centro").val(dato);
                    ocultarVentana(tipo);
                break;
                case "sam1":
                    $("#sam1").val(dato);
                    ocultarVentana(tipo);
                break;
                case "sam2":
                    $("#sam2").val(dato);
                    ocultarVentana(tipo);
                break;
                case "sap1":
                    $("#sap1").val(dato);
                    ocultarVentana(tipo);
                break;
                case "sap2":
                    $("#sap2").val(dato);
                    ocultarVentana(tipo);
                break;
            }
        }
        function validarCentro() {
            var acc = "ValidarCentro";
            var centro = $('#centro').val().toUpperCase();
            var enviar = "&centro=" + centro;
            if (centro.length > 0) {
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action="  + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        var okcon = "No se encuentra en el Sistema el centro : " + centro;
                            var iconm = $('#iconmsg');
                            iconm.css('visibility','visible');
                            iconm.attr('src','images/advertencia.PNG');
                            $('#msg').html(okcon);
                            $('#centro').val('');
                            $('#centro').focus();
                    } else {
                        borrarmsg();
                    }
                }
            });
            }
        }
        function validarsam() {
            var acc = "ValidarSAM2";
            var sam = $('#sam1').val().toUpperCase();
            var enviar = "&sam=" + sam;
            if (sam.length > 0) {
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action="  + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        var okcon = "No se encuentra en el Sistema el folio sam: " + sam;
                            var iconm = $('#iconmsg');
                            iconm.css('visibility','visible');
                            iconm.attr('src','images/advertencia.PNG');
                            $('#msg').html(okcon);
                            $('#sam').val('');
                            $('#sam1').focus();
                    } else {
                        borrarmsg();
                    }
                }
            });
            }

        }

        function validarsam2() {
            var acc = "ValidarSAM2";
            var sam = $('#sam2').val().toUpperCase();
            var enviar = "&sam=" + sam;
            if (sam.length > 0) {
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action="  + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        var okcon = "No se encuentra en el Sistema el folio sam: " + sam;
                            var iconm = $('#iconmsg');
                            iconm.css('visibility','visible');
                            iconm.attr('src','images/advertencia.PNG');
                            $('#msg').html(okcon);
                            $('#sam2').val('');
                            $('#sam2').focus();
                    } else {
                        borrarmsg();
                    }
                }
            });
            }
        }

        function validarsap() {
            var acc = "ValidarSAP2";
            var sap = $('#sap1').val().toUpperCase();
            var enviar = "&sap=" + sap;

          if (sap.length > 0) {
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action="  + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        var okcon = "No se encuentra en el Sistema el folio sap: " + sap;
                            var iconm = $('#iconmsg');
                            iconm.css('visibility','visible');
                            iconm.attr('src','images/advertencia.PNG');
                            $('#msg').html(okcon);
                            $('#sap1').val('');
                            $('#sap1').focus();
                    } else {
                        borrarmsg();
                    }
                }
            });
            }
        }

        function validarsap2() {
            var acc = "ValidarSAP2";
            var sap = $('#sap2').val().toUpperCase();
            var enviar = "&sap=" + sap;

          if (sap.length > 0) {
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionVisualizarReportesEstatusOrdenes',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action="  + acc + enviar,
                success: function (data) {
                    if (data == 0) {
                        var okcon = "No se encuentra en el Sistema el folio sap: " + sap;
                            var iconm = $('#iconmsg');
                            iconm.css('visibility','visible');
                            iconm.attr('src','images/advertencia.PNG');
                            $('#msg').html(okcon);
                            $('#sap2').val('');
                            $('#sap2').focus();
                    } else {
                        borrarmsg();
                    }
                }
            });
            }
        }