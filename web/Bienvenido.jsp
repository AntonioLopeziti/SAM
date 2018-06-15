<%-- 
   Document   : Bienvenido
   Created on : 11/04/2016, 11:18:58 PM
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.Conexion"%>
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
        String permi = po.getProperty("etiqueta.ModuloNoAcc");
        String finalizar = po.getProperty("etiqueta.TituloEndSession");
        String msg = po.getProperty("etiqueta.ContenidoEndSession");
        String msg2 = po.getProperty("etiqueta.ContenidoEndSession2");
        String y = po.getProperty("etiqueta.ContenidoEndYesSession");
        String n = po.getProperty("etiqueta.ContenidoEndNoSession");
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
        String SAMnot = po.getProperty("etiqueta.Moduloinaccesible");
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

        String verificarP2(char per) {
            String x = "none";
            return x;
        }

    %>
    <%
        String p = ACC_Usuarios.ObtenerInstancia().VerificarPermisos(Nombre);

        //////////////////////////////////////// Configuración ///////////////////////////////////////////////////
        String conf = verificarP(p.charAt(0));                         // Configuración
        /////////////////////////////////////// Usuarios ///////////////////////////////////////////////////////
        String conf_user = verificarP(p.charAt(1));                    // Configuración Usuario
        String conf_userCrear = verificarP(p.charAt(2));               // Configuracion Usuario Crear
        String conf_userModif = verificarP(p.charAt(3));               // Configuracion Usuario Modificar
        String conf_userVisual = verificarP(p.charAt(4));              // Configuracion Usuario Visualizar
        ////////////////////////////////////// Folios /////////////////////////////////////////////////////////
        String conf_fol = verificarP(p.charAt(5));                     // Configuracion Folio
        String conf_folCrear = verificarP(p.charAt(6));                // Configuracion Folio Crear
        String conf_folModif = verificarP(p.charAt(7));                // Configuracion Folio Modificar
        String conf_folVisual = verificarP(p.charAt(8));               // Configuracion Folio Visualizar
        ////////////////////////////////////// Reportes //////////////////////////////////////////////////////
        String conf_rep = verificarP(p.charAt(9));                     // Reportes
        String conf_repSAM = verificarP(p.charAt(10));                 // Reportes SAM

        ////////////////////////////////////// Gestión materiales ////////////////////////////////////////////
        String gestMat = verificarP(p.charAt(11));                      // Gestion Materiales
        ////////////////////////////////////// Organización //////////////////////////////////////////////////       
        String gestMat_org = verificarP(p.charAt(12));                  // Gestion Materiales Organizacion    
        String gestMat_orgCen = verificarP(p.charAt(13));               // Centros
        String gestMat_orgAlmXc = verificarP(p.charAt(14));             // Gestion Materiales Organizacion Alm por Cen
        ////////////////////////////////////// Datos Maestros ////////////////////////////////////////////////
        String gestMat_datM = verificarP(p.charAt(15));                 // Gestion Materiales Datos Maestros
        String gestMat_datMmat = verificarP(p.charAt(16));              // Gestion Materiales Datos Maestros Materiales
        String gestMat_datMmatCrear = verificarP(p.charAt(17));         // Gestion Materiales Datos Maestros Materiales Crear
        String gestMat_datMmatMod = verificarP(p.charAt(18));           // Gestion Materiales Datos Maestros Materiales Modificar
        String gestMat_datMmatVis = verificarP(p.charAt(19));           // Gestion Materiales Datos Maestros Materiales Visualizar        
        String gestMat_datMCC = verificarP(p.charAt(20));               // Gestion Materiales Datos Maestros Materiales Catalogo Compras
        String gestMat_datMCCProv = verificarP(p.charAt(21));           // Gestion Materiales Datos Maestros Materiales Catalogo Compras
        String gestMat_datMCCProvCrea = verificarP(p.charAt(22));       // Gestion Materiales Datos Maestros Materiales Catalogo Compras Crea Proveedores
        String gestMat_datMCCProvMod = verificarP(p.charAt(23));        // Gestion Materiales Datos Maestros Materiales Catalogo Compras Modificar Proveedores
        String gestMat_datMCC_ProvVis = verificarP(p.charAt(24));       // Gestion Materiales Datos Maestros Materiales Catalogo Compras Visualizar Proveedores
        String gestMat_datMCC_Inf = verificarP(p.charAt(25));           // Gestion Materiales Datos Maestros Materiales Catalogo Compras InfoRecords
        String gestMat_datMCC_CrearInR = verificarP(p.charAt(26));      // Gestion Materiales Datos Matesros Materiales Catalogo Compras Crear Info Records
        String gestMat_datMCC_ModInR = verificarP(p.charAt(27));        // Gestion Materiales Datos Matesros Materiales Catalogo Compras Modificar Info Records
        String gestMat_datMCC_VisInR = verificarP(p.charAt(28));        // Gestion Materiales Datos Matesros Materiales Catalogo Compras Visualizar Info Records
        String gestMat_datMC_Cli = verificarP(p.charAt(29));            // Gestion Materiales Datos Maestros Clientes         
        String gestMat_datMC_CliCrear = verificarP(p.charAt(30));       // Gestion Materiales Datos Maestros Clientes Crear Clientes
        String gestMat_datMC_CliMod = verificarP(p.charAt(31));         // Gestion Materiales Datos Maestros Clientes Modificar Clientes
        String gestMat_datMC_Clivis = verificarP(p.charAt(32));         // Gestion Materiales Datos Maestros Clientes Visualizar Clientes
        /////////////////////////////////// Compras //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMat_C = verificarP(p.charAt(33));                    // Gestion Materiales Compras
        String gestMat_CSC = verificarP(p.charAt(34));                  // Gestion Materiales Compras Solicitud de Compra
        String gestMat_CSC_Cr = verificarP(p.charAt(35));               // Gestion Materiales Compras Solicitud de Compra Crear
        String gestMat_CSC_Mod = verificarP(p.charAt(36));              // Gestion Materiales Compras Solicitud de Compra Modificar
        String gestMat_CSC_Vis = verificarP(p.charAt(37));              // Gestion Materiales Compras Solicitud de Compra Visualizar
        String gestMatListaSolped = verificarP(p.charAt(38));           // Listas Solped
        String gestMat_CPD = verificarP(p.charAt(39));                  // Gestion Materiales Compras Pedido de Compras
        String gestMat_CPD_Vis = verificarP(p.charAt(40));              // Gestion Materiales Compras Pedido de Compras Visualizar
        ////////////////////////////////////// Gestion de Stocks ////////////////////////////////////////////////////////////////////////////////////////
        String gestMat_GS = verificarP(p.charAt(41));                   // Gestion Materiales Gestion Stock 
        String gestMat_GSDoc = verificarP(p.charAt(42));                // Gestion Materiales Gestion Stock Documentos Materiales
        String gestMat_GSDoc_Vis = verificarP(p.charAt(43));            // Gestion Materiales Gestion Stock Documentos Materiales Visualizar Doc. Material
        String gestMat_GSDoc_LstMov = verificarP(p.charAt(44));         // Gestion Materiales Gestion stock Documentos Materiales Lista Mov. Materiales
        String gestMat_GSMov = verificarP(p.charAt(45));                // Gestion Materiales Gestion Stock Movimientos
        String gestMat_GSMov_MovM = verificarP(p.charAt(46));           // Gestion Materiales Gestion Stock Movimientos Mov. Material
        String gestMat_GSMov_ResM = verificarP(p.charAt(47));           // Gestion Materiales Gestion Stock Reservas
        String gestMat_GSMov_ResMCr = verificarP(p.charAt(48));         // Gestion Materiales Gestion Stock Reservas
        String gestMat_GSMov_ResMMo = verificarP(p.charAt(49));         // Gestion Materiales Gestion Stock Reservas
        String gestMat_GSMov_ResMVi = verificarP(p.charAt(50));         // Gestion Materiales Gestion Stock Reservas
        String gestMatListReser = verificarP(p.charAt(51));             // Listas Reservas
        String gestMat_GSMov_EntSer = verificarP(p.charAt(52));         // Gestion Materiales Gestion Stock Entrada Servicios
        String gestMat_GSStockM = verificarP(p.charAt(53));             // Gestion Materiales Gestion Stock Stock Material

        ///////////////////////////////////////////// Gestion Comerial ///////////////////////////////////////////////////
        String gestCome = verificarP(p.charAt(54));
        //////////////////////// Cotizacion //////////////////////////////////////////////////////////////////////////////
        String gestCome_Cotizacion = verificarP(p.charAt(55));
        String gestCome_Cotiz_Crear = verificarP(p.charAt(56));
        String gestCome_Cotiz_Modif = verificarP(p.charAt(57));
        String gestCome_Cotiz_Visual = verificarP(p.charAt(58));
        /////////////////////// Pedidos ///////////////////////////////////////////////////////////////////////////
        String gestCome_Pedidos = verificarP(p.charAt(59));
        String gestCome_Pedi_Crear = verificarP(p.charAt(60));
        String gestCome_Pedi_Modif = verificarP(p.charAt(61));
        String gestCome_Pedi_Visua = verificarP(p.charAt(62));

        //////////////////////// Gestion Mantenimiento ////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant = verificarP(p.charAt(63));                    // Gestion Matenimiento
        //////////////////////////////// Datos Maestros /////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_DM = verificarP(p.charAt(64));                 // Gestion Mantenimiento Datos Maestros
        String gestMant_DMUbi = verificarP(p.charAt(65));              // Gestion Mantenimiento Datos Maestros Ubicaciones
        String gestMant_DMUbi_Cre = verificarP(p.charAt(66));          // Gestion Mantenimiento Datos Maestros Ubicaciones Crear
        String gestMant_DMUbi_Mod = verificarP(p.charAt(67));          // Gestion Mantenimiento Datos Maestros Ubicaciones Modificar
        String gestMant_DMUbi_Vis = verificarP(p.charAt(68));          // Gestion Mantenimiento Datos Maestros Ubicaciones Visualizar

        String gestMant_DMEqui = verificarP(p.charAt(69));             // Gestion Mantenimiento Datos Maestros Equipos
        String gestMant_DMEqui_Cre = verificarP(p.charAt(70));         // Gestion Mantenimiento Datos Maestros Equipos Crear
        String gestMant_DMEqui_Mod = verificarP(p.charAt(71));         // Gestion Mantenimiento Datos Maestros Equipos Modificar
        String gestMant_DMEqui_Vis = verificarP(p.charAt(72));         // Gestion Mantenimiento Datos Maestros Equipos Visualizar
        String gestMant_DMBom = verificarP(p.charAt(73));              // Gestion Mantenimiento Datos Maestros Boom Equipos
        String gestMant_DMBom_Crea = verificarP(p.charAt(74));         // Gestion Mantenimiento Datos Maestros Boom Equipos Crear
        String gestMant_DMBom_Mod = verificarP(p.charAt(75));          // Gestion Mantenimiento Datos Maestros Boom Equipos Modificar
        String gestMant_DMBom_Vis = verificarP(p.charAt(76));          // Gestion Mantenimiento Datos Maestros Boom Equipos Visualizar
        String gestMant_DMHrut = verificarP(p.charAt(77));             // Gestion Mantenimiento Datos Maestros Hojas Ruta
        String gestMant_DMHrut_Cra = verificarP(p.charAt(78));         // Gestion Mantenimiento Datos Maestros Hojas Ruta Crear 
        String gestMant_DMHrut_Mod = verificarP(p.charAt(79));         // Gestion Mantenimiento Datos Maestros Hojas Ruta Modificar
        String gestMant_DMHrut_Vis = verificarP(p.charAt(80));         // Gestion Mantenimiento Datos Maestros Hojas Ruta Visualizar
        ///////////////////////////// Monitor de Equipos //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_ME = verificarP(p.charAt(81));                 // Gestion Mantenimiento Monitor de Equipos
        String gestMant_ME_MCPxE = verificarP(p.charAt(82));           // Gestion Mantenimiento Monitor de Equipos Monitor de Contadores y Plan de Mantenimiento
        //////////////////////////// Avisos PM /////////////////////////////////////////////////////////////////////////////////////
        String gestMant_APM = verificarP(p.charAt(83));                // Gestion Mantenimiento Avisos PM
        String gestMant_APM_MAPM = verificarP(p.charAt(84));           // Gestion Mantenimiento Avisos PM Monitor de Avisos PM
        String gestMant_APM_Cre = verificarP(p.charAt(85));            // Gestion Mantenimiento Avisos PM Crear
        String gestMant_APM_Mod = verificarP(p.charAt(86));            // Gestion Mantenimiento Avisos PM Modificar
        String gestMant_APM_Vis = verificarP(p.charAt(87));            // Gestion Mantenimiento Avisos PM Visualizar
        ////////////////////////// Ordenes PM //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_OPM = verificarP(p.charAt(88));                // Gestion Mantenimiento Ordenes PM
        String gestMant_OPM_Cre = verificarP(p.charAt(89));            // Gestion Mantenimiento Ordenes PM Crear
        String gestMant_OPM_Mod = verificarP(p.charAt(90));            // Gestion Mantenimiento Ordenes PM Modificar 
        String gestMant_OPM_Vis = verificarP(p.charAt(91));            // Gestion Mantenimiento Ordenes PM Visualizar
        String gestMant_OPM_LstO = verificarP(p.charAt(92));           // Gestion Mantenimiento Ordenes PM Lista de Ordenes
        ////////////////////// Notificaciones PM /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_NPM = verificarP(p.charAt(93));                // Gestion Mantenimiento Notificaciones PM      
        String gestMant_NPM_Cre = verificarP(p.charAt(94));            // Gestion Mantenimiento Notificaciones PM Crear
        String gestMant_NPM_Vis = verificarP(p.charAt(95));            // Gestion Mantenimiento Notificaciones PM Visualizar

        ///////////////////// Gestiòn de Calidad ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestCali = verificarP(p.charAt(96));                    // GestiÃ³n de Calidad
        ///////////////////// Plan de Inspecciòn ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestCali_PIM = verificarP(p.charAt(97));                // Plan de inspeccion de calidad para Material
        String gestCaliMe_PIM = verificarP(p.charAt(98));              // Calidad Medidas
        String gestListaMLIe_PIM = verificarP(p.charAt(99));           // Listado Lotes de inspección
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////// Gestión de Documentos ////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestDocu = verificarP(p.charAt(100));
        ///////////////////// Visualizar Documentos ////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestDocu_VisDoc = verificarP(p.charAt(101));

        ////////////////////// Gestion produccion //////////////////////////////////////////////////////////////
        String Getion_prod = verificarP(p.charAt(102));
        /////////////// Datos Maestros /////////////////////////////////////////////////
        String gestPP_DM = verificarP(p.charAt(103));
        String gestPP_Mat = verificarP(p.charAt(104));
        String gestPP_MatCre = verificarP(p.charAt(105));
        String gestPP_MatMod = verificarP(p.charAt(106));
        String gestPP_MatVis = verificarP(p.charAt(107));
        String gestPP_ListMat = verificarP(p.charAt(108));
        String gestPP_ListMatCr = verificarP(p.charAt(109));
        String gestPP_ListMatMod = verificarP(p.charAt(110));
        String gestPP_ListMatVis = verificarP(p.charAt(111));
        String gestPP_Hrut = verificarP(p.charAt(112));
        String gestPP_Hrut_Cra = verificarP(p.charAt(113));
        String gestPP_Hrut_Mod = verificarP(p.charAt(114));
        String gestPP_Hrut_Vis = verificarP(p.charAt(115));
        ////////////////////// Notificar Tiempos PP //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestPP_NotTie = verificarP(p.charAt(116));                 // Gestión Produccion Notificar Tiempos PP
        String gestPP_MPP = verificarP(p.charAt(117));                    // Gestión Produccion Monitor PP
        String gestPP_NotTiPP = verificarP(p.charAt(118));                // Gestión Produccion Notificar tiempos PP
        String gestPP_RepNot = verificarP(p.charAt(119));                 // Gestion Produccion Reporte Not
        String gestPP_RepStatusOrd = verificarP(p.charAt(120));           // Gestion Mantenimiento Reporte Status
        ////////////////////////// Ordenes PP //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_OPP = verificarP(p.charAt(121));                // GestiÃ³n Mantenimiento Ordenes PP
        String gestMant_OPP_Cre = verificarP(p.charAt(122));            // GestiÃ³n Mantenimiento Ordenes PP Crear
        String gestMant_OPP_Mod = verificarP(p.charAt(123));            // GestiÃ³n Mantenimiento Ordenes PP Modificar 
        String gestMant_OPP_Vis = verificarP(p.charAt(124));            // GestiÃ³n Mantenimiento Ordenes PP Visualizar
        String gestMant_OPP_LstO = verificarP(p.charAt(125));           // GestiÃ³n Mantenimiento Ordenes PP Lista de Ordenes
        ////////////////////// Notificaciones PP /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_NPP = verificarP(p.charAt(126));                // GestiÃ³n Mantenimiento Notificaciones PP      
        String gestMant_NPP_Cre = verificarP(p.charAt(127));            // GestiÃ³n Mantenimiento Notificaciones PP Crear
        String gestMant_NPP_Vis = verificarP(p.charAt(128));            // GestiÃ³n Mantenimiento Notificaciones PP1 Visualizar
        String gestCome_Fljdocum = verificarP(p.charAt(129));           // Gestion Comercial Flujo de Dcoumentos
        String gestCome_Fljdeudores = verificarP(p.charAt(130));           // Gestion Comercial Flujo de Deudores
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="keywords" content="alert, confirm, prompt, demo" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/alerts.css">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jqueryalerts.js"></script>  
        <script src="js/jquery.ui.draggable.js"></script>
        <script src="js/jquery-ui.js"></script>  
        <script src="js/menu.js"></script>
        <script src="js/jquerys.js"></script>   
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.bienvenido"));%></title>        
    </head> 
    <body >   
        <div id="main-header">  
            <hr>
            <div id="header2" style="display:none">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="#" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <div id="header">
                <ul class="sf-menu" id="example">
                    <li class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="#" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a>
                        <ul>
                            <li class="current"  style="display: <%=conf%>"><a href="#"><%out.println(po.getProperty("etiqueta.Configuracion_menu"));%></a>
                                <ul>
                                    <li class="current" style="display: <%=conf_user%>"><a href="#"><%out.println(po.getProperty("etiqueta.Usuarios_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=conf_userCrear%>"><a href="CrearUsuarios.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=conf_userModif%>"><a href="ModificarUsuarios.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=conf_userVisual%>"><a href="VisualizarUsuarios.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li style="display: <%=conf_fol%>"><a href="#"><%out.println(po.getProperty("etiqueta.Folios_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=conf_folCrear%>"><a href="CrearFolio.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=conf_folModif%>"><a href="Modificarfolios.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=conf_folVisual%>"><a href="Visualizarfolios.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li style="display: <%=conf_rep%>"><a href="#"><%out.println(po.getProperty("etiqueta.Reportes_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=conf_repSAM%>"><a href="Reportes.jsp"><%out.println(po.getProperty("etiqueta.ReportesSAM_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li style="display: <%=gestMat_orgCen%>"><a href="Centros.jsp"><%out.println(po.getProperty("etiqueta.Centros_menu"));%></a></li>
                                </ul>
                            </li>
                            <li class="current" style="display: <%=gestMat%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionMateriales_menu"));%></a>
                                <ul>
                                    <li class="current" style="display: <%=gestMat_org%>"><a href="#"><%out.println(po.getProperty("etiqueta.Organizacion_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMat_orgAlmXc%>"><a href="CentroAlmacen.jsp"><%out.println(po.getProperty("etiqueta.AlmacenCentros_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMat_datM%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosMan_menu"));%></a>
                                        <ul>
                                            <li class="current" style="display:<%=gestMat_datMmat%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosMat_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_datMmatCrear%>"><a href="CreaMate.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosMatCrear_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_datMmatMod%>"><a href="ModifMate.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosMatModif_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_datMmatVis%>"><a href="ConsultaMate.jsp"><%out.println(po.getProperty("etiqueta.DatosMatesrosMatVisual_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display:<%=gestMat_datMCC%> "><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatComp_menu"));%></a>
                                                <ul>
                                                    <li class="current" style="display:<%=gestMat_datMCCProv%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatComProveedor_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_datMCCProvCrea%>"><a href="CreaProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompCrearProv_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCCProvMod%>"><a href="ModificaProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompModificarProv_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_ProvVis%>"><a href="VisualizarProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompVisProv_menu"));%></a></li>
                                                        </ul> 
                                                    </li>
                                                    <li class="current" style="display:<%=gestMat_datMCC_Inf%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompInfoRecord_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_datMCC_CrearInR%>"><a href="CrearInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompCrearInfo_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_ModInR%>"><a href="ModificarInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompModificarInfo_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_VisInR%>"><a href="VisualizarInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompVisInfo_menu"));%></a></li>
                                                        </ul>
                                                    </li>
                                                    <li class="current" style="display: <%=gestMat_datMC_Cli%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosClientes_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_datMC_CliCrear%>"><a href="CrearClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCrearCliente_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMC_CliMod%>"><a href="ModificarClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosModificarCliente_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMC_Clivis%>"><a href="VisualizarClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosVisCliente_menu"));%></a></li>
                                                        </ul>
                                                    </li>
                                                </ul>     
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMat_C%>"><a href="#"><%out.println(po.getProperty("etiqueta.Compras_menu"));%></a>
                                        <ul>
                                            <li class="current" style="display: <%=gestMat_CSC%>"><a href="#"><%out.println(po.getProperty("etiqueta.ComprasSolCom_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_CSC_Cr%>"><a href="CrearSolped.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_CSC_Mod%>"><a href="ModificarSolped.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_CSC_Vis%>"><a href="VisualizarSolPed.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                    <li style="display: <%=gestMatListaSolped%>"><a href="ReporteSolicitudPedido.jsp"><%out.println(po.getProperty("etiqueta.ListaSolpedR"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMat_CPD%>"><a href="#"><%out.println(po.getProperty("etiqueta.ComprasPedComp_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_CPD_Vis%>"><a href="VisualizarPedidos.jsp"><%out.println(po.getProperty("etiqueta.ComprasPedCompVis_menu"));%></a></li>
                                                </ul>
                                            </li>

                                        </ul>
                                    </li>

                                    <li class="current" style="display: <%=gestMat_GS%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionStock_menu"));%></a>
                                        <ul>
                                            <li class="current" style="display: <%=gestMat_GSDoc%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionStockDocMat_manu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_GSDoc_Vis%>"><a href="VisualizarDocumentosLstMaterial2.jsp"><%out.println(po.getProperty("etiqueta.GestionStockDocMatVisu_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_GSDoc_LstMov%>"><a href="VisualizarDocumentosListaMaterial.jsp"><%out.println(po.getProperty("etiqueta.GestionStockDocMatListMovMat_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMat_GSMov%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionStockMovimientos_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_GSMov_MovM%>"><a href="MovimientoMateriales.jsp"><%out.println(po.getProperty("etiqueta.GestionStockMovimMovMat_menu"));%></a></li>
                                                    <li class="current" style="display: <%=gestMat_GSMov_ResM%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionStockMovimReservas_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_GSMov_ResMCr%>"><a href="Reservas.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_GSMov_ResMMo%>"><a href="ModificarReservas.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_GSMov_ResMVi%>"><a href="VisualizarReservas.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                            <li style="display: <%=gestMatListReser%>"><a href="ReporteReservas2.jsp"><%out.println(po.getProperty("etiqueta.ListaReser"));%></a></li>
                                                        </ul>
                                                    </li>
                                                    <li style="display: <%=gestMat_GSMov_EntSer%>"><a href="PedidosServicioExterno.jsp"><%out.println(po.getProperty("etiqueta.GestionStockMovimEntServicios_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMat_GSStockM%>"><a href="VisualizarStockMaterial.jsp"><%out.println(po.getProperty("etiqueta.GestionStockStockMaterial_menu"));%></a>     
                                            </li>
                                        </ul>
                                    </li>


                                </ul>
                            </li>
                            <li class="current" style="display: <%=gestCome%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionComercial_menu"));%></a>
                                <ul>
                                    <li class="current" style="display: <%=gestCome_Cotizacion%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionComercial_Cotizacion_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestCome_Cotiz_Crear%>"><a href="CrearCotizacion.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestCome_Cotiz_Modif%>"><a href="ModificarCotizacion.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=gestCome_Cotiz_Visual%>"><a href="VisualizarCotizacion.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestCome_Pedidos%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionComercial_Pedidos_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestCome_Pedi_Crear%>"><a href="javascript:VerificarVendedorPedidos();"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestCome_Pedi_Modif%>"><a href="ModificarPedidosSD.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=gestCome_Pedi_Visua%>"><a href="VisualizarPedidosSD.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestCome_Fljdocum%>"><a href="FlujoDocumentos.jsp">Flujo de documentos</a></li>
                                    <li class="current" style="display: <%=gestCome_Fljdeudores%>"><a href="FlujoDeudoresSD.jsp">Saldo de clientes</a></li>
                                </ul>
                            </li>
                            <li class="current" style="display: <%=gestMant%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionMantenim"));%></a>
                                <ul>
                                    <li class="current" style="display: <%=gestMant_DM%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosMan_menu"));%></a>
                                        <ul>
                                            <li class="current" style="display: <%=gestMant_DMUbi%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosUbicac_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_DMUbi_Cre%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMUbi_Mod%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMUbi_Vis%>"><a href="VisualizarUbicacionesTecnicas.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMant_DMEqui%>"><a href="#"><%out.println(po.getProperty("etiqueta.Equipos_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_DMEqui_Cre%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMEqui_Mod%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMEqui_Vis%>"><a href="VisualizarEquipos.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMant_DMBom%>"><a href="#"><%out.println(po.getProperty("etiqueta.BoomEqui_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_DMBom_Crea%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMBom_Mod%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMBom_Vis%>"><a href="VisualizarBomMateriales.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMant_DMHrut%>"><a href="#"><%out.println(po.getProperty("etiqueta.HojaRuta_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_DMHrut_Cra%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMHrut_Mod%>"><a href="javascript:inval();"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_DMHrut_Vis%>"><a href="VisualizarHojasRuta.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>

                                    <li class="current" style="display: <%=gestMant_ME%>"><a href="#"><%out.println(po.getProperty("etiqueta.MonitorEquipos_menu"));%></a>
                                        <ul>
                                            <li class="current" style="display: <%=gestMant_ME_MCPxE%>"> <a href="MonitorStatus.jsp"><%out.println(po.getProperty("etiqueta.MonitorContaPlanEq_menu"));%></a></li>
                                        </ul>
                                    </li>

                                    <li class="current" style="display: <%=gestMant_APM%>"><a href="#"><%out.println(po.getProperty("etiqueta.AvisosPM_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMant_APM_MAPM%>"><a href="MonitorAvisosPM.jsp"><%out.println(po.getProperty("etiqueta.MonitorAvisosPM_menu"));%></a></li>
                                            <li style="display: <%=gestMant_APM_Cre%>"><a href="CrearAvisoAcceso.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestMant_APM_Mod%>"><a href="ModificarAvisoAcceso.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=gestMant_APM_Vis%>"><a href="ConsultaAvisos.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMant_OPM%>"><a href="#"><%out.println(po.getProperty("etiqueta.OrdenesPM_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMant_OPM_Cre%>"><a href="CrearOrden.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPM_Mod%>"><a href="ModificarOrden.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPM_Vis%>"><a href="VisualizarOrdenes.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPM_LstO%>"><a href="ListaOrdenes.jsp"><%out.println(po.getProperty("etiqueta.ListaOrdenes_menu"));%></a></li>

                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMant_NPM%>"><a href="#"><%out.println(po.getProperty("etiqueta.NotificacionesPM"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMant_NPM_Cre%>"><a href="CrearNotificacionesPM.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestMant_NPM_Vis%>"><a href="VisualizarNotificacionesPM.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>


                            <li class="current" style="display: <%=Getion_prod%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionProduccion"));%></a>
                                <ul>
                                    <li class="current" style="display: <%=gestPP_DM%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosPP"));%></a>
                                        <ul>
                                            <li class="current" style="display: <%=gestPP_Mat%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_Materiales_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestPP_MatCre%>"><a href="CrearMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_MatMod%>"><a href="ModificarMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_MatVis%>"><a href="VisualizarMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestPP_ListMat%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_BoomEqui_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestPP_ListMatCr%>"><a href="CrearBomMaterialPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_ListMatMod%>"><a href="ModificarBomMaterialPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_ListMatVis%>"><a href="VisualizarBomMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestPP_Hrut%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_HojaRuta_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestPP_Hrut_Cra%>"><a href="CrearHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_Hrut_Mod%>"><a href="ModificarHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestPP_Hrut_Vis%>"><a href="VisualizarHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>                                    
                                    <!--Monitor Status PP-->
                                    <li class="current" style="display: <%=gestPP_NotTie%>"><a href="#">Notificar Tiempos PP</a>
                                        <ul>
                                            <li class="current" style="display: <%=gestPP_MPP%>"> <a href="ListadoOrdFab.jsp">Monitor PP</a></li>
                                            <li class="current" style="display: <%=gestPP_NotTiPP%>"> <a href="NotificacionTiemposPP.jsp">Notificar Tiempos</a></li>
                                            <li class="current" style="display: <%=gestPP_RepNot%>"> <a href="ReporteMovNotificaciones.jsp">Reporte Notificaciones</a></li>
                                            <li class="current" style="display: <%=gestPP_RepStatusOrd%>"> <a href="ReporteStatusOrdenesPP.jsp">Reporte Estatus</a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMant_OPP%>"><a href="#"><%out.println(po.getProperty("etiqueta.OrdenesPP"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMant_OPP_Cre%>"><a href="CrearOrdenPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPP_Mod%>"><a href="ModificarOrdenPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPP_Vis%>"><a href="VisualizaOrdenesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                            <li style="display: <%=gestMant_OPP_LstO%>"><a href="ListaOrdenesPP.jsp"><%out.println(po.getProperty("etiqueta.ListaOrdenes_menu"));%></a></li>

                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestMant_NPP%>"><a href="#"><%out.println(po.getProperty("etiqueta.NotificacionesPP"));%></a>
                                        <ul>
                                            <li style="display: <%=gestMant_NPP_Cre%>"><a href="CrearNotificacionesPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestMant_NPP_Vis%>"><a href="VisualizarNotificacionesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>

                            <li class="current" style="display: <%=gestCali%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionCalidad"));%></a>
                                <ul>
                                    <li style="display: <%=gestCali_PIM%>"><a href="PlanesInspeccion.jsp"><%out.println(po.getProperty("etiqueta.PlanInspeccioMaterial"));%></a></li>
                                    <li style="display: <%=gestCaliMe_PIM%>"><a href="AvisosCalidad.jsp"><%out.println(po.getProperty("etiqueta.MedidasAviso_menu"));%></a></li>
                                    <li style="display: <%=gestListaMLIe_PIM%>"><a href="ListaLotesInpseccion.jsp"><%out.println(po.getProperty("etiqueta.LoteInspecLis_menu"));%></a></li>
                                </ul>
                            </li>
                            <li class="current" style="display: <%=gestDocu%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionDocument"));%></a>
                                <ul>
                                    <li style="display: <%=gestDocu_VisDoc%>"><a href="VisualizaDocumentos.jsp"><%out.println(po.getProperty("etiqueta.GestVisDoc"));%></a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>   
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>                 
            <input  id="regresar" type="image" src="images/regresaOFF.png" disabled/>
            <input  type="image" src="images/cance.PNG"  id="confirm_button"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.bienvenido"));%>      <span style="text-transform: uppercase"> <%=Nombre%>  </span></h1></div>         
        </div>
        <script>
            $(document).ready(function () {
                $('#iconmsg').hide();
                $('#guardar').prop('disabled', true);
                $('#regresar').prop('disabled', true);
                $('#cancelar').prop('disabled', true);
                $("#confirm_button").click(function () {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapsnd05.wav";
                    BE.play();
                    jConfirm('<%=msg%> \n \n <%=msg2%> \n \n', '<%=finalizar%>', '<%=y%>', '<%=n%>', function (x) {
                        if (x == true) {
                            jQuery(location).attr('href', 'Logout');
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapsnd05.wav";
                            BE.play();
                        } else {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapsnd05.wav";
                            BE.play();
                        }
                    });
                });
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
                    WriteDate.html("Fecha indefinida");
                }
                startTime();
                CargarAvisosVendedor();
            });

            function startTime() {
                today = new Date();
                n = today.getHours();
                m = today.getMinutes();
                s = today.getSeconds();
                h = checkTime(n);
                m = checkTime(m);
                s = checkTime(s);
                $('#tiempo').html(h + ":" + m + ":" + s);
                t = setTimeout('startTime()', 500);
            }
            function checkTime(i)
            {
                if (i < 10) {
                    i = "0" + i;
                }
                return i;
            }
            function inval() {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                var iconm = $('#iconmsg');
                iconm.show();
                iconm.attr('src', 'images/aceptar.png');
                $('#msg').html('<%=SAMnot%>');
            }
            function VerificarVendedorPedidos() {
                var Vend = '<%=Nombre%>';
                var acc = "VerificarAccesoVendedor";
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'peticionPedidoSDCrear',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Accion=" + acc + "&Vendedor=" + Vend,
                    success: function (data) {
                        if (data == 0) {
                            var BE = document.createElement('audio');
                            BE.src = "audio/saperror.wav";
                            BE.play();
                            var iconm = $('#iconmsg');
                            iconm.show();
                            iconm.attr('src', 'images/advertencia.PNG');
                            $('#msg').html('Modulo disponible para vendedor');
                        } else {
                            window.location.href = "CrearPedidoSD.jsp";
                        }
                    }
                });
            }
            function CargarAvisosVendedor() {
                var Vend = '<%=Nombre%>';
                var acc = "CargarAvisosVendor";
                $.ajax({
                    async: false,
                    type: 'GET',
                    dataType: 'json',
                    url: 'peticionPedidoSDCrear',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Accion=" + acc + "&Vendedor=" + Vend,
                    success: function (data) {
                        if (data[0].length > 0) {
                            if (data[1].length > 0 || data[2].length > 0 || data[3].length > 0) {
                                $('#header2').css('display', 'block');
                                $('#header').css('display', 'none');
                                $('#confirm_button').prop('disabled', true);
                                var BE = document.createElement('audio');
                                BE.src = "saperror.wav";
                                BE.play();
                                var ancho = 800;
                                var alto = 700;
                                var x = (screen.width / 2) - (ancho / 2);
                                var y = (screen.height / 2) - (alto / 2);
                                var ventana = $('#Windowmsg');
                                ventana.css({top: y + "px", left: x + "px"});
                                ventana.css('display', 'block');
                                $('#aviso1txt').val(data[1]);
                                $('#aviso2txt').val(data[2]);
                                $('#aviso3txt').val(data[3]);
                            }
                        }
                    }
                });
            }
            function CerrarVentaAviso() {
                $('#header2').css('display', 'none');
                $('#header').css('display', 'block');
                $('#confirm_button').prop('disabled', false);
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
                $('#Windowmsg').css('display', 'none');
            }
        </script>
        <div class="contenido">
            <div class="logoimage">
                <IMG SRC="images/Logo_Empresa.png"  ALT="Logo">
            </div>
        </div>            
        <div id="Windowmsg" class="VentanaModalMensajes">
            <div id="handleMsg"><label id="TituloMatch">Avisos</label><div class="BotonCerrar_Matc" onclick="CerrarVentaAviso();"><label >X</label></div></div>
            <div class="divAviso1">
                <label>Aviso 1</label>
                <hr style="border: 1px solid #007CC0; margin-left: -2%;">
               <textarea class="textAr"  id="aviso1txt" disabled></textarea>
            </div>
            <div class="divAviso1">
                <label>Aviso 2</label>
                <hr style="border: 1px solid #007CC0; margin-left: -2%;">
                 <textarea class="textAr"  id="aviso2txt" disabled></textarea>
            </div>
            <div class="divAviso1">
                <label>Aviso 3</label>
                <hr style="border: 1px solid #007CC0; margin-left: -2%;">
                 <textarea class="textAr"  id="aviso3txt" disabled></textarea>
            </div>
        </div>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
            </div>
        </footer>
        <style>
            .logoimage{
                margin-bottom: 10%;
                margin-top: 120px;
                width: 28%;
                margin-left: 38%;
                margin-right: 10%;
            }

            .logoimage img{
                vertical-align: central;
                width:100%;
                border:none;
                margin: 0;
                padding:0;
                height: auto;
            }
            .VentanaModalMensajes{
                position: fixed; 
                width: 700px; 
                height: 550px;
                margin-top: 10px;
                left: 100%; 
                font-family:Verdana, Arial, Helvetica, sans-serif; 
                font-size: 15px; 
                font-weight: normal; 
                border: #333333 3px solid; 
                background-color: #f2f2f2; 
                color: #000000;
                display:none;
                z-index:1002;
            }
            #handleMsg{   
                padding-top: .2%;
                height: 5%;
                width: 100%;
                color:#E1F0D0;
                background: #333  top repeat-x;
            }
            .divAviso1{
                padding-left: 2%;
                margin-top: 1%;
                width: 96%;
                margin-left: 1%;
                margin-right: 1%;
                height: 30%;
                background: #fff;}
            .textAr{
                resize: none;
                margin-right: 1%;
                height: 65%;
                width: 96%;
                overflow-x: scroll; 
                overflow-y: scroll; 
                border: double #000;
            }

        </style>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
