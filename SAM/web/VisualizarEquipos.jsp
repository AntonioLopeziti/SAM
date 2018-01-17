<%-- 
    Document   : VisualizarEquipos
    Created on : 10/06/2016, 12:27:39 PM
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
        String existFol = po.getProperty("etiqueta.NoexisteEquipoEQ");
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
        String CameqVacci = po.getProperty("etiqueta.VisEq_CameqVacci");
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
                var pag = p.charAt(55);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=menValores%>';
                        break;
                    case 3:
                        msg = "<%=CampoOb%>";
                        break;
                    case 4:
                        msg = "<%=existFol%>";
                        break;
                    case 5:
                        msg = "<%=OKconsul%>";
                        break;
                    case 6:
                        msg = "<%=NoArchMos%>";
                        break;
                    case 7:
                        msg = "<%=CameqVacci%>";
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
            function seleccionar(eq) {
                var se = $('#equ');
                se.val(eq);
                se.focus();
                ocultarVentana();
            }
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
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleEquipos.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/VisualizarEquipos.js"></script>  
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.titVisEq"));%></title>       
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
            <input  id="finalizar" type="image" src="images/cancelaOFF.png"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.titVisEq"));%></h1></div> 
        </div>             
        <div class="contenido">
            <div class="ContentEquipos">  
                <div class="divmatchequipo">
                    <label><%out.println(po.getProperty("etiqueta.numerodeequipoEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divizqequipoo">
                        <input style="width:80%; text-transform: uppercase;" id="equ" maxlength="18" type="text"/><button id="btnmatch"  class="BtnMatchIcon"></button>                                                
                    </div>
                    <div class="dividerequipoo">
                        <button id="VisDoo" style="width: 40%;margin-right: 15%;">Visualizar Documentos</button>        
                    </div>
                    <input type="text" id="deq" style="width:90%; border: none; " readonly/>
                </div>
                <section class="divdatosgralEquipos">
                    <label><%out.println(po.getProperty("etiqueta.DatosgeneralesEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divizqequipo">
                        <label><%out.println(po.getProperty("etiqueta.VU_Clase"));%></label><input id="clase" style="width:45%;" type="text" disabled>
                        <hr>
                        <label ><%out.println(po.getProperty("etiqueta.VU_GrupoAutoriz"));%></label><input id="grupAuto" style="width: 15%;" value="" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_Peso"));%></label><input id="peso" type="text" style="width:40%;" value="0,000" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_NInventario"));%></label><input id="inven" style="width:48%;" type="text" disabled="">
                        <hr>
                    </div>
                    <div class="dividerequipo">
                        <label><%out.println(po.getProperty("etiqueta.VU_TamanoDimens"));%></label><input id="dim" style="width:40%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VU_PstaEnServDesde"));%></label><input id="serv" style="width:25%;" type="text" disabled>
                        <hr>
                    </div>
                </section>
                <section class="divdatosFabricacionEquipos">
                    <label><%out.println(po.getProperty("etiqueta.DatosdefabricacionEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divizqequipo">
                        <label><%out.println(po.getProperty("etiqueta.FabricanteEQ"));%></label><input id="fab_eq" style="width:50%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.DenomitipoEQ"));%></label><input id="denom_eq" style="width:30%;" type="text" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.nopiezaEQ"));%></label><input id="pieza_eq"  style="width:45%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.FabrNoSerieEQ"));%></label><input id="serie_eq"  style="width:45%;" type="text" disabled="">
                        <hr>
                    </div>
                    <div class="dividerequipo">
                        <label><%out.println(po.getProperty("etiqueta.PaisproductorEQ"));%></label><input id="pais_eq" type="text" style="width: 10%;" disabled>
                        <hr>
                    </div>
                </section> 
                <section class="divdatosEmplazamiento">
                    <label><%out.println(po.getProperty("etiqueta.DatosemplazamientoEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divcomequipo">
                        <label><%out.println(po.getProperty("etiqueta.CeemplazamEQ"));%></label><input id="ceemp_eq" style="width:15%;" type="text" disabled>
                        <hr>
                        <label ><%out.println(po.getProperty("etiqueta.EmplazamientoEQ"));%></label><input id="emp_eq" style="width:30%;" type="text" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.areadeempresaEQ"));%></label><input id="empre_eq" style="width:12%;"  type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PuestodeTrabajoEQ"));%></label><input id="puesto_eq" style="width: 25%;" type="text" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.IndicadorABCEQ"));%></label><input id="indica_eq"  style="width: 8%;" type="text" disabled="">
                        <hr>
                    </div>                           
                </section> 
                <section class="divimputacion">
                    <label><%out.println(po.getProperty("etiqueta.ImputacionEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divcomequipo">
                        <label><%out.println(po.getProperty("etiqueta.VESociedadEQ"));%></label><input id="soc_eq" type="text" style="width:15%;" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VECentroCosteEQ"));%></label><span><input id="coste_eq" type="text" style="width:35%;" disabled> / <input id="coste2_eq" type="text" style="width:15%;"disabled></span>
                        <hr>                              
                    </div>                           
                </section>  
                <section class="divresponabilidades">
                    <label><%out.println(po.getProperty("etiqueta.VEResponsabilidadesEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divcomequipo">
                        <label><%out.println(po.getProperty("etiqueta.VECentroplanifEQ"));%></label><input id="cenp_eq" style="width:15%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VEGrupoplanifEQ"));%></label><input id="grpop_eq" style="width:12%;" type="text" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VEPtotbjorespEQ"));%></label><span><input id="ptr_eq" style="width:25%;" type="text" disabled/> <input id="ptr2_eq" type="text" style="width:15%;" disabled></span>
                        <hr>                              
                    </div>                           
                </section>  
                <section class="divestructura">
                    <label><%out.println(po.getProperty("etiqueta.VEEstructuraEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divcomequipo">
                        <label><%out.println(po.getProperty("etiqueta.VEFunctionallocEQ"));%></label><input id="ubc_eq" type="text" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.VEEquiposuperiorEQ"));%></label><input id="equs_eq" type="text" style="width:30%;" disabled/>
                        <hr>                                                            
                    </div>                           
                </section>  
                <section class="divgeneralidades">
                    <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.GeneralidadesEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divcomequipo">
                        <label><%out.println(po.getProperty("etiqueta.materialmatch"));%></label><input id="mat_eq" type="text" style="width:50%;" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumSerieEQ"));%></label><span><input id="numser_eq" type="text" style="width:25%;" disabled/> <label style="width:15%;"><%out.println(po.getProperty("etiquetaTipoEquipo"));%></label><input id="tipo_eq" type="text" style="width:10%;" disabled></span>
                        <hr>                                                             
                    </div>   
                    <div style="width: 45%; float:left">
                        <input type="text" style="width:70%; border: none; background: none;" id="desmatequ" readonly/>
                    </div>
                </section> 
                <section class="divdatosInfoStockEquipos">
                    <label><%out.println(po.getProperty("etiqueta.InfoStockEQ"));%></label> 
                    <hr class="lineaazul">
                    <div class="divizqequipo">
                        <label><%out.println(po.getProperty("etiquetal.TipoStockEQ"));%></label><input id="tipoStock_eq" style="width:8%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Centro_CC"));%></label><input id="centro_eq" type="text" style="width:14%;" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.alamcenEQ"));%></label><input id="alma_eq" type="text" style="width:14%;" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.LoteStockEQ"));%></label><input id="lote_eq" type="text" style="width:25%;" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.StockEspecialEQ"));%></label><input id="StockEsp_eq" type="text" style="width:6%;" disabled="">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ClienteEQ"));%></label><input id="cliente_eq" type="text" style="width:30%;" disabled="">
                        <hr>
                    </div>
                    <div class="dividerequipo">
                        <label><%out.println(po.getProperty("etiqueta.LoteMaestroEQ"));%></label><input id="lotemaes_eq" style="width:20%;" type="text" disabled>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.FechaÚltMovMcíaEQ"));%></label><input id="fchaUt_eq" style="width:25%;" year_eqtype="text" disabled> 
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.proveedorEQ"));%></label><input id="prov_eq" style="width:20%;" type="text" disabled>
                        <hr>
                    </div>
                </section> 
            </div>


            <div id="VentanaModal" class="VentanaModal">
                <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="CerrarMCEqupos"><label >X</label></div></div>
                <div class="PanelBntMatch"><button id="retmc"><%out.println(po.getProperty("etiqueta.GralRestriciones"));%></button><hr></div>
                <div id="BuscarParam" class="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                            <label><%out.println(po.getProperty("etiqueta.GralEquipo"));%></label><input type="text" id="equBus" maxlength="18" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></label><input type="text" maxlength="40" id="denEqBus" style="width:35%;"/>
                            <hr>
                            <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="3" type="text"  id="numAcMax"  style="width:10%;" />
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okEquipo"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" id="CerrarMCEqupos2"/>
                    </div>
                </div>
                <div id="ConsultaTabla" style="display: none;">
                    <div class="tablaCab">
                        <div class="table-scroll" id="table-scroll">
                            <div class="fixedY" id="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.GralEquipo"));%></th><th><%out.println(po.getProperty("etiqueta.GralDenominacion"));%></th>
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
            <div id="VentanaModalCentroP" class="VentanaModal">
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
            </div>
            <div id="VentUbTecAvvv" class="VentanaModalAvvv">
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
                    var writefecha = $('#fecha')
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else {
                        writefecha.html("Fecha Indefinida");
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