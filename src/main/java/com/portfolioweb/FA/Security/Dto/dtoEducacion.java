
package com.portfolioweb.FA.Security.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    private String Logo;
    @NotBlank
    private String Periodo;
    
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String Logo, String Periodo) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.Logo = Logo;
        this.Periodo = Periodo;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
    
}
