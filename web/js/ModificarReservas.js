$(document).ready(function () {
    var sam = $('#samr');
    $('#match_CC').hide();
    $('#match_CA').hide();
    $('#match_CL').hide();
    $('#match_CO').hide();
    $('#match_OI').hide();
    $('#match_sam').hide();

    $('#samr').focus(function () {
        $('#samr').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').hide();
        $('#match_CL').hide();
        $('#match_CO').hide();
        $('#match_OI').hide();
        $('#match_sam').show();

    });

    $('#material_ma').keypress(function (e) {
        var tecla = (document).al ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patr = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patr.test(te);
    });

    $('#texto_mate').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });

    $('#centrito').keypress(function (e) {
        var tecla = (document).al ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patr = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patr.test(te);
    });

    $('#TImat').keypress(function (e) {
        var tecla = (document).al ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patr = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patr.test(te);
    });

    $('#numAcMax5').keypress(function (e) {
        var tecla = (document).al ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patr = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patr.test(te);
    });

    $('#OkMaterial').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });

    $('#FolSAm').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMatchFolioSAM();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMaxFS').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMatchFolioSAM();
        }
        if (tecla == 32) {
            return false;
        }
        patrn = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patrn.test(te);
    });
    $('#samr').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validarSAM();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-Z]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    $('#match_sam').click(function () {
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalFolioSAM");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('sam');
    });

    $('#btnAdd').click(function () {
        borrarmsg();
        var fil = $('input[name = "material"]').length;
        if (fil > 0) {
            $('.prueba79').remove();
            var cont = fil;
            var fila = '<tr name="posi"><td><input type=\"checkbox\" style=\"size: 100%;\" name=\"remover\" value=\"0\" id=\"eliminar\"/> </td>\n\
                   <td><input  type="text" maxlength="40" name="material" id="material' + cont + '"  value="" onblur="BluOfMaterial(' + cont + ')" onclick="BtnShow(' + cont + ')" /><button id="match_MA' + cont + '" class="BtnMatchIcon"  style="display : none;" onclick="MatchMaterial(' + cont + ')"></button></td>\n\
                   <td><input  type="text" name="cantidad" id="cantidad' + cont + '" value="" onblur=" this.value = checkDec(this.value, 3);"  onfocus="PermitWord(' + cont + ')" /></td>\n\
                   <td><input  type="text" name="unidadmedida" id="unidadmedida' + cont + '" disabled value="" onfocus="BtnHide()" /></td>\n\
                   <td style="width: 40%;"><input  type="text" name="descripcion" id="descripcion' + cont + '" disabled value="" style="width: 100%; text-transform: uppercase;" onfocus="BtnHide()" /></td></tr>';
            $('#CargarOperaciones').append(fila);
            cont++;
        }
    });

    $('#btnDelete').click(function () {
        $('#TablaReservas').find('input[name="posicion"], [name="remover"]').each(function () {
            if ($(this).is(":checked")) {
                $(this).parents("tr").remove();
            }
        });
    });

    $('#modificar').click(function () {
        var err = $('#errin').val();
        var reci = $('#reciin').val();
        var proc = $('#procin').val();
        var tmov = $('#ClaseMov').val();
        //alert(err + reci + proc);
        if (err.length > 0 && reci.length > 0 && proc.length > 0) {
            mesg(11, 'images/aceptar.png', "audio/saperror.wav");
            var numfilas = $("#TablaReservas tr").length;
            $('#guarda').show();
            $('#guarda').attr('src', 'images/guarda.PNG');
            $('#guarda').attr('disabled', false);
            for (var i = 0; i < numfilas; i++) {
                $('#cantidad' + i).attr('disabled', false);
            }

            if (tmov === "201") {
                boquea();
                $('#centroco').attr('disabled', false);
            } else if (tmov === "261") {
                boquea();
                $('#orden').attr('disabled', false);
            } else if (tmov === "311") {
                boquea();
                $('#Arece').attr('disabled', false);
            }
            $('#centro').attr('disabled', false);
            $('#Almacen').attr('disabled', false);
        } else if (reci.length > 0 && err.length == 0 && proc.length == 0) {
            mesg(12, 'images/advertencia.PNG', "audio/saperror.wav");
            //alert("No se Edita");
        } else {
            $('#btnAdd').attr('disabled', false);
            $('#btnDelete').attr('disabled', false);
            var numfilas = $("#TablaReservas tr").length;
            $('#guarda').show();
            $('#guarda').attr('src', 'images/guarda.PNG');
            $('#guarda').attr('disabled', false);
            for (var i = 0; i < numfilas; i++) {
                $('#cantidad' + i).attr('disabled', false);
            }
        }
    });
});

