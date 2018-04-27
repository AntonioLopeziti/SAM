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

    %>
    <%
        String p = ACC_Usuarios.ObtenerInstancia().VerificarPermisos(Nombre);
        //////////////////////////////////////// ConfiguraciÃ³n ///////////////////////////////////////////////////
        ///////  ObtenciÃ³n de caracteres para permisos por modulo ///////////////////////////////////////////////
        String conf = verificarP(p.charAt(0));                         // ConfiguraciÃ³n
        /////////////////////////////////////// Usuarios ///////////////////////////////////////////////////////
        String conf_user = verificarP(p.charAt(1));                    // ConfiguracÃ³n Usuario
        String conf_userCrear = verificarP(p.charAt(2));               // Configuracion Usuario Crear
        String conf_userModif = verificarP(p.charAt(3));               // Configuracion Usuario Modificar
        String conf_userVisual = verificarP(p.charAt(4));              // Configuracion Usuario Visualizar
        ////////////////////////////////////// Folios /////////////////////////////////////////////////////////
        String conf_fol = verificarP(p.charAt(5));                     // Configuracion Folio
        String conf_folCrear = verificarP(p.charAt(6));                // ConfiguraciÃ³n Folio Crear
        String conf_folModif = verificarP(p.charAt(7));                // ConfiguraciÃ³n Folio Modificar
        String conf_folVisual = verificarP(p.charAt(8));               // ConfiguraciÃ³n Folio Visualizar
        ////////////////////////////////////// Reportes //////////////////////////////////////////////////////
        String conf_rep = verificarP(p.charAt(9));
        String conf_repSAM = verificarP(p.charAt(10));
        ///////////////////////////////////////////////////////////////////////////////////////////////////////        
        ////////////////////////////////////// GestiÃ³n materiales //////////////////////////////////////////////
        String gestMat = verificarP(p.charAt(11));                      // Gestion Materiales
        ////////////////////////////////////// OrganizaciÃ³n ///////////////////////////////////////////////////       
        String gestMat_org = verificarP(p.charAt(12));                  // Gestion Materiales OrganizaciÃ³n
        String gestMat_orgCen = verificarP(p.charAt(13));               // Gestion Materiales Organizacion Centro 
        String gestMat_orgAlmXc = verificarP(p.charAt(14));             // Gestion Materiales Organizacion Alm por Cen
        //////////////////////////////////// Datos Maestros //////////////////////////////////////////////////////////////
        String gestMat_datM = verificarP(p.charAt(15));                 // Gestion Materiales Datos Maestros
        String gestMat_datMmat = verificarP(p.charAt(16));             // Gestion Materiales Datos Maestros Materiales
        String gestMat_datMmatCrear = verificarP(p.charAt(17));        // Gestion Materiales Datos Maestros Materiales Crear
        String gestMat_datMmatMod = verificarP(p.charAt(18));          // Gestion Materiales Datos Maestros Materiales Modificar
        String gestMat_datMmatVis = verificarP(p.charAt(19));          // Gestion Materiales Datos Maestros Materiales Visualizar        
        String gestMat_datMCC = verificarP(p.charAt(20));              // GestiÃ³n Materiales Datos Maestros Materiales Catalogo Compras
        String gestMat_datMCCCreaP = verificarP(p.charAt(21));         // GestiÃ³n Materiales Datos Maestros Materiales Catalogo Compras Crea Proveedores
        String gestMat_datMCCModP = verificarP(p.charAt(22));          // GestiÃ³n Materiales Datos Maestros Materiales Catalogo Compras Modificar Proveedores
        String gestMat_datMCC_VisP = verificarP(p.charAt(21));         // GestiÃ³n Materiales Datos Maestros Materiales Catalogo Compras Visualizar Proveedores
        String gestMat_datMCC_VisInR = verificarP(p.charAt(22));       // GestiÃ³n Materiales Datos Matesros Materiales Catalogo Compras Visualizar Info Records
        String gestMat_datMC = verificarP(p.charAt(23));               // Gestion Materiales Datos Maestros Clientes         
        String gestMat_datMC_VisC = verificarP(p.charAt(24));          // Gestion Materiales Datos Maestros Clientes Visualizar Clientes
        /////////////////////////////////// Compras //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMat_C = verificarP(p.charAt(25));                   // GestiÃ³n Materiales Compras
        String gestMat_CSC = verificarP(p.charAt(26));                 // GestiÃ³n Materiales Compras Solicitud de Compra
        String gestMat_CSC_Cr = verificarP(p.charAt(27));              // GestiÃ³n Materiales Compras Solicitud de Compra Crear
        String gestMat_CSC_Mod = verificarP(p.charAt(28));             // GestiÃ³n Materiales Compras Solicitud de Compra Modificar
        String gestMat_CSC_Vis = verificarP(p.charAt(29));             // GestiÃ³n Materiales Compras Solicitud de Compra Visualizar
        String gestMatListaSolped = verificarP(p.charAt(30));          // Listas Solped
        String gestMat_CPD = verificarP(p.charAt(31));                 // GestiÃ³n Materiales Compras Pedido de Compras
        String gestMat_CPD_Vis = verificarP(p.charAt(32));             // GestiÃ³n Materiales Compras Pedido de Compras Visualizar
        ////////////////////////////////// GestiÃ³n de Stocks ////////////////////////////////////////////////////////////////////////////////////////
        String gestMat_GS = verificarP(p.charAt(33));                  // GestiÃ³n Materiales Gestion Stock 
        String gestMat_GSDoc = verificarP(p.charAt(34));               // GestiÃ³n Materiales GestiÃ³n Stock Documentos Materiales
        String gestMat_GSDoc_Vis = verificarP(p.charAt(35));           // GestiÃ³n Materiales GestiÃ³n Stock Documentos Materiales Visualizar Doc. Material
        String gestMat_GSDoc_LstMov = verificarP(p.charAt(36));        // GestiÃ³n Materiales GestiÃ³n stock Documentos Materiales Lista Mov. Materiales
        String gestMat_GSMov = verificarP(p.charAt(37));               // GestiÃ³n Materiales Gestion Stock Movimientos
        String gestMat_GSMov_MovM = verificarP(p.charAt(38));          // GestiÃ³n Materiales GestiÃ³n Stock Movimientos Mov. Material
        String gestMat_GSMov_ResM = verificarP(p.charAt(39));          // GestiÃ³n Materiales GestiÃ³n Stock Reservas
        String gestMat_GSMov_ResMCr = verificarP(p.charAt(40));        // GestiÃ³n Materiales GestiÃ³n Stock Reservas
        String gestMat_GSMov_ResMMo = verificarP(p.charAt(41));        // GestiÃ³n Materiales GestiÃ³n Stock Reservas
        String gestMat_GSMov_ResMVi = verificarP(p.charAt(42));        // GestiÃ³n Materiales GestiÃ³n Stock Reservas
        String gestMatListReser = verificarP(p.charAt(43));            // Lkstas Reservas
        String gestMat_GSMov_EntSer = verificarP(p.charAt(44));        // GestiÃ³n Materiales GestiÃ³n Stock Entrada Servicios
        String gestMat_GSStockM = verificarP(p.charAt(45));            // Gestion Materiales GestiÃ³n Stock Stock Material
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////// Gestion Comerial /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestCome = verificarP(p.charAt(46));
        //////////////////////// Cotizacion //////////////////////////////////////////////////////////////////////////////
        String gestCome_Cotizacion = verificarP(p.charAt(47));
        String gestCome_Cotiz_Crear = verificarP(p.charAt(48));
        String gestCome_Cotiz_Modif = verificarP(p.charAt(49));
        String gestCome_Cotiz_Visual = verificarP(p.charAt(50));
        /////////////////////// Pedidos ///////////////////////////////////////////////////////////////////////////
        String gestCome_Pedidos = verificarP(p.charAt(51));
        String gestCome_Pedi_Crear = verificarP(p.charAt(52));
        String gestCome_Pedi_Modif = verificarP(p.charAt(53));
        String gestCome_Pedi_Visua = verificarP(p.charAt(54));       
        //////////////////////// GestiÃ³n Mantenimiento ////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant = verificarP(p.charAt(55));                    // GestiÃ³n Matenimiento
        //////////////////////////////// Datos Maestros /////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_DM = verificarP(p.charAt(56));                 // GestiÃ³n Mantenimiento Datos Maestros
        String gestMant_DMUbi = verificarP(p.charAt(57));              // GestiÃ³n Mantenimiento Datos Maestros Ubicaciones
        String gestMant_DMUbi_Cre = verificarP(p.charAt(58));          // GestiÃ³n Mantenimiento Datos Maestros Ubicaciones Crear
        String gestMant_DMUbi_Mod = verificarP(p.charAt(59));          // GestiÃ³n Mantenimiento Datos Maestros Ubicaciones Modificar
        String gestMant_DMUbi_Vis = verificarP(p.charAt(60));          // GestiÃ³n Mantenimiento Datos Maestros Ubicaciones Visualizar
        String gestMant_DMEqui = verificarP(p.charAt(61));             // GestiÃ³n Mantenimiento Datos Maestros Equipos
        String gestMant_DMEqui_Cre = verificarP(p.charAt(62));         // GestiÃ³n Mantenimiento Datos Maestros Equipos Crear
        String gestMant_DMEqui_Mod = verificarP(p.charAt(63));         // GestiÃ³n Mantenimiento Datos Maestros Equipos Modificar
        String gestMant_DMEqui_Vis = verificarP(p.charAt(64));         // GestiÃ³n Mantenimiento Datos Maestros Equipos Visualizar
        String gestMant_DMBom = verificarP(p.charAt(65));              // GestiÃ³n Mantenimiento Datos Maestros Boom Equipos
        String gestMant_DMBom_Crea = verificarP(p.charAt(66));         // GestiÃ³n Mantenimiento Datos Maestros Boom Equipos Crear
        String gestMant_DMBom_Mod = verificarP(p.charAt(67));          // GestiÃ³n Mantenimiento Datos Maestros Boom Equipos Modificar
        String gestMant_DMBom_Vis = verificarP(p.charAt(68));          // GestiÃ³n Mantenimiento Datos Maestros Boom Equipos Visualizar
        String gestMant_DMHrut = verificarP(p.charAt(69));             // GestiÃ³n Mantenimiento Datos Maestros Hojas Ruta
        String gestMant_DMHrut_Cra = verificarP(p.charAt(70));         // GestiÃ³n Mantenimiento Datos Maestros Hojas Ruta Crear 
        String gestMant_DMHrut_Mod = verificarP(p.charAt(71));         // GestiÃ³n Mantenimiento Datos Maestros Hojas Ruta Modificar
        String gestMant_DMHrut_Vis = verificarP(p.charAt(72));         // GestiÃ³n Mantenimiento Datos Maestros Hojas Ruta Visualizar
        ///////////////////////////// Monitor de Equipos //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_ME = verificarP(p.charAt(73));                 // GestiÃ³n Mantenimiento Monitor de Equipos
        String gestMant_ME_MCPxE = verificarP(p.charAt(74));           // GestiÃ³n Mantenimiento Monitor de Equipos Monitor de Contadores y Plan de Mantenimiento
        //////////////////////////// Avisos PM /////////////////////////////////////////////////////////////////////////////////////
        String gestMant_APM = verificarP(p.charAt(75));                // GestiÃ³n Mantenimiento Avisos PM
        String gestMant_APM_MAPM = verificarP(p.charAt(76));           // GestiÃ³n Mantenimiento Avisos PM Monitor de Avisos PM
        String gestMant_APM_Cre = verificarP(p.charAt(77));            // GestiÃ³n Mantenimiento Avisos PM Crear
        String gestMant_APM_Mod = verificarP(p.charAt(78));            // GestiÃ³n Mantenimiento Avisos PM Modificar
        String gestMant_APM_Vis = verificarP(p.charAt(79));            // GestiÃ³n Mantenimiento Avisos PM Visualizar
        ////////////////////////// Ordenes PM //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_OPM = verificarP(p.charAt(80));                // GestiÃ³n Mantenimiento Ordenes PM
        String gestMant_OPM_Cre = verificarP(p.charAt(81));            // GestiÃ³n Mantenimiento Ordenes PM Crear
        String gestMant_OPM_Mod = verificarP(p.charAt(82));            // GestiÃ³n Mantenimiento Ordenes PM Modificar 
        String gestMant_OPM_Vis = verificarP(p.charAt(83));            // GestiÃ³n Mantenimiento Ordenes PM Visualizar
        String gestMant_OPM_LstO = verificarP(p.charAt(84));           // GestiÃ³n Mantenimiento Ordenes PM Lista de Ordenes
        ////////////////////// Notificaciones PM /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_NPM = verificarP(p.charAt(85));                // GestiÃ³n Mantenimiento Notificaciones PM      
        String gestMant_NPM_Cre = verificarP(p.charAt(86));            // GestiÃ³n Mantenimiento Notificaciones PM Crear
        String gestMant_NPM_Vis = verificarP(p.charAt(87));            // GestiÃ³n Mantenimiento Notificaciones PM Visualizar
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////// Gestiòn de Calidad ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestCali = verificarP(p.charAt(88));                    // GestiÃ³n de Calidad
        ///////////////////// Plan de Inspecciòn ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestCali_PIM = verificarP(p.charAt(89));                // Plan de inspeccion de calidad para Material
        String gestCaliMe_PIM = verificarP(p.charAt(90));              // Calidad Medidas
        String gestListaMLIe_PIM = verificarP(p.charAt(91));           // Listado Lotes de inspección
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////// Gestión de Documentos ////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestDocu = verificarP(p.charAt(92));
        ///////////////////// Visualizar Documentos ////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestDocu_VisDoc = verificarP(p.charAt(93));////////////////7
        ////////////////////// Gestion produccion
        String Getion_prod = verificarP(p.charAt(94));
        String gestMant_PP = verificarP(p.charAt(95));
        String gestMant_PPUbi = verificarP(p.charAt(96));
        String gestMant_PPUbi_Cre = verificarP(p.charAt(97));
        String gestMant_PPUbi_Mod = verificarP(p.charAt(98));
        String gestMant_PPDMUbi_Vis = verificarP(p.charAt(99));
        String gestMant_PPEqui = verificarP(p.charAt(100));
        String gestMant_PPEqui_Cre = verificarP(p.charAt(101));
        String gestMant_PPEqui_Mod = verificarP(p.charAt(102));
        String gestMant_PPEqui_Vis = verificarP(p.charAt(103));
        String gestMant_PPBom = verificarP(p.charAt(104));
        String gestMant_PPBom_Crea = verificarP(p.charAt(105));
        String gestMant_PPBom_Mod = verificarP(p.charAt(106));
        String gestMant_PPBom_Vis = verificarP(p.charAt(107));
        String gestMant_PPHrut = verificarP(p.charAt(108));
        String gestMant_PPHrut_Cra = verificarP(p.charAt(109));
        String gestMant_PPHrut_Mod = verificarP(p.charAt(110));
        String gestMant_PPHrut_Vis = verificarP(p.charAt(111));
       ////////////////////// Monitor de Equipos PP //////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_MEPP = verificarP(p.charAt(112));                 // GestiÃ³n Mantenimiento Monitor de Equipos PP
        String gestMant_MPP = verificarP(p.charAt(113));                    // GestiÃ³n Mantenimiento Monitor PP
        String gestMant_ME_MCPxEPP = verificarP(p.charAt(114));           // GestiÃ³n Mantenimiento Notificar tiempos PP
        String gestMant_ME_RepNot = verificarP(p.charAt(115));              // GestiÃ³n Mantenimiento Reporte Not
        String gestMant_ME_RepStatusOrd = verificarP(p.charAt(115));        // GestiÃ³n Mantenimiento Reporte Status
        //////////////////////////// Avisos PP /////////////////////////////////////////////////////////////////////////////////////
        String gestMant_APP = verificarP(p.charAt(115));                // GestiÃ³n Mantenimiento Avisos PP
        String gestMant_APP_MAP = verificarP(p.charAt(116));           // GestiÃ³n Mantenimiento Avisos PP Monitor de Avisos PM
        String gestMant_APP_Cre = verificarP(p.charAt(117));            // GestiÃ³n Mantenimiento Avisos PP Crear
        String gestMant_APP_Mod = verificarP(p.charAt(118));            // GestiÃ³n Mantenimiento Avisos PP Modificar
        String gestMant_APP_Vis = verificarP(p.charAt(119));            // GestiÃ³n Mantenimiento Avisos PP Visualizar
        ////////////////////////// Ordenes PP //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_OPP = verificarP(p.charAt(120));                // GestiÃ³n Mantenimiento Ordenes PP
        String gestMant_OPP_Cre = verificarP(p.charAt(121));            // GestiÃ³n Mantenimiento Ordenes PP Crear
        String gestMant_OPP_Mod = verificarP(p.charAt(122));            // GestiÃ³n Mantenimiento Ordenes PP Modificar 
        String gestMant_OPP_Vis = verificarP(p.charAt(123));            // GestiÃ³n Mantenimiento Ordenes PP Visualizar
        String gestMant_OPP_LstO = verificarP(p.charAt(124));           // GestiÃ³n Mantenimiento Ordenes PP Lista de Ordenes
        ////////////////////// Notificaciones PP /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String gestMant_NPP = verificarP(p.charAt(125));                // GestiÃ³n Mantenimiento Notificaciones PP      
        String gestMant_NPP_Cre = verificarP(p.charAt(126));            // GestiÃ³n Mantenimiento Notificaciones PP Crear
        String gestMant_NPP_Vis = verificarP(p.charAt(127));            // GestiÃ³n Mantenimiento Notificaciones PP1 Visualizar
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
                                                    <li class="current" style="display:<%=gestMat_datMmat%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatComProveedor_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_datMCCCreaP%>"><a href="CreaProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompCrearProv_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCCModP%>"><a href="ModificaProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompModificarProv_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_VisP%>"><a href="VisualizarProveedores.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompVisProv_menu"));%></a></li>
                                                        </ul> 
                                                    <li class="current" style="display:<%=gestMat_datMmat%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompInfoRecord_menu"));%></a>
                                                        <ul>
                                                            <li style="display: <%=gestMat_datMCC_VisInR%>"><a href="CrearInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompCrearInfo_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_VisP%>"><a href="ModificarInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompModificarInfo_menu"));%></a></li>
                                                            <li style="display: <%=gestMat_datMCC_VisInR%>"><a href="VisualizarInfoRecords.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCatCompVisInfo_menu"));%></a></li>
                                                        </ul>
                                                 </ul>     
                                            </li>
                                            <li class="current" style="display: <%=gestMat_datMC%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosClientes_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMat_datMCC_VisP%>"><a href="CrearClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosCrearCliente_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_datMCC_VisInR%>"><a href="ModificarClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosModificarCliente_menu"));%></a></li>
                                                    <li style="display: <%=gestMat_datMC_VisC%>"><a href="VisualizarClientes.jsp"><%out.println(po.getProperty("etiqueta.DatosMaestrosVisCliente_menu"));%></a></li>
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
                                            <li style="display: <%=gestCome_Cotiz_Modif%>"><a href="#"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
