<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.util.LinkedList"%>
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
        String reso = po.getProperty("etiqueta.Resolucio");
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleModificarOrden.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script src="js/dom-drag.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/ModOrdenPP.js"></script>
        <title><%out.println(po.getProperty("etiqueta.ModOrden_Ordenes_PP"));%></title>   
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
                var pag = p.charAt(123);
                if (pag == 1) {

                } else if (pag == 0) {
                    session.invalidate();
                    window.location.href = "index.jsp";
                }
            }
            checkPermisoPag();
        </script>
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
                <input id="aceptar" type="image" src="images/aceptar.png" />     
                <input id="guardar" type="image" src="images/guarda.PNG" disabled="true" />  
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" src="images/cance.PNG"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="" />
            </div>            
            <div class="contenido">
                <div class="titulo" style="width: 98.7%"><h1><%out.println(po.getProperty("etiqueta.ModOrdPP_Ordenes_PP"));%></h1></div>      
                <div class="ContenidoScrollbar">
                    <div id="cargarMate" hidden></div>
                    <div class="ContentOrden"> 
                        <br>
                        <label style="margin-right: 80px;"><%out.println(po.getProperty("etiqueta.ModOrdOrdennn_Ordenes_PP"));%></label>
                        <input type="text" id="ord" value="" style ="width: 150px;"/>
                        <button id="matchOrden" class='BtnMatchIcon' onclick=""></button>
                        <hr style="width:150px; margin-left: 0;">

                        <!--///////////Ventana Modal Orden//////////////////////////////////////////////--> 
                        <div id="VentanaModalOrden" class="VentanaModal">
                            <div id="handle1"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ModOrdNumOrdenn_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Orden');"><label >X</label></div></div>
                            <div class="PanelBntMatch"><button onclick="changeWindows()"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                            <div id="BuscarParamOrden" class="BuscarParam_u">
                                <div class="fondo_Match">
                                    <div class="busquedaMatch">
                                        <label><%out.println(po.getProperty("etiqueta.ModOrdPlanMantePreee_Ordenes_PP"));%></label>
                                        <input type="text" id="txtPlPr" style="width:35%;" focus/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.ModOrdOrdeeeen_Ordenes_PP"));%></label>
                                        <input type="text" id="txtOrd" style="width:35%;"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.ModOrdTxxBreee_Ordenes_PP"));%></label>
                                        <input type="text" id="txtBrev" style="width:55%;"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes_PP"));%></label>
                                        <input type="number" min="1"  id="numAcMaxOrd" max="100" value="100" style="width:10%;" />
                                        <hr>
                                    </div>        
                                </div> 
                                <div class="Botones_Match">
                                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okOrden"/>
                                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Orden');"/>
                                </div>
                            </div>
                            <div id="ConsultaTablaOrden" style="display: none;">
                                <div class="tablaCab">
                                    <div class="table-scroll" id="table-scrollOrden">
                                        <div class="fixedY" id="fixedYOrden">
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th><%out.println(po.getProperty("etiqueta.ModOrdPlMantPrven_Ordenes_PP"));%></th>
                                                        <th><%out.println(po.getProperty("etiqueta.ModOrdOrdeeeen_Ordenes_PP"));%></th>
                                                        <th><%out.println(po.getProperty("etiqueta.ModOrdTxxBreee_Ordenes_PP"));%></th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                        <div id="cuerpoDatos">
                                            <div class="nofixedX" id="cargarDatosOrden">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="text" id="mjDatosIncorrectos" value="<%=menValores%>" hidden/>
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
                            <script type="text/javascript">
                                function fechaIni() {
                                    var hoy = new Date();
                                    var dd = hoy.getDate();
                                    var mm = hoy.getMonth() + 1;
                                    var yyyy = hoy.getFullYear();
                                    if (dd < 10) {
                                        dd = '0' + dd;
                                    }
                                    if (mm < 10) {
                                        mm = '0' + mm;
                                    }
                                    hoy = yyyy + '-' + mm + '-' + dd;
                                    document.getElementById("fechIni").value = hoy;
                                }
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
                                    $('#iconmsg').hide();
                                }
                                function inval() {
                                    var funinva = "<%=funcioninv%>";
                                    $('#msg').html(funinva);
                                    var icon = $('#iconmsg');
                                    icon.show();
                                    icon.attr('src', "images/advertencia.PNG");
                                    var BE = document.createElement('audio');
                                    BE.src = au;
                                    BE.play();
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
