/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.recursos;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.idat.rest.modelo.Articulo;
import org.idat.rest.modelo.Navegacion;
import org.idat.rest.servicio.ArticuloServicio;

/**
 *
 * @author Administrador
 */



@Path("/articulos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_XML)
//@Produces(MediaType.APPLICATION_XML)
public class ArticuloRecurso {
    
    
   ArticuloServicio servicio = new ArticuloServicio();
    
    @GET
        public List<Articulo> getArticulos(@QueryParam("autor") String autor,
                                           @QueryParam("year")  int year    ,
                                           @QueryParam("month") int month ){
            
            if (autor != null && autor.length() > 0) {
                return servicio.getArticuloPorAutor(autor);
            }
            if (year > 0 && month > 0) {
                return servicio.getArticulosPorFecha(year, month);        
            }
            
        return servicio.getArticulos();
    }
    
        
        
        
        
//      @GET
//        public List<Articulo> getArticulos(){
//        return servicio.getArticulos();
//    }   
//        
//        
   
        
        
        
          @GET
    @Path("/{articuloId}")
    public Articulo getArticulo(@PathParam("articuloId") int id,
                                @Context UriInfo uriInfo){
        
        Articulo respuesta = servicio.getArticulo(id);
        
        
        String linkSelf = uriInfo.getAbsolutePath().toString();
        
        String linkComm = linkSelf + "/comentarios";
        
        Navegacion self = new Navegacion("Recurso",linkSelf,"Locación del Recurso");
        
        Navegacion comm = new Navegacion("Comentarios", linkComm, "Locación de los Comentarios");
        
        respuesta.getNavegacion().add(self);
        respuesta.getNavegacion().add(comm);
        
        return respuesta;
    }
    
        
        
        
        
        
//    @GET
//    @Path("/{articuloId}")
//    public Articulo getArticulo(@PathParam("articuloId") int id){
//        return servicio.getArticulo(id);
//    }
//    
    
//    @POST
//    public Articulo addArticulo(Articulo articulo){
//        return servicio.addArticulo(articulo);
//    }
//    
    
    @POST
    public Response addArticulo(Articulo articulo, @Context UriInfo uriInfo) {
        Articulo respuesta = servicio.addArticulo(articulo);
       // URI uri = new URI("/MiBlog/api/articulos/" + respuesta.getId());        
        URI uri = uriInfo.getAbsolutePathBuilder()
                    .path(String.valueOf(respuesta.getId()))
                    .build();

        return Response.created(uri)
                .entity(respuesta)
                .build();

    }
    
    
    
    
    
    
    
    @DELETE
    @Path("/{articuloId}")
    public void deleteArticulo(@PathParam("articuloId") int id){
        servicio.deleteArticulo(id);
    }
    
    @PUT
    @Path("/{articuloId}")
    public Articulo updateArticulo(@PathParam("articuloId") int id, Articulo articulo){
        articulo.setId(id);
        return servicio.updateArticulo(articulo);
    }
    
    
//    @GET
//    @Path("/{articuloId}/comentarios")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getComentarios(){
//        return "Estos son los comentarios";
//    
//    }
    
    
    
    @Path("/{articuloId}/comentarios")
    public ComentarioRecurso getComentarios(){
        return new ComentarioRecurso();
    
    }
    
    
    
    
}
