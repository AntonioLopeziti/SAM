<%-- 
    Document   : PlanesInspeccion
    Created on : 13/12/2016, 01:27:04 PM
--%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String MenVal = po.getProperty("etiqueta.MensajeNoExiste");
        String CampOb = po.getProperty("etiqueta.CompObligatorios");
        String okcons = po.getProperty("etiqueta.ConOk_FO");
        String errocon = po.getProperty("etiqueta.NoExisteMateril_MAT");
        String material = po.getProperty("etiqueta.materialmatch");
        String centro = po.getProperty("etiqueta.centromatch");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/menu.css" media="screen">
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
                var pag = p.charAt(97);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();

            function msgMatch(val) {
                switch (val) {
                    case "MenVal":
                        var MenVal = '<%=MenVal%>';
                        $('#msg').html(MenVal);
                        $("#iconmsg").show();
                        $("#iconmsg").attr('src', 'images/advertencia.PNG');
                        break;
                    case "CampOb":
                        var CampOb = '<%=CampOb%>';
                        $('#msg').html(CampOb);
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        break;
                    case "errocon":
                        var errocon = '<%=errocon%>';
                        $('#msg').html(errocon);
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        break;
                    case "okcons":
                        var okcons = '<%=okcons%>';
                        $('#msg').html(okcons);
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/aceptar.png');
                        break;
                    case "menValores":
                        var menValores = '<%=menValores%>';
                        $('#msg').html(menValores);
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/aceptar.png');
                        break;
                }
            }

        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/stylePlanesInspeccion.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/PlanesInspeccion.js"></script>
        <title>Plan de Inspección por Material</title>
    </head>
    <body>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inv();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png" onclick="Cargar();"/>      
            <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>   
            <div class="titulo">
                <h1><%out.println(po.getProperty("etiqueta.PlanInp_title"));%></h1>
            </div>
        </div>
        <div class="contenido">
            <div class="ContentPlanesInspeccion">
                <section class="DatosBasicPlan_info">
                    <label><%out.println(po.getProperty("etiqueta.PlanInpDatosCab"));%></label>
                    <hr id="LineaTituloInfo">
                    <section class="divdatosEmplazamientoPlan">
                        <label><%=material%></label><input type="text" id="material" maxlength="40" style="width:20%; background-repeat: no-repeat; background-position-x: -1%; text-transform: uppercase;"/><button id="match_Material" class='BtnMatchIcon'></button><input type="text" id="descripcionj" style="width: 40%;" disabled>
                        <hr>
                    </section>
                    <section class="BasicoComp11_info">
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input type="text" id="centro" maxlength="4" style="width: 6%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_Centro" class='BtnMatchIcon'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PlanInHojRut"));%></label><input type="text" id="grupohoja" style="width: 15%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;" maxlength="8"/><button id="match_Grupo" class='BtnMatchIcon'></button>
                        <hr>
                    </section>
                    <section class="BasicoComp12_info">
                        <label><%out.println(po.getProperty("etiqueta.PlanContGrHR"));%></label><input type="text" id="Contghr" style="width: 8%; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PlanContCrAdc"));%></label><input type="text" id="Contcad" style="width: 18%; text-transform: uppercase;" disabled/>
                        <hr>
                    </section>
                    <section class="BasicoComp13_info">
                        <label><%out.println(po.getProperty("etiqueta.PlanContado"));%></label><input type="text" id="contador" style="width: 25%; text-transform: uppercase;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PlanTipoHR"));%></label><input type="text" id="hojaruta" maxlength="4" style="width: 4%; text-transform:" disabled/>
                        <input id ='IdioMat' value='<%=Idioma%>' hidden></input>
                        <hr>
                    </section>
                </section>
                <div id="divtaboper">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanINodo"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIOpera"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanICoperac"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIVP"));%></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo">
                                <table id="TabBody">
                                    <tbody>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr class="ocultar">
                                            <td>0000</td>
                                            <td>00000000000</td>
                                            <td>000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                            <td>00000000000000000000000000000000000000000000000000000000000000000000000</td>
                                            <td>00000000</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </section>
                        </section>
                    </section>
                </div>
                <div id="divtabcarca">
                    <section id="TableNotfi2" >
                        <section class="TableContainer2">
                            <section class="SecHead2">
                                <table id="TabHead2">
                                    <thead>
                                        <tr>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIQ"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanICaracte"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIdioma"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIProced"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIUPM"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIFcati"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIConjun"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIICCAt"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIICGpCd"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.PlanIIIndimp"));%></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody2" id="SecCuerpo2">
                                <table id="TabBody2">
                                    <tbody>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr class="ocultar">
                                            <td>0000</td>
                                            <td>000000000000</td>
                                            <td>00000000000000000000000000000000000</td>
                                            <td>0000000000000000000000</td>
                                            <td>0000000000000000000000000000000</td>
                                            <td>0000000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                            <td>00000000000000000000000</td>
                                            <td>00000000000000000000000000</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </section>
                        </section>
                    </section>
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
                        //document.getElementById('fecha').innerHTML = fechaActual;
                        $('#fecha').html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                        //document.getElementById('fecha').innerHTML = fechaActual;
                        $('#fecha').html(fechaActual);
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
                    function cargardos() {
                        $num_op = '';
                        $("input[name=planes]").each(function () {
                            if (this.checked) {
                                $num_op = $(this).val();
                            }
                        });
                        cargartablacarac($num_op);
                    }
                </script>
            </div>
        </footer>
        <div id="VentanaModal" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('material');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltro"><%out.println(po.getProperty("etiqueta.BuscarMaterial_MAT"));%></button><hr></div>
            <div id="BuscarParam_m" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%=material%></label><input type="text" id="material_ma" style="width:35%; text-transform: uppercase;" maxlength = "40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></label><input type="text" maxlength="40" id="texto_mate" style="width:35%;"/>
                        <hr>
                        <label><%=centro%></label><input type="text" id="centrito" style="width:10%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax"   style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkMaterial"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('material');"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%=material%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th><th><%out.println(po.getProperty("etiqueta.centromatch"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></button><hr></div>
            <div id="ConsultaTablaC">
                <div class="tablaCab">
                    <div id="table-scrollC" class="table-scroll">
                        <div id="fixedYC" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Centro_CA"));%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosC">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalGrupoHoja" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('grupo');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.PlanInHojRut"));%></button><hr></div>
            <div id="ConsultaTablaG">
                <div class="tablaCab">
                    <div id="table-scrollG" class="table-scroll">
                        <div id="fixedYG" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th><th><%out.println(po.getProperty("etiqueta.PlanInHojRut"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosG">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
//        function cargartablacarac(url,op)
//        {   var mat = $('#material').val();
//            var cnt = $('#centro').val();
//            var gpHR = $('#grupohoja').val();
//            var enviar = 
//            var enviar = "&val=" + valor + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf+"&caso=dos"+"&equipo="+equipo+"&eq2="+eq2;
//                
//                            $.ajax({
//                                async: false,
//                                type: 'GET',
//                                url: url,
//                                contentType: "application/x-www-form-urlencoded",
//                                processData: true,
//                                data: enviar,
//                                success: function (data) {
//                                   $("#SecTab").html(data);
//                                }
//
//                            });
//        }
    </script>
    <script>
        function inv() {
            var funinva = "<%=funcioninv%>";
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            var men = document.getElementById("msg");
            men.innerHTML = funinva;
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>
