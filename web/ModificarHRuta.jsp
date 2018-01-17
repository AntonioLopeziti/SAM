<%-- 
    Document   : ModificarHRuta
    Created on : 8/07/2016, 11:53:42 AM
    Author     : Erick_Jimenez
--%>
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
        String equipo = po.getProperty("etiqueta.HREquipo");
        String perfil = po.getProperty("etiqueta.HRPerfil");
        String tipodhrut = po.getProperty("etiqueta.HRTipodehojaderuta");
        String HRGrupohojaderuta = po.getProperty("etiqueta.HRGrupohojaderuta");
        String HRContgrupoHRuta = po.getProperty("etiqueta.HRContgrupoHRuta");
        String HRSeleccionHRuta = po.getProperty("etiqueta.HRSeleccionHRuta");
        String HRClavedeGrupohojasderuta = po.getProperty("etiqueta.HRClavedeGrupohojasderuta");
        String HRTextobreve = po.getProperty("etiqueta.HRTextobreve");
        String HRCtdmaximaaciertos = po.getProperty("etiqueta.HRCtdmaximaaciertos");
        String mensa = po.getProperty("etiqueta.MHRNoexistenvaloresparaestaseleccion");
        
        
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="css/crearHRuta.css"> 
        <link rel="stylesheet" href="css/menu.css" media="screen">
