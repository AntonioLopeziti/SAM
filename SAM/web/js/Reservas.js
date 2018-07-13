$(document).ready(function () {
    var cen = $('#centro');
    var alm = $('#Almacen');
    var cco = $('#centroco');
    var or = $('#orden');
    var cla = $('#ClaseMov');
    var mov = $('#ListTipMov');
    $('#centro').css("background-image", "url(images/necesario.PNG)");
    $('#Almacen').css("background-image", "url(images/necesario.PNG)");
    $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
    $('#centroco').css("background-image", "url(images/necesario.PNG)");
    $('#orden').css("background-image", "url(images/necesario.PNG)");
    $('#Arece').css("background-image", "url(images/necesario.PNG)");
    $('#match_CC').hide();
    $('#match_CA').hide();
    $('#match_CL').hide();
    $('#match_CO').hide();
    $('#match_OI').hide();
    $('#match_AR').hide();
    $('#match_CLM').hide();
    $('#centro').focus(function () {
        $('#match_CC').show();
        $('#match_CA').hide();
        $('#match_CL').hide();
        $('#match_CO').hide();
        $('#match_OI').hide();
        $('#match_AR').hide();
        $('#match_CLM').hide();
        $('#centro').css("background-image", "none");
        if ($('#Almacen').length < 1) {
            $('#Almacen').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ClaseMov').length < 1) {
            $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#Almacen').focus(function () {
        $('#Almacen').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').show();
        $('#match_CL').hide();
        $('#match_CO').hide();
        $('#match_OI').hide();
        $('#match_AR').hide();
        $('#match_CLM').hide();
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ClaseMov').length < 1) {
            $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#ClaseMov').focus(function () {
        $('#ClaseMov').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').hide();
        $('#match_CL').show();
        $('#match_CO').hide();
        $('#match_OI').hide();
        $('#match_AR').hide();
        $('#match_CLM').show();
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Almacen').val().length < 1) {
            $('#Almacen').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#centroco').focus(function () {
        $('#centroco').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').hide();
        $('#match_CL').hide();
        $('#match_CO').show();
        $('#match_OI').hide();
        $('#match_AR').hide();
        $('#match_CLM').hide();
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Almacen').val().length < 1) {
            $('#Almacen').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ClaseMov').length < 1) {
            $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#orden').focus(function () {
        $('#orden').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').hide();
        $('#match_CL').hide();
        $('#match_CO').hide();
        $('#match_OI').show();
        $('#match_AR').hide();
        $('#match_CLM').hide();
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Almacen').val().length < 1) {
            $('#Almacen').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ClaseMov').length < 1) {
            $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
        }
    });

    $('#Arece').focus(function () {
        $('#Arece').css("background-image", "none");
        $('#match_CC').hide();
        $('#match_CA').hide();
        $('#match_CL').hide();
        $('#match_CO').hide();
        $('#match_OI').hide();
        $('#match_AR').show();
        $('#match_CLM').hide();
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#Almacen').val().length < 1) {
            $('#Almacen').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#ClaseMov').length < 1) {
            $('#ClaseMov').css("background-image", "url(images/necesario.PNG)");
        }
    });



    $('#centro').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#Almacen').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#ClaseMov').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#centroco').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#orden').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            validar();
        }
    });
    $('#match_CC').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('centro');
    });
    $('#match_CA').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalAlmacen");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('Almacen');
    });
    $('#match_CO').click(function () {
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalCentroCoste");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('centroco');
    });
    $('#match_OI').click(function () {
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalOrdenes");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('orden');
    });

    $('#match_AR').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalAlmacen");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('Arece');
    });

    $('#match_CLM').click(function () {
        var theHandle = document.getElementById("handle5");
        var theRoot = document.getElementById("VentanaModalClaseMov");
        Drag.init(theHandle, theRoot);
        MostrarVentanaModal('ClaseMov');
    });

    $('#OkCentro').click(function () {
        ConsultaMatchCentroCo();
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMatchCentroCo();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#OkOrden').click(function () {
        ConsultaMatchOrdenes();
    });
    $('#OkMaterial').click(function () {
        ConsultarMaterial();
    });
    $('#centro_co').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaMatchCentroCo();
        }
    });
    $('#sociedad_co').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaMatchCentroCo();
        }
    });

    $('#material_ma').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#texto_mate').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#centrito').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#numAcMax5').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    $('#texto_breve').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaMatchCentroCo();
        }
    });
    $('#orden_or').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaMatchOrdenes();
        }
    });
    $('#texto_breveor').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaMatchOrdenes();
        }
    });
    $('#TImat').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultarMaterial();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaMatchOrdenes();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(tecla);
        return patron.test(t);
    });
    //////VALIDAR CAMPOS
    cen.blur(function () {
        validarCen();
    });
    cen.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarCen();
        }
    });
    alm.blur(function () {
        validarAlm();
    });
    alm.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarAlm();
        }
    });
    cco.blur(function () {
        validarCCO();
    });
    cco.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarCCO();
        }
    });
    or.blur(function () {
        validarOR();
    });
    or.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarOR();
        }
    });

    cla.blur(function () {
        validarClase();
    });

    cla.keypress(function (e) {
        if (e.which == 13 || e.keycode == 13) {
            validarClase();
        }
    });

    mov.blur(function () {
        var movi = $('#ListTipMov').val();
        ClasMOV(movi);
    });

