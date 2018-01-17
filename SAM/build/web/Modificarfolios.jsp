<%-- 
    Document   : Modificarfolios
    Created on : 30/06/2016, 11:12:21 AM
--%>

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
        String ok = po.getProperty("etiqueta.ConOk_FO");
        String existFol = po.getProperty("etiqueta.MensajeNoExiste_FO");
        String processCancell = po.getProperty("etiqueta.procesosCancelado_SAM");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String menPrenecesario = po.getProperty("etiqueta.Pefinece_FoM");
        String MenNoexist = po.getProperty("etiqueta.MensajeNoExiste_FO");
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
        String FoCoin = po.getProperty("etiqueta.FoliosCoin");
        String FoMay = po.getProperty("etiqueta.FoMay");
        String LongFolO = po.getProperty("etiqueta.LongFolO");
        String CamOblig = po.getProperty("etiqueta.CompObligatorios");
        String FolActEx = po.getProperty("etiqueta.FolActEx");
        String FolNoAct = po.getProperty("etiqueta.FolNoAct");

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
                var pag = p.charAt(7);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au, fo) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=menValores%>';
                        break;
                    case 2:
                        msg = '<%=CamOblig%>';
                        break;
                    case 3:
                        msg = '<%=LongFolO%>';
                        break;
                    case 4:
                        msg = '<%=FoMay%>';
                        break;
                    case 5:
                        msg = '<%=FoCoin%>';
                        break;
                    case 6:
                        msg = '<%=existFol%>';
                        break;
                    case 7:
                        msg = '<%=menPrenecesario%>';
                        break;
                    case 8:
                        msg = '<%=ok%>';
                        break;
                    case 9:
                        msg = '<%=FolActEx%>' + " " + fo;
                        break;
                    case 10:
                        msg = '<%=FolNoAct%>';
                        break;
                        
                }
                $('#msg').html(msg);
                var icon = $('#iconmsg');
                icon.show();
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleFolios.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/ModificarFolios.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.MFOLtitulo"));%></title>       
    </head>
    <body>  
        <div id="main-header">  
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>     
            <input id="guardar" type="image" src="images/guarda.PNG"/>  
            <input  id="regresar" type="image" src="images/regresa.PNG" />
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.MFOLtitulo"));%></h1></div> 
        </div>
        <div class="contenido">
            <div class="ContentFolios">   
                <section class="SecFolios">
                    <label><%out.println(po.getProperty("etiqueta.MFEditarFolio"));%></label> 
                    <hr id="lineapFolio">
                    <section class="SectcompFolios">
                        <label><%out.println(po.getProperty("etiqueta.Prefijofol_FO"));%></label><input id="prefijoFO" style="width:8%; background-repeat: no-repeat; text-transform: uppercase;" type="text"  maxlength="2"/><button id="match_FO" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.FolioInicial_FO"));%></label><input id="FolioInicialFO" disabled  type="text" maxlength="8" style="width:15%; background-repeat: no-repeat;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.FolioFinal_FO"));%></label><input id="FolioFinalFO" disabled type="text" maxlength="8" style="width:15%; background-repeat: no-repeat;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.FolioActual_FO"));%></label><input id="FolActualFO" type="text" min="1"  disabled style="width: 15%;"/>
                        <hr>                                 
                    </section>
                </section>   
                <section class="ContTablaFolio">
                    <section class="ContTablaFolio2">
                        <section id="TablaStatus">
                            <table class="TablaCont">
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <th><%out.println(po.getProperty("etiqueta.Prefijofol_FO"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.FolioInicial_FO"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.FolioFinal_FO"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.FolioActual_FO"));%></th>
                                    </tr>
                                </thead>
                            </table>
                            <section id="SecTab">                       
                            </section>
                        </section>
                    </section>
                </section>
            </div>
            <input id="ClIdio" value="<%=Idioma%>" hidden>
        </div>       
        <div id="VentanaModal" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMCFolio"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="btnbuf"><%out.println(po.getProperty("etiqueta.BuscarPrefijo"));%></button><hr></div>
            <div id="BuscarParam_fo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MFPrefijo"));%></label><input type="text" id="Pref_Fol" style="width:35%; text-transform: uppercase" maxlength="2"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></label><input type="text" id="Des_Fol" maxlength="40" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFolio"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarMCFolio2"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MFPrefijo"));%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
            <div id="handleDoc"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.FinalizarDocumento_FIDO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeSalirModulo();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
            <div class="ContenidoFinalizarDoc">
                <label><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc_FIDO"));%></label>
                <br>
                <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.MensajeFinalizarDoc2_FIDO"));%></label>
            </div>
            <div class="BotenesFinalizarDocumento">
                <button id="FinalizarSIDoc" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                <button id="FinalizarNODoc" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
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
                    var WriteDate = $('#fecha');
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        WriteDate.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        WriteDate.html(fechaActual);
                    } else {
                        WriteDate.html("Fecha Indefinida");
                    }
                </script>
            </div>
        </footer>
    </body>
    <script>

        function msjTotal(pru, pre, fa) {

            var mendata = '<%=FolNoAct%>';
            switch (pru) {
                case "mensno":
                    var mensNo = '<%=MenNoexist%>';
                    $('#msg').html(mensNo + " " + pre);
                    break;
                case "menedi":
                    var folact = '<%=FolActEx%>';
                    var xx = folact + " " + pre.toUpperCase();

                    var men = document.getElementById("msg");
                    men.innerHTML = '<%=FolActEx%>' + " " + pre.toUpperCase();
                    alert(pru + ", " + pre + ", " + fa + ", " + xx + ", " + men.innerHTML);
                    //document.getElementById('FolActualFO_M').value = fa;
                    break;
                case "menedice":
                    msgData("mendata");
                    $('#prefijoFO_M').css('background-image', "url(images/necesario.PNG)");
                    break;
            }
        }

        function msjMatch(val) {
            switch (val) {
                case "menedice":
                    var folnoac = '<%=FolNoAct%>';
                    msgData(folnoac);
                    break;
                case "encon":
                    var okcon = "<%=menValores%>";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    break;
                case "processCancell":
                    var proca = "<%=processCancell%>";
                    $('#msg').html(proca);
                    break;
                case "funcioninv":
                    var mein = '<%=funcioninv%>';
                    $('#msg').html(mein);
                    break;
                case "FoCoin":
                    var focoin = '<%=FoCoin%>';
                    msgData(focoin);
                    break;
                case "FoMay":
                    var fomay = '<%=FoMay%>';
                    msgData(fomay);
                    break;
                case "LongFolO":
                    var long = '<%=LongFolO%>';
                    msgData(long);
                    break;
                case "CamOblig":
                    var camobli = '<%=CamOblig%>';
                    msgData(camobli);
                    break;
                case "mens":
                    var mens = '<%=menPrenecesario%>';
                    var men = document.getElementById("msg");
                    men.innerHTML = mens;
                    break;
                case "menok":
                    var menok = '<%=ok%>';
                    $('#msg').html(menok);
                    break;
            }
        }
    </script>           

    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>