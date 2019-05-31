(function(document,JSON){
    'use strict';
    
    function $(id){
        
        return document.getElemetById(id)
    }
    
    var btnGetArticle = $('btnGetArticle'),
        btnAddArticle = $('btnAddArticle'),
        formulario    = $('frmCrear');
        
        btnGetArticle.addEventListener('click', getAll, false);
        btnAddArticle.addEventListener('click', addArticle, false);
        formulario.addEventListener('submit', function(e){
            e.preventDefault();
        },false);
        
      function AddArticle(){
          var url = 'articulos',
              method = 'post',
              data = {titulo: $('titulo_articulo').value,
                      contenido: $('contenido_articulo').value,
                      autor: $('cliente_articulo').value  },
              callback = function(datos){
                  muestraArticulo(JSON.parse(datos));
              };
          ajax(url, method, JSON.stringify(data), callback) ;   
      }  
        function getAll(){
            
            var url = 'articulos',
                method = 'GET',
                data = null,
                articuloId = $('articuloId').value,
                callback  = function(data){
                    if(articuloId !== ''){
                        
                    }
                }
            
        }
        
     
    
}  )