//    mov.keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            var movi = $('#ListTipMov').val();
//            ClasMOV(movi);
//        }
//    });

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
});

$(document).ready(function () {
    var cont = 1;
    $('#btnAdd').click(function () {
        var fila = '<tr name="posi"><td><input type="checkbox" style="size: 100%;" name="posicion" value="" id="posicion' + cont + '"></td>\n\
                   <td><input  type="text" name="material" id="material' + cont + '" onblur="ValMateReserva(' + cont + ')" onclick="BtnShow(' + cont + ')" value=""  /><button id="match_MA' + cont + '" class="BtnMatchIcon"  style="display : none;" onclick="MatchMaterial(' + cont + ')"></button></td>\n\
                   <td><input  type="text" min="1" name="cantidad" id="cantidad' + cont + '" value="" onfocus="BtnHide()" onblur="this.value = checkDec(this.value, 3,' + cont + ' )"  onKeyUp="this.value = check99(this.value, 999999, 7,' + cont + ')"   /></td>\n\
                   <td><input  type="text" name="unidadmedida" id="unidadmedida' + cont + '" disabled value="" onfocus="BtnHide()" /></td>\n\
                   <td style="width: 40%;"><input  type="text" name="descripcion" id="descripcion' + cont + '" disabled value="" style="width: 100%; text-transform: uppercase;" onfocus="BtnHide()" /></td></tr>';
        $('#TablaReservas').append(fila);
        cont++;
    });

    $('#btnDelete').click(function () {
        $('#iconmsg').hide();
        $('#msg').html("");
        $('#TablaReservas').find('input[name="posicion"]').each(function () {
            if ($(this).is(":checked")) {
                $(this).parents("tr").remove();
            }
        });
    });

    $("#ListTipMov").blur(function () {
        var movi = $("#ListTipMov").val();
        var mov = movi.substr(0, 3);
        if (mov == "311") {
            $("#lismat").prop("disabled", false);
        } else {
            $("#lismat").prop("disabled", true);
        }
    });

    $("#lismat").click(function () {
        var alre = $('#Arece').val();
        var al = $('#Almacen').val();
//        alert(alre.toUpperCase() +" "+ al.toUpperCase());

        if (alre.toUpperCase() == al.toUpperCase()) {

        } else if (alre.length < 1 || al.length < 1) {

        } else {


            mostrarVentanaModalib();
            var usua = $("#usus").val();
            var acc = "verList";
            var acc1 = "verListinp";
            var enviar = "&usua=" + usua;
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionReservasListMaterial',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + enviar,
                success: function (data) {
                    $("#TabTextli").html(data);
                }
            });
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionReservasListMaterial',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc1 + enviar,
                success: function (data) {
                    $("#vallima").val(data);
                }
            });
        }
    });

    $("#cerrarmodalCL").click(function () {
        ocultarVentana('VentanaModalTextli');
    });
    $("#cerrarmodalTL").click(function () {
        ocultarVentana('VentanaModalTextli');
    });



    function mostrarVentanaModalib() {
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
        borramsg();
        var theHandle = document.getElementById("handle6");
        var theRoot = document.getElementById("VentanaModalTextli");
        Drag.init(theHandle, theRoot);
    }

    $("#matlismodalOK").click(function () {
        var valis = $("#vallima").val();
        var al = $('#Almacen').val();
        var alre = $('#Arece').val();
        var alma1 = $("#Almacen").val();
        var alma2 = $("#Arece").val();
        var centro = $("#centro").val();
        ocultarVentana('VentanaModalTextli');
        if (alma1.length > 0 && alma2.length > 0) {
            var acc = "conlis";
            var enviar = "&valis=" + valis.toUpperCase() + "&alm1=" + al.toUpperCase() + "&alm2=" + alre.toUpperCase() + "&centro=" + centro.toUpperCase();
            $.ajax({
                async: false,
                type: 'GET',
                url: 'peticionReservasListMaterial',
                contentType: "application/x-www-form-urlencoded",
                processData: true,
                data: "Accion=" + acc + enviar,
                success: function (data) {
                    $("#CargaTodo").html(data);
                    var fil = $("#CargaTodo>tr").length;
                    cont = parseInt(fil);
                    var obj = document.getElementById('btnAdd');
                    obj.click();
                    setTimeout(function () {
                        var pon = document.getElementsByName("posicion");
                        var tada = parseInt(cont) - 1;
//                    alert(pon+" "+tada);
                        pon[tada].checked = true;
                        var obde = document.getElementById("btnDelete");
                        obde.click();
                    }, 500);
                }
            });
        } else {
            var BE = document.createElement('audio');
            BE.src = "audio/sapmsg.wav";
            BE.play();
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            mensajes('almva', "", "");
        }
    });


});

