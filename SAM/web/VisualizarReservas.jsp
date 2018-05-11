
<%-- 
    Document   : VisualizarReservas
    Created on : 29-oct-2016, 12:16:27
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
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
        String CampOb = po.getProperty("etiqueta.CompObligatorios");
        String noten = po.getProperty("etiqueta.RESNoenc");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
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
                var pag = p.charAt(50);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au, res) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=menValores%>';
                        break;
                    case 2:
                        msg = '<%=CampOb%>';
                        break;
                    case 3:
                        msg = '<%=noten%> ' + res;
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
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/StyleModificarReservas.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarReservas.js"></script>
        <title><%out.println(po.getProperty("etiqueta.RESERVisualizar_Title"));%></title>
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
            <input type="image" src="images/guardaOFF.png"/>
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png"/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png"/> 
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.RESERVisualizar_Title"));%></h1></div>
        </div>
        <div class="contenido">
            <div class="ContentReservas">
                <section class="DivBusquedaSAMReservas">
                    <label id="lblTitulo_reporte" style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESERBusuqedti"));%></label>
                    <hr id="LineaTituloRev">
                    <section class="DivIzquierda12">
                        <label><%out.println(po.getProperty("etiqueta.RESERReser"));%></label><input id="NReserva" type="text" onpaste="return false"  style="width: 40%; text-transform: uppercase;" maxlength="10"/><button id="Match_Reser" class='BtnMatchIcon2'></button>
                        <hr>
                    </section>
                    <span style="margin-top: -20%;"> <img disabled style="vertical-align: middle"  id="ICONAD"><input readOnly type="text" id="mensgesolped" style="border:none; background: none; width:90%;"/></span>
                </section>
                <section class="DivReserva">
                    <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RERSETitleData"));%></label>
                    <hr id="LineaTituloRev">
                    <section class="DivIzquierda">
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input disabled id="centro" type="text" onpaste="return false"  maxlength="4" style="width: 13%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></label><input disabled id="Almacen" type="text" maxlength="4" style="width: 13%; text-transform: uppercase;"/>
                        <hr>
                        <label style="width: 26%;"><%out.println(po.getProperty("etiqueta.PedidoClMovPEd"));%></label><input disabled id="ClaseMov" maxlength="3" type="text" style="width: 9%;"/>
                        <hr>
                    </section>
                    <section class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESImp"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESCCosto"));%></label><input disabled id="centroco" maxlength="10" type="text" style="width: 25%; margin-left: -5%; text-transform: uppercase; "/><label style="width: 1%; margin-left: 4%;"><%out.println(po.getProperty("etiqueta.RESOTRO"));%></label>
                            <hr>
                        </section>
                        <section class="DerechaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESOrdenin"));%></label><input disabled id="orden" type="text" maxlength="12" style="width: 25%; text-transform: uppercase; margin-left: -8%; "/>
                            <hr>
                        </section>
                    </section>
                    <section style="margin-top:0.5%;" class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESMov311"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESAlmRe"));%></label><input id="Arece" type="text" maxlength="12" style="width: 25%; text-transform: uppercase; margin-left: -8%;" disabled/>
                            <hr>
                        </section>        
                    </section> 
                </section>
                <div id="tablaResr">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.RESCantNe"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.STOCKUnidadMedid"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo">
                                <table id="TabBody">
                                    <tbody>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr class="ocultar">
                                            <td>00000</td>
                                            <td>000000000000000000000000000000000000</td>
                                            <td>0000000000000000000</td>
                                            <td>00000000000000000</td>
                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </section>
                        </section>
                    </section>
                </div>
            </div>
        </div>
        <div id="VentanaModalMReserva" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraMCR"><label>X</label></div></div>
            <div class="PanelBntMatch"><button id="retorMCR"><%out.println(po.getProperty("etiqueta.RESNumb"));%></button><hr></div>
            <div id="BuscarParamReserva" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.RESNumb"));%></label><input type="text" id="ReservaBus"  maxlength="12" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="OkReserva"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerraMCR2"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll" class="table-scroll">
                        <div id="fixedY" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.RESNumb"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatos">
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
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
            var meses2 = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
            var f = new Date();
            var idioma = "<%=Idioma%>";
            var writefecha = $('#fecha');
            if (idioma == "ES") {
                var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                var fre = f.getFullYear() + "-" + meses2[f.getMonth()] + "-" + f.getDate();
                writefecha.html(fechaActual);
            } else if (idioma == "EN") {
                var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                writefecha.html(fechaActual);
            } else {
                writefecha.html(fechaActual);
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
