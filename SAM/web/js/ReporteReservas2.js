/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    startTime();
    $('#iconmsg').css('visibility', 'hidden');
};
function back() {
    window.location.href = "Bienvenido.jsp";
}
function fin() {
    window.location.href = "Bienvenido.jsp";
}
function Validar() {
    ValidarConsulta();
    
    //location.href = "VisualizarReporteReservas2.jsp";
}
function ErrorBusqueda() {
    var okcon = "No existen datos";
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "visible";
    iconm.src = "images/aceptar.png";
    var men = document.getElementById("msg");
    men.innerHTML = okcon;
}
function vali() {
    var reserva = document.getElementById("reserva").value;
    var fecha1 = document.getElementById("fechainicio").value;
    var reserva2 = document.getElementById("reserva2").value;
    var fecha2 = document.getElementById("fechafin").value;
    var centro = document.getElementById("centro").value;
    var clase = document.getElementById("clase").value;
    var material = document.getElementById("material").value;
    var almacen = document.getElementById("almacen").value;
    //var usuario = document.getElementById("usuario").value;
    var orden = document.getElementById("orden").value;


    //Crear atriutos de sesion para enviar a siguiete pagina

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

            var rs = xmlhttp.responseText;

            var men = document.getElementById("msg");
            if (rs == 1) {

                location.href = "VisualizarReporteReservas2.jsp";
            } else {
                alert("no" + rs);
                document.getElementById("").value = "";
                var iconm = document.getElementById("iconmsg");
                setTimeout(function () {

                }, 8000);

            }
        }
    };
    xmlhttp.open("GET", "ReservasMatchs?reserva=" + reserva + "&fecha1=" + fecha1 + "&reserva2=" + reserva2 + "&fecha2=" + fecha2 + "&centro=" + centro + "&clase=" + clase + "&material=" + material + "&almacen=" + almacen + "&orden=" + orden + "&Action=subir", true);
    xmlhttp.send();

}

function mostrarVentanaModal(tipo) {

    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            ConsultaCentro();
            break;
        case "reserva":
            ConsultaReserva();
            break;
        case "posicion":
            var ventana3 = document.getElementById('VentanaModalPosicion');
            abrirVentana(ventana3);
            ConsultaPosicion();
            break;
        case "reserva2":
            ConsultaReserva2();
            break;
        case "posicion2":
            var ventana5 = document.getElementById('VentanaModalPosicion2');
            abrirVentana(ventana5);
            ConsultaPosicion2();
            break;
        case "clase":
            ConsultaClase();
            break;
        case "material":
            ConsultaMaterial();
            break;
        case "almacen":
            ConsultaAlmacen();
            break;
        case "orden":
            ConsultaOrden();
            break;
        case "coste":
            var ventana10 = document.getElementById('VentanaModalCoste');
            abrirVentana(ventana10);
            ConsultaCoste();
            break;

    }
}
function abrirVentana(ventana) {

    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
}
function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case "centro":
            var ventana1 = document.getElementById('VentanaModalCentro');
            ventana1.style.display = 'none';
            document.getElementById("BuscarParamOCompras_SP").style.display = "none";
            document.getElementById("ConsultaTablaOCompras").style.display = "block";
            document.getElementById("OrgCompras").focus();
            borramsg();
            break;
        case "reserva":
            var ventana2 = document.getElementById('VentanaModalReserva');
            ventana2.style.display = 'none';
            document.getElementById("BuscarReserva").style.display = "none";
            document.getElementById("ConsultaTablaReserva").style.display = "block";
            document.getElementById("reserva").focus();
            borramsg();
            break;
        case "posicion":
            var ventana3 = document.getElementById('VentanaModalPosicion');
            ventana3.style.display = 'none';
            document.getElementById("BuscarPosicion").style.display = "none";
            document.getElementById("ConsultaTablaPosicion").style.display = "block";
            document.getElementById("posicion").focus();
            borramsg();
            break;
        case "reserva2":
            var ventana4 = document.getElementById('VentanaModalReserva2');
            ventana4.style.display = 'none';
            document.getElementById("BuscarReserva2").style.display = "none";
            document.getElementById("ConsultaTablaReserva2").style.display = "block";
            document.getElementById("reserva2").focus();
            borramsg();
            break;
        case "posicion2":
            var ventana5 = document.getElementById('VentanaModalPosicion2');
            ventana5.style.display = 'none';
            document.getElementById("BuscarPosicion2").style.display = "none";
            document.getElementById("ConsultaTablaPosicion2").style.display = "block";
            document.getElementById("posicion2").focus();
            borramsg();
            break;
        case "clase":
            var ventana6 = document.getElementById('VentanaModalClase');
            ventana6.style.display = 'none';
            document.getElementById("BuscarClase").style.display = "none";
            document.getElementById("ConsultaTablaClase").style.display = "block";
            document.getElementById("clase").focus();
            borramsg();
            break;
        case "material":
            var ventana7 = document.getElementById('VentanaModalMaterial');
            ventana7.style.display = 'none';
            document.getElementById("BuscarMaterial").style.display = "none";
            document.getElementById("ConsultaTablaMaterial").style.display = "block";
            document.getElementById("material").focus();
            borramsg();
            break;
        case "almacen":
            var ventana8 = document.getElementById('VentanaModalAlmacen');
            ventana8.style.display = 'none';
            document.getElementById("BuscarAlmacen").style.display = "none";
            document.getElementById("ConsultaTablaAlamcen").style.display = "block";
            document.getElementById("almacen").focus();
            borramsg();
            break;

        case "orden":
            var ventana9 = document.getElementById('VentanaModalOrden');
            ventana9.style.display = 'none';
            document.getElementById("BuscarOrden").style.display = "none";
            document.getElementById("ConsultaTablaOrden").style.display = "block";
            document.getElementById("orden").focus();
            borramsg();
            break;
        case "coste":
            var ventana10 = document.getElementById('VentanaModalCoste');
            ventana10.style.display = 'none';
            document.getElementById("BuscarCoste").style.display = "none";
            document.getElementById("ConsultaTablaCoste").style.display = "block";
            document.getElementById("coste").focus();
            borramsg();
            break;

    }
}

