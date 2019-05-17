/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Administrador
 */
public class Comentario {
    
    private int id;
    private String comentario;
    private Calendar creado;
    private String autor;

    public Comentario() {
    }

    public Comentario(int id, String comentario,  String autor) {
        this.id = id;
        this.comentario = comentario;
         this.creado = new GregorianCalendar();  
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Calendar getCreado() {
        return creado;
    }

    public void setCreado(Calendar creado) {
        this.creado = creado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
            
    
    
    
    
    
}
