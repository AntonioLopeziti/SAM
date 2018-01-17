

$(document).ready(function(){
    startTime();
     $('#iconmsg').hide();
     $('#regresar').click(function(){
         $(location).attr('href', 'VisualizarDocumentosListaMaterial.jsp');
     });
     $('#finalizar').click(function(){
          $(location).attr('href', 'Bienvenido.jsp');
     });
     ValidarQuery(); 
});
function inval() {
    ShowMsg(0, "images/advertencia.PNG", "audio/saperror.wav");
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
function Select(id, vl) {
    var mandar = "";
    if (id == "" && vl == "") {
        mandar = "";
    } else if (id == "" && vl != "") {
        mandar = vl;
    } else if (id != "" && vl == "") {
        mandar = id;
    } else if (id != "" && vl != "") {
        mandar = id;
    }
    vali(mandar);
}

function vali(id) {
    if (id === null) {
        ErrorBusquedaMatch();
    } else {
        location.href = "VisualizarDocumentosLstMaterial2.jsp?MiI=" + id;
        enviarID(id);
    }
}

function enviarID(id) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionAllDocListaMaterial',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "ID=" + id,
        success: function (data) {
            if (data == 1) {
                $('#material_DLM').val("");
                $('#iconmsg').hide();
            }
        }
    });
}