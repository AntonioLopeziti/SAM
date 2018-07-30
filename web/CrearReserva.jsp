
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
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
        String Centro = (String) session.getAttribute("CentroUsuario");
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String noexisteval = po.getProperty("etiqueta.NoExisteValores_SAM");
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
                var pag = p.charAt(48);
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
                        msg = '<%=noexisteval%>';
                        break;
                    case 2:
                        msg = 'Material no existe o no ha sido creado';
                        break;
                    case 3:
                        msg = 'Campo Centro obligatorio';
                        break;
                    case 4:
                        msg = 'Campo Almacén obligatorio';
                        break;
                    case 5:
                        msg = 'Material no existe o no ha sido creado en Centro - Almacén';
                        break;
                    case 7:
                        msg = 'Seleccione un tipo de movimiento';
                        break;
                    case 8:
                        msg = 'Campo Centro de Costo obligatorio';
                        break;
                    case 9:
                        msg = 'Campo Orden obligatorio';
                        break;
                    case 10:
                        msg = 'Centro no encontrado en el sistema';
                        break;
                    case 11:
                        msg = 'Almacén no encontrado en el sistema';
                        break;
                    case 12:
                        msg = 'Centro Coste no encontrado o no ha sido creado';
                        break;
                    case 13:
                        msg = 'Orden no encontrada o no ha sido  creada';
                        break;
                    case 14:
                        msg = 'Introduce al menos una posición en la tabla';
                        break;
                    case 15:
                        msg = 'Campo Cantidad necesaria obligatorio';
                        break;
                    case 16:
                        msg = 'Campo Cantidad necesaria no acepta un valor 0.000';
                        break;
                    case 17:
                        msg = 'Campo Unidad Medida debe ser completado registrando un material valido';
                        break;
                    case 18:
                        msg = 'Guardardo datos, espere un momento...';
                        break;
                    case 19:
                        msg = 'Ocurrio un error inesperado al guardar, Consulte a su administrador';
                        break;
                    case 20:
                        msg = 'Documento Creado: ' + va;
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
        <link rel="stylesheet" href="css/CrearReserva.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>     
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/CrearReserva.js" type="text/javascript"></script>
        <title>Crear Reserva</title>       
    <body>   
        <div id="main-header">    
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>                
            <input id="guardar" type="image" src="images/guarda.PNG"/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled />
            <div class="titulo"><h1>Crear reservas</h1></div> 
        </div>            
        <div class="contenido">  
            <div class="ContentReserva">
                <div class="ContentCabecera">
                    <label style="padding-left: 2%;">Reserva de materiales para consumo</label>
                    <hr class="lines">
                    <div class="div1R">
                        <input type="text" hidden id="NombreUser" value="<%=Nombre%>"/>
                        <input type="text" hidden id="IpData" />
                        <label>Centro</label><input type="text" id="Centro" maxlength="4" style="width: 22%; text-transform: uppercase; background-repeat: no-repeat"><button id="matchCentro" class='BtnMatchIcon2'></button>
                        <hr>
                        <label>Almacén</label><input type="text" id="Almacen" maxlength="4" style="width: 22%; text-transform: uppercase; background-repeat: no-repeat"><button id="MatchAlmacen" class='BtnMatchIcon2'></button>
                        <hr>
                        <label>Clase mov.</label><select id="ListTipMov" style="width: 52%;"><option></option></select> 
                        <hr>
                    </div>
                    <div class="div2R">
                        <div class="ResInp">
                            <label style="margin-left: 2%;">Consumo con imputación (201 ó 261)</label>
                            <hr class="lines">
                            <div class="imp1">
                                <label>Centro Coste</label><input type="text" maxlength="10" style="width: 45%; background-repeat: no-repeat; text-transform: uppercase;" id="CentroCoste"/><button id="MatchCenCosto" class='BtnMatchIcon2'></button>
                                <hr>
                            </div>
                            <div class="imp2">
                                <label>ú Orden interna CO</label><input type="text" maxlength="15" style="width: 45%; background-repeat: no-repeat; text-transform: uppercase;" id="Orden"/><button id="MatchOrden" class='BtnMatchIcon2'></button>
                                <hr>
                            </div>
                        </div>
                        <!--                        <div class="ResTras">
                                                    <label style="margin-left: 2%;">Traslado 311</label>
                                                    <hr class="lines">
                                                    <div class="tras">
                                                        <label>Almacén destino</label><input type="text" style="width: 15%;" id="AlmacenDes"/><button id="MatchAlmDes"  class='BtnMatchIcon2'></button><button class="BtnLisMat"> Lista Materiales</button>
                                                        <hr>
                                                    </div>
                                                </div>-->
                    </div>
                </div>
                <div class='DivPosiciones'>
                    <div class="DivResumenPos">
                        <div id="tabscrll2">
                            <section id="TableNotfi2">
                                <section class="TableContainer2">
                                    <section class="SecHead2">
                                        <table id="TabHead2">
                                            <thead>
                                                <tr>
                                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                                    <td>Material</td>
                                                    <td>Cantidad necesaria</td>
                                                    <td>Unidad Medida</td>
                                                    <td>Descripción</td>
                                            </thead>
                                        </table>
                                    </section>
                                    <section class="SecBody2" id="SecCuerpo2">
                                    </section>
                                </section>
                            </section>
                        </div>
                        <section class="DobleScroll2" id="DobleSection2">
                            <section id="DobleContainer2"></section>
                        </section>
                    </div>
                    <input hidden type="text" id="postextpos">
                    <section id="botonesadddel">
                        <input id="AgregarFilas" type="image" src="images/ADD.PNG" style="vertical-align: middle"/>
                        <input id="BorrarFilas" type="image" src="images/DELETEADD.PNG" style="padding-top: 1px; vertical-align: middle; margin-left: -1%;"/>
                    </section>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch">Centro</label><div class="BotonCerrar_Matc" id="CerrarMCCentro"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaCentro">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCentro">
                        <div class="fixedY" id="fixedYCentro">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Centro</th>
                                        <th>Denominación</th>
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
            <div id="handle2"><label id="TituloMatch">Almacén</label><div class="BotonCerrar_Matc" id="CerrarMCAlmacen"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmacen">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmacen">
                        <div class="fixedY" id="fixedYAlmacen">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Almacén</th>
                                        <th>Denominación</th>
                                        <th>Centro</th>
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
        <div id="VentanaModalAlmDes" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Almacén destino</label><div class="BotonCerrar_Matc" id="CerrarMCAlmDes"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaAlmDes">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollAlmDes">
                        <div class="fixedY" id="fixedYCAlmDes">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Almacén Dest.</th>
                                        <th>Denominación</th>
                                        <th>Centro</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosAlmDes">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCCosto" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch">Centro Costo</label><div class="BotonCerrar_Matc" id="CerraMCCCosto"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retCCosto"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParCCosto" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Centro Costo</label><input type="text" id="BusCcosto" maxlength="10" style="width:25%; text-transform: uppercase;"/>
                        <hr>
                        <label>Denominación</label><input type="text" id="BusdenCCosto" maxlength="20" style="width:40%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkCosto"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCCCosto2"/>
                </div>
            </div>            
            <div id="ConsultaTablaCCosto" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollCCosto">
                        <div class="fixedY" id="fixedYCCosto">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width:40%;">Centro Costo</th>
                                        <th style="width:60%; text-align: left;">Denominación</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosCCosto">
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <div id="VentanaModalOrden" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch">Orden</label><div class="BotonCerrar_Matc" id="CerraMCOrden"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retOrden"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParOrden" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Orden</label><input type="text" id="BusOrden" maxlength="10" style="width:25%; text-transform: uppercase;"/>
                        <hr>
                        <label>Texto breve</label><input type="text" id="BusdenOrden" maxlength="20" style="width:40%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax2"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkOrden"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCOrden2"/>
                </div>
            </div>            
            <div id="ConsultaTablaOrden" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollOrden">
                        <div class="fixedY" id="fixedYOrden">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width: 35%;">Orden</th>
                                        <th style="width: 65%; text-align: left;">Texto Breve</th>
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
        <div id="VentanaModalMateriales" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch">Material / Texto breve</label><div class="BotonCerrar_Matc" id="CerraMCMaterial"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retMaterial"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="BuscarParMaterial" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label>Material</label><input type="text" id="BusMaterial" maxlength="40" style="width:25%; text-transform: uppercase;"/>
                        <hr>
                        <label>Texto breve</label><input type="text" id="BusdenMaterial" maxlength="40" style="width:40%; text-transform: uppercase;"/>
                        <hr>  
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax3"   style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkMaterial"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="CerraMCMaterial2"/>
                </div>
            </div>            
            <div id="ConsultaTablaMaterial" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial">
                        <div class="fixedY" id="fixedYMaterial">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width: 30%;">Material</th>
                                        <th style="width: 70%; text-align: left;">Texto Breve</th>
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
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
                    var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                    var meses2 = new Array('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12');
                    var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                    var f = new Date();
                    var idioma = "<%=Idioma%>";
                    var writefecha = $('#fecha');
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        var fre = f.getFullYear() + "-" + meses2[f.getMonth()] + "-" + f.getDate();
                        writefecha.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else {
                        writefecha.html(fechaActual);
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
