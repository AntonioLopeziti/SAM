/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    startTime();
    window.onload = function () {
        startTime();
        bloq();
        CArgarMne();
        tabsprin();

    };
    $('#guardar').click(function (e) {
        e.preventDefault();
        validar();
    });
    $('#CerraCalendar1').click(function (e) {
        CerrarCalendario();
    });
    $('#calenimg').click(function (e) {
        CerrarCalendario();
    });

    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();



    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;

    var today = day + "." + month + "." + year;
    $("#theDate").attr("value", today);
    $("#theDate").val(today);
    $('#ubictec_CA').css("background-image", "none");
    $('#equipo_CA').css("background-image", "none");
    $('#conjunto_CA').css("background-image", "none");
    $('#GrpPlanificacion_CA').css("background-image", "none");
    $('#puestotrabajo_CA').css("background-image", "none");
    $('#match_A1').hide();
    $('#match_A2').hide();
    $('#match_A3').css("display", "none");
    $('#match_A4').css("display", "none");
    $('#match_A5').css("display", "none");

    $('#ubictec_CA').focus(function () {
        $('#match_A1').show();
        $('#match_A2').hide();
        $('#match_A3').css("display", "none");
        $('#match_A4').css("display", "none");
        $('#match_A5').css("display", "none");
        $('#ubictec_CA').css("background-image", "none");

    });
    $('#ubictec_CA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            //validar();
        }
    });

    $('#equipo_CA').focus(function () {
        $('#equipo_CA').css("background-image", "none");
        $('#match_A1').hide();
        $('#match_A2').show();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').hide();
    });
