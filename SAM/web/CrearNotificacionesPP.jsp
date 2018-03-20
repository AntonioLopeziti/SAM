<%@page import="Clases.ClassModuloCrearOrden"%>
<%@page import="Clases.ClassModuloCrearOrden"%> 
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.Consultas"%>
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
        String orn = request.getParameter("orden");
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
        String Noex = po.getProperty("etiqueta.NPMNoexisten");
        String NPMAvisoPant = po.getProperty("etiqueta.NPMAvisoPant");
        String reso = po.getProperty("etiqueta.Resolucio");
        folios fo = ACC_Folios.ObtenerIstancia().ObtenerFolioExcedido("CO");
        String MonReall = po.getProperty("etiqueta.NPMMonReallEx");
        int fa = fo.getFolioActual();
        String NPMCamOrOb = po.getProperty("etiqueta.NPMCamOrObl");
        String NPMOrNoExx = po.getProperty("etiqueta.NPMNoExOrdee");
        String NPMSinMatVaCon = po.getProperty("etiqueta.NPMSinMatVaCon");
        String NPMCantRequi = po.getProperty("etiqueta.NPMCanRequi");
        String NPMCanReqMC = po.getProperty("etiqueta.NPMLotReqMatCe");
        String NPMCanLotAlNoSu = po.getProperty("etiqueta.NPMCanLotAlNoSu");
        String NPMMatCree = po.getProperty("etiqueta.NPMMatCree");
        String NPMMovNoCree = po.getProperty("etiqueta.NPMMovNoCree");
        String NPMDurReOb = po.getProperty("etiqueta.NPMDurReOb");
        String NPMSolPoEqMon = po.getProperty("etiqueta.NPMSolPosEqMon");
        String NOTSTfin = po.getProperty("etiqueta.NOTSTfin");
        String nopecaob = po.getProperty("etiqueta.nopecaob");
        String NOTSTfincab = po.getProperty("etiqueta.NOTSTfincab");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        ClassModuloCrearOrden html = new ClassModuloCrearOrden();
        String htmlResponse;
    %>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script>
            function msgMatch(val) {
                switch (val) {
                    case "NPMCamOrOb":
                        var NPMCamOrOb = '<%=NPMCamOrOb%>';
                        $('#msg').html(NPMCamOrOb);
                        break;
                    case "NPMOrNoExx2":
                        var NPMOrNoExx = '<%=NPMOrNoExx%>';
                        $('#msg').html(NPMOrNoExx);
                        break;
                    case "NPMOrNoExx":
                        var NPMOrNoExx = '<%=NPMOrNoExx%>';
                        $('#etav').html(NPMOrNoExx);
                        break;
                    case "NPMSinMatVaCon":
                        var NPMSinMatVaCon = '<%=NPMSinMatVaCon%>';
                        $("#etav").html(NPMSinMatVaCon);
                        break;
                    case "NPMCantRequi":
                        var NPMCantRequi = '<%=NPMCantRequi%>';
                        $('#etav').html(NPMCantRequi);
                        break;
                    case "NPMCanReqMC":
                        var NPMCanReqMC = '<%=NPMCanReqMC%>';
                        $('#etva').html(NPMCanReqMC);
                        break;
                    case "NPMCanLotAlNoSu":
                        var NPMCanLotAlNoSu = '<%=NPMCanLotAlNoSu%>';
                        $('#etav').html(NPMCanLotAlNoSu);
                        break;
                    case "NPMMatCree":
//                        var NPMMatCree = '<%=NPMMatCree%>';
                        var NPMMatCree = "Consumo creado ";
                        var fol = $("#folasmov").val();
                        $('#msg').html(NPMMatCree + "CO" + fol);
                        break;
                    case "NPMMovNoCree":
                        var NPMMovNoCree = '<%=NPMMovNoCree%>';

                        $('#msg').html(NPMMovNoCree);
                        break;
                    case "NPMDurReOb":
                        var NPMDurReOb = '<%=NPMDurReOb%>';
                        $('#msg').html(NPMDurReOb);
                        $("#iconmsg").css("visibility", "visible");
                        $("#iconmsg").attr("src", "images/advertencia.PNG");
                        break;
                    case "NPMSolPoEqMon":
                        var NPMSolPoEqMon = '<%=NPMSolPoEqMon%>';
                        $('#etav').html(NPMSolPoEqMon);
                        break;
                    case "NOTSTfin":
                        var NOTSTfin = '<%=NOTSTfin%>';
                        $('#etav2').html(NOTSTfin);
                        break;
                    case "nopecaob":
                        var nopecaob = '<%=nopecaob%>';
                        $('#etav').html(nopecaob);
                        break;
                    case "invv":
                        var funcioninv = '<%=funcioninv%>'
                        $('#msg').html(funcioninv);
                        break;
                }


            }


            function msgMatch2(ord, r2) {
//                var NPMDurReOb = '<%=NPMDurReOb%>';
//                $('#msg').html(NPMDurReOb + " " + ord + ": " + r2);
                var NPMDurReOb = "Notificación creada " + r2;
                $('#msg').html(NPMDurReOb);

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
                var pag = p.charAt(116);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            var usuario = '<%=Nombre%>';
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleCrearNotificacionesPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">        
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/CreaNotificacionesPP.js"></script>
        <!--<script src="js/NotificacionesPM.js"></script>-->
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.NPMNotificacionordenmt_PP"));%></title>  

    </head>
    <body>
        <div id="divoc" hidden></div>
        <div id="divreq" hidden></div>
        <div id="main-header">    
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:invall();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"  onclick="mostrar1()" />             
            <!--<input id="aceptar" type="image" src="images/aceptar.png"  onclick="ListaMateriales()" />-->                
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled />               
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="backto();"/>
            <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
            <input  id="cancelar"type="image" src="images/cancela.PNG" onclick="back();"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.NPMNotificacionespmbuques_PP"));%></h1></div>      
            <!--                mostrarventaavi()-->
        </div>
        <div id="Cont" hidden></div> 
        <div class="contenido">
            <input type="text" id="folasmov" hidden/> 
            <input type="text" id="bt" hidden/>
            <div class="ContentEquipos">
                <div class="divmatchequipo">
                    <label><%out.println(po.getProperty("etiqueta.NPMOrden_PP"));%></label> 
                    <hr class="lineaazul">
                    <section class="subdiv1">
                        <label><%out.println(po.getProperty("etiqueta.NPMOrden_PP"));%></label><input  id="notor" type="text" maxlength="12" onkeypress="mostrarPP(event, this.value)" style="width:40%;"/><button id="match_N1" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NPMOperacion_PP"));%></label><input id="notope" type="text"  maxlength="4" style="width:40%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NPMSuboperacion_PP"));%></label><input id="notsop" type="text" maxlength="4" style="width:40%;" />
                        <hr>
                        <label>Cant. a fabricar</label><input id="cntFabricar" type="text" maxlength="8" style="width:30%;"/>
                        <hr>
                        <label>Cant. fabricada</label><input id="cntFabricada" type="text" maxlength="8" style="width: 30%;"/>
                        <hr>
                    </section>
                    <section class="subdiv2">
                        <label><%out.println(po.getProperty("etiqueta.NPMStatus_PP"));%></label><input id="notsta" style="width:80%; background:none; border:none;" type="text" readonly value=""/>
                    </section> 
                    <section class="subdiv3">
                        <button onclick="libbotPP()" > <img src="images/liberar.png"><span>Liberar</span></button>
                        <button onclick="canbotPP()" > <img src="images/cierretecnico.png"><span>Cierre Técnico</span></button>
                        <button  onclick="cciebotPP()"> <img src="images/cancelarcierre.png"><span>Can. Cierre Téc.</span></button>
                    </section>
                </div>

                <!--                <section class="divdatosgralEquipos">
                                    <label><%out.println(po.getProperty("etiqueta.NPMEquipo_PP"));%></label> 
                                    <hr class="lineaazul">
                                    <div class="div1gral">
                                        <label><%out.println(po.getProperty("etiqueta.NPMEquipo_PP"));%></label><input id="nteq" type="text" style=" width:35%;" disabled/><span style="margin-left: 5%;"><input id="nteqch" Style="vertical-align: middle" type="checkbox"  disabled/><label id="labme" style="color:#ABABA6;"><%out.println(po.getProperty("etiqueta.NPMEquipomontado_PP"));%></label></span>
                                        <hr> 
                                        <input id="ntdeseq" type="text" style=" width:55%; border:none;"   value="" readonly />
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.NPEqsuperior_PP"));%></label><input id="notesp"  type="text" disabled>
                                        <span style="margin-left: 5%;"> <button id="VisDoo" style="width: 35%;" disabled>Visualizar Documentos</button> </span>
                                        <hr> 
                                        <input id="notdesesp" type="text" style=" width:55%; border:none;" value="" readonly />
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.NPCentroalma_PP"));%></label><input id="notcent" type="text" disabled style="width: 15%;" /> / <input id="notalm" type="text" disabled style="width: 15%; " />
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.NPMMaterial_PP"));%></label><input id="notmat" type="text" disabled  style="width: 45%;"/>
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.NPMLote_PP"));%></label><input id="notlote" type="text" disabled  style="width: 20%;"/>
                                        <hr>
                                    </div>
                                    <div class="div2gral">
                                        <button  onclick="HorasT()" id="desmo" style="padding-right: -5%; width: 48%;"><img style="width:15%; " src="images/desmontar.png" ><%out.println(po.getProperty("etiqueta.NPMDesmontEnsa_PP"));%></button> 
                                        <button  onclick="monta()" id="desmo2" style="width:52%;"><img style="width:13.5%; " src="images/montar.png" ><%out.println(po.getProperty("etiqueta.NPMMontEnsa_PP"));%></button>
                
                                        <div id="table-scroll">
                                            <div id="fixedY">
                                                <table>
                                                    <thead style="font-size: 1.2em;">
                                                        <tr>
                                                            <td><%out.println(po.getProperty("etiqueta.NPMCaract_PP"));%></td>
                                                            <td><%out.println(po.getProperty("etiqueta.NPMValo_PP"));%></td>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                            <div id="cuerpoDatos">
                                                <div id="nofixedX">
                                                    <table>
                                                        <tbody style="font-size: 0.8em;">
                                                            <tr><td id="tdl1">&nbsp;</td><td id="tdr1">&nbsp;</td></tr>
                                                            <tr><td id="tdl2">&nbsp;</td><td id="tdr2">&nbsp;</td></tr>
                                                            <tr><td id="tdl3">&nbsp;</td><td id="tdr3">&nbsp;</td></tr>
                                                            <tr><td id="tdl4">&nbsp;</td><td id="tdr4">&nbsp;</td></tr>
                                                            <tr><td id="tdl5">&nbsp;</td><td id="tdr5">&nbsp;</td></tr>
                                                            <tr><td id="tdl6">&nbsp;</td><td id="tdr6">&nbsp;</td></tr>
                                                            <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                
                                            </div>
                                        </div>
                                    </div>
                                </section>-->
                <section class="tabdiv">
                    <div class="tablaSolicitud">
                        <section id="SecTab">                                     
                            <table class="TablaCont">
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td></td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMNF_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMOp_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMClave_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMPtotrb_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMCentro_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMDescripcionoperac_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMCantidad_PP"));%>&nbsp;&nbsp;&nbsp;</td>
<!--                                        <td><%out.println(po.getProperty("etiqueta.NPMCMU_PP"));%></td>-->
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMDuracion_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMNotdur_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMUMD_PP"));%>&nbsp;&nbsp;&nbsp;</td>
<!--                                        <td><%out.println(po.getProperty("etiqueta.NPMTrabajo_PP"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.NPMNottrab_PP"));%></td>-->
<!--                                        <td><%out.println(po.getProperty("etiqueta.NPMUMT_PP"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.NPMUMD_PP"));%></td>
                                        <td><%out.println(po.getProperty("etiqueta.NPMUMT_PP"));%></td>-->

                                    </tr>
                                </thead>
                                <tbody id="bodyc">

                                    <tr><td><input type="checkbox" class="che" id="checkbox"  name="checkbo" value="val1"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox1" name="checkbo" value="val2"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox2" name="checkbo" value="val3"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox3" name="checkbo" value="val4"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox4" name="checkbo" value="val5"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox5" name="checkbo" value="val6"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>
                                    <tr><td><input type="checkbox" class="che" id="checkbox6" name="checkbo" value="val7"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>

                                </tbody>

                            </table>
                        </section>  
                    </div>
                    <button id="btntab" onclick="selecoftabPP()"><img src="images/notificaroperacion.png"><%out.println(po.getProperty("etiqueta.NPMUMTNR_PP"));%></button><br><br>                   
                    <!--<button id="btntab2" onclick="cldCK()"><img src="images/notificaroperacion.png">N.R</button>-->                      
                    <p class="last1"></p>                   
                </section>

            </div>       
        </div>


        <div id="divpm13" hidden></div>
        <div id="divpm11" hidden></div>
        <div id="divqm11" hidden></div>

        <!--        <div id="VentanaModalCentroP" class="VentanaModal">
                    <div id="handle3"><label id="TituloMatch">Documentos</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaa('CentroP');"><label >X</label></div></div>
                    <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                    <div id="ConsultaTablaCentP">
                        <div class="tablaCab">
                            <div class="table-scroll" id="table-scrollCentroP">                             
                                <div>
                                    <section class="SecHead">
                                        <table id="TabHeadN">
                                            <thead>
                                                <tr>
                                                    <td>Apl.</td>
                                                    <td>Nombre</td> 
                                                    <td>Aplicación</td>                                                                                    
                                                    <td>Fichero</td>                                            
                                                </tr>
                                            </thead>
                                        </table>
                                    </section>
                                </div>
                                <div id="cuerpoDatos">
                                    <div class="nofixedX" id="cargarDatosCentroP">
                                    </div>
                                </div>                            
                            </div>
                        </div>
                    </div>
                </div>-->

        <div id="VentanaModal" class="VentanaModalCC">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMNumeroorden_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick= "retornaFiltroBus('BuscarParam_u1', 'ConsultaTabla1')">Ordenes PP</button><hr></div>
            <div id="BuscarParam_u1" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
<!--                        <label><%out.println(po.getProperty("etiqueta.CecosteMAV_PP"));%></label><input  id="env1vm"   type="text" style="width: 35%;"  onkeypress="enterMat(event)"  />
                        <hr>-->
                        <label><%out.println(po.getProperty("etiqueta.NPMOrden_PP"));%></label><input id="ordmatvm" aling="center" type="text" style="width: 35%;" onkeypress="enterMat(event)"/>
                        <hr> 
                        <label><%out.println(po.getProperty("etiqueta.NPMTextobreve_PP"));%></label><input type="text" id="txtbrvm" aling="center" style="width: 45%;" onkeypress="enterMat(event)"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NPMCantidadmaxaci_PP"));%></label><input type="text" maxlength="3"  id="env5vm" style="width: 10%;"/>

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar();"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal');"/>
                </div>
            </div>
            <div id="ConsultaTabla1" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedYM" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <!--<th><%out.println(po.getProperty("etiqueta.CecosteMAV_PP"));%></th>-->
                                        <th><%out.println(po.getProperty("etiqueta.NPMOrden_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTextobreve_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXM" id="nofixedX1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="ventatabdes" class="Ventabdes">
            <div id="handleDes"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMNotipmbques_PP"));%></label></div>
            <div class="Contentabdes">
                <section class="divtabdes">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMDatossolidecom_PP"));%></label> 
                    <hr class="lineaazul">
                    <div class="div1vtd">
                        <label><%out.println(po.getProperty("etiqueta.NPMNumerosolccompra_PP"));%></label>
                        <input type="text" style="width: 25%; margin-left: -10%" id="nspp31" disabled /><input type="text" id="npspp31" style="width:12%; margin-left: 2%;" disabled/>
                        <hr color="white" style="margin-top: -1px; width: 25%; margin-left: 10px;">
                        <label><%out.println(po.getProperty("etiqueta.NPMCtdoperacion_PP"));%></label>
                        <input type="text" style="width: 35%; margin-left: -35%" readonly/>
                        <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                        <label><%out.println(po.getProperty("etiqueta.NPMPrecio_PP"));%></label>
                        <input type="text" id="prep31" style="width: 18%; margin-left: -35%" readonly/>
                        <input type="text" id="clmop31" style="width: 8%; " readonly/>
                        <input type="text" value="por" style="width: 14%; " readonly/>
                        <input type="text" id="cabap31" style="width: 9%; " readonly/>
                        <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                    </div>

                    <div class="div2vtd">
                        <label><%out.println(po.getProperty("etiqueta.NPMGrupoarticulo_PP"));%></label>
                        <input type="text" id="grarp31" style="width: 20%; margin-left: -10%;" readonly/>
                        <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMClasecoste_PP"));%></label>
                        <input type="text" style="width: 13%; margin-left: -1%;" readonly/>
                        <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                        <hr style="margin-top: -10px; width: 20%; margin-left: 51%;">
                        <label ><%out.println(po.getProperty("etiqueta.NPMGrupoCompr_PP"));%></label>
                        <input type="text" id="gcate31" style="width: 10%; margin-left: -8%;" readonly/>/
                        <input type="text" id="ocop31" style="width: 10%; margin-left: -1%;" readonly/>
                        <label style="width:20%;margin-left: -1%;"><%out.println(po.getProperty("etiqueta.NPMAcreedor_PP"));%></label>
                        <input type="text" id="provp31" style="width: 13%; margin-left: -1%;" readonly/>
                        <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                        <hr style="margin-top: -10px; width: 20%; margin-left: 51%;">
                        <label><%out.println(po.getProperty("etiqueta.NPMSolicitante_PP"));%></label>
                        <input type="text" id="solp31" style="width: 20%; margin-left: -10%;" readonly/>
                        <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMRegistroinfo_PP"));%></label>
                        <input type="text" style="width: 13%; margin-left: -1%;" readonly/>
                        <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                        <hr style="margin-top: -10px; width: 20%; margin-left: 51%;">
                    </div> 
                </section>
                <section class="tab1">
                    <table class="TablaCont">
                        <thead>
                            <tr id="CabeceraTabla">
                                <td><%out.println(po.getProperty("etiqueta.NPMNoitem_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMNumserv_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMDescripcion_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCantidad_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMUMS_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMPrecio_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMPor_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMGrparticulos_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMClasecosto_PP"));%></td>

                            </tr>
                        </thead>
                        <tbody id="bpmt1">
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                        </tbody>

                    </table>
                </section>  
                <section class="tab1">
                    <table class="TablaCont">
                        <thead>
                            <tr id="CabeceraTabla">
                                <td><%out.println(po.getProperty("etiqueta.NPMPeriodo_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMITEM_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMBorrado_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMDescripcion_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCentro_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMAlm_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMNumpro_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMNombreprov_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCantidad_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMUMC_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMPrecio_PP"));%></td> 
                            </tr>
                        </thead>
                        <tbody id="bpmt2" >
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                        </tbody>

                    </table>
                </section> 
                <section class="tab1">
                    <table class="TablaCont">
                        <thead>
                            <tr id="CabeceraTabla">
                                <td><%out.println(po.getProperty("etiqueta.NPMPeriodo_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMPosP_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMEjerc_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMDoc_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMItemdoc_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMTipo_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMMov_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMFechacont_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCantidad_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMimporte_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMMoneda_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCreadopor_PP"));%></td>

                            </tr>
                        </thead>
                        <tbody id="bpmt3" >
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                        </tbody>

                    </table>
                </section>   

            </div>
            <div class="Botdes1">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cerraventabs('ventatabdes');"/>
                <img class="BtnMatchIcon" src="images/S_B_CANC.gif" onclick="cerraventabs('ventatabdes');"/>
            </div>  
        </div>

        <!--        <div id="ventaQM01" class="Ventabdes">
                    <div id="handleQm"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMLoteinspecord"));%></label></div>
                    <div class="vqm"> 
                        <div class="Contentabdes">
                            <section class="se1qm">
                                <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMCabecera"));%></label> 
                                <hr class="lineaazul">
                                <div class="se1qm1">
                                    <label><%out.println(po.getProperty("etiqueta.NPMOrden"));%></label>
                                    <input type="text" id="nuoqm11" style="width: 25%; margin-left: -40%;" readonly/>
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMTextobreve"));%></label>
                                    <input type="text" id="txbqm11" style="width: 18%; margin-left: 2%;" readonly/>
                                    <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <hr style="margin-top: -10px; width: 20%; margin-left: 56%;">
                                    <label><%out.println(po.getProperty("etiqueta.NPMLoteinsp"));%></label>
                                    <input type="text" id="nliqm11" style="width: 25%; margin-left: -40%;" readonly/>
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMCentro"));%></label>
                                    <input type="text" id="cenqm11" style="width: 18%; margin-left: 2%;" readonly/>
                                    <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <hr style="margin-top: -10px; width: 20%; margin-left: 56%;">
                                    <label><%out.println(po.getProperty("etiqueta.NPMCreadopor"));%></label>
                                    <input type="text" id="crdqm11" style="width: 25%; margin-left: -40%;" readonly/>
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMCreacionlote"));%></label>
                                    <input type="text" id="fclqm11" style="width: 18%; margin-left: 2%;" readonly/>
                                    <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <hr style="margin-top: -10px; width: 20%; margin-left: 56%;">
                                    <label><%out.println(po.getProperty("etiqueta.NPMModificadopor"));%></label>
                                    <input type="text" id="umrqm11" style="width: 25%; margin-left: -40%;" readonly/>
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMFechamodific"));%></label>
                                    <input type="text" id="fmrqm11" style="width: 18%; margin-left: 2%;" readonly/>
                                    <input type="text" id="opqm1" hidden />
                                    <hr style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <hr style="margin-top: -10px; width: 20%; margin-left: 56%;">
                                </div>
        
                                <div id="se1qm2">
                                    <br> <br> 
                                    <hr color="white" style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <hr color="white" style="margin-top: -1px; width: 25%; margin-left: 10px;">
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMHora"));%></label>
                                    <input type="text" id="hclqm11" style="width: 25%; margin-left: 2%;border: none;" readonly/>
                                    <hr style="margin-top: -1px; width: 18%; margin-left: 10px;">
                                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMHora"));%></label>
                                    <input type="text" id="hmlqm11" style="width: 25%; margin-left: 2%; border: none;" readonly/>
                                    <hr style="margin-top: -1px; width: 18%; margin-left: 10px;">
                                </div>
                            </section> 
                                                <section class="se2qm" >
                                                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMCarecteristicasinspe"));%></label> 
                                                    <hr class="lineaazul">
                                                    <div class="tab1">
                                                        <table class="TablaCont">
                                                            <thead>
                                                                <tr id="CabeceraTabla">
                                                                    <td><%out.println(po.getProperty("etiqueta.NPMCar"));%></td>
                                                                    <td><%out.println(po.getProperty("etiqueta.NPMTextobrevecarac"));%></td>
                                                                    <td><%out.println(po.getProperty("etiqueta.NPMUMe"));%></td>
                                                                    <td><%out.println(po.getProperty("etiqueta.NPMRegistr"));%></td>
                                                                    <td><%out.println(po.getProperty("etiqueta.NPMMuep"));%></td>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="tab1q1" >
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                            </tbody>
                            
                                                        </table>
                                                    </div>
                                                </section>  
                            <section class="se3qm" >
                                <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMNuevosres"));%></label> 
                                <hr class="lineaazul">
                                <div class="tab1">
                                    <table class="TablaCont">
                                        <thead>
                                            <tr id="CabeceraTabla">
                                                <td><%out.println(po.getProperty("etiqueta.NPMITEM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCarecteristicas"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                <td>Especif.</td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCualitativa"));%></td>
                                                <td>Inspeccionado</td>
                                                <td>Resultado</td>
                                                <td>Valoración</td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMGCodig"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMUMC"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMNota"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCatalog"));%></td>
        
                                            </tr>
                                        </thead>
                                        <tbody id="tab2q1" >
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        </tbody>
        
                                    </table>
                                    <button id="guaresqm01" style="margin-left:80%;"><img style="width: 13%;margin-left: -5%;" src="images/guares.png" />Grabar Resultados</button>
                                </div>
                            </section>   
                            <section class="se4qm" >
                                <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMCarecteristicasinspe"));%></label> 
                                <hr class="lineaazul">
                                <div class="tab1">
                                    <table class="TablaCont">
                                        <thead>
                                            <tr id="CabeceraTabla">
                                                <td><%out.println(po.getProperty("etiqueta.NPMNumcar"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMNumResultad"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCaracterisinspec"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCualitativa"));%></td>
                                                <td>Inspeccionado</td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMValororiginal"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMGCodig"));%></td>
                                                <td>Valoración</td>
                                                <td>Especif.</td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMTextobreve"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.NPMCreadopor"));%></td>
                                            </tr>
                                        </thead>
                                        <tbody id="tab4q1" >
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        </tbody>
        
                                    </table>
                                </div>
                            </section>                          
                        </div>
                        <div class="Botdes">
                            <div id="BotenAv2">
                                <img  src="images/HR_ok.png" style="margin-right:-4%;" onclick="cerraventabs('ventaQM01');"/>
                                <img  src="images/S_B_CANC.gif" onclick="cerraventabs('ventaQM01');"/>
                            </div> 
                        </div>
                    </div>                                
                </div>    -->
        <!--Ventana de Calidad-->
        <!--        <div id="VentanaModalCalidad" class="VentanaModalCld">
                    <div id="handle22"><label id="TituloMatch">Gestión lotes de inspección</label></div>
                    <br><div id="BuscarParamCalidada" class="BuscarParam_u">
                        <div class="fondo_MatchRG">
                            <div class="CldMov">
                                <label>Cabecera</label>
                                <hr class="lnMov">
                                <section class="bkCld" id="CldMov1">
                                    <label class="cldLeft">Orden</label>
                                    <label id="lblOrdCld">600000000003</label>
                                    <label id="lbloper" hidden></label>
                                    <hr>
                                    <label class="cldLeft">Lote insp.</label>
                                    <label id="lblLoteICld">Lote XXXX</label>
                                    <hr style="visibility:hidden;">
                                    <label class="cldLeft">Creado por</label>
                                    <label id="lblCreadoCld">Bonieq XXXX</label>
                                    <hr>
                                    <label class="cldLeft">Modificado por</label>
                                    <label id="lblModificadoCld">BonieqG</label>
                                    <hr>
                                </section>
                                <section class="bkCld2" id="CldMov2">
                                    <label class="cldLeft2">Texto breve</label>
                                    <label id="lblTxtCld">600000000003ssssssssssss</label>
                                    <hr>
                                    <section class="bkCld" id="CldMov3">
                                        <label class="cldLeft">Centro</label>
                                        <label id="lblCtrCld">BAJA</label>
                                        <hr style="visibility:hidden;">
                                        <label class="cldLeft">Creación lote</label>
                                        <label id="lblFchCCld" hidden>25.07.2017</label>
                                        <label id="lblFchCCld3"></label>
                                        <hr>
                                        <label class="cldLeft">Fecha modific.</label>
                                        <label id="lblFchMCld" hidden>26.07.2017</label>
                                        <label id="lblFchMCld3"></label>
                                        <hr>
                                    </section>
                                    <section class="bkCld" id="CldMov4">
                                        <label class="cldLeft3">Hora</label>
                                        <label id="lblHrCld">20:00:00</label>
                                        <hr>
                                        <label class="cldLeft3">Hora</label>
                                        <label id="lblHr2Cld">21:00:00</label>
                                        <label style="margin-left: 5%;">Inspector</label>
                                        <label id="lblUsrCld" style="margin-left: 4%;">DESARROLLO</label>                                
                                        <hr>
                                    </section>
                                </section>
        
                            </div>
                            <br>
                            <div class="CldMov">
                                <label>Nuevos resultados</label>
                                <hr class="lnMov">
                                <section class="DobleScroll" id="DobleSection">
                                    <section id="DobleContainer"></section>
                                </section>
                                <section class="TableContainer">
                                    <section class="SecHead">
                                        <table id="TabHead2">
                                            <thead>
                                                <tr>
                                                    <td>Pos.</td>
                                                    <td>Característica</td>
                                                    <td>Especif.</td>
                                                    <td hidden></td>
                                                    <td hidden></td>
                                                    <td hidden></td>
                                                    <td hidden></td>
                                                    <td hidden></td>
                                                    <td hidden>Cualitativa</td>
                                                    <td hidden>Renglon</td>
                                                    <td>A Inspeccionar</td>
                                                    <td>Inspeccionado</td>
                                                    <td>Resultado</td>
                                                    <td>UMC</td>
                                                    <td>Código</td>
                                                    <td></td>
                                                    <td>Valoración</td>
                                                    <td>Nota</td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </thead>
                                        </table>
                                    </section>
                                    <section class="SecBody" id="SecCuerpoCld">
        
                                    </section>
                                </section>
                                <button class="btnCalidad" id="btnGrabarR" type="submit">Grabar Resultados</button>
                            </div>
                            <br>
                            <div class="PanelBnt"><button id="btnDE1">&nbsp;Decisión Empleo 1&nbsp;&nbsp;</button><button id="btnDE2">&nbsp;Decisión Empleo 2&nbsp;&nbsp;</button><hr></div>
                            <div class="CldMov" id="pnlDE1">
                                <label>Decisión de empleo</label>
                                <hr class="lnMov">
                                <section id="CldMov6">
                                    <label class="cldLeft4">Equipo</label>
                                    <label class="cldLeft5" id="lblTxtEQ"></label>
                                    <hr>
                                    <label class="cldLeft4">Código DE</label>
                                    <input type="text" style="text-transform: uppercase;" maxlength="10" class="bxsmall" id="bxCod00" onfocus="CodBtnShow('00')">
                                    <button name="cld10" id="btnCod00" class='BtnMatchIcon' width="100%" onclick="matchInspCod('00', 'DE-01', '')"></button>
                                    <input type="text" style="text-transform: uppercase;" maxlength="10" class="bxsmall" id="bxCodn" readonly>
                                    <label class="cldLeft5" id="lblTxtDE"></label>
                                    <hr>
                                </section>
                            </div>
                            <div class="CldMov" id="pnlDE2" hidden>
                                <label>Decisión de empleo</label>
                                <hr class="lnMov">
                                <section id="CldMov6">
                                    <label class="cldLeft4">Código DE</label>
                                    <input type="text" style="text-transform: uppercase;" maxlength="10" class="bxsmall" id="bxCod002" onfocus="CodBtnShow('002')">
                                    <button name="cld10" id="btnCod002" class='BtnMatchIcon' width="100%" onclick="matchInspCod('002', 'DE-01', '')"></button>
                                    <input type="text" style="text-transform: uppercase;" maxlength="10" class="bxsmall" id="bxCodnn2" readonly>
                                    <label class="cldLeft5" id="lblTxtDE2"></label>
                                    <button id="btCod30" class='BtnMatchIconDescri' width="100%" onclick="MatchTexto('0')"></button>
                                    <textarea style="resize:none;" id="Textlib0" hidden></textarea>
                                    <hr>
                                </section>
                            </div>
                            <br>
                        </div>
                        <div class="Botones_Match">
                            <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; " id="okCalidad"/>
                            <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="margin-right:-4%; " onclick="cerraventabs('VentanaModalCalidad');" id="btnCancelCld"/>
                        </div>
                    </div>
                </div><br><br><br>-->
        <div id="VentanaModalTexto" class="VentanaModal">
            <div id="handle27"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMTxtLibree_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalTexto', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.NPMTxtLibree_PP"));%></button><hr></div>
            <div id="BuscarParamTexto" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NPMTxtLibree_PP"));%></label><input type="text" id="bxTextoL" style="width:30%;" hidden=""/>
                        <label><%out.println(po.getProperty("etiqueta.NPMTxtLibree_PP"));%></label><input type="text" id="bxTextoLNota" style="width:30%;" hidden=""/>
                        <textarea style="resize:none;" id="Textlib" class="txtArL"></textarea>
                    </div>        
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okTexto"/>              
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okTexto2"/>              
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('VentanaModalTexto', '');"/>
                </div>
            </div>
        </div>
        <!--        <div id="VentanaModalCalidad2" class="VentanaModalCld">
                    <div id="handle23"><label id="TituloMatch">Gestión lotes de inspección</label></div>
                    <br><div id="BuscarParamCalidad" class="BuscarParam_u">
                        <div class="fondo_MatchRG">
                            <div class="CldMov">
                                <label>Cabecera</label>
                                <hr class="lnMov">
                                <section class="bkCld" id="CldMov1n">
                                    <label class="cldLeft">Orden</label>
                                    <label id="lblOrdCld2">600000000003</label>
                                    <label id="lbloper2" hidden></label>
                                    <hr>
                                    <label class="cldLeft">Lote insp.</label>
                                    <label id="lblLoteICld2">Lote XXXX</label>
                                    <hr style="visibility:hidden;">
                                    <label class="cldLeft">Creado por</label>
                                    <label id="lblCreadoCld2">Bonieq XXXX</label>
                                    <hr>
                                    <label class="cldLeft">Modificado por</label>
                                    <label id="lblModificadoCld2">BonieqG</label>
                                    <hr>
                                </section>
                                <section class="bkCld2" id="CldMov2n">
                                    <label class="cldLeft2">Texto breve</label>
                                    <label id="lblTxtCld2">600000000003ssssssssssss</label>
                                    <hr>
                                    <section class="bkCld" id="CldMov3n">
                                        <label class="cldLeft">Centro</label>
                                        <label id="lblCtrCld2">BAJA</label>
                                        <hr style="visibility:hidden;">
                                        <label class="cldLeft">Creación lote</label>
                                        <label id="lblFchCCld2">25.07.2017</label>
                                        <hr>
                                        <label class="cldLeft">Fecha modific.</label>
                                        <label id="lblFchMCld2">26.07.2017</label>
                                        <hr>
                                    </section>
                                    <section class="bkCld" id="CldMov4n">
                                        <label class="cldLeft3">Hora</label>
                                        <label id="lblHrCld2">20:00:00</label>
                                        <hr>
                                        <label class="cldLeft3">Hora</label>
                                        <label id="lblHr2Cld2">21:00:00</label>
                                        <label style="margin-left: 5%;">Inspector</label>
                                        <label id="lblUsrCld2" style="margin-left: 4%;">DESARROLLO</label>
                                        <hr>
                                    </section>
                                </section>
                                
                            </div>
                            <br>
                            <div class="CldMov">
                                <label>Nuevos resultados</label>
                                <hr class="lnMov">
                                <section class="DobleScroll" id="DobleSection2">
                                    <section id="DobleContainer2"></section>
                                </section>
                                <section class="TableContainer">
                                    <section class="SecHead">
                                        <table id="TabHead">
                                            <thead>
                                                <tr>
                                                    <td>Pos.</td>
                                                    <td>Característica</td>
                                                    <td>Especif.</td>
                                                    <td hidden>Cualitativa</td>
                                                    <td hidden>Renglon</td>
                                                    <td>A Inspeccionar</td>
                                                    <td>Inspeccionado</td>
                                                    <td>Resultado</td>
                                                    <td>UMC</td>
                                                    <td>Código</td>
                                                    <td></td>
                                                    <td>Valoración</td>
                                                    <td>Nota</td>
                                                    <td></td>
                                                </tr>
                                            </thead>
                                        </table>
                                    </section>
                                    <section class="SecBody" id="SecCuerpoCld2">
        
                                    </section>
                                </section>
        
                                <button class="btnCalidad" id="btnGrabarR2" type="submit">Grabar Resultados</button>
                            </div>
                            <br>
                        </div>
                        <div class="Botones_Match">
                            <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCalidad2"/>
                            <img  src="images/S_B_CANC.gif" id="btnCancelCld2" onclick="cerraventabs('VentanaModalCalidad2');"/>
                        </div>
                    </div> 
                </div><br><br><br>-->
        <div id="VentanaModalInspCod" class="VentanaModal">
            <div id="handle24"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalInspCod', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <section class="dataCab">
                <!--<label>Catálogo: </label><label id="catInsCod"></label>-->
                <label><%out.println(po.getProperty("etiqueta.NPMCnjSelect_PP"));%> </label><label id="conjInsCod"></label>
                <br>
                <label><%out.println(po.getProperty("etiqueta.NPMGpoCdgos_PP"));%> </label><label id="gpoCodInsCod"></label>
            </section>
            <div id="ConsultaTablaClsInf">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClsInf">
                        <div class="fixedY" id="fixedYPClsInf">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.NPMCdgo_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTxtBRevPCod_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXCLD" id="cargarDatosInspCod">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAv" class="VentanaModalAv">
            <div id="handleAV"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMAdventMsg_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalAv', 'bxPedido');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv"></label>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAv"/>
                </div>
            </div>
        </div>
        <div id="VentanaModalForzar" class="VentanaModalFr">
            <div id="handleAV1"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMValoracionManual_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalForzar', '');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <label>Caract.</label>
                    <label id="lblCar" style="margin-left:4%; "></label>
                    <label id="lbltxb" style="margin-left:4%; "></label>
                    <label id="lblpos" style="margin-left:4%; " hidden></label><br><br>
                    <div class="CldMovFr">
                        <label>Opte por</label>
                        <hr class="lnMov">
                        <section class="bkCld" id="CldMov5">
                            <input type="radio" name="forzar" value="A" checked> Aceptar<br>
                            <input type="radio" name="forzar" value="R"> Rechazar<br>
                        </section>
                    </div>
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFr"/>
                </div>
            </div>
        </div>
        <div id="ventaPM01" class="Ventabdes" style="margin-top: 20px;">
            <div id="handlePM01"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMNotificacionoperor_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ventaPM01', '');"><label >X</label></div></div>
            <div class="Contentabdes">
                <section class="ve1pm">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMDatosoper_PP"));%></label> 
                    <hr class="lineaazul">
                    <label style="width:20%; margin-left: 2%;"><%out.println(po.getProperty("etiqueta.NPMOrdenoperacion_PP"));%></label>
                    <input type="text" style="width: 15%; margin-left: 2%;" id="nspp11" disabled/>  
                    <input type="text" style="width: 5%; margin-left: 1%;" id="npspp11" disabled/>
                    <hr style="margin-top: -1px; width: 15%; margin-left: 10px;">
                    <input type="text" style="width: 35%; margin-left: 1%; border:none; " id="txbp11" readonly/>
                    <hr style="margin-top: -1px; width: 15%; margin-left: 10px;">
                    <div class="ve1pm1">
                        <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMCantidad"));%></label>
                        <input type="text" id="canbap11" style="width: 45%; margin-left: 21%;" disabled/>  
                        <input type="text" id="umpp11" style="width: 5%; margin-left: 2%;" disabled/> 
                        <hr style="margin-top: -1px; width: 33%; margin-left: 10px;">
                        <input type="checkbox" id="ivptp11"  style="margin-left: 45%;" disabled/>
                        <label style="width:20%; margin-left: -1%;"><%out.println(po.getProperty("etiqueta.NPMNotificacifinal_PP"));%></label>

                    </div>

                    <div class="ve1pm2">
                        <div class="ve1pm21">
                            <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMTiempoplante_PP"));%></label> 
                            <hr class="lineaazul">
                            <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMDuracion_PP"));%></label>
                            <input type="text" id="donp11" style="width: 25%; margin-left: 2%;border: none;" readonly/> 
                            <input type="text" id="udnp11" style="width: 25%; margin-left: 2%;border: none;" readonly/> 
                            <hr style="margin-top: -1px; width: 28%; margin-left: 7px;">
                            <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMTrabajo_PP"));%></label>
                            <input type="text" id="top11" style="width: 25%; margin-left: 6%; border: none;" readonly/> 
                            <input type="text" id="utp11" style="width: 25%; margin-left: 2%; border: none;" readonly/> 
                            <hr style="margin-top: -1px; width: 28%; margin-left: 7px;">
                        </div>

                        <div class="ve1pm22">
                            <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMNotificadmomen_PP"));%></label> 
                            <hr class="lineaazul">
                            <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMDuracion_PP"));%></label>
                            <input type="text" id="aynp11" style="width: 25%; margin-left: 2%;border: none;" readonly/> 
                            <input type="text" id="" style="width: 25%; margin-left: 2%;border: none;" readonly/> 
                            <hr style="margin-top: -1px; width: 28%; margin-left: 7px;">
                            <label style="width:20%; margin-left: 3%;"><%out.println(po.getProperty("etiqueta.NPMTrabajo_PP"));%></label>
                            <input type="text" id="aynp21" style="width: 25%; margin-left: 6%; border: none;" readonly/> 
                            <input type="text" id="" style="width: 25%; margin-left: 2%; border: none;" readonly/> 
                            <hr style="margin-top: -1px; width: 28%; margin-left: 7px;">
                        </div>
                    </div>   
                </section>

                <section class="ve2pm">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMNotificacitiem_PP"));%></label> 
                    <hr class="lineaazul">
                    <label style="width:20%; margin-left: 1%;"><%out.println(po.getProperty("etiqueta.NPMDuracionReal_PP"));%></label>
                    <input id="durp1" type="text" style="width: 7%; margin-left: 2%; background: no-repeat" />
                    <select id="durp2" style="margin-left: 2%;">
                        <option value="H">H</option>
                        <option value="MIN">MIN</option>
                    </select>
                    <label style="width:20%; margin-left: 5%;"><%out.println(po.getProperty("etiqueta.NPMNotanotific_PP"));%></label>
                    <input id="nofip1" type="text" style="width: 37%; margin-left: 4%; " />
                    <hr color="white" style="margin-top: -1px; width: 13%; margin-left: 9px;">
                    <label style="width:20%; margin-left: 1%;">No. personal</label>
                    <input id="trrep1" type="text" style="width: 10%; margin-left:3%;" onclick="mostbotmatus()"/><button id="match_Nope" class='BtnMatchIcon2'></button>
                    <input type="checkbox" id="nfpm1" style="margin-left: 7%;" />
                    <label style="width:20%; margin-left: -1%;"><%out.println(po.getProperty("etiqueta.NPMNotificacifinal_PP"));%></label>
                    <button onclick="valNotTiemPP01()" id="nttiem" style="margin-left: 10%; width: 20%; height: -5%"><img style="width: 13%;margin-left: -5%;" src="images/guarda.PNG" /><label style="margin-right:20%; "> <%out.println(po.getProperty("etiqueta.NPMNotifictiem"));%></label></button>
                    <hr color="white" style="margin-top: -1px; width: 13%; margin-left: 9px;">
                </section> 

                <section class="tab2">
                    <table class="TablaCont">
                        <thead>
                            <tr id="CabeceraTabla">
                                <td></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMReserva_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMPos_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMMaterial_PP"));%>&nbsp;&nbsp;&nbsp;</td>
                                <td><%out.println(po.getProperty("etiqueta.NPMLotee_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCantCons_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCantidaNeces_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCanttomada_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMCentro_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMUMB_PP"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.NPMAlmacen_PP"));%></td>
                                <!--<td><%out.println(po.getProperty("etiqueta.NPMTextobrvmat_PP"));%></td>-->
                                <td><%out.println(po.getProperty("etiqueta.NPMTextoBreveDelMaterial_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

                            </tr>
                        </thead>
                        <tbody id="tabp1">
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>

                        </tbody>

                    </table>

                </section>
            </div>
            <div class="Botpm">
                <button onclick="ListaMateriales()" ><img style="height:15px;" src="images/hoja.PNG" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMListOfMateriales_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                <button style="" onclick="ConsMaterial();" > <img style="height:15px;" src="images/cosma2.png" /> <%out.println(po.getProperty("etiqueta.NPMConsumoMate_PP"));%></button>
                <!--Nope<button onclick="LlamarFunc();" style="height:20px;"> <img src="images/palomal.png" style="margin-left: -5%; margin-right:5%;" /><%out.println(po.getProperty("etiqueta.NPMNotificaOper_PP"));%></button>-->
                <!--<button onclick="LlamarFunc();" ><img height="15" width="16"  src="images/palomal.png" /><%out.println(po.getProperty("etiqueta.NPMNotificaOper"));%></button>-->
                <button onclick="cerraventabs('ventaPM01')" ><img  src="images/S_B_CANC.gif" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMFinaliproce_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                <!--<button><img  src="images/S_B_CHCK.gif" onclick=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMValidar_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>-->
            </div> 
        </div>
        <div id="VentanaModalListaMat" class="VentanaModalLM">
            <div id="handle23"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMListOfMateriales_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalListaMat', '');"><label >X</label></div></div>
            <br><div id="BuscarParamListM" class="BuscarParam_u">
                <div class="fondo_MatchRGLM">
                    <div class="CldMov">
                        <section class="DobleScroll" id="DobleSection3">
                            <section id="DobleContainer3"></section>
                        </section>
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead3">
                                    <thead>
                                        <tr>
                                            <td></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMMaterialess_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMPzaFrabicant_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMDescript_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMLoteeee_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMStok_PP"));%></td>
                                            <td hidden><%out.println(po.getProperty("etiqueta.NPMCntrooo_PP"));%></td>
                                            <td hidden><%out.println(po.getProperty("etiqueta.NPMAlmacen_PP"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMUCC_PP"));%></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo3">

                            </section>
                        </section>
                    </div>
                    <br>
                </div>
                <div class="Botones_MatchLM">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; " id="okLMNC"/>
                    <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="margin-right:-4%; " onclick="cerraventabs('VentanaModalListaMat');"/>
                </div>
            </div>
        </div><br><br><br>
        <div id="VentanaModalHoras" class="VentanaModalH">
            <div id="handle25"><label id="TituloMatch"></label></div>
            <br><div id="BuscarParamListH" class="BuscarParam_u">
                <div class="fondo_MatchH">
                    <div class="CldMovH">
                        <label class="cldLeft6"><%out.println(po.getProperty("etiqueta.NPHorasTrab_PP"));%></label>
                        <input id="bxHT" type="text" style="text-transform: uppercase;" maxlength="10" class="bxH" onkeypress="return valida(event)">
                        <hr>
                    </div>
                    <br>
                </div>
                <div class="Botones_MatchLM">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; " id="okHoras"/>
                    <img class="BtnMatchIcon" src="images/S_B_CANC.gif" style="margin-right:-4%; " id="cnlHrs"/>
                </div>
            </div>
        </div><br><br><br>
        <div id="ventanaavis" class="VenAvisoss">
            <div id="handleAv2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMInformacion_PP"));%></label><div class="BotonCerrar_Matc" onclick="cerravisos();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_B_HINT.gif"  ALT="Info"></div>
            <div class="ContenidoAv">
                <br>
                <label id="etav"><%out.println(po.getProperty("etiqueta.NPMAvisoPant_PP"));%></label>
            </div>
            <div class="BotenAv">
                <button id="FinalizarSIDoc" onclick="cerravisos()"><img src="images/palomal.png"/> </button>

            </div>
        </div> 

        <div id="ventanaavis2" class="VenAvisoss">
            <div id="handleAv3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NOTSTfincab_PP"));%></label><div class="BotonCerrar_Matc" onclick="cerravisos2();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
            <div class="ContenidoAv">
                <br>
                <label id="etav2"><%out.println(po.getProperty("etiqueta.NPMOperacnconestatusinal"));%></label>
            </div>
            <div class="BotenAv">
                <button id="FinalizarSIDoc" onclick="selecoftab2()"><img src="images/palomal.png"/> </button>
                <button id="FinalizarSIDoc" onclick="cerravisos2()"><img src="images/S_B_CANC.gif"/> </button>
            </div>
        </div> 

        <!--        <div id="ventanaavis2" class="VenAvisoss">
                    <div id="handleAv3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NOTSTfincab"));%></label><div class="BotonCerrar_Matc" onclick="cerravisos();"><label >X</label></div></div>
                    <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
                    <div class="ContenidoAv">
                        <br>
                        <label id="etav2"><%out.println(po.getProperty("etiqueta.NPMOperacnconestatusinal"));%></label>
                    </div>
                    <div class="BotenAv">
                        <button id="FinalizarSIDoc" onclick="selecoftab2()"><img src="images/palomal.png"/> </button>
                        <button id="FinalizarSIDoc" onclick="cerravisos2()"><img src="images/S_B_CANC.gif"/> </button>
        
                    </div>
                </div> -->

        <div id="VentModalmat" class="VentanaModalCC">
            <div id="handle11"><label id="TituloMatch">Número de material</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentModalmat');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick= "retornaFiltroBus('BuscarParam_u2', 'ConsultaTabla2')">Número/Texo breve del material</button><hr></div>
            <div id="BuscarParam_u2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NPMMaterial_PP"));%></label><input id="mmmat"  type="text" style="width: 15%;" maxlength="40" onkeypress="MandarMat(event)" />
                        <input id="mmid" aling="center" type="text" style="width: 15%; margin-left:16px; margin-top:2%;" hidden/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NPMTextobreve_PP"));%></label><input type="text" id="mmtxtbr" maxlength="40" style="width: 45%;" onkeypress="MandarMat(event)"/>
                        <hr>
                        <!--                        Tipo de material-->
                        <label><%out.println(po.getProperty("etiqueta.NPMTpoMatr_PP"));%></label><input type="text" id="mmtipMatt" maxlength="4" style="width: 45%;" onkeypress="MandarMat(event)"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NPMCantidadmaxaci_PP"));%></label><input type="text"  maxlength="3" id="env5vmat"  style="width: 10%;" value="500"/>
                    </div>       
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="LoadMaters('peticionMatMatNotPM');"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentModalmat');"/>
                </div>
            </div>
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll">
                    <div class="fixedYM" id="fixedY">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMMaterial_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMAlmacen_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTxtoBrevbe_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTipo_o_PP"));%></th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="cuerpoDatos">
                        <div class="nofixedXM" id="nofixedX2">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="VentanaModalLote" class="VentanaModal">
        <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMCpnsLotes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalLote')"><label >X</label></div></div>
        <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.NPMLlotes_PP"));%></button><hr></div>
        <div id="BuscarParam_GrupoP" class="BuscarParam_u" style="display: none">
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.NPMGrupoplanif_PP"));%></label><input type="text" id="GrupoPMatch_CA" style="width:20%;"  focus/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.NPMCentroPlanificador_PP"));%></label><input type="text" id="CentroPMatch_CA" style="width:15%;"/>
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
        <div id="ConsultaTabla6" >
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll6">
                    <div class="fixedY" id="fixedY6">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMLlote_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMSttockLU_PP"));%></th>
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



    <div id="VentanaModalValora" class="VentanaModal">
        <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMValorResInspection_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalValora')"><label >X</label></div></div>
        <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restricciones_PP"));%></button><hr></div>
        <div id="ConsultaTabla9" >
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll21">
                    <div class="fixedY" id="fixedY9">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMDescripBreve_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTVal_PP"));%></th>
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

    <div id="VentanaModalCodig" class="VentanaModal">
        <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMCodigoo_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalCodig')"><label >X</label></div></div>
        <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restricciones_PP"));%></button><hr></div>
        <div id="ConsultaTabla10" >
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll21">
                    <div class="fixedY" id="fixedY10">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMCod_PP"));%></th><th><%out.println(po.getProperty("etiqueta.NPMTxtBrevPCodig_PP"));%></th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="cuerpoDatos">
                        <div class="nofixedX" id="cargarDatos10">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 


    <div id="VentanaModalUSU" class="VentanaModal">
        <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMNoPersonall_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalUSU')"><label >X</label></div></div>
        <div class="PanelBntMatch"><button onclick= "retornaFiltroBus('BuscarParam_GrupoPu', 'ConsultaTabla7')"><%out.println(po.getProperty("etiqueta.NPMNoPersonall_PP"));%></button><hr></div>
        <div id="BuscarParam_GrupoPu" class="BuscarParam_u" >
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.NPMNoPersonall_PP"));%></label><input type="text" id="NOpernot" style="width:20%;"  focus/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.NPMName_PP"));%></label><input type="text" id="Nombrepezzz" style="width:20%;"  />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax7no" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                    <hr>
                </div>        
            </div> 
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ConsultaUSU();"/>
                <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('grupop');"/>
            </div>
        </div>
        <div id="ConsultaTabla7" style="display: none" >
            <div class="tablaCab">
                <div class="table-scroll" id="table-scrollusua">
                    <div class="fixedY" id="fixedYsuarr">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMNoPersonall_PP"));%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th><%out.println(po.getProperty("etiqueta.NPMName_PP"));%></th>
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



    <div id="VenMontEq" class="VenMontEq">
        <div name="handleEQ"  id="handleEQ"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NOTSTfincab_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VenMontEq');"><label >X</label></div></div>
        <label><%out.println(po.getProperty("etiqueta.NPMEquipo_PP"));%></label> 
        <hr class="lineaazul2">  
        <div class="div1gralEQ">
            <label><%out.println(po.getProperty("etiqueta.NPMEquipo_PP"));%></label><input id="nteq2" type="text" style=" width:35%;" disabled/><span style="margin-left: 5%;"></span>
            <hr> 
            <input id="ntdeseq2" type="text" style=" width:55%; border:none;"   value="" readonly />
            <hr>
            <label><%out.println(po.getProperty("etiqueta.NPEqsuperior_PP"));%></label><input id="notesp2"  type="text" disabled>
            <hr> 
            <input id="notdesesp2" type="text" style=" width:55%; border:none;" value="" readonly />
            <hr>
            <label><%out.println(po.getProperty("etiqueta.NPCentroalma_PP"));%></label><input id="notcent2" type="text" disabled style="width: 8%;" /> / <input id="notalm2" type="text" disabled style="width: 8%; " />
            <hr>
            <label><%out.println(po.getProperty("etiqueta.NPMMaterial_PP"));%></label><input id="notmat2" type="text" disabled  style="width: 45%;"/>
            <hr>
            <label><%out.println(po.getProperty("etiqueta.NPMLote_PP"));%></label><input id="notlote2" type="text" disabled  style="width: 20%;"/> <input id="notlote22" type="text"  style=" margin-left:5px; width: 20%;"/><button id="match_N22" class='BtnMatchIcon2'></button>
            <hr>
        </div>
        <div class="BotMONTEQ">
            <button id="FinalizarSIDoc" onclick="Statmonta()"><img src="images/palomal.png"/> </button>
            <button id="FinalizarSIDoc" onclick="ocultarVentana('VenMontEq');"><img src="images/S_B_CANC.gif"/> </button>

        </div>
    </div> 


    <div id="VentanaModalLoteEQ" class="VentanaModal">  
        <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMCpnsLotes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalLoteEQ')"><label >X</label></div></div>
        <div class="PanelBntMatch"><button>Lotes</button><hr></div>
        <div id="BuscarParam_GrupoP" class="BuscarParam_u" style="display: none">
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.NPMGrupoplanif_PP"));%></label><input type="text" id="GrupoPMatch_CA" style="width:20%;"  focus/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.NPMCentroPlanificador_PP"));%></label><input type="text" id="CentroPMatch_CA" style="width:15%;"/>
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
        <div id="ConsultaTabla6" >
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll6">
                    <div class="fixedY" id="fixedY6">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMLlotes_PP"));%></th>
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

    <!--    <div id="VentanaModalMsgAddFile" class="VentanaModalAv"> 
            <div id="handleFile"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMAdventMsg_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalMsgAddFile', 'bxPedido');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv">¿Desea agregar archivos?</label>
                    <button id='addFile' onclick="AbrirVentanaAddFile();" >sí</button><button id='btnCancelar' onclick="OcultarMensajeFile('VentanaModalMsgAddFile');">no</button>
                </div>
            </div>
        </div>
        <div id="VentanaModalAddFile" class="VentanaModalFiles">
            <div id="handleFileAdd"><label id="TituloMatch">Agregar Archivos</label></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <section id="TablaStatus" class="TablaStatusC">
                    <section id="SecTabPpal">
                        <form action="GuardarArchivo" name="FormCreateC" method="POST" enctype="multipart/form-data" id="FormCreateC">
    
                            <table class="TablaCont" id="table12">
                                <input type="file" onchange="DatosArchivos();" name="file" id="archivos" >
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;Nombre del archivo&nbsp;</td>
                                        <td>&nbsp;Tipo&nbsp;</td>
                                        <td>&nbsp;Tamaño&nbsp;</td>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </section>
            </div>
            <div class="Botones_MatchFile">
                <input type="button" value="Cancelar" class="cancDatAdj"  onclick="OcultarMensajeFile('VentanaModalAddFile');"/>
                <img class="BtnMatchIcon" src="images/DELETEADD.PNG" style="margin-right:-4%; cursor:pointer;" id="EliminarArchivo" onclick="DeleteFile();"/>
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFiles" onclick="uploadFiles();"/>
            </div>
        </div>       -->

    <!--    <div id="VentanaModalMsgAddFileT" class="VentanaModalAv">
            <div id="handleFileT"><label id="TituloMatch">Advertencia</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaT('VentanaModalMsgAddFileT');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv">¿Desea agregar archivos?</label>
                    <button id='addFile' onclick="AbrirVentanaAddFileT('VentanaModalAddFileT', 'handleFileAddT', 'VentanaModalMsgAddFileT');" >sí</button><button id='btnCancelar' onclick="OcultarMensajeFile('VentanaModalMsgAddFileT');">no</button>
                </div>
            </div>
        </div>
        <div id="VentanaModalAddFileT" class="VentanaModalFiles">
            <div id="handleFileAddT"><label id="TituloMatch">Agregar Archivos</label></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <section id="TablaStatus" class="TablaStatusC">
                    <section id="SecTabPpal">
                        <form action="GuardarArchivo" name="FormCreateT" method="POST" enctype="multipart/form-data" id="FormCreateT">
    
                            <table class="TablaCont" id="table12T">
                                <input type="file" onchange="DatosArchivosT('table12T', 'archivosT');" name="fileT[]" id="archivosT" >
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;Nombre del archivo&nbsp;</td>
                                        <td>&nbsp;Tipo&nbsp;</td>
                                        <td>&nbsp;Tamaño&nbsp;</td>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </section>
            </div>
            <div class="Botones_MatchFile">
                <input type="button" value="Cancelar" class="cancDatAdj"  onclick="OcultarMensajeFile('VentanaModalAddFileT');"/>
                <img class="BtnMatchIcon" src="images/DELETEADD.PNG" style="margin-right:-4%; cursor:pointer;" id="EliminarArchivo" onclick="DeleteFileT('table12T');"/>
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFilesT" onclick="uploadFilesT();"/>
            </div>
        </div>     -->

    <!--    <div id="VentanaModalMsgAddFileCalidad" class="VentanaModalAv">
            <div id="handleFileCalidad"><label id="TituloMatch">Advertencia</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaT('VentanaModalMsgAddFileCalidad');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv">¿Desea agregar archivos?</label>
                    <button id='addFile' onclick="AbrirVentanaAddFileCalidad('VentanaModalAddFileCalidad', 'handle21', 'VentanaModalMsgAddFileCalidad');" >sí</button><button id='btnCancelar' onclick="OcultarMensajeFile('VentanaModalMsgAddFileCalidad');">no</button>
                </div>
            </div>
        </div>
        <div id="VentanaModalAddFileCalidad" class="VentanaModalFiles">
            <div id="handle21"><label id="TituloMatch">Agregar Archivos</label></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <section id="TablaStatus" class="TablaStatusC">
                    <section id="SecTabPpal">
                        <form action="GuardarArchivosCalidad" name="FormCreateCali" method="POST" enctype="multipart/form-data" id="FormCreate">
    
                            <table class="TablaCont" id="tableCalidad">
                                <input type="file" onchange="DatosArchivosCalidad();" name="fileCali" id="archivosCalidad" >
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;Nombre del archivo&nbsp;</td>
                                        <td>&nbsp;Tipo&nbsp;</td>
                                        <td>&nbsp;Tamaño&nbsp;</td>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </section>
            </div>
            <div class="Botones_MatchFile">
                <input type="button" value="Cancelar" class="cancDatAdj"  onclick="OcultarMensajeFile('VentanaModalAddFileCalidad');"/>
                <img class="BtnMatchIcon" src="images/DELETEADD.PNG" style="margin-right:-4%; cursor:pointer;" id="EliminarArchivoCalidad" onclick="DeleteFileCalidad();"/>
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFilesCalidad" onclick="uploadFilesCalidad();"/>
            </div>
        </div>-->
    <!--    <div id="VentUbTecAvvv" class="VentanaModalAvvv">
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
        </div>          -->
    <%
        htmlResponse = html.imprimirTablaCabLotInsp();
        out.println(htmlResponse);
        htmlResponse = html.imprimirTablaPosLotInsp();
        out.println(htmlResponse);

    %>
    <footer>
        <hr class="fecha" id="footerline" />
        <div hidden>
            <input type="text" id="fenot"/>
            <input type="text" id="clidi" value="<%=Idioma%>"/>
            <input type="text" id="honot"/>
            <input type="text" id="usua"/>
            <input type="text" id="lotI"/>
        </div> 
        <div  class="fecha">
            <label id="fecha" name="fecha"></label><label>, </label> 
            <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
            <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
            <script type="text/javascript">
                var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                var meses2 = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
                var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                var f = new Date();
                var idioma = "<%=Idioma%>";
                if (idioma == "ES") {
                    var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                    var mes = meses2[f.getMonth()];
                    var dia = f.getDate();
                    if (dia <= 9) {
                        dita = "0" + dia;
                    } else {
                        dita = dia;
                    }
                    //alert(mes + "-" + dia);
                    if (mes <= 9) {
                        mesito = mes;
                    } else {
                        mesito = mes;
                    }
                    var fnoti = f.getFullYear() + "-" + mesito + "-" + dita;
                    document.getElementById('fecha').innerHTML = fechaActual;
                    document.getElementById("fenot").value = fnoti;
                } else if (idioma == "EN") {
                    var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                    var mes = meses2[f.getMonth()];
                    var dia = f.getDate();
                    if (dia <= 9) {
                        dita = "0" + dia;
                    } else {
                        dita = dia;
                    }
                    //alert(mes + "-" + dia);
                    if (mes <= 9) {
                        mesito = mes;
                    } else {
                        mesito = mes;
                    }
                    var fnoti = f.getFullYear() + "-" + mesito + "-" + dita;
                    document.getElementById('fecha').innerHTML = fechaActual;
                    document.getElementById("fenot").value = fnoti;
                } else {
                    var fechaActual = "Fecha indefinida";
                }
            </script>
            <script type="text/javascript">

                window.onload = function () {
//                    startTime();
                    CArgarMne();
                    bloq();
                    $("#usua").val("<%=Nombre%>");
                    validaUsuarioVis();
                };
                function CArgarMne() {
                    var mensajOk = '<%=orn%>';
                    if (mensajOk != 'null') {
                        $("#notor").val(mensajOk);
                        $("#bt").val(mensajOk);
                        mostrar1();
                    } else {
                        //borramsg();  
                    }

                }
                function bloq() {
                    $("#iconmsg").css("visibility", "hidden");
                    $("#guardar").prop("disabled", true);
                }
                function invall() {
                    msgMatch("invv");
                    $("#iconmsg").css("visibility", "visible");
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    $('#iconmsg').show();
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                }

            </script>
        </div>
        <script>
            function validaUsuarioVis() {
                var acc = "validaUsuarioVis";
                var usr = "<%=Nombre%>";
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
    </footer>
</body>
<script>
    function cerravisos() {
        $("#etav").html("<%=NPMAvisoPant%>");
        $("#ventanaavis").css("display", "none");
    }
    function mensajess(me, im) {
        var men = "";
        switch (me) {
            case 0:
                men = "<%=Noex%>";
                break;
            case 1:
                men = "<%=MonReall%>";
                break;
        }
        $("#iconmsg").css("visibility", "visible");
        $("#iconmsg").attr("src", im);
        $("#msg").html(men);
    }
    var usuario = '<%=Nombre%>';
</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>
