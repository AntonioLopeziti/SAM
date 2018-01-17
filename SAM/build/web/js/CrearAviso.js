/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

$(document).ready(function () {
        startTime();
        window.onload = function () {
            startTime();
            bloq();
        };
    $('#aviso_CAA').css("background-image", "url(images/necesario.PNG)");

    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').css("display", "none");
    $('#aviso_CAA').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').css("display", "none");
        $('#aviso_CAA').css("background-image", "none");

    });
    $('#aviso_CAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {

            validar();
        }
    });

    $('#Notificacion_CAA').focus(function () {
        $('#Notificacion_CAA').css("background-image", "none");
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').css("display", "none");
        if ($('#aviso_CAA').val().length < 1) {
            $('#aviso_CAA').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Modelo_CAA').val().length < 1) {
            $('#Modelo_CAA').css("background-image", "url(images/necesario.PNG)");
        }

    });
    $('#Notificacion_CAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $("#Modelo_CAA").focus(function () {
        $('#Modelo_CAA').css("background-image", "none");
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        if ($('#aviso_CAA').val().length < 1) {
            $('#aviso_CAA').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Notificacion_CAA').val().length < 1) {
            $('#Notificacion_CAA').css("background-image", "url(images/necesario.PNG)");
        }

    });
    $("#Modelo_CAA").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13)
        {
            validar();
        }
    });

