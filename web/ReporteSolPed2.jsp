<%-- 
    Document   : ReporteSolPed
    Created on : 28/08/2016, 11:27:41 AM
    Author     : AREConsulting
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
        String TituloPagina = po.getProperty("etiqueta.TituloPaginaRSP");
        String TituloPantalla = po.getProperty("etiqueta.SubTituloRSP");
        String DatosBasicos = po.getProperty("etiqueta.DatosBasicosR");
        String sapR = po.getProperty("etiqueta.FolioSAPR");
        String samR = po.getProperty("etiqueta.FolioSAMR");
        String fechar = po.getProperty("etiqueta.FechaR");
        String ar = po.getProperty("etiqueta.aR");
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
            var pag = p.charAt(81);
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
        <link rel="stylesheet" href="css/StyleReportesSolped.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script  src="js/dom-drag.js"></script>
        <script src="js/ReportesSolped2.js" type="text/javascript"></script>  
        <title><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></title>      
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
            <input id="aceptar" type="image" src="images/aceptar.png" />                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="fin();"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="fin();"/>
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png" onclick="Validar();"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ReporteSolPed_Title"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivBusqueda">
                    <label><%out.println(po.getProperty("etiqueta.Reporte_DatosBas"));%></label>
                    <hr id="lineatituloReportes">
                    <section class='DivIzquierda'>
                        <label id="lblCentro">Centro</label><input id="centro" type="text" maxlength="4" style='width: 10%; text-transform: uppercase;'><button id="match_A1" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAM"><%out.println(po.getProperty("etiqueta.Reporte_FolioSAM"));%></label><input id="sami" type="text" style='width: 30%;' maxlength="10"><button id="match_A2" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAP"><%out.println(po.getProperty("etiqueta.Reporte_FolioSAP"));%></label><input id="sapi" type="text" style='width: 30%;' maxlength="10"><button id="match_A3" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFecha"><%out.println(po.getProperty("etiqueta.Reporte_Fecha"));%></label><input value="" maxlength="10" type="date" value="" id="fechainicio" style="width:30%;  background-repeat: no-repeat;"/>
                        <hr>
                    </section>
                    <section class='DivDerecha'>
                        <label><%out.println(po.getProperty("etiqueta.Reporte_a"));%></label><input id="samf" type="text" style='width: 30%;' maxlength="10"><button id="match_A4" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Reporte_a"));%></label><input id="sapf" type="text" style='width: 30%;' maxlength="10"><button id="match_A5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Reporte_a"));%></label><input value="" maxlength="10" type="date" value="" id="fechafin" style="width:30%;  background-repeat: no-repeat;"/>
                        <hr>
                    </section>
                </section>
              <section class="DivRadio">
                    <section class='DivLeft'>
                         <label id="lblSolicitante">Solicitante</label><input id="solicitante" type="text" maxlength="4" style='width: 30%; text-transform: uppercase;'><button id="match_AA6" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblAlmacen">Almacen</label><input id="almacen" type="text" style='width: 30%;' maxlength="10"><button id="match_AA7" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblMaterial">Material</label><input id="material" type="text" style='width: 30%;' maxlength="10"><button id="match_AA8" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblTipoPos">Tipo Posición</label><input id="posicion" type="text" style='width: 30%;' maxlength="10"><button id="match_AA9" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblTipoImp">Tipo Imputación</label><input id="imputacion" type="text" style='width: 30%;' maxlength="10"><button id="match_AA10" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblCentroCos">Centro Coste</label><input id="coste" type="text" style='width: 30%;' maxlength="10"><button id="match_AA11" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblOrden">Orden</label><input id="orden" type="text" style='width: 30%;' maxlength="10"><button id="match_AA12" class='BtnMatchIcon'></button>
                        <hr>
                       <!-- <label id="lblServicio">Servicio</label><input id="servicio" type="text" style='width: 30%;' maxlength="10"><button id="match_AA13" class='BtnMatchIcon'></button>
                        <hr>-->
                    </section>
                   
                </section>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParamOCompras_SP" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">       
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaOCompras">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOCompras">
                        <div class="fixedY" id="fixedYOCompras">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Centro</th><th>Descripción</th>
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
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarFoliosam1" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaFolioSAM1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY1">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAM</th>
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
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarFoliosam2" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaFolioSAM2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAM</th>
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
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarFoliosap1" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaFolioSAP1">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAP</th>
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
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarFoliosap2" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaFolioSAP2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAP</th>
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
    <!--MATCHS Filtros-->
    
     <div id="VentanaModalSolicitante" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('solicitante')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarSolicitante" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaSolicitante">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Solicitante</th>
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
            <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('almacen')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarAlmacen" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Almacén</th>
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
            <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('material')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarMaterial" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaMaterial">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Número Material</th>
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
            <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('posicion')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarPosicion" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaPosicion">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Tipo Posición</th>
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
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('imputacion')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarImputacion" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaImputacion">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Tipo Imputación</th>
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
     <div id="VentanaModalCoste" class="VentanaModal">
            <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('coste')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarCoste" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaCoste">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Centro Coste</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCoste">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('orden')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarOrden" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaOrden">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Número de Orden</th>
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
    
     <div id="VentanaModalServicio" class="VentanaModal">
            <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('servicio')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarServicio" class="BuscarParam_u" style="display:none"> 
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okSAP"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;"onclick="ocultarVentana('sap');"/>
                </div>
            </div>
            <div id="ConsultaTablaCoste">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll1">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Número de Servicio</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosServicio">
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
                <script type="text/javascript">
                    function startTime() {
                        today = new Date();
                        n = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        h = checkTime(n);
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
                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                        document.getElementById('guardar').disabled = true;
                    }

                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function fin() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
        }
        function Validar() {
            vali();
            location.href = "VisualizarReporteSolPed2.jsp";
        }
        function ErrorBusqueda() {
            var okcon = "No existen datos";
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = okcon;
        }
        function vali() {
            var sam = document.getElementById("sami").value;
            var sap = document.getElementById("sapi").value;
            var fecha1 = document.getElementById("fechainicio").value;
            var sam2 = document.getElementById("samf").value;
            var sap2 = document.getElementById("sapf").value;
            var fecha2 = document.getElementById("fechafin").value;
            var centro = document.getElementById("centro").value;
            
            var solicitante = document.getElementById("solicitante").value;
            var almacen = document.getElementById("almacen").value;
            var material = document.getElementById("material").value;
            var posicion = document.getElementById("posicion").value;
            var imputacion = document.getElementById("imputacion").value;
            var coste = document.getElementById("coste").value;
            var orden = document.getElementById("orden").value;
            
            var vl = "";
            var b = 0;
            var chk = document.getElementsByName("cms")
            for (var j = 0; j < chk.length; j++) {
                if (chk.item(j).checked == false) {
                    b++;
                    vl = chk.item(j).checked;
                } else {
                    vl = "true";
                }
            }
        var elementos = document.getElementsByName("rb");
            for (var i = 0; i < elementos.length; i++) {
                if (elementos[i].checked) {
                    var valor = elementos[i].value;
                }
            }
            enviarDatos(sam, sap, fecha1, sam2, sap2, fecha2, centro, valor, vl,solicitante,almacen,material,posicion,imputacion,coste,orden);
       
    
    }

        /*function validate() {
         var b = 0, chk = document.getElementsByName("cms")
         for (var j = 0; j < chk.length; j++) {
         if (chk.item(j).checked == false) {
         b++;
         }
         }
         if (b == chk.length) {
         alert("Selecciones una o varias opciones");
         document.getElementById("cms").style.border = "2px solid red";
         return false;
         } else {
         document.getElementById("cms").style.border = "";
         }
         }*/

        function enviarDatos(sam, sap, fecha1, sam2, sap2, fecha2, centro, valor, vl,solicitante,almacen,material,posicion,imputacion,coste,orden) {
        
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    
                    var rs = xmlhttp.responseText;
                  
                    var men = document.getElementById("msg");
                    if (rs == 1) {
                        location.href = "VisualizarReporteSolPed2.jsp?solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden;
                    } else {
                        document.getElementById("").value = "";
                        var iconm = document.getElementById("iconmsg");
                        setTimeout(function () {

                        }, 8000);
                    }
                }
            };
            xmlhttp.open("GET", "PeticionVisualizarReportesSP2?SAMISP=" + sam + "&SAPISP=" + sap + "&FECHAISP=" + fecha1 + "&SAMFSP=" + sam2 + "&SAPFSP=" + sap2 + "&FECHAFSP=" + fecha2 + "&CENTRO=" + centro + "&VALOR=" + valor+"&solicitante="+solicitante+"&almacen="+almacen+"&material="+material+"&posicion="+posicion+"&imputacion="+imputacion+"&coste="+coste+"&orden="+orden, true);
            xmlhttp.send();
           
        }
        function mostrarVentanaModal(tipo) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            switch (tipo) {
                case "centro":
                    var ventana1 = document.getElementById('VentanaModalCentro');
                    abrirVentana(ventana1);
                    ConsultaCentro();
                    break;
                case "sam1":
                    var ventana2 = document.getElementById('VentanaModalSAM1');
                    abrirVentana(ventana2);
                    ConsultaFolioSAM1();
                    break;
                case "sam2":
                    var ventana3 = document.getElementById('VentanaModalSAM2');
                    abrirVentana(ventana3);
                    ConsultaFolioSAM2();
                    break;
                case "sap1":
                    var ventana4 = document.getElementById('VentanaModalSAP1');
                    abrirVentana(ventana4);
                    ConsultaFolioSAP1();
                    break;
                case "sap2":
                    var ventana5 = document.getElementById('VentanaModalSAP2');
                    abrirVentana(ventana5);
                    ConsultaFolioSAP2();
                    break;
                case "solicitante":
                    var ventana6 = document.getElementById('VentanaModalSolicitante');
                    abrirVentana(ventana6);
                    ConsultaSolicitante();
                    break;
                  case "almacen":
                    var ventana7 = document.getElementById('VentanaModalAlmacen');
                    abrirVentana(ventana7);
                    ConsultaAlmacen();
                    break;
                case "material":
                    var ventana8 = document.getElementById('VentanaModalMaterial');
                    abrirVentana(ventana8);
                    ConsultaMaterial();
                    break;
                case "posicion":
                    var ventana9 = document.getElementById('VentanaModalPosicion');
                    abrirVentana(ventana9);
                    ConsultaPosicion();
                    break; 
                 case "imputacion":
                    var ventana10 = document.getElementById('VentanaModalImputacion');
                    abrirVentana(ventana10);
                    ConsultaImputacion();
                    break; 
                 case "coste":
                    var ventana11 = document.getElementById('VentanaModalCoste');
                    abrirVentana(ventana11);
                    ConsultaCoste();
                    break;
                case "orden":
                    var ventana12 = document.getElementById('VentanaModalOrden');
                    abrirVentana(ventana12);
                    ConsultaOrden();
                    break;
                case "servicio":
                    var ventana13 = document.getElementById('VentanaModalServicio');
                    abrirVentana(ventana13);
                   // ConsultaFolioSAP2();
                    break;
                   
            }
        }
        function abrirVentana(ventana) {
            var ancho = 350;
            var alto = 650;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            ventana.style.left = x + "px";
            ventana.style.top = y + "px";
            ventana.style.display = 'block';
        }
        function ocultarVentana(tipo) {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#overlay').remove();
            switch (tipo) {
                case "centro":
                    var ventana1 = document.getElementById('VentanaModalCentro');
                    ventana1.style.display = 'none';
                    document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                    document.getElementById("ConsultaTablaOCompras").style.display = "block";
                    document.getElementById("OrgCompras").focus();
                    borramsg();
                    break;
                case "sam1":
                    var ventana2 = document.getElementById('VentanaModalSAM1');
                    ventana2.style.display = 'none';
                    document.getElementById("BuscarFoliosam1").style.display = "none";
                    document.getElementById("ConsultaTablaFolioSAM1").style.display = "block";
                    document.getElementById("sam1").focus();
                    borramsg();
                    break;
                case "sam2":
                    var ventana3 = document.getElementById('VentanaModalSAM2');
                    ventana3.style.display = 'none';
                    document.getElementById("BuscarFoliosam2").style.display = "none";
                    document.getElementById("ConsultaTablaFolioSAM2").style.display = "block";
                    document.getElementById("sam2").focus();
                    borramsg();
                    break;
                case "sap1":
                    var ventana4 = document.getElementById('VentanaModalSAP1');
                    ventana4.style.display = 'none';
                    document.getElementById("BuscarFoliosap1").style.display = "none";
                    document.getElementById("ConsultaTablaFolioSAP1").style.display = "block";
                    document.getElementById("sap1").focus();
                    borramsg();
                    break;
                case "sap2":
                    var ventana5 = document.getElementById('VentanaModalSAP2');
                    ventana5.style.display = 'none';
                    document.getElementById("BuscarFoliosap2").style.display = "none";
                    document.getElementById("ConsultaTablaFolioSAP2").style.display = "block";
                    document.getElementById("sap2").focus();
                    borramsg();
                    break;
               case "solicitante":
                    var ventana6 = document.getElementById('VentanaModalSolicitante');
                    ventana6.style.display = 'none';
                    document.getElementById("BuscarSolicitante").style.display = "none";
                    document.getElementById("ConsultaTablaSolicitante").style.display = "block";
                    document.getElementById("solicitante").focus();
                    borramsg();
                    break;
               case "almacen":
                    var ventana7 = document.getElementById('VentanaModalAlmacen');
                    ventana7.style.display = 'none';
                    document.getElementById("BuscarAlmacen").style.display = "none";
                    document.getElementById("ConsultaTablaAlmacen").style.display = "block";
                    document.getElementById("almacen").focus();
                    borramsg();
                    break;
                      case "material":
                    var ventana8 = document.getElementById('VentanaModalMaterial');
                    ventana8.style.display = 'none';
                    document.getElementById("BuscarMaterial").style.display = "none";
                    document.getElementById("ConsultaTablaMaterial").style.display = "block";
                    document.getElementById("material").focus();
                    borramsg();
                    break;
              
              case "posicion":
                    var ventana9 = document.getElementById('VentanaModalPosicion');
                    ventana9.style.display = 'none';
                    document.getElementById("BuscarPosicion").style.display = "none";
                    document.getElementById("ConsultaTablaPosicion").style.display = "block";
                    document.getElementById("posicion").focus();
                    borramsg();
                    break;
                case "imputacion":
                    var ventana10 = document.getElementById('VentanaModalImputacion');
                    ventana10.style.display = 'none';
                    document.getElementById("BuscarImputacion").style.display = "none";
                    document.getElementById("ConsultaTablaImputacion").style.display = "block";
                    document.getElementById("imputacion").focus();
                    borramsg();
                    break;
               case "coste":
                    var ventana11 = document.getElementById('VentanaModalCoste');
                    ventana11.style.display = 'none';
                    document.getElementById("BuscarCoste").style.display = "none";
                    document.getElementById("ConsultaTablaCoste").style.display = "block";
                    document.getElementById("coste").focus();
                    borramsg();
                    break;
                    
                 case "orden":
                    var ventana12 = document.getElementById('VentanaModalOrden');
                    ventana12.style.display = 'none';
                    document.getElementById("BuscarOrden").style.display = "none";
                    document.getElementById("ConsultaTablaOrden").style.display = "block";
                    document.getElementById("orden").focus();
                    borramsg();
                    break;
              case "servicio":
                    var ventana13 = document.getElementById('VentanaModalServicio');
                    ventana13.style.display = 'none';
                    document.getElementById("BuscarServicio").style.display = "none";
                    document.getElementById("ConsultaTablaServicio").style.display = "block";
                    document.getElementById("servicio").focus();
                    borramsg();
                    break;
              }       
        }
        function ConsultaCentro() {
            var url = "PeticionVisualizarReportesReservas";
            var acc = "CentroReserva";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaOCompras").style.display = "block";
                        document.getElementById("cargarDatosOCompras").innerHTML = rs;
                        fnc();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc, true);
            xmlhttp.send();
        }
        function ConsultaFolioSAM1() {
            var url = "PeticionVisualizarReportesReservas";
            var acc = "SAMsolped";
            var tipo = "sam1";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaFolioSAM1").style.display = "block";
                        document.getElementById("cargarDatosFolioSAM1").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaFolioSAM2() {
            var url = "PeticionVisualizarReportesReservas";
            var acc = "SAMsolped";
            var tipo = "sam2";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaFolioSAM2").style.display = "block";
                        document.getElementById("cargarDatosFolioSAM2").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaFolioSAP1() {
            var url = "SolpedMatchs";
            var acc = "SAPsolped";
            var tipo = "sap1";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarParamOCompras_SP").style.display = "none";
                        document.getElementById("ConsultaTablaFolioSAP1").style.display = "block";
                        document.getElementById("cargarDatosFolioSAP1").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaFolioSAP2() {
            var url = "SolpedMatchs";
            var acc = "SAPsolped";
            var tipo = "sap2";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarFoliosap2").style.display = "none";
                        document.getElementById("ConsultaTablaFolioSAP2").style.display = "block";
                        document.getElementById("cargarDatosFolioSAP2").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        //Consultas MATCHS****************
        function ConsultaSolicitante() {
            var url = "SolpedMatchs";
            var acc = "solicitante";
            var tipo = "solicitante";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarSolicitante").style.display = "none";
                        document.getElementById("ConsultaTablaSolicitante").style.display = "block";
                        document.getElementById("cargarDatosSolicitante").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaAlmacen() {
            var url = "SolpedMatchs";
            var acc = "almacen";
            var tipo = "almacen";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarAlmacen").style.display = "none";
                        document.getElementById("ConsultaTablaAlmacen").style.display = "block";
                        document.getElementById("cargarDatosAlmacen").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaMaterial() {
            var url = "SolpedMatchs";
            var acc = "material";
            var tipo = "material";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarMaterial").style.display = "none";
                        document.getElementById("ConsultaTablaMaterial").style.display = "block";
                        document.getElementById("cargarDatosMaterial").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
         function ConsultaPosicion() {
            var url = "SolpedMatchs";
            var acc = "posicion";
            var tipo = "posicion";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarPosicion").style.display = "none";
                        document.getElementById("ConsultaTablaPosicion").style.display = "block";
                        document.getElementById("cargarDatosPosicion").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
         function ConsultaImputacion() {
            var url = "SolpedMatchs";
            var acc = "imputacion";
            var tipo = "imputacion";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarImputacion").style.display = "none";
                        document.getElementById("ConsultaTablaImputacion").style.display = "block";
                        document.getElementById("cargarDatosImputacion").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
         function ConsultaCoste() {
            var url = "SolpedMatchs";
            var acc = "coste";
            var tipo = "coste";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarCoste").style.display = "none";
                        document.getElementById("ConsultaTablaCoste").style.display = "block";
                        document.getElementById("cargarDatosCoste").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        function ConsultaOrden() {
            var url = "SolpedMatchs";
            var acc = "orden";
            var tipo = "orden";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        ErrorBusquedaMatch();
                    } else {
                        document.getElementById("BuscarOrden").style.display = "none";
                        document.getElementById("ConsultaTablaOrden").style.display = "block";
                        document.getElementById("cargarDatosOrden").innerHTML = rs;
                        fnc1();
                        borramsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?Action=" + acc + "&tipo=" + tipo, true);
            xmlhttp.send();
        }
        //***************************
        
        
        function borramsg() {
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "hidden";
            var men = document.getElementById("msg");
            men.innerHTML = "";
        }
        function fnc() {
            document.getElementById('table-scrollOCompras').onscroll = function () {
                document.getElementById('fixedYOCompras').style.top = document.getElementById('table-scrollOCompras').scrollTop + 'px';
            };
        }
        function fnc1() {
            document.getElementById('table-scroll1').onscroll = function () {
                document.getElementById('fixedY1').style.top = document.getElementById('table-scroll1').scrollTop + 'px';
            };
        }
        function Select(dato, tipo) {
            switch (tipo) {
                case "centro":
                    document.getElementById("centro").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "sam1":
                    document.getElementById("sami").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "sam2":
                    document.getElementById("samf").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "sap1":
                    document.getElementById("sapi").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "sap2":
                    document.getElementById("sapf").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "solicitante":
                    document.getElementById("solicitante").value = dato;
                    ocultarVentana(tipo);
                    break;
                 case "almacen":
                    document.getElementById("almacen").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "material":
                    document.getElementById("material").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "posicion":
                    document.getElementById("posicion").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "imputacion":
                    document.getElementById("imputacion").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "coste":
                    document.getElementById("coste").value = dato;
                    ocultarVentana(tipo);
                    break;
                case "orden":
                    document.getElementById("orden").value = dato;
                    ocultarVentana(tipo);
                    break;
            }
        }

        function validarCentro() {

            var url = "PeticionVisualizarReportesSP";
            var acc = "ValidarCentro";
            var centro = document.getElementById("centro");
            var c = centro.value;

            if (c.length > 0) {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {

                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var okcon = "No se encuentra en el Sistema el centro : " + c.toUpperCase();
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            centro.value = '';
                            centro.focus();
                        } else {
                            borrarmsg();
                        }
                    }
                };

                xmlhttp.open("GET", url + "?Action=" + acc + "&centro=" + c, true);
                xmlhttp.send();
            }
        }

        function validarsam() {

            var url = "PeticionVisualizarReportesSP";
            var acc = "ValidarSAM";
            var sam = document.getElementById("sami");
            var c = sam.value;

            if (c.length > 0) {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {

                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var okcon = "No se encuentra en el Sistema el folio sam : " + c.toUpperCase();
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            sam.value = '';
                            sam.focus();
                        } else {
                            borrarmsg();
                        }
                    }
                };

                xmlhttp.open("GET", url + "?Action=" + acc + "&sam=" + c, true);
                xmlhttp.send();
            }
        }

        function validarsam2() {

            var url = "PeticionVisualizarReportesSP";
            var acc = "ValidarSAM";
            var sam = document.getElementById("samf");
            var c = sam.value;

            if (c.length > 0) {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {

                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var okcon = "No se encuentra en el Sistema el folio sam : " + c.toUpperCase();
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            sam.value = '';
                            sam.focus();
                        } else {
                            borrarmsg();
                        }
                    }
                };

                xmlhttp.open("GET", url + "?Action=" + acc + "&sam=" + c, true);
                xmlhttp.send();
            }
        }

        function validarsap() {
           
            var url = "PeticionVisualizarReportesSP2";
            var acc = "ValidarSAP";
            var sap = document.getElementById("sapi");
            var c = sap.value;

            if (c.length > 0) {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {

                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var okcon = "No se encuentra en el Sistema el folio sap : " + c.toUpperCase();
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            sap.value = '';
                            sap.focus();
                        } else {
                            borrarmsg();
                        }
                    }
                };

                xmlhttp.open("GET", url + "?Action=" + acc + "&sap=" + c, true);
                xmlhttp.send();
            }
        }

        function validarsap2() {
            
            var url = "PeticionVisualizarReportesSP2";
            var acc = "ValidarSAP";
            var sap = document.getElementById("sapf");
            var c = sap.value;
             
            if (c.length > 0) {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {

                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var okcon = "No se encuentra en el Sistema el folio sap : " + c.toUpperCase();
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            sap.value = '';
                            sap.focus();
                        } else {
                            borrarmsg();
                        }
                    }
                };

                xmlhttp.open("GET", url + "?Action=" + acc + "&sap=" + c, true);
                xmlhttp.send();
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