//    $('#equipo_CA').keypress(function (e) {
//        if (e.which == 13 || e.keyCode == 13) {
//            validar();
//        }
//    });
    $("#conjunto_CA").focus(function () {
        $('#conjunto_CA').css("background-image", "none");
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').show();
        $('#match_A4').hide();
        $('#match_A5').hide();

    });
    $("#conjunto_CA").keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13)
        {
            // validar();
        }
    });
    $('#GrpPlanificacion_CA').focus(function () {
        $('#GrpPlanificacion_CA').css("background-image", "none");
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').show();
        $('#match_A5').hide();
    });
    $('#GrpPlanificacion_CA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            // validar();
        }
    });
    $('#puestotrabajo_CA').focus(function () {
        $('#match_A1').hide();
        $('#match_A2').hide();
        $('#match_A3').hide();
        $('#match_A4').hide();
        $('#match_A5').show();
    });
    $('#puestotrabajo_CA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            //validar();
        }
    });

    $('#ubitec_MAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            Consultaubitec();
        }
    });
    $('#ClaseAvisoMAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaFolioSAM();
        }
    });
    $('#Denominacion_MAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            Consultaubitec();
        }
    });
    $('#Sociedad_MAA').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            Consultaubitec();
        }
    });
    $('#numAcMax').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            Consultaubitec();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    ///// match  Equipos
    $('#DenominacionEquipoMatch_MAA').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaEquipos();
        }
    });
    $('#EquipoMatch_MAA').keypress(function (e) {
        if (e.wich == 13 || e.keyCode == 13) {
            ConsultaEquipos();
        }
    });
    $('#numAcMax2').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaEquipos();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    //// match conjunto
    $('#Material_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaConjunto();
        }
    });
    $('#MaterialDes_bus').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaConjunto();
        }
    });
    $('#numAcMax3').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaConjunto();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    //// macth puesto trabajo responsable
    $('#ptrDenom_Match').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaPtr();
        }
    });
    $('#ptrPuestoT_Match').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaPtr();
        }
    });

    $('#ptrCentro_Match').keypress(function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            ConsultaPtr();
        }
    });
    $('#numAcMax8').keypress(function (e) {
        var tecla = (document).all ? e.keyCode : e.which;
        if (tecla == 13) {
            ConsultaPtr();
        }
        patron = /[0-9]/;
        te = String.fromCharCode(tecla);
        return patron.test(te);
    });

    $('.numFac').keypress(function (e) {
        tecla = (document.all) ? e.keyCode : e.which;
        if (tecla == 8) {
            return true;
        }
        if (this.value.substring(0) == 0) {
            this.value = (this.value + '').replace(/[^1-9]/g, '');
        }
        patron = /[0-9]/;
        tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    });

    $("#aceptar").click(function () {
        UBEQconsul();
    });
    $("#regresar").click(function () {
        back();
    });
    $("#finalizar").click(function () {
        limpiar();
    });
    $("#cancelar").click(function () {
        finalizar();
    });



    ////////segunda parte///////////

    $("#BVOclo").hide();
    $("#BVOcp").hide();
    $("#BVOdi").hide();
    $("#BVOptr").hide();

    $('#IVOclo').focus(function () {
        $("#BVOclo").show();
        $("#BVOcp").hide();
        $("#BVOdi").hide();
        $("#BVOptr").hide();
    });

    $('#IVOcp').focus(function () {
        $("#BVOclo").hide();
        $("#BVOcp").show();
        $("#BVOdi").hide();
        $("#BVOptr").hide();
    });
    $('#IVOdi').focus(function () {
        $("#BVOclo").hide();
        $("#BVOcp").hide();
        $("#BVOdi").show();
        $("#BVOptr").hide();
    });
    $('#IVOptr').focus(function () {
        $("#BVOclo").hide();
        $("#BVOcp").hide();
        $("#BVOdi").hide();
        $("#BVOptr").show();
    });
    $('#IVOctr').focus(function () {
        $("#BVOclo").hide();
        $("#BVOcp").hide();
        $("#BVOdi").hide();
        $("#BVOptr").hide();
    });

    $("#BVOptr").click(function () {
        mostrarVentanaModal('ptr2');
    });

    $("#BVOcp").click(function () {
        mostrarVentanaModal('centro');
    });

    $("#BVOclo").click(function () {
        mostrarVentanaModal('CLasOR');
        cargarCLASORden();
    });

    $("#okORDAV").click(function () {
        MandarORdeAVis();
    });

    $("#okCONAVI").click(function () {
        TERminAVISO();
    });



    $("#match_A1").click(function () {
        mostrarVentanaModal('ubitec');
    });


    $("#match_A2").click(function () {
        mostrarVentanaModal('equipo');
    });


    $("#match_A3").click(function () {
        mostrarVentanaModal('conjunto')
    });

    $('#equipo_CA').keyup(function (){
        UBEQconsul();
        //LLamaequipo();
    });
    $('#equipo_CA').blur(function (){
        UBEQconsul();
    });
    //$("#equipo_CA").click(function () {
        //alert("vbfbfkj");
        //LLamaequipo();
   // });

    $("#ubictec_CA").click(function () {
        LLamaUBtecn();
    });

    $("#match_A4").click(function () {
        mostrarVentanaModal('grupop');
    });
    $("#match_A5").click(function () {
        mostrarVentanaModal('ptr');
    });
    $("#btnacubt").click(function () {
        Consultaubitec();
    });
    $("#btnacequi").click(function () {
        ConsultaEquipos();
    });
    $("#btnacconj").click(function () {
        ConsultaConjunto();
    });

    $("#btnaccen").click(function () {
        ConsultCentro();
    });

    $("#btnacptr").click(function () {
        ConsultaPtr();
    });


    function mostrarVentanaModal(tipo)
    {


        switch (tipo) {
            case 'ubitec':
                var theHandle = document.getElementById("handle");
                var theRoot = document.getElementById("VentanaModalUbitec");
                Drag.init(theHandle, theRoot);
                var ventana = document.getElementById('VentanaModalUbitec');
                abrirVentana(ventana);
                $("#ubitec_MAA").focus();
                $("#ubitec_MAA").val('');
                $("#Denominacion_MAA").val('');
                $("#Sociedad_MAA").val('');
                $("#numAcMax").val('500');
                break;

            case'equipo':
                var theHandle = document.getElementById("handle2");
                var theRoot = document.getElementById("VentanaModalEquipos");
                Drag.init(theHandle, theRoot);
                var ventana = document.getElementById('VentanaModalEquipos');
                borramsg();
                abrirVentana(ventana);
                $("#DenominacionEquipoMatch_MAA").focus();
                $("#DenominacionEquipoMatch_MAA").val('');
                $("#EquipoMatch_MAA").val('');
                $("#numAcMax2").val('500');
                //$("#iconmsg").hide();
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'conjunto':
                var theHandle = document.getElementById("handle3");
                var theRoot = document.getElementById("VentanaModalConjunto");
                Drag.init(theHandle, theRoot);
                var ventana3 = document.getElementById('VentanaModalConjunto');
                abrirVentana(ventana3);
                borramsg();
                $("#Material_bus").focus();
                $("#Material_bus").val('');
                $("#MaterialDes_bus").val('');
                $("#numAcMax3").val('500');
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'centro':
                var theHandle = document.getElementById("handle4");
                var theRoot = document.getElementById("VentanaModalCentro");
                Drag.init(theHandle, theRoot);
                var ventana4 = document.getElementById("VentanaModalCentro");
                borramsg();
                abrirVentana(ventana4);
                var txtcanal = document.getElementById('CanalD_CL');
                txtcanal.focus();
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'usuario':
                var theHandle = document.getElementById("handle5");
                var theRoot = document.getElementById("VentanaModalUsuario");
                Drag.init(theHandle, theRoot);
                var ventana5 = document.getElementById("VentanaModalUsuario");
                borramsg();
                abrirVentana(ventana5);
                var txtsector = document.getElementById('Sector_CL');
                txtsector.focus();
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'grupop':
                var theHandle = document.getElementById("handle6");
                var theRoot = document.getElementById("VentanaModalGrupoP");
                Drag.init(theHandle, theRoot);
                $('#GrpPlanificacion_CA').val("");

                var ventana6 = document.getElementById("VentanaModalGrupoP");
                borramsg();

                $("#GrpPlanificacion_CA").html("");

                abrirVentana(ventana6);
                ConsultaGrupoP();
                var txtsector = document.getElementById('Sector_CL');
                txtsector.focus();
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'centrop':
                var theHandle = document.getElementById("handle7");
                var theRoot = document.getElementById("VentanaModalCentroP");
                Drag.init(theHandle, theRoot);
                var ventana7 = document.getElementById("VentanaModalCentroP");
                borramsg();
                abrirVentana(ventana7);
                ConsultaCentroP();
                var txtsector = document.getElementById('Sector_CL');
                txtsector.focus();
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;
            case 'ptr':
                var theHandle = document.getElementById("handle8");
                var theRoot = document.getElementById("VentanaModalPtr");
                Drag.init(theHandle, theRoot);

                var ventana8 = document.getElementById("VentanaModalPtr");
                borramsg();
                abrirVentana(ventana8);
                $("#ptrDenom_Match").focus();
                $("#ptrDenom_Match").val("");
                $("#ptrPuestoT_Match").val("");
                $("#ptrCentro_Match").val("");
                $("#numAcMax8").val("500");
                $("#iconmsg").css("visibility", "hidden");
                $("#msg").html("");
                break;

        }

    }
    $("#match_A54").click(function () {
        ElminarFilACt();
    });
    $("#match_A546").click(function () {
        AgragarFilACt();
    });
    function Consultaubitec() {
        var acc = "ConsultaUbitec";
        var ubitec = $("#ubitec_MAA").val();
        var denominacion = $("#Denominacion_MAA").val();
        var sociedad = $("#Sociedad_MAA").val();
        var ctd = $("#numAcMax").val();
        var enviar = "&Parametro8=" + ubitec + "&Parametro6=" + denominacion + "&Parametro7=" + sociedad + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    ErrorBusquedaMatch();
                } else {
                    $("#BuscarParam_u").css("display", "none");
                    $("#ConsultaTabla").css("display", "block");
                    $("#cargarDatos1").html(rs);
                    borramsg();
                }
            }

        });
    }


    function ConsultaEquipos() {
        var acc = "ConsultaEquipos";
        var equipo = $("#EquipoMatch_MAA").val();
        var denominacion = $("#DenominacionEquipoMatch_MAA").val();
        var ctd = $("#numAcMax2").val();
        var enviar = "&Parametro10=" + denominacion + "&Parametro9=" + equipo + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    ErrorBusquedaMatch();
                } else {
                    $("#BuscarParamSoc_u").css("display", "none");
                    $("#ConsultaTabla2").css("display", "block");
                    $("#cargarDatos2").html(data);
                    borramsg();
                }
            }

        });
    }


    function ConsultaConjunto() {
        var acc = "ConsultaMateriales";
        var mat = $("#Material_bus").val();
        var texto = $("#MaterialDes_bus").val();
        var ctd = $("#numAcMax3").val();
        var enviar = "&Parametro5=" + mat + "&Parametro2=" + texto + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    ErrorBusquedaMatch();
                } else {
                    $("#BuscarParam_OV").css("display", "none");
                    $("#ConsultaTabla3").css("display", "block");
                    $("#cargarDatos3").html(data);
                    borramsg();
                }
            }

        });
    }

    function ConsultCentro() {
        var acc = "ConsultaCentro";
        var activo = $("#ActivoMatch_CA").val();
        var denominacion = $("#SubnumeroMatch_CA").val();
        var sociedad = $("#SociedadMatch_CA").val();
        var ubitec = $("#UbitecMatch_CA").val();
        var ctd = $("#numAcMax4").val();
        var enviar = "&Parametro5=" + activo + "&Parametro6=" + denominacion + "&Parametro7=" + sociedad + "&Parametro8=" + ubitec + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                $("#BuscarParam_Can").css("display", "none");
                $("#ConsultaTabla4").css("display", "block");
                $("#cargarDatos4").html(data);
                borramsg();
            }

        });
    }


    function ConsultaGrupoP() {
        var acc = "ConsultaGrupoPlanificacion";
        var grupo = $("#GrpPlanificacion_CA").val();
        var centro = $("#CentroPlaninificacion_CA").val();
        var ctd = $("#numAcMax4").val();
        var enviar = "&Parametro22=" + grupo + "&Parametro23=" + centro + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                $("#BuscarParam_GrupoP").css("display", "none");
                $("#ConsultaTabla6").css("display", "block");
                $("#cargarDatos6").html(data);
                borramsg();
            }

        });
    }

    function ConsultaPtr() {
        var acc = "ConsultaPuestoTrabajo";
        var denominacion = $("#ptrDenom_Match").val();
        var ptres = $("#ptrPuestoT_Match").val();
        var centro = $("#ptrCentro_Match").val();
        var ctd = $("#numAcMax8").val();
        var enviar = "&Parametro2=" + denominacion + "&Parametro25=" + centro + "&Parametro24=" + ptres + "&Parametro4=" + ctd;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                var rs = data;
                if (rs == 0) {
                    ErrorBusquedaMatch();
                } else {
                    $("#BuscarParam_Ptr").css("display", "none");
                    $("#ConsultaTabla8").css("display", "block");
                    $("#cargarDatos8").html(data);
                    borramsg();
                }
            }

        });
    }


    $("#ubictec_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#equipo_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#conjunto_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#GrpPlanificacion_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#CentroPlaninificacion_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#puestotrabajo_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#puestotrabajo2_CA").keydown(function (e) {
        tecla = e.keyCode ? e.keyCode : e.which;
        if (tecla == 32) {
            return false;
        }
    });
    $("#ubitec_MAA").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#EquipoMatch_MAA").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#Material_bus").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#CanalD_CL").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#GrupoPMatch_CA").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#CentroPMatch_CA").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#ptrPuestoT_Match").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });
    $("#ptrCentro_Match").keydown(function (e) {
        key = e.keyCode ? e.keyCode : e.which;
        if (key == 32) {
            return false;
        }
    });


});

