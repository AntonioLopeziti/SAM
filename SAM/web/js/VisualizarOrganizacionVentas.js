/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    //$('#organizacion').css("background-image", "url(images/necesario.PNG)"); 
    $('#btnmatch3').hide();
    $('#organizacion').focus(function(){
        $('#btnmatch3').show();
        $('#organizacion').css("background-image", "none"); 
    }); 
    $('#organizacion').blur(function(){    
        if($('#organizacion').val().length < 1){
            //$('#organizacion').css("background-image", "url(images/necesario.PNG)");
        }
        
    });
     
});

