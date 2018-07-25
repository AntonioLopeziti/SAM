
<%@page import="java.io.File"%>
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
        String Aviso = request.getParameter("Aviso");
        String Tipo = request.getParameter("Tipo");
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String TituloPagina = po.getProperty("etiqueta.TituloPagina2");
        String TituloPaginaC = po.getProperty("etiqueta.TituloPagina2C");
        String TituloPantalla = po.getProperty("etiqueta.TituloPantalla2");
        String TituloPantallaC = po.getProperty("etiqueta.TituloPantalla2C");
        String Notificacion = po.getProperty("etiqueta.Notificacion");
        String Status = po.getProperty("etiqueta.PedidoStatu");
        String Pestana = po.getProperty("etiqueta.TituloPestana");
        String Objeto = po.getProperty("etiqueta.Objeto");
        String Ubicacion = po.getProperty("etiqueta.Ubicacion");
        String Equipo = po.getProperty("etiqueta.Equipo");
        String Conjunto = po.getProperty("etiqueta.Conjunto");
        String Responsabilidades = po.getProperty("etiqueta.Responsabilidades");
        String Grupo = po.getProperty("etiqueta.Grupo");
        String Puesto = po.getProperty("etiqueta.Puesto");
        String Autor = po.getProperty("etiqueta.Autor");
        String FechaAviso = po.getProperty("etiqueta.FechaAviso");
        String Circun = po.getProperty("etiqueta.Circunstancias");
        String Des = po.getProperty("etiqueta.Descripcion");
        String Actividades = po.getProperty("etiqueta.Actividades");
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
        String pos = po.getProperty("etiqueta.posCreAv");
        String grupCod = po.getProperty("etiqueta.grupCodCreAv");
        String codAct = po.getProperty("etiqueta.codActCreAv");
        String txtCod = po.getProperty("etiqueta.txtCodCreAv");
        String txtAcc = po.getProperty("etiqueta.txtAccCreAv");
        String te = po.getProperty("etiqueta.teCreAv");
        String factCan = po.getProperty("etiqueta.factCanCreAv");
        String feIn = po.getProperty("etiqueta.feInCreAv");
        String horaAv = po.getProperty("etiqueta.horaAvCreAv");
        String fechaFin = po.getProperty("etiqueta.fechaFinCreAv");
        String activ = po.getProperty("etiqueta.activCreAv");
        String okc = po.getProperty("etiqueta.ConOk_FO");
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
                var a = '<%=Aviso%>';
                var pag = p.charAt(87);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
                if (a == null || a == "" || a == "null") {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function CargarModulo() {
                var Aviso = '<%=Aviso%>';
                var Tipo = '<%=Tipo%>';
                CargarCabecera(Aviso, Tipo);
                //CargarTextos(Aviso, Tipo);
                //CargarActividades(Aviso, Tipo);
            }
            function inval() {
                var okcon = "<%=funcioninv%>";
                $('#msg').html(okcon);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', "images/advertencia.PNG");
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
            }
            function ConsuOK() {
                var okcon = "<%=okc%>";
                $('#msg').html(okcon);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', "images/aceptar.png");
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/styleAvisos.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/VisualizarAvisoGral.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%=TituloPagina%>: <%=TituloPaginaC%></title>       
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
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%=TituloPantalla%>: <%=TituloPantallaC%></h1></h1></div>    
        </div> 
        <div class="contenido">
            <div class="ContentAvisos">              
                <div class="divconOrden2">
                    <div class="divconOrden3">
                        <div class="DivParametrosOrden">
                            <label><%=Notificacion%></label><input style="width:20%;" type="text" id="num_aviso" disabled /><input disabled style="width:5%;" type="text" id="Num_ClaseAviso"/><input type="text" maxlength="40" id="Des_Aviso" disabled>
                            <hr>
                            <label><%=Status%></label><input type="text" id="status_mensaje" style="width:30%;" disabled/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.OrdenCAA"));%></label><input type="text" id="statusOrden_CA"  value="" disabled/>
                            <hr>
                        </div>
                    </div>        
                    <div id="MensajeErorAviso" style="display: none;"><input type="image" src="images/advertencia.PNG" style="margin-left: 2%; vertical-align: middle;" id="iconmsger"><input type="text" id="menser" style="width: 80%; border: none; background: none;" readonly/></div>
                    <section class="SeccionPestañas_orden">
                        <div class="tabsorden">
                            <input type="button" value="<%=Pestana%>" id="tabcabec">
                        </div>
                        <hr id="lineatabs">
                    </section>                       
                    <section class="ContenidoTabsOrden">
                        <section class="TabCabecOrden" id="seccioncabecera" >                                
                            <section class="SecRespo_ord" >   
                                <label id="lblTitulo_ord" style="width: 60%;"><%=Objeto%></label>
                                <hr id="lineatitulo_orde">
                                <section class="SecRespo1_ord">     
<!--                                    <label><%=Ubicacion%></label><input style="width: 30%;" id="ubitecnica" type="text" disabled> <input type="text" id="DesUbic" style="width: 45%; background: none; border: none;" readonly/>
                                    <hr>-->
                                    <label><%=Equipo%></label><input style="width: 30%;" type="text" id="num_equipo" disabled> <input type="text" id="DesEqu" style="width: 45%; background: none; border: none;" readonly/>
                                    <hr>
                                    <label><%=Conjunto%></label><input style="width: 30%;" type="text" id="conjunto" disabled> <input type="text" id="DesConj" style="width: 45%; background: none; border: none;" readonly/>
                                    <hr>
                                </section>   
                            </section>    
                            <section class="Secbobj_ord">
                                <label id="lblTitulo_ord"><%=Responsabilidades%></label>
                                <hr id="lineatitulo_orde">   
                                <div class="divcomorden">
                                    <label id="lbl1_ord"><%=Grupo%></label><input tyoe="text" style="width:8%;" id="GrupoPlanificacion" value="" disabled> / <input type="text"   style="width:10%;" id="GrupoPlanificacion2" disabled > <span> <label id="DenoGplan" style="font-size: 0.9em; font-family: 'Tahoma'; width: auto;"/></label>  <label id="DesCen" style="font-size: 0.9em; font-family: 'Tahoma'; "/></label></span>
                                    <hr>
                                    <label id="lbl1_ord"><%=Puesto%></label><input type="text" id="PtoTrabResp"  style="width:12%;"  value="" disabled> / <input type="text"  style="width:10%;" id="CentroEmplaza" disabled>  <span> <label id="DesPue" style="font-size: 0.9em; font-family: 'Tahoma'; width: auto;"/></label>  <label id="DesCenP" style="font-size: 0.9em; font-family: 'Tahoma'; "/></label></span>
                                    <hr>
                                    <label id="lbl1_ord"><%=Autor%></label><input type="text" id="AutorAviso"  style="width:18%;" value="" disabled> <label id="lbl1_AutorAviso" style="margin-left: 3%;"><%=FechaAviso%></label><input style="width:12%; margin-left: -5%; margin-left: 5px;" type="text" id="fechaaviso" disabled><input type="text" id="horaaviso"  style="width:10%; margin-left: 4%;" disabled>
                                    <hr id="lineaautor" style=""> <hr style="margin-top: -10px;margin-left: 292px;width: 230px;">
                                </div>
                            </section>
                            <section class="divfecha_ord">
                                <label id="lblTitulo_ord"><%=Circun%></label>
                                <hr id="lineatitulo_orde">
                                <div class="divizqorden" >                                       
                                    <label><%=Des%></label>
<!--                                    <input id="inic_ord" type="text" disabled style="width:30%;"/>-->
                                    <hr> 
                                    <textarea rows="8" cols="82"  id="TexareaCircunstancia_CA" disabled></textarea>
                                </div>    
                            </section>
                            <section hidden class="actividades">
                                <label id="lblTitulo_ord"><%=Actividades%></label>
                                <hr id="lineatitulo_orde">  
                                <div id="tabscrll">
                                    <section id="TableNotfi" >
                                        <section class="TableContainer">
                                            <section class="SecHead">
                                                <table id="TabHead">
                                                    <thead>
                                                        <tr>
                                                            <td></td>
                                                            <td><%=pos%></td>
                                                            <td><%=grupCod%></td>
                                                            <td><%=codAct%></td>
                                                            <td><%=txtCod%></td>
                                                            <td><%=txtAcc%></td>
                                                            <td><%=te%></td>
                                                            <!--<td><%=factCan%></td>-->
                                                            <td><%=feIn%></td>
                                                            <td><%=horaAv%></td>
                                                            <td><%=fechaFin%></td>
                                                            <td><%=horaAv%></td>
                                                            <!--<td><%=activ%></td>-->      
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </section>
                                            <section class="SecBody" id="SecCuerpo">
                                            </section>
                                        </section>
                                    </section>
                                </div>
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