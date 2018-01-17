
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="Entidades.planop"%>
<%@page import="Entidades.sociedades"%>
<%@page import="AccesoDatos.ACC_Orden"%>
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
        String tituloVisualCompo = po.getProperty("etiqueta.VisualizarPPComponentes");
        String Orden = po.getProperty("etiqueta.ordenOr_PP");
        String Status = po.getProperty("etiqueta.StatusSistema_PP");
        String Tablbl1 = po.getProperty("etiqueta.Tablbl1");
        String Tablbl2 = po.getProperty("etiqueta.Tablbl2");
        String Tablbl3 = po.getProperty("etiqueta.Tablbl3");
        String Tablbl4 = po.getProperty("etiqueta.Tablbl4");
        String Tablbl5 = po.getProperty("etiqueta.Tablbl5");
        String Tablbl6 = po.getProperty("etiqueta.Tablbl6");
        String Tablbl7 = po.getProperty("etiqueta.Tablbl7");
        String Tablbl8 = po.getProperty("etiqueta.Tablbl8");
        String Tablbl9 = po.getProperty("etiqueta.Tablbl9");
        String Tab1 = po.getProperty("etiqueta.Tab1_PP");
        String Resp = po.getProperty("etiqueta.Responsable_ord_PP");
        String Tab2 = po.getProperty("etiqueta.Tab2_PP");
        String Tab3 = po.getProperty("etiqueta.Tab3_PP");
        String Tab4 = po.getProperty("etiqueta.Tab4_PP");
        String Tab5 = po.getProperty("etiqueta.Tab5_PP");
        String Tab6 = po.getProperty("etiqueta.Tab6_PP");
        String Tab7 = po.getProperty("etiqueta.Tab7_PP");
        String Tab8 = po.getProperty("etiqueta.Tab8_PP");
        String Tab9 = po.getProperty("etiqueta.Tab9_PP");
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
        String msgDoc = po.getProperty("etiqueta.VisEq_NoArchMos");
    %>
    <%
        String orden = request.getParameter("ord");
        String petic = request.getParameter("peticion");
        String tipoOrd = request.getParameter("tipo");
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="js/dom-drag.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarOrdenes2.js"></script> 
        <script src="js/dom-drag.js"></script>

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
                var pag = p.charAt(74);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
            var msg;
            switch (m) {
                case 1:
                    msg = '<%=msgDoc%>';
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



        <link rel="stylesheet" href="css/style.css"> 
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleVisOrden.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">


        <title><%=tituloVisualCompo%></title>     
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png"/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png" />               
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/cance.PNG" onclick="finalizar();"/>
            <input  id="cancelar"type="image" src="images/cancela.PNG" onclick="finalizar();"/>
            <div class="titulo"><span><h1><%=tituloVisualCompo%><b> <label style="font-size: 1em;"><%=orden%></label></b>: <label style="font-size: 1em;" id="tabs"></label></h1></span></div>  
        </div>
        <script>
            function inval() {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "Función Invalida";
            }
            function back() {
                window.history.back();
            }
            function finalizar() {
                window.location.href = "Bienvenido.jsp";
            }
        </script>
        <div class="contenido">
            <div id="conten" hidden></div>
            <div class="imagenContenidoConsulta1">
                <div class="divconOrden2">
                    <div class="divconOrden3">
                        <div class="DivParametrosOrden">
                            <label><%=Orden%></label> <input type="text" id="claseOrden_orden" disabled value="" style="width: 6%;"/> <input disabled type="text" id="Num_orden" value="<%=orden%>" style="width: 10%;"/> <input type="text" id="Des_orden" style="width: 70%;" disabled value="">
                            <hr>
                            <label><%=Status%></label> <input type="text" id="statusSis_orden" disabled value=""/> 
                            <!--<button id="VisDoo" style="width: 10%;margin-left: 5px;">Vis Docs</button>-->  
                            <hr>
                        </div>  
                        <table hidden="true">
                            <thead>
                                <tr>
                                    <th>Adress</th>
                                </tr>
                            </thead>
                            <tbody id="loadAd">
                            </tbody>
                        </table>
                    </div>
                    <section class="SeccionPestañas_orden">
                        <div class="tabsorden">
                            <input type="button" value="<%=Tab1%>" id="tabcabec" onclick="checkTab('cab');">
                            <input type="button" value="<%=Tab2%>" id="tabsOp" onclick="checkTab('tabsOp');">
                            <input type="button" value="<%=Tab3%>" id="tabComp" onclick="checkTab('tabComp');">
                            <!--<input type="button" value="<%=Tab4%>" id="tabcost" onclick="checkTab('tabcost');">-->
                            <!--<input type="button" value="<%=Tab5%>" id="TabObje" onclick="checkTab('TabObje');">-->
                            <!--<input type="button" value="<%=Tab6%>" onclick="checkTab('tabdatA');" id="tabdatA">-->
                            <input type="button" value="<%=Tab7%>" id="tabEmplz" onclick="checkTab('tabEmplz');">
                            <input type="button" value="<%=Tab8%>"id="tabplani" onclick="checkTab('tabplani');">
                            <input type="button" id="tabsctrl" value="<%=Tab9%>" onclick="checkTab('tabsctrl');">
                        </div>
                        <hr id="lineatabs">
                    </section>                       
                    <section class="ContenidoTabsOrden">
                        <section class="TabCabecOrden" id="seccioncabecera" style="visibility: visible;">                                
                            <section class="SecRespo_ord" >   
                                <section class="SecRespo1_ord">                                            
                                    <label id="lblTitulo_ord" style="width: 60%;"><%=Resp%></label>
                                    <hr id="lineatitulo_orde">
                                    <label><%out.println(po.getProperty("etiqueta.Grupo_ord_PP"));%></label><span><input id="gpoPlan_ord" type="text" disabled value=""> / <input type="text" id="gpoPlan2_ord" disabled value=""> <input type="text" style="width:40%; background: none; border: none" readonly value="" id="nombreGupoPl"/></span>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PuestoTra_ord_PP"));%></label><span><input type="text" id="rs_ord" disabled value=""> / <input type="text" id="rs2_ord" disabled value=""><input type="text" style="width:20%; background: none; border: none" readonly id="lbldescr_ord" /></span>
                                    <hr>
                                </section>
                                <section class="SecRespo2_ord">                                  
                                    <label><%out.println(po.getProperty("etiqueta.Notificacion_ord_PP"));%></label><input id="not_ord"type="text" value="" disabled>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.Costo_ord_PP"));%></label><span><input id="cos_ord"type="text" value="0.00" disabled><label style="width:5%;">MXN</label></span>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PMAct_ord_PP"));%></label><span><input id="Cl_ord"type="text" value="" disabled><inuput id="DesClaAct"/></span>
                                    <hr>
