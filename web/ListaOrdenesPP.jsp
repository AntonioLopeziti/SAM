
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String orndenoexis = po.getProperty("etiqueta.NoExiste_OR");
        String claseordno = po.getProperty("etiqueta.NoExisteClase_OR");
        String Ubicnot = po.getProperty("etiqueta.ListaUbicacNot");
        String ListaEquiponot = po.getProperty("etiqueta.ListaEquiponot");
        String Listapuetonot = po.getProperty("etiqueta.Listapuetonot");
        String ReportesListNoExiRes = po.getProperty("etiqueta.ReportesListNoExiRes");
        String Listalehgieunc = po.getProperty("etiqueta.Listalehgieunc");
        String ReporteErrorFolioSAM = po.getProperty("etiqueta.ReporteErrorFolioSAM");
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String Domingo = po.getProperty("etiqueta.Domingo");
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
                var pag = p.charAt(125);
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
                        msg = '<%=menValores%>';
                        break;
                    case 2:
                        msg = '<%=orndenoexis%>';
                        break;
                    case 3:
                        msg = '<%=claseordno%>';
                        break;
                    case 4:
                        msg = '<%=Ubicnot%>';
                        break;
                    case 5:
                        msg = '<%=ListaEquiponot%>';
                        break;
                    case 6:
                        msg = '<%=Listapuetonot%>';
                        break;
                    case 7:
                        msg = '<%=ReportesListNoExiRes%>';
                        break;
                    case 8:
                        msg = '<%=Listalehgieunc%>';
                        break;
                    case 9:
                        msg = '<%=ReporteErrorFolioSAM%>';
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
        <link rel="stylesheet" href="css/StyleListOrdenesPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/ListaOrdenesPP.js" type="text/javascript"></script>
        <!--<script src="js/ListOrdenes.js" type="text/javascript"></script>-->
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloListaOrdenes_LO_PP"));%></title>   
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
            <input id="Idioma" type="Text" value="<%=Idioma%>" hidden>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloListaOrdenes_LO_PP"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentListMat">
                <div class="divStatuLO">
                    <label><%out.println(po.getProperty("etiqueta.Statusorden_LO"));%></label>
                    <hr class="titulo_ListO">  
                    <div class="divst1">
                        <input id="abie" value="ABIE" type="checkbox"/><label style="margin-right: 2%;"><%out.println(po.getProperty("etiqueta.Pendiente_LO_PP"));%></label>
                        <input id="lib" value="LIB." type="checkbox"/><label style="margin-right: 2%;"><%out.println(po.getProperty("etiqueta.EnTratamineto_LO_PP"));%></label>
                        <input id="ctec" value="CTEC" type="checkbox"/><label style="margin-right: 2%;"><%out.println(po.getProperty("etiqueta.Concluido_LO_PP"));%></label>
                    </div>
                </div>
                <div class="DivSelecOrdenes_LO">
                    <label><%out.println(po.getProperty("etiqueta.SeleOrde_LO_PP"));%></label>
                    <hr class="titulo_ListO">
                    <section class="SeleOrIzq_LO">
                        <label><%out.println(po.getProperty("etiqueta.ClasOrd_LO_PP"));%></label><input type="text" style="width:12%; text-transform: uppercase;" maxlength="4" id="clOrdL"/><button id="btnmat1" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Ord_LO_PP"));%></label><input type="text" style="width: 30%; text-transform: uppercase;" maxlength="12" id="OrdeL"/><button id="btnmat2" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM_PP"));%></label><input type="text" style="width: 30%; text-transform: uppercase;" maxlength="12" id="SAMOrden"/><button id="btnmat3" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.TxtBree_Ordene_PP"));%></label><input type="text" id="txtbrvord" style="width: 45%; text-transform: uppercase;" maxlength="150">
                        <hr>