function ValMateReserva(v) {
    var ma = $('#material' + v).val();
    if (ma.length > 0) {
        obtener(ma, v);
    }
}

function BtnShow(val) {
    document.getElementById("match_MA" + val).style.display = "inline";
    $('#material' + val).keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 13) {
            ValMateRese(val);
        }
    });
}

function BtnHide()
{
//    for (var i = 0; i < 100; i++)
//    {
//        document.getElementById("match_MA" + i).style.display = "none";
//    }
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
    CArgarMne();
    bloq();
    //TableMat();
    ConsultaMatchClaseMov();
};

function TableMat() {
    var acc = "TablaPrincipal";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            $('#CargaTodo').html(data);
        }
    });
}

function LimpAll() {
    $('#centro').val("");
    $('#Almacen').val("");
    $('#ClaseMov').val("");
    $('#centroco').val("").attr('disabled', false);
    $('#orden').val("").attr('disabled', false);
    $('#Arece').val("").attr('disabled', false);
    $('#TablaStatus').load("Reservas.jsp #TablaStatus");
}

function GetCantend(C, U) {
    var findata;
    var umc = parseInt(CheckUnidaMed(U));
    if (umc == 0) {
        var fin = parseFloat(C).toFixed(3);
        va = fin.split(".");
        v0 = va[0];
        v1 = va[1];
        findata = v0 + ".000";
    } else if (umc == 3) {
        findata = cantconvert(C.toString());
    } else {
        findata = "0.000";
    }
    return findata;
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
}
function CheckUnidaMed(valor)
{
    var resp = "";
    var acc = "umed";
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

function checkDec(num, tam, i) {
    var u = document.getElementById("unidadmedida" + i).value;
    if (num > 99999999) {
    } else if (num.length < 1) {
        return num = 0;
    }
    return GetCantend(num, u);
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

function ClasMOV(cl) {
    var mov = cl.substring(0, 3);
    if (mov === '201') {
        $('#orden').attr('disabled', true).val("");
        $('#Arece').attr('disabled', true).val("");
        $('#orden').css("background-image", "none");
        $('#Arece').css("background-image", "none");
        $('#centroco').attr('disabled', false);
        $('#centroco').css("background-image", "url(images/necesario.PNG)");
    }
    if (mov === '261') {
        $('#Arece').attr('disabled', true).val("");
        $('#centroco').attr('disabled', true).val("");
        $('#Arece').css("background-image", "none");
        $('#centroco').css("background-image", "none");
        $('#orden').attr('disabled', false);
        $('#orden').css("background-image", "url(images/necesario.PNG)");
    }
    if (mov === '311') {
        $('#orden').attr('disabled', true).val("");
        $('#centroco').attr('disabled', true).val("");
        $('#orden').css("background-image", "none");
        $('#centroco').css("background-image", "none");
        $('#Arece').attr('disabled', false);
        $('#Arece').css("background-image", "url(images/necesario.PNG)");
    }
}

function CArgarMne() {
    mensajes("MensOk");
}

function borramsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}
function bloq() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function inval() {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    mensajes("inval");
}

function back() {
    $(location).attr('href', 'Bienvenido.jsp');
}

function ErrorBusquedaMatch() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapmsg.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/aceptar.png');
    mensajes("MenValores");
}

function borrarmsg() {
    $('#iconmsg').hide();
    $('#msg').html("");
}

function mensajesValidacionInco(msg) {
    var BE = document.createElement('audio');
    BE.src = "audio/saperror.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    $('#msg').html(msg);
}

