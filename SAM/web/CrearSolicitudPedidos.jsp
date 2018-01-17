
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
<%-- 
    Document   : CrearSolicitudPedidos
    Created on : 21/07/2016, 06:37:07 PM
    Author     : 
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%> 
<!DOCTYPE html>
<html> 
    <%
        String Nombre = (String) session.getAttribute("Usuario");
        String Idioma = (String) session.getAttribute("Idioma");
        try {
            if (Nombre.equals(null) || Nombre.equals("") || Nombre == null || Idioma.equals(null)) {
                session.invalidate();
                response.sendRedirect("index.jsp");
            } else {
    %>
    <%
        String propiedad = "";
        String ruta = "/WEB-INF/";
        if (Idioma.equals("ES")) {
            propiedad = "LanguageES.properties";
        } else if (Idioma.equals("EN")) {
            propiedad = "LanguageEN.properties";
        } else {
            propiedad = null;
        }

        String concatena = ruta + propiedad;
        URL url = application.getResource(concatena);
        InputStream in = url.openStream();
        Properties po = new Properties();
        po.load(in);
        String reso = po.getProperty("etiqueta.Resolucio");
        String MenInval = po.getProperty("etiqueta.FuncionInval_Menu");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String MenError = po.getProperty("etiqueta.errroCrarSC");
        String MenExito = po.getProperty("etiqueta.solicitudexito");
        String CampOb = po.getProperty("etiqueta.CompObligatorios");
        String docum = po.getProperty("etiqueta.SelciClasseDoc");
        String Enero = po.getProperty("etiqueta.Enero");
        String Febrero = po.getProperty("etiqueta.Febrero");
        String Marzo = po.getProperty("etiqueta.Marzo");
        String Abril = po.getProperty("etiqueta.Abril");
        String Mayo = po.getProperty("etiqueta.Mayo");
        String Junio = po.getProperty("etiqueta.Junio");
        String Julio = po.getProperty("etiqueta.Julio");
        String Agosto = po.getProperty("etiqueta.Agosto");
        String Septiembre = po.getProperty("etiqueta.Septiembre");
        String Octubre = po.getProperty("etiqueta.Octubre");
        String Noviembre = po.getProperty("etiqueta.Noviembre");
        String Diciembre = po.getProperty("etiqueta.Diciembre");
        String Lunes = po.getProperty("etiqueta.Lunes");
        String Martes = po.getProperty("etiqueta.Martes");
        String Miercoles = po.getProperty("etiqueta.Miercoles");
        String Jueves = po.getProperty("etiqueta.Jueves");
        String Viernes = po.getProperty("etiqueta.Viernes");
        String Sabado = po.getProperty("etiqueta.Sabado");
        String Domingo = po.getProperty("etiqueta.Domingo");

    %>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script>
            function CheckResolucion() {
                if (screen.width <= 500) {
                    var msgResolucion = '<%=reso%>';
                    alert(msgResolucion);

                    window.location.href = "Bienvenido.jsp";
                }
            }
            CheckResolucion();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleSolped.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/CrearSolPed.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.CSPtitulodesolped"));%></title>       
    </head>
    <body>

        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                        </li>
                    </ul>
                </div>
                <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
                <input  id="guardar" type="image" src="images/guarda.PNG" onclick="guardarTabla();"/>               
                <input  id="regresar" type="image" src="images/regresa.PNG"/>
                <input id="finalizar" type="image" src="images/cance.PNG"/>
                <input  id="cancelar"type="image" src="images/cancela.PNG"/>                
            </div>

            <script>
                function TruncateTable() {
                    /// alert("hola");
                    var url = "peticionCrearSolPed";
                    var acc = "VaciarTabla";
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function ()
                    {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                        {
                            var rs = xmlhttp.responseText;
                            //alert(rs);
                            if (rs == 1) {
                                window.location.href = "Bienvenido.jsp";
                            }

                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc, true);
                    xmlhttp.send();
                }
                function TruncateTablesave(f) {
                    /// alert("hola");
                    var url = "peticionCrearSolPed";
                    var acc = "VaciarTabla";
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function ()
                    {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                        {
                            var rs = xmlhttp.responseText;
                            if (rs == 1) {
                                ActualizarFolio();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc, true);
                    xmlhttp.send();
                }

                function guardarTabla()
                {
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                        {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.visibility = "visible";
                                iconm.src = "images/advertencia.PNG";
                                var men = document.getElementById("msg");
                                men.innerHTML = '<%=MenError%>';
                                document.getElementById('guardar').disabled = true;
                            } else {
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.visibility = "visible";
                                iconm.src = "images/aceptar.png";
                                var men = document.getElementById("msg");
                                men.innerHTML = "<%=MenExito%>" + " " + rs;
                                document.getElementById('TextCabecera_SP').value = "";
                                tablec();
                                document.getElementById('guardar').disabled = true;
                                TruncateTablesave(rs);

                            }
                        }
                    };
                    xmlhttp.open("GET", "PeticionSolPedV", true);
                    xmlhttp.send();
                }
                function ActualizarFolio() {
                    var acc = "nuevofolio";
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function ()
                    {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                        {
                            rs = xmlhttp.responseText;
                            if (rs == 1) {
                                
                            }

                        }
                    };
                    xmlhttp.open("GET", "peticionCargarPosicionSolPed?Accion=" + acc, true);
                    xmlhttp.send();

                }
                function checkCamposObligatorios() {
                    if ($('#Inputacion_SP').val() == "k" || $('#Inputacion_SP').val() == "K") {
                        $('#Material_SP').css("background-image", "none");
                        $('#textobreve_SP').css("background-image", "url(images/necesario.PNG)");
                        $('#GrpoArtic_SP').css("background-image", "url(images/necesario.PNG)");
                        $('#CentroCosto_SP').css("background-image", "url(images/necesario.PNG)");
                    } else if ($('#Inputacion_SP').val() == "f" || $('#Inputacion_SP').val() == "F") {
                        $('#Material_SP').css("background-image", "none");
                        $('#textobreve_SP').css("background-image", "url(images/necesario.PNG)");
                        $('#GrpoArtic_SP').css("background-image", "url(images/necesario.PNG)");
                        $('#Orden_SP').css("background-image", "url(images/necesario.PNG)");
                    } else {
                        $('#Material_SP').css("background-image", "url(images/necesario.PNG)");
                        $('#textobreve_SP').css("background-image", "none");
                        $('#GrpoArtic_SP').css("background-image", "none");
                        $('#CentroCosto_SP').css("background-image", "none");
                        $('#Orden_SP').css("background-image", "none");
                    }
                }
                function generarautoDatosObligatorios() {
                    $('#Material_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#Cantidad_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#UM_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#FechaEntr_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#Centro_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#Almacen_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#GpoCompras_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#Solicitante_SP').css("background-image", "url(images/necesario.PNG)");
                    $('#OrgCompras_SP').css("background-image", "url(images/necesario.PNG)");
                }
                function generarautoDatosObligatorios2() {
                    $('#Material_SP').css("background-image", "none");
                    $('#Cantidad_SP').css("background-image", "none");
                    $('#UM_SP').css("background-image", "none");
                    $('#FechaEntr_SP').css("background-image", "none");
                    $('#Centro_SP').css("background-image", "none");
                    $('#Almacen_SP').css("background-image", "none");
                    $('#GpoCompras_SP').css("background-image", "none");
                    $('#Solicitante_SP').css("background-image", "none");
                    $('#OrgCompras_SP').css("background-image", "none");
                    $('#CentroCosto_SP').css("background-image", "none");
                    $('#Orden_SP').css("background-image", "none");
                }
                function MensajeSalirModulo()
                {
                    var ventana = document.getElementById('MensajeSalirModulo');
                    var ancho = 350;
                    var alto = 650;
                    var x = (screen.width / 2) - (ancho / 2);
                    var y = (screen.height / 2) - (alto / 2);
                    ventana.style.left = x + "px";
                    ventana.style.top = y + "px";
                    ventana.style.display = 'block';
                }
                function CerrarMensajeSalirModulo()
                {
                    var ventana = document.getElementById('MensajeSalirModulo');
                    ventana.style.display = 'none';
                }
                function inval() {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "<%=MenInval%>";
                }
                function mostrarVentanaModal(tipo) {
                    switch (tipo) {
                        case "imputacion":
                            var ventana = document.getElementById('VentanaModalImputacion');
                            abrirVentana(ventana);
                            var txtimp = document.getElementById('BusTipoImputacion');
                            txtimp.focus();
                            break;
                        case "TipoPosicion":
                            var ventana2 = document.getElementById('VentanaModalTipoPosicion');
                            abrirVentana(ventana2);
                            var txtpos = document.getElementById('BusTipoPosicion');
                            txtpos.focus();
                            break;
                        case "Material":
                            var ventana3 = document.getElementById('VentanaModalMateriales');
                            abrirVentana(ventana3);
                            var txtmat = document.getElementById('BusMaterial');
                            BusquedaMaterial();
                            txtmat.focus();
                            break;
                        case "UM":
                            var ventana4 = document.getElementById('VentanaModalUM');
                            abrirVentana(ventana4);
                            var txtum = document.getElementById('BusUM');
                            txtum.focus();
                            break;
                        case "GArticulos":
                            var ventana5 = document.getElementById('VentanaModalGArticulos');
                            abrirVentana(ventana5);
                            var txtga = document.getElementById('BusGArtiulos');
                            txtga.focus();
                            break;
                        case "Centro":
                            var ventana6 = document.getElementById('VentanaModalCentro');
                            abrirVentana(ventana6);
                            var txtcen = document.getElementById('BusCentro');
                            txtcen.focus();
                            break;
                        case "Almacen":
                            var ventana7 = document.getElementById('VentanaModalAlmacen');
                            abrirVentana(ventana7);
                            var txtalm = document.getElementById('BusDenAlm');
                            txtalm.focus();
                            break;
                        case "GCompras":
                            var ventana8 = document.getElementById('VentanaModalGCompras');
                            abrirVentana(ventana8);
                            var txtgc = document.getElementById('BusGCompras');
                            txtgc.focus();
                            break;
                        case "proveedor":
                            var ventana9 = document.getElementById('VentanaModalProveedor');
                            abrirVentana(ventana9);
                            var txtpr = document.getElementById('BusAcreedorSP');
                            txtpr.focus();
                            break;
                        case "proveedorfijo":
                            var ventana10 = document.getElementById('VentanaModalProveedorFijo');
                            abrirVentana(ventana10);
                            var txtpro = document.getElementById('BusAcreedorFijoSP');
                            txtpro.focus();
                            break;
                        case "OCompras":
                            var ventana11 = document.getElementById('VentanaModalOrgCompras');
                            abrirVentana(ventana11);
                            var txtoc = document.getElementById('BusOComprasSP');
                            txtoc.focus();
                            break;
                        case "Contrato":
                            var ventana12 = document.getElementById('VentanaModalContrato');
                            abrirVentana(ventana12);
                            //var txtcon = document.getElementById('');
                            //txtcon.focus();
                            break;
                        case "Registro":
                            var ventana13 = document.getElementById('VentanaModalRegistro');
                            abrirVentana(ventana13);
                            var txtreg = document.getElementById('BusRegistroSP');
                            txtreg.focus();
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
                    $('#overlay').remove();
                    switch (tipo) {
                        case "imputacion":
                            var ventana = document.getElementById('VentanaModalImputacion');
                            ventana.style.display = 'none';
                            document.getElementById("BuscarParamImputacion_SP").style.display = "block";
                            document.getElementById("ConsultaTablaImputacion").style.display = "none";
                            document.getElementById("Inputacion_SP").focus();
                            borramsg();
                            break;
                        case "TipoPosicion":
                            var ventana2 = document.getElementById('VentanaModalTipoPosicion');
                            ventana2.style.display = 'none';
                            document.getElementById("BuscarParamTipoPosicion_SP").style.display = "block";
                            document.getElementById("ConsultaTablaTipoPosicion").style.display = "none";
                            document.getElementById("Posicion_SP").focus();
                            borramsg();
                            break;
                        case "Material":
                            var ventana3 = document.getElementById('VentanaModalMateriales');
                            ventana3.style.display = 'none';
                            document.getElementById("BuscarParamMateriales_SP").style.display = "block";
                            document.getElementById("ConsultaTablaMaterial").style.display = "none";
                            document.getElementById("ConsultaTablaServicio").style.display = "none";
                            document.getElementById("Material_SP").focus();
                            borramsg();
                            break;
                        case "UM":
                            var ventana4 = document.getElementById('VentanaModalUM');
                            ventana4.style.display = 'none';
                            document.getElementById("BuscarParamUM_SP").style.display = "block";
                            document.getElementById("ConsultaTablaUM").style.display = "none";
                            document.getElementById("UM_SP").focus();
                            borramsg();
                            break;
                        case "GArticulos":
                            var ventana5 = document.getElementById('VentanaModalGArticulos');
                            ventana5.style.display = 'none';
                            document.getElementById("BuscarParamGArticulos_SP").style.display = "block";
                            document.getElementById("ConsultaTablaGArticulos").style.display = "none";
                            document.getElementById("GrpoArtic_SP").focus();
                            borramsg();
                            break;
                        case "Centro":
                            var ventana6 = document.getElementById('VentanaModalCentro');
                            ventana6.style.display = 'none';
                            document.getElementById("BuscarParamCentro_SP").style.display = "block";
                            document.getElementById("ConsultaTablaCentro").style.display = "none";
                            document.getElementById("Centro_SP").focus();
                            borramsg();
                            break;
                        case "Almacen":
                            var ventana7 = document.getElementById('VentanaModalAlmacen');
                            ventana7.style.display = 'none';
                            document.getElementById("BuscarParamAlmacen_SP").style.display = "block";
                            document.getElementById("ConsultaTablaAlmacen").style.display = "none";
                            document.getElementById("Almacen_SP").focus();
                            borramsg();
                            break;
                        case "GCompras":
                            var ventana8 = document.getElementById('VentanaModalGCompras');
                            ventana8.style.display = 'none';
                            document.getElementById("BuscarParamGCompras_SP").style.display = "block";
                            document.getElementById("ConsultaTablaGCompras").style.display = "none";
                            document.getElementById("GpoCompras_SP").focus();
                            borramsg();
                            break;
                        case "proveedor":
                            var ventana9 = document.getElementById('VentanaModalProveedor');
                            ventana9.style.display = 'none';
                            document.getElementById("BuscarParam_Prov").style.display = "block";
                            document.getElementById("ConsultaTablaProveedor").style.display = "none";
                            document.getElementById("ProvDesea_SP").focus();
                            borramsg();
                            break;
                        case "proveedorfijo":
                            var ventana10 = document.getElementById('VentanaModalProveedorFijo');
                            ventana10.style.display = 'none';
                            document.getElementById("BuscarParam_ProvFijo").style.display = "block";
                            document.getElementById("ConsultaTablaProveedorFijo").style.display = "none";
                            document.getElementById("ProvFijo_SP").focus();
                            borramsg();
                            break;
                        case "OCompras":
                            var ventana11 = document.getElementById('VentanaModalOrgCompras');
                            ventana11.style.display = 'none';
                            document.getElementById("BuscarParamOCompras_SP").style.display = "block";
                            document.getElementById("ConsultaTablaOCompras").style.display = "none";
                            document.getElementById("OrgCompras_SP").focus();
                            borramsg();
                            break;
                        case "Contrato":
                            var ventana12 = document.getElementById('VentanaModalContrato');
                            ventana12.style.display = 'none';
                            document.getElementById("BuscarParamContrato_SP").style.display = "block";
                            document.getElementById("ConsultaTablaContrato").style.display = "none";
                            document.getElementById("Contrato_SP").focus();
                            borramsg();
                            break;
                        case "Registro":
                            var ventana13 = document.getElementById('VentanaModalRegistro');
                            ventana13.style.display = 'none';
                            document.getElementById("BuscarParamRegistro_SP").style.display = "block";
                            document.getElementById("ConsultaTablaRegistro").style.display = "none";
                            document.getElementById("RegInfor_SP").focus();
                            borramsg();
                            break;
                    }
                }

                ///////////////////// Consulta Imputacion 
                function ConsultaImputacion() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarTipoImputacion";
                    var idi = '<%=Idioma%>';
                    var tipo = document.getElementById("BusTipoImputacion").value;
                    var deno = document.getElementById("BusDenImputacion").value;
                    var ctd = document.getElementById("numAcMax").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamImputacion_SP").style.display = "none";
                                document.getElementById("ConsultaTablaImputacion").style.display = "block";
                                document.getElementById("cargarDatosImputación").innerHTML = rs;
                                fnc();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&TipoImp=" + tipo + "&DenImp=" + deno + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                ///// Consulta Match Tipo posicion
                function ConsultaTipoPosicion() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarTipoPosicion";
                    var idi = '<%=Idioma%>';
                    var tipo = document.getElementById("BusTipoPosicion").value;
                    var texto = document.getElementById("BusTextoTipoPosicion").value;
                    var ctd = document.getElementById("numAcMax2").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamTipoPosicion_SP").style.display = "none";
                                document.getElementById("ConsultaTablaTipoPosicion").style.display = "block";
                                document.getElementById("cargarDatosTipoImputacion").innerHTML = rs;
                                fnc2();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&TipoPos=" + tipo + "&TextoPos=" + texto + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }

                ////// Consulta Match Materiales
                function ConsultaMaterial() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarMateriales";
                    var idi = '<%=Idioma%>';
                    var usu = '<%=Nombre%>';
                    var Mat = document.getElementById("BusMaterial").value;
                    var texto = document.getElementById("BusTextoMaterial").value;
                    var cent = document.getElementById("BusCentroMaterial").value;
                    var ctd = document.getElementById("numAcMax3").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamMateriales_SP").style.display = "none";
                                document.getElementById("ConsultaTablaServicio").style.display = "none";
                                document.getElementById("ConsultaTablaMaterial").style.display = "block";
                                document.getElementById("cargarDatosMateriales").innerHTML = rs;
                                fnc3();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Material=" + Mat + "&TextoMat=" + texto + "&Centro=" + cent + "&Ctd=" + ctd + "&Idioma=" + idi + "&Usuario=" + usu, true);
                    xmlhttp.send();
                }
                function ConsultaServicio() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarServicio";
                    var idi = '<%=Idioma%>';
                    var Servicio = document.getElementById("BusServicio").value;
                    var Stexto = document.getElementById("BusTextoServicio").value;
                    var ctd = document.getElementById("numAcMaxS").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;

                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamServicio_SP").style.display = "none";
                                document.getElementById("ConsultaTablaMaterial").style.display = "none";
                                document.getElementById("ConsultaTablaServicio").style.display = "block";
                                document.getElementById("cargarDatosServicio").innerHTML = rs;
                                fncS();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Servicio=" + Servicio + "&TextoServ=" + Stexto + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaUM() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarUM";
                    var idi = '<%=Idioma%>';
                    var Mat = document.getElementById("Material_SP").value;
                    var UM = document.getElementById("BusUM").value;
                    var TextUM = document.getElementById("BusTextoUM").value;
                    var ctd = document.getElementById("numAcMax4").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamUM_SP").style.display = "none";
                                document.getElementById("ConsultaTablaUM").style.display = "block";
                                document.getElementById("cargarDatosUM").innerHTML = rs;
                                fnc4();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Material=" + Mat + "&UM=" + UM + "&TextoUM=" + TextUM + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }

                function ConsultaGArticulos() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarGArticulos";
                    var idi = '<%=Idioma%>';
                    var Mat = document.getElementById("Material_SP").value;
                    var GArt = document.getElementById("BusGArtiulos").value;
                    var DGArt = document.getElementById("BusDenGArt").value;
                    var ctd = document.getElementById("numAcMax5").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamGArticulos_SP").style.display = "none";
                                document.getElementById("ConsultaTablaGArticulos").style.display = "block";
                                document.getElementById("cargarDatoGArticulos").innerHTML = rs;
                                fnc5();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Material=" + Mat + "&GArt=" + GArt + "&DGArt=" + DGArt + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaCentro() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarCentro";
                    var idi = '<%=Idioma%>';
                    var Mat = document.getElementById("Material_SP").value;
                    var Cen = document.getElementById("BusCentro").value;
                    var Nom = document.getElementById("BusDesCentro").value;
                    var ctd = document.getElementById("numAcMax6").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamCentro_SP").style.display = "none";
                                document.getElementById("ConsultaTablaCentro").style.display = "block";
                                document.getElementById("cargarDatoCentro").innerHTML = rs;
                                fnc6();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Material=" + Mat + "&CentroSP=" + Cen + "&CentroNomSP=" + Nom + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaAlmacen() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarAlmacen";
                    var idi = '<%=Idioma%>';
                    var DenAlm = document.getElementById("BusDenAlm").value;
                    var Almacen = document.getElementById("BusAlmacen").value;
                    var Centr = document.getElementById("BusCentroAlmacen").value;
                    var ctd = document.getElementById("numAcMax7").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamAlmacen_SP").style.display = "none";
                                document.getElementById("ConsultaTablaAlmacen").style.display = "block";
                                document.getElementById("cargarDatoAlmacen").innerHTML = rs;
                                fnc7();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&DenAlm=" + DenAlm + "&Almacen=" + Almacen + "&CentroSP=" + Centr + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaGCompras() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarGCompras";
                    var idi = '<%=Idioma%>';
                    var Mat = document.getElementById("Material_SP").value;
                    var GCompras = document.getElementById("BusGCompras").value;
                    var DenGCompras = document.getElementById("BusDenGCompras").value;
                    var ctd = document.getElementById("numAcMax8").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamGCompras_SP").style.display = "none";
                                document.getElementById("ConsultaTablaGCompras").style.display = "block";
                                document.getElementById("cargarDatoGCompras").innerHTML = rs;
                                fnc8();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Material=" + Mat + "&GCompras=" + GCompras + "&DenGCompras=" + DenGCompras + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaProveedor() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarProveedor";
                    var Acreedor = document.getElementById("BusAcreedorSP").value;
                    var NomAcree = document.getElementById("BusNomAcreSP").value;
                    var ctd = document.getElementById("numAcMax9").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParam_Prov").style.display = "none";
                                document.getElementById("ConsultaTablaProveedor").style.display = "block";
                                document.getElementById("cargarDatosProveedor").innerHTML = rs;
                                fnc9();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Acreedor=" + Acreedor + "&NombreAcreedor=" + NomAcree + "&Ctd=" + ctd, true);
                    xmlhttp.send();
                }
                function ConsultaProveedorFijo() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarProveedorFijo";
                    var Acreedor = document.getElementById("BusAcreedorFijoSP").value;
                    var NomAcree = document.getElementById("BusNomAcreFijoSP").value;
                    var ctd = document.getElementById("numAcMax10").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParam_ProvFijo").style.display = "none";
                                document.getElementById("ConsultaTablaProveedorFijo").style.display = "block";
                                document.getElementById("cargarDatosProveedorFijo").innerHTML = rs;
                                fnc10();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Acreedor=" + Acreedor + "&NombreAcreedor=" + NomAcree + "&Ctd=" + ctd, true);
                    xmlhttp.send();
                }
                function ConsultaOCompras() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarOCompras";
                    var idi = '<%=Idioma%>';
                    var OCompras = document.getElementById("BusOComprasSP").value;
                    var DenOcompras = document.getElementById("BusDenOComSP").value;
                    var ctd = document.getElementById("numAcMax11").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                                document.getElementById("ConsultaTablaOCompras").style.display = "block";
                                document.getElementById("cargarDatosOCompras").innerHTML = rs;
                                fnc11();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&OCompras=" + OCompras + "&DenOCompras=" + DenOcompras + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaContrato() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarContrato";
                    var idi = '<%=Idioma%>';
                    var ctd = document.getElementById("numAcMax12").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamContrato_SP").style.display = "none";
                                document.getElementById("ConsultaTablaContrato").style.display = "block";
                                document.getElementById("cargarDatosContrato").innerHTML = rs;
                                fnc12();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function ConsultaRegistro() {
                    var url = "peticionCrearSolPed";
                    var acc = "ConsultarRegistro";
                    var idi = '<%=Idioma%>';
                    var Registro = document.getElementById("BusRegistroSP").value;
                    var ctd = document.getElementById("numAcMax13").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            rs = xmlhttp.responseText;
                            if (rs == 0) {
                                ErrorBusquedaMatch();
                            } else {
                                document.getElementById("BuscarParamRegistro_SP").style.display = "none";
                                document.getElementById("ConsultaTablaRegistro").style.display = "block";
                                document.getElementById("cargarDatosRegistro").innerHTML = rs;
                                fnc13();
                                borramsg();
                            }
                        }
                    };
                    xmlhttp.open("GET", url + "?Accion=" + acc + "&RegistroInfo=" + Registro + "&Ctd=" + ctd + "&Idioma=" + idi, true);
                    xmlhttp.send();
                }
                function Select(dato, element) {
                    switch (element) {
                        case 'imputacion':
                            ocultarVentana("imputacion");
                            var imp = document.getElementById("Inputacion_SP");
                            imp.value = dato;
                            imp.focus();
                            break;
                        case 'TipoPosicion':
                            ocultarVentana("TipoPosicion");
                            var pos = document.getElementById("Posicion_SP");
                            pos.value = dato;
                            pos.focus();
                            break;
                        case 'UM':
                            ocultarVentana("UM");
                            var um = document.getElementById("UM_SP");
                            um.value = dato;
                            um.focus();
                            break;
                        case 'GArticulos':
                            ocultarVentana("GArticulos");
                            var ga = document.getElementById("GrpoArtic_SP");
                            ga.value = dato;
                            ga.focus();
                            break;
                        case 'Centro':
                            ocultarVentana("Centro");
                            var ce = document.getElementById("Centro_SP");
                            ce.value = dato;
                            ce.focus();
                            break;
                        case 'Almacen':
                            ocultarVentana("Almacen");
                            var al = document.getElementById("Almacen_SP");
                            al.value = dato;
                            al.focus();
                            break;
                        case 'GCompras':
                            ocultarVentana("GCompras");
                            var gc = document.getElementById("GpoCompras_SP");
                            gc.value = dato;
                            gc.focus();
                            break;
                        case 'proveedor':
                            ocultarVentana("proveedor");
                            var pro = document.getElementById("ProvDesea_SP");
                            pro.value = dato;
                            pro.focus();

                            break;
                        case 'proveedorfijo':
                            ocultarVentana("proveedorfijo");
                            var prof = document.getElementById("ProvFijo_SP");
                            prof.value = dato;
                            prof.focus();
                            break;
                        case 'OCompras':
                            ocultarVentana("OCompras");
                            var oc = document.getElementById("OrgCompras_SP");
                            oc.value = dato;
                            oc.focus();
                            break;
                        case 'Contrato':
                            ocultarVentana("Contrato");
                            var con = document.getElementById("Contrato_SP");
                            con.value = dato;
                            con.focus();
                            break;
                        case 'Registro':
                            ocultarVentana("Registro");
                            var reg = document.getElementById("RegInfor_SP");
                            reg.value = dato;
                            reg.focus();
                            break;
                        case 'Servicio':
                            ocultarVentana("Material");
                            var m = document.getElementById("Material_SP");
                            m.value = dato;
                            m.focus();
                            break;



                    }
                }
                function SelectMaterial(mat, des, um, gpoArt, cen, gpoCom) {
                    ocultarVentana("Material");
                    var m = document.getElementById("Material_SP");
                    m.value = mat;
                    $('#Material_SP').css("background-image", "none");
                    ///
                    var d = document.getElementById("textobreve_SP");
                    d.value = des;
                    $('#textobreve_SP').css("background-image", "none");
                    ///
                    var u = document.getElementById("UM_SP");
                    u.value = um;
                    $('#UM_SP').css("background-image", "none");
                    ///
                    var ga = document.getElementById("GrpoArtic_SP");
                    ga.value = gpoArt;
                    $('#GrpoArtic_SP').css("background-image", "none");
                    ///
                    var c = document.getElementById("Centro_SP");
                    c.value = cen;
                    $('#Centro_SP').css("background-image", "none");
                    ///
                    var gc = document.getElementById("GpoCompras_SP");
                    gc.value = gpoCom;
                    $('#GpoCompras_SP').css("background-image", "none");
                }
                //// Funciones Adicionales
                function ErrorBusquedaMatch() {
                    var okcon = "<%=menValores%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
                function borramsg() {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                }
                function fnc() {
                    document.getElementById('table-scrollImputacion').onscroll = function () {
                        document.getElementById('fixedYImputacion').style.top = document.getElementById('table-scrollImputacion').scrollTop + 'px';
                    };
                }
               

                function ValidarMaximo(num) {
                    if (num >= 100) {
                        document.getElementById("numAcMax").value = 100;
                        document.getElementById("numAcMax2").value = 100;
                        document.getElementById("numAcMax3").value = 100;
                        document.getElementById("numAcMax4").value = 100;
                        document.getElementById("numAcMax5").value = 100;
                        document.getElementById("numAcMax6").value = 100;
                        document.getElementById("numAcMax7").value = 100;
                        document.getElementById("numAcMax8").value = 100;
                        document.getElementById("numAcMax9").value = 100;
                        document.getElementById("numAcMax10").value = 100;
                        document.getElementById("numAcMax11").value = 100;
                        document.getElementById("numAcMax12").value = 100;
                        document.getElementById("numAcMax13").value = 100;
                        document.getElementById("numAcMaxS").value = 100;

                    } else if (num < 1) {
                        document.getElementById("numAcMax").value = 100;
                        document.getElementById("numAcMax2").value = 100;
                        document.getElementById("numAcMax3").value = 100;
                        document.getElementById("numAcMax4").value = 100;
                        document.getElementById("numAcMax5").value = 100;
                        document.getElementById("numAcMax6").value = 100;
                        document.getElementById("numAcMax7").value = 100;
                        document.getElementById("numAcMax8").value = 100;
                        document.getElementById("numAcMax9").value = 100;
                        document.getElementById("numAcMax10").value = 100;
                        document.getElementById("numAcMax11").value = 100;
                        document.getElementById("numAcMax12").value = 100;
                        document.getElementById("numAcMax13").value = 100;
                        document.getElementById("numAcMaxS").value = 100;
                    }
                }

            </script>

            <div id="Cont" hidden></div> 
            <div class="contenido">
                <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.CSPtitulodesolped"));%></h1></div>      
                <div class="ContenidoScrollbar">
                    <div class="ContentSolped">             
                        <div class="div1SolPed">
                            <div class="subdiv1Solped">
                                <label style="width: 10%;"><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></label>
                                <select id="claseDoc" style="margin-left: 2%; width: 20%;">
                                    <option></option>
                                    <option value="FO"><%out.println(po.getProperty("etiqueta.CSPFOClaseDocumento1"));%></option>
                                    <option value="NB"><%out.println(po.getProperty("etiqueta.CSPFOClaseDocumento2"));%></option>
                                    <option value="NC"><%out.println(po.getProperty("etiqueta.CSPFOClaseDocumento3"));%></option>
                                    <option value="RV"><%out.println(po.getProperty("etiqueta.CSPFOClaseDocumento4"));%></option>
                                </select>


                                <br>
                                <textarea rows="4" cols="1"  style="resize:none;" id="TextCabecera_SP" maxlength="130"></textarea>
                                <br>
                                <label style="width: 8%;"><%out.println(po.getProperty("etiqueta.CSPPosciones"));%></label>
                                <hr style="margin-top: -1px; margin-left: 0; width: 8%;">
                                <br>                                
                            </div>

                            <script>
                                /////// Funciones Tabla
                                function tablec() {
                                    var xmlhttp = new XMLHttpRequest();
                                    xmlhttp.onreadystatechange = function ()
                                    {
                                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                        {
                                            document.getElementById("SecTab").innerHTML = xmlhttp.responseText;
                                            AgregarList();
                                            LimpiarSP();
                                        }
                                    };
                                    xmlhttp.open("GET", "PeticionSolPed", true);
                                    xmlhttp.send();
                                }
                                function AgregarTabla()
                                {
                                    //// orden en la BD (van en orden descendiente de la bd) falta agregar abajo donde envias los datos al servlet
                                    var valor = document.getElementById("DetallePosicion").value;
                                    var val = valor.replace("0", "");
                                    //alert(val);
                                    var doc = document.getElementById("claseDoc").value; ////// clase_documento 
                                    var ti = document.getElementById('Inputacion_SP').value;/// tipo_imputacion
                                    var mat = document.getElementById('Material_SP').value; /// num_material
                                    var tb = document.getElementById('textobreve_SP').value;/// texto_breve
                                    var cnt = document.getElementById('Cantidad_SP').value;//// cantidad_solped
                                    var um = document.getElementById('UM_SP').value;/////////// unidad_medida_pedido
                                    var fe = document.getElementById('FechaEntr_SP').value;//// fecha_entraga_posicion
                                    var ga = document.getElementById('GrpoArtic_SP').value;//// grupo_articulos
                                    var ctr = document.getElementById('Centro_SP').value;////// centro
                                    var alm = document.getElementById('Almacen_SP').value;///// almacen
                                    var gc = document.getElementById('GpoCompras_SP').value;/// grupo_compras
                                    var sl = document.getElementById('Solicitante_SP').value;// nombre_solicitante
                                    var fc = document.getElementById('fcrea').value;//////////// fecha_solicitud
                                    var pd = document.getElementById('ProvDesea_SP').value;///// proveedor_deseado
                                    var pf = document.getElementById('ProvFijo_SP').value;////// num_proveedor
                                    var oc = document.getElementById('OrgCompras_SP').value;//// organizacion_compras
                                    var con = document.getElementById('Contrato_SP').value;///// contrato
                                    var pc = document.getElementById('PosContrato_SP').value;/// posicion_contrato
                                    var tp = document.getElementById('Posicion_SP').value;////// tipo_posicion_doc_compras
                                    var ri = document.getElementById('RegInfor_SP').value;////// num_registro_info
                                    var dis = document.getElementById('Distribucion_SP').value;// distribucion
                                    var cm = document.getElementById('CtaMayor_SP').value;/////// cuenta_mayor
                                    var sc = document.getElementById('SocCP_SP').value;////////// sociedad_cp
                                    var cc = document.getElementById('CentroCosto_SP').value;//// centro_coste
                                    var txc = document.getElementById('TextCabecera_SP').value;// texto_cabecera
                                    var txp = document.getElementById('TextPos_SP').value;/////// texto posicion
                                    var enviapart1 = "&ti=" + ti + "&mat=" + mat + "&tb=" + tb + "&cnt=" + cnt + "&um=" + um + "&fe=" + fe + "&ga=" + ga + "&ctr=" + ctr + "&alm=" + alm;
                                    var enviapart2 = enviapart1 + "&gc=" + gc + "&sl=" + sl + "&fc=" + fc + "&pd=" + pd + "&pf=" + pf + "&oc=" + oc + "&con=" + con + "&pc=" + pc + "&tp=" + tp;
                                    var enviapart3 = enviapart2 + "&ri=" + ri + "&dis=" + dis + "&cm=" + cm + "&sc=" + sc + "&cc=" + cc + "&txtc=" + txc + "&txtp=" + txp;
                                    var xmlhttp = new XMLHttpRequest();
                                    xmlhttp.onreadystatechange = function ()
                                    {
                                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                        {
                                            document.getElementById("SecTab").innerHTML = xmlhttp.responseText;
                                            document.getElementById('guardar').disabled = false;
                                            AgregarList();
                                            LimpiarSP();
                                            generarautoDatosObligatorios();
                                        }
                                    };
                                    xmlhttp.open("GET", "PeticionSolPed?id=" + val + "&doc=" + doc + enviapart3, true);
                                    xmlhttp.send();
                                }
                                function AgregarList()
                                {
                                    var xmlhttp = new XMLHttpRequest();
                                    xmlhttp.onreadystatechange = function ()
                                    {
                                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                        {
                                            document.getElementById("DetallePosicion").innerHTML = xmlhttp.responseText;
                                            LimpiarSP();

                                        }
                                    };
                                    xmlhttp.open("GET", "PeticionSolPedList", true);
                                    xmlhttp.send();
                                }
                                function LimpiarSP()
                                {
                                    //Textos
                                    // document.getElementById('TextCabecera_SP').value = "";
                                    document.getElementById('TextPos_SP').value = "";
                                    //Lado izquierdo
                                    document.getElementById('Inputacion_SP').value = "";
                                    document.getElementById('Posicion_SP').value = "";
                                    document.getElementById('Material_SP').value = "";
                                    document.getElementById('textobreve_SP').value = "";
                                    document.getElementById('Cantidad_SP').value = "";
                                    document.getElementById('UM_SP').value = "";
                                    document.getElementById('FechaEntr_SP').value = "";
                                    document.getElementById('GrpoArtic_SP').value = "";
                                    document.getElementById('Centro_SP').value = "";
                                    document.getElementById('Almacen_SP').value = "";
                                    document.getElementById('GpoCompras_SP').value = "";
                                    document.getElementById('Solicitante_SP').value = '<%=Nombre%>';
                                    //Lado Derecho
                                    document.getElementById('NumNece_SP').value = "";
                                    document.getElementById('ProvDesea_SP').value = "";
                                    document.getElementById('ProvFijo_SP').value = "";
                                    document.getElementById('OrgCompras_SP').value = "";
                                    document.getElementById('Contrato_SP').value = "";
                                    document.getElementById('PosContrato_SP').value = "";
                                    document.getElementById('RegInfor_SP').value = "";
                                    document.getElementById('Distribucion_SP').value = "";
                                    document.getElementById('CtaMayor_SP').value = "";
                                    document.getElementById('SocCP_SP').value = "";
                                    document.getElementById('CentroCosto_SP').value = "";
                                }
                                function DatosObligatorios() {
                                    //// sin imputacion sin posicion
                                    var ClaseDoc = document.getElementById('claseDoc').value;
                                    var mat = document.getElementById('Material_SP').value;
                                    var cnt = document.getElementById('Cantidad_SP').value;
                                    var cnt = document.getElementById('Cantidad_SP').value;
                                    var um = document.getElementById('UM_SP').value;
                                    var fe = document.getElementById('FechaEntr_SP').value;
                                    var ctr = document.getElementById('Centro_SP').value;
                                    var alm = document.getElementById('Almacen_SP').value;
                                    var gc = document.getElementById('GpoCompras_SP').value;
                                    var sl = document.getElementById('Solicitante_SP').value;
                                    var oc = document.getElementById("OrgCompras_SP").value;
                                    //////// tipo imputacion
                                    var ti = document.getElementById('Inputacion_SP').value;
                                    //var tp = document.getElementById('Posicion_SP').value;
                                    var tb = document.getElementById('textobreve_SP').value;
                                    var cc = document.getElementById('CentroCosto_SP').value;
                                    var or = document.getElementById("Orden_SP").value;

                                    if (ClaseDoc.length > 0) {
                                        if (ti < 1) {
                                            if (mat.length < 1 || cnt.length < 1 || um.length < 1 || fe.length < 1 || ctr.length < 1 || alm.length < 1 || gc.length < 1 || sl.length < 1 || oc.length < 1) {
                                                var iconm = document.getElementById("iconmsg");
                                                iconm.style.visibility = "visible";
                                                iconm.src = "images/aceptar.png";
                                                var men = document.getElementById("msg");
                                                men.innerHTML = '<%=CampOb%>';
                                            } else {
                                                borramsg();
                                                AgregarTabla();
                                            }

                                        } else {
                                            if (ti == "k" || ti == "K") {
                                                if (tb.length < 1 || cnt.length < 1 || um.length < 1 || fe.length < 1 || ctr.length < 1 || alm.length < 1 || gc.length < 1 || sl.length < 1 || oc.length < 1 || cc.length < 1) {
                                                    var iconm = document.getElementById("iconmsg");
                                                    iconm.style.visibility = "visible";
                                                    iconm.src = "images/aceptar.png";
                                                    var men = document.getElementById("msg");
                                                    men.innerHTML = '<%=CampOb%>';
                                                } else {
                                                    borramsg();
                                                    AgregarTabla();
                                                }
                                            }
                                            if (ti == "f" || ti == "F") {
                                                if (tb.length < 1 || cnt.length < 1 || um.length < 1 || fe.length < 1 || ctr.length < 1 || alm.length < 1 || gc.length < 1 || sl.length < 1 || oc.length < 1 || or.length < 1) {
                                                    var iconm = document.getElementById("iconmsg");
                                                    iconm.style.visibility = "visible";
                                                    iconm.src = "images/aceptar.png";
                                                    var men = document.getElementById("msg");
                                                    men.innerHTML = '<%=CampOb%>';
                                                } else {
                                                    borramsg();
                                                    AgregarTabla();
                                                }
                                            }

                                        }

                                    } else {
                                        var iconm = document.getElementById("iconmsg");
                                        iconm.style.visibility = "visible";
                                        iconm.src = "images/aceptar.png";
                                        var men = document.getElementById("msg");
                                        men.innerHTML = '<%=docum%>';
                                    }
                                }
                                function ValidarPorDatos() {

                                    var ti = document.getElementById('Inputacion_SP').value;/// tipo_imputacion
                                    var mat = document.getElementById('Material_SP').value; /// num_material
                                    var um = document.getElementById('UM_SP').value;/////////// unidad_medida_pedido                                  
                                    var ga = document.getElementById('GrpoArtic_SP').value;//// grupo_articulos
                                    var ctr = document.getElementById('Centro_SP').value;////// centro
                                    var alm = document.getElementById('Almacen_SP').value;///// almacen
                                    var gc = document.getElementById('GpoCompras_SP').value;/// grupo_compras
                                    var sl = document.getElementById('Solicitante_SP').value;// nombre_solicitante
                                    var pd = document.getElementById('ProvDesea_SP').value;///// proveedor_deseado
                                    var pf = document.getElementById('ProvFijo_SP').value;////// num_proveedor
                                    var oc = document.getElementById('OrgCompras_SP').value;//// organizacion_compras
                                    var tp = document.getElementById('Posicion_SP').value;////// tipo_posicion_doc_compras
                                    var ri = document.getElementById('RegInfor_SP').value;////// num_registro_info
                                    var sc = document.getElementById('SocCP_SP').value;////////// sociedad_cp
                                    var cc = document.getElementById('CentroCosto_SP').value;//// centro_coste
                                    var url = "peticionValidarCamposSolped";
                                    var datos = "?TI=" + ti + "&MAT=" + mat + "&UM=" + um + "&GA=" + ga + "&CE=" + ctr + "&Al=" + alm + "&GC=" + gc + "&SL=" + sl;
                                    var data = datos + "&PD=" + pd + "&PF=" + pf + "&OC=" + oc + "&TP=" + tp + "&RI=" + ri + "&SC=" + sc + "&CC=" + cc;
                                    var xmlhttp = new XMLHttpRequest();
                                    xmlhttp.onreadystatechange = function ()
                                    {
                                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                        {
                                            var rs = xmlhttp.responseText;
                                        }
                                    };
                                    xmlhttp.open("GET", url + data, true);
                                    xmlhttp.send();
                                }
                                function SeleccionarPosicion(valor) {
                                    if (valor.length == 0 || valor == null) {
                                        LimpiarSP();

                                    } else {
                                        var val = valor.replace("0", "");

                                        var acc = "ObtenerPosicion";
                                        var xmlhttp = new XMLHttpRequest();
                                        xmlhttp.onreadystatechange = function ()
                                        {
                                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                            {
                                                document.getElementById("datossobrecargados").innerHTML = xmlhttp.responseText;
                                                cargardatos();
                                            }
                                        };
                                        xmlhttp.open("GET", "peticionCargarPosicionSolPed?Accion=" + acc + "&Posicion=" + val, true);
                                        xmlhttp.send();
                                    }
                                }
                                function cargardatos() {
                                    generarautoDatosObligatorios2();
                                    var impu = document.getElementById("Inputacion_SP1").value;
                                    document.getElementById("Inputacion_SP").value = impu;
                                    var tipp = document.getElementById("Posicion_SP1").value;
                                    document.getElementById("Posicion_SP").value = tipp;
                                    var mate = document.getElementById("Material_SP1").value;
                                    document.getElementById("Material_SP").value = mate;
                                    var text = document.getElementById("textobreve_SP1").value;
                                    document.getElementById("textobreve_SP").value = text;
                                    var can = document.getElementById("Cantidad_SP1").value;
                                    document.getElementById("Cantidad_SP").value = can;
                                    var um = document.getElementById("UM_SP1").value;
                                    document.getElementById("UM_SP").value = um;
                                    var fe = document.getElementById("FechaEntr_SP1").value;
                                    document.getElementById("FechaEntr_SP").value = fe;
                                    var ga = document.getElementById("GrpoArtic_SP1").value;
                                    document.getElementById("GrpoArtic_SP").value = ga;
                                    var cen = document.getElementById("Centro_SP1").value;
                                    document.getElementById("Centro_SP").value = cen;
                                    var al = document.getElementById("Almacen_SP1").value;
                                    document.getElementById("Almacen_SP").value = al;
                                    var gc = document.getElementById("GpoCompras_SP1").value;
                                    document.getElementById("GpoCompras_SP").value = gc;
                                    var sol = document.getElementById("Solicitante_SP1").value;
                                    document.getElementById("Solicitante_SP").value = sol;
                                    var prod = document.getElementById("ProvDesea_SP1").value;
                                    document.getElementById("ProvDesea_SP").value = prod;
                                    var prof = document.getElementById("ProvFijo_SP1").value;
                                    document.getElementById("ProvFijo_SP").value = prof;
                                    var oc = document.getElementById("OrgCompras_SP1").value;
                                    document.getElementById("OrgCompras_SP").value = oc;
                                    var con = document.getElementById("Contrato_SP1").value;
                                    document.getElementById("Contrato_SP").value = con;
                                    var posC = document.getElementById("PosContrato_SP1").value;
                                    document.getElementById("PosContrato_SP").value = posC;
                                    var Reg = document.getElementById("RegInfor_SP1").value;
                                    document.getElementById("RegInfor_SP").value = Reg;
                                    var dist = document.getElementById("Distribucion_SP1").value;
                                    document.getElementById("Distribucion_SP").value = dist;
                                    var cm = document.getElementById("CtaMayor_SP1").value;
                                    document.getElementById("CtaMayor_SP").value = cm;
                                    var so = document.getElementById("SocCP_SP1").value;
                                    document.getElementById("SocCP_SP").value = so;
                                    var cc = document.getElementById("CentroCosto_SP1").value;
                                    document.getElementById("CentroCosto_SP").value = cc;
                                    var texp = document.getElementById("TextPos_SP1").value;
                                    document.getElementById("TextPos_SP").value = texp;


                                }
                            </script>
                            <div class="tablaSolicitud">
                                <section id="SecTab">                                     
                                    <table class="TablaCont" id="table12">
                                        <thead>
                                            <tr id="CabeceraTabla">
                                                <td></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPPoscion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTextoBreve"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCantidad"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPFechaEntrega"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCentro"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPSolicitante"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPNumNecesidad"));%></td>                                                
                                                <td><%out.println(po.getProperty("etiqueta.CSPProvDesea"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPProvFijo"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPContrato"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPPosContrato"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPRegistroInfo"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPMatnopieza"));%></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        </tbody>
                                    </table>
                                </section>
                            </div>
                            <input style="display: none" id="folioSP">
                            <div class="subdiv2">
                                <label><%out.println(po.getProperty("etiqueta.CSPDetallePosicion"));%></label>
                                <br>
                                <select style="width:30%; margin-left: 25%;" id="DetallePosicion" onchange="SeleccionarPosicion(this.value);"></select>
                                <button onclick="DatosObligatorios();" style="background-image: url(images/ADD.PNG); background-repeat: no-repeat; padding-right: 1%; padding-left: 3.5%; padding-bottom: .5%;">Agregar posición</button>
                            </div>
                        </div>
                        <div id="datossobrecargados" hidden></div>
                        <div class="divmputacion">
                            <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                            <hr id="TituloImputacionLinea">
                            <div class="divizqimpu_CSP">
                                <label><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></label><input value="" maxlength="1" type="text" id="Inputacion_SP" style="width:4%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchInmputacion_SP" class='BtnMatchIcon'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></label><input value="" maxlength="1" type="text" id="Posicion_SP" style="width:4%; background-repeat: no-repeat"/><button id="matchTipoPos_SP" class='BtnMatchIcon'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input value="" maxlength="18" type="text" id="Material_SP" style="width:25%;  background-repeat: no-repeat"/><button id="matchMaterial_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPTextoBreve"));%></label><input value=""  maxlength="40" type="text" id="textobreve_SP" style="width:45%; background-repeat: no-repeat"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPCantidad"));%></label><input value="" maxlength="13" type="text" id="Cantidad_SP" style="width:20%; background-repeat: no-repeat;"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input value="" maxlength="3" type="text" id="UM_SP" style="width:6%; background-repeat: no-repeat;"/><button id="matchUM_SP" class="BtnMatchIcon"></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPFechaEntrega"));%></label><input value="" maxlength="10" type="date" value="" id="FechaEntr_SP" style="width:30%;  background-repeat: no-repeat;"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></label><input value="" maxlength="9" type="text" id="GrpoArtic_SP" style="width:25%; background-repeat: no-repeat;"/><button id="matchGpoArt" class="BtnMatchIcon"></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input value="" maxlength="4" type="text" id="Centro_SP" style="width:40%; background-repeat: no-repeat;"/><button id="matchCentro_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><input value="" maxlength="4" type="text" id="Almacen_SP" style="width:18%; background-repeat: no-repeat"/><button id="matchAlmacen_SP" class='BtnMatchIcon'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input value="" maxlength="3" type="text" id="GpoCompras_SP" style="width:6%; background-repeat: no-repeat"/><button id="matchGrpoCompras_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPSolicitante"));%></label><input  maxlength="12" type="text" id="Solicitante_SP" value="<%=Nombre%>" style="width:14%; background-repeat: no-repeat;"/>
                                <hr>
                            </div>
                            <div class="divizqimpu_CSP">
                                <label><%out.println(po.getProperty("etiqueta.CSPNumNecesidad"));%></label><input value="" type="text" id="NumNece_SP" style="width:15%;" readOnly/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPProvDesea"));%></label><input value="" type="text" id="ProvDesea_SP" style="width:15%; background-repeat:no-repeat;"/><button id="matchProvDesea_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPProvFijo"));%></label><input value="" type="text" id="ProvFijo_SP" style="width:15%; background-repeat:no-repeat;"/><button id="matchProvFijo_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></label><input value="" type="text" id="OrgCompras_SP" style="width:8%; background-repeat:no-repeat;"/><button id="matchOrgCompras_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPContrato"));%></label><input value="" type="text" id="Contrato_SP" style="width:20%; background-repeat:no-repeat;"/><button id="matchContrato_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPPosContrato"));%></label><input value="" type="text" id="PosContrato_SP" style="width:10%;"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPRegistroInfo"));%></label><input value="" type="text" id="RegInfor_SP" style="width:20%; background-repeat:no-repeat;"/><button id="matchRegInfor_SP" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPDistriibucion"));%></label><Select id="Distribucion_SP" style="width:45%;">
                                    <option></option>
                                    <option><%out.println(po.getProperty("etiqueta.CSPDistriibucion1"));%></option>
                                    <option><%out.println(po.getProperty("etiqueta.CSPDistriibucion2"));%></option>
                                    <option><%out.println(po.getProperty("etiqueta.CSPDistriibucion3"));%></option>

                                </select>
                                <hr>

                                <label><%out.println(po.getProperty("etiqueta.CSPCtaMayor"));%></label><input value="" type="text" id="CtaMayor_SP" style="width:20%; background-repeat: no-repeat"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPSociedadCP"));%></label><input value="" type="text" id="SocCP_SP" style="width:20%;"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><input value="" type="text" id="CentroCosto_SP" style="width:20%; background-repeat: no-repeat"/>
                                <hr>
                                <label>Órden</label><input value="" type="text" id="Orden_SP" style="width:20%; background-repeat: no-repeat"/>
                                <hr>
                            </div>
                        </div>
                        <div class="textopos">
                            <label style="margin-left:3%;"><%out.println(po.getProperty("etiqueta.CSPCeTextPsoci"));%></label>
                            <br>
                            <textarea rows="4" cols="1"  style="resize:none;" id="TextPos_SP" maxlength="130"></textarea>
                        </div>
                    </div>
                </div>       
            </div> 

            <div id="VentanaModalImputacion" class="VentanaModal">
                <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('imputacion');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamImputacion_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></label><input type="text" id="BusTipoImputacion" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPDenominaciTipImpu"));%></label><input type="text" id="BusDenImputacion" style="width:35%;"/>
                            <hr>                          
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okImputacion"/>                       
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('imputacion');"/>
                    </div>
                </div>
                <div id="ConsultaTablaImputacion" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollImputacion">
                            <div class="fixedY" id="fixedYImputacion">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenominaciTipImpu"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosImputación">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>                

            <div id="VentanaModalTipoPosicion" class="VentanaModal">
                <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPTipoPosciionDocumento"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('TipoPosicion');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamTipoPosicion_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></label><input type="text" id="BusTipoPosicion" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPTextoTipoPosicion"));%></label><input type="text" id="BusTextoTipoPosicion" style="width:35%;"/>
                            <hr>                          
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax2" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPosicion"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('TipoPosicion');"/>
                    </div>
                </div>
                <div id="ConsultaTablaTipoPosicion" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollTioPosicion">
                            <div class="fixedY" id="fixedYTipoPosicion">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></th><th><%out.println(po.getProperty("etiqueta.CSPTextoTipoPosicion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosTipoImputacion">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                function BusquedaMaterial() {
                    document.getElementById("BuscarParamMateriales_SP").style.display = "block";
                    document.getElementById("BuscarParamServicio_SP").style.display = "none";
                    document.getElementById("BtnNumMat").style.color = "#fff";
                    document.getElementById("BtnNumMat").style.background = "#007CC0";
                    document.getElementById("BtnNumSer").style.color = "#000";
                    document.getElementById("BtnNumSer").style.background = "#fff";
                    document.getElementById("ConsultaTablaServicio").style.display = "none";
                    document.getElementById("BusMaterial").focus();
                }
                function BusquedaServicio() {
                    document.getElementById("BuscarParamServicio_SP").style.display = "block";
                    document.getElementById("BuscarParamMateriales_SP").style.display = "none";
                    document.getElementById("BtnNumMat").style.color = "#000";
                    document.getElementById("BtnNumMat").style.background = "#fff";
                    document.getElementById("BtnNumSer").style.color = "#fff";
                    document.getElementById("BtnNumSer").style.background = "#007CC0";
                    document.getElementById("ConsultaTablaMaterial").style.display = "none";
                    document.getElementById("BusServicio").focus();

                }
            </script>
            <div id="VentanaModalMateriales" class="VentanaModal">
                <div id="handle3"><label id="TituloMatch">Material o servicio</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Material');"><label >X</label></div></div>
                <div><button style="color: #fff; background-color: #007CC0;" id="BtnNumMat" onclick="BusquedaMaterial();">Num.Material</button><button id="BtnNumSer" onclick="BusquedaServicio();">Servicio</button><hr></div>
                <div id="BuscarParamMateriales_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="BusMaterial" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPTextoBrveMaterial"));%></label><input type="text" id="BusTextoMaterial" style="width:35%;"/>
                            <hr>   
                            <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="BusCentroMaterial" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax3" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>                        
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Material');"/>
                    </div>
                </div>
                <div id="BuscarParamServicio_SP" class="BuscarParam_u" style="display: none;">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.Servicio"));%></label><input type="text" id="BusServicio" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.etiqueta.MFDescripcion"));%></label><input type="text" id="BusTextoServicio" style="width:35%;"/>
                            <hr> 
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMaxS" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okServicio"/>                        
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Servicio');"/>
                    </div>
                </div>
                <div id="ConsultaTablaMaterial" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollMaterial">
                            <div class="fixedY" id="fixedYMaterial">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></th><th><%out.println(po.getProperty("etiqueta.CSPTextoBrveMaterial"));%></th><th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosMateriales">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="ConsultaTablaServicio" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollServicio">
                            <div class="fixedY" id="fixedYServicio">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Servicio</th><th>Descripción</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosServicio">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="VentanaModalUM" class="VentanaModal">
                <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPUMSPTitulo"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('UM');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamUM_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="BusUM" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPUMTexto"));%></label><input type="text" id="BusTextoUM" style="width:35%;"/>
                            <hr>                           
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax4" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUnidadMedida"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('UM');"/>
                    </div>
                </div>
                <div id="ConsultaTablaUM" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollUM">
                            <div class="fixedY" id="fixedYUM">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></th><th hidden><%out.println(po.getProperty("etiqueta.CSPUMTexto"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosUM">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="VentanaModalGArticulos" class="VentanaModal">
                <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GArticulos');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamGArticulos_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></label><input type="text" id="BusGArtiulos" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPUMDenGArticulos"));%></label><input type="text" id="BusDenGArt" style="width:35%;"/>
                            <hr>                           
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax5" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okGArticulos"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('GArticulos');"/>
                    </div>
                </div>
                <div id="ConsultaTablaGArticulos" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollGArticulos">
                            <div class="fixedY" id="fixedYGArticulos">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></th><th><%out.println(po.getProperty("etiqueta.CSPUMTexto"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatoGArticulos">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalCentro" class="VentanaModal">
                <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Centro');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamCentro_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="BusCentro" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPNombre"));%></label><input type="text" id="BusDesCentro" style="width:35%;"/>
                            <hr>                           
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax6" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCentro"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Centro');"/>
                    </div>
                </div>
                <div id="ConsultaTablaCentro" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollCentro">
                            <div class="fixedY" id="fixedYCentro">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th><th><%out.println(po.getProperty("etiqueta.CSPNombre"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatoCentro">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalAlmacen" class="VentanaModal">
                <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Almacen');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.CSPBusquedaDenAlma"));%></button><hr></div>
                <div id="BuscarParamAlmacen_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPDenAlm"));%></label><input type="text" id="BusDenAlm" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><input type="text" id="BusAlmacen" style="width:35%;"/>
                            <hr> 
                            <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="BusCentroAlmacen" style="width:35%;"/>
                            <hr> 
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax7" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAlmacen"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Almacen');"/>
                    </div>
                </div>
                <div id="ConsultaTablaAlmacen" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollAlmacen">
                            <div class="fixedY" id="fixedYAlmacen">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPDenAlm"));%></th><th><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></th><th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatoAlmacen">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalGCompras" class="VentanaModal">
                <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GCompras');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamGCompras_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input type="text" id="BusGCompras" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPDenGCompras"));%></label><input type="text" id="BusDenGCompras" style="width:35%;"/>
                            <hr>                            
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax8" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okGCompras"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('GCompras');"/>
                    </div>
                </div>
                <div id="ConsultaTablaGCompras" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollGCompras">
                            <div class="fixedY" id="fixedYGCompras">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenGCompras"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatoGCompras">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalProveedor" class="VentanaModal">
                <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('proveedor');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.ProvedoresGral_matchPro"));%></button><hr></div>
                <div id="BuscarParam_Prov" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></label><input type="text" id="BusAcreedorSP" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></label><input type="text" id="BusNomAcreSP" style="width:35%;"  focus/>
                            <hr>                            
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax9" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer" id="okProveedor"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultar('proveedor');"/>
                    </div>
                </div>
                <div id="ConsultaTablaProveedor" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollProveedor">
                            <div class="fixedY" id="fixedYProveedor">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></th><th><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosProveedor">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalProveedorFijo" class="VentanaModal">
                <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('proveedorfijo');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.ProvedoresGral_matchPro"));%></button><hr></div>
                <div id="BuscarParam_ProvFijo" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></label><input type="text" id="BusAcreedorFijoSP" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></label><input type="text" id="BusNomAcreFijoSP" style="width:35%;"  focus/>
                            <hr>                            
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax10" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer" id="okProveedorFijo"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('proveedorfijo');"/>
                    </div>
                </div>
                <div id="ConsultaTablaProveedorFijo" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollProveedorFijo">
                            <div class="fixedY" id="fixedYProveedorFijo">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></th><th><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosProveedorFijo">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalOrgCompras" class="VentanaModal">
                <div id="handle11"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('OCompras')"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamOCompras_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></label><input type="text" id="BusOComprasSP" style="width:35%;"  focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Denominacioncomp_mathPro"));%></label><input type="text" id="BusDenOComSP" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax11" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okOCompras"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('OCompras');"/>
                    </div>
                </div>
                <div id="ConsultaTablaOCompras" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollOCompras">
                            <div class="fixedY" id="fixedYOCompras">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosOCompras">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 

            <div id="VentanaModalContrato" class="VentanaModal">
                <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPNumContrato"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Contrato')"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.CSPDocum"));%></button><hr></div>
                <div id="BuscarParamContrato_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax12" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okContrato"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('Contrato');"/>
                    </div>
                </div>
                <div id="ConsultaTablaContrato" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollContrato">
                            <div class="fixedY" id="fixedYContrato">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty(""));%></th><th><%out.println(po.getProperty(""));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosContrato">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModalRegistro" class="VentanaModal">
                <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPNumeroRegistro"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Registro')"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
                <div id="BuscarParamRegistro_SP" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CSPRegistroInfo"));%></label><input type="text" id="BusRegistroSP" style="width:35%;"  focus/>
                            <hr>                           
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax13" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okRegistro"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('Registro');"/>
                    </div>
                </div>
                <div id="ConsultaTablaRegistro" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollRegistro">
                            <div class="fixedY" id="fixedYRegistro">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPRegistroInfo"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosRegistro">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>

        <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
            <div id="handleDoc"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.FinalizarDocumento_FIDO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeSalirModulo();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
            <div class="ContenidoFinalizarDoc">
                <label><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc_FIDO"));%></label>
                <br>
                <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc2_FIDO"));%></label>
            </div>
            <div class="BotenesFinalizarDocumento">
                <button id="FinalizarSIDoc" style="cursor:pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                <button id="FinalizarNODoc" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
            </div>
        </div>

        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <input type="text" id="fcrea" hidden>
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
                    var mes = new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
                    var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                    var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                    var f = new Date();
                    d = f.getDate();
                    d = checkday(d);
                    function checkday(i)
                    {
                        if (i < 10) {
                            i = "0" + i;
                        }
                        return i;
                    }
                    document.getElementById('fcrea').value = +f.getFullYear() + "-" + mes[f.getMonth()] + "-" + d;
                    var idioma = "<%=Idioma%>";
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }

                </script>

                <script type="text/javascript">
                    function startTime() {
                        today = new Date();
                        h = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        m = checkTime(m);
                        s = checkTime(s);
                        document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
                        t = setTimeout('startTime()', 500);
                    }
                    function checkTime(i)
                    {
                        if (i < 10) {
                            i = "0" + i;
                        }
                        return i;
                    }
                    window.onload = function () {
                        startTime();
                        bloq();

                    };
                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                        document.getElementById('aceptar').disabled = true;
                        document.getElementById('guardar').disabled = true;
                    }

                </script>
            </div>
        </footer>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>

