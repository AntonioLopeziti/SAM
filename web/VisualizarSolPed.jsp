
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%-- 
    Document   : VisualizarSolPed
    Created on : 24-ago-2016, 18:52:49
--%>

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
        String reso = po.getProperty("etiqueta.Resolucio");

        String SoliNot = po.getProperty("etiqueta.CSPSolicituNoEnco");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
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
                var pag = p.charAt(37);
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
                        msg = "<%=CampoOb%>";
                        break;
                    case 3:
                        msg = "<%=SoliNot%>";
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
        <link rel="stylesheet" href="css/StyleSolped.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarSolPed.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.CSPVisuSolped"));%></title>    
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
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"  />
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.CSPVisuSolped"));%></h1></div>    
        </div>            
        <div class="contenido">
            <div class="ContentSolped">
                <div class="divCab">
                    <section id="cabeceraTemp" hidden></section>
                    <section class="SecI">
                        <label><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></label><select id="ClaseDoc" style="width: 40%">
                        </select>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPVisNumSol"));%></label><input type="text" id="Numsoli" maxlength="10"/><button id="matchFolSolped"  class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></label><input type="text" id="OrgCompras"  maxlength="4" style="width: 20%; background-repeat: no-repeat; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input type="text" id="GpoCompras" maxlength="3" style="width: 20%; background-repeat: no-repeat; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPNumNecesidad"));%></label><input type="text" id="necesidad" style="width: 25%;" disabled/>
                    </section>
                    <section class="SecD">
                        <img disabled  id="ICONAD"><input readOnly type="text" id="mensgesolped" style="border:none; background: none"/>
                        <textarea rows="6" cols="6"  style="resize:none;" id="TextCabecera_SP"  disabled></textarea>
                    </section>
                </div>
                <div class="divTabla">
                    <label><%out.println(po.getProperty("etiqueta.CSPPosciones"));%></label>
                    <hr>
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
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
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
                <div class="DivDetallePos">
                    <label><%out.println(po.getProperty("etiqueta.CSPDetallePosicion"));%></label><select id="Distribucion_SP"></select>
                </div>
                <div class="divImputacion" id="divimpu">
                    <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                    <hr id="LineSC">
                    <div class="divTipos">
                        <div class="tip1">
                            <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion2"));%></label><input type="text" maxlength="1" id="TipoImputacion" style="width:15%; text-transform: uppercase;" disabled/>
                            <hr>
                        </div>
                        <div class="tip2">
                            <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición2"));%></label><input type="text" maxlength="1" id="TipoPosicion" style="width:15%; text-transform: uppercase;" disabled/>
                            <hr>
                        </div>
                        <div class="tip3">
                            <button id="btnservicios" style="background-image: url(images/servicios.PNG); background-repeat: no-repeat; padding-right: 1%; padding-left: 8%; padding-bottom: .5%;" ><%out.println(po.getProperty("etiqueta.CSPServicio"));%></button>                                    
                        </div>
                    </div>
                    <div class="divimpsol">
                        <div class="inp1">
                            <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="Material" style="width:35%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPCantida"));%></label><input type="text" id="Cantidad" onpaste="return false" style="width: 10%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPFechEnt"));%></label><input  type="text" id="FecEntrega" maxlength="10" style="witdh:20%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="Centro" maxlength="4" style="width: 20%; text-transform: uppercase; background-repeat: no-repeat;" disabled />
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><input type="text" id="Almacen" maxlength="4" style="width: 20%; background-repeat: no-repeat;" disabled/>
                            <hr>
                        </div>
                        <div class="inp2">
                            <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="Txtbrve" style="width: 60%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="unidamedida" style="width: 10%; background-repeat: no-repeat;" disabled />
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></label><input type="text" id="GpoArticulo" style="width: 25%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPSolic"));%></label><input type="text" id="solicitante" value= "" style="width: 25%; background-repeat: no-repeat;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPSEstLbe"));%></label><input type="text" id="E1" style="width: 3%;" disabled>  <input id="E2" type="text" style="width: 5%;" disabled/> <input type="text" id="E3" style="width: 45%; border: none; background: none;" readonly/>
                            <hr>
                        </div>
                    </div>
                    <br>
                    <div class="subimputacion" id="divim">
                        <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                        <hr id="LineSubIm">
                        <div class="subinn1">
                            <label><%out.println(po.getProperty("etiqueta.CSPCMayor"));%></label><input type="text" id="ctaMayor" style="width: 30%;" disabled/>
                            <hr>
                        </div>
                        <div class="subinn2">
                            <label><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><input type="text" id="CenCosto" style="width: 30%;" disabled/>
                            <hr>
                        </div>
                        <div class="subinn3">
                            <label><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></label><input type="text" id="Orde" style="width: 30%;" disabled/>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="Divtextposicion">
                    <label><%out.println(po.getProperty("etiqueta.CSPCeTextPsoci"));%></label>
                    <hr style="border: none">
                    <textarea rows="6" cols="6"  style="resize:none;" id="TextPosicion_SP"  disabled></textarea>
                </div>
            </div>
        </div>
        <div class="VentanaModalServices" id="WindowService">
            <div id="handleSer"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.WServSp"));%></label></div>
            <div class="ServiceGral">
                <div class="ServDatoPso">
                    <label><%out.println(po.getProperty("etiqueta.SerDatosPos"));%></label>
                    <hr id="LineSC">
                    <div class="Serv1">
                        <label><%out.println(po.getProperty("etiqueta.CSPCMayor"));%></label><input type="text" id="ctaMayorSer"  readOnly style="width: 30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion2"));%></label><input type="text" id="ImputacionSer" readOnly value="K" style="width: 10%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="MaterialSer" readOnly style="width: 40%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPCantida"));%></label><input type="text" id="CantidadSer" readOnly style="width: 15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPFechEnt"));%></label><input type="text" id="FentregaSer" maxlength="10" readOnly style="width: 25%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="CentroSer" readOnly style="width: 15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPAlmac"));%></label><input type="text" id="AlmacenSer" readOnly style="width: 15%;"/>
                        <hr>
                    </div>
                    <div class="Serv1">
                        <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición2"));%></label><input type="text" id="TipoPosicionSer" readOnly style="width: 5%;"/> 
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPCCosto"));%></label><input type="text" id="CentroCostoSer" readOnly style="width: 35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="TxtbrveSer" readOnly style="width: 65%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="UnidadMediaSer" readOnly style="width: 15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></label><input type="text" id="GArticuloSer" readOnly style="width: 35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPSolic"));%></label><input type="text" id="SolicitanteSer" readOnly style="width: 35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPOrden"));%></label><input type="text" id="OrdenSer" readOnly style="width: 25%;"/>
                        <hr>
                    </div>
                </div>                    
                <div class="ServTable">
                    <div id="TablaStatus2">
                        <table class="TablaCont2">
                            <tr id="CabeceraTabla">
                                <td>&nbsp;&nbsp;&nbsp;</td>
                                <td><%out.println(po.getProperty("etiqueta.CSPPosicio"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.SerLinea"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.SerServic"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.CSPCantida"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.CSPNumSerDesc"));%></td>
                            </tr> 
                            <tbody id="gloSer">
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="BonotServies">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="cursor:pointer;" id="Cerrarservicios"/>
                </div>
            </div>
        </div>
        <div id="VentanaModalFolioSolped" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPVisNumSol"));%></label><div class="BotonCerrar_Matc" id="CerrarMCSolped"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornafiltrosolped"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamsolped" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPVisNumSol2"));%></label><input type="text" id="BusSolpedSAP" style="width:35%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input type="date" id="fechasol" maxlength="10" style="width:35%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="oksolp"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCSolped2"/>
                </div>
            </div>
            <div id="ConsultaTablaSolped" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSolped">
                        <div class="fixedY" id="fixedYSolped">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPVisNumSol2"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.GralFecha"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSolped">
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
                writefecha.html("Fecha indefinida");
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