function validar() {
    $('#iconmsg').hide();
    $('#msg').html("");
    var cen = $('#centro').val();
    var al = $('#Almacen').val();
    var cc = $('#centroco').val();
    var orde = $('#orden').val();
    var alre = $('#Arece').val();
    var mov2 = $('#ListTipMov').val();
    var movi3 = mov2.substring(0, 3);

    if (cen.length < 1 || al.length < 1 || movi3.length < 1) {
        if (cen.length < 1) {
            $('#centro').focus();
        } else if (al.length < 1) {
            $('#Almacen').focus();
        } else if (movi3.length < 1) {
            $('#ListTipMov').focus();
        } else {
        }
        var BE = document.createElement('audio');
        BE.src = "audio/sapmsg.wav";
        BE.play();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        mensajes("CampOb");
    } else {
        if (movi3 === "201" || movi3 === "261" || movi3 === "311") {
            switch (movi3) {
                case '201':
                    if (cen != "" && al != "" && movi3 == "201" && cc != "") {
                        COMPRmatereial();
                    } else {
                        if (cc.length < 1) {
                            ClasMOV(movi3);
                            $('#centroco').focus();
                        } else {
                        }
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        mensajes("CampOb201");
                    }
                    break;
                case '261':
                    if (cen != "" && al != "" && movi3 == "261" && orde != "") {
                        COMPRmatereial();
                    } else {
                        if (orde.length < 1) {
                            ClasMOV(movi3);
                            $('#orden').focus();
                        } else {
                        }
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        mensajes("CampOb261");
                    }
                    break;
                case '311':

                    if (cen != "" && al != "" && movi3 == "311" && alre != "") {
                        var numfilas = $("input[name = 'material']").length;
                        for (var i = 0; i < numfilas + 1; i++) {
                            var m = document.getElementsByName("material");
                            var ma = m[i].value;

                            if (validatmaterialLamacen311(ma) == true) {
                                if (ValAlma1() == true) {
                                    ValAlma();
                                } else {
                                    COMPRmatereial();
                                }
                            }
//                            else {
//                                mensajes("EAlm", ma, "");
//                                break;
//                            }
                        }
                    } else {
                        if (alre.length < 1) {
                            ClasMOV(movi3);
                            $('#Arece').focus();
                        } else {
                        }
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        mensajes("CampOb311");
                    }
                    break;
            }
        } else {
            var BE = document.createElement('audio');
            BE.src = "audio/saperror.wav";
            BE.play();
            var mensj = "Clase de Movimiento no permitida";
            $('#iconmsg').show();
            $('#iconmsg').attr('src', 'images/advertencia.PNG');
            $('#msg').html(mensj);
        }
    }
}

function validatmaterialLamacen311(m) {
    var acc = "ValMaterialAlmacen";
    var cen = "&cen=" + $('#centro').val();
    var al = "&al=" + $('#Almacen').val();
    var al2 = "&alre=" + $('#Arece').val();
    var d311 = false;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + cen + al + al2 + "&mater=" + m,
        success: function (data) {
            if (data == 1) {
                d311 = true;
            }
        }
    });
    return d311;

}

function COMPRmatereial() {
    var numfilas = $("input[name = 'material']").length;
    var i = 0;
//    alert(numfilas);
    while (i <= numfilas) {
        if (i == numfilas) {
//            alert("num filas: " + numfilas + ", i = " + i);
            GuardaDatosTabla();
            break;
        } else {
            var mati = document.getElementsByName("material");
            var canti = document.getElementsByName("cantidad");
            var cantidad = canti[i].value;
            var material = mati[i].value;
//            alert("cantidad: " + cantidad + ", material: " + material + ", valor de i: " + i);
            if (material === "" || cantidad === "" || cantidad == null || cantidad === 'NaN.000') {
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                mensajes("tablva");
                if (material == "") {
                    material = mati[i].focus();
                    break;
                } else if (cantidad == "" || cantidad === 'NaN.000' || cantidad == null || cantidad.length < 1) {
//                    alert("hola val ceros");
                    cantidad = canti[i].focus();
                    break;
                }
            } else {
                if (cantidad === "0.000" || cantidad == 0) {
                    i++;
                } else {
                    if (ValMateGuar(i)) {
                        //alert("el i: " + i + ", cantidad: " + cantidad + ", material " + material);
                        i++;
                    } else {
                        MensajeMal2(material, i);
                        break;
                    }
                }
            }
        }
    }
}


