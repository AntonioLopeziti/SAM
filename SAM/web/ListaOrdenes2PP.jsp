
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
        String okconsu = po.getProperty("etiqueta.ConOk_FO");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String reso = po.getProperty("etiqueta.Resolucio");
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
        String Ac = request.getParameter("acc");
        String cl1 = request.getParameter("cl1");
        String cl2 = request.getParameter("cl2");
        String or1 = request.getParameter("or1");
        String or2 = request.getParameter("or2");
        String sa1 = request.getParameter("sa1");
        String sa2 = request.getParameter("sa2");
        String tb1 = request.getParameter("tb1");
        String tb2 = request.getParameter("tb2");
        String ub1 = request.getParameter("ub1");
        String ub2 = request.getParameter("ub2");
        String ep1 = request.getParameter("ep1");
        String ep2 = request.getParameter("ep2");
        String po1 = request.getParameter("po1");
        String po2 = request.getParameter("po2");
        String fc1 = request.getParameter("fc1");
        String fc2 = request.getParameter("fc2");
        String f1 = request.getParameter("feEx1");
        String f2 = request.getParameter("feEx2");
        String abi = request.getParameter("abi");
        String lib = request.getParameter("lib");
        String cte = request.getParameter("cte");
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
                var pag = p.charAt(43);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                var chk = '<%=Ac%>';
                if (chk == null || chk === "" || chk === "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleListaOrden.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/ListaOrden2PP.js" type="text/javascript"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title>Lista de órdenes PP Selección de ordénes PP</title>       
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
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>            
            <!--<div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloListaOrdenes_LO"));%></h1></div>-->      
            <div class="titulo"><h1>Lista de órdenes PP Selección de ordénes PP</h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div id="general" class="general">
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td><%out.println(po.getProperty("etiqueta.ClasOrd_LO"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Ord_LO"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.CSPTxtBrv"));%></td>
                                                <td>Material</td>
                                                <td>Fecha Inicio Ext</td>
                                                <td>Fecha</td>
<!--                                                <td>Notificado</td>
                                                <td>Cantidad</td>-->
                                                <td><%out.println(po.getProperty("etiqueta.GralIcono"));%></td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">
                                </section>
                            </section>
                        </section>
                    </div>
<!--                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>-->
                </div>                         
            </div> 
        </div>
        <div id="Windowmsg" class="VentanaModalMensajes">
            <div id="handleMsg"><label id="TituloMatch">Seleccione una operación</label><div class="BotonCerrar_Matc" id="CerrarVentanaMsg1"><label >X</label></div></div>
            <div class="orcla">
                <label><%out.println(po.getProperty("etiqueta.ordNumConsAv"));%>:</label> <label id="numordenmsg"></label>
            </div>
            <div class="contdiv">
                <button id="btnVis" >Visualizar</button>
                <button id="btnNot" >Crear Notificaciones</button>
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
    <script>
        function inval() {
            var okcon = "<%=funcioninv%>";
            $('#msg').html(okcon);
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', "images/advertencia.PNG");
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
        }
        function CargarTabla() {
            var cl1 = '<%=cl1%>';
            var cl2 = '<%=cl2%>';
            var or1 = '<%=or1%>';
            var or2 = '<%=or2%>';
            var sa1 = '<%=sa1%>';
            var sa2 = '<%=sa2%>';
            var tb1 = '<%=tb1%>';
            var tb2 = '<%=tb2%>';
            var ub1 = '<%=ub1%>';
            var ub2 = '<%=ub2%>';
            var ep1 = '<%=ep1%>';
            var ep2 = '<%=ep2%>';
            var po1 = '<%=po1%>';
            var po2 = '<%=po2%>';
            var fc1 = '<%=fc1%>';
            var fc2 = '<%=fc2%>';
            var f1 = '<%=f1%>';
            var f2 = '<%=f2%>'
            var abi = '<%=abi%>';
            var lib = '<%=lib%>';
            var cte = '<%=cte%>';
            var acc = '<%=Ac%>';
            var par = "&cl1=" + cl1 + "&cl2=" + cl2 + "&or1=" + or1 + "&or2=" + or2 +
                    "&sa1=" + sa1 + "&sa2=" + sa2 + "&tb1=" + tb1 + "&tb2=" + tb2 +
                    "&ub1=" + ub1 + "&ub2=" + ub2 + "&ep1=" + ep1 + "&ep2=" + ep2 +
                    "&po1=" + po1 + "&po2=" + po2 + "&fc1=" + fc1 + "&fc2=" + fc2 +
                    "&feEx1=" + f1 + "&feEx2=" + f2 +
                    "&abi=" + abi + "&lib=" + lib + "&cte=" + cte;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionModuloListaOrdenesPP',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "acc=" + acc + par,
                success: function (data) {
                    $('#SecCuerpo').html(data);
                    var okcon = "<%=okconsu%>";
                    $('#msg').html(okcon);
                    var icon = $('#iconmsg');
                    icon.show();
                    icon.attr('src', "images/aceptar.png");
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
//                    $("#DobleSection").scroll(function () {
//                        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
//                    });
//                    $("#SecCuerpo").scroll(function () {
//                        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
//                    });


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
