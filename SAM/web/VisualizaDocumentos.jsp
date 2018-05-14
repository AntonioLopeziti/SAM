<%-- 
    Document   : VisualizaDocumentos
    Created on : 8/12/2016, 09:41:04 AM
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
                var pag = p.charAt(101);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            
            
            function msgMatch(mn, im, au, val){
                var m = "";
                switch (mn) {
                    case 0:
                        m = "Campo equipo obligatorio";
                        break;  
                    case 1:
                        m = "Campo ubicación técnica obligatorio";
                        break;
                    case 3:
                        m = "No hay archivos por mostrar";
                        break;
                    case 4:
                        m = "Campo ubicación técnica obligatorio";
                        break;
                    case 5:
                        m= "Campo Avisos de Mantenimiento obligatorio";
                        break;
                    case 6:
                        m = "Campo Aviso de Calidad obligatorio";
                        break;
                    case 7:
                        m = "Campo Lote de Inspección obligatorio";
                        break;
                    case 8:
                        m = "Campo Clase de Documento obligatorio";
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#msg').html(m);
                $("#iconmsg").css("visibility", "visible");
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', im);
                
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleVisualiza.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizaDocs.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.DOCADJV_Title"));%></title>       
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
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.DOCADJV_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="divmensajes">
                <label class="LbMonitor"><%out.println(po.getProperty("etiqueta.ParametrosBus_USU"));%></label>
                <div class="container">
                    <hr class="LineasMonitor">
                    <input id="rbEquipo" type="radio" name="Busqueda" value="Equipos" checked=""> <label><%out.println(po.getProperty("etiqueta.DOCADEquipo"));%></label>
                    <input type="text" class="bxmiddles" id="bxEquipo" style="text-transform: uppercase;"/>
                    <button id="btnEquipo" class='BtnMatchIcon'></button>
                    <br><br>
                    <input id="rbUbic" type="radio" name="Busqueda" value="Ubicaciones"> <label>Ubicación Técnica</label>
                    <input type="text" class="bxmiddles" id="bxUbic" style="text-transform: uppercase;" disabled/>
                    <button id="btnUbic" class='BtnMatchIcon'></button>
                    <br><br>
                    <input id="rbAviso" type="radio" name="Busqueda" value="Avisos"> <label>Avisos de Mantenimiento</label>
                    <input type="text" class="bxmiddles" id="bxAviso" style="text-transform: uppercase;" disabled/>
                    <button id="btnAviso" class='BtnMatchIcon'></button>
                    <br><br>
                    <input id="rbNotificaPM" type="radio" name="Busqueda" value="NotificacionesPM"> <label>Aviso de Calidad</label>
                    <input type="text" class="bxmiddles" id="bxNoticaPM" style="text-transform: uppercase;" disabled/>
                    <button id="btnNoficaPM" class='BtnMatchIcon'></button>
                    <br><br>
                    <input id="rbNotificaQM" type="radio" name="Busqueda" value="NotificacionesQM"> <label>Lote de Inspección</label>
                    <input type="text" class="bxmiddles" id="bxNoticaQM" style="text-transform: uppercase;" disabled/>
                    <button id="btnNotificaQM" class='BtnMatchIcon'></button>
                    <br><br>
                    <input id="rbMov" type="radio" name="Busqueda" value="Movimientos"> <label>Clase de Documento</label>
                    <input type="text" class="bxmiddles" id="bxMovMer" style="text-transform: uppercase;" disabled/>
                    <button id="btnMovMer" class='BtnMatchIcon'></button>
                </div>
            </div>
        </div>
        <div id="VentanaModalEquipo" class="VentanaModal">
            <div id="handle"><label id="TituloMatch">Equipos</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalEquipo', 'bxEquipo');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnEquipoM">Equipos</button><hr></div>
            <div id="BuscarParamEquipo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.EquipoOR"));%></label><input type="text" id="bxEqE" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="5" type="text"  id="bxMaxE"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalEquipo', 'bxEquipo');"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo">
                        <div class="fixedY" id="fixedYEquipo">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.EquipoOR"));%></th>
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
        <div id="VentanaModalUbicacion" class="VentanaModal">
            <div id="handle1"><label id="TituloMatch">Ubicaciones</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalUbicacion', 'bxUbic');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnUbicacionM">Ubicación</button><hr></div>
            <div id="BuscarParamUbicacion" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Ubicación</label><input type="text" id="ubictBus" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="5" id="bxnumAcMax"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbicacion"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalUbicacion', 'bxUbic');"/>
                </div>
            </div>
            <div id="ConsultaTablaUbicacion" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbicacion">
                        <div class="fixedY" id="fixedYUbicacion">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Ubicación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUbicacion">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAvisos" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch">Avisos</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalAvisos', 'bxAviso');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnAvisosM">Avisos</button><hr></div>
            <div id="BuscarParamAvisos" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Aviso</label><input type="text" id="bxAvMtch" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="5" type="text"  id="bxMaxAv"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAviso"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalAvisos', 'bxAviso');"/>
                </div>
            </div>
            <div id="ConsultaTablaAvisos" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAvisos">
                        <div class="fixedY" id="fixedYAvisos">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Aviso</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosAvisos">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalNotiPM" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Notificaciones PM</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalNotiPM', 'bxNoticaPM');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnNotiPMM">Notificaciones PM</button><hr></div>
            <div id="BuscarParamNotiPM" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Notificación PM</label><input type="text" id="bxNPMMtch" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="5" type="text"  id="bxMaxNPM"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okNotiPM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalNotiPM', 'bxNoticaPM');"/>
                </div>
            </div>
            <div id="ConsultaTablaNotiPM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollNotiPM">
                        <div class="fixedY" id="fixedYNotiPM">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Notificaciones PM</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosNotiPM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalNotiQM" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch">Notificaciones QM</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalNotiQM', 'bxNoticaQM');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnNotiQMM">Notificaciones QM</button><hr></div>
            <div id="BuscarParamNotiQM" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Notificación QM</label><input type="text" id="bxNQMMtch" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="5" type="text"  id="bxMaxNQM"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okNotiQM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalNotiQM', 'bxNoticaQM');"/>
                </div>
            </div>
            <div id="ConsultaTablaNotiQM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollNotiQM">
                        <div class="fixedY" id="fixedYNotiQM">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Notificaciones QM</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosNotiQM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalMovimientos" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch">Clase de Documentos</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalMovimientos', 'bxMovMer');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnMovimientosM">Clase de Documentos</button><hr></div>
            <div id="BuscarParamMovimientos" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Clase de Documentos</label><input type="text" id="bxMovMtch" style="width:35%;" class="carpeta"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="5" type="text"  id="bxMaxMov"  style="width:10%;" class="numero"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMovimientos"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('VentanaModalMovimientos', 'bxMovMer');"/>
                </div>
            </div>
            <div id="ConsultaTablaMovimientos" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMovimientos">
                        <div class="fixedY" id="fixedYMovimientos">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Clase de Documento</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMovimientos">
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
    <script language="javascript">
        $(document).ready(function () {
            $("#rbt").attr('checked', true);
        });

        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function peticiones(url, id, accion, f)
        {
            var extras = "", v1, v2, v3, v4;
            switch (accion)
            {
                case "VentanaModalEquipo":
                    v1 = document.getElementById("bxEqE").value;
                    v2 = "";
                    v3 = document.getElementById("bxMaxE").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
                case "VentanaModalUbicacion":
                    v1 = document.getElementById("ubictBus").value;
                    v2 = "";
                    v3 = document.getElementById("bxnumAcMax").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
                case "VentanaModalAvisos":
                    v1 = document.getElementById("bxAvMtch").value;
                    v2 = "";
                    v3 = document.getElementById("bxMaxAv").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
                case "VentanaModalNotiPM":
                    v1 = document.getElementById("bxNPMMtch").value;
                    v2 = "";
                    v3 = document.getElementById("bxMaxNPM").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
                case "VentanaModalNotiQM":
                    v1 = document.getElementById("bxNQMMtch").value;
                    v2 = "";
                    v3 = document.getElementById("bxMaxNQM").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
                case "VentanaModalMovimientos":
                    v1 = document.getElementById("bxMovMtch").value;
                    v2 = "";
                    v3 = document.getElementById("bxMaxMov").value;
                    extras = "&v1=" + v1 + "&v2=" + v2 + "&v3=" + v3;
                    break;
            }
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    var temp = new Array();
                    temp = xmlhttp.responseText.split(",");
                    if(temp[0] == 0)
                    {
                        inval("<%=menValores%>");
                        $(temp[1]).trigger("click");
                    }
                    else
                    {
                        document.getElementById(id).innerHTML = xmlhttp.responseText;
                        fnc(f);
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + accion + extras, true);
            xmlhttp.send();
        }
    </script>
    <script>
        function inv() {
            var funinva = "<%=funcioninv%>";
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>

