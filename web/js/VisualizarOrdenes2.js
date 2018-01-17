/* global Drag */

$(document).ready(function () {
    
    $('#VisDoo').click(function () {
        VisDoc();
//        if ($("#idUbiTec").val() != "") {
//            VisDoc();
//        } else {
//            ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
//        }
    });
    
    $('#VisVis').click(function () {        
        var position = $('#ubtecPosOc').val();
        SendPath(position);
        ocultarVenAv('VenAvv');
    });
    $('#ViGuarAr').click(function () {
        var posit = $('#ubtecPosOc').val();
        SendMod(posit);
        ocultarVenAv('VenAvv');
    });
    $('#tabcabec').css({"background": "#007CC0", "color": "#fff"});

    var arrb3 = [
        $('#tabcabec'),
        $('#tabsOp'),
        $('#tabComp'),
        $('#tabcost'),
        $('#TabObje'),
        $('#tabdatA'),
        $('#tabEmplz'),
        $('#tabplani'),
        $('#tabsctrl')
    ];
    $.each([$('#seccioncabecera'), $('#taboperacion'), $('#tabComponentes'), $('#SecDatosAdc'), $('#tabObjetos'), $('#tabCostes'), $('#SeccionEmplaz_ord'), $('#tabseccionplanif'), $('#tabSeccionControl')], function (i, v) {
        v.hide();
        $.each(arrb3, function (a, f) {
            f.click(function () {
                v.hide();
                if (i == a) {
                    v.show();
                    color2(i, f);
                    return;
                }
            });
        });
    });

    function color2(i, v) {
        $.each(arrb3, function (a, f) {
            f.css({"background": "#fff", "color": "#000"});
        });
        for (j = 0; j < arrb3.length; j++) {
            if (i == j) {
                v.css({"background": "#007CC0", "color": "#fff"});
            }
        }
    }

});

function VisDoc() {
    acc = "matchDocs";
    var equi = $("#equ_ord").val().toUpperCase();
    var cenEqui = equi.substring(0, 4);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&equi=" + equi + "&centroo=" + cenEqui,
        success: function (rs) {
            if (rs == 0) {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
            } else {
                blockPropiety('handle3', 'VentanaModalCentroP');
                $('#SecCuerpo4').html(rs);
                AjustarCabecera('TabHead4', 'TabBody4', 36, 'SecCuerpo4');
                fncCentroP();
                //borramsg();
            }
        }
    });
}
function fncCentroP() {
    $('#table-scrollCentroP').scroll(function () {
        $('#fixedYCentroP').css({top: $('#scrollCentroP').scrollTop()});
    });
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function ocultarVentanaaVO(tipo) {
    switch (tipo) {
        case "CentroP":
            var ventana = $('#VentanaModalCentroP');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function SendPath(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarRuta(cad);
}
function EnviarRuta(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            }
        }
    };
    xmlhttp.open("GET", "peticionVisualizarOrden2?acc=EnviarSocket&ruta=" + ruta, true);
    xmlhttp.send();
}

