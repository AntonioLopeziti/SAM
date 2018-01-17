<%-- 
    Document   : VisualizarDocumentosListaMaterial
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
                response.sendRedirect("#");
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
        String VLDErrorProvr = po.getProperty("etiqueta.VLDErrorProvr");
        String ErroClase = po.getProperty("etiqueta.ReportesListaReserResNoECM");
        String nohayres = po.getProperty("etiqueta.ReportesListNoExiRes");
        String VLDErrorAlmace = po.getProperty("etiqueta.VLDErrorAlmace");
        String VLDErrorCentro = po.getProperty("etiqueta.VLDErrorCentro");
        String VLDErrorMaterial = po.getProperty("etiqueta.VLDErrorMaterial");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
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
                var pag = p.charAt(36);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function mensajesValidacionInco(msg, im, au, val) {
                var m = "";
                switch (msg) {
                    case 0:
                        m = "<%=funcioninv%>";
                        break;
                    case 1:
                        m = "<%=menValores%>";
                        break;
                    case 2:
                        m = "<%=VLDErrorMaterial%> " + val;
                        break;
                    case 3:
                        m = "<%=VLDErrorCentro%> " + val;
                        break;
                    case 4:
                        m = "<%=VLDErrorAlmace%> " + val;
                        break;
                    case 5:
                        m = "<%=VLDErrorProvr%> " + val;
                        break;
                    case 6:
                        m = "<%=ErroClase%>: " + val;
                        break;
                    case 7:
                        m = "<%=nohayres%>";
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', im);
                $('#msg').html(m);
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleDocListaMaterial.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarDocListaMaterial.js"></script>  
        <title><%out.println(po.getProperty("etiqueta.TiutloVisDocVDL"));%></title>  
    <body>
        <script>
            $(function () {
                var fehSet = $('#fecCon');
                $("#datapicker").datepicker({
                    dateFormat: 'dd.mm.yy',
                    firstDay: 0,
                    monthNames: ['<%=Enero%>', '<%=Febrero%>', '<%=Marzo%>', '<%=Abril%>', '<%=Mayo%>', '<%=Junio%>',
                        '<%=Julio%>', '<%=Agosto%>', '<%=Septiembre%>', '<%=Octubre%>', '<%=Noviembre%>', '<%=Diciembre%>'],
                    dayNames: ['<%=Domingo%>', '<%=Lunes%>', '<%=Martes%>', '<%=Miercoles%>', '<%=Jueves%>', '<%=Viernes%>', '<%=Sabado%>'],
                    dayNamesMin: ['<%=Do%>', '<%=lu%>', '<%=Ma%>', '<%=Mi%>', '<%=Ju%>', '<%=vi%>', '<%=sa%>'],
                    onSelect: function (date) {
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
            <input  id="regresar" type="image" src="images/regresa.PNG" />
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png" />
            <div class="titulo">
                <h1><%out.println(po.getProperty("etiqueta.TiutloVisDocVDL"));%></h1>
            </div> 
        </div>
        <div class="contenido">
            <div class="ContentDocumentosLista" id="contentMain">   
                <section class="SecDatosPosi_DLM">
                    <label><%out.println(po.getProperty("etiqueta.DatosPsosDocVLD"));%></label>
                    <hr id="lineadatosposDLM">
                    <section class="sec1">
                        <label><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></label><input type="text" id="material" class="campos" style="width: 35%; text-transform: uppercase;" maxlength="40"/><button id="match1" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CentroDocVLD"));%></label><input type="text" id="centro" class="campos" style="text-transform: uppercase; width: 15%;" maxlength="4" /><button id="match2" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.AlmacDocVLD"));%></label><input type="text" id="almacen" class="campos" style="text-transform: uppercase; width: 15%;" maxlength="4" /><button id="match3" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ProveedorDocVLD"));%></label><input type="text" id="proveedor" class="campos" style="width: 35%; text-transform: uppercase;" maxlength="10" /><button id="match4" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ClmovDocVLD"));%></label><input type="text" id="clase" class="campos" style="width: 7%;" maxlength="3"/><button id="match5" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VLDFechaCon"));%></label><input type="text"  id="fecCon" class="campos" onpaste="return false;" style="width: 25%;"/><button id="match7" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class="sec2">
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input type="text" id="material2" class="campos" style="width: 35%; text-transform: uppercase;" maxlength="40"/><button id="match6" class='BtnMatchIcon2'></button>
                        <hr>
                    </section>
                </section>
            </div> 
        </div>
        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></label><div class="BotonCerrar_Matc" id="OCUMaterial1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retorMat"><%out.println(po.getProperty("etiqueta.NTextBDocVlD"));%></button><hr></div>
            <div id="BuscarParamMaterial" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></label><input type="text" name="matename" id="SearchMaterial" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" name="matename" id="searchTMaterial"  maxlength="80" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" name="matename"  id="numAcMax1" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="OCUMaterial2"/>
                </div>
            </div>
            <div id="ConsultaTablaMaterial" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial">
                        <div class="fixedY" id="fixedYMaterial">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
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
        <div id="VentanaModalMaterial2" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></label><div class="BotonCerrar_Matc" id="OCUMaterial3"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retorMat2"><%out.println(po.getProperty("etiqueta.NTextBDocVlD"));%></button><hr></div>
            <div id="BuscarParamMaterial2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></label><input type="text" name="matename2" id="SearchMaterial2" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></label><input type="text" name="matename2" id="searchTMaterial2"  maxlength="80" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" name="matename2"  id="numAcMax2" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="OCUMaterial4"/>
                </div>
            </div>
            <div id="ConsultaTablaMaterial2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial2">
                        <div class="fixedY" id="fixedYMaterial2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MaterialDocVLD"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMaterial2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></label><div class="BotonCerrar_Matc" id="OCULCentro"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Centro_CC"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_CC"));%></th>
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
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.IdAlmacen_CA"));%></label><div class="BotonCerrar_Matc" id="OCULAlmac"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmacen">
                        <div class="fixedY" id="fixedYAlmacen">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.IdAlmacen_CA"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_CA"));%></th><th><%out.println(po.getProperty("etiqueta.Centro_CA"));%></th>
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
        <div id="VentanaModalProveedor" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumCuentProvDocVLD"));%></label><div class="BotonCerrar_Matc" id="OCULProv"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="RetProv"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamProveedor" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ProveedorDocVLD"));%></label><input type="text" name="nameprov" id="searchPAcre" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ProveedorNomDocVLD"));%></label><input type="text" name="nameprov" id="SearchPNombre" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  name="nameprov"  id="numAcMaxP" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okProveedor"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="OCULProv2"/>
                </div>
            </div>
            <div id="ConsultaTablaProveedor" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollProveedor">
                        <div class="fixedY" id="fixedYProveedor">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ProveedorDocVLD"));%></th><th><%out.println(po.getProperty("etiqueta.ProveedorNomDocVLD"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosProveedor">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalClaseM" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ClaMovVLD"));%></label><div class="BotonCerrar_Matc" id="OCULClase"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaMovimiento">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseM">
                        <div class="fixedY" id="fixedYClaseM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ClaMovVLD"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseM">
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
                <script>
                    function inval() {
                        mensajesValidacionInco(0, "images/advertencia.PNG", "audio/saperror.wav");
                    }
                </script>
        </footer>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>