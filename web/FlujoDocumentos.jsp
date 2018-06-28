<%-- 
    Document   : ReporteMovNotificaciones
    Created on : Apr 25, 2018, 7:54:36 PM
    Author     : Jhonatan
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
        po.load(in);
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
        String Noexistval = po.getProperty("etiqueta.NoExisteValores_SAM");
        String ErroCent = po.getProperty("etiqueta.ReporteErrorCentro");
        String ErroSAM = po.getProperty("etiqueta.ReporteErrorFolioSAM");
        String ErroSAP = po.getProperty("etiqueta.ReporteErrorFolioSAP");
        String ErroNop = po.getProperty("etiqueta.ReporteErrorNumeroOperacion");
        String ErroOrn = po.getProperty("etiqueta.ReporteErrorNumeroorden");
        String Ordob = po.getProperty("etiqueta.ReporteOrdenob");
        String Datosnot = po.getProperty("etiqueta.ReporteNoExusDatis");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
    %>
    <head>
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
                var pag = p.charAt(129);
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <!--<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/FlujoDocumentos.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script  src="js/dom-drag.js"></script>        
        <script src="js/FlujoDocumentos.js" type="text/javascript"></script>        
        <title>Flujo de Documentos SD</title>  
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
            <input style="margin-bottom: 0.266em;" id="ejecutar" type="image" src="images/ejecuta.png" onclick="ValidarFD();"/>
            <div class="titulo"><h1>Flujo de Documentos SD</h1></div>  
        </div>            
        <div class="contenido">
            <div class="ContentReportes">                
                <section class="DivBusqueda">
                    <section class='DivLeft'>
                        <label id="lblFolioSAM">Solicitante</label><input id="solicitante" type="text" style='width: 35%; text-transform: uppercase;' maxlength="15"><button id="match_A1" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAM">Pedido de Venta</label><input id="pedVenta" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A2" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFolioSAP">Material</label><input id="material" type="text" style='width: 38%; text-transform: uppercase;' maxlength="25"><button id="match_A3" class='BtnMatchIcon'></button>
                        <hr>
                        <label id="lblFecha">Fecha de Pedido</label><input value="" maxlength="10" type="text" value="" id="fecha_inicio" style="width:30%;"/><button id="match_F1" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class='DivRight'>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="solicitante2" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A6" class='BtnMatchIcon'></button>
                        <hr>
                        
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="pedVenta2" type="text" style='width: 35%; text-transform: uppercase;' maxlength="10"><button id="match_A4" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input id="material2" type="text" style='width: 38%; text-transform: uppercase;' maxlength="25"><button id="match_A5" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Rango_a"));%></label><input value="" maxlength="10" type="text" value="" id="fecha_fin" style="width:30%;"/><button id="match_F2" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                </section>
                <section class="DivRadio" hidden>
                    <section class='DivLeft'>
                        <input type="radio" id="rb1" name="rb" value="0" checked><label for="rb1"><%out.println(po.getProperty("etiqueta.Reporte_ConError"));%></label><br>
                        <input type="radio" id="rb2" name="rb"value="1" ><label for="rb2"><%out.println(po.getProperty("etiqueta.Reporte_TodosDa"));%></label>
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
            
        <!-- Cliente -->
        <div id="VentanaModalCliente" class="VentanaModal">
            <div id="handle"><label id="TituloMatch">Cliente</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Cliente')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="retornPCliente();"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarPCliente" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Cliente</label><input type="text" id="BusCliente" style="width:35%; text-transform: uppercase;" maxlength="20"/>
                        <hr>
                        <label>Nombre</label><input type="text" id="BusDesCliente" style="width:35%;" maxlength="40"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax" maxlength="3" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCliente"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Cliente');"/>
                </div>
            </div>
            <div id="ConsultaTablaCliente">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCliente">
                        <div class="fixedY" id="fixedYCliente">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width:20%;">Cliente</th>
                                        <th style="width:80%;">Nombre</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClientes">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cliente 2 -->
        <div id="VentanaModalCliente2" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch">Cliente</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Cliente2')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="retornPCliente2();"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarPCliente2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Cliente</label><input type="text" id="BusCliente2" style="width:35%; text-transform: uppercase;" maxlength="20"/>
                        <hr>
                        <label>Nombre</label><input type="text" id="BusDesCliente2" style="width:35%;" maxlength="40"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax2" maxlength="3" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okCliente2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Cliente2');"/>
                </div>
            </div>
            <div id="ConsultaTablaCliente2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCliente2">
                        <div class="fixedY" id="fixedYCliente2">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width:20%;">Cliente</th>
                                        <th style="width:80%;">Nombre</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosClientes2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!--Pedidos Venta-->
        <div id="VentanaModalPedidos" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Pedido Vta.</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Pedido')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaPedidos">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPedido">
                        <div class="fixedY" id="fixedYPedido">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAM</th>
                                        <th>Pedido Vta</th>
                                        <th>Solicitante</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosPedido">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Pedidos Venta-->
        <div id="VentanaModalPedidos2" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch">Pedido Vta.</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Pedido2')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaPedidos2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPedido2">
                        <div class="fixedY" id="fixedYPedido2">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Folio SAM</th>
                                        <th>Pedido Vta</th>
                                        <th>Solicitante</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosPedido2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--- Materiales -->
        <div id="VentanaModalMateriales" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch">Material</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Materiales')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="retornPMateriales();"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarPMateriales" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Material</label><input type="text" id="BusMaterial" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label>Descripción</label><input type="text" id="BusDMaterial" style="width:35%;" maxlength="40"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax3" maxlength="3" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMateriales"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Materiales');"/>
                </div>
            </div>
            <div id="ConsultaTablaMateriales">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMateriales">
                        <div class="fixedY" id="fixedYMateriales">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width:20%;">Material</th>
                                        <th style="width:80%;">Descipción</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMateriales">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--- Materiales 2 -->
        <div id="VentanaModalMateriales2" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch">Material</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Materiales2')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="retornPMateriales2();"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarPMateriales2" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Material</label><input type="text" id="BusMaterial2" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label>Descripción</label><input type="text" id="BusDMaterial2" style="width:35%;" maxlength="40"/>
                        <hr>                           
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax4" maxlength="3" style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMateriales2"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Materiales2');"/>
                </div>
            </div>
            <div id="ConsultaTablaMateriales2">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMateriales2">
                        <div class="fixedY" id="fixedYMateriales2">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width:20%;">Material</th>
                                        <th style="width:80%;">Descipción</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosMateriales2">
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
                        $('#iconmsg').hide();
                    };
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