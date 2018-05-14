<%-- 
    Document   : CrearAvisoAcceso
    Created on : 12/08/2016, 02:15:07 PM
    Author     : JaroMX
--%>
<%@page import="AccesoDatos.ACC_Aviso"%>
<%@page import="Entidades.aviso"%>
<%@page import="java.util.LinkedList"%>
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
        String FalCamAv = po.getProperty("etiqueta.FalCamAv");
        String NoCreaAv = po.getProperty("etiqueta.NoCreaAv");
        String FuncInval = po.getProperty("etiqueta.FuncionInval_Menu");
        String TabConVac = po.getProperty("etiqueta.TabConVac");
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
                var pag = p.charAt(85);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/CrearAviso.css"> 
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/CrearAviso.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloCrearAviso"));%></title>        
    </head>
    <body id="BODY">
        <div id="main-header">  
            <hr>                
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png" />                
            <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG" />
            <input id="finalizar" type="image" src="images/cance.PNG" />
            <input  id="cancelar"type="image" src="images/cancela.PNG" />
            <div class="titulo"><h1><%out.println(po.getProperty(("etiqueta.TituloCrearAviso")));%></h1></div>  
        </div>
        <div class="contenido">
            <div class="ContentAviso">
            <section class="divAviscr">
                    <label><%out.println(po.getProperty("etiqueta.AccesoClaseAviso"));%></label>
                    <select id="aviso_CAA" style="width:7%; margin-left: -5%;" >
                        <option></option>  
                        <option>M3</option>
<!--                        
//                         LinkedList<aviso> a = ACC_Aviso.ObtenerInstancia().ConsultaMatchAviso1();
//                         for(int i = 0; i < a.size(); i++){
//                             out.println("<option>" +a.get(i).getClase_aviso()+"</option>");
//                         }
                         %>   
                    --></select>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.AccesoNotificacion"));%></label><input type="text" id="Notificacion_CAA" disabled="" style="width:20%; background-repeat: no-repeat; background-position-x: -2%;"/>
                    <hr>
            </section>
            <section class="divaviso2" >   
                    <label><%out.println(po.getProperty("etiqueta.AccesoModelo"));%></label>
                    <hr id="Linblue">
                    <div class="subdiv2">
                    <label><%out.println(po.getProperty("etiqueta.AccesoNumeroModelo"));%></label><span><input id="Modelo_CAA" type="text" disabled value="" style="width:20%; background-repeat: no-repeat; background-position-x: -2%;"></span>
                    <hr>
                    </div>
            </section>
            </div>
        </div>                   
        <div id="VentanaModalAviso" class="VentanaModalAvi">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MatchavisoTitulo"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('avisos');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Matchaviso"));%></button><hr></div>
            <div id="ConsultaTabla" style="display: bloke;">
                <div class="tablaCab">
                    <div id="table-scroll" class="table-scroll">
                        <div id="fixedY" class="fixedYca">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MatchavisoCl"));%></th><th><%out.println(po.getProperty("etiqueta.MatchavisoClaseaviso"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXca" id="cargarDatos">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalNotificacion" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MatchNotiTitulo"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('notificacion');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.MatchNotiBoton"));%></button><hr></div>
            <div  id="BuscarParamSoc_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiClaseaviso"));%></label>
                        <input type="text" id="CentroAlmacen_bus" style="width:10%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiDescrip"));%></label>
                        <input type="text" id="AlmacenDesc_bus" style="width:50%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiNoti"));%></label>
                        <input type="text" id="Almacen_bus" style="width:22%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MatchCantidadMaxima_VA"));%></label><input type="number" min="1"  id="numAcMax2" max="100" value="100" style="width:10%;" onblur="ValidarValor(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" onclick="ConsultaAllNotificacion();"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%; cursor: pointer;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('notificacion');"/>
                </div>
            </div>
            <div id="ConsultaTabla2" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll2" class="table-scroll">
                        <div id="fixedY2" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MatchavisoCl"));%></th><th><%out.println(po.getProperty("etiqueta.MatchNotifDescripcion"));%></th><th><%out.println(po.getProperty("etiqueta.MatchNotifiNotifi"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatos2" class="nofixedX">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalModelo" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.BusquedaMo_MM"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('modelo');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.MatchNotiBoton"));%></button><hr></div>
            <div id="BuscarParam_OV" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiClaseaviso"));%></label>
                        <input type="text" id="CentroAlmacen_bus" style="width:10%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiDescrip"));%></label>
                        <input type="text" id="AlmacenDesc_bus" style="width:50%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MatchNotiNoti"));%></label>
                        <input type="text" id="Almacen_bus" style="width:22%;" onkeypress="ValidarMatch(event);" focus/>
                        <hr>

                        <label><%out.println(po.getProperty("etiqueta.MatchCantidadMaxima_VA"));%></label><input type="number" min="1"  id="numAcMax3" max="100" value="100" style="width:10%;" onblur="ValidarValor(this.value);"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="ConsultaAllModelo();"/>
                    <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('modelo');"/>
                </div>
            </div>
            <div id="ConsultaTabla3" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll3" class="table-scroll">
                        <div id="fixedY3" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("MatchNotifCl"));%></th><th><%out.println(po.getProperty("etiqueta.MatchNotifDescripcion"));%></th><th><%out.println(po.getProperty("etiqueta.MatchNotifiNotifi"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div id="cargarDatos3" class="nofixedX">
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
            </div>
        </footer>
    </body>
    <script>
        
        function validar() {
            var cen = document.getElementById("aviso_CAA").value.toUpperCase();

            if (cen.length < 1)
            {
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                var mensj = '<%=FalCamAv%>';
                $("#iconmsg").css("visibility" , "visible");
                $("#iconmsg").attr("src","images/advertencia.PNG");
                $("#msg").html(mensj);
            } else {
                validarm3();
            }
        }
        function validarm3() {
            var cen = document.getElementById("aviso_CAA").value.toUpperCase();

            if (cen == "M3") {
                ok();
            } else {
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                var mensj = '<%=NoCreaAv%>';
                $("#iconmsg").css("visibility","visible");
                $("#iconmsg").attr("src","images/advertencia.PNG");
                $("#msg").html(mensj);
            }
        }
        function check() {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            $("#iconmsg").css("visibility","visible");
            $("#iconmsg").attr("src","images/aceptar.png");
            $("#msg").html('<%=FuncInval%>');
        }
        function inval() {

            //error
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            $("#iconmsg").css("visibility","visible");
            $("#iconmsg").attr("src","images/advertencia.PNG");
            $("#msg").html('<%=FuncInval%>');
        }
        function back() {
            window.location.href = "Bienvenido.jsp";
        }

 
        function ErrorBusquedaMatch() {
            //MEnsaje de correcto
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();

            var okcon = "Tabla de consulta vacia";
            $("#iconmsg").css("visibility","visible");
            $("#iconmsg").attr("src","images/aceptar.png");
            $("#msg").html(okcon);
        }
        function borramsg() {
            $("#iconmsg").css("visibility","hidden");
            $("#msg").html("");
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
</html>