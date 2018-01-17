<%-- 
    Document   : VistaAllStockMaterial
    Created on : 23/07/2016, 12:31:42 PM
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
        String reso = po.getProperty("etiqueta.Resolucio");
    %>
    <%
        String ACC = request.getParameter("Accion");
        String material = request.getParameter("material");
        String garticulo = request.getParameter("garticulo");
        String almacen = request.getParameter("almacen");
        String centro = request.getParameter("centro");
        String lote = request.getParameter("lote");
        String tipo = request.getParameter("tipo");
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
                var a = '<%=ACC%>';
                var p = '<%=permiso%>';
                var pag = p.charAt(45);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (a == null || a == "" || a == "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function msgMatch(v, im, aud) {
                var m = "";
                switch (v) {
                    case 0:
                        m = "<%=funcioninv%>";
                        break;
                    case 1:
                        m = '<%=OKconsul%>';
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = aud;
                BE.play();
                $('#iconmsg').attr('src', im);
                $('#iconmsg').show();
                $('#msg').html(m);
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleVistaAllStockMaterial.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarStockMateriales.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.STOCKnventario_Title"));%></title>
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="finali();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo">
                <h1><%out.println(po.getProperty("etiqueta.STOCKnventario_Title"));%></h1>
            </div>
        </div>            
        <div class="contenido">
            <div class="ContentSt">
                <div class="gen">
                    <label class="labelTitulo"> BAJAFERRIES </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>: </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
                        <script type="text/javascript">
                            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                            var f = new Date();
                            var minut = (f.getMinutes() < 10 ? '0' + f.getMinutes() : f.getMinutes());
                            var idioma = "<%=Idioma%>";
                            if (idioma == "ES") {
                                var fechaActu = "Periodo: " + meses[f.getMonth()] + " Ejercicio: " + f.getFullYear() + "<br>Fecha: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Hora: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else if (idioma == "EN") {
                                var fechaActu = "Period: " + meses[f.getMonth()] + " Exercise " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else {
                                var fechaActu = "Fecha indefinida";
                            }
                        </script>
                    </div>
                </div>
                <div id="general" class="general">
                    <div id="global" class="tableContainer">
                        <section id="TableNotfi" >
                            <section class="TableContainer" id="tabDat">
                            </section>
                        </section>
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
                window.onload = function () {
                    loadtab();
                };
            </script>
        </div>
    </footer>
</body>
<script>
    function finali() {
        $(location).attr('href', 'Bienvenido.jsp');
    }
    function back() {
        $(location).attr('href', 'VisualizarStockMaterial.jsp');
    }
    function loadtab() {
        var mat = '<%=material%>';
        var gart = '<%=garticulo%>';
        var alm = '<%=almacen%>';
        var cen = '<%=centro%>';
        var lot = '<%=lote%>';
        var che = '<%=tipo%>';
        var acc = "<%=ACC%>";
        var par = "Accion=" + acc + "&material=" + mat + "&garticulo=" + gart + "&almacen=" + alm + "&centro=" + cen + "&lote=" + lot + "&tipo=" + che;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionInventario',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: par,
            success: function (data) {
                $("#tabDat").html(data);
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                msgMatch(1, 'images/aceptar.png', 'audio/sapmsg.wav');
            }
        });
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