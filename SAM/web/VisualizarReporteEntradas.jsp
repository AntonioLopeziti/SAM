
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
        String acc = request.getParameter("Accion");
        String cen = request.getParameter("cen");
        String sam = request.getParameter("sam");
        String sam2 = request.getParameter("sam2");
        String sap = request.getParameter("sap");
        String sap2 = request.getParameter("sap2");
        String fec = request.getParameter("fec");
        String fec2 = request.getParameter("fec2");
        String radio = request.getParameter("radio");
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
        String ConsEx = po.getProperty("etiqueta.ConOk_FO");
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
                var a = '<%=acc%>';
                var pag = p.charAt(10);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (a === "" || a == null || a === "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarReporteEntradas.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.ReporteEntrada_Title"));%></title>       
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
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>    
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteEntrada_Title"));%></h1></div>    
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> BAJAFERRIES </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>: </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
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
                var fechaActu = "Period: " + meses[f.getMonth()] + " Exersice: " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + "Time: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
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
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReporteNumdocu"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_horadia"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_fechap"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RecibidoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ProcesadoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ErroroRetSAP"));%></td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">
                                </section>
                            </section>
                        </section>
                    </div>
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
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
    <script>
        function Correr() {
            var CENT = '<%=cen%>';
            var SAM1 = '<%=sam%>';
            var SAM2 = '<%=sam2%>';
            var SAP1 = '<%=sap%>';
            var SAP2 = '<%=sap2%>';
            var FEC1 = '<%=fec%>';
            var FEC2 = '<%=fec2%>';
            var radio = '<%=radio%>';
            var acc = '<%=acc%>';
            var param = "&cen=" + CENT + "&sam=" + SAM1 + "&sam2=" + SAM2 + "&sap=" + SAP1 + "&sap2=" + SAP2;
            var par = "Accion=" + acc + param + "&fec=" + FEC1 + "&fec2=" + FEC2 + "&radio=" + radio;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionVisualizarReportesEntradas',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: par,
                success: function (data) {
                    $('#SecCuerpo').html(data);
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=ConsEx%>";
                    var iconm = $('#iconmsg');
                    iconm.show();
                    iconm.attr('src', 'images/aceptar.png');
                    $('#msg').html(okcon);
                }
            });
        }
        function inval() {
            var okcon = "<%=funcioninv%>";
            $('#msg').html(okcon);
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', "images/advertencia.PNG");
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
