<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="Clases.ClassModuloCreaOrdenPP" %>
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
        String ClasO = request.getParameter("ClasO");
        String CenPl = request.getParameter("CenPl");
        String PueTr = request.getParameter("PueTr");
        String equipe = request.getParameter("equipe");
        String ubicate = request.getParameter("ubicate");
        String folSA = request.getParameter("folSA");
        String foltip = request.getParameter("Tipo");
        String html;
        ClassModuloCreaOrdenPP classO = new ClassModuloCreaOrdenPP();

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleCreaOrdenPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/CreaOrdenPP.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <title><%out.println(po.getProperty("etiqueta.CreaOrdenOR_PP"));%></title>   
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
                var pag = p.charAt(122);
                if (pag == 1) {

                } else if (pag == 0) {
                    session.invalidate();
                    window.location.href = "index.jsp";
                }
            }
            checkPermisoPag();
            var usuario = '<%=Nombre%>';
        </script>
    </head>
    <body>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input type="text" hidden id="IDFecha"/>
            </div>
        </div>

        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>
                        </li>
                    </ul>
                </div>
                <script>
                </script>
                <input id="aceptar" type="image" src="images/aceptaOFF.png"/>     
                <input id="guardar" type="image" src="images/guarda.PNG" onclick="datosObligatorios();" />  
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="back();" />
                <!--<input  id="cancelar" type="image" src="images/cancela.PNG" onclick="checkOpeServ();" />-->


            </div>            
            <div class="contenido">
                <div class="titulo" style="width: 98.7%"><h1><%out.println(po.getProperty("etiqueta.ModOrdTitulo_PP"));%></h1></div>      
                <div class="ContenidoScrollbar">
                    <div id="cargarMate" hidden></div>
                    <div id="cargarEqui" hidden></div>
                    <div class="ContentOrden">        
                        <section id="cebeceraOrd">
                            <div class="wallWhite">
                                <label class="subTitle">&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.CreaOrdenCabOrd"));%></label>
                                <hr id="lineaAzul" >
                            </div>
                            <div class="DivDatosCrearOrden" id="DatosCabecera">

                                <div class="DivDatosBasicos" id="divDatBasicos">
                                    <label class="subTitle"><%out.println(po.getProperty("etiqueta.Reporte_DatosBas"));%></label>
                                    <hr id="lineaAzulSub" >
                                    <label><%out.println(po.getProperty("etiqueta.ClOrdenOR"));%>  </label>
                                    <select id="ClOrden" onblur="">
                                    </select>    
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CreOrDesrip"));%></label>
                                    <input type="text" id="Descri" onblur="" style="width: 220px" maxlength="40"/>
                                    <hr>
                                    <label><%out.println(po.getProperty("etiqueta.CreOrMat_PP"));%></label>
                                    <input type="text" id="Equipo" onKeyUp="this.value = this.value.toUpperCase();cargarMat();" style="width: 135px"  maxlength="18"/><button id="matchEqui" class='BtnMatchIcon'></button>
                                    <hr>
                                    <section style="display: none"><label><%out.println(po.getProperty("etiqueta.CreOrUbTen"));%></label>
                                    <input type="text"id="UbiTec" onKeyUp="this.value = this.value.toUpperCase();" maxlength="30" style="width: 200px"/><button id="matchUbiT" class='BtnMatchIcon'></button>
                                    <hr></section>
                                    <div class="halfHoriz1">
                                        <label><%out.println(po.getProperty("etiqueta.CreOrCntPla"));%></label>
                                        <select id="CentPl">
                                        </select>    
                                        <hr>
                                    </div>
                                    <div class="halfHoriz2">
                                        <label><%out.println(po.getProperty("etiqueta.CreOrPtoTraRes"));%></label>
                                        <input type="text"id="PtoTjo" onKeyUp="this.value = this.value.toUpperCase();" maxlength="8"/><button id="matchPtoT" class='BtnMatchIcon'></button>
                                        <hr>
                                    </div>
                                    <div class="DivFecha">
                                        <label class="subTitle"><%out.println(po.getProperty("etiqueta.CreOrFea"));%></label>
                                        <hr id="lineaAzulSub2" style="width: 102%"> 
                                        <label><%out.println(po.getProperty("etiqueta.CreOrIniExtr"));%></label>
                                        <input  maxlength="10" type="text" value="" id="fechIni" readonly style="width:25%; background-repeat: no-repeat;" onpaste="return false;"/><button id="matchF1" class="BtnMatchIcon"></button>

                                        <!--<input type="date" id="fechIni">-->
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CreOrDFimExtr"));%></label>
                                        <input  maxlength="10" type="text" value="" id="fechFin" readonly style="width:25%; background-repeat: no-repeat;" onpaste="return false;"/><button id="matchF2" class="BtnMatchIcon"></button>
                                        <!--<input type="date"id="fechFin"/>-->
                                        <hr>
                                    </div>
                                </div>
                                <div class="DivDatosBasicos2" id="divDatBasicos2">  
                                    <div class="DivHRM">
                                        <label class="subTitle"><%out.println(po.getProperty("etiqueta.CreOrHojadeRuMod"));%></label>
                                        <hr id="lineaAzulSub">
                                        <label><%out.println(po.getProperty("etiqueta.CreOrNumHojdeRut"));%>&nbsp;</label>
                                        <input type="text"id="NumHR" style="width: 30%;" />
                                        <hr>
                                        <label><%out.println(po.getProperty("etiqueta.CreOrContHojRut"));%> &nbsp;&nbsp;</label>
                                        <input type="text"id="ContHR" style="width: 13%"/>
                                        <button id="matchContHR" class='BtnMatchIcon2'></button>
                                        <hr>
                                        <input type="button" value="" id="btnTomOpe" class="btnTomar"/>
                                    </div>  
                                    <div class="DivLstM">
                                        <label class="subTitle"><%out.println(po.getProperty("etiqueta.CreOrLstMat"));%></label>
                                        <hr id="lineaAzulSub">
                                        <input type="button" value="" id="btnTomComp" class="btnTomar"/>
                                    </div>
                                </div>
                                <div id="DivDatosBasicos3" class="DivDatosBasicos3" style="visibility: hidden;" >
                                    <label style="color: red;">Errores</label>
                                    <br>
                                    <label id="errorTxt"></label>
                                </div>
                            </div>   
                        </section>
                        <div class="tabsorden" >
                            <button id="tabOpe" onclick="tabOpe();" disabled="true"><%out.println(po.getProperty("etiqueta.CreOrOperaciones"));%></button>
                            <button id="tabComp" onclick="tabComp();" disabled="true"s><%out.println(po.getProperty("etiqueta.CreOrComponentes"));%></button>
                        </div>
                        <hr id="lineatabs">
                        <div class="ContenidoTabsOrden2">
                            <div id="capaTabs" class="ContenidoTabsOrden">
                                <section class="TabSecOpe" id="seccionOpe">
                                    <section id="TablaStatusOpe" class="TablaStatusC">
                                        <%
                                            html = classO.imprimirTablaOperacionesPP();
                                            out.println(html);
                                        %>
                                    </section>
                                    <button id="btnAddTO" class="btnAdd"  onclick="addOpe();"></button>
                                    <button id="btnDeleteTO" class="btnDelete"></button>
                                    <button id="btnservicios" style="background-image: url(images/servicios.PNG); background-repeat: no-repeat; padding-right: 1%; padding-left: 8%; float: right;" disabled="true" onClick="popUpSta();" >Servicio</button>    
                                </section>
                                <section class="TabSecComp" id="seccionComp" >                                
                                    <section id="TablaStatusComp" class="TablaStatusC">
                                        <%
                                            html = classO.imprimirTablaComponentesPP();
                                            out.println(html);
                                        %>
                                    </section>
                                    <button id="btnAddTC" class="btnAdd" onclick=""></button>
                                    <button id="btnDeleteTC" class="btnDelete" onclick="deleteRowComp('TablaComponentes');"></button>
                                    <span id="cargarOneMat" style="display: none;"></span>
                                </section>
                            </div>
                        </div>
                        <%
                            html = classO.imprimirTablaServiciosPP();
                            out.println(html);
                        %>
                        <hr>
                        <%
                            html = classO.imprimirTablaMaterialesPP();
                            out.println(html);
                        %>
                        <hr>
                        <section id="TablaStDescri">
                            <%
                                html = classO.imprimirTablaTextosDescriPP();
                                out.println(html);
                            %>
                        </section>
                    </div> 
                </div>       
            </div>
                        
            
            <!--//////////Ventana Modal Materiales/////////////-->
            <div id="VentanaModalEquipo" class="VentanaModal">
                <div id="handle1"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumdeMatMatch_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Material');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamEquipo', 'ConsultaTablaEquipo', 'denEqui');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="BuscarParamEquipo" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.DenMat_Ordenes_PP"));%></label>
                            <input type="text" id="denEqui" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.NumMate_Ordenes_PP"));%></label>
                            <input type="text" id="numEqui" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes_PP"));%></label>
                            <input type="number" min="1"  id="numAcMaxEqui"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxEqui', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Material');"/>
                    </div>
                </div>
                <div id="ConsultaTablaEquipo" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollEquipo">
                            <div class="fixedY" id="fixedYEquipo">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.DenMat_Ordenes_PP"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.NumMate_Ordenes_PP"));%></th>
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
            <!-- /////////////Ventana Modal Equipo ////////////////--> 
