
package com.portfolioweb.FA.Dto;

import javax.validation.constraints.NotBlank;


public class dtoskill {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public dtoskill() {
    }

    public dtoskill(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
