/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.modelo;

/**
 *
 * @author Administrador
 */
public class Navegacion {
    
    private String Titulo;
    private String link;
    private String descripcion;

    public Navegacion() {
    }

    public Navegacion(String Titulo, String link, String descripcion) {
        this.Titulo = Titulo;
        this.link = link;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
    
    
}
