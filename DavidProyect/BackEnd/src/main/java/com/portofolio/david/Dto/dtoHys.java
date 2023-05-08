/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portofolio.david.Dto;
import javax.validation.constraints.NotBlank;


public class dtoHys {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    @NotBlank
    private String imagenC; 
    
    public dtoHys() {
    }

    public dtoHys(String nombre, int porcentaje, String imagenC) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imagenC = imagenC;
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
    
    public String getImagenC() {
        return imagenC;
    }

    public void setImagenC(String imagenC) {
        this.imagenC = imagenC;
    }
}
