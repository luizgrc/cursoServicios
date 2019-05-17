/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.excepciones;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.idat.rest.modelo.MensajeError;

/**
 *
 * @author Administrador
 */
@Provider
public class DatosNoEncontradosMapper implements ExceptionMapper<DatosNoEncontradosException>{

    @Override
    public Response toResponse(DatosNoEncontradosException exception) {
        MensajeError mensaje = new MensajeError("Datos no Encontrados" , 404,"Esta informacion no se encuentra");
        return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
    }
    
}