function abrVen(c2){
    $("#ubtecPosOc").val(c2);
    $("#VentanaModalCentroP").hide();
    var ventana = document.getElementById('VentUbTecAvvv');
    abrirVentanaAv(ventana);
    blockPropiety('handleAvvv', 'VentUbTecAvvv');
}
function abrirVentanaAv(ventana){
    var ancho = 900;
    var alto = 250;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    //document.getElementById("lbAv").innerHTML = msg;
}
function SendMod(c)
{
    var ficheros = document.getElementsByName('tdFch');
    var path = ficheros[c].textContent;
    var carpets = path.split("\\");
    var cad = carpets[3] + "," + carpets[4] + "," + carpets[5];
    EnviarModificar(cad);
}
function EnviarModificar(ruta)
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            if (xmlhttp.responseText == 1)
            {
                document.getElementById("msg").innerHTML = "Error al cargar el Archivo";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
            } else {
                document.getElementById("msg").innerHTML = "";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "hidden";
            }
        }
    };
    xmlhttp.open("GET", "peticionVisualizarOrden2?acc=EnviarMod&ruta=" + ruta, true);
    xmlhttp.send();
}
function ocultarVenAv(tipo){
    switch (tipo) {
        case "VenAvv":
            var ventana = $('#VentUbTecAvvv');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}
function cargarCabecera() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        var Acc = "CargarDatosCabeceraSAP";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#claseOrden_orden').val(rs[0]);
                $('#Des_orden').val(rs[1]);
                $('#statusSis_orden').val(rs[2]);
                $('#rs_ord').val(rs[3]);
                $('#rs2_ord').val(rs[4]);
                $('#not_ord').val(rs[5]);
                $('#cos_ord').val(rs[6]);
                $('#Cl_ord').val(rs[7]);
                $('#Est_ord').val(rs[8]);
                $('#inic_ord').val(rs[9]);
                $('#fin_ord').val(rs[10]);
                $('#prior_ord').val(rs[11]);
                $('#revi_ord').val(rs[12]);
                $('#ubic_ord').val(rs[13]);
                $('#lbldescr_ord1').val(rs[14]);
                $('#equ_ord').val(rs[15]);
                $('#desequipo').val(rs[16]);
                $('#Conj_ord').val(rs[17]);
                $('#opera_ord').val(rs[18]);
                $('#ptotr_ord').val(rs[20]);
                $('#ptotr2_ord').val(rs[21]);
                $('#clvctrol_ord').val(rs[22]);
                $('#cant_ord').val(rs[27]);
                $('#duraoper_ord').val(rs[28]);
                $('#duraoper2_ord').val(rs[29]);
                $('#DescOper_ord').val(rs[32]);
//                $('#trinv_ord').val(rs[23]);
//                $('#trinv2_ord').val(rs[24]);
//                $('#cant_ord').val(rs[25]);
//                $('#duraoper_ord').val(rs[26]);
//                $('#duraoper2_ord').val(rs[27]);
                $('#gpoPlan_ord').val(rs[31]);
                $('#gpoPlan2_ord').val(rs[4]);
            }
        });
    } else if (ordType == 2) {
        Acc = "CargarDatosCabeceraSAM";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#claseOrden_orden').val(rs[0]);
                $('#Des_orden').val(rs[1]);
                $('#rs_ord').val(rs[2]);
                $('#rs2_ord').val(rs[3]);
                $('#Cl_ord').val(rs[0]);
                $('#inic_ord').val(rs[4]);
                $('#fin_ord').val(rs[5]);
                $('#ubic_ord').val(rs[6]);
                $('#equ_ord').val(rs[7]);
                $('#opera_ord').val(rs[8]);
                $('#ptotr_ord').val(rs[9]);
                $('#ptotr2_ord').val(rs[10]);
                $('#clvctrol_ord').val(rs[11]);
                $('#cant_ord').val(rs[12]);
                $('#duraoper_ord').val(rs[13]);
                $('#duraoper2_ord').val(rs[14]);
                $('#DescOper_ord').val(rs[16]);
//                $('#ptotr_ord').val(rs[9]);
//                $('#ptotr2_ord').val(rs[10]);
//                $('#clvctrol_ord').val(rs[11]);
//                $('#cant_ord').val(rs[12]);
//                $('#duraoper_ord').val(rs[13]);
//                $('#duraoper2_ord').val(rs[14]);
//                $('#gpoPlan_ord').val(rs[15]);
//                $('#gpoPlan2_ord').val(rs[3]);
            }
        });
    }

}

