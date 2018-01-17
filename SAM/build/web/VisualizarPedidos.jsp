<%-- 
    Document   : VisualizarPedidos
    Created on : 20-ago-2016, 17:39:09
--%>


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
        String reso = po.getProperty("etiqueta.Resolucio");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String existFol = po.getProperty("etiquestaPedidoNovaPed");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
        String creaby = po.getProperty("etiqueta.PedidoCreatPRPED");
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
                var pag = p.charAt(32);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            var crid = '<%=creaby%>';
            checkPermisoPag();
            function ShowMsg(m, im, au, ped, us) {
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
                        $('#createdby').html(ped + " " + crid + " " + us);
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
            function Select(ped) {
                $('#pedido').val(ped);
                ocultarVentana();

            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StylePedidos.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/PedidosEstandar.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.PedidosEstandarPED"));%></title>       
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
            <div class="titulo"><span><h1><%out.println(po.getProperty("etiqueta.PedidosEstandarPED"));%> <label id="createdby" style="font-size: 1em;"> </label></h1></span></div>      
        </div>        
        <div class="contenido">
            <div class="ContentPedidos">
                <div class="divcat1">
                    <div class="subdivcat1">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="carrito" src="images/carrito.PNG"/>
                        <select style="width: 40%;" disabled id="selepe">
                            <option id="tipodoc"></option>
                        </select>
                        <input type="text" maxlength="10" style="width: 25%; text-transform: uppercase;" id="pedido"/><button id="match_C2" class='BtnMatchIcon'></button>
                    </div>
                    <div class="subdivcat2">
                        <label><%out.println(po.getProperty("etiqueta.PedidosProveedor"));%></label><input type="text" style="width: 50%;" disabled id="proveedor">
                        <hr>                                
                    </div>
                    <div class="subdivcat3">
                        <label><%out.println(po.getProperty("etiqueta.PedidoFechadocPED"));%></label><input type="text" maxlength="10" style="width: 40%;" id="fechadoc" disabled>
                        <hr>      
                    </div>
                </div>
                <div class="botton1Ped">
                    <div class="btn1dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrar" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultar" src="images/gris.PNG"/>
                    </div>
                    <div id="Cabecera" class="div1">                             
                        <div class="tabsdiv1">
                            <button  id="btnText"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>
                            <button  id="btnDatOrg"><%out.println(po.getProperty("etiqueta.dtoOrgPed"));%></button>                               
                            <button  id="btnEstLib"><%out.println(po.getProperty("etiqueta.EstraLib"));%></button>                               
                        </div>
                        <hr id="lineatabsPedido">
                        <div class="sections">
                            <section id="divcon">
                                <div class="divcabec">
                                    <label><%out.println(po.getProperty("etiqueta.CabeceratextPed"));%></label>
                                </div>
                                <div id="divdentro" class="divdentro">
                                    <textarea rows="4" cols="6" class="texttar" id="TextCabecera" maxlength="130" disabled></textarea>
                                </div>   
                            </section>
                            <section id="TabDatOrg" class="TabDatOrg">
                                <label><%out.println(po.getProperty("etiqueta.OrgCompraPED"));%></label><input type="text" id="txtOrgCompras" disabled><input type="text" id="DOrgCompPED" class="DescdatO" style="width: 30%;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.GrupoCompPed"));%></label><input type="text" id="txtGrupoCompras" disabled><input type="text" id="DGpoCompr" class="DescdatO" style="width: 30%;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.SocuedadPED"));%></label><input type="text" id="txtSociedad" disabled><input type="text" id="DScoeidad" class="DescdatO" style="width: 30%;" disabled/>
                                <hr>
                            </section>
                            <section id="TabLiberacio" class="TabDataliberac">
                                <div class="sublib">
                                    <label><%out.println(po.getProperty("etiqueta.PedidosGrupoLib"));%></label><input type="text" id="txtgrupoLib" style="width: 8%;" disabled><input type="text" id="DtxtgrupoLib"  class="DescdatO2" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosEstrLib"));%></label><input type="text" id="txtEstrategiaLib" style="width: 8%;" disabled><input type="text" id="DtxtindLiberaci"  class="DescdatO2"  disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosIndLib"));%></label><input type="text" id="txtindLiberaci" style="width: 5%;" disabled><input type="text" id="DtxtindLiberaci"  class="DescdatO2"  disabled/>
                                    <hr>
                                    <button id="botnchanglib"></button>
                                </div>
                                <div class="sublib">
                                    <div class="DatosLibestau"></div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="botton2Ped">
                    <div class="btn2dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrarDiv2" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultarDiv2" src="images/gris.PNG"/>
                    </div>
                    <div class="ventanitatabla" id="div2">
                        <div id="tabscrll">
                            <section id="TableNotfi" >
                                <section class="TableContainer">
                                    <section class="SecHead">
                                        <table id="TabHead">
                                            <thead>
                                                <tr>
                                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                                    <td>E</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoPosic"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoImpu"));%></td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoPos"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoMat"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.Pedidotxt"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoCanPed"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoUMPPED"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoFecEn"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoCentro"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoAlmacen"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoLote"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoSolici"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoRegInfo"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoNumNec"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoSolPe"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoPosSol"));%>&nbsp;</td>
                                                    <td><%out.println(po.getProperty("etiqueta.PedidoContmar"));%>&nbsp;</td>
                                                </tr>
                                            </thead>
                                        </table>
                                    </section>
                                    <section class="SecBody" id="SecCuerpo">
                                        <table id="TabBody">
                                            <tbody>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                <tr class="ocultar"><td>00</td><td>00</td><td>00000000000</td><td>0000000</td><td>0000000</td><td>000000000000</td><td>0000000000000000000000000000000000</td><td>0000000000000</td><td>000000000000</td><td>00000000000000</td><td>0000000000</td><td>0000000000000</td><td>0000000000</td><td>000000000000</td><td>00000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000000</td></tr>
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
                <div class="btn3pedi">
                    <div class="btn3dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrarDiv3" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultarDiv3" src="images/gris.PNG"/>
                    </div>
                    <div class="divposicpedi" id="div3">
                        <div class="selectpos">
                            <label><%out.println(po.getProperty("etiqueta.PedidoPosicion"));%></label><select id="pospedidos"><option></option></select>
                            <hr>  
                        </div>
                        <div class="Tabdivpsocione">
                            <button  id="btnServices"><%out.println(po.getProperty("etiqueta.PedidoServPed"));%></button>
                            <button  id="btnDatosMaters"><%out.println(po.getProperty("etiqueta.PedidoDatoMatEPe"));%></button>
                            <button  id="btnhistori"><%out.println(po.getProperty("etiqueta.PedidoHistPe"));%></button>
                            <button  id="btntxtmatp"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>
                            <button  id="btnimputacion"><%out.println(po.getProperty("etiqueta.PedidoImput"));%></button>
                            <hr id="lineatabs2">
                        </div>
                        <div class="divContenidoPso" id="DivServic">
                            <div class="Tab1Pos">
                                <section id="TableNotfi3" >
                                    <section class="TableContainer3">
                                        <section class="SecHead3">
                                            <table id="TabHead3">
                                                <thead>
                                                    <tr>
                                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoLineaPed"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoIndBorraPed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoNServPed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCanEPD"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoUM"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoPrecBruPed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoMonPedi"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoTolerexcsumin"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoSobreCumplIlPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoFrafPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoAmbitServ"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoSaliPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoPosCatSrStPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoNOServExt"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValoNetoPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCantReaPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidotxtserPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidotxtlinPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoFomulPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValFomuPEd1"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValFomuPEd2"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValFomuPEd3"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValFomuPEd4"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoValFomuPEd5"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCampUsuarPed1"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCampUsuarPed2"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCampUsuarPed3"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCampUsuarPed4"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoIDLínePEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoGrupoSCPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCCPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoNumLinePEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCLINPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoAltPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoLineliciPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoLinesiplPEd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidiotamlotcPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoExterIPED"));%></td>  
                                                    </tr>
                                                </thead>
                                            </table>
                                        </section>
                                        <section class="SecBody3" id="SecCuerpo3">
                                            <table id="TabBody3">
                                                <tbody>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                    <tr class="ocultar">
                                                        <td>00</td>
                                                        <td>00000000000</td>
                                                        <td>00000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>00000000000000000000000000000000000000000000000000000000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>0000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>0000000000000</td>
                                                        <td>0000000000000</td>
                                                        <td>0000000000000</td>
                                                        <td>0000000000000</td>
                                                        <td>0000000000000000</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </section>
                                    </section>
                                </section>
                                <!--                                <div class="tablaSolicitudSer">
                                                                    <section id="SecTab">                                     
                                                                        <table class="TablaCont" id="table12">
                                                                            <thead>
                                                                                <tr id="CabeceraTabla">
                                                                                    <td></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.LineaPed"));%></td>                                                            
                                                                                    <td><%out.println(po.getProperty("etiqueta.IndBorraPed"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.NServPed"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.TxtBPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CantidadBOM"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.UMBOM"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.PrecBruPed"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.MonPedi"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.Tolerexcsumin"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.SobreCumplIlPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.OrdPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.FrafPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.AmbitServ"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.SaliPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.PosCatSrStPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.NOServExt"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValoNetoPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CantReaPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.txtserPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.txtlinPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.FomulPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValFomuPEd1"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValFomuPEd2"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValFomuPEd3"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValFomuPEd4"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ValFomuPEd5"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CampUsuarPed1"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CampUsuarPed2"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CampUsuarPed3"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CampUsuarPed4"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.IDLínePEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.GrupoSCPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CCPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.NumLinePEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.CLINPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.AltPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.LineliciPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.LinesiplPEd"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.tamlotcPED"));%></td>
                                                                                    <td><%out.println(po.getProperty("etiqueta.ExterIPED"));%></td>                                                  
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody id="ServiciosPedidos">
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td><input class="chkcenter"  disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td></td><td></td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td><input class="chkcenter" disabled type="checkbox"/></td><td>&nbsp;</td></tr>
                                
                                                                            </tbody>
                                                                        </table>
                                                                    </section>
                                                                </div>-->
                            </div> 
                        </div>
                        <div class="Tab2Pos" id="Tab2DatosMate">
                            <div class="subtabmat1">
                                <label><%out.println(po.getProperty("etiqueta.PedidoGpArticuPED"));%></label><input type="text" id="GpoArtic" style="width: 25%;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoNuMatProPEd"));%></label><input type="text" id="NumMatpro" style="width: 55%;" disabled/>
                                <hr>
                            </div>
                            <div class="subtabmat2">
                                <label><%out.println(po.getProperty("etiqueta.PedidoCódigoEANUPED"));%></label><input type="text" id="CodigoE" style="width:40%;" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoLotProvPEd"));%></label><input type="text" id="Lotepro" style="width: 35%" disabled/>
                                <hr>
                            </div>
                        </div>
                        <div class="Tab3Pos" id="Tab3HisPed">
                                <section id="TableNotfi2" >
                                    <section class="TableContainer2">
                                        <section class="SecHead2">
                                            <table id="TabHead2">
                                                <thead>
                                                    <tr>
                                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.Pedidotxt"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoClMovPEd"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoMateDoc"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoPosDocMatPEd"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoFeContaPED"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCanEPD"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCtdCosteInEPD"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoUPMped"));%>&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoImporteMLPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoMLPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCantdUMPPPD"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoCTDCIUMPPED"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoUMPpreciped"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoImprtEDP"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoMonPedi"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidoReferePED"));%></td>    
                                                    </tr>
                                                </thead>
                                            </table>
                                        </section>
                                        <section class="SecBody2" id="SecCuerpo2">
                                            <table id="TabBody2">
                                                <tbody>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td></td><td></td><td>&nbsp;</td><td></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr class="ocultar">
                                                        <td>00</td>
                                                        <td>000000000000000000000000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>000000000000000000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>0000000000000000000000000</td>
                                                        <td>0000000000000000000000000</td>
                                                        <td>00000000000000000000</td>
                                                        <td>000000000000000000000000000000000000000000</td>
                                                        <td>00000000000000000</td>
                                                        <td>0000000000000000000</td>
                                                        <td>000000000000000</td>
                                                        <td>000000000000000000000000</td>
                                                        <td>00000000000000000000000000000000000000000</td>
                                                        <td>0000000000000000000</td>
                                                        <td>00000000000000000000</td>
                                                        <td>000000000000000000000</td>
                                                        <td>0000000000000000</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </section>
                                    </section>
                                </section>
                        </div>
                        <div class="Tab4Pos" id="Tab4Textos">
                            <div class="divtabtextped">
                                <label><%out.println(po.getProperty("etiqueta.PedidoTextoPosPd"));%></label>
                            </div>
                            <div class="divtabtxtped2">
                                <textarea rows="4" cols="6" class="texttar" id="TextPosici" maxlength="130" disabled></textarea>
                            </div>
                        </div>
                        <div class="Tab5Pos" id="Tab5Imputacion">
                            <div class="subtabmat1">
                                <label><%out.println(po.getProperty("etiqueta.PedidoTipoimp"));%></label><input type="text" id="tipoimputa" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoCtaMay"));%></label><input type="text" id="ctamayor" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoSocCO"));%></label><input type="text" id="socie" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></label><input type="text" id="ordenor" disabled/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidoCCoste"));%></label><input type="text" id="centrocos" disabled/>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="VentanaModal" class="VentanaModal">
        <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana();"><label >X</label></div></div>
        <div class="PanelBntMatch"><button id="retornpedidmat"><%out.println(po.getProperty("etiqueta.PedidosEstandarPED"));%></button><hr></div>
        <div id="BuscarParam_fo" class="BuscarParam_u">
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.PedidosEstandarPED"));%></label><input type="text" id="pedidBus" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                    <hr>                        
                    <label><%out.println(po.getProperty("etiqueta.PedidoSolPe"));%></label><input type="text" id="SolpedBus"  maxlength="10" style="width:35%; text-transform: uppercase;"/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.PedidoSolPe"));%> SAM</label><input type="text" id="SolpedSAM" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax"  style="width:10%;" maxlength="3"/>
                    <hr>
                </div>        
            </div> 
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPedidos"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana();"/>
            </div>
        </div>
        <div id="ConsultaTabla" style="display: none;">
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll">
                    <div class="fixedY" id="fixedY">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.PedidosEstandarPED"));%></th><th><%out.println(po.getProperty("etiqueta.PedidoSolPe"));%></th><th><%out.println(po.getProperty("etiqueta.PedidoSolPe"));%> SAM</th>
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