function boquea() {
    $('#centro').attr('disabled', true);
    $('#Almacen').attr('disabled', true);
    $('#centroco').attr('disabled', true);
    $('#orden').attr('disabled', true);
    $('#Arece').attr('disabled', true);
}

function checkDec(num, tam) {
    var limit;
    var MSGF;
    if (tam == 3) {
        limit = 9999999.999;
        MSGF = 3;
    } else {
        limit = 99999999.99;
        MSGF = 4;
    }
    if (num.length > 0) {
        if (parseFloat(limit) >= parseFloat(num)) {
            va = num.split(".");
            v01 = va[0];
            if (v01.length == 0) {
                v01 = "0";
            }
            v0 = parseInt(v01);
            v1 = va[1];
            if (num.indexOf(".") != -1) {
                if (v1.length > tam) {
                    var da = v1.substr(0, tam);
                    return v0 + "." + da;
                } else {
                    for (i = 0; i <= tam; i++) {
                        v1 += "0";
                    }
                    return v0 + "." + v1.substr(0, tam);
                }
            } else {
                var nn = "0";
                for (a = 0; a < tam; a++) {
                    nn += "0";
                }
                return v0 + "." + nn.substr(0, tam);
            }
        } else {
            mensajesValidacionInco(MSGF);
            return "";
        }
    } else {
        return "";
    }
}

function BtnShow(i) {
    document.getElementById("match_MA" + i).style.display = "inline";
    $('#material' + i).keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 13) {
            validaMaterialRes(i);
        }
    });
}

function BluOfMaterial(i) {
    var mat = $('#material' + i).val();
    if (mat.length > 0) {
        obtener(mat, i);
    }
}

function validaMaterialRes(va) {
    var mater = $('#material' + va).val();
    var cen = $('#centro').val();
    var al = $('#Almacen').val();
    var acc = "ValMate";
    var enviar = "&mater=" + mater.toUpperCase() + "&cen=" + cen.toUpperCase() + "&al=" + al.toUpperCase();
    //alert(enviar);
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            //alert(data);
            if (data == 1) {
                traerMAtres(va);
            } else {
                mesg(4, 'images/advertencia.PNG', "audio/saperror.wav");
            }
        }

    });
}

function traerMAtres(val) {
    var mater = $('#material' + val).val();
    var acc = "CarMatRese";
    var enviar = "&mater=" + mater + "&ctdmax=" + val;
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            var n = data;
            $('#descripcion' + val).val(n[0]);
            $('#unidadmedida' + val).val(n[1]);
        }
    });
}

function bloqueoAddDelete() {
    $('#btnAdd').attr('disabled', true);
    $('#btnDelete').attr('disabled', true);
}

function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    $('#tiempo').html(h + ":" + m + ":" + s);
    $('#hores').val(h + ":" + m + ":00");
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
    bloqueoAddDelete();
};

function LimpAll() {
    $('#samr').val("");
    $('#centro').val("");
    $('#Almacen').val("");
    $('#ClaseMov').val("");
    $('#centroco').val("");
    $('#orden').val("");
    $('#Arece').val("");
    $('#TablaStatus').load("ModificarReservas.jsp #TablaStatus");
}

function bloq() {
    $('#iconmsg').hide();
    $('#guardar').attr('disabled', true);
    $('#modificar').attr('disabled', true);
}

function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function back() {
    $(location).attr('href', 'Bienvenido.jsp');
}

function mensajesValidacionInco(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(msg);
}

function MostrarVentanaModal(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd01.wav";
    BE.play();
    switch (tipo) {
        case "sam":
            $('#VentanaModalFolioSAM').css({
                position: 'absolute', left: 508, top: 60
            });
            $('#VentanaModalFolioSAM').show();
            $('#FolSAm').val("").focus();
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case "Material":
            $('#VentanaModalMaterial').css({
                position: 'absolute', left: 508, top: 60
            });
            $('#VentanaModalMaterial').show();
            $('#material_ma').val("").focus();
            $('#texto_mate').val("");
            $('#centrito').val("");
            $('#TImat').val("");
            $('#numAcMax5').val("500");
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
    }
}

