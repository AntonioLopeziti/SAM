
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
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
        String Centro = (String) session.getAttribute("CentroUsuario");
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
                var pag = p.charAt(27);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();

            function ShowMsg(m, im, au, va) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
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
        <link rel="stylesheet" href="css/StyleCotizacionSD.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>     
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/CotizacionSDCrear.js"></script>  
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.CotizacionTituloCrear"));%></title>       
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
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" />
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.CotizacionTituloCrear"));%></h1></div> 
        </div>            
        <div class="contenido">    
            <div class="DivContentPrincipal">
                <div class="DivClas">
                    <label><%out.println(po.getProperty("etiqueta.CotizacionClaseOferta"));%></label><input type="text" id="ClaseOferta"/><button id="MCClaseOferta" class='BtnMatchIcon'></button>
                    <hr>  
                </div>
                <div class="DivDatosBasicoCabecera">
                    <label><%out.println(po.getProperty("etiqueta.CotizacionDatosOrgaTi"));%></label>
                    <hr id="LineaTitulo">
                    <div class="divOrg">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionOrganventas"));%></label><input type="text" id="OrgVentas"  style="width: 15%;" maxlength="4"/><button id="MCOrgVentas" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionCanalDistri"));%></label><input type="text" id="CanalDist"/><button id="MCCanalDis" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionSector"));%></label><input type="text" id="Sector"/><button id="MCSector" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionOficinaVent"));%></label><input type="text" id="OficVentas"/><button id="MCOficinaVentas" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionGrupoVended"));%></label><input type="text" id="GpoVen"/><button id="MCGpoVen" class='BtnMatchIcon'></button>
                        <hr> 
                    </div>
                </div>
                <div class="DivDatosCotiza">
                    <div class="DivIzq">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaRepar"));%></label><input type="text" id="OfertaRep" style="width: 30%;"/><button id="MCOferRep" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionSolicitante"));%></label><input type="text" id="Solicitate" style="width: 30%;" value="<%=Nombre%>" readonly/>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionDestinMerca"));%></label><input type="text" id="DestMec" style="width: 30%;"/><button id="MCDestMerc" class='BtnMatchIcon'></button>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CotizacionNumPediClie"));%></label><input type="text" id="NmPedCliente" style="width: 48%;"/>
                        <hr> 
                        <label>Area de ventas</label><input type="text" id="NmPedCliente" style="width: 48%;"/>
                        <hr> 
                        <label>Motivo pedido</label><select></select>
                        <hr> 
                        <label>Moneda documento</label><input type="text" style="width: 10%;"/> / <input type="text"  style="width: 25%;    "/>
                        <hr> 
                    </div>
                    <div class="DivDer">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionValorNeto"));%></label><input type="text" id="ValorNeto" style="width: 30%;"/> <input type="text" id="Moneda" style="width: 15%;"/><button id="MCMoneda" class='BtnMatchIcon'></button>
                        <hr> 
                        <input type="text" id="descripcionSolicitante" style="width: 100%;  border: none; background: none;" readonly >
                        <hr hidden>
                        <input type="text" id="descripcionDestMe" style="width: 100%; border: none; background: none;" readonly >
                        <hr hidden>
                        <br><br>
                        <label style="margin-top: 5px;"><%out.println(po.getProperty("etiqueta.CotizacionFechaPedido"));%></label><input type="text" id="FechPedi" style="width: 30%;"/><button id="MCFechPed" class='BtnMatchIcon'></button>
                        <hr> 
                        <label>Fecha documento</label><input type="text" id="FechPedi" style="width: 30%;"/>
                        <hr> 
                        <label>Fecha precio</label><input type="text" id="FechPedi" style="width: 30%;"/>
                        <hr> 
                        <label>Fecha entrega</label><input type="text" id="FechPedi" style="width: 30%;"/>
                        <hr> 
                    </div>
                </div>
                <div class="divitems">
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td>&nbsp;&nbsp;&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPPosicio"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTImpt"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTposi"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPMaterial"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPUM"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCantida"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPFechEnt"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCentro"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPAlmac"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPSolic"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCMayor"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPCCosto"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPOrden"));%>&nbsp;</td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">
                                    <table id="TabBody">
                                        <tbody>                                            
                                            <tr><td><input type="checkbox"/></td><td><input type="text" style="width: 100%; border: none; text-align: center;"  readonly value="00010"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr class="ocultar"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>
                                        </tbody>
                                    </table>
                                </section>
                            </section>
                        </section>
                    </div>   
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>  
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
