<%-- 
 Document   : Movimiento Materiales
--%>


<%@page import="Clases.ClassModuloCrearOrden"%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
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

        String Folio = request.getParameter("FolioMO");
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String movim = po.getProperty("etiqueta.TituMovv_Mov");
        String movim101 = po.getProperty("etiqueta.TituMovv101_Mov");
        String movim102 = po.getProperty("etiqueta.TituMovv102_Mov");
        String E1 = po.getProperty("etiqueta.ErroSonMov_Mov");
        String E2 = po.getProperty("etiqueta.NumPedObl_Mov");
        String E3 = po.getProperty("etiqueta.ErroN3_Mov");
        String E4 = po.getProperty("etiqueta.ErroN4_Mov");
        String E5 = po.getProperty("etiqueta.ErroN5_Mov");
        String E6 = po.getProperty("etiqueta.ErroN6_Mov");
        String E7 = po.getProperty("etiqueta.ErroN7_Mov");
        String E8 = po.getProperty("etiqueta.ErroN8_Mov");
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
        ClassModuloCrearOrden html = new ClassModuloCrearOrden();
        String htmlResponse;
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
                var pag = p.charAt(38);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            var usuario = '<%=Nombre%>';
            var idioma = '<%=Idioma%>';
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/styleMovMaterial.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/MovMateriales.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><% out.println(po.getProperty("etiqueta.Mov_title"));%></title>
    </head>
    <body>
        <script>
            $(function () {
                var fehSet = document.getElementById('bxFecha');
                $("#datapicker").datepicker({
                    dateFormat: 'dd.mm.yy',
                    firstDay: 0,
                    monthNames: ['<%=Enero%>', '<%=Febrero%>', '<%=Marzo%>', '<%=Abril%>', '<%=Mayo%>', '<%=Junio%>',
                        '<%=Julio%>', '<%=Agosto%>', '<%=Septiembre%>', '<%=Octubre%>', '<%=Noviembre%>', '<%=Diciembre%>'],
                    dayNames: ['<%=Domingo%>', '<%=Lunes%>', '<%=Martes%>', '<%=Miercoles%>', '<%=Jueves%>', '<%=Viernes%>', '<%=Sabado%>'],
                    dayNamesMin: ['<%=Do%>', '<%=lu%>', '<%=Ma%>', '<%=Mi%>', '<%=Ju%>', '<%=vi%>', '<%=sa%>'],
                    onSelect: function (date) {
                        fehSet.value = date;
                        fehSet.focus();
                        CerrarCalendario();
                    }
                });
            });
            $(function () {
                $('#datapicker').datepicker().hide();
            });
        </script>
        <div id="divresr" ></div><input type="text" id="txtrsv" hidden/>
        <div id="tmpCabeceraDef" hidden>
            <table id="TablaTmpDefCab"></table>
            <table id="TablaTmpDefPos"></table>
            <table id="TablaTmpDefTxt"></table>
        </div>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inv();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input id="guardar" type="image" src="images/guarda.PNG" />
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back()"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="window.location.href = 'MovimientoMateriales.jsp'"/>
            <div class="titulo"><h1><% out.println(po.getProperty("etiqueta.Mov_title")); %></h1></div>
        </div>
        <div class="contenido">                      
            <div class="ContenidoScrollbar">
                <div class="bkcontainer">
                    <div class="bkn1">
                        <label><% out.println(po.getProperty("etiqueta.MovParameEj")); %></label>
                        <hr class="lnMov">

                        <div class="bknn1">
                            <label><% out.println(po.getProperty("etiqueta.GralCentroAll")); %></label>
                            <input type="text" class="bxsmall" id="bxCentro" style="text-transform: uppercase;" maxlength='4'/>
                            <button id="btnCentro" class='BtnMatchIcon'></button>
                            <hr>
                            <label><% out.println(po.getProperty("etiqueta.MovAlmac")); %></label>
                            <input type="text" class="bxsmall" id="bxAlmacen" style="text-transform: uppercase;" maxlength='4'/>
                            <button id="btnAlmacen" class='BtnMatchIcon'></button><br>
                            <button class="btnImgreserva" id="btnAdd" type="submit"><% out.println(po.getProperty("etiqueta.MovAgregPo")); %></button>
                        </div>
                        <div class="bknn2">
                            <label><% out.println(po.getProperty("etiqueta.MovFechCont")); %></label>
                            <input type="text" class="bxmiddle" id="bxFecha" readOnly >
                            <button id="btnfechaD" class='BtnMatchIcon'></button>
                            <br>
                            <label><% out.println(po.getProperty("etiqueta.MovClaMov")); %></label>
                            <input type="text" class="bxmiddles"  id="bxClase" maxlength="3"/>
                            <button id="btnClase" class='BtnMatchIcon'></button><br>
                            <button class="btnImgreserva" id="btnReserva" type="submit"><% out.println(po.getProperty("etiqueta.MovTratRes")); %></button>
                            <input type="text" id="bxReserva" maxlength="12" style="text-transform: uppercase;">
                            <button id="btnMacthreserv" class='BtnMatchIcon'></button><br>
                        </div>
                        <div class="bknn3">
                            <label><% out.println(po.getProperty("etiqueta.MovTextMov")); %></label>
                            <input type="text" class="bxlong" id="bxTexto"  maxlength="40">
                            <hr>
                            <label><% out.println(po.getProperty("etiqueta.MovNotaEntr")); %></label>
                            <input type="text" class="bxlongs" id="bxNota" maxlength="16"><br>
                            <label><% out.println(po.getProperty("etiqueta.MovCrtPort")); %></label>
                            <input type="text" class="bxlongs" id="bxCarta" maxlength="16">
                        </div>
                    </div>
                    <section id="TablaStatus" class="TablaStatusC">
                        <section id="SecTabPpal">
                            <table class="TablaCont" id="TablaMov">
                                <tr id="CabeceraTabla">
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td><% out.println(po.getProperty("etiqueta.Tmaterial_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.Tcantidad_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TUM_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.Tlote_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TstockEspecial_MOM")); %></td>
                                    <td class="ajustar"><% out.println(po.getProperty("etiqueta.Ttextobreve_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.Torden_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TCentroDeCostos_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TclasCost_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TPedido_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TPosPed_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.Treserva_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TPosRes_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TProveedor_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TMaterialDestino_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TCentroDestino_MOM")); %></td>
                                    <td><% out.println(po.getProperty("etiqueta.TAlmacenDestino_MOM")); %></td>
                                </tr> 
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
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            </table>
                        </section>
                    </section>
                    <section>
                        <input id="BorrarFila" type="image" src="images/DELETEADD.PNG"/>
                    </section>
                </div>
                <label class="ocultar" id="lbl305"></label>
            </div>
        </div>

        <div id="VentanaModalClase" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><% out.println(po.getProperty("etiqueta.mov_MOM")); %></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalClase', 'bxClase');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><% out.println(po.getProperty("etiqueta.GralRestriciones")); %></button><hr></div>
            <div id="ConsultaTablaClase">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClase">
                        <div class="fixedY" id="fixedYClase">
                            <table>
                                <thead>
                                    <tr>
                                        <th><% out.println(po.getProperty("etiqueta.MovTextMov")); %></th><th><% out.println(po.getProperty("etiqueta.GralDescripcion")); %></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClase">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModal101" class="VentanaModal101">
            <div id="handle4"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam101" class="BuscarParam_u">
                <div class="fondo_Match101">
                    <div class="PedidoCompra">
                        <label><% out.println(po.getProperty("etiqueta.pedido_MOM")); %></label>
                        <hr class="lnMov">
                        <label><% out.println(po.getProperty("etiqueta.pedido_MOM")); %></label>
                        <input type="text" class="bx101" id="bxPedido" maxlength="10">
                        <button id="btnPedido" class='BtnMatchIcon'></button>
                        <label><% out.println(po.getProperty("etiqueta.pos_MOM")); %></label>
                        <input type="text" class="bx101" id="bxPosc" maxlength="5">
                        <button class="btnImg" id="btnTomar" type="submit">
                            <img src="images/ejecuta.GIF" />
                            <label><% out.println(po.getProperty("etiqueta.tomar_MOM")); %></label>
                        </button>
                    </div>
                    <br>
                    <section id="TablaStatus101" class="TablaStatusC">
                        <section id="SecTab101">
                        </section>
                    </section>

                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="ok101"/>                       
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModal101', 'btnAdd', 'm');"/>
                </div>
            </div>
        </div>
        <div id="VentanaModal201" class="VentanaModal201">
            <div id="handle7"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam201" class="BuscarParam_u">
                <div class="fondo_Match201">
                    <div class="content200">
                        <label><%out.println(po.getProperty("etiqueta.DatsMov_Mov"));%></label>
                        <hr class="lnMov">
                        <div class="cnt200">
                            <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label>
                            <input type="text" class="bx200" id="bxMaterial201" maxlength="40">
                            <button id="btnMat201" class='BtnMatchIcon'></button>
                            <hr>
                            <p id="txtMaterial" class="material200G"></p>
                            <br>
                            <label><%out.println(po.getProperty("etiqueta.GralCantidad"));%></label>
                            <input type="text" class="bxMD200" id="bxcnt201" maxlength="11" onblur="this.value = checkDec(this.value, 3)">
                            <input type="text" class="bxUM200" id="bxUM201" maxlength="3" onKeyUp="this.value = this.value.toUpperCase();">
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.LoteDocVLD"));%></label>
                            <input type="text" class="bxMMD200" id="bxLote201" style="text-transform: uppercase;" maxlength="10">
                            <button id="btnLot201" class='BtnMatchIcon'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPCCosto"));%></label>
                            <input type="text" class="bxMMD200" id="bxccs201" style="text-transform: uppercase;" maxlength="10">
                            <button id="btnCcs201" class='BtnMatchIcon'></button>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="ok201" />                       
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="close201"/>
                </div>
            </div>
        </div>
        <!-- Ventana Modal Lote de Inpseccion-->

        <div id="VentanaModalGestionInp" class="VentanaModalLoteiInpe">
            <div id="handle19"><label  id="TituloMloins">Gestión lotes de inspección</label></div>
            <div  class="BuscarParam_u">
                <div class="CabecesLI">
                    <label style="width:80%;">Cabecera</label>
                    <hr class="lnMov">
                    <div class="subcabLI">
                        <label>Material</label><input type="text" id="MaterialLoteInsp" style="width:15%;" disabled/> <input type="text"  id="DesMateLI" style="width:60%; border: none; background: none" readonly/>
                        <hr>
                        <label>Centro</label><input tpye="text" style="background:none; border: none;" id="CentroLI" readOnly/>
                        <hr>
                    </div>
                </div>
                <div class="NuevosResil">
                    <label style="width:80%;">Nuevos resultados</label>
                    <hr class="lnMov">
                    <section id="TablaStatusPI" class="TablaStatusC">
                        <section id="SecTabPI">

                        </section>
                    </section>
                </div>
                <div class="Divdefectos">
                    <label style="width:80%;">Defectos</label>
                    <hr class="lnMov">
                    <div class="sub1def">
                        <label>Clase informe</label><input type="text" id="claInfor"  style="width:30%;"/>
                        <hr>
                        <label>Grupo de codigo</label><input type="text" id="gpocodigo"   style="width:30%;"/>
                        <hr>
                        <label>Clase defecto</label><input type="text" id="cladefecto"   style="width:25%;"/>
                        <hr>
                    </div>
                    <div class="sub1def">
                        <br>
                        <label>Número defectos</label><input type="text" id="NumDefectos" style="width:30%;"/>
                        <hr>
                        <label>Clase defecto</label><input type="text" id="clasedefect" style="width:8%;"/>
                        <hr>
                    </div>
                    <div class="sub2def">
                        <br>
                        <label>Descripción</label><input type="text" id="DescrpDef" style="width:70%;"/>
                        <hr>
                    </div>
                </div>
                <div class="DivDesiciónEmpleo">
                    <label style="width:80%;">Desición de empleo</label>
                    <hr class="lnMov">
                    <div class="subem">
                        <label>Código DE</label><input type="text" style="width:5%;"/>
                        <hr>
                        <label>Gr. Códigos DE</label><input type="text" style="width: 10%"/>
                        <hr>
                    </div>
                </div>
                <div class="Botones_GestionInpeccion">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" onclick="OKPlainpeccion();"/>                       
                    <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="cursor:pointer;" onclick="CerrarVenatanGPI();"/>
                </div>
            </div>
        </div> 

        <!-- Movimiento 261  ventana-->
        <div id="VentanaModal261" class="VentanaModal261">
            <div id="handle11"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam261" class="BuscarParam_u">
                <div class="fondo_Match201">
                    <div class="content200">
                        <label><%out.println(po.getProperty("etiqueta.DatsMov_Mov"));%></label>
                        <hr class="lnMov">
                        <div class="cnt200">
                            <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label>
                            <input type="text" class="bx200" id="bxMaterial261" maxlength="40">
                            <button id="btnMat261" class='BtnMatchIcon'></button>
                            <hr>
                            <p class="material200G"  id="txtMaterial261"></p>
                            <br>
                            <label><%out.println(po.getProperty("etiqueta.GralCantidad"));%></label>
                            <input type="text" class="bxMD200" id="bxcnt261" maxlength="11" onblur="this.value = checkDec(this.value, 3)">
                            <input type="text" class="bxUM200" id="bxUM261" maxlength="3" onKeyUp="this.value = this.value.toUpperCase();">
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.LoteDocVLD"));%></label>
                            <input type="text" class="bxMMD200" id="bxLote261" style="text-transform: uppercase;" maxlength="10">
                            <button id="btnLot261" class='BtnMatchIcon'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></label>
                            <input type="text" class="bxMMD200" id="bxord261" maxlength="12">
                            <button id="btnOrd261" class='BtnMatchIcon'></button>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="ok261"/>                       
                    <img class="BtnMatchIcon" src="images/HR_not.png"  id="clo261" style="cursor:pointer;"/>
                </div>
            </div>
        </div>            
        <!--Poner aqui 305-->
        <div id="VentanaModal305" class="VentanaModalRG">
            <div id="handle15"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam303" class="BuscarParam_u">
                <div class="fondo_MatchRG">
                    <section class="TableContainer">
                        <section class="SecHead">
                            <table id="TabHead">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                        <td ></td>
                                        <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.GralCantidad"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.PedidoLote"));%></td>
                                        <td></td>
                                        <td><%out.println(po.getProperty("etiqueta.TCentroDestino_MOM"));%></td>
                                    </tr>
                                </thead>
                            </table>
                        </section>
                        <section class="SecBody" id="SecCuerpo">

                        </section>
                    </section>
                    <section>
                        <input id="BorrarFila" onclick="Verificar305();" type="image" src="images/DELETEADD.PNG"/>
                        <input id="AgregarFila" onclick="AgregaPos();" class="addFila" type="image" src="images/ADD.PNG"/>
                    </section>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="ok305"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModal305', 'btnAdd', 'm');"/>
                </div>
            </div>
        </div>
        <div id="VentanaModal303" class="VentanaModalRG">
            <div id="handle13"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam303" class="BuscarParam_u">
                <div class="fondo_MatchRG">
                    <section id="TablaStatus303" class="TablaStatusC303">
                        <table class="TablaCont" id="Tabla303">
                            <thead>
                                <tr id="CabeceraTabla303">
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.GralCantidad"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.PedidoLote"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.TCentroDestino_MOM"));%></td>
                                </tr>
                            </thead>
                            <%
                                out.println("<tbody>");
                                for (int d = 0; d <= 50; d++) {
                                    out.println("<tr>\n"
                                            + "                <td><input type=\"checkbox\" style=\"size: 100%;\" id=\"TCpos" + d + "\" name=\"TCpos\" value=" + d + "></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCmat\" id=\"TCmat" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCmat')\" onblur=\"checkMate()\" style=\"width: 125px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"18\">                                                                      <button id=\"match_TCmat" + d + "\" name=\"match_TCmat\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"match303mat('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCtxtB\" id=\"TCtxtB" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 200px;\" maxlength=\"40\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCcant\" id=\"TCcant" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 95px;\" onblur=\"this.value = checkDec(this.value, 3)\" maxlength=\"11\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCumc\" id=\"TCumc" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"3\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TClot\" id=\"TClot" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TClot')\" style=\"width: 45px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">                                                                       <button id=\"match_TClot" + d + "\" name=\"match_TClot\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"match303lot('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCcent\" id=\"TCcent" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCcent')\" onKeyUp=\"this.value = this.value.toUpperCase();\" style=\"width: 55px;\"  maxlength=\"4\">                                                                                                                       <button id=\"match_TCcent" + d + "\" name=\"match_TCcent\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"match303cent('" + d + "')\"></button>     </td>\n"
                                            + "           </tr>");

                                }
                                out.println("</tbody>");
                            %>

                        </table>
                    </section>
                    <section>
                        <input id="BorrarFila" type="image"  onclick="deleteRow('Tabla303');"   src="images/DELETEADD.PNG"/>
                        <input id="AgregarFila" class="addFila" onclick="checkRow303();" type="image" src="images/ADD.PNG"/>
                    </section>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" onclick="validar303();"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModal303', 'btnAdd', 'm');"/>
                </div>
            </div>
        </div>
        <div id="VentanaModal311" class="VentanaModal201">
            <div id="handle16"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParam311" class="BuscarParam_u">
                <div class="fondo_Match201">
                    <div class="content200">
                        <label><%out.println(po.getProperty("etiqueta.dats311_Mov"));%></label>
                        <hr class="lnMov">
                        <div class="cnt200">
                            <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label>
                            <input type="text" class="bx200" id="bxMaterial311" maxlength="40">
                            <button id="btnMat311" class='BtnMatchIcon'></button>
                            <hr>
                            <p id="txtMaterial311" class="material200G"></p>
                            <br>
                            <label><%out.println(po.getProperty("etiqueta.GralCantidad"));%></label>
                            <input type="text" class="bxMD200" id="bxcnt311" maxlength="11" onblur="this.value = checkDec(this.value, 3)">
                            <input type="text" class="bxUM200" id="bxUM311" maxlength="3" onKeyUp="this.value = this.value.toUpperCase();">
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.LoteDocVLD"));%></label>
                            <input type="text" class="bxMMD200" id="bxLote311" style="text-transform: uppercase;" maxlength="10">
                            <button id="btnLot311" class='BtnMatchIcon'></button>
                            <hr>
                            <!--<span class="lb311">
                                <label>Stock Inicial</label>
                                <input type="text" class="bxMSD200" id="bxstk311" maxlength="1">
                                <span class="lbl3111">
                                    <label>Proveedor</label>
                                    <input type="text" class="bxMMD200" id="bxpov311" maxlength="10">
                                    <button id="btnPov311" class='BtnMatchIcon'></button>
                                </span>
                                <hr>
                            </span>-->
                        </div>
                    </div><br>
                    <div class="content200">
                        <label><%out.println(po.getProperty("etiqueta.Desti_Mov"));%></label>
                        <hr class="lnMov">
                        <div class="cnt200">
                            <label><%out.println(po.getProperty("etiqueta.almDesti_Mov"));%></label>
                            <input type="text" class="bxMMD200" id="bxAlmacen311" style="text-transform: uppercase;">
                            <button id="btnAlmacen311" class='BtnMatchIcon'></button>
                            <br>
                            <input type="text" class="bxMMD200" id="bxAlmacenIvend">
                        </div>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="ok311"/>                       
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="clo311"/>
                </div>
            </div>
        </div>
        <div id="VentanaRG" class="VentanaModalRG">
            <div id="handle20"><label id="TituloMatch" class="Titles"></label></div>
            <br><div id="BuscarParamRG" class="BuscarParam_u">
                <div class="fondo_MatchRG">
                    <section id="TablaStatusRG" class="TablaStatusC">
                        <section id="SecRG">
                        </section>
                    </section>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okRG"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaRG', 'btnAdd', 'm');"/>
                </div>
            </div>
        </div>
        <div id="VentanaModalStockT" class="VentanaModal">
            <div id="handle21"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.STOCKNumMaterial"));%> (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalStockT', 'bxMaterial305');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnStockT"><%out.println(po.getProperty("etiqueta.NTextBDocVlD"));%></button><hr></div>
            <div id="BuscarParamStockT" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="bxTxtS" style="width:50%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Clveidiom_Mov"));%></label><input type="text" id="bxCliS" style="width:10%;" value="<%=Idioma%>"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input type="text" id="bxMatS" style="width:50%;"/>
                        <hr><br><br>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%>s</label><input type="number" min="1"  id="bxCnmS" value="500" style="width:10%;"/>
                        <input type="text" id="idxM" style="width:50%;" hidden/>
                        <hr>
                    </div>      
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okStockT"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalStockT', 'bxMaterial305');"/>
                </div>
            </div>
            <div id="ConsultaTablaStockT" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollStockT">
                        <div class="fixedY" id="fixedYStockT">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></th><th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosStockT">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.STOCKNumMaterial"));%> (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalMaterial', 'bxMaterial201');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnMaterial"><%out.println(po.getProperty("etiqueta.NTextBDocVlD"));%></button><hr></div>
            <div id="BuscarParamMaterial" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="bxtxtm" style="width:50%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Clveidiom_Mov"));%></label><input type="text" id="bxclim" style="width:10%;" value="<%=Idioma%>"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input type="text" id="bxmatm" style="width:50%;"/>
                        <hr><br><br>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="bxcnmm" value="500" style="width:10%;"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalMaterial', 'bxMaterial201');"/>
                </div>
            </div>
            <div id="ConsultaTablaMaterial" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial">
                        <div class="fixedY" id="fixedYMaterial">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></th><th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMaterial">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/// Ventana Modal Material 303-->
        <div id="VentanaModalMaterial303" class="VentanaModal">
            <div id="handleMat303"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.STOCKNumMaterial"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaM('mat303');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnMaterial303"><%out.println(po.getProperty("etiqueta.NTextBDocVlD"));%></button><hr></div>
            <div id="BuscarParamMaterial303" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="txtMat303" style="width:50%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Clveidiom_Mov"));%></label><input type="text" id="idio303" style="width:10%;" value="<%=Idioma%>"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input type="text" id="mat303" style="width:50%;"/>
                        <hr><br><br>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMaxMat303" value="500" style="width:10%;"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial303"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentanaM('mat303');"/>
                </div>
            </div>
            <div id="ConsultaTablaMaterial303" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial">
                        <div class="fixedY" id="fixedYMaterial">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></th><th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMaterial303">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCC" class="VentanaModalCC">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMCentrodecoste"));%> (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalCC', 'bxccs201');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnCC"><%out.println(po.getProperty("etiqueta.MAPMCentrodecoste"));%></button><hr></div>
            <div id="BuscarParamCC" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPClaseCoste"));%></label><input type="text" id="bxcc" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DescripCLacosto"));%></label><input type="text" id="bxtxc" style="width:40%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMCentrodecoste"));%></label><input type="text" id="bxsc" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DescripCcoso"));%></label><input type="text" id="bxtxc2" style="width:40%;"/>
                        <hr>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCC"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalCC', 'bxccs201');"/>
                </div>
            </div>
            <div id="ConsultaTablaCC" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCC">
                        <div class="fixedYL" id="fixedYCC">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPClaseCoste"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMCentrodecoste"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXL" id="cargarDatosCC">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalProv" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch">Número de la cuenta del proveedor o acreedor (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalProv', 'bxpov201');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnProv">Proveedores (general)</button><hr></div>
            <div id="BuscarParamProv" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Nombre</label><input type="text" id="bxnom" style="width:40%;"/>
                        <hr>
                        <label>Acreedor</label><input type="text" id="bxacc" style="width:30%;"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okProv"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalProv', 'bxpov201');"/>
                </div>
            </div>
            <div id="ConsultaTablaProv" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollProv">
                        <div class="fixedY" id="fixedYProv">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Nombre 1</th><th>Acreedor</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosProv">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPedido" class="VentanaModalCC">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalPedido', 'bxPedido');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnPedido"><%out.println(po.getProperty("etiqueta.Pedidofec_Mov"));%></button><hr></div>
            <div id="BuscarParamPedido" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.DocFechDocumentMaDMa"));%></label><input type="date" id="bxFch" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DocumenCom_Mov"));%></label><input type="text" id="bxDC" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.SolPedReporte"));%></label><input type="text" id="bxSolp" style="width:30%;"/>
                        <hr><br><br>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="bxCnM" max="500" value="500" style="width:15%;"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPedido"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalPedido', 'bxPedido');"/>
                </div>
            </div>
            <div id="ConsultaTablaPedido" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPedido">
                        <div class="fixedYL" id="fixedYPedido">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.FechDoc1_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.DcoComp_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.SoliPe_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.SoliPe_Mov"));%> SAM</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXL" id="cargarDatosPedido">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAlmacen" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.RESAlamcene"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalAlmacen', 'bxAlmacen');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmacen">
                        <div class="fixedY" id="fixedYAlmacen">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosAlmacen">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalTexto" class="VentanaModal">
            <div id="handle27"><label id="TituloMatch">Texto Libre</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalTexto', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>Texto Libre</button><hr></div>
            <div id="BuscarParamTexto" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Texto Libre</label><input type="text" id="bxTextoL" style="width:30%;" hidden=""/>
                        <textarea style="resize:none;" id="Textlib" class="txtArL"></textarea>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okTexto"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalTexto', '');"/>
                </div>
            </div>
        </div>

        <div id="VentanaModalLote" class="VentanaModalLoteL">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LoteMa_Mov"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalLote', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaLote">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollLote">
                        <div class="fixedYL" id="fixedYLote">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa1_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa2_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa3_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa4_Mov"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXL" id="cargarDatosLote">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalLote303" class="VentanaModalLoteL">
            <div id="handleLot303"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LoteMa_Mov"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaM('lot303');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaLote303">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollLote">
                        <div class="fixedYL" id="fixedYLote">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa1_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa2_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa3_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa4_Mov"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXL" id="cargarDatosLote303">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalDoc" class="VentanaModal">
            <div id="handle17"><label id="TituloMatch"></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalDoc', 'bxDocMat');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaDoc">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDoc">
                        <div class="fixedY" id="fixedYDoc">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></th><th><%out.println(po.getProperty("etiqueta.GralPosicion"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDoc">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalCentro', 'bxCentro');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCentro">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentro303" class="VentanaModal">
            <div id="handleCent303"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaM('Centro');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCentro303">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Inicio Antonio Match Orden-->
        <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumOrden_Mov"));%> (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalOrden', 'bxord261');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnOrd"><%out.println(po.getProperty("etiqueta.NumOrden1_Mov"));%></button><hr></div>
            <div id="BuscarParamOrd" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></label><input type="text" id="bxOrden" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></label><input type="text" id="bxtxtOrd" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="bxcnmor" value="500" style="width:10%;"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okOrd"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalOrden', 'bxord261');"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden">
                        <div class="fixedY" id="fixedYOrdOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.PedidoOrnd"));%></th><th><%out.println(po.getProperty("etiqueta.Pedidotxt"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrd">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalReserva" class="VentanaModalReservasL">
            <div id="handle14"><label id="TituloMatch">Limitar ambito de valores (1)</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalReserva', 'bxReserva');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnPnRese">Restricciones</button><hr></div>
            <div id="BuscarParamReserva" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatchRes">
                        <label>Reserva</label><input type="text" id="SReserva" style="width:25%;"/>
                        <hr>
                        <label>Posición</label><input type="text" id="SPosicion" style="width:15%;"/>
                        <hr>
                        <label>Material</label><input type="text" id="SMaterial" style="width:25%;"/>
                        <hr>
                        <label>Texto Material</label><input type="text" id="STMaterial" style="width:25%;"/>
                        <hr>
                        <label>Centro</label><input type="text" id="SCentro" style="width:10%;"/>
                        <hr>
                        <label>Almacén</label><input type="text" id="SAlmacen" style="width:10%;"/>
                        <hr>
                        <label>Usuario</label><input type="text" id="SUsuario" style="width:15%;"/>
                        <hr>
                        <label>Ctd.máxima aciertos </label><input type="text"  id="CtdAccmax" value="500" style="width:5%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okReser"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalReserva', 'bxReserva');"/>
                </div>
            </div>
            <div id="ConsultaTablaReserva" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollReserva">
                        <div class="fixedYR" id="fixedYReserva">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Num Reserva</th><th>Folio SAM</th><th>Posición</th><th>Clase.mov.</th><th>Material</th><th>TextoMaterial</th><th>Centro</th><th>Almacén</th><th>Usuario</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXR" id="cargarDatosReserva">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalAv" class="VentanaModalAv">
            <div id="handleAV"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.AdventMsg_Mov"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalAv', 'bxPedido');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv"></label>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAv"/>
                </div>
            </div>
        </div>
        <div id="VentanaModalDocMat" class="VentanaModal">
            <div id="handle18"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.DocMoMt_MOv"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalDocMat', 'bxPedido');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.DocMoMt_MOv"));%></button><hr></div>
            <div id="ConsultaTablaDocMat">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDocCompras">
                        <div class="fixedY" id="fixedYPDocCompras">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.DocMater_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.ReportesSolStatuPedido"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDocCompras">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalClsInf" class="VentanaModal">
            <div id="handle23"><label id="TituloMatch">Limitar ámbito de valores</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalClsInf', 'bxCldInfoC');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>Restricciones</button><hr></div>
            <div id="ConsultaTablaClsInf">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClsInf">
                        <div class="fixedY" id="fixedYPClsInf">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ClaseInfor</th><th>Texto breve</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClsInf">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalInspCod" class="VentanaModal">
            <div id="handle24"><label id="TituloMatch">Limitar ámbito de valores</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalInspCod', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>Restricciones</button><hr></div>
            <section class="dataCab">
                <label>Catálogo: </label><label id="catInsCod"></label>
                <br>
                <label>Conjunto de selección: </label><label id="conjInsCod"></label>
                <br>
                <label>Grupo de códigos: </label><label id="gpoCodInsCod"></label>
            </section>
            <div id="ConsultaTablaClsInf">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClsInf">
                        <div class="fixedY" id="fixedYPClsInf">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Código</th><th>Texto breve para código</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosInspCod">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCalidad" class="VentanaModalCld">
            <div id="handle22"><label id="TituloMatch">Gestión lotes de inspección</label></div>
            <br><div id="BuscarParamCalidada" class="BuscarParam_u">
                <div class="fondo_MatchRG">
                    <div class="CldMov">
                        <label>Cabecera</label>
                        <hr class="lnMov">
                        <section class="bkCld">
                            <label class="cldLeft">Material</label>
                            <input type="text" class="bx101" id="bxMatC" maxlength="40">
                            <label class="cldLong" id="lblMatC">&nbsp;&nbsp;&nbsp;MATERIAL XXXXXXX</label>
                            <hr>
                            <label class="cldLeft">Centro</label>
                            <label id="lblCtrC">&nbsp;&nbsp;BAJA&nbsp;&nbsp;</label>
                            <label>Doc.compr.&nbsp;&nbsp;&nbsp;</label>
                            <input type="text" class="bx101" id="bxDocComC" readonly="true" maxlength="40">
                            <label>Lote inspección&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input type="text" class="bx101" readonly="true" id="bxLoteInspCal" maxlength="40">
                            <label>&nbsp;&nbsp;Inspector&nbsp;&nbsp;</label>
                            <label id="numInsp">236</label>
                            <hr>
                        </section>
                    </div>
                    <br>
                    <div class="CldMov">
                        <label>Nuevos resultados</label>
                        <hr class="lnMov">
                        <section class="DobleScroll" id="DobleSection">
                            <section id="DobleContainer"></section>
                        </section>
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead2">
                                    <thead>
                                        <tr>
                                            <td>Pos.</td>
                                            <td>Característica</td>
                                            <td>Especif.</td>
                                            <td hidden>Cualitativa</td>
                                            <td hidden>Renglon</td>
                                            <td>A Inspeccionar</td>
                                            <td>Inspeccionado</td>
                                            <td>Resultado</td>
                                            <td>UMC</td>
                                            <td>Código</td>
                                            <td></td>
                                            <td>Valoración</td>
                                            <td>Nota</td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpoCld">

                            </section>
                        </section>

                        <button class="btnCalidad" id="btnGrabarR" type="submit">Grabar Resultados</button>
                    </div>
                    <br>
                    <div class="CldMov">
                        <label>Defectos</label>
                        <hr class="lnMov">
                        <section class="bkCld">
                            <label class="cldLeft2">Clase de Informe</label>
                            <input type="text" class="bx101" id="bxClsInf" maxlength="40" onfocus="showMatch('btnMatchhClInf');" onblur="hideMatch('btnMatchhClInf');consultarClsInf();">
                            <!--<button id="btnMatchhClInf" class='BtnMatchIcon' onclick="openWinClsInf()"></button>-->
                            <label id="lblClsInf"></label>
                            <br>
                            <label class="cldLeft2">Perfil catálogo</label>
                            <input type="text" class="bx101" id="bxPerfilC" maxlength="40" readonly>
                            <label id="lblPerCat"></label>
                            <section class="DobleScroll" id="DobleSectionN">
                                <section id="DobleContainerN"></section>
                            </section>
                            <section class="TableContainer" id="dfCld">
                                <br>
                                <section class="SecHead">
                                    <table id="TabHead3">
                                        <thead>
                                            <tr>
                                                <td></td>
                                                <td>Gr.códigos</td>
                                                <td></td>
                                                <td>Cód.</td>
                                                <td>Cl.defecto</td>
                                                <td>Número defectos</td>
                                                <td>Clase defecto</td>
                                                <td>Gr.códigos</td>
                                                <td></td>
                                                <td>Cód.</td>
                                                <td>Ubic.defecto</td>
                                                <td>Descripción</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpoCld2">

                                </section>
                            </section>
                            <section id="bkCld">
                                <button id="btnCld3" class="btnCalidad3" type="submit" onclick="EliminaCld()"></button>
                                <button id="btnCld4" class="btnCalidad4" type="submit" onclick="addPos()"></button>
                                <button class="btnCalidad2" id="btnGrabarD" type="submit">Graba defectos</button>
                            </section>
                        </section>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCalidad"/>
                </div>
            </div>
        </div>
        <div id="VentanaModalClaseDefecto" class="VentanaModal">
            <div id="handle25"><label id="TituloMatch">Selección múltiple de códigos</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalClaseDefecto', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>Cl.defecto</button><hr></div>
            <div id="ConsultaTablaClaseDefecto">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseDefecto">
                        <div class="fixedY" id="fixedYClaseDefecto">
                            <table>
                                <thead>
                                    <tr>
                                        <th id="thPCat"></th><th>Problemas</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseDefecto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalClaseDefectoE" class="VentanaModal">
            <div id="handle26"><label id="TituloMatch">Selección múltiple de códigos</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalClaseDefectoE', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>Cl.defecto</button><hr></div>
            <div id="ConsultaTablaClaseDefectoE">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseDefectoE">
                        <div class="fixedY" id="fixedYClaseDefectoE">
                            <table>
                                <thead>
                                    <tr>
                                        <th id="thPCatE"></th><th>Problemas</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseDefectoE">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div id="VentanaModalMsgAddFile" class="VentanaModalAv">
            <div id="handleFile"><label id="TituloMatch">Advertencia</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalMsgAddFile', 'bxPedido');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv">¿Desea agregar archivos?</label>
                    <button id='addFile' onclick="AbrirVentanaAddFile();" >sí</button><button id='btnCancelar'>no</button>
                </div>
            </div>
        </div>
        <div id="VentanaModalAddFile" class="VentanaModalFiles">
            <div id="handleFileAdd"><label id="TituloMatch">Agregar Archivos</label></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <section id="TablaStatus" class="TablaStatusC">
                    <section id="SecTabPpal">
                        <form action="GuardarArchivo" name="FormCreate" method="POST" enctype="multipart/form-data" id="FormCreate">

                            <table class="TablaCont" id="table12">
                                <input type="file" onchange="DatosArchivos();" name="file" id="archivos" >
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;Nombre del archivo&nbsp;</td>
                                        <td>&nbsp;Tipo&nbsp;</td>
                                        <td>&nbsp;Tamaño&nbsp;</td>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </section>
            </div>
            <div class="Botones_MatchFile">
                <input type="button" value="Cancelar" class="cancDatAdj"  onclick="cancelarFile();"/>
                <img class="BtnMatchIcon" src="images/DELETEADD.PNG" style="margin-right:-4%; cursor:pointer;" id="EliminarArchivo" onclick="DeleteFile();"/>
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFiles" onclick="uploadFiles();"/>
            </div>
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
            </div>
        </div>
        <%
            htmlResponse = html.imprimirTablaCabLotInsp();
            out.println(htmlResponse);
            htmlResponse = html.imprimirTablaPosLotInsp();
            out.println(htmlResponse);

        %>
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
                    var e;
                    var cgd = 0, gg = 0;

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
                        bloq();
                        FechaN();
                        MostrarFolio();
                        GuardarMovimientos("VaciarTemporal", "");

                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                    }
                    function msgWindo123(ven, num) {
                        msg = "";
                        switch (num) {
                            case 1:
                                msg = '<%=E1%>';
                                break;
                            case 2:
                                msg = '<%=E2%>';
                                break;
                            case 3:
                                msg = '<%=E3%>';
                                break;
                            case 4:
                                msg = '<%=E4%>';
                                break;
                            case 5:
                                msg = '<%=E5%>';
                                break;
                            case 6:
                                msg = '<%=E6%>';
                                break;
                            case 7:
                                msg = '<%=E7%>';
                                break;
                            case 8:
                                msg = '<%=E8%>';
                                break;
                        }
                        abrirVentanaAv(ven, msg);
                        var theHandle = document.getElementById("handleAV");
                        var theRoot = document.getElementById("VentanaModalAv");
                        Drag.init(theHandle, theRoot);
                    }
                    function CantidadPositiva(id)
                    {
                        var cnt = document.getElementById(id);
                        if (cnt.value < 1) {
                            cnt.value = 1;
                        }
                    }
                    function TitulosVentanas()
                    {
                        var motit = '<%=movim%>';
                        var clase = document.getElementById('bxClase').value;
                        var title = document.getElementsByClassName("Titles");
                        switch (clase)
                        {
                            case "101":
                                title[0].innerHTML = '<%=movim101%>';
                                break;
                            case "102":
                                title[0].innerHTML = '<%=movim102%>';
                                break;
                            case "201":
                                title[1].innerHTML = motit + " 201";
                                title[6].innerHTML = motit + " 201";
                                break;
                            case "202":
                                title[1].innerHTML = motit + " 202";
                                break;
                            case "261":
                                title[2].innerHTML = motit + " 261";
                                title[6].innerHTML = motit + " 261";
                                break;
                            case "262":
                                title[2].innerHTML = motit + " 262";
                                break;
                            case "303":
                                title[4].innerHTML = motit + " 303";
                                break;
                            case "305":
                                title[3].innerHTML = motit + " 305";
                                break;
                            case "311":
                                title[5].innerHTML = motit + " 311";
                                title[6].innerHTML = motit + " 311";
                                break;
                            case "312":
                                title[5].innerHTML = motit + " 312";
                                break;
                        }
                    }
                    function inv() {
                        var funinva = "<%=funcioninv%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                    }
                    function inval()
                    {
                        var funinva = "<%=CampoOb%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                        var temp = new Array();
                        temp[0] = document.getElementById("bxCentro");
                        temp[1] = document.getElementById("bxAlmacen");
                        temp[2] = document.getElementById("bxClase");
                        temp[3] = document.getElementById("bxTexto");
                        temp[4] = document.getElementById("bxCarta");

                        for (i = 0; i < temp.length; i++)
                        {
                            if (temp[i].value.length === 0)
                            {
                                temp[i].focus();
                                return;
                            }
                        }
                    }
                    function invalV(c, a, cl)
                    {
                        var funinva = "<%=menValores%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                        var f1 = document.getElementById("bxCentro");
                        var f2 = document.getElementById("bxAlmacen");
                        var f3 = document.getElementById("bxClase");

                        if (c == 0) {
                            f1.focus();
                            return;
                        }
                        if (a == 0) {
                            f2.focus();
                            return;
                        }
                        if (cl == 0) {
                            f3.focus();
                            return;
                        }
                    }
                    function invalido(funinva)
                    {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.png";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                    }
                    function invalidoAd(funinva)
                    {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                    }
                    function FechaN()
                    {
                        var d = new Date();
                        var month = d.getMonth();
                        switch (month)
                        {
                            case 0 :
                                month = "01";
                                break;
                            case 1 :
                                month = "02";
                                break;
                            case 2 :
                                month = "03";
                                break;
                            case 3 :
                                month = "04";
                                break;
                            case 4 :
                                month = "05";
                                break;
                            case 5 :
                                month = "06";
                                break;
                            case 6 :
                                month = "07";
                                break;
                            case 7 :
                                month = "08";
                                break;
                            case 8 :
                                month = "09";
                                break;
                            case 9 :
                                month = "10";
                                break;
                            case 10 :
                                month = "11";
                                break;
                            case 11 :
                                month = "12";
                                break;
                        }
                        var day = d.getDate();
                        switch (day)
                        {
                            case 1 :
                                day = "01";
                                break;
                            case 2 :
                                day = "02";
                                break;
                            case 3 :
                                day = "03";
                                break;
                            case 4 :
                                day = "04";
                                break;
                            case 5 :
                                day = "05";
                                break;
                            case 6 :
                                day = "06";
                                break;
                            case 7 :
                                day = "07";
                                break;
                            case 8 :
                                day = "08";
                                break;
                            case 9 :
                                day = "09";
                                break;
                            default:
                                day = d.getDate();
                                break;
                        }
                        document.getElementById("bxFecha").value = day + "." + month + "." + +d.getFullYear();
                    }
                    function mostrarVentana(t)
                    {
                        switch (t) {
                            case "VentanaModalInspCod":
                                var ven = document.getElementById(t);
                                abrirVentanaModalClsInf(ven);
                                $("#" + t).css('z-index', 11);
                                break;
                            case "VentanaModalClsInf":
                                var ven = document.getElementById(t);
                                abrirVentanaModalClsInf(ven);
                                $("#" + t).css('z-index', 11);
                                break;
                            case "VentanaModalGestionInp":
                                var ven = document.getElementById(t);
                                abrirVentanalLInspecion(ven);
                                break;
                            case "VentanaModalTexto":
                            case "VentanaModalClaseDefecto":
                            case "VentanaModalClaseDefectoE":
                            case "VentanaModalCentro":
                            case "VentanaModalDoc":
                            case "VentanaModalAlmacen":
                            case "VentanaModalClase":
                            case "VentanaModalPedido":
                            case "VentanaModalMaterial":
                            case "VentanaModalStockT":
                            case "VentanaModalProv":
                            case "VentanaModalOrden":
                            case "VentanaModalDocMat":
                            case "VentanaModalMaterial303":
                                var ven = document.getElementById(t);
                                abrirVentana(ven);
                                break;
                            case "VentanaModalReserva":
                                var ven = document.getElementById(t);
                                abrirVentanaReserva(ven);
                                break;
                            case "VentanaModalLote303":
                                var ven = document.getElementById(t);
                                abrirVentana(ven);

                                break;
                            case "VentanaModalCentro303":
                                var ven = document.getElementById(t);
                                abrirVentana(ven);
                                break;
                            case "VentanaModal101":
                                descm();
                                var ven = document.getElementById(t);
                                tabla101(t + "NBS");
                                abrirVentana101(ven);
                                document.getElementById("bxPedido").focus();
                                break;
                            case "VentanaRG":
                                descm();
                                LimpiarPpal("LimpiarPpal");
                                var ven = document.getElementById(t);
                                abrirVentanaLote(ven);
                                break;
                            case "VentanaModalCC":
                            case "VentanaModalLote":
                                var ven = document.getElementById(t);
                                abrirVentanaLote(ven);
                                break;
                            case "VentanaModal261":
                            case "VentanaModal311":
                            case "VentanaModal303":
                                descm();
                                //Limpiar registros por usuario
                                var tmov = document.getElementById('bxClase').value;
                                var sm = "&v1=" + tmov;
                                GuardarMovimientos("VaciarMovimientos", sm);
                                if (tmov === "262") {
                                    tmov = "261";
                                }
                                if (tmov === "312") {
                                    tmov = "311";
                                }
                                var ven = document.getElementById(t);
                                abrirVentanaLote(ven);
                                checkFirstRow303();
                                almacenDestino311();
                                break;
                            case "VentanaModal201":
                                descm();
                                //Limpiar registros por usuario
                                var tmov = document.getElementById('bxClase').value;
                                var sm = "&v1=" + tmov;
                                GuardarMovimientos("VaciarMovimientos", sm);
                                if (tmov === "202") {
                                    tmov = "201";
                                }
                                var ven = document.getElementById(t);
                                abrirVentana200(ven);
                                document.getElementById("bxMaterial" + tmov).focus();
                                break;
                            case "VentanaModal305":
                                descm();
                                //Limpiar registros por usuario
                                LimpiarPpal("LimpiarPpal");
                                GuardarMovimientos("VaciarTemporal", "");

                                var tmov = document.getElementById('bxClase').value;
                                var sm = "&v1=" + tmov;
                                GuardarMovimientos("VaciarMovimientos", sm);
                                var ven = document.getElementById(t);
                                abrirVentanaLote(ven);
                                eliminaTabla300();
                                CargaTabla300('SecCuerpo');

                                break;
                            case "VentanaModalAlmacenA":
                                var ven = document.getElementById('VentanaModalAlmacen');
                                abrirVentana(ven);
                                peticiones('PeticionMovMateriales', 'cargarDatosAlmacen', t, 'Almacen');
                                break;
                                break;
                            case "VentanaModalCentroA":
                                var ven = document.getElementById('VentanaModalCentro');
                                abrirVentana(ven);
                                peticiones('PeticionMovMateriales', 'cargarDatosCentro', t, 'Centro');
                                break;
                        }
                        switch (t) {
                            case "VentanaModalCentro":
                                peticiones('PeticionMovMateriales', 'cargarDatosCentro', t, 'Centro');
                                break;
                            case "VentanaModalAlmacen":
                                peticiones('PeticionMovMateriales', 'cargarDatosAlmacen', t, 'Almacen');
                                break;
                            case "VentanaModalClase":
                                peticiones('PeticionMovMateriales', 'cargarDatosClase', t, 'Clase');
                                break;
                        }
                    }
                    function CantidadPedido()
                    {
                        var ped = document.getElementById('bxPedido').value;
                        var cla = document.getElementById('bxClase').value;
                        if (ped.length > 0)
                        {
                            if (cla === "101") {
                                tabla101('VentanaModal101');
                                LimpiarPpal("LimpiarPpal");
                            }
                            if (cla === "102") {
                                DocComprasMov(ped);
                                LimpiarPpal("LimpiarPpal");
                                tabla101("VentanaModal101NBS");
                            }
                        } else
                        {
                            var theHandle = document.getElementById('handleAV');
                            var theRoot = document.getElementById('VentanaModalAv');
                            Drag.init(theHandle, theRoot);
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 2);
                        }
                    }
                    function DocComprasMov(ped) {
                        var url = "PeticionMovMateriales";
                        var acc = "DocMovimiento102";
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                rs = xmlhttp.responseText;
                                if (rs == 1) {

                                    var theHandle = document.getElementById('handleAV');
                                    var theRoot = document.getElementById('VentanaModalAv');
                                    Drag.init(theHandle, theRoot);
                                    var ven = document.getElementById('VentanaModalAv');
                                    msgWindo123(ven, 3);
                                } else {
                                    mostrarVentana("VentanaModalDocMat");
                                    document.getElementById("cargarDatosDocCompras").innerHTML = rs;
                                    var theHandle = document.getElementById('handle18');
                                    var theRoot = document.getElementById('VentanaModalDocMat');
                                    Drag.init(theHandle, theRoot); //                        fnc4();
                                }
                            }
                        };
                        xmlhttp.open("GET", url + "?Action=" + acc + "&DocCom=" + ped, true);
                        xmlhttp.send();
                    }
                    function seleccionaMov101(docmat, foliosam) {
                        var mov102 = "";
                        if (docmat.length > 0) {
                            mov102 = docmat + ",FSAP";
                        } else {
                            mov102 = foliosam + ",FSAM";
                        }
                        CheckTypeFolio(mov102);
                    }
                    function CheckTypeFolio(mov102) {
                        var arr = new Array();
                        arr = mov102.split(",");
                        var f1 = arr[0];
                        var f2 = arr[1];
                        tabla102(f1, f2);
                    }
                    function tabla102(f1, f2) {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionTablasMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=VentanaModal101&clase=102&DocCom=" + f1 + "&TipoFolio=" + f2,
                            success: function (data) {
                                if (data == 1) {
                                    ocultarVentana('VentanaModalDocMat', 'bxPedido');
                                    var theHandle = document.getElementById('handleAV');
                                    var theRoot = document.getElementById('VentanaModalAv');
                                    Drag.init(theHandle, theRoot);
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Núm Doc. Compras no contiene posiciones ";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                }
                                if (data == 2) {
                                    ocultarVentana('VentanaModalDocMat', 'bxPedido');
                                    var theHandle = document.getElementById('handleAV');
                                    var theRoot = document.getElementById('VentanaModalAv');
                                    Drag.init(theHandle, theRoot);
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Documento \"" + f1 + "\" 101 anulado";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else {
                                    ocultarVentana('VentanaModalDocMat', 'bxPedido');
                                    document.getElementById("SecTab101").innerHTML = data;
                                    var c = document.getElementsByName("tdCantCa102");
                                    for (i = 0; i < c.length; i++) {
                                        if (c[i].textContent === "") {
                                            c[i].textContent = "0.000";
                                        }
                                    }
                                }
                            }
                        });
                    }
                    function tabla101(accion)
                    {
                        var extras = "";
                        var v1 = document.getElementById('bxPedido').value;
                        var v2 = document.getElementById('bxPosc').value;
                        var v3 = document.getElementById('bxCentro').value.toUpperCase();
                        //Se mueve dentro del if cuando se tenga el usuario y se quita el metodo limpiar
                        LimpiarPpal("LimpiarPpal");
                        var pd = "&ped=" + v1;
                        GuardarTemporal('GuardaTemporal', pd);
                        if (accion === "VentanaModal101")
                        {
                            extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                        }
                        var clase = document.getElementById('bxClase').value;
                        var almacen = document.getElementById("bxAlmacen").value.toUpperCase();
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Pedido de Compras no encontrado o sin Posiciones ";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    tabla101("VentanaModal101NBS");
                                } else
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "El documento de compras " + v1 + " no esta liberado";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    tabla101("VentanaModal101NBS");
                                } else if (xmlhttp.responseText == 2) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "El documento de compras " + v1 + " no es apto para <br> entradas de mercancias, debido que es un pedido de servicio";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    tabla101("VentanaModal101NBS");
                                } else if (xmlhttp.responseText == 3) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "El documento de compras " + v1 + " contiene <br> una orden que no esta liberada";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    tabla101("VentanaModal101NBS");
                                } else
                                {
                                    document.getElementById("SecTab101").innerHTML = xmlhttp.responseText;
                                    var lote = document.getElementsByName('bx101Lote');
                                    var mat = document.getElementsByName('tdMaterial');
                                    var porrc = document.getElementsByName('bx101Prb');
                                    for (f = 0; f < lote.length; f++)
                                    {
                                        if (mat[f].textContent == "") {
                                            //                                            alert(f);
                                            $('#bxLote' + f).prop("disabled", true);
                                        } else {
                                            if (verificarLotemate(mat[f].textContent.trim()) == "0") {
                                                $('#bxLote' + f).prop("disabled", true);
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionTablasMovMateriales?Action=" + accion + "&almacen=" + almacen + extras + "&clase=" + clase, true);
                        xmlhttp.send();
                    }

                    function LimpiarPpal(accion)
                    {
                        var clase = document.getElementById('bxClase').value;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("SecTabPpal").innerHTML = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionTablasMovMateriales?Action=" + accion + "&clase=" + clase, true);
                        xmlhttp.send();
                    }
                    function abrirVentanaModalClsInf(ventana) {
                        var ancho = 350;
                        var alto = 650;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                        var iconm = $('#iconmsg');
                        var men = $('#msg');
                        men.html("");
                        iconm.hide();
                    }
                    function abrirVentana(ventana)
                    {
                        var ancho = 600;
                        var alto = 550;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                        document.getElementById('aceptar').focus();
                    }
                    function abrirVentanaReserva(ventana)
                    {
                        var ancho = 1300;
                        var alto = 550;
                        if (screen.width <= 1100) {
                            ancho = 1000;
                            alto = 600;
                        }
                        if (screen.width <= 650) {
                            ancho = 550;
                        }
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                        document.getElementById('aceptar').focus();
                    }
                    function abrirVentanaAv(ventana, msg)
                    {
                        var ancho = 900;
                        var alto = 250;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                        document.getElementById("lbAv").innerHTML = msg;
                    }
                    function abrirVentanaLote(ventana)
                    {
                        var ancho = 1050;
                        var alto = 600;
                        if (screen.width <= 1100) {
                            ancho = 1000;
                        }
                        if (screen.width <= 650) {
                            ancho = 550;
                        }
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                    }
                    function abrirVentanaCalidad(ventana)
                    {
                        var ancho = 1150;
                        var alto = 750;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                    }
                    function abrirVentana200(ventana)
                    {
                        var ancho = 1050;
                        var alto = 400;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                    }
                    function abrirVentana101(ventana)
                    {
                        var ancho = 1000;
                        var alto = 800;
                        if (screen.width <= 1100) {
                            ancho = 1000;
                            alto = 600;
                        }
                        if (screen.width <= 650) {
                            ancho = 550;
                            alto = 750;
                        }
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                    }
                    function abrirVentanalLInspecion(ventana)
                    {
                        var ancho = 1000;
                        var alto = 700;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                    }
                    function ocultarVentana(ven, id, M)
                    {
                        if (M === "m") {
                            actcm();
                        }
                        var ventana = document.getElementById(ven);
                        ventana.style.display = 'none';
                        document.getElementById("msg").innerHTML = "";
                        document.getElementById("iconmsg").style.visibility = "hidden";
                        try {
                            var txt = document.getElementById(id);
                            txt.focus();
                        } catch (e) {
                        }
                    }
                    function seleccionarReserva(f1, f2, id, ven) {
                        var cl = document.getElementById("bxClase").value;
                        var val = document.getElementById(id);
                        if (f1.length > 0) {
                            val.value = f1;
                        } else {
                            val.value = f2;
                        }
                        ocultarVentana(ven, id);
                    }
                    function seleccionaCld(grupo, cod, txt, ix, ven)
                    {
                        document.getElementById("Cod1" + ix).value = grupo;
                        document.getElementById("Cod2" + ix).value = cod;
                        document.getElementById("Cod3" + ix).value = txt;
                        ocultarVentana(ven, "Cod1" + ix);
                    }
                    function seleccionaCldE(grupo, cod, txt, ix, ven)
                    {
                        document.getElementById("Cod4" + ix).value = grupo;
                        document.getElementById("Cod5" + ix).value = cod;
                        document.getElementById("Cod6" + ix).value = txt;
                        ocultarVentana(ven, "Cod4" + ix);
                    }
                    function selecciona(val, id, ven)//nuevo lalo
                    {
                        document.getElementById(id).value = val;
                        ocultarVentana(ven, id);
                    }
                    function seleccionaADE(val, id, ven, ivent)//nuevo lalo
                    {
                        document.getElementById(id).value = val;
                        document.getElementById('bxAlmacenIvend').value = ivent;
                        ocultarVentana(ven, id);
                    }
                    function seleccionaDoc(val, id, ven)//nuevo lalo
                    {
                        var arr = new Array();
                        arr = val.split(",");
                        document.getElementById('lbl305').innerHTML = val;
                        document.getElementById(id).value = arr[0];
                        $('#bxPosDoc').css('background-image', 'none');
                        document.getElementById('bxPosDoc').value = parseInt(arr[1]);
                        ocultarVentana(ven, id);
                    }
                    function seleccionar(val, id, ven)
                    {
                        var ck = document.getElementsByName('reserv1');
                        var cl = document.getElementById("bxClase").value;
                        if (cl === "202") {
                            cl = "201";
                        }
                        if (cl === "262") {
                            cl = "261";
                        }
                        if (cl === "312") {
                            cl = "311";
                        }
                        switch (cl) {
                            case "201":
                            case "261":
                            case "303":
                            case "311":
                                if (ck.length > 0)
                                {
                                    document.getElementById(id).value = val;
                                    ocultarVentana(ven, id);
                                } else
                                {
                                    document.getElementById(id + cl).value = val;
                                    ocultarVentana(ven, id + cl);
                                }
                                break;
                            case "305":
                                document.getElementById(id).value = val;
                                ocultarVentana(ven, id);
                                break;
                            default:
                                document.getElementById(id).value = val;
                                ocultarVentana(ven, id);
                                break;
                        }
                    }
                    function seleccionarMat(val, id, ven)//NuevoLalo
                    {
                        ///// Obtener datos 
                        var cl = document.getElementById("bxClase").value;
                        if (cl === "202") {
                            cl = "201";
                        }
                        if (cl === "262") {
                            cl = "261";
                        }
                        if (cl === "312") {
                            cl = "311";
                        }
                        switch (cl) {
                            case "261":
                            case "311":
                            case "303":
                                var m = document.getElementById("bxMaterial" + cl);
                                m.focus();
                                m.value = val;
                                ObtenerMaterialN(cl);
                                d_um(cl);
                                ocultarVentana(ven, id);
                                break;
                            default:
                                document.getElementById(id).value = val;
                                ocultarVentana(ven, id);
                                ObtenerMaterial200();
                                d_um("201");
                                break;
                        }
                    }

                    function seleccionarMatT(val, id, ven, cnt, um)
                    {
                        var m = document.getElementById("bxMat" + id);
                        document.getElementById("txtUM" + id).innerHTML = um;
                        document.getElementById("txtAD" + id).innerHTML = document.getElementById('bxCentro').value.toUpperCase();
                        document.getElementById("bxCnt" + id).value = cnt;
                        m.value = val;
                        ObtenerMaterialN3(id);
                        ObtenerLote300(id);
                        ocultarVentana(ven, "bxMat" + id);
                    }
                    function ObtenerMaterialN3(id)
                    {
                        var material = document.getElementById("bxMat" + id).value;
                        var lang = "<%=Idioma%>";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=NombreMaterial&v1=" + material + "&lang=" + lang,
                            success: function (data) {
                                if (data == 0) {
                                    invalido("Material no creado para el Centro e Idioma de Trab");
                                } else {
                                    document.getElementById("txtMat" + id).innerHTML = data.trim();
                                    document.getElementById("msg").innerHTML = "";
                                    document.getElementById("iconmsg").style.visibility = "hidden";
                                }
                            }
                        });
                    }
                    function ObtenerAll305(id)
                    {
                        var material = document.getElementById("bxMat" + id).value;
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var lang = "<%=Idioma%>";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=Obtener305&v1=" + material + "&v2=" + centro + "&lang=" + lang,
                            success: function (data) {
                                if (data == 0) {
                                    invalido("Material no creado para el Centro e Idioma de Trab");
                                } else {
                                    var temp = new Array();
                                    temp = data.split(",");

                                    document.getElementById("txtMat" + id).innerHTML = temp[0].trim();
                                    document.getElementById("bxCnt" + id).value = temp[1].trim();
                                    document.getElementById("txtUM" + id).innerHTML = temp[2].trim();
                                    document.getElementById("txtAD" + id).innerHTML = temp[3].trim();

                                    document.getElementById("msg").innerHTML = "";
                                    document.getElementById("iconmsg").style.visibility = "hidden";
                                    ObtenerLote300(id);
                                }
                            }
                        });
                    }
                    function ObtenerMaterialN(cl)
                    {
                        if (cl === "262") {
                            cl = "261";
                        }
                        if (cl === "312") {
                            cl = "311";
                        }
                        var material = document.getElementById('bxMaterial' + cl).value;
                        var lang = "<%=Idioma%>";

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=NombreMaterial&v1=" + material + "&lang=" + lang,
                            success: function (data) {
                                if (data == 0) {
                                    document.getElementById("txtMaterial" + cl).innerHTML = "";
                                    invalido("Material no creado para el Centro e Idioma de Trab");
                                } else {
                                    $('#bxUM' + cl).css('background-image', 'none');
                                    document.getElementById("txtMaterial" + cl).innerHTML = data;
                                    document.getElementById("msg").innerHTML = "";
                                    document.getElementById("iconmsg").style.visibility = "hidden";
                                }
                            }
                        });
                    }
                    function CargaTabla300(id)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById(id).innerHTML = xmlhttp.responseText;
                                AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=TablaN300", true);
                        xmlhttp.send();
                    }
                    function addPos()
                    {
                        var r1 = document.getElementsByName('defectos');
                        var ck = r1.length;
                        var no = parseInt(ck) - 1;
                        var i = parseInt(r1[no].value) + 1;
                        var table = document.getElementById("TabBody3");
                        var row = table.insertRow(r1.length);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        var cell5 = row.insertCell(4);
                        var cell6 = row.insertCell(5);
                        var cell7 = row.insertCell(6);
                        var cell8 = row.insertCell(7);
                        var cell9 = row.insertCell(8);
                        var cell10 = row.insertCell(9);
                        var cell11 = row.insertCell(10);
                        var cell12 = row.insertCell(11);
                        var cell13 = row.insertCell(12);
                        cell1.innerHTML = "<input type=\"checkbox\" name=\"defectos\" value=\"" + i + "\" onfocus=\"hideBtnsCld()\">";
                        cell2.innerHTML = "<input id=\"Cod1" + i + "\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df1\" onkeypress=\"valMt9(event, '" + i + "', this.value)\" onfocus=\"CodBtGr1Show('" + i + "')\">";
                        cell3.innerHTML = "<button name=\"df2\" id=\"btCod1" + i + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"MatchCod9('" + i + "')\"></button>";
                        cell4.innerHTML = "<input id=\"Cod2" + i + "\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df3\" readonly>";
                        cell5.innerHTML = "<input id=\"Cod3" + i + "\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df4\" readonly>";
                        cell6.innerHTML = "<input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df5\" onfocus=\"hideBtnsCld()\" onkeypress=\"return numCld(event)\">";
                        cell7.innerHTML = "<select class=\"bxcRG\" name=\"df6\" onfocus=\"hideBtnsCld()\">\n" +
                                "  <option value=\"01\">Defecto crítico</option>\n" +
                                "  <option value=\"02\">Defecto grave</option>\n" +
                                "  <option value=\"03\">Defecto leve</option>\n" +
                                "</select>";
                        cell8.innerHTML = "<input id=\"Cod4" + i + "\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df7\" onfocus=\"CodBtGr2Show('" + i + "')\">";
                        cell9.innerHTML = "<button name=\"df8\" id=\"btCod2" + i + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"MatchCodE('" + i + "')\"></button>";
                        cell10.innerHTML = "<input id=\"Cod5" + i + "\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df9\" readonly>";
                        cell11.innerHTML = "<input id=\"Cod6" + i + "\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df10\" readonly>";
                        cell12.innerHTML = "<input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df11\" onfocus=\"CodBtGr3Show('" + i + "')\">\n" +
//                        cell12.innerHTML = "<input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df11\">\n" +
                                "<textarea style=\"resize:none;\" name=\"df13\" id=\"Textlib" + i + "\" hidden></textarea>";
                        cell13.innerHTML = "<button name=\"df12\" id=\"btCod3" + i + "\" class='BtnMatchIconDescri' style=\"display : none;\" width=\"100%\" onclick=\"MatchTexto('" + i + "')\"></button>";
                        document.getElementById('DobleContainerN').style.height = document.getElementById("TabBody3").offsetHeight + "px";
                    }
                    function AgregaPos()
                    {
                        var r1 = document.getElementsByName('305');
                        var ck = r1.length;
                        var no = parseInt(ck) - 1;
                        var i = parseInt(r1[no].value) + 1;
                        var ni = parseInt(i + 1);
                        var table = document.getElementById("TabBody");
                        var row = table.insertRow(r1.length);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        var cell5 = row.insertCell(4);
                        var cell6 = row.insertCell(5);
                        var cell7 = row.insertCell(6);
                        var cell8 = row.insertCell(7);
                        var cell9 = row.insertCell(8);
                        cell1.innerHTML = "<input id=\"rbt\" type=\"checkbox\" name=\"305\" value=\"" + i + "\">";
                        cell2.innerHTML = "<input name=\"movsn1\" type=\"text\" class=\"bxcRG\" id=\"bxMat" + i + "\" maxlength=\"40\" style=\"text-transform: uppercase;\" onkeypress=\"validar(event, '" + i + "')\" onblur=\"ObtenerAll305('" + i + "')\" onfocus=\"matBtnShow('" + i + "')\">";
//                        cell2.innerHTML = "<input name=\"movsn1\" type=\"text\" class=\"bxcRG\" id=\"bxMat" + i + "\" maxlength=\"40\" style=\"text-transform: uppercase;\" onKeyPress=\"return NadaFK(event)\" onfocus=\"matBtnShow('" + i + "')\">";
                        cell3.innerHTML = "<button id=\"btnMat" + i + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"matVen300('" + i + "')\"></button>";
                        cell4.innerHTML = "<label name=\"movsn2\" id=\"txtMat" + i + "\"></label>";
                        cell5.innerHTML = "<input maxlength=\"13\" type=\"text\"  name=\"movsn3\"  class=\"bxcRG\" id=\"bxCnt" + i + "\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"matchTbl300('')\">";
                        cell6.innerHTML = "<label name=\"movsn4\" id=\"txtUM" + i + "\"></label>";
                        cell7.innerHTML = "<input type=\"text\" name=\"movsn5\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + i + "\" onfocus=\"loteBtnShowN('" + i + "')\">";
                        cell8.innerHTML = "<button id=\"btnLote" + i + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote300('" + i + "')\"></button>";
                        cell9.innerHTML = "<label name=\"movsn6\" id=\"txtAD" + i + "\"></label>";
                    }
                    function validar(e, id) {
                        var tecla = (document.all) ? e.keyCode : e.which;
                        if (tecla == 13)
                        {
                            ObtenerAll305(id);
                        }
                    }
                    function eliminaTabla300()
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=elimina305", true);
                        xmlhttp.send();
                    }
                    function CargaTabla300I()
                    {
                        eliminaTabla300();
                        var r1 = document.getElementsByName('movsn1');
                        var r2 = document.getElementsByName('movsn2');
                        var r3 = document.getElementsByName('movsn3');
                        var r4 = document.getElementsByName('movsn4');
                        var r5 = document.getElementsByName('movsn5');
                        var r6 = document.getElementsByName('movsn6');

                        for (var i = 0; i < r1.length; i++)
                        {
                            var extras = "&v1=" + r1[i].value + "&v2=" + r2[i].textContent + "&v3=" + r3[i].value +
                                    "&v4=" + r4[i].textContent + "&v5=" + r5[i].value +
                                    "&v6=" + r6[i].textContent;
                            var xmlhttp = new XMLHttpRequest();
                            xmlhttp.onreadystatechange = function () {
                                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                {
                                    document.getElementById('SecCuerpo').innerHTML = xmlhttp.responseText;
                                    AjustarCabecera('TabHead', 'TabBody', 8, 'SecCuerpo');
                                }
                            };
                            xmlhttp.open("GET", "PeticionMovMateriales?Action=TablaN300" + extras, true);
                            xmlhttp.send();
                        }
                    }
                    function peticiones(url, id, accion, f, lote, mmm, v)
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var extras = "";
                        var v1;
                        var v2;
                        var v3;
                        var v4;
                        var ck = document.getElementsByName('reserv1');

                        switch (accion)
                        {
                            case "VentanaModalPedido":
                                v1 = document.getElementById("bxFch").value;
                                v2 = document.getElementById("bxDC").value;
                                v3 = document.getElementById("bxSolp").value;
                                v4 = document.getElementById("bxCnM").value;
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4;
                                break;
                            case "VentanaModalMaterial":
                                v1 = document.getElementById("bxtxtm").value;
                                v2 = document.getElementById("bxclim").value;
                                v3 = document.getElementById("bxmatm").value;
                                v4 = document.getElementById("bxcnmm").value;
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4;
                                break;
                            case "VentanaModalStockT":
                                v1 = document.getElementById("bxTxtS").value;
                                v2 = document.getElementById("bxCliS").value;
                                v3 = document.getElementById("bxMatS").value;
                                v4 = document.getElementById("bxCnmS").value;
                                v5 = document.getElementById("idxM").value;
                                if (v4 === "") {
                                    v4 = "999";
                                }
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4 + "&lote=" + v5;
                                break;
                            case "VentanaModalCC":
                                v1 = document.getElementById("bxcc").value;
                                v2 = document.getElementById("bxsc").value;
                                v3 = document.getElementById("bxtxc").value;
                                v4 = document.getElementById("bxtxc2").value;
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4;
                                break;
                            case "VentanaModalProv":
                                v1 = document.getElementById("bxnom").value;
                                v2 = document.getElementById("bxacc").value;
                                extras = "&v1=" + v1 + "&v2=" + v2;
                                break;
                            case "VentanaModalOrden": //// Antonio Inicio
                                v1 = document.getElementById("bxOrden").value;
                                v2 = document.getElementById("bxtxtOrd").value;
                                v3 = document.getElementById("bxcnmor").value;
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                                break; //// Fin
                            case "VentanaModalReserva": //// Antonio Inicio
                                v1 = document.getElementById("SReserva").value;
                                v2 = document.getElementById("SPosicion").value;
                                v3 = document.getElementById("SAlmacen").value;
                                v4 = document.getElementById("SMaterial").value;
                                v5 = document.getElementById("SCentro").value;
                                v6 = document.getElementById("CtdAccmax").value;
                                v7 = document.getElementById("bxClase").value;
                                v8 = document.getElementById("SUsuario").value;
                                v9 = document.getElementById("STMaterial").value;
                                extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4 + "&v5=" + v5 + "&v6=" + v6 + "&CLM=" + v7 + "&v8=" + v8 + "&v9=" + v9;
                                break; //// Fin
                            case "VentanaModalClaseDefecto":
                                v1 = document.getElementById('bxPerfilC').value;
                                extras = "&v1=" + v1 + "&v2=" + v + "&v3=9";
                                break;
                            case "VentanaModalClaseDefectoE":
                                v1 = document.getElementById('bxPerfilC').value;
                                extras = "&v1=" + v1 + "&v2=" + v + "&v3=E";
                                break;
                            case "VentanaModalLote":
                                var clas = document.getElementById("bxClase").value;
                                var clas2 = document.getElementById("bxClase").value;
                                var alm = document.getElementById("bxAlmacen").value;
                                if (clas === "101" || clas === "102" || clas === "305")
                                {
                                    extras = "&v1=" + mmm + "&v2=" + clas2 + "&v3=" + alm;
                                } else
                                {
                                    if (ck.length > 0)
                                    {
                                        extras = "&v1=" + mmm + "&v2=" + clas2 + "&v3=" + alm;
                                    } else
                                    {
                                        if (clas === "202") {
                                            clas = "201";
                                        }
                                        if (clas === "262") {
                                            clas = "261";
                                        }
                                        if (clas === "312") {
                                            clas = "311";
                                        }
                                        v1 = document.getElementById("bxMaterial" + clas).value;
                                        extras = "&v1=" + v1 + "&v2=" + clas2 + "&v3=" + alm;
                                    }
                                }
                                break;
                        }
                        var lang = "<%=Idioma%>";
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0) {
                                    ocultarVentana(temp[1], temp[2]);
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/advertencia.PNG";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "No hay valores por mostrar";
                                } else {
                                    document.getElementById(id).innerHTML = xmlhttp.responseText;
                                    fnc(f);
                                }
                            }
                        };
                        xmlhttp.open("GET", url + "?Action=" + accion + "&lang=" + lang + extras + "&lote=" + lote + "&ctr=" + centro, true);
                        xmlhttp.send();
                    }
                    function ValidarCampos(clase)
                    {
                        var extras = "";
                        var v1 = document.getElementById("bxCentro").value.toUpperCase();
                        var v2 = document.getElementById("bxAlmacen").value.toUpperCase();
                        var v3 = document.getElementById("bxClase").value;

                        extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");

                                if (temp[0] == 0 || temp[1] == 0 || temp[2] == 0)
                                {
                                    invalV(temp[0], temp[1], temp[2]);
                                } else
                                {
                                    switch (clase)
                                    {
                                        case "101":
                                        case "102":
                                            mostrarVentana('VentanaModal101');
                                            break;
                                        case "201":
                                        case "202":
                                            mostrarVentana('VentanaModal201');
                                            break;
                                        case "261":
                                        case "262":
                                            mostrarVentana('VentanaModal261');
                                            break;
                                        case "303":
                                            mostrarVentana('VentanaModal303');
                                            break;
                                        case "305":
                                            mostrarVentana('VentanaModal305');
                                            break;
                                        case "311":
                                        case "312":
                                            mostrarVentana('VentanaModal311');
                                            break;
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=ValidarCampos" + extras, true);
                        xmlhttp.send();
                    }
                    function ObtenerMaterial200()
                    {
                        var material = document.getElementById('bxMaterial201').value;
                        var lang = "<%=Idioma%>";
                        if (material.length > 0) {
                            var xmlhttp = new XMLHttpRequest();
                            xmlhttp.onreadystatechange = function () {
                                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                                {
                                    if (xmlhttp.responseText == 0)
                                    {
                                        invalido("Material no creado para el Centro e Idioma de Trab");
                                        document.getElementById("txtMaterial").innerHTML = "";
                                    } else
                                    {
                                        document.getElementById("txtMaterial").innerHTML = xmlhttp.responseText;
                                        document.getElementById("msg").innerHTML = "";
                                        document.getElementById("iconmsg").style.visibility = "hidden";
                                    }
                                }
                            };
                            xmlhttp.open("GET", "PeticionMovMateriales?Action=NombreMaterial&v1=" + material + "&lang=" + lang, true);
                            xmlhttp.send();
                        }
                    }
                    function d_um(mov)
                    {
                        var material = document.getElementById("bxMaterial" + mov).value;
                        var movimiento = document.getElementById('bxClase').value;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("bxUM" + mov).value = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=umD" + "&v1=" + material, true);
                        xmlhttp.send();
                    }
                    function d_umT(mov)
                    {
                        var material = document.getElementById("bxMaterial" + mov).value;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("bxUM" + mov).value = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=umDT" + "&v1=" + material, true);
                        xmlhttp.send();
                    }
                    function ObtenerLote300(i)
                    {
                        var material = document.getElementById("bxMat" + i).value;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    document.getElementById("bxLote" + i).disabled = false;
                                } else
                                {
                                    document.getElementById("bxLote" + i).disabled = true;
                                    document.getElementById("bxLote" + i).value = '';
                                    $('#btnLot' + i).hide();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=LoteD" + "&v1=" + material, true);
                        xmlhttp.send();
                    }
                    function ObtenerLoteD()
                    {
                        var movimiento = document.getElementById('bxClase').value;
                        if (movimiento === "202") {
                            movimiento = "201";
                        }
                        if (movimiento === "262") {
                            movimiento = "261";
                        }
                        if (movimiento === "312") {
                            movimiento = "311";
                        }

                        var material = document.getElementById("bxMaterial" + movimiento).value;

                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    document.getElementById("bxLote" + movimiento).disabled = false;
                                    if ($('#bxLote' + movimiento).val().length > 0) {
                                        $('#bxLote' + movimiento).css('background-image', 'none');
                                    } else
                                    {
                                        $('#bxLote' + movimiento).css('background-image', 'url(images/necesario.PNG)');
                                    }
                                } else
                                {
                                    document.getElementById("bxLote" + movimiento).disabled = true;
                                    document.getElementById("bxLote" + movimiento).value = '';
                                    $('#bxLote' + movimiento).css('background-image', 'none');
                                    $('#btnLot' + movimiento).hide();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=LoteD" + "&v1=" + material, true);
                        xmlhttp.send();
                    }
                    function ObtenerCantidadD()//nuevo lalo
                    {
                        var material = document.getElementById("bxMaterial303").value.toUpperCase();
                        var centro = document.getElementById("bxCentro303").value.toUpperCase();
                        var lote = document.getElementById("bxLote303").value.toUpperCase();
                        var almacen = document.getElementById("bxAlmacen").value.toUpperCase();

                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById('bxcnt303').value = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=CantidadTransito" + "&v1=" + material + "&v4=" + centro + "&v5=" + almacen + "&lote=" + lote, true);
                        xmlhttp.send();
                    }
                    function TomarDatos300(action)
                    {
                        var material = document.getElementById('bxMaterial303').value.toUpperCase();
                        var cantidad = document.getElementById('bxcnt303').value;
                        var UM = document.getElementById('bxUM303').value.toUpperCase();
                        var lote = document.getElementById('bxLote303').value.toUpperCase();
                        var destino = document.getElementById('bxCentro303').value.toUpperCase();

                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var movimiento = document.getElementById('bxClase').value;
                        var posicion = document.getElementsByName('tdPos');
                        var cdes = document.getElementsByName('mmctr');
                        var numDoc = "";
                        var posDoc = "";
                        var pp = 1;
                        if (posicion.length > 0)
                        {
                            pp = parseInt(posicion[posicion.length - 1].textContent) + 1;
                        }
                        //                            if (cdes.length > 0)
                        //                            {
                        //                                if (cdes[cdes.length - 1].textContent != destino) {
                        //                                    var ven = document.getElementById('VentanaModalAv');
                        //                                    var msg = "Posición incorrecta para Cento Destino";
                        //                                    abrirVentanaAv(ven, msg);
                        //                                    return;
                        //                                }
                        //                            }
                        if (material === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Código de Material Obligatorio";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (cantidad === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Cantidad es Obligatoria";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (UM === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Unidad de Medida Obligatoria";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        var lotes = VerificarSujetoLote(material);
                        if (lotes == 1) {
                            if (lote.length < 1) {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Lote es Obligatorio para Material - Centro";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }

                        if (destino === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Centro Destino Obligatorio";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        DecimalesUM('303');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else
                                {
                                    if (temp[2] == 0)
                                    {
                                        TomarDatos300("ValidaLote");
                                    } else
                                    {
                                        if (temp[3] == 0)
                                        {
                                            TomarDatos300("ValidaCenDes");
                                        } else
                                        {
                                            if (cgd < 1) {
                                                var texto = document.getElementById('txtMaterial303').innerHTML;
                                                if (texto != "")
                                                {
                                                    var clas = document.getElementById('bxClase').value;
                                                    var extr = "&v1=" + material + "&v2=" + cantidad +
                                                            "&v3=" + UM + "&v4=" + lote +
                                                            "&v5=" + texto + "&CDestino=" + destino + "&v7=" + centro + "&clase=" + clas +
                                                            "&v8=" + pp + "&v9=" + movimiento +
                                                            "&v10=" + numDoc + "&v11=" + posDoc;
                                                    Tabla200('VentanaModal303', extr);
                                                    var ven = document.getElementById('VentanaModalAv');
                                                    var msg = "Posición añadida correctamente";
                                                    abrirVentanaAv(ven, msg);
                                                    var theHandle = document.getElementById("handleAV");
                                                    var theRoot = document.getElementById("VentanaModalAv");
                                                    Drag.init(theHandle, theRoot);
                                                    ocultarVentana('VentanaModal303', 'btnAdd');
                                                }
                                                cgd++;
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + "&v1=" + material + "&v2=" + UM + "&v3=" + cantidad + "&v4=" + centro + "&v5=" + almacen + "&lote=" + lote + "&v6=" + destino + "&v7=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function TomarDatos305(c, action)
                    {
                        var movimiento = document.getElementById('bxClase').value;
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();

                        var r1 = document.getElementsByName('movsn1');//Material I
                        var r2 = document.getElementsByName('movsn2');//Texto T
                        var r3 = document.getElementsByName('movsn3');//Cantidad I
                        var r4 = document.getElementsByName('movsn4');//UM T
                        var r5 = document.getElementsByName('movsn5');//lote I
                        var r6 = document.getElementsByName('movsn6');//Centro T
                        var numDoc = "";
                        var posDoc = "";
                        var registros = 0;

                        for (var i = 0; i < r1.length; i++)
                        {
                            if (r1[i].value === "" || r2[i].innerHTML == "")
                            {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Código de Material Obligatorio";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        ValidaMaterialHabilitado(r1[c].value);
                        if (habl === 0) {
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.display = "inline";
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = "Material inhabilitado";
                            r1[c].focus();
                            return;
                        }
                        for (var i = 0; i < r1.length; i++)
                        {
                            if (r3[i].value === "")
                            {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Cantidad es Obligatoria";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        for (var i = 0; i < r1.length; i++)
                        {
                            if (r5[i].disabled === false)
                            {
                                if (r5[i].value === "" && parseInt(r3[i].value) > 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Lote es Obligatorio para Material - Centro";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }
                            }
                        }
                        for (var i = 0; i < r1.length; i++)
                        {
                            DecimalesUMR(r4[i].innerHTML, r3[i]);
                        }
                        var extras = "&v1=" + r1[c].value + "&v3=" + r3[c].value + "&v4=" + centro + "&v5=" + almacen + "&lote=" + r5[c].value + "&v7=" + movimiento + "&v6=" + r6[c].innerHTML;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    if (action === 'ValidaCntST') {
                                        r3[c].focus();
                                    } else {
                                        r5[c].focus();
                                    }
                                } else
                                {
                                    if (action === 'ValidaCntST') {
                                        if (c < r1.length - 1) {
                                            TomarDatos305(parseInt(c += 1), 'ValidaCntST');
                                        } else {
                                            TomarDatos305(0, 'ValidaCenDesT');
                                        }
                                    }
                                    if (action === 'ValidaCenDesT') {
                                        if (c < r1.length - 1) {
                                            TomarDatos305(parseInt(c += 1), 'ValidaCenDesT');
                                        } else {
                                            var i = 1;
                                            for (var c = 0; c < r1.length; c++)
                                            {
                                                if (parseInt(r3[c].value) > 0)
                                                {
                                                    registros++;
                                                    var extr = "&v1=" + r1[c].value + "&v2=" + r3[c].value +
                                                            "&v3=" + r4[c].innerHTML + "&v4=" + r5[c].value.toUpperCase() +
                                                            "&v5=" + r2[c].innerHTML + "&CDestino=" + r6[c].innerHTML +
                                                            "&v7=" + centro + "&clase=" + movimiento +
                                                            "&v8=" + i + "&v9=" + movimiento +
                                                            "&v10=" + numDoc + "&v11=" + posDoc;
                                                    Tabla200('VentanaModal303', extr);
                                                    i++;
                                                }
                                            }
                                            verificarRegistros305('VerificarRegistros', registros, movimiento);
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }

                    function VerificarSujetoLote(m) {
                        var d = "";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=SujeroLoteMat&matelote=" + m,
                            success: function (data) {
                                d = data;
                            }
                        });
                        return d;
                    }
                    function TomarDatos260(action) {
                        var material = document.getElementById('bxMaterial261').value.toUpperCase();
                        var cantidad = document.getElementById('bxcnt261').value;
                        var UM = document.getElementById('bxUM261').value.toUpperCase();
                        var lote = document.getElementById('bxLote261').value.toUpperCase();
                        var ord = document.getElementById('bxord261').value;


                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var movimiento = document.getElementById('bxClase').value;
                        var posicion = document.getElementsByName('tdPoss');
                        var Orden = document.getElementsByName('mmnor');
                        var pp = 1;
                        if (posicion.length > 0)
                        {
                            pp = parseInt(posicion[posicion.length - 1].textContent) + 1;
                        }
                        if (Orden.length > 0) {
                            if (Orden[Orden.length - 1].textContent != ord) {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Dato incorrecto para posición orden";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        if (material === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 4);
                            return;
                        }
                        if (ord === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 5);
                            return;
                        }
                        if (cantidad === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 6);
                            return;
                        }
                        if (UM === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 7);
                            return;
                        }
                        //                        var lotes = VerificarSujetoLote(material);
                        //                        if (lotes == 1) {
                        //                            if (lote === "") {
                        //                                var ven = document.getElementById('VentanaModalAv');
                        //                                var msg = "Lote es Obligatorio para Material - Centro";
                        //                                abrirVentanaAv(ven, msg);
                        //                                return;
                        //                            }
                        //                        }
                        //                        if (lote === "")
                        //                        {
                        //                            var ven = document.getElementById('VentanaModalAv');
                        //                            var msg = "Lote es Obligatorio para Material - Centro";
                        //                            abrirVentanaAv(ven, msg);
                        //                            return;
                        //                        }
                        DecimalesUM('261');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else
                                {
                                    if (temp[2] == 0)
                                    {
                                        TomarDatos260("ValidaLote");
                                    } else
                                    {
                                        if (temp[3] == 0)
                                        {
                                            TomarDatos260("ValidaOrden");
                                        } else
                                        {
                                            if (cgd < 1) {
                                                var texto = document.getElementById('txtMaterial261').innerHTML;
                                                if (texto != "")
                                                {
                                                    var pos_;
                                                    try {
                                                        pos_ = document.getElementsByName('reserv8')[e].textContent;
                                                        document.getElementById('txtrsv').value = document.getElementsByName('reserv7')[e].textContent;
                                                    } catch (err) {
                                                        pos_ = "";
                                                        document.getElementById('txtrsv').value = "";
                                                    }
                                                    var clas = document.getElementById('bxClase').value;
                                                    var extr = "&v1=" + material + "&v2=" + cantidad +
                                                            "&v3=" + UM + "&v4=" + lote +
                                                            "&v5=" + texto + "&Orden=" + ord +
                                                            "&v7=" + centro + "&clase=" + clas +
                                                            "&v8=" + pp + "&v9=" + movimiento +
                                                            "&v12=" + pos_;
                                                    Tabla200('VentanaModal261', extr);
                                                    var ven = document.getElementById('VentanaModalAv');
                                                    var msg = "Posición añadida correctamente";
                                                    abrirVentanaAv(ven, msg);
                                                    var theHandle = document.getElementById("handleAV");
                                                    var theRoot = document.getElementById("VentanaModalAv");
                                                    Drag.init(theHandle, theRoot);
                                                    ocultarVentana('VentanaModal261', 'btnAdd');
                                                    e++;
                                                    cgd++;
                                                    if (document.getElementsByName('reserv1').length > 0)
                                                    {
                                                        AgregarPosisciones();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + "&v1=" + material + "&v2=" + UM + "&v3=" + cantidad + "&v4=" + centro + "&v5=" + almacen + "&lote=" + lote + "&v6=" + ord + "&v7=" + movimiento, true);
                        xmlhttp.send();

                    }

                    function TomarDatos310(action)
                    {
                        var material = document.getElementById('bxMaterial311').value.toUpperCase();
                        var cantidad = document.getElementById('bxcnt311').value;
                        var UM = document.getElementById('bxUM311').value.toUpperCase();
                        var lote = document.getElementById('bxLote311').value.toUpperCase();
                        var AlmDes = document.getElementById('bxAlmacen311').value.toUpperCase();

                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var movimiento = document.getElementById('bxClase').value;
                        var posicion = document.getElementsByName('tdPoss');
                        var pp = 1;
                        if (posicion.length > 0)
                        {
                            pp = parseInt(posicion[posicion.length - 1].textContent) + 1;
                        }
                        if (material === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Código de Material Obligatorio";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (cantidad === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Cantidad es Obligatoria";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (UM === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Unidad de Medida Obligatoria";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (AlmDes === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Almacén Destino es campo Obligatorio";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        var lotes = VerificarSujetoLote(material);
                        if (lotes == 1) {
                            if (lote.length < 1) {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Lote es Obligatorio para Material - Centro";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        if (AlmDes === document.getElementById('bxAlmacen').value.toUpperCase())
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Seleccione un Almacén Diferente";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        DecimalesUM('311');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else
                                {
                                    if (temp[2] == 0)
                                    {
                                        TomarDatos310("ValidaLote");
                                    } else
                                    {
                                        if (temp[3] == 0)
                                        {
                                            TomarDatos310("ValidaAlmDes");
                                        } else
                                        {
                                            if (cgd < 1) {
                                                var texto = document.getElementById('txtMaterial311').innerHTML;
                                                if (texto != "")
                                                {
                                                    var pos_;
                                                    try {
                                                        pos_ = document.getElementsByName('reserv8')[e].textContent;
                                                        document.getElementById('txtrsv').value = document.getElementsByName('reserv7')[e].textContent;
                                                    } catch (err) {
                                                        pos_ = "";
                                                        document.getElementById('txtrsv').value = "";
                                                    }
                                                    var clas = document.getElementById('bxClase').value;
                                                    var extr = "&v1=" + material + "&v2=" + cantidad +
                                                            "&v3=" + UM + "&v4=" + lote +
                                                            "&v5=" + texto + "&almacen=" + AlmDes +
                                                            "&v7=" + centro + "&clase=" + clas +
                                                            "&v8=" + pp + "&v9=" + movimiento +
                                                            "&v12=" + pos_;
                                                    Tabla200('VentanaModal311', extr);
                                                    var ven = document.getElementById('VentanaModalAv');
                                                    var msg = "Posición añadida correctamente";
                                                    abrirVentanaAv(ven, msg);
                                                    var theHandle = document.getElementById("handleAV");
                                                    var theRoot = document.getElementById("VentanaModalAv");
                                                    Drag.init(theHandle, theRoot);
                                                    ocultarVentana('VentanaModal311', 'btnAdd');
                                                    e++;
                                                    cgd++;
                                                    if (document.getElementsByName('reserv1').length > 0)
                                                    {
                                                        AgregarPosisciones();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + "&v1=" + material + "&v2=" + UM + "&v3=" + cantidad + "&v4=" + centro + "&v5=" + almacen + "&lote=" + lote + "&v6=" + AlmDes + "&v7=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function cantconvert(valor) {
                        if (valor.indexOf(".") != -1) {
                            va = valor.split(".");
                            v0 = va[0];
                            v1 = va[1];
                            if (v1.length == 1) {
                                var valorfinal = v0 + "." + v1 + "00";
                                return valorfinal;
                            } else if (v1.length == 2) {
                                var valorfinal = v0 + "." + v1 + "0";
                                return valorfinal;
                            } else {
                                return valor;
                            }

                        } else {
                            valor = valor + ".000";
                            return valor
                        }
                        return valor;
                    }
                    function GetTolConf(pe, po) {
                        var resp;
                        var acc = "GetTolearanciaConf";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + "&pedidotol=" + pe + "&postol=" + po,
                            success: function (data) {
                                resp = data;
                            }
                        });
                        return resp;
                    }
                    function GetCantend(C, U) {
                        var findata;
                        //                        var Tol = parseInt(GetTolConf());
                        //                        var cansol = parseFloat(C);
                        //                        var porcen = cansol * Tol / 100;
                        //                        var tolera = cansol + porcen;
                        var umc = parseInt(CheckUnidaMed(U));
                        if (umc == 0) {
                            findata = Math.floor(C);
                            if (findata < 1) {
                                findata = findata + 1;
                            }
                            findata += ".000";
                        }
                        if (umc == 3) {
                            findata = cantconvert(C.toString());
                        }
                        if (findata === undefined) {
                            findata = C;
                        }
                        return findata;
                    }
                    function GetCantFinal(C, U, ped, pos) {
                        var findata;
                        var tolera = 0.000;
                        var Tol = parseInt(GetTolConf(ped, pos));
                        var cansol = parseFloat(C);
                        var tolera = cansol * Tol / 100;
                        var umc = parseInt(CheckUnidaMed(U));
                        if (umc == 0) {
                            findata = Math.floor(tolera);
                        }
                        if (umc == 3) {
                            findata = cantconvert(tolera.toString());
                        }
                        return findata;
                    }
                    function CheckUnidaMed(valor)
                    {
                        var resp = "0";
                        var acc = "umed";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + "&v1=" + valor,
                            success: function (data) {
                                resp = data;
                            }
                        });
                        return resp;
                    }
                    function TomarDatosR(cc)
                    {
                        var movimiento = document.getElementById('bxClase').value;
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();

                        var r1 = document.getElementsByName('reserv1');//Material
                        var r2 = document.getElementsByName('reserv2');//Cantidad
                        var r3 = document.getElementsByName('reserv3');//um
                        var r4 = document.getElementsByName('reserv4');//lote
                        var r5 = document.getElementsByName('reserv5');// ext
                        var r6 = document.getElementsByName('reserv6');//Folio
                        var r7 = document.getElementsByName('reserv7');//pos
                        var r8 = document.getElementsByName('reserv8');//Descripcion

                        var registros = 0;

                        if (parseInt(r2[cc].value) > 0) {
                            ValidaMaterialHabilitado(r1[cc].textContent);
                            if (habl === 0) {
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.display = "inline";
                                iconm.style.visibility = "visible";
                                iconm.src = "images/advertencia.PNG";
                                var men = document.getElementById("msg");
                                men.innerHTML = "Material inhabilitado";
                                r2[cc].focus();
                                return;
                            }
                        }

                        for (tdr = 0; tdr < r1.length; tdr++)
                        {
                            if (r2[tdr].value === "")
                            {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Cantidad es Obligatoria";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        for (tdr = 0; tdr < r1.length; tdr++)
                        {
                            if (r4[tdr].disabled === false)
                            {
                                if (r4[tdr].value === "" && parseInt(r2[tdr].value) > 0) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Lote es Obligatorio para Material - Centro";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }
                            }
                        }
                        for (tdr = 0; tdr < r1.length; tdr++)
                        {
                            DecimalesUMR(r3[tdr].textContent, r2[tdr]);
                        }
                        document.getElementById('txtrsv').value = r6[0].textContent;
                        var action = "ValidaLote";
                        var extras = "&v1=" + r1[cc].textContent + "&v3=" + r2[cc].value + "&v4=" + centro + "&v5=" + almacen + "&lote=" + r4[cc].value + "&v7=" + movimiento;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    r4[cc].focus();
                                } else
                                {
                                    if (cc < r1.length - 1) {
                                        TomarDatosR(parseInt(cc += 1));
                                    } else {
                                        var i = 1;
                                        for (var c = 0; c < r1.length; c++) {
                                            if (parseInt(r2[c].value) > 0)
                                            {
                                                registros++;
                                                var action = "";
                                                var extr = "&v1=" + r1[c].textContent + "&v2=" + r2[c].value +
                                                        "&v3=" + r3[c].textContent + "&v4=" + r4[c].value +
                                                        "&v5=" + r8[c].textContent +
                                                        "&v7=" + centro + "&clase=" + movimiento +
                                                        "&v8=" + i + "&v9=" + movimiento +
                                                        "&v12=" + r7[c].textContent;
                                                switch (movimiento)
                                                {
                                                    case "201":
                                                        extr += "&v6=" + r5[c].textContent;
                                                        action = "VentanaModal201";
                                                        break;
                                                    case "261":
                                                        extr += "&Orden=" + r5[c].textContent;
                                                        action = "VentanaModal261";
                                                        break;
                                                    case "311":
                                                        extr += "&almacen=" + r5[c].textContent;
                                                        action = "VentanaModal311";
                                                        break;
                                                }
                                                Tabla200(action, extr);
                                                i++;
                                            }
                                        }

                                        var ven = document.getElementById('VentanaModalAv');
                                        var msg = "Posición añadida correctamente";
                                        abrirVentanaAv(ven, msg);
                                        var theHandle = document.getElementById("handleAV");
                                        var theRoot = document.getElementById("VentanaModalAv");
                                        Drag.init(theHandle, theRoot);
                                        ocultarVentana('VentanaRG', 'btnAdd');
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }

                    function TomarDatos200(action)
                    {

                        var material = document.getElementById('bxMaterial201').value.toUpperCase();
                        var cantidad = document.getElementById('bxcnt201').value;
                        var UM = document.getElementById('bxUM201').value.toUpperCase();
                        var CenCos = document.getElementById('bxccs201').value.toUpperCase();
                        var lote = document.getElementById('bxLote201').value.toUpperCase();
                        var loted = document.getElementById('bxLote201').value.toUpperCase();

                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var movimiento = document.getElementById('bxClase').value;
                        var posicion = document.getElementsByName('tdPoss');
                        var CentroC = document.getElementsByName('mmcec');

                        var pp = 1;
                        if (posicion.length > 0)
                        {
                            pp = parseInt(posicion[posicion.length - 1].textContent) + 1;
                        }
                        if (CentroC.length > 0)
                        {
                            if (CentroC[CentroC.length - 1].textContent !== CenCos)
                            {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Centro de Coste diferente al Ingresado";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }
                        if (material === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 4);
                            return;
                        }
                        var lotes = VerificarSujetoLote(material);
                        if (lotes == 1) {
                            if (lote.length < 1) {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Lote es Obligatorio para Material - Centro";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            }
                        }

                        if (cantidad === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 6);
                            return;
                        }
                        if (UM === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 7);
                            return;
                        }
                        if (CenCos === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            msgWindo123(ven, 8);
                            return;
                        }
                        DecimalesUM('201');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = temp[1];
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else
                                {
                                    if (temp[2] == 0)
                                    {
                                        TomarDatos200("ValidaLote");
                                    } else
                                    {
                                        if (temp[3] == 0)
                                        {
                                            TomarDatos200("ValidaCeCos");
                                        } else
                                        {
                                            if (cgd < 1) {

                                                ObtenerMaterial200();
                                                var texto = document.getElementById('txtMaterial').innerHTML;
                                                if (texto != "")
                                                {
                                                    var pos_;
                                                    try {
                                                        pos_ = document.getElementsByName('reserv8')[e].textContent;
                                                        document.getElementById('txtrsv').value = document.getElementsByName('reserv7')[e].textContent;
                                                    } catch (err) {
                                                        pos_ = "";
                                                        document.getElementById('txtrsv').value = "";
                                                    }
                                                    var clas = document.getElementById('bxClase').value;
                                                    var extr = "&v1=" + material + "&v2=" + cantidad +
                                                            "&v3=" + UM + "&v4=" + lote +
                                                            "&v5=" + texto + "&v6=" + CenCos +
                                                            "&v7=" + centro + "&clase=" + clas +
                                                            "&v8=" + pp + "&v9=" + movimiento +
                                                            "&v12=" + pos_;
                                                    Tabla200('VentanaModal201', extr);
                                                    var ven = document.getElementById('VentanaModalAv');
                                                    var msg = "Posición añadida correctamente";
                                                    abrirVentanaAv(ven, msg);
                                                    var theHandle = document.getElementById("handleAV");
                                                    var theRoot = document.getElementById("VentanaModalAv");
                                                    Drag.init(theHandle, theRoot);
                                                    ocultarVentana('VentanaModal201', 'btnAdd');
                                                    e++;
                                                    cgd++;
                                                    //                                                    if (document.getElementsByName('reserv1').length > 0)
                                                    //                                                    {
                                                    //                                                        AgregarPosisciones();
                                                    //                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + "&v1=" + material + "&v2=" + UM + "&v3=" + cantidad + "&v4=" + centro + "&v5=" + almacen + "&lote=" + lote + "&v6=" + CenCos + "&v7=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function Tabla200(action, extras)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("SecTabPpal").innerHTML = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionTablasMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }
                    function ValidaRG(action, extras)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {

                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }
                    function descm() {
                        document.getElementById("bxCentro").disabled = true;
                        document.getElementById("bxAlmacen").disabled = true;
                        document.getElementById("bxFecha").disabled = true;
                        document.getElementById("bxClase").disabled = true;
                        document.getElementById("bxTexto").disabled = true;
                        document.getElementById("bxNota").disabled = true;
                        document.getElementById("bxCarta").disabled = true;
                        document.getElementById("btnReserva").disabled = true;
                        document.getElementById("bxReserva").disabled = true;
                    }
                    function actcm() {
                        var tab = document.getElementsByName("Pedidos");
                        if (tab.length < 1) {
                            document.getElementById("bxCentro").disabled = false;
                            document.getElementById("bxAlmacen").disabled = false;
                            document.getElementById("bxFecha").disabled = false;
                            document.getElementById("bxClase").disabled = false;
                            document.getElementById("bxTexto").disabled = false;
                            document.getElementById("bxNota").disabled = false;
                            document.getElementById("bxCarta").disabled = false;
                            document.getElementById("btnReserva").disabled = false;
                            document.getElementById("bxReserva").disabled = false;
                            document.getElementById("btnAdd").disabled = false;
                        }
                    }
                    function acttm()
                    {
                        if (document.getElementsByName('Pedidos').length < 1)
                        {
                            document.getElementById('divresr').innerHTML = "";
                        }
                    }
                    function LimpiarPantalla(ventana)
                    {
                        switch (ventana) {
                            case "VentanaModalPedido":
                                document.getElementById("bxFch").value = "";
                                document.getElementById("bxDC").value = "";
                                document.getElementById("bxSolp").value = "";
                                break;
                            case "VentanaModalMaterial":
                                document.getElementById("bxtxtm").value = "";
                                document.getElementById("bxmatm").value = "";
                                break;
                            case "VentanaModalCC":
                                document.getElementById("bxcc").value = "";
                                document.getElementById("bxsc").value = "";
                                document.getElementById("bxtxc").value = "";
                                document.getElementById("bxtxc2").value = "";
                                break;
                            case "VentanaModalProv":
                                document.getElementById("bxnom").value = "";
                                document.getElementById("bxacc").value = "";
                                break;
                            case "VentanaModalOrden":
                                document.getElementById("bxOrden").value = "";
                                document.getElementById("bxtxtOrd").value = "";
                                break;
                            case "VentanaModalStockT":
                                document.getElementById("bxTxtS").value = "";
                                document.getElementById("bxCliS").value = "<%=Idioma%>";
                                document.getElementById("bxMatS").value = "";
                                document.getElementById("bxCnmS").value = "500";
                                break;
                        }
                    }
                    function AgregarPosicion()
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var clase = document.getElementById('bxClase').value;
                        var texto = document.getElementById('bxTexto').value;
                        var nota = document.getElementById('bxNota').value;
                        var carta = document.getElementById('bxCarta').value;


                        if (centro === "" || almacen === "" || clase === "" || texto === "")
                        {
                            inval();

                        } else
                        {
                            if (validarFecha() == false) {
                                var ven = document.getElementById('VentanaModalAv');
                                var msg = "Error: Fecha anterior a la actual";
                                abrirVentanaAv(ven, msg);
                                var theHandle = document.getElementById("handleAV");
                                var theRoot = document.getElementById("VentanaModalAv");
                                Drag.init(theHandle, theRoot);
                                return;
                            } else {
                                if (clase === "101" || clase === "102") {
                                    if (centro === "" || almacen === "" || clase === "" || texto === "" || carta === "") {
                                        inval();
                                    } else {
                                        document.getElementById("msg").innerHTML = "";
                                        document.getElementById("iconmsg").style.visibility = "hidden";
                                        ValidarCampos(clase);
                                    }
                                } else {
                                    document.getElementById("msg").innerHTML = "";
                                    document.getElementById("iconmsg").style.visibility = "hidden";
                                    ValidarCampos(clase);
                                }
                            }
                        }
                    }
                    function
                            fnc(f) {
                        document.getElementById('table-scroll' + f).onscroll = function () {
                            document.getElementById('fixedY' + f).style.top = document.getElementById('table-scroll' + f).scrollTop + 'px';
                        };
                    }
                    function loteBtnShow(val, tam)
                    {
                        document.getElementById("btnLote" + val).style.display = "inline";
                        for (i = 0; i < tam; i++) {
                            if (i != val)
                            {
                                document.getElementById("btnLote" + i).style.display = "none";
                            }
                            $('#bxLote' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[ÑñA-Za-z0-9\s]/;
                                return patron.test(t);
                            });
                            $('#bxProv' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[ÑñA-Za-z0-9\s]/;
                                modal
                                return patron.test(t);
                            });
                        }
                    }
                    function CodBtnShow(val)
                    {
                        var CheckBx = document.getElementsByName('cld10');
                        document.getElementById("btnCod" + val).style.display = "inline";
                        for (var i = 0; i < CheckBx.length; i++)
                        {
                            if (CheckBx[i] != document.getElementById("btnCod" + val))
                            {
                                CheckBx[i].style.display = "none";
                            }
                        }
                    }
                    function CodBtGr1Show(val)
                    {
                        codGr2();
                        codGr3();
                        var buttons = document.getElementsByName('df2');
                        document.getElementById("btCod1" + val).style.display = "inline";
                        for (var i = 0; i < buttons.length; i++)
                        {
                            if (buttons[i] != document.getElementById("btCod1" + val))
                            {
                                buttons[i].style.display = "none";
                            }
                        }
                    }
                    function CodBtGr2Show(val)
                    {
                        codGr1();
                        codGr3();
                        var buttons = document.getElementsByName('df8');
                        document.getElementById("btCod2" + val).style.display = "inline";
                        for (var i = 0; i < buttons.length; i++)
                        {
                            if (buttons[i] != document.getElementById("btCod2" + val))
                            {
                                buttons[i].style.display = "none";
                            }
                        }
                    }
                    function CodBtGr3Show(val)
                    {
                        codGr1();
                        codGr2();
                        var buttons = document.getElementsByName('df12');
                        document.getElementById("btCod3" + val).style.display = "inline";
                        for (var i = 0; i < buttons.length; i++)
                        {
                            if (buttons[i] != document.getElementById("btCod3" + val))
                            {
                                buttons[i].style.display = "none";
                            }
                        }
                    }
                    function loteBtnShowN(val)
                    {
                        var CheckBx = document.getElementsByName('305');
                        document.getElementById("btnLote" + val).style.display = "inline";
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            if (CheckBx[i].value != val)
                            {
                                document.getElementById("btnLote" + CheckBx[i].value).style.display = "none";
                            }
                            $('#bxLote' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[ÑñA-Za-z0-9\s]/;
                                return patron.test(t);
                            });
                            $('#bxProv' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[ÑñA-Za-z0-9\s]/;
                                return patron.test(t);
                            });
                        }
                    }
                    //                    function validarltranum(e) {
                    function matBtnShow(val)
                    {
                        var CheckBx = document.getElementsByName('305');
                        loteBtnHideN();
                        document.getElementById("btnMat" + val).style.display = "inline";
                        for (var i = 0; i < CheckBx.length; i++)
                        {
                            if (CheckBx[i].value != val)
                            {
                                document.getElementById("btnMat" + CheckBx[i].value).style.display = "none";
                            }
                        }
                    }
                    //                    function validarltranum(e) {
                    //                        var te = (document).all ? e.keyCode : e.which;
                    //                        t = String.fromCharCode(te);
                    //                        patron = /[ÑñA-Za-z0-9\s]/;
                    //                        return patron.test(t);
                    //                    }
                    function hideBtnsCld()
                    {
                        codGr1();
                        codGr2();
                        codGr3();
                    }
                    function codGr1()
                    {
                        var CheckBx = document.getElementsByName('defectos');
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            document.getElementById("btCod1" + CheckBx[i].value).style.display = "none";
                        }
                    }
                    function codGr2()
                    {
                        var CheckBx = document.getElementsByName('defectos');
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            document.getElementById("btCod2" + CheckBx[i].value).style.display = "none";
                        }
                    }
                    function codGr3()
                    {
                        var CheckBx = document.getElementsByName('defectos');
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            document.getElementById("btCod3" + CheckBx[i].value).style.display = "none";
                        }
                    }
                    function matchTbl300()
                    {
                        loteBtnHideN();
                        matBtnHide();
                    }
                    function matBtnHide()
                    {
                        var CheckBx = document.getElementsByName('305');
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            document.getElementById("btnMat" + CheckBx[i].value).style.display = "none";
                        }
                    }
                    function loteBtnHideN()
                    {
                        var CheckBx = document.getElementsByName('305');
                        for (i = 0; i < CheckBx.length; i++)
                        {
                            document.getElementById("btnLote" + CheckBx[i].value).style.display = "none";
                            if ($('#bxPrb' + i).val() === "0") {
                                $('#bxPrb' + i).prop("readonly", true);
                            }
                        }
                    }
                    function loteBtnHide(val)
                    {
                        for (i = 0; i < val; i++) {
                            document.getElementById("btnLote" + i).style.display = "none";
                            if ($('#bxPrb' + i).val() === "0") {
                                $('#bxPrb' + i).prop("readonly", true);
                            }
                            $('#bxPrb' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[0-9.]/;
                                return patron.test(t);
                            });
                            $('#bxProv' + i).keypress(function (e) {
                                var te = (document).all ? e.keyCode : e.which;
                                if (te == 32) {
                                    return false;
                                }
                                t = String.fromCharCode(te);
                                patron = /[ÑñA-Za-z0-9\s]/;
                                return patron.test(t);
                            });
                        }
                    }

                    function soloNumeros(e) {
                        var te = (document).all ? e.keyCode : e.which;
                        t = String.fromCharCode(te);
                        patron = /[0-9.]/;
                        return patron.test(t);
                    }
                    function NadaFK(e, id) {
                        var te = (document).all ? e.keyCode : e.which;
                        t = String.fromCharCode(te);
                        patron = /[]/;
                        return patron.test(t);
                    }

                    function MatchLote(val, mat)
                    {
                        mostrarVentana('VentanaModalLote');
                        peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', val, mat);
                        //$("BODY").append('<div id="overlay"></div>');
                        var theHandle = document.getElementById('handle6');
                        var theRoot = document.getElementById('VentanaModalLote');
                        Drag.init(theHandle, theRoot);
                    }
                    function MatchLote300(val)
                    {
                        var mat = document.getElementById("bxMat" + val).value;
                        mostrarVentana('VentanaModalLote');
                        peticiones('PeticionMovMateriales', 'cargarDatosLote', 'VentanaModalLote', 'Lote', val, mat);
                        //$("BODY").append('<div id="overlay"></div>');
                        var theHandle = document.getElementById('handle6');
                        var theRoot = document.getElementById('VentanaModalLote');
                        Drag.init(theHandle, theRoot);
                    }
                    function MatchCod9(val)
                    {
                        mostrarVentana('VentanaModalClaseDefecto');
                        document.getElementById('thPCat').innerHTML = document.getElementById('bxPerfilC').value;
                        peticiones('PeticionMovMateriales', 'cargarDatosClaseDefecto', 'VentanaModalClaseDefecto', 'ClaseDefecto', '', '', val);
                        var theHandle = document.getElementById('handle25');
                        var theRoot = document.getElementById('VentanaModalClaseDefecto');
                        Drag.init(theHandle, theRoot);
                    }
                    function valMt9(e, i, vl)
                    {
                        var tecla = (document.all) ? e.keyCode : e.which;
                        if (tecla == 13)
                        {
                            if (vl === document.getElementById('bxPerfilC').value && document.getElementById('bxPerfilC').value != "") {
                                MatchCod9(i);
                                document.getElementById("msg").innerHTML = "";
                                document.getElementById("iconmsg").style.visibility = "hidden";
                            } else {
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.display = "inline";
                                iconm.style.visibility = "visible";
                                iconm.src = "images/advertencia.PNG";
                                var men = document.getElementById("msg");
                                men.innerHTML = "Grupo códigos " + vl + " contradice los grupos de códigos del perfil de catálogo";
                            }
                            //                                }
                            //                            });

                        }
                    }
                    function MatchCodE(val)
                    {
                        mostrarVentana('VentanaModalClaseDefectoE');
                        document.getElementById('thPCatE').innerHTML = document.getElementById('bxPerfilC').value;
                        peticiones('PeticionMovMateriales', 'cargarDatosClaseDefectoE', 'VentanaModalClaseDefectoE', 'ClaseDefectoE', '', '', val);
                        var theHandle = document.getElementById('handle26');
                        var theRoot = document.getElementById('VentanaModalClaseDefectoE');
                        Drag.init(theHandle, theRoot);
                    }
                    function MatchTexto(v)
                    {
                        mostrarVentana('VentanaModalTexto');
                        document.getElementById('Textlib').value = document.getElementById("Textlib" + v).value;
                        document.getElementById('bxTextoL').value = v;
                        var theHandle = document.getElementById('handle27');
                        var theRoot = document.getElementById('VentanaModalTexto');
                        Drag.init(theHandle, theRoot);
                        document.getElementById('Textlib').focus();
                    }
                    function verificarLotemate(mat) {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=ValidarMaterialLote&matelote=" + mat,
                            success: function (data) {
                                d = data;
                            }
                        });
                        return d.trim();
                    }
                    function TablaCaracteristicas(val, cnt) {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=Cld101&v1=" + val + "&v2=" + cnt,
                            success: function (data) {
                                document.getElementById('SecCuerpoCld').innerHTML = data;
                                AjustarCabecera('TabHead2', 'TabBody2', 8, 'SecCuerpoCld');
                                document.getElementById('DobleContainer').style.height = document.getElementById("TabBody2").offsetHeight + "px";
                                bloquearCamposResul();
                            }
                        });
                    }
                    function TablaDefectos() {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=Defectos",
                            success: function (data) {
                                document.getElementById('SecCuerpoCld2').innerHTML = data;
                                AjustarCabecera('TabHead3', 'TabBody3', 8, 'SecCuerpoCld2');

                            }
                        });
                    }
                    function ObtenerDatos101()
                    {
                        //movimiento
                        var movimiento = document.getElementById('bxClase').value;
                        //inputs
                        var porrc = document.getElementsByName('bx101Prb');
                        var lote = document.getElementsByName('bx101Lote');
                        //                        var nae = document.getElementsByName('bx101Nae');
                        //                        var cean = document.getElementsByName('bx101CEAN');
                        var uean = document.getElementsByName('bx101UEAN');//Unidad Medida
                        var prov = document.getElementsByName('bx101Prov');

                        //td's
                        var cnr = document.getElementsByName('tdCR');//Cantidad Recepcionada
                        var cnp = document.getElementsByName('tdCP');//Cantidad
                        var ped = document.getElementsByName('tdPedido');
                        var pos = document.getElementsByName('tdPos');
                        var mat = document.getElementsByName('tdMaterial');
                        var alm = document.getElementsByName('tdAlmacen');
                        var doc = document.getElementsByName('tdDocCom');
                        var cls = document.getElementsByName('tdClase');
                        var pro = document.getElementsByName('tdProveedor');
                        var txt = document.getElementsByName('tdtxt');
                        var ulc = document.getElementsByName('tdulc');
                        var cec = document.getElementsByName('tdCeCo');
                        var ord = document.getElementsByName('tdOrder');
                        var clc = document.getElementsByName('tdClCoste');
                        var tim = document.getElementsByName("tdTImp"); ////// Imputacion

                        var n1 = 0;
                        var n2 = 0;

                        var registros = 0;

                        switch (movimiento)
                        {
                            case "101":
                                for (i = 0; i < porrc.length; i++)
                                {
                                    n1 = parseFloat(porrc[i].value);
                                    n2 += n1;
                                }
                                if (n2 <= 0.000) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "No existen posiciones listas para su recepción";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }

                                for (i = 0; i < porrc.length; i++)
                                {
                                    if (porrc[i].value.length < 1) {
                                        porrc[i].focus();
                                        invalido("Cantidad Obligatoria no puede ir vacio");
                                        return;
                                    }
                                }
                                for (i = 0; i < porrc.length; i++)
                                {
                                    if (uean[i].value == "") {
                                        uean[i].focus();
                                        invalido("Unidad de Medida Obligatorio");
                                        return;
                                    }
                                }
                                for (i = 0; i < lote.length; i++) {
                                    ValidaMaterialHabilitado(mat[i].textContent);
                                    if (habl === 0) {
                                        var iconm = document.getElementById("iconmsg");
                                        iconm.style.display = "inline";
                                        iconm.style.visibility = "visible";
                                        iconm.src = "images/advertencia.PNG";
                                        var men = document.getElementById("msg");
                                        men.innerHTML = "Material inhabilitado";
                                        porrc[i].focus();
                                        return;
                                    }
                                }
                                for (i = 0; i < porrc.length; i++)
                                {
                                    if (!(porrc[i].value == "0")) {
                                        var tole = GetCantFinal(cnp[i].textContent, uean[i].value, ped[i].textContent, pos[i].textContent);
                                        var pr2 = parseFloat(cnp[i].textContent) + parseFloat(tole);
                                        var ccc = parseFloat(porrc[i].value) + parseFloat(cnr[i].textContent);
                                        if (ccc > pr2) {
                                            var ven = document.getElementById('VentanaModalAv');
                                            var msg = "El Material" + " " + mat[i].textContent + " excede la cantidad de pedido aplicada con tolerancia";
                                            abrirVentanaAv(ven, msg);
                                            var theHandle = document.getElementById("handleAV");
                                            var theRoot = document.getElementById("VentanaModalAv");
                                            Drag.init(theHandle, theRoot);
                                            return;
                                        }
                                    }
                                }
                                for (i = 0; i < lote.length; i++)
                                {
                                    if (tim[i].textContent == "" && !(mat[i].textContent == "")) {
                                        var isDisabled = $('#bxLote' + i).prop('disabled');
                                        if (parseInt(porrc[i].value) !== 0) {
                                            if (isDisabled === false) {
                                                if (lote[i].value === "")
                                                {
                                                    var ven = document.getElementById('VentanaModalAv');
                                                    var msg = "El Material" + " " + mat[i].textContent + " esta sujeto a Lote  <br> el campo lote es obligatorio";
                                                    abrirVentanaAv(ven, msg);
                                                    var theHandle = document.getElementById("handleAV");
                                                    var theRoot = document.getElementById("VentanaModalAv");
                                                    Drag.init(theHandle, theRoot);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }


                                for (i = 0; i < lote.length; i++)
                                {

                                    var pr = parseFloat(porrc[i].value);
                                    var tolera = GetCantend(porrc[i].value, uean[i].value);
                                    if (pr > 0.000) {
                                        registros++;
                                        var extras = "";
                                        if (tim[i].textContent == "" && !(mat[i].textContent == "")) {
                                            extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                                                    "&v3=&v4=" +
                                                    "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                                                    "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                                                    "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                                                    "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                                                    "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                                                    "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                                                    "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=";
                                        }
                                        if (tim[i].textContent == "K") {
                                            if (!(cec[i].textContent == "") || clc[i].textContent == "") {
                                                extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                                                        "&v3=&v4=" +
                                                        "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                                                        "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                                                        "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                                                        "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                                                        "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                                                        "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                                                        "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=";
                                            }
                                        }
                                        if (tim[i].textContent == "F") {
                                            if (!(ord[i].textContent == "")) {
                                                extras = "&v1=" + tolera + "&v2=" + encodeURIComponent(lote[i].value.toUpperCase()) +
                                                        "&v3=&v4=" +
                                                        "&v5=" + uean[i].value + "&v6=" + prov[i].value.toUpperCase() + "&ped=" + ped[i].textContent + "&pos=" + pos[i].textContent +
                                                        "&v7=" + mat[i].textContent + "&v8=" + alm[i].textContent + "&v9=" + doc[i].textContent + "&v10=" + cls[i].textContent +
                                                        "&v11=" + pro[i].textContent + "&v12=" + txt[i].textContent +
                                                        "&v13=" + cnr[i].textContent + "&v14=" + cnp[i].textContent +
                                                        "&v15=" + ulc[i].textContent + "&v16=" + movimiento +
                                                        "&v17=" + cec[i].textContent + "&v18=" + clc[i].textContent +
                                                        "&v19=" + ord[i].textContent + "&v20=" + tim[i].textContent + "&v22=";
                                            }
                                        }
                                        ActualizaTemp('ActualizaTemporal', extras);
                                    }
                                }
                                break;
                            case "102":
                                var porrec = document.getElementsByName("bx102Prb");
                                var claspe = "";
                                var lotepr = "";
                                var tdmateri = document.getElementsByName("tdMaterial102");
                                var tdtxtmat = document.getElementsByName("tdtxt102");
                                var tdalmace = document.getElementsByName("tdAlmacen102");
                                var tdlote = document.getElementsByName("tdLote102");
                                var tdccance = document.getElementsByName("tdCantCa102");
                                var tdccanen = document.getElementsByName("tdCanEnt102");
                                var tdunme = document.getElementsByName("tdUME102");
                                var tdcentr = document.getElementsByName("tdCentro102");
                                var tdfecha = document.getElementsByName("tdFecEnt102");
                                var tdprove = document.getElementsByName("tdNumProv102");
                                var tddocco = document.getElementsByName("tdNumDocCom102");
                                var tdposco = document.getElementsByName("tdPosDoc102");
                                var tdceco = document.getElementsByName("tdCeCo102");
                                var tdorden = document.getElementsByName("tdOrd102");
                                var tdclaco = document.getElementsByName("tdClaCos102");
                                var tdmovim = document.getElementsByName("tdnumMov");
                                var n1 = 0;
                                var n2 = 0;
                                for (i = 0; i < porrec.length; i++) {
                                    n1 = parseInt(porrec[i].value);
                                    n2 += n1
                                }
                                if (n2 === 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "No existen posiciones listas para su recepción";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }
                                for (i = 0; i < porrec.length; i++) {
                                    //                                    var po = 0;
                                    //                                    if(porrec[i].value == ""){
                                    //                                      porrec[i].value == po;  
                                    //                                    }
                                    if (!(parseInt(porrec[i].value) == 0)) {
                                        var cf = (parseFloat(tdccance[i].textContent)) + (parseFloat(porrec[i].value));
                                        if (cf > parseFloat(tdccanen[i].textContent)) {
                                            var ven = document.getElementById('VentanaModalAv');
                                            var msg = "Cantidad Por Devolver mas Cantidad Cancelada, supera <br> a cantidad Entrante  en posición " + tdposco[i].textContent;
                                            abrirVentanaAv(ven, msg);
                                            var theHandle = document.getElementById("handleAV");
                                            var theRoot = document.getElementById("VentanaModalAv");
                                            Drag.init(theHandle, theRoot);
                                            return;
                                        }
                                    }
                                }
                                for (i = 0; i < tddocco.length; i++) {
                                    var pr = parseInt(porrec[i].value);
                                    if (pr !== 0) {
                                        registros++;
                                        var extras = "";
                                        if (tdorden[i].textContent.lentgh > 0 || tdceco[i].textContent.length > 0) {
                                            extras = "&v7=" + tdmateri[i].textContent + "&v12=" + tdtxtmat[i].textContent +
                                                    "&v8=" + tdalmace[i].textContent + "&v2=" + tdlote[i].textContent +
                                                    "&v1=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v14=" + tdccanen[i].textContent +
                                                    "&v5=" + tdunme[i].textContent + "&v22=" + tdcentr[i].textContent +
                                                    "&v13=" + tdccance[i].textContent + "&v3=" + tdmovim[i].textContent +
                                                    "&v21=" + tdfecha[i].textContent + "&v16=" + movimiento + "&v9=" + "&v11=" + tdprove[i].textContent + "&ped=" + tddocco[i].textContent +
                                                    "&pos=" + tdposco[i].textContent + "&v17=" + tdceco[i].textContent +
                                                    "&v19=" + tdorden[i].textContent + "&v18=" + tdclaco[i].textContent + "&v20=" + "&v15=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v6=" + lotepr + "&v10=" + claspe;
                                        } else {
                                            extras = "&v7=" + tdmateri[i].textContent + "&v12=" + tdtxtmat[i].textContent +
                                                    "&v8=" + tdalmace[i].textContent + "&v2=" + tdlote[i].textContent +
                                                    "&v1=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v14=" + tdccanen[i].textContent +
                                                    "&v5=" + tdunme[i].textContent + "&v22=" + tdcentr[i].textContent +
                                                    "&v13=" + tdccance[i].textContent + "&v3=" + tdmovim[i].textContent +
                                                    "&v21=" + tdfecha[i].textContent + "&v16=" + movimiento + "&v9=" + "&v11=" + tdprove[i].textContent + "&ped=" + tddocco[i].textContent +
                                                    "&pos=" + tdposco[i].textContent + "&v17=" + tdceco[i].textContent +
                                                    "&v19=" + tdorden[i].textContent + "&v18=" + tdclaco[i].textContent + "&v20=V" + "&v15=" + GetCantend(porrec[i].value, tdunme[i].textContent) + "&v6=" + lotepr + "&v10=" + claspe;
                                        }
                                        ActualizaTemp('ActualizaTemporal', extras);
                                    }
                                }
                                break;
                        }
                        setTimeout(function () {
                            verificarRegistros101('VerificarRegistros', registros, movimiento);
                        }, 2000);
                    }

                    function verificarRegistrosRG(action, cantidad, movimiento)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 0) {
                                    GuardarMovimientos("VaciarTemporal", "");
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Error de conexión";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    LimpiarPpal("LimpiarPpal");
                                } else {
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.display = "none";
                                    iconm.style.visibility = "hidden";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "";
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Posición añadida correctamente";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    ocultarVentana('VentanaRG', 'btnAdd');
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + "&v1=" + cantidad + "&v2=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function verificarRegistros305(action, cantidad, movimiento)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 0) {
                                    GuardarMovimientos("VaciarTemporal", "");
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Error de conexión";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    LimpiarPpal("LimpiarPpal");
                                } else {
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.display = "none";
                                    iconm.style.visibility = "hidden";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "";
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Posición añadida correctamente";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    ocultarVentana('VentanaModal305', 'btnAdd');
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + "&v1=" + cantidad + "&v2=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function verificarRegistros101(action, cantidad, movimiento)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 0) {
                                    GuardarMovimientos("VaciarTemporal", "");
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Error de conexión";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    LimpiarPpal("LimpiarPpal");
                                } else {
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.display = "none";
                                    iconm.style.visibility = "hidden";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "";
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Lineas adoptadas para su recepción";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    ocultarVentana('VentanaModal101', 'btnAdd');
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + "&v1=" + cantidad + "&v2=" + movimiento, true);
                        xmlhttp.send();
                    }
                    function ActualizaTemp(action, extras)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("SecTabPpal").innerHTML = xmlhttp.responseText;
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }
                    function GuardarTemporal(action, extras)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }
                    function VerificarRegistros()
                    {
                        var CheckBx = document.getElementsByName('Pedidos');

                        for (var i = 0; i < CheckBx.length; i++) {
                            if (CheckBx[i].checked)
                            {
                                EliminaTemporal(CheckBx[i].value);
                            }
                        }
                    }
                    function EliminaTemporal(val)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        var mov = document.getElementById('bxClase').value;
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                document.getElementById("SecTabPpal").innerHTML = xmlhttp.responseText;
                                actcm();
                                acttm();
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=EliminaTemporal&ped=" + val + "&mov=" + mov, true);
                        xmlhttp.send();
                    }
                    function Verificar305()
                    {
                        var CheckBx = document.getElementsByName('305');
                        if (CheckBx.length > 1) {
                            for (var i = 0; i < CheckBx.length; i++)
                            {
                                if (CheckBx[i].checked)
                                {
                                    document.getElementById("TabBody").deleteRow(i);
                                    Verificar305();
                                }
                            }
                        }
                    }
                    function EliminaCld()
                    {
                        var CheckBx = document.getElementsByName('defectos');
                        if (CheckBx.length > 1) {
                            for (var i = 0; i < CheckBx.length; i++)
                            {
                                if (CheckBx[i].checked)
                                {
                                    document.getElementById("TabBody3").deleteRow(i);
                                    EliminaCld();
                                }
                            }
                        }
                    }
                    function validarFecha() {
                        var fecha = document.getElementById("bxFecha").value;
                        var f = fecha.split(".");
                        var d = f[0];
                        var m = f[1];
                        var y = f[2];
                        var f1 = new Date(y, m, d);
                        var date = new Date();
                        var d1 = checkTime(date.getDate());
                        var m1 = checkTime(date.getMonth() + 1);
                        var y1 = date.getFullYear();
                        var f2 = new Date(y1, m1, d1);
                        if (f2 > f1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                    function dataxxxx() {
                        document.getElementById('VentanaModalCalidad').style.display = 'none';
                        if (document.getElementById('bxClase').value === "101" || document.getElementById('bxClase').value === "303") {
                            abrirVentanaMsgAddFile();
                        } else {
                            MovimientosMO();
                        }
                    }
                    function MovimientosMO()
                    {
                        if (gg < 1)
                        {
                            gg++;
                            //Cabecera
                            var al;
                            var centro = document.getElementById('bxCentro').value.toUpperCase();
                            var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                            var fecha = document.getElementById('bxFecha').value;
                            var tmov = document.getElementById('bxClase').value;
                            var texto = document.getElementById('bxTexto').value;
                            var nota = document.getElementById('bxNota').value;
                            var carta = document.getElementById('bxCarta').value;

                            var lote = document.getElementsByName('mmnlt');
                            var cantidad = document.getElementsByName('mmprr');//Por recibir
                            var Descripc = document.getElementsByName('mmdsc');
                            var material = document.getElementsByName('mmmat');
                            var pedido = document.getElementsByName('mmped');
                            var posicion = document.getElementsByName('mmnpe');
                            var tabix = document.getElementsByName('mmidx');
                            var ultima = document.getElementsByName('mmuct');
                            var almDes = document.getElementsByName('mmalm');
                            var cdes = document.getElementsByName('mmctr');
                            var unmms = document.getElementsByName('mmumb');
                            var almpe = document.getElementsByName('mmalmped');

                            //                        var tab = document.getElementsByName("Pedidos");
                            //                        if (tab.length == 0) {
                            //                            var ven = document.getElementById('VentanaModalAv');
                            //                            var msg = "Error: Sin Movimientos";
                            //                            abrirVentanaAv(ven, msg);
                            //                            return;
                            //                        }

                            var cad = "";
                            var extra = "&v1=" + centro + "&v2=" + almacen + "&v3=" + fecha + "&v4=" + tmov +
                                    "&v5=" + encodeURIComponent(texto) + "&v6=" + encodeURIComponent(nota) +
                                    "&v7=" + encodeURIComponent(carta) + "&v8=" + cad;
                            var tt = "Guarda" + tmov + "Cabecera";
                            switch (tmov)
                            {
                                case "101":
                                    //                                    saveDatos101();
                                    GestionLoteInsp(0);
                                    //                                var tim = document.getElementsByName('mmtimp');
                                    //                                var extrass = "&v1=";
                                    //                                for (i = 0; i < lote.length; i++)
                                    //                                {
                                    //                                    if (tim[i].textContent == "") {
                                    //                                        tim[i].textContent = "V";
                                    //                                    }
                                    //
                                    //                                    extrass += lote[i].textContent.toUpperCase() + "," + cantidad[i].textContent +
                                    //                                            "," + material[i].textContent + "," + centro +
                                    //                                            "," + almacen + "," + tim[i].textContent + ",";
                                    //                                }
                                    //                                extrass = extrass.substring(0, extrass.length - 1);
                                    //                                extrass += "&v2=" + lote.length;
                                    //                                Lote101(extrass, tt, extra, cad);
                                    break;
                                case "102":
                                    var tim1 = document.getElementsByName('mmtimp');
                                    var extrass = "&v1=";
                                    for (i = 0; i < pedido.length; i++) {
                                        extrass += fecha + "," + tmov +
                                                "," + lote[i].textContent + "," + cantidad[i].textContent + "," + Descripc[i].textContent + "," + material[i].textContent + "," + pedido[i].textContent + "," + posicion[i].textContent + "," + tabix[i].textContent + "," + tim1[i].textContent +
                                                "," + centro + "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + pedido.length;
                                    Lote102(extrass, tt, extra, cad);
                                    break;
                                case "201":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote201(extrass, tt, extra, cad, 'Movimiento201');
                                    break;
                                case "202":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote201(extrass, tt, extra, cad, 'Lote202Posiciones');
                                    break;
                                case "261":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote261(extrass, tt, extra, cad, "Movimiento261");
                                    break;
                                case "262":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote261(extrass, tt, extra, cad, 'Lote262Posiciones');
                                    break;
                                case "303":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + "," + cdes[i].textContent + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote300(extrass, tt, extra, cad, 'Movimiento303');
                                    break;
                                case "305":
                                    var extrass = "&v1=";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + "," + cdes[i].textContent + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length;
                                    Lote300(extrass, tt, extra, cad, 'Movimiento305');
                                    break;
                                case "311":
                                    var extrass = "&v1=";
                                    var lang = "<%=Idioma%>";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almacen + "," + almDes[i].textContent + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length + "&v3=" + tmov + "&v4=" + lang;
                                    Lote311(extrass, tt, extra, cad);
                                    break;
                                case "312":
                                    var extrass = "&v1=";
                                    var lang = "<%=Idioma%>";
                                    for (i = 0; i < lote.length; i++)
                                    {
                                        extrass += lote[i].textContent + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                                "," + almDes[i].textContent + "," + almacen + ",";
                                    }
                                    extrass = extrass.substring(0, extrass.length - 1);
                                    extrass += "&v2=" + lote.length + "&v3=" + tmov + "&v4=" + lang;
                                    Lote311(extrass, tt, extra, cad);
                                    break;
                            }

                        }
                    }
                    function Lote261(extrass, tt, extra, cad, action)//NuevoLalo
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;
                        var alm = document.getElementById('bxAlmacen').value.toUpperCase();
                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var tabix = document.getElementsByName('mmidx');
                        var orden = document.getElementsByName('mmnord');
                        var unmms = document.getElementsByName('mmumb');

                        var actt = "Guarda" + tmov + "Posiciones";
                        for (i = 0; i < lote.length; i++)
                        {
                            var rsv_, pos_;
                            try {
                                rsv_ = document.getElementById('txtrsv').value;
                                pos_ = document.getElementsByName('mmPosR')[i].textContent;
                            } catch (err) {
                                rsv_ = "";
                                pos_ = "";
                            }
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + cad + "&v8=" + tabix[i].textContent + "&v9=" + centro +
                                    "&v10=" + orden[i].textContent + "&v11=" + unmms[i].textContent +
                                    "&v12=" + alm + "&v13=" + rsv_ + "&v14=" + pos_;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length, action);
                        }, 2000);
                    }
                    function Lote300(extrass, tt, extra, cad, action)//NuevoLalo
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;
                        var alm = document.getElementById('bxAlmacen').value.toUpperCase();

                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var tabix = document.getElementsByName('mmidx');
                        var cdes = document.getElementsByName('mmctr');
                        var unmms = document.getElementsByName('mmumb');

                        var actt = "Guarda" + tmov + "Posiciones";
                        for (i = 0; i < lote.length; i++)
                        {
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + cad + "&v8=" + tabix[i].textContent + "&v9=" + centro +
                                    "&v10=" + cdes[i].textContent + "&v11=" + unmms[i].textContent +
                                    "&v12=" + alm;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length, action);
                        }, 2000);
                    }
                    function Lote311(extrass, tt, extra, cad)//NuevoLalo
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var alm = document.getElementById('bxAlmacen').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;
                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var tabix = document.getElementsByName('mmidx');
                        var almdes = document.getElementsByName('mmalm');
                        var unmms = document.getElementsByName('mmumb');

                        var actt = "Guarda" + tmov + "Posiciones";
                        for (i = 0; i < lote.length; i++)
                        {
                            var rsv_, pos_;
                            try {
                                rsv_ = document.getElementById('txtrsv').value;
                                pos_ = document.getElementsByName('mmPosR')[i].textContent;
                            } catch (err) {
                                rsv_ = "";
                                pos_ = "";
                            }
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + cad + "&v8=" + tabix[i].textContent + "&v9=" + centro +
                                    "&v10=" + almdes[i].textContent + "&v11=" + unmms[i].textContent +
                                    "&v12=" + alm + "&v13=" + rsv_ + "&v14=" + pos_;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length);
                        }, 2000);
                    }
//                    function Lote311(extrass, tt, extra, cad)//NuevoLalo
//                    {
//                        var centro = document.getElementById('bxCentro').value.toUpperCase();
//                        var alm = document.getElementById('bxAlmacen').value.toUpperCase();
//                        var fecha = document.getElementById('bxFecha').value;
//                        var tmov = document.getElementById('bxClase').value;
//
//                        var lote = document.getElementsByName('mmnlt');
//                        var cantidad = document.getElementsByName('mmprr');//Por recibir
//                        var Descripc = document.getElementsByName('mmdsc');
//                        var material = document.getElementsByName('mmmat');
//                        var tabix = document.getElementsByName('mmidx');
//                        var almdes = document.getElementsByName('mmalm');
//                        var unmms = document.getElementsByName('mmumb');
//
//                        var xmlhttp = new XMLHttpRequest();
//                        xmlhttp.onreadystatechange = function () {
//                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
//                            {
//                                var arr = new Array();
//                                arr = xmlhttp.responseText.split(",");
//
//                                if (arr[0] == 1)
//                                {
//                                    var ven = document.getElementById('VentanaModalAv');
//                                    var msg = "Los datos son erroneos";
//                                    abrirVentanaAv(ven, msg);
//                                    var men = document.getElementById("msg");
//                                    men.innerHTML = "Error en la contabilización del movimiento";
//                                    gg = 0;
//                                } else
//                                {
//                                    if (arr[1].trim() != "") {
//                                        alert(arr[1]);
//                                    }
//                                    //                                    if (tmov === "311" && arr[1].trim() != "") {
//                                    //                                        alert(arr[1]);
//                                    //                                    }
//                                    GuardarMovimientos(tt, extra);
//                                    var actt = "Guarda" + tmov + "Posiciones";
//                                    for (i = 0; i < lote.length; i++)
//                                    {
//                                        var rsv_, pos_;
//                                        try {
//                                            rsv_ = document.getElementById('txtrsv').value;
//                                            pos_ = document.getElementsByName('mmPosR')[i].textContent;
//                                        } catch (err) {
//                                            rsv_ = "";
//                                            pos_ = "";
//                                        }
//                                        var extras = "&v1=" + fecha + "&v2=" + tmov +
//                                                "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
//                                                "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
//                                                "&v7=" + cad + "&v8=" + tabix[i].textContent + "&v9=" + centro +
//                                                "&v10=" + almdes[i].textContent + "&v11=" + unmms[i].textContent +
//                                                "&v12=" + alm + "&v13=" + rsv_ + "&v14=" + pos_;
//                                        GuardarMovimientos(actt, extras);
//                                    }
//                                    ActualizaFolio();
//                                }
//                            }
//                        };
//                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=Movimiento311" + extrass, true);
//                        xmlhttp.send();
//                    }
                    function Lote101(extrass, tt, extra, cad)//NuevoLalo
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;

                        var lotePro = document.getElementsByName('mmLoteProvd');
                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var tabix = document.getElementsByName('mmidx');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var ultima = document.getElementsByName('mmuct');
                        var unmms = document.getElementsByName('mmumb');
                        var cencos = document.getElementsByName('mmcec');
                        var orden = document.getElementsByName('mmnord');
                        var ClCost = document.getElementsByName('mmclco');
                        var almpe = document.getElementsByName('mmalmped');
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var al;
                        var actt = "Guarda" + tmov + "Posiciones";

                        for (i = 0; i < lote.length; i++)
                        {
                            //                                        if (almpe[i].textContent == "") {
                            //                                            al = almacen;
                            //                                        } else {
                            //                                            al = almpe[i].textContent;
                            //                                        }
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + encodeURIComponent(lote[i].textContent.toUpperCase()) + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                    "&v9=" + cad + "&v10=" + tabix[i].textContent + "&v11=" + ultima[i].textContent +
                                    "&v12=" + centro + "&v13=" + unmms[i].textContent + "&v14=" + cencos[i].textContent +
                                    "&v15=" + ClCost[i].textContent + "&v16=" + orden[i].textContent + "&v17=" + almacen + "&v18=" + lotePro[i].textContent;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length);
                        }, 2000);

                    }


                    function Lote201(extrass, tt, extra, cad, action)//NuevoLalo
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;
                        var alm = document.getElementById('bxAlmacen').value.toUpperCase();

                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var tabix = document.getElementsByName('mmidx');
                        var cecos = document.getElementsByName('mmcec');
                        var unmms = document.getElementsByName('mmumb');

                        var actt = "Guarda" + tmov + "Posiciones";
                        var rsv_, pos_;
                        for (i = 0; i < lote.length; i++)
                        {
                            try {
                                rsv_ = document.getElementById('txtrsv').value;
                                pos_ = document.getElementsByName('mmPosR')[i].textContent;
                            } catch (err) {
                                rsv_ = "";
                                pos_ = "";
                            }
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + cad + "&v8=" + tabix[i].textContent + "&v9=" + centro +
                                    "&v10=" + cecos[i].textContent + "&v11=" + unmms[i].textContent +
                                    "&v12=" + alm + "&v13=" + rsv_ + "&v14=" + pos_;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length, action);
                        }, 2000);
                    }
                    function Lote102(extrass, tt, extra, cad)
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;

                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var tabix = document.getElementsByName('mmidx');
                        var ultima = document.getElementsByName('mmuct');
                        var unmms = document.getElementsByName('mmumb');
                        var folim = document.getElementsByName('mmmovim');
                        var posmo = document.getElementsByName('tdPosMov');
                        var cantc = document.getElementsByName('mmcnt');


                        var actt = "Guarda" + tmov + "Posiciones";
                        for (i = 0; i < lote.length; i++)
                        {
                            var extras = "&v1=" + fecha + "&v2=" + tmov +
                                    "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v5=" + Descripc[i].textContent + "&v6=" + material[i].textContent +
                                    "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                    "&v9=" + cad + "&v10=" + tabix[i].textContent + "&v11=" + ultima[i].textContent +
                                    "&v12=" + centro + "&v13=" + unmms[i].textContent + "&v14=" + folim[i].textContent +
                                    "&v15=" + cantc[i].textContent + "&v16=" + almacen + "&v17=" + posmo[i].textContent;
                            GuardarMovimientos(actt, extras);
                        }
                        setTimeout(function () {
                            GuardarMovimientos(tt, extra, extrass, lote.length);
                        }, 2000);
                    }

                    function VerificaLote()
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var tmov = document.getElementById('bxClase').value;

                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var material = document.getElementsByName('mmmat');

                        var acct = "Lote" + tmov + "Posiciones";
                        for (i = 0; i < lote.length; i++)
                        {
                            var extrass = "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                    "&v6=" + material[i].textContent + "&v12=" + centro + "&v13=" + almacen;
                            GuardarMovimientos(acct, extrass);
                        }

                    }
                    function GuardarMovimientos(action, extras, extrass, c, acc)
                    {
                        var cantidad = document.getElementsByName('mmprr');
                        var ultima = document.getElementsByName('mmuct');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var lote = document.getElementsByName('mmnlt');
                        var folim = document.getElementsByName('mmmovim');
                        var cantc = document.getElementsByName('mmcnt');
                        var mov = document.getElementById('bxClase').value;

                        extras += "&v19=" + c;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1) {
                                    switch (mov) {
                                        case "101":
                                            Guarda101(extrass);
                                            break;
                                        case "102":
                                            Guarda102(extrass);
                                            break;
                                        case "201":
                                        case "202":
                                            Guarda200(extrass, acc);
                                            break;
                                        case "261":
                                        case "262":
                                            Guarda260(extrass, acc);
                                            break;
                                        case "303":
                                        case "305":
                                            Guarda300(extrass, acc);
                                            break;
                                        case "311":
                                            Guarda310(extrass, acc);
                                            break;
                                    }
                                }
                                if (xmlhttp.responseText == 2) {
                                    gg = 0;
                                    $("#guardar").prop("disabled", false);
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Problemas de Conexión";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la Red";
                                    switch (mov) {
                                        case "101":
                                            for (var i = 0; i < ultima.length; i++) {
                                                var ex = "&v1=" + ultima[i].textContent + "&v2=" + cantidad[i].textContent +
                                                        "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                                        "&v3=" + encodeURIComponent(lote[i].textContent.toUpperCase());
                                                RetrocesoMov("retrocesoMov101", ex);
                                            }
                                            break;
                                        case "102":
                                            for (i = 0; i < lote.length; i++)
                                            {
                                                var ex = "&v3=" + lote[i].textContent + "&v4=" + cantidad[i].textContent +
                                                        "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                                        "&v14=" + folim[i].textContent + "&v15=" + cantc[i].textContent;
                                                RetrocesoMov("retrocesoMov102", ex);
                                            }
                                            break;
                                    }
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();
                    }
                    function Guarda310(extrass) {
                        var dtrer = "Action=Movimiento311" + extrass;
                        $.ajax({
                            beforeSend: function () {
                                $("button").prop("disabled", true);
                                $("input").prop("disabled", true);
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.display = "inline";
                                iconm.style.visibility = "visible";
                                iconm.src = "images/load.gif";
                                var men = document.getElementById("msg");
                                men.innerHTML = "Espere un momento por favor......";
                            },
                            type: 'GET',
                            url: 'PeticionGuardaMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: dtrer,
                            success: function (data) {
                                var arr = new Array();
                                arr = data.split(",");

                                if (arr[0] == 1)
                                {
                                    $("input").prop("disabled", false);
                                    $("button").prop("disabled", false);
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Los datos son erroneos";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    gg = 0;
                                    RetrocesoMov("BorraCabPos");
                                } else
                                {
                                    ActualizaFolio();
                                }

                            },
                            error: function (xhr, status) {
                                $("input").prop("disabled", false);
                                $("button").prop("disabled", false);
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.display = "inline";
                                iconm.style.visibility = "visible";
                                iconm.src = "images/advertencia.PNG";
                                var men = document.getElementById("msg");
                                men.innerHTML = "Error de respuesta";
                            }
                        });
                    }
                    function Guarda300(extrass, action) {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Los datos son erroneos";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    gg = 0;
                                    ocultarVentana('VentanaModalCalidad', '');
                                    RetrocesoMov("BorraCabPos");
                                } else
                                {
                                    llenaCalidad();
                                    insertarCabLotInsp();
                                    insertarPosLotIns();
                                    ActualizaFolio();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extrass, true);
                        xmlhttp.send();
                    }
                    function Guarda260(extrass, action) {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Material Insuficiente";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    gg = 0;
                                    RetrocesoMov("BorraCabPos");
                                } else
                                {
                                    ActualizaFolio();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extrass, true);
                        xmlhttp.send();
                    }
                    function Guarda200(extrass, action) {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Material Insuficiente";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    gg = 0;
                                    RetrocesoMov("BorraCabPos");
                                } else
                                {
                                    ActualizaFolio();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + extrass, true);
                        xmlhttp.send();
                    }
                    function Guarda102(extrass) {
                        var cantidad = document.getElementsByName('mmprr');
                        var ultima = document.getElementsByName('mmuct');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var lote = document.getElementsByName('mmnlt');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Los datos son erroneos \n Cantidad excedida en stock";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    for (var i = 0; i < ultima.length; i++) {
                                        var ex = "&v1=" + ultima[i].textContent + "&v2=" + cantidad[i].textContent +
                                                "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                                "&v3=" + encodeURIComponent(lote[i].textContent.toUpperCase());
                                        RetrocesoMov("retrocesoMov102", ex);
                                    }
                                } else
                                {
                                    ActualizaFolio();
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=Movimiento102" + extrass, true);
                        xmlhttp.send();
                    }
                    function Guarda101(extrass) {
                        var cantidad = document.getElementsByName('mmprr');
                        var ultima = document.getElementsByName('mmuct');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var lote = document.getElementsByName('mmnlt');
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 1)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Los datos son erroneos";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Error en la contabilización del movimiento";
                                    ocultarVentana('VentanaModalCalidad', '');
                                    for (var i = 0; i < ultima.length; i++) {
                                        var ex = "&v1=" + ultima[i].textContent + "&v2=" + cantidad[i].textContent +
                                                "&v7=" + pedido[i].textContent + "&v8=" + posicion[i].textContent +
                                                "&v3=" + encodeURIComponent(lote[i].textContent.toUpperCase());
                                        RetrocesoMov("retrocesoMov101", ex);
                                    }
                                } else
                                {
                                    llenaCalidad();
                                    insertarCabLotInsp();
                                    insertarPosLotIns();
                                    ActualizaFolio();
                                }
                            }

                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=Lote101Posiciones" + extrass, true);
                        xmlhttp.send();
                    }
                    function RetrocesoMov(action, ex)
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=" + action + ex, true);
                        xmlhttp.send();
                    }
                    function clickParaGenteDesesperada() {
                        cgd = 0;
                    }
                    function ActualizaFolio()
                    {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var men = "Documento Contabilizado MO" + xmlhttp.responseText;
                                window.location.href = "MovimientoMateriales.jsp?FolioMO=" + men;
                            }
                        };
                        xmlhttp.open("GET", "PeticionGuardaMovMateriales?Action=ActualizarFolio", true);
                        xmlhttp.send();
                    }
                    function validaDefectos(pos)
                    {
                        var n = document.getElementsByName('df1');
                        var e = document.getElementsByName('df7');

                        var d3 = document.getElementsByName('df3');
                        var d4 = document.getElementsByName('df4');
                        var d5 = document.getElementsByName('df5');
                        var d6 = document.getElementsByName('df6');
                        var d9 = document.getElementsByName('df9');
                        var d10 = document.getElementsByName('df10');
                        var d11 = document.getElementsByName('df11');

                        var cadena = "";
                        for (i = 0; i < n.length; i++)
                        {
                            cadena += n[i].value + e[i].value;
                        }
                        if (cadena === "")
                        {
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.display = "inline";
                            iconm.style.visibility = "visible";
                            iconm.src = "images/aceptar.png";
                            var men = document.getElementById("msg");
                            men.innerHTML = "No es necesario grabar";
                            return;
                        }

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=validaGrCod9&v1=" + n[pos].value + "&v2=" + e[pos].value,
                            success: function (data) {
                                var temp = new Array();
                                temp = data.split("|");
                                if (temp[0] == 0 || temp[1] == 0)
                                {
                                    var vl = "";
                                    if (temp[0] == 0) {
                                        vl = n[pos].value;
                                    }
                                    if (temp[1] == 0) {
                                        vl = e[pos].value;
                                    }
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.display = "inline";
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/advertencia.PNG";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "Grupo códigos " + vl + " contradice los grupos de códigos del perfil de catálogo";
                                } else {
                                    pos++;
                                    if (pos < n.length) {
                                        validaDefectos(pos);
                                    } else
                                    {
                                        guardarDefCabeceraTmp();
                                        for (var g = 0; g < e.length; g++)
                                        {
                                            var defArr = new Array();
                                            defArr[0] = n[g].value;
                                            defArr[1] = d3[g].value;
                                            defArr[2] = d4[g].value;
                                            defArr[3] = d5[g].value;
                                            defArr[4] = d6[g].value;
                                            defArr[5] = e[g].value;
                                            defArr[6] = d9[g].value;
                                            defArr[7] = d10[g].value;
                                            defArr[8] = d11[g].value;
                                            defArr[9] = g + 1;
                                            guardarDefectosTemp(defArr);
                                        }
                                        guardaDefTxt();
                                        hideBtnsCld();
                                        document.getElementById('btnGrabarD').disabled = true;
                                        $("#SecCuerpoCld2").find(":text").prop('disabled', true);
                                        $("#btnCld3").prop('disabled', true);
                                        $("#btnCld4").prop('disabled', true);
                                        var iconm = document.getElementById("iconmsg");
                                        iconm.style.display = "inline";
                                        iconm.style.visibility = "visible";
                                        iconm.src = "images/aceptar.png";
                                        var men = document.getElementById("msg");
                                        men.innerHTML = "Se graban los datos de defectos p. lote de insp. QM" + document.getElementById('bxLoteInspCal').value;
                                    }
                                }
                            }
                        });

                    }
                    function guardaDefTxt()
                    {
                        var txt = document.getElementsByName('df13');
                        var loteI = document.getElementById('bxLoteInspCal').value;

                        for (var i = 0; i < txt.length; i++)
                        {
                            var c = 132;
                            var cc = 1;
                            for (var x = 0; x < txt[i].value.length; x += 132)
                            {
                                var txtArr = new Array();
                                txtArr[0] = loteI;
                                txtArr[1] = parseInt(i + 1);
                                txtArr[2] = cc;
                                txtArr[3] = txt[i].value.substring(x, c);
                                grabaTextoDefectos(txtArr);
                                c += 132;
                                cc++;
                            }
                        }
                    }
                    function grabaTextoDefectos(txtArr)
                    {
                        var table = document.getElementById("TablaTmpDefTxt");
                        var row = table.insertRow(table.rows.length);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        cell1.innerHTML = txtArr[0];
                        cell2.innerHTML = txtArr[1];
                        cell3.innerHTML = txtArr[2];
                        cell4.innerHTML = txtArr[3];
                    }
                    function guardarDefCabeceraTmp()
                    {
                        var loteI = document.getElementById('bxLoteInspCal').value;
                        var ctr = document.getElementById('bxCentro').value;
                        var mat = document.getElementById('bxMatC').value;
                        var ped = document.getElementsByName('mmped');
                        var clI = document.getElementById('bxClsInf').value;
                        var lbI = document.getElementById('lblClsInf').innerHTML;
                        var pfC = document.getElementById('bxPerfilC').value;
                        var lbP = document.getElementById('lblPerCat').innerHTML;
                        var usr = document.getElementById('numInsp').innerHTML;
                        var table = document.getElementById("TablaTmpDefCab");
                        var row = table.insertRow(table.rows.length);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        var cell5 = row.insertCell(4);
                        var cell6 = row.insertCell(5);
                        var cell7 = row.insertCell(6);
                        var cell8 = row.insertCell(7);
                        var cell9 = row.insertCell(8);

                        cell1.innerHTML = loteI;
                        cell2.innerHTML = ctr.toUpperCase();
                        cell3.innerHTML = mat;
                        cell4.innerHTML = ped[0].textContent;
                        cell5.innerHTML = clI;
                        cell6.innerHTML = lbI;
                        cell7.innerHTML = pfC;
                        cell8.innerHTML = lbP;
                        cell9.innerHTML = usr;
                    }
                    function guardarDefCabecera(arCb)
                    {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionGuardaMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=DefectosCalidadCabecera&v1=" + arCb[0] + "&v2=" + arCb[1]
                                    + "&v3=" + arCb[2] + "&v4=" + arCb[3] + "&v5=" + arCb[4]
                                    + "&v6=" + arCb[5] + "&v7=" + arCb[6] + "&v8=" + arCb[7] + "&v9=" + arCb[8],
                            success: function (data) {

                            }
                        });
                    }
                    function guardarDefectosTemp(DfArray)
                    {
                        var loteI = document.getElementById('bxLoteInspCal').value;
                        var table = document.getElementById("TablaTmpDefPos");
                        var row = table.insertRow(table.rows.length);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        var cell5 = row.insertCell(4);
                        var cell6 = row.insertCell(5);
                        var cell7 = row.insertCell(6);
                        var cell8 = row.insertCell(7);
                        var cell9 = row.insertCell(8);
                        var cell10 = row.insertCell(9);
                        var cell11 = row.insertCell(10);

                        cell1.innerHTML = DfArray[0];
                        cell2.innerHTML = DfArray[1];
                        cell3.innerHTML = DfArray[2];
                        cell4.innerHTML = DfArray[3];
                        cell5.innerHTML = DfArray[4];
                        cell6.innerHTML = DfArray[5];
                        cell7.innerHTML = DfArray[6];
                        cell8.innerHTML = DfArray[7];
                        cell9.innerHTML = DfArray[8];
                        cell10.innerHTML = DfArray[9];
                        cell11.innerHTML = loteI;
                    }
                    function guardarDefectos(DfArray)
                    {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionGuardaMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=DefectosCalidadPosiciones&v1=" + DfArray[0] + "&v2=" + DfArray[1]
                                    + "&v3=" + DfArray[2] + "&v4=" + DfArray[3] + "&v5=" + DfArray[4]
                                    + "&v6=" + DfArray[5] + "&v7=" + DfArray[6] + "&v8=" + DfArray[7]
                                    + "&v9=" + DfArray[8] + "&v10=" + DfArray[9] + "&v11=" + DfArray[10],
                            success: function (data) {

                            }
                        });
                    }
                    function guardarDefTxt(arrTx)
                    {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionGuardaMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=DefectosCalidadTexto&v1=" + arrTx[0] + "&v2=" + arrTx[1]
                                    + "&v3=" + arrTx[2] + "&v4=" + arrTx[3],
                            success: function (data) {

                            }
                        });
                    }
                    function MostrarFolio()
                    {
                        var men = document.getElementById("msg");
                        var fol = "<%=Folio%>";
                        if (fol != "null") {
                            men.innerHTML = "<%=Folio%>";
                        }
                    }
                    function tratarReserva() {
                        //                            var centro = document.getElementById('bxCentro').value;
                        //                            var almacen = document.getElementById('bxAlmacen').value;
                        //                            var clase = document.getElementById('bxClase').value;
                        //                            var texto = document.getElementById('bxTexto').value;
                        //                            var nota = document.getElementById('bxNota').value;
                        //                            var carta = document.getElementById('bxCarta').value;
                        //                            var reserv = document.getElementById('bxReserva').value;
                        var temp = new Array();
                        temp[0] = document.getElementById('bxCentro');
                        temp[1] = document.getElementById('bxAlmacen');
                        temp[2] = document.getElementById('bxClase');
                        temp[3] = document.getElementById('bxReserva');
                        temp[4] = document.getElementById('bxTexto');
                        for (i = 0; i < temp.length; i++)
                        {
                            if (temp[i].value.length === 0)
                            {
                                invalidoAd("<%=CampoOb%>");
                                temp[i].focus();
                                return;
                            }
                        }
                        validarDatosRes(temp);
                    }
                    var vr;
                    function validarDatosRes(temp) {
                        extras = "&v1=" + temp[0].value.toUpperCase() + "&v2=" + temp[1].value.toUpperCase() + "&v3=" + temp[2].value + "&v4=" + temp[3].value;
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=ValidarCamposReservas" + extras, success: function (data) {
                                var res = new Array();
                                res = data.split("|");
                                var ce = res[0];//Centro
                                var al = res[1];//Almacen
                                var cm = res[2];//Clase movimiento
                                var rs = res[3];//Reserva
                                var er = res[4];//Error
                                vr = res[5];
                                if (ce == 0) {
                                    temp[0].focus();
                                    invalR();
                                    return;
                                }
                                if (al == 0) {
                                    temp[1].focus();
                                    invalR();
                                    return;
                                }
                                if (cm == 0) {
                                    temp[2].focus();
                                    invalR();
                                    return;
                                }
                                if (rs == 0) {
                                    temp[3].focus();
                                    invalR();
                                    return;
                                }
                                if (er == 1) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "La reserva contiene error y no se puede tratar";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }
                                if (vr == 0) {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Sin Posiciones no aptas para su procesamiento.";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                    return;
                                }
                                nr = res[6];
                                fl = res[7];
                                cl = res[8];
                                TomarPosiciones();
                            }
                        });
                    }
                    function TomarPosiciones() {
                        var lang = "<%=Idioma%>";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=CargarPosicionReserva" + "&q=" + vr + "&v1=" + nr + "&v2=" + fl + "&v3=" + cl + "&lang=" + lang,
                            success: function (data) {
                                document.getElementById("SecRG").innerHTML = data;
                                if (document.getElementsByName('reserv1').length > 0)
                                {
                                    TitulosVentanas();
                                    mostrarVentana("VentanaRG");
                                    var theHandle = document.getElementById('handle20');
                                    var theRoot = document.getElementById('VentanaRG');
                                    Drag.init(theHandle, theRoot);
                                }
                            }
                        });
                    }
                    function AgregarPosisciones()
                    {
                        var c1 = document.getElementsByName('reserv1');
                        var c2 = document.getElementsByName('reserv2');
                        var c3 = document.getElementsByName('reserv3');
                        var c4 = document.getElementsByName('reserv4');
                        var c5 = document.getElementsByName('reserv5');
                        var c6 = document.getElementsByName('reserv6');
                        var mov = document.getElementById('bxClase').value;

                        document.getElementById('btnAdd').disabled = true;

                        if (e < c1.length)
                        {
                            $("#btnAdd").trigger("click");

                            switch (mov)
                            {
                                case "311":
                                    document.getElementById('bxMaterial311').value = c1[e].textContent.trim();
                                    document.getElementById('bxcnt311').value = c2[e].textContent.trim();
                                    document.getElementById('bxUM311').value = c5[e].textContent.trim();
                                    document.getElementById('bxAlmacen311').value = c6[e].textContent.trim();
                                    $('#bxMaterial311').css('background-image', 'none');
                                    $('#bxcnt311').css('background-image', 'none');
                                    $('#bxUM311').css('background-image', 'none');
                                    $('#bxAlmacen311').css('background-image', 'none');
                                    ObtenerMaterialN('311');
                                    break;
                                case "261":
                                    document.getElementById('bxMaterial261').value = c1[e].textContent.trim();
                                    document.getElementById('bxcnt261').value = c2[e].textContent.trim();
                                    document.getElementById('bxord261').value = c3[e].textContent.trim();
                                    document.getElementById('bxUM261').value = c5[e].textContent.trim();
                                    $('#bxMaterial261').css('background-image', 'none');
                                    $('#bxcnt261').css('background-image', 'none');
                                    $('#bxord261').css('background-image', 'none');
                                    $('#bxUM261').css('background-image', 'none');
                                    ObtenerMaterialN('261');
                                    break;
                                case "201":
                                    document.getElementById('bxMaterial201').value = c1[e].textContent.trim();
                                    document.getElementById('bxcnt201').value = c2[e].textContent.trim();
                                    document.getElementById('bxccs201').value = c4[e].textContent.trim();
                                    document.getElementById('bxUM201').value = c5[e].textContent.trim();
                                    $('#bxMaterial201').css('background-image', 'none');
                                    $('#bxcnt201').css('background-image', 'none');
                                    $('#bxccs201').css('background-image', 'none');
                                    $('#bxUM201').css('background-image', 'none');
                                    ObtenerMaterial200();
                                    break;
                                default:
                                    break;
                            }

                        }
                        if (e === c1.length)
                        {
                            if (document.getElementsByName('mmidx').length < 1)
                            {
                                document.getElementById("divresr").innerHTML = "";
                            }
                        }
                    }
                    function invalR() {
                        var funinva = "<%=menValores%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = funinva;
                    }
                    function Aumentar() {

                        e++;
                        if (document.getElementsByName('reserv1').length > 0)
                        {
                            AgregarPosisciones();
                        }
                    }
                    function Validar305()
                    {
                        var v1 = document.getElementById('bxDocMat').value;
                        var v2 = document.getElementById('bxPosDoc').value;
                        var extras = "&v1=" + v1 + "&v2=" + v2;

                        if (v1 === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Folio SAP Necesario";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }
                        if (v2 === "")
                        {
                            var ven = document.getElementById('VentanaModalAv');
                            var msg = "Numero de Posición Requerida";
                            abrirVentanaAv(ven, msg);
                            var theHandle = document.getElementById("handleAV");
                            var theRoot = document.getElementById("VentanaModalAv");
                            Drag.init(theHandle, theRoot);
                            return;
                        }

                        var lang = "<%=Idioma%>";
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                if (xmlhttp.responseText == 0)
                                {
                                    var ven = document.getElementById('VentanaModalAv');
                                    var msg = "Folio SAP no encontrado o sin Posiciones";
                                    abrirVentanaAv(ven, msg);
                                    var theHandle = document.getElementById("handleAV");
                                    var theRoot = document.getElementById("VentanaModalAv");
                                    Drag.init(theHandle, theRoot);
                                } else
                                {
                                    CambiarStatusDoc('CambiaStatus305', 'X');
                                    var temp = new Array();
                                    temp = xmlhttp.responseText.split(",");

                                    document.getElementById('bxMaterial303').value = parseInt(temp[0]);
                                    document.getElementById('txtMaterial303').innerHTML = temp[1];
                                    document.getElementById('bxcnt303').value = parseInt(temp[2]);
                                    document.getElementById('bxUM303').value = temp[3];
                                    document.getElementById('bxLote303').value = temp[4];
                                    ocultarVentana('VentanaModal305', 'ok303');
                                    mostrarVentana('VentanaModal303');
                                    var centrod = $('#bxCentro303');
                                    centrod.val($('#bxCentro').val());
                                    centrod.prop('disabled', true);
                                    $('#bxLote303').prop('disabled', true);
                                    $('#bxUM303').prop('disabled', true);
                                    $('#bxcnt303').prop('disabled', true);
                                    $('#bxMaterial303').prop('disabled', true);

                                    $('#bxCentro303').css('background-image', 'none');
                                    $('#bxLote303').css('background-image', 'none');
                                    $('#bxUM303').css('background-image', 'none');
                                    $('#bxcnt303').css('background-image', 'none');
                                    $('#bxMaterial303').css('background-image', 'none');
                                    var theHandle = document.getElementById('handle13');
                                    var theRoot = document.getElementById('VentanaModal303');
                                    Drag.init(theHandle, theRoot);
                                }
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=Valida305&lang=" + lang + extras, true);
                        xmlhttp.send();
                    }
                    function CambiarStatusDoc(action, v4)
                    {
                        var v1 = document.getElementById('bxDocMat').value;
                        var v2 = document.getElementById('bxPosDoc').value;
                        var v3 = document.getElementById('bxCentro').value.toUpperCase();

                        var extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3 + "&v4=" + v4;
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                            }
                        };
                        xmlhttp.open("GET", "PeticionMovMateriales?Action=" + action + extras, true);
                        xmlhttp.send();


                    }



                    function checkDecCant1(num, tam, input) {
                        var d;
                        var umd;
                        if (num.length > 0) {
                            //                        num = nu,m.substring(1,num.length);
                            umd = document.getElementById(input).value;
                            //alert(umd);
                            if (umd.length < 1) {
                                document.getElementById(input).focus();
                                return num;
                            } else {
                                var exisU = getExisUMD(umd);
                                //                            alert(exisU);
                                if (exisU == 1) {
                                    var type = getTypeUMD(umd);
                                    //  alert(type);
                                    if (type == 0) {
                                        num = Math.round(num);
                                        d = parseFloat(num).toFixed(tam);
                                        return d;
                                    } else if (type == 3) {
                                        num = parseFloat(num).toFixed(tam);
                                        return num;
                                    }
                                } else {
                                    document.getElementById(input).focus();
                                    //                                alert("umdno exis");
                                    return num;
                                }
                            }
                        } else if (num.length < 1) {
                            return "";
                        }
                    }
                    var An = 0;
                    function GestionLoteInsp(i) {
                        $('#guardar').prop('disabled', true);
                        var mat = document.getElementsByName('mmmat');
                        if (An < mat.length) {
                            if (!(mat[An].textContent == "")) {
                                VerificarMateLoteInpeccion(mat[i].textContent);
                            } else {
                                OKPlainpeccion();
                            }
                        } else {
                            ocultarVentana('VentanaModalGestionInp', 'btnAdd', 'm');
                            An = 0;
                            saveDatos101();
                        }

                    }
                    function VerificarMateLoteInpeccion(mat) {
                        var dataSend = "&MLI=" + mat;
                        var acc = "CheckMateLoteInpecion";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + dataSend, success: function (data) {
                                var d = data.trim();
                                if (!(d === 'NOT')) {
                                    OpenGestionLoteIns(d);
                                } else {
                                    OKPlainpeccion();
                                }
                            }
                        });
                    }
                    function OpenGestionLoteIns(mat) {
                        ObtenerdatosCabPI(mat);
                        mostrarVentana('VentanaModalGestionInp');
                        var theHandle = document.getElementById('handle19');
                        var theRoot = document.getElementById('VentanaModalGestionInp');
                        Drag.init(theHandle, theRoot);
                    }
                    function ObtenerdatosCabPI(m) {
                        var dataSend = "&MLI=" + m;
                        var acc = "ObtenerCabeceraPI";
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + dataSend, success: function (data) {
                                var a = data.split("'");
                                $('#MaterialLoteInsp').val(a[0].trim());
                                $('#DesMateLI').val(a[1].trim());
                                $('#CentroLI').val(a[2].trim());
                            }
                        });
                    }

                    function OKPlainpeccion() {
                        An = parseInt(An) + 1;
                        GestionLoteInsp(An);
                    }
                    function ObtenerTablaCaracteristicasPI() {

                    }
                    function CerrarVenatanGPI() {
                        var ven = document.getElementById('VentanaModalAv');
                        var msg = "No se  puede cancelar el proceso  plan de inspección";
                        abrirVentanaAv(ven, msg);
                        var theHandle = document.getElementById("handleAV");
                        var theRoot = document.getElementById("VentanaModalAv");
                        Drag.init(theHandle, theRoot);
                        return;
                    }

                    function Limpia200()
                    {
                        document.getElementById('bxMaterial201').value = "";
                        document.getElementById('bxcnt201').value = "";
                        document.getElementById('bxUM201').value = "";
                        document.getElementById('bxLote201').value = "";
                        document.getElementById('bxccs201').value = "";
                        document.getElementById('txtMaterial').innerHTML = "";

                        $('#bxMaterial201').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxcnt201').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxUM201').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxLote201').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxccs201').css('background-image', 'url(images/necesario.PNG)');
                    }

                    function Limpia260()
                    {
                        document.getElementById('bxMaterial261').value = "";
                        document.getElementById('bxcnt261').value = "";
                        document.getElementById('bxUM261').value = "";
                        document.getElementById('bxLote261').value = "";
                        document.getElementById('bxord261').value = "";
                        document.getElementById('txtMaterial261').innerHTML = "";

                        $('#bxMaterial261').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxcnt261').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxUM261').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxLote261').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxord261').css('background-image', 'url(images/necesario.PNG)');
                    }



                    function Limpia310()
                    {
                        document.getElementById('bxMaterial311').value = "";
                        document.getElementById('bxcnt311').value = "";
                        document.getElementById('bxUM311').value = "";
                        document.getElementById('bxLote311').value = "";
                        document.getElementById('bxAlmacen311').value = "";
                        document.getElementById('txtMaterial311').innerHTML = "";

                        $('#bxMaterial311').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxcnt311').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxUM311').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxLote311').css('background-image', 'url(images/necesario.PNG)');
                        $('#bxAlmacen311').css('background-image', 'url(images/necesario.PNG)');
                    }

                    function saveDatos101() {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var almacen = document.getElementById('bxAlmacen').value.toUpperCase();
                        var fecha = document.getElementById('bxFecha').value;
                        var tmov = document.getElementById('bxClase').value;
                        var texto = document.getElementById('bxTexto').value;
                        var nota = document.getElementById('bxNota').value;
                        var carta = document.getElementById('bxCarta').value;

                        var lote = document.getElementsByName('mmnlt');
                        var cantidad = document.getElementsByName('mmprr');//Por recibir
                        var Descripc = document.getElementsByName('mmdsc');
                        var material = document.getElementsByName('mmmat');
                        var pedido = document.getElementsByName('mmped');
                        var posicion = document.getElementsByName('mmnpe');
                        var tabix = document.getElementsByName('mmidx');
                        var ultima = document.getElementsByName('mmuct');
                        var almDes = document.getElementsByName('mmalm');
                        var cdes = document.getElementsByName('mmctr');
                        var unmms = document.getElementsByName('mmumb');
                        var almpe = document.getElementsByName('mmalmped');
                        var f = new Date();
                        var horas = f.getHours();
                        var minutos = f.getMinutes();
                        var segundos = f.getSeconds();
//                        var cad = horas + ":" + minutos + ":" + segundos;
                        var cad = "";
                        var extra = "&v1=" + centro + "&v2=" + almacen + "&v3=" + fecha + "&v4=" + tmov +
                                "&v5=" + texto + "&v6=" + nota +
                                "&v7=" + carta + "&v8=" + cad;
                        var tt = "Guarda" + tmov + "Cabecera";
                        var tim = document.getElementsByName('mmtimp');
                        var extrass = "&v1=";
                        for (i = 0; i < lote.length; i++)
                        {
                            if (tim[i].textContent == "") {
                                tim[i].textContent = "V";
                            }

                            extrass += encodeURIComponent(lote[i].textContent.toUpperCase()) + "," + cantidad[i].textContent + "," + material[i].textContent + "," + centro +
                                    "," + almacen + "," + tim[i].textContent + ",";
                        }
                        extrass = extrass.substring(0, extrass.length - 1);
                        extrass += "&v2=" + lote.length;
                        Lote101(extrass, tt, extra, cad);
                    }

                    function checkDec(num, tam) {
                        var limit;
                        var FINC;
                        if (tam == 3) {
                            limit = 9999999.999;
                            FINC = "Formato Incorecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
                        } else {
                            limit = 99999999.99;
                            FINC = "Formato Incorecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
                        }
                        if (num.length > 0) {
                            if (parseFloat(limit) >= parseFloat(num)) {
                                va = num.split(".");
                                v01 = va[0];
                                if (v01.length == 0) {
                                    v01 = "0";
                                }
                                v0 = parseInt(v01);
                                v1 = va[1];
                                if (num.indexOf(".") != -1) {
                                    if (v1.length > tam) {
                                        var da = v1.substr(0, tam);
                                        borrarmsg();
                                        return v0 + "." + da;
                                    } else {
                                        for (i = 0; i <= tam; i++) {
                                            v1 += "0";
                                        }
                                        borrarmsg();
                                        return v0 + "." + v1.substr(0, tam);
                                    }
                                } else {
                                    var nn = "0";
                                    for (a = 0; a < tam; a++) {
                                        nn += "0";
                                    }
                                    borrarmsg();
                                    return v0 + "." + nn.substr(0, tam);
                                }
                            } else {
                                mensajesValidacionInco(FINC);
                                return "";
                            }
                        } else {
                            borrarmsg();
                            return "";
                        }

                    }
                    function borrarmsg() {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                        var men = document.getElementById("msg");
                        men.innerHTML = "";
                    }
                    function mensajesValidacionInco(msg) {
                        var BE = document.createElement('audio');
                        BE.src = "audio/saperror.wav";
                        BE.play();
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = msg;
                    }
                    function DecimalesUM(mov)
                    {
                        var um = document.getElementById("bxUM" + mov).value;
                        var acc = "ObtenerUM";
                        $.ajax({
                            type: 'GET',
                            async: false,
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + "&v1=" + um,
                            success: function (data) {
                                if (data == 0) {
                                    document.getElementById("bxcnt" + mov).value = parseInt(document.getElementById("bxcnt" + mov).value) + ".000";
                                }
                            }
                        });
                    }
                    function DecimalesUMR(um, inp)
                    {
                        var acc = "ObtenerUM";
                        $.ajax({
                            type: 'GET',
                            async: false,
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + "&v1=" + um,
                            success: function (data) {
                                if (data == 0) {
                                    inp.value = parseInt(inp.value) + ".000";
                                }
                            }
                        });
                    }

                    var ccld = 0;
                    function PosicionesCld()
                    {
                        var cl = document.getElementsByName('mmmat');
                        var ct = document.getElementsByName('mmprr');
                        if (ccld >= cl.length)
                        {
                            dataxxxx();
                            return;
                        }
                        document.getElementById('btnGrabarR').disabled = false;
                        document.getElementById('btnGrabarD').disabled = false;
                        $("#btnCld3").prop('disabled', false);
                        $("#btnCld4").prop('disabled', false);
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=ValidaMat&v1=" + cl[ccld].textContent,
                            success: function (data) {
                                if (data == 1)
                                {

                                    var theHandle = document.getElementById('handle22');
                                    var theRoot = document.getElementById('VentanaModalCalidad');
                                    Drag.init(theHandle, theRoot);
                                    abrirVentanaCalidad(document.getElementById('VentanaModalCalidad'));
                                    cargarCabeceraCalidad(cl[ccld].textContent);
                                    TablaCaracteristicas(cl[ccld].textContent, ct[ccld].textContent);
                                    TablaDefectos();
                                    obtenerMov();
                                    ccld++;
                                } else {
                                    ccld++;
                                    PosicionesCld();
                                }
                            }
                        });
                    }
                    function obtenerMov()
                    {
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=obtenerCL&v1=" + document.getElementById('bxClase').value,
                            success: function (data) {
                                document.getElementById('bxClsInf').value = data;
                                consultarClsInf();
                            }
                        });
                    }
                    function llenaCalidad()
                    {
                        var myTableC = document.getElementById('TablaTmpDefCab');
                        var myTableP = document.getElementById('TablaTmpDefPos');
                        var myTableT = document.getElementById('TablaTmpDefTxt');

                        for (var c = 0; c < myTableC.rows.length; c++)
                        {
                            var arrCb = new Array();
                            for (var i = 0; i < myTableC.rows[0].cells.length; i++)
                            {
                                arrCb[i] = myTableC.rows[c].cells[i].textContent;
                            }
                            guardarDefCabecera(arrCb);
                        }
                        for (var c = 0; c < myTableP.rows.length; c++)
                        {
                            var arrPs = new Array();
                            for (var i = 0; i < myTableP.rows[0].cells.length; i++)
                            {
                                arrPs[i] = myTableP.rows[c].cells[i].textContent;
                            }
                            guardarDefectos(arrPs);
                        }
                        for (var c = 0; c < myTableT.rows.length; c++)
                        {
                            var arrTx = new Array();
                            for (var i = 0; i < myTableT.rows[0].cells.length; i++)
                            {
                                arrTx[i] = myTableT.rows[c].cells[i].textContent;
                            }
                            guardarDefTxt(arrTx);
                        }
                    }
                    function numCld(e)
                    {
                        tecla = (document.all) ? e.keyCode : e.which;
                        patron = /[0-9]/;
                        tecla_final = String.fromCharCode(tecla);
                        return patron.test(tecla_final);
                    }
                    function abrirVentanaMsgAddFile() {
                        var theHandle = document.getElementById('handleFile');
                        var theRoot = document.getElementById('VentanaModalMsgAddFile');
                        Drag.init(theHandle, theRoot);
                        var ven = document.getElementById('VentanaModalMsgAddFile');
                        var ancho = 900;
                        var alto = 250;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ven.style.left = x + "px";
                        ven.style.top = y + "px";
                        ven.style.display = 'block';
                    }
                    function AbrirVentanaAddFile() {
                        OcultarMensajeFile('VentanaModalMsgAddFile');
                        var theHandle = document.getElementById('handleFileAdd');
                        var theRoot = document.getElementById('VentanaModalAddFile');
                        Drag.init(theHandle, theRoot);
                        var ven = document.getElementById('VentanaModalAddFile');
                        var ancho = 800;
                        var alto = 600;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ven.style.left = x + "px";
                        ven.style.top = y + "px";
                        ven.style.display = 'block';
                    }
                    function OcultarMensajeFile(window) {
                        var ventana = document.getElementById(window);
                        ventana.style.display = 'none';

                    }
                    var output = [];
                    function uploadFiles() {
                        var Formdata = new FormData($('#FormCreate')[0]);
                        var centro = $("#bxCentro").val();
                        for (var i = 0; i < output.length; i++) {
                            Formdata.append('file[]', output[i]);
                        }
                        Formdata.append(centro, 'x');
                        $.ajax({
                            url: 'archivosMovimiento101',
                            type: 'POST',
                            data: Formdata,
                            dataType: "json",
                            async: false,
                            cache: false,
                            contentType: false,
                            processData: false,
                            success: function (data) {
                                if (data[0] == "0") {
                                } else {
                                    insertDataFiles(data);
                                    OcultarMensajeFile('VentanaModalAddFile');
                                    MovimientosMO();
                                }
                            }

                        });
                        return false;
                    }

                    function getExtension(filename) {
                        var index = filename.lastIndexOf('.');
                        if (index == -1) {
                            return "";
                        } else {
                            return filename.substring(index + 1);
                        }
                    }
                    function getNameFile(filename) {
                        var index = filename.lastIndexOf('\\');
                        if (index == -1) {
                            return "";
                        } else {
                            return filename.substring(index + 1);
                        }
                    }



                    function insertDataFiles(d) {
                        var acc = "insertarDataFile";
                        for (var i = 0; i < d.length; i++) {
//                            rut = d[i].replace(/'/g, "´");
                            var datosSend = "&v1=" + (i + 1) +
                                    "&v2=" + (getExtension(d[i])).toUpperCase() +
                                    "&v3=" + "EVC" +
                                    "&v4=" + getNameFile(d[i]) +
                                    "&v5=" + usuario +
                                    "&v6=" + encodeURIComponent(d[i]);
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: 'PeticionMovMateriales',
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: "Action=" + acc + datosSend,
                                success: function (rs) {
//                                    alert(rs);
                                }
                            });
                        }


                    }
                    function datos() {
                        var archivos = document.getElementById('archivos').files;
                        for (var i = 0; i < archivos.length; i++) {
                            output.push(archivos[i]);
                        }

                        for (var i = 0; i < output.length; i++) {
                            var name = output[i].name;
                            var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                            var size = output[i].size / 1024 / 1024;
                            var tamano = size.toFixed(2);
                            var peso = "";
                            if (tamano >= 1) {
                                peso = tamano + " mb";
                            } else {
                                peso = tamano + " kb";
                            }
                            var fila = '<tr><td><input type="checkbox" id="rb' + i + '" name="rb" value="' + i + '"</td>\n\
                                            <td><label id="nombre' + i + '">' + name + '</label></td>\n\
                                            <td><label id="tipo' + i + '">' + ext + '</label></td>\n\
                                            <td><label id="tamaño' + i + '">' + peso + '</label></td></tr>';

                            $('#table12 > tbody').append(fila);
                        }
                    }

                    function DatosArchivos() {
                        var trs = $("#table12 tr").length;
                        var final = trs - 1;
                        if (final >= 1) {
                            for (var i = 0; i < final; i++) {
                                $("#table12 tr:last").remove();
                            }
                            datos();
                        } else if (final >= 2) {
                            for (var i = 0; i < final; i++) {
                                $("#table12").remove();
                            }
                            datos();
                        } else {
                            datos();
                        }
                    }
                    function cancelarFile() {
                        OcultarMensajeFile('VentanaModalAddFile');
                        MovimientosMO();
                    }

                    function DeleteFile() {
                        var elementos = $('[name = "rb"]');
                        for (var i = 0; i < output.length; i++) {
                            if (elementos[i].checked) {
                                output.splice(i, 1);
                                $('#table12').find('input[name="rb"]').each(function () {
                                    if ($(this).is(":checked")) {
                                        $(this).parents("tr").remove();
                                    }
                                });
                            }
                        }
                    }
                    var habl;
                    function ValidaMaterialHabilitado(mat) {
                        var acc = "MaterialHabilitado";
                        var dataSend = "&v1=" + mat + "&v2=" + $('#bxCentro').val() + "&v3=" + $('#bxAlmacen').val();

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMovMateriales',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Action=" + acc + dataSend,
                            success: function (data) {
                                habl = parseInt(data);
                                if (parseInt(data) === 0) {
//                                    return false;
                                }
                                if (parseInt(data) === 1) {
//                                    return true;
                                }
                            }
                        });
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "Bienvenido.jsp";
        }

    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>