<!--                        <label><%out.println(po.getProperty("etiqueta.UbicTec_LO_PP"));%></label><input type="text" style="width:42%; text-transform: uppercase;" maxlength="30" id="ubitl"/><button id="btnmat4" class="BtnMatchIcon"></button>
                        <hr>-->
                        <label>Material</label><input type="text" style="width:42%; text-transform: uppercase;" maxlength="18" id="equiL"/><button id="btnmat5" class="BtnMatchIcon"></button>
                        <!--                        <hr>
                                                <label><%out.println(po.getProperty("etiqueta.PtoTbjoRes_LO_PP"));%></label><input type="text" style="width: 25%; text-transform: uppercase;" id="ptol"/><button id="btnmat6" class="BtnMatchIcon2"></button>-->
                        <hr>
                        <label>Inicio Extremo</label><input  maxlength="10" type="text" value="" id="fechaord" style="width:25%; background-repeat: no-repeat;" onpaste="return false;"/><button id="btnmat13" class="BtnMatchIcon"></button>
                        <hr>
                        <label>Fecha</label><input maxlength="15" type="text" value="" id="iniEx1" style="width:30%; background-repeat: no-repeat;"><button id="btnmat15" class="BtnMatchIcon"></button>
                        <hr>
                    </section>
                    <section class="SelOrDer_LO">
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 12%; text-transform: uppercase;" id="clOrdL2"/><button id="btnmat7" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 30%; text-transform: uppercase;" id="OrdeL2"/><button id="btnmat8" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 30%; text-transform: uppercase;" id="SAMOrden2"/><button id="btnmat9" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 45%; text-transform: uppercase;" id="txtbrvord2"/>
                        <!--<hr>-->
                        <!--<label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 42%; text-transform: uppercase;" id="ubitl2"/><button id="btnmat10" class="BtnMatchIcon"></button>-->
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 42%; text-transform: uppercase;" id="equiL2"/><button id="btnmat11" class="BtnMatchIcon"></button>
                        <!--<hr>-->
                        <!--<label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input type="text" style="width: 25%; text-transform: uppercase;" id="ptol2"/><button id="btnmat12" class="BtnMatchIcon"></button>-->
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input  maxlength="10" type="text" value="" id="fechaord2" style="width:25%;  background-repeat: no-repeat;" onpaste="return false;"/><button id="btnmat14" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.A_LO_PP"));%></label><input maxlength="15" type="text" id="iniEx2" style="width: 30%; background-repeat: no-repeat"><button id="btnmat16" class="BtnMatchIcon"></button>
                        <hr>
                    </section>                      
                </div>
            </div>  
        </div>
        <div id="VentanaModalClaseOrden" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ClaseOrdenManOr_PP"));%></label><div class="BotonCerrar_Matc"id="CerraClaOd"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retbtncl"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamCOr" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ClaseOrdenMOR_PP"));%></label><input type="text" id="CClaseOrden" maxlength="8" style="width:35%; text-transform: uppercase;" focus/>
                        <hr>
                        <label>Centro</label><input type="text" id="CentroClasOrd" maxlength="4" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okClaseOrden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraClaOd2"/>
                </div>
            </div>
            <div id="ConsultaTablaClaseOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseOrden">
                        <div class="fixedY" id="fixedYClaseOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ClaseOrdenMOR_PP"));%></th><th>Centro</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseOrden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>          
        <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumOrdenPM_OR_PP"));%></label><div class="BotonCerrar_Matc"  id="CerraOrdmtc"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retord1"><%out.println(po.getProperty("etiqueta.BtnNumOrdenPM_OR_PP"));%></button><hr></div>
            <div id="BuscarParam_OR" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ordenOr_PP"));%></label><input type="text" id="NumOrden_Bus" maxlength="12" style="width:35%; text-transform: uppercase;"  />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></label><input type="text" id="TextoOrden_Bus" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax2"  style="width:10%;" maxlength="3" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okorden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraOrdmtc2"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollord">
                        <div class="fixedY" id="fixedYord">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ordenOr_PP"));%></th><th><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAM" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><div class="BotonCerrar_Matc"  id="CerraSAMMC"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retSAM"><%out.println(po.getProperty("etiqueta.BtnNumOrdenPM_OR_PP"));%></button><hr></div>
            <div id="BuscarParam_SAM" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input type="text" id="FoliSAM_ord" maxlength="12" style="width:35%; text-transform: uppercase;"  />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></label><input type="text" id="TextoSAM_ord" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax3"  style="width:10%;" maxlength="3" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okSAM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraSAMMC2"/>
                </div>
            </div>
            <div id="ConsultaTablaSAM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM">
                        <div class="fixedY" id="fixedSAM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSAM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalUbiTec" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></label><div class="BotonCerrar_Matc" id="Cerrarubute"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retubitec"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamUbi" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></label><input type="text" id="UbitteBus" style="width:35%; text-transform: uppercase;" malength="30"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DenUbiOr_PP"));%></label><input type="text" id="DUbitectBus" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax4" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbicacion"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="Cerrarubute2"/>
                </div>
            </div>
            <div id="ConsultaTablaUbicacion" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbicacion">
                        <div class="fixedY" id="fixedYUbicacion">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></th><th><%out.println(po.getProperty("etiqueta.DenUbiOr_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUbicacion">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalEquipos" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="cerareq"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retequi"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamE" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Material</label><input type="text" id="equBus" maxlength="30" style="width:35%; text-transform: uppercase"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" maxlength="40" id="denEqBus" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax5"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="cerareq2"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo">
                        <div class="fixedY" id="fixedYEquipo">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Material</th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosEquipo">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPuesto" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PuestoTrabjotiumaLO_PP"));%></label><div class="BotonCerrar_Matc" id="Cerrapueto"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retrpuesto"><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></button><hr></div>
            <div id="BuscarParamPt" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></label><input type="text" id="puestp" style="width:35%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></label><input type="text" id="Ptexto_mate" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax6"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPuesto"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="Cerrapueto2" />
                </div>
            </div>
            <div id="ConsultaTablaPuesto" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuesto">
                        <div class="fixedY" id="fixedYPuesto">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></th><th><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosPuesto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalClaseOrden2" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ClaseOrdenManOr_PP"));%></label><div class="BotonCerrar_Matc"id="CerraClaOd222"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retbtncl2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamCOr2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ClaseOrdenMOR_PP"));%></label><input type="text" id="CClaseOrden2" maxlength="8" style="width:35%; text-transform: uppercase;" focus/>
                        <hr>
                        <label>Centro</label><input type="text" id="CentroClasOrd2" maxlength="4" style="width:15%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax7" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okClaseOrden2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraClaOd22"/>
                </div>
            </div>
            <div id="ConsultaTablaClaseOrden2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClaseOrden2">
                        <div class="fixedY" id="fixedYClaseOrden2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ClaseOrdenMOR_PP"));%></th><th>Centro</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClaseOrden2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <div id="VentanaModalOrden2" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumOrdenPM_OR_PP"));%></label><div class="BotonCerrar_Matc"  id="CerraOrdmtc22"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retord12"><%out.println(po.getProperty("etiqueta.BtnNumOrdenPM_OR_PP"));%></button><hr></div>
            <div id="BuscarParam_OR2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.ordenOr_PP"));%></label><input type="text" id="NumOrden_Bus2" maxlength="12" style="width:35%; text-transform: uppercase;"  />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></label><input type="text" id="TextoOrden_Bus2" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax8"  style="width:10%;" maxlength="3" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okorden2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraOrdmtc222"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollord2">
                        <div class="fixedY" id="fixedYord2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.ordenOr_PP"));%></th><th><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosOrden2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSAM2" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><div class="BotonCerrar_Matc"  id="CerraSAMMC22"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retSAM2"><%out.println(po.getProperty("etiqueta.BtnNumOrdenPM_OR_PP"));%></button><hr></div>
            <div id="BuscarParam_SAM2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input type="text" id="FoliSAM_ord2" maxlength="12" style="width:35%; text-transform: uppercase;"  />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></label><input type="text" id="TextoSAM_ord2" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax9"  style="width:10%;" maxlength="3" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okSAM2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraSAMMC222"/>
                </div>
            </div>
            <div id="ConsultaTablaSAM2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM2">
                        <div class="fixedY" id="fixedSAM2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.textobreve_OR_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosSAM2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalUbiTec2" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></label><div class="BotonCerrar_Matc" id="Cerrarubute22"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retubitec2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamUbi2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></label><input type="text" id="UbitteBus2" style="width:35%; text-transform: uppercase;" malength="30"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DenUbiOr_PP"));%></label><input type="text" id="DUbitectBus2" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax10" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbicacion2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="Cerrarubute222"/>
                </div>
            </div>
            <div id="ConsultaTablaUbicacion2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbicacion2">
                        <div class="fixedY" id="fixedYUbicacion2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.UbicaOR_PP"));%></th><th><%out.println(po.getProperty("etiqueta.DenUbiOr_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosUbicacion2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalEquipos2" class="VentanaModal">
            <div id="handle11"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="cerareq22"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retequi2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamE2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.EquipoOR_PP"));%></label><input type="text" id="equBus2" maxlength="30" style="width:35%; text-transform: uppercase"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" maxlength="40" id="denEqBus2" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax11"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="cerareq222"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo2">
                        <div class="fixedY" id="fixedYEquipo2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Material</th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosEquipo2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalPuesto2" class="VentanaModal">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PuestoTrabjotiumaLO_PP"));%></label><div class="BotonCerrar_Matc" id="Cerrapueto22"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retrpuesto2"><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></button><hr></div>
            <div id="BuscarParamPt2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></label><input type="text" id="puestp2" style="width:35%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></label><input type="text" id="Ptexto_mate2" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax12"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPuesto2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="Cerrapueto222" />
                </div>
            </div>
            <div id="ConsultaTablaPuesto2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuesto2">
                        <div class="fixedY" id="fixedYPuesto2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestpTrabj_LO_PP"));%></th><th><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosPuesto2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <!--Ventana Modal Fecha Inicio Extremo-->
        <div id="VentanaModalInicioExtremo1" class="VentanaModal">
            <div id="handle13"><label id="TituloMatch">Fecha Inicio Extrema</label><div class="BotonCerrar_Matc" id="CerrarIniEx1"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retiniex1">Inicio Extremo</button><hr></div>
            <div id="BuscarParamIE2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Fecha Inicio Extrema</label><input type="text" id="FiniEx1" style="width:35%; text-transform: uppercase;" />
                        <hr>
