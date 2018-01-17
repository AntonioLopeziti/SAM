/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    //$('#canal').css("background-image", "url(images/necesario.PNG)"); 
    $('#btnmatch4').hide();
    $('#canal').focus(function(){
        $('#btnmatch4').show();
        $('#canal').css("background-image", "none"); 
    }); 
    $('#canal').blur(function(){    
        if($('#canal').val().length < 1){
            //$('#canal').css("background-image", "url(images/necesario.PNG)");
        }
        
    });
     
});