function startTime() {
    var h;
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    var hor;
    if (h < 10) {
        hor = "0" + h;
    } else {
        hor = h;
    }
    $("#tiempo").html(hor + ":" + m + ":" + s);
    $("#Time").val(hor + ":" + m + ":00");
    t = setTimeout('startTime()', 500);

}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

function AgragarFilACt() {
//                            alert("hola");
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var fila = tabla.insertRow(numfilas);
    var iad = parseInt(numfilas);
    var checbo = document.createElement("input");
    checbo.type = "checkbox";
    var cell1 = fila.insertCell(0);
    cell1.appendChild(checbo);

    var ele0 = document.createElement("input");
    ele0.type = "text";
    ele0.readOnly = true;
    ele0.style.backgroundColor = "#F2F2F2";
    ele0.style.borderStyle = "none";
    ele0.style.width = "60px";
    var cell0 = fila.insertCell(1);
    cell0.appendChild(ele0);

    var cell2 = fila.insertCell(2);
    var element2 = document.createElement("input");
    element2.onclick = function () {
        OculButt(iad)
    };
    element2.type = "text";
    element2.style.width = "65px";
    element2.style.borderStyle = "none";
    element2.id = "grco" + iad;
    element2.name = "grco";
    element2.maxLength = 8;
    var ele2 = document.createElement("input");
    ele2.type = "button";
    ele2.onclick = function () {
        venMate(iad)
    };
    ele2.style.marginleft = "1px";
    ele2.style.height = "18px";
    ele2.style.width = "19px";
    ele2.style.backgroundImage = "url('images/busqueda.png')";
    ele2.style.backgroundPosition = "center";
    ele2.style.backgroundRepeat = "no-repeat";
    ele2.style.display = "none";
    ele2.id = "matmat1" + iad;
    ele2.name = "matmat1";
    cell2.appendChild(element2);
    cell2.appendChild(ele2);

    var cell3 = fila.insertCell(3);
    var element3 = document.createElement("input");
    element3.type = "text";
    element3.style.width = "125px";
    element3.style.borderStyle = "none";
    element3.id = "deco" + iad;
    element3.maxLength = 4;
    cell3.appendChild(element3);

    var cell4 = fila.insertCell(4);
    var element4 = document.createElement("input");
    element4.type = "text";
    element4.style.width = "125px";
    element4.style.borderStyle = "none";
    element4.readOnly = true;
    element4.style.backgroundColor = "#F2F2F2";
    element4.id = "teco" + iad;
    element4.maxLength = 40;
    cell4.appendChild(element4);

    var cell5 = fila.insertCell(5);
    var element5 = document.createElement("input");
    element5.type = "text";
    element5.style.width = "125px";
    element5.style.borderStyle = "none";
    element5.id = "teac" + iad;
    element5.maxLength = 40;
    cell5.appendChild(element5);

    var cell6 = fila.insertCell(6);
    var elemet6 = document.createElement("spam");
    cell6.appendChild(elemet6);

//    var cell7 = fila.insertCell(7);
//    var element7 = document.createElement("input");
//    element7.type = "text";
//    element7.maxLength = 3;
//    element7.style.display = "none";
//    element7.style.borderStyle = "none";
//    element7.id = "FCan" + iad;
//    element7.style.display = "none";
//    element7.onkeypress = function (e) {
//        tecla = (document.all) ? e.keyCode : e.which;
//        if (tecla == 8) {
//            return true;
//        }
//        if (this.value.substring(0) == 0) {
//            this.value = (this.value + '').replace(/[^1-9]/g, '');
//        }
//        patron = /[0-9]/;
//        tecla_final = String.fromCharCode(tecla);
//        return patron.test(tecla_final);
//    };
//    cell7.appendChild(element7);

    var cell8 = fila.insertCell(7)
    var element8 = document.createElement("input");
    element8.onclick = function () {
        OculFe(iad)
    };
    element8.type = "text";
    element8.style.width = "72%";
    element8.style.borderStyle = "none";
    element8.id = "fechaAV" + iad;
    element8.maxLength = 10;
    element8.readOnly = true;
    var ele8 = document.createElement("input");
    ele8.type = "button";
    ele8.id = "dateNew" + iad;
    ele8.class = "BtnMatchIcon";
    ele8.onclick = function () {
        venFee(iad)
    };
    ele8.style.marginleft = "1px";
    ele8.style.height = "18px";
    ele8.style.width = "19px";
    ele8.style.backgroundPosition = "center";
    ele8.style.backgroundRepeat = "no-repeat";
    ele8.style.backgroundImage = "url('images/match.png')";
    ele8.style.display = "none";
    cell8.appendChild(element8);
    cell8.appendChild(ele8);

    var cell9 = fila.insertCell(8);
    var element9 = document.createElement("input");
    element9.type = "text";
    element9.style.width = "80px";
    element9.style.borderStyle = "none";
    element9.readOnly = true;
    element9.id = "Time" + iad;
    element9.onclick = function () {
        OculBTi(iad)
    };
    var ele9 = document.createElement("input");
    ele9.type = "button";
    ele9.style.marginleft = "1px";
    ele9.style.height = "18px";
    ele9.style.width = "19px";
    ele9.style.backgroundImage = "url('images/busqueda.png')";
    ele9.style.backgroundPosition = "center";
    ele9.style.backgroundRepeat = "no-repeat";
    ele9.id = "matma" + iad;
    ele9.style.display = "none";
    ele9.onclick = function () {
        venTiempoU(iad)
    };
    cell9.appendChild(element9);
    cell9.appendChild(ele9);

    var cell10 = fila.insertCell(9);
    var element10 = document.createElement("input");
    element10.onclick = function () {
        OculFe2(iad)
    };
    element10.type = "text";
    element10.style.width = "72%";
    element10.style.borderStyle = "none";
    element10.id = "fechaAV1" + iad;
    element10.maxLength = 10;
    element10.readOnly = true;
    var ele10 = document.createElement("input");
    ele10.type = "button";
    ele10.id = "dateNew1" + iad;
    ele10.class = "BtnMatchIcon";
    ele10.onclick = function () {
        venFee1(iad)
    };
    ele10.style.marginleft = "1px";
    ele10.style.height = "18px";
    ele10.style.width = "19px";
    ele10.style.backgroundPosition = "center";
    ele10.style.backgroundRepeat = "no-repeat";
    ele10.style.backgroundImage = "url('images/match.png')";
    ele10.style.display = "none";
    cell10.appendChild(element10);
    cell10.appendChild(ele10);
//    var cell10 = fila.insertCell(10);
//    var element10 = document.createElement("input");
//    element10.type = "date";
//    element10.style.width = "145px";
//    element10.style.borderStyle = "none";
//    element10.id = "theDate1" + iad;
//    cell10.appendChild(element10);

    var cell11 = fila.insertCell(10);
    var element11 = document.createElement("input");
    element11.type = "text";
    element11.style.width = "80px";
    element11.style.borderStyle = "none";
    element11.readOnly = true;
    element11.id = "Time1" + iad;
    element11.onclick = function () {
        OculBTi2(iad)
    };
    var ele11 = document.createElement("input");
    ele11.type = "button";
    ele11.style.marginleft = "1px";
    ele11.style.height = "18px";
    ele11.style.width = "19px";
    ele11.style.backgroundImage = "url('images/busqueda.png')";
    ele11.style.backgroundPosition = "center";
    ele11.style.backgroundRepeat = "no-repeat";
    ele11.id = "matma1" + iad;
    ele11.style.display = "none";
    ele11.onclick = function () {
        venTiempoD(iad)
    };
    cell11.appendChild(element11);
    cell11.appendChild(ele11);

//    var ele12 = document.createElement("input");
//    ele12.type = "text";
//    ele12.readOnly = true;
//    ele12.style.backgroundColor = "#F2F2F2";
//    ele12.style.borderStyle = "none";
//    ele12.style.width = "60px";
//    ele12.value = "0";
//    var cell12 = fila.insertCell(12);
//    cell12.appendChild(ele12);


    var ele13 = document.createElement("input");
    ele13.type = "text";
    ele13.name = "valores";
    ele13.value = iad;
    ele13.hidden = true;
    var cell13 = fila.insertCell(11);
    cell13.appendChild(ele13);
    cell13.hidden = true;

}
function ElminarFilACt() {

    try {
        var tabla = document.getElementById("AvisoTabla");
        var numfilas = tabla.rows.length;

        for (var i = 0; i < numfilas; i++) {
            var filas = tabla.rows[i];
            var chec = filas.cells[0].childNodes[0];
            if (null != chec && true == chec.checked) {
                tabla.deleteRow(i);
                numfilas--;
                i--;
            }

        }

    } catch (e) {
        alert(e);
    }

}



