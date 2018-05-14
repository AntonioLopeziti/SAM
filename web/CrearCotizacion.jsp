
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
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
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
                var pag = p.charAt(56);
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
        <link rel="stylesheet" href="css/StyleCotizacionesSD.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>     
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/CotizacionSDCrear.js"></script>  
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.CotizacionTituloCrear"));%></title>       
    <body>   
        <script>
            $(function () {
                $("#datapicker").datepicker({
                    dateFormat: 'dd.mm.yy',
                    firstDay: 0,
                    monthNames: ['<%=Enero%>', '<%=Febrero%>', '<%=Marzo%>', '<%=Abril%>', '<%=Mayo%>', '<%=Junio%>',
                        '<%=Julio%>', '<%=Agosto%>', '<%=Septiembre%>', '<%=Octubre%>', '<%=Noviembre%>', '<%=Diciembre%>'],
                    dayNames: ['<%=Domingo%>', '<%=Lunes%>', '<%=Martes%>', '<%=Miercoles%>', '<%=Jueves%>', '<%=Viernes%>', '<%=Sabado%>'],
                    dayNamesMin: ['<%=Do%>', '<%=lu%>', '<%=Ma%>', '<%=Mi%>', '<%=Ju%>', '<%=vi%>', '<%=sa%>'],
                    onSelect: function (date) {
                        var idda = $('#idDataFeee').val();
                        var fehSet = $('#' + idda);
                        fehSet.val(date);
                        fehSet.focus();
                        CerrarCalendario();
                    }
                });
            });
            $(function () {
                $('#datapicker').datepicker().hide();
            });

        </script>
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
<!--            <div class="DivContentCreaPedido">
                <div class="contain-cabecera">
                    <div class="divDer">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDPedido2"));%></label><input tye="text" id="oferta" style="width: 35%;" readonly/>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDSolicitante"));%></u></label><input tye="text" id="Solicitante" style="width: 35%;"/><button id="matchSolic" class='BtnMatchIcon'></button>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDDestMecia"));%></u></label><input tye="text" id="DestMcia" style="width: 35%;"/><button id="matchDestMerc" class='BtnMatchIcon'></button>
                        <hr>
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDNumPedClie"));%></u></label><input tye="text" id="PedCliente" style="width: 55%;"/>
                        <hr>

                    </div>
                    <div class="divIzq">
                        <label><%out.println(po.getProperty("etiqueta.PedidosSDValorNeto"));%></label><input tye="text"  style="width: 38%;" id="valorNeto"/> <input type="text" style="width: 12%;"  id="Moneda1"/><button id="matchMoDoc" class='BtnMatchIcon'></button>
                        <hr>
                        <input tye="text" readonly style="width: 100%; border: none; background: none; text-decoration: underline;" id="TextoInter1"/>
                        <hr style="border: #F2F2F2">
                        <input tye="text" disabled style="width: 100%; border: none; background: none; margin-top: 5px; text-decoration: underline;" id="TextoInter2"/>
                        <hr style="border: #F2F2F2">
                        <label><u><%out.println(po.getProperty("etiqueta.PedidosSDFechaPedido"));%></u></label><input tye="text"  style="width: 20%; margin-top: 5px;" id="fechpedido"/><button id="matchFechPedido" class='BtnMatchIcon'></button>
                        <hr>
                    </div>
                </div>
                <div class="contain-cabacera-detalle" id="contai">
                    <div class="btn1dinamic">
                        <input type="image" style="vertical-align:middle;cursor:pointer;" id="btnmostrar" src="images/cuadro.PNG"/>
                        <input type="image" style="vertical-align:middle;cursor:pointer; margin-left: -5px;" id="btnocultar" src="images/gris.PNG"/>
                    </div>

                    <div class="divCabeceradetalle" id="divDetailCab">
                        <div class="tabs">
                            <button  id="btnVent"><%out.println(po.getProperty("etiqueta.CotizacionOfertaVenta"));%></button>
                            <button  id="btntxts"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>                               
                        </div>
                        <section class="Cab122">
                            <div class="DivVents" id="DivVentas">
                                <label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.PedidosSDDetallesCab"));%></label>
                                <hr style="width: 100%; margin-left: 0; margin-top: 0;  border: 1px solid #3892E0">
                                <div class="DetalleCabIzq">
                                    <label><%out.println(po.getProperty("etiqueta.CotizacionClaseOferta"));%></label><input type="text" style="width: 12%;"  id="claseOferta"/><button id="matchClaseOferta" class='BtnMatchIcon'></button> <input type="text" id="DenomiacionOfer" style="width: 45%; border: none; background:none;" readonly   />
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDAreaVentas"));%></label><input type="text" style="width: 12%;" id="OrgVentas" /><button id="matchOrgVentas" class='BtnMatchIcon'></button>  / <input type="text" id="CanalDist" style="width: 10%;" /><button id="matchCnalDis" class='BtnMatchIcon'></button> / <input type="text" style="width: 10%;"  id="Sector"/><button id="matchSector" class='BtnMatchIcon'></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDOficinaVentas"));%></label><input type="text" style="width: 12%;"  id="OficinaVentas"/><button id="matchOficina" class='BtnMatchIcon'></button> <input type="text" style="width: 45%;  border: none; background: none" readonly id="DOficinaVentas"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDGrupoVendedo"));%></label><input type="text" style="width: 12%"  id="GpoVendedores"/><button id="matchGpoVend" class='BtnMatchIcon'></button> <input type="text" style="width: 45%; border: none; background: none;" readonly id="DGpoVendedores"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDMotivoPedido"));%></label><select style="width: 20%" ID="MotivoPed" /></select>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDMonedaDocs"));%></label><input type="text" style="width: 15%;"  id="Moneda2"><button id="matchMn2" class='BtnMatchIcon'></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaZonaVenta"));%></label><input type="text" style="width: 12%;"  id="Zonaventas"><button id="matchZonaVentas" class='BtnMatchIcon'></button> <input id="DenominacionZonaVentas" type="text" style="width: 45%; background: none; border: none;" readonly />
                                    <hr>
                                </div>
                                <div class="DetalleCabDer">
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDFechaDocumento"));%></label><input type="text" style="width: 15%;" id="fechaDocumento" /><button id="matchFecDoc" class='BtnMatchIcon'></button>
                                    <hr>
                                    <input type="text" style="width: 100%; background: none; border: none;" readonly id="AreVentas" />
                                    <hr style="border: #fff;">
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDCreadoPor"));%></label><input type="text" style="width: 15%;"  id="NombreResp" disabled value="<%=Nombre%>"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PedidosSDFechaPrecio"));%></label><input type="text" style="width: 15%;"  id="FechaPrecio"/><button id="matchFecgPreci" class='BtnMatchIcon'></button>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaListaPrec"));%></label><select type="text" style="width: 15%;"  id="LisPrecio"></select>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaGpoPrecio"));%></label><select type="text" style="width: 15%;"  id="GpoPrecio"/></select>
                                    <hr>
                                </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
                <div>
                    <div class="DivResPos2">
                        <label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.PedidosSDResuPosi"));%></label>
                        <hr style="width: 100%; margin-top:-1px;   border: 1px solid #3892E0">
                        <div class="DivResPosiciones" id="ContResPos">
                            <div class="DivRe1">
                                <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaValiD"));%></label><input type="text" style="width: 45%"  id="ValidoDe"/><button id="matchValidoDe" class='BtnMatchIcon'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PedidosSDFechPreEntr"));%></label><input type="text" style="width: 45%;"  id="fech_prefEnt"/><button id="matchPrefEnt" class='BtnMatchIcon'></button>
                                <hr>
                            </div>
                            <div class="DivRe2">
                                <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaValiA"));%></label><input type="text" style="width: 30%;" id="ValidoA" /><button id="matchValidoA" class='BtnMatchIcon'></button>
                                <hr>
                            </div>
                            <div class="DivResumenPos">
                                <div id="tabscrll2">
                                    <section id="TableNotfi2">
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
                                                        <tr><td>&nbsp</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
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
                        <button  id="btnCondi"><%out.println(po.getProperty("etiqueta.PedidosSDCondiciones"));%></button>                               
                        <button  id="btnRep"><%out.println(po.getProperty("etiqueta.PedidosSDRepartos"));%></button>                               
                        <button  id="btnEstatus"><%out.println(po.getProperty("etiqueta.PedidosSDEstatus"));%></button>                               
                        <button  id="btnTextos"><%out.println(po.getProperty("etiqueta.TextosPed"));%></button>                               
                    </div>
                    <div class="Contenidotabs">

                        <div class="DivExpedicion" id="ContExp">
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDCentro"));%></label><select  style="width: 8%;" id="Centro"></select> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenominacionCentro"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDProEntre"));%></label><select style="width: 8%;"  id="PrioridadEntrega"> </select> <input style="width: 50%; border: none; background: none;" readonly id="DenPrioEntrega"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDAlmacen"));%></label><input type="text" style="width: 8%;"  id="Almacen"/><button id="matchAlmacen" class='BtnMatchIcon'></button> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenAlma"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPtoExp"));%></label><input type="text" style="width: 8%;"  id="PtoExp"/><button id="matchptoExp" class='BtnMatchIcon'></button> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenPtoExp"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDRuta"));%></label><input type="text" style="width: 10%;"   id="Ruta"/><button id="matchRuta" class='BtnMatchIcon'></button> <input type="text" style="width: 50%; border: none; background: none;" readonly id="DenRuta"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPesoNeto"));%></label><input type="text" style="width: 12%"  id="PesosNeto"/> <input type="text" style="width: 5%;"  id="UnidadPeso"/><button id="matchUPeso" class='BtnMatchIcon'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDPesoBruto"));%></label><input type="text" style="width: 12%"  id="PesoBruto"/>
                            <hr>
                        </div>
                        <div class="DivCondiciones" id="ContCond">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondCtd"));%></label><input type="text" style="width: 15%;"  id="Catd1"/> <input type="text" style="width: 5%;"  id="UMv1"/><button id="matchmoncat" class='BtnMatchIcon'></button>
                            <hr style="width: 8%; margin-left: 0; margin-top: -1px;">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondNeto"));%></label><input type="text" style="width: 15%;"  id="Neto"/> <input type="text" style="width: 5%;"  id="mone"/><button id="matchNetoUM" class='BtnMatchIcon'></button>
                            <hr style="width: 8%; margin-left: 0; margin-top: -1px;">
                            <label style="width: 8%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PedidosSDCondImpues"));%></label><input type="text" style="width: 15%;"  id="importe"/>
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
                            <label style='width: 10%; margin-top: 12px; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepPlazoe"));%></label><select id="PlazEnt" style="width: 20%;"></select>
                            <hr style='width: 10%; margin-left: 0; margin-top: -1px;'>
                            <label  style='width: 10%; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepCtdPed"));%></label><input type='text' style='width: 15%;' id="CantPed" /> <input id="UMedi" type='text' style='width: 5%;' /><button id="matchMnUM" class='BtnMatchIcon'></button>
                            <hr style='width: 10%; margin-left: 0; margin-top: -1px;'>
                            <label  style='width: 10%; display: inline-block;'><%out.println(po.getProperty("etiqueta.PedidosSDRepCtdEnt"));%></label><input type='text' style='width: 15%;'  id="Cantentrg"/>
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
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatStatuGloeb"));%></label><input type='text' style="width: 20%;"  id="statusglobal"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatMotivo"));%></label><select  id="MotivoRech" style="width: 20%" ></select>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidosSDStatMotivoEn"));%></label><input type='text' style="width: 20%;"  id="statusEnt"/>
                            <hr>
                        </div>
                        <div id="divtxts"><textarea rows="18" cols="6"  style="resize:none; width: 98%; margin-top: 1%;" id="TextPosicion_SP"  readonly></textarea></div>
                    </div>
                </div>
            </div>-->
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input id="idDataFeee" hidden/>
            </div>
        </div>
        <div id="VentanaModalSolicitante" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></label><div class="BotonCerrar_Matc" id="CerraMCSol"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retSoli"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParSol" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></label><input type="text" id="BusSolic" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Nombre_pro"));%></label><input type="text" id="BusNomb" maxlength="4" style="width:35%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkSolic"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCSol2"/>
                </div>
            </div>            
            <div id="ConsultaTablaSolic" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSolic">
                        <div class="fixedY" id="fixedYSolic">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Nombre_pro"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSolic">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalDesMer" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CotizacionDestinMerca"));%></label><div class="BotonCerrar_Matc" id="CerraMCDesMcia"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retDesMcia"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParDesMcia" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionDestinMerca"));%></label><input type="text" id="BusDest" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax2"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkDesMcia"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCDesMcia2"/>
                </div>
            </div>            
            <div id="ConsultaTablaDestMcia" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDesMcia">
                        <div class="fixedY" id="fixedYDesMcia">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CotizacionDestinMerca"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDestMcia">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalMoneda" class="VentanaModal">
            <input type="text" id="iddtmon" hidden>
            <div id="handle3"><label id="TituloMatch">Moneda documento</label><div class="BotonCerrar_Matc" id="CerraMCMon"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retSoli"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaMoneda" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMone">
                        <div class="fixedY" id="fixedYMoneda">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Moneda</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSolic">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalClaseOferta" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CotizacionClaseOferta"));%></label><div class="BotonCerrar_Matc" id="CerraMCClaOf"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retClasOf"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParClasOf" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionClaseOferta"));%></label><input type="text" id="BusClaseof" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenomClase" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax3"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkClaOf"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCClaOf2"/>
                </div>
            </div>            
            <div id="ConsultaTablaClasOf" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClasOf">
                        <div class="fixedY" id="fixedYClasOf">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CotizacionClaseOferta"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClasOf">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalOrgVentas" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.matchorganizacion"));%></label><div class="BotonCerrar_Matc" id="CerraMCOrgVentas"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retOrgVen"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParOrgVentas" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.matchorganizacion"));%></label><input type="text" id="BusOrgVe" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenomOrgVen" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax4"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkOrgVentas"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCOrgVentas2"/>
                </div>
            </div>            
            <div id="ConsultaTablaOrgVen" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrgVentas">
                        <div class="fixedY" id="fixedYOrgVentas">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.matchorganizacion"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrgVentas">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalCanalDis" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.matchcanal"));%></label><div class="BotonCerrar_Matc" id="CerraMCCanalDist"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retCanalDis"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParCanalDist" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.matchcanal"));%></label><input type="text" id="BusCanalDis" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenomCanalDi" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax5"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkCanalDist"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCCanalDist2"/>
                </div>
            </div>            
            <div id="ConsultaTablaCanalDist" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCanalDist">
                        <div class="fixedY" id="fixedYCanalDist">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.matchcanal"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCanalDist">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalSector" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Sector_clie"));%></label><div class="BotonCerrar_Matc" id="CerraMCSector"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retSector"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParSector" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Sector_clie"));%></label><input type="text" id="BusSector" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenomSector" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax6"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkSector"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCSector2"/>
                </div>
            </div>            
            <div id="ConsultaTablaSector" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSector">
                        <div class="fixedY" id="fixedYSector">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Sector_clie"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSector">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalOficinaVentas" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CotizacionOficinaVent"));%></label><div class="BotonCerrar_Matc" id="CerraMCOVentas"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retOfVentas"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParOficinaVentas" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionOficinaVent"));%></label><input type="text" id="BusOVentas" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenOfVentas" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax7"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkOfVentas"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCOVentas2"/>
                </div>
            </div>            
            <div id="ConsultaTablaOficinaVentas" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOfVentas">
                        <div class="fixedY" id="fixedYOfVentas">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CotizacionOficinaVent"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOfVentas">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalGrupoVendedores" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CotizacionGrupoVended"));%></label><div class="BotonCerrar_Matc" id="CerraMCGpoVendedores"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retGpoVendedores"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParGpoVendedores" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionGrupoVended"));%></label><input type="text" id="BusGpoVendedores" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenGpoVendedores" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax8"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkGpoVendedores"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCGpoVendedores2"/>
                </div>
            </div>            
            <div id="ConsultaTablaGrpoV" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGpoV">
                        <div class="fixedY" id="fixedYGpoV">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CotizacionGrupoVended"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosGpoVendedores">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalZonaVentas" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CotizacionOfertaZonaVenta"));%></label><div class="BotonCerrar_Matc" id="CerraMCZonaVentas"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retZonaVentas"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParZonaVentas" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CotizacionOfertaZonaVenta"));%></label><input type="text" id="BusZonaVentas" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="BusDenZonaVentas" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax9"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkZonaVentas"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCZonaVentas"/>
                </div>
            </div>            
            <div id="ConsultaTablaZventas" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollZVent">
                        <div class="fixedY" id="fixedYZVent">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CotizacionOfertaZonaVenta"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosZonaVentas">
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
