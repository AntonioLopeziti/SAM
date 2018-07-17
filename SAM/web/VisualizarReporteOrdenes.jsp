<%-- 
    Document   : VisualizarReporteOrdenes
    Created on : 28/08/2016, 01:00:37 PM     
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
        String sam = (String) session.getAttribute("SAMIO");
        String sap = (String) session.getAttribute("SAPIO");
        String fecha1 = (String) session.getAttribute("FECHAIO");
        String sam2 = (String) session.getAttribute("SAMFO");
        String sap2 = (String) session.getAttribute("SAPFO");
        String fecha2 = (String) session.getAttribute("FECHAFO");
        String centro = (String) session.getAttribute("CEN");
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
        <script src="js/ReporteOrdenes.js" type="text/javascript"></script>
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

            function msgMatchD(val) {
                switch (val) {
                    case "ConsEx":
                        var ConsEx = "<%=ConsEx%>";
                        $('#msg').html(ConsEx);
                        break;
                }
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <script src="js/ReporteOrdenes.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.ReporteOrdenes_Title"));%></title>   
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
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="retorn();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="back();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>     
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteOrdenes_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> SANPER </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate">  <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>: </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
                        <script type="text/javascript">
                            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                            var f = new Date();
                            var Idioma = "<%=Idioma%>";
                            if (Idioma == "ES") {
                                var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                                $('#fecha').html(fechaActual);
                            } else if (Idioma == "EN") {
                                var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                                $('#fecha').html(fechaActual);
                            } else {
                                $('#fecha').html("Fecha indefinida");
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
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportNumord"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_horadia"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_fechap"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RecibidoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ProcesadoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ErroroRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
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
            <input id ='IdioMat' value='<%=Idioma%>' hidden></input>
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
                    var minut = (f.getMinutes() < 10 ? '0' + f.getMinutes() : f.getMinutes());

                    var idioma = "<%=Idioma%>";
                    if (idioma == "ES") {
                        var fechaActu = "Periodo: " + meses[f.getMonth()] + " Ejercicio: " + f.getFullYear() + "<br>Fecha: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Hora: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                        document.getElementById('fech').innerHTML = fechaActu;
                    } else if (idioma == "EN") {
                        var fechaActu = "Periodo: " + meses[f.getMonth()] + " Exercise: " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                        document.getElementById('fech').innerHTML = fechaActu;
                        ;
                        document.getElementById('fech').innerHTML = fechaActu;
                    } else {
                        var fechaActu = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
                    window.onload = function () {
                        startTime();
                        bloq();
                        Correr();
                        $("#DobleSection").scroll(function () {
                            $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                        });
                        $("#SecCuerpo").scroll(function () {
                            $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                        });
                    };
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
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
            } else if (sam1 == "" && sam2 != "") {//derecho SAM
                SAMDerecho();
            } else if (sam1 != "" && sam2 == "") {//izquierdo SAM
                SAMIzquierdo();
            } else if (sam1 != "" && sam2 != "") {//SAM LOS DOS
                SAMDOS();
            } else if (sap1 == "" && sap2 != "") {//derecho SAP
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
            } else if (sam1 != "" && sam2 != "" && sap1 != "" && sap2 != "" && fecha1 != "" && fecha2 != "") {
                TODOS();
            } else if (centro != "" || centro != null) {
                Centro();
            }
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
