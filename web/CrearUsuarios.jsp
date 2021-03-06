<%-- 
    Document   : VisualizarUsuarios
    Created on : 29/06/2016, 12:11:59 PM
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
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
        String Mens = po.getProperty("etiqueta.CompObligatorios");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String claveMayor = po.getProperty("etiqueta.ContraMayor_USCR");
        String ClavesInco = po.getProperty("etiqueta.ContraIgual_USCR");
        String ExisUser = po.getProperty("etiqueta.UsuarioExist");
        String UsuarioOK = po.getProperty("etiqueta.UsuarioOkGurda_USCR");
        String UsuarioEr = po.getProperty("etiqueta.usuaioMalGuerd_USCR");
        String CorreoInv = po.getProperty("etiqueta.CorrNoVal");
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
        ////// menu
        String menu_m = po.getProperty("etiqueta.Menu_menu");
        String conf_m = po.getProperty("etiqueta.Configuracion_menu");
        String usua_m = po.getProperty("etiqueta.Usuarios_menu");
        String crear_m = po.getProperty("etiqueta.Crear_menu");
        String modif_m = po.getProperty("etiqueta.Modi_menu");
        String visua_m = po.getProperty("etiqueta.Vis_menu");
        String folios_m = po.getProperty("etiqueta.Folios_menu");
        String repo_m = po.getProperty("etiqueta.Reportes_menu");
        String reposam_m = po.getProperty("etiqueta.ReportesSAM_menu");
        String gestMat_m = po.getProperty("etiqueta.GestionMateriales_menu");
        String organi_m = po.getProperty("etiqueta.Organizacion_menu");
        String centr_m = po.getProperty("etiqueta.Centros_menu");
        String almxcen_m = po.getProperty("etiqueta.AlmacenCentros_menu");
        String datMae_m = po.getProperty("etiqueta.DatosMaestrosMan_menu");
        String DatMaMat_m = po.getProperty("etiqueta.DatosMaestrosMat_menu");
        String CatCom_m = po.getProperty("etiqueta.DatosMaestrosCatComp_menu");
        String provee_m = po.getProperty("etiqueta.DatosMaestrosCatCompVisProv_menu");
        String infore_m = po.getProperty("etiqueta.DatosMaestrosCatCompVisInfo_menu");
        String Clien_m = po.getProperty("etiqueta.DatosMaestrosClientes_menu");
        String VisuCl_m = po.getProperty("etiqueta.DatosMaestrosVisCliente_menu");
        String Compr_m = po.getProperty("etiqueta.Compras_menu");
        String ComSP = po.getProperty("etiqueta.ComprasSolCom_menu");
        String PedCom = po.getProperty("etiqueta.ComprasPedComp_menu");
        String VisuPe_m = po.getProperty("etiqueta.ComprasPedCompVis_menu");
        String GestSt_m = po.getProperty("etiqueta.GestionStock_menu");
        String DocMat_m = po.getProperty("etiqueta.GestionStockDocMat_manu");
        String DocMatV_m = po.getProperty("etiqueta.GestionStockDocMatVisu_menu");
        String LiMovMat_m = po.getProperty("etiqueta.GestionStockDocMatListMovMat_menu");
        String movimi_m = po.getProperty("etiqueta.GestionStockMovimientos_menu");
        String MovMat_m = po.getProperty("etiqueta.GestionStockMovimMovMat_menu");
        String MovRes_m = po.getProperty("etiqueta.GestionStockMovimReservas_menu");
        String MovEntSer_m = po.getProperty("etiqueta.GestionStockMovimEntServicios_menu");
        String StkMov_m = po.getProperty("etiqueta.GestionStockStockMaterial_menu");
        String GesMan_m = po.getProperty("etiqueta.GestionMantenim");
        String GesMaDM_m = po.getProperty("etiqueta.DatosMaestrosMan_menu");
        String ubicac_m = po.getProperty("etiqueta.DatosMaestrosUbicac_menu");
        String equip_m = po.getProperty("etiqueta.Equipos_menu");
        String bommeq_m = po.getProperty("etiqueta.BoomEqui_menu");
        String CreaMat_m = po.getProperty("etiqueta.DatosMaestrosMatCrear_menu");
        String ModMat_m = po.getProperty("etiqueta.DatosMaestrosMatModif_menu");
        String VisMat_m = po.getProperty("etiqueta.DatosMatesrosMatVisual_menu");
        String HojRut_m = po.getProperty("etiqueta.HojaRuta_menu");
        String MonEquip_m = po.getProperty("etiqueta.MonitorEquipos_menu");
        String MonECont_m = po.getProperty("etiqueta.MonitorContaPlanEq_menu");
        String AvisoPM_m = po.getProperty("etiqueta.AvisosPM_menu");
        String MonitorAvisoPM_m = po.getProperty("etiqueta.MonitorAvisosPM_menu");
        String OrdenePM_m = po.getProperty("etiqueta.OrdenesPM_menu");
        String ListOrden_m = po.getProperty("etiqueta.ListaOrdenes_menu");
        String Notif_m = po.getProperty("etiqueta.NotificacionesPM");
        String GestCal = po.getProperty("etiqueta.GestionCalidad");
        String GestCal_PIM = po.getProperty("etiqueta.PlanInspeccioMaterial");
        String GestCalAvi_PIM = po.getProperty("etiqueta.MedidasAviso_menu");
        String GestCalLLI_PIM = po.getProperty("etiqueta.LoteInspecLis_menu");
        String GestDoc = po.getProperty("etiqueta.GestionDocument");
        String GestVisDoc = po.getProperty("etiqueta.GestVisDoc");
        String listasolp = po.getProperty("etiqueta.ListaSolpedR");
        String CenNoEnc = po.getProperty("etiqueta.CenNoVal");
        String ListaRes = po.getProperty("etiqueta.ListaReser");
        String flujoDoc = "Flujo de documentos";
        String flujoDeu = "Saldo de clientes";
        String RporteStock1000 = "Reporte Almacén 1000";
    %> 
    <%!
        String verificarP(char per) {
            String x = "";
            if (per == '0') {
                x = "none";
            } else {
                x = "visible";
            }
            return x;
        }

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
                var pag = p.charAt(2);
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
                        msg = '<%=CenNoEnc%>';
                        break;
                    case 2:
                        msg = '<%=Mens%>';
                        break;
                    case 3:
                        msg = '<%=claveMayor%>';
                        break;
                    case 4:
                        msg = '<%=ClavesInco%>';
                        break;
                    case 5:
                        msg = '<%=ExisUser%>' + " " + $('#User_U').val().toUpperCase();
                        break;
                    case 6:
                        msg = '<%=CorreoInv%>';
                        break;
                    case 7:
                        msg = '<%=ExisUser%>';
                        break;
                    case 8:
                        msg = '<%=UsuarioOK%>';
                        break;
                    case 9:
                        msg = '<%=UsuarioEr%>';
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
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/StyleGeneral.css">   
        <link rel="stylesheet" href="css/StyleUsuarios.css">   
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/sha1.js"></script>
        <script src="js/CrearUsuarios.js"></script>
        <script src="js/menu.js"></script>
        <script src="js/jquerys.js"></script>   
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.js"></script>
        <!--//permisos-->
        <link href="css/prettify.css" rel="stylesheet">
        <script src="js/prettify.js" type="text/javascript"></script>
        <link href="css/exec.dyn.css" rel="stylesheet" type="text/css">
        <link href="css/ui.dynatree.css" rel="stylesheet" type="text/css">
        <script src="js/exec.dyn.js" type="text/javascript"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="js/jquery-ui.custom.js" type="text/javascript"></script>
        <script src="js/jquery.dynatree.js" type="text/javascript"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.CrearUsser_USUA"));%></title>        
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
            <input  id="guardar" type="image" src="images/guarda.PNG"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar"type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.CrearUsser_USUA"));%></h1></div>
        </div>
        <div class="contenido">
            <div class="CrearUser_USU">
                <div class="DivDatosUser_USU">
                    <label><%out.println(po.getProperty("etiqueta.DatosUsuario_USUCR"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="CompUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Centro_USCR"));%></label><input type="text" maxlength="4"  id="Centro_U" style="width:8%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></label><input type="text" id="User_U" style="width:12%; text-transform: uppercase;" maxlength="10"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Password_USCR"));%></label><input type="password" placeholder="  *****************" id="Pwd1_U" style="width: 18%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ConfirPass_USCR"));%></label><input type="password" placeholder="  *****************" id="pwd2_U" style="width:18%;"/>
                        <hr>
                    </div>
                </div>   
                <div class="DivDatosUsePerson_USU">
                    <label><%out.println(po.getProperty("etiqueta.DatosPeson_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="DivIzquUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Nombre_USCR"));%></label><input type="text" id="Nombre_U" style="width: 50%; text-transform: uppercase;" maxlength="50"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApePat_USCR"));%></label><input type="text" id="APP_U" maxlength="50" style="width: 50%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApeMat_USCR"));%></label><input type="text" id="APM_U" maxlength="50" style="width:50%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.RFC_USCR"));%></label><input type="text" id="RFC_U" maxlength="15" style="width:50%; text-transform: uppercase;"/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Corre_USCR"));%></label><input type="email" maxlength="100" id="Email_U" style="width:50%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono_USCR"));%></label><input type="text" maxlength="20" id="Tel1_U" style="width:50%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono2_USCR"));%></label><input type="text" maxlength="20" id="Tel2_U"  style="width:50%;"/>
                        <hr>
                    </div>
                </div> 
                <div class="Direc_USCR">
                    <label><%out.println(po.getProperty("etiqueta.Direccion_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US"> 
                    <div class="DivIzquUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Calle_USCR"));%></label><input type="text" maxlength="100" id="Calle_U" style="width:50%; text-transform: uppercase;"" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumInt_USCR"));%></label><input type="text" maxlength="20" id="NumInt_U" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumExt_USCR"));%></label><input type="text" maxlength="20" id="NumExt_U" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Colonia_USCR"));%></label><input type="text" maxlength="100" id="Colonia_U" style="width:45%; text-transform: uppercase;""/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Poblacion_USCR"));%></label><input type="text" maxlength="100" id="Poblacion_U" style="width:40%; text-transform: uppercase;""/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Estado_USCR"));%></label><input type="text" maxlength="20" id="Estado_U" style="width: 40%; text-transform: uppercase;""/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CvePais"));%></label><input type="text" id="Pais_U" maxlength="20" style="width: 45%; text-transform: uppercase;""/>
                        <hr>
                    </div>
                </div>
                <div class="DivPermisoU_USCR">
                    <label><%out.println(po.getProperty("etiqueta.Permisos_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US"> 
                    <div id="tree3">
                    </div> 
                </div>
                <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
                    <div id="handleDoc"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.FinalizarDocumento_FIDO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeSalirModulo();"><label >X</label></div></div>
                    <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
                    <div class="ContenidoFinalizarDoc">
                        <label><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc_FIDO"));%></label>
                        <br>
                        <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc2_FIDO"));%></label>
                    </div>
                    <div class="BotenesFinalizarDocumento">
                        <button id="FinalizarSIDoc" style="cursor:pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                        <button id="FinalizarNODoc" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
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
                    var WriteDate = $('#fecha');
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        WriteDate.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        WriteDate.html(fechaActual);
                    } else {
                        WriteDate.html("Fecha Indefinida");
                    }
                </script>
            </div>
        </footer>
    </body>
    <script>
        function test() {
            var key = "";
            key = key + getPermission("conf"); //  0 Configuracion
            key = key + getPermission("conf_user"); ////  1  Configuracion - Usuario
            key = key + getPermission("conf_userCrear"); // 2 Configuracion - Usuario - Crear
            key = key + getPermission("conf_userModif"); // 3 Configuracion - Usuario - Modificar
            key = key + getPermission("conf_userVisual"); // 4 Configuracion -  Usuario - Visualizar
            key = key + getPermission("conf_fol"); // 5 Configuracion - Folios 
            key = key + getPermission("conf_folCrear"); // 6 Configuracion - Folios - Crear
            key = key + getPermission("conf_folModif"); // 7 Configuracion Folio - Modificar
            key = key + getPermission("conf_folVisual"); // 8 Configuracion Folio - Visualizar
            key = key + getPermission("conf_repo"); // 9 Reportes
            key = key + getPermission("conf_repoSAM"); // 10 Reportes SAM
            key = key + getPermission("gestMat"); // 11 G. Materiales
            key = key + getPermission("gestMat_org"); // 12 G. Materiales - Organizacion
            key = key + getPermission("gestMat_orgCen"); // 13 G. Materiales - Organizacion - Centro
            key = key + getPermission("gestMat_orgAlmXc"); // 14 G. Materiales - Organizacion - Alm x centro
            key = key + getPermission("gestMat_datM"); // 15 G. Materiales - Datos Maestros
            key = key + getPermission("gestMat_datMmat"); // 16 G. Materiales - Datos Maestros - Materiales
            key = key + getPermission("gestMat_datMmatCrear"); // 17 G. Materiales - Datos Maestros - Materiales - Crear
            key = key + getPermission("gestMat_datMmatMod"); // 18 G. Materiales - Datos Maestros - Materiales - Modificar
            key = key + getPermission("gestMat_datMmatVis"); // 19 G. Materiales - Datos Maestros - Materiales - Visualizar
            key = key + getPermission("gestMat_datMCC"); // 20 G. Materiales - Datos Maestros - Cat. Compras 
            key = key + getPermission("gestMat_datMCC_Prov"); // 21 G. Materiales - Datos Maestros - Cat. Compras - Proveedor
            key = key + getPermission("gestMat_datMCC_Prov_cre"); // 22 G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Crear
            key = key + getPermission("gestMat_datMCC_Prov_mod"); // 23 G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Modificar
            key = key + getPermission("gestMat_datMCC_Prov_vis"); // 24 G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Visualizar
            key = key + getPermission("gestMat_datMCC_InfoRec"); // 25 G. Materiales - Datos Maestros - Cat. Compras - Inforecord
            key = key + getPermission("gestMat_datMCC_InfoRec_cre"); // 26 G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Crea
            key = key + getPermission("gestMat_datMCC_InfoRec_mod"); // 27 G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Modifica
            key = key + getPermission("gestMat_datMCC_InfoRec_vis"); // 28 G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Visualiza
            key = key + getPermission("gestMat_datMCC_Clie"); // 29 G. Materiales - Datos Maestros - Cat. Compras - Clientes 
            key = key + getPermission("gestMat_datMCC_Clie_cre"); // 30 G. Materiales - Datos Maestros - Cat. Compras - Clientes - Crea
            key = key + getPermission("gestMat_datMCC_Clie_mod"); // 31 G. Materiales - Datos Maestros - Cat. Compras - Clientes - Modifica
            key = key + getPermission("gestMat_datMCC_Clie_vis"); // 32 G. Materiales - Datos Maestros - Cat. Compras - Clientes - Visualiza
            key = key + getPermission("gestMat_Comp"); // 33 G. Materiales - Compras
            key = key + getPermission("gestMat_Comp_SC"); // 34 G. Materiales - Compras - Solicitud Compras
            key = key + getPermission("gestMat_Comp_SC_cre"); // 35 G. Materiales - Compras - Solicitud Compras
            key = key + getPermission("gestMat_Comp_SC_mod"); // 36 G. Materiales - Compras - Solicitud Compras - Crear
            key = key + getPermission("gestMat_Comp_SC_vis"); // 37 G. Materiales - Compras - Solicitud Compras - Modificar
            key = key + getPermission("gestMat_Comp_SC_lisSol"); // 38 G. Materiales - Compras - Solicitud Compras - Visualizar
            key = key + getPermission("gestMat_Comp_PC"); // 39 G. Materiales - Compras - Pedidos de compra
            key = key + getPermission("gestMat_Comp_PC_vis"); // 40 G. Materiales - Compras - Pedidos de compra - Visualizar
            key = key + getPermission("gestMat_GesStk"); // 41 G. Materiales - G. Stock
            key = key + getPermission("gestMat_GesStk_DocMat"); // 42 G. Materiales - G. Stock - Doc Material
            key = key + getPermission("gestMat_GesStk_DocMat_VisDocMar"); // 43 G. Materiales - G. Stock - Doc Material - Visualizar Doc Mat
            key = key + getPermission("gestMat_GesStk_DocMat_ListMov"); // 44 G. Materiales - G. Stock - Doc Material - Listas Mov
            key = key + getPermission("gestMat_GesStk_Movim"); // 45 G. Materiales - G. Stock - Movimientos
            key = key + getPermission("gestMat_GesStk_Movim_MovMat"); // 46 G. Materiales - G. Stock - Movimientos - Movimientos Materiales
            key = key + getPermission("gestMat_GesStk_Movim_Reser"); // 47 G. Materiales - G. Stock - Movimientos - Reservas
            key = key + getPermission("gestMat_GesStk_Movim_Reser_cre"); // 48 G. Materiales - G. Stock - Movimientos - Reservas - Crear
            key = key + getPermission("gestMat_GesStk_Movim_Reser_mod"); // 49 G. Materiales - G. Stock - Movimientos - Reservas - Modificar
            key = key + getPermission("gestMat_GesStk_Movim_Reser_vis"); // 50 G. Materiales - G. Stock - Movimientos - Reservas - Visualizar
            key = key + getPermission("gestMat_GesStk_Movim_Reser_LisRes"); // 51 G. Materiales - G. Stock - Movimientos - Reservas - Listas de reservas
            key = key + getPermission("gestMat_GesStk_Movim_EntSer"); // 52 G. Materiales - G. Stock - Movimientos - Entradas de Servicio
            key = key + getPermission("gestMat_GesStk_StkMat"); // 53 G. Materiales - G. Stock - Stock Material
            key = key + getPermission("gestCom"); // 54 G. Comercial
            key = key + getPermission("gestCom_Cot"); // 55 G. Comercial - Cotizacion
            key = key + getPermission("gestCom_Cot_cre"); // 56 G. Comercial - Cotizacion - Crear
            key = key + getPermission("gestCom_Cot_mod"); // 57 G. Comercial - Cotizacion - Modificar
            key = key + getPermission("gestCom_Cot_vis"); // 58 G. Comercial - Cotizacion - Visualizar
            key = key + getPermission("gestCom_Ped"); // 59 G. Comercial - Pedidos
            key = key + getPermission("gestCom_Ped_cre"); // 60 G. Comercial - Pedidos - Crear
            key = key + getPermission("gestCom_Ped_mod"); // 61 G. Comercial - Pedidos - Modificar
            key = key + getPermission("gestCom_Ped_vis"); // 62 G. Comercial - Pedidos - Visualizar
            key = key + getPermission("gestMant"); // 63 G. Mantenimiento
            key = key + getPermission("gestMant_DM"); // 64 G. Mantenimiento - Datos Maestros
            key = key + getPermission("gestMant_DM_UbiTec"); // 65 G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas
            key = key + getPermission("gestMant_DM_UbiTec_cre"); // 66 G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Crear
            key = key + getPermission("gestMant_DM_UbiTec_mod"); // 67 G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Modificar
            key = key + getPermission("gestMant_DM_UbiTec_vis"); // 68 G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Visualizar
            key = key + getPermission("gestMant_DM_Equi"); // 69 G. Mantenimiento - Datos Maestros - Equipos
            key = key + getPermission("gestMant_DM_Equi_cre"); // 70 G. Mantenimiento - Datos Maestros - Equipos - Crear
            key = key + getPermission("gestMant_DM_Equi_mod"); // 71 G. Mantenimiento - Datos Maestros - Equipos - Modificar
            key = key + getPermission("gestMant_DM_Equi_vis"); // 72 G. Mantenimiento - Datos Maestros - Equipos - Visualizar
            key = key + getPermission("gestMant_DM_LisMat"); // 73 G. Mantenimiento - Datos Maestros - lista Materiales
            key = key + getPermission("gestMant_DM_LisMat_cre"); // 74 G. Mantenimiento - Datos Maestros - lista Materiales - Crear
            key = key + getPermission("gestMant_DM_LisMat_mod"); // 75 G. Mantenimiento - Datos Maestros - lista Materiales - Modificar
            key = key + getPermission("gestMant_DM_LisMat_vis"); // 76 G. Mantenimiento - Datos Maestros - lista Materiales - Visualizar
            key = key + getPermission("gestMant_DM_HR"); // 77 G. Mantenimiento - Datos Maestros - Hojas de ruta
            key = key + getPermission("gestMant_DM_HR_cre"); // 78 G. Mantenimiento - Datos Maestros - Hojas de ruta - Crear
            key = key + getPermission("gestMant_DM_HR_mod"); // 79 G. Mantenimiento - Datos Maestros - Hojas de ruta - Modificar
            key = key + getPermission("gestMant_DM_HR_vis"); // 80 G. Mantenimiento - Datos Maestros - Hojas de ruta - Visualizar
            key = key + getPermission("gestMant_MonEq"); // 81 G. Mantenimiento - Monitor Equipos
            key = key + getPermission("gestMant_MonEq_MonSta"); // 82 G. Mantenimiento - Monitor Equipos - Monitor Status
            key = key + getPermission("gestMant_Avi"); // 83 G. Mantenimiento - Avisos
            key = key + getPermission("gestMant_Avi_MonAv"); // 84 G. Mantenimiento - Avisos - Monito Avisos
            key = key + getPermission("gestMant_Avi_cre"); // 85 G. Mantenimiento - Avisos - Crear
            key = key + getPermission("gestMant_Avi_mod"); // 86 G. Mantenimiento - Avisos - Modificar
            key = key + getPermission("gestMant_Avi_vis"); // 87 G. Mantenimiento - Avisos - Visualizar
            key = key + getPermission("gestMant_Ord"); // // 88 G. Mantenimiento - Ordenes
            key = key + getPermission("gestMant_Ord_cre"); // 89 G. Mantenimiento - Ordenes - Crear
            key = key + getPermission("gestMant_Ord_mod"); // 90 G. Mantenimiento - Ordenes - Modificar
            key = key + getPermission("gestMant_Ord_vis"); // 91 G. Mantenimiento - Ordenes - Visualizar
            key = key + getPermission("gestMant_Ord_lisOr"); // 92 G. Mantenimiento - Ordenes - Lista Ordenes
            key = key + getPermission("gestMant_Not"); // 93 G. Mantenimiento - Notificaciones
            key = key + getPermission("gestMant_Not_Cre"); // 94 G. Mantenimiento - Notificaciones - Crear
            key = key + getPermission("gestMant_Not_Vis"); // 95 G. Mantenimiento - Notificaciones - Visualizar
            key = key + getPermission("gestCali"); // 96 G. Calidad
            key = key + getPermission("gestCali_PlanInp"); // 97 G. Calidad - Plan de inspeccion 
            key = key + getPermission("gestCali_MedAvi"); // 98 G. Calidad - Medidas Avisos
            key = key + getPermission("gestCali_LisLotInp"); // 99 G. Calidad - Listas Lotes Inspeccion
            key = key + getPermission("gestDocu"); // 100 G. Documentos
            key = key + getPermission("gestDocu_VisDoc"); // 101 G. Documentos - Visualizar Documentos
            key = key + getPermission("gestProd"); // 102 G. Produccion
            key = key + getPermission("gestProd_DM"); // 103 G. Produccion - Datos maestros
            key = key + getPermission("gestProd_DM_Mat"); // 104 G. Produccion - Datos maestros - Materiales
            key = key + getPermission("gestProd_DM_Mat_cre"); // 105 G. Produccion - Datos maestros - Materiales -Crea
            key = key + getPermission("gestProd_DM_Mat_mod"); // 106 G. Produccion - Datos maestros - Materiales - Modifica
            key = key + getPermission("gestProd_DM_Mat_vis"); // 107 G. Produccion - Datos maestros - Materiales - Visualizar
            key = key + getPermission("gestProd_DM_LM"); // 108 G. Produccion - Datos maestros - Lista Materiales
            key = key + getPermission("gestProd_DM_LM_cre"); // 109 G. Produccion - Datos maestros - Lista Materiales - Crea
            key = key + getPermission("gestProd_DM_LM_mod"); // 110 G. Produccion - Datos maestros - Lista Materiales - Modifica
            key = key + getPermission("gestProd_DM_LM_vis"); // 111 G. Produccion - Datos maestros - Lista Materiales - Visualiza
            key = key + getPermission("gestProd_DM_HR"); // 112 G. Produccion - Datos maestros - Hojas de ruta
            key = key + getPermission("gestProd_DM_HR_cre"); // 113 G. Produccion - Datos maestros - Hojas de ruta - Crea
            key = key + getPermission("gestProd_DM_HR_mod"); // 114 G. Produccion - Datos maestros - Hojas de ruta - Modifica
            key = key + getPermission("gestProd_DM_HR_vis"); // 115 G. Produccion - Datos maestros - Hojas de ruta - Visualiza
            key = key + getPermission("gestProd_NotTi"); // 116 G. Produccion - Notifica Tiempos
            key = key + getPermission("gestProd_NotTi_MonPP"); // 117 G. Produccion - Notifica Tiempos - Monitor PP
            key = key + getPermission("gestProd_NotTi_NotTi"); // 118 G. Produccion - Notifica Tiempos - Notificar tiempos
            key = key + getPermission("gestProd_NotTi_RepBot"); // 119 G. Produccion - Notifica Tiempos - Reporte Notificaciones
            key = key + getPermission("gestProd_NotTi_RepStat"); // 120 G. Produccion - Notifica Tiempos - Reporte Estatus
            key = key + getPermission("gestProd_OrdPP"); // 121 G. Produccion - Ordenes PP
            key = key + getPermission("gestProd_OrdPP_cre"); // 122 G. Produccion - Ordenes PP - Crear
            key = key + getPermission("gestProd_OrdPP_mod"); // 123 G. Produccion - Ordenes PP - Modificar
            key = key + getPermission("gestProd_OrdPP_vis"); // 124 G. Produccion - Ordenes PP - Visualizar
            key = key + getPermission("gestProd_OrdPP_LisOPP"); // 125 G. Produccion - Ordenes PP - Listas de Ordenes PP
            key = key + getPermission("gestProd_NotPP"); // 126 G. Produccion - Notificaciones PP
            key = key + getPermission("gestProd_NotPP_cre"); // 127 G. Produccion - Notificaciones PP - Crear
            key = key + getPermission("gestProd_NotPP_vis"); // 128 G. Produccion - Notificaciones PP - Visualizar                    
            key = key + getPermission("gestCome_Fljdocum"); // 129 G. Comercial - Flujo de documentos                  
            key = key + getPermission("gestCome_FljDeudores"); // 130 G. Comercial - Flujo deudores                  
            key = key + getPermission("gestMat_GesStk_Repor1000"); // 131 G. Materiales  - Reporte Stock Almacen 1000                 
            key = key + getPermission("gestMat_GesStk_ReporEtiquetas"); // 132 G. Produccion - Reporte Etiquetas                  
            return key;
        }


        function getPermission(id) {
            var tree = $("#tree3").dynatree("getTree");
            var node = tree.getNodeByKey(id);
            var x = node.hasSubSel;
            var p;
            if (x) {
                p = "1";
            } else if (node.isSelected()) {
                p = "1";
            } else {
                p = "0";
            }
            return p;
        }

        var treeData = [
            {title: '<%=menu_m%>', key: "menu", expand: true, select: true,
                children: [
                    {title: '<%=conf_m%>', key: "conf", expand: true,
                        children: [
                            {title: '<%=usua_m%>', key: "conf_user", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "conf_userCrear"},
                                    {title: '<%=modif_m%>', key: "conf_userModif"},
                                    {title: '<%=visua_m%>', key: "conf_userVisual"},
                                    {title: 'prueba', key: "conf_userVisual4"}
                                ]},
                            {title: '<%=folios_m%>', key: "conf_fol", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "conf_folCrear"},
                                    {title: '<%=modif_m%>', key: "conf_folModif"},
                                    {title: '<%=visua_m%>', key: "conf_folVisual"}
                                ]},
                            {title: '<%=repo_m%>', key: "conf_repo", expand: true,
                                children: [
                                    {title: '<%=reposam_m%>', key: "conf_repoSAM"}
                                ]},
                            {title: '<%=centr_m%>', key: "gestMat_orgCen"}
                        ]},
                    {title: '<%=gestMat_m%>', key: "gestMat", expand: true,
                        children: [
                            {title: '<%=organi_m%>', key: "gestMat_org", expand: true,
                                children: [
                                    {title: '<%=almxcen_m%>', key: "gestMat_orgAlmXc"}
                                ]},
                            {title: '<%=datMae_m%>', key: "gestMat_datM", expand: true,
                                children: [
                                    {title: '<%=DatMaMat_m%>', key: "gestMat_datMmat", expand: true,
                                        children: [
                                            {title: '<%=CreaMat_m%>', key: "gestMat_datMmatCrear"},
                                            {title: '<%=ModMat_m%>', key: "gestMat_datMmatMod"},
                                            {title: '<%=VisMat_m%>', key: "gestMat_datMmatVis"}
                                        ]},
                                    {title: '<%=CatCom_m%>', key: "gestMat_datMCC", expand: true,
                                        children: [
                                            {title: 'Proveedor', key: "gestMat_datMCC_Prov", expand: true,
                                                children: [
                                                    {title: '<%=crear_m%>', key: "gestMat_datMCC_Prov_cre"},
                                                    {title: '<%=modif_m%>', key: "gestMat_datMCC_Prov_mod"},
                                                    {title: '<%=visua_m%>', key: "gestMat_datMCC_Prov_vis"}
                                                ]},
                                            {title: 'InfoRecord', key: "gestMat_datMCC_InfoRec", expand: true,
                                                children: [
                                                    {title: '<%=crear_m%>', key: "gestMat_datMCC_InfoRec_cre"},
                                                    {title: '<%=modif_m%>', key: "gestMat_datMCC_InfoRec_mod"},
                                                    {title: '<%=visua_m%>', key: "gestMat_datMCC_InfoRec_vis"}
                                                ]},
                                            {title: '<%=Clien_m%>', key: "gestMat_datMCC_Clie", expand: true,
                                                children: [
                                                    {title: '<%=crear_m%>', key: "gestMat_datMCC_Clie_cre"},
                                                    {title: '<%=modif_m%>', key: "gestMat_datMCC_Clie_mod"},
                                                    {title: '<%=visua_m%>', key: "gestMat_datMCC_Clie_vis"}
                                                ]}
                                        ]}
                                ]},
                            {title: '<%=Compr_m%>', key: "gestMat_Comp", expand: true,
                                children: [
                                    {title: '<%=ComSP%>', key: "gestMat_Comp_SC", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMat_Comp_SC_cre"},
                                            {title: '<%=modif_m%>', key: "gestMat_Comp_SC_mod"},
                                            {title: '<%=visua_m%>', key: "gestMat_Comp_SC_vis"},
                                            {title: '<%=listasolp%>', key: "gestMat_Comp_SC_lisSol"}
                                        ]
                                    },
                                    {title: '<%=PedCom%>', key: "gestMat_Comp_PC", expand: true,
                                        children: [
                                            {title: '<%=VisuPe_m%>', key: "gestMat_Comp_PC_vis"}
                                        ]
                                    }
                                ]},
                            {title: '<%=GestSt_m%>', key: "gestMat_GesStk", expand: true,
                                children: [
                                    {title: '<%=DocMat_m%>', key: "gestMat_GesStk_DocMat", expand: true,
                                        children: [
                                            {title: '<%=DocMatV_m%>', key: "gestMat_GesStk_DocMat_VisDocMar"},
                                            {title: '<%=LiMovMat_m%>', key: "gestMat_GesStk_DocMat_ListMov"}
                                        ]
                                    },
                                    {title: '<%=movimi_m%>', key: "gestMat_GesStk_Movim", expand: true,
                                        children: [
                                            {title: '<%=MovMat_m%>', key: "gestMat_GesStk_Movim_MovMat"},
                                            {title: '<%=MovRes_m%>', key: "gestMat_GesStk_Movim_Reser", expand: true,
                                                children: [
                                                    {title: '<%=crear_m%>', key: "gestMat_GesStk_Movim_Reser_cre"},
                                                    {title: '<%=modif_m%>', key: "gestMat_GesStk_Movim_Reser_mod"},
                                                    {title: '<%=visua_m%>', key: "gestMat_GesStk_Movim_Reser_vis"},
                                                    {title: '<%=ListaRes%>', key: "gestMat_GesStk_Movim_Reser_LisRes"}
                                                ]
                                            },
                                            {title: '<%=MovEntSer_m%>', key: "gestMat_GesStk_Movim_EntSer"}
                                        ]
                                    },
                                    {title: '<%=StkMov_m%>', key: "gestMat_GesStk_StkMat"},
                                    {title: '<%=RporteStock1000%>', key: "gestMat_GesStk_Repor1000"}
                                ]}
                        ]},
                    {title: 'Gest.Comercial', key: "gestCom", expand: true,
                        children: [
                            {title: 'Cotizacion', key: "gestCom_Cot", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestCom_Cot_cre"},
                                    {title: '<%=modif_m%>', key: "gestCom_Cot_mod"},
                                    {title: '<%=visua_m%>', key: "gestCom_Cot_vis"}
                                ]},
                            {title: 'Pedidos', key: "gestCom_Ped", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestCom_Ped_cre"},
                                    {title: '<%=modif_m%>', key: "gestCom_Ped_mod"},
                                    {title: '<%=visua_m%>', key: "gestCom_Ped_vis"}
                                ]},
                           {title: '<%=flujoDoc%>', key: "gestCome_Fljdocum"},
                           {title: '<%=flujoDeu%>', key: "gestCome_FljDeudores"}
                        ]},
                    {title: '<%=GesMan_m%>', key: "gestMant", expand: true,
                        children: [
                            {title: '<%=GesMaDM_m%>', key: "gestMant_DM", expand: true,
                                children: [
                                    {title: '<%=ubicac_m%>', key: "gestMant_DM_UbiTec", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DM_UbiTec_cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DM_UbiTec_mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DM_UbiTec_vis"}
                                        ]},
                                    {title: '<%=equip_m%>', key: "gestMant_DM_Equi", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DM_Equi_cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DM_Equi_mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DM_Equi_vis"}
                                        ]},
                                    {title: '<%=bommeq_m%>', key: "gestMant_DM_LisMat", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DM_LisMat_cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DM_LisMat_mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DM_LisMat_vis"}
                                        ]
                                    },
                                    {title: '<%=HojRut_m%>', key: "gestMant_DM_HR", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DM_HR_cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DM_HR_mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DM_HR_vis"}
                                        ]
                                    }

                                ]},
                            {title: '<%=MonEquip_m%>', key: "gestMant_MonEq", expand: true,
                                children: [
                                    {title: '<%=MonECont_m%>', key: "gestMant_MonEq_MonSta"}
                                ]},
                            {title: '<%=AvisoPM_m%>', key: "gestMant_Avi", expand: true,
                                children: [
                                    {title: '<%=MonitorAvisoPM_m%>', key: "gestMant_Avi_MonAv"},
                                    {title: '<%=crear_m%>', key: "gestMant_Avi_cre"},
                                    {title: '<%=modif_m%>', key: "gestMant_Avi_mod"},
                                    {title: '<%=visua_m%>', key: "gestMant_Avi_vis"}
                                ]},
                            {title: '<%= OrdenePM_m%>', key: "gestMant_Ord", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestMant_Ord_cre"},
                                    {title: '<%=modif_m%>', key: "gestMant_Ord_mod"},
                                    {title: '<%=visua_m%>', key: "gestMant_Ord_vis"},
                                    {title: '<%=ListOrden_m%>', key: "gestMant_Ord_lisOr"}
                                ]},
                            {title: '<%=Notif_m%>', key: "gestMant_Not", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestMant_Not_Cre"},
                                    {title: '<%=visua_m%>', key: "gestMant_Not_Vis"}
                                ]}
                        ]},
                    {title: 'Gestion Produccion', key: "gestProd", expand: true,
                        children: [
                            {title: 'Datos Mastros', key: "gestProd_DM", expand: true,
                                children: [
                                    {title: 'Materiales', key: "gestProd_DM_Mat", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestProd_DM_Mat_cre"},
                                            {title: '<%=modif_m%>', key: "gestProd_DM_Mat_mod"},
                                            {title: '<%=visua_m%>', key: "gestProd_DM_Mat_vis"}
                                        ]},
                                    {title: 'Lista de Materiales', key: "gestProd_DM_LM", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestProd_DM_LM_cre"},
                                            {title: '<%=modif_m%>', key: "gestProd_DM_LM_mod"},
                                            {title: '<%=visua_m%>', key: "gestProd_DM_LM_vis"}
                                        ]},
                                    {title: 'Hojas de ruta', key: "gestProd_DM_HR", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestProd_DM_HR_cre"},
                                            {title: '<%=modif_m%>', key: "gestProd_DM_HR_mod"},
                                            {title: '<%=visua_m%>', key: "gestProd_DM_HR_vis"}
                                        ]}
                                ]},
                            {title: 'Notifica Tiempos', key: "gestProd_NotTi", expand: true,
                                children: [
                                    {title: 'Monitor PP', key: "gestProd_NotTi_MonPP"},
                                    {title: 'Notifica Tiempos', key: "gestProd_NotTi_NotTi"},
                                    {title: 'Reporte de Notificaciones', key: "gestProd_NotTi_RepBot"},
                                    {title: 'Reporte Estatus', key: "gestProd_NotTi_RepStat"},
                                    {title: 'Reporte Etiquetas', key: "gestMat_GesStk_ReporEtiquetas"}
                                ]},
                            {title: 'Ordenes PP', key: "gestProd_OrdPP", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestProd_OrdPP_cre"},
                                    {title: '<%=modif_m%>', key: "gestProd_OrdPP_mod"},
                                    {title: '<%=visua_m%>', key: "gestProd_OrdPP_vis"},
                                    {title: 'Listas de ordenes', key: "gestProd_OrdPP_LisOPP"}
                                ]},
                            {title: 'Notificaciones PP', key: "gestProd_NotPP", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestProd_NotPP_cre"},
                                    {title: '<%=visua_m%>', key: "gestProd_NotPP_vis"}
                                ]},
                        ]},
                    {title: '<%=GestCal%>', key: "gestCali", expand: true,
                        children: [
                            {title: '<%=GestCal_PIM%>', key: "gestCali_PlanInp"},
                            {title: '<%=GestCalAvi_PIM%>', key: "gestCali_MedAvi"},
                            {title: '<%=GestCalLLI_PIM%>', key: "gestCali_LisLotInp"}
                        ]},
                    {title: '<%=GestDoc%>', key: "gestDocu", expand: true,
                        children: [
                            {title: '<%=GestVisDoc%>', key: "gestDocu_VisDoc"}
                        ]}
                ]}
        ];
    </script>
    <script>

        $("#tree3").dynatree({
            checkbox: true,
            selectMode: 3,
            children: treeData,
            onDblClick: function (node, event) {
                node.toggleSelect();
            },
            onKeydown: function (node, event) {
                if (event.which == 32) {
                    node.toggleSelect();
                    return false;
                }
            },
            // The following options are only required, if we have more than one tree on one page:
            //				initId: "treeData",
            cookieId: "dynatree-Cb3",
            idPrefix: "dynatree-Cb3-"
        });


    </script>     
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