//Consultas MATCHS****************
function ConsultaCentro() {
    var url = "ReservasMatchs";
    var acc = "centro";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana1 = document.getElementById('VentanaModalCentro');
                abrirVentana(ventana1);
                document.getElementById("cargarDatosCentro").innerHTML = rs;
                fnc('table-scrollCenRes', 'fixedYCenRes');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaReserva() {
    var url = "ReservasMatchs";
    var acc = "reserva";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana2 = document.getElementById('VentanaModalReserva');
                abrirVentana(ventana2);
                document.getElementById("cargarDatosReserva").innerHTML = rs;
                fnc('table-scrollResNum', 'fixedYResNum');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaReserva2() {
    var url = "ReservasMatchs";
    var acc = "reserva2";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana4 = document.getElementById('VentanaModalReserva2');
                abrirVentana(ventana4);
                document.getElementById("cargarDatosReserva2").innerHTML = rs;
                fnc('table-scrollResNum2', 'fixedYResNum2');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaPosicion() {
    var url = "ReservasMatchs";
    var acc = "posicion";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                document.getElementById("BuscarPosicion").style.display = "none";
                document.getElementById("ConsultaTablaPosicion").style.display = "block";
                document.getElementById("cargarDatosPosicion").innerHTML = rs;
                fnc();
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}

function ConsultaPosicion2() {

    var url = "ReservasMatchs";
    var acc = "posicion2";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                document.getElementById("BuscarPosicion2").style.display = "none";
                document.getElementById("ConsultaTablaPosicion2").style.display = "block";
                document.getElementById("cargarDatosPosicion2").innerHTML = rs;
                fnc();
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaClase() {
    var url = "ReservasMatchs";
    var acc = "clase";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana6 = document.getElementById('VentanaModalClase');
                abrirVentana(ventana6);
                document.getElementById("cargarDatosClase").innerHTML = rs;
                fnc('table-scrollClasM', 'fixedYClaM');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaMaterial() {

    var url = "ReservasMatchs";
    var acc = "material";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana7 = document.getElementById('VentanaModalMaterial');
                abrirVentana(ventana7);
                document.getElementById("cargarDatosMaterial").innerHTML = rs;
                fnc('table-scrollMatRes', 'fixedYMatRes');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaAlmacen() {
    var url = "ReservasMatchs";
    var acc = "almacen";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana8 = document.getElementById('VentanaModalAlmacen');
                abrirVentana(ventana8);
                document.getElementById("cargarDatosAlmacen").innerHTML = rs;
                fnc('table-scrollSol', 'fixedYSol');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaOrden() {
    var url = "ReservasMatchs";
    var acc = "orden";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                var ventana9 = document.getElementById('VentanaModalOrden');
                abrirVentana(ventana9);
                document.getElementById("cargarDatosOrden").innerHTML = rs;
                fnc('table-scrollTxtmat', 'fixedYTxtmat');
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
function ConsultaCoste() {

    var url = "ReservasMatchs";
    var acc = "coste";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            rs = xmlhttp.responseText;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                document.getElementById("BuscarCoste").style.display = "none";
                document.getElementById("ConsultaTablaCoste").style.display = "block";
                document.getElementById("cargarDatosCoste").innerHTML = rs;
                fnc();
                borramsg();
            }
        }
    };
    xmlhttp.open("GET", url + "?Action=" + acc, true);
    xmlhttp.send();
}
//***************************


function borramsg() {
    var iconm = document.getElementById("iconmsg");
    iconm.style.visibility = "hidden";
    var men = document.getElementById("msg");
    men.innerHTML = "";
}
function fnc(scroll, fixed) {
    document.getElementById(scroll).onscroll = function () {
        document.getElementById(fixed).style.top = document.getElementById(scroll).scrollTop + 'px';
    };
}
function Select(dato, tipo) {


    switch (tipo) {
        case "centro":
            document.getElementById("centro").value = dato;
            ocultarVentana(tipo);
            break;
        case "reserva":
            document.getElementById("reserva").value = dato;
            ocultarVentana(tipo);
            break;
        case "reserva2":
            document.getElementById("reserva2").value = dato;
            ocultarVentana(tipo);
            break;
        case "posicion":
            document.getElementById("posicion").value = dato;
            ocultarVentana(tipo);
            break;
        case "posicion2":
            document.getElementById("posicion2").value = dato;
            ocultarVentana(tipo);
            break;
        case "clase":
            document.getElementById("clase").value = dato;
            ocultarVentana(tipo);
            break;
        case "material":
            document.getElementById("material").value = dato;
            ocultarVentana(tipo);
            break;
        case "almacen":
            document.getElementById("almacen").value = dato;
            ocultarVentana(tipo);
            break;
        case "orden":
            document.getElementById("orden").value = dato;
            ocultarVentana(tipo);
            break;
        case "coste":
            document.getElementById("coste").value = dato;
            ocultarVentana(tipo);
            break;
    }
}

function validarCentro() {

    var url = "PeticionVisualizarReportesSP";
    var acc = "ValidarCentro";
    var centro = document.getElementById("centro");
    var c = centro.value;

    if (c.length > 0) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                rs = xmlhttp.responseText;
                if (rs == 0) {
                    var okcon = "No se encuentra en el Sistema el centro : " + c.toUpperCase();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    centro.value = '';
                    centro.focus();
                } else {
                    borrarmsg();
                }
            }
        };

        xmlhttp.open("GET", url + "?Action=" + acc + "&centro=" + c, true);
        xmlhttp.send();
    }
}

function validarsam() {

    var url = "PeticionVisualizarReportesSP";
    var acc = "ValidarSAM";
    var sam = document.getElementById("sami");
    var c = sam.value;

    if (c.length > 0) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                rs = xmlhttp.responseText;
                if (rs == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sam : " + c.toUpperCase();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    sam.value = '';
                    sam.focus();
                } else {
                    borrarmsg();
                }
            }
        };

        xmlhttp.open("GET", url + "?Action=" + acc + "&sam=" + c, true);
        xmlhttp.send();
    }
}