function CargarTablaOperacion() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        url = 'peticionVisualizarOrden2';
        Acc = "CargarTablaOpSAP";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#CargarOperaciones').html(rs);
            }
        });
    } else if (ordType == 2) {
        Acc = "CargarTablaOpSAM";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#CargarOperaciones').html(rs);
            }
        });
    }
}
function CargarTablaComponentes() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        Acc = "CargarTablaCompSAP";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#CargaComponent').html(rs);
            }
        });
    } else if (ordType == 2) {
        Acc = "CargarTablaCompSAM";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#CargaComponent').html(rs);
            }
        });

    }
}
function checkTypeEquiUbi() {
    var equi = $("#equ_ord").val();
    if (equi.length > 0) {
        return 1;
    } else {
        return 0;
    }
}
function CargarPestEmpl() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        Acc = "CargarEmplzSAP";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {

                $('#centrempl_ord').val(rs[0]);
                $('#empl_ord').val(rs[1]);
                $('#local_ord').val(rs[2]);
                $('#areempres_ord').val(rs[3]);
                $('#puesto_ord').val(rs[4]);
                $('#indicad_ord').val(rs[5]);
                $('#campoclas_ord').val(rs[6]);
                $('#socieimp_ord').val(rs[7]);
                $('#actfijo_ord').val(rs[8]);
                $('#actfijo2_ord').val(rs[9]);
                $('#cencoste_ord').val(rs[10]);
                $('#elementoPep_ord').val(rs[11]);
            }
        });
    } else if (ordType == 2) {
        var check = checkTypeEquiUbi();
        if (check == 1) {
            consultaEmplEqui();
        } else {
            consultaEmplUbiT();
        }
    }
}

function consultaEmplEqui() {
    Acc = "CargarEmplzSAMequi";
    var equi = $("#equ_ord").val();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + Acc + "&Clave=" + equi,
        success: function (rs) {
            $('#centrempl_ord').val(rs[0]);
            $('#empl_ord').val(rs[1]);
            $('#areempres_ord').val(rs[2]);
            $('#puesto_ord').val(rs[3]);
            $('#indicad_ord').val(rs[4]);
            $('#campoclas_ord').val(rs[5]);
            $('#socieimp_ord').val(rs[6]);
            $('#actfijo_ord').val(rs[7]);
            $('#cencoste_ord').val(rs[8]);
        }
    });
}
function consultaEmplUbiT() {
    Acc = "CargarEmplzSAMubi";
    var equi = $("#ubic_ord").val();
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + Acc + "&Clave=" + equi,
        success: function (rs) {
            $('#centrempl_ord').val(rs[0]);
            $('#empl_ord').val(rs[1]);
            $('#areempres_ord').val(rs[2]);
            $('#puesto_ord').val(rs[3]);
            $('#indicad_ord').val(rs[4]);
            $('#campoclas_ord').val(rs[5]);
            $('#socieimp_ord').val(rs[6]);
            $('#cencoste_ord').val(rs[7]);
        }
    });
}



function CargarPestPlanific() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        Acc = "CargarPlanifSAP";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#planmant_ord').val(rs[0]);
                $('#posmant_ord').val(rs[1]);
                $('#TipoHojaruta_ord').val(rs[2]);
                $('#GpoHRuta_ord').val(rs[3]);
                $('#ContGpoHRuta_ord').val(rs[4]);
            }
        });
    } else if (ordType == 2) {
        Acc = "CargarPlanifSAM";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
//               tablas en espera......
            }
        });
    }
}
function CargarPestCtrl() {
    var ord = $('#mjorden').val();
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        Acc = "CargarCtrlSAP";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#autorcontrol_ord').val(rs[0]);
                $('#fentradactrl_ord').val(rs[1]);
                $('#modctrl_ord').val(rs[2]);
                $('#fecmodfctrl_ord').val(rs[3]);
            }
        });
    } else if (ordType == 2) {
        Acc = "CargarCtrlSAM";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'peticionVisualizarOrden2',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "acc=" + Acc + "&ord=" + ord,
            success: function (rs) {
                $('#autorcontrol_ord').val(rs[1]);
                $('#fentradactrl_ord').val(rs[0]);
                $('#fecmodfctrl_ord').val(rs[2]);
                if (rs[2].length > 0) {
                    $('#modctrl_ord').val(rs[1]);
                }

            }
        });
    }
}


function OpenServices(rs) {
    getDate(rs);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = document.getElementById('ServicioOperacion');
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    var theHandle = document.getElementById("handleSer");
    var theRoot = document.getElementById("ServicioOperacion");
    Drag.init(theHandle, theRoot);

}

