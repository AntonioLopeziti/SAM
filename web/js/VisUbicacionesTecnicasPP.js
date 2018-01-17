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
    $('#btnmatch').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#okUbic').click(function () {
        ConsultaUbicacionTec();
    });
    $('#aceptar').click(function () {
        CargaDatos();
    });
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
                borrarmsg();
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
    }else{
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
                }else{
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
function fnc() {
    document.getElementById('table-scroll').onscroll = function () {
        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}
function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function Select(we) {
    var se = $("#idUbiTec").val(we);
    se.focus();
    ocultarVentana();
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
    