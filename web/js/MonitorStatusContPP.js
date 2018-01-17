$(document).ready(function () {
    startTime();

    window.onload = function () {
        startTime();
        MostrarRadioPP();
        cargaryaaPP();
        CArgarMnee();
//    bloq();
    };
});

function startTime() {
    today = new Date();
    h = today.getHours();
    m = today.getMinutes();
    s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    $("#tiempo").html(h + ':' + m + ':' + s);
    t = setTimeout('startTime()', 500);
}
function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}