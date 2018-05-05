
<%@page import="java.io.InputStream"%>
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
        String Valoerr = po.getProperty("etiqueta.NoExisteValores_SAM");
        String VacioData = po.getProperty("etiqueta.PedidosSDDocuemntVaci");
        String ErorPedi = po.getProperty("etiqueta.PedidosSDDocuError");
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
                    case 1:
                        msg = '<%=Valoerr%>';
                        break;
                    case 2:
                        msg = '<%=VacioData%>';
                        break;
                    case 3:
                        msg = '<%=ErorPedi%>';
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
        <link rel="stylesheet" href="css/StylePedidoSDVisualizar.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>     
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/PedidoSDVisualziar.js"></script>  
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.PedidosSDTituloVisua"));%></title>       
    <body>   
        <div id="main-header">    
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" style="cursor: pointer;" src="images/aceptar.png"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled/> 
            <input  id="regresar" type="image" style="cursor: pointer;" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;"  src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.PedidosSDTituloVisua"));%></h1></div> 
        </div>            
        <div class="contenido"> 
            <div class="DivContentVisPedSD">
                <div class="parambus">
                    <div class="DivBusquedaPeSD">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDParamBusque"));%></label>
                        <hr id="lineaTitulo">
                        <div class="divPed">
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPedido"));%></label><input type="text" style="width: 25%; text-transform: uppercase;" id="txtPedido" maxlength="10" /><button id="MCPedidos" class='BtnMatchIcon'></button>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="contain-cabecera">
                    <div class="divDer">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDPedido2"));%></label><input tye="text" id="Pedido" style="width: 30%;" disabled/> <input tye="text" id="FolioSAM" style="width: 30%;" disabled/>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDSolicitante"));%></u></label><input tye="text" id="Solicitante" style="width: 35%;" disabled/>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDDestMecia"));%></u></label><input tye="text" id="DestMcia" style="width: 35%;" disabled/>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDNumPedClie"));%></u></label><input tye="text" id="PedCliente" style="width: 55%;" disabled/>
                        <hr>

                    </div>
                    <div class="divIzq">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDValorNeto"));%></label><input tye="text" disabled style="width: 38%;" id="valorNeto"/> <input type="text" style="width: 12%;" disabled id="Moneda1"/>
                        <hr>
                        <input tye="text" readonly style="width: 100%; border: none; background: none; text-decoration: underline;" id="TextoInter1"/>
                        <hr style="border: #F2F2F2">
                        <input tye="text" disabled style="width: 100%; border: none; background: none; margin-top: 5px; text-decoration: underline;" id="TextoInter2"/>
                        <hr style="border: #F2F2F2">
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDFechaPedido"));%></u></label><input tye="text" disabled style="width: 20%; margin-top: 5px;" id="fechpedido"/>
                        <hr>
                    </div>
                </div>
                <div class="contain-cabacera-detalle" id="contai">
                    <div class="btn1dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrar" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnocultar" src="images/gris.PNG"/>
                    </div>
                    <div class="divCabeceradetalle" id="divDetailCab">
                        <div class="tabs">
                            <button  id="btnVent"><%out.println(po.getProperty("etiqueta.CotizacionOfertaVenta"));%></button>
                            <button  id="btntxts"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>                               
                        </div>
                        <section class="Cab133">
                            <div class="DivVents" id="DivVentas">
                                <label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.PedidosSDDetallesCab"));%></label>
                                <hr style="width: 100%; margin-top:-1px;   border: 1px solid #3892E0">
                                <div class="contad">
                                    <div class="DetalleCabIzq">
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDClasePedido"));%></label><input type="text" style="width: 15%;" disabled id="clasePedido"/> <input type="text" style="width: 49%; border: none; background:none;" readonly   />
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDAreaVentas"));%></label><input type="text" style="width: 15%;" id="OrgVentas" disabled/>  / <input type="text" id="CanalDist" style="width: 10%;" disabled/> / <input type="text" style="width: 10%;" disabled id="Sector"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDOficinaVentas"));%></label><input type="text" style="width: 15%;" disabled id="OficinaVentas"/> <input type="text" style="width: 49%;  border: none; background: none" readonly id="DOficinaVentas"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDGrupoVendedo"));%></label><input type="text" style="width: 12%" disabled id="GpoVendedores"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DGpoVendedores"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDMotivoPedido"));%></label><select style="width: 50%" ID="MotivoPed" disabled ><option id="opcion1"></option></select>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDMonedaDocs"));%></label><input type="text" style="width: 15%;" disabled id="Moneda2">
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaZonaVenta"));%></label><input type="text" style="width: 12%;" disabled id="Zonaventas"> <input type="text" style="width: 45%; background: none; border: none;" readonly />
                                        <hr>
                                    </div>
                                    <div class="DetalleCabDer">
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDFechaDocumento"));%></label><input type="text" style="width: 15%;" id="fechaDocumento" disabled/>
                                        <hr>
                                        <input type="text" style="width: 100%; background: none; border: none;" readonly id="AreVentas" />
                                        <hr style="border: #fff;">
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDCreadoPor"));%></label><input type="text" style="width: 15%;" disabled id="NombreResp"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.PedidosSDFechaPrecio"));%></label><input type="text" style="width: 15%;" disabled id="FechaPrecio"/> 
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaListaPrec"));%></label><input type="text" style="width: 15%;" disabled id="LisPrecio">
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaGpoPrecio"));%></label><input type="text" style="width: 15%;" disabled id="GpoPrecio"/> 
                                        <hr>
                                    </div>
                                </div>
                                <div class="DivTablaCli">
                                    <div id="tabscrll">
                                        <section id="TableNotfi" >
                                            <section class="TableContainer">
                                                <section class="SecHead">
                                                    <table id="TabHead">
                                                        <thead>
                                                            <tr>
                                                                <td>&nbsp;&nbsp;&nbsp;</td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDFuncionInter"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDInterlocutor"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDNombre"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDCalle"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDCodigoPostal"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDPoblacion"));%></td>
                                                                <td><%out.println(po.getProperty("etiqueta.PedidosSDDefInterlo"));%></td>
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
                                                            <tr class="ocultar"><td>00</td><td>00000000000000</td><td>0000000000000000</td><td>000000000000000000000</td><td>00000000000000000000000000000</td><td>000000000000000</td><td>000000000000000</td><td>000000000000000</td></tr>
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
                            <div class="DiTtx" id="textosCabecera">
                                <label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.CotizacionOferttxtCab"));%></label>
                                <hr style="width: 100%; margin-top:-1px;   border: 1px solid #3892E0">
                                <textarea rows="18" cols="6"  style="resize:none; width: 97%; height: 100%; margin-top: 1%; border: 1px solid #007CC0; margin-left: 1%;" id="TextCabece"  disabled></textarea></div>
                        </section>
                    </div>
                </div>
                <div>
                    <div class="DivResPos2">
                        <label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.PedidosSDResuPosi"));%></label>
                        <hr style="width: 100%; margin-top:-1px;   border: 1px solid #3892E0">
                        <div class="DivResPosiciones" id="ContResPos">
                            <label style="width: 15%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDFechPreEntr"));%></label> <input type="text" style="width: 10%;" disabled id="fech_prefEnt"/>
                            <hr style="width: 15%; margin-top: -1px; margin-left: 0;">
                            <div class="DivResumenPos">
                                <div id="tabscrll2">
                                    <section id="TableNotfi2" >
                                        <section class="TableContainer2">
                                            <section class="SecHead2">
                                                <table id="TabHead2">
                                                    <thead>
                                                        <tr>
                                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDPosicion"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDMaterial"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDCantidPedi"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDUM"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDR"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDDemonmacion"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDNMaterialClien"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDTPos"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDPIndMciaPelig"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDPosSup"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDTipoFechaEntrega"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.PedidosSDFechaReparto"));%></td>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </section>
                                            <section class="SecBody2" id="SecCuerpo2">
                                                <table id="TabBody2">
                                                    <tbody>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        <tr class="ocultar"><td>00</td><td>000000</td><td>00000000000</td><td>00000000000000</td><td>0000</td><td>000</td><td>00000000000000000000</td><td>0000000000000000000000</td><td>0000000</td><td>0000000000000</td><td>00000000</td><td>00000000000000000</td><td>00000000000000</td></tr>
                                                    </tbody>
                                                </table>
                                            </section>
                                        </section>
                                    </section>
                                </div>
                                <section class="DobleScroll2" id="DobleSection2">
                                    <section id="DobleContainer2"></section>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="DivPos">
                    <label style="display: inline-block; width: 5%;"><%out.println(po.getProperty("etiqueta.PedidosSDPosicion"));%></label><input type="text" style="background: none; border: none; width: 15% ;" readonly id="posci" />
                    <hr style="width: 5%; margin-top:-1px; margin-left: 0;">
                    <div class="tabs">
                        <button  id="btnExped"><%out.println(po.getProperty("etiqueta.PedidosSDExpedicion"));%></button>
                        <button  id="btnCondi" hidden><%out.println(po.getProperty("etiqueta.PedidosSDCondiciones"));%></button>                               
                        <button  id="btnRep"><%out.println(po.getProperty("etiqueta.PedidosSDRepartos"));%></button>                               
                        <button  id="btnEstatus"><%out.println(po.getProperty("etiqueta.PedidosSDEstatus"));%></button>  
                        <button  id="btnTextos"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>   
                    </div>
                    <div class="Contenidotabs">

                        <div class="DivExpedicion" id="ContExp">
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDCentro"));%></label><input type="text"  style="width: 8%;" disabled id="Centro"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenominacionCentro"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDProEntre"));%></label><input type="text" style="width: 3%;" disabled id="PrioridadEntrega"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenPrioEntrega"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDAlmacen"));%></label><input type="text" style="width: 8%;" disabled id="Almacen"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenAlma"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPtoExp"));%></label><input type="text" style="width: 8%;" disabled id="PtoExp"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenPtoExp"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDRuta"));%></label><input type="text" style="width: 10%;"  disabled id="Ruta"/> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenRuta"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPesoNeto"));%></label><input type="text" style="width: 12%" disabled id="PesosNeto"/> <input type="text" style="width: 5%;" disabled id="UnidadPeso"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPesoBruto"));%></label><input type="text" style="width: 12%" disabled id="PesoBruto"/>
                            <hr>
                        </div>
                        <div class="DivCondiciones" id="ContCond">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondCtd"));%></label><input type="text" style="width: 15%;" disabled id="Catd1"/> <input type="text" style="width: 5%;" disabled id="UMv1"/>
                            <hr style="width: 8%; margin-left: 0; margin-top: -1px;">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondNeto"));%></label><input type="text" style="width: 15%;" disabled id="Neto"/> <input type="text" style="width: 5%;" disabled id="mone"/>
                            <hr style="width: 8%; margin-left: 0; margin-top: -1px;">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondImpues"));%></label><input type="text" style="width: 15%;" disabled id="importe"/>
                            <hr style="width: 8%; margin-left: 0; margin-top: -1px;">
                            <br>
                            <div id="tabscrll3">
                                <section id="TableNotfi3" >
                                    <section class="TableContainer3">
                                        <section class="SecHead3">
                                            <table id="TabHead3">
                                                <thead>
                                                    <tr>
                                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondInact"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondClCd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDDemonmacion"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondImporte"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondMon"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondPor"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDUM"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDValorCond"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondMon"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDConco"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondUMB"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondDeCoCo"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDUM"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDValorCond"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondMonCd"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDCondEst"));%></td>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </section>
                                        <section class="SecBody3" id="SecCuerpo3">
                                            <table id="TabBody3">
                                                <tbody>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr class="ocultar"><td>00</td><td>000000</td><td>000000</td><td>0000000000000</td><td>00000000</td><td>00000</td><td>00000</td><td>00000</td><td>00000000000000</td><td>0000000</td><td>000000000</td><td>00000000</td><td>00000000</td><td>000000</td><td>00000000000000</td><td>0000000</td><td>000000</td></tr>
                                                </tbody>
                                            </table>
                                        </section>
                                    </section>
                                </section> 
                            </div>
                            <section class="DobleScroll3" id="DobleSection3">
                                <section id="DobleContainer3"></section>
                            </section>
                        </div>
                        <div class="DivRepartos" id="ContRep">
                            <input type='checkbox' disabled/><label><%out.println(po.getProperty("etiqueta.PedidosSDRepFechCa"));%></label><br>
                            <label style='width: 10%; margin-top: 12px; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepPlazoe"));%></label><input type="text" id="PlazEnt" style="width: 20%;" disabled/>
                            <hr style='width: 10%; margin-left: 0; margin-top: -1px;'>
                            <label  style='width: 10%; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepCtdPed"));%></label><input type='text' style='width: 15%;' id="CantPed" disabled/> <input id="UMedi" type='text' style='width: 5%;' disabled/>
                            <hr style='width: 10%; margin-left: 0; margin-top: -1px;'>
                            <label  style='width: 10%; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepCtdEnt"));%></label><input type='text' style='width: 15%;' disabled id="Cantentrg"/>
                            <hr style='width: 10%; margin-left: 0; margin-top: -1px;'>
                            <br>
                            <div id="tabscrll4">
                                <section id="TableNotfi4" >
                                    <section class="TableContainer4">
                                        <section class="SecHead4">
                                            <table id="TabHead4">
                                                <thead>
                                                    <tr>
                                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepPeriodo"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepFecEntr"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepCanPed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepCanRed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepCanCon"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepUMV"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepBloEn"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepCantEn"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepTpoRep"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepSolPed"));%></td>
                                                        <td><%out.println(po.getProperty("etiqueta.PedidosSDRepSolpedPs"));%></td>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </section>
                                        <section class="SecBody4" id="SecCuerpo4">
                                            <table id="TabBody4">
                                                <tbody>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                    <tr class="ocultar"><td>00</td><td>0000000000000</td><td>000000000000000</td><td>0000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td></tr>
                                                </tbody>
                                            </table>
                                        </section>
                                    </section>
                                </section>
                            </div>
                            <section class="DobleScroll4" id="DobleSection4">
                                <section id="DobleContainer4"></section>
                            </section>
                        </div>
                        <div class="DivEstatus" id="ContSta">
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatStatuGloeb"));%></label><input type='text' style="width: 20%;" disabled id="statusglobal"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatMotivo"));%></label><select id="MotivoRech" style="width: 20%" disabled><option id="opcion2"></option></select>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatMotivoEn"));%></label><input type='text' style="width: 20%;" disabled id="statusEnt"/>
                            <hr>
                        </div>
                        <div id="divtxts"><textarea rows="18" cols="6"  style="resize:none; width: 98%; margin-top: 1%;" id="TextPosicion_SP"  readonly></textarea></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPedidosSD" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PedidosSDDocumVe"));%></label><div class="BotonCerrar_Matc" id="CerraMCPed"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retPed"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParPedSD" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDDocu"));%></label><input type="text" id="DocumVenta" maxlength="12" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label>Folio SAM</label><input type="text" id="FSAM" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDClasePedido"));%></label><input type="text" id="ClasePedid" maxlength="4" style="width:35%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPedido"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCPed2"/>
                </div>
            </div>            
            <div id="ConsultaTablaPedidos" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollpedido">
                        <div class="fixedY" id="fixedYPedidoSd">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.PedidosSDClasePedido"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.PedidosSDDocu"));%></th>
                                        <th>Folio SAM</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosPedidos">
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
