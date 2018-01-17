<%-- 
    Document   : ReporteAvisos
    Created on : 27/08/2016, 11:03:41 PM
--%>
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
        po.load(in);
        String Noexistval = po.getProperty("etiqueta.NoExisteValores_SAM");
        String ErroCent = po.getProperty("etiqueta.ReporteErrorCentro");
        String ErroSAM = po.getProperty("etiqueta.ReporteErrorFolioSAM");
        String ErroSAP = po.getProperty("etiqueta.ReporteErrorFolioSAP");
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

            }
            $('#msg').html(msg);
            var icon = $('#iconmsg');
            icon.show();
            icon.attr('src', im);
            var BE = document.createElement('audio');
            BE.src = au;
            BE.play();
        }
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


    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script  src="js/dom-drag.js"></script>
        <script src="js/Reportes2.js" type="text/javascript"></script>
        <script src="js/ReporteAvisos.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.ReporteAvisos_Title"));%></title>    
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
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="fin();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png" onclick="Validar();"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteAvisos_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivBusqueda">
                    <label><%out.println(po.getProperty("etiqueta.Reporte_DatosBas"));%></label>
                    <hr id="lineatituloReportes">
                    <section class='DivIzquierda'>
                        <label id="lblCentro"><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input id="centro" type="text" style='width: 10%; text-transform: uppercase;' maxlength="4"><button id="match_A1" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAM"><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></label><input id="sami" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A2" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAP"><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></label><input id="sapi" type="text" style='width: 35%; text-transform: uppercase;' maxlength="12"><button id="match_A3" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFecha"><%out.println(po.getProperty("etiqueta.Reporte_fechap"));%></label><input value="" maxlength="10" type="text" value="" id="fecha_inicio" style="width:20%;"/><button id="match_F1A" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class='DivDerecha'>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="samf" type="text" style='width: 30%; text-transform: uppercase' maxlength="10"><button id="match_A4" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="sapf" type="text" style='width: 35%; text-transform: uppercase' maxlength="12"><button id="match_A5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input value="" maxlength="10" type="text" value="" id="fecha_fin" style="width:20%;"/><button id="match_F2A" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                </section>
                <section class="DivRadio">
                    <section class='DivLeft'>
                        <input type="radio" id="rb1" name="rb" value="1" ><label for="rb1"><%out.println(po.getProperty("etiqueta.Reporte_ConError"));%></label><br>
                        <input type="radio" id="rb2" name="rb"value="0" checked><label for="rb2"><%out.println(po.getProperty("etiqueta.Reporte_TodosDa"));%></label>
                        <input id ='IdioMat' value='<%=Idioma%>' hidden></input>
                    </section>
                </section>
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
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaOCompras">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOCompras">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAM1" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sam1')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAM1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM">
                        <div class="fixedY" id="fixedYSAM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></th>
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
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sam2')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAM2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM2">
                        <div class="fixedY" id="fixedYSAM2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></th>
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
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sap1')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAP1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAP">
                        <div class="fixedY" id="fixedYSAP">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></th>
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
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sap2')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaFolioSAP2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAP2">
                        <div class="fixedY" id="fixedYSAP2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></th>
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