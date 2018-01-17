<%--
    Document   : MonitorStatusCont
    Created on : 15/06/2016, 11:34:29 AM
    Author     : AREconsulting
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
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
        String Val = request.getParameter("valor");
        String Ctr = request.getParameter("centro");        
        String Ubi = request.getParameter("");
        String Equ = request.getParameter("equipo");
        String equipo2 = request.getParameter("equipo2");
        String puesto = request.getParameter("puesto");
        String meFOL = request.getParameter("foll");
        String mte = request.getParameter("mte");
        String mte2 = request.getParameter("mte2");
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
        int f;
        String foc;
        folios fo = new folios();
        fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CC");
        f = fo.getFolioActual();
        foc = fo.getIdFolios() + f;
    %>

    <head>
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">    
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
                var pag = p.charAt(104);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleMonitorPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/MonitorStatusContPP.js"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloModulo_MSC_PP"));%></title>       
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
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="principalpage();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloModulo_MSC_PP"));%></h1></div>
        </div>            
        <div class="contenido">
            <section class="MonitorStatusCont">
                <section id="TablaStatus">
                    <section id="SecTab">                       
                    </section>
                    <p class="last"></p>
                </section>
                <section id="BusquedaStatus">
                    <section id="BusquedaSec">
                        <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.AjusteB_MSC_PP")); %></label>
                        <hr class="LineasMonitor">
                        <section class="Radio_Ajuste">                        
                            <input type="radio" name="Ajuste" value="Alerta"> <label><% out.println(po.getProperty("etiqueta.Alerta_MSC_PP")); %></label><br>
                            <input type="radio" name="Ajuste" value="Advertencia"> <label><% out.println(po.getProperty("etiqueta.Advertencia_MSC_PP")); %></label><br>
                            <input type="radio" name="Ajuste" value="NoAdvertencia"> <label><% out.println(po.getProperty("etiqueta.NoAdvertencia_MSC_PP")); %></label><br>
                            <input type="radio" name="Ajuste" value="NoContador"> <label><% out.println(po.getProperty("etiqueta.NoContador_MSC_PP")); %></label><br>
                            <input type="radio" name="Ajuste" value="Todos"> <label><% out.println(po.getProperty("etiqueta.Todos_MSC_PP")); %></label><br>
                            <br>
                            <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.Jerarquia_MSC_PP")); %></label>
                            <input id="Jrq" class="BxJerarquia" type="text">
                            <hr class="LineasAjuste">
                            <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.SFI_MSC_PP")); %></label>
                            <input id="Sfi" class="BxJerarquia" type="text" maxlength="3" onclick="funumeric()" />
                            <button id="BtnAplica" type="button" onclick="MostrarTabla('PeticionMonitorStatusContPP', '');">
                                <img src="images/ejecuta.png"> 
                                &nbsp;&nbsp;&nbsp;<% out.println(po.getProperty("etiqueta.Aplicar_MSC_PP")); %>
                            </button>
                        </section>                                
                    </section>
                    <br>
                    <section id="BusquedaSec">
                        <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Medicion_MSC_PP")); %></label>
                        <hr class="LineasMonitor">
                        <section class="Radio_Ajuste">                   
                            <label><% out.println(po.getProperty("etiqueta.Diferencia_MSC_PP")); %></label><br>
                            <input id="Dif" class="BxDiferencia" type="text">
                            <button id="BtnDif" type="button" onclick="ActualizarMedicion()">
                                <img src="images/DiferenteMSC.PNG">
                                &nbsp;&nbsp;<% out.println(po.getProperty("etiqueta.Actualizar_MSC_PP"));%>
                            </button>
                        </section>
                    </section>
                </section>
            </section>
        </div>       
        <section id="SecTab2" hidden ></section>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2.5px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <div hidden><input type="text" value="<%=Nombre%>" id="usua"</div>
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
        function back() {
            window.location.href = "MonitorStatus.jsp";
        }
        function principalpage() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            $("#msg").html(funinva);
        }
        function cargaryaaPP(){
         var modos = "<%=Val%>";   
         MostrarTablaa3('PeticionMonitorStatusContPP', modos);   
        }
        function MostrarTablaa3(url, val)
        {            
            var jr = $("#Jrq").val();
            var sf = $("#Sfi").val();
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var mt = "<%=mte%>";
            var mt2 = "<%=mte2%>";
            var enviar = "&val=" + val + "&ct=" + ct.toUpperCase() + "&ub=" + ub + "&eq=" + eq + "&modo=" + val + "&jr=" + jr + "&sf=" + sf+"&caso=uno&eq2="+eq2 + "&pue=" + pue;
                
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: url,
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: enviar,
                                success: function (data) {                                   
                                   $("#SecTab").html(data);
                                }
                            });
        }
        function MostrarTabla(url, valor)
        {
            var modo;
            var radiosA = document.getElementsByName('Ajuste');
            for (var i = 0; i < radiosA.length; i++)
            {
                if (radiosA[i].checked)
                {
                    modo = radiosA[i].value;
                }
            }
            var jr = $("#Jrq").val();
            var sf = $("#Sfi").val();
            var Lang = "<%=Idioma%>";
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&valor=" + valor + "&Idioma=" + Lang + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf + "&eq2=" + eq2 + "&pue=" + pue;
            $.ajax({
                async: false,
                type: 'GET',
                url: url,
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    $("#SecTab").html(data);
                }

            });
        }
        function MostrarRadioPP()
        {
            var vl = "<%=Val%>";
            var radiosA = document.getElementsByName('Ajuste');
            for (var i = 0; i < radiosA.length; i++)
            {
                if (radiosA[i].value == vl)
                {
                    radiosA[i].checked = true;
                }
            }
        }
        function borramsg() {

            $("#iconmsg").css("visibility", "hidden");
            $("#msg").html("");
        }
        function CArgarMnee() {
            var mensajOk = '<%=meFOL%>';
            if (mensajOk != 'null') {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $("#iconmsg").css("visibility", "visible");
                $("#iconmsg").attr("src", "images/aceptar.png");
                $("#msg").html('Documento ' + mensajOk + " creado");
            } else {
                borramsg();
            }
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>