/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();

    $("#regresar").click(function () {
        back();
    });

    function back() {
        window.location.href = "Bienvenido.jsp";
    }
    $('#material').css("background-image", "url(images/necesario.PNG)");
    //$('#centro').css("background-image", "url(images/necesario.PNG)");
    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').hide();
    $('#match_C4').hide();
    $('#material').focus(function () {
        $('#match_C1').show();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').hide();
        $('#material').css("background-image", "none");
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $('#material').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validar();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#centro').focus(function () {
        $('#centro').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').show();
        $('#match_C3').hide();
        $('#match_C4').hide();
        if ($('#material').val().length < 1) {
            $('#material').css("background-image", "url(images/necesario.PNG)");

        }
    });
    $('#centro').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            validar();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $("#organizacion").focus(function () {
        $('#organizacion').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').show();
        $('#match_C4').hide();
        if ($('#material').val().length < 1) {
            $('#material').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
    });
    $("#organizacion").keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $("#canal").keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $("#canal").focus(function () {
        $('#canal').css("background-image", "none");
        $('#match_C1').hide();
        $('#match_C2').hide();
        $('#match_C3').hide();
        $('#match_C4').show();
        if ($('#material').val().length < 1) {
            $('#material').css("background-image", "url(images/necesario.PNG)");
        }
        if ($('#centro').val().length < 1) {
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
    });

    //Eventos Match
    $('#match_C1').click(function () {
        var theHandle = document.getElementById("handle");
        var theRoot = document.getElementById("VentanaModal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('material');
    });
    $('#match_C2').click(function () {
        var theHandle = document.getElementById("handle2");
        var theRoot = document.getElementById("VentanaModalCentro");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('centro');
    });
    $('#match_C3').click(function () {
        var theHandle = document.getElementById("handle3");
        var theRoot = document.getElementById("VentanaModalOrganizacion");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('organizacion');
    });
    $('#match_C4').click(function () {
        var theHandle = document.getElementById("handle4");
        var theRoot = document.getElementById("VentanaModalCanal");
        Drag.init(theHandle, theRoot);
        mostrarVentanaModal('canal');

    });

    $('#OkMaterial').click(function () {
        ConsultarMaterial();
    });
    $('#material_ma').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#tipmat').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#texto_mate').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
    });
    $('#centrito').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultarMaterial();
        }
        if (tecla == 32) {
            return false;
        }
        patron = /[0-9a-zA-ZñÑ]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });
    $('#numAcMax').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te === 8) {
            return false;
        }
        if (te === 13) {
            ConsultarMaterial();
        }
        patron = /[0-9]/;
        t = String.fromCharCode(te);
        return patron.test(t);
    });
    $('#retornfiltro').click(function () {
        $("#BuscarParam_m").css("display", "block");
        $("#ConsultaTabla").css("display", "none");
    });

    $("#aceptar").click(function () {
        validar();
    });


    function mostrarVentanaModal(tipo)
    {
        switch (tipo) {
            case 'material':

                var ventana = document.getElementById("VentanaModal");
                abrirVentana(ventana);
                var txtmate = $("#material_ma");
                $("#texto_mate").val("");
                $("#centrito").val("");
                var nm = $("#numAcMax");
                txtmate.focus();
                txtmate.val("");
                nm.val('500');
                var iconm = $("#iconmsg");
                iconm.hide();
                var men = $("#msg");
                men.html("");
                mensajess(0, "");
                break;
            case 'centro':
                var ventanac = document.getElementById("VentanaModalCentro");
                abrirVentana(ventanac);
                var txtcen = $("#centro");
                txtcen.focus();
                var iconm = $("#iconmsg");
                iconm.hide();
                var men = $("#msg");
                men.html("");
                mensajess(0, "");
                break;
            case 'organizacion':

                var ventanam = document.getElementById("VentanaModalOrganizacion");
                abrirVentana2(ventanam);
                var txtorga = $("#organizacion");
                txtorga.focus();
                var iconm = $("#iconmsg");
                iconm.hide();
                var men = $("#msg");
                men.html("");
                mensajess(0, "");
                break;
            case 'canal':

                var ventanaca = document.getElementById('VentanaModalCanal');
                abrirVentana3(ventanaca);
                var txtca = $("#canal");
                txtca.focus();
                var iconm = $("#iconmsg");
                iconm.hide();
                var men = $("#msg");
                men.html("");
                mensajess(0, "");
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
        ConsultaMatchCentro();
    }
    function abrirVentana2(ventana) {
        var ancho = 350;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        ConsultaMatchOrganizacion();
    }
    function abrirVentana3(ventana) {
        var ancho = 350;
        var alto = 650;
        var x = (screen.width / 2) - (ancho / 2);
        var y = (screen.height / 2) - (alto / 2);
        ventana.style.left = x + "px";
        ventana.style.top = y + "px";
        ventana.style.display = 'block';
        ConsultaMatchCanal();
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
                $("#BuscarParam_C").css("display", "none");
                $("#ConsultaTablaC").css("display", "block");
                $("#CargarDatosC").html(data);
                fnc1();
            }

        });
    }



    function ConsultaMatchOrganizacion() {
        var acc = "ConsultaMatchOrganizacion";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc,
            success: function (data) {
                $("#BuscarParam_O").css("display", "none");
                $("#ConsultaTablaO").css("display", "block");
                $("#CargarDatosO").html(data);
                fnc1();
            }

        });
    }


    function ConsultaMatchCanal() {
        var acc = "ConsultaMatchCanal";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc,
            success: function (data) {
                $("#BuscarParam_CA").css("display", "none");
                $("#ConsultaTablaCA").css("display", "block");
                $("#CargarDatosCA").html(data);
                fnc1();
            }

        });
    }

    function ConsultarMaterial() {
        var acc = "ConsultaMaterial";
        var mate = $("#material_ma").val();
        var des = $("#texto_mate").val();
        var cen = $("#centrito").val();
        var tp = $("#tipmat").val();
        var ctdmax = $("#numAcMax").val();
        var enviar = "&MaterialMatch=" + mate + "&DescripMatch=" + des + "&CentroMatch=" + cen + "&TPMAT=" + tp + "&CantidadMatch=" + ctdmax;
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarMateriales',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    mensajess(1, "");
                } else {
                    $("#BuscarParam_m").css("display", "none");
                    $("#ConsultaTabla").css("display", "block");
                    $("#CargarDatosM").html(data);
                    fnc();
                    borrarmsg();
                }
            }

        });
    }

    function borrarmsg() {
        var iconm = $("#iconmsg");
        iconm.hide();
        var men = $("#msg");
        men.html("");
    }


    function fnc() {
        document.getElementById('table-scroll').onscroll = function () {
            document.getElementById('fixedY').style.top = document.getElementById('table-scroll').scrollTop + 'px';
        };
    }
    function fnc1() {
        document.getElementById('table-scrollC').onscroll = function () {
            document.getElementById('fixedYC').style.top = document.getElementById('table-scrollC').scrollTop + 'px';
        };
    }

    function validar()
    {
        var mat = $("#material").val();
        var cen = $("#centro").val();
        var can = $("#canal").val();
        var orga = $("#organizacion").val();
        if (mat.length < 1 || cen.length < 1)
        {
            mensajess(2, "");
            dataFocus();

        } else
        {
            enviarDatos(mat, cen, orga, can);
        }
    }

    function dataFocus() {
        mensajess(2, "");
        var temp = new Array();
        temp[0] = document.getElementById("material");
        temp[1] = document.getElementById("centro");


        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].value.length === 0)
            {
                temp[i].focus();
                return;
            }
        }
    }


    function enviarDatos(mate, cent, organ, canl) {
        var enviar = "&MaterialCarga=" + mate + "&CentroCarga=" + cent + "&OrganizacionCarga=" + organ + "&CanalCarga=" + canl;
        var acc = "CargarMaterial";
        $.ajax({
            async: false,
            type: 'GET',
            url: 'peticionVisualizarMateriales',
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    limpiar();
                    mensajess(3, "");
                } else {
                  var  n = data;
                    $("#descripcionj").html(n[0]);
                    $("#centro").html(n[1]);
                    $("#organizacion").val(n[2]);
                    $("#canal").val(n[3]);
                    $("#umb").val(n[4]);
                    $("#nomaterial").val(n[5]);
                    $("#tipomaterialj").val(n[6]);
                    $("#grupoarticulosj").val(n[7]);
                    $("#sectorj").val(n[8]);
                    $("#umventaj").val(n[9]);
                    $("#gematerialj").val(n[10]);
                    $("#gtpmatej").val(n[11]);
                    $("#jeraproj").val(n[12]);
                    $("#gpmatej").val(n[13]);
                    $("#grupoimmatej").val(n[14]);
                    $("#gtpgenj").val(n[15]);
                    $("#gvdispoj").val(n[16]);
                    $("#grupotransportej").val(n[17]);
                    $("#centrobenej").val(n[18]);
                    $("#sujetolotej").val(n[19]);
                    $("#grupocargaj").val(n[20]);
                    $("#grupocomprasj").val(n[21]);
                    $("#caraplannj").val(n[22]);
                    $("#puntopedidoj").val(n[23]);
                    $("#gpnecej").val(n[24]);
                    $("#tlpnecej").val(n[25]);
                    $("#tlminj").val(n[26]);
                    $("#hpfijoj").val(n[27]);
                    $("#pnecesij").val(n[28]);
                    $("#tlmaxj").val(n[29]);
                    $("#stockmaximoj").val(n[30]);
                    $("#claseaproj").val(n[31]);
                    $("#ttmdiaj").val(n[32]);
                    $("#stockseguridadj").val(n[33]);
                    $("#stockseguridadmj").val(n[34]);
                    $("#claseaprovij").val(n[35]);
                    $("#pepdiaj").val(n[36]);
                    $("#epimcenj").val(n[37]);
                    $("#qmaporj").val(n[38]);
                    $("#icpreciosj").val(n[39]);
                    $("#pmviperj").val(n[40]);
                    $("#precioestandarj").val(n[41]);
                    $("#cantidadbasej").val(n[42]);
                    $("#clasevaloracionj").val(n[43]);
                    $("#categoriavaloracionj").val(n[44]);
                    mensajess(4, "");
                }
            }

        });
    }


    function limpiar()
    {
        $("#material").val("");
        $("#descripcionj").html("");
        $("#centro").val("");
        $("#organizacion").val("");
        $("#organizacion").val("");
        $("#canal").val("");
        $("#umb").val("");
        $("#nomaterial").val("");
        $("#tipomaterialj").val("");
        $("#grupoarticulosj").val("");
        $("#sectorj").val("");
        $("#umventaj").val("");
        $("#gematerialj").val("");
        $("#gtpmatej").val("");
        $("#jeraproj").val("");
        $("#gpmatej").val("");
        $("#grupoimmatej").val("");
        $("#gtpgenj").val("");
        $("#gvdispoj").val("");
        $("#grupotransportej").val("");
        $("#centrobenej").val("");
        $("#sujetolotej").val("");
        $("#grupocargaj").val("");
        $("#grupocomprasj").val("");
        $("#caraplannj").val("");
        $("#puntopedidoj").val("");
        $("#gpnecej").val("");
        $("#tlpnecej").val("");
        $("#tlminj").val("");
        $("#hpfijoj").val("");
        $("#pnecesij").val("");
        $("#tlmaxj").val("");
        $("#stockmaximoj").val("");
        $("#claseaproj").val("");
        $("#ttmdiaj").val("");
        $("#stockseguridadj").val("");
        $("#stockseguridadmj").val("");
        $("#claseaprovij").val("");
        $("#pepdiaj").val("");
        $("#epimcenj").val("");
        $("#qmaporj").val("");
        $("#icpreciosj").val("");
        $("#pmviperj").val("");
        $("#precioestandarj").val("");
        $("#cantidadbasej").val("");
        $("#clasevaloracionj").val("");
        $("#categoriavaloracionj").val("");
    }


    function cargar(rs)
    {
        var n = new Array();
        n = rs.split(",");
        $("#descripcionj").html(n[0]);
        $("#centro").html(n[1]);
        $("#organizacion").val(n[2]);
        $("#canal").val(n[3]);
        $("#umb").val(n[4]);
        $("#nomaterial").val(n[5]);
        $("#tipomaterialj").val(n[6]);
        $("#grupoarticulosj").val(n[7]);
        $("#sectorj").val(n[8]);
        $("#umventaj").val(n[9]);
        $("#gematerialj").val(n[10]);
        $("#gtpmatej").val(n[11]);
        $("#jeraproj").val(n[12]);
        $("#gpmatej").val(n[13]);
        $("#grupoimmatej").val(n[14]);
        $("#gtpgenj").val(n[15]);
        $("#gvdispoj").val(n[16]);
        $("#grupotransportej").val(n[17]);
        $("#centrobenej").val(n[18]);
        $("#sujetolotej").val(n[19]);
        $("#grupocargaj").val(n[20]);
        $("#grupocomprasj").val(n[21]);
        $("#caraplannj").val(n[22]);
        $("#puntopedidoj").val(n[23]);
        $("#gpnecej").val(n[24]);
        $("#tlpnecej").val(n[25]);
        $("#tlminj").val(n[26]);
        $("#hpfijoj").val(n[27]);
        $("#pnecesij").val(n[28]);
        $("#tlmaxj").val(n[29]);
        $("#stockmaximoj").val(n[30]);
        $("#claseaproj").val(n[31]);
        $("#ttmdiaj").val(n[32]);
        $("#stockseguridadj").val(n[33]);
        $("#stockseguridadmj").val(n[34]);
        $("#claseaprovij").val(n[35]);
        $("#pepdiaj").val(n[36]);
        $("#epimcenj").val(n[37]);
        $("#qmaporj").val(n[38]);
        $("#icpreciosj").val(n[39]);
        $("#pmviperj").val(n[40]);
        $("#precioestandarj").val(n[41]);
        $("#cantidadbasej").val(n[42]);
        $("#clasevaloracionj").val(n[43]);
        $("#categoriavaloracionj").val(n[44]);
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
function bloq()
{
    $("#iconmsg").hide();
    $("#guardar").css("disabled", "true");
}
window.onload = function () {
    startTime();
    bloq();
//                        var us = '<%=Nombre%>'
//                        TraerCentro(us);
};

function inval()
{
    mensajess(5, "");

}
