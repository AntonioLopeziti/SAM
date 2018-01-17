/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('#centro').css("background-image", "url(images/necesario.PNG)"); 
    $('#btnmatch2').hide();
    $('#centro').focus(function(){
        $('#btnmatch2').show();
        $('#centro').css("background-image", "none"); 
    }); 
    $('#centro').blur(function(){    
        if($('#centro').val().length < 1){
            $('#centro').css("background-image", "url(images/necesario.PNG)");
        }
        
    });
     
});

