<%-- 
    Document   : ReporteStockMaterial
    Created on : 8/08/2018, 06:24:35 PM
--%>
<%@page import="java.io.InputStream"%>
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
        String noMat = po.getProperty("etiqueta.STOCKMatNoVal");
        String noGar = po.getProperty("etiqueta.STOCKGpoArtNoVal");
        String noTxM = po.getProperty("etiqueta.STOCKtxMNoVal");
        String noAlm = po.getProperty("etiqueta.STOCKAlmNoVal");
        String noCnt = po.getProperty("etiqueta.STOCKCntNoVal");
        String noLot = po.getProperty("etiqueta.STOCKLotNoVal");
        String notrsult = po.getProperty("etiqueta.ReportesListNoExiRes");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
        String NoData = po.getProperty("etiqueta.NoExisteValores_SAM");
        String reso = po.getProperty("etiqueta.Resolucio");
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
                var pag = p.charAt(53);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function msgMatch(mn, im, au, val) {
                var m = "";
                switch (mn) {
                    case 0:
                        m = '<%=funcioninv%>';
                        break;
                    case 1:
                        m = '<%=menValores%>';
                        break;
                    case 2:
                        m = '<%=noMat%> ' + val;
                        break;
                    case 3:
                        m = '<%=noGar%> ' + val;
                        break;
                    case 4:
                        m = '<%=noTxM%> ' + val;
                        break;
                    case 5:
                        m = '<%=noAlm%> ' + val;
                        break;
                    case 6:
                        m = '<%=noCnt%> ' + val;
                        break;
                    case 7:
                        m = '<%=noLot%> ' + val;
                        break;
                    case 8:
                        m = '<%=notrsult%> ';
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#msg').html(m);
                $('#iconmsg').show();
                $('#iconmsg').attr('src', im);
            }
            function back() {
                $(location).attr('href', 'Bienvenido.jsp');
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link href="css/StyleReporteStockMaterial.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/ReporteStockMaterial.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.rsm_Titulo_MM"));%></title>
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
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo">
                <h1><%out.println(po.getProperty("etiqueta.rsm_Titulo_MM"));%></h1>
            </div>
        </div>            
        <div class="contenido">
            <div class="ContentStock">                
                <div class="Datos_info">
                    <div class="BasicoComp11_info">
                        <label> <% out.println(po.getProperty("etiqueta.STOCKNumMaterial"));%> </label><input id="material" style=" width: 37%; text-transform: uppercase;" maxlength="40" type="text"><button id="match1" class='BtnMatchIcon2'></button>
                        <hr>
                        <label> <% out.println(po.getProperty("etiqueta.GralAlmacenAll"));%> </label><input id="almacen" style="width: 16%; text-transform: uppercase;" maxlength="4" type="text"><button id="match3" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><% out.println(po.getProperty("etiqueta.GralCentroAll"));%> </label><input id="centro" style=" text-transform: uppercase; width: 16%;" maxlength="4" type="text"><button id="match4" class='BtnMatchIcon2'></button>
                        <hr>
                        <input id ='IdioMat' value='<%=Idioma%>' hidden>
                    </div>
                </div>
            </div>
            <div id="VentanaModalMaterial" class="VentanaModal">
                <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULMat"><label>X</label></div></div>
                <div class="PanelBntMatch"><button id="btnRegresaMaterial"><%out.println(po.getProperty("etiqueta.BuscarMaterial_MAT"));%></button><hr></div>
                <div id="BuscarParamMaterial" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.materialmatch"));%></label><input type="text" name="namemate" id="materialbus" style="width: 35%; text-transform: uppercase;" maxlength="40"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></label><input type="text" name="namemate" id="DescripcionBus" style="width: 35%;" maxlength="40"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" name="namemate" id="numAcMax1" maxlength="3"  style="width:10%;" />
                            <hr>

                        </div>
                    </div>
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="OCULMat2"/>
                    </div>
                </div>
                <div id="ConsultaTablaMaterial" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scrollMaterial" class="table-scroll">
                            <div id="fixedYMaterial" class="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.materialmatch"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th>
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
            <div id="VentanaModalAlmacen" class="VentanaModal">
                <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><div class="BotonCerrar_Matc" id="OCULAlmac"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.CSPBusquedaDenAlma"));%></button><hr></div>
                <div id="ConsultaTablaAlmacen">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollAlm">
                            <div class="fixedY" id="fixedYAlm">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenAlm"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatoAlmacen">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="VentanaModalCentro" class="VentanaModal">
                <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULCentro"><label>X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></button><hr></div>
                <div id="ConsultaTablac">
                    <div class="tablaCab">
                        <div id="table-scrollcentro" class="table-scroll">
                            <div id="fixedYcentro" class="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="CargarDatosCentro">
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
            if (idioma == "ES") {
                var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                $('#fecha').html(fechaActual);
            } else if (idioma == "EN") {
                var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                $('#fecha').html(fechaActual);
            } else {
                $('#fecha').html("Fecha indefinida");
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
</html></html>