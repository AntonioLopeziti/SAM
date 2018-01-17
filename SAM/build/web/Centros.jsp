<%-- 
    Document   : CrearCentros
    Created on : 28/07/2016, 12:47:52 PM

--%>


<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="javax.script.ScriptContext"%>
<%@page import="javax.script.Bindings"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="AccesoDatos.ACC_UbicacionTecnica"%>
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String ExistCen = po.getProperty("etiqueta.ExisteCentro_CC");
        String CenSaved = po.getProperty("etiqueta.Centrosave_CC");
        String CenErr = po.getProperty("etiqueta.CentroErr_CC ");
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
        String borrado = po.getProperty("etiqueta.CentroBorrOR");

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
                var pag = p.charAt(13);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleCentros.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/Centros.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><% out.println(po.getProperty("etiqueta.Titulo_CC"));%></title>
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
            <input id="guardar" type="image" src="images/guarda.PNG"/>               
            <input id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled />
            <input id="cancelar" type="image" src="images/cancelaOFF.png" disabled />     
            <div class="titulo">
                <h1><% out.println(po.getProperty("etiqueta.TituloModulo_CC")); %></h1>
            </div>
        </div>
        <div class="contenido">
            <section class="MonitorStatus">
                <section class="MonitorSection">
                    <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Parametro_CC")); %></label>
                    <hr class="LineasMonitor">
                    <section class="SecBusqueda">
                        <label><% out.println(po.getProperty("etiqueta.Centro_CC")); %></label>
                        <input id="Ctro" class="BusquedaBx" type="text" maxlength="4" >
                        <hr class="LineasBusqueda">
                        <label><% out.println(po.getProperty("etiqueta.Descripcion_CC")); %></label>
                        <input id="Desc" class="BusquedaBx" type="text" maxlength="30">
                        <hr class="LineasBusqueda">
                    </section>
                </section>
                <br>
                <section class="MonitorStatusCont">
                    <section id="TablaStatus">
                        <table class="TablaCont">
                            <thead>
                                <tr id="CabeceraTabla">
                                    <th class="thRD">&nbsp;</th>
                                    <th class="thCen"><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th>
                                    <th class="thDes"><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
                                </tr>
                            </thead>
                        </table>
                        <section id="SecTab">                   
                        </section>
                        <br>
                    </section>
                    <section id="BusquedaStatus">
                        <input  id="cancelarn" type="image" src="images/eliminar.png"/>
                    </section>
                </section>
            </section>
            <section class="MonitorStatus">
                <section class="MonitorSection">
                    <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Parametro_CC")); %></label>
                    <hr class="LineasMonitor">
                    <section class="SecBusqueda">
                        <label><%out.println(po.getProperty("etiqueta.CentroDestino_CC"));%></label>
                        <input id="bxCtro" class="BusquedaBx" type="text" maxlength="4">
                        <hr class="LineasBusqueda">
                        <label><% out.println(po.getProperty("etiqueta.Descripcion_CC")); %></label>
                        <input id="bxDesc" class="BusquedaBx" type="text"  maxlength="30">
                        <hr class="LineasBusqueda">
                    </section>
                </section>
                <br>
                <section class="MonitorStatusCont">
                    <section id="TablaStatus">
                        <table class="TablaCont">
                            <thead>
                                <tr id="CabeceraTabla">
                                    <th class="thRD">&nbsp;</th>
                                    <th class="thCen"><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th>
                                    <th class="thDes"><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
                                </tr>
                            </thead>
                        </table>
                        <section id="SecTab303">                   
                        </section>
                        <p class="last"></p>
                    </section>
                    <section id="BusquedaStatus">
                        <input  id="cancelar303" type="image" src="images/eliminar.png"/>
                    </section>
                </section>
            </section>
        </div>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
            var f = new Date();
            var idioma = "<%=Idioma%>";
            var writefecha = $('#fecha');
            if (idioma == "ES") {
                var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                writefecha.html(fechaActual);
            } else if (idioma == "EN") {
                var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                writefecha.html(fechaActual);
            } else {
                writefecha.html("Fecha Indefinida");
            }
                </script>
            </div>
        </footer>
    </body>
    <script>


        function inval() {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            var funinva = '<%=funcioninv%>';
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
        }

        function mensajess(num, id) {

            switch (num) {
                case 0:
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    break;
                case 1:
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    $("#" + id).focus();
                    var okcon = "<%=ExistCen%>";
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    $("#msg").html(okcon);
                    $("#iconmsg").css("visibility", "visible");

                    break;
                case 2:
                    var okcon = "<%=CenSaved%>";
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/aceptar.png");
                    $("#msg").html(okcon);
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    break;
                case 3:
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    var okcon = "<%=CenErr%>";
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/aceptar.png");
                    $("#msg").html(okcon);
                    $("#iconmsg").css("visibility", "visible");
                    break;
                case 4 :
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();

                    var okcon = "<%=borrado%>";
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/aceptar.png");
                    $("#msg").html(okcon);
                    $("#iconmsg").css("visibility", "visible");
                    ;
                    break;
                case 5 :
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();

                    var okcon = "Solo se permite crear solo un centro";
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    $("#msg").html(okcon);
                    $("#iconmsg").css("visibility", "visible");
                    ;
                    break;

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
