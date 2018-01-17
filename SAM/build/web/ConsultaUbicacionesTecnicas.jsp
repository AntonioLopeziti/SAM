<%-- 
    Document   : ConsultaUbicacionesTecnicas
    Created on : 9/06/2016, 01:41:27 PM
    Author     : Lu
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="AccesoDatos.ACC_UbicacionTecnica"%>
<%@page import="Entidades.ubicacion_tecnica"%>
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

            String titulo = po.getProperty("etiqueta.VU_Titulo");
            String ubicaciontecnica = po.getProperty("etiqueta.VU_UbicacionTecnica");

            String datosgenerales = po.getProperty("etiqueta.VU_DatosGenerales");
            String clase = po.getProperty("etiqueta.VU_Clase");
            String grupoautoriz = po.getProperty("etiqueta.VU_GrupoAutoriz");
            String peso = po.getProperty("etiqueta.VU_Peso");
            String tamanodimens = po.getProperty("etiqueta.VU_TamanoDimens");
            String ninventario = po.getProperty("etiqueta.VU_NInventario");
            String pstaenservdesde = po.getProperty("etiqueta.VU_PstaEnServDesde");

            String datosemplazamiento = po.getProperty("etiqueta.VU_DatosEmplazamiento");
            String ceemplazam = po.getProperty("etiqueta.VU_CeEmplazam");
            String emplazamiento = po.getProperty("etiqueta.VU_Emplazamiento");
            String areaempresa = po.getProperty("etiqueta.VU_AreaEmpresa");
            String puestotrabajo = po.getProperty("etiqueta.VU_PuestoTrabajo");
            String indicadorabc = po.getProperty("etiqueta.VU_IndicadorABC");

            String imputacion = po.getProperty("etiqueta.VU_Imputacion");
            String sociedad = po.getProperty("etiqueta.VU_Sociedad");
            String activofijo = po.getProperty("etiqueta.VU_ActivoFijo");
            String centrocoste = po.getProperty("etiqueta.VU_CentroCoste");

            String responsabilidades = po.getProperty("etiqueta.VU_Responsabilidades");
            String centroplanif = po.getProperty("etiqueta.VU_CentroPlanif");
            String grupoplanif = po.getProperty("etiqueta.VU_GrupoPlanif");
            String ptotbjoresp = po.getProperty("etiqueta.VU_PtoTbjoResp");

            String estructura = po.getProperty("etiqueta.VU_Estructura");
            String ubictecn = po.getProperty("etiqueta.VU_UbicTecn");
            String equiposuperior = po.getProperty("etiqueta.VU_EquipoSuperior");

            String titulomatch = po.getProperty("etiqueta.VU_TituloMatch");
            String botonmatch = po.getProperty("etiqueta.VU_BotonMatch");

        %>
        <link rel="stylesheet" type="text/css" href="css/StyleUbicaciones.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>


        <title>Vizualizar Datos Maestros de Ubicaciones Tecnicas </title>
    </head>
    <body>


        <!--   -->
        <script language="JavaScript" type="text/javascript">
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("tableContainer").innerHTML = xmlhttp.responseText;
                }
            };
            xmlhttp.open("GET", "peticionUbtecEq?", true);
            xmlhttp.send();
        </script>

        <!-- Script para mostrar MATCH  -->
        <script>

            function mostrarVentanaModal(url, valor)
            {

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

            function ocultarVentana()
            {
                var ventana = document.getElementById('VentanaModal');
                ventana.style.display = 'none';
            }


//          validacion de un campo vacio
            function validar(event) {
                if (event.which == 13 || event.keyCode == 13) {
                    Validar();
                    return false;
                }
                return true;
            }

            function Validar() {
                var ubitec = document.getElementById("idUbiTec");
                if (ubitec.value == "" || ubitec.value == 0)
                {
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = "Complete todos los campos vacios";
                    setTimeout(function () {
                        men.innerHTML = "";
                        iconm.style.visibility = "hidden";
                    }, 8000);
                } else
                {
                    enviarDatos(ubitec.value);
                }
            }

            function enviarDatos(ubitec) {

                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        var rs = xmlhttp.responseText;
                        var men = document.getElementById("msg");
                        if (rs == 1) {

                            recibeDatos(ubitec);
                        } else {
                            document.getElementById("idUbiTec").value = "";
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            men.innerHTML = "Ubicacion de la Tecnica Incorrecta, Verifique por favor";
                            setTimeout(function () {
                                men.innerHTML = "";
                                iconm.style.visibility = "hidden";
                            }, 8000);
                        }
                    }
                };
                xmlhttp.open("GET", "peticionValidaUbiTec?idUbiTec=" + ubitec, true);
                xmlhttp.send();

            }

            //Recibe los datos de un servlet
            function recibeDatos(uh) {

                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        var res = xmlhttp.responseText;
                        document.getElementById("glob").innerHTML = res;
                        cargarDatos();
                    }
                };
                xmlhttp.open("GET", "peticionUbicTecnica?idUbiTec=" + uh, true);
                xmlhttp.send();

            }


            function cargarDatos() {

                var idubitec = document.getElementById("idUbiTe").value;
                document.getElementById("idUbiTec").value = idubitec;
                var desubitec = document.getElementById("DesUbiTe").value;
                document.getElementById("DesUbiTec").value = desubitec;

                var grupoautoriz = document.getElementById("GrupoAutori").value;
                document.getElementById("GrupoAutoriz").value = grupoautoriz;

                var ceemplazam = document.getElementById("CeEmplaza").value;
                document.getElementById("CeEmplazam").value = ceemplazam;
                var emplazamiento = document.getElementById("Emplazamient").value;
                document.getElementById("Emplazamiento").value = emplazamiento;
                var areaempresa = document.getElementById("AreaEmpres").value;
                document.getElementById("AreaEmpresa").value = areaempresa;

                var sociedad = document.getElementById("Socieda").value;
                document.getElementById("Sociedad").value = sociedad;
                var centro = document.getElementById("Centr").value;
                document.getElementById("Centro").value = centro;
                var sociedadcc = document.getElementById("SociedadC").value;
                document.getElementById("SociedadCC").value = sociedadcc;

                var centroplanif = document.getElementById("CentroPlani").value;
                document.getElementById("CentroPlanif").value = centroplanif;
                var grupoplanif = document.getElementById("GrupoPlani").value;
                document.getElementById("GrupoPlanif").value = grupoplanif;

                var ubictecn = document.getElementById("UbicTec").value;
                document.getElementById("UbicTecn").value = ubictecn;

            }


            function validarubi(variable)
            {

                if (variable == null || variable == 0)
                {
                    var btnSav = document.getElementById("div_cop");
                    btnSav.style.visibility = 'hidden';
                } else
                {
                    showubic(variable);
                }

            }

            function GetXmlHttpObject() {
                var xmlHttp = null;
                try {
                    // Firefox, Opera 8.0+, Safari 
                    xmlHttp = new XMLHttpRequest();
                } catch (e) {
                    // Internet Explorer 
                    try {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e) {
                        }
                    }
                }
                return xmlHttp;
            }

        </script>
        <!-- Terminacion para mostrar MATCH -->

        <!-- Seguimiento del MATCH -->
        <script>
            function buscar(us)
            {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                    {
                        document.getElementById("tableContainer").innerHTML = xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET", "peticionubitecequ?q=" + us, true);
                xmlhttp.send();
            }

            function abrirventana2(url, ancho, alto)
            {

                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                window.open(url, 'po p up', 'width=' + ancho + ', height=' + alto + ', left=' + x + ', top=' + y + ', toolbar=no, scrollbar=yes,RESIZABLE=NO');
            }


            function seleccion1(ubi) {
                document.getElementById("idUbiTec").value = ubi;
                ocultarVentana();
            }

            function Aceptar() {
                document.getElementById("idUbiTec").value = ubi;
                ocultarVentana();
            }


        </script>
        <!--        Script para los botones-->
        <script>
            function regresar() {
                location.href = "Bienvenido.jsp";
            }

            function Limpiar() {

                document.getElementById("idUbiTec").value = "";
                document.getElementById("DesUbiTec").value = "";

                document.getElementById("Clase").value = "";
                document.getElementById("GrupoAutoriz").value = "";
                document.getElementById("Peso").value = "";
                document.getElementById("TamanoDimens").value = "";
                document.getElementById("NInventario").value = "";

                document.getElementById("PstaenServ").value = "";

                document.getElementById("CeEmplazam").value = "";
                document.getElementById("Emplazamiento").value = "";
                document.getElementById("AreaEmpresa").value = "";
                document.getElementById("PuestoTrabajo").value = "";
                document.getElementById("IndicadorABC").value = "";

                document.getElementById("Sociedad").value = "";
                document.getElementById("ActivoFijo").value = "";
                document.getElementById("ActivoFijoDos").value = "";
                document.getElementById("CentroCoste").value = "";
                document.getElementById("CentroCosteDos").value = "";

                document.getElementById("CentroPlanif").value = "";
                document.getElementById("GrupoPlanif").value = "";
                document.getElementById("PtoTbjoResp").value = "";
                document.getElementById("PtoTbjoRespDos").value = "";

                document.getElementById("UbicTecn").value = "";
                document.getElementById("EquipoSuperior").value = "";
            }
        </script>


        <!-- Encabezado -->
        <header id="ma-header">
            <hr class="lineainicial"/>
            <div class="encabezado">               
                <input id="menu" type="image" src="images/menu.PNG" /> 
                <input id="aceptar" type="image" src="images/aceptar.png" onclick="Validar();"/>                
                <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>               
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="regresar();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="regresar();"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="Limpiar();"/>
            </div>
            <div class="titulo"> <h1> <% out.println(titulo); %> </h1> </div>
        </header>



        <div id="glob"hidden></div> 
        <div id="global">
            <div style="width: 100%;">

                <section class="caja">
                    <div class="content">
                        <div class="tituloLab"> <label> <% out.println(ubicaciontecnica);%> </label> </div>
                        <hr class="lineaUbic">
                        <div>
                            <input style="width: 45%;" id="idUbiTec" type="text" onkeypress="return validar(event)"/> <input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentanaModal('peticionlistaequipos', document.getElementById('idUbiTec').value)"/> <span style="width: 5px; position: absolute;" id="div_cop"></span> <input name="p1valid" id="p1valid" maxlength="1"  type="hidden"/>  <input style="width: 45%;" disabled id="DesUbiTec" type="text" value="">
                        </div>
                    </div>
                </section>

                <section class="caja">
                    <div class="content">   
                        <div class="tituloLab"> <label> <% out.println(datosgenerales);%> </label> </div>
                        <hr class="lineaUbic">

                        <div class="user">
                            <label> <% out.println(clase);%> </label> <input style="width: 25%;" class="espacioLinea" disabled id="Clase" align="right" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(grupoautoriz);%> </label> <input style="width: 15%;" disabled class="espacioLinea" id="GrupoAutoriz" align="right" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(peso);%> </label> <input style="width: 20%; margin-right: 5%;" class="espacioLinea" disabled id="Peso" align="right" type="text" value="0,000"> <label> <% out.println(tamanodimens);%> </label> <input disabled style="width: 20%;" id="TamanoDimens" align="right" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <div>
                                <label> <% out.println(ninventario);%> </label> <input class="espacioLinea" disabled style="width: 20%; margin-right: 5%;" disabled id="NInventario" align="right" type="text"> <label> <% out.println(pstaenservdesde);%> </label> <input disabled style="width: 15%;" id="PstaenServ" align="right" type="text">
                                <hr class="linealab">
                            </div>
                        </div>
                    </div>
                </section>

                <section class="caja">
                    <div class="content">
                        <div class="tituloLab"> <label> <% out.println(datosemplazamiento);%> </label> </div>
                        <hr class="lineaUbic">
                        <div class="user">
                            <label> <% out.println(ceemplazam);%> </label> <input class="espacioLinea" disabled style="width: 10%;" id="CeEmplazam" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(emplazamiento);%> </label> <input class="espacioLinea" disabled style="width: 18%;" id="Emplazamiento" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(areaempresa);%> </label> <input class="espacioLinea" disabled style="width: 10%;" id="AreaEmpresa" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(puestotrabajo);%> </label> <input class="espacioLinea" disabled style="width: 15%;" id="PuestoTrabajo" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(indicadorabc);%> </label> <input class="espacioLinea" disabled style="width: 8%;" id="IndicadorABC" type="text">
                            <hr class="linealab">
                        </div>
                    </div>
                </section>

                <section class="caja">
                    <div class="content">
                        <div class="tituloLab"> <label> <% out.println(imputacion);%> </label> </div>
                        <hr class="lineaUbic">
                        <div class="user">
                            <label> <% out.println(sociedad);%> </label> <input style="width: 10%;" disabled class="espacioLinea" id="Sociedad" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(activofijo);%> </label> <input disabled style="width: 20%; margin-right: 1%;" class="espacioLinea" id="ActivoFijo" type="text">/<input disabled style="width: 10%; margin-left: 1%;" id="ActivoFijoDos" align="right" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(centrocoste);%> </label> <input disabled style="width: 18%; margin-right: 1%;" class="espacioLinea" id="Centro" align="right" type="text">/<input disabled style="width: 10%; margin-left: 1%;" id="SociedadCC" type="text">
                            <hr class="linealab">
                        </div>
                    </div>
                </section>

                <section class="caja">
                    <div class="content">
                        <div class="tituloLab"> <label> <% out.println(responsabilidades);%> </label> </div>
                        <hr class="lineaUbic">
                        <div class="user">
                            <label> <% out.println(centroplanif);%> </label> <input disabled style="width: 10%;" class="espacioLinea" id="CentroPlanif" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(grupoplanif);%> </label> <input disabled style="width: 10%;" class="espacioLinea" id="GrupoPlanif" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(ptotbjoresp);%> </label> <input disabled style="width: 15%;" class="espacioLinea" id="PtoTbjoResp" type="text"> <input disabled style="width: 10%;" id="PtoTbjoRespDos" align="right" type="text">
                            <hr class="linealab">
                        </div>
                    </div>
                </section>

                <section class="caja">
                    <div class="content">
                        <div class="tituloLab"> <label> <% out.println(estructura);%> </label> </div>
                        <hr class="lineaUbic">
                        <div class="user">
                            <label> <% out.println(ubictecn);%> </label> <input disabled style="width: 35%;" class="espacioLinea"  id="UbicTecn" type="text">
                            <hr class="linealab">
                        </div>
                        <div class="user">
                            <label> <% out.println(equiposuperior);%> </label> <input disabled style="width: 15%;" class="espacioLinea" id="EquipoSuperior" type="text">
                            <hr class="linealab">
                        </div>
                    </div>
                </section>

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

        <!-- Para abrir el MATCH -->
        <div id="VentanaModal" class="VentanaModal">

            <div id="handle"> <label id="TituloMatch"> <% out.println(titulomatch); %> </label> <div class="BotonCerrar_Matc" onclick="ocultarVentana();"><label >X</label></div></div>
            <div class="PanelBntMatch"><button> <% out.println(botonmatch); %> </button><hr></div>

            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/btnokmatch.PNG" style="margin-right:-4%;" onclick="Aceptar();"/>
            </div>
            <div class = "container-datos">
                <form align="center">     
                    <div id="tableCont" class="tableContainer">

                    </div>
                </form>
            </div>
        </div>
        <!-- Terminacion del MATCH -->


    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