<!--            <div id="VentanaModalEquipo" class="VentanaModal">
                <div id="handle1"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumdeEqMatch_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Equipo');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamEquipo', 'ConsultaTablaEquipo', 'denEqui');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamEquipo" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.DenEq_Ordenes"));%></label>
                            <input type="text" id="denEqui" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Num_Ordenes"));%></label>
                            <input type="text" id="numEqui" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxEqui"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxEqui', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Equipo');"/>
                    </div>
                </div>
                <div id="ConsultaTablaEquipo" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollEquipo">
                            <div class="fixedY" id="fixedYEquipo">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.DenEq_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Num_Ordenes"));%></th>
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
            </div>-->

            <!--///////////Ventana Modal Ubication Tecnica//////////////////////////////////////////////--> 
            <div id="VentanaModalUbiT" class="VentanaModal">
                <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.UbTecnica_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('UbiT');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamUbiT', 'ConsultaTablaUbiT   ', 'denUbiT');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.UbTecnica_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('UbiT');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamUbiT', 'ConsultaTablaUbiT   ', 'denUbiT');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamUbiT" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.Denominacion_Ordenes"));%></label>
                            <input type="text" id="denUbiT" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.UbTecnica_Ordenes"));%></label>
                            <input type="text" id="ubiTecM" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxUbiT" value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxUbiT', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbiT"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('UbiT');"/>
                    </div>
                </div>
                <div id="ConsultaTablaUbiT" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollUbiT"> 
                            <div class="fixedY" id="fixedYUbiT">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.UbTecnica_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DenUbTec_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosUbiT">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--///////////Ventana Modal Centro Planificacion//////////////////////////////////////////////--> 

            <div id="VentanaModalCentroP" class="VentanaModal">
                <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CntPlanMante_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('CentroP');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaCentP">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollCentroP"> 
                            <div class="fixedY" id="fixedYCentroP">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Nombre_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosCentroP">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Clase Orden//////////////////////////////////////////////--> 

            <div id="VentanaModalClaseOr" class="VentanaModal">
                <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ClasOrd_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ClaseOr');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="ConsultaTablaClaseOr">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollClaseOr">
                            <div class="fixedY" id="fixedYClaseOr">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Cl_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Denominacion_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosClaseOr">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Contador Hoja de Ruta//////////////////////////////////////////////--> 

            <div id="VentanaModalContaHR" class="VentanaModal">
                <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CntGrpHR_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ContaHR');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaContaHR">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollContaHR"> 
                            <div class="fixedY" id="fixedYContaHR">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.GrpHRuta_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.CGH_Ordenes"));%></th>
                                            <!--<th><% //out.println(po.getProperty("etiqueta.TxtBHR_Ordenes"));%></th>-->
                                            <th><%out.println(po.getProperty("etiqueta.TxtBHR_OrdenesCab"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosContaHR">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--///////////Ventana Modal Puesto Trabajo Resp//////////////////////////////////////////////--> 
            <div id="VentanaModalPtoTr" class="VentanaModal">
                <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PstTbRsMM_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('PtoTr');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamPtoTr', 'ConsultaTablaPtoTr', 'clasePto');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.PstTbRsMM_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('PtoTr');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamPtoTr', 'ConsultaTablaPtoTr', 'clasePto');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamPtoTr" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.ClPsTra_Ordenes"));%></label>
                            <input type="text" id="clasePto" style="width:15%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Cnt_Ordenes"));%></label>
                            <input type="text" id="centroPto" style="width:15%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PstTra_Ordenes"));%></label>
                            <input type="text" id="ptoTrM" style="width:25%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Desc_Ordenes"));%></label>
                            <input type="text" id="descriPto" style="width:45%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxPto"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxPto', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPtoTr"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('PtoTr');"/>
                    </div>
                </div>
                <div id="ConsultaTablaPtoTr" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollPtoTr"> 
                            <div class="fixedY" id="fixedYPtoTr">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Ce_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.PstoTbjo_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DenomBreve_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosPtoTr">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--///////////Ventana Modal Lista de Materiales//////////////////////////////////////////////--> 

            <div id="VentanaModalLstMat" class="VentanaModal">
                <div id="handle7"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LstDeMat_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('LstMat');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.SelNumLstMat_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaLstMat">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollLstMat">
                            <div class="fixedY" id="fixedYLstMat">
                                <table>
                                    <thead>
                                        <tr>
                                            <th style="width: 150px"><input type="checkbox" style="size: 100%;visibility: hidden" ></th>
                                            <th><%out.println(po.getProperty("etiqueta.OnumMat"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.OnumPz"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.CreOrDesrip"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosLstMat">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="Botones_MatchLst">
                        <input type="button" value="Agregar" onclick="checkMatLstM()"/>
                        <input type="button" value="Cancelar" onclick="ocultarVentana('LstMat')"/>
                    </div>
                </div>

            </div>
            <!--///////////Ventana Modal Unidad de Medida//////////////////////////////////////////////--> 

            <div id="VentanaModalUMD" class="VentanaModal">
                <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.UniDurNormal_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('UMD');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaUMD">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollUMD">
                            <div class="fixedY" id="fixedYUMD">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.UM_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.TxtUnMed_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosUMD">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>       
            <!--///////////Ventana Modal Clave Moneda//////////////////////////////////////////////--> 

            <div id="VentanaModalClvM" class="VentanaModal">
                <div id="handle19"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ClvMoneda_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sClvM');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaClvM">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollClvM">
                            <div class="fixedY" id="fixedYClvM">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Mon_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.TxtExplic_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosClvM">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Clave Lote//////////////////////////////////////////////--> 

            <div id="VentanaModalLote" class="VentanaModal">
                <div id="handle20"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumdeLote_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('lote');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaLote">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollLote">
                            <div class="fixedY" id="fixedYLote"> 
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Lote_Ordenes"));%></th>

                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosLote"> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Material//////////////////////////////////////////////--> 
            <div id="VentanaModalMat" class="VentanaModal">
                <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumMate_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Mat');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamMat', 'ConsultaTablaMat', 'txtMatMatch');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle9"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumMate_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Mat');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamMat', 'ConsultaTablaMat', 'txtMatMatch');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamMat" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.TxrBreMat_Ordenes"));%></label>
                            <input type="text" id="txtMatMatch" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Material_Ordenes"));%></label>
                            <input type="text" id="matMatch" style="width:15%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Cnt_Ordenes"));%></label>
                            <input type="text" id="centroMatch" style="width:25%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.OnumPz"));%></label>
                            <input type="text" id="numPzFabMatch" style="width:25%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxMat"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxMat', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" onclick="matchTCMatOk();"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Mat');"/>
                    </div>
                </div>
                <div id="ConsultaTablaMat" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollMat"> 
                            <div class="fixedY" id="fixedYMat">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.TxrBreMat_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Material_Ordenes"));%></th>
                                            <!--<th><%out.println(po.getProperty("etiqueta.Ce_Ordenes"));%></th>-->
                                            <th>Numero de Pza. de Fabricante</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosMat">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Num Cuenta Mayor//////////////////////////////////////////////--> 
            <div id="VentanaModalNumCM" class="VentanaModal">
                <div id="handle16"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumCuenMay_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumCM');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamNumCM', 'ConsultaTablaNumCM', 'matchClCoste');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle16"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumCuenMay_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumCM');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamNumCM', 'ConsultaTablaNumCM', 'matchClCoste');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamNumCM" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.ClssCoste_Ordenes"));%></label>
                            <input type="text" id="matchClCoste" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.ClssCosteTxtBre_Ordenes"));%></label>
                            <input type="text" id="matchTxtCl" style="width:45%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxNumCM"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxMat', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okNumCM"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('NumCM');"/>
                    </div>
                </div>
                <div id="ConsultaTablaNumCM" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollNumCM"> 
                            <div class="fixedY" id="fixedYNumCM">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.ClCoste_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.TxtBree_Ordene"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosNumCM">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Num Cuenta Mayor 2//////////////////////////////////////////////--> 
            <div id="VentanaModalNumCM2" class="VentanaModal">
                <div id="handle18"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumCuenMay_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumCM2');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamNumCM2', 'ConsultaTablaNumCM2', 'matchClCoste2');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle18"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumCuenMay_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumCM2');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamNumCM2', 'ConsultaTablaNumCM2', 'matchClCoste2');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamNumCM2" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.ClssCoste_Ordenes"));%></label>
                            <input type="text" id="matchClCoste2" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PlandeCuentas_Ordenes"));%></label>
                            <input type="text" id="matchPlanC2" style="width:15%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.ClssCosteTxtBre_Ordenes"));%></label>
                            <input type="text" id="matchTxtCl2" style="width:45%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxNumCM2"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxMat', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okNumCM2"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('NumCM2');"/>
                    </div>
                </div>
                <div id="ConsultaTablaNumCM2" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollNumCM2"> 
                            <div class="fixedY" id="fixedYNumCM2">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.ClCoste_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.TxtBree_Ordene"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosNumCM2">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Num Servicio//////////////////////////////////////////////--> 
            <div id="VentanaModalNumS" class="VentanaModal">
                <div id="handle17"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumServ_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumS');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamNumS', 'ConsultaTablaNumS', 'numStxtB');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle17"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NumServ_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('NumS');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamNumS', 'ConsultaTablaNumS', 'numStxtB');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamNumS" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.TxtBreeServ_Ordenes"));%></label>
                            <input type="text" id="numStxtB" style="width:35%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.NumServ_Ordenes"));%></label>
                            <input type="text" id="numSnum" style="width:15%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxNumServicio"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxMat', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okNumS"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('NumS');"/>
                    </div>
                </div>
                <div id="ConsultaTablaNumS" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollNumS"> 
                            <div class="fixedY" id="fixedYNumS">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.TxtBreeServ_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Servicio_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosNumS">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/////////////////////////////Ventana Modal Centro--> 
            <div id="VentanaModalCentro" class="VentanaModal">
                <div id="handle10"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Centros_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Centro');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaCentro">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollCentro">
                            <div class="fixedY" id="fixedYCentro">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Centro_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DescCentro_Ordenes"));%></th>
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
            <!--/////////////////////////////Ventana Modal Almacen--> 
            <div id="VentanaModalAlmacen" class="VentanaModal">
                <div id="handle11"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Almacenes_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Almacen');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>

                <div id="ConsultaTablaAlmacen">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollAlmacen">
                            <div class="fixedY" id="fixedYAlmacen">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Ce_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Alm_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DenomAlmacn"));%>   </th>
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

            <!--/////////////////////////////Ventana Modal Grupo Articulos--> 
            <div id="VentanaModalGpoA" class="VentanaModal">
                <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OgpoAr_Ordenes_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GpoA');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestriPP('BuscarParamGpoArt', 'ConsultaTablaGpoA', 'gpoAtxt');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes_PP"));%></button><hr></div>
                <div id="handle13"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OgpoAr"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GpoA');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button onclick="returnRestri('BuscarParamGpoArt', 'ConsultaTablaGpoA', 'gpoAtxt');"><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="BuscarParamGpoArt" class="BuscarParam_u">  
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.OgpoAr"));%></label>
                            <input type="text" id="gpoAtxt" style="width:20%;" focus/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.OdenGr"));%></label>
                            <input type="text" id="gpoAden" style="width:25%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.OdesGr"));%></label>
                            <input type="text" id="gpoAdes" style="width:25%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CtdMaxAc_Ordenes"));%></label>
                            <input type="number" min="1"  id="numAcMaxGpoA"  value="100" style="width:10%;" onblur="ValidarMaximo('numAcMaxPto', this.value);"/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okGpoArt"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('GpoArt');"/>
                    </div>
                </div>

                <div id="ConsultaTablaGpoA">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollGpoA">
                            <div class="fixedY" id="fixedYGpoA">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.GpAr_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DenomGrArtic_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DescDosGpoArt_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosGpoA"> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/////////////////////////////Ventana Modal Grupo Compras--> 
            <div id="VentanaModalGpoC" class="VentanaModal">
                <div id="handle14"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GrupoDeComp_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GpoC');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="ConsultaTablaGpoC">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollGpoC">
                            <div class="fixedY" id="fixedYGpoC">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.GCp_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Denominacion_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosGpoC">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/////////////////////////////Ventana Modal Organización Compras--> 
            <div id="VentanaModalGpoC2" class="VentanaModal">
                <div id="handle15"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OrgComp_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('GpoC2');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
                <div id="ConsultaTablaGpoC2">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollGpoC2">
                            <div class="fixedY" id="fixedYGpoC2">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.OrgC_Ordenes"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.DenominacionOrgComp_Ordenes"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosGpoC2">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--///////////Ventana Modal Gestion de Servicios//////////--> 
            <div id="VentanaModalServicios" class="VentanaModal">
                <div id="handle12"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.GestionSerExt_Ordenes"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Servi');"><label >X</label></div></div>
                <div id="ParamServi1" class="BuscarParam_u">
                    <div class="fondo_Match" style="margin-top: 9%;">
                        <div class="busquedaMatch" style="margin-top: -8%;">
                            <div id="datS1">
                                <label><%out.println(po.getProperty("etiqueta.CtdOperacion_Ordenes"));%></label>
                                <input type="text" id="serCtdOp1" style="width:35%;" onKeyUp="this.value = check99(this.value, '9999999', 7)" maxlength="11"/>
                                <input type="text" id="serCtdOp2" style="width:9%;"  onKeyUp="this.value = this.value.toUpperCase();" maxlength="3"/>
                                <button id="matchSctd" class='BtnMatchIcon' onclick="consultaSctd();"></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.Precio_Ordenes"));%></label>
                                <input type="text" id="serPrec1" style="width:30%;" maxlength="11" onblur="this.value = checkDec(this.value, 2)"   onKeyUp="this.value = check99(this.value, '99999999', 8)"  />
                                <input type="text" id="serPrec2" style="width:10%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="5"/>
                                <button id="matchSpre" class='BtnMatchIcon2' onclick="consultaSclvM();"></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.GpoArts_Ordenes"));%></label>
                                <input type="text" id="serGrArt" style="width:25%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="9"/>
                                <button id="matchSgpoA" class='BtnMatchIcon2' onKeyUp="this.value = this.value.toUpperCase();"></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.GpoCom_Ordenes"));%></label>
                                <input type="text" id="serGrCom1" style="width:10%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="3"/> /
                                <button id="matchSgpoC1" class='BtnMatchIcon' onclick="consultaSgpoC1();" ></button>
                                <input type="text" id="serGrCom2" style="width:13%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="4"/>
                                <button id="matchSgpoC2" class='BtnMatchIcon' onclick="consultaSgpoC2();" ></button>
                                <hr>
                                <!--                                <label>Contrato</label>
                                                                <input type="text" id="serContr1" style="width:20%;"/> /
                                                                <input type="text" id="serContr2" style="width:13%;"/>
                                                                <hr>-->
                                <!--                                <label>Destinatario</label>
                                                                <input type="text" id="serDest" style="width:33%;"/>
                                                                <hr>-->
                                <label><%out.println(po.getProperty("etiqueta.Solicitante_Ordenes"));%></label>
                                <input type="text" id="serSoli" style="width:33%;"value="<%=Nombre%>" readonly="true"/>
                                <hr>
                                <!--                                <label>Plaz.entr.prev.</label>
                                                                <input type="text" id="serPlzEnt" style="width:10%;"/>
                                                                <input type="checkbox" id="serSubCont"/>
                                                                <label style="float: right;">Subcontr.</label>
                                                                <hr>-->
                            </div>
                            <div id="datS2">
                                <!--                                <label>Clv.clasific.</label>
                                                                <input type="text" id="serClvCl" style="width:30%;" />
                                                                <hr>-->
                                <!--                                <label>por</label>
                                                                <input type="text" id="serPor" style="width:15%;"/>
                                                                <hr style="visibility: hidden;">-->
                                <label><%out.println(po.getProperty("etiqueta.ClasedeCostee_Ordenes"));%></label>
                                <input type="text" id="serClCos" style="width:30%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="10"/>
                                <button id="matchSclC" class='BtnMatchIcon2'></button>
                                <hr>
                                <label><%out.println(po.getProperty("etiqueta.Acreedor_Ordenes"));%></label>
                                <input type="text" id="serAcre" style="width:30%;"/>
                                <button id="matchSacre" class='BtnMatchIcon2' onclick="consultaSacre();"></button>
                                <hr>
                                <!--                                <label>Registro info</label>
                                                                <input type="text" id="serRegInf" style="width:30%;"/>
                                                                <hr>-->
                                <!--                                <label>Puesto descarga</label>
                                                                <input type="text" id="serPtoDes" style="width:50%;"/>
                                                                <hr>-->
                                <!--                                <label>N° necesidad</label>
                                                                <input type="text" id="serNoNes" style="width:30%;"/>
                                                                <hr>-->
                                <!--                                <label>Ped.marco</label>
                                                                <input type="text" id="serPedMar1" style="width:30%;"/> / 
                                                                <input type="text" id="serPedMar2" style="width:10%;"/>
                                                                <hr>-->
                            </div>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <input type="button" value="Ok" onclick="validarSer1();"/>
                        <input type="button" value="Cancelar proceso" onclick="ocultarVentana('Servi')"/>
                    </div>
                </div>
                <div id="ParamServi2" style="display: none;" class="BuscarParam_us">
                    <br>
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <div class="PanelBntMatch" style="margin-top: -3%;"><label><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></label><hr style="width: 100%;margin-left: -3%;"></div>
                            <label><%out.println(po.getProperty("etiqueta.NoServicioo_Ordenes"));%></label>
                            <input type="text" id="serNoSer" style="width:17%;" onKeyUp="this.value = this.value.toUpperCase();" maxlength="18"/> 
                            <button id="matchSnoS" class='BtnMatchIcon2'></button>
                            <input type="text" id="txtServi" hidden>
                            <input type="text" id="umdServi" hidden>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.Cantidad_Ordenes"));%></label>
                            <input type="text" id="serCant" style="width:17%;" maxlength="11" onblur="this.value = checkDec(this.value, 3)"   onKeyUp="this.value = check99(this.value, '999999', 7)"/> 
                            <label id="serCant2"></label>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.PrecioEstimado_Ordenes"));%></label>
                            <input type="text" id="serPrecEst1" style="width:14%;" maxlength="11" onblur="this.value = checkDec(this.value, 2)"   onKeyUp="this.value = check99(this.value, '99999999', 8)" />     
                            <input type="text" id="serPrecEst2" style="width:6%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.GrupodeArtículoss_Ordenes"));%></label>
                            <input type="text" id="serGrpArt2" style="width:10%;" onKeyUp="this.value = this.value.toUpperCase();"/>  
                            <button id="matchSgrAr2" class='BtnMatchIcon2' onclick="consultaSgpoA2();"></button>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.ClasedeCostee_Ordenes"));%></label>
                            <input type="text" id="serClCost" style="width:11%;" onKeyUp="this.value = this.value.toUpperCase();"/>  
                            <button id="matchSclCs" class='BtnMatchIcon2'></button>
                            <hr>
                        </div>
                    </div>
                    <div class="Botones_Match">
                        <input type="button" value="Ok" onclick="validarSer2();"/>
                        <input type="button" value="Cancelar proceso" onclick="ocultarVentana('Servi');"/>
                    </div>

                </div>
            </div>

            <!--///////////Ventana Modal Clave Control//////////////////////////////////////////////--> 
            <div id="VentanaModalClaveCtrl" class="VentanaModal">
                <div id="handle21"><label id="TituloMatch">Clave orden</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ClaveCtrl');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>

                <div id="ConsultaTablaClaveCtrl">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollClaveCtrl">
                            <div class="fixedY" id="fixedYClaveCtrl">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Cl.</th>
                                            <th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosClaveCtrl">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>                     

            <!--///////////Ventana Modal Proveedor//////////////////////////////////////////////--> 
            <div id="VentanaModalAcreedor" class="VentanaModal">
                <div id="handle22"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.Oacr"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Acreedor');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>

                <div id="ConsultaTablaClaveCtrl">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollClaveCtrl">
                            <div class="fixedY" id="fixedYClaveCtrl">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.Oprov"));%></th>
                                            <th><%out.println(po.getProperty("etiqueta.Onomp"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosAcreedor">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  

            <div id="VentanaModalTextli" class="VentanaModal">
                <div id="handle23"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OtxtL"));%></label><div class="BotonCerrar_Matc" id="cerrarmodalTL"><label >X</label></div></div>
                <div class="PanelBntMatch"><button  ><%out.println(po.getProperty("etiqueta.OtxtL"));%></button><hr></div>
                <div id="BuscarTxtD" class="BuscarParam_uD">
                    <div class="fonhandle3do_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.OtxtLo"));%></label><label id="opCurrent"></label>
                            <textarea style="resize:none;" id="Textlib"></textarea>
                        </div>
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okDescri" />
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;margin-right:-4%;" onclick="ocultartexa();" id="xDescri"/>
                    </div>
                </div>
            </div>



            <input type="text" id="mjIdioma" value="<%=Idioma%>" hidden/>
            <input type="text" id="mjDatosIncorrectos" value="<%=menValores%>" hidden/>
            <input type="text" id="mjClasO" value="<%=ClasO%>" hidden/>
            <input type="text" id="mjCenPl" value="<%=CenPl%>" hidden/>
            <input type="text" id="mjPueTr" value="<%=PueTr%>" hidden/>
            <input type="text" id="mjequipe" value="<%=equipe%>" hidden/>
            <input type="text" id="mjubicate" value="<%=ubicate%>" hidden/>
            <input type="text" id="mjfolSA" value="<%=folSA%>" hidden/>
            <input type="text" id="mjfuncInv" value="<%=funcioninv%>" hidden/>
            <input type="text" id="mjUmdInv" value="Unidad de medida no valida" hidden/>



            <div id="MensajeSalirModulo" class="VenfinalizarDocumentos">
                <div id="handleDocMod"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.OdelO"));%></label><div class="BotonCerrar_Matc" onclick="CerrarMensajeEliminarOperacion();"><label >X</label></div></div>
                <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
                <div class="ContenidoFinalizarDoc">
                    <label><%out.println(po.getProperty("etiqueta.Odelp1"));%></label>
                    <br>
                    <label id="lbl2finDoc"><%out.println(po.getProperty("etiqueta.Odelp2"));%></label>
                </div>
                <div class="BotenesFinalizarDocumento">
                    <button id="EliminarOpeY" style="cursor:pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndYesSession"));%></button>
                    <button id="EliminarOpeN" style="cursor: pointer;" ><%out.println(po.getProperty("etiqueta.ContenidoEndNoSession"));%></button>
                </div>
            </div>
            <div id="VentanaModalTextoDescripcion" class="VenfinalizarDocumentos">
                <div id="handleDoc"><label id="TituloMatch">Texto Descripcion</label><div class="BotonCerrar_Matc" onclick="CerrarMensajeEliminarOperacion();"><label >X</label></div></div>
                <div class="imgeninfo"><IMG SRC="images/S_M_QUES.png"  ALT="Info"></div>
                <label>Ingresar Texto</label>
                <textarea id="txtAreaDes"></textarea>
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
                    function fechaIni() {
                        var hoy = new Date();
                        var dd = hoy.getDate();
                        var mm = hoy.getMonth() + 1;
                        var yyyy = hoy.getFullYear();
                        if (dd < 10) {
                            dd = '0' + dd;
                        }
                        if (mm < 10) {
                            mm = '0' + mm;
                        }
                        hoy = dd + '.' + mm + '.' + yyyy;
                        document.getElementById("fechIni").value = hoy;
                        document.getElementById("fechFin").value = hoy;
                    }
                    function startTime() {
                        today = new Date();
                        h = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
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
                        tabOpe();
                        fechaIni();
                        CargarCentroP();
                        CargarClaseOr();
                        getCentroActual();
                        CArgarDATavi();

                    };


                    function CArgarDATavi() {
                        var claseor = $('#mjClasO').val();
                        var centrplan = $('#mjCenPl').val();
                        var putra = $('#mjPueTr').val();
                        var equipe = $('#mjequipe').val();
                        var utecn = $('#mjubicate').val();
                        var folS = $('#mjfolSA').val();
                        var ClOrd = $('#ClOrden');
                        var Descr = $('#Descri');
                        var Equip = $('#Equipo');
                        var UbiTe = $('#UbiTec');
                        var CentP = $('#CentPl');
                        var PtoTj = $('#PtoTjo');
                        var DatObli = [ClOrd, Descr, Equip, CentP, PtoTj];
                        if (claseor != 'null' || centrplan != 'null' || putra != 'null' || equipe != 'null' || utecn != 'null' || folS != 'null') {
                            $("#ClOrden").val(claseor);
                            $("#Equipo").val(equipe);
                            $("#UbiTec").val(utecn);
                            $("#PtoTjo").val(putra);
                            $("#CentPl").val(centrplan);

                        } else {
//                            borramsg();
                        }
                        setTimeout(function () {
                            $.each(DatObli, function (i, v) {
                                if (v.val().length > 0) {
                                    v.css('background-image', 'none');
                                    v.css("background-color", "#ffffff");
                                } else {
                                    v.css({background: 'url(images/necesario.PNG) no-repeat'});
                                    v.css("background-color", "#ffffff");
                                }
                            });
                        }, 800);
                    }
                    function GuardaFOLAvi(fol) {
                        var folS = '<%=folSA%>';
                        var folt = '<%=foltip%>';
                        var acc = "";
                        var enviar = "&folAV=" + folS + "&folORD=" + fol;
                        if (folS == 'null') {
                        } else {
                            if (folS.length == 8) {
                                acc = "ACTaviORDSAP";
                            } else {
                                acc = "ACTaviORD";
                            }
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: 'PeticionModuloAvisos',
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: "Action=" + acc + enviar,
                                success: function (data) {
                                    if (data == 0) {
                                        $(location).attr('href', 'ModificarAviso.jsp?Aviso=' + folS + "&Tipo=" + folt);
//                                        if (folS.length == 8) {
//                                            window.location.href = "ModificarAviso.jsp?P=" + folS + "&FolOR=" + fol + "&M=";
//                                        } else {
//                                            window.location.href = "ModificarAviso.jsp?M=" + folS + "&FolOR=" + fol + "&P=";
//                                        }
                                    }
                                }
                            });
                        }
                    }
                </script>
            </div>
        </footer>
    </body>
    <script>
        function CerrarCalendario() {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#Calenndar').css('display', 'none');
            $('#datapicker').datepicker().hide();
        }
        function OpenCalendario(id) {
            $("#" + id).focus();
            $("#IDFecha").val(id);
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            var ancho = 500;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            var ventana = $('#Calenndar');
            ventana.css({top: y + "px", left: x + "px"});
            ventana.css('display', 'block');
            var theHandle = document.getElementById("handlecalendar");
            var theRoot = document.getElementById("Calenndar");
            Drag.init(theHandle, theRoot);
            $('#datapicker').datepicker().show();
        }
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
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>