<%-- 
    Document   : VisualizarDocumentosListaMaterial
    Created on : 10/08/2016, 01:48:03 PM
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
                response.sendRedirect("#");
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
        String Docee = po.getProperty("etiqueta.DocNoencon");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String Mens = po.getProperty("etiqueta.CompObligatorios");
        String NoExisteValores_SAM = po.getProperty("etiqueta.NoExisteValores_SAM");
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
    <%
        String iddoc = request.getParameter("MiI");
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
                var pag = p.charAt(35);
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
                        msg = '<%=Mens%>';
                        break;
                    case 2:
                        msg = '<%=Docee%>';
                        break;
                    case 3:
                        msg = '<%=NoExisteValores_SAM%>';
                        break;
                    case 4:
                        msg = 'Error: En comunicacion con Ivend';
                        break;
                    case 5:
                        msg = "Espere un momento...";
                        break;

                }
                $('#msg').html(msg);
                var icon = $('#iconmsg');
                icon.attr('src', im);
                icon.show();
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
            function CheckData() {
                var iddocu = '<%=iddoc%>';
                if (iddocu == null || iddocu == "null") {
                    iddocu = "";
                }
                if (iddocu != "") {
                    $('#idDoc').val(iddocu);
                    $('#idDoc').prop('disabled', true);
                    $('#ejeDo').prop('disabled', true);
                    validaDoc(iddocu);
                }
            }
            function ShowMsgWindow(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = 'Error: Movimiento aceptado anteriormente';
                        break;
                    case 1:
                        msg = 'Error: No Coinciden posiciones';
                        break;
                    case 2:
                        msg = 'Enviado Exitosamente';
                        break;
                    case 3:
                        msg = 'Traspaso Cencelado correctamente';
                        break;
                    case 4:
                        msg = 'Error: El movimiento no puede ser rechazado, ya fue aceptado pero no fue enviado correctamente';
                        break;
                }

                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                var ancho = 450;
                var alto = 500;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                var ventana = $('#Windowmsg');
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                var icon = $('#iocnomsgso');
                icon.show();
                icon.attr('src', im);
                $('#msgss').html(msg);
                var theHandle = document.getElementById("handleMsg");
                var theRoot = document.getElementById("Windowmsg");
                document.getElementById("CloMsg").focus();
                Drag.init(theHandle, theRoot);
                borramsg();
            }

        </script>

        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleDocListaMaterial.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/DocumentoListaMaterial.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.DocVisualizDocMat_Title"));%></title>  
    <body>
        <div id="main-header">   
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptaOFF.png"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png"/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" />
            <input  id="cancelar" type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.DocVisualizDocMat_Title"));%><span id="idD"></span></h1></div>      
        </div>
        <div class="contenido">
            <div id="ContenOculto" hidden ></div>
            <div class="ContentDocumento">                       
                <div class="divcab">
                    <select disabled="true" style="width: 10%;"><option><%out.println(po.getProperty("etiqueta.DocVisualizDMa"));%></option></select>
                    <select disabled="true" style="width: 18%;"><option><%out.println(po.getProperty("etiqueta.DocDocumentMaDMa"));%></option></select>
                    <input type="text" value="" id="idDoc" style="width: 18%; text-transform: uppercase;" maxlength="10"/><button id="btnmatchDoc"  class="BtnMatchIcon"></button> 
                    <input type="text" value="" id="ejerdoc" style="width: 8%;" disabled="true"/>
                    <input type="image" id="ejeDo" src="images/ejecu.JPG"  style="vertical-align: middle"/> 
                    <input type="image" src="images/buscar.JPG"  style="vertical-align: middle"/> 
                    <input type="image" src="images/period.JPG" disabled="true" style="vertical-align: middle"/> 
                    <button  id="btnAccept"><%out.println(po.getProperty("etiqueta.DocVisConfirmar"));%></button>
                    <button  id="btnCancelD">Rechazar</button>
                    <input type="text" id="SAPDATA" hidden/>
                    <input type="text" id="SAMDATA" hidden/>
                </div>
                <section class="Seccionbtn1">                            
                    <div class="btn1dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrar" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultar" src="images/gris.PNG"/>
                    </div>
                    <div class="pesta1">
                        <div class="tabsorden">
                            <button id="tabGen"><%out.println(po.getProperty("etiqueta.DocGeneDMa"));%></button>
                            <button id="tabProv"><%out.println(po.getProperty("etiqueta.DocProvDMa"));%></button>
                        </div>
                        <hr id="lineatabs">
                        <div class="ContenidoTabsOrden">
                            <section class="TabSecGeneral" id="seccionGnrl">                                
                                <section class="gnrS1">
                                    <label><%out.println(po.getProperty("etiqueta.DocFechDocumentMaDMa"));%></label><input style="width: 40%;" type="text" id="fechDoc" disabled="true"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DocFechConDMa"));%></label><input style="width: 40%;" type="text" id="fechCont" disabled="true"/>
                                    <hr>
                                </section>
                                <section class="gnrS1">
                                    <label><%out.println(po.getProperty("etiqueta.DocFechEntDMa"));%></label><input style="width: 40%;" type="text" id="notEnt" disabled="true"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DocCrtaportDMa"));%></label><input style="width: 40%;" type="text" id="cartPort" disabled="true"/>
                                    <hr>
                                </section>
                                <section class="gnrS1">
                                    <label><%out.println(po.getProperty("etiqueta.DocTxtcabDMa"));%></label><input type="text" style="width: 45%;"  id="txtCab" disabled="true"/>
                                    <hr>
                                </section>
                            </section>
                            <section class="TabSecProveedor" id="seccionProv" >                                
                                <section class="prov1">
                                    <label><%out.println(po.getProperty("etiqueta.DocProvDMa"));%></label><input type="text" id="prov" disabled="true" style="width: 30%;"/>
                                    <hr>
                                    <input type="text" id="proNo" disabled="true" style="width: 90%;"/>
                                    <br>
                                </section>
                                <section class="prov2">
                                    <label><%out.println(po.getProperty("etiqueta.DocProvRecDMa"));%></label><input type="text" id="provR" disabled="true" style="width:60%;"/>
                                    <hr>
                                </section>
                            </section>
                        </div>
                    </div>
                </section> 
                <section class="secTabl">
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td>&nbsp;&nbsp;&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.DocNoDocDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocPoscion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DoclotDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocCmvDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocpedDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocCUMEDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocUMEDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocCCsDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocOrdDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocSocDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocEDMa"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocAlamDes"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.DocNomPDMa"));%></td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo2">
                                    <table id="TabBody">
                                        <tbody>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr class="ocultar">
                                                <td>0000</td>
                                                <td>0000000000000000000000</td>
                                                <td>00000000000000</td>
                                                <td>0000000000000000000</td>
                                                <td>00000000000000000000</td>
                                                <td>0000000000000000000000</td>
                                                <td>00000000000000000000000000000000</td>
                                                <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>
                                                <td>0000000000000000</td>
                                                <td>0000000000000</td>
                                                <td>00000000000000000</td>
                                                <td>00000000000000000</td>
                                                <td>00000000000000000</td>
                                                <td>00000000000000000</td>
                                                <td>0000000000000000000</td>
                                                <td>00000000000000000000</td>
                                                <td>000000000000000000000</td>
                                                <td>000000000000000000000</td></tr>
                                        </tbody>
                                    </table>
                                </section>
                            </section>
                        </section>
                    </div>
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
                </section>
                <label><%out.println(po.getProperty("etiqueta.CSPDetallePosicion"));%></label><select id="SelectPos" style="width:10%;"><option></option></select>
                <section class="SectTabbtn2">
                    <div class="btn1dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrar2" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultar2" src="images/gris.PNG"/>
                    </div>
                    <div class="pesta2">
                        <div class="tabsorden">
                            <button id="tabMat"><%out.println(po.getProperty("etiqueta.DocMatDMa"));%></button>
                            <button id="tabSe"><%out.println(po.getProperty("etiqueta.DocSeDMa"));%></button>
                            <button id="tabLot"><%out.println(po.getProperty("etiqueta.DocDPedDMa"));%></button>
                            <button id="tabCtd"><%out.println(po.getProperty("etiqueta.DocCtdaaDMa"));%></button>
                            <button id="tabImp"><%out.println(po.getProperty("etiqueta.DoclotDMa"));%></button>
                        </div>
                        <hr id="lineatabs">
                        <section class="ContenidoTabsOrden2" id="Secidin">
                            <section class="TabSecMaterial" id="seccionMate" >   
                                <section class="subMat1">
                                    <label><%out.println(po.getProperty("etiqueta.DocMatDMa"));%></label><input type="text" id="matNom" disabled="true" style="width: 30%;"/>
                                    <input type="text" id="numMat" disabled="true" style="width: 15%;"/>
                                    <hr>                                        
                                    <label><%out.println(po.getProperty("etiqueta.DocN0MateProDMa"));%></label><input type="text" id="noMatProv" disabled="true" style="width: 25%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DocGpoArDMa"));%></label><input type="text" id="grpArt" disabled="true" style="width: 10%;"/>
                                    <hr>
                                </section>
                            </section>
                            <section class="TabSecSe" id="seccionSe">   
                                <section class="subSe1">
                                    <label><%out.println(po.getProperty("etiqueta.DocClMoviDMa"));%></label><input type="text" id="clsMov" style="width: 10%;" disabled="true"/>
                                    <input type="text" id="indE" disabled="true" style="width: 3%;"/>
                                    <input type="text" id="inddebe" value="" disabled="true" style="width: 2%;"/>
                                    <input type="text" id="" value="" readonly style="width: 30%; border: none; background: none;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DocProvDMa"));%></label><input type="text" id="provNoms" disabled="true" style="width: 50%;"/>
                                    <hr>                                          
                                    <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input type="text" id="cenDes" disabled="true" style="width: 50%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></label><input type="text" id="alm" disabled="true" style="width: 30%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DocPtoDescDMa"));%></label><input type="text" id="ptoDes" disabled="true" style="width: 35%;"/>
                                    <hr>
                                </section>
                                <section class="subSe2">
                                    <label><%out.println(po.getProperty("etiqueta.DocTipoStokDMa"));%></label><select disabled="true" style="width:30%;"><option>Libre Utilizacion</option></select>
                                    <hr>
                                    <input type="text" id="provCod" style="width:20%;" disabled="true"/>  
                                    <hr style="border:none;">
                                    <input type="text" id="centroCod" disabled="true" style="width:15%;"  />
                                    <hr style="border:none;">
                                    <input type="text" id="almCod" disabled="true"  style="width:15%;"/><label style="margin-left: 3%;"><%out.println(po.getProperty("etiqueta.DocDesti"));%></label><input type="text" style="margin-left: -18%; width: 15%;" id="almDes" disabled="true"/>
                                </section>
                            </section>
                            <section class="TabSecLot" id="seccionLot" style="">   
                                <section class="subLot1">
                                    <label><%out.println(po.getProperty("etiqueta.DocPedidoDMa"));%></label><input type="text" id="pedNom" disabled="true" style="width:15%;"/>  
                                    <input type="text" id="pedCod" disabled="true" style="width:5%;"/>
                                    <hr>
                                </section>
                            </section> 
                            <section class="TabSecCtd" id="seccionCtd" style="">   
                                <section class="subCtd1">
                                    <label><%out.println(po.getProperty("etiqueta.DocProvDMa"));%></label><input type="text" id="ItprovNom" style="width:40%;" disabled="true"/>
                                    <input type="text" id="ItprovCod" disabled="true" style="width:15%;"/>
                                    <hr>
                                    <br>
                                    <br>
                                    <label><%out.println(po.getProperty("etiqueta.DocProvRecDMa"));%></label><input type="text" id="ItprovRNom" style="width:40%;" disabled="true"/>
                                    <input type="text" id="ItprovRCod" disabled="true" style="width:15%;"/>
                                    <hr>
                                </section>                                        
                            </section>
                            <section class="TabSecImp" id="seccionImp">   
                                <section class="subImp1">
                                    <label><%out.println(po.getProperty("etiqueta.DoclotDMa"));%></label><input type="text" id="numLot" disabled="true" style="width:10%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidoLotProvPEd"));%></label><input type="text" id="numLotProv" disabled="true" style="width:10%;"/>
                                </section>
                            </section>
                        </section>
                    </div>
                </section>
            </div>
        </div>

        <div id="VentanaModal" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retmc"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParam" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MovClaMov"));%></label><input type="text" id="ClaseMovi" maxlength="5" style="width:15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DocDocumentMaDMa"));%></label><input type="text" maxlength="12" id="DocMat" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="3" type="text"  id="numAcMax"  style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMC"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerrarMC2"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MovClaMov"));%></th><th><%out.println(po.getProperty("etiqueta.DocDocumentMaDMa"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th>
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
        <div id="Windowmsg" class="VentanaModalMensajes">
            <div id="handleMsg"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPInfom"));%></label><div class="BotonCerrar_Matc" id="CerrarVentanaMsg1"><label >X</label></div></div>
            <div class="imginfo"><IMG id="iocnomsgso" ALT="Info"></div>
            <div class="InfoMensaje"><label id="msgss"></label></div>
            <div class="okmsg">
                <input id="CloMsg" type="image" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>   
            </div>
        </div>
        <div id="VentanaModalIvent" class="VentanaModalIvent">
            <div id="handle22"><label id="TituloMatch">Reenvio de materiales Ivent</label></div>
            <div class="PanelBntMatch"><button>Materiales Pendientes</button><hr></div>
            <div id="ConsultaTabla">
                <div class="tablaCab">
                    <div class="table-scrolliv" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Material</th><th>Descripcion</th><th>Cantidad</th><th>Almacen</th><th>Mensaje</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatosiv">
                            <div class="nofixedX" id="cargarDatosWSE">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="otnren">
                    <button id="btnreenvi" style="margin-right:-4%; cursor: pointer;">Reenviar</button>
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
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>