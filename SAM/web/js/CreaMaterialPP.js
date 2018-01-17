/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    $('#iconmsg').attr("hidden", "true");
    $("#regresar").click(function () {
        back();
    });
    function back() {
        window.location.href = "Bienvenido.jsp";
    }
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
        MATE,
        CENTRO,
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
    $.each(arrayDAT, function (i, v) {
        v.css('background-image', 'url(images/necesario.PNG)');
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
    $('#guardar').click(function () {
        ValidarDatos();
    });

    function ValidarDatos() {
        var temp = new Array();
        temp[0] = MATE;
        temp[1] = CENTRO;
        temp[2] = ORGANIZACION;
        temp[3] = CANAL;
        temp[4] = UMB;
        temp[5] = NOMATERIAL;
        temp[6] = TIPOMATERIAL;
        temp[7] = GPOARTICULOS;
        temp[8] = SECTOR;
        temp[9] = UMVENTAJ;
        temp[10] = GEMATERIA;
        temp[11] = GTPMATER;
        temp[12] = JERAPRO;
        temp[13] = GPOMATE;
        temp[14] = GROPOIMATE;
        temp[15] = GTPGEN;
        temp[16] = GVDISPO;
        temp[17] = GRUPOTRANSPORTE;
        temp[18] = CENTROBENE;
        temp[19] = SUJETOLOTE;
        temp[20] = GRUPOCARGAJ;
        temp[21] = GRUPOCOMPRASJ;
        temp[22] = CARAPLANN;
        temp[23] = PUNTOPEDIDO;
        temp[24] = GPNECE;
        temp[25] = TLPNECE;
        temp[26] = TLMIN;
        temp[27] = HPFFIJO;
        temp[28] = PNECESI;
        temp[29] = TLMAX;
        temp[30] = STOCKMAXIMO;
        temp[31] = CLASEAPRO;
        temp[32] = TTMDIA;
        temp[33] = STOCKSEGURIDAD;
        temp[34] = STOCKSEGURIDADM;
        temp[35] = CLASEAPROVI;
        temp[36] = PEPDIA;
        temp[37] = EPIMCEN;
        temp[38] = QMAPOR;
        temp[39] = ICPRECIOS;
        temp[40] = PMVIPER;
        temp[41] = PRECIOESTANDAR;
        temp[42] = CANTIDADBASE;
        temp[43] = CLASEVALORACION;
        temp[44] = CATEGORIAVALORACION;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(2, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        if (MATE.val().length >= 8) {
            validarMaterialExis(MATE.val());
        }
//        if (MATE.val().length >= 8) {
//            if (MATE.val() == PWD2.val()) {
//                validarMaterialoExistente(USER.val());
//            } else {
//                PWD1.focus();/
//                ShowMsg(4, "images/advertencia.PNG", "audio/saperror.wav");
//            }
//        } else {
//            PWD1.focus();
//            ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
//        }
    }
    function validarCentro(centro) {
        var resp = false;
        var acc = "ValidarCentro";
        c = centro.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloCreaMaterialesPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Centro=" + c,
            success: function (data) {                
                if (data == 1) {
                    resp = true;
                }
            }
        });
        return resp;
    }
    function validarMaterialExis(mate) {
        var acc = "validaMateEx";
        var mat = mate.toUpperCase();
        $.ajax({
            async: false,
            type: "GET",
            url: "PeticionModuloCreaMaterialesPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Mate=" + mat,
            success: function (data) {
                if (data != 1) {                    
                    GuardarDatosMate();
                } else {                    
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
                }
            }
        });
    }
    function GuardarDatosMate() {
        var acc = "GuardarDatos";
        var par = "&Organiz=" + ORGANIZACION.val() + "&Canal=" + CANAL.val() + "&Ubm=" + UMB.val() + "&NoMat=" + NOMATERIAL.val() + "&TipMat=" + TIPOMATERIAL.val() + "&GpoArt=" + GPOARTICULOS.val() + "&Sector=" + SECTOR.val() + "&UmVent=" + UMVENTAJ.val() + "&Gmater=" + GEMATERIA.val() + "&GtpMate=" + GTPMATER.val() + "&Jerapro=" + JERAPRO.val() + "&GropoiMate=" + GROPOIMATE.val() + "&Gtpgen=" + GTPGEN.val() + "&Gvdispo=" + GVDISPO.val() + "&GpoTransporte=" + GRUPOTRANSPORTE.val() + "&CentroBene=" + CENTROBENE.val() + "&SujetoLote=" + SUJETOLOTE.val() + "&GrupoCarga=" + GRUPOCARGAJ.val() + "&GrupoCompras=" + GRUPOCOMPRASJ.val() + "&CaraPlann=" + CARAPLANN.val() + "&PuntoPed=" + PUNTOPEDIDO.val() + "&Gpnece=" + GPNECE.val() + "&Tlmin=" + TLMIN.val() + "&Hppfijo=" + HPFFIJO.val() + "&Pnecesi=" + PNECESI.val() + "&Tlmax=" + TLMAX.val() + "&StockMax=" + STOCKMAXIMO.val() + "&Claseapro=" + CLASEAPRO.val() + "&Tmdia=" + TTMDIA.val() + "&StockSeg=" + STOCKSEGURIDAD.val() + "&StockSegM=" + STOCKSEGURIDADM.val() + "&ClaseAprov=" + CLASEAPROVI.val() + "&Pepdia=" + PEPDIA.val() + "&Epimcen=" + EPIMCEN.val() + "&Qmapor=" + QMAPOR.val() + "&Icprecios=" + ICPRECIOS.val() + "&PmViper=" + PMVIPER.val() + "&PrecioEstandar=" + PRECIOESTANDAR.val() + "&CantidadBase=" + CANTIDADBASE.val() + "&ClaseValoracion=" + CLASEVALORACION.val() + "&CateVal=" + CATEGORIAVALORACION.val();
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "PeticionModuloCreaMaterialesPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&Mate=" + MATE.val().toUpperCase() + "&Centro=" + CENTRO.val().toUpperCase() + par,
            success: function (data) {
                if (data == 5) {
                    ShowMsg(4, "images/aceptar.png", "audio/sapmsg.wav");
                    limpiar();
//                    reiniDatOb();                    
                }
                if (data == 6) {
                    ShowMsg(5, "images/advertencia.PNG", "audio/saperror.wav");
//                    reiniDatOb();
                    limpiar();

                }
            }
        });
    }
    function limpiar() {
        $.each(arrayDAT, function (i, v) {
            v.val("");
        });
    }
    function borramsg() {
        $('#iconmsg').hide();
        $('#msg').html("");
    }
});
function startTime() {
    today = new Date();
    n = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    h = checkTime(n);
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
