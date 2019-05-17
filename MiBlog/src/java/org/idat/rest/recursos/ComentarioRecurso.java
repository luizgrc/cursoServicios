/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.recursos;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.idat.rest.modelo.Comentario;
import org.idat.rest.servicio.ComentarioServicio;

/**
 *
 * @author Administrador
 */

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComentarioRecurso {
    
    ComentarioServicio servicio = new ComentarioServicio();
    
    
    @GET
    public List<Comentario> getComentarios(@PathParam("articuloId") int articuloId){
    
        return servicio.getComentarios(articuloId);
    
    }
    
    
    @GET
    @Path ("/{ComentarioId}")
    public Comentario getComentario(@PathParam("articuloId") int articuloId,
                                    @PathParam("comentarioId") int comentarioId){
    
    return servicio.getComentario(articuloId, comentarioId);
    }
    
    
    @POST
    public Comentario addComentario(@PathParam("articuloId") int articuloId,
                                     Comentario comentario){
    
        return servicio.addComentario(articuloId, comentario);
                
    }
    
    
    @DELETE 
    @Path("/{comentarioId}")
    public void deleteComentario(@PathParam("articuloId") int articuloId,
                                @PathParam("comentarioId") int comentarioId){
    
        servicio.deleteComentario(articuloId, comentarioId);
    }
    
    
    @PUT
    @Path("/{comentarioId}")
    public Comentario updateComentario(@PathParam("articuloId") int articuloId,
                                        @PathParam("comentarioId") int comentarioId,
                                        Comentario comentario){
    comentario.setId(comentarioId);
    return servicio.updateComentario(articuloId, comentario);
    }
    
}
