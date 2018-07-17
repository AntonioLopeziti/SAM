<%-- 
    Document   : VisualizarReporteNotificaciones
    Created on : 28/08/2016, 12:54:29 PM
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
        String sam = (String) session.getAttribute("SAM");
        String sam2 = (String) session.getAttribute("SAM1");
        String sap = (String) session.getAttribute("SAP");
        String ord = (String) session.getAttribute("ORD");
        String ord2 = (String) session.getAttribute("ORD2");
        String ope = (String) session.getAttribute("OPE");
        String ope2 = (String) session.getAttribute("OPE2");
        String centro = (String) session.getAttribute("CENTRO");
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
                var pag = p.charAt(10);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <title><%out.println(po.getProperty("etiqueta.ReporteNotif_Title"));%></title>       
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
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="retorn();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="back();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>         
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteNotif_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> SANPER </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%> </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
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
                                var fechaActu = "Period: " + meses[f.getMonth()] + " Exercise " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                                ;
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else {
                                var fechaActu = "Fecha indefinida";
                            }
                        </script>
                    </div>
                </div>
                <div id="general" class="general">
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_horadia"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_fechap"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_NotParFin"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_NumOrden"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.Reporte_NumOperacion"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.RecibidoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ProcesadoRetSAP"));%></td>
                                                <td><%out.println(po.getProperty("etiqueta.ErroroRetSAP"));%></td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">
                                </section>
                            </section>
                        </section>
                    </div>
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
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
                        Correr();
                        $("#DobleSection").scroll(function () {
                            $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                        });
                        $("#SecCuerpo").scroll(function () {
                            $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                        });
                    };
                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                        document.getElementById('guardar').disabled = true;
                    }

                </script>
            </div>
        </footer>
    </body>

    <script language="javascript">
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
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
        }
        function retorn() {
            window.location.href = "ReporteNotificaciones.jsp";
        }
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
        }
        function Correr() {
            var sam1 = "<%=sam%>";
            var sam2 = "<%=sam2%>";
            var sap = "<%=sap%>";
            var ord = "<%=ord%>";
            var ord2 = "<%=ord2%>";

            var ope = "<%=ope%>";
            var ope2 = "<%=ope2%>";
            var centro = "<%=centro%>";
            if (sam1 == "" && sam2 == "" && sap == "" && ord == "" && ord2 == "" && ope == "" && ope2 == "" && centro == "") {
                Vacio();
            } else if (sam1 == "" && sam2 != "") {//derecho SAM
                SAMDerecho();
            } else if (sam1 != "" && sam2 == "") {//izquierdo SAM
                SAMIzquierdo();
            } else if (sam1 != "" && sam2 != "") {//SAM LOS DOS
                SAMDerecho();
            } else if (ord == "" && ord2 != "") {//Busqueda por numero de orden derecho
                ORDRangos();
            } else if (ord != "" && ord2 != "") {
                ORDRangos();
            } else if (ord != "" && ord2 == "") {
                ORD();
            } else if (ope != "" && ope2 == "") {
                OPE();
            } else if (ope == "" && ope2 != "") {
                OPERangos();
            } else if (ope != "" && ope2 != "") {
                OPERangos();
            } else if (sap != "" && ord != "") {//izquierdo SAP
                SAPIzquierdo()
            } else if (sam1 != "" && sam2 != "" && sap != "" && ord != "" && ord2 != "" && ope != "" && ope2 != "" && centro != "") {
                TODOS();
            } else if (centro != "") {
                Centro();
            }
        }
        function Vacio() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaVacia";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function SAMDerecho() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaRangosSAM";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function SAMIzquierdo() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaSAM";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function SAMDOS() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "Consulta2SAM";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function SAPIzquierdo() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaSAP";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Action=" + acc, true);
            xmlhttp.send();
        }
        function TODOS() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "Todos";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Action=" + acc, true);
            xmlhttp.send();
        }
        function Centro() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaCentro";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function ORDRangos() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaRangosORD";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function ORD() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaORD";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function ORDvalores() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaORDvalores";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function OPE() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaOPE";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function OPERangos() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaOPERangos";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
        function OPEvalores() {
            var ur = "PeticionVisualizarReportesNotificaciones";
            var acc = "ConsultaORDvalores";
            var ventana = document.getElementById('general');
            var ancho = 750;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    var okcon = "<%=okconsu%>";
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                }
            };
            xmlhttp.open("GET", ur + "?Accion=" + acc, true);
            xmlhttp.send();
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