function GuardaDatosTabla() {
    var folio = $('#ffff').val();
    var actual = parseInt(folio);
    var numfilas = $("input[name = 'material']").length;
    var centro = $('#centro').val();
    var almacen = $('#Almacen').val();
    var movimiento = $('#ListTipMov').val();
    var mov = movimiento.substring(0, 3);
    var centrocoste = $('#centroco').val();
    var orden = $('#orden').val();
    var alde = $('#Arece').val();
    var sum = 0;

    //var cont;
//    alert(numfilas);
    for (var i = 0; i < numfilas; i++) {
        var mat = document.getElementsByName("material");
        var material = mat[i].value;
        var canti = document.getElementsByName("cantidad");
        var cantidad = canti[i].value;
        var unimed = document.getElementsByName("unidadmedida");
        var unimedida = unimed[i].value;
        var descri = document.getElementsByName("descripcion");
        var descripcion = descri[i].value;
        var description = descripcion.replace(/'/g, "´");
        var cont;
        var posicion = i + 1;
        if (posicion <= 9) {
            cont = "000" + posicion + "0";
        } else if (posicion < 100 && posicion > 9) {
            cont = "00" + posicion + "0";
        } else if (posicion < 1000 && posicion > 99) {
            cont = "0" + posicion + "0";
        } else {
            cont = posicion + "0";
        }
//        alert("mat: " + material + ", canti :" + cantidad);
        var enviar = "&MATERIAL=" + material.toUpperCase() + "&CANTIDAD=" + GetCantend(cantidad, unimedida) + "&UNIDADMEDIDA=" + unimedida.toUpperCase() + "&DESCRIPCION=" + encodeURIComponent(description.toUpperCase()) + "&FOLIO=" + actual + "&CENTRO=" + centro.toUpperCase() + "&ALMACEN=" + almacen.toUpperCase() + "&MOVIMIENTO=" + mov + "&CENTROCO=" + centrocoste.toUpperCase() + "&ORDEN=" + orden + "&CONTADOR=" + cont + "&alde=" + alde.toUpperCase();
//        alert(enviar);
        if ((material === "" && material === null) || (cantidad === "" && cantidad === null) || (unimedida === "" && unimedida === null) || (descripcion === "" && descripcion === null)) {

        } else {
            if (cantidad === "0.000" || cantidad == 0) {

            } else {
                if (inst(enviar)) {
                    sum++;
                }
                ;
            }
        }
    }
//    alert(sum);
    if (sum > 0) {
        setTimeout(function () {
            obtenerDatos(mov, sum);
       }, 1000);        
    }
}

function inst(enviar) {
    alert("Aqui hace la insercion: " + enviar);
    var rt = false;
    var acc = "GuardarReservaPosiciones";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionGuardaReserva',
        contentType: 'application/x-www-form-urlencoded',
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 0) {
//                alert("PTM");t
            } else {
                rt = true;
                //TableMat();
            }
        }
    });
    return rt;
}

function obtenerDatos(cl, c) {
    //alert("Entra");
    var acc = "GuardarReserva";
    var centro = $('#centro').val();
    var almacen = $('#Almacen').val();
    var clase = $('#ListTipMov').val();

    var centroco = $('#centroco').val();
    var orden = $('#orden').val();
    var fecha = $('#feres').val();
    var hora = $('#hores').val();
    var alde = $('#Arece').val();
    var foc = $('#focfoc').val();

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionGuardaReserva',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&CENTRO=" + centro.toUpperCase() + "&ALMACEN=" + almacen.toUpperCase() + "&CLASE=" + cl + "&CENTROCO=" + centroco.toUpperCase() + "&ORDEN=" + orden + "&FECHA=" + fecha + "&HORA=" + hora + "&alde=" + alde.toUpperCase() + "&USUARIOCREA=" + $('#usus').val() + "&cont=" + c,
        success: function (data) {
            if (data == 0) {
                $('#msg').html("Error en la Red");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
            } else {
                LimpAll();
                $('#msg').html("Creado correctamente " + data);
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/aceptar.png');
                ConsultaMatchClaseMov();
                
            }
        }
    });
}

//function Reload(fol) {
//    window.location.href = "Reservas.jsp?men=" + fol;
//}

function ValMateGuar(va) {
    var rt = false;
    var cen = $('#centro').val();
    var al = $('#Almacen').val();
    var clase = $('#ListTipMov').val();
    var Arece = $('#Arece').val();
    //var matt = $("input[name = 'material']").val();
    var matt = document.getElementsByName("material");
    var acc = "ValMate";
    var enviar;
    var mater = matt[va].value;
    //alert("matt: " + matt + ", mater: " + mater + ", val: " + va);
    if (clase === "311") {
        for (var i = 0; i <= 2; i++) {
            if (i == 2) {
                rt = true;
            } else {
                var alma;
                if (i == 0) {
                    alma = al;
                } else {
                    alma = Arece;
                }
                enviar = "&mater=" + mater + "&cen=" + cen + "&al=" + alma;
                if (valor31(acc, enviar)) {
                } else {
                    return rt;
                }
            }
        }
        return rt;
    } else {
        var enviar = "&mater=" + mater + "&cen=" + cen + "&al=" + al;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionReservas',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 1) {
                    rt = true;
                }
            }
        });
        return rt;
    }
}

function valor31(acc, enviar) {
    var rt = false;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            if (data == 1) {
                rt = true;
            }
        }
    });
    return rt;
}

function MensajeMal2(mat, i) {
    var mati = document.getElementsByName("material");
    mati[i].focus();
    var BE = document.createElement('audio');
    BE.src = "audio/sapmsg.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    mensajes("Mate", mat);
}

function ValAlma1() {
    var alde = $('#Arece').val();
    var almacen = $('#Almacen').val();
    var rt = false;
    if (alde === almacen) {
        return rt = true;
    }
    return rt;
}

function ValAlma(u) {
    var alde = $('#Arece').val();
    var almacen = $('#Almacen').val();
    if (alde.toUpperCase() === almacen.toUpperCase()) {
        if (u == 2) {
            $('#Arece').focus();
        } else {
            $('#Almacen').focus();
        }
        var BE = document.createElement('audio');
        BE.src = "audio/sapmsg.wav";
        BE.play();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        mensajes("AlmReNot");
    }
}

