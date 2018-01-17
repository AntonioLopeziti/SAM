
<%@page import="AccesoDatos.ACC_Usuarios"%>
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
                response.sendRedirect("#");
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
                var pag = p.charAt(75);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StylePlsnOrden.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.TiutloVisDocVDL"));%></title>  
    <body>
        <div id="main-header"> 
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled/> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="fin();"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="fin();"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TiutloVisDocVDL"));%></h1></div>
        </div>
        <div class="contenido">
            <div class="ContentDoc">
                <div class="gen">
                    <label class="labelTitulo"> BAJAFERRIES </label> <br>
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
                                var fechaActu = "Period: " + meses[f.getMonth()] + " Exercise: " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time " + f.getHours() + ":" + minut + ":" + f.getSeconds();
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
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td><%out.println(po.getProperty("etiqueta.Ord_LO"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ClasOrd_LO"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ListaOrDEIEx"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.NPMTextobreve"));%></td>
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

                        //MEnsaje de correcto
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        startTime();
                        validar();
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
    <script>
        var matchM = "";
        function back() {
            window.location.href = "ListaOrdenes.jsp";
        }
        function fin() {
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
        function seleccionarOrden(orden) {
            var acc = "Checksap";
            $.ajax({
                async: false,
                type: "GET",
                url: "PeticionPlanOrden",
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + "&orden=" + orden,
                success: function (data) {
                    if (data == 1) {
                        window.location.href = "VisualizarOrdenes2.jsp?ord=" + orden + "&peticion=peticionVisualizarOrdenes&tipo=1";
                    } else {
                        window.location.href = "VisualizarOrdenes2.jsp?ord=" + orden + "&peticion=peticionVisualizarCreaOrdenes&tipo=2";
                    }
                }
            });
        }
        function validar() {

            var status1 = getParameterByName('status1');
            var status2 = getParameterByName('status2');
            var status3 = getParameterByName('status3');
            VacioTodo(status1, status2, status3);
        }
        function getParameterByName(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                    results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }
        function VacioTodo(st1, st2, st3) {
            var ur = "PeticionPlanOrden";
            if (st1 && st2 == "" && st3 == "") {
                var ur = "PeticionPlanOrden";
                var acc = "ConsultaUno";
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
                        var okcon = "<%=OKconsul%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.png";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    }
                };
                xmlhttp.open("GET", ur + "?Action=" + acc + "&MiStatus1=" + st1 + "&MiStatus2='' &MiStatus3=''", true);
                xmlhttp.send();

            } else if (st1 && st2 && st3 == "") {
                var ur = "PeticionPlanOrden";

                var acc = "ConsultaDos";
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
                        var okcon = "<%=OKconsul%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.png";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    }
                };
                xmlhttp.open("GET", ur + "?Action=" + acc + "&MiStatus1=" + st1 + "&MiStatus2=" + st2 + "&MiStatus3=''", true);
                xmlhttp.send();
            } else if (st1 && st2 && st3) {
                var ur = "PeticionPlanOrden";

                var acc = "ConsultaTres";
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
                        var okcon = "<%=OKconsul%>";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/aceptar.png";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    }
                };
                xmlhttp.open("GET", ur + "?Action=" + acc + "&MiStatus1=" + st1 + "&MiStatus2=" + st2 + "&MiStatus3=" + st3, true);
                xmlhttp.send();
            } else {

                var orden = getParameterByName('orden');
                var orden2 = getParameterByName('orden2');
                var clase = getParameterByName('clase');
                var ubicacion = getParameterByName('ubicacion');
                var equipo = getParameterByName('equipo');
                var accion = getParameterByName('accion');
                switch (accion) {
                    case "uno":
                        var ur = "PeticionPlanOrden";
                        var acc = "ConsultaValidar4";
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
                                var rs1 = xmlhttp.responseText;
                                if (rs1 == 1) {
                                    location.href = "ListaOrdenes.jsp";
                                } else {
                                    document.getElementById("SecCuerpo").innerHTML = xmlhttp.responseText;
                                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                                    var okcon = "<%=OKconsul%>";
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/aceptar.png";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = okcon;
                                }

                            }
                        };
                        //  xmlhttp.open("GET", ur + "?Action=" + acc + "&MiStatus1=" + st1 + "&MiStatus2=" + st2 + "&MiStatus3=" + st3 , true);
                        xmlhttp.open("GET", ur + "?Action=" + acc + "&orden=" + orden + "&clase=" + clase + "&ubicacion=" + ubicacion + "&equipo=" + equipo, true);

                        xmlhttp.send();

                        break;
                    case "dos":
                        var ur = "PeticionPlanOrden";
                        var acc = "orden2";
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
                                var okcon = "<%=OKconsul%>";
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.visibility = "visible";
                                iconm.src = "images/aceptar.png";
                                var men = document.getElementById("msg");
                                men.innerHTML = okcon;


                            }
                        };
                        //  xmlhttp.open("GET", ur + "?Action=" + acc + "&MiStatus1=" + st1 + "&MiStatus2=" + st2 + "&MiStatus3=" + st3 , true);
                        xmlhttp.open("GET", ur + "?Action=" + acc + "&orden=" + orden + "&orden2=" + orden2, true);

                        xmlhttp.send();
                        break;
                }


            }
        }
        function ConsultaFilt(mat1, mat2, centro, alm, lote, prov, clasm, lim) {
            var ur = "peticionAllDocumentosLstMaterial";
            var acc = "ConsultaFiltrada";
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
                    var okcon = "<%=OKconsul%>";
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
        function Select(id) {
            vali(id);
        }
        function vali(id) {
            if (id === null) {
                ErrorBusquedaMatch();
            } else {
                location.href = "VisualizarDocumentosLstMaterial2.jsp?MiId=" + id;
                enviarID(id);
            }
        }
        function enviarID(id) {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    var men = document.getElementById("msg");
                    if (rs == 1) {
                        location.href = "VisualizarDocumentosLstMaterial2.jsp?MiId=" + id;
                    } else {
                        document.getElementById("material_DLM").value = "";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";

                    }
                }
            };
            xmlhttp.open("GET", "peticionAllDocumentosLstMaterial?ID=" + id, true);
            xmlhttp.send();
        }
        function selCol(obj, cant) {

            if (cant > 0) {
                document.getElementById(obj).style.background = "rgb(162,215,186)";
            } else {
                document.getElementById(obj).style.background = "rgb(255,152,140)";
            }
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