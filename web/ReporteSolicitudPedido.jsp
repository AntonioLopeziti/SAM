<%-- 
    Document   : ReporteSolPed
    Created on : 28/08/2016, 11:27:41 AM
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
        String pos = po.getProperty("etiqueta.ReportesSolStatusPos");
        String imp = po.getProperty("etiqueta.ReportesSolStatusTi");
        String mate = po.getProperty("etiqueta.MensajeNoExiste");
        String alma = po.getProperty("etiqueta.CSPErralm");
        String Solic = po.getProperty("etiqueta.ReportesSolStatusSoli");
        String Noexistval = po.getProperty("etiqueta.NoExisteValores_SAM");
        String ErroCent = po.getProperty("etiqueta.ReporteErrorCentro");
        String ErroSAM = po.getProperty("etiqueta.ReporteErrorFolioSAM");
        String ErroSAP = po.getProperty("etiqueta.ReporteErrorFolioSAP");
        String ErrorSol = po.getProperty("etiqueta.ReportesSolStatusSoli");
        String ErrorAlm = po.getProperty("etiqueta.ReporteErrorAlmace");
        String ErrorMate = po.getProperty("etiqueta.ReportesListaRMateNE");
        String ReportesListNoExiRes = po.getProperty("etiqueta.ReportesListNoExiRes");
        String ErroNop = po.getProperty("etiqueta.ReporteErrorNumeroOperacion");
        String ErroOrn = po.getProperty("etiqueta.ReporteErrorNumeroorden");
        String Ordob = po.getProperty("etiqueta.ReporteOrdenob");
        String Datosnot = po.getProperty("etiqueta.ReporteNoExusDatis");
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
        String Diciembre = po.getProperty("etiquDiciembre");
        String Lunes = po.getProperty("etiqueta.Lunes");
        String Martes = po.getProperty("etiqueta.Martes");
        String Miercoles = po.getProperty("etiqueta.Miercoles");
        String Jueves = po.getProperty("etiqueta.Jueves");
        String Viernes = po.getProperty("etiqueta.Viernes");
        String Sabado = po.getProperty("etiqueta.Sabado");
        String Domingo = po.getProperty("etiqueta.Domingo");
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
    %>
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
            var pag = p.charAt(38);
            if (pag == 0) {
                window.location.href = "Bienvenido.jsp";
            }
        }
        checkPermisoPag();
        function ShowMsg(m, im, au, va) {
            var msg;
            switch (m) {
                case 0:
                    msg = '<%=funcioninv%>';
                    break;
                case 1:
                    msg = "<%=ErroCent%>: " + va;
                    break;
                case 2:
                    msg = "<%=ErroSAM%>: " + va;
                    break;
                case 3:
                    msg = "<%=ErroSAP%>: " + va;
                    break;
                case 4:
                    msg = "<%=ErroNop%>: " + va;
                    break;
                case 5:
                    msg = "<%=ErroOrn%>: " + va;
                    break;
                case 6:
                    msg = "<%=Noexistval%>";
                    break;
                case 7:
                    msg = "<%=Ordob%>";
                    break;
                case 8:
                    msg = "<%=Datosnot%>";
                    break;
                case 9:
                    msg = "<%=Solic%> " + va;
                    break;
                case 10:
                    msg = "<%=alma%> " + va;
                    break;
                case 11:
                    msg = "<%=mate%> " + va;
                    break;
                case 12:
                    msg = "<%=pos%> " + va;
                    break;
                case 13:
                    msg = "<%=imp%> " + va;
                    break;
                case 14:
                    msg = "<%=ErrorSol%> " + va;
                    break;
                case 15:
                    msg = "<%=ErrorAlm%> " + va;
                    break;
                case 16:
                    msg = "<%=ErrorMate%> " + va;
                    break;
                case 17:
                    msg = "<%=ReportesListNoExiRes%> ";
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportesSolped.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script  src="js/dom-drag.js"></script>
        <script src="js/ReporteSolicitudPedido.js" type="text/javascript"></script>  
        <title><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></title>      
    </head>
    <body>  
        <script>
        $(function () {
            $("#datapicker").datepicker({
                dateFormat: 'dd.mm.yy',
                firstDay: 0,
                monthNames: ['<%=Enero%>', '<%=Febrero%>', '<%=Marzo%>', '<%=Abril%>', '<%=Mayo%>', '<%=Junio%>',
                    '<%=Julio%>', '<%=Agosto%>', '<%=Septiembre%>', '<%=Octubre%>', '<%=Noviembre%>', '<%=Diciembre%>'],
                dayNames: ['<%=Domingo%>', '<%=Lunes%>', '<%=Martes%>', '<%=Miercoles%>', '<%=Jueves%>', '<%=Viernes%>', '<%=Sabado%>'],
                dayNamesMin: ['<%=Do%>', '<%=lu%>', '<%=Ma%>', '<%=Mi%>', '<%=Ju%>', '<%=vi%>', '<%=sa%>'],
                onSelect: function (date) {
                    var idda = $('#IDFecha').val();
                    var fehSet = $('#' + idda);
                    fehSet.val(date);
                    fehSet.focus();
                    CerrarCalendario();
                }
            });
        });
        $(function () {
            $('#datapicker').datepicker().hide();
        });
        </script>
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
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivBusqueda">
                    <label><%out.println(po.getProperty("etiqueta.Reporte_DatosBas"));%></label>
                    <hr id="lineatituloReportes">
                    <section class='DivIzquierda'>
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><select id="centro" type="text" maxlength="4" style='width: 30%; text-transform: uppercase;'>
                        </select>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></label><input id="sami" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match1" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></label><input id="sapi" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match2" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input  maxlength="10" type="text" onpaste="return false;" value="" id="fechainicio" style="width:25%;  background-repeat: no-repeat;"/><button id="match10" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></label><input id="solicitante" type="text" maxlength="12" style='width: 35%; text-transform: uppercase;'><button id="match3" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></label><input id="almacen" type="text" style='width: 35%; text-transform: uppercase;' maxlength="4"><button id="match4" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></label><input id="material" type="text" style='width: 35%; text-transform: uppercase;' maxlength="40"><button id="match5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTipoPosición2"));%></label><input id="posicion" type="text" style='width: 35%; text-transform: uppercase;' maxlength="1"><button id="match6" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPTituloImputacion2"));%></label><input id="imputacion" type="text" style='width: 35%; text-transform: uppercase;' maxlength="1"><button id="match7" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class='DivDerecha'>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="samf" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match8" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="sapf" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match9" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input value="" maxlength="10" type="text"  id="fechafin" onpaste="return false;"  style="width:25%;  background-repeat: no-repeat;"/><button id="match11" class='BtnMatchIcon'></button>
                        <hr>
                    </section>

                </section>

            </div>
        </div>
        <div id="VentanaModalSAM1" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div id="closeSAM" class="BotonCerrar_Matc" ><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAM1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM1">
                        <div class="fixedY" id="fixedYSAM1">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioSAM1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAM2" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div id="closeSAM2" class="BotonCerrar_Matc"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAM2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM2">
                        <div class="fixedY" id="fixedYSAM2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioSAM2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAP1" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeSAP" ><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAP1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAP">
                        <div class="fixedY" id="fixedYSAP">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioSAP1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAP2" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeSAP2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAP2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAP2">
                        <div class="fixedY" id="fixedYSAP2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioSAP2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSolicitante" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeSOL"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaSolicitante">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSolic">
                        <div class="fixedY" id="fixedYSoli">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteSolStatus"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSolicitante">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAlmacen" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeAlma"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlma">
                        <div class="fixedY" id="fixedYAlma">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></th>
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

        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeMate"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaMaterial">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMate">
                        <div class="fixedY" id="fixedYMate">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMaterial">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalPosicion" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closePos"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaPosicion">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPos">
                        <div class="fixedY" id="fixedYPos">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTipoPosición2"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosPosicion">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        

        <div id="VentanaModalImputacion" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="closeimpu"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaImputacion">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollimp">
                        <div class="fixedY" id="fixedYimp">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPTituloImputacion2"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosImputacion">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input type="text" hidden id="IDFecha"/>
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