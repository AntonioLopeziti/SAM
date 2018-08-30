<%-- 
    Document   : VisualizarUsuarios
    Created on : 29/06/2016, 12:11:59 PM
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String reso = po.getProperty("etiqueta.Resolucio");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
        String Mens = po.getProperty("etiqueta.CompObligatorios");
        String MenVal = po.getProperty("etiqueta.MsgErorVal_User");
        String MenInval = po.getProperty("etiqueta.FuncionInval_Menu");

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
        String flujoDoc = "Flujo de documentos";
        String flujoDeu = "Saldo de clientes";
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
        String ListaRes = po.getProperty("etiqueta.ListaReser");
        String GesComer = "Gestión Comercial";
        String GesComer_cot = "Cotización";
        String GesComer_Ped = "Pedido Venta";
        String GesProd = "Gestión Producción";
        String DatosM = "Datos Maestros";
        String DatosMMat = "Materiales";
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
                var pag = p.charAt(4);
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
                        msg = '<%=MenVal%>';
                        break;
                    case 3:
                        msg = '<%=OKconsul%>';
                        break;
                    case 4:
                        msg = "<%=menValores%>";
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
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarUsuaro.js"></script>
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
        <script src="js/jquery.dynatreeUn.js" type="text/javascript"></script> 
        <title><%out.println(po.getProperty("etiqueta.VisualizarUsuar_USU"));%></title>       
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
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>      
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.VisualizarUsuar_USU"));%></h1></div> 
        </div>
        <div class="contenido">
            <div class="CrearUser_USU">
                <div class="DivParame_USU">
                    <label><%out.println(po.getProperty("etiqueta.ParametrosBus_USU"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="CompUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></label><input type="text" maxlength="10" id="User_U" style="width:20%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/><button id="btnmatch"  class="BtnMatchIcon"></button>
                        <hr>                               
                    </div>
                </div> 
                <div class="DivParame_USU">
                    <label><%out.println(po.getProperty("etiqueta.StatusSistemaUse_USU"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="CompUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Centro_USCR"));%></label><input type="text" maxlength="4"  id="Centro_U" disabled style="width:8%; text-transform: uppercase;"/><input style="margin-left: 20%; margin-top: -30%;" type="checkbox" id="Habilitado_U" disabled/><label><%out.println(po.getProperty("etiqueta.StatusUse_USU"));%></label> 
                        <hr>                                                                          
                    </div>
                </div>   
                <div class="DivDatosUsePerson_USU">
                    <label><%out.println(po.getProperty("etiqueta.DatosPeson_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="DivIzquUser_USE">                                    
                        <label><%out.println(po.getProperty("etiqueta.Nombre_USCR"));%></label><input type="text" id="Nombre_U" value="" style="width: 50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApePat_USCR"));%></label><input type="text" id="APP_U" style="width: 50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApeMat_USCR"));%></label><input type="text" id="APM_U" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.RFC_USCR"));%></label><input type="text" id="RFC_U" style="width:50%;" disabled/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Corre_USCR"));%></label><input type="text" id="Email_U" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono_USCR"));%></label><input type="text" id="Tel1_U" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono2_USCR"));%></label><input type="text" id="Tel2_U" style="width:50%;" disabled/>
                        <hr>
                    </div>
                </div> 
                <div class="Direc_USCR">
                    <label><%out.println(po.getProperty("etiqueta.Direccion_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US"> 
                    <div class="DivIzquUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Calle_USCR"));%></label><input type="text" id="Calle_U" style="width:50%;" disabled />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumInt_USCR"));%></label><input type="text" id="NumInt_U" style="width:30%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumExt_USCR"));%></label><input type="text" id="NumExt_U" style="width:30%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Colonia_USCR"));%></label><input type="text" id="Colonia_U" style="width:45%;" disabled/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Poblacion_USCR"));%></label><input type="text" id="Poblacion_U" style="width:40%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Estado_USCR"));%></label><input type="text" id="Estado_U" style="width: 40%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CvePais"));%></label><input type="text" id="Pais_U" style="width: 45%;" disabled/>
                        <hr>
                    </div>                            
                </div> 
                <div class="DivPermisoU_USCR">
                    <label><%out.println(po.getProperty("etiqueta.Permisos_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US"> 
                    <div id="tree3"></div>                          
                </div>
            </div>
        </div>
        <div id="VentanaModal" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMCUser"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnbuuser"><%out.println(po.getProperty("etiqueta.BuscarPUsuario_USr"));%></button><hr></div>
            <div id="BuscarParam_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch"><label><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>
                        </label><input type="text" maxlength="10" id="usuariio_bus" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okUs"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarMCUser2" style="cursor: pointer"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></th><th><%out.println(po.getProperty("etiqueta.Nombre_USCR"));%></th><th><%out.println(po.getProperty("etiqueta.RFC_USCR"));%></th>
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
                <span><input type="image" style="float:left; margin-top: -2.5px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
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
                WriteDate.html("Fecha indefinida");
            }
                </script>
            </div>
        </footer>
    </body>
    <script>
        function CargarPemisos(use) {
            var acc = "CargarPermisos";
            var p;
            $.ajax({
                async: false,
                type: "GET",
                url: "peticionModuloVisualUsuario",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&Parametro1=" + use,
                success: function (data) {
                    p = data;
                    var treeData = [
                        {title: '<%=menu_m%>', key: "menu", expand: true, select: true,
                            children: [
                                {title: '<%=conf_m%>', key: "conf", expand: true,
                                    children: [
                                        {title: '<%=usua_m%>', key: "conf_user", expand: true,
                                            children: [
                                                {title: '<%=crear_m%>', key: "conf_userCrear"},
                                                {title: '<%=modif_m%>', key: "conf_userModif"},
                                                {title: '<%=visua_m%>', key: "conf_userVisual"}
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
                                {title: '<%=GesComer%>', key: "gestCom", expand: true,
                                    children: [
                                        {title: '<%=GesComer_cot%>', key: "gestCom_Cot", expand: true,
                                            children: [
                                                {title: '<%=crear_m%>', key: "gestCom_Cot_cre"},
                                                {title: '<%=modif_m%>', key: "gestCom_Cot_mod"},
                                                {title: '<%=visua_m%>', key: "gestCom_Cot_vis"}
                                            ]},
                                        {title: '<%=GesComer_Ped%>', key: "gestCom_Ped", expand: true,
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
                                                    ]
                                                },
                                                {title: '<%=equip_m%>', key: "gestMant_DM_Equi", expand: true,
                                                    children: [
                                                        {title: '<%=crear_m%>', key: "gestMant_DM_Equi_cre"},
                                                        {title: '<%=modif_m%>', key: "gestMant_DM_Equi_mod"},
                                                        {title: '<%=visua_m%>', key: "gestMant_DM_Equi_vis"}
                                                    ]
                                                },
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
                    $("#tree3").dynatree({
                        checkbox: true,
                        selectMode: 3,
                        children: treeData,
                        onDblClick: function (node, event) {
                            //                                        node.toggleSelect();
                        },
                        onKeydown: function (node, event) {
                            if (event.which == 32) {
                                //                                            node.toggleSelect();
                                //                                            return false;
                            }
                        },
                        // The following options are only required, if we have more than one tree on one page:
                        //				initId: "treeData",
                        cookieId: "dynatree-Cb3",
                        idPrefix: "dynatree-Cb3-"
                    });
                    getPermission("conf", p.charAt(0)); // Configuracion
                    getPermission("conf_user", p.charAt(1)); // Configuracion - Usuario
                    getPermission("conf_userCrear", p.charAt(2)); // Configuracion - Usuario - Crear
                    getPermission("conf_userModif", p.charAt(3)); // Configuracion - Usuario - Modificar
                    getPermission("conf_userVisual", p.charAt(4)); // Configuracion -  Usuario - Visualizar
                    getPermission("conf_fol", p.charAt(5)); // Configuracion - Folios 
                    getPermission("conf_folCrear", p.charAt(6)); // Configuracion - Folios - Crear
                    getPermission("conf_folModif", p.charAt(7)); // Configuracion Folio - Modificar
                    getPermission("conf_folVisual", p.charAt(8)); // Configuracion Folio - Visualizar
                    getPermission("conf_repo", p.charAt(9)); // Reportes
                    getPermission("conf_repoSAM", p.charAt(10)); // Reportes SAM
                    getPermission("gestMat", p.charAt(11)); // G. Materiales
                    getPermission("gestMat_org", p.charAt(12)); // G. Materiales - Organizacion
                    getPermission("gestMat_orgCen", p.charAt(13)); // G. Materiales - Organizacion - Centro
                    getPermission("gestMat_orgAlmXc", p.charAt(14)); // G. Materiales - Organizacion - Alm x centro
                    getPermission("gestMat_datM", p.charAt(15)); // G. Materiales - Datos Maestros
                    getPermission("gestMat_datMmat", p.charAt(16)); // G. Materiales - Datos Maestros - Materiales
                    getPermission("gestMat_datMmatCrear", p.charAt(17)); // G. Materiales - Datos Maestros - Materiales - Crear
                    getPermission("gestMat_datMmatMod", p.charAt(18)); // G. Materiales - Datos Maestros - Materiales - Modificar
                    getPermission("gestMat_datMmatVis", p.charAt(19)); // G. Materiales - Datos Maestros - Materiales - Visualizar
                    getPermission("gestMat_datMCC", p.charAt(20)); // G. Materiales - Datos Maestros - Cat. Compras 
                    getPermission("gestMat_datMCC_Prov", p.charAt(21)); // G. Materiales - Datos Maestros - Cat. Compras - Proveedor
                    getPermission("gestMat_datMCC_Prov_cre", p.charAt(22)); // G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Crear
                    getPermission("gestMat_datMCC_Prov_mod", p.charAt(23)); // G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Modificar
                    getPermission("gestMat_datMCC_Prov_vis", p.charAt(24)); // G. Materiales - Datos Maestros - Cat. Compras - Proveedor - Visualizar
                    getPermission("gestMat_datMCC_InfoRec", p.charAt(25)); // // G. Materiales - Datos Maestros - Cat. Compras - Inforecord
                    getPermission("gestMat_datMCC_InfoRec_cre", p.charAt(26)); // // G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Crea
                    getPermission("gestMat_datMCC_InfoRec_mod", p.charAt(27)); // // G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Modifica
                    getPermission("gestMat_datMCC_InfoRec_vis", p.charAt(28)); // // G. Materiales - Datos Maestros - Cat. Compras - Inforecord - Visualiza
                    getPermission("gestMat_datMCC_Clie", p.charAt(29)); // // G. Materiales - Datos Maestros - Cat. Compras - Clientes 
                    getPermission("gestMat_datMCC_Clie_cre", p.charAt(30)); // // G. Materiales - Datos Maestros - Cat. Compras - Clientes - Crea
                    getPermission("gestMat_datMCC_Clie_mod", p.charAt(31)); // // G. Materiales - Datos Maestros - Cat. Compras - Clientes - Modifica
                    getPermission("gestMat_datMCC_Clie_vis", p.charAt(32)); // // G. Materiales - Datos Maestros - Cat. Compras - Clientes - Visualiza
                    getPermission("gestMat_Comp", p.charAt(33)); // // G. Materiales - Compras
                    getPermission("gestMat_Comp_SC", p.charAt(34)); // // G. Materiales - Compras - Solicitud Compras
                    getPermission("gestMat_Comp_SC_cre", p.charAt(35)); // // G. Materiales - Compras - Solicitud Compras
                    getPermission("gestMat_Comp_SC_mod", p.charAt(36)); // // G. Materiales - Compras - Solicitud Compras - Crear
                    getPermission("gestMat_Comp_SC_vis", p.charAt(37)); // // G. Materiales - Compras - Solicitud Compras - Modificar
                    getPermission("gestMat_Comp_SC_lisSol", p.charAt(38)); // // G. Materiales - Compras - Solicitud Compras - Visualizar
                    getPermission("gestMat_Comp_PC", p.charAt(39)); // // G. Materiales - Compras - Pedidos de compra
                    getPermission("gestMat_Comp_PC_vis", p.charAt(40)); // // G. Materiales - Compras - Pedidos de compra - Visualizar
                    getPermission("gestMat_GesStk", p.charAt(41)); // // G. Materiales - G. Stock
                    getPermission("gestMat_GesStk_DocMat", p.charAt(42)); // // G. Materiales - G. Stock - Doc Material
                    getPermission("gestMat_GesStk_DocMat_VisDocMar", p.charAt(43)); // // G. Materiales - G. Stock - Doc Material - Visualizar Doc Mat
                    getPermission("gestMat_GesStk_DocMat_ListMov", p.charAt(44)); // // G. Materiales - G. Stock - Doc Material - Listas Mov
                    getPermission("gestMat_GesStk_Movim", p.charAt(45)); // // G. Materiales - G. Stock - Movimientos
                    getPermission("gestMat_GesStk_Movim_MovMat", p.charAt(46)); // // G. Materiales - G. Stock - Movimientos - Movimientos Materiales
                    getPermission("gestMat_GesStk_Movim_Reser", p.charAt(47)); // // G. Materiales - G. Stock - Movimientos - Reservas
                    getPermission("gestMat_GesStk_Movim_Reser_cre", p.charAt(48)); // // G. Materiales - G. Stock - Movimientos - Reservas - Crear
                    getPermission("gestMat_GesStk_Movim_Reser_mod", p.charAt(49)); // // G. Materiales - G. Stock - Movimientos - Reservas - Modificar
                    getPermission("gestMat_GesStk_Movim_Reser_vis", p.charAt(50)); // // G. Materiales - G. Stock - Movimientos - Reservas - Visualizar
                    getPermission("gestMat_GesStk_Movim_Reser_LisRes", p.charAt(51)); // // G. Materiales - G. Stock - Movimientos - Reservas - Listas de reservas
                    getPermission("gestMat_GesStk_Movim_EntSer", p.charAt(52)); // // G. Materiales - G. Stock - Movimientos - Entradas de Servicio
                    getPermission("gestMat_GesStk_StkMat", p.charAt(53)); // // G. Materiales - G. Stock - Stock Material
                    getPermission("gestCom", p.charAt(54)); // // G. Comercial
                    getPermission("gestCom_Cot", p.charAt(55)); // // G. Comercial - Cotizacion
                    getPermission("gestCom_Cot_cre", p.charAt(56)); // // G. Comercial - Cotizacion - Crear
                    getPermission("gestCom_Cot_mod", p.charAt(57)); // // G. Comercial - Cotizacion - Modificar
                    getPermission("gestCom_Cot_vis", p.charAt(58)); // // G. Comercial - Cotizacion - Visualizar
                    getPermission("gestCom_Ped", p.charAt(59)); // // G. Comercial - Pedidos
                    getPermission("gestCom_Ped_cre", p.charAt(60)); // // G. Comercial - Pedidos - Crear
                    getPermission("gestCom_Ped_mod", p.charAt(61)); // // G. Comercial - Pedidos - Modificar
                    getPermission("gestCom_Ped_vis", p.charAt(62)); // // G. Comercial - Pedidos - Visualizar
                    getPermission("gestMant", p.charAt(63)); // // G. Mantenimiento
                    getPermission("gestMant_DM", p.charAt(64)); // // G. Mantenimiento - Datos Maestros
                    getPermission("gestMant_DM_UbiTec", p.charAt(65)); // // G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas
                    getPermission("gestMant_DM_UbiTec_cre", p.charAt(66)); // // G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Crear
                    getPermission("gestMant_DM_UbiTec_mod", p.charAt(67)); // // G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Modificar
                    getPermission("gestMant_DM_UbiTec_vis", p.charAt(68)); // // G. Mantenimiento - Datos Maestros - Ubicaciones tecnicas - Visualizar
                    getPermission("gestMant_DM_Equi", p.charAt(69)); // // G. Mantenimiento - Datos Maestros - Equipos
                    getPermission("gestMant_DM_Equi_cre", p.charAt(70)); // // G. Mantenimiento - Datos Maestros - Equipos - Crear
                    getPermission("gestMant_DM_Equi_mod", p.charAt(71)); // // G. Mantenimiento - Datos Maestros - Equipos - Modificar
                    getPermission("gestMant_DM_Equi_vis", p.charAt(72)); // // G. Mantenimiento - Datos Maestros - Equipos - Visualizar
                    getPermission("gestMant_DM_LisMat", p.charAt(73)); // // G. Mantenimiento - Datos Maestros - lista Materiales
                    getPermission("gestMant_DM_LisMat_cre", p.charAt(74)); // // G. Mantenimiento - Datos Maestros - lista Materiales - Crear
                    getPermission("gestMant_DM_LisMat_mod", p.charAt(75)); // // G. Mantenimiento - Datos Maestros - lista Materiales - Modificar
                    getPermission("gestMant_DM_LisMat_vis", p.charAt(76)); // // G. Mantenimiento - Datos Maestros - lista Materiales - Visualizar
                    getPermission("gestMant_DM_HR", p.charAt(77)); // // G. Mantenimiento - Datos Maestros - Hojas de ruta
                    getPermission("gestMant_DM_HR_cre", p.charAt(78)); // // G. Mantenimiento - Datos Maestros - Hojas de ruta - Crear
                    getPermission("gestMant_DM_HR_mod", p.charAt(79)); // // G. Mantenimiento - Datos Maestros - Hojas de ruta - Modificar
                    getPermission("gestMant_DM_HR_vis", p.charAt(80)); // // G. Mantenimiento - Datos Maestros - Hojas de ruta - Visualizar
                    getPermission("gestMant_MonEq", p.charAt(81)); // // G. Mantenimiento - Monitor Equipos
                    getPermission("gestMant_MonEq_MonSta", p.charAt(82)); // // G. Mantenimiento - Monitor Equipos - Monitor Status
                    getPermission("gestMant_Avi", p.charAt(83)); // // G. Mantenimiento - Avisos
                    getPermission("gestMant_Avi_MonAv", p.charAt(84)); // // G. Mantenimiento - Avisos - Monito Avisos
                    getPermission("gestMant_Avi_cre", p.charAt(85)); // // G. Mantenimiento - Avisos - Crear
                    getPermission("gestMant_Avi_mod", p.charAt(86)); // // G. Mantenimiento - Avisos - Modificar
                    getPermission("gestMant_Avi_vis", p.charAt(87)); // // G. Mantenimiento - Avisos - Visualizar
                    getPermission("gestMant_Ord", p.charAt(88)); // // G. Mantenimiento - Ordenes
                    getPermission("gestMant_Ord_cre", p.charAt(89)); // // G. Mantenimiento - Ordenes - Crear
                    getPermission("gestMant_Ord_mod", p.charAt(90)); // // G. Mantenimiento - Ordenes - Modificar
                    getPermission("gestMant_Ord_vis", p.charAt(91)); // // G. Mantenimiento - Ordenes - Visualizar
                    getPermission("gestMant_Ord_lisOr", p.charAt(92)); // // G. Mantenimiento - Ordenes - Lista Ordenes
                    getPermission("gestMant_Not", p.charAt(93)); // // G. Mantenimiento - Notificaciones
                    getPermission("gestMant_Not_Cre", p.charAt(94)); // // G. Mantenimiento - Notificaciones - Crear
                    getPermission("gestMant_Not_Vis", p.charAt(95)); // // G. Mantenimiento - Notificaciones - Visualizar
                    getPermission("gestCali", p.charAt(96)); // // G. Calidad
                    getPermission("gestCali_PlanInp", p.charAt(97)); // // G. Calidad - Plan de inspeccion 
                    getPermission("gestCali_MedAvi", p.charAt(98)); // // G. Calidad - Medidas Avisos
                    getPermission("gestCali_LisLotInp", p.charAt(99)); // // G. Calidad - Listas Lotes Inspeccion
                    getPermission("gestDocu", p.charAt(100)); // // G. Documentos
                    getPermission("gestDocu_VisDoc", p.charAt(101)); // // G. Documentos - Visualizar Documentos
                    getPermission("gestProd", p.charAt(102)); // // G. Produccion
                    getPermission("gestProd_DM", p.charAt(103)); // // G. Produccion - Datos maestros
                    getPermission("gestProd_DM_Mat", p.charAt(104)); // // G. Produccion - Datos maestros - Materiales
                    getPermission("gestProd_DM_Mat_cre", p.charAt(105)); // // G. Produccion - Datos maestros - Materiales -Crea
                    getPermission("gestProd_DM_Mat_mod", p.charAt(106)); // // G. Produccion - Datos maestros - Materiales - Modifica
                    getPermission("gestProd_DM_Mat_vis", p.charAt(107)); // // G. Produccion - Datos maestros - Materiales - Visualizar
                    getPermission("gestProd_DM_LM", p.charAt(108)); // // G. Produccion - Datos maestros - Lista Materiales
                    getPermission("gestProd_DM_LM_cre", p.charAt(109)); // // G. Produccion - Datos maestros - Lista Materiales - Crea
                    getPermission("gestProd_DM_LM_mod", p.charAt(110)); // // G. Produccion - Datos maestros - Lista Materiales - Modifica
                    getPermission("gestProd_DM_LM_vis", p.charAt(111)); // // G. Produccion - Datos maestros - Lista Materiales - Visualiza
                    getPermission("gestProd_DM_HR", p.charAt(112)); // // G. Produccion - Datos maestros - Hojas de ruta
                    getPermission("gestProd_DM_HR_cre", p.charAt(113)); // // G. Produccion - Datos maestros - Hojas de ruta - Crea
                    getPermission("gestProd_DM_HR_mod", p.charAt(114)); // // G. Produccion - Datos maestros - Hojas de ruta - Modifica
                    getPermission("gestProd_DM_HR_vis", p.charAt(115)); // // G. Produccion - Datos maestros - Hojas de ruta - Visualiza
                    getPermission("gestProd_NotTi", p.charAt(116)); // // G. Produccion - Notifica Tiempos
                    getPermission("gestProd_NotTi_MonPP", p.charAt(117)); // // G. Produccion - Notifica Tiempos - Monitor PP
                    getPermission("gestProd_NotTi_NotTi", p.charAt(118)); // // G. Produccion - Notifica Tiempos - Notificar tiempos
                    getPermission("gestProd_NotTi_RepBot", p.charAt(119)); // // G. Produccion - Notifica Tiempos - Reporte Notificaciones
                    getPermission("gestProd_NotTi_RepStat", p.charAt(120)); // // G. Produccion - Notifica Tiempos - Reporte Estatus
                    getPermission("gestProd_OrdPP", p.charAt(121)); // // G. Produccion - Ordenes PP
                    getPermission("gestProd_OrdPP_cre", p.charAt(122)); // // G. Produccion - Ordenes PP - Crear
                    getPermission("gestProd_OrdPP_mod", p.charAt(123)); // // G. Produccion - Ordenes PP - Modificar
                    getPermission("gestProd_OrdPP_vis", p.charAt(124)); // // G. Produccion - Ordenes PP - Visualizar
                    getPermission("gestProd_OrdPP_LisOPP", p.charAt(125)); // // G. Produccion - Ordenes PP - Listas de Ordenes PP
                    getPermission("gestProd_NotPP", p.charAt(126)); // // G. Produccion - Notificaciones PP
                    getPermission("gestProd_NotPP_cre", p.charAt(127)); // // G. Produccion - Notificaciones PP - Crear
                    getPermission("gestProd_NotPP_vis", p.charAt(128)); // // G. Produccion - Notificaciones PP - Visualizar                    
                    getPermission("gestCome_Fljdocum", p.charAt(129)); // // G. Comercial - Flujo de documentos                    
                    getPermission("gestCome_FljDeudores", p.charAt(130)); // // G. Comercial - Flujo de documentos                    
                    getPermission("gestMat_GesStk_Repor1000", p.charAt(131)); // // G. Materiales - Reporte Almacen 1000                    
                    getPermission("gestMat_GesStk_ReporEtiquetas", p.charAt(132)); // // G. Produccion - Reporte Etiquetas                    
                }
            });
        }
    </script>

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
