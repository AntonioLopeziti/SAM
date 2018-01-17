$(document).ready(function () {
//    $('#msg').attr("hidden","true");
    $('#iconmsg').attr("hidden", "true");

    startTime();

    $("#regresar").click(function () {
        back();
    });
    function back() {
        window.location.href = "Bienvenido.jsp";
    }
    var IDUBTEC = $('#idUbiTec');
    var CLASE = $('#Clase');
    var GPOAUTOR = $('#GrupoAutoriz');
    var PESO = $('#Peso');
    var NINVENT = $('#NInventario');
    var TAMDIM = $('#TamanoDimens');
    var PSTAENSER = $('#PstaenServ');
    var CEMPLAZAM = $('#CeEmplazam');
    var EMPLAZAM = $('#Emplazamiento');
    var AREAEMP = $('#AreaEmpresa');
    var PTOTRAB = $('#PuestoTrabajo');
    var INDABC = $('#IndicadorABC');
    var CENTRO = $('#Centro');
    var SOCIED = $('#Sociedad');
    var ACTFIJO = $('#ActivoFijo');
    var ACTFIJODOS = $('#ActivoFijoDos');
    var SOCIEDADCC = $('#SociedadCC');
    var CENTROPLANIF = $('#CentroPlanif');
    var GPOPLANIF = $('#GrupoPlanif');
    var PTOTRABRES = $('#PtoTbjoResp');
    var PTOTRABRESDOS = $('#PtoTbjoRespDos');
    var UBTEC = $('#UbicTecn');

    var arrayDAT = [
        IDUBTEC,
        CLASE,
        GPOAUTOR,
        PESO,
        NINVENT,
        TAMDIM,
        PSTAENSER,
        CEMPLAZAM,
        EMPLAZAM,
        AREAEMP,
        PTOTRAB,
        INDABC,
        CENTRO,
        SOCIED,
        ACTFIJO,
        ACTFIJODOS,
        SOCIEDADCC,
        CENTROPLANIF,
        GPOPLANIF,
        PTOTRABRES,
        PTOTRABRESDOS,
        UBTEC
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
        });
    });

    $('#guardar').click(function () {
        ValidarDatos();
    });

    function ValidarDatos() {
        var temp = new Array();
        temp[0] = IDUBTEC;
        temp[1] = CLASE;
        temp[2] = GPOAUTOR;
        temp[3] = PESO;
        temp[4] = NINVENT;
        temp[5] = TAMDIM;
        temp[6] = PSTAENSER;
        temp[7] = CEMPLAZAM;
        temp[8] = EMPLAZAM;
        temp[9] = AREAEMP;
        temp[10] = PTOTRAB;
        temp[11] = INDABC;
        temp[12] = CENTRO;
        temp[13] = SOCIED;
        temp[14] = ACTFIJO;
        temp[15] = ACTFIJODOS;
        temp[16] = SOCIEDADCC;
        temp[17] = CENTROPLANIF;
        temp[18] = GPOPLANIF;
        temp[19] = PTOTRABRES;
        temp[20] = PTOTRABRESDOS;
        temp[21] = UBTEC;
        for (i = 0; i < temp.length; i++)
        {
            if (temp[i].val().trim().length === 0)
            {
                ShowMsg(1, "images/advertencia.PNG", "audio/saperror.wav");
                temp[i].focus();
                return;
            }
        }
        GuardarDatosUbTec();
    }

    function GuardarDatosUbTec() {
        var acc = "GuardarDatos";
        var par = "&idUbTec=" + IDUBTEC.val() + "&clase=" + CLASE.val() + "&gpoAutor=" + GPOAUTOR.val() + "&peso=" + PESO.val() + "&nInvent=" + NINVENT.val() + "&tamDim=" + TAMDIM.val() + "&pStaEnSer=" + PSTAENSER.val() + "&cEmplaz=" + CEMPLAZAM.val() + "&emplaz=" + EMPLAZAM.val() + "&areaEmp=" + AREAEMP.val() + "&ptoTrab=" + PTOTRAB.val() + "&indAbc=" + INDABC.val() + "&centro=" + CENTRO.val() + "&socied=" + SOCIED.val() + "&actFijo=" + ACTFIJO.val() + "&actFijoDos=" + ACTFIJODOS.val() + "&sociedCC=" + SOCIEDADCC.val() + "&centroPlani=" + CENTROPLANIF.val() + "&gpoPlanif=" + GPOPLANIF.val() + "&ptoTrabRes=" + PTOTRABRES.val() + "&ptoTrabResDos=" + PTOTRABRESDOS.val() + "&ubtec=" + UBTEC.val();        
        $.ajax({
            beforeSend: function () {
                $('#guardar').prop("disabled", true);
            },
            async: false,
            type: "GET",
            url: "PeticionCreaUbicacionesTecPP",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            data: "Action=" + acc + par,
            success: function (data) {
                alert(data);
                if (data == 5) {
                    ShowMsg(2, "images/aceptar.png", "audio/sapmsg.wav");
                    limpiar();
//                    reiniDatOb();                    
                }
                if (data == 6) {
                    ShowMsg(3, "images/advertencia.PNG", "audio/saperror.wav");
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
    