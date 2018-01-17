<%-- 
    Document   : MonitorAvisosPM
    Created on : 17/06/2016, 12:28:21 PM
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String ptNV = po.getProperty("etiqueta.ptNV");
        String ReportesListNoExiRes = po.getProperty("etiqueta.ReportesListNoExiRes");
        String Listalehgieunc = po.getProperty("etiqueta.Listalehgieunc");
        String NPMOrdennoten = po.getProperty("etiqueta.NPMOrdennoten");
        String NPMEquipnotfou = po.getProperty("etiqueta.NPMEquipnotfou");
        String NPMUbicacionnot = po.getProperty("etiqueta.NPMUbicacionnot");
        String NPMclaseAvisoNotFoun = po.getProperty("etiqueta.NPMclaseAvisoNotFoun");
        String ReporteErrorFolioSAM = po.getProperty("etiqueta.ReporteErrorFolioSAM");
        String notifino = po.getProperty("etiqueta.NPMNotificacionFou");
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
                var pag = p.charAt(67);
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
                        msg = '<%=notifino%>';
                        break;
                    case 3:
                        msg = '<%=ReporteErrorFolioSAM%>';
                        break;
                    case 4:
                        msg = '<%=NPMclaseAvisoNotFoun%>';
                        break;
                    case 5:
                        msg = '<%=NPMUbicacionnot%>';
                        break;
                    case 6:
                        msg = '<%=NPMEquipnotfou%>';
                        break;
                    case 7:
                        msg = '<%=NPMOrdennoten%>';
                        break;
                    case 8:
                        msg = '<%=ptNV%>';
                        break;
                    case 9:
                        msg = '<%=Listalehgieunc%>';
                        break;
                    case 10:
                        msg = '<%=ReportesListNoExiRes%>';
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
        <link rel="stylesheet" href="css/styleMAPM.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/MonitorAvisosPM.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.MAPMMonitordeAvisosPM"));%></title>       
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
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled />               
            <input  id="regresar" type="image" src="images/regresa.PNG" />
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.MAPMMonitordeAvisosPM"));%></h1></div>      
        </div>          
        <div class="contenido">
            <div class="ContentMonitorAviso">
                <section class="divStatu">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.MAPMStatusdelEquipo"));%></label> 
                    <hr class="lineaazul">
                    <input id="pend" value="MEAB" type="checkbox"/><label><%out.println(po.getProperty("etiqueta.pendiente"));%></label>
                    <input id="posp" value="MDIF" type="checkbox"/><label><%out.println(po.getProperty("etiqueta.MAPMPospuesto"));%></label>
                    <input id="trat" value="METR" type="checkbox"/><label><%out.println(po.getProperty("etiqueta.MAPMEntratam"));%></label>
                    <input id="conc" value="MECE" type="checkbox"/><label><%out.println(po.getProperty("etiqueta.MAPMConcluido"));%></label>
                </section>
                <section class="divSelAviso">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.MAPMSelecciondeAvisos"));%></label> 
                    <hr class="lineaazul">
                    <div class="divizqequipo">
                        <label><%out.println(po.getProperty("etiqueta.MAPMNotificacion"));%></label><input  id="Aviso1" style="width: 25%; text-transform: uppercase;" type="text" maxlength='12'/><button id="btn1" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input  id="Aviso2" style="width: 25%; text-transform: uppercase;" type="text" maxlength='12'/><button id="btn2" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMClasedeaviso"));%></label><input  id="Aviso15" style="width: 15%; text-transform: uppercase;" type="text" maxlength='6'/><button id="btn13" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></label><input id="Aviso3" style="width: 40%; text-transform: uppercase;" type="text" maxlength='30'/><button id="btn3" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></label><input  id="Aviso4" style="width: 40%; text-transform: uppercase" maxlength='18' type="text"/><button id="btn4" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMOrden"));%></label><input  id="Aviso5" style="width: 25%;  text-transform: uppercase" maxlength='12' type="text"/><button id="btn5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PtoTbjoRes_LO"));%></label><input id="Aviso6"  style="width: 25%; text-transform: uppercase;" /><button id="btn6" class="BtnMatchIcon"></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMFechadeaviso"));%></label><input id="Aviso7"  style="width:20%;" type="text" maxlength='10' onpaste="return false;" /><button id="btn15" class="BtnMatchIcon"></button>
                        <hr>
                    </div>
                    <div class="dividerequipo">
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso8"  type="text" style="width:25%; text-transform: uppercase;" maxlength='12'/><button id="btn7" class='BtnMatchIcon'></button>
                        <hr>                                
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso9"  type="text" style="width:25%; text-transform: uppercase;" maxlength='12'/><button id="btn8" class='BtnMatchIcon'></button>
                        <hr>                                
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso16"  type="text" style="width:15%; text-transform: uppercase;" maxlength='6'/><button id="btn14" class='BtnMatchIcon'></button>
                        <hr>                                
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso10" type="text" style="width:40%; text-transform: uppercase;" maxlength='30'/><button id="btn9" class='BtnMatchIcon'></button>
                        <hr>                                
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso11" type="text" style="width:40%; text-transform: uppercase;" maxlength='18'/><button id="btn10" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso12" type="text" style="width:25%; text-transform: uppercase;" maxlength='12'/><button id="btn11" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso13" type="text" style="width:25%; text-transform: uppercase;" maxlength='12'/><button id="btn12" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMa"));%></label><input id="Aviso14" type="text" style="width:20%;" onpaste="return false;"x maxlength='10'/><button id="btn16" class="BtnMatchIcon"></button>
                        <hr>
                    </div>
                </section>                   
            </div>
        </div>
        <div id="VentanaModalNoti1" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMNoNotifmonitor"));%></label><div class="BotonCerrar_Matc" id="CerrarNoti"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="mosnot"><%out.println(po.getProperty("etiqueta.MAPMNotifimonitor"));%></button><hr></div>
            <div id="BuscarParamNot1" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMNoNotifmonitor"));%></label><input id="NNotbus" maxlength="12" type="text" style="width: 25%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="NotTxtBus"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okNotificacion"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarNoti2"/>
                </div>
            </div>
            <div id="ConsultaTablaNot1" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollNot1">
                        <div class="fixedY" id="fixedYNot1">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNotifimonitor"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosNotificaciones1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalNoti2" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMNoNotifmonitor"));%></label><div class="BotonCerrar_Matc" id="CerrarNotif2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="mosnot2"><%out.println(po.getProperty("etiqueta.MAPMNotifimonitor"));%></button><hr></div>
            <div id="BuscarParamNot2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMNoNotifmonitor"));%></label><input id="NNotbus2" maxlength="12" type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="NotTxtBus2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax2"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okNotificacion2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarNoti22"/>
                </div>
            </div>
            <div id="ConsultaTablaNot2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollNot2">
                        <div class="fixedY" id="fixedYNot2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNotifimonitor"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosNotificaciones2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalSAM" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><div class="BotonCerrar_Matc" id="CerrarSAM"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retsam"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamSAM" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input id="SAMbus" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtSAM"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax3"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okSAM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarSAMM"/>
                </div>
            </div>
            <div id="ConsultaTablaSAM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM">
                        <div class="fixedY" id="fixedYSAM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosSAM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalSAM2" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><div class="BotonCerrar_Matc" id="CerrarSAM2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retsam2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamSAM2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input id="SAMbus2" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtSAM2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax4"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okSAM2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarSAMM2"/>
                </div>
            </div>
            <div id="ConsultaTablaSAM2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollSAM2">
                        <div class="fixedY" id="fixedYSAM2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosSAM2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalClase" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMClasedeaviso"));%></label><div class="BotonCerrar_Matc" id="CerrarClase"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaClase">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClase">
                        <div class="fixedY" id="fixedYClase">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMClasedeaviso"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosClase">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalClase2" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMClasedeaviso"));%></label><div class="BotonCerrar_Matc" id="CerrarClase2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaClase2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollClase2">
                        <div class="fixedY" id="fixedYClase2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMClasedeaviso"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosClase2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div id="VentanaModalUbicacion" class="VentanaModal">
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></label><div class="BotonCerrar_Matc" id="CerrarUbic"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retubi"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamUbicacion" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></label><input id="Ubicacbus" maxlength="30"  type="text" style="width: 30%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtUbi"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax5"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okUbi"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarUbicc"/>
                </div>
            </div>
            <div id="ConsultaTablaUbicacion" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbic">
                        <div class="fixedY" id="fixedYUbic">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosUbic">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalUbicacion2" class="VentanaModal">
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></label><div class="BotonCerrar_Matc" id="CerrarUbic2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retubi2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamUbicacion2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></label><input id="Ubicacbus2" maxlength="30"  type="text" style="width: 30%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtUbi2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax6"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okUbi2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarUbicc2"/>
                </div>
            </div>
            <div id="ConsultaTablaUbicacion2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollUbic2">
                        <div class="fixedY" id="fixedYUbic2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMUbicaciontecnica"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosUbic2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalEquipo" class="VentanaModal">
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></label><div class="BotonCerrar_Matc" id="CerrarEquipo"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retequ"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamEquipo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></label><input id="EquipoBus" maxlength="18"  type="text" style="width: 30%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="TxtEqui"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax7"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okEquipo"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarEquipoo"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo">
                        <div class="fixedY" id="fixedYEquipo">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosEquipo">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalEquipo2" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></label><div class="BotonCerrar_Matc" id="CerrarEquipo2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retequ2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamEquipo2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></label><input id="EquipoBus2" maxlength="18"  type="text" style="width: 30%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="TxtEqui2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax8"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okEquipo2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarEquipoo2"/>
                </div>
            </div>
            <div id="ConsultaTablaEquipo2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollEquipo2">
                        <div class="fixedY" id="fixedYEquipo2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMEquipo"));%></th><th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosEquipo2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle11"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMOrden"));%></label><div class="BotonCerrar_Matc" id="CerrarOrden"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retorde"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamOrden" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NPMNumeroorden"));%></label><input id="OrdenBus" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="TxtOrd"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax9"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okOrden"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarOrdenn"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden">
                        <div class="fixedY" id="fixedYOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.NPMNumeroorden"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMFoSAMmonitor"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosOrden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalOrden2" class="VentanaModal">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MAPMOrden"));%></label><div class="BotonCerrar_Matc" id="CerrarOrden2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retorde2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamOrden2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NPMNumeroorden"));%></label><input id="OrdenBus2" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="TxtOrd2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax10"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okOrden2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarOrdenn2"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden2">
                        <div class="fixedY" id="fixedYOrden2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.NPMNumeroorden"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMFoSAMmonitor"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosOrden2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalPuesto" class="VentanaModal">
            <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarPuesto"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retpto"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamPuesto" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></label><input id="PuestoBus" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtPuesto"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax11"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okPuesto"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarPuestoo"/>
                </div>
            </div>
            <div id="ConsultaTablaPuesto" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuesto">
                        <div class="fixedY" id="fixedYPuesto">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosPuesto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <div id="VentanaModalPuesto2" class="VentanaModal">
            <div id="handle14"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></label><div class="BotonCerrar_Matc" id="CerrarPuesto2"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retpto2"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParamPuesto2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></label><input id="PuestoBus2" maxlength="12"  type="text" style="width: 25%; text-transform: uppercase;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></label><input type="text" maxlength="40" id="txtPuesto2"  style="width: 45%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3" id="numAcMax12"  style="width: 10%;">

                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" id="okPuesto2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarPuestoo2"/>
                </div>
            </div>
            <div id="ConsultaTablaPuesto2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPuesto2">
                        <div class="fixedY" id="fixedYPuesto2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.puestoptrMAA"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.MAPMNTxtBrevmonitor"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cuerpoDatosPuesto2">
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
