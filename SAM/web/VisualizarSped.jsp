<%-- 
    Document   : VisualizarSped
    Created on : 8/09/2016, 09:50:42 AM
    Author     : JaroMX
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String existFol = po.getProperty("etiqueta.MensajeNoExiste_FO");
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
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleVisualizarSolped.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/visualizarSPed.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.ModSolicitudePedid"));%></title>       
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
                <input id="aceptar" type="image" src="images/aceptar.png"/>                
                <input id="guardar" type="image" src="images/guarda.PNG" disabled /> 
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" disabled/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" disabled/>
            </div>            
            <div class="contenido">
                <div id="VisualUser_USU" hidden></div>
                <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ModSolicitudePedid"));%></h1></div>      
                <div class="ContenidoScrollbar">
                    <div class="ContentSolped">
                        <div class="subParametrosBusquedaSolped">
                                <label>Parámetros de búsqueda</label>
                                <hr id="lineaPaSAPSA">    
                                <div class="paramSAMSAP">
                                    <label>Folio SAP:</label><input type="text" style="width: 25%; background-repeat: no-repeat;" id="folioSAP_SP"/><button id="matchFolioSAP_SP" class='BtnMatchIcon'></button>
                                    <hr id="lineaBusqueda">
                                    <label>Folio SAM:</label><input type="text" style="width: 25%; background-repeat: no-repeat;" id="folioSAM_SP"/><button id="matchFolioSAM_SP" class='BtnMatchIcon'></button>
                                    <hr id="lineaBusqueda">                                  
                                </div>                                
                            </div>
                        <div class="divCab">
                            <section class="SecI">
                                <label><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></label><select id="ClaseDoc" style="width: 40%">
                                    <option><%out.println(po.getProperty("etiqueta.CSPCSOLPEDOF"));%></option>
                                </select>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></label><input type="text" id="OrgCompras" maxlength="4" style="width: 20%; background-repeat: no-repeat;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input type="text" id="GpoCompras" maxlength="3" style="width: 20%; background-repeat: no-repeat;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.CSPNumNecesidad"));%></label><input type="text" id="necesidad" style="width: 25%;" disabled/>
                            </section>
                            <section class="SecD">
                                <textarea rows="6" cols="6"  style="resize:none;" id="TextCabecera_SP" maxlength="130" disabled></textarea>
                            </section>
                        </div>
                        <div class="divTabla">
                            <label><%out.println(po.getProperty("etiqueta.CSPPosciones"));%></label>
                            <hr>
                            <section id="TablaStatus">
                                <table class="TablaCont">
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPPoscion"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPTextoBreve2"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPCantidad"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPUnidadMedida2"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPPreciEstima"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPMone"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPFechaEntrega2"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo2"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPCentro"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPSolicitante"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPGrpoCompras2"));%></td>                                               
                                        <td><%out.println(po.getProperty("etiqueta.CSPNumNecesidad2"));%></td>                                                
                                        <td><%out.println(po.getProperty("etiqueta.CSPProvDesea"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPProvFijo"));%></td>                                                
                                        <td><%out.println(po.getProperty("etiqueta.CSPContrato"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPPosContrato"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPRegistroInfo"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPMatnopieza"));%></td>
                                    <tbody id="glo">
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                </table>
                            </section>
                        </div>
                        <div class="DivDetallePos">
                            <label><%out.println(po.getProperty("etiqueta.CSPDetallePosicion"));%></label><select></select>
                        </div>
                        <div class="divImputacion">
                            <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                            <hr id="LineSC">
                            <div class="divTipos">
                                <div class="tip1">
                                    <label><%out.println(po.getProperty("etiqueta.CSPTipoImputacion"));%></label><input type="text" maxlength="1" id="TipoImputacion" style="width:15%;" disabled><button id="matchTImputacion" class='BtnMatchIcon'></button>
                                    <hr>
                                </div>
                                <div class="tip2">
                                    <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición"));%></label><input type="text" id="TipoPosicion" style="width:15%;" disabled><button id="matchTPosicion" class='BtnMatchIcon'></button>
                                    <hr>
                                </div>
                                <div class="tip3">
                                    <button id="btnservicios" style="background-image: url(images/servicios.PNG); background-repeat: no-repeat; padding-right: 1%; padding-left: 8%; padding-bottom: .5%;"><%out.println(po.getProperty("etiqueta.Servicio"));%></button>                                    
                                </div>
                            </div>
                            <div class="divimpsol">
                                <div class="inp1">
                                    <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="Material" style="width:35%; background-repeat: no-repeat;" disabled/><button id="matchMaterial" class='BtnMatchIcon2'></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPCantidad"));%></label><input type="text" id="Cantidad" style="width: 10%; background-repeat: no-repeat;" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPFechaEntrega"));%></label><input type="date" id="FecEntrega" style="width: 30%; background-repeat: no-repeat;" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="Centro" style="width: 20%; background-repeat: no-repeat;" disabled/><button id="matchCentro" class='BtnMatchIcon2'></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><input type="text" id="Almacen" style="width: 20%; background-repeat: no-repeat;" disabled/><button id="matchAlmacen" class='BtnMatchIcon2'></button>
                                    <hr>
                                </div>
                                <div class="inp2">
                                    <label><%out.println(po.getProperty("etiqueta.CSPTextoBreve"));%></label><input type="text" id="Txtbrve" style="width: 60%; background-repeat: no-repeat;" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="unidamedida" style="width: 10%; background-repeat: no-repeat;" disabled/><button id="matchUM" class="BtnMatchIcon"></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPGrpoArticulo"));%></label><input type="text" id="GpoArticulo" style="width: 25%; background-repeat: no-repeat;" disabled/><button id="matchGpoArticulo" class="BtnMatchIcon"></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPSolicitante"));%></label><input type="text" id="solicitante" style="width: 25%; background-repeat: no-repeat;" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CSPPreciValor"));%></label><input type="text" id="preciovalor" style="width: 15%; background-repeat: no-repeat;" disabled/>
                                    <input type="text" id="clvmoneda" style="width: 10%; background-repeat: no-repeat;" disabled>
                                    <hr>
                                </div>
                            </div>
                            <br>
                            <div class="subimputacion">
                                <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                                <hr id="LineSubIm">
                                <div class="subinn1">
                                    <label><%out.println(po.getProperty("etiqueta.CSPCtaMayor"));%></label><input type="text" id="ctaMayor" style="width: 30%;" disabled/><button id="matchCtaMayor" class="BtnMatchIcon2"></button>
                                    <hr>
                                </div>
                                <div class="subinn2">
                                    <label><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><input type="text" id="CenCosto" style="width: 30%;" disabled/><button id="matchCCosto" class="BtnMatchIcon2"></button>
                                    <hr>
                                </div>
                                <div class="subinn3">
                                    <label><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></label><input type="text" id="Orde" style="width: 30%;" disabled/><button id="matchOrden" class="BtnMatchIcon2"></button>
                                    <hr>
                                </div>
                            </div>
                        </div>
                        <div class="Divtextposicion">
                            <label><%out.println(po.getProperty("etiqueta.CSPCeTextPsoci"));%></label>
                            <hr style="border: none">
                            <textarea rows="6" cols="6"  style="resize:none;" id="TextPosicion_SP" maxlength="130" disabled></textarea>
                        </div>
                    </div>
                </div>
            </div>       
        </div>   
        <div id="VentanaModalSAP" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sap')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParamOCompras_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Número folio SAP</label><input type="text" id="BuscarfoliosapSP" style="width:35%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaOCompras" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOCompras">
                        <div class="fixedY" id="fixedYOCompras">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAP</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOCompras">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalSAM" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sam');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParamGCompras_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Número folio SAM</label><input type="text" id="BuscarFoliosam" style="width:35%;" focus/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax2" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okSAM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('sam');"/>
                </div>
            </div>
            <div id="ConsultaTablaGCompras" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGCompras">
                        <div class="fixedY" id="fixedYGCompras">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAM</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoGCompras">
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
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                        
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
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
                        document.getElementById('iconmsg').style.visibility = "hidden";
                    };

                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function validar(){
            var sap = document.getElementById('folioSAP_SP').value;
            if (sap.length < 1){
                  var mensj = 'Campo folio sap vacio';
                  var iconm = document.getElementById("iconmsg");
                  iconm.style.visibility = "visible";
                  iconm.src = "images/advertencia.PNG";
                  var men = document.getElementById("msg");
                  men.innerHTML = mensj;  
            } else {
                Validarsap(sap);
            }
        }
        function val(){
            var sam = document.getElementById('folioSAM_SP').value;
            if (sam.length < 1){
                  var mensj = 'Campo folio sam vacio';
                  var iconm = document.getElementById("iconmsg");
                  iconm.style.visibility = "visible";
                  iconm.src = "images/advertencia.PNG";
                  var men = document.getElementById("msg");
                  men.innerHTML = mensj;  
            } else {
                Validarsam(sam);
            }
        }
        function Validarsap(sap) {
            var  url = "ModulovisualizarSolped";
            var  Acc = "ValidarfolioSAP";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    if (rs == 1) {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = 'El folio sap existe:' + sap;
                        cargarDatos();
                    } else {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = 'El folio sap  no existe:' + sap;
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + Acc + "&sap=" + sap, true);
            xmlhttp.send();
        }
        function Validarsam(sam) {
            var  url = "ModulovisualizarSolped";
            var  Acc = "ValidarfolioSAM";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    if (rs == 1) {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = 'El folio sam existe:' + sam;
                    } else {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = 'El folio sam  no existe:' + sam;
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + Acc + "&sam=" + sam, true);
            xmlhttp.send();
        }
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
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
        function borrarmsg() {
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "hidden";
            var men = document.getElementById("msg");
            men.innerHTML = "";
        }
        function mostrarVentanaModal(tipo) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            switch (tipo) {
                case "sap":
                    var ventana1 = document.getElementById('VentanaModalSAP');
                    abrirVentana(ventana1);
                    var txtoc = document.getElementById('BuscarfoliosapSP');
                    txtoc.focus();
                    break;
                case "sam":
                    var ventana2 = document.getElementById('VentanaModalSAM');
                    abrirVentana(ventana2);
                    var txtgc = document.getElementById('BuscarFoliosam');
                    txtgc.focus();
                    break;
            }
        }
        function abrirVentana(ventana) {
            var ancho = 350;
            var alto = 650;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
        }
        function ocultarVentana(tipo) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#overlay').remove();
            switch (tipo) {
                case "sap":
                    var ventana1 = document.getElementById('VentanaModalSAP');
                    ventana1.style.display = 'none';
                    document.getElementById("BuscarParamOCompras_SP").style.display = "block";
                    document.getElementById("ConsultaTablaOCompras").style.display = "none";
                    document.getElementById("OrgCompras").focus();
                    borramsg();
                    break;
                case "sam":
                    var ventana2 = document.getElementById('VentanaModalSAM');
                    ventana2.style.display = 'none';
                    document.getElementById("BuscarParamGCompras_SP").style.display = "block";
                    document.getElementById("ConsultaTablaGCompras").style.display = "none";
                    document.getElementById("GpoCompras").focus();
                    borramsg();
                    break;
            }
        }
        function ConsultaFolioSAP() {
            var url = "ModulovisualizarSolped";
            var acc = "ConsultaFolioSAP";
            var folio = document.getElementById("BuscarfoliosapSP").value;
            var ctd = document.getElementById("numAcMax").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaOCompras").style.display = "block";
                        document.getElementById("cargarDatosOCompras").innerHTML = rs;
                        fnc();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&folio=" + folio + "&cdtmax=" + ctd , true);
            xmlhttp.send();
        }
        function ConsultaFolioSAM() {
            var url = "ModulovisualizarSolped";
            var acc = "ConsultaFolioSAM";
            var folio = document.getElementById("BuscarFoliosam").value;
            var ctd = document.getElementById("numAcMax2").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamGCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaGCompras").style.display = "block";
                        document.getElementById("cargarDatoGCompras").innerHTML = rs;
                        fnc2();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&folio=" + folio + "&cdtmax=" + ctd , true);
            xmlhttp.send();
        }
         function cargarDatos() {
            var url = "ModulovisualizarSolped";
            var folio = document.getElementById('folioSAP_SP').value;
            var type = "sap";
            var acc = "CargarDatos";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    document.getElementById("VisualUser_USU").innerHTML = rs;
                    cargar();
                    var okcon = "";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&folio=" + folio + "&tipo=" + type, true);
            xmlhttp.send();
        }
        function cargar() {
            var OrgCompras = document.getElementById("Orgcompras_VSP").value;
            document.getElementById("OrgCompras").value = OrgCompras;
            var Grupocompras = document.getElementById("GrupoCompras_VSP").value;
            document.getElementById("GpoCompras").value = Grupocompras;
            var nesecidad = document.getElementById("Folio_VSP").value;
            document.getElementById("necesidad").value = "00000"+nesecidad;
            var textocabecera = document.getElementById("Textocaecera_VSP").value;
            document.getElementById("TextCabecera_SP").value = textocabecera;
        }
        function ErrorBusquedaMatch() {
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
            var okcon = "<%=menValores%>";
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = okcon;
        }
        function borramsg() {
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "hidden";
            var men = document.getElementById("msg");
            men.innerHTML = "";
        }
        function fnc() {
            document.getElementById('table-scrollOCompras').onscroll = function () {
                document.getElementById('fixedYOCompras').style.top = document.getElementById('table-scrollOCompras').scrollTop + 'px';
            };
        }
        function fnc2() {
            document.getElementById('table-scrollGCompras').onscroll = function () {
                document.getElementById('fixedYGCompras').style.top = document.getElementById('table-scrollGCompras').scrollTop + 'px';
            };
        }
        function fnc3() {
            document.getElementById('table-scrollImputacion').onscroll = function () {
                document.getElementById('fixedYImputacion').style.top = document.getElementById('table-scrollImputacion').scrollTop + 'px';
            };
        }
        function fnc4() {
            document.getElementById('table-scrollTioPosicion').onscroll = function () {
                document.getElementById('fixedYTipoPosicion').style.top = document.getElementById('table-scrollTioPosicion').scrollTop + 'px';
            };
        }
        function fnc5() {
            document.getElementById('table-scrollMaterial').onscroll = function () {
                document.getElementById('fixedYMaterial').style.top = document.getElementById('table-scrollMaterial').scrollTop + 'px';
            };
        }
        function fnc6() {
            document.getElementById('table-scrollCentro').onscroll = function () {
                document.getElementById('fixedYCentro').style.top = document.getElementById('table-scrollCentro').scrollTop + 'px';
            };
        }
        function fnc7() {
            document.getElementById('table-scrollAlmacen').onscroll = function () {
                document.getElementById('fixedYAlmacen').style.top = document.getElementById('table-scrollAlmacen').scrollTop + 'px';
            };
        }
        function fnc8() {
            document.getElementById('table-scrollUM').onscroll = function () {
                document.getElementById('fixedYUM').style.top = document.getElementById('table-scrollUM').scrollTop + 'px';
            };
        }
        function fnc9() {
            document.getElementById('table-scrollGArticulos').onscroll = function () {
                document.getElementById('fixedYGArticulos').style.top = document.getElementById('table-scrollGArticulos').scrollTop + 'px';
            };
        }
        function Select(dato, tipo) {
            switch (tipo) {
                case "sap":
                    document.getElementById("folioSAP_SP").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "sam":
                    document.getElementById("folioSAM_SP").value = "00000" + dato;
                    ocultarVentana(tipo);
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