function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    switch (tipo) {
        case 'sam':
            $('#VentanaModalFolioSAM').hide();
            $('#BuscarParam_sam').show();
            $('#ConsultaTablasam').hide();
            $('#samr').focus();
            break;
        case "material":
            $('#VentanaModalMaterial').hide();
            $('#BuscarParam_m').show();
            $('#ConsultaTablam').hide();
            break;
        default:
            break;
    }
}

function seleccionar(obj, tipo, id) {
    switch (tipo) {
        case 'sam':
            $('#samr').val(obj).focus();
            ocultarVentana(tipo);
            break;
        case "material":
            $("#material" + id).val(obj).focus();
            obtener(obj, id);
            ocultarVentana(tipo);
            break;
        default:
            break;
    }
}

function obtener(obj, num) {
    var acc = "CargarMaterialReserva";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'peticionVisualizarMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MATERIALRESERVA=" + obj,
        success: function (data) {
            if (data == 0) {
                $('#material' + num).val("");
                $('#unidadmedida' + num).val("");
                $('#descripcion' + num).val("");
                mesg("1", "images/advertencia.PNG");
            } else {
                var n = data;
                $('#descripcion' + num).val(n[0]);
                $('#unidadmedida' + num).val(n[1]);
            }
        }
    });
}

function ConsultaMatchFolioSAM() {
    var acc = "ConsultaFolioSAM";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ModificarReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&FolSAm=" + $('#FolSAm').val() + "&FecSAm=" + $('#FecSAm').val() + "&numAcMaxFS=" + $('#numAcMaxFS').val(),
        success: function (data) {
            if (data == 0) {
                mesg(0, 'images/aceptar.png', "audio/sapmsg.wav");
            } else {
                $('#BuscarParam_sam').hide();
                $('#ConsultaTablasam').show();
                $('#CargarDatosSAM').html(data);
                fnc2();
            }
        }
    });
}

function fnc2() {
    document.getElementById('table-scroll').onscroll = function () {
        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
    };
}
function fncMat() {
    document.getElementById('table-scrollm').onscroll = function () {
        document.getElementById('fixedYm').style.top = document.getElementById('table-scrollm').scrollTop + 'px';
    };
}
function inval() {
    mesg(1, 'images/advertencia.PNG', "audio/saperror.wav");
}

function cambiarot() {
    $('#BuscarParam_sam').show();
    $('#ConsultaTablasam').hide();
    $('#FolSAm').focus();
}

function validarSAM() {
    var acc = "ValidarSAM";
    var folio = $('#samr').val();
    if ($('#samr').val().length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            dataType: 'json',
            url: 'ModificarReservas',
            contentType: "application/x-www-urlencoded",
            processData: true,
            data: "Action=" + acc + "&sam=" + folio.toUpperCase(),
            success: function (data) {
                if (data == 0) {
                    mesg(3, 'images/advertencia.PNG', "audio/saperror.wav");
                    $('#samr').val("").focus();
                } else {
                    var n = data;
                    $('#errin').val(n[0]);
                    $('#reciin').val(n[1]);
                    $('#procin').val(n[2]);
                    $('#us2').val(n[3]);
                    $('#guarda').attr('disabled', true);
                    borrarmsg();
                    ObtenerDatosReserva();
                    GetDatosTabla($('#samr').val());
                    CargarStatus();
                    boquea();
                }
            }
        });
    }
}

function ObtenerDatosReserva() {
    var acc = "ConsultaCargarDatos";
    $.ajax({
        async: false,
        type: 'GET',
        dataType: 'json',
        url: 'ModificarReservas',
        contentType: "application/x-www-urlencoded",
        processData: true,
        data: "Action=" + acc + "&sam=" + $('#samr').val(),
        success: function (data) {
            var n = data;
            $('#centro').val(n[5]);
            $('#Almacen').val(n[7]);
            $('#ClaseMov').val(n[6]);
            $('#centroco').val(n[8]);
            $('#orden').val(n[9]);
            $('#Arece').val(n[13]);
            mesg(2, 'images/aceptar.png', "audio/sapmsg.wav");
        }
    });
}

