<%-- 
    Document   : ModificarUsuarios
    Created on : 30/06/2016, 10:46:51 AM
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
        String claveMayor = po.getProperty("etiqueta.ContraMayor_USCR");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String reso = po.getProperty("etiqueta.Resolucio");
        String processCancell = po.getProperty("etiqueta.procesosCancelado_SAM");
        String Selusuar = po.getProperty("etiqueta.SeleccionaUser_USU");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String ClavesInco = po.getProperty("etiqueta.ContraIgual_USCR");
        String InExisUser = po.getProperty("etiqueta.UsuarioInExist");
        String UsuarioOK = po.getProperty("etiqueta.UsuarioOkGurda_USCR");
        String UsuarioEr = po.getProperty("etiqueta.usuaioMalGuerd_USMR");
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
        String CorreoInv = po.getProperty("etiqueta.CorrNoVal");
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
                var pag = p.charAt(3);
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
                        msg = '<%=Selusuar%>';
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
                    case 5:
                        msg = '<%=CenNoEnc%>';
                        break;
                    case 6:
                        msg = '<%=CorreoInv%>';
                        break;
                    case 7:
                        msg = '<%=Mens%>';
                        break;
                    case 8:
                        msg = '<%=ClavesInco%>';
                        break;
                    case 9:
                        msg = '<%=InExisUser%>';
                        break;
                    case 10:
                        msg = '<%=UsuarioOK%>';
                        break;
                    case 11:
                        msg = '<%=UsuarioEr%>';
                        break;
                    case 12:
                        msg = '<%=claveMayor%>';
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
        <script src="js/sha1.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/ModificarUsuario.js"></script>
        <script src="js/menu.js"></script>
        <script src="js/jquerys.js"></script>   
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <!--//permisos-->
        <link href="css/prettify.css" rel="stylesheet">
        <script src="js/prettify.js" type="text/javascript"></script>
        <link href="css/exec.dyn.css" rel="stylesheet" type="text/css">
        <link href="css/ui.dynatree.css" rel="stylesheet" type="text/css">
        <script src="js/exec.dyn.js" type="text/javascript"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="js/jquery-ui.custom.js" type="text/javascript"></script>
        <script src="js/jquery.dynatree.js" type="text/javascript"></script> 
        <title><%out.println(po.getProperty("etiqueta.ModificarUsuar_USU"));%></title>             
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
            <input  id="guardar" type="image" src="images/guarda.PNG"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar"type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ModificarUsuar_USU"));%></h1></div>  
        </div>           
        <div class="contenido">
            <div class="CrearUser_USU">
                <div class="DivDatosUser_USU">
                    <label><%out.println(po.getProperty("etiqueta.ParametrosBus_USU"));%></label>
                    <hr id="lblTituloCrerUser_US">
                    <div class="CompUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></label><input type="text" maxlength="10" id="User_U"  style="width:20%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/><button id="btnmatch"  class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ModificarContra_USU"));%></label><input type="checkbox" id="CheckPass" disabled/>
                        <hr>
                        <div id="contentHide" style="display: none">
                            <label><%out.println(po.getProperty("etiqueta.Password_USCR"));%></label><input type="password" placeholder="  *****************" id="Pwd1_U" style="width: 18%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.ConfirPass_USCR"));%></label><input type="password" placeholder="  *****************" id="pwd2_U" style="width:18%;"/>
                            <hr>
                        </div>
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
                        <label><%out.println(po.getProperty("etiqueta.Nombre_USCR"));%></label><input maxlength="50" type="text"  id="Nombre_U" value="" style="width: 50%; background-repeat: no-repeat; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApePat_USCR"));%></label><input maxlength="50" type="text" id="APP_U" style="width: 50%; background-repeat: no-repeat; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ApeMat_USCR"));%></label><input maxlength="50" type="text" id="APM_U" style="width:50%; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.RFC_USCR"));%></label><input maxlength="15" type="text" id="RFC_U" style="width:50%; text-transform: uppercase;" disabled/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Corre_USCR"));%></label><input maxlength="100" type="text" id="Email_U" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono_USCR"));%></label><input maxlength="20" type="text" id="Tel1_U" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Telefono2_USCR"));%></label><input maxlength="20" type="text" id="Tel2_U" style="width:50%;" disabled/>
                        <hr>
                    </div>
                </div> 
                <div class="Direc_USCR">
                    <label><%out.println(po.getProperty("etiqueta.Direccion_USCR"));%></label>
                    <hr id="lblTituloCrerUser_US"> 
                    <div class="DivIzquUser_USE">    
                        <label><%out.println(po.getProperty("etiqueta.Calle_USCR"));%></label><input type="text" maxlength="100" id="Calle_U" style="width:50%; text-transform: uppercase; background-repeat: no-repeat;" disabled />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumInt_USCR"));%></label><input type="text" maxlength="20" id="NumInt_U" style="width:30%; background-repeat: no-repeat;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumExt_USCR"));%></label><input type="text" maxlength="20" id="NumExt_U" style="width:30%; background-repeat: no-repeat;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Colonia_USCR"));%></label><input type="text" maxlength="100" id="Colonia_U" style="width:45%; text-transform: uppercase; background-repeat: no-repeat;" disabled/>
                        <hr>
                    </div>
                    <div class="DivDereUser_USE"> 
                        <label><%out.println(po.getProperty("etiqueta.Poblacion_USCR"));%></label><input maxlength="100" type="text" id="Poblacion_U" style="text-transform: uppercase; width:40%; background-repeat: no-repeat;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Estado_USCR"));%></label><input maxlength="20" type="text" id="Estado_U" style="text-transform: uppercase; width: 40%; background-repeat: no-repeat;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CvePais"));%></label><input type="text" maxlength="20" id="Pais_U" style="text-transform: uppercase; width: 45%; background-repeat: no-repeat;" disabled/>
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
                        </label><input type="text" id="usuariio_bus" maxlength="10" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax"  style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okUs"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerrarMCUser2"/>
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
        <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
            <div id="handleDoc"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.FinalizarDocumento_FIDO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeSalirModulo();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
            <div class="ContenidoFinalizarDoc">
                <label><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc_FIDO"));%></label>
                <br>
                <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc2_FIDO"));%></label>
            </div>
            <div class="BotenesFinalizarDocumento">
                <button id="FinalizarSIDoc" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                <button id="FinalizarNODoc" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
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
                    var writefecha = $('#fecha');
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else {
                        writefecha.html("Fecha Indefinida");
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
                                                {title: '<%=DatMaMat_m%>', key: "gestMat_datMmat",
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
                                            ]}
                                    ]
                                },
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
                    getPermission("conf", p.charAt(0));
                    getPermission("conf_user", p.charAt(1));
                    getPermission("conf_userCrear", p.charAt(2));
                    getPermission("conf_userModif", p.charAt(3));
                    getPermission("conf_userVisual", p.charAt(4));
                    getPermission("conf_fol", p.charAt(5));
                    getPermission("conf_folCrear", p.charAt(6));
                    getPermission("conf_folModif", p.charAt(7));
                    getPermission("conf_folVisual", p.charAt(8));
                    getPermission("conf_repo", p.charAt(9));
                    getPermission("conf_repoSAM", p.charAt(10));
                    getPermission("gestMat", p.charAt(11));
                    getPermission("gestMat_org", p.charAt(12));
                    getPermission("gestMat_orgCen", p.charAt(13));
                    getPermission("gestMat_orgAlmXc", p.charAt(14));
                    getPermission("gestMat_datM", p.charAt(15));
                    getPermission("gestMat_datMmat", p.charAt(16));
                    getPermission("gestMat_datMmatCrear", p.charAt(17));
                    getPermission("gestMat_datMmatMod", p.charAt(18));
                    getPermission("gestMat_datMmatVis", p.charAt(19));
                    getPermission("gestMat_datMCC", p.charAt(20));
                    getPermission("gestMat_datMCC_VisP", p.charAt(21));
                    getPermission("gestMat_datMCC_VisInR", p.charAt(22));
                    getPermission("gestMat_datMC", p.charAt(23));
                    getPermission("gestMat_datMC_VisC", p.charAt(24));
                    getPermission("gestMat_C", p.charAt(25));
                    getPermission("gestMat_CSC", p.charAt(26));
                    getPermission("gestMat_CSC_Cr", p.charAt(27));
                    getPermission("gestMat_CSC_Mod", p.charAt(28));
                    getPermission("gestMat_CSC_Vis", p.charAt(29));
                    getPermission("gestMat_CSC_listas", p.charAt(30));
                    getPermission("gestMat_CPD", p.charAt(31));
                    getPermission("gestMat_CPD_Vis", p.charAt(32));
                    getPermission("gestMat_GS", p.charAt(33));
                    getPermission("gestMat_GSDoc", p.charAt(34));
                    getPermission("gestMat_GSDoc_Vis", p.charAt(35));
                    getPermission("gestMat_GSDoc_LstMov", p.charAt(36));
                    getPermission("gestMat_GSMov", p.charAt(37));
                    getPermission("gestMat_GSMov_MovM", p.charAt(38));
                    getPermission("gestMat_GSMov_Rese", p.charAt(39));
                    getPermission("gestMat_GSMov_ReseCr", p.charAt(40));
                    getPermission("gestMat_GSMov_ReseMo", p.charAt(41));
                    getPermission("gestMat_GSMov_ReseVi", p.charAt(42));
                    getPermission("gestMat_GSMov_ReseLis", p.charAt(43));
                    getPermission("gestMat_GSMov_EntSer", p.charAt(44));
                    getPermission("gestMat_GSStockM", p.charAt(45));
                    getPermission("gestMant", p.charAt(46));
                    getPermission("gestMant_DM", p.charAt(47));
                    getPermission("gestMant_DMUbi", p.charAt(48));
                    getPermission("gestMant_DMUbi_Cre", p.charAt(49));
                    getPermission("gestMant_DMUbi_Mod", p.charAt(50));
                    getPermission("gestMant_DMUbi_Vis", p.charAt(51));
                    getPermission("gestMant_DMEqui", p.charAt(52));
                    getPermission("gestMant_DMEqui_Cre", p.charAt(53));
                    getPermission("gestMant_DMEqui_Mod", p.charAt(54));
                    getPermission("gestMant_DMEqui_Vis", p.charAt(55));
                    getPermission("gestMant_DMBom", p.charAt(56));
                    getPermission("gestMant_DMBom_Crea", p.charAt(57));
                    getPermission("gestMant_DMBom_Mod", p.charAt(58));
                    getPermission("gestMant_DMBom_Vis", p.charAt(59));
                    getPermission("gestMant_DMHrut", p.charAt(60));
                    getPermission("gestMant_DMHrut_Cra", p.charAt(61));
                    getPermission("gestMant_DMHrut_Mod", p.charAt(62));
                    getPermission("gestMant_DMHrut_Vis", p.charAt(63));
                    getPermission("gestMant_ME", p.charAt(64));
                    getPermission("gestMant_ME_MCPxE", p.charAt(65));
                    getPermission("gestMant_APM", p.charAt(66));
                    getPermission("gestMant_APM_MAPM", p.charAt(67));
                    getPermission("gestMant_APM_Cre", p.charAt(68));
                    getPermission("gestMant_APM_Mod", p.charAt(69));
                    getPermission("gestMant_APM_Vis", p.charAt(70));
                    getPermission("gestMant_OPM", p.charAt(71));
                    getPermission("gestMant_OPM_Cre", p.charAt(72));
                    getPermission("gestMant_OPM_Mod", p.charAt(73));
                    getPermission("gestMant_OPM_Vis", p.charAt(74));
                    getPermission("gestMant_OPM_LstO", p.charAt(75));
                    getPermission("gestMant_NPM", p.charAt(76));
                    getPermission("gestMant_NPM_Cre", p.charAt(77));
                    getPermission("gestMant_NPM_Vis", p.charAt(78));
                    getPermission("gestCali", p.charAt(79));
                    getPermission("gestCali_PIM", p.charAt(80));
                    getPermission("gestCaliAvi_PIM", p.charAt(81));
                    getPermission("gestCalLLIPM_PIM", p.charAt(82));
                    getPermission("gestDocu", p.charAt(83));
                    getPermission("gestDocu_VisDoc", p.charAt(84));


                }
            });
        }
        function test() {
            var key = "";
            key = key + getCheckPermission("conf");                         //// 0
            key = key + getCheckPermission("conf_user");                    //// 1
            key = key + getCheckPermission("conf_userCrear");               //// 2
            key = key + getCheckPermission("conf_userModif");               //// 3
            key = key + getCheckPermission("conf_userVisual");              //// 4
            key = key + getCheckPermission("conf_fol");                     //// 5
            key = key + getCheckPermission("conf_folCrear");                //// 6
            key = key + getCheckPermission("conf_folModif");                //// 7
            key = key + getCheckPermission("conf_folVisual");               //// 8
            key = key + getCheckPermission("conf_repo");                    //// 9
            key = key + getCheckPermission("conf_repoSAM");                 //// 10
            key = key + getCheckPermission("gestMat");                      //// 11
            key = key + getCheckPermission("gestMat_org");                  //// 12
            key = key + getCheckPermission("gestMat_orgCen");               //// 13
            key = key + getCheckPermission("gestMat_orgAlmXc");             //// 14
            key = key + getCheckPermission("gestMat_datM");                 //// 15
            key = key + getCheckPermission("gestMat_datMmat");              //// 16
            key = key + getCheckPermission("gestMat_datMmatCrear");         //// 17
            key = key + getCheckPermission("gestMat_datMmatMod");           //// 18
            key = key + getCheckPermission("gestMat_datMmatVis");           //// 19
            key = key + getCheckPermission("gestMat_datMCC");               //// 20
            key = key + getCheckPermission("gestMat_datMCC_VisP");          //// 21
            key = key + getCheckPermission("gestMat_datMCC_VisInR");        //// 22
            key = key + getCheckPermission("gestMat_datMC");                //// 23
            key = key + getCheckPermission("gestMat_datMC_VisC");           //// 24
            key = key + getCheckPermission("gestMat_C");                    //// 25
            key = key + getCheckPermission("gestMat_CSC");                  //// 26
            key = key + getCheckPermission("gestMat_CSC_Cr");               //// 27
            key = key + getCheckPermission("gestMat_CSC_Mod");              //// 28
            key = key + getCheckPermission("gestMat_CSC_Vis");              //// 29
            key = key + getCheckPermission("gestMat_CSC_listas");           //// 30
            key = key + getCheckPermission("gestMat_CPD");                  //// 31
            key = key + getCheckPermission("gestMat_CPD_Vis");              //// 32
            key = key + getCheckPermission("gestMat_GS");                   //// 33
            key = key + getCheckPermission("gestMat_GSDoc");                //// 34
            key = key + getCheckPermission("gestMat_GSDoc_Vis");            //// 35
            key = key + getCheckPermission("gestMat_GSDoc_LstMov");         //// 36
            key = key + getCheckPermission("gestMat_GSMov");                //// 37
            key = key + getCheckPermission("gestMat_GSMov_MovM");           //// 38
            key = key + getCheckPermission("gestMat_GSMov_Rese");           //// 39
            key = key + getCheckPermission("gestMat_GSMov_ReseCr");         //// 40
            key = key + getCheckPermission("gestMat_GSMov_ReseMo");         //// 41
            key = key + getCheckPermission("gestMat_GSMov_ReseVi");         //// 42
            key = key + getCheckPermission("gestMat_GSMov_ReseLis");        //// 43
            key = key + getCheckPermission("gestMat_GSMov_EntSer");         //// 44
            key = key + getCheckPermission("gestMat_GSStockM");             //// 45
            key = key + getCheckPermission("gestMant");                     //// 46
            key = key + getCheckPermission("gestMant_DM");                  //// 47
            key = key + getCheckPermission("gestMant_DMUbi");               //// 48
            key = key + getCheckPermission("gestMant_DMUbi_Cre");           //// 49
            key = key + getCheckPermission("gestMant_DMUbi_Mod");           //// 50
            key = key + getCheckPermission("gestMant_DMUbi_Vis");           //// 51
            key = key + getCheckPermission("gestMant_DMEqui");              //// 52
            key = key + getCheckPermission("gestMant_DMEqui_Cre");          //// 53
            key = key + getCheckPermission("gestMant_DMEqui_Mod");          //// 54
            key = key + getCheckPermission("gestMant_DMEqui_Vis");          //// 55
            key = key + getCheckPermission("gestMant_DMBom");               //// 56
            key = key + getCheckPermission("gestMant_DMBom_Crea");          //// 57
            key = key + getCheckPermission("gestMant_DMBom_Mod");           //// 58
            key = key + getCheckPermission("gestMant_DMBom_Vis");           //// 59
            key = key + getCheckPermission("gestMant_DMHrut");              //// 60
            key = key + getCheckPermission("gestMant_DMHrut_Cra");          //// 61
            key = key + getCheckPermission("gestMant_DMHrut_Mod");          //// 62
            key = key + getCheckPermission("gestMant_DMHrut_Vis");          //// 63
            key = key + getCheckPermission("gestMant_ME");                  //// 64
            key = key + getCheckPermission("gestMant_ME_MCPxE");            //// 65
            key = key + getCheckPermission("gestMant_APM");                 //// 66
            key = key + getCheckPermission("gestMant_APM_MAPM");            //// 67
            key = key + getCheckPermission("gestMant_APM_Cre");             //// 68
            key = key + getCheckPermission("gestMant_APM_Mod");             //// 69
            key = key + getCheckPermission("gestMant_APM_Vis");             //// 70
            key = key + getCheckPermission("gestMant_OPM");                 //// 71
            key = key + getCheckPermission("gestMant_OPM_Cre");             //// 72
            key = key + getCheckPermission("gestMant_OPM_Mod");             //// 73
            key = key + getCheckPermission("gestMant_OPM_Vis");             //// 74
            key = key + getCheckPermission("gestMant_OPM_LstO");            //// 75
            key = key + getCheckPermission("gestMant_NPM");                 //// 76
            key = key + getCheckPermission("gestMant_NPM_Cre");             //// 77
            key = key + getCheckPermission("gestMant_NPM_Vis");             //// 78
            key = key + getCheckPermission("gestCali");                     //// 79
            key = key + getCheckPermission("gestCali_PIM");                 //// 80
            key = key + getCheckPermission("gestCaliAvi_PIM");              //// 81
            key = key + getCheckPermission("gestCalLLIPM_PIM");             //// 82
            key = key + getCheckPermission("gestDocu");                     //// 83
            key = key + getCheckPermission("gestDocu_VisDoc");              //// 84
            return key;
        }

    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