var output = [];
function uploadFiles() {
    var Formdata = new FormData($('#FormCreate')[0]);
    for (var i = 0; i < output.length; i++) {
        Formdata.append('file[]', output[i]);
    }
    $.ajax({
        url: 'ArchivosSAM',
        type: 'POST',
        data: Formdata,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {

        }

    });
    return false;
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Se comento para avisos-SANPER (AL-No validar ubTec)
//function validar() {
//    
//    var ubitec = $("#ubictec_CA").val();
//    var equipo = $("#equipo_CA").val();
//    var Nfolio = GetFolio();
//    var textobreve = $("#DescripcionCircunstancias_CA").val();
////            alert(equipo.length +" "+ ubitec.length +" "+textobreve.length );
//    if (equipo.length < 1 && ubitec.length < 1)
//    {
//        //error
//        mensajess(0, "audio/saperror.wav", "images/advertencia.PNG");
//        if (equipo.length < 1) {
//            $("#equipo_CA").focus();
//        }
//    } else {
//        if (textobreve.length < 1) {
//            if (textobreve.length < 1) {
//                mensajess(0, "audio/saperror.wav", "images/advertencia.PNG");
//                $("#DescripcionCircunstancias_CA").focus();
//            }
//        } else {
//            $('#guardar').prop('disabled', true);
//            ValidarDatosAv(Nfolio);
//        }
//    }
//}

function validar() {

    var equipo = $('#equipo_CA').val();
    var textobreve = $("#descripcionnotificacion_CA").val();
    //var Nfolio = GetFolio();
    var Nfolio = "";
    if (equipo.length < 1 || equipo === "" && textobreve.length < 1 || textobreve === "") {

        mensajess(0, "audio/saperror.wav", "images/advertencia.PNG");
    } else {
        mensajess(18, "audio/sapmsg.wav", "images/load.gif");
        $('#guardar').prop('disabled', true);
        setTimeout(function () {
            ValidarDatosAv(Nfolio);
        }, 400);
    }
}

function  ValidarDatosAv(Nfolio) {

    //var ubitec = $("#ubictec_CA").val();
    var ubitec = "";
    var equipo = $("#equipo_CA").val();
    var acc = "ValidarCUca";
    var enviar = "&Parametro9=" + equipo.toUpperCase() + "&Parametro8=" + ubitec.toUpperCase();
    var fol = Nfolio;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            var rec = new Array();
            rec = data.split(",");
            var ub = rec[0];
            var eq = rec[1];
            //if (ub == 0 || eq == 0) {
            if (data == 0) {
                //DatosNOvalidos(ub, eq);
                DatosNOvalidos("", data);
            } else {
                //Comenté Funcion porque no aplicaba.
                //FechaTabla(0);
                //Agregar Funcion directa para guardar aviso.
                Save(fol);
            }

        },
    });

}