<!--                                            <li style="display: <%=gestCome_Cotiz_Modif%>"><a href="ModificarCotizacion.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>-->
                                            <li style="display: <%=gestCome_Cotiz_Visual%>"><a href="VisualizarCotizacion.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
                                    <li class="current" style="display: <%=gestCome_Pedidos%>"><a href="#"><%out.println(po.getProperty("etiqueta.GestionComercial_Pedidos_menu"));%></a>
                                        <ul>
                                            <li style="display: <%=gestCome_Pedi_Crear%>"><a href="CrearPedidoSD.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                            <li style="display: <%=gestCome_Pedi_Modif%>"><a href="#"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                            <!--<li style="display: <%=gestCome_Pedi_Modif%>"><a href="ModificarPedidosSD.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>-->
                                            <li style="display: <%=gestCome_Pedi_Visua%>"><a href="VisualizarPedidosSD.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                        </ul>
                                    </li>
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
                                    <li class="current" style="display: <%=gestMant_PP%>"><a href="#"><%out.println(po.getProperty("etiqueta.DatosMaestrosPP"));%></a>
                                        <ul>
<!--                                            <li class="current" style="display: <%=gestMant_PPUbi%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_DatosMaestrosUbicac_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_PPUbi_Cre%>"><a href="CrearUbicacionesTecnicasPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPUbi_Mod%>"><a href="ModificarUbicacionesTecnicasPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPDMUbi_Vis%>"><a href="VisualizarUbicacionesTecnicasPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>-->
                                            <li class="current" style="display: <%=gestMant_PPEqui%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_Materiales_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_PPEqui_Cre%>"><a href="CrearMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPEqui_Mod%>"><a href="ModificarMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPEqui_Vis%>"><a href="VisualizarMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMant_PPBom%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_BoomEqui_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_PPBom_Crea%>"><a href="CrearBomMaterialPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPBom_Mod%>"><a href="ModificarBomMaterialPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPBom_Vis%>"><a href="VisualizarBomMaterialesPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                            <li class="current" style="display: <%=gestMant_PPHrut%>"><a href="#"><%out.println(po.getProperty("etiqueta.PP_HojaRuta_menu"));%></a>
                                                <ul>
                                                    <li style="display: <%=gestMant_PPHrut_Cra%>"><a href="CrearHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Crear_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPHrut_Mod%>"><a href="ModificarHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Modi_menu"));%></a></li>
                                                    <li style="display: <%=gestMant_PPHrut_Vis%>"><a href="VisualizarHojasRutaPP.jsp"><%out.println(po.getProperty("etiqueta.Vis_menu"));%></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>                                    
                                    <!--Monitor Status PP-->
                                    <li class="current" style="display: <%=gestMant_MEPP%>"><a href="#">Notificar Tiempos PP</a>
                                        <ul>
                                            <li class="current" style="display: <%=gestMant_MPP%>"> <a href="MonitorPP.jsp">Monitor PP</a></li>
                                            <li class="current" style="display: <%=gestMant_ME_MCPxEPP%>"> <a href="NotificacionTiemposPP.jsp">Notificar Tiempos</a></li>
                                            <li class="current" style="display: <%=gestMant_ME_RepNot%>"> <a href="ReporteMovNotificaciones.jsp">Reporte Notificaciones</a></li>
                                            <li class="current" style="display: <%=gestMant_ME_RepStatusOrd%>"> <a href="ReporteStatusOrdenesPP.jsp">Reporte Estatus</a></li>
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
        </script>
        <div class="contenido">
            <div class="logoimage">
                <IMG SRC="images/Logo_Empresa.png"  ALT="Logo">
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
                width: 40%;
                margin-left: 30%;
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
        </style>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