function getDate(rs) {
    document.getElementById("gloSer").innerHTML = rs;
}

function CerrarServices() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    document.getElementById("ServicioOperacion").style.display = 'none';
}

function SelectServices(obj) {
    var op = new Array();
    op = obj.split("|");
    var obj1 = op[0];
    var obj2 = op[1];
    var ordType = $('#mjtipoOrd').val();
    if (ordType == 1) {
        if (obj1 == "PM02") {
//            alert("q.- " + obj1 + "  f.-" + obj2);
            Abre(obj1, obj2);
//            Abre2(obj1, obj2);
        } else {
            var menCam = "No hay Servicios en esta operación";
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#iconmsg').show();
            $('#msg').html(menCam);
        }
    } else if (ordType == 2) {
        if (obj1 == "PM02" || obj1 == "PM03") {
            AbreSAM(obj1, obj2);
//            Abre2SAM(obj1, obj2);
        } else {
            var menCam = "No hay servicios en esta operacion";
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#msg').html(menCam);
        }
    }
}

function Abre2(clave, op) {
    var url = '<%=petic%>';
    var acc = "GetDatosCabe";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var rs = xmlhttp.responseText;
            if (rs == 0) {
                var menCam = "no existen datos";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                iconm.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = menCam;
            } else {

                document.getElementById("contenidoo").innerHTML = rs;
                pasaDatos();
            }
        }
    };
    xmlhttp.open("GET", url + "?acc=" + acc + "&Clave=" + clave + "&Ope=" + op + "&NumOr=" + '<%=orden%>', true);
    xmlhttp.send();
}

function pasaDatos() {
    var ctdop = document.getElementById("CtdOpera_SER2").value;
    document.getElementById("CtdOpera_SER").value = ctdop;
    var pr = document.getElementById("Precio_SER2").value;
    document.getElementById("precio_SER").value = pr;
    var grupati = document.getElementById("GrupoAti_SER2").value;
    document.getElementById("GrupoAti_SER").value = grupati;
    var grcmpra = document.getElementById("grcompra_SER2").value;
    document.getElementById("grcompra_SER").value = grcmpra;
    var cntrato = document.getElementById("contrato_SER2").value;
    document.getElementById("contrato_SER").value = cntrato;
    var dstinatario = document.getElementById("Destinatario_SER2").value;
    document.getElementById("Destinatario_SER").value = dstinatario;
    var slicitante = document.getElementById("solicitante_SER2").value;
    document.getElementById("solicitante_SER").value = slicitante;
    var plnt = document.getElementById("plaentprev_SER2").value;
    document.getElementById("plaentprev_SER").value = plnt;

    var cls = document.getElementById("cl.clas_SER2").value;
    document.getElementById("cl.clas_SER").value = cls
    var pr = document.getElementById("por_SER2").value;
    document.getElementById("por_SER").value = pr;
    var clasecs = document.getElementById("clasecos_SER2").value;
    document.getElementById("clasecos_SER").value = clasecs;
    var acrees = document.getElementById("acree_SER2").value;
    document.getElementById("acree_SER").value = acrees;
    var reginf = document.getElementById("reginfo_SER2").value;
    document.getElementById("reginfo_SER").value = reginf;
    var pustodes = document.getElementById("puestodes_SER2").value;
    document.getElementById("puestodes_SER").value = pustodes;
    var necs = document.getElementById("Neces_SER2").value;
    document.getElementById("Neces_SER").value = necs;
    var pdmr = document.getElementById("pdmar_SER2").value;
    document.getElementById("pdmar_SER").value = pdmr;

}

