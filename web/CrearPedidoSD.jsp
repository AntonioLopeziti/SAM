
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
        String Folio = request.getParameter("FolioPV");
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
        String noexisteval = po.getProperty("etiqueta.NoExisteValores_SAM");
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
                var pag = p.charAt(27);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();

            function ShowMsg(m, im, au, va, v1, v2, v3) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=noexisteval%>';
                        break;
                    case 2:
                        msg = 'No se ha podido determinar el Area de ventas';
                        break;
                    case 3:
                        msg = 'Indicar solicitante';
                        break;
                    case 4:
                        msg = 'Indicar destinatario de mercancias';
                        break;
                    case 5:
                        msg = 'Indicar referencia de cliente';
                        break;
                    case 6:
                        msg = 'Indicar clase de pedido';
                        break;
                    case 7:
                        msg = 'Indicar fecha de entrega';
                        break;
                    case 8:
                        msg = 'La fecha es un perido pasado al actual';
                        break;
                    case 9:
                        msg = 'Definir Area de ventas';
                        break;
                    case 10:
                        msg = 'Material ' + v1 + ' en org.ventas ' + v2 + ', canal distr. ' + v3 + ' no esta previsto';
                        break;
                    case 11:
                        msg = 'Indicar Material, obligatorio';
                        break;
                    case 12:
                        msg = 'Relacion Interlocutor no coinciden';
                        break;
                    case 13:
                        msg = 'Clase de pedido no prevista';
                        break;
                    case 14:
                        msg = 'Grupo de vendedores no prevista';
                        break;
                    case 15:
                        msg = 'Oficina de ventas no prevista';
                        break;
                    case 16:
                        msg = 'Descripción vacia, cargue datos desde material';
                        break;
                    case 17:
                        msg = 'Unidad medida vacia, cargue datos desde material';
                        break;
                    case 18:
                        msg = 'Cantidad vacia, agregue una cantidad';
                        break;
                    case 19:
                        msg = 'Introduce solicitante';
                        break;
                    case 20:
                        msg = 'Relación Interlocutor no valida';
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
        <link rel="stylesheet" href="css/StyleCrearPedidosSD.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>     
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/CrearPedidoSD.js"></script>  
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.PedidosSDTituloCrear"));%></title>       
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
                        validarFecha(date);
                        CerrarCalendario();
                    }
                });
            });
            $(function () {
                $('#datapicker').datepicker().hide();
            });
            function validarFecha(fecha) {
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
                    ShowMsg(8, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#fechaEntrega').focus();
                    $('#fechaEntrega').val('');
                } else {
                    $('#fechaEntrega').val(fecha);
                    $('#fechaEntrega').focus();
                    borramsg();
                }
            }
            function MostrarFolio()
            {
                var men = document.getElementById("msg");
                var fol = "<%=Folio%>";
                if (fol != "null") {
                    var icon = $('#iconmsg');
                    icon.attr('src', "images/aceptar.png");
                    icon.show();
                    men.innerHTML = "Documento creado: " + "<%=Folio%>";
                }
            }
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
            <input  id="regresar" type="image" src="images/regresaOFF.png" disabled/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.PedidosSDTituloCrear"));%></h1></div> 
        </div>            
        <div class="contenido">    
            <div class="divCabeceraCrea">
                <section class="contain-cabeceracrea">
                    <label>Cabecera</label>
                    <hr id="linetitu">
                    <div class='Contenedor1'>
                        <section class="SectionFloat">
                            <label>Pedido</label><input type="text" id="pedido" maxlenght="10" style="width:25%;" readonly/>
                            <hr>
                            <label>Solicitante</label><input type="text" id="solicitante" maxlength="10" style="width:35%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchSolicitante" class='BtnMatchIcon'></button>
                            <hr>
                            <label>Dest.Mcia.</label><input type="text" id="destinatario" maxlength="10" style="width:35%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchDestMecia" class='BtnMatchIcon'></button>
                            <hr>
                            <label>Area de ventas</label><input type="text" id="orgVentas" maxlength="4" style="width:10%; background-repeat: no-repeat; text-transform: uppercase;" disabled/><button id="matchOrgVentas" class='BtnMatchIcon'></button> / <input type="text" id="CanalDis" maxlength="2"  style="width:8%; background-repeat: no-repeat; text-transform: uppercase;" disabled/><button id="matchcanalDis" class='BtnMatchIcon'></button> / <input type="text" id="Sector" maxlength="2"  style="width:8%; background-repeat: no-repeat; text-transform: uppercase;" disabled/><button id="matchSector" class='BtnMatchIcon'></button>
                            <hr>
                            <label>Ref.Cliente</label><input type="text" id="refcliente" maxlength="35" style="width:55%; background-repeat: no-repeat"/>
                            <hr>
                            <label>Creado por</label><input type="text" id="CreadoPor" value="<%=Nombre%>" style="width: 42%;" readonly/>
                            <hr>
                            <label>Fecha entrega</label><input type="text" id="fechaEntrega" readOnly style="width: 25%; background-repeat: no-repeat;"/><button id="matchFechaentrega" class='BtnMatchIcon'></button> 
                            <hr>
                        </section>
                        <section class="SectionFloat2">
                            <label>Clase de pedido</label><input type="text" id="ClasePedido" maxlength='4' style="width: 8%; background-repeat: no-repeat; text-transform: uppercase;" /><button id="matchClasePedido" class='BtnMatchIcon'></button> <input type='text' id='txtClasePedido'style="width: 52%; background: none; border: none;" readonly/>
                            <hr>
                            <input type="text" style="width: 100%; background: none; border:none;" id="txtSolicitante" readonly/>
                            <hr style="border:1.8px solid #fff;">
                            <input type="text" style="width: 100%; background: none; border:none;" id="txtDestMcia" readOnly/>
                            <hr style="border:1.8px solid #fff;">
                            <input type="text" style="width: 100%; background: none; border: none;" id="txtAreaVentas" readOnly/>
                            <hr style="border:1.8px solid #fff;">
                            <label>Oficina de ventas</label><input type="text"  style="width: 8%; text-transform: uppercase;" maxlength='4' id="OficinaVentas" /><button id="matchpoficinaVentas" class='BtnMatchIcon'></button> <input type='text' id='txtOficinaVentas'style="width: 52%; background: none; border: none;" readonly/>
                            <hr>
                            <label>Gpo. de vendedores</label><input type="text" style="width: 6%; text-transform: uppercase" maxlength="3" id="GpoVendedores" /><button id="matchGpoVendedores" class='BtnMatchIcon'></button> <input type='text' id='txtGpoVended'style="width: 55%; background: none; border: none;" readonly/>
                            <hr>
                            <label>Fecha precio</label><input type="text" id='fechaPrecio'  style="width: 16%" readonly/><button id="matchDescCabecera" class="BtnMatchIconDescricabe"></button>
                            <hr>
                        </section>
                    </div>
                </section>
            </div>
            <div class='DivPosiciones'>
                <label>Posiciones</label>
                <hr id="linetitu">
                <div class="DivResumenPos">
                    <div id="tabscrll2">
                        <section id="TableNotfi2">
                            <section class="TableContainer2">
                                <section class="SecHead2">
                                    <table id="TabHead2">
                                        <thead>
                                            <tr>
                                                <td>&nbsp;&nbsp;&nbsp;</td>
                                                <td>Posición</td>
                                                <td>Material</td>
                                                <td>Descripción</td>
                                                <td>Cantidad</td>
                                                <td>Unidad Medida</td>
                                                <td>Texto pos.</td>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody2" id="SecCuerpo2">
                                    <table id="TabBody2">
                                        <tbody>
                                            <tr id="tr0">
                                                <td><input type="checkbox" name="Cehckbx" value="0"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic0" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater0" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '0')" maxlength="40"/><button id="matchtdmaterial0" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '0');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr0" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti0" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi0" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion0" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(0)"></button><textarea hidden style="resize: none;" id="textoposTemp0"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp0"></textarea></td>
                                            </tr>
                                            <tr id="tr1">
                                                <td><input type="checkbox" name="Cehckbx" value="1"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic1" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater1" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '1')" maxlength="40"/><button id="matchtdmaterial1" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '1');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr1" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti1" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi1" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion1" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(1)"></button><textarea hidden style="resize: none;" id="textoposTemp1"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp1"></textarea></td>
                                            </tr>
                                            <tr id="tr2">
                                                <td><input type="checkbox" name="Cehckbx" value="2"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic2" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater2" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '2')" maxlength="40"/><button id="matchtdmaterial2" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '2');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr2" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti2" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi2" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion2" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(2)"></button><textarea hidden style="resize: none;" id="textoposTemp2"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp2"></textarea></td>
                                            </tr>
                                            <tr id="tr3">
                                                <td><input type="checkbox" name="Cehckbx" value="3"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic3" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater3" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '3')" maxlength="40"/><button id="matchtdmaterial3" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '3');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr3" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti3" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi3" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion3" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(3)"></button><textarea hidden style="resize: none;" id="textoposTemp3"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp3"></textarea></td>
                                            </tr>
                                            <tr id="tr4">
                                                <td><input type="checkbox" name="Cehckbx" value="4"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic4" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater4" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '4')" maxlength="40"/><button id="matchtdmaterial4" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '4');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr4" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti4" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi4" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion4" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(4)"></button><textarea hidden style="resize: none;" id="textoposTemp4"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp4"></textarea></td>
                                            </tr>
                                            <tr id="tr5">
                                                <td><input type="checkbox" name="Cehckbx" value="5"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic5" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater5" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '5')" maxlength="40"/><button id="matchtdmaterial5" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '5');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr5" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti5" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi5" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion5" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(5)"></button><textarea hidden style="resize: none;" id="textoposTemp5"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp5"></textarea></td>
                                            </tr>
                                            <tr id="tr6">
                                                <td><input type="checkbox" name="Cehckbx" value="6"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic6" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater6" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '6')" maxlength="40"/><button id="matchtdmaterial6" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '6');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr6" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti6" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi6" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion6" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(6)"></button><textarea hidden style="resize: none;" id="textoposTemp6"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp6"></textarea></td>
                                            </tr>
                                            <tr id="tr7">
                                                <td><input type="checkbox" name="Cehckbx" value="7"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic7" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater7" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '7')" maxlength="40"/><button id="matchtdmaterial7" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '7');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr7" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti7" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi7" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion7" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(7)"></button><textarea hidden style="resize: none;" id="textoposTemp7"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp7"></textarea></td>
                                            </tr>
                                            <tr id="tr8">
                                                <td><input type="checkbox" name="Cehckbx" id="8"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic8" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater8" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '8')" maxlength="40"/><button id="matchtdmaterial8" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '8');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr8" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti8" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi8" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion8" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(8)"></button><textarea hidden style="resize: none;" id="textoposTemp8"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp8"></textarea></td>
                                            </tr>
                                            <tr id="tr9">
                                                <td><input type="checkbox" name="Cehckbx" value="9"/></td>
                                                <td><input type="text" class="tdSMatch" id="tdPosic9" name="PosicTD" onfocus="QuitarMatch()" readonly/></td>
                                                <td><input type="text" class='tdCMatch' id="tdMater9" name="MaterTD" onfocus="MostrarMatch('tdMater', 'matchtdmaterial', '9')" maxlength="40"/><button id="matchtdmaterial9" onclick="MostrarMatchGridMateriales('VentanaModalMateriales', 'handle8', '9');" name="matchMaterial" class='BtnMatchIconGrid'></button></td>
                                                <td><input type="text" class='tdSMatch' id="tdDescr9" name="DesciTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><input type="text" class="tdSMatch" id="tdCanti9" name="CantiTD" onblur="this.value = checkDec(this.value, 3)" onKeyPress="return soloNumeros(event)" onfocus="QuitarMatch()"/></td>
                                                <td><input type="text" class="tdCMatch" id="tdUmedi9" name="UMediTD" onfocus="QuitarMatch()" readOnly/></td>
                                                <td><button id="textoPosicion9" name="matchTxtPos" class="BtnMatchIconDescri" onclick="mostrarVentanaTextoPos(9)"></button><textarea hidden style="resize: none;" id="textoposTemp9"></textarea><textarea hidden style="resize: none;" id="textoposEmbaTemp9"></textarea></td>
                                            </tr>
                                            <tr class="ocultar" id="temporalro"><td>00</td><td>00000000</td><td>0000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000</td><td>00000000000000000000000000</td><td>00000000000000</td><td>000000000000</td></tr>
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
                <input hidden type="text" id="postextpos">
                <section id="botonesadddel">
                    <input id="AgregarFilas" type="image" src="images/ADD.PNG" style="vertical-align: middle"/>
                    <input id="BorrarFilas" type="image" src="images/DELETEADD.PNG" style="padding-top: 1px; vertical-align: middle; margin-left: -1%;"/>
                </section>
            </div>
        </div>
        <div id="VentanaModalTextli" class="VentanaModalTxtCabecera">
            <div id="handleTxtCab"><label id="TituloMatch">Texto Cabecera</label><div class="BotonCerrar_Matc" id="cerrarmodaTxtCab"><label >X</label></div></div>
            <div class="Contenttexto2"><textarea style="resize: none;" id="textoCabecera"></textarea></div>
            <div class="Botones_MatchTEX">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="cursor:pointer;" id="Cerraok"/>
                <img class="BtnMatchIcon" src="images/eliminar.png" style="cursor:pointer;" id="cerrarmodaTxtCab2"/>
            </div>
        </div>
        <div id="VentanaModalTextPos" class="VentanaModalTxtCabecera">
            <div id="handleTxtPos"><label id="TituloMatch">Texto Posioion</label><div class="BotonCerrar_Matc" id="cerrarmodaTxtPos"><label >X</label></div></div>
            <div class="Selectdatatextpos">
                <select id="SelectTipoTexto">
                    <option value="0" selected="selected">Texto ventas Materiales</option>
                    <option value="1">Instrucciones de embarque</option>
                </select>
            </div>
            <div class="Contenttextopos" id="textoEmbarqu"><textarea style="resize: none;" id="textoPos" ></textarea></div>
            <div class="Contenttextopos" id="textoventasMat" ><textarea style="resize: none;" id="textoEmbarq" readonly></textarea></div>
            <div class="Botones_MatchTEXp">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="cursor:pointer;" id="CerraokPos"/>
                <img class="BtnMatchIcon" src="images/eliminar.png" style="cursor:pointer;" id="cerrarmodaTxtPos2"/>
            </div>
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <input id="idDataFeee" hidden/>
        </div>
        <div id="VentanaModalOrgVentas" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch">Organizacion ventas</label><div class="BotonCerrar_Matc" id="CerrarMCOrgVenta"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaOrgVentas">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollorgVentas">
                        <div class="fixedY" id="fixedYorgVentas">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Org. ventas</th>
                                        <th>Descripción</th>
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
        <div id="VentanaModalCanalDist" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Canal distribución</label><div class="BotonCerrar_Matc" id="CerrarMCCanalDist"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCanalDist">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCanalDis">
                        <div class="fixedY" id="fixedYCanalDis">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Org.ventas</th>
                                        <th>Canal Dist.</th>
                                        <th>Denominación</th>
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
            <div id="handle4"><label id="TituloMatch">Sector</label><div class="BotonCerrar_Matc" id="CerrarMCSector"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaSector">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSector">
                        <div class="fixedY" id="fixedYSector">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Sector</th>
                                        <th>Denominación</th>
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
        <div id="VentanaModalClasePedido" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch">Clase de pedido</label><div class="BotonCerrar_Matc" id="CerraMCPedido"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaClasePed">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaPed">
                        <div class="fixedY" id="fixedYClasPed">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Clase pedido</th>
                                        <th>Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClasePedido">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalOficinaVentas" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch">Oficina de ventas</label><div class="BotonCerrar_Matc" id="CerrarMCOficinaVentas"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaOficinaVentas">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOficinaVentas">
                        <div class="fixedY" id="fixedYOficinaVentas">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Oficina Ventas</th>
                                        <th>Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOficinaVentas">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalGrpoVend" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch">Grupo vendedores</label><div class="BotonCerrar_Matc" id="CerraMCGpoVendedores"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retGpoVend"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParGpovend" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Grupo vendedor</label><input type="text" id="Busgpovend" maxlength="3" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label>Denominación</label><input type="text" id="Busdenomgvend" maxlength="20" style="width:35%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax7"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkGpoVendedor"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCGpoVendedores2"/>
                </div>
            </div>            
            <div id="ConsultaTablaGpoVend" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGpoVendedor">
                        <div class="fixedY" id="fixedYGpoVendedor">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Grupo vendedor</th>
                                        <th>Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosGpoVendedor">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalMateriales" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch">Materiales</label><div class="BotonCerrar_Matc" id="CerraMCMateriales"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="reMateri"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParMateriales" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Materiales</label><input type="text" id="BusMaterial" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label>Descripción</label><input type="text" id="BusdesMaterial" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax8"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkMateriales"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCMateriales2"/>
                </div>
            </div>            
            <div id="ConsultaTablaMateriales" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMateriales">
                        <div class="fixedY" id="fixedYMateriales">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Materiales</th>
                                        <th>Descripción</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMateriales">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>                        
        <div id="VentanaModalCliente" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch">Deudores generales</label><div class="BotonCerrar_Matc" id="CerraMCDeudores"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retClien"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParDeudores" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Cliente</label><input type="text" id="BusCliente" maxlength="10" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label>Nombre</label><input type="text" id="BusNombre" maxlength="25" style="width:35%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax9"   style="width:10%;" />
                        <hr>
                        <input type="text" hidden id="Tipodeudor"/>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkDeuudores"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCDeudores2"/>
                </div>
            </div>            
            <div id="ConsultaTablaDeudores" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDeudores">
                        <div class="fixedY" id="fixedYDeudores">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Cliente</th>
                                        <th>Nombre</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDeudodres">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>                        
        <div id="VentanaModalUMedida" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch">Unidad de medida</label><div class="BotonCerrar_Matc" id="CerrarMCUnidadMedida"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaUnidadMedida">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOUnidadMedida">
                        <div class="fixedY" id="fixedYUnidadMedida">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Unidad Medida</th>
                                        <th>Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUnidadMedida">
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
