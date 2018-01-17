/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
 $('#equhr').css("background-image", "url(images/necesario.PNG)");
 $('#ghrin').css("background-image", "url(images/necesario.PNG)");
 $('#perfihr').css("background-image", "url(images/necesario.PNG)");
    $('#match_C1').hide();
    $('#match_C2').hide();
    $('#match_C3').css("display", "none");
 
 $('#util').css("background-image", "url(images/necesario.PNG)");
 $('#centr').css("background-image", "url(images/necesario.PNG)");
 $('#cogrhr').css("background-image", "url(images/necesario.PNG)");
 $('#sthrntr').css("background-image", "url(images/necesario.PNG)");
 $('#grpl').css("background-image", "url(images/necesario.PNG)");
 $('#match_C4').hide();
 $('#match_C5').hide();
 $('#match_C6').hide();
 $('#match_C7').hide();
 $('#match_C8').hide();
 
$('#equhr').focus(function () {
   $('#equhr').css("background-image","none"); 
   $('#match_C1').show();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#util').val().length < 1){
   $('#util').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#centr').val().length < 1){
    $('#centr').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
});   
$('#ghrin').focus(function () {
   $('#ghrin').css("background-image","none");  
   $('#match_C1').hide();
   $('#match_C2').show();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();
   
  if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 

  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
  if($('#util').val().length < 1){
   $('#util').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#centr').val().length < 1){
    $('#centr').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  } 
}); 
$('#perfihr').focus(function () {
   $('#perfihr').css("background-image", "none");
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').show();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();
   
  if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#util').val().length < 1){
   $('#util').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#centr').val().length < 1){
    $('#centr').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
   
});

$('#util').focus(function () {
   $('#util').css("background-image","none"); 
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').show();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#centr').val().length < 1){
    $('#centr').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
});   

$('#centr').focus(function () {
   $('#centr').css("background-image","none"); 
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').show();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#util').val().length < 1){
    $('#util').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
});   

$('#cogrhr').focus(function () {
   $('#cogrhr').css("background-image","none"); 
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').hide();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#util').val().length < 1){
    $('#util').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#centr').val().length < 1){
   $('#centr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#sthrntr').val().length < 1){
   $('#sthrntr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
});   

$('#sthrntr').focus(function () {
   $('#sthrntr').css("background-image","none"); 
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').show();
    $('#match_C8').hide();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#util').val().length < 1){
    $('#util').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#centr').val().length < 1){
   $('#centr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#grpl').val().length < 1){
    $('#grpl').css("background-image","url(images/necesario.PNG)");  
    
  }
});

$('#grpl').focus(function () {
   $('#grpl').css("background-image","none"); 
   $('#match_C1').hide();
   $('#match_C2').hide();
   $('#match_C3').hide();
    $('#match_C4').hide();
    $('#match_C5').hide();
    $('#match_C6').hide();
    $('#match_C7').hide();
    $('#match_C8').show();

 
  if($('#ghrin').val().length < 1){
    $('#ghrin').css("background-image","url(images/necesario.PNG)");  
  }
  if($('#perfihr').val().length < 1){
    $('#perfihr').css("background-image", "url(images/necesario.PNG)");   
  }
   if($('#equhr').val().length < 1){
   $('#equhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#util').val().length < 1){
    $('#util').css("background-image","url(images/necesario.PNG)");  
    
  }
   if($('#centr').val().length < 1){
   $('#centr').css("background-image","url(images/necesario.PNG)");      
  } 
 if($('#cogrhr').val().length < 1){
   $('#cogrhr').css("background-image","url(images/necesario.PNG)");      
  } 
  if($('#sthrntr').val().length < 1){
    $('#sthrntr').css("background-image","url(images/necesario.PNG)");  
    
  }
});
});