/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
     AjustarCabecera('TabHead', 'TabBody', 3, 'SecCuerpo');
    $("#DobleSection").scroll(function () {
        $("#SecCuerpo").scrollTop($("#DobleSection").scrollTop());
    });
    $("#SecCuerpo").scroll(function () {
        $("#DobleSection").scrollTop($("#SecCuerpo").scrollTop());
    });
    document.getElementById('DobleContainer').style.height = document.getElementById("TabBody").offsetHeight + "px";
    $('#iconmsg').hide();
    startTime();
    $('#regresar').click(function () {
        $(location).attr('href', 'Bienvenido.jsp');
    });
    var inputs = [
        $('#ClaseOferta'),
        $('#OrgVentas'),
        $('#CanalDist'),
        $('#Sector'),
        $('#OficVentas'),
        $('#GpoVen'),
        $('#OfertaRep'),
        $('#Solicitate'),
        $('#DestMec'),
        $('#NmPedCliente'),
        $('#ValorNeto'),
        $('#Moneda'),
        $('#FechPedi')
    ];
    var buttonsMC = [
        $('#MCClaseOferta'),
        $('#MCOrgVentas'),
        $('#MCCanalDis'),
        $('#MCSector'),
        $('#MCOficinaVentas'),
        $('#MCGpoVen'),
        $('#MCOferRep'),
        $('#MCDestMerc'),
        $('#MCMoneda'),
        $('#MCFechPed')
    ];
    $.each(buttonsMC, function(i,v){
        v.hide();
    });
    $.each(inputs, function(i,v){
        switch(i){
            case 0:
                v.focus(function(){
                    FocusableMC(0);
                });
                break;
            case 1:
                v.focus(function(){
                    FocusableMC(1);
                });
                break;
            case 2:
                v.focus(function(){
                    FocusableMC(2);
                });
                break;
            case 3:
                v.focus(function(){
                    FocusableMC(3);
                });
                break;
            case 4:
                v.focus(function(){
                    FocusableMC(4);
                });
                break;
            case 5:
                v.focus(function(){
                    FocusableMC(5);
                });
                break;
            case 6:
                v.focus(function(){
                    FocusableMC(6);
                });
                break;
            case 7:
                v.focus(function(){
                    FocusableMC(-1);
                });
                break;
            case 8:
                v.focus(function(){
                    FocusableMC(7);
                });
                break;
            case 9:
                v.focus(function(){
                    FocusableMC(-1);
                });
                break;
            case 10:
                v.focus(function(){
                    FocusableMC(-1);
                });
                break;
            case 11:
                v.focus(function(){
                    FocusableMC(8);
                });
                break;
            case 12:
                v.focus(function(){
                    FocusableMC(9);
                });
                break;
        }
    });
    function FocusableMC(index) {
        $.each(buttonsMC, function (ind, va) {
            if (ind == index) {
                va.show();
            } else {
                va.hide();
            }
        });
    }
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
function AjustarCabecera(cabecera, cuerpo, diferiencia, section)
{
    var myTable = document.getElementById(cuerpo);
    var arr = new Array();
    for (i = 0; i < myTable.rows[0].cells.length; i++)
    {
        arr[i] = myTable.rows[0].cells[i];
    }
    var val = 0;
    for (i = 0; i < arr.length; i++)
    {
        val += arr[i].offsetWidth;
    }
    var myTableCb = document.getElementById(cabecera);
    myTableCb.style.width = val + 7 + "px";
    var arrCb = new Array();
    for (i = 0; i < myTableCb.rows[0].cells.length; i++)
    {
        arrCb[i] = myTableCb.rows[0].cells[i];
    }
    for (i = 0; i < arr.length - 1; i++)
    {
        arrCb[i].style.width = (arr[i].offsetWidth - diferiencia) + "px";
    }
    document.getElementById(section).style.width = val + 17 + "px";
}