function DatosNOvalidos(ub, eq) {

    //var ubitec = document.getElementById('ubictec_CA');
    var equipo = document.getElementById('equipo_CA');

//    if (ub == 0) {
//        ubitec.focus();
//        mensajALer('U');
//        return;
//    }
    if (eq == 0) {
        equipo.focus();
        mensajALer('E');
        return;
    }

}




function inval() {

    mensajess(1, "audio/saperror.wav", "images/advertencia.PNG");

}
function check() {
    mensajess(1, "audio/saperror.wav", "images/aceptar.png");

}

function back() {
    window.location.href = "CrearAvisoAcceso.jsp";
}

function finalizar() {
    window.location.href = "Bienvenido.jsp";
}
function Reload(fol) {
    uploadFiles();
    window.location.href = "CrearAviso.jsp?men=" + fol;
}







function mandarGruCod(num) {
    var idioma = "<%=Idioma%>";
    var acc = "MatchGrupCod";
    var url = "PeticionModuloAvisos";
    var enviar = "&lan=" + idioma + "&numbe=" + num;

    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            var rs = data;
            if (rs == 0) {
                ErrorBusquedaMatch();
            } else {
                $("#cargarDatos9").html(data);
            }
        }

    });


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

function ocultarVentana(tipo) {
    switch (tipo) {
        case "ubitec":
            $("#VentanaModalUbitec").css("display", "none");
            $("#BuscarParam_u").css("display", "block");
            $("#ConsultaTabla").css("display", "none");
            break;
        case 'equipo':
            $("#VentanaModalEquipos").css("display", "none");
            $("#BuscarParamSoc_u").css("display", "block");
            $("#ConsultaTabla2").css("display", "none");
            break;
        case 'conjunto':
            $("#VentanaModalConjunto").css("display", "none");
            $("#BuscarParam_OV").css("display", "block");
            $("#ConsultaTabla3").css("display", "none");
            break;
        case 'centro':
            $("#VentanaModalCentro").css("display", "none");
            $("#BuscarParam_Can").css("display", "block");
            $("#ConsultaTabla4").css("display", "none");
            break;
        case 'usuario':
            $("#VentanaModalUsuario").css("display", "none");
            $("#BuscarParam_Sec").css("display", "block");
            $("#ConsultaTabla5").css("display", "none");
            break;
        case 'grupop':
            $("#VentanaModalGrupoP").css("display", "none");
            $("#BuscarParam_GrupoP").css("display", "block");
            $("#ConsultaTabla6").css("display", "none");
            break;
        case 'centrop':
            $("#VentanaModalCentroP").css("display", "none");
            $("#BuscarParam_P").css("display", "block");
            $("#ConsultaTabla7").css("display", "none");
            break;
        case 'ptr':
            $("#VentanaModalPtr").css("display", "none");
            $("#BuscarParam_Ptr").css("display", "block");
            $("#ConsultaTabla8").css("display", "none");
            break;
        case 'GrupCodi':
            $("#VentanaModalGrupoCod").css("display", "none");

            break;
        case 'VentanaModal':
            $("#VentHora").css("display", "none");
            break;
        default:
            break;
    }
}


function ErrorBusquedaMatch() {
    //MEnsaje de correcto
    mensajess(2, "audio/sapmsg.wav", "images/aceptar.png");
}
function borramsg() {

    $("#iconmsg").css("visibility", "hidden");
    $("#msg").html("");
}

function seleccionar(obj, tipo) {
    switch (tipo) {
        case 'ubitec':
            var ub = new Array();
            var ub = obj.split("|");
            $("#ubictec_CA").focus();
            $("#ubictec_CA").val(ub[0]);
            $("#DenominacionUbitec_MAA").val(ub[1]);
            ocultarVentana(tipo);
            break;
        case 'equipo':
            var equip = new Array();
            var equip = obj.split("|");
            $("#equipo_CA").focus();
            $("#equipo_CA").val(equip[0]);
            $("#DenominacionEquipo_MAA").val(equip[1]);
            ocultarVentana(tipo);
            break;
        case 'conjunto':
            var material = new Array();
            var material = obj.split("|");
            $("#conjunto_CA").focus();
            $("#conjunto_CA").val(material[0]);
            $("#DenominacionConjunto_MAA").val(material[1]);
            ocultarVentana(tipo);
            break;
        case 'centro':
            $("#puestotrabajo2_CA").focus();
            $("#puestotrabajo2_CA").val(obj);
            ocultarVentana(tipo);
            break;
        case 'usuario':
            $("#autorAviso_CA").focus();
            $("#autorAviso_CA").value(obj);
            ocultarVentana(tipo);
            break;
        case 'grupop':
            var grucen = new Array();
            var grucen = obj.split("|");
            $("#GrpPlanificacion_CA").focus();
            $("#GrpPlanificacion_CA").val(grucen[0]);
            $("#CentroPlaninificacion_CA").val(grucen[1]);
            ocultarVentana(tipo);
            break;
        case 'ptr':
            var p = new Array();
            var p = obj.split("|");
            $("#puestotrabajo_CA").focus();
            $("#puestotrabajo_CA").val(p[0]);
            $("puestotrabajo2_CA").val(p[1]);
            $("DenominacionPuestoTrabajo_MAA").val(p[2]);
            ocultarVentana(tipo);
            break;
        default:
            break;
    }
}