function ConsultaMatchCentro() {
    var acc = "ConsultaMatchCentro";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            $('#BuscarParam_c').hide();
            $('#ConsultaTabla').show();
            $('#CargarDatos').html(data);
            fnc();
        }
    });
}

function ConsultaMatchAlmacen(id) {
    var acc = "ConsultaMatchAlmacen";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&id=" + id + "&Idioma=" + $('#idiomaa').val(),
        success: function (data) {
            $('#BuscarParam_a').hide();
            $('#ConsultaTablaa').show();
            $('#CargarDatosa').html(data);
            fnc2();
        }
    });
}

function ConsultaMatchClaseMov() {
    var acc = "MatchTipoMovReservas";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc, // + "&id=" + id,
        success: function (data) {
            //$('#BuscarParam_CM').hide();
            //$('#ConsultaTablaCM').show();
            //$('#CargarDatoCM').html(data);
            $('#ListTipMov').html(data);
        }
    });
}

function ConsultaMatchCentroCo() {
    var acc = "ConsultaMatchCentroCoste";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&CentroCO=" + $('#centro_co').val() + "&SociedadCO=" + $('#sociedad_co').val() + "&DescripcionCO=" + $('#texto_breve').val() + "&CantidadMatch=" + $('#numAcMax').val(),
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $('#BuscarParam_co').hide();
                $('#ConsultaTablaco').show();
                $('#CargarDatosco').html(data);
                borrarmsg();
            }
        }
    });
}

function ConsultaMatchOrdenes() {
    var acc = "ConsultaMatchOrdenes";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionReservas',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&NumOrd=" + $('#orden_or').val() + "&DescripcionCO=" + $('#texto_breveor').val() + "&CantidadMatch=" + $('#numAcMax2').val(),
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $('#BuscarParam_o').hide();
                $('#ConsultaTablao').show();
                $('#CargarDatoso').html(data);
                fnc3();
                borrarmsg();
            }
        }
    });
}

function ConsultarMaterial() {
    var acc = "ConsultaMatchMatReserva";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'peticionVisualizarMateriales',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + "&MaterialMatch=" + $('#material_ma').val() + "&DescripMatch=" + $('#texto_mate').val() + "&CentroMatch=" + $('#centrito').val() + "&CantidadMatch=" + $('#numAcMax5').val() + "&TImat=" + $('#TImat').val(),
        success: function (data) {
            if (data == 0) {
                ErrorBusquedaMatch();
            } else {
                $('#BuscarParam_m').hide();
                $('#ConsultaTablam').show();
                $('#CargarDatosm').html(data);
                borrarmsg();
            }
        }
    });
}

//function fnc() {
//    document.getElementById('table-scroll').onscroll = function () {
//        document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
//    };
//}
//function fnc2() {
//    document.getElementById('table.scrolla').onscroll = function () {
//        document.getElementById('fixedYa').style.top = document.getElementById('table-scrolla').scrollTop + 'px';
//    };
//}
//function fnc3() {
//    document.getElementById('table.scrollco').onscroll = function () {
//        document.getElementById('fixedYco').style.top = document.getElementById('table-scrollco').scrollTop + 'px';
//    };
//}
//function fnc4() {
//    document.getElementById('table.scrollo').onscroll = function () {
//        document.getElementById('fixedYo').style.top = document.getElementById('table-scrollo').scrollTop + 'px';
//    };
//}
//function fnc5() {
//    document.getElementById('table.scrollm').onscroll = function () {
//        document.getElementById('fixedYm').style.top = document.getElementById('table-scrollm').scrollTop + 'px';
//    };
//}

