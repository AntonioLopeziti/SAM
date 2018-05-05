<%-- 
    Document   : MonitorPP
    Created on : 15/01/2018, 04:36:06 PM
    Author     : Panda
--%>

<%@page import="java.net.URL"%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
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
        String existFol = po.getProperty("etiqueta.NoexisteEquipoEQ");
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
    <%        String Accion = request.getParameter("Accion");
        String centro = request.getParameter("centro");
        String folio = request.getParameter("sam1");
        String orden = request.getParameter("sap1");
    %>
    <head>
        <script>
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 1:
                        msg = 'No hay valores para esta sección';
                        break;
                }
                $('#msg').html(msg);                
                var icon = $('#iconmsg');
                icon.attr('visibility', true);
                icon.show();
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
        </script>
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
        <link rel="stylesheet" href="css/StyleListadoOrdenesPP.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/listadoOrd.js"></script>
        <title>Monitor PP</title>
    </head>
    <body>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>
            <input id="guardar" type="image" src="images/guarda.PNG"/>
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1>Listado de órdenes de fabricación PP</h1></div>
        </div>
        <div class="contenido">
            <section class="bkButtons">
                <!--<button onclick="libbot()"><img src="images/liberar.png"></button>-->
                <!--<button onclick="canbot()"><img src="images/cierretecnico.png"></button>-->
                <!--<button onclick="cciebot()"><img src="images/cancelarcierre.png"></button>-->
                <button id="imgLib" class="bgButtons"></button>
                <button id="imgCie" class="bgButtons"></button>
                <button id="imgCan" class="bgButtons"></button>
            </section>
            <!--            <section class="bkClassNoti">
                            <label style="padding-left: 10px; font-size: 13.5px;">Clase de notificación</label>
                            <hr id="LineaTituloInfo">
                            <input type="radio" name="clnoti" checked> Notif.pacial
                            <input type="radio" name="clnoti" class="rbcln"> Notif.final
                            <input type="radio" name="clnoti" class="rbcln"> Notif.final autom.
                            <input type="checkbox" name="ckreserva" class="rbcln"> Compensar reserva
                        </section>-->
            <section class="bkSubSec">
                <div class="CldMov">
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
                    <section class="TableContainer">
                        <section class="SecHead">
                            <table id="TabHead">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td>Habilitar</td>
                                        <td>Cl.Ord</td>
                                        <td>Orden</td>
                                        <td>Centro</td>
                                        <td>Material</td>
                                        <td>Texto material</td>
                                        <td>Estatus</td>
                                        <td>Cantidad</td>
                                        <td>Mensaje</td>
                                        <td>Fecha Inicio</td>
                                        <td>Notificado</td>
                                    </tr>
                                </thead>
                            </table>
                        </section>
                        <section class="SecBody" id="SecCuerpo">
                        </section>
                    </section>
                </div>
            </section>
            <br>
        </div>
        <section id="LastSec"></section>
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
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
                    var e;
                    var usuario = "<%=Nombre%>";

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
                        startTime();
                        bloq();
                        verificarOpCargar();
//                        tablaListadoOrdenesPP();
                    };
                    function verificarOpCargar() {
                        var acc = '<%=Accion%>';                        
                        if (acc == 'CargaTodaTabla') {
                            tablaListadoOrdenesPP();                            
                        }            
                        if (acc == 'CargaTablaCentro') {                            
                            var cnt = '<%=centro%>';
                            tablaListadoOrdenesPorCentro(cnt);
                        }
                        if (acc == 'CargaTablaFolio'){
                            var fol = '<%=folio%>';
                            tablaListadoOrdenesPorFolio(fol)
                        }
                        if (acc == 'CargaTablaMaterial'){
                            var mat = '<%=orden%>';
                            tablaListadoOrdenesPorMaterial(mat)
                        }
                        if(acc == 'CargaTablaCenFol'){
                            var cnt = '<%=centro%>';
                            var fol = '<%=folio%>';
                            tablaListadoOrdenesPorCenFol(cnt,fol);
                        }
                        if(acc == 'CargaTablaCenMat'){
                            var cnt = '<%=centro%>';
                            var mate = '<%=orden%>';
                            tablaListadoOrdenesPorCenMate(cnt,mate);
                        }
                        if(acc == 'CargaTablaFolMat'){
                            var fol = '<%=folio%>';
                            var mate = '<%=orden%>';
                            tablaListadoOrdenesPorFolMate(fol,mate);
                        }
                    }
                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
//                        document.getElementById('guardar').disabled = true;
                    }

                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "ListadoOrdFab.jsp";
        }
    </script>

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
