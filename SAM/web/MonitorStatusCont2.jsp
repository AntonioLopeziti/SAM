<%--
    Document   : MonitorStatusCont
    Created on : 15/06/2016, 11:34:29 AM
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
        String Val = request.getParameter("valor");
        String Ctr = request.getParameter("centro");
        String Ubi = request.getParameter("ubitec");
        String Equ = request.getParameter("equipo");
        String Ord = request.getParameter("orden");
        String equipo2 = request.getParameter("equipo2");
        String puesto = request.getParameter("puesto");
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
                var pag = p.charAt(65);
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
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/MonitorStatusCont2.js"></script> 
        <title><%out.println(po.getProperty("etiqueta.TituloModulo_MSC"));%></title>     
       
    <body>
            <div id="main-header">   
                <hr>
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                        </li>
                    </ul>
                </div>
                <input id="aceptar"  type="image" src="images/aceptar.png"/>                
                <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
                <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
                <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloModulo_MSC"));%></h1></div>      
            </div>            
            <div class="contenido">
                    <section class="MonitorStatusCont">
                        <section id="TablaStatus2">
                            <section id="SecTab" class="SecTabClass">                       
                            </section>
                            <button id="BtnNotPM" type="button" >
                               <img src="images/S_B_CHNG.gif">
                               &nbsp;<% out.println(po.getProperty("etiqueta.NotOrden_MSC")); %></button>
                            <p class="last"></p>
                            
                        </section>
                        <section id="BusquedaStatus">
                            <section id="BusquedaSec" class="BusqSecc">
                                <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.AjusteB_MSC")); %></label>
                                <hr class="LineasMonitor">
                                <section class="Radio_Ajuste">                        
                                    <input id="alerta" type="radio" name="Ajuste" value="Alerta"> <label><% out.println(po.getProperty("etiqueta.Alerta_MSC")); %></label><br>
                                    <input id="advert" type="radio" name="Ajuste" value="Advertencia"> <label><% out.println(po.getProperty("etiqueta.Advertencia_MSC")); %></label><br>
                                    <input id="noadvert" type="radio" name="Ajuste" value="NoAdvertencia"> <label><% out.println(po.getProperty("etiqueta.NoAdvertencia_MSC")); %></label><br>
                                    <input id="nocont" type="radio" name="Ajuste" value="NoContador"> <label><% out.println(po.getProperty("etiqueta.NoContador_MSC")); %></label><br>
                                    <input id="todos" type="radio" name="Ajuste" value="Todos"> <label><% out.println(po.getProperty("etiqueta.Todos_MSC")); %></label><br>
                                    <br>
                                    <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.Jerarquia_MSC")); %></label>
                                    <input id="Jrq" class="BxJerarquia" type="text">
                                    <hr class="LineasAjuste">
                                    <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.SFI_MSC")); %></label>
                                    <input id="Sfi" class="BxJerarquia" type="text">
                                    <button id="BtnAplica" type="button" onclick="MostrarTabla('PeticionMonitorStatusCont2', '');">
                                        <img src="images/ejecuta.png"> 
                                        &nbsp;&nbsp;&nbsp;<% out.println(po.getProperty("etiqueta.Aplicar_MSC"));%>
                                    </button>
                                </section>     
                            </section>       
                        </section>
                                    <button id="BtnNotOr" type="button" hidden onclick="PantallaNotificaciones('PeticionMonitorStatusCont2', '');" >
                               <img src="images/Editar.PNG">
                               &nbsp;<% out.println(po.getProperty("etiqueta.NotificarOrden_MSC"));%></button>   
                    </section>
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
                      
                        function carghar(){
                           
                            $num_equipo='';
                            $("input[name=monitor]").each(function(){
                               if (this.checked) {
                                $num_equipo=$(this).val();
                                 
                               }
                             });
                            segundatabla("PeticionMonitorStatusCont2","",$num_equipo);
                        }

                    </script>
                </div>
            </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "MonitorStatus.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            $("#msg").html(funinva);
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
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&val=" + valor + "&ct=" + ct.toUpperCase() + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf+"&caso=uno&eq2="+eq2 + "&pue=" + pue;
                
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: url,
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: enviar,
                                success: function (data) {
//                                    alert(data);
                                   $("#SecTab").html(data);
                                }

                            });
        }
        
        function segundatabla(url,valor,equipo)
        {
            //alert(url+" "+valor+" "+equipo);
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
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&val=" + valor + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf+"&caso=dos"+"&equipo="+equipo+"&eq2="+eq2 + "&pue=" + pue;
                
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: url,
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: enviar,
                                success: function (data) {
//                                    alert(data);
                                   $("#tablados").html(data);
                                }

                            });
        }
        
        function PantallaNotificaciones(url,orden)
        {
            var Lang = "<%=Idioma%>";
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                    document.getElementById("SecTab").innerHTML = xmlhttp.responseText;
                }
            };
            xmlhttp.open("GET", url + "?val=" + valor + "&Idioma=" + Lang + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf + "&caso=dos" + "&orden=" + orden+"&eq2="+eq2, true);
            xmlhttp.send();
            
//            window.location.href = "CrearNotificacionesPM.jsp?valor=" + valor + "&Idioma=" + Lang + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf + "&caso=dos" + "&orden=" + orden;
//            cleanfield();
            
        }
        
        function MostrarRadio()
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
        function ActualizarMedicion()
        {
            var valor;
            var can = document.getElementById("Dif").value;
            var radiosM = document.getElementsByName('monitor');
            for (var i = 0; i < radiosM.length; i++)
            {
                if (radiosM[i].checked)
                {
                    valor = radiosM[i].value;
                }
            }
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    MostrarTabla('PeticionMonitorStatusCont', '');
                    document.getElementById("Dif").value = "";
                    if (xmlhttp.responseText > 0)
                    {
                        document.getElementById('Mensaje').innerHTML = "<img src=\"images/aceptar.png\" /> <label>Documento de medición " + xmlhttp.responseText + " creado</label>";
                    }
                }
            };
            xmlhttp.open("GET", "PeticionGuardaMonitor?val=" + valor + "&can=" + can, true);
            xmlhttp.send();
        }
        
        function PasarVal(orn){
             window.location.href = "CrearNotificacionesPM.jsp?orden="+orn; 
        }
        function MostrarTDos(){
            var val ="<%=Val%>";
            MostrarTabla3('PeticionMonitorStatusCont2', val);
        }
        function MostrarTabla3(url, val)
        {            
            var jr = $("#Jrq").val();
            var sf = $("#Sfi").val();
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&val=" + val + "&ct=" + ct.toUpperCase() + "&ub=" + ub + "&eq=" + eq + "&modo=" + val + "&jr=" + jr + "&sf=" + sf+"&caso=uno&eq2="+eq2 + "&pue=" + pue;
                
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: url,
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: enviar,
                                success: function (data) {
                                    alert(data);
                                   $("#SecTab").html(data);
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
</htmml>