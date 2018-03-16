<%-- 
    Document   : ConsultaListaMateriales
    Created on : 1/06/2016, 12:55:06 PM
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String existFol = po.getProperty("etiqueta.errorBOM");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
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
            var idi = '<%=Idioma%>';
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
                var pag = p.charAt(98);
                if (pag == 0) {
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
                        msg = '<%=menValores%>';
                        break;
                    case 2:
                        msg = '<%=CampoOb%>';
                        break;
                    case 3:
                        msg = '<%=existFol%>';
                        break;
                    case 4:
                        msg = '<%=OKconsul%>';
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
            function seleccionar(dato, id, ven, par, tab) {
                $('#' + id).val(dato);
                ocultarVentana(ven, par, tab, "#" + id);
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleBoomMaterialesPPVisualizar.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarBoomEquiposPP.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.VisualizarListMatBOOMPP"));%></title>       
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
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.VisualizarListMatBOOMPP"));%></h1></div>      
        </div>            
        <div id="Conte" hidden></div> 
        <div class="contenido">
            <div class="ContentBoom">
                <div class="divParamBus">
                    <label><%out.println(po.getProperty("etiqueta.ParametrosBus_PP"));%></label>
                    <hr id="lineaBomtitu">
                    <div class="Contenidobus">
                        <label><%out.println(po.getProperty("etiqueta.Mteriales_PP"));%></label><input type="text" id="EquBoom" maxlength="18" style="width: 22%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="btnmatch"  class="BtnMatchIcon"></button> <input type="text" id="DesEquBM" style="width: 52%; background: none; border: none;" readonly/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.centrotrabajoBOOM_PP"));%></label><input type="text" maxlength="4" id="centrotrab" style="width: 10%; text-transform: uppercase; background-repeat: no-repeat;"><button id="btnmatch2"  class="BtnMatchIcon2"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.AlternativaBOOM_PP"));%></label><input type="text" id="Altern" maxlength="2" style="width: 6%;" />                                
                        <hr>
                        <label>Cantidad Base</label><input type="text" id="cantBase" maxlength="10" style="width: 8%; text-transform: uppercase; background-repeat: no-repeat;">
                        <hr>
                    </div>
                </div>

                <div class="tablaSolicitud">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.AlternativaBOOM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NumeroBom_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.centrotrabajoBOOM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ComponenteBOM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.DescripcionBOM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CantidadBOM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.UMBOM_PP"));%></td>

                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo">
                                <table id="TabBody">
                                    <tbody>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr class="ocultar">
                                            <td>0000</td>
                                            <td>00000000000</td>
                                            <td>0000000000000000</td>
                                            <td>0000000000000000</td>
                                            <td>0000000000000000</td>
                                            <td>00000000000000000000000000000</td>
                                            <td>000000000000000</td>
                                            <td>000000000000000</td>
                                            <!--<td>000000000000000000000</td>-->
                                        </tr>
                                    </tbody>
                                </table>
                            </section>
                        </section>
                    </section>
                </div>
            </div>
            <div id="VentanaModal" class="VentanaModal">
                <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitiarAmbitoValores_PP"));%></label><div class="BotonCerrar_Matc" id="CerraMCEqu"><label >X</label></div></div>
                <div class="PanelBntMatch"><button id="retmcequipo"><%out.println(po.getProperty("etiqueta.Restricciones_PP"));%></button><hr></div>
                <div id="BuscarParam" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.Mteriales_PP"));%></label><input type="text" id="equiBus" maxlength="18" style="width:35%; text-transform: uppercase;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.DenominacionMterial_PP"));%></label><input type="text" id="dnEquBus" maxlength="40" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaximaAciertos_PP"));%></label><input type="text"  id="numAcMax" maxlength="3"  style="width:10%;" />
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerraMCEqu2"/>
                    </div>
                </div>
                <div id="ConsultaTabla" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scroll">
                            <div class="fixedY" id="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Mteriales_PP"));%></th><th><%out.println(po.getProperty("etiqueta.DenominacionMterial_PP"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatos">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VentanaModal2" class="VentanaModal">
                <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitiarAmbitoValores_PP"));%></label><div class="BotonCerrar_Matc" id="CerrarVen1"><label >X</label></div></div>
                <div class="PanelBntMatch"><button id="RetcentroBoom"><%out.println(po.getProperty("etiqueta.Restricciones_PP"));%></button><hr></div>
                <div id="BuscarParam2" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.CentroBOOM_PP"));%></label><input type="text" id="CenBus" maxlength="4" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.DescripcionBOM_PP"));%></label><input type="text" id="CNombreBus" maxlength="30" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaximaAciertos_PP"));%></label><input type="text" maxlength="3" id="numAcMax2"  style="width:10%;"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCentro"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerrarVen2"/>
                    </div>
                </div>
                <div id="ConsultaTabla2" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scroll2">
                            <div class="fixedY" id="fixedY2">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CentroBOOM_PP"));%></th><th><%out.println(po.getProperty("etiqueta.DescripcionBOM_PP"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatos2">
                                </div>
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
                <span><input type="image" style="float:left; margin-top: -2.5px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
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
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>