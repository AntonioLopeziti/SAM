<%-- 
    Document   : VisualizarProveedores
    Created on : 16/06/2016, 10:34:37 AM
    Author     : AREConsulting
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String MenInval = po.getProperty("etiqueta.FuncionInval_Menu");
        String Mens = po.getProperty("etiqueta.CompObligatorios");
        String OKconsul = po.getProperty("etiqueta.ConOk_FO");
        String provNo = po.getProperty("etiqueta.NoProvedro_pro");
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
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String CenNoEnc = po.getProperty("etiqueta.CenNoVal");
        String ProvGuar = po.getProperty("etiqueta.ProvGuardCrea_prov");
        String ProvNotGuard = po.getProperty("etiqueta.ProvNotGuardCrea_prov");
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
                var pag = p.charAt(22);
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
                        msg = '<%=CenNoEnc%>';
                        break;
                    case 2:
                        msg = '<%=Mens%>';
                        break;
                    case 3:
                        msg = '<%=ProvGuar%>';
                        break;
                    case 4:
                        msg = '<%=ProvNotGuard%>';
                        break;
                }
                $('#msg').html(msg);                
                var icon = $('#iconmsg');        
                icon.css("visibility", "visible");
                icon.show();
                icon.attr('src', im);
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleCreaProovedores.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/CreaProovedores.js"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloProveedorCrea_pro"));%></title>           
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png" disabled/>      
            <input  id="guardar" type="image" src="images/guarda.PNG"/>                  
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloProveedorCrea_pro"));%></h1></div>                 
        </div>
        <div class="contenido">
            <section class="VisualProveedor_pro">
                <section class="ParametrosBusqueda_pro">
                    <label><%out.println(po.getProperty("etiqueta.ParametroBusqueda_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="SectionComp_pro">
                        <label><%out.println(po.getProperty("etiqueta.Acreedor_pro"));%></label><input maxlength="10" type="text" value="" id="Acreed" maxlength="10" style="width: 15%; background-repeat: no-repeat; background-position-x: -2%;"/>
                        <!--<button id="match_C1" class='BtnMatchIcon2'></button>-->
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Sociedad_pro"));%></label><input maxlength="4" type="text" id="sociedad" maxlength="4" style="width:8%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/>
                        <!--<button id="match_C2" class='BtnMatchIcon2'></button>-->
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.OrgCompras_pro"));%></label><input maxlength="4" type="text" id="org_compras" maxlength="4" style="width:8%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/>
                        <!--<button id="match_C3" class='BtnMatchIcon2'></button>-->
                        <hr>
                    </section>                       
                </section>
                <section class="Direccion_pro">
                    <label><%out.println(po.getProperty("etiqueta.Direccion_pro"));%></label>
                    <hr id="LineatituloPro">
                    <div class="nombresProved">
                        <label><%out.println(po.getProperty("etiqueta.Nombre_pro"));%></label><input id="nomProv" style="width:34%; background-repeat: no-repeat; background-position-x: -2%;"  value="" type="text" />
                        <hr>
                    </div>
                    <div class="nombres2Proved">
                        <input type="text" style="width:45%; border:none;" id="nombre1_pro" readonly/> <input type="text" style="width:45%; background-repeat: no-repeat; background-position-x: -2%; border:none;" id="nombre2_pro" readonly/>
                        <input type="text" style="width:45%; border:none;" id="nombre3_pro" readonly/> <input type="text" style="width:45%; background-repeat: no-repeat; background-position-x: -2%; border:none;" id="nombre4_pro" readonly/>
                    </div>
                    <div class="DirecIzq_pro">    
                        <label><%out.println(po.getProperty("etiqueta.Poblacion_pro"));%></label><input style="width:35%; background-repeat: no-repeat; background-position-x: -2%;" id="poblacion_pro" value="" type="text" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ResidenciaAt_pro"));%></label><input style="width:35%; background-repeat: no-repeat; background-position-x: -2%;" id="residencia_pro" value="" type="text" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Calle_pro"));%></label><input style="width:60%; background-repeat: no-repeat; background-position-x: -2%;" id="calle_pro" value="" type="text" />
                        <hr>
                    </div>
                    <div class="DirecDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.Distrito_pro"));%></label><input style="width:60%; background-repeat: no-repeat; background-position-x: -2%;" id="distrito_pro" value="" type="text" >
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumEdificio_pro"));%></label><input style="width:20%; background-repeat: no-repeat; background-position-x: -2%;" id="edificio_pro" value="" type="text" >
                        <hr>
                    </div>
                </section>
                <section class="DatosSociedad_pro">
                    <label><%out.println(po.getProperty("etiqueta.DatosSocie_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="DatosSoIzq_pro">
                        <label><%out.println(po.getProperty("etiqueta.NumIndFiscal"));%></label><input type="text" id="nif_pro" value="" style="background-repeat: no-repeat; background-position-x: -2%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ConPago_pro"));%></label><input type="text" id="pago_pro" value="" style="width:15%; background-repeat: no-repeat; background-position-x: -2%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.IndABC_pro"));%></label><input type="text" id="ABC_pro" value="" style="width:6%; background-repeat: no-repeat; background-position-x: -2%;" />
                        <hr>
                    </section>
                    <section class="DatosSoDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.GrupoCuenta_pro"));%></label><input type="text" id="grupocuentas_pro" value="" style="width:18%; background-repeat: no-repeat; background-position-x: -2%;">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CuentaAsoc_pro"));%></label><input type="text" id="cuentaaso_pro" value="" style="background-repeat: no-repeat; background-position-x: -2%;">
                        <hr>
                    </section>
                </section>
                <section class="Compras_pro">
                    <label><%out.println(po.getProperty("etiqueta.Compras_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="DatosSoIzq_pro">
                        <label><%out.println(po.getProperty("etiqueta.MonedaPedido_pro"));%></label><input type="text" id="moneda_pro" value="" style="width:15%; background-repeat: no-repeat; background-position-x: -2%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ValorMinimo_pro"));%></label><input type="text" id="valor_pro" value="" style="width:35%; background-repeat: no-repeat; background-position-x: -2%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Iconterm_pro"));%></label><input type="text" id="ico1_pro" value="" style="width:10%; background-repeat: no-repeat; background-position-x: -2%;" /> <input type="text" id="ico2_pro" value="" style="width:40%; background-repeat: no-repeat; background-position-x: -2%;"/>
                        <hr>
                    </section>
                    <section class="DatosSoDer_pro">
                        <label><%out.println(po.getProperty("etiqueta.ControlConfirm_pro"));%></label><input type="text" id="confir_pro" value="" style="width:18%; background-repeat: no-repeat; background-position-x: -2%;">
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GrupoCompras_pro"));%></label><input type="text" id="grupocompras_pro" value="" style="width:20%; background-repeat: no-repeat; background-position-x: -2%;" >
                        <hr>
                    </section>
                </section>
                <section class="BloqueoBorrado_pro">
                    <label><%out.println(po.getProperty("etiqueta.BloqueoBorado_pro"));%></label>
                    <hr id="LineatituloPro">
                    <section class="SectionComp_pro">
                        <span>
                            <input id="petBor_pro" type="checkbox" ><%out.println(po.getProperty("etiqueta.PetiBorSoc_pro"));%>
                            <br>
                            <input id="bloqConta_pro" type="checkbox" ><%out.println(po.getProperty("etiqueta.BloqContPSoc_pro"));%>
                            <br>
                            <input id="petBorCe_pro" type="checkbox" ><%out.println(po.getProperty("etiqueta.PeBorrado_pro"));%>
                        </span>
                    </section>   
                </section>
            </section>

        </div>
        <div id="VentanaModalProveedor" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaModal('proveedor');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltprov"><%out.println(po.getProperty("etiqueta.ProvedoresGral_matchPro"));%></button><hr></div>
            <div id="BuscarParam_Prov" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></label><input type="text" id="nomProv_ProvBusc" style="width:35%;"  maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></label><input type="text" id="Idrov_RpvBus" style="width:35%;" maxlength="10"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer" id="okProveedor"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentanaModal('proveedor');"/>
                </div>
            </div>
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></th><th><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos1">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalSociedad" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaModal('sociedad');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltrosoc"><%out.println(po.getProperty("etiqueta.DeudorGral_MatchCL"));%></button><hr></div>
            <div id="BuscarParamSoc_u" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Socied_CL"));%></label><input type="text" id="Soc_CLbus" maxlength="4" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denonsoc_CL"));%></label><input type="text" id="nomSoc_CLBus" maxlength="25" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Poblas0c_CL"));%></label><input type="text" id="PoblaciSoc_CLBus" maxlength="25" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.ClvMonSoc_CL"));%></label><input type="text" id="ClvMone_CLBus" maxlength="5" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"   id="numAcMax2"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="OkSociedad"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentanaModal('sociedad');"/>
                </div>
            </div>
            <div id="ConsultaTabla2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll2">
                        <div class="fixedY" id="fixedY2">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Socied_CL"));%></th><th><%out.println(po.getProperty("etiqueta.Denonsoc_CL"));%></th><th><%out.println(po.getProperty("etiqueta.ClvMonSoc_CL"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalOrgCompras" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentanaModal('compras')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltorgco"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_OC" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></label><input type="text" id="OrgaCom_Pro" maxlength="4" style="width:35%; text-transform: uppercase;"  focus/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denominacioncomp_mathPro"));%></label><input type="text" id="Denom_Pro" maxlength="20" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax3" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okOrgaCom"/>                        
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentanaModal('compras');"/>
                </div>
            </div>
            <div id="ConsultaTabla3" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll3">
                        <div class="fixedY" id="fixedY3">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos3">
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
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">                    
//                    function startTime() {
//                        today = new Date();
//                        n = today.getHours();
//                        m = today.getMinutes();
//                        s = today.getSeconds();
//                        h = checkTime(n);
//                        m = checkTime(m);
//                        s = checkTime(s);
//                        document.getElementById('tiempo').innerHTML = h + ":" + m + ":" + s;
//                        t = setTimeout('startTime()', 500);
//                    }
//                    function checkTime(i)
//                    {
//                        if (i < 10) {
//                            i = "0" + i;
//                        }
//                        return i;
//                    }
                    window.onload = function () {
//                        startTime();
                        bloq();
                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
//                        document.getElementById('guardar').disabled = true;
//                        document.getElementById('cancelar').disabled = true;
//                        document.getElementById('finalizar').disabled = true;
                    }

                <!--</script>-->
            </div>
        </footer>
    </body>
    <!--    <script>
            function inval() {
                //error
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = "<%=MenInval%>";
            }
            function back() {
                window.location.href = "Bienvenido.jsp";
            }
            function ValidarDatos() {
                var prov = document.getElementById('Acreed').value;
                var soci = document.getElementById('sociedad').value;
                var orga = document.getElementById('org_compras').value;
                if (prov.length < 1 || soci.length < 1 || orga.length < 1) {
    
                    var mensj = '<%=Mens%>';
    
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = mensj;
    
    
                    dataFocus();
                } else {
                    EnviarDatos(prov, soci, orga);
                }
            }
    
    
            function dataFocus() {
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
    
    
                var temp = new Array();
                temp[0] = document.getElementById("Acreed");
                temp[1] = document.getElementById("sociedad");
                temp[2] = document.getElementById("org_compras");
    
                for (i = 0; i < temp.length; i++)
                {
                    if (temp[i].value.length === 0)
                    {
                        temp[i].focus();
                        return;
                    }
                }
            }
    
    
    
            function EnviarDatos(prov, soci, orga) {
                var url = "peticionModuloVisualizarProveedores";
                var acc = "CargarProveedor";
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        var rs = xmlhttp.responseText;
                        if (rs == 0) {
                            var BE = document.createElement('audio');
                            BE.src = "audio/saperror.wav";
                            BE.play()
                            var okcon = "<%=provNo%>";
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/advertencia.PNG";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                            limpiar();
                        } else {
                            var BE = document.createElement('audio');
                            BE.src = "audio/sapmsg.wav";
                            BE.play();
                            cargar(rs);
                            var okcon = "<%=OKconsul%>";
                            var iconm = document.getElementById("iconmsg");
                            iconm.style.visibility = "visible";
                            iconm.src = "images/aceptar.png";
                            var men = document.getElementById("msg");
                            men.innerHTML = okcon;
                        }
                    }
                };
                xmlhttp.open("GET", url + "?accion=" + acc + "&acreedor=" + prov + "&sociedad=" + soci + "&Compras=" + orga, true);
                xmlhttp.send();
            }
            function cargar(res) {
                var r = new Array();
                r = res.split(",");
                document.getElementById("nombre1_pro").value = r[0];
                document.getElementById("nombre2_pro").value = r[1];
                document.getElementById("nombre3_pro").value = r[2];
                document.getElementById("nombre4_pro").value = r[3];
                document.getElementById("poblacion_pro").value = r[4];
                document.getElementById("residencia_pro").value = r[5];
                document.getElementById("calle_pro").value = r[6];
                document.getElementById("distrito_pro").value = r[7];
                document.getElementById("edificio_pro").value = r[8];
                document.getElementById("nif_pro").value = r[9];
                document.getElementById("pago_pro").value = r[10];
                document.getElementById("ABC_pro").value = r[11];
                document.getElementById("grupocuentas_pro").value = r[12];
                document.getElementById("cuentaaso_pro").value = r[13];
                document.getElementById("moneda_pro").value = r[14];
                document.getElementById("valor_pro").value = r[15];
                document.getElementById("ico1_pro").value = r[16];
                document.getElementById("ico2_pro").value = r[17];
                document.getElementById("confir_pro").value = r[18];
                document.getElementById("grupocompras_pro").value = r[19];
                document.getElementById("petBor_pro").checked = VerificarChecks(r[20]);
                document.getElementById("bloqConta_pro").checked = VerificarChecks(r[21]);
                document.getElementById("petBorCe_pro").checked = VerificarChecks(r[22]);
            }
            function VerificarChecks(valor) {
                if (valor == "x" || valor == "X") {
                    return true;
                } else {
                    return false;
                }
            }
            function mostrarVentanaModal(tipo) {
                switch (tipo) {
                    case 'proveedor':
                        var ventana = document.getElementById('VentanaModalProveedor');
                        abrirVentana(ventana);
                        var txtpro = document.getElementById('nomProv_ProvBusc');
                        document.getElementById('Idrov_RpvBus').value = '';
                        document.getElementById('numAcMax').value = '500';
                        txtpro.focus();
                        txtpro.value = '';
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                        var men = document.getElementById("msg");
                        men.innerHTML = "";
                        break;
                    case 'sociedad':
                        var ventana2 = document.getElementById('VentanaModalSociedad');
                        abrirVentana(ventana2);
                        var txtsoc = document.getElementById('Soc_CLbus');
                        document.getElementById('Soc_CLbus').value = '';
                        document.getElementById('nomSoc_CLBus').value = '';
                        document.getElementById('PoblaciSoc_CLBus').value = '';
                        document.getElementById('ClvMone_CLBus').value = '';
                        document.getElementById('numAcMax2').value = '500';
                        txtsoc.focus();
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                        var men = document.getElementById("msg");
                        men.innerHTML = "";
                        break;
                    case 'compras':
                        var ventana3 = document.getElementById('VentanaModalOrgCompras');
                        abrirVentana(ventana3);
                        var txtcom = document.getElementById('OrgaCom_Pro');
                        document.getElementById('Denom_Pro').value = '';
                        document.getElementById('numAcMax3').value = '500';
                        txtcom.value = '';
                        txtcom.focus();
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "hidden";
                        var men = document.getElementById("msg");
                        men.innerHTML = "";
                        break;
                }
    
            }
            function abrirVentana(ventana) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapsnd05.wav";
                BE.play();
    
                var ancho = 350;
                var alto = 650;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ventana.style.left = x + "px";
                ventana.style.top = y + "px";
                ventana.style.display = 'block';
            }
            function ocultarVentanaModal(tipo) {
                $('#overlay').remove();
                switch (tipo) {
                    case 'proveedor':
                        var ventana = document.getElementById('VentanaModalProveedor');
                        ventana.style.display = 'none';
                        document.getElementById("BuscarParam_Prov").style.display = "block";
                        document.getElementById("ConsultaTabla").style.display = "none";
                        document.getElementById("Acreed").focus();
                        break;
                    case 'sociedad':
                        var ventana2 = document.getElementById('VentanaModalSociedad');
                        ventana2.style.display = 'none';
                        document.getElementById("BuscarParamSoc_u").style.display = "block";
                        document.getElementById("ConsultaTabla2").style.display = "none";
                        document.getElementById("sociedad").focus();
                        break;
                    case 'compras':
                        var ventana3 = document.getElementById('VentanaModalOrgCompras');
                        ventana3.style.display = 'none';
                        document.getElementById("BuscarParam_OC").style.display = "block";
                        document.getElementById("ConsultaTabla3").style.display = "none";
                        document.getElementById("org_compras").focus();
                        break;
                }
    
            }
            function datosincorrectos() {
    
                //error
                var BE = document.createElement('audio');
                BE.src = "audio/saperror.wav";
                BE.play();
                var okcon = "<%=menValores%>";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/aceptar.png";
                var men = document.getElementById("msg");
                men.innerHTML = okcon;
            }
            function borrarmsg() {
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "hidden";
                var men = document.getElementById("msg");
                men.innerHTML = "";
            }
    
            function ConsultaProveedor() {
                var url = "peticionModuloVisualizarProveedores";
                var acc = "ConsultaMatchProveedor";
                var nom = document.getElementById('nomProv_ProvBusc').value;
                var pro = document.getElementById('Idrov_RpvBus').value;
                var ctd = document.getElementById('numAcMax').value;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            datosincorrectos();
                        } else {
                            document.getElementById("BuscarParam_Prov").style.display = "none";
                            document.getElementById("ConsultaTabla").style.display = "block";
                            document.getElementById("cargarDatos1").innerHTML = rs;
                            fnc();
                            borrarmsg();
                        }
                    }
                };
                xmlhttp.open("GET", url + "?accion=" + acc + "&nombre=" + nom + "&acreedor=" + pro + "&ctd=" + ctd, true);
                xmlhttp.send();
            }
            function ConsultaSociedad() {
                var url = "peticionModuloVisualizarProveedores";
                var idi = '<%=Idioma%>';
                var acc = "ConsultaMatchSociedad";
                var proveedor = document.getElementById("Acreed").value;
                var sociedad = document.getElementById('Soc_CLbus').value;
                var nombresoc = document.getElementById('nomSoc_CLBus').value;
                var poblacion = document.getElementById('PoblaciSoc_CLBus').value;
                var moneda = document.getElementById('ClvMone_CLBus').value;
                var ctd = document.getElementById('numAcMax2').value;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            datosincorrectos();
                        } else {
                            document.getElementById("BuscarParamSoc_u").style.display = "none";
                            document.getElementById("ConsultaTabla2").style.display = "block";
                            document.getElementById("cargarDatos2").innerHTML = rs;
                            fnc2();
                            borrarmsg();
                        }
                    }
                };
                xmlhttp.open("GET", url + "?accion=" + acc + "&acreedor=" + proveedor + "&sociedad=" + sociedad + "&NomSociedad=" + nombresoc + "&poblacion=" + poblacion + "&moneda=" + moneda + "&ctd=" + ctd + "&Idioma=" + idi, true);
                xmlhttp.send();
            }
            function ConsultaOrgCompras() {
                var url = "peticionModuloVisualizarProveedores";
                var acc = "ConsultaMatchOrgCompras";
                var idioma = '<%=Idioma%>';
                var proveedor = document.getElementById("Acreed").value;
                var Org = document.getElementById('OrgaCom_Pro').value;
                var Den = document.getElementById('Denom_Pro').value;
                var ctd = document.getElementById('numAcMax3').value;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        rs = xmlhttp.responseText;
                        if (rs == 0) {
                            datosincorrectos();
                        } else {
                            document.getElementById("BuscarParam_OC").style.display = "none";
                            document.getElementById("ConsultaTabla3").style.display = "block";
                            document.getElementById("cargarDatos3").innerHTML = rs;
                            fnc3();
                            borrarmsg();
                        }
                    }
                };
                xmlhttp.open("GET", url + "?accion=" + acc + "&acreedor=" + proveedor + "&Compras=" + Org + "&Denominacion=" + Den + "&ctd=" + ctd + "&Idioma=" + idioma, true);
                xmlhttp.send();
            }
            function seleccionar(obj, tipo) {
                switch (tipo) {
                    case "proveedor":
                        var a = document.getElementById("Acreed");
                        a.focus();
                        a.value = obj;
                        ocultarVentanaModal(tipo);
                        break;
                    case "sociedad":
                        var s = document.getElementById("sociedad");
                        s.focus();
                        s.value = obj;
                        ocultarVentanaModal(tipo);
                        break;
                    case "compras":
                        var o = document.getElementById("org_compras");
                        o.focus();
                        o.value = obj;
                        ocultarVentanaModal(tipo);
                        break;
                    default:
                        break;
    
                }
    
            }
            function ValidarMaximo(num) {
                if (num < 1) {
                    document.getElementById("numAcMax").value = 100;
                    document.getElementById("numAcMax2").value = 100;
                    document.getElementById("numAcMax3").value = 100;
                }
            }
            function fnc() {
                document.getElementById('table-scroll').onscroll = function () {
                    document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                };
            }
            function fnc2() {
                document.getElementById('table-scroll2').onscroll = function () {
                    document.getElementById('fixedY2').style.top = document.getElementById('table-scroll2').scrollTop + 'px';
                };
            }
            function fnc3() {
                document.getElementById('table-scroll2').onscroll = function () {
                    document.getElementById('fixedY2').style.top = document.getElementById('table-scroll2').scrollTop + 'px';
                };
            }
            function limpiar() {
                var a = document.getElementById("Acreed");
                a.value = "";
                var s = document.getElementById("sociedad");
                s.value = "";
                var o = document.getElementById("org_compras");
                o.value = "";
                document.getElementById("nombre1_pro").value = "";
                document.getElementById("nombre2_pro").value = "";
                document.getElementById("nombre3_pro").value = "";
                document.getElementById("nombre4_pro").value = "";
                document.getElementById("poblacion_pro").value = "";
                document.getElementById("residencia_pro").value = "";
                document.getElementById("calle_pro").value = "";
                document.getElementById("distrito_pro").value = "";
                document.getElementById("edificio_pro").value = "";
                document.getElementById("nif_pro").value = "";
                document.getElementById("pago_pro").value = "";
                document.getElementById("ABC_pro").value = "";
                document.getElementById("grupocuentas_pro").value = "";
                document.getElementById("cuentaaso_pro").value = "";
                document.getElementById("moneda_pro").value = "";
                document.getElementById("valor_pro").value = "";
                document.getElementById("ico1_pro").value = "";
                document.getElementById("ico2_pro").value = "";
                document.getElementById("confir_pro").value = "";
                document.getElementById("grupocompras_pro").value = "";
                document.getElementById("petBor_pro").checked = false;
                document.getElementById("bloqConta_pro").checked = false;
                document.getElementById("petBorCe_pro").checked = false;
                a.focus();
            }
        </script>-->
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>

