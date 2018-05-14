<%-- 
    Document   : MonitorStatus
    Created on : 9/06/2016, 04:45:41 PM
    Author     : AREConsulting
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String NoRangoen = po.getProperty("etiqueta.NoenctrRangoEq");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
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
                var pag = p.charAt(82);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleMonitor.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/MonitorStatus.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><% out.println(po.getProperty("etiqueta.Titulo_MS"));%></title>       
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
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloModulo_MS"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentMonitor">
                <div class="MonitorSect1">
                    <label><% out.println(po.getProperty("etiqueta.Ejecucion"));%></label>
                    <hr class="LineasMonitor">   
                    <div class="monitrdiv1">
                        <input id="rbt1" type="radio" name="Ejecucion" value="Ubicacion" checked> <label><% out.println(po.getProperty("etiqueta.Ubicacion_MS")); %></label><br>
                        <input type="radio" name="Ejecucion" value="Equipo"> <label><% out.println(po.getProperty("etiqueta.Equipo_MS"));%></label><br>   
                    </div>
                </div>  
                <div class="parametroBus">
                    <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Parametro_MS"));%></label>
                    <hr class="LineasMonitor">
                    <div class="subparametoBu">
                        <label><% out.println(po.getProperty("etiqueta.Plani_MS"));%></label><input id="Ctro" maxlength="4" type="text" style="width: 15%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="btnmat1" class='BtnMatchIcon'></button>
                        <hr>
                        <label><% out.println(po.getProperty("etiqueta.PtoTbjoRes_LO"));%></label><input id="PtoTjo" maxlength="10" type="text" style="width: 15%; background-repeat: no-repeat; text-transform: uppercase;"/><button id="btnpto" class='BtnMatchIcon'></button>
                        <hr>
                        <label><% out.println(po.getProperty("etiqueta.Ubi_MS"));%></label><input id="Ubic" maxlength="30" type="text" style="width: 35%; text-transform: uppercase;"/><button id="btnmat2" class='BtnMatchIcon'></button>
                        <hr>
                        <label><% out.println(po.getProperty("etiqueta.Equi_MS"));%></label><input id="Eqpo" maxlength="18" type="text" style="width: 20%; text-transform: uppercase;" disabled/><button id="btnmat3" class='BtnMatchIcon'></button> <samp>a</samp> <input id="Eqpo31" maxlength="18" type="text" style="width: 20%; text-transform: uppercase;" disabled/><button id="btnmat31" class='BtnMatchIcon'></button>
                        <hr>
                        <input hidden id="Idioma" value="<%=Idioma%>"/>
                    </div>
                </div> 
                <div class="divmodovis">
                    <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Visual_MS")); %></label>
                    <hr class="LineasMonitor">
                    <input type="radio" name="Visualizacion" value="Medidas" checked> <label><% out.println(po.getProperty("etiqueta.Medidas_MS")); %></label><br>
                    <input type="radio" name="Visualizacion" value="Mantenimiento"> <label><% out.println(po.getProperty("etiqueta.Mante_MS"));%></label>    
                </div>
                <div class="divmensajes">
                    <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Msj_MS")); %></label>
                    <hr class="LineasMonitor">
                    <input type="radio" name="Mensaje" value="Alerta"> <label><% out.println(po.getProperty("etiqueta.Alert_MS")); %></label><br>
                    <input type="radio" name="Mensaje" value="Advertencia"> <label><% out.println(po.getProperty("etiqueta.Adver_MS")); %></label><br>
                    <input type="radio" name="Mensaje" value="NoAdvertencia"> <label><% out.println(po.getProperty("etiqueta.NoAdver_MS")); %></label><br>
                    <input type="radio" name="Mensaje" value="NoContador"> <label><% out.println(po.getProperty("etiqueta.NoCont_MS")); %></label><br>
                    <input type="radio" name="Mensaje" value="Todos" checked> <label><% out.println(po.getProperty("etiqueta.Todo_MS"));%></label>
                </div>
            </div>

        </div>       
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Centro');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="vemoce"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamCentro_SP" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Centro_CC"));%></label><input type="text" id="BusCentro" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></label><input type="text" id="BusDesCentro" style="width:35%;"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax" maxlength="3" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCentro"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Centro');"/>
                </div>
            </div>
            <div id="ConsultaTablaCentro" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatoCentro">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalUbiTecn" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Ubicacion');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="vemoubt" ><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></button><hr></div>
            <div id="BuscarParamUbi" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></label><input type="text" id="ubictBus" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></label><input type="text" id="DesUbiBus" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3" id="numAcMax2"  style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbic"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('Ubicacion');"/>
                </div>
            </div>
            <div id="ConsultaTablaubitec" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbitec">
                        <div class="fixedY" id="fixedYUbitec">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUbitec">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalEquipo" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Equipo');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="vemoequ"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamEquipo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralEquipo"));%></label><input type="text" id="equBus" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" id="denEqBus" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax3" style="width:10%;" maxlength="3"/>
                        <hr>
                        <input type="text" id="idEQ" hidden />
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('Equipo');"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo">
                        <div class="fixedY" id="fixedYEquipo">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralEquipo"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosEquipo">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPuesto" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PuestoTrabjotiumaLO"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Puesto');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retrpuesto"><%out.println(po.getProperty("etiqueta.puestpTrabj_LO"));%></button><hr></div>
            <div id="BuscarParamPt" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.puestpTrabj_LO"));%></label><input type="text" id="puestp" style="width:35%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PTDescripcio"));%></label><input type="text" id="Ptexto_mate" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax6"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPuesto"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Puesto');" />
                </div>
            </div>
            <div id="ConsultaTablaPuesto" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuesto">
                        <div class="fixedY" id="fixedYPuesto">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestpTrabj_LO"));%></th><th><%out.println(po.getProperty("etiqueta.PTDescripcio"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosPuesto">
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
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        $(document).ready(function () {
            $("#rbt").attr('checked', true);
        });

        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {

            //error
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();

            var funinva = '<%=funcioninv%>';
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
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

        function mensajess(m, au, im) {
            var ms = "";
            switch (m) {
                case 0:
                    ms = '<%=CampoOb%>';
                    break;
                case 1:
                    ms = '<%=NoRangoen%>';
                    break
                case 2:
                    ms = 'Puesto de trabajo no valido';
                    break
            }
            var BE = document.createElement('audio');
            BE.src = au;
            BE.play();
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", im);
            $("#msg").html(ms);
        }

    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
