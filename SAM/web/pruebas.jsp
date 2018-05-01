<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="Clases.ClassModuloCreaOrdenPP" %>
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
        String menValores = po.getProperty("etiqueta.NoExisteValores_SAM");
        String funcioninv = po.getProperty("etiqueta.FuncionInval_Menu");
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
        String reso = po.getProperty("etiqueta.Resolucio");
        String Do = po.getProperty("etiqueta.CSPDom");
        String lu = po.getProperty("etiqueta.CSPLun");
        String Ma = po.getProperty("etiqueta.CSPMar");
        String Mi = po.getProperty("etiqueta.CSPMie");
        String Ju = po.getProperty("etiqueta.CSPJue");
        String vi = po.getProperty("etiqueta.CSPVie");
        String sa = po.getProperty("etiqueta.CSPSab");
        String ClasO = request.getParameter("ClasO");
        String CenPl = request.getParameter("CenPl");
        String PueTr = request.getParameter("PueTr");
        String equipe = request.getParameter("equipe");
        String ubicate = request.getParameter("ubicate");
        String folSA = request.getParameter("folSA");
        String foltip = request.getParameter("Tipo");
        String html;
        ClassModuloCreaOrdenPP classO = new ClassModuloCreaOrdenPP();

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleCreaOrdenPP.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">  
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>       
        <script src="js/prueba.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/jquery-iu-1.12.0.js"></script>
        <title><%out.println(po.getProperty("etiqueta.CreaOrdenOR_PP"));%></title>   
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
                var pag = p.charAt(111);
                if (pag == 1) {

                } else if (pag == 0) {
                    session.invalidate();
                    window.location.href = "index.jsp";
                }
            }
            checkPermisoPag();
            var usuario = '<%=Nombre%>';
        </script>
    </head>
    <body>
        <div id="Calenndar" class="VentanaFecha">
            <div id="handlecalendar"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.CSPCalen"));%></label><div class="BotonCerrar_Matc" id="CerraCalendar1"><label >X</label></div></div>
            <div class="scrolCale"><div id="datapicker"></div></div>
            <div class="btnCalendar">
                <img class="BtnMatchIconBut" id="calenimg" src="images/S_B_CANC.gif" style="cursor:pointer;"/>
                <input type="text" hidden id="IDFecha"/>
            </div>
        </div>

        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>
                        </li>
                    </ul>
                </div>
                <script>
                </script>
                <input id="aceptar" type="image" src="images/aceptaOFF.png"/>     
                <input id="guardar" type="image" src="images/guarda.PNG" onclick="datosObligatorios();" />  
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="back();" />
                <!--<input  id="cancelar" type="image" src="images/cancela.PNG" onclick="checkOpeServ();" />-->


            </div>            
            <div class="contenido">
                <input type="button" value="fundillo" onclick="pruebaPrint()"/>   
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
                    function fechaIni() {
                        var hoy = new Date();
                        var dd = hoy.getDate();
                        var mm = hoy.getMonth() + 1;
                        var yyyy = hoy.getFullYear();
                        if (dd < 10) {
                            dd = '0' + dd;
                        }
                        if (mm < 10) {
                            mm = '0' + mm;
                        }
                        hoy = dd + '.' + mm + '.' + yyyy;
                        document.getElementById("fechIni").value = hoy;
                        document.getElementById("fechFin").value = hoy;
                    }
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
                        bloq();
                    };

                    function back() {
                        window.location.href = "Bienvenido.jsp";
                    }
                    function pruebaPrint() {
                        var zpl = "^XA\n" +
                                "^MMT\n" +
                                "^PW807\n" +
                                "^LL0408\n" +
                                "^LS0\n" +
                                "^FO704,320^GFA,01152,01152,00012,:Z64:\n" +
                                "eJzVk7Fr20AUxt9ZISoUZAcKCU2wMoYMJqPAIaf/ImNDxg6poUshhVNqSIeWLFkLMXQMmIyGM9ih/0C2rJdOpi0XeygIJPT6TndSl5QUOvXJoJ8/7t777jsE8A/Vood+sXk9UDGLzatRC89gCf6wtq69bsHuvbE/mQK0ifH8Yl/MAYKtAPS7Mz1TAP64zfDLBaakN0fP+eXnD+2U9vKsQHz9/pMg7mxrrQ9PP7YTgN0uLlD0xz7tjaL1u+/r/REQ70bhAsN++ob6dL5pPQxO1CvSw6wQ6J/MOXloZgW/9xIVJn+fCx/UGN7itDpxB7RyyKYgcsc+wFPpeIP+4tRyRNFVG3pMeTh3W9mAybxixTAvB1DMCrQu9WUQCgQ6xgEIO2CDodHLAWsNpeBIlxx510Yvh+0YPs4cL1QL7eBNGJr+5dFi6sOcHgNXnpxcWV4h/1Y3jQOtZxULxLTibCIrXsHfOi2v1/Oc1Xp3BHJk+wM1F24uxXlwVPo8AIbznnA+PXnFnX9Yxdy3frYozR8u0DXjMrE5PAFfTlQ3MbxE+s+ecLk19GzzZcke6TkUNvPEk2OWVvkjrtr8ycRwaOMx90jHdfcYwLGUiWUfONproVKBPa2pt86lqeZXdMvpY3lx03rki/mv6xduwusD:C017\n" +
                                "^FT695,344^A0I,28,28^FB108,1,0^FH\\^FDPto Tbjo:^FS\n" +
                                "^FT424,368^A0I,27,26^FB79,1,0^FH\\^FDFECHA:^FS\n" +
                                "^FT334,369^A0I,27,26^FB120,1,0^FH\\^FD12/04/2018^FS\n" +
                                "^FT198,370^A0I,27,26^FB70,1,0^FH\\^FDHORA:^FS\n" +
                                "^FT114,370^A0I,27,26^FB94,1,0^FH\\^FD12:12:12^FS\n" +
                                "^FT201,27^A0I,21,21^FB130,1,0^FH\\^FDER CLIENTE 01^FS\n" +
                                "^FT362,27^A0I,21,21^FB160,1,0^FH\\^FDL DE VENTA SANP^FS\n" +
                                "^FT526,27^A0I,21,21^FB162,1,0^FH\\^FDCION DE MATERIA^FS\n" +
                                "^FT701,27^A0I,21,21^FB173,1,0^FH\\^FDLARGO DE PRODUC^FS\n" +
                                "^BY2,3,99^FT744,139^BCI,,Y,N\n" +
                                "^FD>;1234567890>6-LOTEMATE01->5123456>67.00^FS\n" +
                                "^FT423,328^A0I,27,26^FB121,1,0^FH\\^FDCANTIDAD:^FS\n" +
                                "^FT291,328^A0I,27,26^FB126,1,0^FH\\^FD1234567.00^FS\n" +
                                "^FT797,75^A0I,28,28^FB94,1,0^FH\\^FDORDEN:^FS\n" +
                                "^FT692,75^A0I,28,28^FB141,1,0^FH\\^FD1234567890^FS\n" +
                                "^FT515,75^A0I,28,28^FB70,1,0^FH\\^FDLOTE:^FS\n" +
                                "^FT429,75^A0I,28,28^FB157,1,0^FH\\^FDLOTEMATE01^FS\n" +
                                "^FT209,75^A0I,28,28^FB25,1,0^FH\\^FDA:^FS\n" +
                                "^FT174,75^A0I,28,28^FB135,1,0^FH\\^FD1234567.00^FS\n" +
                                "^FO449,335^GB126,0,7^FS\n" +
                                "^FO36,65^GB139,0,5^FS\n" +
                                "^FO272,64^GB157,0,5^FS\n" +
                                "^FO552,64^GB141,0,5^FS\n" +
                                "^FO54,317^GB99,0,4^FS\n" +
                                "^FO166,318^GB125,0,5^FS\n" +
                                "^FO15,359^GB101,0,6^FS\n" +
                                "^FO213,358^GB120,0,6^FS\n" +
                                "^FT573,347^A0I,28,28^FB120,1,0^FH\\^FDAABB3388^FS\n" +
                                "^FT150,327^A0I,27,26^FB91,1,0^FH\\^FDMETROS^FS\n" +
                                "^FT789,26^A0I,21,21^FB80,1,0^FH\\^FDCLIENTE:^FS\n" +
                                "^FT141,253^A0I,21,21^FB129,1,0^FH\\^FDAL 1234567890^FS\n" +
                                "^FT141,285^A0I,21,21^FB128,1,0^FH\\^FDAL 1234567890^FS\n" +
                                "^FT308,253^A0I,21,21^FB167,1,0^FH\\^FDA SANPER MATERI^FS\n" +
                                "^FT309,285^A0I,21,21^FB167,1,0^FH\\^FDA SANPER MATERI^FS\n" +
                                "^FT468,253^A0I,21,21^FB158,1,0^FH\\^FDATERIAL DE VENT^FS\n" +
                                "^FT467,285^A0I,21,21^FB158,1,0^FH\\^FDATERIAL DE VENT^FS\n" +
                                "^FT640,253^A0I,21,21^FB173,1,0^FH\\^FDPRODUCCION DE M^FS\n" +
                                "^FT639,285^A0I,21,21^FB173,1,0^FH\\^FDPRODUCCION DE M^FS\n" +
                                "^FT800,253^A0I,21,21^FB161,1,0^FH\\^FDTEXTO LARGO DE ^FS\n" +
                                "^FT801,285^A0I,21,21^FB162,1,0^FH\\^FDTEXTO LARGO DE ^FS\n" +
                                "^XZ";
                        var printWindow = window.open();
                        printWindow.document.open('text/plain');
                        printWindow.document.write(zpl);
                        printWindow.document.close();
                        printWindow.focus();
                        printWindow.print();
                        printWindow.close();
                    }
                    function CArgarDATavi() {
                        var claseor = $('#mjClasO').val();
                        var centrplan = $('#mjCenPl').val();
                        var putra = $('#mjPueTr').val();
                        var equipe = $('#mjequipe').val();
                        var utecn = $('#mjubicate').val();
                        var folS = $('#mjfolSA').val();
                        var ClOrd = $('#ClOrden');
                        var Descr = $('#Descri');
                        var Equip = $('#Equipo');
                        var UbiTe = $('#UbiTec');
                        var CentP = $('#CentPl');
                        var PtoTj = $('#PtoTjo');
                        var DatObli = [ClOrd, Descr, Equip, CentP, PtoTj];
                        if (claseor != 'null' || centrplan != 'null' || putra != 'null' || equipe != 'null' || utecn != 'null' || folS != 'null') {
                            $("#ClOrden").val(claseor);
                            $("#Equipo").val(equipe);
                            $("#UbiTec").val(utecn);
                            $("#PtoTjo").val(putra);
                            $("#CentPl").val(centrplan);

                        } else {
//                            borramsg();
                        }
                        setTimeout(function () {
                            $.each(DatObli, function (i, v) {
                                if (v.val().length > 0) {
                                    v.css('background-image', 'none');
                                    v.css("background-color", "#ffffff");
                                } else {
                                    v.css({background: 'url(images/necesario.PNG) no-repeat'});
                                    v.css("background-color", "#ffffff");
                                }
                            });
                        }, 800);
                    }
                    function GuardaFOLAvi(fol) {
                        var folS = '<%=folSA%>';
                        var folt = '<%=foltip%>';
                        var acc = "";
                        var enviar = "&folAV=" + folS + "&folORD=" + fol;
                        if (folS == 'null') {
                        } else {
                            if (folS.length == 8) {
                                acc = "ACTaviORDSAP";
                            } else {
                                acc = "ACTaviORD";
                            }
                            $.ajax({
                                async: false,
                                type: 'GET',
                                url: 'PeticionModuloAvisos',
                                contentType: "application/x-www-form-urlencoded",
                                processData: true,
                                data: "Action=" + acc + enviar,
                                success: function (data) {
                                    if (data == 0) {
                                        $(location).attr('href', 'ModificarAviso.jsp?Aviso=' + folS + "&Tipo=" + folt);
//                                        if (folS.length == 8) {
//                                            window.location.href = "ModificarAviso.jsp?P=" + folS + "&FolOR=" + fol + "&M=";
//                                        } else {
//                                            window.location.href = "ModificarAviso.jsp?M=" + folS + "&FolOR=" + fol + "&P=";
//                                        }
                                    }
                                }
                            });
                        }
                    }
                </script>
            </div>
        </footer>
    </body>
    <script>
        function CerrarCalendario() {
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            $('#Calenndar').css('display', 'none');
            $('#datapicker').datepicker().hide();
        }
        function OpenCalendario(id) {
            $("#" + id).focus();
            $("#IDFecha").val(id);
            var BE = document.createElement('audio');
            BE.src = "audio/sapsnd05.wav";
            BE.play();
            var ancho = 500;
            var alto = 750;
            var x = (screen.width / 2) - (ancho / 2);
            var y = (screen.height / 2) - (alto / 2);
            var ventana = $('#Calenndar');
            ventana.css({top: y + "px", left: x + "px"});
            ventana.css('display', 'block');
            var theHandle = document.getElementById("handlecalendar");
            var theRoot = document.getElementById("Calenndar");
            Drag.init(theHandle, theRoot);
            $('#datapicker').datepicker().show();
        }
        $(function () {
            $("#datapicker").datepicker({
                dateFormat: 'dd.mm.yy',
                firstDay: 0,
                monthNames: ['<%=Enero%>', '<%=Febrero%>', '<%=Marzo%>', '<%=Abril%>', '<%=Mayo%>', '<%=Junio%>',
                    '<%=Julio%>', '<%=Agosto%>', '<%=Septiembre%>', '<%=Octubre%>', '<%=Noviembre%>', '<%=Diciembre%>'],
                dayNames: ['<%=Domingo%>', '<%=Lunes%>', '<%=Martes%>', '<%=Miercoles%>', '<%=Jueves%>', '<%=Viernes%>', '<%=Sabado%>'],
                dayNamesMin: ['<%=Do%>', '<%=lu%>', '<%=Ma%>', '<%=Mi%>', '<%=Ju%>', '<%=vi%>', '<%=sa%>'],
                onSelect: function (date) {
                    var idda = $('#IDFecha').val();
                    var fehSet = $('#' + idda);
                    fehSet.val(date);
                    fehSet.focus();
                    CerrarCalendario();
                }
            });
        });
        $(function () {
            $('#datapicker').datepicker().hide();
        });
    </script>
    <%}
        } catch (Exception e) {
            System.err.println("Errr:" + e);
            session.invalidate();
            response.sendRedirect("index.jsp");
        }%>
</html>