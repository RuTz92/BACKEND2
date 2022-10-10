
package com.portfolioweb.FA.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private int id;
    @NotBlank
    private String proyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha;
    private String img;

    public dtoProyecto() {
    }

    public dtoProyecto(String proyecto, String descripcion, String fecha, String img) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
