<%-- 
    Document   : VisualizaDocumentoDatos
    Created on : 9/12/2016, 12:56:49 PM
    Author     : Panda
--%>

<%@page import="java.net.URL"%>
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

        String Folio = request.getParameter("FolioMO");
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String existFol = po.getProperty("etiqueta.NoexisteEquipoEQ");
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
    <%        String Accion = request.getParameter("Action");
        String equip = request.getParameter("equip");
        String cnt = request.getParameter("centroo");
        String ubte = request.getParameter("ubte");
        String avi = request.getParameter("avi");
        String loi = request.getParameter("loi");
        String cmv = request.getParameter("cmv");
        String msgg = request.getParameter("msgg");
        String valeq = request.getParameter("valeq");
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
                var pag = p.charAt(82);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleVisualizaDocsD.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarDocsD.js"></script>
        <title>Visualizar Documentos: Datos Básicos</title>
    </head>
    <body>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>
            <input id="guardar" type="image" src="images/guarda.PNG" disabled />
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1>Visualizar documento: Datos básicos Evidencia de Calidad</h1></div>
        </div>
        <div class="contenido">
            <section id="FrameContainer" style="display: none">

                <!--<iframe style="margin-top: -60px" src="Filess/USER EXIT FB60.pdf"></iframe>-->
                <!--<iframe src="Filess/ZGUARDA_AVISOS.htm" width="1250px" height="480px"></iframe>-->
            </section>
            <section id="ContentBk">
                <div class="bkcontainer">
                    <div class="bkn1">
                        <label>Documento</label>
                        <hr class="lnMov">

                        <div class="bknn1">
                            <label id="bknLabDoc"></label>
                            <input type="text" class="bxlarge" id="bxDocumento" style="text-transform: uppercase;" maxlength='4' /> 
                            <label id="DescVisDooc" style="width: 45%;margin-left: 2%;"></label>                                                         
                            <hr class="hrContainer">
                            <!--                            <label>Documento SAM</label>
                                                        <input type="text" class="bxlarge" id="bxDcSAM" style="text-transform: uppercase;" maxlength='4'/>-->
                        </div>
                        <!--                        <div class="bknn2">
                                                    <label>Parc.</label>
                                                    <input type="text" class="bxsmall" id="bxParc" style="text-transform: uppercase;" maxlength='4'/>
                                                    <hr class="hrContainer">
                                                </div>
                                                <div class="bknn3">
                                                    <label>Versión</label>
                                                    <input type="text" class="bxsmall" id="bxVersion" style="text-transform: uppercase;" maxlength='4'/>
                                                    <hr class="hrContainer">
                                                </div>-->
                    </div>
                </div>
                <div class="PanelBnt"><button id="btnDatosDoc">&nbsp;Datos de doc.&nbsp;&nbsp;&nbsp;</button>
                    <!--                    <button id="btnEnlacesObj">&nbsp;Enlaces de objetos&nbsp;&nbsp;</button>-->
                    <hr></div>
                <div id="secTree" class="bkcontainer">
                    <!--                    <div class="bkn2">
                                            <label>Datos de documento</label>
                                            <hr class="lnMov">
                    
                                            <div class="bknn4">
                                                <label>Descripción</label>
                                                <input type="text" class="bxXlarge" id="bxDocumento" style="text-transform: uppercase;" maxlength='4'/>
                                                <hr class="hrContainer">
                                                <label>Responsable</label>
                                                <input type="text" class="bxXmiddle" id="ss" style="text-transform: uppercase;" maxlength='4'/>
                                                <label id="lbResponsable">Boniek González , QM</label>
                                                <hr class="hrContainerr">
                                            </div>
                                        </div>-->
                    <div class="bkn3">
                        <label>Datos de documento</label>
                        <hr class="lnMov">
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHeadN">
                                    <thead>
                                        <tr>
                                            <td>Num Doc</td>
                                            <td>Parc.</td>
                                            <td>Versión</td>
                                            <td>Clase Doc.</td>
                                            <td>Nombre</td>
                                            <td hidden>Archivo</td>
                                            <td>Apl.</td>
                                            <td>Aplicación</td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpoN"></section>
                        </section>
                    </div>
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
                </div>
                <section id="TableNotfi" style="display: none">
                    <div class="PanelBnt"><button id="btnObjSAP">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Objeto SAP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button><hr></div>
                    <section class="TableContainer">
                        <section class="SecHead">
                            <table id="TabHead">
                                <thead>
                                    <tr>
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>Notificación&nbsp;</td>
                                        <td>TxtBrv&nbsp;</td>
                                        <td>ClaseDcto&nbsp;</td>
                                    </tr>
                                </thead>
                            </table>
                        </section>
                        <section class="SecBody" id="SecCuerpo">
                            <table id="TabBody">
                                <tbody>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                    <tr class="ocultar"><td>&nbsp;&nbsp;&nbsp;</td><td>ADMON_PORTUARIA__IA__I</td><td>ADMON_PORTUARIA__INTEGRAL_DEADMRAL_DEADM</td><td>ADMON_PORT00000000UARI</td><td>&nbsp;</td></tr>
                                </tbody>
                            </table>
                        </section>
                    </section>
                </section>
                <section class="DobleScroll" id="DobleObj" style="display: none">
                    <section id="DobleContainerObj"></section>
                </section>
            </section>

        </div>
        <div id="VentUbTecAvvv" class="VentanaModalAvvv">
            <div id="handleAvvv"><label id="TituloMatch">¿Qué desea realizar?</label><div class="BotonCerrar_Matc" onclick="ocultarVenAv('VenAvv');"><label>X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <br><br>
                <div class="fondo_MatchAv">
                    <button id="VisVis" style="width: 40%;margin-left: 5%;">Visualizar</button> 
                    <button id="ViGuarAr" style="width: 40%;margin-left: 5%;">Modificar</button>
                    <input id="ubtecPosOc" hidden></input>
                </div>
                <div class="Botones_Match">
                </div>
            </div>
        </div> 
        <section id="LastSec"></section>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
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
                    var e;

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
                        loadtab();
                        validaUsuarioVis();
                        mostEti();
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
        function back() {
            window.location.href = "VisualizaDocumentos.jsp";
        }
        function loadtab() {
            var acc = "<%=Accion%>";
            var eq = "<%=equip%>"
            var cn = "<%=cnt%>"
            var ubte = "<%=ubte%>";
            var avi = "<%=avi%>";
            var loi = "<%=loi%>";
            var cmv = "<%=cmv%>";
            var par = "Action=" + acc + "&equip=" + eq + "&centroo=" + cn + "&ubte=" + ubte + "&avi=" + avi + "&loi=" + loi + "&cmv=" + cmv;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionVisualizarDocs',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: par,
                success: function (data) {
                    $("#SecCuerpoN").html(data);
                    AjustarCabecera('TabHeadN', 'TabBodyN', 3, 'SecCuerpoN');
                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBodyN").offsetHeight + "px";
//                msgMatch(1, 'images/aceptar.png', 'audio/sapmsg.wav');
                }
            });
        }
