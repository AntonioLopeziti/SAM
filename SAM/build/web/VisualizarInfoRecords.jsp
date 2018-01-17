<%-- 
   Document   : VisualizarInfoRecords
   Created on : 21/06/2016, 02:43:24 PM
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
        String ConOK = po.getProperty("etiqueta.ConOk_FO");
        String CamReq = po.getProperty("etiqueta.CamReq_INFO");
        String NoRegEn = po.getProperty("etiqueta.NoRegEn_INFO");
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
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleInfoRecord.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/VisualizarIinfoRecord.js"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloVisualizaInfoRecord_info"));%></title>           
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
            <input id="aceptar" type="image" src="images/aceptar.png" onclick="validar();"/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png"/>               
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" src="images/canceOFF.png" disabled/>
            <input  id="cancelar"type="image" src="images/cancelaOFF.png" disabled/>      
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloVisualizaInfoRecord_info"));%></h1></div> 
        </div>
        <div class="contenido">
            <section class="VisualInfoRecord_info">
                <section class="ParametrosBusqueda_info">
                    <label style="width:100%;"><%out.println(po.getProperty("etiqueta.ParametrosBusquda_info"));%></label>
                    <hr id="LineaTituloInfo">
                    <section class="ParamIzq_info">
                        <label style="width:100%;"><%out.println(po.getProperty("etiqueta.TitPorInfoRecord_info"));%></label>
                        <hr id="LineaTituloInfo">
                        <span><label style="margin-top: 15%;"><%out.println(po.getProperty("etiqueta.RegistroInfo_info"));%></label><input type="text" id="info_IR" maxlength="10" style="width:45%; background-repeat: no-repeat; "/><button id="Match_I1" class='BtnMatchIcon'></button>
                            <hr id="LineaRegInfo_inf">
                        </span>
                    </section>
                    <section class="ParamDer_info">
                        <label style="width: 80%;"><%out.println(po.getProperty("etiqueta.PorDatosMaest_info"));%></label>
                        <hr id="LineaTituloInfo">
                        <label><%out.println(po.getProperty("etiqueta.Material_info"));%></label><input type="text" id="material_IR" value="" maxlength="40" style="width:50%; background-repeat:no-repeat;"/><button id="Match_I2" class='BtnMatchIcon'></button>
                        <hr id="lineaParamDer_info">
                        <label><%out.println(po.getProperty("etiqueta.Provedor_info"));%></label><input type="text" id="proveedor_IR" value="" maxlength="10" style="  width: 15%; background-repeat: no-repeat; "/><button id="Match_I3" class='BtnMatchIcon'></button> <input type="text" style="width:45%; border: none;" id="nombrePro_IR" readonly/>
                        <hr id="lineaParamDer_info">
                        <label><%out.println(po.getProperty("etiqueta.OrgaComp_info"));%></label><input type="text" id="orgCompras_IR" value=""  maxlength="4" style="width:10%; text-transform: uppercase; background-repeat: no-repeat;"/><button id="Match_I4" class='BtnMatchIcon'></button>
                        <hr id="lineaParamDer_info">
                        <label><%out.println(po.getProperty("etiqueta.Tipoinfo_info"));%></label><input type="text" id="Infotipo_IR" value=""  maxlength="1" style="width:5%; background-repeat: no-repeat;"/><button id="Match_I5" class="BtnMatchIcon"></button>
                        <hr id="lineaParamDer_info">
                        <label><%out.println(po.getProperty("etiqueta.Centro_info"));%></label><input type="text" id="centro_IR" value=""  maxlength="4" style="width:10%; text-transform: uppercase; background-repeat: no-repeat"/><button id="Match_I6" class='BtnMatchIcon'></button>
                        <hr id="lineaParamDer_info">
                    </section>
                </section>
                <section class="DatosBasicComp_info">
                    <label style=""><%out.println(po.getProperty("etiqueta.DatosBasicoCom_info"));%></label>
                    <hr id="LineaTituloInfo">
                    <section class="BasicoComp1_info">
                        <label><%out.println(po.getProperty("etiqueta.GrupoArtculos_info"));%></label><input id="GrupoArticulos_IR" type="text" style="width: 25%;" value="" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GrupoCompras_info"));%></label><input id="GrupoCompras_IR" type="text" style="width: 10%;" value="" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.PlazEntrPrev_info"));%></label><input id="PlazaEntr_IR" type="text" style="width: 10%;" value="0" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NumMatPro_info"));%></label><input id="NumMatPro_IR" type="text" style="width: 40%;" value="" disabled/>
                        <hr>
                    </section>
                    <section class="BasicoComp2_info">
                        <label><%out.println(po.getProperty("etiqueta.CantStandar_info"));%></label><input id="CantidadStandar_IR" type="text" style="width:30%;" value="0.000" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxima_info"));%></label><input id="CantidadMaxima_IR" type="text" style="width:30%;" value="0.000" disabled/>
                        <hr>
                    </section>
                    <section class="BasicoComp3_info">
                        <label><%out.println(po.getProperty("etiqueta.SinTextoMat_info"));%></label><input id="SinText_IR" type="text" style="width:10%;" value="" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.IndObligConFped_info"));%></label><input id="IndObl_IR" type="text" style="width:10%;" value="" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.TolSumIncom_info"));%></label><input id="TolSumImc_IR" type="text" style="width: 18%;" value="0.0" disabled/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Tolecsum_info"));%></label><input id="TolecSum_IR" type="text" style="width:18%;" value="0.0" disabled/>
                        <hr>
                    </section>
                </section>
                <section class="Convers_info">
                    <label style=""><%out.println(po.getProperty("etiqueta.Conversion_info"));%></label>
                    <hr id="LineaTituloInfo">
                    <section class="ConverCompl_info">
                        <label><%out.println(po.getProperty("etiqueta.CntUniMedPed_info"));%></label><input id="CantUniMedPed_IR" value="0" type="text" style="width:15%;" disabled/><input id="CantUniMedPed2_IR" value="" type="text" style="width:10%; margin-left: 1px;" disabled/>
                        <hr>                                    
                    </section>
                    <section class="ConverCompl2_info">
                        <label><%out.println(po.getProperty("etiqueta.CntUniMeBase_info"));%></label><input id="CantUniMedBase_IR" value="" type="text" style="width:15%" disabled/><input id="CantUniMedBase2_IR" value="" type="text" style="width:10%; margin-left: 1px;" disabled/>
                    </section>
                </section>
                <section class="SecPrecio_info">
                    <label><%out.println(po.getProperty("etiqueta.Precio_info"));%></label>
                    <hr id="LineaTituloInfo">
                    <section class="PreciDer_info">
                        <label style="width:25%; display: inline-block;"><%out.println(po.getProperty("etiqueta.PrecioNeto_info"));%></label><input id="PrecioNeto_IR" value="0.00" type="text" style="width:15%;" disabled/><input id="ClaveMoneda_IR" value="" type="text" style="width:10%; margin-left: 1px" disabled/><label style="margin-left:6%;"><%out.println(po.getProperty("etiqueta.Por_info"));%></label><input id="CntBase_IR" value="0" type="text" style="width:15%; margin-left: 3%;" disabled/><input id="CntBase2_IR" value type="text" style="width:10%; margin-left:1px;" disabled/>
                        <hr style="width:25%; margin-top: -1px; margin-left: 0;">
                    </section>
                    <section class="PreciDer1_info">
                        <label><%out.println(po.getProperty("etiqueta.IndImpuest_info"));%></label><input id="IVA_IR" value="" type="text" style="width:8%; margin-left: 5%;" disabled/>
                        <hr>
                    </section>
                </section>
            </section>
        </div>
        <div id="VentanaModalRegistro" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.TituloMatch1_INFO"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('registroinfo');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltoinfo"><%out.println(po.getProperty("etiqueta.RegistroInfo_INFO"));%></button><hr></div>
            <div id="BuscarParamIR_reg" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.RegistroInfo_info"));%></label><input type="text" id="registro1_reg" maxlength="10" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Provedor_info"));%></label><input type="text" id="Proveedor1_reg" maxlength="10" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Material_info"));%></label><input type="text" id="Material1_reg" maxlength="40" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.RegistroInfotipo_INFO"));%></label><input type="text" id="TipoReg1_reg" maxlength="1" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.OrgaCompras_INFO"));%></label><input type="text" id="OrgCompre1_reg" maxlength="4" style="width:35%; text-transform: uppercase;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CentroInfo_INFO"));%></label><input type="text" id="Centroeg1_reg" style="width:35%; text-transform: uppercase;" maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax" maxlength="3" style="width:10%;"/>
                        <hr>
                    </div> 
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okregistroinfo"/>                  
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('registroinfo');"/>
                </div>
            </div> 
            <div id="ConsultaTabla" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll">
                        <div class="fixedY" id="fixedY">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.RegistroInfo_info"));%></th><th><%out.println(po.getProperty("etiqueta.Material_info"));%></th><th><%out.println(po.getProperty("etiqueta.Provedor_info"));%></th>                                                                           </tr>
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
        <div id="VentanaModalMaterial" class="VentanaModal">
            <div id="handle2"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.nUMMaterial_info"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('Material');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornmateinfo"><%out.println(po.getProperty("etiqueta.nUMTextoMaterial_info"));%></button><hr></div>
            <div id="BuscarParamMate_reg" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Material_info"));%></label><input type="text" id="MaterialMatch_reg" style="width:35%;"  maxlength="40"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.TextoBreveMat_info"));%></label><input type="text" id="textoMateMatch_reg" style="width:35%;" maxlength="40"/>
                        <hr>                        
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax2"   style="width:10%;" maxlength="3"/>
                        <hr>
                    </div> 
                </div>
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okMaterial"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('Material');"/>
                </div>
            </div> 
            <div id="ConsultaTabla2" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollMaterial_reg">
                        <div class="fixedY" id="fixedYMaterial_reg">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Material_info"));%></th><th><%out.println(po.getProperty("etiqueta.TextoBreveMat_info"));%></th>
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

        <div id="VentanaModalProveedor" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('proveedor');"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornfiltprovin"><%out.println(po.getProperty("etiqueta.ProvedoresGral_matchPro"));%></button><hr></div>
            <div id="BuscarParam_Prov" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></label><input type="text" id="NombreproveedorMatch_reg" maxlength="35" style="width:35%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></label><input type="text" id="ProveedorMacth_reg" maxlength="10" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax3"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer" id="okProveedor"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" onclick="ocultarVentana('proveedor');"/>
                </div>
            </div>
            <div id="ConsultaTabla3" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollProveedor_reg">
                        <div class="fixedY" id="fixedYProveedor_reg">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Prpve_ProMatch"));%></th><th><%out.println(po.getProperty("etiqueta.NombreProv_mathPro"));%></th>
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

        <div id="VentanaModalOrgCompras" class="VentanaModal">
            <div id="handle4"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('compras')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornorgcin"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_OC" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></label><input type="text" id="OrgComMatch_reg" style="width:35%; text-transform: uppercase;"  maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Denominacioncomp_mathPro"));%></label><input type="text" maxlength="20" id="DenomOrgMatch_reg" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax4" style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okOrgaCom"/>                    
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('compras');"/>
                </div>
            </div>
            <div id="ConsultaTabla4" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll4">
                        <div class="fixedY" id="fixedY4">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.OrganizaCompras_matchPro"));%></th><th><%out.println(po.getProperty("etiqueta.Denomina_CL"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos4">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="VentanaModalInfoTipo" class="VentanaModal">
            <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('infotipo')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retornarinfotipo"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_InfoTipo" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.Tipoinfor_info"));%></label><input type="text" id="infotipoMatch_reg" style="width:35%;" maxlength="1" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.Descr_info"));%></label><input type="text" id="DesTipoinfoMatch_reg" style="width:35%;" maxlength="60"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text" id="numAcMax5"   style="width:10%;"  maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okInfoTipo"/>                    
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('infotipo');"/>
                </div>
            </div>
            <div id="ConsultaTabla5" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll5">
                        <div class="fixedY" id="fixedY5">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Tipoinfor_info"));%></th><th><%out.println(po.getProperty("etiqueta.Descr_info"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos5">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        

        <div id="VentanaModalCentro" class="VentanaModal">
            <div id="handle6"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('centro')"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retorncenin"><%out.println(po.getProperty("etiqueta.Restriciones_CL"));%></button><hr></div>
            <div id="BuscarParam_Centro" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">
                        <label><%out.println(po.getProperty("etiqueta.CentroMatch_info"));%></label><input type="text" id="CentroMatch_reg" style="width:35%; text-transform: uppercase;"  maxlength="4"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.NombreMatch_info"));%></label><input type="text" id="NCentroMatch_reg" style="width:35%;" maxlength="30"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input type="text"  id="numAcMax6"  style="width:10%;" maxlength="3"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor: pointer;" id="okCentro"/>                   
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor: pointer;" onclick="ocultarVentana('centro');"/>
                </div>
            </div>
            <div id="ConsultaTabla6" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scroll6">
                        <div class="fixedY" id="fixedY6">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_Centro"));%></th>
                                        <th><%out.println(po.getProperty("etiqueta.Reporte_Descripcion"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatos6">
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
<!--                <script type="text/javascript">
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
                        bloq();
                    };

                    function bloq() {
                        document.getElementById('iconmsg').style.visibility = "hidden";
                        document.getElementById('guardar').disabled = true;
                    }

                </script>-->
            </div>
        </footer>
    </body>
    <script>
        function inval() {

            //error
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/advertencia.PNG";
            var men = document.getElementById("msg");
            men.innerHTML = '<%=MenInval%>';
        }
        function back() {
            window.location.href = "Bienvenido.jsp";
        }
        function mostrarVentanaModal(tipo) {
            switch (tipo) {
                case "registroinfo":
                    var ventana = document.getElementById('VentanaModalRegistro');
                    abrirVentana(ventana);
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    var r = document.getElementById("registro1_reg");
                    document.getElementById("Proveedor1_reg").value = '';
                    document.getElementById("Material1_reg").value = '';
                    document.getElementById("TipoReg1_reg").value = '';
                    document.getElementById("OrgCompre1_reg").value = '';
                    document.getElementById("Centroeg1_reg").value = '';
                    document.getElementById("numAcMax").value = '500';
                    r.value = '';
                    r.focus();
                    break;
                case "Material":
                    var ventana2 = document.getElementById('VentanaModalMaterial');
                    abrirVentana(ventana2);
                    var txtmat = document.getElementById('MaterialMatch_reg');
                    document.getElementById('textoMateMatch_reg').value = '';
                    document.getElementById('numAcMax2').value = '500';
                    txtmat.focus();
                    txtmat.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case "proveedor":
                    var ventana3 = document.getElementById('VentanaModalProveedor');
                    abrirVentana(ventana3);
                    var txtpro = document.getElementById('NombreproveedorMatch_reg');
                    document.getElementById('ProveedorMacth_reg').value = '';
                    document.getElementById('numAcMax3').value = '500';
                    txtpro.focus();
                    txtpro.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case "compras":
                    var ventana4 = document.getElementById('VentanaModalOrgCompras');
                    abrirVentana(ventana4);
                    var txtorg = document.getElementById('OrgComMatch_reg');
                    document.getElementById('OrgComMatch_reg').value = '';
                    document.getElementById('numAcMax4').value = '500';
                    txtorg.focus();
                    txtorg.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case "infotipo":
                    var ventana5 = document.getElementById("VentanaModalInfoTipo");
                    abrirVentana(ventana5);
                    var txtit = document.getElementById("infotipoMatch_reg");
                    document.getElementById("DesTipoinfoMatch_reg").value = '';
                    document.getElementById("numAcMax5").value = '500';
                    txtit.focus();
                    txtit.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                case "centro":
                    var ventana6 = document.getElementById('VentanaModalCentro');
                    abrirVentana(ventana6);
                    var txtcen = document.getElementById('CentroMatch_reg');
                    document.getElementById('NCentroMatch_reg').value = '';
                    document.getElementById('numAcMax6').value = '500';
                    txtcen.focus();
                    txtcen.value = '';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "hidden";
                    var men = document.getElementById("msg");
                    men.innerHTML = "";
                    break;
                default:
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
        function ocultarVentana(tipo) {
            $('#overlay').remove();
            switch (tipo) {
                case "registroinfo":
                    document.getElementById("VentanaModalRegistro").style.display = 'none';
                    document.getElementById("BuscarParamIR_reg").style.display = 'block';
                    document.getElementById("ConsultaTabla").style.display = 'none';
                    document.getElementById("info_IR").focus();
                    break;
                case "Material":
                    document.getElementById("VentanaModalMaterial").style.display = 'none';
                    document.getElementById("BuscarParamMate_reg").style.display = 'block';
                    document.getElementById("ConsultaTabla2").style.display = 'none';
                    document.getElementById("material_IR").focus();
                    break;
                case "proveedor":
                    document.getElementById("VentanaModalProveedor").style.display = 'none';
                    document.getElementById("BuscarParam_Prov").style.display = 'block';
                    document.getElementById("ConsultaTabla3").style.display = 'none';
                    document.getElementById("proveedor_IR").focus();
                    break;
                case "compras":
                    document.getElementById("VentanaModalOrgCompras").style.display = 'none';
                    document.getElementById("BuscarParam_OC").style.display = 'block';
                    document.getElementById("ConsultaTabla4").style.display = 'none';
                    document.getElementById("orgCompras_IR").focus();
                    break;
                case "infotipo":
                    document.getElementById("VentanaModalInfoTipo").style.display = 'none';
                    document.getElementById("BuscarParam_InfoTipo").style.display = 'block';
                    document.getElementById("ConsultaTabla5").style.display = 'none';
                    document.getElementById("Infotipo_IR").focus();
                    break;
                case "centro":
                    document.getElementById("VentanaModalCentro").style.display = 'none';
                    document.getElementById("BuscarParam_Centro").style.display = 'block';
                    document.getElementById("ConsultaTabla6").style.display = 'none';
                    document.getElementById("centro_IR").focus();
                    break;
                default:
                    break;
            }
        }
        function datosincorrectos() {
            //MEnsaje de correcto
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
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
        function validar() {
            var infor = document.getElementById("info_IR").value;
            var mate = document.getElementById("material_IR").value;
            var prov = document.getElementById("proveedor_IR").value;
            var org = document.getElementById("orgCompras_IR").value;
            var tipo = document.getElementById("Infotipo_IR").value;
            var cen = document.getElementById("centro_IR").value;
            if (!infor.length < 1) {
                EnviarDatosInfo(infor);
            } else {
                if (!(mate.length < 1 || prov.length < 1 || org.length < 1 || tipo.length < 1 || cen.length < 1)) {
                    EnviarDatosInfo2(infor, mate, prov, org, tipo, cen);
                } else {

                    var okcon = '<%=CamReq%>';
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/aceptar.png";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    dataFocus();
                }
            }
        }
        function dataFocus() {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();


            var temp = new Array();
            temp[0] = document.getElementById("info_IR");
            temp[1] = document.getElementById("material_IR");
            temp[2] = document.getElementById("proveedor_IR");
            temp[3] = document.getElementById("orgCompras_IR");
            temp[4] = document.getElementById("Infotipo_IR");
            temp[5] = document.getElementById("centro_IR");

            for (i = 0; i < temp.length; i++)
            {
                if (temp[i].value.length === 0)
                {
                    temp[i].focus();
                    return;
                }
            }
        }



        function EnviarDatosInfo(info) {
            //alert(info);
            var url = "peticionVisualizarInfoRecord";
            var acc = "ValidarRegistro";
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    if (rs == 0) {

                        //error
                        var BE = document.createElement('audio');
                        BE.src = "audio/saperror.wav";
                        BE.play();

                        var okcon = '<%=NoRegEn%>' + info;
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    } else {
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        cargarDatosinfo(rs);
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + "&info=" + info, true);
            xmlhttp.send();
        }
        function EnviarDatosInfo2(infor, mate, prov, org, tipo, cen) {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ValidarRegistroDM";
            var datos = "&mate=" + mate + "&prov=" + prov + "&comp=" + org + "&tipo=" + tipo + "&cent=" + cen;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    var rs = xmlhttp.responseText;
                    if (rs == 0) {
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        var okcon = '<%=NoRegEn%>' + infor;
                        var iconm = document.getElementById("iconmsg");
                        iconm.style.visibility = "visible";
                        iconm.src = "images/advertencia.PNG";
                        var men = document.getElementById("msg");
                        men.innerHTML = okcon;
                    } else {
                        cargarDatosinfo(rs);
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos, true);
            xmlhttp.send();
        }
        function datosobligatorios2() {
            $('#info_IR').css("background-image", "none");
            $('#material_IR').css("background-image", "none");
            $('#proveedor_IR').css("background-image", "none");
            $('#orgCompras_IR').css("background-image", "none");
            $('#Infotipo_IR').css("background-image", "none");
            $('#centro_IR').css("background-image", "none");
        }
        function cargarDatosinfo(rs) {
            datosobligatorios2();
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
            var okcon = "<%=ConOK%>";
            var iconm = document.getElementById("iconmsg");
            iconm.style.visibility = "visible";
            iconm.src = "images/aceptar.png";
            var men = document.getElementById("msg");
            men.innerHTML = okcon;
            var a = new Array();
            a = rs.split(",");
            document.getElementById("info_IR").value = a[0];
            document.getElementById("material_IR").value = a[1];
            document.getElementById("proveedor_IR").value = a[2];
            document.getElementById("nombrePro_IR").value = a[3];
            document.getElementById("orgCompras_IR").value = a[4];
            document.getElementById("Infotipo_IR").value = a[5];
            document.getElementById("centro_IR").value = a[6];
            document.getElementById("GrupoArticulos_IR").value = a[7];
            document.getElementById("GrupoCompras_IR").value = a[8];
            document.getElementById("PlazaEntr_IR").value = a[9];
            document.getElementById("NumMatPro_IR").value = a[10];
            document.getElementById("CantidadStandar_IR").value = a[11];
            document.getElementById("CantidadMaxima_IR").value = a[12];
            document.getElementById("SinText_IR").value = a[13];
            document.getElementById("IndObl_IR").value = a[14];
            document.getElementById("TolSumImc_IR").value = a[15];
            document.getElementById("TolecSum_IR").value = a[16];
            document.getElementById("CantUniMedPed_IR").value = a[17];
            document.getElementById("CantUniMedPed2_IR").value = a[18];
            document.getElementById("CantUniMedBase_IR").value = a[19];
            document.getElementById("CantUniMedBase2_IR").value = a[20];
            document.getElementById("PrecioNeto_IR").value = a[21];
            document.getElementById("ClaveMoneda_IR").value = a[22];
            document.getElementById("CntBase_IR").value = a[23];
            document.getElementById("CntBase2_IR").value = a[24];
            document.getElementById("IVA_IR").value = a[25];
        }
        function ConsultarInfo() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchInfo";
            var info = document.getElementById('registro1_reg').value;
            var prov = document.getElementById('Proveedor1_reg').value;
            var mate = document.getElementById("Material1_reg").value;
            var tipo = document.getElementById("TipoReg1_reg").value;
            var comp = document.getElementById("OrgCompre1_reg").value;
            var cent = document.getElementById("Centroeg1_reg").value;
            var cant = document.getElementById('numAcMax').value;
            var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = datos + "&comp=" + comp + "&cent=" + cent + "&cant=" + cant;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParamIR_reg").style.display = "none";
                        document.getElementById("ConsultaTabla").style.display = "block";
                        document.getElementById("cargarDatos1").innerHTML = rs;
                        fnc();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }
        function ConsultarMaterial() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchMaterial";
            var idioma = '<%=Idioma%>';
            var mat = document.getElementById('MaterialMatch_reg').value;
            var texto = document.getElementById('textoMateMatch_reg').value;
            var cant = document.getElementById('numAcMax2').value;
            //var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = "&mate=" + mat + "&texto=" + texto + "&cant=" + cant + "&idioma=" + idioma;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParamMate_reg").style.display = "none";
                        document.getElementById("ConsultaTabla2").style.display = "block";
                        document.getElementById("cargarDatos2").innerHTML = rs;
                        fnc2();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }
        function ConsultarProveedor() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchProveedor";
            var nomPro = document.getElementById('NombreproveedorMatch_reg').value;
            var Acreedor = document.getElementById('ProveedorMacth_reg').value;
            var cant = document.getElementById('numAcMax3').value;
            //var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = "&prov=" + Acreedor + "&nprov=" + nomPro + "&cant=" + cant;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParam_Prov").style.display = "none";
                        document.getElementById("ConsultaTabla3").style.display = "block";
                        document.getElementById("cargarDatos3").innerHTML = rs;
                        fnc3();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }
        function ConsultarOrganizacion() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchOrganizacion";
            var idioma = '<%=Idioma%>';
            var org = document.getElementById('OrgComMatch_reg').value;
            var den = document.getElementById('DenomOrgMatch_reg').value;
            var cant = document.getElementById('numAcMax4').value;
            //var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = "&comp=" + org + "&den=" + den + "&cant=" + cant + "&idioma=" + idioma;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParam_OC").style.display = "none";
                        document.getElementById("ConsultaTabla4").style.display = "block";
                        document.getElementById("cargarDatos4").innerHTML = rs;
                        fnc4();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }
        function ConsultarInfoTipo() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchInfoTipo";
            var idioma = '<%=Idioma%>';
            var infotipo = document.getElementById('infotipoMatch_reg').value;
            var desinfo = document.getElementById('DesTipoinfoMatch_reg').value;
            var cant = document.getElementById('numAcMax5').value;
            //var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = "&tipo=" + infotipo + "&Dtipo=" + desinfo + "&cant=" + cant + "&idioma=" + idioma;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParam_InfoTipo").style.display = "none";
                        document.getElementById("ConsultaTabla5").style.display = "block";
                        document.getElementById("cargarDatos5").innerHTML = rs;
                        fnc5();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }
        function ConsultarCentro() {
            var url = "peticionVisualizarInfoRecord";
            var acc = "ConsultaMatchCentro";
            // var idioma = '<%=Idioma%>';
            var cen = document.getElementById('CentroMatch_reg').value;
            var ncen = document.getElementById('DenomOrgMatch_reg').value;
            var cant = document.getElementById('numAcMax6').value;
            //var datos = "&info=" + info + "&prov=" + prov + "&mate=" + mate + "&tipo=" + tipo;
            var datos2 = "&cent=" + cen + "&ncen=" + ncen + "&cant=" + cant;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                    rs = xmlhttp.responseText;
                    if (rs == 0) {
                        datosincorrectos();
                    } else {
                        document.getElementById("BuscarParam_Centro").style.display = "none";
                        document.getElementById("ConsultaTabla6").style.display = "block";
                        document.getElementById("cargarDatos6").innerHTML = rs;
                        fnc6();
                        borrarmsg();
                    }
                }
            };
            xmlhttp.open("GET", url + "?acc=" + acc + datos2, true);
            xmlhttp.send();
        }

        function seleccionar(tipo, obj) {
            switch (tipo) {
                case "registro":
                    ocultarVentana('registroinfo');
                    var re = document.getElementById("info_IR");
                    re.value = obj;
                    re.focus();
                    break;
                case "Material":
                    ocultarVentana('Material');
                    var mat = document.getElementById("material_IR");
                    mat.value = obj;
                    mat.focus();
                    break;
                case "proveedor":
                    ocultarVentana('proveedor');
                    var pr = document.getElementById("proveedor_IR");
                    pr.value = obj;
                    pr.focus();
                    break;
                case "compras":
                    ocultarVentana('compras');
                    var org = document.getElementById("orgCompras_IR");
                    org.value = obj;
                    org.focus();
                    break;
                case "infotipo":
                    ocultarVentana('infotipo');
                    var it = document.getElementById("Infotipo_IR");
                    it.value = obj;
                    it.focus();
                    break;
                case "centro":
                    ocultarVentana('centro');
                    var cen = document.getElementById("centro_IR");
                    cen.value = obj;
                    cen.focus();
                    break;
            }
        }
        function fnc() {
            document.getElementById('table-scroll').onscroll = function () {
                document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
            };
        }
        function fnc2() {
            document.getElementById('table-scrollMaterial_reg').onscroll = function () {
                document.getElementById('fixedYMaterial_reg').style.top = document.getElementById('table-scrollMaterial_reg').scrollTop + 'px';
            };
        }
        function fnc3() {
            document.getElementById('table-scrollProveedor_reg').onscroll = function () {
                document.getElementById('fixedYProveedor_reg').style.top = document.getElementById('table-scrollProveedor_reg').scrollTop + 'px';
            };
        }
        function fnc4() {
            document.getElementById('table-scroll4').onscroll = function () {
                document.getElementById('fixedY4').style.top = document.getElementById('table-scroll4').scrollTop + 'px';
            };
        }
        function fnc5() {
            document.getElementById('table-scroll5').onscroll = function () {
                document.getElementById('fixedY5').style.top = document.getElementById('table-scroll5').scrollTop + 'px';
            };
        }
        function fnc6() {
            document.getElementById('table-scroll6').onscroll = function () {
                document.getElementById('fixedY6').style.top = document.getElementById('table-scroll6').scrollTop + 'px';
            };
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>