function GetDatosTabla(sam) {
    var acc = "ConsultaCargarDatosTabla";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ModificarReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&sam=" + sam,
        success: function (data) {
            if (data == 0) {
                mesg(5, 'images/aceptar.png', "audio/sapmsg.wav");
            } else {
                $('#CargarOperaciones').html(data);
            }
        }
    });
}

function CargarStatus() {
    var err = $('#errin').val();
    var reci = $('#reciin').val();
    var proc = $('#procin').val();
    //alert("error: " + err + ", recibido: " + reci + ", procesado: " + proc);
    if (err.length > 0 && reci.length > 0 && proc.length > 0) {
        $('#modificar').attr('disabled', false);
        //mesg(11, 'images/advertencia.PNG', "audio/saperror.wav");
    } else if (err.length > 0) {
        //$('#laberr').html("Error: " + err);
        //document.getElementById("lerrim").hidden = 0;
        $('#modificar').prop('disabled', false);
    } else if (reci.length > 0) {
        //$('#modificar').prop('disabled', true);
        //$('#laberr').html("");
        document.getElementById("lerrim").hidden = 1;
    } else {
        //$('#btnAdd').attr('disabled', false);
        //$('#btnDelete').attr('disabled', false);
        //$('#').attr('disabled', false);
        $('#modificar').attr('disabled', false);
        //document.getElementById("lerrim").hidden = 1;
        //$('#laberr').html("");
    }

}

function valorMate() {
    var filnew = $('input[name = "material"]').length;
    var mati = document.getElementsByName("material");
    var canti = document.getElementsByName("cantidad");
    for (i = 0; i < filnew; i++) {
        if (mati[i].value.length == 0) {
            mesg(6, 'images/advertencia.PNG', "audio/saperror.wav");
            mati[i].focus();
            return;
        }
        if (canti[i].value.length == 0) {
            mesg(7, 'images/advertencia.PNG', "audio/saperror.wav");
            canti[i].focus();
            return;
        }
        if (parseFloat(canti[i].value) == 0.000) {
            mesg(8, 'images/advertencia.PNG', "audio/saperror.wav");
            canti[i].focus();
            return;
        }

    }
    var us1 = $('#us1').val();
    var us = $('#us2').val();
    if (us1 == us) {
        ActualizarCabecera();
        Elimresenew();
        ActualizarDatos();
    } else {
        mesg(9, 'images/advertencia.PNG', "audio/saperror.wav");
    }

}
function ActualizarCabecera() {
    var centro = $('#centro').val();
    var almacen = $('#Almacen').val();
    var movimiento = $('#ClaseMov').val();
    var centrocoste = $('#centroco').val();
    var orden = $('#orden').val();
    var alde = $('#Arece').val();
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ModificarReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=UpdateCabecera&sam=" + $('#samr').val() + "&Cen1=" + centro +
                "&Mov1=" + movimiento + "&Alm1=" + almacen + "&CenCos1=" + centrocoste +
                "&Ord1=" + orden + "&AlmDes1=" + alde,
        success: function (data) {
        }
    });
}
function ActualizarDatos() {
    var filnew = $('input[name = "material"]').length;
    var centro = $('#centro').val();
    var almacen = $('#Almacen').val();
    var movimiento = $('#ClaseMov').val();
    var centrocoste = $('#centroco').val();
    var orden = $('#orden').val();
    var alde = $('#Arece').val();
    var sam = $('#samr').val();
    var check = document.getElementsByName('remover');
    var mati = document.getElementsByName("material");
    var cant = document.getElementsByName("cantidad");
    var ume = document.getElementsByName("unidadmedida");
    var des = document.getElementsByName("descripcion");
    var remover = "";
    var accion = "UpdatePosiciones";
    for (i = 0; i < filnew; i++) {
        for (var j = 0; j < check.length; j++) {
            if (check[i].checked) {
                remover = "X";
            }
        }
        var dato = "&sam=" + sam.toUpperCase() + "&Posi1=" + Posires(parseInt(i) + 1) +
                "&Mate1=" + mati[i].value + "&Cen1=" + centro + "&Alm1=" + almacen +
                "&cantidad=" + cant[i].value + "&UniMed=" + ume[i].value + "&CenCos1=" + centrocoste +
                "&Ord1=" + orden + "&Mov1=" + movimiento + "&Des=" + des[i].value + "&AlmDes1=" + alde + "&remover=" + remover;
        UpdatePosicionReserva(accion, dato);
    }

}
function Posires(n) {
    if (n < 10) {
        return "000" + n + "0";
    }
    if (n > 10 && n < 100) {
        return "00" + n + "0";
    }
    if (n > 100 && n < 1000) {
        return "0" + n + "0";
    }
    return n;
}
function UpdatePosicionReserva(accion, datos) {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ModificarReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + accion + datos,
        success: function (data) {
            mesg(10, 'images/aceptar.png', "audio/sapmsg.wav");
            LimpAll();
        }
    });
}
function Elimresenew() {
    $.ajax({
        async: false,
        type: 'GET',
        url: 'ModificarReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=ELiminarDato&sam=" + $('#samr').val(),
        success: function (data) {
        }
    });
}

