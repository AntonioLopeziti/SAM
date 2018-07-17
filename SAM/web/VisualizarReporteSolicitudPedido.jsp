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
        String ACC = request.getParameter("Action");
        String SM1 = request.getParameter("SM1");
        String SM2 = request.getParameter("SM2");
        String SP1 = request.getParameter("SP1");
        String SP2 = request.getParameter("SP2");
        String FC1 = request.getParameter("FC1");
        String FC2 = request.getParameter("FC2");
        String SLC = request.getParameter("SLC");
        String AMC = request.getParameter("AMC");
        String MTL = request.getParameter("MTL");
        String POS = request.getParameter("POS");
        String IMT = request.getParameter("IMT");
        String CEN = request.getParameter("CEN");

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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
                var a = '<%=ACC%>';
                var pag = p.charAt(38);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (a == null || a == "" || a == "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=ConsEx%>';
                        break;

                }
                $('#msg').html(msg);
                var icon = $('#iconmsg');
                icon.css('visibilty', true);
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script type="text/javascript" src="js/VisualizarReporteSolicitudPdido.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></title>       
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
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> SANPER </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%> </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
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
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.PedidoPos"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFSolici"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTposi"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTImpt"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCantidad"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.MovAlmac"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFecLib"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportesSolStatusIndLib"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportesSolStatusDesCo"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportesSolStatuInidiProc"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportesSolStatuInidiErr"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ReportesSolStatuPedido"));%></td>
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
    function ReporteSolped() {
        var acc = '<%=ACC%>';
        var sam1 = '<%=SM1%>';
        var sam2 = '<%=SM2%>';
        var sap1 = '<%=SP1%>';
        var sap2 = '<%=SP2%>';
        var fech1 = '<%=FC1%>';
        var fechf = '<%=FC2%>';
        var solic = '<%=SLC%>';
        var almac = '<%=AMC%>';
        var mater = '<%=MTL%>';
        var posic = '<%=POS%>';
        var imput = '<%=IMT%>';
        var cen = '<%=CEN%>';
        var param = "&SM1=" + sam1 + "&SM2=" + sam2 + "&SP1=" + sap1 + "&SP2=" + sap2 + "&FC1=" + fech1 + "&FC2=" + fechf;
        var par = param + "&SLC=" + solic + "&AMC=" + almac + "&MTL=" + mater + "&POS=" + posic + "&IMT=" + imput + "&CEN=" + cen;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaSolped',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                $("#SecCuerpo").html(data);
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                $("#DobleSection").scroll(function () {
                    $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                });
                $("#SecCuerpo").scroll(function () {
                    $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                });
                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");

            }
        });
    }
</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>
