/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.idat.rest.dao.BaseDeDatos;
import org.idat.rest.excepciones.DatosNoEncontradosExcepcion;
import org.idat.rest.modelo.Articulo;

/**
 *
 * @author Administrador
 */
public class ArticuloServicio {
    
   private List<Articulo> listado = BaseDeDatos.getInstancia().getListado();

    public List<Articulo> getArticulos() {
        return listado;
    }

    public Articulo getArticulo(int id) {

        Articulo respuesta = null;

        for (Articulo articulo : listado) {
            if (articulo.getId() == id) {
              respuesta = articulo;
            }
        }
        if (respuesta == null){
        
            throw new DatosNoEncontradosExcepcion("No se encuentra el artículo");
        
        }
        
        
        return respuesta;
    }
    
    
    public List<Articulo> getArticuloPorAutor(String autor){
        List<Articulo> resultado = new ArrayList<>();
        
        for (Articulo articulo : listado) {
            if (articulo.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(articulo);
            }
        }
        return resultado;
    
    
    }
    
    
    public List<Articulo> getArticulosPorFecha(int year, int month){
    
        List<Articulo> resultado = new ArrayList<>();
        
        Calendar fecha = new GregorianCalendar();
        
        for (Articulo articulo : listado) {
            fecha.setTime((articulo.getCreado().getTime()));
           
            if (fecha.get(Calendar.YEAR) == year
                    && fecha.get(Calendar.MONTH) == month -1 ) {
                resultado.add(articulo);
            }
        }
        return resultado;
    }
    
    
    
    
    
    
    

    public Articulo addArticulo(Articulo articuloNuevo) {

        articuloNuevo.setId(getMaxId());
        listado.add(articuloNuevo);
        return articuloNuevo;
    }

    private int getMaxId() {

        int size = listado.size();
        if (size > 0) {
            return listado.get(size - 1).getId() + 1;
        }
        return 1;
    }

    public Articulo updateArticulo(Articulo articuloModificado) {

        int posicion = getPosicion(articuloModificado.getId());
        listado.set(posicion, articuloModificado);
        return articuloModificado;
    }

    private int getPosicion(int id){
        
        int posicion = 0;
        
        for(int i = 0; i < listado.size(); i++){
            if(id == listado.get(i).getId()){
                posicion = i;
            }
        }
        return posicion;
    }
    
    public void deleteArticulo(int id){
        
        int posicion = getPosicion(id);
        listado.remove(posicion);
    }
       
    
    
    
}
