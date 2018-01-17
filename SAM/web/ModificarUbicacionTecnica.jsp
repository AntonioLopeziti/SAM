<%-- 
    Document   : ModificarUbicacionTecnica
    Created on : 22/07/2016, 09:57:48 AM
    Author     : AREConsulting
--%>

<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <%
            String Nombre = (String) session.getAttribute("Usuario");
            String Idioma = (String) session.getAttribute("Idioma");
            try {
                if (Nombre.equals(null) || Nombre.equals("") || Nombre == null || Idioma.equals(null)) {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                } else {

        %>
        <%            String propiedad = "";
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
            String TituloVisualizarOrden = po.getProperty("etiqueta.VisualizarOrden");
            String Orden = po.getProperty("etiqueta.Orden");
            String Mens = po.getProperty("etiqueta.mensaje");
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

            String titulo = po.getProperty("etiqueta.MU_Titulo");
            String ubictecn = po.getProperty("etiqueta.MU_UbicTecn");
            String masccodific = po.getProperty("etiqueta.MU_MascCodific");
            String nivjerarquico = po.getProperty("etiqueta.MU_NivJerarquicos");
            String indestructura = po.getProperty("etiqueta.MU_IndEstructura");

            String titulomatch = po.getProperty("etiqueta.MU_TituloMatch");
            String botonmatch = po.getProperty("etiqueta.MU_BotonMatch");
            
        %>

        <link rel="stylesheet" type="text/css" href="css/StyleMoUbiTec.css">
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title> Modificar Ubicación Tecnica </title>

        <script>
//            Valida un campo vacio
            function validar(event) {
                if (event.which == 13 || event.keyCode == 13) {
                    Validar();
                    return false;
                }
                return true;
            }

            function Validar() {
                var ubi1 = document.getElementById("ubi1");
                var ubi2 = document.getElementById("ubi2");
                var ubi3 = document.getElementById("ubi3");
                var ubi4 = document.getElementById("ubi4");
                var ubictecn = document.getElementById("UbicTecn");

                if (ubictecn.value == "" || ubictecn.value == 0) {
                    ubi1.style.color = "#3636F8";
                    ubi2.style.color = "#3636F8";
                    ubi3.style.color = "#3636F8";
                    ubi4.style.color = "#3636F8";

                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "Por favor, entre ubicación";
                    setTimeout(function () {
                        men.innerHTML = "";
                        iconm.style.visibility = "hidden";
                    }, 8000);
                } else {
                    alert("manda funcion para ver si existe en la bd");
                }
            }

            function regresar() {
                location.href = "Bienvenido.jsp";
            }
            
            //muestra ventana modal
            function mostrarVentanaModal(url, valor){
                var ventana = document.getElementById('VentanaModal');
                var ancho = 350;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.style.left = x + "px";
                ventana.style.top = y + "px";
                ventana.style.display = 'block';
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        document.getElementById("tableCont").innerHTML = xmlhttp.responseText;
                    }
                };
                xmlhttp.open("GET", url + "?id=" + valor, true);
                xmlhttp.send();
            }
            
            //Oculta ventana modal
            function ocultarVentana()
            {
                var ventana = document.getElementById('VentanaModal');
                ventana.style.display = 'none';
            }

        </script>

    </head>
    <body>

        <header id="ma-header">
            <hr class="lineainicial"/>
            <div class="encabezado">               
                <input id="menu" type="image" src="images/menu.PNG" /> 
                <input id="aceptar" type="image" src="images/aceptar.png" onclick="Validar();"/>                
                <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>               
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="regresar();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="regresar();"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="regresar();"/>
            </div>
            <div class="titulo"> <h1> <% out.println(titulo);%> </h1> </div>
        </header>

        <div class="general">
            <div id="global">

                <div style="width:100%;">
                    <div style="width: 100%; margin-top: 5%;">
                        <section class="caja">
                            <div class="user">
                                <label id="ubi1"> <% out.println(ubictecn);%> </label><input class="inputubicactecnica" id="UbicTecn" type="text" onkeypress="return validar(event)"/> 
                                <hr class="hrubicactecnica">
                            </div>
                            <div class="user">
                                <label id="ubi2"> <% out.println(masccodific);%> </label> <label id="MascCodific" class="texBlue">  </label>
                                <hr class="hrmasccodif">
                            </div>
                            <div class="user">
                                <label id="ubi3"><% out.println(nivjerarquico);%> </label> <label id="NivJerarquicos" class="texBlue2">  </label>
                                <hr class="hrmasccodif">
                            </div>
                            <br>
                            <div class="user">
                                <label id="ubi4"> <% out.println(indestructura);%> </label> <input class="inputindestructura" id="txtIndEstructura" type="text" onkeypress="return validar(event)"><input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentanaModal('listaEstructuraUbicacionTecnica', document.getElementById('txtIndEstructura').value)"/> <span style="width: 5px; position: absolute;" id="div_cop"></span> <input name="p1valid" id="p1valid" maxlength="1"  type="hidden"/> <label id="RIndEstructura" class="texBlue">  </label>
                                <hr class="hrmasccodif">
                            </div>
                        </section>
                    </div>
                </div>

            </div>
        </div>

        <footer>
            <div style="font-size: .8em;">
                <hr class="fecha" id="footerline">
                <span><input type="image" style="float:left;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <div  class="fecha">
                    <label id="fecha" name="fecha"></label><label>, </label> 
                    <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>

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
                        };

                        function bloq() {
                            document.getElementById('iconmsg').style.visibility = "hidden";
                            document.getElementById('guardar').disabled = true;
                        }

                    </script>
                </div>
            </div>
        </footer>
                        
                        
        <!--        Ventana Match-->
        <div id="VentanaModal" class="VentanaModal">

            <div id="handle"> <label id="TituloMatch"> <% out.println(titulomatch); %> </label> <div class="BotonCerrar_Matc" onclick="ocultarVentana();"><label >X</label></div></div>

            <div class="PanelBntMatch"><button> <% out.println(botonmatch); %> </button><hr></div>
<!--            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/btnokmatch.PNG" style="margin-right:-4%;" onclick="Aceptar();"/>
            </div>-->

            <div class = "container-datos">
                <form align="center">     
                    <div id="tableCont" class="tableContainer">

                    </div>
                </form>
            </div>
        </div>
            
            

    </body>

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>

</html>
