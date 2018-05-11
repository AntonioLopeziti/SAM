<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
<%-- 
    Document   : CrearSolped
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
        String ERCuenM = "Cuenta Mayor no Valida";
        String ERCCost = "Centro de Costo no valido";
        String ERORD = "No éxiste la Orden";
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
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
        String Cando = po.getProperty("etiqueta.CSPCanceldocu");
        String findo = po.getProperty("etiqueta.CSPFinaliDocu");
        String Folioexc = po.getProperty("etiqueta.CSPFolExc");
        String CmCcAs = po.getProperty("etiqueta.CSPAsocCmCc");
        String formcan = po.getProperty("etiqueta.CSPMensajeformato");
        String formpre = po.getProperty("etiqueta.CSPMensajeformato2");
        String fehcin = po.getProperty("etiqueta.CSPFechainco");
        String NesNot = po.getProperty("etiqueta.CSPNeceNoEncon");
        String necobl = po.getProperty("etiqueta.CSPNeceObli");
        String notmodi = po.getProperty("etiqueta.CSPNomodifi");
        String errgco = po.getProperty("etiqueta.CSPErrGCom");
        String errmat = po.getProperty("etiqueta.CSPErrMate");
        String errcen = po.getProperty("etiqueta.CSPErrcen");
        String erralm = po.getProperty("etiqueta.CSPErralm");
        String errume = po.getProperty("etiqueta.CSPErrume");
        String errgar = po.getProperty("etiqueta.CSPErrgar");
        String oblgc = po.getProperty("etiqueta.CSPoblgcom");
        String oblma = po.getProperty("etiqueta.CSPoblgmat");
        String oblcan = po.getProperty("etiqueta.CSPoblcant");
        String cant1 = po.getProperty("etiqueta.CSPercan");
        String oblfec = po.getProperty("etiqueta.CSPoblFeE");
        String oblcen = po.getProperty("etiqueta.CSPoblCen");
        String oblum = po.getProperty("etiqueta.CSPoblume");
        String oblga = po.getProperty("etiqueta.CSPoblgar");
        String Cannt = po.getProperty("etiqueta.CSPCantt");
        String oblTxtbrv = po.getProperty("etiqueta.CSPtxtbrv");
        String oblCMayo = po.getProperty("etiqueta.CSPoblcmayor");
        String oblorden = po.getProperty("etiqueta.CSPoblorden");
        String oblccost = po.getProperty("etiqueta.CSPoblccost");
        String oblErrAdpos = po.getProperty("etiqueta.CSPoblerrAffpos");
        String oblErrModpos = po.getProperty("etiqueta.CSPoblerrModpos");
        String elimpos = po.getProperty("etiqueta.CSPServDel");
        String servno = po.getProperty("etiqueta.CSPServInval");
        String timppo = po.getProperty("etiqueta.CSPObTposSer");
        String errguar = po.getProperty("etiqueta.CSPDocumentoContErr");
        String notexitd = po.getProperty("etiqueta.CSPoblNoexitsda");
        String documco = po.getProperty("etiqueta.CSPDocumentoCont");
        String PosNotabla = po.getProperty("etiqueta.CSPoblNoexitsda");
        String solicinott = po.getProperty("etiqueta.CSPStratpe");
        String solex = po.getProperty("etiqueta.CSPexitmodsa");
        String indp = po.getProperty("etiqueta.CSPlibinpe");
        String CSPUMECatalogo = po.getProperty("etiqueta.CSPUMECatalogo");
        String Sering = po.getProperty("etiqueta.CSPServUnda");
        String SerCan = po.getProperty("etiqueta.CSPServCan");
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
                var pag = p.charAt(36);
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
                    case 3:
                        msg = '<%=formcan%>';
                        break;
                    case 4:
                        msg = '<%=formpre%>';
                        break;
                    case 5:
                        msg = '<%=fehcin%>';
                        break;
                    case 6:
                        msg = '<%=menValores%>';
                        break;
                    case 7:
                        msg = '<%=errgco%>';
                        break;
                    case 8:
                        msg = '<%=errmat%>';
                        break;
                    case 9:
                        msg = '<%=errcen%>';
                        break;
                    case 10:
                        msg = '<%=erralm%>';
                        break;
                    case 11:
                        msg = '<%=errume%>';
                        break;
                    case 12:
                        msg = '<%=errgar%>';
                        break;
                    case 13:
                        msg = '<%=oblgc%>';
                        break;
                    case 14:
                        msg = '<%=oblma%>';
                        break;
                    case 15:
                        msg = '<%=oblcan%>';
                        break;
                    case 16:
                        msg = '<%=cant1%>';
                        break;
                    case 17:
                        msg = '<%=oblfec%>';
                        break;
                    case 18:
                        msg = '<%=oblcen%>';
                        break;
                    case 19:
                        msg = '<%=oblum%>';
                        break;
                    case 20:
                        msg = '<%=oblga%>';
                        break;
                    case 21:
                        msg = '<%=Cannt%>';
                        break;
                    case 22:
                        msg = '<%=oblTxtbrv%>';
                        break;
                    case 23:
                        msg = '<%=oblCMayo%>';
                        break;
                    case 24:
                        msg = '<%=oblorden%>';
                        break;
                    case 25:
                        msg = '<%=oblccost%>';
                        break;
                    case 26:
                        msg = '<%=oblErrAdpos%>';
                        break;
                    case 27:
                        msg = '<%=oblErrModpos%>';
                        break;
                    case 28:
                        msg = '<%=notexitd%>';
                        break;
                    case 29:
                        msg = '<%=documco%> ' + va;
                        break;
                    case 30:
                        msg = '<%=errguar%>';
                        break;
                    case 31:
                        msg = '<%=timppo%>';
                        break;
                    case 32:
                        msg = '<%=servno%>';
                        break;
                    case 33:
                        msg = '<%=Sering%>';
                        break;
                    case 34:
                        msg = '<%=necobl%>';
                        break;
                    case 35:
                        msg = '<%=NesNot%> ' + va;
                        break;
                    case 36:
                        msg = '<%=notmodi%>';
                        break;
                    case 37:
                        msg = '<%=elimpos%>';
                        break;
                    case 38:
                        msg = '<%=PosNotabla%>';
                        break;
                    case 39:
                        msg = '<%=solicinott%>';
                        break;
                    case 40:
                        msg = '<%=solex%>';
                        break;
                    case 41:
                        msg = '<%=indp%>';
                        break;
                    case 42:
                        msg = '<%=CSPUMECatalogo%>';
                        break;
                    case 43:
                        msg = '<%=SerCan%>';
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
            function ShowMsgWindow(m, im, au, val) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=ERCuenM%>' + " " + val;
                        break;
                    case 1:
                        msg = '<%=ERCCost%>' + " " + val;
                        break;
                    case 2:
                        msg = '<%=ERORD%>' + " " + val;
                        break;
                    case 3:
                        msg = '<%=Folioexc%>';
                        break;
                    case 4:
                        msg = '<%=CmCcAs%>';
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                var ancho = 570;
                var alto = 150;
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
            function Exit(idm, au) {
                var msg = "";
                switch (idm) {
                    case 1:
                        msg = '<%=Cando%>';
                        break;
                    case 2:
                        msg = "<%=findo%>";
                        break;

                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#msgexit').html(msg);
                var ventana = $('#MensajeSalirModulo');
                var ancho = 350;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.css({top: y + "px", left: x + "px"});
                ventana.css('display', 'block');
                var theHandle = document.getElementById("handleDoc");
                var theRoot = document.getElementById("MensajeSalirModulo");
                Drag.init(theHandle, theRoot);
                $('#FinalizarNODoc').focus();

            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleSolped.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>    
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/ModificarSolped.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.CSPModifi_title"));%></title>       
    </head>
    <body>    
        <script>
            $(function () {
                var fehSet = document.getElementById('FecEntrega');
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
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
                    $('#FecEntrega').focus();
                    $('#FecEntrega').val('');
                } else {
                    borramsg();
                }
            }
            function validarUserCanSAP() {
                var loge = '<%=Nombre%>';
                var solici = $('.tdsol:first').text();
                if (loge == solici) {
                    return true;
                }
                return false;
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
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input id="guardar" type="image" src="images/guarda.PNG"/> 
            <input id="guardarSAP" type="image" src="images/guarda.PNG"/> 
            <input  id="regresar" type="image" src="images/regresaOFF.png"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" />
            <input  id="EditS" type="image" src="images/Editar.PNG" />
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.CSPModifi_title"));%></h1></div> 
        </div>            
        <div class="contenido">
            <div class="ContentSolped">
                <div class="divCab">
                    <section class="SecI">
                        <label><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></label><select id="ClaseDoc" style="width: 40%">
                        </select>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPNumNecesidad"));%></label><input type="text" id="necesidadSolp" maxlength="10" style="width: 25%; text-transform: uppercase;" /><button id="matchSolped" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPOrgCompras"));%></label><select id="OrgCompras"  style="width: 22%;"></select>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input onpaste="return false" type="text" id="GpoCompras" maxlength="3" style="width: 20%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchGrupoCompra" class='BtnMatchIcon2'></button>
                        <hr>
                        <input tyoe="text" id="SAMCancel" hidden>
                        <input tyoe="text" id="SAPCancel" hidden>
                    </section>
                    <section class="SecD">
                        <img disabled  id="ICONAD"><input readOnly type="text" id="mensgesolped" style="border:none; background: none"/></span>
                        <textarea rows="6" cols="6" style="resize:none;" id="TextCabecera_SP"></textarea>
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
                    <label><%out.println(po.getProperty("etiqueta.CSPDetallePosicion"));%></label><select id="Distribucion_SP" ></select><button id="btnAddPos" ><%out.println(po.getProperty("etiqueta.CSPAgregaPos"));%></button><button id="btnModPos" ><%out.println(po.getProperty("etiqueta.CSPModPos"));%></button><button id="btnEliPos"><%out.println(po.getProperty("etiqueta.CSPEliPos"));%></button>
                </div>
                <div id="datossobrecargados" hidden></div>
                <div class="divImputacion">
                    <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                    <hr id="LineSC">
                    <div class="divTipos">
                        <div class="tip1">
                            <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion2"));%></label><select id="TipoImputacion" style="width:20%;"></select>
                            <hr>
                        </div>
                        <div class="tip2">
                            <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición2"));%></label><select id="TipoPosicion" style="width:20%;"></select>
                            <hr>
                        </div>
                        <div class="tip3">
                            <button id="btnservicios" style="background-image: url(images/servicios.PNG); background-repeat: no-repeat; padding-right: 1%; padding-left: 8%; padding-bottom: .5%;" ><%out.println(po.getProperty("etiqueta.CSPServicio"));%></button>                                    
                        </div>
                    </div>
                    <div class="divimpsol">
                        <div class="inp1">
                            <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="Material" maxlength="18" onpaste="return false" style="width:35%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchMaterial" class='BtnMatchIcon2'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPCantida"));%></label><input type="text" id="Cantidad"  onpaste="return false" onpaste="return false" maxlength="11"  style="width: 25%; background-repeat: no-repeat;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPFechEnt"));%></label><input  type="text" id="FecEntrega" onpaste="return false"  maxlength="10" style="witdh:20%; background-repeat: no-repeat;"><button class="BtnMatchIcon" id="btnfecha"></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="Centro" onpaste="return false"  maxlength="4" style="width: 20%; text-transform: uppercase; background-repeat: no-repeat;" /><button id="matchCentro" class='BtnMatchIcon2'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPAlmac"));%></label><input type="text" id="Almacen" onpaste="return false" maxlength="4" style="width: 20%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchAlmacen" class='BtnMatchIcon2'></button>
                            <hr>
                        </div>
                        <div class="inp2">
                            <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="Txtbrve"  maxlength="40" onpaste="return false" style="width: 60%; background-repeat: no-repeat;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="unidamedida"  maxlength="3" onpaste="return false" style="width: 10%; background-repeat: no-repeat; text-transform: uppercase;" /><button id="matchUM" class="BtnMatchIcon"></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></label><input type="text" id="GpoArticulo"  maxlength="9" onpaste="return false" style="width: 25%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchGpoArticulo" class="BtnMatchIcon"></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CSPSolic"));%></label><input type="text" id="solicitante" readOnly value= "<%=Nombre%>" style="width: 25%; background-repeat: no-repeat;"/>
                            <hr>
                        </div>
                    </div>
                    <br>
                    <div class="subimputacion">
                        <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion"));%></label>
                        <hr id="LineSubIm">
                        <div class="subinn1">
                            <label><%out.println(po.getProperty("etiqueta.CSPCMayor"));%></label><input type="text" id="ctaMayor"  maxlength="10" onpaste="return false" style="width: 30%; background-repeat: no-repeat;"/><button id="matchCtaMayor" class="BtnMatchIcon2"></button>
                            <hr>
                        </div>
                        <div class="subinn2">
                            <label><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><input type="text" id="CenCosto"  maxlength="10" onpaste="return false" style="width: 30%; text-transform: uppercase; background-repeat: no-repeat"/><button id="matchCCosto" class="BtnMatchIcon2"></button>
                            <hr>
                        </div>
                        <div class="subinn3">
                            <label><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></label><input type="text"  maxlength="12"  id="Orde" style="width: 30%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="matchOrden" class="BtnMatchIcon2"></button> / <input type="text" style="width:30%; background: none; border: none;" readOnly id="OrdSAM"/>
                            <hr>
                        </div>
                    </div>
                </div>
                <div class="Divtextposicion">
                    <label><%out.println(po.getProperty("etiqueta.CSPCeTextPsoci"));%></label>
                    <hr style="border: none">
                    <textarea style="resize:none;"  id="TextPosicion_SP"></textarea>
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
                        <table id="tabSolpedSer" class="TablaCont2">
                            <thead>
                                <tr id="CabeceraTabla">
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td><%out.println(po.getProperty("etiqueta.CSPPosicio"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.SerLinea"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.SerServic"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.CSPCantida"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.CSPUM"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.CSPNumSerDesc"));%></td>
                                </tr> 
                            </thead>
                            <tbody id="glob">                     
                            </tbody>
                        </table>
                    </div>
                    <section id="botonesadddel">
                        <input id="AgregarFilaServicios" type="image" src="images/ADD.PNG" style="vertical-align: middle"/>
                        <input id="BorrarFilaServicios" type="image" src="images/DELETEADD.PNG" style="padding-top: 1px; vertical-align: middle; margin-left: -1%;"/>
                    </section>
                </div>
                <div class="BonotServies">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="sevad"/>                       
                    <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="cursor:pointer;" id="CloseServi"/>
                </div>
            </div>
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
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
        <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
            <div id="handleDoc"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.FinalizarDocumento_FIDO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeSalirModulo();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
            <div class="ContenidoFinalizarDoc">
                <label id="msgexit"></label>
                <br>
                <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.CSPcontinu"));%></label>
            </div>  <div id="Windowmsg" class="VentanaModalMensajes">
                <div id="handleMsg"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPInfom"));%></label><div class="BotonCerrar_Matc" id="CerrarVentanaMsg1"><label >X</label></div></div>
                <div class="imginfo"><IMG id="iocnomsgso" ALT="Info"></div>
                <div class="InfoMensaje"><label id="msgss"></label></div>
                <div class="okmsg">
                    <input id="CloMsg" type="image" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>   
                </div>
            </div>
            <div class="BotenesFinalizarDocumento">
                <button id="FinalizarSIDoc" style="cursor:pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                <button id="FinalizarNODoc" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
            </div>
        </div>
        <div id="VentanaModalFolioSolped" class="VentanaModal">
            <div id="handle15"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPVisNumSol"));%></label><div class="BotonCerrar_Matc" id="closeMCFolio1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retFolio"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamsolped" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPVisNumSol2"));%></label><input type="text" id="BusSolpedSAM" style="width:35%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input type="date" id="fechasol" style="width:35%;" maxlength="10" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax0" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="oksolp"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="closeMCFolio2"/>
                </div>
            </div>
            <div id="ConsultaTablaSolped" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSolped">
                        <div class="fixedY" id="fixedYSolped">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></th><th><%out.println(po.getProperty("etiqueta.GralFecha"));%></th>
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
        <div id="VentanaModalGCompras" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><div class="BotonCerrar_Matc" id="CerrarMCOrg1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retgcom"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamGCompras_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></label><input type="text" id="BusGCompras" maxlength="3" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPDenGCompras"));%></label><input type="text" id="BusDenGCompras" maxlength="20" style="width:35%;"/>
                        <hr>                            
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax2"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okGCompras"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCOrg2"/>
                </div>
            </div>
            <div id="ConsultaTablaGCompras" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGCompras">
                        <div class="fixedY" id="fixedYGCompras">
                            <table>
                                <thead> 
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPGrpoCompras"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenGCompras"));%></th>
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
        <div id="VentanaModalMateriales" class="VentanaModalMate">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><div class="BotonCerrar_Matc" id="CerraMCMate1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retmate"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamMateriales_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></label><input type="text" id="BusMaterial" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTextoBrveMaterial"));%></label><input type="text" id="BusTextoMaterial" style="width:35%;"/>
                        <hr>   
                        <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text"  id="BusCentroMaterial" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CPSMateriaTipo"));%></label><input type="text"  id="BusTipoMat" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax5"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCMate2"/>
                </div>
            </div>            
            <div id="ConsultaTablaMaterial" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scrollM" id="table-scrollMaterial">
                        <div class="fixedYM" id="fixedYMaterial">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPMaterial"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTextoBrveMaterial"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CPSMateriaTipo"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXM" id="cargarDatosMateriales">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><div class="BotonCerrar_Matc" id="CerrarMCCentro1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retcentro" ><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamCentro_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="BusCentro" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPNombre"));%></label><input type="text" id="BusDesCentro" style="width:35%;"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax6" style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCentro"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCCentro2"/>
                </div>
            </div>
            <div id="ConsultaTablaCentro" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr><th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPNombre"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoCentro">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAlmacen" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><div class="BotonCerrar_Matc" id="CerrarMCAlmacen1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retAlmacen"><%out.println(po.getProperty("etiqueta.CSPBusquedaDenAlma"));%></button><hr></div>
            <div id="BuscarParamAlmacen_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></label><input type="text" id="BusAlmacen" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPDenAlm"));%></label><input type="text" id="BusDenAlm" style="width:35%;"/>
                        <hr>                        
                        <label><%out.println(po.getProperty("etiqueta.CSPCentro"));%></label><input type="text" id="BusCentroAlmacen" style="width:35%; text-transform: uppercase;"/>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax7"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAlmacen"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCAlmacen2"/>
                </div>
            </div>
            <div id="ConsultaTablaAlmacen" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmacen">
                        <div class="fixedY" id="fixedYAlmacen">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPAlmacen"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenAlm"));%></th><th><%out.println(po.getProperty("etiqueta.CSPCentro"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoAlmacen">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalUM" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPUMSPTitulo"));%></label><div class="BotonCerrar_Matc" id="CerrarMCUMedida1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retUMedida"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamUM_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></label><input type="text" id="BusUM" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPUMTexto"));%></label><input type="text" id="BusTextoUM" style="width:35%;"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax8"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUnidadMedida"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCUMedida2"/>
                </div>
            </div>
            <div id="ConsultaTablaUM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUM">
                        <div class="fixedY" id="fixedYUM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPUnidadMedida"));%></th><th><%out.println(po.getProperty("etiqueta.CSPUMTexto"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalGArticulos" class="VentanaModalGA">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></label><div class="BotonCerrar_Matc" id="CerrarMCGArticulo1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retGArticulo"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamGArticulos_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></label><input type="text" id="BusGArtiulos" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPUMDenGArticulos"));%></label><input type="text" id="BusDenGArt" style="width:35%;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CSPUMDeSGArticulos"));%></label><input type="text" id="BusDesGArt" style="width:35%;"/>
                        <hr>                   
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax9"   style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okGArticulos"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCGArticulo2"/>
                </div>
            </div>
            <div id="ConsultaTablaGArticulos" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGArticulos">
                        <div class="fixedY" id="fixedYGArticulos">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPGpoArt"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPUMDenGArticulos"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPUMDeSGArticulos"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoGArticulos">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCuentaMayor" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPClaseCoste"));%></label><div class="BotonCerrar_Matc" id="CerraMCCMayor1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retCMayor"><%out.println(po.getProperty("etiqueta.CSPNumCuentaPl"));%></button><hr></div>
            <div id="BuscarParamCuentaMayor" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPNumCuentaMay"));%></label><input type="text" id="BusNCuenta" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPDesCuMaypr"));%></label><input type="text" id="BusDesNCuenta" style="width:35%;"/>
                        <hr>                               
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax10"   style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCMayor"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCCMayor2"/>
                </div>
            </div>
            <div id="ConsultaTablaCMayor" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCMayor">
                        <div class="fixedY" id="fixedYCMayor">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPNumCuentaMay"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDesCuMaypr"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoCMayor">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentroCosto" class="VentanaModal">
            <div id="handle11"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><div class="BotonCerrar_Matc" id="CerrarMcCCosto1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retCCosto"><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></button><hr></div>
            <div id="BuscarParamCCosto" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></label><input type="text" id="BusCCosto" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPDenCentroCosto"));%></label><input type="text" id="BusDemCCosto" style="width:35%;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CSPSocie"));%></label><input type="text" id="BusSoc" style="width:35%; text-transform: uppercase;"/>
                        <hr>                  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3" id="numAcMax11"  value="100" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCCcosto"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMcCCosto2"/>
                </div>
            </div>
            <div id="ConsultaTablaCCosto" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCCosto">
                        <div class="fixedY" id="fixedYCCosto">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPCentroCosto"));%></th><th><%out.println(po.getProperty("etiqueta.CSPDenCentroCosto"));%></th><th><%out.println(po.getProperty("etiqueta.CSPSocie"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCCosto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalOrden" class="VentanaModalOR">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></label><div class="BotonCerrar_Matc" id="CerrarMCOrden1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retOrden"><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></button><hr></div>
            <div id="BuscarParamOrden" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPClOrd"));%></label><input type="text" id="BusClaseOrd" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></label><input type="text" id="BusNumOrd" style="width:35%; text-transform: uppercase;t"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CSPTXTBRVOrd"));%></label><input type="text" id="BustxtOrd" style="width:35%;"/>
                        <hr>                   
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax12"  style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okOrden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCOrden2"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden">
                        <div class="fixedY" id="fixedYOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPOrdn"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTXTBRVOrd"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.CSPClOrd"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalServicios" class="VentanaModal">
            <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPNumSer"));%></label><div class="BotonCerrar_Matc" id="CloseMCSer1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="RetSerma"><%out.println(po.getProperty("etiqueta.CSPNumSerDes"));%></button><hr></div>
            <div id="BuscarParamServicio" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CSPNumSer"));%></label><input type="text" id="BusNumServicio" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPNumSerDesc"));%></label><input type="text" id="BusDesServicio" style="width:35%;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlentgh="3"  id="numAcMax13"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okdSer"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CloseMCSer2"/>
                </div>
            </div>
            <div id="ConsultaTablaServicios" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollServicios">
                        <div class="fixedY" id="fixedYServicios">
                            <table>
                                <thead>
                                    <tr>
                                            <th><%out.println(po.getProperty("etiqueta.CSPNumSer"));%></th><th><%out.println(po.
                                                    getProperty("etiqueta.CSPNumSerDesc"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosServicios">
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

                    function verificaCentPorUsuario() {
                        var centr = '<%=Centro%>';
                        var c = $('#Centro');
                        var mc = $('#BusCentroMaterial');
                        if (centr == null || centr == "") {
                            c.val('');
                            c.prop('disabled', false);
                            c.css('background-image', 'url(images/necesario.PNG)');
                            mc.val('');
                            mc.prop('disabled', false);
                        } else {
                            c.val(centr);
                            c.prop('disabled', true);
                            mc.val(centr);
                            mc.prop('disabled', true);
                        }
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