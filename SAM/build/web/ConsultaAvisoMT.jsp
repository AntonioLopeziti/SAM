<%-- 
    Document   : ConsultaAvisoMT
    Created on : 9/06/2016, 04:37:24 PM
    Author     : JaroMX
--%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
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
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link href="css/styleAvisoMT.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title>Visualizar aviso-MT:</title>    
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
                var pag = p.charAt(70);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>

        <%
            String str = request.getParameter("id");
        %>
        <SCRIPT>
            alert('<%=str%>');
        </SCRIPT>   
        <script>
            var valor = '<%=str%>';
            window.onload = function () {
                document.getElementById("#NotificacionId").value = (valor);
                document.getElementById("NotificacionId").value = (valor);
                document.getElementById('NotificacionId').value = (valor);
            }
        </script>
        <script>
            $(document).ready(function () {
                var aviso = '<%=str%>';
                $('#NotificacionId').val(aviso);

            });
        </script>
        <script>
            function Return() {
                window.location.href = "ConsultaAvisos.jsp";
            }
        </script>


    </head>
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
                <input id="aceptar" type="image" src="images/aceptar.png" onclick="validar();"/>                
                <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="Return();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
                <input  id="cancelar"type="image" src="images/cancela.PNG" onclick="back();"/>
                <script>
                    function inval() {
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = "Función Invalida";
                        setTimeout(function () {
                            men.innerHTML = "";
                            iconm.style.visibility = "hidden";
                        }, 8000);
                    }
                    function back() {
                        window.location.href = "Bienvenido.jsp";
                    }
                </script>


                <div  class="contenido" >
                    <div class="titulo"><span><h1>Visualizar aviso-MT <b><label>Aviso de Avería</label></b>: <label id="tabs"></label></h1></span></div>  
                    <div id="contenido" class="imagenContenidoConsulta">
                        <div class="divconOrden2">
                            <div class="divconOrden3">
                                <div class="DivParametrosOrden">
                                    <label>Notificación</label>  <input type="text" id="NotificacionId" name="NotificacionId" value=""/> <input type="text" id="ClaseAviso"/> <input type="text" id="Des_aviso">
                                    <hr id="lineaAviso">
                                    <label>Status mensaje</label><input type="text" id="statusAviso"/>
                                    <hr id="lineaStatusMensaje">
                                </div>
                            </div>
                            <script>
                                function tabCabecera() {
                                    document.getElementById('seccioncabecera').style.display = "block";
                                    document.getElementById('SecDatosAdc').style.display = "none";
                                    document.getElementById('SeccionEmplaz_ord').style.display = "none";
                                    document.getElementById('tabseccionplanif').style.display = "none";
                                    document.getElementById('tabSeccionControl').style.display = "none";
                                    document.getElementById('tabs').innerHTML = "Aviso";
                                }
                                function tabsDatosAd() {
                                    document.getElementById('SecDatosAdc').style.display = "block";
                                    document.getElementById('seccioncabecera').style.display = "none";
                                    document.getElementById('SeccionEmplaz_ord').style.display = "none";
                                    document.getElementById('tabseccionplanif').style.display = "none";
                                    document.getElementById('tabSeccionControl').style.display = "none";
                                    document.getElementById('tabs').innerHTML = "Documentos";
                                }
                                function tabsEmpl() {
                                    document.getElementById('SeccionEmplaz_ord').style.display = "block";
                                    document.getElementById('seccioncabecera').style.display = "none";
                                    document.getElementById('SecDatosAdc').style.display = "none";
                                    document.getElementById('tabseccionplanif').style.display = "none";
                                    document.getElementById('tabSeccionControl').style.display = "none";
                                    document.getElementById('tabs').innerHTML = "Averia, parada";
                                }
                                function tabsplanif() {
                                    document.getElementById('tabseccionplanif').style.display = "block";
                                    document.getElementById('SeccionEmplaz_ord').style.display = "none";
                                    document.getElementById('seccioncabecera').style.display = "none";
                                    document.getElementById('SecDatosAdc').style.display = "none";
                                    document.getElementById('tabSeccionControl').style.display = "none";
                                    document.getElementById('tabs').innerHTML = "Datos emplazamiento";
                                }
                            </script>
                            <section class="SeccionPesta�as_orden">
                                <div class="tabsorden">
                                    <input type="button" value="Aviso" id="tabcabec" onclick="tabCabecera();"><input type="button" value="Documentos" onclick="tabsDatosAd();"><input type="button" value="Avería, parada" onclick="tabsEmpl();"><input type="button" value="Datos Emplazamiento" onclick="tabsplanif();">
                                </div>
                                <hr id="lineatabs">
                            </section>                       
                            <section class="ContenidoTabsOrden">
                                <section class="TabCabecOrden" id="seccioncabecera">
                                    <section class="ContentOrd" > 
                                        <section class="divdatosgralEquipos">
                                            <label class="tituloequipo">Objeto de referencia</label> 
                                            <hr class="lineaazul">
                                            <div class="divizqequipo">
                                                <label>Ubic.técn.</label><input id="clase" type="text" disabled>
                                                <hr id="lineaclase">
                                                <label >Equipo</label><input id="grupAuto" type="text" disabled="">
                                                <hr id="lineagrpo">
                                                <label>Conjunto</label><input id="peso" type="text" disabled>
                                                <hr id="lineaclase">
                                            </div>
                                        </section>

                                        <section class="divdatosFabricacionEquipos">
                                            <label class="tituloequipo">Circunstancias</label> 
                                            <hr class="lineaazul">
                                            <div class="divizqequipo">
                                                <label>Codificación</label><input id="fab_eq" type="text" disabled="">
                                                <hr id="lineafab_eq">
                                                <label >Descripción</label><input id="denom_eq" type="text" disabled="">
                                                <hr id="lineadenom_eq">
                                            </div>
                                            <div class="dividerequipo">
                                                <input id="pais_eq" type="text" disabled>    
                                            </div>
                                        </section>
                                        <section class="divdatosEmplazamiento">
                                            <label class="tituloequipo">Responsabilidades</label> 
                                            <hr class="lineaazul">
                                            <div class="divcomequipo">
                                                <label>Grupo planf.</label><input id="ceemp_eq" type="text" disabled>
                                                <hr id="lineaceem_eq">
                                                <label >Pto.tbjo.resp.</label><input id="emp_eq" type="text" disabled="">
                                                <hr id="lineaemp_eq">
                                                <label>Dpto.responsable</label><span><input id="empre_eq" type="text" disabled> <input id="resp_eq" type="text" disabled></span>
                                                <hr id="linearempre_eq">
                                                <label>Responsable</label><span><input id="puesto_eq" type="text" disabled=""> <input id="resp_eq" type="text" disabled></span>
                                                <hr id="lineapuesto_eq">
                                                <label>Autor del Aviso</label><input id="Autor_aviso" type="text" disabled=""> <label>Fecha de Aviso</label><span><input id="fecha_aviso" type="text" disabled="">  <input id="Aviso_Hora" type="text" disabled></span>
                                                <hr id="lineaindica_eq">
                                            </div> 
                                        </section>
                                        <section class="divimputacion">
                                            <label class="tituloequipo">Datos Averia</label> 
                                            <hr class="lineaazul">
                                            <div class="divcomequipo">
                                                <label>Inicio averia</label><span><input id="soc_eq" type="text" disabled=""> <input id="soc_eq" type="text" disabled=""></span>
                                                <hr id="lineasoc_eq">
                                                <label>Fin de Averia</label><input id="Fin_Averia" type="text" disabled=""> <input id="Hora_fin" type="text" disabled=""> <label>Duración Parada</label><span><input id="Duracion_Parada" type="text" disabled=""> <input id="Tiempo_Dato" type="text" disabled=""></span>
                                                <hr id="lineaindica_eq">                             
                                            </div>                           
                                        </section>
                                    </section>
                                    <%--Comienza la pesta�a Documentos--%>
                                </section>
                                <section class="SecDatosAdc" id="SecDatosAdc">
                                    <section class="Secorgan_ord">
                                        <label id="lblTitulo_ord">Documentos Enlazados</label>
                                        <hr id="lineatitulo_orde">   

                                        <div class="rwd">
                                            <table class="rwd_auto">
                                                <thead>
                                                    <tr>
                                                        <th><label>Clase</label></th>
                                                        <th><label>Documento</label></th>
                                                        <th><label>UVL</label></th>
                                                        <th><label>ÚltV</label></th>
                                                        <th><label>Liverados</label></th>
                                                        <th><label>Parc.</label></th>
                                                        <th><label>Vs</label></th>
                                                        <th><label>Descripción</label></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                        </div> 
                                    </section>  

                                </section>
                                <%--Comienza pesta�a Averia Parada --%>
                                <section class="SeccionEmplaza_ord" id="SeccionEmplaz_ord">
                                    <section class="SecDatosEmp_ord">
                                        <label id="lblTitulo_ord">Inicio</label>
                                        <hr id="lineatitulo_orde">   
                                        <div class="divcomorden">
                                            <label id="lbl2_ord">Inicio de Avería</label> <input type="text" id="inicioAveriaDia">
                                            <hr id="lineaInicioAveriaDia">
                                            <label id="lbl2_ord">Hora in.avería</label> <input type="text" id="InicioAveriaHora">
                                            <hr id="lineaInicioAveriaHora">   
                                        </div>
                                    </section>
                                    <section class="seccimputa_ord">
                                        <label id="lblTitulo_ord">Final</label>
                                        <hr id="lineatitulo_orde">  
                                        <div class="divizqord1">
                                            <label id="lbl2_ord">Fin de Avería</label><input id="FinAveriaFecha" type="text">
                                            <hr id="lineaFinAveriaFecha">
                                            <label id="lbl2_ord">Hora fin Avería</label><input type="text" id="FinAveriaHora"> 
                                            <hr id="lineaFinAveriaHora">
                                        </div>
                                    </section>

                                    <section class="seccimputa_ord">
                                        <label id="lblTitulo_ord">Parada</label>
                                        <hr id="lineatitulo_orde">  
                                        <div class="divizqord1">
                                            <input type="checkbox" name="checkParada" value="Parada"><label id="lbl2_ord">Parada</label>  <label id="lbl2_ord">Duración parada</label><input id="FinAveriaFecha" type="text">
                                            <hr id="lineaTiempoParada">
                                        </div>
                                    </section>
                                </section>
                                <%--Comienza pesta�a Datos Emplazamiento--%>
                                <section class="tabSeccionPlanif" id="tabseccionplanif">
                                    <section class="divplanmant_ord">
                                        <label id="lblTitulo_ord">Datos de emplazamiento</label>
                                        <hr id="lineatitulo_orde">                                    
                                        <div id="divizqplanfi_ord">
                                            <label id="lbl2_ord" >Ce.emplazam.</label><input type="text" id="Ceemplazam">
                                            <hr id="lineaCeemplazam">
                                            <label id="lbl2_ord">Emplazamiento</label><input type="text" id="emplazamiento">
                                            <hr id="lineaEmplazamiento">
                                            <label id="lbl2_ord">Local</label><input type="text" id="local">
                                            <hr id="lineaLocal">
                                            <label id="lbl2_ord">Área de empresa</label><input type="text" id="AreaEmpresa">
                                            <hr id="lineaAreaEmpresa">
                                            <label id="lbl2_ord">Puesto trabajo</label><input type="text" id="PuestoTrabajo">
                                            <hr id="lineaPuestoTrabajo">
                                            <label id="lbl2_ord">Indicador ABC</label><input type="text" id="IndicadorABC">
                                            <hr id="lineaIndicadorABC">
                                            <label id="lbl2_ord">Campo clasif.</label><input type="text" id="CampoClasif">
                                            <hr id="lineaCampoClasif">
                                        </div>                                  
                                    </section>
                                    <section class="divImputacion">
                                        <label id="lblTitulo_ord">Imputación</label>
                                        <hr id="lineatitulo_orde">  
                                        <div id="divizqplanfi_ord">
                                            <label id="lbl2_ord" >Sociedad</label><input type="text" id="Ceemplazam">
                                            <hr id="lineaSociedad">
                                            <label id="lbl2_ord">Activo Fijo</label><input type="text" id="ActivoFijo"> / <input type="text" id="ActivoFijo2">
                                            <hr id="lineaActivoFijo">
                                            <label id="lbl2_ord">División</label><input type="text" id="Divicion">
                                            <hr id="lineaDivicion">
                                            <label id="lbl2_ord">Centro de coste</label><input type="text" id="CentroCoste">    <label id="lblCentroCoste">Sociedad CO</label><span> <input id="fecha_aviso" type="text"></span>
                                            <hr id="lineaCentroCoste"> <hr id="lineaSociedadCO">
                                            <label id="lbl2_ord">Elemento PEP</label><input type="text" id="ElementoPEP">
                                            <hr id="lineaElementoPEP">
                                            <label id="lblOrdenLiquidacion">Ord. Liquidación</label><input type="text" id="OrdenLiquidacion">
                                            <hr id="lineaOrdenLiquidacion">
                                        </div>

                                    </section>
                                </section>

                        </div>
                    </div>
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
                            tabsprin();
                            main();
                        };

                        function bloq() {
                            document.getElementById('iconmsg').style.visibility = "hidden";
                            document.getElementById('guardar').disabled = true;
                        }

                        function tabsprin() {
                            document.getElementById('SecDatosAdc').style.display = "none";
                            document.getElementById('SeccionEmplaz_ord').style.display = "none";
                            document.getElementById('tabseccionplanif').style.display = "none";
                            document.getElementById('tabSeccionControl').style.display = "none";
                            document.getElementById('seccioncabecera').style.display = "block";
                            document.getElementById('tabs').innerHTML = "Cabe"
                            $input.disabled = true;
                        }

                    </script>
                    <script>
                        function main() {
                            $(document).ready(function () {
                                $("input").disable();
                            });
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