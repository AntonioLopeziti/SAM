<%-- 
 Document   : AvisosCalidad
--%>


<%@page import="Clases.ClassModuloCrearOrden"%>
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

        String Folio = request.getParameter("FolioMO");
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String CampoOb = po.getProperty("etiqueta.CompObligatorios");
        String movim = po.getProperty("etiqueta.TituMovv_Mov");
        String movim101 = po.getProperty("etiqueta.TituMovv101_Mov");
        String movim102 = po.getProperty("etiqueta.TituMovv102_Mov");
        String E1 = po.getProperty("etiqueta.ErroSonMov_Mov");
        String E2 = po.getProperty("etiqueta.NumPedObl_Mov");
        String E3 = po.getProperty("etiqueta.ErroN3_Mov");
        String E4 = po.getProperty("etiqueta.ErroN4_Mov");
        String E5 = po.getProperty("etiqueta.ErroN5_Mov");
        String E6 = po.getProperty("etiqueta.ErroN6_Mov");
        String E7 = po.getProperty("etiqueta.ErroN7_Mov");
        String E8 = po.getProperty("etiqueta.ErroN8_Mov");
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
        ClassModuloCrearOrden html = new ClassModuloCrearOrden();
        String htmlResponse;
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
                var pag = p.charAt(38);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            var usuario = '<%=Nombre%>';
            var idioma = '<%=Idioma%>';
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/styleAvisosCalidad.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/AvisosCalidad.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title>Medidas para avisos</title>
    </head>
    <body>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inv();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>
            <input id="guardar" type="image" src="images/guarda.PNG" />
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back()"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/canceOFF.png" disabled/>
            <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="window.location.href = 'AvisosCalidad.jsp'"/>
            <div class="titulo"><h1>Medidas para avisos (<%=Nombre%>)</h1></div>
        </div>
        <div class="contenido">                      
            <section class="bkcontainer">
                <div class="CldMov">
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
                    <section class="TableContainer">
                        <section class="SecHead">
                            <table id="TabHead">
                                <thead>
                                    <tr>
                                        <td>Estatus</td>
                                        <td>Aviso</td>
                                        <td>Nro. Correlativo</td>
                                        <td>Nro. Clasificación</td>
                                        <td>Texto Breve</td>
                                        <td>Grupo Códigos</td>
                                        <td>Código Medidas</td>
                                        <td>Rol Med.Resp.</td>
                                        <td>Responsable Medida</td>
                                        <td>Fecha Inicio</td>
                                        <td>Hora Inicio</td>
                                        <td>Fecha Fin</td>
                                        <td>Hora Fin</td>
                                        <td hidden>Fecha Mod</td>
                                        <td hidden>Hora Mod</td>
                                        <td>Clasificación Pos.</td>
                                    </tr>
                                </thead>
                            </table>
                        </section>
                        <section class="SecBody" id="SecCuerpoCld">

                        </section>
                    </section>
                </div>
                <div id="VentanaModalTexto" class="VentanaModalTextCalidad">
                    <div id="handleCali"><label id="TituloMatch">Tratar medida</label><div class="BotonCerrar_Matcali" onclick="ocultarVentana('VentanaModalTexto');"><label >X</label></div></div>
                    <div class="DivFuncionIcon"><input  id="cietec"  type="image" src="images/cierretecnico.png" /></div>
                    <div class="DivAcica"><label>Aviso</label><input type="text" id="avisoid" style="width: 20%;" readonly/></div>
                    <div class="DivMeidpara"><label>Medida para: </label></div>
                    <div class="divdatmedida">
                        <label>Código medidas</label><input type="text" id="codMedId" readonly/>
                        <label style="margin-left: 2%;">Inicio previsto</label><input type="text" id="inPrev" class="bxMed" disabled/><input style="margin-left: 2%;" type="text" id="hrPrev" class="bxMed" disabled/>
                        <hr>
                        <label>Texto medidas</label><input type="text" id="txtMedId" readonly/>
                        <label style="margin-left: 2%;">Usuario</label><input type="text" id="usrAv" class="bxMed"/><button id="btnmatch"  class="BtnMatchIcon"></button>
                        <hr>
                        <label>Status global</label><input type="text" id="statusid" readonly/>
                        <hr>
                    </div>
                    <div class="divtextare"><textarea style="resize:none;" id="Textlib" class="txtArL" readonly></textarea><textarea style="resize:none;" id="TextlibMod" class="txtArL"></textarea></div>
                    <div style="margin-right: 2%; margin-top: 1%;" ><button class="btnCalidad" id="btnGuardar">Guardar</button></div>
                </div>
                <br><br>                
            </section>
        </div>
    <seccion>
    </seccion>
    <div id="VentanaModal" class="VentanaModal">
        <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMCUser"><label >X</label></div></div>
        <div class="PanelBntMatch"><button id="btnbuuser"><%out.println(po.getProperty("etiqueta.BuscarPUsuario_USr"));%></button><hr></div>
        <div id="BuscarParam_u" class="BuscarParam_u">
            <div class="fondo_Match">
                <div class="busquedaMatch"><label><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>
                    </label><input type="text" maxlength="10" id="usuariio_bus" style="width:35%; text-transform: uppercase;"/>
                    <hr>
                    <label>Nombre</label><input type="text" maxlength="20" id="nombre_bus" style="width:35%; text-transform: uppercase;"/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  maxlength="3"  id="numAcMax"   style="width:10%;" />
                    <hr>
                </div>        
            </div> 
            <div class="Botones_Match">
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okUs"/>
                <img class="BtnMatchIcon" src="images/HR_not.png" id="CerrarMCUser2" style="cursor: pointer"/>
            </div>
        </div>
        <div id="ConsultaTabla" style="display: none;">
            <div class="tablaCab">
                <div class="table-scroll" id="table-scroll">
                    <div class="fixedY" id="fixedY">
                        <table>
                            <thead>
                                <tr>
                                    <th><%out.println(po.getProperty("etiqueta.Usuario_USCR"));%></th><th><%out.println(po.getProperty("etiqueta.Nombre_USCR"));%></th><th>Apellido</th>
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
            <script type="text/javascript">
                var usuario = "<%=Nombre%>";

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
                    CargarTablaUsr();
                    bloq();

                };
                function CargarTablaUsr() {
                    var acc = "AvisosUsuario";
                    var usr = "<%=Nombre%>";
                    var datosSend = "&v1=" + usr;
                    $.ajax({
                        async: false,
                        type: 'GET',
                        url: 'PeticionAvisosCalidad',
                        contentType: "application/x-www-form-urlencoded",
                        processData: true,
                        data: "Action=" + acc + datosSend,
                        success: function (rs) {
                            $('#SecCuerpoCld').html(rs);
                            AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpoCld');
                            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
                        }
                    });
                }

                function bloq() {
                    document.getElementById('iconmsg').style.visibility = "hidden";
                }
                function msgWindo123(ven, num) {
                    msg = "";
                    switch (num) {
                        case 1:
                            msg = '<%=E1%>';
                            break;
                        case 2:
                            msg = '<%=E2%>';
                            break;
                        case 3:
                            msg = '<%=E3%>';
                            break;
                        case 4:
                            msg = '<%=E4%>';
                            break;
                        case 5:
                            msg = '<%=E5%>';
                            break;
                        case 6:
                            msg = '<%=E6%>';
                            break;
                        case 7:
                            msg = '<%=E7%>';
                            break;
                        case 8:
                            msg = '<%=E8%>';
                            break;
                    }
                    abrirVentanaAv(ven, msg);
                }
                function CantidadPositiva(id)
                {
                    var cnt = document.getElementById(id);
                    if (cnt.value < 1) {
                        cnt.value = 1;
                    }
                }

            </script>
        </div>
    </footer>
</body>
<script language="javascript">
    function back() {
        window.location.href = "Bienvenido.jsp";
    }

</script>
<%}
    } catch (Exception e) {
        System.err.println("Errr:" + e);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }%>
</html>