<!--                                    <label><%out.println(po.getProperty("etiqueta.EstadoInst_ord_PP"));%></label><input id="Est_ord"type="text" value="" disabled>
                                    <hr>   -->
                                </section>  
                            </section>                                  

                            <section class="divfecha_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.Fechas_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">
                                <div class="divizqorden" >                                       
                                    <label><%out.println(po.getProperty("etiqueta.InicExtr_ord_PP"));%></label><input id="inic_ord" type="text" value="" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.FinExtr_ord_PP"));%></label><input type="text" id="fin_ord" value="" disabled/>
                                    <hr>
<!--                                    <label><%out.println(po.getProperty("etiqueta.InicProg_ord_PP"));%></label><span><input type="text" id="inicpro_ord" value="" disabled/><input type="text" id="inicpro2_ord" disabled></span>
                                    <hr>-->
                                    <label><%out.println(po.getProperty("etiqueta.FinProg_ord_PP"));%></label><span><input type="text" id="finpro_ord" value="" disabled/><input type="text" id="finpro2_ord" disabled/></span>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.ClProg_ord_PP"));%></label><select id="Clpro_ord" value="" disabled><option><%out.println(po.getProperty("etiqueta.ClProgDia_ord"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClProgAde_ord_PP "));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClProgAtr_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClProgPro_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClProRes_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClProNec_ord_PP"));%></option></select>                                            
                                    <hr>
    <!--                                    <label><%out.println(po.getProperty("etiqueta.VistaReo_ord_PP"));%></label><select id="vistaReo_ord"  value="" disabled><option><%out.println(po.getProperty("etiqueta.VistaREOPred_ord_PP"));%></option>
                                            <option><%out.println(po.getProperty("etiqueta.VistaREOSuc_ord_PP "));%></option>
                                            <option><%out.println(po.getProperty("etiqueta.VistaREOMix_ord_PP"));%></option>
                                            <option><%out.println(po.getProperty("etiqueta.VistaREOCre_ord_PP"));%></option></select>
                                        <hr>-->
    <!--                                    <label><%out.println(po.getProperty("etiqueta.Version_ord_PP"));%></label><select id="version_ord" value="" disabled><option><%out.println(po.getProperty("etiqueta.VersionMax_ord"));%>;</option>
                                            <option><%out.println(po.getProperty("etiqueta.VersionMin_ord_PP"));%></option>
                                            <option><%out.println(po.getProperty("etiqueta.VersionNor_ord_PP"));%></option></select>
                                        <hr>-->
                                </div>
                                <div class="divderorden"> 
                                    <label><%out.println(po.getProperty("etiqueta.Prioriad_ord_PP"));%></label><select value=""  disabled id="prior_ord">
                                        <option></option>
                                        <option><%out.println(po.getProperty("etiqueta.PrioMuyElev_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.PrioAlto_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.PioMedio_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.PrioBajo_ord_PP"));%></option></select>
                                    <hr>
    <!--                                    <label><%out.println(po.getProperty("etiqueta.Revision_ord_PP"));%></label><input id="revi_ord"type="text" value="" value="" disabled/>
                                        <hr>-->
    <!--                                    <label><%out.println(po.getProperty("etiqueta.InicReal_ord_PP"));%></label><span><input id="inreal_ord"type="text" value="" disabled/><input type="text" id="inreal2_ord" disabled><input type="checkbox" id="check1_ord" disabled><%out.println(po.getProperty("etiqueta.DezpOrd_ord_PP"));%></span>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.FinReal_ord_PP"));%></label><span><input id="finreal_ord"type="text"  value="" disabled/><input type="text" id="finreal2_ord" disabled><input type="checkbox"  disabled><%out.println(po.getProperty("etiqueta.DatosREO_ord_PP"));%></span>
                                        <hr>-->
