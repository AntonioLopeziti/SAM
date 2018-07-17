<%-- 
    Document   : VisualizarReporteSolPed
    Created on : 28/08/2016, 01:04:43 PM
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        String sam = (String) session.getAttribute("SAMSP");
        String sap = (String) session.getAttribute("SAPSP");
        String fecha1 = (String) session.getAttribute("FECHASP");
        String sam2 = (String) session.getAttribute("SAMSPF");
        String sap2 = (String) session.getAttribute("SAPFSP");
        String fecha2 = (String) session.getAttribute("FECHASPF");
        String centro = (String) session.getAttribute("CEN");
        String valor = (String) session.getAttribute("VAL");
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
        String TituloPagina = po.getProperty("etiqueta.TituloPaginaRSP");
        String TituloPantalla = po.getProperty("etiqueta.SubTituloRSP");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String reso = po.getProperty("etiqueta.Resolucio");
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
            <%
                String permiso = ACC_Usuarios.ObtenerInstancia().VerificarPermisos(Nombre);
            %>
            function checkPermisoPag() {
                var p = '<%=permiso%>';
                var pag = p.charAt(81);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.Reporte_TituloSolPed"));%></title>       
    <body>  
        <div id="main-header"> 
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="retorn();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="back();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>            
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.Reporte_TituloSolPed"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> SANPER </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> Usuario: </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
                        <script type="text/javascript">
                            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                            var f = new Date();
                            var minut = (f.getMinutes() < 10 ? '0' + f.getMinutes() : f.getMinutes());

                            var idioma = "<%=Idioma%>";
                            if (idioma == "ES") {
                                var fechaActu = "Periodo: " + meses[f.getMonth()] + " Ejercicio: " + f.getFullYear() + "<br>Fecha: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Hora: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else if (idioma == "EN") {
                                var fechaActu = "Period: " + meses[f.getMonth()] + " Exercise: " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                                ;
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else {
                                var fechaActu = "Fecha indefinida";
                            }
                        </script>
                    </div>
                </div>
                <div id="general" class="general">
                    <div class="container-datos">
                        <form align="center">     
                            <div id="global" class="tableContainer">

                            </div>
                        </form>
                    </div>
                </div>                   
            </div> 
        </div>
    </div>
    <footer>
        <hr class="fecha" id="footerline">
        <div  class="fecha">
            <label id="fecha" name="fecha"></label><label>, </label> 
            <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
            <span><input type="image" style="float:left; margin-top: -2.5px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
            <script type="text/javascript">
                
//obtener datos de url match

    function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
var solicitante = getParameterByName('solicitante');
var almacen = getParameterByName('almacen');
var material = getParameterByName('material');
var posicion = getParameterByName('posicion');
var imputacion = getParameterByName('imputacion');
var coste = getParameterByName('coste');
var orden = getParameterByName('orden');

               
            
                
//******************************************                
                
                var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                var f = new Date();
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
                    n = today.getHours();
                    m = today.getMinutes();
                    s = today.getSeconds();
                    h = checkTime(n);
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
                    Correr();
                };

                function bloq() {
                    document.getElementById('iconmsg').style.visibility = "hidden";
                    document.getElementById('guardar').disabled = true;
                }

            </script>
        </div>
    </footer>
</body>
<script language="javascript">
    function retorn() {
        window.location.href = "ReporteSolPed2.jsp";
    }
    function back() {
        window.location.href = "Bienvenido.jsp";
    }
    function inval() {
        var funinva = '<%=funcioninv%>';
        var iconm = document.getElementById("iconmsg");
        iconm.style.visibility = "visible";
        iconm.src = "images/advertencia.PNG";
        var men = document.getElementById("msg");
        men.innerHTML = funinva;
    }
    function Correr() {
        var sam1 = "<%=sam%>";
        var sap1 = "<%=sap%>";
        var fecha1 = "<%=fecha1%>";
        var sam2 = "<%=sam2%>";
        var sap2 = "<%=sap2%>";
        var fecha2 = "<%=fecha2%>";
        var centro = "<%=centro%>";
        if (sam1 == "" && sap1 == "" && fecha1 == "" && sam2 == "" && sap2 == "" && fecha2 == "" && centro == "") {
            Vacio();
        } else if(sam1 != "" && sap1 != ""){
            SAPSAM();
        }else if (sam1 != "" && sam2 != "") {//SAM LOS DOS
            SAMDOS();
        } else if (sam1 === "" && sam2 != "") {//derecho SAM
            SAMDerecho();
        } else if (sam1 != "" && sam2 == "") {//izquierdo SAM
            SAMIzquierdo();
        }else if (sap1 == "" && sap2 != "") {//derecho SAP
            SAPDerecho();
        } else if (sap1 != "" && sap2 == "") {//izquierdo SAP
            SAPIzquierdo();
        } else if (sap1 != "" && sap2 != "") { //SAP LOS DOS
            SAPDOS();
        } else if (fecha1 != "" && fecha2 == "") { //fecha izquierda
        FECHAIZQUIERDA();
        } else if (fecha1 == "" && fecha2 != "") { //fecha dereacha
            FECHADERECHA();
        } else if (fecha1 != "" && fecha2 != "") { //las dos fechas
            FECHADOS();
        } else if (sam1 != "" && sam2 != "" && sap1 != "" && sap2 != "" && fecha1 != "" && fecha2 != "" && centro != "") {
            TODOS();
        } else if (centro != "" || centro != null)
            Centro();
    }
     function Vacio() {
            var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
            
            var ur = "PeticionVisualizarReportesSolPed2";
            var acc = "ConsultaVacia2";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("global").innerHTML = xmlhttp.responseText;
                    var okcon = "Consulta Exitosa";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
            xmlhttp.send();
        }
        
         function SAPSAM() {
            var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
            var ur = "PeticionVisualizarReportesSolPed2";
            var acc = "ConsultaSapSam";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("global").innerHTML = xmlhttp.responseText;
                    var okcon = "Consulta Exitosa";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
            xmlhttp.send();
        }
        
        
        
        
        
        
        
    function SAMDerecho() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed2";
        var acc = "ConsultaSamDerecha";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function SAMIzquierdo() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed2";
        var acc = "ConsultaSamIzquierda";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function SAMDOS() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed2";
        var acc = "ConsultaSamDos";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
        xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function SAPDerecho() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed2";
        var acc = "ConsultaSapDerecho";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function SAPIzquierdo() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed21";
        var acc = "ConsultaSapIzquierdo";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
          xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function SAPDOS() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed21";
        var acc = "ConsultaSapDos";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function FECHAIZQUIERDA() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed21";
        var acc = "ConsultaFechaIzquierda";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
        xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function FECHADERECHA() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed21";
        var acc = "ConsultaFechaDerecha";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function FECHADOS() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
          
       var ur = "PeticionVisualizarReportesSolPed2";
        var acc = "ConsultaFechaDos";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
         xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function TODOS() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "SolpedMatchs";
        var acc = "ConsultaTodos";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
        xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
    function Centro() {
        var solicitante = getParameterByName('solicitante');
            var almacen = getParameterByName('almacen');
            var material = getParameterByName('material');
            var posicion = getParameterByName('posicion');
            var imputacion = getParameterByName('imputacion');
            var coste = getParameterByName('coste');
            var orden = getParameterByName('orden');
        var ur = "PeticionVisualizarReportesSolPed21";
        var acc = "Centro";
        var ventana = document.getElementById('general');
        var ancho = 750;
        var alto = 750;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                document.getElementById("global").innerHTML = xmlhttp.responseText;
                var okcon = "Consulta Exitosa";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
        };
        xmlhttp.open("GET", ur + "?Action=" + acc+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
        xmlhttp.send();
    }
</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>
