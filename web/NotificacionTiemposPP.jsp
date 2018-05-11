<%-- 
    Document   : NotificacionTiemposPP
    Created on : Jan 15, 2018, 4:00:38 PM
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
    <%            String propiedad = "";
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
        String Mens = po.getProperty("etiqueta.mensaje");
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
        String nomUs = (String) session.getAttribute("Usuario");

        String titulo = po.getProperty("etiqueta.CU_Titulo");
        String NPMAvisoPant = po.getProperty("etiqueta.NPMAvisoPant");
        String ubicactecnica = po.getProperty("etiqueta.CU_UbicacTecnica");
        String masccodific = po.getProperty("etiqueta.CU_MascCodific");
        String nivjerarquicos = po.getProperty("etiqueta.CU_NivJerarquicos");
        String indestructura = po.getProperty("etiqueta.CU_IndEstructura");
        String tpoubictec = po.getProperty("etiqueta.CU_TpoUbicTecn");
        String modelo = po.getProperty("etiqueta.CU_Modelo");
        String mubicactecnica = po.getProperty("etiqueta.CU_MUbicacTecnica");
        String ubicref = po.getProperty("etiqueta.CU_UbicRef");
        String prefubictecsuperior = po.getProperty("etiquera.CU_PrefUbicTecSuperior");
        String ubictecnsup = po.getProperty("etiqueta.CU_UbicTecnSup");
        String denominacion = po.getProperty("etiqueta.CU_Denominacion");

        String titulomatch = po.getProperty("etiqueta.CU_TituloMatch");
        String botonmatch = po.getProperty("etiqueta.CU_BotonMatch");
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
            var usuario = '<%=Nombre%>';

            <%
                String permiso = ACC_Usuarios.ObtenerInstancia().VerificarPermisos(Nombre);
            %>
            function checkPermisoPag() {
                var p = '<%=permiso%>';
                var pag = p.charAt(51);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function msgMatch(mn, im, au, val) {
                var m = "";
                switch (mn) {
                    case 0:
                        m = '<%=funcioninv%>';
                        break;
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#msg').attr("visibility", true);
                $('#msg').html(m);
                $('#iconmsg').show();
                $('#iconmsg').attr('src', im);
            }
        </script>
        <script>
            function ponerUsuarioDefault() {
                var us = usuario;
                document.getElementById("NoPers").value = us;
//                $('#NoPers').val(usuario);
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleNotificaTiempos.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/NotificarTiempos.js"></script>
        <title>Notificar Tiempos</title>    
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png"/> 
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png"/>
            <div class="titulo"><h1>Notificación de Tiempos PP</h1></div>      
        </div>
        <div class="contenido">
            <div class="ContentNotif">
                <label>Busqueda General</label>
                <hr id="lineaNotiTiempos">
                <div class="divNoPers1">
                    <label>No Personal</label><input type="text" id="NoPers" value="" maxlength="10" style="text-transform: uppercase; background-repeat: no-repeat;" /><button id="btnmatchUsuarios"  class="BtnMatchIcon"></button>
                    <hr>
                </div>
                <div class="divNoPerso2">
                    <button id="LimPantalla" style="margin-left: 40%;">Limpiar Pantalla</button>
                </div>
            </div>
            <div class="bkClassNoti" hidden>
                <label style="padding-left: 25px; font-size: 13px;">Clase de notificación</label>
                <!--<label style="padding-left: 10px; font-size: 13.5px;">Clase de notificación</label>-->
                <hr id="LineaTituloInfo">
                <input type="radio" value="par" name="clnoti" id="NotParcial"> Notif.pacial
                <input type="radio" value="fin" name="clnoti" class="rbcln" id="NotFinal"> Notif.final
                <input type="radio" value="aut" name="clnoti" checked class="rbcln" id="NotFinalAu"> Notif.final autom.
                <input type="checkbox" value="res" name="ckreserva" class="rbcln" id="CompRes"> Compensar reserva
            </div>
            <div class="divmatchEsp">
                <label>Especificaciones</label> 
                <hr class="lineaazul">
                <label id="lblTextoLargo"></label>
            </div><br><br>
            <div class="divmatchEsp">
                <label>Observaciones</label> 
                <hr class="lineaazul">
                <label id="lblTextoLargo2"></label>
            </div><br><br>
            <div class="DatosGeneNotiTiemp">
                <label>Datos Generales</label>
                <hr id="lineaNotiTiempos">
                <div class="divNoOrdFabri">
                    <label>Orden Fabricación</label><input type="text" id="OrdFab" maxlength="15" style="text-transform: uppercase; background-repeat: no-repeat;"/><button id="btnmatchOrdLib"  class="BtnMatchIcon"></button>
                    <section id="sectionMuestraExc" style="margin-left: 4%; width: 40%;">
                    </section>
                    <section id="sectionVisualExc" class="sctVisEx" style="margin-left: 4%; width: 40%;">
                        <input type="checkbox" value="lim" disabled> <label style=" width: 40%;">Exceso Limitado</label>
                    </section>

                    <!--<label type="text" id="DescripOrd" style="margin-left: 4%; width: 50%;"></label>-->
                    <hr>
                    <!--<label>Operación</label>-->                                                            
                    <section id="sectionMostOp" hidden>
<!--                        <select id="NoOpe">
                            <option>0010</option>               
                        </select>   -->

                    </section>
                    <section class="divmatchEsp" style="margin-left: -22%; width: 45%;">
                        <label><%out.println(po.getProperty("etiqueta.NPMStatus_PP"));%></label>
                        <label style="display: inline-block; width: 80%; margin-left: -5%;" id="notsta"></label>
                    </section>
                    <section class="divmatchEsp" style="margin-left: -5%; width: 55%;">
                        <label>Notificado:</label>
                        <label style="display: inline-block; width: 20%; margin-left: -5%;" id="cntNN"></label>
                        <label>Total:</label>
                        <label style="display: inline-block; width: 20%; margin-left: -7%;" id="cntRR"></label>
                        <input type="text" id="cntHID" hidden/>
                    </section>
                    
                    <!--<hr style="margin-top: -1%;">-->
                </div>
            </div>
            <div class="DatosReales">
                <label>Datos Reales</label>
                <hr id="lineaNotiTiempos">
                <div class="divCntBuenMal">
                    <label>Not.ctd.buena</label><input type="text" id="cntBuena" style="margin-left: 78px; text-transform: uppercase; background-repeat: no-repeat;" onblur="this.value = checkDecc(this.value, 3)"/>
                    <hr>
                    <label>Rechazo.notif</label><input type="text" id="cntMala" style="margin-left: 80px; text-transform: uppercase; background-repeat: no-repeat;" onblur="this.value = checkDecc(this.value, 3)"/>
                    <hr>
                </div>
                <div class="divBtnIniFin">
                    <button id="btnInicio" onclick="validarCantidades();"><input type="image" src="images/ejecuta.png"/></button><label>Inicio not. tiempos</label>
                    <!--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="motivoRechazo();"><input type="image" src="images/btnDescri.png"/></button><label>Motivo rechazo</label>-->
                    <br>
                    <button id="btnFin" onclick="selecoftabPP();"><input type="image" src="images/ejecuta.png"></button><label>Fin not. tiempos</label>
                </div>
            </div>
        </div>
        <div id="ventanaavis" class="VenAvisoss">
            <div id="handleAv2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMInformacion_PP"));%></label><div class="BotonCerrar_Matc" onclick="cerravisos();"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_B_HINT.gif"  ALT="Info"></div>
            <div class="ContenidoAv">
                <br>
                <label id="etav"><%out.println(po.getProperty("etiqueta.NPMAvisoPant_PP"));%></label>
            </div>
            <div class="BotenAv">
                <button id="FinalizarSIDoc" onclick="cerravisos()"><img src="images/palomal.png"/> </button>

            </div>
        </div>

        <div id="ventanaavis3" class="VenAvisoss">
            <div id="handleAv4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMInformacion_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ventanaavis3', '');"><label >X</label></div></div>
            <div class="imgeninfo"><IMG SRC="images/S_B_HINT.gif"  ALT="Info"></div>
            <div class="ContenidoAv">
                <br>
                <label id="">Esta operación no permite registros</label>
            </div>
            <div class="BotenAv">
                <button id="" onclick="ocultarVentana('ventanaavis3', '');"><img src="images/palomal.png"/> </button>

            </div>
        </div> 
        <div id="VentanaModalOrdenFab" class="VentanaModal">
            <div id="handle"><label id="TituloMatch">Orden Fabricación</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaMatch('OrdFab');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button onclick="cambiarMath();">Restricciones</button><hr></div>
            <div id="BuscarParamCentro_SP" class="BuscarParam_u">
                <div id="BuscarParamOrden" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">                            
                            <label>Orden</label>
                            <input type="text" id="txtOrd" style="width:35%; text-transform: uppercase;"/>
                            <hr>
                            <label>Texto breve</label>
                            <input type="text" id="txtBrev" style="width:55%; text-transform: uppercase;"/>
                            <hr>
                            <label>Ctd.máxima aciertos</label>
                            <input type="number" min="1"  id="numAcMaxOrd" max="100" value="100" style="width:10%;" />
                            <hr>
                        </div>
                    </div>
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okOrden"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentanaMatch('OrdFab');"/>
                    </div>
                </div>
                <div id="ConsultaTablaOrFa" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollUsuarios">
                            <div class="fixedY" id="fixedYUsuario">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Orden Fabricación</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosOrdenFab">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>         
        <div id="VentanaModalUsuarios" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch">No. Personal</label><div class="BotonCerrar_Matc" onclick="ocultarVentanaMatch('NoPer');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button>Restricciones</button><hr></div>
            <div id="BuscarParamCentro_SP" class="BuscarParam_u">
                <div id="ConsultaTablaUsu" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scrollUsuarios">
                            <div class="fixedY" id="fixedYUsuario">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Usuario</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="cargarDatosUsuarios">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="ventaPM01" class="Ventabdes" style="margin-top: 20px;">
            <div id="handlePM01"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.NPMNotificacionoperor_PP"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('ventaPM01', '');"><label >X</label></div></div>
            <div class="Contentabdes">
                <section class="DobleScroll" id="DobleSection">
                    <section id="DobleContainer"></section>
                </section>
                <section class="TableContainer">
                    <section class="SecHead">
                        <table id="TabHead">
                            <thead>
                                <tr>
                                    <td></td>
                                    <td hidden></td>
                                    <td>Operación</td>
                                    <td>Material</td>
                                    <td>Texto breve</td>
                                    <td>Cantidad</td>
                                    <td>UM</td>
                                    <td>Centro</td>
                                    <td>Almacen</td>
                                    <td>Lote</td>
                                    <td></td>
                                    <td>Ancho</td>
                                    <td>Clase Mov.</td>
                                </tr>
                            </thead>
                        </table>
                    </section>
                    <section class="SecBody" id="SecCuerpoCld">
                        <label></label>
                    </section>
                </section>
                <button id="btnCld4" class="btnCalidad4" type="submit" onclick="addPos()"></button>
                <button id="btnCld3" class="btnCalidad3" type="submit" onclick="EliminaFila()"></button>
            </div>
            <div class="Botpm">
                <button style="" onclick="ConsMaterial();" > <img style="height:15px;" src="images/cosma2.png" /> <%out.println(po.getProperty("etiqueta.NPMConsumoMate_PP"));%></button>
                <button onclick="cerraventabs('ventaPM01')" ><img  src="images/S_B_CANC.gif" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%out.println(po.getProperty("etiqueta.NPMFinaliproce_PP"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div> 
        </div>
        <div id="VentanaModalLote" class="VentanaModalLoteL">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LoteMa_Mov"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalLote', '');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
            <div id="ConsultaTablaLote">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollLote">
                        <div class="fixedYL" id="fixedYLote">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa1_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa2_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa3_Mov"));%></th><th><%out.println(po.getProperty("etiqueta.LoteMa4_Mov"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXL" id="cargarDatosLote">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <script>
                function cerravisos() {
                    $("#etav").html("<%=NPMAvisoPant%>");
                    $("#ventanaavis").css("display", "none");
                }
                function checkDec(num, tam) {
                    var limit;
                    var FINC;
                    if (tam == 3) {
                        limit = 9999999.999;
                        FINC = "Formato Incorecto para Cantidad, Solo permite 7 enteros y 3 decimales. Cantidad no mayor a 9999999.999";
                    } else {
                        limit = 99999999.99;
                        FINC = "Formato Incorecto para Precio, Solo permite 8 enteros y 2 decimales, Precio no mayor a 99999999.99";
                    }
                    if (num.length > 0) {
                        if (parseFloat(limit) >= parseFloat(num)) {
                            va = num.split(".");
                            v01 = va[0];
                            if (v01.length == 0) {
                                v01 = "0";
                            }
                            v0 = parseInt(v01);
                            v1 = va[1];
                            if (num.indexOf(".") != -1) {
                                if (v1.length > tam) {
                                    var da = v1.substr(0, tam);
                                    borrarmsg();
                                    return v0 + "." + da;
                                } else {
                                    for (i = 0; i <= tam; i++) {
                                        v1 += "0";
                                    }
                                    borrarmsg();
                                    return v0 + "." + v1.substr(0, tam);
                                }
                            } else {
                                var nn = "0";
                                for (a = 0; a < tam; a++) {
                                    nn += "0";
                                }
                                borrarmsg();
                                return v0 + "." + nn.substr(0, tam);
                            }
                        } else {
                            mensajesValidacionInco(FINC);
                            return "";
                        }
                    } else {
                        borrarmsg();
                        return "";
                    }

                }
            </script>
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
        </footer>            
    </body>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