<!--                                    <label><%out.println(po.getProperty("etiqueta.FechaRef_ord_PP"));%></label><span><input id="fechaRef_ord"type="text" value="" disabled/><input type="checkbox"  id ="fecauto_ord" disabled checked><%out.println(po.getProperty("etiqueta.FechaAuto_ord_PP"));%></span>
                                    <hr>-->
    <!--                                    <label><%out.println(po.getProperty("etiqueta.InicPasa_ord_PP"));%></label><span><input id="pasado_ord"type="text" value="" disabled/><input type="checkbox"  id ="desc_ord"  disabled><%out.println(po.getProperty("etiqueta.ConDesca_ord_PP"));%></span>
                                        <hr id="lineapasado_ord">-->
    <!--                                    <label><%out.println(po.getProperty("etiqueta.AdptarFech_ord_PP"));%></label><span><input id="adpFec_ord"type="text"  value=""  disabled/><input type="checkbox" id="neccapc" checked disabled><%out.println(po.getProperty("etiqueta.NecCapac_ord_PP"));%></span>
                                        <hr id="lineaadpFec_ord">-->
                                </div>
                            </section>
                            <section class="Secbobj_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.Objetoreferencia_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">   
                                <div class="divcomorden">
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.UbicTecnica_ord_PP"));%></label><input tyoe="text" id="ubic_ord" value="" disabled> <input style="width: 45%; background: none; border: none;" readonly id="lbldescr_ord1"/>
                                    <hr>
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.Equipo_ord_PP"));%></label><input type="text" id="equ_ord"  value="" disabled> <input style="width: 45%; background: none; border: none;" readonly id="desequipo"/>
                                    <hr>