//        function loadtab() {
//            var acc = "CargaTabla";
//            var par = "accion=" + acc;
//            $.ajax({
//                async: false,
//                type: 'GET',
//                url: 'PeticionVisorDocs',
//                contentType: "application/x-www-form-urlencoded",
//                processData: true,
//                data: par,
//                success: function (data) {
//                    $("#SecCuerpoN").html(data);
//                    AjustarCabecera('TabHeadN', 'TabBodyN', 3, 'SecCuerpoN');
//                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBodyN").offsetHeight + "px";
//                    msgMatch(1, 'images/aceptar.png', 'audio/sapmsg.wav');
//                }
//            });
//        }

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
//        function CargaTabla()
//        {
//            var xmlhttp = new XMLHttpRequest();
//            xmlhttp.onreadystatechange = function () {
//                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
//                {
//                    document.getElementById("SecCuerpoN").innerHTML = xmlhttp.responseText;
//                    AjustarCabecera('TabHeadN', 'TabBodyN', 3, 'SecCuerpoN');
//                    document.getElementById('DobleContainer').style.height = document.getElementById("TabBodyN").offsetHeight + "px";
//                }
//            };
//            xmlhttp.open("GET", "PeticionVisualizarDocs?Action=CargaTabla", true);
//            xmlhttp.send();
//        }
        function EnviarRuta(ruta)
        {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    if (xmlhttp.responseText == 1)
                    {
                        document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                    } else {
                        document.getElementById("msg").innerHTML = "";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                    }
                }
            };
            xmlhttp.open("GET", "peticionModuloVisualizarEquipos?Action=EnviarSocket&ruta=" + ruta, true);
            xmlhttp.send();
        }
        function EnviarModificar(ruta)
        {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    if (xmlhttp.responseText == 1)
                    {
                        document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                    } else {
                        document.getElementById("msg").innerHTML = "";
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                    }
                }
            };
            xmlhttp.open("GET", "peticionModuloVisualizarEquipos?Action=EnviarMod&ruta=" + ruta, true);
            xmlhttp.send();
        }
