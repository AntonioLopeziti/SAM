/* 
 *
 *
 *jQuery de visualizar BOM Materiales
 *
 *
 */
$(document).ready(function(){ 
    //mostrar valores necesarios***************************
      
     $('#lm1').css("background-image", "url(images/necesario.PNG)"); 
     $('#boton').show();
     $('#boton2').hide();
     $('#lm').focus(); 
     $('#lm').css("background-image", "none"); 
     $('#lm').on('keyup',function(){
         $('#lm').css("background-image", "none"); 
     }).keyup();
     $('#lm1').on('keyup',function(){
         $('#lm1').css("background-image", "none"); 
     }).keyup();
      
      
    
    
    
    
      
    //*******************************************************
    
    //metodo para obtener el evento de ENTER
    $(document).keypress(function(e){
            if(e.which === 13)
            {   
               
               if ($('.cajaexterna').is(':visible')){
                   $('.cajaexterna').hide();  
                   $('.ventanaTablaEquipos').show();
                  
               }
                    
               else{
                       
                    if($("#lm").val()===""){
                       $('#lm').css("background-image", "url(images/necesario.PNG)");
                     
                    }
                    if($("#lm1").val()===""){
                        $('#lm1').css("background-image", "url(images/necesario.PNG)");
                    } 
                
                }
            }
    });
    //***************************************************+
    //***boton aceptar
    $('#aceptar').on('click',function() {
            
        $('#boton').hide();
        $('#boton2').hide();
        if($("#lm").val()===""){
            $('#lm').css("background-image", "url(images/necesario.PNG)"); 
        }
        if($("#lm1").val()===""){
            $('#lm1').css("background-image", "url(images/necesario.PNG)");
        } 
    
    });
    
    
    
    //ocultan la marca de necesario************************************************
    $("#lm").click(function() {
        $('#lm').css('background-image','none');
        $('#boton').show();
        $('#boton2').hide();
        
    });
    $("#lm1").click(function() {
        $('#lm1').css('background-image','none');
        $('#boton2').show();
        $('#boton').hide();
        
    });
    
    
    //******************************************************************************
    //**VentanaModal_____________________________
    $('#boton').on('click',function(){
        $('.cajaexterna').show();
        $('#boton').hide();
        $('#label_equipo').focus();
    });
    
    $('#cerrarModal').on('click',function(){
        $('.cajaexterna').hide(); 
        $('#lm').css("background-image", "url(images/necesario.PNG)"); 
        
    });
    
    $('#aceptarVentana').on('click',function(){
         $('.cajaexterna').hide(); 
         $('.ventanaTablaEquipos').show();
        
    });
      
    
    //***********************
    //*****Ventana Modal Equipo
    $('#cerrarModalEquipo').on('click',function(){
        $('.ventanaTablaEquipos').hide();
        $('#lm').css("background-image", "url(images/necesario.PNG)"); 
    });
    
    
    
    //FIN ventana equipo
     //*****Ventana Modal CENTRO**********************************************
    $('#boton2').on('click',function(){
        $('.ventanaTablaCentro').show(); 
        $('#boton2').hide();
    });
    $('#cerrarModalCentro').on('click',function(){
        $('.ventanaTablaCentro').hide();
        $('#lm1').css("background-image", "url(images/necesario.PNG)"); 
        
    });
    //FIN ventana equipo
   
    
    
//fin del metodo DOCUMENT READY
});

