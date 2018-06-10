/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.dato;

import java.util.Date;

/**
 *
 * @author CARLOS
 */
public class Empleado extends Persona{
    private String usuario;
    private String contraseña;
    private Date fechIngreso;
    private String cargo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechIngreso() {
        return fechIngreso;
    }

    public void setFechIngreso(Date fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
