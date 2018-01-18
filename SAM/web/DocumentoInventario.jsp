<%-- 
    Document   : DocumentoInventario
    Created on : 24/11/2017, 09:59:25 AM
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
        <link rel="stylesheet" href="css/StyleDocumentoInventario.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/DocumentoInventario.js"></script>
        <title>Crear documento de inventario: Acceso</title>
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
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1>Crear documento de inventario: Acceso</h1></div>
        </div>
        <div class="contenido">
            <section class="bkTop" style="display: none;">
                <label>Fecha documento</label>
                <input type="text" class="bxmdl" id="bxFch1" style="text-transform: uppercase;"/>
                <button id="btnFch1" class='BtnMatchIcon'></button>
                <hr>
                <label>Fecha planif.recuento</label>
                <input type="text" class="bxmdl" id="bxFch2" style="text-transform: uppercase;"/>
                <button id="btnFch2" class='BtnMatchIcon'></button>
                <hr><br>
            </section>
            <section class="bkSubSec">
                <label style="margin-left: 3%;">Lugar del inventario</label>
                <hr class="lnMov">
                <section class="bkTop">
                    <label>Centro</label>
                    <input type="text" class="bxsmall" id="bxCentro" style="text-transform: uppercase;"/>
                    <button id="btnCentro" class='BtnMatchIcon'></button>
                    <hr>
                    <label>Almacén</label>
                    <input type="text" class="bxsmall" id="bxAlmacen" style="text-transform: uppercase;"/>
                    <button id="btnAlmacen" class='BtnMatchIcon'></button>
                    <hr>
                    <section style="display: none;" >  <!--seccion temporal-->
                        <label>Stock especial</label>
                        <input type="text" class="bxssmall" id="bxStockEsp" style="text-transform: uppercase;"/>
                        <button id="btnStockEsp" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                </section>
            </section>
            <br>
            <section class="bkSubSec" style="display: none;">
                <label style="margin-left: 3%;">Otras especific.</label>
                <hr class="lnMov">
                <section class="bkTop">
                    <section class="bkin">
                        <input type="checkbox" name="inventario" value="bloqueo"> <label>Bloq.contabiliz</label><br>
                        <input type="checkbox" name="inventario" value="fijar"> <label>Fijar stock teórico</label><br>
                        <input type="checkbox" name="inventario" value="borrar" checked> <label>Lotes con pet. borr.</label><br>
                    </section>
                    <label>Número de inventario</label>
                    <input type="text" class="bxlong" id="bxNInvt" style="text-transform: uppercase;"/>
                    <hr>
                    <label>Referencia invent.</label>
                    <input type="text" class="bxlong" id="bxRinvt" style="text-transform: uppercase;"/>
                    <hr>
                    <label>Clase agrupación</label>
                    <input type="text" class="bxssmall" id="bxAgrp" style="text-transform: uppercase;"/>
                    <button id="btnAgrp" class='BtnMatchIcon'></button>
                    <hr>
                    <label>Denominación</label>
                    <input type="text" class="bxxlong" id="bxDenm" style="text-transform: uppercase;"/>
                    <hr>
                </section>
            </section>
        </div>
        <section id="LastSec"></section>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalCentro', 'bxCentro');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
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
        <div id="VentanaModalAlmacen" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.RESAlamcene"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalAlmacen', 'bxAlmacen');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmacen">
                        <div class="fixedY" id="fixedYAlmacen">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosAlmacen">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
//                        document.getElementById('guardar').disabled = true;
                    }
                    function peticiones(url, id, accion, f, lote)
                    {
                        var centro = document.getElementById('bxCentro').value.toUpperCase();
                        var extras = "";

                        var lang = "<%=Idioma%>";
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                            {
                                var temp = new Array();
                                temp = xmlhttp.responseText.split(",");
                                if (temp[0] == 0) {
                                    ocultarVentana(temp[1], temp[2]);
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/advertencia.PNG";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "No hay valores por mostrar";
                                } else {
                                    document.getElementById(id).innerHTML = xmlhttp.responseText;
                                    fnc(f);
                                }
                            }
                        };
                        xmlhttp.open("GET", url + "?Action=" + accion + "&lang=" + lang + extras + "&lote=" + lote + "&ctr=" + centro, true);
                        xmlhttp.send();
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
    </script>

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>