<!--                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.Conjunto_ord_PP"));%></label><input type="text" id="Conj_ord"  value="" disabled> <input style="width: 45%; background: none; border: none;" id="lbldescr_ord1">
                                    <hr>-->
                                </div>
                            </section>
                            <section class="Secoper_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.PrimeraOperacion_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">   
                                <div class="divcomorden">
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.Operacion_ord_PP"));%></label><input tyoe="text" id="opera_ord" value="" disabled/> <input type="text" id="DescOper_ord" disabled style="width: 65%;">
                                    <hr>
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.PtoTraCe_ord_PP"));%></label><input type="text" id="ptotr_ord"  value="" disabled> / <input type="text" id="ptotr2_ord" disabled><label id="lblclactrl"><%out.println(po.getProperty("etiqueta.ClvCtrl_ord_PP"));%></label><input type="text" id="clvctrol_ord" value="" disabled>
                                    <hr>
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.Cant_ord_PP"));%></label><input type="text" id="cant_ord" value="" disabled><label id="lblduropr_ord"><%out.println(po.getProperty("etiqueta.DurOper_ord_PP"));%></label><input type="text" id="duraoper_ord" value="" disabled><input type="text" id="duraoper2_ord" disabled>
                                    <hr>
                                    <label id="lbl1_ord"><%out.println(po.getProperty("etiqueta.NumPers_ord_PP"));%></label><input type="text" id="numper_ord" disabled><input type="text" id="numper2_ord" disabled>
                                    <hr>
                                </div>
                            </section>
                            <p><p><p><p>
                        </section>

                        <section class="taboperacion" id="taboperacion" hidden>
                            <div>
                                <section id="TablaStatus">
                                    <table class="TablaCont">
                                        <tr id="CabeceraTabla">
                                            <td><%out.println(po.getProperty("etiqueta.operacitablaORD_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.puestatrabOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CentrotBOMM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ClaveControOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.txtbrvoperOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.TEOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CntOR"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CntOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.UNOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.UbiteOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.EquipoOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NotificOR_PP"));%></td>
                                        </tr>
                                        <tbody id="CargarOperaciones">
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        </tbody>
                                    </table>
                            </div>
                        </section>
                        <section class="tabComponentes" id="tabComponentes" hidden>
                            <div>
                                <section id="TablaStatus">
                                    <table class="TablaCont">
                                        <tr id="CabeceraTabla">
                                            <td><%out.println(po.getProperty("etiqueta.pCompOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CompOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.DescrOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CtdNecOr_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.UMOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.TPOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.AlmaOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.CEmOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.OpOR_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.loteOR_PP"));%></td>
                                        </tr>
                                        <tbody id="CargaComponent">
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    </table>
                            </div>
                        </section>
                        <section class="tabCostes" id="tabCostes" hidden>
                            <section class="subsectioncoste1">
                                <div class="divizqCoste_ord">
                                    <label><%out.println(po.getProperty("etiqueta.Gastosestimados_PP"));%></label><input type="text" id="GatsEstim_ord"  disabled><label id="lblCostedes">MXN</label>
                                    <hr>
                                    <span><input type="button" value="<%out.println(po.getProperty("etiqueta.InformePlReal_PP"));%>" style=" width: 45%;" disabled><input disabled style="margin-left: 2%; width: 50%;" type="button"value="<%out.println(po.getProperty("etiqueta.InformepresCom_PP"));%>"></span>
                                </div>
                                <div class="divderCoste_ord">
                                    <span><input type="radio"><%out.println(po.getProperty("etiqueta.ValoresMonedaObj_PP"));%></span><input type="text" disabled>
                                    <hr>
                                    <span><input type="radio"><%out.println(po.getProperty("etiqueta.ValoresMonedaSoc_PP"));%></span><input type="text" disabled>
                                    <hr>
                                </div>
                            </section>                               
                        </section>
                        <section class="tabObjetos" id="tabObjetos" hidden>
                            <div>
                                <section id="TablaStatus">
                                    <table class="TablaCont">
                                        <tr id="CabeceraTabla">
                                            <td><%out.println(po.getProperty("etiqueta.VO_IndTra_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Clasif_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_NSerie_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Mat_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_TxtBrevM_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Equipo_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_DenomObj_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_UbTec_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_DenUbTec_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Notif_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Nav_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Desc_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_Conj_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.VO_DenomConj_PP"));%></td>       
                                        </tr>
                                        <tbody>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    </table>
                            </div>
                        </section>

                        <section class="SecDatosAdc" id="SecDatosAdc" hidden>                                
                            <section class="Secorgan_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.Organizacion_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">   
                                <div class="divcomorden1">
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.Sociedad_ord_PP"));%></label><input tyoe="text" id="socied_ord" value="" disabled><label id="lbldescr_ord"></label> 
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.Division_ord_PP"));%></label><input type="text" id="divic_ord" disabled>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.SociedadCO_ord_PP"));%></label><input type="text" id="socCO_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.CeCoRespon_ord_PP"));%></label><input type="text" id="cecores_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.CentroBenef_ord_PP"));%></label><input type="text" id="cebenef_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.ClaseObjeto_ord_PP"));%></label><select id="claseobj_ord" disabled><option><%out.println(po.getProperty("etiqueta.ClaseObjetoInver_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClaseObjetoGtoGral_ord_PP"));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClaseObjetoResul_ord_PP "));%></option>
                                        <option><%out.println(po.getProperty("etiqueta.ClaseObjetoFabric_ord_PP"));%></option></select>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.GrupoProceso_ord_PP"));%></label><input type="text" id="gpoproc_ord" disabled>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.ElementoPEP_ord_PP"));%></label><input type="text" id="elemntopep_ord" disabled>
                                    <hr>                                                                                        
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.DefProyecto_ord_PP"));%></label><input type="text" id="defproy_ord" disabled>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.Subgrafo_ord_PP"));%></label><input type="text" id="subgrafo_ord" disabled> / <input type="text" id="subgrafo2_ord" disabled>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.ElemRefPM_ord_PP"));%></label><input type="text" id="elemref_ord" disabled>
                                    <hr>
                                </div> 
                            </section>  
                            <section class="Secccopkit_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.ControlCopkit_ord_PP"));%></label>
                                <hr id="lineatitulo_orde"> 
                                <div class="divcomorden1">
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.CodOrden_ord_PP"));%></label><input type="text" id="codorden_ord" disabled><label id="lblprior_ord"><%out.println(po.getProperty("etiqueta.AddPriori_ord_PP"));%></label><input class="desdatos" id="lblprior_ord"/><label id="priomanual_ord"><%out.println(po.getProperty("etiqueta.PriorModManual_ord_PP"));%></label><input id="chkprimanual" type="checkbox" disabled>
                                    <hr>
                                </div>
                            </section>
                        </section>

                        <section class="SeccionEmplaza_ord" id="SeccionEmplaz_ord" hidden>
                            <section class="SecDatosEmp_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.DatosEmplaza_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">   
                                <div class="divcomorden1">
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.CeEmplamie_ord_PP"));%></label><input type="text" id="centrempl_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.Emplazamiento_ord_PP"));%></label><input type="text" id="empl_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.Local_ord_PP"));%></label><input type="text" id="local_ord" disabled>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.AreEmpresa_ord_PP"));%></label><input type="text" id="areempres_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.PuestoTrabajo_ord_PP"));%></label><input type="text" id="puesto_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.IndicadorABC_ord_PP"));%></label><input type="text" id="indicad_ord" disabled><label id="lbldescr_ord"></label>
                                    <hr>
                                    <label id="lbl2_ord"><%out.println(po.getProperty("etiqueta.CampoClasif_ord_PP"));%></label><input type="text" id="campoclas_ord" disabled>
                                    <hr>
                                </div>
                            </section>
                            <section class="seccimputa_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.imputacion_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">  
                                <div class="divizqord1">
                                    <label><%out.println(po.getProperty("etiqueta.Sociedadlocat_ord_PP"));%></label><input id="socieimp_ord" type="text" value="" disabled><label id="lbldescr_ord1"></label>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.ActivoFijo_ord_PP"));%></label><input type="text" id="actfijo_ord" disabled> / <input type="text" id="actfijo2_ord" disabled>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.DiviLoca_ord_PP"));%></label><input type="text" id="divisim_ord" disabled>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CentroCos_ord_PP"));%></label><input type="text" id="cencoste_ord" disabled><label id="lbldescr_ordcoste"></label>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.ElemPEP_PP"));%></label><input type="text" id="elementoPep_ord" disabled>
                                    <hr>
                                </div>
                                <div class="divderord"> 
                                    <label>México</label>
                                    <br>
                                    <br>
                                    <label><%out.println(po.getProperty("etiqueta.SocieCOLoc_ord_PP"));%></label><input id="sociCOimp_ord"type="text">
                                    <hr >
                                    <label><%out.println(po.getProperty("etiqueta.OrdLiquid_PP"));%></label><input id="ordliquid_ord"type="text">
                                    <hr >
                                </div>
                            </section>
                        </section>

                        <section class="tabSeccionPlanif" id="tabseccionplanif" hidden>
                            <section class="divplanmant_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.PlanMantenimiento_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">                                    
                                <div id="divizqplanfi_ord">
                                    <label><%out.println(po.getProperty("etiqueta.PlanMantPrev_ord_PP"));%></label><input type="text" id="planmant_ord" disabled/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.NoTomaMant_ord_PP"));%></label><input type="text" id="numtomamant_ord" disabled>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.PosMante_ord_PP"));%></label><input type="text" id="posmant_ord" disabled>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.FechaConclus_ord_PP"));%></label><input type="text" id="fechcon_ord" disabled>
                                    <hr>
                                </div>
                            </section>
                            <section class="divhojasRuta_ord">
                                <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.HojasRuta_ord_PP"));%></label>
                                <hr id="lineatitulo_orde">  
                                <div id="divderplanifi_ord">
                                    <label id="lblTitulo_ord" style="width: 100%;"><%out.println(po.getProperty("etiqueta.UltimaHojaRutaIncluida_ord_PP"));%></label>
                                    <hr id="lineatitulo_ordepla">  
                                    <label><%out.println(po.getProperty("etiqueta.TipoHojaRuta_ord_PP"));%></label><input type="text" id="TipoHojaruta_ord" disabled>
                                    <hr id="lineaultima_ord">
                                    <label><%out.println(po.getProperty("etiqueta.GpoHojasRuta_ord_PP"));%></label><input type="text" id="GpoHRuta_ord" disabled>
                                    <hr id="lineaultima_ord">
                                    <label><%out.println(po.getProperty("etiqueta.ContGPRuta_ord_PP"));%></label><input type="text" id="ContGpoHRuta_ord" disabled>
                                    <hr id="lineaultima_ord">
                                </div>                       
                            </section>
                        </section>

                        <section class="tabSeccionControl" id="tabSeccionControl" hidden>
                            <section class="subtabSeccionControl">
                                <section class="sectionDatsGestion_ord">
                                    <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.DatosGestion_ord_PP"));%></label>
                                    <hr id="lineatitulo_orde">  
                                    <div class="divcomorden2">
                                        <label><%out.println(po.getProperty("etiqueta.Autor_ord_PP"));%></label><input type="text" id="autorcontrol_ord" disabled>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.FechaEntrada_ord_PP"));%></label><input type="text" id="fentradactrl_ord" disabled>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.ModificadoPor_ord_PP"));%></label><input type="text" id="modctrl_ord" disabled>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.FechaModi_ord_PP"));%></label><input type="text" id="fecmodfctrl_ord" disabled>
                                        <hr>
                                    </div>
                                </section>
                            </section>
                        </section>
                    </section>

                </div>
            </div>
        </div>

        <div class="ServicioOperacion" id="ServicioOperacion">

            <div id="handleSer"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GestionSerExt_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="CerrarServices()"><label >X</label></div></div>
            <div id="contenidoo" hidden></div>
            <div class="DatosGen">

                <div class="DGsub1">
                    <label><%out.println(po.getProperty("etiqueta.CtdOperacion_Ordenes_PP"));%></label><input type="text" id="CtdOpera_SER" disabled style="width:45%;"/> <input type="text" disabled style="width:10%;"/>
                    <hr>
                    <!--                <label>Precio</label><input type="text" id="precio_SER" disabled style="width:40%;"/> <input type="text" disabled style="width:15%;"/>
                                    <hr>-->
                    <label><%out.println(po.getProperty("etiqueta.GpoArts_Ordenes_PP"));%></label><input type="text" id="GrupoAti_SER" disabled style="width:30%;"/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.GpoCom_Ordenes_PP"));%></label><input type="text" id="grcompra_SER" disabled style="width:12%;"/> / <input type="text" disabled style="width:12%;"/>
                    <hr>
                    <!--                <label>Contrato</label><input type="text" id="contrato_SER" disabled style="width:30%;"/> / <input type="text" disabled style="width:20%;"/>
                                    <hr>-->
                    <!--                <label>Destinatario</label><input type="text" id="Destinatario_SER" disabled style="width:35%;"/>
                                    <hr>-->
                    <label><%out.println(po.getProperty("etiqueta.Solicitante_Ordenes_PP"));%></label><input type="text" id="solicitante_SER" disabled style="width:35%;"/>
                    <hr>
                    <!--                <label>Plaz.Entr.prev.</label><input type="text" id="plaentprev_SER" disabled style="width:10%;"/> <input type="checkbox"/><label>Subcontr.</label>
                                    <hr>-->
                </div>
                <div class="DGsub2">
                    <!--                <label>Clv.clasific</label><input type="text" id="cl.clas_SER" disabled style="width:30%;"/>
                                    <hr>-->
                    <!--                <label>por</label><input type="text" id="por_SER" disabled style="width:25%;"/>
                                    <hr>-->
                    <label><%out.println(po.getProperty("etiqueta.ClasedeCostee_Ordenes_PP"));%></label><input type="text" id="clasecos_SER" disabled style="width:30%;"/>
                    <hr>
                    <!--                <label>Acreedor</label><input type="text" id="acree_SER" disabled style="width:30%;"/>
                                    <hr>-->
                    <!--                <label>Registro info</label><input type="text" id="reginfo_SER" disabled style="width:30%;"/>
                                    <hr>-->
                    <!--                <label>Puesto descarga</label><input type="text" id="puestodes_SER" disabled style="width:55%;"/>
                                    <hr>-->
                    <!--                <label>N° necesidad</label><input type="text" id="Neces_SER" disabled style="width:30%;"/>
                                    <hr>
                                    <label>Ped.marco</label><input type="text" id="pdmar_SER" disabled style="width:10%;"/> / <input type="text" disabled style="width:10%;"/>
                                    <hr>-->
                </div>
            </div>
            <div class="ServTable">
                <div id="TablaStatus2">
                    <table class="TablaCont2" id="TablaCont2">
                        <tr id="CabeceraTabla">
                            <td><%out.println(po.getProperty("etiqueta.NumServiOr_PP"));%></td>
                            <td><%out.println(po.getProperty("etiqueta.CantidOr_PP"));%></td>
                            <td><%out.println(po.getProperty("etiqueta.PriceEstimOr_PP"));%></td>
                            <td><%out.println(po.getProperty("etiqueta.UnitMedidaaOr_PP"));%></td>
                            <td><%out.println(po.getProperty("etiqueta.GpooArtsOr_PP"));%></td>
                            <td><%out.println(po.getProperty("etiqueta.ClseCsteOr_PP"));%></td>
                            
                        </tr> 
                        <tbody id="gloSer">
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

