$(document).ready(function () {
    startTime();    
    $('#iconmsg').hide();
    $('#btnmatchMate').hide();
    $('#btnmatchCentro').hide();
    $('#guardar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);
    $('#finalizar').prop('disabled', true);    
    $('#material').focus(function () {
        $('#btnmatchMate').show();
    });
    $('#centro').focus(function (){
       $('#btnmatchCentro').show();
    });
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    $('#btnmatchMate').click(function () {
        mostrarVentanaModal();
    });
    $('#CerrarMCEqupos').click(function () {
        ocultarVentana();
    });
    $('#CerrarMCEqupos2').click(function () {
        ocultarVentana();
    });
    var MATE = $('#material');
    var CENTRO = $('#centro');
    var ORGANIZACION = $('#organizacion');
    var CANAL = $('#canal');
    var UMB = $('#umb');
    var NOMATERIAL = $('#nomaterial');
    var TIPOMATERIAL = $('#tipomaterialj');
    var GPOARTICULOS = $('#grupoarticulosj');
    var SECTOR = $('#sectorj');
    var UMVENTAJ = $('#umventaj');
    var GEMATERIA = $('#gematerialj');
    var GTPMATER = $('#gtpmatej');
    var JERAPRO = $('#jeraproj');
    var GPOMATE = $('#gpmatej');
    var GROPOIMATE = $('#grupoimmatej');
    var GTPGEN = $('#gtpgenj');
    var GVDISPO = $('#gvdispoj');
    var GRUPOTRANSPORTE = $('#grupotransportej');
    var CENTROBENE = $('#centrobenej');
    var SUJETOLOTE = $('#sujetolotej');
    var GRUPOCARGAJ = $('#grupocargaj');
    var GRUPOCOMPRASJ = $('#grupocomprasj');
    var CARAPLANN = $('#caraplannj');
    var PUNTOPEDIDO = $('#puntopedidoj');
    var GPNECE = $('#gpnecej');
    var TLPNECE = $('#tlpnecej');
    var TLMIN = $('#tlminj');
    var HPFFIJO = $('#hpfijoj');
    var PNECESI = $('#pnecesij');
    var TLMAX = $('#tlmaxj');
    var STOCKMAXIMO = $('#stockmaximoj');
    var CLASEAPRO = $('#claseaproj');
    var TTMDIA = $('#ttmdiaj');
    var STOCKSEGURIDAD = $('#stockseguridadj');
    var STOCKSEGURIDADM = $('#stockseguridadmj');
    var CLASEAPROVI = $('#claseaprovij');
    var PEPDIA = $('#pepdiaj');
    var EPIMCEN = $('#epimcenj');
    var QMAPOR = $('#qmaporj');
    var ICPRECIOS = $('#icpreciosj');
    var PMVIPER = $('#pmviperj');
    var PRECIOESTANDAR = $('#precioestandarj');
    var CANTIDADBASE = $('#cantidadbasej');
    var CLASEVALORACION = $('#clasevaloracionj');
    var CATEGORIAVALORACION = $('#categoriavaloracionj');

    var arrayDAT = [
//        MATE,
//        CENTRO,
        ORGANIZACION,
        CANAL,
        UMB,
        NOMATERIAL,
        TIPOMATERIAL,
        GPOARTICULOS,
        SECTOR,
        UMVENTAJ,
        GEMATERIA,
        GTPMATER,
        JERAPRO,
        GPOMATE,
        GROPOIMATE,
        GTPGEN,
        GVDISPO,
        GRUPOTRANSPORTE,
        CENTROBENE,
        SUJETOLOTE,
        GRUPOCARGAJ,
        GRUPOCOMPRASJ,
        CARAPLANN,
        PUNTOPEDIDO,
        GPNECE,
        TLPNECE,
        TLMIN,
        HPFFIJO,
        PNECESI,
        TLMAX,
        STOCKMAXIMO,
        CLASEAPRO,
        TTMDIA,
        STOCKSEGURIDAD,
        STOCKSEGURIDADM,
        CLASEAPROVI,
        PEPDIA,
        EPIMCEN,
        QMAPOR,
        ICPRECIOS,
        PMVIPER,
        PRECIOESTANDAR,
        CANTIDADBASE,
        CLASEVALORACION,
        CATEGORIAVALORACION
    ];
    var ob = [
        MATE,
        CENTRO
    ];
    $.each(ob, function(i, v){
        v.css('background-image', 'url(images/necesario.PNG)');
        v.focus(function () {
            v.css('background-image', 'none');
        });
        v.blur(function(){
           if(v.val() == ''){
               v.css('background-image', 'url(images/necesario.PNG)');               
           }else{
               v.css('background-image', 'none');
           } 
        });
    });
    $.each(arrayDAT, function (i, v) {
//        v.css('background-image', 'url(images/necesario.PNG)');
        v.prop('disabled', true);
        v.focus(function () {
            v.css('background-image', 'none');
        });
        v.blur(function () {
            if (v.val() == '') {
                v.css('background-image', 'url(images/necesario.PNG)');
            } else {
                v.css('background-image', 'none');
            }
            if (i == 1) {
                if (v.val().length > 0) {
                    var n = validarCentro(v.val());                    
                    if (n === true) {
                        borramsg();
                    } else {
                        ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                        v.val("");
                        v.focus();
                    }
                }
            }
        });
    });
});
function mostrarVentanaModal()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ventana = $('#VentanaModal');
    var ancho = 350;
    var alto = 650;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    $('#equBus').val("");
    $('#denEqBus').val("");
    $('#equBus').focus();
    $('#numAcMax').val("500");
    borramsg();
    var theHandle = document.getElementById("handle");
    var theRoot = document.getElementById("VentanaModal");
    Drag.init(theHandle, theRoot);
}
function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function ocultarVentana()
{
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#VentanaModal').hide();
    $('#BuscarParam').css('display', 'block');
    $('#ConsultaTabla').css('display', 'none');
    $('#equ').focus();
}
function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
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