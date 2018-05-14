<%--
    Document   : MonitorStatusCont
    Created on : 15/06/2016, 11:34:29 AM
    Author     : AREconsulting
--%>

<%@page import="AccesoDatos.ACC_Usuarios"%>
<%@page import="AccesoDatos.ACC_Folios"%>
<%@page import="Entidades.folios"%>
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
        String Val = request.getParameter("valor");
        String Ctr = request.getParameter("centro");
        String Ubi = request.getParameter("ubitec");
        String Equ = request.getParameter("equipo");
        String equipo2 = request.getParameter("equipo2");
        String puesto = request.getParameter("puesto");
        String meFOL = request.getParameter("foll");
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
        int f;
        String foc;
        folios fo = new folios();
        fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CC");
        f = fo.getFolioActual();
        foc = fo.getIdFolios() + f;
    %>

    <head>
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script>
            function NuevaTabla2() {
                var url = "PeticionMonitorStatusCont1_";
                var radiosM = document.getElementsByName('monitor');
                var Cp = Array();
                var val1;
                var val2;
                var valores = '';
                var jr = '';
                var sf = '';

                var Lang = "<%=Idioma%>";
                for (var i = 0; i < radiosM.length; i++)
                {
                    if (radiosM[i].checked)
                    {
                        valor = radiosM[i].value;
                        Cp = valor.split(",");
                        val1 = Cp[3];
                        val2 = Cp[11];

                    }
                }

                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionMonitorStatusCont1_',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "val=" + valores + "&Idioma=" + Lang + "&ct=" + val2 + "&eq=" + val1,
                    success: function (data) {

                        var rs = data;
                        var no = Array();
                        no = rs.split(",");
                        var ckt = document.getElementsByName("CKmonitor");
                        for(var i = 0; i < radiosM.length; i++){ ckt[i].checked = false; }
                        for (var i = 0; i < radiosM.length; i++)
                        {
                            if (radiosM[i].checked)
                            {
                                var tam = parseInt(i) + parseInt(no.length - 1);
//                                alert(tam+" "+i+" "+parseInt(no.length - 1));
                                 var ta2 = document.getElementsByTagName("tr");
                                for (var h = i; h < tam; h++) {
//                                    alert(h);
                                     ta2[h+1].style.backgroundColor = '#D3D3D3';
                                     ckt[h].checked = true;
                                }
                            }
                        }
                    },
                });

            }
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
                var pag = p.charAt(82);
                if (pag == 0) {
                    window.location.href = "Bienvenido.jsp";
                }
            }
            checkPermisoPag();
        </script>
        <link rel="stylesheet" href="css/StyleGeneral.css"> 
        <link rel="stylesheet" href="css/StyleMonitor.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/MonitorAvisosCont.js"></script>
        <title><%out.println(po.getProperty("etiqueta.TituloModulo_MSC"));%></title>       
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
            <input id="guardar" type="image" src="images/guardaOFF.png" disabled /> 
            <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
            <input id="finalizar" type="image" style="margin-bottom: -1px;" src="images/cance.PNG" onclick="principalpage();"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png" disabled/>
            <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.TituloModulo_MSC"));%></h1></div>
        </div>            
        <div class="contenido">
            <section class="MonitorStatusCont">
                <section id="TablaStatus">
                    <section id="SecTab">                       
                    </section>
                    <p class="last"></p>
                </section>
                <section id="BusquedaStatus">
                    <section id="BusquedaSec">
                        <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.AjusteB_MSC")); %></label>
                        <hr class="LineasMonitor">
                        <section class="Radio_Ajuste">                        
                            <input type="radio" name="Ajuste" value="Alerta"> <label><% out.println(po.getProperty("etiqueta.Alerta_MSC")); %></label><br>
                            <input type="radio" name="Ajuste" value="Advertencia"> <label><% out.println(po.getProperty("etiqueta.Advertencia_MSC")); %></label><br>
                            <input type="radio" name="Ajuste" value="NoAdvertencia"> <label><% out.println(po.getProperty("etiqueta.NoAdvertencia_MSC")); %></label><br>
                            <input type="radio" name="Ajuste" value="NoContador"> <label><% out.println(po.getProperty("etiqueta.NoContador_MSC")); %></label><br>
                            <input type="radio" name="Ajuste" value="Todos"> <label><% out.println(po.getProperty("etiqueta.Todos_MSC")); %></label><br>
                            <br>
                            <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.Jerarquia_MSC")); %></label>
                            <input id="Jrq" class="BxJerarquia" type="text">
                            <hr class="LineasAjuste">
                            <label id="" class="LbAjuste"><% out.println(po.getProperty("etiqueta.SFI_MSC")); %></label>
                            <input id="Sfi" class="BxJerarquia" type="text" maxlength="3" onclick="funumeric()" />
                            <button id="BtnAplica" type="button" onclick="MostrarTabla('PeticionMonitorStatusCont', '');">
                                <img src="images/ejecuta.png"> 
                                &nbsp;&nbsp;&nbsp;<% out.println(po.getProperty("etiqueta.Aplicar_MSC")); %>
                            </button>
                        </section>                                
                    </section>
                    <br>
                    <section id="BusquedaSec">
                        <label class="LbMonitor"><% out.println(po.getProperty("etiqueta.Medicion_MSC")); %></label>
                        <hr class="LineasMonitor">
                        <section class="Radio_Ajuste">                   
                            <label><% out.println(po.getProperty("etiqueta.Diferencia_MSC")); %></label><br>
                            <input id="Dif" class="BxDiferencia" type="text">
                            <button id="BtnDif" type="button" onclick="ActualizarMedicion()">
                                <img src="images/DiferenteMSC.PNG">
                                &nbsp;&nbsp;<% out.println(po.getProperty("etiqueta.Actualizar_MSC"));%>
                            </button>
                        </section>
                    </section>
                </section>
            </section>
        </div>       
        <section id="SecTab2" hidden ></section>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label><label>|  LAN <%=Idioma%></label>
                <span><input type="image" style="float:left; margin-top: -2.5px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
                <div hidden><input type="text" value="<%=Nombre%>" id="usua"</div>
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

                    function NuevaTabla() {
                        var radiosM = document.getElementsByName('monitor');
                        var Cp = Array();
                        var val1;
                        var val2;
                        var valores = '';
                        var ub = '';
                        var modo = '';
                        var jr = '';
                        var sf = '';
                        var eq2 = '';
                        var Lang = "<%=Idioma%>";
                        for (var i = 0; i < radiosM.length; i++)
                        {
                            if (radiosM[i].checked)
                            {
                                valor = radiosM[i].value;
                                Cp = valor.split(",");
                                val1 = Cp[3];
                                val2 = Cp[11];
                            }
                        }
                        var enviar = "&val=" + valores + "&Idioma=" + Lang + "&ct=" + val2 + "&eq=" + val1;

                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'PeticionMonitorStatusCont1_2',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: enviar,
                            success: function (data) {
                                var ta = document.getElementsByTagName("tr");
                                for (var j = 0; j < ta.length; j++)
                                {
                                    ta[j].style.backgroundColor = '#E6EBEB';
                                }

                                $("#SecTab2").html(data);
                                NuevaTabla2();
                            }

                        });
                    }

                    function unselectSon(c){
                        var arr = new Array();
                        var radiosM = document.getElementsByName('monitor');
                        var ckmonitor = document.getElementsByName('CKmonitor');
                        var ta2 = document.getElementsByTagName("tr");
                        ta2[c+1].style.backgroundColor = '#E6EBEB';
                        document.getElementById('myCheck' + c).checked = false;
                        for (var i = 0; i < radiosM.length; i++)
                        {
                            if (radiosM[i].checked)
                            {
                                ta2[i+1].style.backgroundColor = '#D3D3D3';
                                document.getElementById('myCheck' + i).checked = true;
                            }
                        }
                        var t = 0;
                        for(var i = 0; i < ckmonitor.length; i++){
                            if (ckmonitor[i].checked){
                                var x = document.getElementById("jaja").rows[i].cells;
                                arr[t] = x[4].textContent;
                                t++;
                            }
                        }
                        
                        for(var j = 0; j < document.getElementById("jaja2").rows.length; j++){
                            var count = 0;
                            for(var i = 0; i < arr.length; i++)
                            {
                                    var x = document.getElementById("jaja2").rows[j].cells;
                                    var eq = x[3].textContent;
                                    if(eq == arr[i]){ count++; }

                            }
                            if(count == 0) { document.getElementById("jaja2").deleteRow(j); }
                        }
                    }
                    function pasaree() {

                        var radiosM = document.getElementsByName('monitor2');
                        for (var i = 0; i < radiosM.length; i++)
                        {
                            radiosM[i].checked = true;
                            if (radiosM[i].checked)
                            {
                                var valor = radiosM[i].value;
                            }
                        }
                    }
                </script>
            </div>
        </footer>
    </body>
    <script language="javascript">
        function back() {
            window.location.href = "MonitorStatus.jsp";
        }
        function principalpage() {
            window.location.href = "Bienvenido.jsp";
        }
        function inval() {
            var funinva = '<%=funcioninv%>';
            $("#iconmsg").css("visibility", "visible");
            $("#iconmsg").attr("src", "images/advertencia.PNG");
            $("#msg").html(funinva);
        }
        function cargarya(){
         var modos = "<%=Val%>";   
         MostrarTabla3('PeticionMonitorStatusCont', modos);   
        }
        
        function MostrarTabla(url, valor)
        {
            var modo;
            var radiosA = document.getElementsByName('Ajuste');
            for (var i = 0; i < radiosA.length; i++)
            {
                if (radiosA[i].checked)
                {
                    modo = radiosA[i].value;
                }
            }

            var jr = $("#Jrq").val();
            var sf = $("#Sfi").val();
            var Lang = "<%=Idioma%>";
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&valor=" + valor + "&Idioma=" + Lang + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq + "&modo=" + modo + "&jr=" + jr + "&sf=" + sf + "&eq2=" + eq2 + "&pue=" + pue;

            $.ajax({
                async: false,
                type: 'GET',
                url: url,
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    $("#SecTab").html(data);
                }

            });
        }

        function MostrarRadio()
        {
            var vl = "<%=Val%>";
            var radiosA = document.getElementsByName('Ajuste');
            for (var i = 0; i < radiosA.length; i++)
            {
                if (radiosA[i].value == vl)
                {
                    radiosA[i].checked = true;
                }
            }
        }


        function COrreTab(i) {

            $("#Dif").val("");
            MostrarTabla('PeticionMonitorStatusCont', '');
            setTimeout("InsertarMedicion(" + i + ")", 500);
        }

        function InsertarMedicion(i) {
            var radiosM = document.getElementsByName('monitor');
            radiosM[i].checked = true;
            var radiosMo = document.getElementsByName('monitor2');
            var Cp = Array();
            var valor;
            var v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15;
            var acc = "InsConta";
            var fa = new Date();
            var usu = $("#usua").val();
            var hora;
            var min;
            var meses = new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
            var f = new Date();
            var mes = meses[f.getMonth()];
            var dia = f.getDate();
            var dita = "";
            if (dia <= 9) {
                dita = "0" + dia;
            } else {
                dita = dia;
            }
            var Fact = f.getFullYear() + "-" + meses[f.getMonth()] + "-" + dita;

            if (fa.getHours() < 10) {
                hora = "0" + fa.getHours();
            } else {
                hora = fa.getHours();
            }
            if (fa.getMinutes() < 10) {
                min = "0" + fa.getMinutes();
            } else {
                min = fa.getMinutes();
            }
            var Hact = hora + ":" + min + ":00";


            for (var i = 0; i < radiosM.length; i++)
            {
                if (radiosM[i].checked)
                {
                    var jj = parseInt(radiosMo.length);
                    if(jj == 0) { jj++; }
                    for (var j = 0; j < jj; j++)
                    {
                        var g = parseInt(i) + parseInt(j);
                        valor = radiosM[g].value;
                        Cp = valor.split(",");
                        v1 = Cp[0];
                        v2 = Cp[1];
                        v3 = Cp[2];
                        v4 = Cp[3];
                        v5 = Cp[4];
                        v6 = Cp[5];
                        v7 = Cp[6];
                        v8 = Cp[7];
                        v9 = Cp[8];
                        v10 = Cp[9];
                        v11 = Cp[10];
                        v12 = Cp[11];
                        v13 = Cp[12];
                        v14 = Cp[13];
                        v15 = Cp[14];
                        var enviar = "&jer=" + v1 + "&niv=" + v2 + "&sta=" + v3 + "&equ=" + v4 + "&den=" + v5 + "&Punto_medida=" + v6 + "&Doc_me=" + v7 + "&Ult_med=" + v8 + "&us_con=" + v9 + "&entradadoc=" + v10 + "&Mate=" + v11 + "&cntr=" + v12 + "&Ser=" + v13 + "&Alma=" + v14 + "&lot=" + v15 + "&Fact=" + Fact + "&Hact=" + Hact + "&usu=" + usu;
//                                alert(enviar);
                        $.ajax({
                            async: false,
                            type: 'GET',
                            url: 'peticionModuloMonitorStatusContadores',
                            contentType: "application/x-www-form-urlencoded",
                            processData: true,
                            data: "Accion=" + acc + enviar,
                            success: function (data) {
                                if (data == 1) {

                                }
                            },
                        });
                    }
                    Reload();
                }
            }
        }


        function Reload() {
            var valo = "<%=Val%>";
            var cent = "<%=Ctr%>";
            var ubit = "<%=Ubi%>";
            var equi = "<%=Equ%>";
            var equi2 = "<%=equipo2%>";
            var foll = "<%=foc%>";
            var pue = "<%=puesto%>";
            window.location.href = "MonitorStatusCont.jsp?valor=" + valo + "&centro=" + cent + "&ubitec=" + ubit + "&equipo=" + equi + "&equipo2=" + equi2 + "&foll=" + foll + "&puesto=" + pue;
        }

        function borramsg() {

            $("#iconmsg").css("visibility", "hidden");
            $("#msg").html("");
        }

        function CArgarMne() {
            var mensajOk = '<%=meFOL%>';
            if (mensajOk != 'null') {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $("#iconmsg").css("visibility", "visible");
                $("#iconmsg").attr("src", "images/aceptar.png");
                $("#msg").html('Documento ' + mensajOk + " creado");
            } else {
                borramsg();
            }

        }
        function MostrarTabla3(url, valor)
        {
            var jr = $("#Jrq").val();
            var sf = $("#Sfi").val();
            var Lang = "<%=Idioma%>";
            var ct = "<%=Ctr%>";
            var ub = "<%=Ubi%>";
            var eq = "<%=Equ%>";
            var eq2 = "<%=equipo2%>";
            var pue = "<%=puesto%>";
            var enviar = "&modo=" + valor + "&Idioma=" + Lang + "&ct=" + ct + "&ub=" + ub + "&eq=" + eq +"&jr=" + jr + "&sf=" + sf + "&eq2=" + eq2 + "&pue=" + pue;

            $.ajax({
                async: false,
                type: 'GET',
                url: url,
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: enviar,
                success: function (data) {
                    $("#SecTab").html(data);
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