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
        String Aviso = request.getParameter("Aviso");
        String Tipo = request.getParameter("Tipo");
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
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
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
        String inv = po.getProperty("etiqueta.FuncionInval_Menu");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">

        <script>
            function CheckResolucion() {
                if (screen.width <= 500) {
                    var msgResolucion = 'Resolución no soportada';
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
                var a = '<%=Aviso%>';
                var pag = p.charAt(86);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (a == null || a == "" || a == "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=inv%>';
                        break;
                    case 1:
                        msg = 'El aviso esta actualmente cerrado';
                        break;
                    case 2:
                        msg = 'La fecha debe ser mayor o igual a la actual';
                        break;
                    case 3:
                        msg = 'Fecha referencia obligarotia';
                        break;
                    case 4:
                        msg = 'Fecha Invalida';
                        break;
                    case 5:
                        msg = 'Hora de referencia obligatoria';
                        break;
                    case 6:
                        msg = 'Se realizó un cierre técnico anteriormente';
                        break;
                    case 7:
                        msg = 'Se realizó un cierre técnico correctamente';
                        break;
                    case 8:
                        msg = 'Error: Ocurrio un error al realizar el cierre técnico';
                        break;
                    case 9:
                        msg = 'No se puede generar una orden porque se realizo un Cierre Técnico anteriormente';
                        break;
                    case 10:
                        msg = 'No se puede ejecutar esta acción por el aviso contiene un error';
                        break;
                    case 11:
                        msg = '<%=menValores%>';
                        break;
                    case 12:
                        msg = 'Clase de orden no encontrada';
                        break;
                    case 13:
                        msg = 'Centro no encontrado';
                        break;
                    case 14:
                        msg = 'Puesto de trabajo no encontrado';
                        break;
                    case 15:
                        msg = 'Clase de orden Obligatoria';
                        break;
                    case 16:
                        msg = 'Centro de planificación Obligatorio';
                        break;
                    case 17:
                        msg = 'Puesto de trabajo obligatorio';
                        break;
                    case 18:
                        msg = 'Clase orden Servicio/mantenimiento no permitida';
                        break;
                    case 19:
                        msg = 'Ubicación técnica no encontrada';
                        break;
                    case 20:
                        msg = 'Equipo no encontrado';
                        break;
                    case 21:
                        msg = 'Material no encontrado';
                        break;
                    case 22:
                        msg = 'Centro planificación no encontrado';
                        break;
                    case 23:
                        msg = 'Equipo es campo obligatorio';
                        break;
                    case 24:
                        msg = 'Grupo de planificación es campo obligatorio';
                        break;
                    case 25:
                        msg = 'Puesto de trabajo es campo obligatorio';
                        break;
                    case 26:
                        msg = 'Grupo de planificación no encontrado';
                        break;
                    case 27:
                        msg = 'Codigo de Actividad obligatorio';
                        break;
                    case 28:
                        msg = 'Tezxto Codigo de Actividad obligatorio';
                        break;
                    case 29:
                        msg = 'Texto de Acción obligatorio';
                        break;
                    case 30:
                        msg = 'Factor de cantidad  obligatorio';
                        break;
                    case 31:
                        msg = 'Fecha de inicio campo obligatorio';
                        break;
                    case 32:
                        msg = 'Hora de inicio campo obligatorio';
                        break;
                    case 33:
                        msg = 'Fecha fin campo obligatorio';
                        break;
                    case 33:
                        msg = 'Hora fin campo obligatorio';
                        break;
                    case 34:
                        msg = 'Hora fin campo obligatorio';
                        break;
                    case 35:
                        msg = 'Grupo de codigo no valido';
                        break;
                    case 36:
                        msg = 'Codigo no valido';
                        break;
                    case 37:
                        msg = 'Fecha fin debe ser mayor a fecha inicio';
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
            function ShowMsgWindow(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = 'Se realizó un cierre técnico correctamente';
                        break;
                    case 1:
                        msg = 'Error al crear Cierre tecnico';
                        break;
                    case 2:
                        msg = 'Aviso Modificado';
                        break;
                    case 3:
                        msg = 'Se completo la modificacion del Aviso SAP, se presentara de nuevo la carga del Aviso como dato maestros';
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                var ancho = 600;
                var alto = 500;
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
            function  CargarEdicion() {
                var Aviso = '<%=Aviso%>';
                var Tipo = '<%=Tipo%>';
                CargarCabecera(Aviso, Tipo);
                CargarTextos(Aviso, Tipo);
            }
        </script>
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/CrearAviso.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <script src="js/ModificarAvisoss.js" type="text/javascript"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.TitleModAv"));%></title>     
    </head>
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
                        var idda = $('#idDataFeee').val();
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
            <input id="TipoAviso" value="<%=Tipo%>" hidden/>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input  id="guardar" type="image" src="images/guarda.PNG" disabled/> 
            <input  id="regresar1" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar"type="image" src="images/cancela.PNG"/>
            <input  id="cietec"  type="image" src="images/cierretecnico.png" />
            <div class="titulo"><span><h1><b><label style="font-size: 1em;"><%out.println(po.getProperty("etiqueta.TitleModAv"));%></label></b><label style="font-size: 1em;" ></label></h1></span></div>  
        </div>
        <div class="contenido">
            <div class="ContentAvisoCrea">  
                <div class="DivParametrosAviso">
                    <label><%out.println(po.getProperty("etiqueta.Notificacion"));%></label><input type="text" id="Notificacion_CA" disabled style="width:8%;"/> <input type="text" id="Claseaviso_CA" disabled style="width:3%;"/> <input type="text"  id="descripcionnotificacion_CA" style="width: 25%;" disabled maxlength="80" />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.StatusMensajeCAA"));%></label><input type="text" id="statusSis" disabled/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.OrdenCAA"));%></label><input type="text" id="statusOrden_CA"  value="" disabled/><button id="BUorav"><img src="images/S_B_CREA.gif"  style="height: 12px;"/></button>
                    <hr>
                </div>
                <div id="MensajeErorAviso" style="display: none;"><input type="image" src="images/advertencia.PNG" style="margin-left: 2%; vertical-align: middle;" id="iconmsger"><input type="text" id="menser" style="width: 80%; border: none; background: none;" readonly/></div>
                <section class="SeccionPestañas_orden">
                    <div class="tabsorden">
                        <input type="button" style="background: #007CC0; color: #fff;" value="<%out.println(po.getProperty("etiqueta.AvisoCAA"));%>"/>
                    </div>
                    <hr id="lineatabs">
                </section>                       
                <section class="ContenidoTabsOrden">
                    <section class="TabCabecOrden" id="seccioncabecera" >                              
                        <section class="Secbobj_avi">
                            <label><%out.println(po.getProperty("etiqueta.ObjetoreferenciaCAA"));%></label>
                            <hr id="lineatitulo">     
                            <div class="divobjavi">
<!--                                <label><%out.println(po.getProperty("etiqueta.ubitecCAA"));%></label><input tyoe="text" id="ubictec_CA" style=" width:20%; text-transform: uppercase;" disabled  maxlength="30" /><button id="match_A1" class='BtnMatchIcon' style="display: none;"></button> <input id="DenominacionUbitec_MAA" style="width:45%; background: none; border: none;" readOnly>
                                <hr>-->
                                <label><%out.println(po.getProperty("etiqueta.equipoCAA"));%></label><input type="text" id="equipo_CA"  style=" width: 20%; text-transform: uppercase;" disabled maxlength="18"/><button id="match_A2" class='BtnMatchIcon' style="display: none;"></button> <input id="DenominacionEquipo_MAA" style="width:45%; background: none; border: none;" readOnly>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.conjuntoCAA"));%></label><input type="text" id="conjunto_CA" style="width: 20%; text-transform: uppercase;" maxlength="40" disabled/><button id="match_A3" class='BtnMatchIcon' style="display: none;"></button> <input id="DenominacionConjunto_MAA" style="width:45%; background: none; border: none;" readOnly>
                                <hr>
                            </div>
                        </section>
                        <section class="SecRes_avi">
                            <label><%out.println(po.getProperty("etiquta.ResponsabilidadesCAA"));%></label>
                            <hr id="lineatitulo">   
                            <div class="divobjavi">
                                <label><%out.println(po.getProperty("etiqueta.GrupoplanCAA"));%></label><input type="text" id="GrpPlanificacion_CA" style="width: 5%; text-transform: uppercase;" disabled /><button id="match_A4" class='BtnMatchIcon' style="display: none;"></button> / <input type="text" id="CentroPlaninificacion_CA"  maxlength="4" style="width:8%; text-transform: uppercase;" disabled/><span> <label id="DenominacionGplan" style="font-size: 0.9em; font-family: 'Tahoma'; width: auto;"/></label> / <label id="DenominacionCentro" style="font-size: 0.9em; font-family: 'Tahoma'; "/></label></span>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.PuestoresponsableCAA"));%></label><input type="text" id="puestotrabajo_CA" maxlength="8" style="width:15%; text-transform: uppercase;" disabled /><button id="match_A5" class='BtnMatchIcon' style="display: none;"></button> / <input type="text" id="puestotrabajo2_CA" style="width:10%; text-transform: uppercase;" disabled />
                                <span> <label id="DenominacionPuestoTrabajo_MAA" style="font-size: 0.9em; font-family: 'Tahoma'; width: auto;"/></label> / <label id="DenCentroP" style="font-size: 0.9em; font-family: 'Tahoma'; "/></label></span>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.autoravisoCAA"));%></label><input type="text" id="autorAviso_CA" style="width:15%" disabled /> <span id='spanfechaavi'><%out.println(po.getProperty("etiqueta.FechaavisoCAA"));%></span><input type="text" id="theDate" disabled /> <input type="text" id="Time" disabled>
                                <hr>
                            </div>
                        </section>
                        <section class="SeccionCircunstancias_CA">
                            <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.Circunstancias"));%></label>
                            <hr id="lineatitulo">   
                            <div class="divobjavi">
                                <label><%out.println(po.getProperty("etiqueta.DescripcioncodiCAA"));%></label><input type="text" id="DescripcionCircunstancias_CA" style="width:20%;" disabled/> 
                                <hr>
                                <textarea rows="8" cols="82" maxlength="800" style="resize: none;" id="TexareaCircunstancia_CA" disabled></textarea>
                            </div>
                        </section>
                    </section>
                    <section hidden class="SSeccionActividadesAV">
                        <label id="lblTitulo_ord"><%out.println(po.getProperty("etiqueta.ActividadesCAA"));%></label>
                        <hr id="lineatitulo">   
                        <div class="ServAct">
                            <div id="TablaStatus2">
                                <table id="tabAct" class="TablaCont2">
                                    <thead>
                                        <tr id="CabeceraTabla">
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.posCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.grupCodCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.codActCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.txtCodCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.txtAccCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.teCreAv"));%></td>
                                            <!--<td><%out.println(po.getProperty("etiqueta.factCanCreAv"));%></td>-->
                                            <td><%out.println(po.getProperty("etiqueta.feInCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.horaAvCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.fechaFinCreAv"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.horaAvCreAv"));%></td>
                                            <!--<td><%out.println(po.getProperty("etiqueta.activCreAv"));%></td>-->
                                        </tr> 
                                    </thead>
                                    <tbody id="TablaAct">                     
                                    </tbody>
                                </table>
                            </div>
                            <section id="botonesadddel">
                                <input id="AgregarFilaAvisos" type="image" src="images/ADD.PNG" style="vertical-align: middle"/>
                                <input id="BorrarFilaAvisos" type="image" src="images/DELETEADD.PNG" style="padding-top: 1px; vertical-align: middle; margin-left: -1%;"/>
                            </section>
                        </div>
                    </section>
                </section>
            </div>
        </div>
        <div id="VentanaModalCANTEC" class="VentanaModalORAV">
            <div id="handleCTEC"><label id="TituloMatch" class="Titles"><%out.println(po.getProperty("etiqueta.MAConcluir"));%></label><div class="BotonCerrar_Matc" id="CerrarCETEC"><label >X</label></div></div>
            <div id="BuscarParam201" class="BuscarParam_u">
                <div class="fondo_MatchCetec">
                    <label><%out.println(po.getProperty("etiqueta.MAFeReferenc"));%></label><input type="text"  id="fecha_conc"  style="text-transform: uppercase; width:25%; " readOnly/><button id="matcfechaCetec" class='BtnMatchIcon' style="display: none;"></button>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.MAHoraReferenc"));%></label><input type="time" name="hora" id="hora_conc"  step="1">
                    <hr>
                </div>
                <div class="Botones_MatCetec">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCONAVI"/>                       
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarVenatCetec"/>
                </div>
            </div>
        </div> 
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input id="idDataFeee" hidden/>
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
        <div id="VentanaModalORDenAV" class="VentanaModalORDenAV">
            <div id="handleOrdenAV"><label id="TituloMatch" clashandleOrdenAVs="Titles"><%out.println(po.getProperty("etiqueta.abOrdenMA"));%></label><div class="BotonCerrar_Matc" id="CerrarVentaOrd"><label >X</label></div></div>
            <div id="BuscarParam201" class="BuscarParam_u">
                <div class="fondo_MatchCetecOrdn">
                    <label><%out.println(po.getProperty("etiqueta.clOrdenMA"));%></label><input type="text" class="bxMMD200" id="IVOclo" maxlength="4"  style="text-transform: uppercase; width: 10%"/><button id="BVOclo" class='BtnMatchIcon' style="display: none;"></button>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.cnPlanMA"));%></label><input type="text" class="bxMMD200" id="IVOcp" maxlength="4" style="width: 10%; text-transform: uppercase;"/><button id="BVOcp" class='BtnMatchIcon' style="display: none;"></button>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.divisionMA"));%></label><input type="text" class="bxMMD200" id="IVOdi" style="width: 15%; text-transform: uppercase;" maxlength="50"/>
                    <hr>  
                    <label><%out.println(po.getProperty("etiqueta.ptoTraResMA"));%></label><input type="text" class="bxMD200" id="IVOptr" style="width: 25%; text-transform: uppercase;"  maxlength="30"><button id="BVPto" class='BtnMatchIcon' style="display: none;"></button> / <input type="text" class="bxUM200" id="IVOctr" style="text-transform: uppercase; width: 10%;" readOnly>
                    <hr>
                </div>
                <div class="Botones_MatCetec">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okORDAV"/>                       
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarVentaOrd2"/>
                </div>
            </div>
        </div> 
        <div id="VentanaModalCLase" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraClaseMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaClase">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClase">
                        <div class="fixedY" id="fixedYClase">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.clOrdenMA"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMDscri"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="DatosCLasOR">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraCentroMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMCent"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMDscri"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="DatosCentro">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="VentanaModalPuestoOrd" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraPtoOrdMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaPtoOrd">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuestOrd">
                        <div class="fixedY" id="fixedYPuestOrd">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMDscri"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="DatosPtoOrd">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalUbitec" class="VentanaModalAviubi">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.tituloubitecmatchMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarUTecMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retubi"><%out.println(po.getProperty("etiqueta.buttonMatchubitecMAA"));%></button><hr></div>
            <div id="BuscarParamUbi" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.tituloubitecmatchMAA"));%></label><input type="text" id="ubitec_MAA" maxlength="30" style="width:25%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="Denominacion_MAA" maxlength="40" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.sociedadmatchMAA"));%></label><input type="text" id="Sociedad_MAA" maxlength="4" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkUbiTec" />
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarUTecMC2"/>
                </div>
            </div>
            <div id="ConsultaTablaUbi" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollubi">
                        <div class="fixedY" id="fixedYUbi">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.tituloubitecmatchMAA"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th><th><%out.println(po.getProperty("etiqueta.sociedadmatchMAA"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUbi">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalEquipos" class="VentanaModalAvi">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.titulomatchequipoMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarEquipoMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="RetErui"><%out.println(po.getProperty("etiqueta.tituloBotonMatchMAA"));%></button><hr></div>
            <div  id="BuscarParamEquipo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" id="DenominacionEquipoMatch_MAA" maxlength="40" style="width:30%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralEquipo"));%></label><input type="text" id="EquipoMatch_MAA" maxlength="18" style="width:15%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax2"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="OKEquipo"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerrarEquipoMC2"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrollEquipo" class="table-scroll">
                        <div id="fixedYEquipo" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th><th><%out.println(po.getProperty("etiqueta.GralEquipo"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatosEquipo" class="nofixedX">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalConjunto" class="VentanaModalAvi">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.TituloConjuntoMatchMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarConjuntoMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retconj"><%out.println(po.getProperty("etiqueta.botonConjuntoMatchMAA"));%></button><hr></div>
            <div id="BuscarParamConjutno" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input type="text" id="Material_bus" maxlength="40" style="width:20%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" id="MaterialDes_bus" maxlength="40" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax3" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="OKConjunto"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarConjuntoMC2"/>
                </div>
            </div>
            <div id="ConsultaTablaConj" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrollConj" class="table-scroll">
                        <div id="fixedYConj" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th><th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatosConj" class="nofixedX">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="VentanaModalGrupoPlan" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraGPlaMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaGPla">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGPlan">
                        <div class="fixedY" id="fixedYGPlan">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Grupo"));%></th><th><%out.println(po.getProperty("etiqueta.Grupo"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatoGPla">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="VentanaModalPuesto" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerraPtoMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaPto">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuest">
                        <div class="fixedY" id="fixedYPuest">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMDscri"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="DatosPto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalGrupoCodigos" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMCGC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="ConsultaTablaGCodigos">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollGCodig">
                        <div class="fixedY" id="fixedYGodigo">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GrpoCoMatchAV"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.codActCreAv"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.ActManteMatchAV"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosGCodigo">
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
