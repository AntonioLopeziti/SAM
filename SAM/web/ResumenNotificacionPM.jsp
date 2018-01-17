<%-- 
    Document   : ResumenNotificacionPM
    Created on : 19-ago-2016, 17:38:40
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
    <%
        String ord = request.getParameter("orden");
        String ope = request.getParameter("opera");
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
                var o = '<%=ord%>';
                var pag = p.charAt(78);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (o == null || o == "null" || o == "") {
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled />                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="fin();"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="fin();"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.NPMNotificacionordenmtVisu"));%></h1></div>      
        </div>         
        <div class="contenido">

            <div class="ContentNotificaciones">
                <div class="CabNotif">
                    <label><%out.println(po.getProperty("etiqueta.NPMOrden"));%></label><input type="text" value="<%=ord%>" style="width: 30%;" disabled/> <input type="text" id="desOrden" style="width: 40%; border: none; background: none;" readonly/>
                    <hr>
                </div>
                <div class="sub2">
                    <label class="tituloequipo"> <%out.println(po.getProperty("etiqueta.NotOpeSubOp"));%> </label> 
                    <hr class="lineaazul">
                    <div>
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td>&nbsp;&nbsp;&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.IndicadoOPVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.OPVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.SBOPVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CLVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.ParVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.NotVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.AVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FEContAVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.PstoTbjoVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.TbjoralVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.unVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.ClActVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.DescripVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.CLVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FecInReaVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FecfinReaVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.PronoTjVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.trabajVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FechInMTmpVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FechIniMatarVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FechfnmastmpVAV"));%>&nbsp;</td>
                                                <td><%out.println(po.getProperty("etiqueta.FechfinmatrdVAV"));%>&nbsp;</td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">
                                </section>
                            </section>
                        </section>
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
                        $("#tiempo").html(h + ":" + m + ":" + s);
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
                        muestraDatoDs();
                        muestraDatos();
                        bloq();
                    };

                    function bloq() {
                        $("#iconmsg").css("visibility", "hidden");
                        $("#guardar").prop("disabled", true);
                    }
                    function muestraDatos() {
                        var acc = "CargarTablaNot";
                        var valor = '<%=ord%>';
                        var oper = '<%=ope%>';
                        var enviar = "&Orden=" + valor + "&operacion="+oper;

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'peticionModuloVisualNotificaciones',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Accion=" + acc + enviar,
                            success: function (data) {
                                var rs = data;
                                $("#SecCuerpo").html(rs);
                                 AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                            }

                        });
                    }

                    function muestraDatoDs() {
                        var acc = "DescripcionOrden";
                        var valor = '<%=ord%>';
                        var enviar = "&Orden=" + valor;

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'peticionModuloVisualNotificaciones',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Accion=" + acc + enviar,
                            success: function (data) {
                                var rs = data;
                                $("#desOrden").html(rs);
                            }

                        });
                    }

                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "VisualizarNotificacionesPM.jsp";
        }
        function fin() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            $("#msg").html(funinva);
        }
        function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
        {
            var myTable = document.getElementById(cuerpo);
            var arr = new Array();
            for (i = 0; i < myTable.rows[0].cells.length; i++)
            {
                arr[i] = myTable.rows[0].cells[i];
            }
            var val = 0;
            for (i = 0; i < arr.length; i++)
            {
                val += arr[i].offsetWidth;
            }
            var myTableCb = document.getElementById(cabecera);
            myTableCb.style.width = val + 7 + "px";
            var arrCb = new Array();
            for (i = 0; i < myTableCb.rows[0].cells.length; i++)
            {
                arrCb[i] = myTableCb.rows[0].cells[i];
            }
            for (i = 0; i < arr.length - 1; i++)
            {
                arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
            }
            document.getElementById(section).style.width = val + 17 + "px";
        }

    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>