/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.dao;

import java.util.ArrayList;
import java.util.List;
import org.idat.rest.modelo.Articulo;
import org.idat.rest.modelo.Comentario;

/**
 *
 * @author Administrador
 */
public class BaseDeDatos {
    private final static BaseDeDatos baseDeDatos = new BaseDeDatos();
    private final List<Articulo> listado = new ArrayList<>();
    
    private BaseDeDatos(){
    
    Articulo art1= new Articulo(1,"Mi primer Artículo","Este es el contenido","Jaime");
     Articulo art2= new Articulo(2,"segundo Artículo","Hola contenido 2 ","Glenda");
     
     art1.getComentarios().add(new Comentario(1,"Muy buen articulo","Daniel"));
     art1.getComentarios().add(new Comentario(2,"Me aburren tus articulos","Carola"));
     art2.getComentarios().add(new Comentario(1,"Muy divertido articulo","Miriam"));
    listado.add(art1);
    listado.add(art2);
    }
    
    
    //creamos el método que nos devuelve la instancia
    public static  BaseDeDatos getInstancia(){
    
    return baseDeDatos;
    
    
    }
    
    
    //y creamos el método que nos devuelva el listado
    
    
    public List<Articulo> getListado(){
    
        return listado;
    
    
    
    }
    
    
    
    
    
}