//        function EnviarRuta(ruta)
//        {
//            var xmlhttp = new XMLHttpRequest();
//            xmlhttp.onreadystatechange = function () {
//                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
//                {
//                    if (xmlhttp.responseText == 1)
//                    {
//                        document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
//                        var iconm = document.getElementById("iconmsg");
//                        iconm.style.visibility = "visible";
//                        iconm.src = "images/advertencia.PNG";
//                    }
//                }
//            };
//            xmlhttp.open("GET", "PeticionVisorDocs?accion=EnviarSocket&ruta=" + ruta, true);
//            xmlhttp.send();
//        }
        function validaUsuarioVis() {
            var acc = "validaUsuarioVis";
            var usr = "<%=Nombre%>";
            $.ajax({
                async: false,
                type: 'GET',
                url: 'MovimientosCalidad',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "action=" + acc + "&v1=" + usr,
                success: function (rs) {
                    if (rs == 0) {
                        $("#ViGuarAr").prop('disabled', true);
                    } else if (rs == 1) {
                        $("#ViGuarAr").prop('disabled', false);
                    }
                }
            });
        }
        function mostEti() {
            var ac = "<%=Accion%>";
            var eq = "<%=equip%>";
            var ubte = "<%=ubte%>";
            var avi = "<%=avi%>";
            var loi = "<%=loi%>";
            var cmv = "<%=cmv%>";
            switch (ac) {
                case "CargaTabla":
                    $("#bknLabDoc").html("Equipo");
                    $("#bxDocumento").val(eq);
                    getDescript("getDEquipo");
                    break;
                case "CargaTabla2":
                    $("#bknLabDoc").html("Ubicación Técnica");
                    $("#bxDocumento").val(ubte);
                    getDescript("getDUbicTec");
                    break;
                case "CargaTabla3":
                    $("#bknLabDoc").html("Aviso de Mantenimiento");
                    $("#bxDocumento").val(parseInt(avi));
                    getDescript("getDAvisos");
                    break;
                case "CargaTabla4":
                    $("#bknLabDoc").html("Lote de Inspección");
                    $("#bxDocumento").val(loi);
                    break;
                case "CargaTabla5":
                    $("#bknLabDoc").html("Clase de Documento");
                    $("#bxDocumento").val(cmv);
                    break;
            }
        }
        function getDescript(acc) {
            var vl = $('#bxDocumento').val();
            var par = "Action=" + acc + "&v1=" + vl;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionVisualizarDocs',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: par,
                success: function (data) {
                    $('#DescVisDooc').html(data);
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
