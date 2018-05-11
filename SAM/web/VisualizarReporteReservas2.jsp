
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
        String okconsu = po.getProperty("etiqueta.ConOk_FO");
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
    <%
        String Ac = request.getParameter("Accion");
        String R1 = request.getParameter("R1");
        String R2 = request.getParameter("R2");
        String S1 = request.getParameter("S1");
        String S2 = request.getParameter("S2");
        String F1 = request.getParameter("F1");
        String F2 = request.getParameter("F2");
        String Cl = request.getParameter("Cl");
        String Sl = request.getParameter("Sl");
        String Mt = request.getParameter("Mat");
        String Ce = request.getParameter("Ce");
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
                var chk = '<%=Ac%>';
                if (chk == null || chk === "" || chk === "null") {
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
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/VisualListaReserva.js" type="text/javascript"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.ListaReser"));%></title>       
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
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ListaReser"));%></h1></div>      
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
                                                <td><%out.println(po.getProperty("etiqueta.RESNumRes"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralPosicion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RESFechNece"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ClaMovVLD"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RESCantNe"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RESCantidUnMed"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMNumeroorden"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCCosto"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocAlamDes"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></td>
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
    function CargarTabla() {
        var acc = '<%=Ac%>';
        var NumR = '<%=R1%>';
        var NumR2 = '<%=R2%>';
        var SAM = '<%=S1%>';
        var SAM2 = '<%=S2%>';
        var Fec1 = '<%=F1%>';
        var Fec2 = '<%=F2%>';
        var Clas = '<%=Cl%>';
        var Sol = '<%=Sl%>';
        var Mat = '<%=Mt%>';
        var Cen = '<%=Ce%>';
        var param = "&R1=" + NumR + "&R2=" + NumR2 + "&S1=" + SAM + "&S2=" + SAM2 + "&F1=" + Fec1 + "&F2=" + Fec2;
        var par = param + "&Cl=" + Clas + "&Sl=" + Sol + "&Mat=" + Mat + "&Ce=" + Cen;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaReservas',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                $('#SecCuerpo').html(data);
                var okcon = "<%=okconsu%>";
                $('#msg').html(okcon);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', "images/aceptar.png");
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                $("#DobleSection").scroll(function () {
                    $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                });
                $("#SecCuerpo").scroll(function () {
                    $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                });


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
