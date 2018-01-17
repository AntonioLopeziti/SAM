/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( document ).ready(function() {           
        startTime();
        
        window.onload = function () {
            startTime();
            MostrarRadio();
            MostrarTabla('PeticionMonitorStatusCont2', '');
            bloq();
//            MostrarTDos();
        };
        
     $("#BtnNotPM").on("click",function(){
         $orden ='';
         $('#tablados input[name=mon]').each(function(){
             if(this.checked){
                 $orden=$(this).val();
             }
         });
         PasarVal($orden);
     });   
        
    $("#BtnNotOr").on("click", function(){
        $num_orden='';
            $('#tablados input').each(function(){
                if (this.checked){
                    $num_orden=$(this).val();
                    alert($num_orden);
                }
            });    
    PantallaNotificaciones("PeticionMonitorStatusCont2","",$num_orden);        
    });             
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


                        function bloq() {
                            document.getElementById('iconmsg').style.visibility = "hidden";
                            document.getElementById('guardar').disabled = true;
                        }


          