<!--                        <label><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></label><input type="text" id="Ptexto_mate2" style="width:35%; text-transform: uppercase;"/>
                        <hr>-->
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax15"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okIniEx1"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarIniEx11" />
                </div>
            </div>
            <div id="ConsultaIniExt1" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollIniEx1">
                        <div class="fixedY" id="fixedYIniEx1">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Inicio Extremo</th><th>Numero de Orden</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosIniExtremo1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        
        <!--Ventana Modal Fecha Inicio Extremo DOS-->
        <div id="VentanaModalInicioExtremo2" class="VentanaModal">
            <div id="handle14"><label id="TituloMatch">Fecha Inicio Extrema</label><div class="BotonCerrar_Matc" id="CerrarIniEx2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retiniex2">Inicio Extremo</button><hr></div>
            <div id="BuscarParamIE22" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Fecha Inicio Extrema</label><input type="text" id="FiniEx2" style="width:35%; text-transform: uppercase;" />
                        <hr>
<!--                        <label><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></label><input type="text" id="Ptexto_mate2" style="width:35%; text-transform: uppercase;"/>
                        <hr>-->
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax16"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okIniEx2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerrarIniEx22" />
                </div>
            </div>
            <div id="ConsultaIniExt2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollIniEx2">
                        <div class="fixedY" id="fixedYIniEx2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Inicio Extremo</th><th><%out.println(po.getProperty("etiqueta.PTDescripcio_LO_PP"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosIniExtremo2">
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