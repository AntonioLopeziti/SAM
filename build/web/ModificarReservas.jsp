<%-- 
    Document   : Reservas
    Created on : 27-oct-2016, 12:16:27
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.Properties"%>
<%@page import = "java.io.InputStream"%>
<%@page import = "java.net.URL"%>
<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
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
        String Notfoli = po.getProperty("etiqueta.RESNOSFOLIOSA");
        String msgok = po.getProperty("etiqueta.ConOk_FO");
        String invalf = po.getProperty("etiqueta.FuncionInval_Menu");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
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
        String material = po.getProperty("etiqueta.materialmatch");
        String centro = po.getProperty("etiqueta.centromatch");
        String MaterialType = po.getProperty("etiqueta.RESMaterialType");
        String errocon = po.getProperty("etiqueta.NoExisteMateril_MAT");
        String MateAl = po.getProperty("etiqueta.RESMatenoCreAl");
        String NotExistda = po.getProperty("etiqueta.NotExistda");
        String MateiNonob = po.getProperty("etiqueta.CSPoblgmat");
        String CSPoblcant = po.getProperty("etiqueta.CSPoblcant");
        String CSPercan = po.getProperty("etiqueta.CSPercan");
        String UserNotmod = po.getProperty("etiqueta.RESUserNotmod");
        String modifire = po.getProperty("etiqueta.RESModif");

        int f;
        String foc;
        folios fo = new folios();
        fo = ACC_Folios.ObtenerIstancia().ObtenerDatos();
        f = fo.getFolioActual();
        foc = fo.getIdFolios() + " - " + "00000" + f;
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
                var pag = p.charAt(41);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function mesg(val, ico, au) {
                var m = "";
                switch (val) {
                    case 0:
                        m = '<%=menValores%>';
                        break;
                    case 1:
                        m = '<%=invalf%>';
                        break;
                    case 2:
                        m = '<%=msgok%>';
                        break;
                    case 3:
                        m = '<%=Notfoli%>';
                        break;
                    case 4:
                        m = "Material " + '<%=MateAl%>';
                        break;
                    case 5:
                        m = '<%=NotExistda%>';
                        break;
                    case 6:
                        m = '<%=MateiNonob%>';
                        break;
                    case 7:
                        m = '<%=CSPoblcant%>';
                        break;
                    case 8:
                        m = '<%=CSPercan%>';
                        break;
                    case 9:
                        m = '<%=UserNotmod%>';
                        break;
                    case 10:
                        m = '<%=modifire%>';
                        break;
                    case 11:
                        m = "se puede modificar";
                        break;
                    case 12:
                        m = "No se puede modificar";
                }
                var BE = document.createElement('audio');
                BE.src = au;
                BE.play();
                $('#iconmsg').attr('src', ico);
                $('#iconmsg').show();
                $('#msg').html(m);
            }

        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <link rel="stylesheet" href="css/StyleReservas.css">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/ModificarReservas.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <title><%out.println(po.getProperty("etiqueta.RESModre_Title"));%></title>
    </head>
    <body>
        <div id="main-header">
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                    </li>
                </ul>
                <div hidden>
                    <input type="tetx" id="errin" maxlength="1" />
                    <input type="tetx" id="reciin" maxlength="1" />
                    <input type="tetx" id="procin" maxlength="1" />
                    <input type="text" id="us1" value="<%=Nombre%>">
                    <input type="text" id="us2">
                </div>    
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png" onclick="validarSAM();"/>
            <input type="image" src="images/guardaOFF.png" id="guarda" onclick="valorMate();" disabled/>
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/> 
            <input id="modificar" type="image" src="images/Editar.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.RESModre_Title"));%></h1></div>
        </div>
        <div class="contenido">
            <div id="VisualizarReserva" hidden></div>
            <div id="Cont" hidden></div>
            <div class="ContentReservas">
                <section class="DivBusquedaSAMReservas">
                    <label><%out.println(po.getProperty("etiqueta.RESERBusuqedti"));%></label>
                    <hr id="LineaTituloRev">
                    <section class="DivIzquierda">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input maxlength="10" id="samr" type="text" onpaste="return false"  style="width: 40%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;" focus/><button id="match_sam" class='BtnMatchIcon2'></button>
                        <hr>
                        <input type="image" style="float:left;"id="lerrim" src = "images/advertencia.PNG" value="" hidden/><label id="laberr"></label>
                        <br>
                    </section>
                </section>
                <section class="DivReserva">
                    <label id="lblTitulo_reporte" style="width: 100%;"><%out.println(po.getProperty("etiqueta.RERSETitleData"));%></label>
                    <hr id="LineaTituloRev">
                    <section class="DivIzquierda">
                        <label><%out.println(po.getProperty("etiqueta.GralCentroAll"));%></label><input disabled id="centro" type="text" onpaste="return false"  maxlength="4" style="width: 13%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_CC" class='BtnMatchIcon2'></button>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralAlmacenAll"));%></label><input disabled id="Almacen" type="text" maxlength="4" style="width: 13%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_CA" class='BtnMatchIcon2'></button>
                        <hr>
                        <label style="width: 26%;"><%out.println(po.getProperty("etiqueta.PedidoClMovPEd"));%></label><input disabled id="ClaseMov" maxlength="3" type="text" style="width: 9%; background-repeat: no-repeat; background-position-x: -2%;"/><label style="width: 41%; margin-left: 2%;"><%out.println(po.getProperty("etiqueta.RES201CenCos"));%></label>
                        <label style="width: 41%; margin-left: 37.5%;"><%out.println(po.getProperty("etiqueta.RES261OrdeIn"));%></label>
                        <label style="width: 41%; margin-left: 37.5%;"><%out.println(po.getProperty("etiqueta.RES311AlmRec"));%></label>
                        <br>
                    </section>
                    <section class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESConImp"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESCCosto"));%></label><input disabled id="centroco" maxlength="10" type="text" style="width: 35%; margin-left: -8%; text-transform: uppercase; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_CO" class='BtnMatchIcon2'></button><label style="width: 1%; margin-left: 4%;"><%out.println(po.getProperty("etiqueta.RESOTRO"));%> </label>
                            <hr>
                        </section>
                        <section class="DerechaInterno">
                            <label style='margin-left: 4%;'><%out.println(po.getProperty("etiqueta.RESOrdenin"));%></label><input disabled id="orden" type="text" maxlength="12" style="width: 35%; text-transform: uppercase; margin-left: -12%; background-repeat: no-repeat; background-position-x: -2%;"/><button id="match_OI" class='BtnMatchIcon2'></button>
                            <hr>
                        </section>
                    </section>
                    <section style="margin-top:0.5%;" class="DivDerecha">
                        <label style="width: 100%;"><%out.println(po.getProperty("etiqueta.RESMov311"));%></label>
                        <hr id="LineaTituloIm">
                        <section class="IzquierdaInterno">
                            <label><%out.println(po.getProperty("etiqueta.RESAlmRe"));%></label><input id="Arece" type="text" maxlength="12" style="width: 25%; text-transform: uppercase; margin-left: -8%; background-repeat: no-repeat; background-position-x: -2%;" disabled/>
                            <hr>
                        </section>        
                    </section> 
                </section>

                <section id="TablaStatus" class="TablaStatusC">
                    <table class="tablaCont" id="TablaReservas">
                        <tbody>
                            <tr id="CabeceraTabla">
                                <td></td>
                                <td><%out.println(po.getProperty("etiqueta.GralMaterialAll"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.RESCantNe"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.STOCKUnidadMedid"));%></td>
                                <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="CargarOperaciones">
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                            <tr><td><input type="checkbox" disabled style="size: 100%;" name="posicion" value=" "></td><td><input type="text" name="material" id="material" disabled style="text-transform: uppercase;"></td><td><input type="number" min="1" name="cantidad" disabled id="cantidad"></td><td><input type="text" name="unidadmedida" disabled id="unidadmedida"/></td><td style="width: 40%;"><input name="descripcion" id="descripcion" disabled style="width: 100%; text-transform: uppercase;"/></td></tr>
                        </tbody>                                    
                    </table>
                </section>
                <section class='botonefil'><button id="btnAdd" ></button><button id="btnDelete"></button></section>
            </div>
        </div>
        <div id="VentanaModalFolioSAM" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('sam');"><label>X</label></div></div>
            <div class="PanelBntMatch"><button onclick="cambiarot()">Folio</button><hr></div>
            <div id="BuscarParam_sam" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></label><input type="text" id="FolSAm" style="width:35%; text-transform: uppercase;" maxlength="10"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input type="date" id="FecSAm" style="width:35%; text-transform: uppercase;" maxlength="10"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type='text' id="numAcMaxFS"  value="500" style="width:10%;" maxlength='3'/>
                        <hr>
                    </div>                
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkFolioSAM" onclick="ConsultaMatchFolioSAM()"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('sam');"/>
                </div>
            </div>
            <div id="ConsultaTablasam" style="display: none;">
                <div class="tablaCab">
                    <div id="table-scroll" class="table-scroll">
                        <div id="fixedY" class="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFolioSAM"));%></th><th><%out.println(po.getProperty("etiqueta.GralFecha"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="CargarDatosSAM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('material');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button onclick="camMATChpri()"><%out.println(po.getProperty("etiqueta.BuscarMaterial_MAT"));%></button><hr></div>
            <div id="BuscarParam_m" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%=material%></label><input type="text" id="material_ma" style="width:35%; text-transform: uppercase;" maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></label><input type="text" id="texto_mate" maxlength="40" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%=centro%></label><input type="text" id="centrito" style="width:10%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%=MaterialType%></label><input type="text" id="TImat" style="width:10%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax5"   style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="OkMaterial"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('material');"/>
                </div>
            </div>
            <div id="ConsultaTablam" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollm">
                        <div class="fixedY" id="fixedYm">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%=material%></th><th><%out.println(po.getProperty("etiqueta.centromatch"));%></th><th><%out.println(po.getProperty("etiqueta.Descripcion_MAT"));%></th><th><%=MaterialType%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedXM" id="CargarDatosm">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>                     
        <footer>
            <hr class="fecha" id="footerline">
            <div hidden>
                <input type="text" id="feres"/>
                <input type="text" id="hores"/>
            </div>
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
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        var fre = f.getFullYear() + "-" + meses2[f.getMonth()] + "-" + f.getDate();
                        document.getElementById('fecha').innerHTML = fechaActual;
                        document.getElementById("feres").value = fre;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
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