function MatchMaterial(valor) {
    var numero = valor;
    Prueba(numero);
    MostrarVentanaModal('material');
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

function MostrarVentanaModal(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd01.wav";
    BE.play();
    switch (tipo) {
        case 'centro':
            var ventana = document.getElementById('VentanaModalCentro');
            abrirVentana(ventana);
            var theHandle = document.getElementById("handle");
            var theRoot = document.getElementById("VentanaModalCentro");
            Drag.init(theHandle, theRoot);
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'Almacen':
            var ventanaA = document.getElementById('VentanaModalAlmacen');
            abrirVentana2(ventanaA, tipo);
            var theHandle = document.getElementById("handle2");
            var theRoot = document.getElementById("VentanaModalAlmacen");
            Drag.init(theHandle, theRoot);
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'Arece':
            var ventanaA = document.getElementById('VentanaModalAlmacen');
            abrirVentana2(ventanaA, tipo);
            var theHandle = document.getElementById("handle2");
            var theRoot = document.getElementById("VentanaModalAlmacen");
            Drag.init(theHandle, theRoot);
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'centroco':
            var ventana3 = document.getElementById('VentanaModalCentroCoste');
            abrirVentanaCE(ventana3);
            var theHandle = document.getElementById("handle3");
            var theRoot = document.getElementById("VentanaModalCentroCoste");
            Drag.init(theHandle, theRoot);
            $('#centro_co').val("").focus();
            $('#texto_breve').val("");
            $('#numAcMax').val("500");
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'orden':
            var ventana4 = document.getElementById('VentanaModalOrdenes');
            abrirVentanaCE(ventana4);
            var theHandle = document.getElementById("handle4");
            var theRoot = document.getElementById("VentanaModalOrdenes");
            Drag.init(theHandle, theRoot);
            $('#orden_or').val("").focus();
            $('#texto_breveor').val("");
            $('#numAcMax2').val("500");
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'material':
            var ventana5 = document.getElementById('VentanaModalMaterial');
            abrirVentanaCE(ventana5);
            var theHandle = document.getElementById("handle7");
            var theRoot = document.getElementById("VentanaModalMaterial");
            Drag.init(theHandle, theRoot);
            $('#material_ma').val("").focus();
            $('#texto_mate').val("");
            $('#centrito').val("");
            $('#TImat').val("");
            $('#numAcMax5').val("500");
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
        case 'ClaseMov':
            var ventanaA = document.getElementById('VentanaModalClaseMov');
            abrirVentanaClaseMov(ventanaA, tipo);
            var theHandle = document.getElementById("handle5");
            var theRoot = document.getElementById("VentanaModalClaseMov");
            Drag.init(theHandle, theRoot);
            $('#iconmsg').hide();
            $('#msg').html("");
            break;
    }
}

function abrirVentana(ventana) {
    $(ventana).css({
        position: 'absolute', left: 508, top: 60
    });
    $(ventana).show();
    ConsultaMatchCentro();
}
function abrirVentana2(ventana, id) {
    $(ventana).css({
        position: 'absolute', left: 508, top: 60
    });
    $(ventana).show();
    ConsultaMatchAlmacen(id);
}
function abrirVentanaClaseMov(ventana, id) {
    $(ventana).css({
        position: 'absolute', left: 508, top: 60
    });
    $(ventana).show();
    ConsultaMatchClaseMov(id);
}
function abrirVentanaCE(ventana) {
    $(ventana).css({
        position: 'absolute', left: 508, top: 60
    });
    $(ventana).show();
}

function seleccionar(obj, tipo, id) {
    switch (tipo) {
        case 'centro':
            $('#centro').val(obj).focus();
            ocultarVentana(tipo);
            break;
        case 'Almacen':
            $('#Almacen').val(obj).focus();
            ocultarVentana('almacen');
            break;
        case 'Arece':
            $('#Arece').val(obj).focus();
            ocultarVentana('almacen');
            break;
        case 'centroco':
            $('#centroco').val(obj).focus();
            ocultarVentana(tipo);
            break;
        case 'orden':
            $('#orden').val(obj).focus();
            ocultarVentana(tipo);
            break;
        case 'material':
            $('#material' + id).val(obj).focus();
            obtener(obj, id);
            ocultarVentana(tipo);
            break;
        case 'ClaseMov':
            $('#ClaseMov').val(obj).focus();
            ocultarVentana('ClaseMov');
            break;
        default:
            break;
    }
}

function ocultarVentana(tipo) {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#overlay').remove();
    switch (tipo) {
        case 'centro':
            $('#VentanaModalCentro').hide();
            $('#BuscarParam_c').show();
            $('#ConsultaTabla').hide();
            $('#centro').focus();
            break;
        case 'almacen':
            $('#VentanaModalAlmacen').hide();
            $('#BuscarParam_a').show();
            $('#VonsultaTablaa').hide();
            $('#Almacen').focus();
            break;
        case 'centroco':
            $('#VentanaModalCentroCoste').hide();
            $('#BuscarParam_co').show();
            $('#ConsultaTablaco').hide();
            $('#centroco').focus();
            break;
        case 'orden':
            $('#VentanaModalOrdenes').hide();
            $('#BuscarParam_o').show();
            $('#ConsultaTablao').hide();
            $('#orden').focus();
            break;
        case 'material':
            $('#VentanaModalMaterial').hide();
            $('#BuscarParam_m').show();
            $('#ConsultaTablam').hide();
            break;
        case 'ClaseMov':
            $('#VentanaModalClaseMov').hide();
            $('#BuscarParam_CM').show();
            $('#ConsultaTablaCM').hide();
            $('#ClaseMov').focus();
            break;
        case 'VentanaModalTextli':
            $('#VentanaModalTextli').hide();
            break;
        default:
            break;
    }
}

function obtener(obj, numero) {
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
                $('#material' + numero).val("");
                $('#unidadmedida' + numero).val("");
                $('#descripcion' + numero).val("");
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                mensajes("errorcon");
            } else {
                var n = data;
                $('#descripcion' + numero).val(n[0]);
                $('#unidadmedida' + numero).val(n[1]);
            }
        }
    });
}

