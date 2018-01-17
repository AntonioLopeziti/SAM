<%-- 
    Document   : ConsultaMateriales
    Created on : 15/06/2016, 10:43:43 AM
    Author     : Jonathan Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
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
        <link rel="stylesheet" href="css/styleMateriales.css"> 
                <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title>Materiales</title>           
    </head>
    <body>
        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <input id="menu" type="image" src="images/menu.PNG"/> 
                <input id="aceptar" type="image" src="images/aceptar.png" onclick="mostrar1();"/>                
                <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
                <input  id="cancelar"type="image" src="images/cancela.PNG" onclick="back();"/>
            </div>
                <script>
                    function back() {
                        window.location.href = "Bienvenido.jsp";
                    }
                </script>
                
                <script>
                    function mostrar(e, r) {
                    tecla = (document.all) ? e.keyCode : e.which;
                    if (tecla == 13) {
                        if (r == null || r == "") {
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = "Complete el Campo Número de Equipo";
                            setTimeout(function () {
                                men.innerHTML = "";
                                iconm.style.visibility = "hidden";
                            }, 8000);
                        } else {
                            var xmlhttp = new XMLHttpRequest();
                            xmlhttp.onreadystatechange = function () {
                                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                    var res = xmlhttp.responseText;
                                    if (res == 1) {
                                        var iconm = document.getElementById("iconmsg");
                                        iconm.style.visibility = "visible";
                                        iconm.src = "images/aceptar.png";
                                        var men = document.getElementById("msg");
                                        men.innerHTML = "No Existe Numero de Material";
                                        setTimeout(function () {
                                            men.innerHTML = "";
                                            iconm.style.visibility = "hidden";
                                        }, 8000);
                                    } else {

                                        document.getElementById("Cont").innerHTML = res;
                                        cargar();
                                    }
                                }
                            }
                            xmlhttp.open("GET", "peticionVisualizarMateriales?ma=" + r, true);
                            xmlhttp.send();
                        }
                    }

                }
                    function mostrar1() {
                    var matc = document.getElementById("material").value;
                    if (matc == null || matc == "") {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = "Complete el Campo Número de Material";
                        setTimeout(function () {
                            men.innerHTML = "";
                            iconm.style.visibility = "hidden";
                        }, 8000);
                    } else {
                        var xmlhttp = new XMLHttpRequest();
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                var res = xmlhttp.responseText;
                                if (res == 1) {
                                    var iconm = document.getElementById("iconmsg");
                                    iconm.style.visibility = "visible";
                                    iconm.src = "images/aceptar.png";
                                    var men = document.getElementById("msg");
                                    men.innerHTML = "No Existe Número de Material";
                                    setTimeout(function () {
                                        men.innerHTML = "";
                                        iconm.style.visibility = "hidden";
                                    }, 8000);
                                } else {

                                    document.getElementById("Cont").innerHTML = res;
                                    cargar();
                                }
                            }
                        }
                        xmlhttp.open("GET", "peticionVisualizarMateriales?ma=" + matc, true);
                        xmlhttp.send();

                    }
                }

                function cargar() {
                    var master = document.getElementById("materialito").value;
                    document.getElementById("mtr").innerHTML = master;
                    var umbase = document.getElementById("umbase").value;
                    document.getElementById("um").value = umbase;
                    var nomate = document.getElementById("nomate").value;
                    document.getElementById("nomaterial").value = nomate;
                }
                </script>
            <div id="Cont" hidden></div> 
            <div class="contenido">
                <div class="titulo"><h1>Visualizar Maestro de Materiales</h1></div> 
                <div class="ContenidoScrollbar">
                    <section class="DatosBasicComp_info">
                            <label>Parámetros de Visualización</label>
                            <hr id="LineaTituloInfo">
                            <section class="divdatosEmplazamiento">
                                <label>Material</label><input id="material" type="text" onkeypress="mostrar(event, this.value)" style="width: 20%;"/><input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentana()"/><label id="mtr" style="width: 55%;">eje</label>
                                <hr id="lineamaterial">
                                <label>Centro</label><input id="centro" type="text" style="width: 10%;"/><input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentana2()"/>
                                <hr id="lineamaterial">
                                <label>Organiz.ventas</label><input id="organizacion" type="text" style="width: 10%;"/><input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentana3()"/>
                                <hr id="lineamaterial">
                                <label>Canal distrib.</label><input id="canal" type="text" style="width:5%;"/><input type="image" style="vertical-align:middle;cursor:pointer;display: inline-block;" id="btnmat" src="images/match.png" onclick="mostrarVentana4()"/>
                                <hr id="lineamaterial">
                            </section>
                    </section>
                    <section class="Datos_info">
                        <label style="">Datos Básicos</label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoComp11_info">
                                <label>UM base</label><input id="um" type="text" style="width: 10%;" disabled/>
                                <hr id="lineadatos">
                                <label>N°Material ant.</label><input id="nomaterial" type="text" style="width: 50%;" disabled/>
                                <hr id="lineadatos">
                            </section>
                            <section class="BasicoComp12_info">
                                <label>Tipo material</label><input type="text" style="width:20%;" disabled/>
                                <hr id="lineadatos">
                                <label>Grupo artículos</label><input type="text" style="width:40%;" disabled/>
                                <hr id="lineadatos">
                            </section>
                    </section>
                    <section class="VisualInfoRecord_info">
                        <section class="ParametrosBusqueda_info">
                            <label style="">Ventas</label>
                            <hr id="LineaTituloInfo">
                            <section class="ParamIzq_info">
                                <label style="width: 80%;">Ventas1</label>
                                <hr id="LineaTituloInfo">
                                <section class="Basic_info">
                                <label>Sector</label><input type="text" style="width:10%;" disabled/>
                                <hr id="lineaestadi">
                                <label>UM venta</label><input type="text" style="width:10%;" disabled/>
                                <hr id="lineaestadi">
                                </section>
                            </section>
                            <section class="ParamDer_info">
                                <label style="width: 80%;">Ventas2</label>
                                <hr id="LineaTituloInfo">
                                <section class="BasicoCo_info">
                                    <label>Gr.estadís.mat.</label><input type="text" style="width:5%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Gr.tp.pos.gral.</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Jquía.productos</label><input type="text" style="width:20%;" disabled/>
                                    <hr id="lineaestadi">
                                </section>
                                <section class="BasicoComp2_info">
                                    <label>Gr.precio mat.</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaprecio">
                                    <label>Gr.imput.mat.</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaprecio">
                                    <label>Gr.Tp.posición</label><input type="text" style="width:15%;" disabled/>
                                    <hr id="lineaprecio">
                                </section>
                            </section>
                            <section class="Parem_info">
                                <label style="width: 80%;">Ventas: Gral./Centro</label>
                                <hr id="LineaTituloInfo">
                                <section class="Bas_info">
                                    <label>Verif.dispon.</label><input type="text" style="width:5%;" disabled/>
                                    <hr id="lineaventas">
                                    <label>Gpo.transp.</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaventas">
                                    <label>CeBe</label><input type="text" style="width:20%;" disabled/>
                                    <hr id="lineaventas">
                                </section>
                                <section class="Basi_info">
                                    <label>Sujeto-lote</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineabasi">
                                    <label>Grupo Carga</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineabasi">
                                </section>
                            </section>
                            </section>
                        </section>
                    <section class="DatosBa_info">
                        <label style="">Compras</label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoComp11_info">
                                <label>Grupo Compras</label><input type="text" style="width: 10%;" disabled/>
                                <hr id="lineadatos">
                            </section>
                    </section>
                    <section class="VisualInfoRecord_info">
                        <section class="Parametros_info">
                            <label style="">Planificación de Necesidades</label>
                            <hr id="LineaTituloInfo">
                            <section class="ParamD_info">
                                <label style="width: 80%;">Planificación 1</label>
                                <hr id="LineaTituloInfo">
                                <section class="BasicoCo_info">
                                    <label>Car.planif.nec.</label><input type="text" style="width:5%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Punto de pedido</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Ciclo planif.</label><input type="text" style="width:20%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Tam.lote pl.nec</label><input type="text" style="width:20%;" disabled/>
                                    <hr id="lineaestadi">
                                    <label>Tam.lote mín.</label><input type="text" style="width:20%;" disabled/>
                                    <hr id="lineaestadi">
                                </section>
                                <section class="BasicoComp2_info">
                                    <label>HorizPalnifFij</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaprecio">
                                    <label>Planif.neces.</label><input type="text" style="width:10%;" disabled/>
                                    <hr id="lineaprecio">
                                    <label>Tam.lote máx.</label><input type="text" style="width:15%;" disabled/>
                                    <hr id="lineaprecio">
                                    <label>Stock máximo</label><input type="text" style="width:15%;" disabled/>
                                    <hr id="lineaprecio">
                                </section>
                            </section>
                            <section class="Parem_in">
                                <label style="width: 80%;">Planificación 2</label>
                                <hr id="LineaTituloInfo">
                                <section class="Bas_info">
                                <label>Aprovisionam.</label><input type="text" style="width:5%;" disabled/>
                                <hr id="lineaestadi">
                                <label>Tmpo.trata,.EM</label><input type="text" style="width:10%;" disabled/>
                                <hr id="lineaestadi">
                                <label>Stock seguridad</label><input type="text" style="width:20%;" disabled/>
                                <hr id="lineaestadi">
                                <label>Stock seg.mín.</label><input type="text" style="width:20%;" disabled/>
                                <hr id="lineaestadi">
                                </section>
                                <section class="Basi_info">
                                <label>Aprovis.espec.</label><input type="text" style="width:10%;" disabled/>
                                <hr id="lineaprecio">
                                <label>Plaz.entr.prev.</label><input type="text" style="width:10%;" disabled/>
                                <hr id="lineaprecio">
                                </section>
                            </section>
                            </section>
                        </section>
                    <section class="DatosBa_info">
                        <label style="">Calidad</label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoComp11_info">
                                <label>ParametrizInsp</label><input type="text" style="width: 10%;" disabled/>
                                <hr>
                            </section>
                            <section class="BasicoComp12_info">
                                <label>Aprovision.QM</label><input type="text" style="width:20%;" disabled/>
                                <hr>
                            </section>
                    </section>
                    <section class="Dato_info">
                        <label style="">Contabilidad</label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoComp14_info">
                                <label>Ctrl precios</label><input type="text" style="width: 10%;" disabled/>
                                <hr>
                                <label>Prec.medio var.</label><input type="text" style="width: 10%;" disabled/>
                                <hr>
                                <label>Precio estándar</label><input type="text" style="width: 10%;" disabled/>
                                <hr>
                            </section>
                            <section class="BasicoComp13_info">
                                <label>Cantidad base</label><input type="text" style="width:20%;" disabled/>
                                <hr>
                                <label>Cl.valoración</label><input type="text" style="width:20%;" disabled/>
                                <hr>
                                <label>Cat.valoración</label><input type="text" style="width:20%;" disabled/>
                                <hr>
                            </section>
                    </section>
                </div>
            </div>
            <footer>
                <hr class="fecha" id="footerline">
                <div  class="fecha">
                    <label id="fecha" name="fecha"></label><label>, </label> 
                    <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                    <span><input type="image" style="float:left;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                    <script type="text/javascript">
                        var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                        var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                        var f = new Date();
                        var idioma = "<%=Idioma%>";
                        if (idioma == "ES") {
                            var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                            document.getElementById('fecha').innerHTML = fechaActual;
                        } else if (idioma == "EN") {
                            var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                            document.getElementById('fecha').innerHTML = fechaActual;
                        } else {
                            var fechaActual = "Fecha indefinida";
                        }
                    </script>
                    <script>
                function mostrarVentana()
                {

                    var ventana = document.getElementById('miVentana');
                    ventana.style.marginTop = "100px";
                    ventana.style.marginLeft = ((document.body.clientWidth - 350) / 2) + "px";
                    ventana.style.display = 'block';
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                            document.getElementById("taCont").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET", "Material?mat=", true);
                    xmlhttp.send();
                }

                function ocultarVentana()
                {
                    var ventana = document.getElementById('miVentana');
                    ventana.style.display = 'none';
                }

                function seleccionar(we) {

                    document.getElementById("material").value = we;
                    ocultarVentana();
                }
            </script>
            <script>
                function mostrarVentana2()
                {

                    var ventana = document.getElementById('miVentana2');
                    ventana.style.marginTop = "100px";
                    ventana.style.marginLeft = ((document.body.clientWidth - 350) / 2) + "px";
                    ventana.style.display = 'block';
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                            document.getElementById("taCont2").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET", "Centros?cent=", true);
                    xmlhttp.send();
                }

                function ocultarVentana2()
                {
                    var ventana = document.getElementById('miVentana2');
                    ventana.style.display = 'none';
                }

                function seleccionar2(we) {

                    document.getElementById("centro").value = we;
                    ocultarVentana2();
                }
            </script>
            <script>
                function mostrarVentana3()
                {

                    var ventana = document.getElementById('miVentana3');
                    ventana.style.marginTop = "100px";
                    ventana.style.marginLeft = ((document.body.clientWidth - 350) / 2) + "px";
                    ventana.style.display = 'block';
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                            document.getElementById("taCont3").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET", "OrganizVentas?orga=", true);
                    xmlhttp.send();
                }

                function ocultarVentana3()
                {
                    var ventana = document.getElementById('miVentana3');
                    ventana.style.display = 'none';
                }

                function seleccionar3(we) {

                    document.getElementById("organizacion").value = we;
                    ocultarVentana3();
                }
            </script>
            <script>
                function mostrarVentana4()
                {

                    var ventana = document.getElementById('miVentana4');
                    ventana.style.marginTop = "100px";
                    ventana.style.marginLeft = ((document.body.clientWidth - 350) / 2) + "px";
                    ventana.style.display = 'block';
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                            document.getElementById("taCont4").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET", "Canal?cana=", true);
                    xmlhttp.send();
                }

                function ocultarVentana4()
                {
                    var ventana = document.getElementById('miVentana4');
                    ventana.style.display = 'none';
                }

                function seleccionar4(we) {

                    document.getElementById("canal").value = we;
                    ocultarVentana4();
                }
            </script>
            <div id="miVentana" >
                <input type=image src="images/ko.png" id="btnAceptar" onclick="ocultarVentana();" name="btnAceptar"  value="Aceptar" width="15" height="15" align="right"/>
                <div id="submiVentana">Materiales</div>
                <div class="containerDatosMatch">
                    <div class="Tabla" id="taCont"></div>
                </div>
            </div> 
            <div id="miVentana2" >
                <input type=image src="images/ko.png" id="btnAceptar" onclick="ocultarVentana2();" name="btnAceptar"  value="Aceptar" width="15" height="15" align="right"/>
                <div id="submiVentana2">Centros</div>
                <div class="containerDatosMatch">
                    <div class="Tabla" id="taCont2"></div>
                </div>
            </div> 
            <div id="miVentana3" >
                <input type=image src="images/ko.png" id="btnAceptar" onclick="ocultarVentana3();" name="btnAceptar"  value="Aceptar" width="15" height="15" align="right"/>
                <div id="submiVentana3">Organizacion Ventas</div>
                <div class="containerDatosMatch">
                    <div class="Tabla" id="taCont3"></div>
                </div>
            </div> 
            <div id="miVentana4" >
                <input type=image src="images/ko.png" id="btnAceptar" onclick="ocultarVentana4();" name="btnAceptar"  value="Aceptar" width="15" height="15" align="right"/>
                <div id="submiVentana4">Canal Distribucion</div>
                <div class="containerDatosMatch">
                    <div class="Tabla" id="taCont4"></div>
                </div>
            </div> 
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