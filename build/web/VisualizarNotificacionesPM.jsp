<%-- 
    Document   : VisualizarNotificacionesPM
    Created on : 18/07/2016, 11:33:06 AM
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.util.LinkedList"%>
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
        String notord = po.getProperty("etiqueta.CSPNotOrden");
        String Indic = po.getProperty("etiqueta.IndiqueNumNo");
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
                var pag = p.charAt(78);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/NotificacionesPM.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VNotificacionesPM.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.NPMNotificacionordenmtVisu"));%></title>       
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
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.NPMNotificacionordenmtVisu"));%></h1></div>      
        </div>            
        <div id="Conte" hidden></div> 
        <div class="contenido">
            <div class="ContentNotificaciones">
                <div class="divmatchequipo" hidden>
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMNumeronotificacionop"));%></label> 
                    <hr class="lineaazul">
                    <div class="ComDiv">
                        <label><%out.println(po.getProperty("etiqueta.NPMNotificacíon"));%></label><input id="not" type="text" style="width: 30%; text-transform: uppercase;" maxlength="10"/>
                        <hr>       
                    </div>
                </div>
                <div class="divOrd">
                    <div class="divOrd1">
                        <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMOrden"));%></label> 
                        <hr class="lineaazul">
                        <div class="ComDiv">
                            <label><%out.println(po.getProperty("etiqueta.NPMOrden"));%></label><input id="ord" type="text"  style=" width:35%; text-transform: uppercase;" maxlength="12" ><button id="match_C1" class='BtnMatchIcon2'></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.NPMOperacion"));%></label><input id="ope" type="text" style="width: 20%;" maxlength="4"/>
                            <hr>
                            <div hidden>
                                <label><%out.println(po.getProperty("etiqueta.NPMSuboperacion"));%></label><input id="subop" type="text" style="width: 20%;" maxlength="4"/>
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="divOrd2" hidden> 
                        <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMOrdenpermanente"));%></label> 
                        <hr class="lineaazul">
                        <div class="ComDiv">
                            <label id="etUbicTecn" class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMUbictecn"));%></label><input id="ubte" type="text"  style="width: 40%; text-transform: uppercase;" maxlength="30"><button id="match_C2" class='BtnMatchIcon2'></button>
                            <hr>
                            <label id="etEquipo" class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMEquipo"));%></label><input id="equ" type="text" style="width: 40%; text-transform: uppercase;" maxlength="18"/><button id="match_C3" class='BtnMatchIcon2'></button>
                            <hr>  
                        </div>
                    </div>    
                </div>
                <section class="divContador" hidden>
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMContanot"));%></label> 
                    <hr class="lineaazul">
                    <div class="ComDiv">
                        <label id="etContador" class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMContador"));%></label><input id="conta" type="text" style=" width:20%;">
                        <hr>
                    </div>
                </section>
                <section class="divCap" hidden>
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMCapacidadindiv"));%></label> 
                    <hr class="lineaazul">
                    <div class="ComDiv">
                        <label id="etClaseCapacidad" class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMClasecapacidad"));%></label><input id="clascap" type="text" style="width:30%;"><button id="match_C4" class='BtnMatchIcon2'></button>
                        <hr>
                        <label id="etNParticion" class="tituloequipo"><%out.println(po.getProperty("etiqueta.NPMNoparticion"));%></label><input id="nopar" type="text" style="width:30%;">
                        <hr>
                    </div>
                </section> 
            </div>
        </div>
        <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc"id="btnceor1" ><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="vemoor" ><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamOrden" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ReportNumord"));%></label><input type="text" id="NumOrden_Bus" style="width:35%; text-transform: uppercase;"  maxlength="12"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></label><input type="text" id="TextoOrden_Bus" style="width:35%;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okorden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="btnceor2"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden">
                        <div class="fixedY" id="fixedYOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReportNumord"));%></th><th><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>                    
    </div>       
    <div id="VentanaModalUbi" class="VentanaModal">
        <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="btnceub1"><label >X</label></div></div>
        <div class="PanelBntMatch"><button id="vemoub"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
        <div id="BuscarParam_u2" class="BuscarParam_u">
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.NPMUbictecn"));%></label><input id="UbicaB" maxlength="30" type="text" style="width: 35%; text-transform: uppercase;" />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input id="DUbicaB" maxlength="40"  type="text" style="width: 35%;" />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax2"  style="width: 10%;"/>

                </div>        
            </div> 
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okUbi"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" id="btnceub2"/>
            </div>
        </div>
        <div id="ConsultaTablaUbicacion" style="display: none;">
            <div class="tablaCab">
                <div class="table-scroll" id="table-scrollUbicacion">
                    <div class="fixedY" id="fixedYUbicacion">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMUbictecn"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="cuerpoDatos">
                        <div class="nofixedX" id="cargarDatosUbicacionn">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>  
    <div id="VentanaModalEquipo" class="VentanaModal">
        <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="btnceeq1" ><label >X</label></div></div>
        <div class="PanelBntMatch"><button id="vemoeq"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
        <div id="BuscarParam_u3"  class="BuscarParam_u">
            <div class="fondo_Match">
                <div class="busquedaMatch">
                    <label><%out.println(po.getProperty("etiqueta.NPMEquipo"));%></label><input id="equipma3" maxlength="30" type="text" style="width: 35%; text-transform: uppercase;" />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input id="denequ"   maxlength="40" type="text" style="width: 45%;" />
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax3"  style="width: 10%;"/>

                </div>        
            </div> 
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okEquipo"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" id="btnceeq2"/>
            </div>
        </div>
        <div id="ConsultaTabla3" style="display: none;">
            <div class="tablaCab">
                <div class="table-scroll" id="table-scrollEquipo">
                    <div class="fixedY" id="fixedYEquipo">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.NPMEquipo"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="cuerpoDatos">
                        <div class="nofixedX" id="CargarDatosEquipo">
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

    function borrarmsg() {
        $("iconmsg").css("visibility", "hidden");
        $("msg").html("");
    }

    function mensajess(m, au, im, v) {
        var ind = '';
        switch (m) {
            case 1:
                ind = '<%=Indic%>';
                break;
            case 2:
                ind = '<%=funcioninv%>';
                break;
            case 3:
                ind = '<%=notord%>' + " " + v;
                break;
            case 4:
                ind = '<%=menValores%>';
                break;
        }
        var BE = document.createElement('audio');
        BE.src = au;
        BE.play();
        $("#iconmsg").css("visibility", "visible");
        $("#iconmsg").attr("src", im);
        $("#msg").html(ind);
    }

</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>