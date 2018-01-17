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
            key = key + getPermission("conf");                         //// 0
            key = key + getPermission("conf_user");                    //// 1
            key = key + getPermission("conf_userCrear");               //// 2
            key = key + getPermission("conf_userModif");               //// 3
            key = key + getPermission("conf_userVisual");              //// 4
            key = key + getPermission("conf_fol");                     //// 5
            key = key + getPermission("conf_folCrear");                //// 6
            key = key + getPermission("conf_folModif");                //// 7
            key = key + getPermission("conf_folVisual");               //// 8
            key = key + getPermission("conf_repo");                    //// 9
            key = key + getPermission("conf_repoSAM");                 //// 10
            key = key + getPermission("gestMat");                      //// 11
            key = key + getPermission("gestMat_org");                  //// 12
            key = key + getPermission("gestMat_orgCen");               //// 13
            key = key + getPermission("gestMat_orgAlmXc");             //// 14
            key = key + getPermission("gestMat_datM");                 //// 15
            key = key + getPermission("gestMat_datMmat");              //// 16
            key = key + getPermission("gestMat_datMmatCrear");         //// 17
            key = key + getPermission("gestMat_datMmatMod");           //// 18
            key = key + getPermission("gestMat_datMmatVis");           //// 19
            key = key + getPermission("gestMat_datMCC");               //// 20
            key = key + getPermission("gestMat_datMCC_VisP");          //// 21
            key = key + getPermission("gestMat_datMCC_VisInR");        //// 22
            key = key + getPermission("gestMat_datMC");                //// 23
            key = key + getPermission("gestMat_datMC_VisC");           //// 24
            key = key + getPermission("gestMat_C");                    //// 25
            key = key + getPermission("gestMat_CSC");                  //// 26
            key = key + getPermission("gestMat_CSC_Cr");               //// 27
            key = key + getPermission("gestMat_CSC_Mod");              //// 28
            key = key + getPermission("gestMat_CSC_Vis");              //// 29
            key = key + getPermission("gestMat_CSC_listas");           //// 30
            key = key + getPermission("gestMat_CPD");                  //// 31
            key = key + getPermission("gestMat_CPD_Vis");              //// 32
            key = key + getPermission("gestMat_GS");                   //// 33
            key = key + getPermission("gestMat_GSDoc");                //// 34
            key = key + getPermission("gestMat_GSDoc_Vis");            //// 35
            key = key + getPermission("gestMat_GSDoc_LstMov");         //// 36
            key = key + getPermission("gestMat_GSMov");                //// 37
            key = key + getPermission("gestMat_GSMov_MovM");           //// 38
            key = key + getPermission("gestMat_GSMov_Rese");           //// 39
            key = key + getPermission("gestMat_GSMov_ReseCr");         //// 40
            key = key + getPermission("gestMat_GSMov_ReseMo");         //// 41
            key = key + getPermission("gestMat_GSMov_ReseVi");         //// 42
            key = key + getPermission("gestMat_GSMov_ReseLis");        //// 43
            key = key + getPermission("gestMat_GSMov_EntSer");         //// 44
            key = key + getPermission("gestMat_GSStockM");             //// 45
            key = key + getPermission("gestMant");                     //// 46
            key = key + getPermission("gestMant_DM");                  //// 47
            key = key + getPermission("gestMant_DMUbi");               //// 48
            key = key + getPermission("gestMant_DMUbi_Cre");           //// 49
            key = key + getPermission("gestMant_DMUbi_Mod");           //// 50
            key = key + getPermission("gestMant_DMUbi_Vis");           //// 51
            key = key + getPermission("gestMant_DMEqui");              //// 52
            key = key + getPermission("gestMant_DMEqui_Cre");          //// 53
            key = key + getPermission("gestMant_DMEqui_Mod");          //// 54
            key = key + getPermission("gestMant_DMEqui_Vis");          //// 55
            key = key + getPermission("gestMant_DMBom");               //// 56
            key = key + getPermission("gestMant_DMBom_Crea");          //// 57
            key = key + getPermission("gestMant_DMBom_Mod");           //// 58
            key = key + getPermission("gestMant_DMBom_Vis");           //// 59
            key = key + getPermission("gestMant_DMHrut");              //// 60
            key = key + getPermission("gestMant_DMHrut_Cra");          //// 61
            key = key + getPermission("gestMant_DMHrut_Mod");          //// 62
            key = key + getPermission("gestMant_DMHrut_Vis");          //// 63
            key = key + getPermission("gestMant_ME");                  //// 64
            key = key + getPermission("gestMant_ME_MCPxE");            //// 65
            key = key + getPermission("gestMant_APM");                 //// 66
            key = key + getPermission("gestMant_APM_MAPM");            //// 67
            key = key + getPermission("gestMant_APM_Cre");             //// 68
            key = key + getPermission("gestMant_APM_Mod");             //// 69
            key = key + getPermission("gestMant_APM_Vis");             //// 70
            key = key + getPermission("gestMant_OPM");                 //// 71
            key = key + getPermission("gestMant_OPM_Cre");             //// 72
            key = key + getPermission("gestMant_OPM_Mod");             //// 73
            key = key + getPermission("gestMant_OPM_Vis");             //// 74
            key = key + getPermission("gestMant_OPM_LstO");            //// 75
            key = key + getPermission("gestMant_NPM");                 //// 76
            key = key + getPermission("gestMant_NPM_Cre");             //// 77
            key = key + getPermission("gestMant_NPM_Vis");             //// 78
            key = key + getPermission("gestCali");                     //// 79
            key = key + getPermission("gestCali_PIM");                 //// 80
            key = key + getPermission("gestCaliAvi_PIM");              //// 81
            key = key + getPermission("gestCalLLIPM_PIM");             //// 82
            key = key + getPermission("gestDocu");                     //// 83
            key = key + getPermission("gestDocu_VisDoc");              //// 84
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
            {title: '<%=menu_m%>', key: "menu", expand: true,
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
                        ]
                    },
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
                                        ]
                                    },
                                    {title: '<%=CatCom_m%>', key: "gestMat_datMCC", expand: true,
                                        children: [
                                            {title: '<%=provee_m%>', key: "gestMat_datMCC_VisP"},
                                            {title: '<%=infore_m%>', key: "gestMat_datMCC_VisInR"}
                                        ]
                                    },
                                    {title: '<%=Clien_m%>', key: "gestMat_datMC", expand: true,
                                        children: [
                                            {title: '<%=VisuCl_m%>', key: "gestMat_datMC_VisC"}
                                        ]
                                    }
                                ]},
                            {title: '<%=Compr_m%>', key: "gestMat_C", expand: true,
                                children: [
                                    {title: '<%=ComSP%>', key: "gestMat_CSC", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMat_CSC_Cr"},
                                            {title: '<%=modif_m%>', key: "gestMat_CSC_Mod"},
                                            {title: '<%=visua_m%>', key: "gestMat_CSC_Vis"},
                                            {title: '<%=listasolp%>', key: "gestMat_CSC_listas"}
                                        ]
                                    },
                                    {title: '<%=PedCom%>', key: "gestMat_CPD", expand: true,
                                        children: [
                                            {title: '<%=VisuPe_m%>', key: "gestMat_CPD_Vis"}
                                        ]
                                    }
                                ]},
                            {title: '<%=GestSt_m%>', key: "gestMat_GS", expand: true,
                                children: [
                                    {title: '<%=DocMat_m%>', key: "gestMat_GSDoc", expand: true,
                                        children: [
                                            {title: '<%=DocMatV_m%>', key: "gestMat_GSDoc_Vis"},
                                            {title: '<%=LiMovMat_m%>', key: "gestMat_GSDoc_LstMov"}
                                        ]
                                    },
                                    {title: '<%=movimi_m%>', key: "gestMat_GSMov", expand: true,
                                        children: [
                                            {title: '<%=MovMat_m%>', key: "gestMat_GSMov_MovM"},
                                            {title: '<%=MovRes_m%>', key: "gestMat_GSMov_Rese", expand: true,
                                                children: [
                                                    {title: '<%=crear_m%>', key: "gestMat_GSMov_ReseCr"},
                                                    {title: '<%=modif_m%>', key: "gestMat_GSMov_ReseMo"},
                                                    {title: '<%=visua_m%>', key: "gestMat_GSMov_ReseVi"},
                                                    {title: '<%=ListaRes%>', key: "gestMat_GSMov_ReseLis"}
                                                ]
                                            },
                                            {title: '<%=MovEntSer_m%>', key: "gestMat_GSMov_EntSer"}
                                        ]
                                    },
                                    {title: '<%=StkMov_m%>', key: "gestMat_GSStockM"}
                                ]
                            }
                        ]},
                    {title: '<%=GesMan_m%>', key: "gestMant", expand: true,
                        children: [
                            {title: '<%=GesMaDM_m%>', key: "gestMant_DM", expand: true,
                                children: [
                                    {title: '<%=ubicac_m%>', key: "gestMant_DMUbi", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DMUbi_Cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DMUbi_Mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DMUbi_Vis"}
                                        ]
                                    },
                                    {title: '<%=equip_m%>', key: "gestMant_DMEqui", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DMEqui_Cre"},
                                            {title: '<%=modif_m%>', key: "gestMant_DMEqui_Mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DMEqui_Vis"}
                                        ]
                                    },
                                    {title: '<%=bommeq_m%>', key: "gestMant_DMBom", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DMBom_Crea"},
                                            {title: '<%=modif_m%>', key: "gestMant_DMBom_Mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DMBom_Vis"}
                                        ]
                                    },
                                    {title: '<%=HojRut_m%>', key: "gestMant_DMHrut", expand: true,
                                        children: [
                                            {title: '<%=crear_m%>', key: "gestMant_DMHrut_Cra"},
                                            {title: '<%=modif_m%>', key: "gestMant_DMHrut_Mod"},
                                            {title: '<%=visua_m%>', key: "gestMant_DMHrut_Vis"}
                                        ]
                                    }

                                ]},
                            {title: '<%=MonEquip_m%>', key: "gestMant_ME", expand: true,
                                children: [
                                    {title: '<%=MonECont_m%>', key: "gestMant_ME_MCPxE"}
                                ]},
                            {title: '<%=AvisoPM_m%>', key: "gestMant_APM", expand: true,
                                children: [
                                    {title: '<%=MonitorAvisoPM_m%>', key: "gestMant_APM_MAPM"},
                                    {title: '<%=crear_m%>', key: "gestMant_APM_Cre"},
                                    {title: '<%=modif_m%>', key: "gestMant_APM_Mod"},
                                    {title: '<%=visua_m%>', key: "gestMant_APM_Vis"}
                                ]},
                            {title: '<%= OrdenePM_m%>', key: "gestMant_OPM", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestMant_OPM_Cre"},
                                    {title: '<%=modif_m%>', key: "gestMant_OPM_Mod"},
                                    {title: '<%=visua_m%>', key: "gestMant_OPM_Vis"},
                                    {title: '<%=ListOrden_m%>', key: "gestMant_OPM_LstO"}
                                ]},
                            {title: '<%=Notif_m%>', key: "gestMant_NPM", expand: true,
                                children: [
                                    {title: '<%=crear_m%>', key: "gestMant_NPM_Cre"},
                                    {title: '<%=visua_m%>', key: "gestMant_NPM_Vis"}
                                ]}
                        ]},
                    {title: '<%=GestCal%>', key: "gestCali", expand: true,
                        children: [
                            {title: '<%=GestCal_PIM%>', key: "gestCali_PIM"},
                            {title: '<%=GestCalAvi_PIM%>', key: "gestCaliAvi_PIM"},
                            {title: '<%=GestCalLLI_PIM%>', key: "gestCalLLIPM_PIM"}
                        ]},
                    {title: '<%=GestDoc%>', key: "gestDocu", expand: true,
                        children: [
                            {title: '<%=GestVisDoc%>', key: "gestDocu_VisDoc"}
                        ]}
                ]
            }
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