function CargarVacio() {
    $(location).attr('href', 'ModificarReservas.jsp');
}

//function checkDec(num, tam, u) {
//
//    if (num > 99999999) {
//        //num = nu, m.substring(1, num.length);
//    } else if (num.length < 1) {
//        return num = 0;
//    }
//    return GetCantend(num, u);
//}

function GetCantend(C, U) {
    var findata;
    var umc = parseInt(CheckUnidaMed(U));
    if (umc == 0) {
        findata = Math.floor(C);
        findata += ".000";
    }
    if (umc == 3) {
        findata = cantconvert(C.toString());
    }
    return findata;
}

function CheckUnidaMed(valor) {
    var resp = "";
    var acc = "runimed";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionMovMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&v1=" + valor,
        success: function (data) {
            resp = data;
        }
    });
    return resp;
}

function cantconvert(valor) {
    if (valor.indexOf(".") != -1) {
        va = valor.split(".");
        v0 = va[0];
        v1 = va[1];
        if (v1.length == 1) {
            var valorfinal = v0 + "." + v1 + "00";
            return valorfinal;
        } else if (v1.length == 2) {
            var valorfinal = v0 + "." + v1 + "0";
            return valorfinal;
        } else {
            valo = v1.substr(0, 3);
            valorf = v0 + "." + valo;
            return valorf;
        }
    } else {
        valor = valor + ".000";
        return valor;
    }
    return val;
}

function PermitWord(i) {
    $("input[type='text'][name='cantidad']").keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        }
        patron = /[0-9.]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });
}

function check99(num, max, tam, i) {
    var u = $('#unidadmedida' + i).val();
    var numEn = Math.round(num);
    if (numEn <= max) {
        return num;
    } else {
        var numMod = num.substring(0, tam) + "" + num.substring((tam + 1), num.length);
        return numMod;
    }
}

function MatchMaterial(va) {
    Prueba(va);
    MostrarVentanaModal("Material");
}

function Prueba(valor) {
    var acc = "Prueba";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionVisualizarReportes',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&VALORCITO=" + valor,
        proccess: function (data) {

        }
    });
}

function ConsultarMaterial() {
    var acc = "MuestraMatchResMat";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MaterialMatch=" + $('#material_ma').val() + "&DescripMatch=" + $('#texto_mate').val() + "&CentroMatch=" + $('#centrito').val() + "&CantidadMatch=" + $('#numAcMax5').val() + "&TImat=" + $('#TImat').val(),
        success: function (data) {
            if (data == 0) {
                mesg(0, 'images/aceptar.png', "audio/sapmsg.wav");
            } else {
                $('#BuscarParam_m').hide();
                $('#ConsultaTablam').show();
                $('#CargarDatosm').html(data);
                fncMat();
                borrarmsg();
            }
        }
    });
}

function ErrorBusquedaMatch() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapmsg.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/aceptar.png');
    $('#msg').html("No existen datos");
    //mensajes("MenValores");
}

function camMATChpri() {
    $('#BuscarParam_m').show();
    $('#ConsultaTablam').hide();
    $('#material_ma').val("").focus();
}