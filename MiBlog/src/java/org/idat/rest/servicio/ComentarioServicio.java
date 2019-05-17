/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.servicio;

import java.util.List;
import org.idat.rest.modelo.Articulo;
import org.idat.rest.modelo.Comentario;

/**
 *
 * @author Administrador
 */
public class ComentarioServicio {
    
    private final ArticuloServicio articuloServicio = new ArticuloServicio();
    
    public List<Comentario> getComentarios(int articuloId){
    
        return articuloServicio.getArticulo(articuloId).getComentarios();
    
    }
    
    
    public Comentario getComentario(int articuloId, int comentarioId){
        List<Comentario> comentarios = articuloServicio
                .getArticulo(articuloId).getComentarios();
        for (Comentario comentario : comentarios) {
            if (comentario.getId()== comentarioId ) {
                return  comentario;
            }
 
        }
        return null;
    }
    
    
    
    public Comentario addComentario(int articuloId, Comentario comentario){
    
        Articulo articulo = articuloServicio.getArticulo(articuloId);
        comentario.setId(getMaximo(articulo));
        articulo.getComentarios().add(comentario);
        return comentario;
    
    }
    
    
    public Comentario updateComentario(int articuloId, Comentario comentario){
    
        Articulo articulo = articuloServicio.getArticulo(articuloId);
        int posicion = getPosicion(articulo,comentario.getId());
        try {
            articulo.getComentarios().set(posicion, comentario);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
        return comentario;
    }
    
    
    public void deleteComentario(int articuloId, int comentarioId){
    
        Articulo articulo = articuloServicio.getArticulo(articuloId);
        
        int posicion = getPosicion(articulo, comentarioId);
        articulo.getComentarios().remove(posicion);
        
    }
    
    
    private int getPosicion(Articulo articulo, int comentarioId){
        List<Comentario> comentarios = articulo.getComentarios();
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId() == comentarioId ) {
                return i;
            }
        }
        return -1;
    }
    
    
    private int getMaximo(Articulo articulo){
    
    int size = articulo.getComentarios().size();
        if (size>0) {
            return articulo.getComentarios().get(size-1).getId()+1;
        }
        return 1;
    }
    
    
    
    
    
}
