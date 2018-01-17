<%-- 
    Document   : VisualizarClientes
    Created on : 22/06/2016, 01:31:26 PM
    Author     : AREConsulting
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
        String Mens = po.getProperty("etiqueta.CompObligatorios");
        String reso = po.getProperty("etiqueta.Resolucio");
        String MenInval = po.getProperty("etiqueta.FuncionInval_Menu");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
        String ClientNo = po.getProperty("etiqueta.NoConsulta_clie");
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
                var pag = p.charAt(53);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleClientes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarClientes.js"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloVisualizacCliente"));%></title>           
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
            <input id="aceptar" type="image" src="images/aceptar.png" onclick="validar();"/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>               
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>     
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloVisualizacCliente"));%></h1></div> 
        </div>
        <div class="contenido">
            <section class="VisualProveedor_pro" id='VisualProveedor_pro'>
                <section class="ParametrosBusqueda_pro">
                    <label><%out.println(po.getProperty("etiqueta.ParametroBusqueda_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="SectionComp_pro">
                        <label><%out.println(po.getProperty("etiqueta.Cliente_clie"));%></label><input maxlength="20" type="text"  style="background-repeat: no-repeat; background-position-x: -2%;"  id="Cliente_C"  style="width: 15%;"/><button id="match_C1" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Sociedad_pro"));%></label><input maxlength="4" type="text" id="Sociedad_C" style="width:8%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/><button id="match_C2" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.OrgVenta_cli"));%></label><input maxlength="4" type="text" id="OrgVentas_C" style="width:8%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/><button id="match_C3"  class='BtnMatchIcon2'></button><label style="margin-left: 2%;"><%out.println(po.getProperty("etiqueta.CanalDist_cli"));%></label><input maxlength="2" type='text' id="CanalDist_C" style=" width:5%; margin-left: -4%; background-repeat: no-repeat; background-position-x: -2%;" /><button id="match_C4" class='BtnMatchIcon'></button><label style="margin-left: 1%;"><%out.println(po.getProperty("etiqueta.Sector_clie"));%></label><input maxlength="2" type='text' id="Sector_C" style="width:5%; margin-left: -8%; background-repeat: no-repeat; background-position-x: -2%;" /><button id="match_C5" class='BtnMatchIcon'></button>
                        <hr>
                    </section>                       
                </section>
                <section class="Direccion_pro">
                    <label><%out.println(po.getProperty("etiqueta.Direccion_pro"));%></label>
                    <hr id="LineatituloPro">
                    <div class="nombresProved">
                        <label><%out.println(po.getProperty("etiqueta.Nombre_pro"));%></label><input id="nombre_CL" value="" style="width:30%;" type="text" disabled>
                        <hr>
                    </div>
                    <div class="nombres2Proved">
                        <input type="text" style="width:45%; border:none;" id="nombre1_cli" readonly/> <input type="text" style="width:45%; border:none;" id="nombre2_cli" readonly/>
                        <input type="text" style="width:45%; border:none;" id="nombre3_cli" readonly/> <input type="text" style="width:45%; border:none;" id="nombre4_cli" readonly/>
                    </div>
                    <div class="DirecIzq_pro">
                        <label><%out.println(po.getProperty("etiqueta.Poblacion_pro"));%></label><input style="width:35%;" id="poblacion_Cl" value="" type="text" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ResidenciaAt_pro"));%></label><input style="width:35%;" id="residencia_Cl" value="" type="text" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Calle_pro"));%></label><input style="width:60%;" id="calle_Cl" value="" type="text" disabled/>
                        <hr>
                    </div>
                    <div class="DirecDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.Distrito_pro"));%></label><input style="width:60%;" id="distrito_Cl" value="" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumEdificio_pro"));%></label><input style="width:20%;" id="edificio_Cl" value="" type="text" disabled>
                        <hr>
                    </div>
                </section>
                <section class="DatosSociedad_pro">
                    <label><%out.println(po.getProperty("etiqueta.DatosSocie_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="DatosSoIzq_pro">
                        <label><%out.println(po.getProperty("etiqueta.NumIndFiscal"));%></label><input type="text" id="nif_Cl" value="" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ConPago_pro"));%></label><input type="text" id="CondPago_Cl" value="" style="width:15%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.IndABC_pro"));%></label><input type="text" id="ABC_Cl" value="" style="width:6%;" disabled/>
                        <hr>
                    </section>
                    <section class="DatosSoDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.GrupoCuenta_pro"));%></label><input type="text" id="GpoCuenta_Cl" value="" style="width:18%;"disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CuentaAsoc_pro"));%></label><input type="text" id="CtaAsoc_Cl" value="" disabled>
                        <hr>
                    </section>
                </section>
                <section class="Compras_pro">
                    <label><%out.println(po.getProperty("etiqueta.Ventas_Clie"));%></label>
                    <hr id="LineatituloPro">
                    <section class="DatosSoIzq_pro">
                        <label><%out.println(po.getProperty("etiqueta.MonedaPedido_pro"));%></label><input type="text" id="mon_Cl" value="" style="width:15%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Iconterm_pro"));%></label><input type="text" style="width:8%;" id="incoP1_Cl" value="" disabled/> <input type="text" id="incoP2_Cl" value="" style="width:40%;" disabled/>
                        <hr>
                    </section>
                    <section class="DatosSoDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.GrupoCompras_pro"));%></label><input type="text" id="GpoComp_Cl" value="" style="width:20%;" disabled>
                        <hr>
                    </section>
                </section>
                <section class="BloqueoBorrado_pro">
                    <label><%out.println(po.getProperty("etiqueta.BloqueoBorado_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="SectionComp_pro">
                        <span>
                            <input id="nivelSoc_Cli" type="checkbox" disabled><%out.println(po.getProperty("etiqueta.PetiBorSoc_pro"));%>
                            <br>
                            <input id="bloConta_Cli" type="checkbox" disabled><%out.println(po.getProperty("etiqueta.BloqContPSoc_pro"));%>
                            <br>
                            <input id="petBorCo_Cli" type="checkbox" disabled><%out.println(po.getProperty("etiqueta.PeBorrado_pro"));%>
                        </span>
                    </section>   
                </section>
            </section>
        </div>
        <div id="VentanaModalCliente" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('cliente');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltrocliente"><%out.println(po.getProperty("etiqueta.DeudorGral_MatchCL"));%></button><hr></div>
            <div id="BuscarParam_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Cliente_clie"));%></label><input type="text" id="Clien_CliBus" maxlength="20" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Nom_MatchCL"));%></label><input type="text" id="nomCl_CliBus" maxlength="40" style="width:35%;"/>
                        <hr>                          
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCliente"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('cliente');"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Cliente_clie"));%></th><th><%out.println(po.getProperty("etiqueta.Nom_MatchCL"));%></th>
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

        <div id="VentanaModalSociedad" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sociedad');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornsocc"><%out.println(po.getProperty("etiqueta.DeudorGral_MatchCL"));%></button><hr></div>
            <div id="BuscarParamSoc_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Socied_CL"));%></label><input type="text" id="Soc_CLbus"  maxlength="4" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denonsoc_CL"));%></label><input type="text" id="nomSoc_CLBus"  maxlength="25" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Poblas0c_CL"));%></label><input type="text" id="PoblaciSoc_CLBus"  maxlength="25" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ClvMonSoc_CL"));%></label><input type="text" id="ClvMone_CLBus"  maxlength="5" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax2"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="OkSociedad"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('sociedad');"/>
                </div>
            </div>
            <div id="ConsultaTabla2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll2">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Socied_CL"));%></th><th><%out.println(po.getProperty("etiqueta.Denonsoc_CL"));%></th><th><%out.println(po.getProperty("etiqueta.ClvMonSoc_CL"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalOrgVentas" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ventas')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retonarfiltrovent"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_OV" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.OrganiVentas_CL"));%></label><input type="text" id="OrgaVen_CL" style="width:35%; text-transform: uppercase;"  maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></label><input type="text" id="Denom_CL" style="width:35%;" maxlength="20"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax3" style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okOrga"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('ventas');"/>
                </div>
            </div>
            <div id="ConsultaTabla3" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll3">
                        <div class="fixedY" id="fixedY3">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.OrganiVentas_CL"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    
        <div id="VentanaModalCanalDist" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('canal')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornarcanalin"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_Can" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CanalDis_CL"));%></label><input type="text" id="CanalD_CL" style="width:35%;"  maxlength="2"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></label><input type="text" id="DenomCanal_CL" style="width:35%;" maxlength="20"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax4"   style="width:10%;"  maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okCanal"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('canal');"/>
                </div>
            </div>
            <div id="ConsultaTabla4" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll4">
                        <div class="fixedY" id="fixedY4">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CanalDis_CL"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
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
        <div id="VentanaModalSector" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sector')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornarfiltrosec"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_Sec" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Sector_clie"));%></label><input type="text" id="Sector_CL" style="width:35%;" maxlength="2"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></label><input type="text" id="DenomSecto_CL" style="width:35%;" maxlength="20"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax5"   style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSector"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('sector');"/>
                </div>
            </div>
            <div id="ConsultaTabla5" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll5">
                        <div class="fixedY" id="fixedY5">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Sector_clie"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
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
                <script type="text/javascript">
                    function startTime() {
                        today = new Date();
                        n = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        h = checkTime(n);
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
                        startTime();
                        bloq();
                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                        document.getElementById('guardar').disabled = true;
                    }

                </script>
            </div>
        </footer>
    </body>
    <script>
        function inval() {
            //error
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = "<%=MenInval%>";
        }
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function validar() {
            var cl = document.getElementById("Cliente_C").value;
            var soc = document.getElementById("Sociedad_C").value;
            var OrgV = document.getElementById("OrgVentas_C").value;
            var CnlD = document.getElementById("CanalDist_C").value;
            var Sect = document.getElementById("Sector_C").value;
            if (cl.length < 1 || soc.length < 1 || OrgV.length < 1 || CnlD.length < 1 || Sect.length < 1)
            {

                var mensj = '<%=Mens%>';
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = mensj;
                dataFocus();
            } else
            {
                enviarDatos(cl, soc, OrgV, CnlD, Sect);
            }
        }

        function dataFocus() {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();


            var temp = new Array();
            temp[0] = document.getElementById("Cliente_C");
            temp[1] = document.getElementById("Sociedad_C");
            temp[2] = document.getElementById("OrgVentas_C");
            temp[3] = document.getElementById("CanalDist_C");
            temp[4] = document.getElementById("Sector_C");


            for (i = 0; i < temp.length; i++)
            {
                if (temp[i].value.length === 0)
                {
                    temp[i].focus();
                    return;
                }
            }
        }

        function enviarDatos(cli, soc, org, can, sec) {
            var url = "peticionModuloVisualizarClientes";
            var acc = "CargarCliente";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    if (rs == 0) {
                        limpiar();
                        var BE = document.createElement('audio');
                        BE.src = "audio/saperror.wav";
                        BE.play();
                        var okcon = "<%=ClientNo%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    } else {
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        cargar(rs);
                        var okcon = "<%=OKconsul%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.png";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&cli=" + cli + "&sociedad=" + soc + "&org=" + org + "&canal=" + can + "&sector=" + sec, true);
            xmlhttp.send();

        }
        function  cargar(rs) {
            var a = new Array();
            a = rs.split(",");
            document.getElementById("nombre1_cli").value = a[0];
            document.getElementById("nombre2_cli").value = a[1];
            document.getElementById("nombre3_cli").value = a[2];
            document.getElementById("nombre4_cli").value = a[3];
            document.getElementById("poblacion_Cl").value = a[4];
            document.getElementById("residencia_Cl").value = a[5];
            document.getElementById("calle_Cl").value = a[6];
            document.getElementById("distrito_Cl").value = a[7];
            document.getElementById("edificio_Cl").value = a[8];
            document.getElementById("nif_Cl").value = a[9];
            document.getElementById("CondPago_Cl").value = a[10];
            document.getElementById("ABC_Cl").value = a[11];
            document.getElementById("GpoCuenta_Cl").value = a[12];
            document.getElementById("CtaAsoc_Cl").value = a[13];
            document.getElementById("mon_Cl").value = a[14];
            document.getElementById("incoP1_Cl").value = a[15];
            document.getElementById("incoP2_Cl").value = a[16];
            document.getElementById("GpoComp_Cl").value = a[17];
            document.getElementById("nivelSoc_Cli").checked = Verificarchecks(a[18]);
            document.getElementById("bloConta_Cli").checked = Verificarchecks(a[19]);
            document.getElementById("petBorCo_Cli").checked = Verificarchecks(a[20]);

        }
        function Verificarchecks(valor) {
            if (valor == "x" || valor == "X") {
                return true;
            } else {
                return false;
            }
        }
        function mostrarVentanaModal(tipo)
        {
            switch (tipo) {
                case 'cliente':
                    var ventana = document.getElementById('VentanaModalCliente');
                    abrirVentana(ventana);
                    var txtcli = document.getElementById('Clien_CliBus');
                    document.getElementById('nomCl_CliBus').value = '';
                    document.getElementById('numAcMax').value = '500';
                    txtcli.focus();
                    txtcli.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case'sociedad':
                    var ventana = document.getElementById('VentanaModalSociedad');
                    abrirVentana(ventana);
                    var txtsoc = document.getElementById('Soc_CLbus');
                    document.getElementById('nomSoc_CLBus').value = '';
                    document.getElementById('PoblaciSoc_CLBus').value = '';
                    document.getElementById('ClvMone_CLBus').value = '';
                    document.getElementById('numAcMax2').value = '500';
                    txtsoc.focus();
                    txtsoc.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case 'ventas':
                    var ventana3 = document.getElementById('VentanaModalOrgVentas');
                    abrirVentana(ventana3);
                    var txtorg = document.getElementById('OrgaVen_CL');
                    document.getElementById('Denom_CL').value = '';
                    document.getElementById('numAcMax3').value = '500';
                    txtorg.focus();
                    txtorg.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case 'canal':
                    var ventana4 = document.getElementById("VentanaModalCanalDist");
                    abrirVentana(ventana4);
                    var txtcanal = document.getElementById('CanalD_CL');
                    document.getElementById('DenomCanal_CL').value = '';
                    document.getElementById('numAcMax4').value = '500';
                    txtcanal.focus();
                    txtcanal.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case 'sector':
                    var ventana5 = document.getElementById("VentanaModalSector");
                    abrirVentana(ventana5);
                    var txtsector = document.getElementById('Sector_CL');
                    document.getElementById('Sector_CL').value = '';
                    document.getElementById('numAcMax5').value = '500';
                    txtsector.focus();
                    txtsector.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";

            }

        }
        function abrirVentana(ventana) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            var ancho = 350;
            var alto = 650;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
        }

        function ocultarVentana(tipo)
        {
            $('#overlay').remove();
            switch (tipo) {
                case "cliente":
                    var ventana = document.getElementById('VentanaModalCliente');
                    ventana.style.display = 'none';
                    document.getElementById("BuscarParam_u").style.display = "block";
                    document.getElementById("ConsultaTabla").style.display = "none";
                    document.getElementById("Cliente_C").focus();
                    break;
                case 'sociedad':
                    var ventana2 = document.getElementById('VentanaModalSociedad');
                    ventana2.style.display = 'none';
                    document.getElementById("BuscarParamSoc_u").style.display = "block";
                    document.getElementById("ConsultaTabla2").style.display = "none";
                    document.getElementById("Sociedad_C").focus();
                    break;
                case 'ventas':
                    var ventana3 = document.getElementById('VentanaModalOrgVentas');
                    ventana3.style.display = 'none';
                    document.getElementById("BuscarParam_OV").style.display = "block";
                    document.getElementById("ConsultaTabla3").style.display = "none";
                    document.getElementById("OrgVentas_C").focus();
                    break;
                case 'canal':
                    document.getElementById('VentanaModalCanalDist').style.display = "none";
                    document.getElementById("BuscarParam_Can").style.display = "block";
                    document.getElementById("ConsultaTabla4").style.display = "none";
                    document.getElementById("CanalDist_C").focus();
                    break;
                case 'sector':
                    document.getElementById('VentanaModalSector').style.display = "none";
                    document.getElementById("BuscarParam_Sec").style.display = "block";
                    document.getElementById("ConsultaTabla5").style.display = "none";
                    document.getElementById("Sector_C").focus();
                    break;
                default:
                    break;
            }

        }
        function ErrorBusquedaMatch() {
            //MEnsaje de correcto
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();


            var okcon = "<%=menValores%>";
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = okcon;
        }
        function borramsg() {
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "hidden";
            var men = document.getElementById("msg");
            men.innerHTML = "";
        }
        function ConsultaCliente() {
            var url = "peticionModuloVisualizarClientes";
            var acc = "ConsultarMatchCliente";
            var nom = document.getElementById('nomCl_CliBus').value;
            var cli = document.getElementById('Clien_CliBus').value;
            var ctd = document.getElementById('numAcMax').value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();

                    } else {
                        document.getElementById("BuscarParam_u").style.display = "none";
                        document.getElementById("ConsultaTabla").style.display = "block";
                        document.getElementById("cargarDatos1").innerHTML = rs;
                        fnc();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&nom=" + nom + "&cli=" + cli + "&ctd=" + ctd, true);
            xmlhttp.send();
        }
        function ConsultaSociedad() {
            var url = "peticionModuloVisualizarClientes";
            var acc = "ConsultaMatchSociedad";
            var idioma = '<%=Idioma%>';
            var cliente = document.getElementById("Cliente_C").value;
            var sociedad = document.getElementById('Soc_CLbus').value;
            var nombresoc = document.getElementById('nomSoc_CLBus').value;
            var poblacion = document.getElementById('PoblaciSoc_CLBus').value;
            var moneda = document.getElementById('ClvMone_CLBus').value;
            var ctd = document.getElementById('numAcMax2').value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {

                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamSoc_u").style.display = "none";
                        document.getElementById("ConsultaTabla2").style.display = "block";
                        document.getElementById("cargarDatos2").innerHTML = rs;
                        fnc2();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&cli=" + cliente + "&sociedad=" + sociedad + "&NomSociedad=" + nombresoc + "&poblacion=" + poblacion + "&moneda=" + moneda + "&ctd=" + ctd + "&idioma=" + idioma, true);
            xmlhttp.send();
        }
        function ConsultaOrgVentas() {
            var url = "peticionModuloVisualizarClientes";
            var acc = "ConsultarMatchOrgVentas";
            var cliente = document.getElementById("Cliente_C").value;
            var orgv = document.getElementById('OrgaVen_CL').value;
            var den = document.getElementById('Denom_CL').value;
            var ctd = document.getElementById('numAcMax3').value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParam_OV").style.display = "none";
                        document.getElementById("ConsultaTabla3").style.display = "block";
                        document.getElementById("cargarDatos3").innerHTML = rs;
                        fnc3();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&cli=" + cliente + "&org=" + orgv + "&den=" + den + "&ctd=" + ctd, true);
            xmlhttp.send();
        }
        function ConsultaCnalDis() {
            var lan = '<%=Idioma%>';
            var url = "peticionModuloVisualizarClientes";
            var acc = "ConsultarMatchCanal";
            var cliente = document.getElementById("Cliente_C").value;
            var orgaven = document.getElementById("OrgVentas_C").value;
            var Canal = document.getElementById('CanalD_CL').value;
            var denCanal = document.getElementById('DenomCanal_CL').value;
            var ctd = document.getElementById('numAcMax4').value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParam_Can").style.display = "none";
                        document.getElementById("ConsultaTabla4").style.display = "block";
                        document.getElementById("cargarDatos4").innerHTML = rs;
                        fnc4();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&cli=" + cliente + "&Organiz=" + orgaven + "&canal=" + Canal + "&denC=" + denCanal + "&ctd=" + ctd + "&idioma=" + lan, true);
            xmlhttp.send();
        }
        function ConsultaSector() {
            var idioma = '<%=Idioma%>';
            var url = "peticionModuloVisualizarClientes";
            var acc = "ConsultarMatchSector";
            var cliente = document.getElementById("Cliente_C").value;
            var Sector = document.getElementById('Sector_CL').value;
            var denoSect = document.getElementById('DenomSecto_CL').value;
            var ctd = document.getElementById('numAcMax5').value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParam_Sec").style.display = "none";
                        document.getElementById("ConsultaTabla5").style.display = "block";
                        document.getElementById("cargarDatos5").innerHTML = rs;
                        fnc5();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&cli=" + cliente + "&sector=" + Sector + "&denSe=" + denoSect + "&ctd=" + ctd + "&idioma=" + idioma, true);
            xmlhttp.send();
        }
        function seleccionar(obj, tipo) {
            switch (tipo) {
                case 'cliente':
                    var c = document.getElementById("Cliente_C");
                    c.focus();
                    c.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'sociedad':
                    var soc = document.getElementById("Sociedad_C");
                    soc.focus();
                    soc.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'ventas':
                    var o = document.getElementById("OrgVentas_C");
                    o.focus();
                    o.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'canal':
                    var ca = document.getElementById('CanalDist_C');
                    ca.focus();
                    ca.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'sector':
                    var se = document.getElementById('Sector_C');
                    se.focus();
                    se.value = obj;
                    ocultarVentana(tipo);
                    break;
                default:
                    break;
            }
        }
        function fnc() {
            document.getElementById('table-scroll').onscroll = function () {
                document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
            };
        }
        function fnc2() {
            document.getElementById('table-scroll2').onscroll = function () {
                document.getElementById('fixedY2').style.top = document.getElementById('table-scroll2').scrollTop + 'px';
            };
        }
        function fnc3() {
            document.getElementById('table-scroll3').onscroll = function () {
                document.getElementById('fixedY3').style.top = document.getElementById('table-scroll3').scrollTop + 'px';
            };
        }
        function fnc4() {
            document.getElementById('table-scroll4').onscroll = function () {
                document.getElementById('fixedY4').style.top = document.getElementById('table-scroll4').scrollTop + 'px';
            };
        }
        function fnc5() {
            document.getElementById('table-scroll5').onscroll = function () {
                document.getElementById('fixedY5').style.top = document.getElementById('table-scroll5').scrollTop + 'px';
            };
        }
        function limpiar() {

            document.getElementById("nombre1_cli").value = "";
            document.getElementById("nombre2_cli").value = "";
            document.getElementById("nombre3_cli").value = "";
            document.getElementById("nombre4_cli").value = "";
            document.getElementById("poblacion_Cl").value = "";
            document.getElementById("residencia_Cl").value = "";
            document.getElementById("calle_Cl").value = "";
            document.getElementById("distrito_Cl").value = "";
            document.getElementById("edificio_Cl").value = "";
            document.getElementById("nif_Cl").value = "";
            document.getElementById("CondPago_Cl").value = "";
            document.getElementById("ABC_Cl").value = "";
            document.getElementById("GpoCuenta_Cl").value = "";
            document.getElementById("CtaAsoc_Cl").value = "";
            document.getElementById("mon_Cl").value = "";
            document.getElementById("incoP1_Cl").value = "";
            document.getElementById("incoP2_Cl").value = "";
            document.getElementById("GpoComp_Cl").value = "";
            document.getElementById("nivelSoc_Cli").checked = false;
            document.getElementById("bloConta_Cli").checked = false;
            document.getElementById("petBorCo_Cli").checked = false;
            document.getElementById("Cliente_C").value = "";
            document.getElementById("Sociedad_C").value = "";
            document.getElementById("OrgVentas_C").value = "";
            document.getElementById('CanalDist_C').value = "";
            document.getElementById('Sector_C').value = "";
            document.getElementById("nombre1_cli").focus();
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>

