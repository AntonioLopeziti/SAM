<%-- 
    Document   : ConfiguracionServidor
--%>


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
        String Verif = po.getProperty("etiqueta.VerificandoTei");
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
        String VerDatCon = po.getProperty("etiqueta.VerifDatCon_ConfSer");
        String ConExx = po.getProperty("etiqueta.ConExx_ConfSer");
        String ConfGrdEx = po.getProperty("etiqueta.ConfGrdEx_ConfSer");
        String ErrGrdCon = po.getProperty("etiqueta.ErrGrdCon_ConfSer");
    %>
    <script>
        function ShowMsg(m, im, au) {
            var msg;
            switch (m) {
                case 0:
                    msg = '<%=funcioninv%>';
                    break;
                case 1:
                    msg = '<%=CampoOb%>';
                    break;
                case 2:
                    msg = '<%=Verif%>';
                    break;
                case 3:
                    msg = '<%=ConExx%>';
                    break;
                case 4:
                    msg = '<%=VerDatCon%>';
                    break;
                case 5:
                    msg = '<%=ConfGrdEx%>';
                    break;
                case 6:
                    msg = '<%=ErrGrdCon%>';
                    break;
                case 7:
                    msg = 'Error: No se cargaron los datos de conexion';
                    break;
                case 8:
                    msg = 'Error: Conexion nula, verifique y guarde conexion';
                    break;
                case 9:
                    msg = 'No existen valores para esta selección';
                    break;
                case 10:
                    msg = 'Campo usuario vacio, introduce un usuario';
                    break;
                case 11:
                    msg = 'Clave de usuario reseteada con éxito';
                    break;
                case 12:
                    msg = 'Error usuario no valido';
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

    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">        
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleConfiguracion.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/ConfiguracionConexion.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/menu.js"></script>
        <script src="js/jquerys.js"></script>   
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.js"></script>   
        <title>Configuración</title>
    </head>
    <body>

        <div id="main-header">     
            <hr/>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input  id="guardar" type="image" src="images/guarda.PNG" />
            <input  id="regresar" type="image" src="images/regresaOFF.png" disabled/>
            <input id="finalizar" type="image" src="images/cance.PNG" />
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1>Configuración</h1></div>
        </div>
        <div class="contenido">
            <div class="DivConexion">
                <div class="DivSAMConex">
                    <label><%out.println(po.getProperty("etiqueta.ParConBD_ConfSer"));%></label>
                    <hr id="lineapri">
                    <div id="demo"></div>
                    <div class="subdivCone">
                        <label><%out.println(po.getProperty("etiqueta.Usuario_ConfSer"));%></label><input type="text" onpaste="return false;" style="width:20%;" maxlength="100" id="UserCnx"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Contrasena_ConfSer"));%></label><input type="text" onpaste="return false;" style="width:20%;" maxlength="100" id="PwdCnx"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Servidor_ConfSer"));%></label><input type="text" style="width:20%;" maxlength="100" id="SerCnx"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Puerto_ConfSer"));%></label><input type="text" onpaste="return false;" style="width:15%;" maxlength="100" id="portCnx"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.BaseDeDatos_ConfSer"));%></label><input type="text" onpaste="return false;" style="width:20%;" maxlength="100" id="DBCnx"/>
                        <hr>
                        <button class="pcnx" id="pcnxSAM"><%out.println(po.getProperty("etiqueta.ProbConexion_ConfSer"));%></button>
                    </div>
                </div>
                <div class="ResestUser">
                    <label>Restablecer Usuario SAM</label>
                    <hr id="lineapri">
                    <div class="BusUse">
                        <label>Usuario</label><input type="text" style="width:15%; text-transform: uppercase;" maxlength="12" id="USeCf"/><button id="matchusercf" class='BtnMatchIcon'></button> <input type="text" id="txtdesc" style="width:60%; background: none; border:none; " readonly/>
                        <hr>
                        <button class="pcnx" id="RestSAM">Restablecer</button>
                    </div>
                </div>
            </div>

            <!--            <div class="DivConexion">
                            <div class="DivSAMConex2">
                                <label><%out.println(po.getProperty("etiqueta.ParWSBD_ConfSer"));%></label>
                                <hr id="lineapri">
                                <div id="demo"></div>
                                <div class="subdivCone"6
                                    <label><%out.println(po.getProperty("etiqueta.URL_ConfSer"));%></label><input type="text" style="width:60%;" maxlength="100" id="URLCnx"/>
                                    <div style="margin-top: -0.2em; float: right; margin-right: 20%;"><input  id="guardarWS" type="image" src="images/guarda.PNG" /></div>
                                    <hr>
                                </div>
                            </div>
                        </div>-->
        </div>            
    </div>   
     <div id="VentanaModalUsuario" class="VentanaModal">
            <div id="handle"><label id="TituloMatch">Usuario</label><div class="BotonCerrar_Matc" id="CerrarMCUsuario"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaUsuario">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUsuario">
                        <div class="fixedY" id="fixedYUsuario">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Usuario</th>
                                        <th>Nombre</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUsuario">
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