function Abre(clave, op) {
    var acc = "GetDatosTablaSAP";
    var ord = $('#mjorden').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&Clave=" + clave + "&Ope=" + op + "&NumOr=" + ord,
        success: function (rs) {
            if (rs == 0) {
                var con = "No hay datos en la tabla";
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                $('#msg').html(con);
            } else {
                OpenServices(rs);
            }
        }
    });

}
function AbreSAM(clave, op) {
    var Acc = "GetDatosTabla";
    var ord = $('#mjorden').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + Acc + "&Clave=" + clave + "&Ope=" + op + "&NumOr=" + ord,
        success: function (rs) {
            if (rs == 0) {
                var con = "No hay datos en la tabla";
                var iconm = document.getElementById("iconmsg");
                iconm.style.visibility = "visible";
                icon.src = "images/advertencia.PNG";
                var men = document.getElementById("msg");
                men.innerHTML = con;
            } else {
                OpenServices(rs);
            }
        }
    });
}


function checkTab(type) {
    switch (type) {
        case 'cab':
            $('#tabs').html($('#mjTablbl1').val());
            break;
        case 'tabsOp':
            $('#tabs').html($('#mjTablbl2').val());
            break;
        case 'tabComp':
            $('#tabs').html($('#mjTablbl3').val());
            break;
        case 'tabcost':
            $('#tabs').html($('#mjTablbl4').val());
            break;
        case 'TabObje':
            $('#tabs').html($('#mjTablbl5').val());
            break;
        case 'tabdatA':
            $('#tabs').html($('#mjTablbl6').val());
            break;
        case 'tabEmplz':
            $('#tabs').html($('#mjTablbl7').val());
            break;
        case 'tabplani':
            $('#tabs').html($('#mjTablbl8').val());
            break;
        case 'tabsctrl':
            $('#tabs').html($('#mjTablbl9').val());
            break;
    }
}

function mostrarVentanaModal()
{
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaVIAR");
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById('VentanaVIAR');
    abrirVentana(ventana);
    cargarTab();
}


function abrirVentana(ventana) {
    ///abrir ventanas
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



function cargarTab() {
    var enviar = "hola";

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionCargaFIle',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos").html(data);
        }

    });
}

function mandvalo(val) {
    var enviar = "&val=" + val;

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionCargaFIle',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: enviar,
        success: function (data) {
            $("#cargarDatos").html(data);
        }

    });
}
function checkAdr() {
    acc = "checkAd";
    var ord = $("#mjorden").val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + acc + "&ord=" + ord,
        success: function (rs) {
            if (rs == 0) {

            } else {
                $('#loadAd').html(rs);
            }


        }
    });
}
function fncDocs() {
    $('#table-scrollArch').scroll(function () {
        $('#fixedYArch').css({top: $('#table-scrollArch').scrollTop()});
    });
}
function blockPropiety(handle, ventanaM) {
    var theHandle = document.getElementById(handle);
    var theRoot = document.getElementById(ventanaM);
    Drag.init(theHandle, theRoot);
    var ventana = document.getElementById(ventanaM);
    abrirVentana(ventana);
}
function abrirVentana(ventana) {
    var ancho = 800;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.style.left = x + "px";
    ventana.style.top = y + "px";
    ventana.style.display = 'block';
    var iconm = $('#iconmsg');
    var men = $('#msg');
    men.html("");
    iconm.hide();
}

function ocultarVentanaa(tipo) {
    switch (tipo) {
        case "CentroP":
            var ventana = $('#VentanaModalArch');
            ventana.hide();
            $('#overlay').remove();
            break;
    }
}

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
    myTableCb.style.width = val + 17 + "px";
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
}

function AbrirMatchDes(numop, tipo) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarOrden2',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "acc=" + tipo + "&ord=" + $('#Num_orden').val() + "&Ope=" + numop,
        success: function (rs) {
             mostrarVentanaModalib(numop, rs);
        }
    });
}
function mostrarVentanaModalib(op, res) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModalTextli');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    var theHandle = document.getElementById("handle12");
    var theRoot = document.getElementById("VentanaModalTextli");
    Drag.init(theHandle, theRoot);
    $('#opCurrent').html(op);
    $('#Textlib').val(res);
}
function ocultartexa() {
    $("#VentanaModalTextli").css('display', 'none');
    $("#Textlib").val("");
}