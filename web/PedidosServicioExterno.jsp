<%-- 
    Document   : PedidosServicioExterno
    Created on : 19-sep-2016, 9:56:09
--%>
<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
<%@page import="AccesoDatos.ACC_PedidoServicios"%>
<%@page import="AccesoDatos.ACC_EntradaServiciosCrea"%>
<%@page import="Entidades.pedido_servicios"%>
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
        String pednot = po.getProperty("etiqueta.ESEntradaSerErr2");
        String Oblped = po.getProperty("etiqueta.ESEntradaSerErr1");
        String pedlib = po.getProperty("etiqueta.ESEntradaSerErr3");
        String selec = po.getProperty("etiqueta.ESEntradaSeleSer");
        String CanRe = po.getProperty("etiqueta.ESEntradaCantOl");
        String Can2d = po.getProperty("etiqueta.ESEntradaCantO2");
        String DesObli = po.getProperty("etiqueta.ESEntradaDesc");
        String CantSup = po.getProperty("etiqueta.ESEntradaCantSup");
        String Erroin = po.getProperty("etiqueta.ESEntradaErrIns");
        String DocCont = po.getProperty("etiqueta.ESEntradaDocCont");
        String Cantped = po.getProperty("etiqueta.ESEntradaErrped");
        String pedhist = po.getProperty("etiqueta.ESEntradaErrpedHi");
        String pedpos = po.getProperty("etiqueta.ESEntradPedidpos");
        String CaliOb = po.getProperty("etiqueta.ESEntradaCaliOb");
        String PlaOb = po.getProperty("etiqueta.ESEntradaPlazOb");
        String ESEntradaExtNoAll = po.getProperty("etiqueta.ESEntradaExtNoAll");
        String ESEntradatablvaciaArc = po.getProperty("etiqueta.ESEntradatablvaciaArc");
        String ESEntradaArchAdj = po.getProperty("etiqueta.ESEntradaArchAdj");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
        String reso = po.getProperty("etiqueta.Resolucio");
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
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
                var pag = p.charAt(44);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();            
            function ShowMsg(m, im, au, mn) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=menValores%>';
                        break;
                    case 2:
                        msg = '<%=Oblped%>';
                        break;
                    case 3:
                        msg = '<%=pednot%>';
                        break;
                    case 4:
                        msg = '<%=pedlib%>';
                        break;
                    case 5:
                        msg = '<%=selec%>';
                        break;
                    case 6:
                        msg = '<%=CanRe%>';
                        break;
                    case 7:
                        msg = '<%=Can2d%>';
                        break;
                    case 8:
                        msg = '<%=DesObli%>';
                        break;
                    case 9:
                        msg = '<%=CantSup%>';
                        break;
                    case 10:
                        msg = '<%=Erroin%>';
                        break;
                    case 11:
                        msg = '<%=DocCont%> ' + mn;
                        break;
                    case 12:
                        msg = '<%=Cantped%>';
                        break;
                    case 13:
                        msg = '<%=pedhist%>';
                        break;
                    case 14:
                        msg = '<%=pedpos%>';
                        break;
                    case 15:
                        msg = '<%=CaliOb%>';
                        break;
                    case 16:
                        msg = '<%=PlaOb%>';
                        break;
                    case 17:
                        msg = '<%=ESEntradaExtNoAll%>';
                        break;
                    case 18:
                        msg = '<%=ESEntradatablvaciaArc%>';
                        break;
                    case 19:
                        msg = '<%=ESEntradaArchAdj%>';
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
            function Select(obj) {
                var ce = new Array();
                var ce = obj.split("|");
                $('#txtPedidoMM').val(ce[0]);
                $('#etCentro').val(ce[1]);
                ocultarVentana();
            }
            function numericdata(id) {
                $('#' + id).keypress(function (e) {
                    var te = (document).all ? e.keyCode : e.which;
                    t = String.fromCharCode(te);
                    patron = /[0-9]/;
                    return patron.test(t);
                });
            }
            function validarGuarda() {
                var n1 = -1;
                $("input[name=checkbo]").each(function (i, v) {
                    if (this.checked)
                    {
                        n1 = i;
                    }
                });
                n = parseInt(n1);
                if (n == -1) {
                    ShowMsg(5, "images/adver.PNG", "audio/saperror.wav");
                } else {
                    var Cant = $('#txtCantidad' + n);
                    var Desc = $('#txtDescripcion' + n);
                    var CanS = $('#etCantSolicitada' + n).text();
                    var CanE = $('#etCantEntregada' + n).text();
                    var calidadS = $('#CaliServ');
                    var plazpS = $('#PlazServ');
                    if (calidadS.val().length == 0) {
                        ShowMsg(15, "images/adver.PNG", "audio/saperror.wav");
                        calidadS.focus();
                        return;
                    }
                    if (plazpS.val().length == 0) {
                        ShowMsg(16, "images/adver.PNG", "audio/saperror.wav");
                        plazpS.focus();
                        return;
                    }
                    if (Cant.val().length === 0) {
                        ShowMsg(6, "images/adver.PNG", "audio/saperror.wav");
                        Cant.focus();
                        return;

                    }
                    if (parseInt(Cant.val()) == 0) {
                        ShowMsg(7, "images/adver.PNG", "audio/saperror.wav");
                        Cant.focus();
                        return;
                    }
                    if (Desc.val().length == 0) {
                        ShowMsg(8, "images/adver.PNG", "audio/saperror.wav");
                        Cant.focus();
                        return;
                    }
                    var cf = (parseInt(Cant.val()) + parseInt(CanE));
                    if (cf > parseInt(CanS)) {
                        ShowMsg(9, "images/adver.PNG", "audio/saperror.wav");
                        Cant.focus();
                        return;
                    }
                    abrirVentanaMsgAddFile();
                }
            }

            function guardardata() {
                var n1 = -1;
                $("input[name=checkbo]").each(function (i, v) {
                    if (this.checked)
                    {
                        n1 = i;
                    }
                });
                n = parseInt(n1);
                var DCom = $('#txtPedidoMM').val();
                var Cent = $('#etCentro').val();
                var CanE = $('#etCantEntregada' + n).text();
                var PosD = $('#etPosicion' + n).text();
                var PosL = $('#etnumlinea' + n).text();
                var Serv = $('#etServicio' + n).text();
                var Cant = $('#txtCantidad' + n);
                var UniM = $('#etUnidadMedida' + n).text();
                var Desc = $('#txtDescripcion' + n);
                var CanS = $('#etCantSolicitada' + n).text();
                var Prec = $('#etPrecioUni' + n).text();
                var refpse = $("#refpse").val();
                var tedcpse = $("#tedcpse").val();
                var texbrpse = $("#texbrpse").val();
                var calidadS = $('#CaliServ');
                var plazpS = $('#PlazServ');
                var usu = "<%=Nombre%>";
                var de = Desc.val();
                var des = de.replace(/'/g, "´");
                var cf = (parseInt(Cant.val()) + parseInt(CanE));
                var datosSer = "&DocCom=" + DCom + "&Posicion=" + PosD + "&Centro=" + Cent + "&NoServicio=" + Serv + "&CantEntrar=" + Cant.val() + "&DesServicio=" + encodeURIComponent(des) + "&PrecioUni=" + Prec + "&linea=" + PosL + "&CantEntregada=" + cf + "&UMS=" + UniM + "&CS=" + CanS + "&refpsee=" + refpse + "&tedcpsee=" + tedcpse + "&texbrpsee=" + texbrpse + "&usu=" + usu + "&Calidad=" + calidadS.val() + "&Plazos=" + plazpS.val();
                var acc = "InsertarPedidoServicio";
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionPedidoServicio',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + datosSer,
                    success: function (data) {
                        CleanTable();
                        $('#guardar').prop('disabled', true);
                        if (data == 1) {
                            ShowMsg(10, "images/adver.PNG", "audio/saperror.wav");
                        } else if (data == 2) {
                            ShowMsg(12, "images/adver.PNG", "audio/saperror.wav");
                        } else if (data == 3) {
                            ShowMsg(13, "images/adver.PNG", "audio/saperror.wav");
                        } else {
                            guardarTexarea(n);
                        }
                    }
                });
            }
            function abrirVentanaMsgAddFile() {
                var theHandle = document.getElementById('handleFile');
                var theRoot = document.getElementById('VentanaModalMsgAddFile');
                Drag.init(theHandle, theRoot);
                var ven = document.getElementById('VentanaModalMsgAddFile');
                var ancho = 900;
                var alto = 250;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ven.style.left = x + "px";
                ven.style.top = y + "px";
                ven.style.display = 'block';
            }
            function AbrirVentanaAddFile() {
                OcultarMensajeFile('VentanaModalMsgAddFile');
                var theHandle = document.getElementById('handleFileAdd');
                var theRoot = document.getElementById('VentanaModalAddFile');
                Drag.init(theHandle, theRoot);
                var ven = document.getElementById('VentanaModalAddFile');
                var ancho = 800;
                var alto = 600;
                var x = (screen.width / 2) - (ancho / 2);
                var y = (screen.height / 2) - (alto / 2);
                ven.style.left = x + "px";
                ven.style.top = y + "px";
                ven.style.display = 'block';
            }
            function OcultarMensajeFile(window) {
                var ventana = document.getElementById(window);
                ventana.style.display = 'none';

            }
            var output = [];
            function uploadFiles() {
                var Formdata = new FormData($('#FormCreate')[0]);
                for (var i = 0; i < output.length; i++) {
                    Formdata.append('file[]', output[i]);
                }
                if (output.length == 0) {
                    ShowMsg(18, "images/advertencia.PNG", "audio/saperror.wav");
                    return;
                }
                $.ajax({
                    url: 'ArchivosEntradasServicios',
                    type: 'POST',
                    data: Formdata,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        if (data == 1) {
                            OcultarMensajeFile('VentanaModalAddFile');
                            guardardata();
                            output.length = 0;
                            var elementos = $('[name = "rb"]');
                            for (var i = 0; i < elementos.length; i++) {
                                $('#table12').find('input[name="rb"]').each(function () {
                                    $(this).parents("tr").remove();
                                });
                            }

                        }
                    }

                });
                return false;
            }
            function cancelarFile() {
                OcultarMensajeFile('VentanaModalAddFile');
                guardardata();
                output.length = 0;
                var elementos = $('[name = "rb"]');
                for (var i = 0; i < elementos.length; i++) {
                    $('#table12').find('input[name="rb"]').each(function () {
                        $(this).parents("tr").remove();
                    });
                }
            }
            function datos() {
                var archivos = document.getElementById('archivos').files;
                for (var i = 0; i < archivos.length; i++) {
                    output.push(archivos[i]);
                }

                for (var i = 0; i < output.length; i++) {
                    var name = output[i].name;
                    var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                    var size = output[i].size / 1024 / 1024;
                    var tamano = size.toFixed(2);
                    var peso = "";
                    if (tamano >= 1) {
                        peso = tamano + " mb";
                    } else {
                        peso = tamano + " kb";
                    }
                    var fila = '<tr><td><input type="checkbox" id="rb' + i + '" name="rb" value="' + i + '"</td>\n\
                                            <td><label id="nombre' + i + '">' + name + '</label></td>\n\
                                            <td><label id="tipo' + i + '">' + ext + '</label></td>\n\
                                            <td><label id="tamaño' + i + '">' + peso + '</label></td></tr>';

                    $('#table12 > tbody').append(fila);
                }
            }

            function DatosArchivos() {
                var extensions = new Array(".jpg", ".png", ".jpeg", ".xml", ".pdf", ".txt", ".docx", ".doc", ".xls", ".xlsx", ".pptx", ".txt");
                var nomb = document.getElementById("archivos").files[0].name;
                var ban = false;
                for (var i = 0; i < output.length; i++) {
                    var nam = output[i].name;
                    if (nam == nomb) {
                        ban = true;
                        break;
                    }
                }
                if (ban == true) {
                    ShowMsg(19, "images/advertencia.PNG", "audio/saperror.wav");
                } else {
                    var ext = (nomb.substring(nomb.lastIndexOf("."))).toLowerCase();
                    var perm = false;
                    for (var i = 0; i < extensions.length; i++) {
                        if (ext == extensions[i]) {
                            perm = true;
                            break;
                        }
                    }
                    if (perm) {
                        borramsg();
                        Datafiless();
                    } else {
                        ShowMsg(17, "images/advertencia.PNG", "audio/saperror.wav");
                        document.getElementById("archivos").focus();
                    }
                }
            }
            function Datafiless() {
                var trs = $("#table12 tr").length;
                var final = trs - 1;
                if (final >= 1) {
                    for (var i = 0; i < final; i++) {
                        $("#table12 tr:last").remove();
                    }
                    datos();
                } else if (final >= 2) {
                    for (var i = 0; i < final; i++) {
                        $("#table12").remove();
                    }
                    datos();
                } else {
                    datos();
                }
            }

            function DeleteFile() {
                var elementos = $('[name = "rb"]');
                for (var i = 0; i < output.length; i++) {
                    if (elementos[i].checked) {
                        output.splice(i, 1);
                        $('#table12').find('input[name="rb"]').each(function () {
                            if ($(this).is(":checked")) {
                                $(this).parents("tr").remove();
                            }
                        });
                    }
                }
            }
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/StylePedidoServicioExterno.css">
        <script src="js/PedidoServicioEx.js"></script>
        <title><%out.println(po.getProperty("etiqueta.ESEntradaServ_Title"));%></title>
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
            <input id="aceptar" type="image" src="images/aceptar.png" disabled />
            <input id="guardar" type="image" src="images/guarda.PNG" />  
            <input  id="regresar" type="image" src="images/regresa.PNG"/>
            <input id="finalizar" type="image" src="images/cance.PNG"/>
            <input  id="cancelar" type="image" src="images/cancela.PNG"/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.ESEntradaServ_Title"));%></h1></div>
        </div>            
        <div class="contenido">
            <div class="ContentOrden">
                <label><%out.println(po.getProperty("etiqueta.ESEntradaServPedidoC"));%></label>
                <hr id="hrblue">
                <div class="buqueOr">
                    <label><%out.println(po.getProperty("etiqueta.ESEntradaServPeMM"));%></label><input type="text" id="txtPedidoMM" maxlength="10" style="width: 15%; text-transform: uppercase;"/><button id="match_C1" class='BtnMatchIcon'></button> / <input type="text" id="PosIten" maxlength="5" style="width: 8%;" /> <input hidden type="text" id="etCentro"> <button id="LeerServicios" class="BtnIconLeer"><%out.println(po.getProperty("etiqueta.ESEntradaSeLeerSer"));%></button> <label id="etTiempo"></label>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.ESEntradaServRefe"));%></label><input type="text" id="refpse" maxlength="16" style="width: 15%;" /><button id="textlib" class="BtnIcontelib"><%out.println(po.getProperty("etiqueta.ESEntradaSeTxtLi"));%></button> <label style="margin: .5%;"><%out.println(po.getProperty("etiqueta.ESEntradaCalServ"));%></label> <input type="text" style="width: 6%; background-repeat: no-repeat;" id="CaliServ" maxlength="3"/>
                    <hr>
                    <label><%out.println(po.getProperty("etiqueta.ESEntradaSerTxtDoc"));%>.</label><input type="text" id="tedcpse" maxlength="26" style="width: 28.5%;"/> <label style="margin: .5%;"><%out.println(po.getProperty("etiqueta.ESEntradaPlazosSer"));%></label> <input type="text" style="width: 6%; background-repeat: no-repeat" id="PlazServ" maxlength="3"/>
                    <hr>
                </div>              
            </div>
            <div class="divTable">
                <div id="tablslc">
                    <section id="TableNotfi" >
                        <section class="TableContainer">
                            <section class="SecHead">
                                <table id="TabHead">
                                    <thead>
                                        <tr>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSerPosicion"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSerLine"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSenumSer"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSeCantEnt"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSeUMS"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.GralDescripcion"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSeCntS"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSeCntE"));%></td>
                                            <td><%out.println(po.getProperty("etiqueta.ESEntradaSePrec"));%></td>
                                        </tr>
                                    </thead>
                                </table>
                            </section>
                            <section class="SecBody" id="SecCuerpo">
                                <table id="TabBody">
                                    <tbody>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                        <tr class="ocultar">
                                            <td>0000</td>
                                            <td>000000000000</td>
                                            <td>000000000000</td>
                                            <td>000000000000000000000</td>
                                            <td>00000000000000000000</td>
                                            <td>00000000000</td>
                                            <td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>
                                            <td>000000000000000000</td>
                                            <td>000000000000000000</td>
                                            <td>000000000000000</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </section>
                        </section>
                    </section>
                </div>
                <section class="DobleScroll" id="DobleSection">
                    <section id="DobleContainer"></section>
                </section>
            </div>
        </div>       
        <div id="VentanaModalPedidoMM" class="VentanaModal">
            <div id="handle"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.LimitarAmbitoValor_US"));%></label><div class="BotonCerrar_Matc" id="cerrarmodalPS"><label >X</label></div></div>
            <div class="PanelBntMatch"><button id="retronafiltroped" ><%out.println(po.getProperty("etiqueta.ESEntradaSPedidPorF"));%></button><hr></div>
            <div id="BuscarParamPedidoMM" class="BuscarParam_u">
                <div class="fondo_Match">
                    <div class="busquedaMatch">

                        <label><%out.println(po.getProperty("etiqueta.ESEntradaSDoc"));%></label><input type="text" id="DocComp" maxlength="10" style="width:35%;"/>
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.GralFecha"));%></label><input type="date" id="fechadoc" maxlength="10" style="width:35%;" />
                        <hr>
                        <label><%out.println(po.getProperty("etiqueta.CantMaxAcier"));%></label><input maxlength="3"  type="text" id="numAcMax"  style="width:10%;"/>
                        <hr>
                    </div>        
                </div> 
                <div class="Botones_Match">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okPedidoMM"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="cerrarmodalPS2"/>
                </div>
            </div>
            <div id="ConsultaTablaClasePedidoMM" style="display: none;">
                <div class="tablaCab">
                    <div class="table-scroll" id="table-scrollPedidoMM">
                        <div class="fixedY" id="fixedYPedidoMM">
                            <table>
                                <thead>
                                    <tr>
                                        <th><%out.println(po.getProperty("etiqueta.GralFecha"));%></th><th><%out.println(po.getProperty("etiqueta.ESEntradaSDoc"));%></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div id="cuerpoDatos">
                            <div class="nofixedX" id="cargarDatosPedidoMM">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="VentanaModalAv" class="VentanaModalAv">
            <div id="handleAV"><label id="TituloMatch">Advertencia</label><div class="BotonCerrar_Matc"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv"></label>
                </div>
                <div class="Botones_Match">

                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okAv"/>
                </div>
            </div>
        </div>


        <div id="VentanaModalTextli" class="VentanaModal">
            <div id="handle3"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.ESEntradaSeTxtLi"));%></label><div class="BotonCerrar_Matc" id="cerrarmodalTL"><label >X</label></div></div>
            <div class="PanelBntMatch"><button  ><%out.println(po.getProperty("etiqueta.ESEntradaSeTxtLi"));%></button><hr></div>
            <div id="BuscarParamPedidoMM" class="BuscarParam_u">
                <div class="fonhandle3do_Match">
                    <div class="busquedaMatch">

                        <label><%out.println(po.getProperty("etiqueta.ESEntradaSeTxtLi"));%></label><textarea style="resize:none;" id="Textlib_pse"></textarea>
                    </div>        
                </div> 
                <div class="Botones_MatchTEX">
                    <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="cerrarmodalOK"/>
                    <img class="BtnMatchIcon" src="images/HR_not.png" style="cursor:pointer;" id="cerrarmodalCL"/>
                </div>
            </div>
        </div>

        <div id="VentanaModalMsgAddFile" class="VentanaModalAv">
            <div id="handleFile"><label id="TituloMatch">Advertencia</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModalMsgAddFile', 'bxPedido');"><label >X</label></div></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <div class="fondo_MatchAv">
                    <img src="images/adver_1.PNG" />
                    <label id="lbAv">¿Desea agregar archivos?</label>
                    <button id='addFile' onclick="AbrirVentanaAddFile();" >sí</button><button id='btnCancelar'>no</button>
                </div>
            </div>
        </div>
        <div id="VentanaModalAddFile" class="VentanaModalFiles">
            <div id="handleFileAdd"><label id="TituloMatch">Agregar Archivos</label></div>
            <div id="BuscarParamAv" class="BuscarParam_u">
                <section id="TablaStatus" class="TablaStatusC">
                    <section id="SecTabPpal">
                        <form action="GuardarArchivo" name="FormCreate" method="POST" enctype="multipart/form-data" id="FormCreate">

                            <table class="TablaCont" id="table12">
                                <input type="file" onchange="DatosArchivos();" name="file" id="archivos" >
                                <thead>
                                    <tr id="CabeceraTabla">
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td>&nbsp;Nombre del archivo&nbsp;</td>
                                        <td>&nbsp;Tipo&nbsp;</td>
                                        <td>&nbsp;Tamaño&nbsp;</td>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </section>
            </div>
            <div class="Botones_MatchFile">
                <input type="button" value="Cancelar" class="cancDatAdj"  onclick="cancelarFile();"/>
                <img class="BtnMatchIcon" src="images/DELETEADD.PNG" style="margin-right:-4%; cursor:pointer;" id="EliminarArchivo" onclick="DeleteFile();"/>
                <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%; cursor:pointer;" id="okFiles" onclick="uploadFiles();"/>
            </div>
        </div>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -4px" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <script type="text/javascript">
                    var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                    var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                    var f = new Date();
                    var writefecha = $('#fecha');
                    var idioma = "<%=Idioma%>";
                    if (idioma == "ES") {
                        var fechaActual = diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " de " + f.getFullYear();
                        writefecha.html(fechaActual);
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + ", " + f.getFullYear();
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
