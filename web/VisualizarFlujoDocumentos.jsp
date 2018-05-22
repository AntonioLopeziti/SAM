<%-- 
    Document   : VisualizarFlujoDocumentos
    Created on : May 22, 2018, 2:05:50 PM
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
        String ConsEx = po.getProperty("etiqueta.ConOk_FO");
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
    %>
    <%
        String centro = request.getParameter("centro");
        String centro2 = request.getParameter("centro2");
        String sam1 = request.getParameter("sam1");
        String sam2 = request.getParameter("sam2");
        String sap1 = request.getParameter("sap1");
        String sap2 = request.getParameter("sap2");
        String Fecha1 = request.getParameter("Fecha1");
        String Fecha2 = request.getParameter("Fecha2");
        String tipoRad = request.getParameter("tipoRad");
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
                var pag = p.charAt();
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
            function ShowMsg(m, im, au, va) {
                var msg;
                switch (m) {
                    case 0:
                        msg = '<%=funcioninv%>';
                        break;
                    case 1:
                        msg = '<%=ConsEx%>';
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
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleReportes.css"> 
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> 
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <title>Reporte Flujo Documentos</title>       
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
            <input id="aceptar" type="image" src="images/aceptaOFF.png" onclick="prueba();"/>                
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="retorn();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="fin();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>     
            <div class="titulo"><h1>Reporte Flujo Documentos</h1></div>  
        </div>            
        <div class="contenido">
            <div class="ContentLista">
                <div class="gen">
                    <label class="labelTitulo"> SANPER </label>
                    <div class="period">
                        <label id="fech" name="fech" class="labelDate"></label> <label class="labelDate"> <%out.println(po.getProperty("etiqueta.Usuario_USCR"));%>:  </label> <label class="labelDate"> <% out.println(Nombre);%> </label>
                        <script type="text/javascript">
                            var meses = new Array("<%=Enero%>", "<%=Febrero%>", "<%=Marzo%>", "<%=Abril%>", "<%=Mayo%>", "<%=Junio%>", "<%=Julio%>", "<%=Agosto%>", "<%=Septiembre%>", "<%=Octubre%>", "<%=Noviembre%>", "<%=Diciembre%>");
                            var diasSemana = new Array("<%=Domingo%>", "<%=Lunes%>", "<%=Martes%>", "<%=Miercoles%>", "<%=Jueves%>", "<%=Viernes%>", "<%=Sabado%>");
                            var f = new Date();
                            var minut = (f.getMinutes() < 10 ? '0' + f.getMinutes() : f.getMinutes());

                            var idioma = "<%=Idioma%>";
                            if (idioma == "ES") {
                                var fechaActu = "Periodo: " + meses[f.getMonth()] + " Ejercicio: " + f.getFullYear() + "<br>Fecha: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Hora: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else if (idioma == "EN") {
                                var fechaActu = "Periodo: " + meses[f.getMonth()] + " Exercise: " + f.getFullYear() + "<br>Date: " + " " + f.getDate() + "/" + meses[f.getMonth()] + "/" + f.getFullYear() + " Time: " + f.getHours() + ":" + minut + ":" + f.getSeconds();
                                document.getElementById('fech').innerHTML = fechaActu;
                                ;
                                document.getElementById('fech').innerHTML = fechaActu;
                            } else {
                                var fechaActu = "Fecha indefinida";
                            }
                        </script>
                    </div>
                </div>
                <div id="general" class="general">
                    <div id="tabscrll">
                        <section id="TableNotfi" >
                            <section class="TableContainer">
                                <section class="SecHead">
                                    <table id="TabHead">
                                        <thead>
                                            <tr>
                                                <td>Denomin.</td>
                                                <td>ClDocVenta</td>
                                                <td>Orden</td>
                                                <td>Lote</td>
                                                <td>UMCtdPrev</td>                                                
                                                <td>Ctd.Prev</td>                                                
                                                <td>El</td>                                                
                                                <td>Ce.coste</td>                                                
                                                <td>Solicitan.</td>                                                
                                                <td>Álmacen</td>                                                
                                                <td>Mandante</td>                                                
                                                <td>Gpo.artíc.</td>                                                
                                                <td>Material</td>                                                
                                                <td>Mat.intr.</td>                                                
                                                <td>Valor neto</td>                                                
                                                <td>Asignación</td>                                                
                                                <td>Mat.precio</td>                                                
                                                <td>Posición</td>                                                
                                                <td>JquíaProd</td>                                                
                                                <td>Ruta</td>                                               
                                                <td>Sector</td>                                                
                                                <td>Doc.vta.</td>                                                
                                                <td>TpDocVtas</td>                                                
                                                <td>ofic.vta.</td>                                                
                                                <td>GrVendedor</td>                                                
                                                <td>Org.Ventas</td>                                                
                                                <td>Can.distr.</td>                                                
                                                <td>Moneda</td>                                                
                                                <td>Centro</td>                                                
                                                <td>Referencia</td>                                             
                                                <td>Entrega</td>                                                
                                                <td>Pos.Ent</td> 
                                                <td>Cant.Ent</td>
                                                <td>UME</td>                                                
                                                <td>Transporte</td>                                                
                                                <td>Pos.Trans</td>                                                
                                                <td>Cant.Trans</td>                                                
                                                <td>UMT</td>                                                
                                                <td>Mov.Entrega</td>                                                
                                                <td>Pos.MovEnt</td>                                                
                                                <td>Cant.MovEnt</td>                                               
                                                <td>UMME</td>                                                
                                                <td>Factura</td>                                                
                                                <td>Pos.Fact</td>                                                
                                                <td>Cant.Fact</td>                                                
                                                <td>UMF</td>                                                
                                                <td>Destinat.Merc</td>                                                
                                                <td>Peso total</td>                                                
                                                <td>Fecha carg</td>                                                
                                                <td>Entrega externa</td>                                                
                                                <td>Peso neto</td>                                                                                           <td>Fecha planif.transp</td>                                                
                                                <td>Puesto expedicion</td>                                                
                                                <td>Lote</td>                                                
                                                <td>Unidad peso</td>                                                
                                                <td>Cantidad entregada</td>                                                
                                                <td>Denominacion ruta</td>                                                
                                                <td>Creado por</td>                                                
                                                <td>No. Pedido cliente</td>                                                
                                                <td>Clase gasto transp</td>                                                
                                                <td>No. gasto transp</td>                                                
                                                <td>Status transfer</td>                                                
                                                <td>Importe gasto</td>                                                
                                                <td>Docto de compras</td>                                                
                                                <td>Suplemento 1</td>                                                
                                                <td>Suplemento 2</td>                                                
                                                <td>Suplemento 3</td>                                                
                                                <td>Suplemento 4</td>                                                
                                                <td>Clase medio trasporte</td>                                                
                                                <td>Identificador ext 1</td>                                                
                                                <td>Identificador ext 2</td>                                                
                                                <td>Ruta p. Transp</td>                                                
                                                <td>Clase transp</td>                                                
                                                <td>Signatura</td>                                                
                                                <td>Status global transp</td>  
                                                <td>Transportista</td>
                                                <td>Denominacion</td>
                                                <td>Clase de ex</td>
                                                <td>F.Inicio.PP</td>
                                                <td>F.Fin.PP</td>
                                                <td>Status Orden</td>
                                                <td>Stock Ped</td>
                                            </tr>
                                        </thead>
                                    </table>
                                </section>
                                <section class="SecBody" id="SecCuerpo">  
                                </section>                              
                            </section>
                        </section>
                    </div>
                    <section class="DobleScroll" id="DobleSection">
                        <section id="DobleContainer"></section>
                    </section>
                </div>                     
            </div> 
        </div>
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
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else if (idioma == "EN") {
                        var fechaActual = diasSemana[f.getDay()] + ", " + meses[f.getMonth()] + " " + f.getDate() + " th, " + f.getFullYear();
                        document.getElementById('fecha').innerHTML = fechaActual;
                    } else {
                        var fechaActual = "Fecha indefinida";
                    }
                </script>
                <script type="text/javascript">
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
                        Correr();
                        $("#DobleSection").scroll(function () {
                            $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
                        });
                        $("#SecCuerpo").scroll(function () {
                            $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
                        });
                    };

                    function bloq() {
                        $('#iconmsg').hide();
                        document.getElementById('guardar').disabled = true;
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
        {
            var myTable = document.getElementById(cuerpo);
            var arr = new Array();
            for (i = 0; i < myTable.rows[0].cells.length; i++)
            {
                arr[i] = myTable.rows[0].cells[i];
            }
            var val = 0;
            for (i = 0; i < arr.length; i++)
            {
                val += arr[i].offsetWidth;
            }
            var myTableCb = document.getElementById(cabecera);
            myTableCb.style.width = val + 7 + "px";
            var arrCb = new Array();
            for (i = 0; i < myTableCb.rows[0].cells.length; i++)
            {
                arrCb[i] = myTableCb.rows[0].cells[i];
            }
            for (i = 0; i < arr.length - 1; i++)
            {
                arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
            }
            document.getElementById(section).style.width = val + 17 + "px";
            document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
        }
        function inval() {
            ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
        }
        function retorn() {
            window.location.href = "FlujoDocumentos.jsp";
        }
        function fin() {
            window.location.href = "FlujoDocumentos.jsp";
        }
        function Correr() {
            var centro = '<%=centro%>';
            var centro2 = '<%=centro2%>';
            var sam1 = '<%=sam1%>';
            var sam2 = '<%=sam2%>';
            var sap1 = '<%=sap1%>';
            var sap2 = '<%=sap2%>';
            var fecha1 = '<%=Fecha1%>';
            var fecha2 = '<%=Fecha2%>';
            var tipoRad = '<%=tipoRad%>';
            var enviar = "&centro=" + centro + "&centro2=" + centro2 + "&sam1=" + sam1 + "&sam2=" + sam2 + "&sap1=" + sap1 + "&sap2=" + sap2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2 + "&tipoRad=" + tipoRad;
            var acc = "ReporteMovNot";
            $.ajax({
                async: false,
                type: 'GET',
                url: 'PeticionVisualizarReportesFlujoDocs',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Action=" + acc + enviar,
                success: function (data) {
                    $("#SecCuerpo").html(data);
                    AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
                    ShowMsg(1, "images/aceptar.png", "audio/sapmsg.wav");
                }
            });
        }
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>




