<%-- 
    Document   : NotificacionTiemposPP
    Created on : Jan 15, 2018, 4:00:38 PM
    Author     : Jhonatan
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
        try {
            if (Nombre.equals(null) || Nombre.equals("") || Nombre == null || Idioma.equals(null)) {
                session.invalidate();
                response.sendRedirect("index.jsp");
            } else {

    %>
    <%            String propiedad = "";
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
        String TituloVisualizarOrden = po.getProperty("etiqueta.VisualizarOrden");
        String Orden = po.getProperty("etiqueta.Orden");
        String Mens = po.getProperty("etiqueta.mensaje");
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

        String titulo = po.getProperty("etiqueta.CU_Titulo");
        String ubicactecnica = po.getProperty("etiqueta.CU_UbicacTecnica");
        String masccodific = po.getProperty("etiqueta.CU_MascCodific");
        String nivjerarquicos = po.getProperty("etiqueta.CU_NivJerarquicos");
        String indestructura = po.getProperty("etiqueta.CU_IndEstructura");
        String tpoubictec = po.getProperty("etiqueta.CU_TpoUbicTecn");
        String modelo = po.getProperty("etiqueta.CU_Modelo");
        String mubicactecnica = po.getProperty("etiqueta.CU_MUbicacTecnica");
        String ubicref = po.getProperty("etiqueta.CU_UbicRef");
        String prefubictecsuperior = po.getProperty("etiquera.CU_PrefUbicTecSuperior");
        String ubictecnsup = po.getProperty("etiqueta.CU_UbicTecnSup");
        String denominacion = po.getProperty("etiqueta.CU_Denominacion");

        String titulomatch = po.getProperty("etiqueta.CU_TituloMatch");
        String botonmatch = po.getProperty("etiqueta.CU_BotonMatch");
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
                var pag = p.charAt(51);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleNotificaTiempos.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/NotificarTiempos.js"></script>
        <title>Notificación de Tiempos PP</title>    
    </head>    
    <body>
        <div id="main-header">     
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png"/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png"/>
            <div class="titulo"><h1>Notificar Tiempos</h1></div>      
        </div>
        <div class="contenido">
            <div class="ContentNotif">
                <label>Busqueda General</label>
                <hr id="lineaNotiTiempos">
                <div class="divNoPers1">
                    <label>No Personal</label><input type="text" id="NoPers" maxlength="30" style="text-transform: uppercase;" />
                    <hr>
                </div>
                <div class="divNoPerso2">
                    <button id="LimPantalla" style="margin-left: 40%;">Limpiar Pantalla</button>  
                </div>
            </div>
            <div class="DatosGeneNotiTiemp">
                <label>Datos Generales</label>
                <hr id="lineaNotiTiempos">
                <div class="divNoOrdFabri">
                    <label>Orden Fabricación</label><input type="text" id="OrdFab" maxlength="30" style="text-transform: uppercase;"/><button id="btnmatchOrdLib"  class="BtnMatchIcon"></button><label type="text" id="DescripOrd" style="margin-left: 4%; width: 50%;">Descripción de Orden</label>
                    <hr>
                    <label>Operación</label><input type="text" id="NoOpe" maxlength="4" style="text-transform: uppercase; width: 6%;"/>
                    <hr>
                </div>                
            </div>
            <div class="DatosReales">
                <label>Datos Reales</label>
                <hr id="lineaNotiTiempos">
                <div class="divCntBuenMal">
                    <label>Not.ctd.buena</label><input type="text" id="cntBuena" style="text-transform: uppercase;"/>
                    <hr>
                    <label>Rechazo.notif</label><input type="text" id=""cntMala style="text-transform: uppercase;"/>
                    <hr>
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
                    var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                    var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                    var f = new Date();
                    var idioma = "<%=Idioma%>";
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        $('#fecha').html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        $('#fecha').html(fechaActual);
                    } else {
                        $('#fecha').html("Fecha indefinida");
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
