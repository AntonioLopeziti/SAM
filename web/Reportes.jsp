
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
        String Titulo = po.getProperty("etiqueta.TituloReporte");
        String SubTitulo = po.getProperty("etiqueta.SubTituloReportes");
        String etiqueta = po.getProperty("etiqueta.TituloPantallaReportes");
        String botonnotificacion = po.getProperty("etiqueta.NotificacionesReporte");
        String botonordenes = po.getProperty("etiqueta.OrdenReporte");
        String botonsolped = po.getProperty("etiqueta.SolPedReporte");
        String botonavisos = po.getProperty("etiqueta.AvisosReporte");
        String botonmovimientos = po.getProperty("etiqueta.MovimientosReporte");
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
                var pag = p.charAt(10);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function inval() {
                var funinva = '<%=funcioninv%>';
                var iconm = $('#iconmsg');
                iconm.show();
                iconm.attr('src', 'images/advertencia.PNG');
                $('#msg').html(funinva);
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/Reports.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <title><%out.println(Titulo);%></title>   
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(SubTitulo);%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivReporte">
                    <label id="lblTitulo_reporte" style="width: 100%;"><%=etiqueta%></label>
                    <hr id="lineatituloReportes">
                    <button id="botonnotificacion" class="Btn"><%=botonnotificacion%></button>
                    <button id="botonorden" class="Btn" onclick="orden();"><%=botonordenes%></button>
                    <button id="botonsolped" class="Btn"><%=botonsolped%></button>
                    <button id="botonavisos" class="Btn" onclick="avisos();"><%=botonavisos%></button>
                    <button id="botonmovimientos" class="Btn"><%=botonmovimientos%></button>
                    <button id="botonReservas" class="Btn" onclick="reservas();"><%out.println(po.getProperty("etiqueta.ReservasReporte"));%></button>
                    <button id="botonentradas" class="Btn"><%out.println(po.getProperty("etiqueta.EntradasReporte"));%></button>
                    <button id="botonEstOrd" class="Btn" onclick="estatus();"><%out.println(po.getProperty("etiqueta.EstatusOrdenReporte"));%></button>
                    <button id="botonConsumos" class="Btn" onclick="consumos();"><%out.println(po.getProperty("etiqueta.ConsumosReporte"));%></button>
                    <button id="botonContEquipos" class="Btn" onclick="cequipos();"><%out.println(po.getProperty("etiqueta.ContadorEquiposReporte"));%></button>
                    <button id="botonivent" class="Btn"><%out.println(po.getProperty("etiqueta.MovimientoIvendReporte"));%></button>
                    <button id="botonLotesInp" class="Btn"><%out.println(po.getProperty("etiqueta.ReportesLotesInps"));%></button>
                    <button id="botonActAvisosSAP" class="Btn"><%out.println(po.getProperty("etiqueta.ReporteAvisoSAPMod"));%></button>
                    <button id="botonDMS" class="Btn"><%out.println(po.getProperty("etiqueta.ReporteDMS"));%></button>
                    <button id="botonCalidaTxtAv" class="Btn"><%out.println(po.getProperty("etiqueta.ReporteQMCalidatxtAv"));%></button>
                    <button id="botonMovNot" class="Btn">Mov. Notificaciones</button>
                    <button id="botonStatOrd" class="Btn">Estatus Orden PP</button>
                </section>
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
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function orden() {
            window.location.href = "ReporteOrdenes.jsp";
        }
        function avisos() {
            window.location.href = "ReporteAvisos.jsp";
        }

        function reservas() {
            window.location.href = "ReporteReservas.jsp";
        }
        function estatus() {
            window.location.href = "ReporteEstatusOrden.jsp";
        }
        function consumos() {
            window.location.href = "ReporteConsumos.jsp";
        }
        function cequipos() {
            window.location.href = "ReporteContadorEquipos.jsp";
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>