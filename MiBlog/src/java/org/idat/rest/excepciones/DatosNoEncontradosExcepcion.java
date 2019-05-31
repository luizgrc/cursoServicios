/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.excepciones;

/**
 *
 * @author Administrador
 */
public class DatosNoEncontradosExcepcion  extends RuntimeException {
    
    public DatosNoEncontradosExcepcion(String mensaje){
        super(mensaje);
    }
    
}
