$(document).ready(function () {
    startTime();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#cancelar').prop('disabled', true);
    $('#iconmsg').hide();
    $('#btnmatch').hide();
    $('#idUbiTec').focus(function () {
        $('#btnmatch').show();
    });

    var UbiTec = $('#idUbiTec');
    var Clase = $('#Clase');
    var GrupoAutoriz = $('#GrupoAutoriz');
    var Peso = $('#Peso');
    var NInventario = $('#NInventario');
    var TamanoDimens = $('#TamanoDimens');
    var PstaenServ = $('#PstaenServ');
    var CeEmplazam = $('#CeEmplazam');
    var Emplazamiento = $('#Emplazamiento');
    var AreaEmpresa = $('#AreaEmpresa');
    var PuestoTrabajo = $('#PuestoTrabajo');
    var IndicadorABC = $('#IndicadorABC');
    var Sociedad = $('#Sociedad');
    var ActivoFijo = $('#ActivoFijo');
    var ActivoFijoDos = $('#ActivoFijoDos');
    var Centro = $('#Centro');
    var SociedadCC = $('#SociedadCC');
    var CentroPlanif = $('#CentroPlanif');
    var GrupoPlanif = $('#GrupoPlanif');
    var PtoTbjoResp = $('#PtoTbjoResp');
    var PtoTbjoRespDos = $('#PtoTbjoRespDos');
    var UbicTecn = $('#UbicTecn');


    var arrayDAT = [
        Clase,
        GrupoAutoriz,
        Peso,
        NInventario,
        TamanoDimens,
        PstaenServ,
        CeEmplazam,
        Emplazamiento,
        AreaEmpresa,
        PuestoTrabajo,
        IndicadorABC,
        Sociedad,
        ActivoFijo,
        ActivoFijoDos,
        Centro,
        SociedadCC,
        CentroPlanif,
        GrupoPlanif,
        PtoTbjoResp,
        PtoTbjoRespDos,
        UbicTecn
    ];
    $.each(arrayDAT, function (i, v) {
        v.prop("disabled", true);
//        $('#guardar').prop("disabled", true);
    });

    $('#guardar').click(function () {
        GuardarDatosUbTecNew();
    });
    $('#btnmatch').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal();
    });
    $('#okUbic').click(function () {
        ConsultaUbicacionTec();
    });
    $('#aceptar').click(function () {
        CargaDatos();
        $('#guardar').prop("disabled", false);
//        $('#aceptar').prop("disabled", true);
//        $('#guardar').css('background-image', 'url(images/guarda.PNG)');       
        $('#guardar').attr('src', 'images/guarda.PNG')
        $.each(arrayDAT, function (i, v) {
            v.prop("disabled", false);
        });
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    function GuardarDatosUbTecNew() {
        alert("guardar");
        var acc = "GuardarDatos";
//        var par = "&idUbTec=" + IDUBTEC.val() + "&clase=" + CLASE.val() + "&gpoAutor=" + GPOAUTOR.val() + "&peso=" + PESO.val() + "&nInvent=" + NINVENT.val() + "&tamDim=" + TAMDIM.val() + "&pStaEnSer=" + PSTAENSER.val() + "&cEmplaz=" + CEMPLAZAM.val() + "&emplaz=" + EMPLAZAM.val() + "&areaEmp=" + AREAEMP.val() + "&ptoTrab=" + PTOTRAB.val() + "&indAbc=" + INDABC.val() + "&centro=" + CENTRO.val() + "&socied=" + SOCIED.val() + "&actFijo=" + ACTFIJO.val() + "&actFijoDos=" + ACTFIJODOS.val() + "&sociedCC=" + SOCIEDADCC.val() + "&centroPlani=" + CENTROPLANIF.val() + "&gpoPlanif=" + GPOPLANIF.val() + "&ptoTrabRes=" + PTOTRABRES.val() + "&ptoTrabResDos=" + PTOTRABRESDOS.val() + "&ubtec=" + UBTEC.val(); 
        var par = "&idUbTec=" + UbiTec.val() + "&clase=" + Clase.val() + "&gpoAut=" + GrupoAutoriz.val() + "&peso=" + Peso.val() + "&nInvent=" + NInventario.val() + "&tamDim=" + TamanoDimens.val() + "&pStaEnSer=" + PstaenServ.val() + "&cEmplaz=" + CeEmplazam.val() + "&emplaz=" + Emplazamiento.val() + "&areaEmp=" + AreaEmpresa.val() + "&ptoTrab=" + PuestoTrabajo.val() + "&indAbc=" + IndicadorABC.val() + "&socied=" + Sociedad.val() + "&actFijo=" + ActivoFijo.val() + "&actFijoDos=" + ActivoFijoDos.val() + "&centro=" + Centro.val() + "&sociedadCc=" + SociedadCC.val() + "&centroPlani=" + CentroPlanif.val() + "&gpoPlanif=" + GrupoPlanif.val() + "&ptoTrabRes=" + PtoTbjoResp.val() + "&ptoTrabResDos=" + PtoTbjoRespDos.val() + "&ubtec=" + UbicTecn.val();
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "PeticionModificaUbicacionesTecPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                alert(data);
                if (data == 5) {
                    //Moficacion exitosa
                    ShowMsg(2, "images/aceptar.png", "audio/sapmsg.wav");
//                    limpiar();
//                    reiniDatOb();                    
                }
                if (data == 6) {
                    //Error al modificar
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
//                    reiniDatOb();
//                    limpiar();

                }
            }
        });
    }
});
function ConsultaUbicacionTec() {
    var acc = "ConsultarMatchUbicacion";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionModuloVisualizarUbicacionesTecPP',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Acc=" + acc + "&Ubi=" + $("#ubictBus").val() + "&DUbi=" + $("#DesUbiBus").val() + "&Ctd=" + $("#numAcMax").val() + "&Idioma=" + $("#IdioMat").val(),
        success: function (data) {
            if (data == 0) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                BE.play();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/aceptar.png');
                msgMatch("menValores");
            } else {
                $('#BuscarParamUbi').hide();
                $('#ConsultaTabla').show();
                $('#cargarDatos').html(data);
                fnc();
//                borrarmsg();
            }
        }
    });
}
function CargaDatos() {
    var ubic = $("#idUbiTec").val();
    if (ubic.length < 1) {
        var BE = document.createElement('audio');
        BE.src = "audio/saperror.wav";
        BE.play();
        $("#idUbiTec").focus();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        msgMatch("CampoOb");
        cleandat();
    } else {
        var acc = "CargarDatosUbicaciones";
        $.ajax({
            async: false,
            type: 'GET',
            dataType: "json",
            url: 'peticionModuloVisualizarUbicacionesTecPP',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Acc=" + acc + "&Ubi=" + $("#idUbiTec").val() + "&Idioma=" + $("#IdioMat").val(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    msgMatch("existeFol");
                    cleandat();
                } else {
                    var a = data;
                    $("#DesUbiTec").val(a[0]);
                    $("#GrupoAutoriz").val(a[1]);
                    $("#CentroPlanif").val(a[2]);
                    $("#CeEmplazam").val(a[3]);
                    $("#Emplazamiento").val(a[4]);
                    $("#Sociedad").val(a[5]);
                    $("#Centro").val(a[6]);
                    $("#AreaEmpresa").val(a[7]);
                    $("#GrupoPlanif").val(a[8]);
                    $("#UbicTecn").val(a[9]);
                    $("#SociedadCC").val(a[10]);
                    $("#PuestoTrabajo").val(a[11]);
                    $("#PtoTbjoResp").val(a[11]);
                    $("#PtoTbjoRespDos").val(a[2]);
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/aceptar.png');
                    msgMatch("OkConsult");
                }
            }
        });
    }
}
function mostrarVentanaModal() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').css({
        position: 'absolute', left: 510, top: 60
    });
    $('#VentanaModal').show();
    $('#ubictBus').val("").focus();
    $('#DesUbiBus').val("");
    $('#numAcMax').val("500");
    $('#msg').html("");
    $('#iconmsg').hide();
}
function ocultarVentana() {
    $('#VentanaModal').hide();
    $('#BuscarParamUbi').show();
    $('#ConsultaTabla').hide();
    $('#idUbiTec').focus();
}
function fnc() {
    document.getElementById('table-scroll').onscroll = function () {
        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}
function Select(we) {
    var se = $("#idUbiTec").val(we);
    se.focus();
    ocultarVentana();
}
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
    m = checkTime(m);
    s = checkTime(s);
    $('#tiempo').html(h + ":" + m + ":" + s);
    t = setTimeout('startTime()', 500);
}

function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
    