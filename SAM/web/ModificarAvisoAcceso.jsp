<%-- 
    Document   : CrearAvisoAcceso
    Created on : 31/08/2016, 04:04:07 PM
--%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
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
        String ORd = request.getParameter("ORd");
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
        String inv = po.getProperty("etiqueta.FuncionInval_Menu");
        String valo = po.getProperty("etiqueta.NoExisteValores_SAM");
        String noter = po.getProperty("etiqueta.datNoExx");
        String introd = po.getProperty("etiqueta.AviIntrodu");
    %>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <script>
            function CheckResolucion() {
                if (screen.width <= 500) {
                    var msgResolucion = 'Resolución no soportada';
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
                var pag = p.charAt(69);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=inv%>';
                        break;
                    case 1:
                        msg = '<%=valo%>';
                        break;
                    case 2:
                        msg = '<%=noter%>';
                        break;
                    case 3:
                        msg = '<%=introd%>';
                        break;
                }
                $('#msg').html(msg);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
        </script>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/CrearAviso.css"> 
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/ModificarAviso.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.ModificarAvisoAccesoMAA"));%></title>        
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
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty(("etiqueta.ModificarAvisoAccesoMAA")));%></h1></div>  
        </div>
        <div class="contenido">
            <section class="divModAvi">
                <div class="DivBuscaAvis">
                    <label><%out.println(po.getProperty(("etiqueta.notificacionMAA")));%></label><input type="text" id="NotifiPM" style="width:15%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;" maxlength="12"/><button id="btnmatch" class="BtnMatchIcon" ></button>
                    <hr id="lineaordenMacth">
                </div>  
            </section>
        </div>                   
        <div id="VentanaModal" class="VentanaModalNot">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.TMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarVentanaNo"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="retronarsiltromatch('BuscarParamNot', 'ConsultaTabla');"><%out.println(po.getProperty("etiqueta.TituloMAA"));%></button><hr></div>
            <div id="BuscarParamNot" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.claseAvisoMAA"));%></label><input type="text" id="ClaseAvisoMAA" maxlength="2" style="width:8%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.notificacionMAA"));%></label><input type="text" id="NotifiMAA" maxlength="12" style="width:25%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.descripcionMAA"));%></label><input type="text" id="DescripMAA" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"  style="width:10%; text-transform: uppercase;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAviso"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarVentanaNo2"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedYN" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ClaseMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.notificacionMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.folioSAMMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.descripcionMAA"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatosN">
                            <div class="nofixedX" id="cargarDatosN">
                            </div>
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
                <span><input type="image" style="float:left;" id="iconmsg"></span><label  id="msg" class="msg"></label>
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

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
</html>