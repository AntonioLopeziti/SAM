<%-- 
    Created on : 16/08/2016, 05:35:21 PM

--%>

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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String okconsu = po.getProperty("etiqueta.ConOk_FO");
        String notCom = po.getProperty("etiqueta.NotificaciMEGComp");
        String Accion = request.getParameter("Accion");
        String lote = request.getParameter("lote");
        String lote2 = request.getParameter("lote2");
        String usuario = request.getParameter("usuario");

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
                var pag = p.charAt(99);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                var chk = '<%=Accion%>';
                if (chk == null || chk === "" || chk === "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au, va) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=okconsu%>';
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

        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/styleMAPM.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/VisualizarLoteInpseccion.js" type="text/javascript"></script>
        <script src="js/dom-drag.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.LoteInspecLis_menu"));%></title> 
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png"  disabled />                
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled />               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.LoteInspecLis_menu"));%></h1></div>      
        </div>
    </div>
    <div class="contenido">
        <div id="tabscrll">
            <section id="TableNotfi" >
                <section class="TableContainer">
                    <section class="SecHead">
                        <table id="TabHead">
                            <thead>
                                <tr>
                                    <td><%out.println(po.getProperty("etiqueta.GralIcono"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.ReportesLoteInp"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.ordNumConsAv"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.NPMHora"));%></td>
                                    <td><%out.println(po.getProperty("etiqueta.CreOrFea"));%></td>
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
<div id="Windowmsg" class="VentanaModalMensajes">
    <div id="handleMsg"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPInfom"));%></label><div class="BotonCerrar_Matc" id="CerrarVentanaMsg1"><label >X</label></div></div>
    <div class="imginfo"><IMG id="iocnomsgso" ALT="Info"></div>
    <div class="InfoMensaje"><label><%out.println(notCom);%></label></div>
    <div class="okmsg">
        <input id="CloMsg" type="image" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;"/>   
    </div>
</div>
<script>
    function CargarTabla() {
        var lote1 = '<%=lote%>';
        var lote2 = '<%=lote2%>';
        var users = '<%=usuario%>';
        var acc = '<%=Accion%>';
        var par = "&lote=" + lote1 + "&lote2=" + lote2 + "&usuario=" + users;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionListaLotesInpeccion',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Accion=" + acc + par,
            success: function (data) {
                $('#SecCuerpo').html(data);
                ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
            }
        });
    }

</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>