/////////// Eventos de los match
////// Match de Centro
//    $('#match_A1').click(function () {
//        mostrarVentanaModal('centros');
//        var theHandle = document.getElementById("handle");
//        var theRoot = document.getElementById("VentanaModalCentros");
//        Drag.init(theHandle, theRoot);
//    });
    $('#match_A2').click(function () {
        mostrarVentanaModal('almacen');
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalAlmacenes");
        Drag.init(theHandle, theRoot);
    });
    $('#match_A3').click(function () {
        mostrarVentanaModal('movimiento');
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalMovimientos");
        Drag.init(theHandle, theRoot);
    });

    $('#match_A5').click(function () {
        mostrarVentanaModal('material');
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalMate");
        Drag.init(theHandle, theRoot);
    });
    /// Funcion match centro
    $('#Centro_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });

    $('#CentroDes_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCentro();
        }
    });

    ///// match Almacen
    $('#CentroAlmacen_bus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    $('#AlmacenDesc_bus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    $('#Almacen_bus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaAlmacen();
        }
    });
    ///// match  Movimientos
    $('#Movimiento_bus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaClaseMovimientos();
        }
    });
    $('#MovimientoDes_bus').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaClaseMovimientos();
        }
    });
    //// funcion match Canal distribucion
    $('#CanalD_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCnalDis();
        }
    });
    $('#DenomCanal_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaCnalDis();
        }
    });
    $('#okCanal').click(function () {
        ConsultaCnalDis();
    });

    //// macth para sector
    $('#Sector_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode.ENTER) {
            ConsultaSector();
        }
    });
    $('#DenomSecto_CL').keypress(function (e) {
        if (e.which == 13 || e.keyCode.ENTER) {
            ConsultaSector();
        }
    });
    $('#okSector').click(function () {
        ConsultaSector();
    });
    $('#FolioSAM_MAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validar();
        }
    });
    $('#ClaseAvisoMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#DescripMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#NotifiMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#FolioSAMMAA').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaFolioSAM();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
   $("#regresar").click(function(){
      back(); 
   });
   $("#finalizar").click(function(){
       back();
   });
   $("#cancelar").click(function(){
       back();
   });
   $("#aceptar").click(function(){
       validar();
   });
   
   
    
});

                    function startTime() {
                        today = new Date();
                        n = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        h = checkTime(n);
                        m = checkTime(m);
                        s = checkTime(s);
                        $("#tiempo").html(h + ":" + m + ":" + s);
                        t = setTimeout('startTime()', 500);
                    }
                    function checkTime(i)
                    {
                        if (i < 10) {
                            i = "0" + i;
                        }
                        return i;
                    }


                    function bloq() {
                        $("#iconmsg").css("visibility","hidden");
                        $("#guardar").prop("disabled",true);
                        $("#aviso_CAA").focus();
                    }
                    function back() {
                        window.location.href = "Bienvenido.jsp";
                    }
                    function ok() {
                        window.location.href = "CrearAviso.jsp";
                    }
                              

            function validate()
             {
            var avsap = $("#Aviso").val();
            var avsam = $("#FolioSAM_MAA").val();
            if (avsap.length < 1 && avsam.length < 1)
            {      
                mensajess(1,"audio/saperror.wav","images/advertencia.PNG");
                
            } else
            {
                enviarDatos(avsap, avsam);
            }
        }
        
        function check() {

            //MEnsaje de correcto
            mensajess(2,"audio/sapmsg.wav","images/aceptar.png");
            setTimeout(function () {
                $("#msg").html("");
                iconm.style.visibility = "hidden";
            }, 8000);
        }

        function inval() {
            //error
            mensajess(2,"audio/saperror.wav","images/advertencia.PNG");
            setTimeout(function () {
                $("#msg").html("");
                iconm.style.visibility = "hidden";
            }, 8000);
        }
        function mostrarVentanaModal(tipo) {
            switch (tipo) {
                case 'sap':
                    var theHandle = document.getElementById("handle");
                    var theRoot = document.getElementById("VentanaModalSAP");
                    Drag.init(theHandle, theRoot);
                    var ventana = document.getElementById('VentanaModalSAP');
                    abrirVentana(ventana);
                    $("#ClaseAvisoMAA").val("");
                    $("#ClaseAvisoMAA").focus();
                    $("#DescripMAA").val("");
                    $("#NotifiMAA").val("");
                    $("#FolioSAMMAA").val("");
                    $("#numAcMax").val("500");
                    break;
                case 'aviso':
                    var theHandle = document.getElementById("handle1");
                    var theRoot = document.getElementById("VentanaModal");
                    Drag.init(theHandle, theRoot);
                    var ventana = document.getElementById('VentanaModal');
                    abrirVentana(ventana);
                    $("#notificacion_av").focus();
                     break;    
            }
        }

        function abrirVentana(ventana) {
            ///abrir ventanas
          
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            var ancho = 350;
            var alto = 650;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            $("#iconmsg").css("visibility","hidden");
            $("#msg").html("");
        }

        function ocultarVentana(tipo) {
            switch (tipo) {
                case 'sap':
                    var ventana = document.getElementById('VentanaModalSAP');
                    ventana.style.display = 'none';
                    $("#BuscarParamSAP").css("display","block");
                    $("#ConsultaTabla1").css("display","none");
                    break;
                case 'aviso':
                    var ventana = document.getElementById('VentanaModal');
                    ventana.style.display = 'none';
                    $("#BuscarParam_u").css("display", "block");
                    $("#ConsultaTabla").css("display" ,"none");
                    $("#numAcMax").val("");
                    $("#DesaNotSAP").val("");
                    $("#notificacion_av").val("");
                    break;    
            }

        }
        function retornfil(id1,id2) {
            $("#"+id1).css("display","block");
            $("#"+id2).css("display","none");
        }

        function ConsultaFolioSAM() {
            var acc = "ConsultaModificarAviso";
            var aviso = $("#ClaseAvisoMAA").val();
            var descripcion = $("#DescripMAA").val();
            var notificacion = $("#NotifiMAA").val();
            var foliosam = $("#FolioSAMMAA").val();
            var ctd = $("#numAcMax").val();
            var enviar = "&Parametro1=" + aviso + "&Parametro2=" + descripcion + "&Parametro3=" + notificacion + "&Parametro4=" + foliosam + "&cdtmax=" + ctd;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionModuloModificarAvisos',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + enviar,
                    success: function (data) {
                    var rs = data;
                        if (rs == 0) {
                            ErrorBusquedaMatch();
                        } else {
                            $("#BuscarParamSAP").css("display","none");
                            $("#ConsultaTabla1").css("display" ,"block");
                            $("#cargarDatos1").html(rs);
                            fnc();
                            borramsg();
                        }
                    }

                });
        }

        function fnc() {
            document.getElementById('table-scroll').onscroll = function () {
                document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
            };
        }


        function seleccionar(obj, tipo) {
            switch (tipo) {
                case 'sap':
                    $("#FolioSAM_MAA").focus();
                    $("#FolioSAM_MAA").val(obj);
                    if (obj == "") {

                        //error
                        
                        var BE = document.createElement('audio');
                        BE.src = "audio/saperror.wav";
                        BE.play();
                        var okcon = "No se puede editar un folio SAP";
                        $("#iconmsg").css("visibility","visible");
                        $("#iconmsg").attr("src","images/aceptar.png");
                        $("#msg").html(okcon);
                    }
                    ocultarVentana(tipo);
                    break;
                case 'aviso':
                    $("#Aviso").focus();
                    $("#Aviso").val(obj);
                    if(obj == ""){

                        //error
                        var BE = document.createElement('audio');
                        BE.src = "audio/saperror.wav";
                        BE.play(); 
                     var okcon = "No se puede editar un folio SAP";
                     $("#iconmsg").css("visibility","visible");
                     $("#iconmsg").attr("src","images/aceptar.png");
                     $("#msg").html(okcon);
                    }
                    ocultarVentana(tipo);
                    break;    
                default:
                    break;
            }
        }
        function ErrorBusquedaMatch() {
            //MEnsaje de correcto
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
            var okcon = "Tabla de consulta vacia";
            $("#iconmsg").css("visibility","visible");
            $("#iconmsg").attr("src","images/aceptar.png");
            $("#msg").html(okcon);
        }
        function borramsg() {
            $("#iconmsg").css("visibility", "hidden");
            $("#msg").html("");
        }

        function enviarAviso(sam) {
            var acc = "Validarsam";
                    var enviar = "&Parametro1=" + sam;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionModuloVisualAvisos',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + enviar,
                    success: function (data) {
                    var rs = data;
                        if (rs == 1) {
                            window.location.href = "ModificarAviso.jsp?sam=" + sam;
                        } else {

                            //error
                            var BE = document.createElement('audio');
                            BE.src = "audio/saperror.wav";
                            BE.play();
                            $("#iconmsg").css("visibility", "visible");
                            $("#iconmsg").attr("src","images/advertencia.PNG");
                            $("#msg").html('El folio sam no existe:' + "00000" + sam);
                        }
                    }

                });
        }
        

        function ConsultaAviso() {
            var acc = "ConsultaMatchNotificacion";
            var avi = $("#notificacion_av").val();
            var DAvi = $("#DesaNotSAP").val();
            var ctdmax = $("#numAcMax").val();
            var folsam = "";
            var enviar = "&AvisoMatch=" + avi + "&DesAvisoSAPM=" + DAvi + "&CantidadMatch=" + ctdmax+"&FOLSAM="+folsam;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionModuloVisualAvisos',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + enviar,
                    success: function (data) {
                    var rs = data;
                        if (rs == 0) {
                        ErrorBusquedaMatch();
                        } else {
                            $("#BuscarParam_u").css("display","none");
                            $("#ConsultaTabla").css("display","block");
                            $("#CargarDatosNotificacion").html(rs);
                            fnc();
                            borrarmsg();
                        }
                    }

                });
        }
      
        function enviarDatos(avisosap, avisosam) {
            var acc = "ValidarAvis";
            var enviar = "&AVISAP=" + avisosap + "&AVISAM=" + avisosam;
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionModuloVisualAvisos',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + enviar,
                    success: function (data) {
                    var rs = data;
                        if (rs == 0) {
                            mensajess(0,"audio/saperror.wav","images/advertencia.PNG");
                            limpiar();
                        } else {
                            window.location.href = "ModificarAviso.jsp?P=" + avisosap + "&M="+avisosam;
                        }
                    }

                });
        }           

            function CArgarMne(){
                     var mensajOk = '<%=ORd%>';
                     if(mensajOk != 'null'){
                        setTimeout("MensaCO('"+mensajOk+"')",500);
                        }else{
                           borramsg();  
                        }
                        
                    }