function ObtenerFolioRandom() {
    var name = $('#NombreUser').val();
    var ip = $('#IpData').val();
    var n = ip + "" + name;
    return n;
}

function Save(fol) {

    var idioma = "<%=Idioma%>";
    var ubitec = $("#ubictec_CA").val();
    var denoubitec = $("#DenominacionUbitec_MAA").val();
    var equipo = $("#equipo_CA").val();
    var denoequipo = $("#DenominacionEquipo_MAA").val();
    var conjunto = $("#conjunto_CA").val();
    var denoconjunto = $("#DenominacionConjunto_MAA").val();
    var grupop = $("#GrpPlanificacion_CA").val();
    var centrop = $("#CentroPlaninificacion_CA").val();
    var puestot = $("#puestotrabajo_CA").val();
    var centro = $("#puestotrabajo2_CA").val();
    var denopuestot = $("#DenominacionPuestoTrabajo_MAA").val();
    var depres = $("#departamento_CA").val();
    var depres2 = $("#departamento2_CA").val();
    var responsable = $("#responsable_CA").val();
    var responsable2 = $("#responsable2_CA").val();
    var autor = $("#autorAviso_CA").val();
    var fecha = $("#theDate").val();
    var hora = $("#Time").val();
    //var cod = $("#codificacion_CA").val();
    var cod = "";
    //var codi = $("#ubitec2_CA").val();
    var codi = ""
    var desc = $("#DescripcionCircunstancias_CA").val();
    var descc = desc.replace(/'/g, "´");
    //alert(descc);
    var folio = $("#folio").val();
    var textobreve = $("#DescripcionCircunstancias_CA").val();
    var txtbreve = textobreve.replace(/'/g, "´");
    var ip = ObtenerFolioRandom();
    enviarDatos(ubitec, denoubitec, equipo, denoequipo, conjunto, denoconjunto, grupop, centrop, puestot, centro, denopuestot, depres, depres2, responsable, responsable2, autor, fecha, hora, cod, codi, descc, fol, txtbreve, idioma, ip);

}
function enviarDatos(ubitec, denoubitec, equipo, denoequipo, conjunto, denoconjunto, grupop, centrop, puestot, centro, denopuestot, depres, depres2, responsable, responsable2, autor, fecha, hora, cod, codi, desc, fol, textobreve, idioma, ip) {
    var foli = fol;
    var ip = ip;
    var statOR = $("#statusSis_orden").val();
    var acc = "GuardarAviso";
    var enviar = "&Parametro37=" + $.trim(foli) + "&Parametro32=" + hora + "&Parametro31=" + fecha + "&Parametro11=" + centrop + "&Parametro38=" + encodeURIComponent(textobreve) + "&Parametro9=" + equipo + "&Parametro33=" + cod + "&Parametro34=" + codi + "&Parametro8=" + ubitec + "&Parametro14=" + denoubitec + "&Parametro10=" + denoequipo + "&Parametro5=" + conjunto + "&Parametro22=" + grupop + "&Parametro24=" + puestot + "&Parametro25=" + centro + "&Parametro15=" + denopuestot + "&Parametro26=" + depres + "&Parametro27=" + depres2 + "&Parametro28=" + responsable + "&Parametro29=" + responsable2 + "&Parametro30=" + autor + "&lan=" + idioma + "&Parametro35=" + encodeURIComponent(desc) + "&statOR=" + statOR + "&Random=" + ip;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc + enviar,
        success: function (data) {
            var rs = data.split(",");
            var num = rs[0];
            var NFol = rs[1];
            if (num == 0) {
                mensajess(3, "audio/saperror.wav", "images/advertencia.PNG");
            } else if (num == 2) {
                textCircuns(NFol, ip);
                Mens(90, "audio/sapmsg.wav", "images/aceptar.png", NFol);
                NuevoLimpia();
            } else {
                Reload();
                alert('<%=datGuaCorr%>');
            }
        }

    });
}

function textCircuns(NFOL, ip) {

    var nota1 = $("#TexareaCircunstancia_CA").val();
    var nota2 = nota1.replace(/'/g, "´");
    var tam = nota2.length;
    var lim = tam / 132;
    var l = Math.ceil(lim);
    for (var i = 0; i < l; i++) {
        var d = i * 132;
        no = nota2.substr(d, 132);
        var acc = "GuardaTEXTos";
        var fila = i + 1;
        var enviar = "&fila=" + fila + "&linea=" + encodeURIComponent(no) + "&foli=" + $.trim(NFOL);
        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                //limpiar();
                if (data == 0) {
                }
            }

        });

    }
    //ActFolAvis(ip);
    //NuevoFOLi();
}

function NuevoLimpia() {
    $('#descripcionnotificacion_CA').val('');
    $(":text", $('.Secbobj_avi')).val('');
    $(":text", $('.SeccionCircunstancias_CA')).val('');
    $('#GrpPlanificacion_CA').val('');
    $('#CentroPlaninificacion_CA').val('');
    $('#puestotrabajo_CA').val('');
    $('#puestotrabajo2_CA').val('');
    $('#TexareaCircunstancia_CA').val('');
    $('#guardar').prop("disabled", false);
}

function ActFolAvis(random) {
    var acc = "ActualizarFolioAviso";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Accion=" + acc + "&Random=" + random,
        success: function (data) {
            $('#guardar').prop("disabled", false);
            LoadItems();
            ShowMsg(20, "images/aceptar.png", "audio/sapmsg.wav", data);
        }
    });
}

function GetFolio() {
    var folio;
    var acc = "RevisarFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {
            //alert("data"+data+"data");
            folio = data;
        }
    });
    return $.trim(folio);
}