<!--        <div id="VentanaModalCentroP" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Documentos</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaaVO('CentroP');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
            <div id="ConsultaTablaCentP">
                <div id="tabscrll">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead4">
                                    <thead>
                                        <tr>
                                            <td style="width: 110px;">Apl.</td>
                                            <td style="width: 394px;">Nombre</td>
                                            <td style="width: 140px;">Aplicación</td>
                                            <td style="width: 577px;">Fichero</td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo4">
                            </section>
                        </section>
                    </section>
                </div>
            </div>
        </div>-->

<!--        <div id="VentUbTecAvvv" class="VentanaModalAvvv">
            <div id="handleAvvv"><label id="TituloMatch">¿Qué desea realizar?</label><div class="BotonCerrar_Matc" onclick="ocultarVenAv('VenAvv');"><label>X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <br><br>
                <div class="fondo_MatchAv">
                    <button id="VisVis" style="width: 40%;margin-left: 5%;">Visualizar</button> <button id="ViGuarAr" style="width: 40%;margin-left: 5%;">Modificar</button>
                    <input id="ubtecPosOc" hidden></input>
                </div>
                <div class="Botones_Match">
                </div>
            </div>
        </div>-->

        <input type="text" id="mjTablbl1" value="<%=Tablbl1%>" hidden/>
        <input type="text" id="mjTablbl2" value="<%=Tablbl2%>" hidden/>
        <input type="text" id="mjTablbl3" value="<%=Tablbl3%>" hidden/>
        <input type="text" id="mjTablbl4" value="<%=Tablbl4%>" hidden/>
        <input type="text" id="mjTablbl5" value="<%=Tablbl5%>" hidden/>
        <input type="text" id="mjTablbl6" value="<%=Tablbl6%>" hidden/>
        <input type="text" id="mjTablbl7" value="<%=Tablbl7%>" hidden/>
        <input type="text" id="mjTablbl8" value="<%=Tablbl8%>" hidden/>
        <input type="text" id="mjTablbl9" value="<%=Tablbl9%>" hidden/>
        <input type="text" id="mjpetic" value="<%=petic%>" hidden/>
        <input type="text" id="mjorden" value="<%=orden%>" hidden/>
        <input type="text" id="mjtipoOrd" value="<%=tipoOrd%>" hidden/>

