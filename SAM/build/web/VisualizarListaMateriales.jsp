<%-- 
    Document   : VisualizarListaMateriales
    Created on : 8/08/2016, 01:01:46 PM
    Author     : Developer-Antonio
--%>

<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String compl = po.getProperty("eitiqueta.Mensaje_FO");
        String existFol = po.getProperty("etiqueta.MensajeNoExiste_FO");
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

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleListaMaterial.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarListaMateriales.js"></script>  
        <title>Visualizar Lista de Materiales</title>       
    <body>
        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                        </li>
                    </ul>
                </div>
                <input id="aceptar" type="image" src="images/aceptar.png"/>                
                <input id="guardar" type="image" src="images/guardaOFF.png" /> 
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png"/>
                <input  id="cancelar" type="image" src="images/cancelaOFF.png"/>
            </div>
            <script>
                function back() {
                    window.location.href = "Bienvenido.jsp";
                }
                function inval() {
                    var funin = '<%=funcioninv%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = funin;
                }
            </script>
            <div id="Conte" hidden></div> 
            <div class="contenido">
                <div class="titulo"><h1>Visualizar Lista Materiales</h1></div>      
                <div class="ContenidoScrollbar">
                    <div class="ContentFolios">               
                        <section class="BuscarLM">
                            <label>Equipo</label><input style="width: 30%; background-repeat: no-repeat;" type="text" id="equipo"/><button id="btnmat1" class='BtnMatchIcon'></button><input class="DescLM" type="text" id="DesEquipo"/>
                            <hr>
                            <label>Centro</label><input maxlength="4" style="width: 10%; background-repeat: no-repeat;" type="text" id="centro"/><button id="btnmat2" class='BtnMatchIcon2'></button><input class="DescLM" type="text" id="DesCentro"/>
                            <hr>
                            <label>Utilización</label><input style="width: 5%; background-repeat: no-repeat;" tyoe="text" id="utilizacion"/><button id="btnmat3" class='BtnMatchIcon'></button><input class="DescLM" type="text" id="DesUtil"/>
                            <hr>
                        </section> 
                        <section class="valideLM">
                            <label>Validez</label>
                            <hr id="lineatiutloLM">
                            <section class="validezsubLM">
                                <label>Número de modificación</label><input type="text"/><button id="btnmat4" class='BtnMatchIcon'></button>
                                <hr>
                                <label>Válido de</label><input type="text"/>
                                <hr>
                                <label>Fin de validez</label><input type="text"/>
                                <hr>
                            </section>
                        </section>
                    </div>
                    <script language="javascript">

                        function borrarmsg() {
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "hidden";
                            var men = document.getElementById("msg");
                            men.innerHTML = "";
                        }
                        function ConsultarEquipos() {
                            //alert("hello");
                            var url = 'peticionModuloListaMateriales';
                            var acc = "ConsultarEquipo";
                            var idioma = '<%=Idioma%>';
                            var equ = document.getElementById("EquipoBus").value;
                            var dequ = document.getElementById("DenEquipoBus").value;
                            var ctd = document.getElementById("numAcMax").value;
                            var xmlhttp = new XMLHttpRequest();
                            xmlhttp.onreadystatechange = function () {
                                var rs = xmlhttp.responseText;
                                if (rs == 0) {

                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/aceptar.png";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "No existen valores";
                                } else {
                                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                        document.getElementById("BuscarParamEq").style.display = "none";
                                        document.getElementById("ConsultaTablaEquipo").style.display = "block";
                                        document.getElementById("cargarDatosEquipo").innerHTML = rs;
                                        fnc();
                                        borrarmsg();
                                    }
                                }
                            };
                            xmlhttp.open("GET", url + "?Acc=" + acc + "&Equipo=" + equ + "&DenEquipo=" + dequ + "&CtdAcc=" + ctd + "&idioma=" + idioma, true);
                            xmlhttp.send();
                        }
                        function ConsultarCentros() {
                            //alert("hello");
                            var url = 'peticionModuloListaMateriales';
                            var acc = "ConsultarCentro";
                            var idioma = '<%=Idioma%>';
                            var cen = document.getElementById("CentroBus").value;
                            var ncen = document.getElementById("NCentroBus").value;
                            var ctd = document.getElementById("numAcMax2").value;
                            var xmlhttp = new XMLHttpRequest();
                            xmlhttp.onreadystatechange = function () {
                                var rs = xmlhttp.responseText;
                                if (rs == 0) {

                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/aceptar.png";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "No existen valores";
                                } else {
                                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                        document.getElementById("BuscarParamCen").style.display = "none";
                                        document.getElementById("ConsultaTablaCentro").style.display = "block";
                                        document.getElementById("cargarDatosCentro").innerHTML = rs;
                                        fnc2();
                                        borrarmsg();
                                    }
                                }
                            };
                            xmlhttp.open("GET", url + "?Acc=" + acc + "&Centro=" + cen + "&NCentro=" + ncen + "&CtdAcc=" + ctd + "&idioma=" + idioma, true);
                            xmlhttp.send();
                        }

                        function Select(obj, tipo) {
                            switch (tipo) {
                                case "Equipo":
                                    var e = document.getElementById("equipo");
                                    e.value = obj;
                                    e.focus();
                                    ocultarVentana('Equipo');
                                    break;
                                case "Centro":
                                    var c = document.getElementById("centro");
                                    c.value = obj;
                                    c.focus();
                                    ocultarVentana('Centro');
                                    break;
                            }
                        }

                        function  CargaDatos() {

                            var fol = document.getElementById("perfihr").value;
                            var fo = fol.toUpperCase();
                            if (fo.length < 1) {
                                var menCam = "<%=compl%>";
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.visibility = "visible";
                                iconm.src = "images/advertencia.PNG";
                                var men = document.getElementById("msg");
                                men.innerHTML = menCam;
                                Limpiar();
                            } else {
                                var url = 'peticionConsultarFolio';
                                var acc = "CargarDatosFolios";
                                var xmlhttp = new XMLHttpRequest();
                                xmlhttp.onreadystatechange = function () {
                                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                        rs = xmlhttp.responseText;
                                        if (rs == 0) {
                                            Limpiar();
                                            var menCam = "<%=existFol%>";
                                            var iconm = document.getElementById("iconmsg");
                                            iconm.style.visibility = "visible";
                                            iconm.src = "images/advertencia.PNG";
                                            var men = document.getElementById("msg");
                                            men.innerHTML = menCam + " " + fo;
                                        } else {
                                            document.getElementById("cargarDatos").innerHTML = rs;
                                            MostrarDatos();
                                            var okcon = "<%=OKconsul%>";
                                            var iconm = document.getElementById("iconmsg");
                                            iconm.style.visibility = "visible";
                                            iconm.src = "images/aceptar.png";
                                            var men = document.getElementById("msg");
                                            men.innerHTML = okcon;
                                        }
                                    }
                                };
                                xmlhttp.open("GET", url + "?Acc=" + acc + "&Folio=" + fo, true);
                                xmlhttp.send();
                            }
                        }
                        function Limpiar()
                        {
                            var f1 = document.getElementById('perfihr');
                            f1.value = "";
                            var f2 = document.getElementById('fio');
                            f2.value = "";
                            var f3 = document.getElementById('ffo');
                            f3.value = "";
                            var f2 = document.getElementById('fao');
                            f2.value = "";
                        }
                        function MostrarDatos() {
                            var f1 = document.getElementById('IdFolio_F1').value;
                            document.getElementById('perfihr').value = f1;
                            var f2 = document.getElementById('FolioInicial_F1').value;
                            document.getElementById('fio').value = f2;
                            var f3 = document.getElementById('FolioActual_F1').value;
                            document.getElementById('ffo').value = f3;
                            var f4 = document.getElementById('Folio_Final_F1').value;
                            document.getElementById('fao').value = f4;
                        }
                        function mostrarVentanaModal(tipo) {
                            switch (tipo) {
                                case "Equipo":
                                    var ventana = document.getElementById('VentanaModalEquipo');
                                    abrirVentana(ventana);
                                    var txt1 = document.getElementById('EquipoBus');
                                    txt1.focus();
                                    borrarmsg();
                                    break;
                                case "Centro":
                                    var ventana = document.getElementById('VentanaModalCentro');
                                    abrirVentana(ventana);
                                    var txt2 = document.getElementById('CentroBus');
                                    txt2.focus();
                                    borrarmsg();
                                    break;
                            }
                        }
                        function abrirVentana(ventana) {
                            var ancho = 350;
                            var alto = 650;
                            var x = (screen.width / 2) - (ancho / 2);
                            var y = (screen.height / 2) - (alto / 2);
                            ventana.style.left = x + "px";
                            ventana.style.top = y + "px";
                            ventana.style.display = 'block';
                        }


                        function ocultarVentana(w)
                        {
                            switch (w) {
                                case "Equipo":
                                    var ventana = document.getElementById('VentanaModalEquipo');
                                    ventana.style.display = 'none';
                                    document.getElementById("BuscarParamEq").style.display = "block";
                                    document.getElementById("ConsultaTablaEquipo").style.display = "none";
                                    break;
                                case "Centro":
                                    var ventana = document.getElementById('VentanaModalCentro');
                                    ventana.style.display = 'none';
                                    document.getElementById("BuscarParamCen").style.display = "block";
                                    document.getElementById("ConsultaTablaCentro").style.display = "none";
                                    break;

                            }
                        }
                        function fnc() {
                            document.getElementById('table-scrollEquipo').onscroll = function () {
                                document.getElementById('fixedYEquipo').style.top = document.getElementById('table-scrollEquipo').scrollTop + 'px';
                            };
                        }
                        function fnc2() {
                            document.getElementById('table-scrollCentro').onscroll = function () {
                                document.getElementById('fixedYCentro').style.top = document.getElementById('table-scrollCentro').scrollTop + 'px';
                            };
                        }

                        function ValidarMaximo(num) {
                            if (num >= 100) {
                                document.getElementById("numAcMax").value = 100;
                                document.getElementById("numAcMax2").value = 100;
                            } else if (num < 1) {
                                document.getElementById("numAcMax").value = 100;
                                document.getElementById("numAcMax2").value = 100;
                            }
                        }

                    </script>

                    <div id="VentanaModalEquipo" class="VentanaModal">
                        <div id="handle"><label id="TituloMatch">Número de equipo</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Equipo');"><label >X</label></div></div>
                        <div class="PanelBntMatch"><button>Equipos</button><hr></div>
                        <div id="BuscarParamEq" class="BuscarParam_u">
                            <div class="fondo_Match">
                                <div class="busquedaMatch">
                                    <label>Num.Equipo</label><input type="text" id="EquipoBus" style="width:35%;"/>
                                    <hr>
                                    <label>Den.Equipo</label><input type="text" id="DenEquipoBus" style="width:35%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                                    <hr>
                                </div>        
                            </div> 
                            <div class="Botones_Match">
                                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                                <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; cursor: pointer; margin-top: -1%;"/>
                                <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('Equipo');"/>
                            </div>
                        </div>
                        <div id="ConsultaTablaEquipo" style="display: none;">
                            <div class="tablaCab">
                                <div class="table-scroll" id="table-scrollEquipo">
                                    <div class="fixedY" id="fixedYEquipo">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th>Número Equipo</th><th>Denominación Equipo</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div id="cuerpoDatos">
                                        <div class="nofixedX" id="cargarDatosEquipo">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="VentanaModalCentro" class="VentanaModal">
                        <div id="handle2"><label id="TituloMatch">Centro</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Centro');"><label >X</label></div></div>
                        <div class="PanelBntMatch"><button>Restricciones</button><hr></div>
                        <div id="BuscarParamCen" class="BuscarParam_u">
                            <div class="fondo_Match">
                                <div class="busquedaMatch">
                                    <label>Centro</label><input type="text" id="CentroBus" style="width:35%;"/>
                                    <hr>
                                    <label>Nombre 1</label><input type="text" id="NCentroBus" style="width:35%;"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="number" min="1"  id="numAcMax2" max="100" value="100" style="width:10%;" onblur="ValidarMaximo(this.value);"/>
                                    <hr>
                                </div>        
                            </div> 
                            <div class="Botones_Match">
                                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCentro"/>
                                <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; cursor: pointer; margin-top: -1%;"/>
                                <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('Centro');"/>
                            </div>
                        </div>
                        <div id="ConsultaTablaCentro" style="display: none;">
                            <div class="tablaCab">
                                <div class="table-scroll" id="table-scrollCentro">
                                    <div class="fixedY" id="fixedYCentro">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th>Centro</th><th>Nombre 1</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div id="cuerpoDatos">
                                        <div class="nofixedX" id="cargarDatosCentro">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script language="javascript">
                        var theHandle = document.getElementById("handle");
                        var theRoot = document.getElementById("VentanaModal");
                        Drag.init(theHandle, theRoot);
                    </script>

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
            </footer>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>