function NuevoFOLi() {
    var acc = "NuevFolio";
    $.ajax({
        async: false,
        type: 'GET',
        url: 'PeticionModuloAvisos',
        contentType: "application/x-www-form-urlencoded",
        processData: true,
        data: "Action=" + acc,
        success: function (data) {

            if (data == 1) {
                guradraTabFecha();
            } else {

            }
        }

    });

}

function limpiar() {
    $("#ubictec_CA").val("");
    $("#equipo_CA").val("");
    $("#conjunto_CA").val("");
    $("#GrpPlanificacion_CA").val("");
    $("#CentroPlaninificacion_CA").val("");
    $("#puestotrabajo_CA").val("");
    $("#puestotrabajo2_CA").val("");
    $("#departamento_CA").val("");
    $("#departamento2_CA").val("");
    $("#responsable_CA").val("");
    $("#responsable2_CA").val("");
    $("#autorAviso_CA").val("");
    $("#theDate").val("");
    $("#Time").val("");
    $("#codificacion_CA").val("");
    $("#ubitec2_CA").val("");
    $("#DescripcionCircunstancias_CA").val("");
    $("#TexareaCircunstancia_CA1").val("");
    $("#TexareaCircunstancia_CA2").val("");
    $("#TexareaCircunstancia_CA3").val("");
    $("#TexareaCircunstancia_CA4").val("");
    $("#TexareaCircunstancia_CA5").val("");
    $("#TexareaCircunstancia_CA6").val("");
    $("#descripcionnotificacion_CA").val("");
}

function OculButt(nu) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    for (var i = 0; i < n; i++) {
        if (nu != i) {
            $("#matmat1" + i).css("display", "none");
        } else {
            $("#matmat1" + nu).css("display", "inline");
        }
    }
}
function OculFe(nu) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    for (var i = 0; i < n; i++) {
        if (nu != i) {
            $("#dateNew" + i).css("display", "none");
        } else {
            $("#dateNew" + nu).css("display", "inline");
        }
    }
}
function OculFe2(nu) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    for (var i = 0; i < n; i++) {
        if (nu != i) {
            $("#dateNew1" + i).css("display", "none");
        } else {
            $("#dateNew1" + nu).css("display", "inline");
        }
    }
}



function seleccionarGC(gr, cod, tex, id, ven) {
    $("#grco" + id).val(gr);
    $("#deco" + id).val(cod);
    $("#teco" + id).val(tex);
    $("#matmat1" + id).css("display", "none");
    ocultarVentana(ven);
}

function OculBTi(nu) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    for (var i = 0; i < n; i++) {
        if (nu != i) {
            $("#matma" + i).css("display", "none");
        } else {
            $("#matma" + nu).css("display", "inline");
        }
    }
}

function OculBTi2(nume) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    for (var i = 0; i < n; i++) {
        if (nume != i) {
            $("#matma1" + i).css("display", "none");
        } else {
            $("#matma1" + nume).css("display", "inline");
        }
    }

}

function AsignarHora(id) {

    var hor = $("#Time").val();
    var sep = new Array();
    var ho1;
    var ho2;
    var ho3;
    sep = hor.split(":");
    ho1 = sep[0];
    ho2 = sep[1];
    ho3 = sep[2];
    $("#Match_HH").val(ho1);
    $("#Match_MM").val(ho2);
    $("#Match_SS").val(ho3);
    $("#idmathor").val(id);
}

function ProcesarHOra() {

    var h1 = $("#Match_HH").val();
    var h2 = $("#Match_MM").val();
    var h3 = $("#Match_SS").val();
    var ho1;
    var ho2;
    var ho3;
    if (h1.length < 2) {
        ho1 = "0" + h1;
    } else {
        ho1 = h1;
    }
    if (h2.length < 2) {
        ho2 = "0" + h2;
    } else {
        ho2 = h2;
    }
    if (h3.length < 2) {
        ho3 = "0" + h3;
    } else {
        ho3 = h3;
    }
    var id = $("#idmathor").val();
    $("#" + id).val(ho1 + ":" + ho2 + ":" + ho3);
    ocultarVentana('VentanaModal');
}

function FechaTabla(i) {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    var vid = document.getElementsByName("valores");
    for (i; i <= n; i++) {
        if (i < numfilas) {
            var id = vid[i].value;
            var fec1 = $("#fechaAV" + id).val();
            var fec2 = $("#fechaAV1" + id).val();
            var fecom1;
            var fecom2;
            var fecom3;
            var fecop1;
            var fecop2;
            var fecop3;
            var com1 = new Array();
            var com2 = new Array();

            com1 = fec1.split("-");
            fecom1 = com1[0];
            fecom2 = com1[1];
            fecom3 = com1[2];

            com2 = fec2.split("-");
            fecop1 = com2[0];
            fecop2 = com2[1];
            fecop3 = com2[2];
            var fe1 = fecom1 + "" + fecom2 + "" + fecom3;
            var fe2 = fecop1 + "" + fecop2 + "" + fecop3;

            if ((fec2 == "" || fec2 == null) && (fec1 == "" || fec1 == null)) {

            } else {
                if (fe2 < fe1) {

                    $("#theDate" + i).focus();
                    var BE = document.createElement('audio');
                    BE.src = "audio/saperror.wav";
                    BE.play();
                    msgMatch("MsgFechasMoAv");
                    $("#iconmsg").css("visibility", "visible");
                    $("#iconmsg").attr("src", "images/advertencia.PNG");
                    break;
                } else {
                }
            }
        } else {
            Save();
            break;
        }
    }
}