function validarsam2() {

    var url = "PeticionVisualizarReportesSP";
    var acc = "ValidarSAM";
    var sam = document.getElementById("samf");
    var c = sam.value;

    if (c.length > 0) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                rs = xmlhttp.responseText;
                if (rs == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sam : " + c.toUpperCase();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    sam.value = '';
                    sam.focus();
                } else {
                    borrarmsg();
                }
            }
        };

        xmlhttp.open("GET", url + "?Action=" + acc + "&sam=" + c, true);
        xmlhttp.send();
    }
}

function validarsap() {

    var url = "PeticionVisualizarReportesSP2";
    var acc = "ValidarSAP";
    var sap = document.getElementById("sapi");
    var c = sap.value;

    if (c.length > 0) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                rs = xmlhttp.responseText;
                if (rs == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sap : " + c.toUpperCase();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    sap.value = '';
                    sap.focus();
                } else {
                    borrarmsg();
                }
            }
        };

        xmlhttp.open("GET", url + "?Action=" + acc + "&sap=" + c, true);
        xmlhttp.send();
    }
}

function validarsap2() {

    var url = "PeticionVisualizarReportesSP2";
    var acc = "ValidarSAP";
    var sap = document.getElementById("sapf");
    var c = sap.value;

    if (c.length > 0) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {

            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                rs = xmlhttp.responseText;
                if (rs == 0) {
                    var okcon = "No se encuentra en el Sistema el folio sap : " + c.toUpperCase();
                    var iconm = document.getElementById("iconmsg");
                    iconm.style.visibility = "visible";
                    iconm.src = "images/advertencia.PNG";
                    var men = document.getElementById("msg");
                    men.innerHTML = okcon;
                    sap.value = '';
                    sap.focus();
                } else {
                    borrarmsg();
                }
            }
        };

        xmlhttp.open("GET", url + "?Action=" + acc + "&sap=" + c, true);
        xmlhttp.send();
    }
}
function ValidarConsulta() {
    borramsg();
    var reserva = $("#reserva").val();
    var fecha1 = $("#fechainicio").val();
    var reserva2 = $("#reserva2").val();
    var fecha2 = $("#fechafin").val();
    var centro = $("#centro").val();
    var clase = $("#clase").val();
    var material = $("#material").val();
    var almacen = $("#almacen").val();
    var orden = $("orden").val();
    
    var acc = "ValidarQuery";
    var enviar = "&reserva=" + reserva + "&reserva2=" + reserva2 + "&fecha1=" + fecha1 + "&fecha2=" + fecha2 + "&centro=" + centro+ "&clase="+clase+ "&material="+material+"&almacen="+almacen+"&orden="+orden;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ReservasMatchs',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                vali();
            }
        }
    });
}