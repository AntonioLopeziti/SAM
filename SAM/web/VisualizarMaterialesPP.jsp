<%-- 
    Document   : ConsultaMateriales
    Created on : 15/06/2016, 10:43:43 AM
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
        String ParametrosV = po.getProperty("etiqueta.parametrosvisu");
        String material = po.getProperty("etiqueta.materialmatch");
        String centro = po.getProperty("etiqueta.centromatch");
        String organizacion = po.getProperty("etiqueta.organizacionmatch");
        String canald = po.getProperty("etiqueta.canaldistri");
        String datos = po.getProperty("etiqueta.datosbasicosmat");
        String umb = po.getProperty("etiqueta.umbase");
        String nomat = po.getProperty("etiqueta.nomaterial");
        String tipmat = po.getProperty("etiqueta.tipomaterial");
        String grupart = po.getProperty("etiqueta.grupoarticulos");
        String ventas = po.getProperty("etiqueta.ventas");
        String venta1 = po.getProperty("etiqueta.ventas1");
        String venta2 = po.getProperty("etiqueta.ventas2");
        String ventagen = po.getProperty("etiqueta.ventasgral");
        String sector = po.getProperty("etiqueta.sector");
        String umventa = po.getProperty("etiqueta.UMventa");
        String gresta = po.getProperty("etiqueta.gresta");
        String grtp = po.getProperty("etiqueta.grtp");
        String jquia = po.getProperty("etiqueta.jquia");
        String grprecio = po.getProperty("etiqueta.grprecio");
        String grimput = po.getProperty("etiqueta.grimput");
        String grtpo = po.getProperty("etiqueta.grtpo");
        String verif = po.getProperty("etiqueta.verif");
        String gpotra = po.getProperty("etiqueta.gpotra");
        String cebe = po.getProperty("etiqueta.cebe");
        String sujeto = po.getProperty("etiqueta.sujeto");
        String grupocarga = po.getProperty("etiqueta.grupocarga");
        String compras = po.getProperty("etiqueta.compras");
        String grupocompras = po.getProperty("etiqueta.grupocompras");
        String planinece = po.getProperty("etiqueta.planinece");
        String plani1 = po.getProperty("etiqueta.plani1");
        String plani2 = po.getProperty("etiqueta.plani2");
        String car = po.getProperty("etiqueta.car");
        String puntod = po.getProperty("etiqueta.puntod");
        String ciclo = po.getProperty("etiqueta.ciclo");
        String tamlote = po.getProperty("etiqueta.tamlote");
        String tamlotemin = po.getProperty("etiqueta.tamlotemin");
        String horiz = po.getProperty("etiqueta.horiz");
        String planine = po.getProperty("etiqueta.planine");
        String tamlotemax = po.getProperty("etiqueta.tamlotemax");
        String stockmax = po.getProperty("etiqueta.stockmax");
        String aprovi = po.getProperty("etiqueta.aprovi");
        String tmpo = po.getProperty("etiqueta.tmpo");
        String stockseg = po.getProperty("etiqueta.stockseg");
        String stocksem = po.getProperty("etiqueta.stocksem");
        String aproespec = po.getProperty("etiqueta.aproespec");
        String plazen = po.getProperty("etiqueta.plazen");
        String calidad = po.getProperty("etiqueta.calidad");
        String paramtr = po.getProperty("etiqueta.paramtr");
        String aproviqm = po.getProperty("etiqueta.aproviqm");
        String conta = po.getProperty("etiqueta.conta");
        String ctrl = po.getProperty("etiqueta.ctrl");
        String precmed = po.getProperty("etiqueta.precmed");
        String precioesta = po.getProperty("etiqueta.precioesta");
        String cantidadba = po.getProperty("etiqueta.cantidadba");
        String clvalo = po.getProperty("etiqueta.clvalo");
        String catvalo = po.getProperty("etiqueta.catvalo");
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
                var pag = p.charAt(19);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleMaterial.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarMateriales.js"></script>
        <title>Visualizar Maestro de Materiales PP</title>           
    </head>
    <body>  
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;"><%out.println(po.getProperty("etiqueta.Menu_menu"));%></a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>      
            <input  id="guardar" type="image" src="images/guardaOFF.png" disabled/>               
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>   
            <div class="titulo">
                <h1>Visualizar Maestro de Materiales PP</h1>
            </div>             
        </div>            
        <div class="contenido">
            <div class="ContentMateriales">
                <section class="DatosBasicComp_info">
                    <label><%=ParametrosV%></label>
                    <hr id="LineaTituloInfo">
                    <section class="divdatosEmplazamiento">
                        <label><%=material%></label><input type="text" id="material" maxlength="40" style="width:20%; background-repeat: no-repeat; background-position-x: -1%; text-transform: uppercase;"/><button id="match_C1" class='BtnMatchIcon2'></button><label id="descripcionj" style="width: 55%;"></label>
                        <hr id="lineamaterial">
                        <label><%=centro%></label><input type="text" id="centro" maxlength="4"  style="width: 10%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_C2" class='BtnMatchIcon2'></button>
                        <hr id="lineamaterial">
                        <label><%=organizacion%></label><input id="organizacion" maxlength="4" type="text" style="width: 10%; background-repeat: no-repeat; background-position-x: -2%; text-transform: uppercase;"/><button id="match_C3" class='BtnMatchIcon2'></button>
                        <hr id="lineamaterial">
                        <label><%=canald%></label><input id="canal" maxlength="2" type="text" style="width:5%; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_C4" class='BtnMatchIcon2'></button>
                        <hr id="lineamaterial">
                    </section>
                </section>
                <section class="Datos_info">
                    <label style=""><%=datos%></label>
                    <hr id="LineaTituloInfo">
                    <section class="BasicoComp11_info">
                        <label><%=umb%></label><input id="umb" type="text" style="width: 10%;" disabled/>
                        <hr id="lineadatos">
                        <label><%=nomat%></label><input id="nomaterial" type="text" style="width: 50%;" disabled/>
                        <hr id="lineadatos">
                    </section>
                    <section class="BasicoComp12_info">
                        <label><%=tipmat%></label><input id="tipomaterialj" type="text" style="width:20%;" disabled/>
                        <hr id="lineadatos">
                        <label><%=grupart%></label><input id="grupoarticulosj" type="text" style="width:40%;" disabled/>
                        <hr id="lineadatos">
                    </section>
                </section>
                <section class="VisualInfoRecord_info">
                    <section class="ParametrosBusqueda_info">
                        <label style=""><%=ventas%></label>
                        <hr id="LineaTituloInfo">
                        <section class="ParamIzq_info">
                            <label style="width: 80%;"><%=venta1%></label>
                            <hr id="LineaTituloInfo">
                            <section class="Basic_info">
                                <label><%=sector%></label><input id="sectorj" type="text" style="width:16%;" disabled/>
                                <hr id="lineaestadi">
                                <label><%=umventa%></label><input id="umventaj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaestadi">
                            </section>
                        </section>
                        <section class="ParamDer_info">
                            <label style="width: 80%;"><%=venta2%></label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoCo_info">
                                <label><%=gresta%></label><input id="gematerialj" type="text" style="width:10%;" disabled/>
                                <hr>
                                <label><%=grtp%></label><input id="gtpmatej" type="text" style="width:10%;" disabled/>
                                <hr>
                                <label><%=jquia%></label><input id="jeraproj" type="text" style="width:20%;" disabled/>
                                <hr>
                            </section>
                            <section class="BasicoComp2_info">
                                <label><%=grprecio%></label><input id="gpmatej" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=grimput%></label><input id="grupoimmatej" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=grtpo%></label><input id="gtpgenj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                            </section>
                        </section>
                        <section class="Parem_info">
                            <label style="width: 80%;"><%=ventagen%></label>
                            <hr id="LineaTituloInfo">
                            <section class="Bas_info">
                                <label><%=verif%></label><input id="gvdispoj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaventas">
                                <label><%=gpotra%></label><input id="grupotransportej" type="text" style="width:15%;" disabled/>
                                <hr id="lineaventas">
                                <label><%=cebe%></label><input id="centrobenej" type="text" style="width:20%;" disabled/>
                                <hr id="lineaventas">
                            </section>
                            <section class="Basi_info">
                                <label><%=sujeto%></label><input id="sujetolotej" type="text" style="width:10%;" disabled/>
                                <hr id="lineabasi">
                                <label><%=grupocarga%></label><input id="grupocargaj" type="text" style="width:10%;" disabled/>
                                <hr id="lineabasi">
                            </section>
                        </section>
                    </section>
                </section>
                <section class="DatosBa_info">
                    <label style=""><%=compras%></label>
                    <hr id="LineaTituloInfo">
                    <section class="BasicoComp11_info">
                        <label><%=grupocompras%></label><input id="grupocomprasj" type="text" style="width: 10%;" disabled/>
                        <hr id="lineadatos">
                    </section>
                </section>
                <section class="VisualInfoRecord2_info">
                    <section class="Parametros_info">
                        <label style=""><%=planinece%></label>
                        <hr id="LineaTituloInfo">
                        <section class="ParamD_info">
                            <label style="width: 80%;"><%=plani1%></label>
                            <hr id="LineaTituloInfo">
                            <section class="BasicoCo_info">
                                <label><%=car%></label><input id="caraplannj" type="text" style="width:10%;" disabled/>
                                <hr id="lineacar">
                                <label><%=puntod%></label><input id="puntopedidoj" type="text" style="width:20%;" disabled/>
                                <hr id="lineacar">
                                <label><%=ciclo%></label><input id="gpnecej" type="text" style="width:20%;" disabled/>
                                <hr id="lineacar">
                                <label><%=tamlote%></label><input id="tlpnecej" type="text" style="width:20%;" disabled/>
                                <hr id="lineacar">
                                <label><%=tamlotemin%></label><input id="tlminj" type="text" style="width:20%;" disabled/>
                                <hr id="lineacar">
                            </section>
                            <section class="BasicoComp2_info">
                                <label><%=horiz%></label><input id="hpfijoj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=planine%></label><input id="pnecesij" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=tamlotemax%></label><input id="tlmaxj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=stockmax%></label><input id="stockmaximoj" type="text" style="width:15%;" disabled/>
                                <hr id="lineaprecio">
                            </section>
                        </section>
                        <section class="Parem_in">
                            <label style="width: 80%;"><%=plani2%></label>
                            <hr id="LineaTituloInfo">
                            <section class="Bas_info">
                                <label><%=aprovi%></label><input id="claseaproj" type="text" style="width:10%;" disabled/>
                                <hr id="lineaestadi">
                                <label><%=tmpo%></label><input id="ttmdiaj" type="text" style="width:10%;" disabled/>
                                <hr id="lineaestadi">
                                <label><%=stockseg%></label><input id="stockseguridadj" type="text" style="width:20%;" disabled/>
                                <hr id="lineaestadi">
                                <label><%=stocksem%></label><input id="stockseguridadmj" type="text" style="width:20%;" disabled/>
                                <hr id="lineaestadi">
                            </section>
                            <section class="Bass_info">
                                <label><%=aproespec%></label><input id="claseaprovij" type="text" style="width:10%;" disabled/>
                                <hr id="lineaprecio">
                                <label><%=plazen%></label><input id="pepdiaj" type="text" style="width:10%;" disabled/>
                                <hr id="lineaprecio">
                            </section>
                        </section>
                    </section>
                </section>
                <section class="DatosBa_info">
                    <label style=""><%=calidad%></label>
                    <hr id="LineaTituloInfo">
                    <section class="BasicoComp11_info">
                        <label><%=paramtr%></label><input id="epimcenj" type="text" style="width: 10%;" disabled/>
                        <hr id="lineapara">
                    </section>
                    <section class="BasicoComp12_info">
                        <label><%=aproviqm%></label><input id="qmaporj" type="text" style="width:20%;" disabled/>
                        <hr id="lineaapro">
                    </section>
                </section>
                <section class="Dato2_info">
                    <label style=""><%=conta%></label>
                    <hr id="LineaTituloInfo">
                    <section class="BasicoComp14_info">
                        <label><%=ctrl%></label><input id="icpreciosj" type="text" style="width: 10%;" disabled/>
                        <hr>
                        <label><%=precmed%></label><input id="pmviperj" type="text" style="width: 10%;" disabled/>
                        <hr>
                        <label><%=precioesta%></label><input id="precioestandarj" type="text" style="width: 10%;" disabled/>
                        <hr>
                    </section>
                    <section class="BasicoComp13_info">
                        <label><%=cantidadba%></label><input id="cantidadbasej" type="text" style="width:20%;" disabled/>
                        <hr>
                        <label><%=clvalo%></label><input id="clasevaloracionj" type="text" style="width:20%;" disabled/>
                        <hr>
                        <label><%=catvalo%></label><input id="categoriavaloracionj" type="text" style="width:20%;" disabled/>
                        <hr>
                    </section>
                </section>
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
        <div id="VentanaModal" class="VentanaModalMate">
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
                        <label>T.Material</label><input type="text"   id="tipmat"   style="width:10%; text-transform: uppercase;" maxlength="4"/>
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
                        <div class="fixedYM" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%=material%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th><th><%out.println(po.getProperty("etiqueta.centromatch"));%></th><th>T.Material</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXM" id="CargarDatosM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.Titulo_CC"));%></button><hr></div>
            <div id="BuscarParam_C" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTablaC" style="display: none;">
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
        <div id="VentanaModalOrganizacion" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('organizacion');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.matchorganizacion"));%></button><hr></div>
            <div id="BuscarParam_O" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTablaO" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrollO" class="table-scroll">
                        <div id="fixedYO" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.matchorganizacion"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosO">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalCanal" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('canal');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.matchcanal"));%></button><hr></div>
            <div id="BuscarParam_CA" class="BuscarParam_u">
                <div class="fondo_Match"></div>
            </div>
            <div id="ConsultaTablaCA" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scrollCA" class="table-scroll">
                        <div id="fixedYCA" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.matchcanal"));%></th><th><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosCA">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script>
        function ocultarVentana(tipo)
        {
            $('#overlay').remove();
            switch (tipo) {
                case 'material':
                    var ventana = document.getElementById('VentanaModal');
                    ventana.style.display = 'none';
                    document.getElementById("BuscarParam_m").style.display = "block";
                    document.getElementById("ConsultaTabla").style.display = "none";
                    document.getElementById("material").focus();
                    break;
                case 'centro':
                    var ventanac = document.getElementById('VentanaModalCentro');
                    ventanac.style.display = 'none';
                    document.getElementById("BuscarParam_c").style.display = "block";
                    document.getElementById("ConsultaTablaC").style.display = "none";
                    document.getElementById("centro").focus();
                    break;
                case 'organizacion':
                    var ventanao = document.getElementById('VentanaModalOrganizacion');
                    ventanao.style.display = 'none';
                    document.getElementById("BuscarParam_O").style.display = "block";
                    document.getElementById("ConsultaTablaO").style.display = "none";
                    break;
                case 'canal':
                    var ventanaca = document.getElementById('VentanaModalCanal');
                    ventanaca.style.display = 'none';
                    document.getElementById("BuscarParam_CA").style.display = "block";
                    document.getElementById("ConsultaTablaCA").style.display = "none";
                    break;
                default:
                    break;
            }
        }

        function seleccionar(obj, tipo) {
            switch (tipo) {
                case 'material':
                    var m = document.getElementById("material");
                    m.focus();
                    m.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'centro':
                    var c = document.getElementById("centro");
                    c.focus();
                    c.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'organizacion':
                    var o = document.getElementById("organizacion");
                    o.focus();
                    o.value = obj;
                    ocultarVentana(tipo);
                    break;
                case 'canal':
                    var ca = document.getElementById("canal");
                    ca.focus();
                    ca.value = obj;
                    ocultarVentana(tipo);
                    break;
                default:
                    break;
            }
        }


        function mensajess(num, id) {
            switch (num) {
                case 0:
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapsnd05.wav";
                    BE.play();
                    break;
                case 1 :
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    var okcon = '<%=menValores%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    $("#iconmsg").show();
                    break
                case 2:
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    var mensj = '<%=CampOb%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = mensj;
                    $("#iconmsg").show();
                    break;
                case 3:
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = '<%=MenVal%>';
                    $("#iconmsg").show();
                    break
                case 4 :
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    var okcon = '<%=okcons%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    $("#iconmsg").show();
                    break;
                case 5 :
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    var okcon = '<%=funcioninv%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    $("#iconmsg").show();
                    break;
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