function guradraTabFecha() {
    var tabla = document.getElementById("AvisoTabla");
    var numfilas = tabla.rows.length;
    var n = parseInt(numfilas) + 1;
    var vids = document.getElementsByName("valores");

    for (var i = 0; i <= n; i++) {
        if (i < numfilas) {
            var ids = vids[i].value;
            var grupco = $("#grco" + ids).val();
            var decodi = $("#deco" + ids).val();
            var textco = $("#teco" + ids).val();
            var txtco = textco.replace(/'/g, "´");
            //alert(txtco);
            var textac = $("#teac" + ids).val();
            var txtac = textac.replace(/'/g, "´");
            //alert(txtac);
            var fucant = $("#FCan" + ids).val();
            var feprt1 = $("#fechaAV" + ids).val();
            var hoprt1 = $("#Time" + ids).val();
            var feprt2 = $("#fechaAV1" + ids).val();
            var hoprt2 = $("#Time1" + ids).val();
            var folavi = $("#Notificacion_CACA").val();
            var hora = $("#Time").val();
            var autor = $("#autorAviso_CA").val();
            var fecha = $("#theDate").val();
            var acc = "GuardarTABDat";
            var enviar = "&grupoCod=" + grupco + "&Descod=" + decodi + "&texCO=" + txtco + "&TexAci=" + encodeURIComponent(txtac) + "&FuCant=" + fucant + "&Feca1=" + feprt1 + "&Hor1=" + hoprt1 + "&Feca2=" + feprt2 + "&Hor2=" + hoprt2 + "&folTab=" + folavi + "&Parametro32=" + hora + "&Parametro30=" + autor + "&Parametro31=" + fecha;

            if (grupco.length == 0) {

            } else {
                $.ajax({
                    async: false,
                    type: 'GET',
                    url: 'PeticionModuloAvisos',
                    contentType: "application/x-www-form-urlencoded",
                    processData: true,
                    data: "Action=" + acc + enviar,
                    success: function (data) {

                        if (data == 0) {
                        }
                    }

                });
            }
        } else {
            var folavi1 = $("#Notificacion_CACA").val();
            Reload(folavi1);
        }
    }

}

function LLamaequipo() {

    $("#equipo_CA").blur(function () {
        UBEQconsul();
    });

//    $('#equipo_CA').keypress(function (e) {
//        var te = (document).all ? e.keyCode : e.which;
//        if (te == 13) {
//            ConsultaFolioSAM();
//        }
//    });

}

function LLamaUBtecn() {
    $("#ubictec_CA").blur(function () {
        UBEQconsul();
    });

    $('#ubictec_CA').keypress(function (e) {
        var te = (document).all ? e.keyCode : e.which;
        if (te == 13) {
            ConsultaFolioSAM();
        }
    });
}

function OpenCalendario(id) {
    $("#" + id).focus();
    $("#IDFecha").val(id);
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    var ancho = 500;
    var alto = 750;
    var x = (screen.width / 2) - (ancho / 2);
    var y = (screen.height / 2) - (alto / 2);
    var ventana = $('#Calenndar');
    ventana.css({top: y + "px", left: x + "px"});
    ventana.css('display', 'block');
    borramsg();
    var theHandle = document.getElementById("handlecalendar");
    var theRoot = document.getElementById("Calenndar");
    Drag.init(theHandle, theRoot);
    $('#datapicker').datepicker().show();
}

function CerrarCalendario() {
    var BE = document.createElement('audio');
    BE.src = "audio/sapsnd05.wav";
    BE.play();
    $('#Calenndar').css('display', 'none');
    $('#datapicker').datepicker().hide();
}

function UBEQconsul() {

    //var ubt = $("#ubictec_CA").val();
    var equ = $("#equipo_CA").val();

    //if ((equ.length > 1) || (equ.length > 1 && ubt.length > 1)) {
    if((equ.length > 1) || (equ.length)){
        var acc = "ValidarEEquip";

        var enviar = "&Equi=" + equ;

        $.ajax({
            async: false,
            type: 'GET',
            url: 'PeticionModuloAvisos',
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + enviar,
            success: function (data) {
                if (data == 0) {
                    mensajess(5, "audio/sapmsg.wav", "images/advertencia.PNG");
                    setTimeout(function () {
                        $("#msg").html("");
                        $("#iconmsg").css("visibility", "hidden");
                    }, 5000);
                } else {
                    $("#EquUbi").html(data);
                    CarGarEQ();
                }
            },
        });
    } 
    //else if (equ.length < 1 && ubt.length > 1) {
//    else if(equ.length < 1){
//        var acc = "ValidarUbitec";
//
//        var enviar = "&Ubite=" + "";
//
//        $.ajax({
//            async: false,
//            type: 'GET',
//            url: 'PeticionModuloAvisos',
//            contentType: "application/x-www-form-urlencoded",
//            processData: true,
//            data: "Action=" + acc + enviar,
//            success: function (data) {
//                if (data == 0) {
//                    mensajess(6, "audio/sapmsg.wav", "images/advertencia.PNG");
//
//                    setTimeout(function () {
//                        $("#msg").html("");
//                        $("#msg").css("visibility", "hidden");
//                    }, 6000);
//                } else {
//                    $("#EquUbi").html(data);
//                    CarGarUBT();
//                }
//            },
//        });
//    }
     else {
    }
}

function CarGarEQ() {
    var GrPL = $("#GrPL").val();
    $("#GrpPlanificacion_CA").val(GrPL);
    var CPMa = $("#CPMa").val();
    $("#CentroPlaninificacion_CA").val(CPMa);
    var IDUbc = $("#IDUbc").val();
    $("#ubictec_CA").val(IDUbc);
    var CPTr2 = $("#CPTr").val();
    $("#puestotrabajo2_CA").val(CPTr2);
    var CPTr = $("#CPPTRA").val();
    $("#puestotrabajo_CA").val(CPTr);
}
function CarGarUBT() {

    var GrPL = $("#GrPL2").val();
    $("#GrpPlanificacion_CA").val(GrPL);
    var CPMa = $("#CPMa2").val();
    $("#CentroPlaninificacion_CA").val(CPMa);
    var IDUbc = $("#IDUbc2").val();
    $("#ubictec_CA").val(IDUbc);
    var CPTr2 = $("#CPTr2").val();
    $("#puestotrabajo2_CA").val(CPTr2);
    var CPTr = $("#CPPTRA2").val();
    $("#puestotrabajo_CA").val(CPTr);
//            alert($("#GrPL2").val()+" "+CPMa+" "+IDUbc+" "+CPTr2+" "+CPTr);
}

function RegresPrin(di1, di2) {
    $("#" + di1).css("display", "block");
    $("#" + di2).css("display", "none");
}


function GetIp() {
    window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;   //compatibility for firefox and chrome
    var pc = new RTCPeerConnection({iceServers: []}), noop = function () {};
    pc.createDataChannel("");    //create a bogus data channel
    pc.createOffer(pc.setLocalDescription.bind(pc), noop);    // create offer and set local description
    pc.onicecandidate = function (ice) {  //listen for candidate events
        if (!ice || !ice.candidate || !ice.candidate.candidate)
            return;
        var myIP = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/.exec(ice.candidate.candidate)[1];
        pc.onicecandidate = noop;
        $('#IpData').val(myIP);
    };
}