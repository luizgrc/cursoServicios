/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.idat.rest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@XmlRootElement
public class MensajeError {
    
    private String mensaje;
    private int codigo;
    private String otraInfo;

    public MensajeError() {
    }

    public MensajeError(String mensaje, int codigo, String otraInfo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.otraInfo = otraInfo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getOtraInfo() {
        return otraInfo;
    }

    public void setOtraInfo(String otraInfo) {
        this.otraInfo = otraInfo;
    }
    
    
    
}
