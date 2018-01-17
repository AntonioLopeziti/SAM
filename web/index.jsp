<%-- 
    Document   : index
    Created on : 11/04/2016, 06:38:09 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico">       
        <link rel="stylesheet" href="css/StyleGeneral.css">
        <link rel="stylesheet" href="css/StyleIndex.css">
        <link rel="stylesheet" href="css/menu.css" media="screen">
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script> 
        <script type="text/javascript" src="js/sha1.js"></script>        
        <script src="js/menu.js"></script>
        <script src="js/jquerys.js"></script>   
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.js"></script>   
        <script src="js/dom-drag.js"></script>
        <title>SAM</title>
    </head>
    <body>
        <div id="main-header">  
            <hr>
            <div id="header">
                <ul class="sf-menu">
                    <li  class="current" style="background: #E2E2E2; padding-left: 0; width: 52px; border:  1px solid #ccc; text-align: left; margin-bottom: 0; margin-right: 20px;"><a href="javascript:inval();" style="margin-left:-0.8em;">Menú</a><div class="arrowc"></div>
                    </li>
                </ul>
            </div>
            <input id="aceptar" type="image" src="images/aceptar.png"/>                
            <input  id="guardar" type="image" src="images/guardaOFF.png" />               
            <input  id="regresar" type="image" src="images/regresaOFF.png"/>
            <input id="finalizar" type="image" src="images/canceOFF.png"/>
            <input  id="cancelar" type="image" src="images/cancelaOFF.png"/>
            <div class="titulo"><h1>SAM</h1></div>
        </div>
        <div class="contenido">
            <div class="login">                  
                <div class="user">
                    <label>Usuario</label><input style="text-transform: uppercase;" name="Usuario" id="Usuario"  type="text" maxlength="20" required>
                    <hr>    
                    <label>Clv.acc.</label><input  name="Password" id="Password"  placeholder="******************************" type="password">
                    <hr>
                </div>    
                <div class="idioma">
                    <label>Idioma</label><input id="idiom" style="text-transform: uppercase;" maxlength="2" type="text" value="ES"/>               
                    <hr>
                </div>
            </div>             
            <div class="imagen">
                <div class="logo">
                    <IMG SRC="images/Logo_Empresa.png"  ALT="Logo">
                </div>
            </div>              
        </div> 
        <div id="VentanaModalInicio" class="VentanaModalLogin">
            <div id="handlelo"><label>  SAM: Modificar clve.acc. para </label> <label id="userclave"></label><div class="BotonCeLo" id="Cerrarventana2"><label >X</label></div></div>
            <div id="divLogin">
                <label>Clave acc.nva</label><input type="password" id="pwdnueva" placeholder="***************************************************************************"/>
                <hr>
                <label>Repetir clave de acceso</label><input type="password" id="pwdnueva2" placeholder="*********************************************************************************************"/>
                <hr>
            </div>
            <div class="infodata"><img src="images/infoicono.PNG"><label>Mayuscúlas/Minuscúlas se distinguen</label></div>
            <div class="Botonesfinal">
                <img class="BtnMatchIcon" src="images/HR_ok.png" id="okUser"/>   
                <img class="BtnMatchIcon" src="images/S_B_CANC.gif" id="Cerrarventana"/>
            </div>
        </div>
        <footer>
            <hr class="fecha" id="footerline">
            <div  class="fecha">
                <label id="fecha" name="fecha"></label><label>, </label> 
                <label id="tiempo" name="tiempo"></label>
                <span><input type="image" style="float:left; margin-top: -2px;" id="iconmsg"></span><label  id="msg" class="msg"></label>
            </div>
        </footer>
    </body>
</html>