<!--        <div id="VentanaVIAR" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.SelecCatMatchAV"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GrupCodi')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>PM1</button><hr></div>
            <div id="ConsultaTabla" >
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th>archivos</th>
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
        </div>  -->
        <div id="VentanaModalTextli" class="VentanaModal">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OtxtL_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultartexa();"><label >X</label></div></div>
            <div class="PanelBntMatch"><button  ><%out.println(po.getProperty("etiqueta.OtxtL_PP"));%></button><hr></div>
            <div id="BuscarTxtD" class="BuscarParam_uD">
                <div class="fonhandle3do_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.OtxtLo_PP"));%></label><label id="opCurrent"></label>
                        <textarea disabled style="resize:none;" id="Textlib"></textarea>
                    </div>
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;margin-right:-4%;" onclick="ocultartexa();" id="xDescri"/>
                </div>
            </div>
        </div>

        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
                var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                var f = new Date();
                var idioma = "<%=Idioma%>";
                if (idioma == "ES") {
                    var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                    document.getElementById('fecha').innerHTML = fechaActual;
                } else if (idioma == "EN") {
                    var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                    document.getElementById('fecha').innerHTML = fechaActual;
                } else {
                    var fechaActual = "Fecha indefinida";
                }
                </script>
                <script type="text/javascript">
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
                        //MEnsaje de correcto
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        startTime();
                        cargarCabecera();
                        CargarTablaOperacion();
                        CargarTablaComponentes();
                        CargarPestEmpl();
                        CargarPestPlanific();
                        CargarPestCtrl();
                        bloq();
                        $('#seccioncabecera').show();
                        validaUsuarioVis();
                    };
                    function bloq() {
                        $('#iconmsg').hide();
                        $('#aceptar').prop("disabled", true);
                    }
                </script>
                <script>
                    function validaUsuarioVis() {
                        var acc = "validaUsuarioVis";
                        var usr = "<%=Nombre%>";//Usuario
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'MovimientosCalidad',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "action=" + acc + "&v1=" + usr,
                            success: function (rs) {
                                if (rs == 0) {
                                    $("#ViGuarAr").prop('disabled', true);
                                } else if (rs == 1) {
                                    $("#ViGuarAr").prop('disabled', false);
                                }
                            }
                        });
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