function validarCen() {
    var acc = "ValidarCentro";
    if ($('#centro').val().length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaReserva',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&CENTI=" + $('#centro').val().toUpperCase(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    mensajes('Cntr', $('#centro').val().toUpperCase());
                    $('#centro').val("").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}

function validarAlm() {
    var acc = "ValidarAlmacen";
    if ($('#Almacen').val().length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaReserva',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&ALM=" + $('#Almacen').val().toUpperCase(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    mensajes('AlmNo', $('#Almacen').val().toUpperCase());
                    $('#Almacen').val("").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}

function validarClase() {
    if ($('#ClaseMov').val() == "201" || $('#ClaseMov').val() == "261" || $('#ClaseMov').val() == "311" || $('#ClaseMov').val() == "") {
        borrarmsg();
    } else {
        var msg = "Clase de Movimiento: " + $('#ClaseMov').val().toUpperCase() + " no permitida";
        mensajesValidacionInco(msg);
        $('#ClaseMov').val("").focus();
    }
}

function validarCCO() {
    var acc = "ValidarCCO";
    if ($('#centroco').val().length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaReserva',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&CCO=" + $('#centroco').val(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    mensajes('CECO', $('#centroco').val().toUpperCase());
                    $('#centroco').val("").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}

function validarOR() {
    var acc = "ValidarOR";
    if ($('#orden').val().length > 0) {
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionGuardaReserva',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + "&OR=" + $('#orden').val(),
            success: function (data) {
                if (data == 0) {
                    var BE = document.createElement('audio');
                    BE.src = "audio/sapmsg.wav";
                    BE.play();
                    $('#iconmsg').show();
                    $('#iconmsg').attr('src', 'images/advertencia.PNG');
                    mensajes('ordnpt', $('#orden').val().toUpperCase());
                    $('#orden').val("").focus();
                } else {
                    borrarmsg();
                }
            }
        });
    }
}

function ValMateRese(val) {
    var mater = $('#material' + val).val();
    var cen = $('#centro').val();
    var al = $('#Almacen').val();
    var clase = $('#ListTipMov').val();
    var cc = $('#centroco').val();
    var orde = $('#orden').val();
    var Arece = $('#Arece').val();
    var acc = "ValMate";
    var enviar;
    if (cen.length < 1 || al.length < 1 || clase.length < 1) {
        if (cen.length < 1) {
            $('#centro').focus();
        } else if (al.length < 1) {
            $('#Almacen').focus();
        } else if (clase.length < 1) {
            $('#ClaseMov').focus();
        } else {
        }
        var BE = document.createElement('audio');
        BE.src = "audio/sapmsg.wav";
        BE.play();
        $('#iconmsg').show();
        $('#iconmsg').attr('src', 'images/advertencia.PNG');
        mensajes("CampOb");
    } else {
        if (clase === "311") {
            if (Arece === "" || Arece === null) {
                var BE = document.createElement('audio');
                BE.src = "audio/sapmsg.wav";
                $('#Arece').focus();
                BE.play();
                $('#iconmsg').show();
                $('#iconmsg').attr('src', 'images/advertencia.PNG');
                mensajes("CampOb");
            } else {
                for (var i = 0; i <= 2; i++) {
                    if (i == 2) {
                        traerMAtres(val);
                    } else {
                        var alma;
                        if (i == 0) {
                            alma = al;
                        } else {
                            alma = Arece;
                        }
                        enviar = "&mater=" + mater.toUpperCase() + "&cen=" + cen.toUpperCase() + "&al=" + alma.toUpperCase();
                        if (valor31(acc, enviar)) {

                        } else {
                            MensajeMal3(val, alma);
                            return;
                        }
                    }
                }

            }
        } else {
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
                    //alert("VAL MAT" + data);
                    if (data == 1) {
                        traerMAtres(val);
                    } else {
                        var BE = document.createElement('audio');
                        BE.src = "audio/sapmsg.wav";
                        BE.play();
                        $('#iconmsg').show();
                        $('#iconmsg').attr('src', 'images/advertencia.PNG');
                        mensajes("Mate", '');
                    }
                }

            });
        }
    }
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

function MensajeMal3(val, alma) {
    var mat = $('#material' + val).val();
    var BE = document.createElement('audio');
    BE.src = "audio/sapmsg.wav";
    BE.play();
    $('#iconmsg').show();
    $('#iconmsg').attr('src', 'images/advertencia.PNG');
    mensajes('MateAl', mat, alma.toUpperCase());
}

function camMATChpri(di1, di2) {
    $('#' + di1).show();
    $('#' + di2).hide();
}

function PutValue(valo) {
    $("#vallima").val(valo);
}