<!--        <link rel="stylesheet" href="css/styleicon.css"> -->
        <script src="js/dom-drag.js"></script>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script src="js/TimeEndSession.js" type="text/javascript"></script>
        <script src="js/CrearHRutaPm.js"></script>
        <title><%out.println(po.getProperty("etiqueta.MHRTituloM"));%></title>       
    </head>
    <body>
        <div class="fondo">
            <hr class="lineainicial"/>
            <div class="encabezado">                  
                <div id="header">
                    <ul class="sf-menu">
                        <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>

                        </li>
                    </ul>
                </div>
                <input id="aceptar" type="image" src="images/aceptar.png"  onclick="mostrar1()" />                
                <input  id="guardar" type="image" src="images/guardaOFF.png" disabled />               
                <input  id="regresar" type="image" src="images/regresa.PNG" onclick="back();"/>
                <input id="finalizar" type="image" src="images/cance.PNG" onclick="back();"/>
                <input  id="cancelar" type="image" src="images/cancela.PNG" onclick="back();"/>
            </div>
            <script>
                function back() {
                    window.location.href = "Bienvenido.jsp";
                } 
            </script>
            <div class="contenido">
                <div class="titulo"><h1><%out.println(po.getProperty("etiqueta.MHRTituloM"));%></h1></div>      
                <div class="imagenContenidoConsulta">
                    <div class="ContentEquipos">
                        <section class="divforhre">
                            <label ><%out.println(po.getProperty("etiqueta.HREquipo"));%></label><input id="equhr" type="text" style="background-repeat: no-repeat; background-position-x: -2%;"/>
                            <button id="match_C1" class='BtnMatchIcon2'></button>
                            <hr id="lineaclase">  
                            <label ><%out.println(po.getProperty("etiqueta.HRGrupohojasruta"));%></label><input id="ghrin" type="text" style="width: 10%;background-repeat: no-repeat; background-position-x: -2%;" />
                            <button id="match_C2" class='BtnMatchIcon2'></button>
                            <hr id="lineaclase">
                            <p class="last"></p>
                        </section>   
                            
                        <section class="divmatchequipo">
                            <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.HRvaloresprefijados"));%></label> 
                            <hr class="lineaazul">
                            <label ><%out.println(po.getProperty("etiqueta.HRPerfil"));%></label><input id="perfihr" type="text" style="width: 17%;background-repeat: no-repeat; background-position-x: -2%;" />
                            <button id="match_C3" class='BtnMatchIcon2'></button>
                            <hr id="lineaclase1">  
                            <label ><%out.println(po.getProperty("etiqueta.HRNúmeromodificacion"));%></label><input id="esqse" type="text" style="width: 27%;" />
                            <hr id="lineaclase1">
                            <label ><%out.println(po.getProperty("etiqueta.HRDíafijado"));%></label><input id="esqse" type="date" />
                            <hr id="lineaclase1">  
                      
                        </section> 
                            <br>
                            <section class="divtercri">
                                <label class="tituloequipo"><%out.println(po.getProperty("etiqueta.MHRCriteriosseleccionhojaruta"));%></label> 
                                <hr class="lineaazul">
                                <label ><%out.println(po.getProperty("etiqueta.MHUtilizacion"));%></label><input id="util" type="text" style="width: 8%;background-repeat: no-repeat; background-position-x: -2%;" />
                                <button id="match_C4" class='BtnMatchIcon2'></button>
                                <hr id="lineaclase2">
                                <label ><%out.println(po.getProperty("etiqueta.MHRCentro"));%></label><input id="centr" type="text" style="width: 11%;background-repeat: no-repeat; background-position-x: -2%;" />
                                <button id="match_C5" class='BtnMatchIcon2'></button>
                                <hr id="lineaclase2">
                                <label ><%out.println(po.getProperty("etiqueta.MHRContgrupoHRuta"));%></label><input id="cogrhr" type="text" style="width: 5%;background-repeat: no-repeat; background-position-x: -2%;" />
                                <button id="match_C6" class='BtnMatchIcon2'></button>
                                <hr id="lineaclase2">
                                <label ><%out.println(po.getProperty("etiqueta.MHRStatushojaderuta"));%></label><input id="sthrntr" type="text" style="width: 8%;background-repeat: no-repeat; background-position-x: -2%;" />
                                <button id="match_C7" class='BtnMatchIcon2'></button>
                                <hr id="lineaclase2">
                                <label ><%out.println(po.getProperty("etiqueta.MHRGrupoplani"));%></label><input id="grpl" type="text" style="width: 8%;background-repeat: no-repeat; background-position-x: -2%;" />
                                <button id="match_C8" class='BtnMatchIcon2'></button>
                                <hr id="lineaclase2">
                                <p class="last"></p>
                            </section>    
                        </div>
            <script>
                function cargar8(url){
                  
                    var env1 = document.getElementById("cen8").value;
                    var env2 = document.getElementById("cen81").value;
                    var env3 = document.getElementById("cen82").value;
                    var env5 = document.getElementById("cen83").value;
                   
                     var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            var res = xmlhttp.responseText;
                            if(res==0){
                                var iconm = document.getElementById("iconmsg");
                                iconm.style.visibility="visible";
                                iconm.src="images/aceptar.png";
                                var msg = document.getElementById("msg");
                                msg.innerHTML="<%=mensa%>";
                                setTimeout(function (){
                                   iconm.style.visibility="hidden" ;
                                   msg.innerHTML="";
                                },8000);
                            }
                            else{
                            document.getElementById("BuscarParam_u8").style.display = "none";
                            document.getElementById("ConsultaTabla8").style.display = "block";
                            document.getElementById("nofixedX8").innerHTML = res;
                            fncoch();
                          } 
                        }
                    };
                    
                    xmlhttp.open("GET","peticionHRGruPla?env1="+env1+"&env2="+env2+"&env3="+env3+"&env5="+env5,true);
                    xmlhttp.send();
                }
                    function cargar2(url){
                  
                    var env1 = document.getElementById("env").value;
                    var env2 = document.getElementById("env2").value;
                    var env3 = document.getElementById("env3").value;
                    var env4 = document.getElementById("env4").value;
                    var env5 = document.getElementById("env5").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                           document.getElementById("BuscarParam_u2").style.display = "none";
                            document.getElementById("ConsultaTabla2").style.display = "block";
                            document.getElementById("nofixedX2").innerHTML = xmlhttp.responseText;
                           fncdos();
                        }
                    };
                    xmlhttp.open("GET",url+"?env1="+env1+"&env2="+env2+"&env3="+env3+"&env4="+env4+"&env5="+env5, true);
                    xmlhttp.send();
                }
                
                
                function cargar(url){
                  
                    var env = document.getElementById("env").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                           document.getElementById("BuscarParam_u").style.display = "none";
                            document.getElementById("ConsultaTabla").style.display = "block";
                            document.getElementById("nofixedX").innerHTML = xmlhttp.responseText;
                            fnc();
                        }
                    };
                    xmlhttp.open("GET",url+"?env="+env, true);
                    xmlhttp.send();
                }
                
                function cargar5(url){
                  
                    var cen5 = document.getElementById("cen5").value;
                    var cen51 = document.getElementById("cen51").value;
                    var cen52 = document.getElementById("cen52").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                            var res = xmlhttp.responseText;
                            if(res==0){
                              var iconm = document.getElementById("iconmsg"); 
                              iconm.style.visibility ="visible";
                              iconm.src ="images/aceptar.png";
                              var men = document.getElementById("msg");
                              men.innerHTML="<%=mensa%>";
                              setTimeout(function (){
                                men.innerHTML="";
                                iconm.style.visibility="hidden";
                              }, 8000);
                            }
                            else{
                           document.getElementById("BuscarParam_u5").style.display = "none";
                            document.getElementById("ConsultaTabla5").style.display = "block";
                            document.getElementById("nofixedX5").innerHTML = res;
                            fnc();
                          }
                        }
                    };
                    xmlhttp.open("GET",url+"?cen5="+cen5+"&cen51="+cen51+"&cen52="+cen52, true);
                    xmlhttp.send();
                }

               function cargar3(url){
                  
                    var env = document.getElementById("env6").value;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                           document.getElementById("BuscarParam_u3").style.display = "none";
                            document.getElementById("ConsultaTabla3").style.display = "block";
                            document.getElementById("nofixedX3").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET",url+"?env6="+env, true);
                    xmlhttp.send();
                }
                
                
                
                function seleccionar(we,inid,id) {
                    
                    document.getElementById(inid).value = we;
                    ocultarVentana(id);
                }
                
                  function seleccionaDos(val1,in1,ven,val2,in2){
                    document.getElementById(in1).value=val1;
                    document.getElementById(in2).value=val2;
                    document.getElementById(in2).style.background ="none";
                    ocultarVentana(ven);
                    cargar8();
                }
                
                 function mostrarVentanaModal(id)
                    {
                       
                        var ventana = document.getElementById(id);                        
                        var ancho = 350;
                        var alto = 650;
                        var x = (screen.width / 2) - (ancho / 2);
                        var y = (screen.height / 2) - (alto / 2);
                        ventana.style.left = x + "px";
                        ventana.style.top = y + "px";
                        ventana.style.display = 'block';
                       
                    }
                
                
                function ocultarVentana(id)
                    {
                        var ventana = document.getElementById(id);
                        ventana.style.display = 'none';
                        document.getElementById("BuscarParam_u").style.display = "block";
                        document.getElementById("ConsultaTabla").style.display = "none";
                    }
                    
                     function fnc() {
                        document.getElementById('table-scroll').onscroll = function() {

                       document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
                        };
                        }
               
               
                    function fncdos() {
                      document.getElementById('table-scroll2').onscroll = function() {

                       document.getElementById('fixedY2').style.top = document.getElementById('table-scroll2').scrollTop + 'px';
                        };
                        }
                        
                        function fncoch() {
                      document.getElementById('table-scroll8').onscroll = function() {

                       document.getElementById('fixedY8').style.top = document.getElementById('table-scroll8').scrollTop + 'px';
                        };
                        }
                    
                     $('#match_C1').click(function () {
                        mostrarVentanaModal("VentanaModal");
                        var theHandle = document.getElementById("handle");
                        var theRoot = document.getElementById("VentanaModal");
                        Drag.init(theHandle, theRoot);
                    });
                
                    $('#match_C2').click(function () {
                        mostrarVentanaModal("VentanaModal2");
                        var theHandle = document.getElementById("handle2");
                        var theRoot = document.getElementById("VentanaModal2");
                        Drag.init(theHandle, theRoot);
                    });
                    
                    $('#match_C3').click(function () {
                        mostrarVentanaModal("VentanaModal3");
                        var theHandle = document.getElementById("handle3");
                        var theRoot = document.getElementById("VentanaModal3");
                        Drag.init(theHandle, theRoot);
                    });
                    
                    $('#match_C5').click(function (){
                        mostrarVentanaModal("VentanaModal5");
                        var theHandle = document.getElementById("handle5");
                        var theRoot = document.getElementById("VentanaModal5");
                        Drag.init(theHandle, theRoot);
                    });
                    
                    $('#match_C7').click(function(){
                       mostrarVentanaModal("VentanaModal7");
                       var theHandle = document.getElementById("handle7");
                       var theRoot =document.getElementById("VentanaMoadal7");
                       Drag.init(theHandle , theRoot)
                    });
                     $('#match_C8').click(function () {
                        mostrarVentanaModal("VentanaModal8");
                        var theHandle = document.getElementById("handle8");
                        var theRoot = document.getElementById("VentanaModal8");
                        Drag.init(theHandle, theRoot);
                    });
            </script>
                       

   <div id="VentanaModal" class="VentanaModal">
                <div id="handle"><label id="TituloMatch"><%=equipo%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%=equipo%></button><hr></div>
                <div id="BuscarParam_u">
                    <div class="fondo_Match">
                        <div class="busquedaMatch"><label><%=equipo%>
                            </label><input type="text" id="env" style="width:35%;" focus/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar('peticionEquiposHRMatch');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal');"/>
                    </div>
                </div>
                <div id="ConsultaTabla" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll">
                            <div id="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.VEDenominacióndelequipo"));%></th><th><%out.println(po.getProperty("etiqueta.VEequiposma"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>

                                        
         <div id="VentanaModal2" class="VentanaModal">
                <div id="handle2"><label id="TituloMatch"><%=HRClavedeGrupohojasderuta%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal2');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%=HRSeleccionHRuta%></button><hr></div>
                <div id="BuscarParam_u2">
                    <div class="fondo_Match">
                        <div class="busquedaMatch"><label style="margin-left:15px; margin-top:10%;"><%=tipodhrut%></label><input id="env1" aling="center" type="text" style="width: 15%; margin-left:17px; margin-top:2%;" />
                   <br> <label style="margin-left:15px; margin-top:2%;"><%=HRGrupohojaderuta%></label><input id="env2" aling="center" type="text" style="width: 30%; margin-left:16px; margin-top:2%;" />
                    <br> <label style="margin-left:15px; margin-top:2%;"><%=HRContgrupoHRuta%></label><input id="env3" aling="center" type="text" style="width: 15%; margin-left:16px; margin-top:2%;"/>
                     <br> <label style="margin-left: 15px; margin-top:2%;"><%=HRTextobreve%></label><input type="text" id="env4" aling="center" style="width: 45%; margin-left:16px; margin-top:2%;"/>
                     <br><label style="margin-left: 15px; margin-top: 2%;"><%=HRCtdmaximaaciertos%></label><input type="number" min="0" value="50" id="env5" aling="center" style="width: 10%; margin-left:16px; margin-top:2%;"/>
                 
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar2('peticionGHRutaCon');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal2');"/>
                    </div>
                </div>
                <div id="ConsultaTabla2" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll2" name="table-scroll2">
                            <div id="fixedY2" name="fixedY2">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.HRGrpHRuta"));%></th><th><%out.println(po.getProperty("etiqueta.HRCGH"));%></th><th><%out.println(po.getProperty("etiqueta.HRTxtbrvHRuta"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX2">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>
                             
                                        
     <div id="VentanaModal3" class="VentanaModal">
                <div id="handle3"><label id="TituloMatch"><%=perfil%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal3');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%=perfil%></button><hr></div>
                <div id="BuscarParam_u3">
                    <div class="fondo_Match">
                        <div class="busquedaMatch"><label><%=perfil%>
                            </label><input type="text" id="env6" style="width:35%;" focus/>
                            <hr>
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar3('peticionperfilHR');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal3');"/>
                    </div>
                </div>
                <div id="ConsultaTabla3" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll">
                            <div id="fixedY">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%=perfil%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX3">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>                                   
                                        
       
                                        
   <div id="VentanaModal5" class="VentanaModal">
       <div id="handle5"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.centromatch"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal5');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.centromatch"));%></button><hr></div>
                <div id="BuscarParam_u5">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                   <label style="margin-left:15px; margin-top:10%;"><%out.println(po.getProperty("etiqueta.MHRCentro"));%></label><input id="cen5" aling="center" type="text" style="width: 15%; margin-left:17px; margin-top:2%;" />
                   <br> <label style="margin-left:15px; margin-top:2%;"><%out.println(po.getProperty("etiqueta.Txtgrupoplanf"));%></label><input id="cen51" aling="center" type="text" style="width: 15%; margin-left:16px; margin-top:2%;"/>
                    <br><br><br><br><br><label style="margin-left: 15px; margin-top: 2%;"><%=HRCtdmaximaaciertos%></label><input type="number" min="0" value="50" id="cen52" aling="center" style="width: 10%; margin-left:16px; margin-top:2%;"/>
                 
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar5('peticionCentrosHRutaMod');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal5');"/>
                    </div>
                </div>
                <div id="ConsultaTabla5" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll5">
                            <div id="fixedY5">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%=perfil%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX5">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>
                                        
                                        
   <div id="VentanaModal7" class="VentanaModal">
       <div id="handle7"><label id="TituloMatch">Status</label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal7');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.MOHRRestricciones"));%></button><hr></div>
                <div id="BuscarParam_u7">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                   <label style="margin-left:15px; margin-top:10%;">Status</label><input id="cen5" aling="center" type="text" style="width: 15%; margin-left:17px; margin-top:2%;" />
                   <br> <label style="margin-left:15px; margin-top:2%;"><%out.println(po.getProperty("etiqueta.Txtgrupoplanf"));%></label><input id="cen51" aling="center" type="text" style="width: 15%; margin-left:16px; margin-top:2%;"/>
                    <br><br><br><br><br><label style="margin-left: 15px; margin-top: 2%;"><%=HRCtdmaximaaciertos%></label><input type="number" min="0" value="50" id="cen52" aling="center" style="width: 10%; margin-left:16px; margin-top:2%;"/>
                 
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar5('peticionCentrosHRutaMod');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal7');"/>
                    </div>
                </div>
                <div id="ConsultaTabla7" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll7">
                            <div id="fixedY7">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%=perfil%></th><th><%out.println(po.getProperty("etiqueta.MFDescripcion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX7">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>                                     
       
                                        
                                        
                                        
   <div id="VentanaModal8" class="VentanaModal">
       <div id="handle8"><label id="TituloMatch"><%out.println(po.getProperty("etiqueta.MHRGrupoplanifiDepartresponsable"));%></label><div class="BotonCerrar_Matc" onclick="ocultarVentana('VentanaModal8');"><label >X</label></div></div>
                <div class="PanelBntMatch"><button><%out.println(po.getProperty("etiqueta.MOHRRestricciones"));%></button><hr></div>
                <div id="BuscarParam_u8">
                    <div class="fondo_Match">
                        <div class="busquedaMatch">
                  <label style="margin-left:15px; margin-top:10%;"><%out.println(po.getProperty("etiqueta.MHRCentro"));%></label><input id="cen8" aling="center" type="text" style="width: 15%; margin-left:17px; margin-top:2%;" />
                   <br> <label style="margin-left:15px; margin-top:2%;"><%out.println(po.getProperty("etiqueta.MRGrupoplanif"));%></label><input id="cen81" aling="center" type="text" style="width: 30%; margin-left:16px; margin-top:2%;" />
                    <br> <label style="margin-left:15px; margin-top:2%;"><%out.println(po.getProperty("etiqueta.Txtgrupoplanf"));%></label><input id="cen82" aling="center" type="text" style="width: 15%; margin-left:16px; margin-top:2%;"/>
                    <br><br><br><br><br><label style="margin-left: 15px; margin-top: 2%;"><%=HRCtdmaximaaciertos%></label><input type="number" min="0" value="50" id="cen83" aling="center" style="width: 10%; margin-left:16px; margin-top:2%;"/>
                 
                        </div>        
                    </div> 
                    <div class="Botones_Match">
                        <img class="BtnMatchIcon" src="images/HR_ok.png" style="margin-right:-4%;" onclick="cargar8('peticionHRGruPla');"/>
                        <img class="BtnMatchIcon" src="images/btnSelMulmatch.PNG" style="margin-right:-7%; margin-top: -1%;"/>
                        <img class="BtnMatchIcon" src="images/HR_not.png" onclick="ocultarVentana('VentanaModal8');"/>
                    </div>
                </div>
                <div id="ConsultaTabla8" style="display: none;">
                    <div class="tablaCab">
                        <div id="table-scroll8">
                            <div id="fixedY8">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><%out.println(po.getProperty("etiqueta.HRCe"));%></th><th><%out.println(po.getProperty("etiqueta.HRGrPlf"));%></th><th><%out.println(po.getProperty("etiqueta.HRTextopgrupoplaneacion"));%></th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>
                            <div id="cuerpoDatos">
                                <div class="nofixedX" id="nofixedX8">
                                </div>
                            </div>
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
                                <span><input type="image" style="float:left;" id="iconmsg"></span><label  id="msg" class="msg"></label>
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

                                    function bloq() {
                                        document.getElementById('iconmsg').style.visibility = "hidden";
                                        document.getElementById('guardar').disabled = true;
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
