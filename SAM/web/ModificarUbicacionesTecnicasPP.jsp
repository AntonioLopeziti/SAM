<%-- 
    Document   : VisualizarUbicacionesTecnicas
    Created on : 19-ago-2016, 19:50:16
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String existFol = po.getProperty("etiqueta.VUNoexisteUbicU");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
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
        String NoArchMos = po.getProperty("etiqueta.VisEq_NoArchMos");
        String CamUbTeVacci = po.getProperty("etiqueta.VisEq_CamUbTeVacci");
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
                var pag = p.charAt(89);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=CamUbTeVacci%>';
                        break;
                    case 1:
                        msg = "<%=NoArchMos%>";
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

            function ConsIdioma() {
                var idi = '<%= Idioma%>';
                ConsultaUbicacionTec(idi);
            }
            function msgMatch(val) {
                switch (val) {
                    case "funinva":
                        var funinva = '<%=funcioninv%>';
                        $('#msg').html(funinva);
                        break;
                    case "menValores":
                        var okcon = "<%=menValores%>";
                        $('#msg').html(okcon);
                        break;
                    case "CampoOb":
                        var menCam = "<%=CampoOb%>";
                        $('#msg').html(menCam);
                        break;
                    case "existeFol":
                        var menCam = "<%=existFol%>";
                        $('#msg').html(menCam);
                        break;
                    case "OkConsult":
                        var okcon = "<%=OKconsul%>";
                        $('#msg').html(okcon);
                        break;
                }
            }
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=CampoOb%>';
                        break;
                    case 2:
                        msg = 'Ubicación técnica modificada'
                        break;
                    case 3:
                        msg = 'Ubicación técnica no modificada'
                        break;
                }
                $('#msg').html(msg);
                var icon = $('#iconmsg');
                icon.css('visibility', 'visible');
                icon.show();
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
//            window.onload = function () {
//                validaUsuarioVis();
//            };

        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleUbicacionesTecnicasPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/ModUbicacionesTecPP.js"></script>
        <title><%out.println(po.getProperty("etiqueta.VU_ModUbicacionTecnica_PP"));%></title>       
    <body>
        <div id="main-header">     
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png"/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.VU_ModUbicacionTecnica_PP"));%></h1></div>      
        </div>            
        <div class="contenido">
            <div class="ContentUbicaciones">                
                <div class="divubic">
                    <label><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="divubic1">
                        <input type="text" id="idUbiTec" maxlength="30" style="text-transform: uppercase;" /><button id="btnmatch"  class="BtnMatchIcon"></button>
                    </div>
                    <div class="divubic2">
                        <!--<input type="text" id="DesUbiTec" disabled /> <button id="VisDoo" style="width: 13.7%;margin-left: .5%;">Vis Docs</button>-->  
                    </div>
                </div>
                <div class="DatosGeneUbi">
                    <label><%out.println(po.getProperty("etiqueta.VU_DatosGenerales_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="datogen1">
                        <label><%out.println(po.getProperty("etiqueta.VU_Clase_PP"));%></label><input type="text" id="Clase"  style="width: 60%;">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_GrupoAutoriz_PP"));%></label><input type="text" id="GrupoAutoriz"  style="width: 35%;">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_Peso_PP"));%></label><input type="text" id="Peso"  style="width: 45%;" value="0,000">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_NInventario_PP"));%></label><input type="text" id="NInventario"  style="width: 45%;">
                        <hr>                                    
                    </div>
                    <div class="datogen2">
                        <label><%out.println(po.getProperty("etiqueta.VU_TamanoDimens_PP"));%></label><input type="text" id="TamanoDimens"  style="width: 30%;">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_PstaEnServDesde_PP"));%></label><input type="text" id="PstaenServ"  style="width: 20%;">
                        <hr>                                                                      
                    </div>
                </div>
                <div class="datoEmplaz">
                    <label><%out.println(po.getProperty("etiqueta.VU_DatosEmplazamiento_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="subdatoemp">
                        <label><%out.println(po.getProperty("etiqueta.VU_CeEmplazam_PP"));%></label><input type="text" style="width: 10%;" id="CeEmplazam" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_Emplazamiento_PP"));%></label><input type="text" style="width: 18%;" id="Emplazamiento" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_AreaEmpresa_PP"));%></label><input type="text" style="width: 10%;" id="AreaEmpresa" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_PuestoTrabajo_PP"));%></label><input type="text" style="width: 15%;" id="PuestoTrabajo" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_IndicadorABC_PP"));%></label><input type="text" style="width: 8%;" id="IndicadorABC" />
                        <hr>
                    </div>
                </div>
                <div class="divinputacio">
                    <label><%out.println(po.getProperty("etiqueta.VU_Imputacion_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="subdatoemp">
                        <label><%out.println(po.getProperty("etiqueta.VU_Sociedad_PP"));%></label><input type="text" style="width: 10%;" id="Sociedad" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_ActivoFijo_PP"));%></label><input type="text" style="width: 20%;" id="ActivoFijo" /> / <input  style="width: 10%;" id="ActivoFijoDos"  type="text"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_CentroCoste_PP"));%></label><input type="text" style="width: 18%;" id="Centro" /> / <input  style="width: 10%;" id="SociedadCC" type="text">
                        <hr>                                
                    </div>
                </div>
                <div class="divResponsa">
                    <label><%out.println(po.getProperty("etiqueta.VU_Responsabilidades_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="subdatoemp">
                        <label><%out.println(po.getProperty("etiqueta.VU_CentroPlanif_PP"));%></label><input type="text" style="width: 10%;" id="CentroPlanif" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_GrupoPlanif_PP"));%></label><input type="text" style="width: 10%;" id="GrupoPlanif" /> 
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_PtoTbjoResp_PP"));%></label><input type="text" style="width: 15%;" id="PtoTbjoResp" /> <input  style="width: 10%;" id="PtoTbjoRespDos" type="text">
                        <hr>                                
                    </div>
                </div>
                <div class="divEstuc">
                    <label><%out.println(po.getProperty("etiqueta.VU_Estructura_PP"));%></label>
                    <hr id="lineaubititu">
                    <div class="subdatoemp">
                        <label><%out.println(po.getProperty("etiqueta.VU_UbicTecn_PP"));%></label><input type="text" style="width: 35%;" id="UbicTecn" />
                        <hr>
                    </div>
                </div>
            </div>
            <input id="IdioMat" value="<%=Idioma%>" hidden>
        </div>
<!--        <div id="VentanaModalCentroP" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch">Documentos</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaa('CentroP');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Resticciones_Ordenes"));%></button><hr></div>
            <div id="ConsultaTablaCentP">
                <div id="tabscrll">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td>Apl.</td>
                                            <td>Nombre</td>
                                            <td>Aplicación</td>
                                            <td>Fichero</td>

                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo">
                            </section>
                        </section>
                    </section>
                </div>
            </div>
        </div>-->
        <div id="VentanaModal" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana();"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornafiltroubic"><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></button><hr></div>
            <div id="BuscarParamUbi" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></label><input type="text" id="ubictBus"  maxlength="30"  style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></label><input type="text" id="DesUbiBus"  maxlength="40"  style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" maxlength="3"  id="numAcMax"  style="width:10%;" />
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okUbic"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana();"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.VU_UbicacionTecnica"));%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<!--        <div id="VentUbTecAvvv" class="VentanaModalAvvv">
            <div id="handleAvvv"><label id="TituloMatch">¿Qué desea realizar?</label><div class="BotonCerrar_Matc" onclick="ocultarVenAv('VenAvv');"><label>X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <br><br>
                <div class="fondo_MatchAv">
                    <button id="VisVis" style="width: 40%;margin-left: 5%;">Visualizar</button> <button id="ViGuarAr" style="width: 40%;margin-left: 5%;">Modificar</button>
                    <input id="ubtecPosOc" hidden></input>
                </div>
                <div class="Botones_Match">
                </div>
            </div>
        </div>-->
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
                        $('#fecha').html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        $('#fecha').html(fechaActual);
                    } else {
                        $('#fecha').html("Fecha indefinida");
                    }
                </script>
            </div>
<!--            <script>
                function validaUsuarioVis() {
                    var acc = "validaUsuarioVis";
                    var usr = "<%=Nombre%>";
                    $.ajax({
                        async: false,
                        type: 'GET',
                        url: 'MovimientosCalidad',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "action=" + acc + "&v1=" + usr,
                        success: function (rs) {
                            if (rs == 0) {
                                $("#ViGuarAr").prop('disabled', true);
                            } else if (rs == 1) {
                                $("#ViGuarAr").prop('disabled', false);
                            }
                        }
                    });
                }
            </script>-->
        </footer>
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
