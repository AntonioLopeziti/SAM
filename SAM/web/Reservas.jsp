<%-- 
    Document   : Reservas
    Created on : 07-sep-2016, 16:46:27
--%>

<%@page import="Entidades.usuario_grupo_materiales"%>
<%@page import="AccesoDatos.ACC_Usuario_grupo_materiales"%>
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
        String meFOL = request.getParameter("men");

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
        String CampOb = po.getProperty("etiqueta.CompObligatorios");
        String MenVal = po.getProperty("etiqueta.MensajeNoExiste");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String material = po.getProperty("etiqueta.materialmatch");
        String centro = po.getProperty("etiqueta.centromatch");
        String errocon = po.getProperty("etiqueta.NoExisteMateril_MAT");
        String CampOb201 = po.getProperty("etiqueta.RESCampoObl201");
        String CampOb261 = po.getProperty("etiqueta.RESCampoObl261");
        String CampOb311 = po.getProperty("etiqueta.RESCampoObl311");
        String AlmReNot = po.getProperty("etiqueta.RESAlmNoRec");
        String tablva = po.getProperty("etiqueta.RESTablvac");
        String MaterialType = po.getProperty("etiqueta.RESMaterialType");
        String Mate = po.getProperty("etiqueta.RESMatenoCre");
        String MateAl = po.getProperty("etiqueta.RESMatenoCreAl");
        String CECONO = po.getProperty("etiqueta.CSPCCostoNovali");
        String centrono = po.getProperty("etiqueta.VLDErrorCentro");
        String Almnot = po.getProperty("etiqueta.VLDErrorAlmace");
        String Ordenot = po.getProperty("etiqueta.CSPNotOrden");
        String AlmErr = po.getProperty("etiqueta.RESERErrAlm");
        int f;
        String foc;
        folios fo = new folios();
        fo = ACC_Folios.ObtenerIstancia().CargarAllDatos("RE");
        f = fo.getFolioActual() + 1;
        foc = fo.getIdFolios() + "" + f;

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
                var pag = p.charAt(48);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/StyleReservas.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/Reservas.js"></script>
        <title><%out.println(po.getProperty("etiqueta.RESCreaRes_Title"));%></title>
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
            <input type="image" src="images/guarda.PNG" onclick="validar();"/>
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.RESCreaRes_Title"));%></h1></div>
        </div>
        <div class="contenido">
            <div id="Cont" ></div>
            <div class="ContentReservas">
                <section class="DivReserva">
                    <label id="lblTitulo_reporte" style="width: 100%;"><%out.println(po.getProperty("etiqueta.RERSETitleData"));%></label>
                    <hr id="LineaTituloRev">
                    <section class="DivIzquierda">
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input id="centro" type="text" onpaste="return false"  maxlength="4" style="width: 13%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_CC" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></label><input id="Almacen" type="text" maxlength="4" style="width: 13%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;" onblur="ValAlma('1')"/><button id="match_CA" class='BtnMatchIcon2'></button>
                        <hr>
                        <label style="width: 26%;"><%out.println(po.getProperty("etiqueta.PedidoClMovPEd"));%></label><select id="ListTipMov" style="width: 13%;" > <option></option> </select> 
                    </section>
                    <section class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESConImp"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESCCosto"));%></label><input id="centroco" maxlength="10" type="text" style="width: 25%; margin-left: -5%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_CO" class='BtnMatchIcon2'></button><label style="width: 1%; margin-left: 4%;"><%out.println(po.getProperty("etiqueta.RESOTRO"));%> </label>
                            <hr>
                        </section>
                        <section class="DerechaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESOrdenin"));%></label><input id="orden" type="text" maxlength="12" style="width: 25%; text-transform: uppercase; margin-left: -8%; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_OI" class='BtnMatchIcon2'></button>
                            <hr>
                        </section>
                    </section>

                    <section style="margin-top:0.5%;" class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESMov311"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESAlmRe"));%></label><input id="Arece" type="text" maxlength="4" onblur="ValAlma('2')" style="width: 25%; text-transform: uppercase; margin-left: -13%; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_AR" class='BtnMatchIcon2'></button><button id="lismat" style="margin-left: 20px;" disabled>List. Mat</button>
                            <hr>
                        </section>        
                    </section>  
                </section>
                <section id="TablaStatus" class="TablaStatusC">
                    <table class="TablaCont" id="TablaReservas">
                        <thead id="CabeceraTabla">
                            <tr>
                                <td></td>
                                <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.RESCantNe"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.STOCKUnidadMedid"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                            </tr>
                        </thead>
                        <tbody id="CargaTodo">
                            <%
                                for (int i = 0; i < 1; i++) {
                                    out.println("<tr name=\"posi\" >\n"
                                            + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"posicion\" value=" + i + " id=\"posicion" + i + "\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"material\" maxlength=\"40\" id=\"material" + i + "\" onblur=\"ValMateReserva(" + i + ")\" onclick=\"BtnShow(" + i + ")\" style=\"text-transform: uppercase;\"><button id=\"match_MA" + i + "\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"MatchMaterial('" + i + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" min=\"1\" name=\"cantidad\" id=\"cantidad" + i + "\" onfocus=\"BtnHide()\"  onblur=\"this.value = checkDec(this.value, 3,'" + i + "')\"  onKeyUp=\"this.value = check99(this.value, '999999', 7 ,'" + i + "')\"  ></td>\n"
                                            + "                <td><input type=\"text\" name=\"unidadmedida\" maxlength=\"2\" id=\"unidadmedida" + i + "\" disabled style=\"text-transform: uppercase;\"></td>\n"
                                            + "                <td style=\"width: 40%;\"><input name=\"descripcion\" maxlength=\"50\" id=\"descripcion" + i + "\" disabled style=\"width: 100%; text-transform: uppercase;\"/></td>\n"
                                            + "           </tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </section>
                <section class='botonefil'>
                    <button id="btnAdd"></button><button id="btnDelete"></button><button id="btnReserva" onclick="window.location.reload()">   <%out.println(po.getProperty("etiqueta.RESNuevReser"));%></button>
                </section>
                <input type="text" id="focfoc" value="<%=foc%>" hidden>
                <input type="text" id="ffff" value="<%=f%>" hidden>
                <input type="text" id="idiomaa" value="<%=Idioma%>" hidden>
                <input type="text" id="usus" value="<%=Nombre%>" hidden>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></button><hr></div>
            <div id="BuscarParam_c" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll" class="table-scroll">
                        <div id="fixedY" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
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
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('almacen');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.RESAlamcene"));%></button><hr></div>
            <div id="BuscarParam_a" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTablaa" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrolla" class="table-scroll">
                        <div id="fixedYa" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th><th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosa">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div id="VentanaModalClaseMov" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ClaseMov');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button>Cl. Movimientos</button><hr></div>
            <div id="BuscarParam_CM" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTablaCM" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrolla" class="table-scroll">
                        <div id="fixedYa" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Tipo</th><th>Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatoCM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    

        <div id="VentanaModalCentroCoste" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centroco');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="camMATChpri('BuscarParam_co', 'ConsultaTablaco')"><%out.println(po.getProperty("etiqueta.VU_CentroCoste"));%></button><hr></div>
            <div id="BuscarParam_co" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.VU_CentroCoste"));%></label><input type="text" id="centro_co" style="width:35%; text-transform: uppercase;" maxlength="10"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PedidoSocCO"));%></label><input type="text" id="sociedad_co" style="width:35%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></label><input type="text" id="texto_breve" style="width:40%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax" style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkCentro"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('centroco');"/>
                </div>
            </div>
            <div id="ConsultaTablaco" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollco">
                        <div class="fixedY" id="fixedYco">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.VU_CentroCoste"));%></th><th><%out.println(po.getProperty("etiqueta.PedidoSocCO"));%></th><th><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosco">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalOrdenes" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('orden');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="camMATChpri('BuscarParam_o', 'ConsultaTablao')"><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></button><hr></div>
            <div id="BuscarParam_o" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></label><input type="text" id="orden_or" style="width:35%; text-transform: uppercase;" maxlength="12"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></label><input type="text" id="texto_breveor" style="width:40%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax2"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkOrden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('orden');"/>
                </div>
            </div>
            <div id="ConsultaTablao" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollo">
                        <div class="fixedY" id="fixedYo">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></th><th><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatoso">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('material');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="camMATChpri('BuscarParam_m', 'ConsultaTablam')"><%out.println(po.getProperty("etiqueta.BuscarMaterial_MAT"));%></button><hr></div>
            <div id="BuscarParam_m" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%=material%></label><input type="text" id="material_ma" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></label><input type="text" id="texto_mate" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%=centro%></label><input type="text" id="centrito" style="width:10%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%=MaterialType%></label><input type="text" id="TImat" style="width:10%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax5"   style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkMaterial"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('material');"/>
                </div>
            </div>
            <div id="ConsultaTablam" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollm">
                        <div class="fixedY" id="fixedYm">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%=material%></th><th><%out.println(po.getProperty("etiqueta.centromatch"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th><th><%=MaterialType%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXM" id="CargarDatosm">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <hr class="fecha" id="footerline">
            <div hidden>
                <input type="text" id="feres"/>
                <input type="text" id="hores"/>
            </div>

            <div id="VentanaModalTextli" class="VentanaModalFres">
                <div id="handle6"><label id="TituloMatch">Listas de Material</label><div class="BotonCerrar_Matc" id="cerrarmodalTL"><label >X</label></div></div>
                <div class="PanelBntMatch"><button>Listas de Material</button><hr></div>
                <div id="BuscarParamPedidoMM" class="BuscarParam_ur">
                    <div class="fonhandle3do_Match">
                        <div class="busquedaMatch">
                            <label>Listas de Material</label><input type="text" id="vallima" value="" readonly/>
                            <div id="table-scroller" style="margin-left:40%; margin-top:10px;">
                                <div id="cuerpoDatos">
                                    <div class="nofixedX" id="TabTextli">
                                    </div>
                                </div>
                            </div>    
                        </div>        
                    </div> 
                    <div class="Botones_MatchTEX">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="matlismodalOK"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="cerrarmodalCL"/>
                    </div>
                </div>
            </div>


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
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        var mes = meses2[f.getMonth()];
                        var dia = f.getDate();
                        if (dia <= 9) {
                            dita = "0" + dia;
                        } else {
                            dita = dia;
                        }
                        var fre = f.getFullYear() + "-" + mes + "-" + dita;
                        $('#fecha').html(fechaActual);
                        $('#feres').val(fre);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                        $('#fecha').html(fechaActual);
                        $('#fre').val(fre);
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">

        function mensajes(valor, v, v2) {
            switch (valor) {
                case "yei":
                    var mensok = "Creado " + v;
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/aceptar.PNG');
                    $('#msg').html(mensok);
                break;
                case "EAlm":
                    var mensok = "Material " + v + " " + '<%=AlmErr%>';
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    $('#msg').html(mensok);
                    break;
                case "MensOk":
                    var mensajOk = '<%=meFOL%>';
                    if (mensajOk != null) {
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/aceptar.png');
                        $('#msg').html("Creado con exito " + mensajOk);
                    } else {
                        borramsg();
                    }
                    break;
                case "MenVal":
                    var menval = '<%=MenVal%>';
                    $('#msg').html(menval);
                    break;
                case "MenValores":
                    var menvalores = '<%=menValores%>';
                    $('#msg').html(menvalores);
                    break;
                case "CampOb":
                    var mensj = '<%=CampOb%>';
                    $('#msg').html(mensj);
                    break;
                case "errorcon":
                    var okcon = '<%=errocon%>';
                    $('#msg').html(okcon);
                    break;
                case "inval":
                    var invalm = '<%=funcioninv%>';
                    $('#msg').html(invalm);
                    break;
                case "CampOb201":
                    var c201 = '<%=CampOb201%>';
                    $('#msg').html(c201);
                    break;
                case "CampOb261":
                    var c261 = '<%=CampOb261%>';
                    $('#msg').html(c261);
                    break;
                case "CampOb311":
                    var c311 = '<%=CampOb311%>';
                    $('#msg').html(c311);
                    break;
                case "AlmReNot":
                    var AlmReNot = '<%=AlmReNot%>';
                    $('#msg').html(AlmReNot);
                    break;
                case "tablva":
                    var tablva = '<%=tablva%>';
                    $('#msg').html(tablva);
                    break;
                case "Mate":
                    var Mate = "Material " + v + " " + '<%=Mate%>';
                    $('#msg').html(Mate);
                    break;
                case "MateAl":
                    var Mate = "Material " + v + " " + '<%=MateAl%>' + " " + v2;
                    $('#msg').html(Mate);
                    break;
                case "CECO":
                    var ce = '<%=CECONO%>' + " " + v;
                    $('#msg').html(ce);
                    break;
                case "Cntr":
                    var ce = '<%=centrono%>' + " " + v;
                    $('#msg').html(ce);
                    break;
                case "AlmNo":
                    var ce = '<%=Almnot%>' + " " + v;
                    $('#msg').html(ce);
                    break;
                case "ordnpt":
                    var ce = '<%=Ordenot%>' + " " + v;
                    $('#msg').html(ce);
                    break;
                case "almva":
                    var ceal = "Falta campos por llenar";
                    $('#msg').html(ceal);
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
