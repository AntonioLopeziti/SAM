
<%@page import="java.io.InputStream"%>
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
        String numdocno = po.getProperty("etiqueta.ReporteDMSNumDocnot");
        String folionot = po.getProperty("etiqueta.ReporteDMFoliDMSnotEn");
        String clsdoc = po.getProperty("etiqueta.ReporteDMSClasDoc");
        String notexitval = po.getProperty("etiqueta.NoExisteValores_SAM");
        String Nohayres = po.getProperty("etiqueta.ReportesListNoExiRes");
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
            var pag = p.charAt(10);
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
                    msg = '<%=Nohayres%>';
                    break;
                case 2:
                    msg = '<%=notexitval%>';
                    break;
                case 3:
                    msg = '<%=folionot%>: ' + va;
                    break;
                case 4:
                    msg = '<%=numdocno%>: ' + va;
                    break;
                case 5:
                    msg = '<%=clsdoc%>: ' + va;
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
        <link rel="stylesheet" href="css/StyleReportes.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/ReporteDMS.js" type="text/javascript"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script  src="js/dom-drag.js"></script>
        <title><%out.println(po.getProperty("etiqueta.ReporteDMS_title"));%></title>      
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
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteDMS_title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivBusquedaNotificaciones">
                    <label><%out.println(po.getProperty("etiqueta.Reporte_DatosBas"));%></label>
                    <hr id="lineatituloReportes">
                    <section class='DivIzquierda'>
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><select style="width: 32%" id="centro"></select>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ReporteDMFoliDMS"));%></label><input id="sam1" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A1" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ReporteDMSNumDOC"));%></label><input id="doc1" type="text" style='width: 45%; text-transform: uppercase;' maxlength="25"><button id="match_A2" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input id="fec1" onpaste="return false" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A3" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></label><input id="cdoc" type="text" style='width: 25%; text-transform: uppercase;' maxlength="3"><button id="match_A4" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class='DivDerecha'>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="sam2" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="doc2" type="text" style='width: 45%; text-transform: uppercase;' maxlength="25"><button id="match_A6" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="fec2" onpaste="return false" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A7" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                </section>
                <section class="DivRadio">
                    <section class='DivLeft'>
                        <input type="radio" id="rb1" name="rb" value="E" ><label for="rb1"><%out.println(po.getProperty("etiqueta.Reporte_ConError"));%></label><br>
                        <input type="radio" id="rb2" name="rb"value="T" checked><label for="rb2"><%out.println(po.getProperty("etiqueta.Reporte_TodosDa"));%></label>
                    </section>
                </section>
            </div>
        </div>
        <div id="VentanaModalDMS" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULDMS"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioDMS">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDMS">
                        <div class="fixedY" id="fixedYDMS">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteDMFoliDMS"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioDMS">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalDMS2" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULDMS2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioDMS">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDMS2">
                        <div class="fixedY" id="fixedYDMS2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteDMFoliDMS"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosFolioDMS2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalDoc" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULDOC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaDoc">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDoc">
                        <div class="fixedY" id="fixedYDoc">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteDMSNumDOC"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDoc">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalDoc2" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULDOC2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaDoc2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollDoc2">
                        <div class="fixedY" id="fixedYDoc2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ReporteDMSNumDOC"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosDoc2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalClaseDoc" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="OCULClA"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaClase">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseDoc">
                        <div class="fixedY" id="fixedYClaseDoc">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.CSPClaseDocumento"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseDoc">
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