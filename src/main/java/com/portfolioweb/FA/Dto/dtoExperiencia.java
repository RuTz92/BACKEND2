
package com.portfolioweb.FA.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String puesto;    
    @NotBlank
    private String descripcionE;
    private String logo;
    private String periodo;
    

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String puesto, String descripcionE, String logo, String periodo) {
        this.nombreE = nombreE;
        this.puesto = puesto;
        this.descripcionE = descripcionE;
        this.logo = logo;
        this.periodo = periodo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
