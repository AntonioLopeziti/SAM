<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String Nombre = (String) session.getAttribute("Usuario");
        String Idioma = (String) session.getAttribute("Idioma");
        String meFOL = request.getParameter("men");
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String pos = po.getProperty("etiqueta.posCreAv");
        String grupCod = po.getProperty("etiqueta.grupCodCreAv");
        String codAct = po.getProperty("etiqueta.codActCreAv");
        String txtCod = po.getProperty("etiqueta.txtCodCreAv");
        String txtAcc = po.getProperty("etiqueta.txtAccCreAv");
        String te = po.getProperty("etiqueta.teCreAv");
        String factCan = po.getProperty("etiqueta.factCanCreAv");
        String feIn = po.getProperty("etiqueta.feInCreAv");
        String horaAv = po.getProperty("etiqueta.horaAvCreAv");
        String fechaFin = po.getProperty("etiqueta.fechaFinCreAv");
        String activ = po.getProperty("etiqueta.activCreAv");
        String clase = po.getProperty("etiqueta.claseCreAv");
        String doc = po.getProperty("etiqueta.docCreAv");
        String ulVerLib = po.getProperty("etiqueta.ulVerLibCreAv");
        String ulVerDoc = po.getProperty("etiqueta.ulVerDocCreAv");
        String lib = po.getProperty("etiqueta.libCreAv");
        String docPar = po.getProperty("etiqueta.docParCreAv");
        String verDoc = po.getProperty("etiqueta.verDocCreAv");
        String desc = po.getProperty("etiqueta.descCreAv");
        String camVac = po.getProperty("etiqueta.CamposVacios");
        String invalid = po.getProperty("etiqueta.FuncionInval_Menu");
        String ubTeNV = po.getProperty("etiqueta.ubTeNV");
        String eqNV = po.getProperty("etiqueta.EqNV");
        String conNV = po.getProperty("etiqueta.conNV");
        String gpNV = po.getProperty("etiqueta.gpNV");
        String cpNV = po.getProperty("etiqueta.cpNV");
        String ptNV = po.getProperty("etiqueta.ptNV");
        String centroNV = po.getProperty("etiqueta.centroNV");
        String exCamVac = po.getProperty("etiqueta.exCamVac");
        String noValSecc = po.getProperty("etiqueta.NoExisteValores_SAM");
        String falDatLlen = po.getProperty("etiqueta.falDatLlen");
        String datGuaCorr = po.getProperty("etiqueta.datGuaCorr");
        String equipoo = po.getProperty("etiqueta.Equipos_menu");
        String msgEq = po.getProperty("etiqueta.msgEquipoo");
        String ubTeec = po.getProperty("etiqueta.VU_UbicacionTecnica");
        String av = po.getProperty("etiqueta.avvCreAv");
        String gra = po.getProperty("etiqueta.grabCreAv");
        String fe = po.getProperty("etiqueta.MsgFechasMoAv");
        
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
        
        int f;
        String foc;
        folios fo = new folios();
        fo = ACC_Folios.ObtenerIstancia().ObtenerDatos();
        f = fo.getFolioActual();
        foc = fo.getIdFolios() + f;

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        
        <script>
            function msgMatch(val) {
                switch (val) {
                    case "MsgFechasMoAv":                        
                        var MsgFechasMoAv = '<%=fe%>';
                        $('#msg').html(MsgFechasMoAv);
                        break;
                    }
            }
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
                var pag = p.charAt(68);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/CrearAviso.css"> 
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/ModificarAvisos.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/menu.css" media="screen">

        <title><%out.println(po.getProperty("etiqueta.TituloCrearAviso"));%></title>     
    </head>
    <body id="BODY" >
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
                        var idda = $('#IDFecha').val();
                        var fehSet = $('#' + idda);
                        fehSet.val(date);
                        fehSet.focus();
                        CerrarCalendario();
                    }
                });
            });
            $(function () {
                $('#datapicker').datepicker().hide();
            });
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
            <input  id="guardar" type="image" src="images/guarda.PNG" />
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG" />
            <input  id="cancelar"type="image" src="images/cancela.PNG"/>
            <div class="titulo"><span><h1><b><label style="font-size: 1em;"><%out.println(po.getProperty("etiqueta.TituloCrearAviso"));%></label></b><label style="font-size: 1em;" id="tabs"></label></h1></span></div>  
        </div>
        <div class="contenido">
            <input style="display: none" id="folio" value = "<%=foc%>">
            <div class="ContentAvisoCrea">
                <div id="EquUbi" hidden></div>
                <div class="DivParametrosAviso">
                    <!--style="width:8%;"-->
                    <label><%out.println(po.getProperty("etiqueta.FoliosamCAA"));%></label><input type="text" id="Notificacion_CA"  disabled  /> <input type="text" id="Claseaviso_CA" value="M3" disabled style="width:3%;"/> <input type="text" maxlength="40" id="descripcionnotificacion_CA" style="width: 25%;"  />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.StatusMensajeCAA"));%></label><input type="text" id="statusSis_orden" style="width:12%;"  value="MEAB" disabled/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.OrdenCAA"));%></label><input type="text" id="statusOrden_CA" style="width:8%;"  value="" disabled/>
                    <hr>
                    <input type="text" id="Notificacion_CACA" value="<%=foc%>" hidden>
                </div>
                <section class="SeccionPestañas_orden">
                    <div class="tabsorden">
                        <input type="button" value="<%out.println(po.getProperty("etiqueta.AvisoCAA"));%>" id="tabcabec" onclick="tabCabecera();">
                    </div>
                    <hr id="lineatabs">
                </section>                       
                <section class="ContenidoTabsOrden">
                    <section class="TabCabecOrden" id="seccioncabecera" >                                
                        <section class="Secbobj_avi">
                            <label><%out.println(po.getProperty("etiqueta.ObjetoreferenciaCAA"));%></label>
                            <hr id="lineatitulo">   
                            <div class="divobjavi">
                                <label><%out.println(po.getProperty("etiqueta.ubitecCAA"));%></label><input tyoe="text" id="ubictec_CA" maxlength="30" style="width:20%;"><button id="match_A1" class='BtnMatchIcon'></button><input style="width:45%; background: none; border: none;" readOnly id="DenominacionUbitec_MAA"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.equipoCAA"));%></label><input type="text" id="equipo_CA" maxlength="18" style="width: 20%;" /><button id="match_A2" class='BtnMatchIcon' ></button><input style="width:45%; border:none; background:none;" readOnly id="DenominacionEquipo_MAA"></label>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.conjuntoCAA"));%></label><input type="text" id="conjunto_CA" maxlength="40"style="width: 20%;"><button id="match_A3" class='BtnMatchIcon'></button><input readOnly style="width:45%; border: none; background: none;" id="DenominacionConjunto_MAA"/>
                                <hr>
                            </div>
                        </section>
                        <section class="SecRes_avi">
                            <label><%out.println(po.getProperty("etiquta.ResponsabilidadesCAA"));%></label>
                            <hr id="lineatitulo">  
                            <div class="divobjavi">
                                <label><%out.println(po.getProperty("etiqueta.GrupoplanCAA"));%></label><input type="text" id="GrpPlanificacion_CA" maxlength="3" style="width: 5%; text-transform: uppercase;"><button id="match_A4" class='BtnMatchIcon'></button> / <input type="text" id="CentroPlaninificacion_CA" maxlength="4" style="width:20%; text-transform: uppercase;">
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PuestoresponsableCAA"));%></label><input type="text" id="puestotrabajo_CA"  maxlength="8" style="width:20%;" ><button id="match_A5" class='BtnMatchIcon'></button> / <input type="text" maxlength="4" id="puestotrabajo2_CA" style="width:10%; text-transform: uppercase;"><input id="DenominacionPuestoTrabajo_MAA" readOnly style="border:none; background: none; width: 40%;"/>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.DepartamentoresCAA"));%></label><input type="text" id="departamento_CA" disabled maxlength="30" style="width:20%;"> <input type="text" disabled id="departamento2_CA" maxlength="30" style="width:20%;"> 
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.ResponsableCAA"));%></label><input type="text" id="responsable_CA" disabled maxlength="30" style="width:20%;"> <input type="text" disabled id="responsable2_CA" style="width:20%;"> 
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.autoravisoCAA"));%></label><input type="text" id="autorAviso_CA" style="width:15%" value="<%=Nombre%>" readonly> <span id='spanfechaavi'><%out.println(po.getProperty("etiqueta.FechaavisoCAA"));%></span><input type="text" id="theDate" style="width:20%" readonly> <input  style="width:15%" type="text" id="Time" readonly>
                                <hr>
                            </div>                                                                                                                                                   
                        </section>
                        <section class="SeccionCircunstancias_CA">
                            <label><%out.println(po.getProperty("etiqueta.CircunstanciasCAA"));%></label>
                            <hr id="lineatitulo">   
                            <div class="divobjavi">
                                <!--<label><%out.println(po.getProperty("etiqueta.CodificacionCAA"));%></label><input type="text" maxlength="8" id="codificacion_CA" style="width:20%;"/> <input type="text" maxlength="4" id="ubitec2_CA"  style="width:20%;">
                                <hr>-->
                                <label><%out.println(po.getProperty("etiqueta.DescripcioncodiCAA"));%></label><input type="text" id="DescripcionCircunstancias_CA" style="width:20%;"  > 
                                <hr>
                                <textarea rows="8" cols="100" style="resize:none;" maxlength="800" id="TexareaCircunstancia_CA" ></textarea>

                            </div>
                        </section>

                        <section class="SeccionActividades_CA">
                            <label><%out.println(po.getProperty("etiqueta.ActividadesCAA"));%></label>
                            <hr id="lineatitulo">   
                            <div class="divcomorden">
                                <div style="overflow-x:auto; width: 95%; height: 200px; overflow-y:auto;">
                                    <table class="tableAviso" style=" height: 90px; background-color:#F2F2F2; font-size: .8em; border-collapse:collapse; table-layout:auto;">
                                        <tr style=" background-color:#DDDDDD;">
                                            <th></th>                                  
                                            <th><%=pos%></th>
                                            <th style="width:30%;"><%=grupCod%></th>
                                            <th><%=codAct%></th>
                                            <th style="width:4150%;"><%=txtCod%></th>
                                            <th><%=txtAcc%></th>
                                            <th><%=te%></th>
                                            <!--<th><%=factCan%></th>-->
                                            <th style="width:750%;"><span style="color:#DDDDDD;">___</span><%=feIn%><span style="color:#DDDDDD;">___</span></th>
                                            <th style="width:750%;"><%=horaAv%><span style="color:#DDDDDD;">_________</span></th>
                                            <th style="width:750%;"><span style="color:#DDDDDD;">_____</span><%=fechaFin%><span style="color:#DDDDDD;">_____</span></th>
                                            <th><%=horaAv%><span style="color:#DDDDDD;">_________</span></th>
                                            <!--<th><%=activ%></th>-->
                                        </tr>
                                        <tbody id="AvisoTabla">
                                            <%
                                                for (int i = 0; i < 50; i++) {
                                                    out.println("<tr>"
                                                            + "<td><input type=\"checkbox\" /></td>"
                                                            + "<td><input type=\"text\" id=\"Tpos" + i + "\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"\" readonly></td>"
                                                            + "<td><input type=\"text\" name=\"grco\" id=\"grco" + i + "\" onclick=\"OculButt('" + i + "')\" style=\"width: 72%; border-width:0;\" maxlength=\"8\" value=\"\"><button name=\"matmat1\" id='matmat1" + i + "' onclick=\"venMate('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></td>"
                                                            + "<td><input type=\"text\" id=\"deco" + i + "\" style=\"width: 100%; border-width:0;\" maxlength=\"4\" value=\"\"></td>"
                                                            + "<td><input type=\"text\" id=\"teco" + i + "\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" maxlength=\"40\" value=\"\" readonly></td>"
                                                            + "<td><input type=\"text\" id=\"teac" + i + "\" style=\"width: 100%; border-width:0;\" maxlength=\"40\" value=\"\"></td>"
                                                            + "<td></td>"
//                                                            + "<td><input type=\"text\" id=\"FCan" + i + "\" class=\"numFac\" style=\"width: 100%; border-width:0;\" maxlength=\"3\" value=\"\"></td>"
//                                                            + "<td><input type=\"date\" id=\"theDate" + i + "\" style=\"width: 100%; border-width:0;\" value=\"\"></td>"
                                                            + "<td><input maxlength=\"10\" type=\"text\" value=\"\" id=\"fechaAV" + i + "\" onclick=\"OculFe('" + i + "')\" style=\"width: 72%; border-width:0;\" onpaste=\"return false;\" readonly /><button id='dateNew" + i + "' onclick=\"venFee('" + i + "')\" class=\"BtnMatchIcon\" style='margin-left:1px; display:none;'></button></td>"
                                                            + "<td><input type=\"text\" style=\"width: 80%;border-width:0;\" onclick=\"OculBTi(" + i + ")\" id=\"Time" + i + "\" readonly /><button id='matma" + i + "' onclick=\"venTiempoU('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
//                                                            + "<td><input type=\"date\" id=\"theDate1" + i + "\" style=\"width: 100%; border-width:0;\" value=\"\"></td>"
                                                            + "<td><input maxlength=\"10\" type=\"text\" value=\"\" id=\"fechaAV1" + i + "\" onclick=\"OculFe2('" + i + "')\" style=\"width: 72%; border-width:0;\" onpaste=\"return false;\" readonly /><button id='dateNew1" + i + "' onclick=\"venFee1('" + i + "')\" class=\"BtnMatchIcon\" style='margin-left:1px; display:none;'></button></td>"
                                                            + "<td><input type=\"text\" style=\"width: 80%; border-width:0;\" onclick=\"OculBTi2(" + i + ")\" id=\"Time1" + i + "\" readonly /><button id='matma1" + i + "' onclick=\"venTiempoD('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
//                                                            + "<td><input type=\"text\" id=\"Tpos" + i + "\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"0\" readonly></td>"
                                                            + "<td hidden ><input type=\"text\" name=\"valores\" value=\"" + i + "\"/></td> "
                                                            + "</tr>\n");

                                                }
                                            %>
                                            <!--<tr style="visibility: hidden;" ><td></td><td><input type="text"  style="width: 100%; background-color: #F2F2F2; border-width:0;" id="grco5" value="" readonly></td><td><input type="text"style="width: 72%; border-width:0;" value=""></td><td><input type="text"  style="width: 100%; border-width:0;" value=""></td><td><input type="text"  style="width: 100%; background-color: #F2F2F2; border-width:0;" value="" readonly></td><td><input type="text" style="width: 100%; border-width:0;" value=""></td><td></td><td><input type="text" style="width: 100%; border-width:0;" value=""></td><td><input type="date" style="width: 100%;background-color: #F2F2F2; border-width:0;" value=""></td><td><input type="time" style="width: 70%;border-width:0;" disabled></td><td><input type="date" style="width: 100%;background-color: #F2F2F2; border-width:0;" value=""></td><td><input type="time" style="width: 100%;background-color: #F2F2F2; border-width:0;" ></td><td><input type="text" style="width: 100%; background-color: #F2F2F2; border-width:0;" value="0" readonly></td></tr>-->     
                                    </table>
                                </div>
                            </div>
                        </section>
                        <section class="SeccionPestañas_orden">
                            <div class="tabsorden">
                                <button id="match_A546" class='BtnDeleteIcon' ></button> <button id="match_A54" class='BtnAddIcon' ></button>
                            </div>
                        </section> 


                    </section>
                    <script>

                        function venMate(l) {
                            var theHandle = document.getElementById("handle9");
                            var theRoot = document.getElementById("VentanaModalGrupoCod");
                            Drag.init(theHandle, theRoot);
                            var ventana8 = document.getElementById("VentanaModalGrupoCod");
                            mandarGruCod(l);
                            abrirVentana(ventana8);
                        }
                        function venFee(l) {
                            OpenCalendario("fechaAV"+l);
                        }
                        function venFee1(l) {
                            OpenCalendario("fechaAV1"+l);
                        }

                        function venTiempoU(l) {
                            var theHandle = document.getElementById("handleho");
                            var theRoot = document.getElementById("VentHora");
                            Drag.init(theHandle, theRoot);
                            var ventana10 = document.getElementById("VentHora");
                            abrirVentana(ventana10);
                            AsignarHora("Time" + l);
                        }
                        function venTiempoD(l) {
                            var theHandle = document.getElementById("handleho");
                            var theRoot = document.getElementById("VentHora");
                            Drag.init(theHandle, theRoot);
                            var ventana10 = document.getElementById("VentHora");
                            abrirVentana(ventana10);
                            AsignarHora("Time1" + l);
                        }

                    </script>
                </section>

                <div id="mensajero"></div>

            </div>
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input type="text" hidden id="IDFecha"/>
            </div>
        </div>
        <div id="VentanaModalUbitec" class="VentanaModalAviubi">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.tituloubitecmatchMAA"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ubitec');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="RegresPrin('BuscarParam_u', 'ConsultaTabla')"><%out.println(po.getProperty("etiqueta.buttonMatchubitecMAA"));%></button><hr></div>
            <div id="BuscarParam_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ubitecCAA"));%></label><input type="text" id="ubitec_MAA" maxlength="30" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="Denominacion_MAA" maxlength="40" style="width:40%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.sociedadmatchMAA"));%></label><input type="text" id="Sociedad_MAA" maxlength="4" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" id="btnacubt" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;"  />
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('ubitec');"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollubiAv">
                        <div class="fixedY" id="fixedYubiA">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ubitecCAA"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th><th><%out.println(po.getProperty("etiqueta.sociedadmatchMAA"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalEquipos" class="VentanaModalAvi">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.titulomatchequipoMAA"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('equipo');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="RegresPrin('BuscarParamSoc_u', 'ConsultaTabla2')"><%out.println(po.getProperty("etiqueta.tituloBotonMatchMAA"));%></button><hr></div>
            <div  id="BuscarParamSoc_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="DenominacionEquipoMatch_MAA" maxlength="40" style="width:40%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralEquipo"));%></label><input type="text" id="EquipoMatch_MAA" maxlength="18" style="width:35%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax2"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" id="btnacequi" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('equipo');"/>
                </div>
            </div>
            <div id="ConsultaTabla2" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrollEqAv" class="table-scroll">
                        <div id="fixedYeqAv" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th><th><%out.println(po.getProperty("etiqueta.GralEquipo"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatos2" class="nofixedX">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    
        <div id="VentanaModalConjunto" class="VentanaModalAvi">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.TituloConjuntoMatchMAA"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('conjunto');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="RegresPrin('BuscarParam_OV', 'ConsultaTabla3')"><%out.println(po.getProperty("etiqueta.botonConjuntoMatchMAA"));%></button><hr></div>
            <div id="BuscarParam_OV" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input type="text" id="Material_bus" maxlength="40" style="width:10%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" id="MaterialDes_bus" maxlength="40" style="width:30%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax3" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" id="btnacconj" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('conjunto');"/>
                </div>
            </div>
            <div id="ConsultaTabla3" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll3" class="table-scroll">
                        <div id="fixedY3" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th><th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatos3" class="nofixedX">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>       
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParam_Can" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input type="text" id="CanalD_CL" style="width:35%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" id="DenomCanal_CL" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax4" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" id="btnaccen" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('centro');"/>
                </div>
            </div>
            <div id="ConsultaTabla4" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll4">
                        <div class="fixedY" id="fixedY4">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos4">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalUsuario" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('usuario')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_Sec" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Usuario</label><input type="text" id="Sector_CL" style="width:25%;"  focus/>
                        <hr>
                        <label>Apellido paterno</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Apellido materno</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Nombre</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Calle</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Colonia</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Población</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Estado</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label>Pais</label><input type="text" id="DenomSecto_CL" style="width:25%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax5" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ConsultaUsuario();"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('usuario');"/>
                </div>
            </div>
            <div id="ConsultaTabla5" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll5">
                        <div class="fixedY" id="fixedY5">
                            <table>
                                <thead>
                                    <tr>
                                        <th >Usuario</th><th>Nombre</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos5">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalGrupoP" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('grupop')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParam_GrupoP" class="BuscarParam_u" style="display: none">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Grupo"));%></label><input type="text" id="GrupoPMatch_CA" style="width:20%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PlannerPlant"));%></label><input type="text" id="CentroPMatch_CA" style="width:15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax6" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ConsultaGrupoP();"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('grupop');"/>
                </div>
            </div>
            <div id="ConsultaTabla6" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll6">
                        <div class="fixedY" id="fixedY6">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Grupo"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.PlannerPlant"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos6">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalCentroP" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centrop')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_CentroP" class="BuscarParam_u" style="display: none">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GrupoPlanificador_CA"));%></label><input type="text" id="GrupoPMatch_CA" style="width:20%;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CentroPlanificador_CA"));%></label><input type="text" id="CentroPMatch_CA" style="width:15%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax7" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ConsultaCentroP();"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('centrop');"/>
                </div>
            </div>
            <div id="ConsultaTabla7" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll7">
                        <div class="fixedY" id="fixedY7">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Grupo"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.PlannerPlant"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos7">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPtr" class="VentanaModalAvi">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.tituloPuestotrabajoMAA"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ptr')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="RegresPrin('BuscarParam_Ptr', 'ConsultaTabla8')"><%out.println(po.getProperty("etiqueta.ClasepuestoMAA"));%></button><hr></div>
            <div id="BuscarParam_Ptr" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.descripcionptrMAA"));%></label><input type="text" id="ptrDenom_Match" style="width:40%;"  maxlength='40'/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></label><input type="text" id="ptrPuestoT_Match" style="width:15%;" maxlength='8'/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.centroMAA"));%></label><input type="text" id="ptrCentro_Match" style="width:10%;" maxlength='40'/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax8" style="width:10%;"  maxlength='3'/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" id="btnacptr" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" />
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('ptr');"/>
                </div>
            </div>
            <div id="ConsultaTabla8" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll17">
                        <div class="fixedY" id="fixedY17">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.centroMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.descripcionptrMAA"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos8">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <div id="VentanaModalGrupoCod" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.SelecCatMatchAV"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GrupCodi')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button>PM1</button><hr></div>
            <div id="ConsultaTabla9" >
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll9">
                        <div class="fixedY" id="fixedY9">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GrpoCoMatchAV"));%></th><th><%out.println(po.getProperty("etiqueta.ActManteMatchAV"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos9">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>                 
        <div id="VentHora" class="VentanaModalHO">
            <div id="handleho" ><label id="TituloMatchas"><%out.println(po.getProperty("etiqueta.SelectHoraMatchAV"));%></label>
                <div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal')"><label >X</label></div></div>
            <div class="busquedaMatch">
                <label> HH </label>
                <label style="margin-left:-25%">MM</label>
                <label style="margin-left:-28%">SS</label>
                <hr>
                <input type="number" min="0" max="23" maxlength="2" minlength="1" id="Match_HH" style="width:10%;" focus/>:
                <input type="number" min="0" max="59" maxlength="2" minlength="1" id="Match_MM" style="width:10%;"/>:
                <input type="number" min="0" max="59" maxlength="2" minlength="1" id="Match_SS" style="width:10%;" />
                <input type="text" id="idmathor" hidden />
            </div>        
            <br>
            <br>
            <br>
            <br>
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ProcesarHOra()"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModal');"/>

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

                    function CArgarMne() {
                        var mensajOk = '<%=meFOL%>';
                        if (mensajOk != 'null') {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapmsg.wav";
                            BE.play();
                            $("#iconmsg").css("visibility", "visible");
                            $("#iconmsg").attr("src", "images/aceptar.png");
                             $("#msg").html('<%=av%> ' + mensajOk + ' <%=gra%>');
                        } else {
                            borramsg();
                        }

                    }
                    function bloq() {
                        $("#iconmsg").css("visibility", "hidden");
                        //document.getElementById('guardar').disabled = true;
                    }
                    function tabsprin() {
                        $("#seccioncabecera").css("display", "block");
                        $("#tabcabec").css("backgroundColor", "#007CC0");
                        $("#tabcabec").css("color", "#fff");
                    }

                </script>

            </div>
        </footer>
    </body>
    <script>
        function mensajess(m, au, im) {
            var mensj = "";
            var mensajOk = '<%=foc%>';
            switch (m) {
                case 0:
                    mensj = '<%=exCamVac%>';
                    break;
                case 1:
                    mensj = '<%=invalid%>';
                    break;
                case 2:
                    mensj = '<%=noValSecc%>';
                    break;
                case 3:
                    mensj = '<%=falDatLlen%>';
                    break;
                case 4:
                    mensj = '<%=av%>  ' + mensajOk + ' <%=gra%>';
                    break;
                case 5 :
                    mensj = +'<%=equipoo%>' + "," + '<%=msgEq%>';
                    break;
                case 6:
                    mensj = '<%=ubTeec%>' + "," + '<%=msgEq%>';
                    break;

            }
            var BE = document.createElement('audio');
            BE.src = au;
            BE.play();
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", im);
            $("#msg").html(mensj);
        }
        function mensajALer(me) {

            switch (me) {
                case "U":
                    $("#msg").html('<%=ubTeNV%>');
                    break;
                case "E":
                    $("#msg").html('<%=eqNV%>');
                    break;
                case "C":
                    $("#msg").html('<%=conNV%>');
                    break;
                case "G":
                    $("#msg").html('<%=gpNV%>');
                    break;
                case "CP":
                    $("#msg").html('<%=cpNV%>');
                    break;
                case "P":
                    $("#msg").html('<%=ptNV%>');
                    break;
                case "CE":
                    $("#msg").html('<%=centroNV%>');
                    break;
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");

            }
        }

    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>



