/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portofolio.david.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String imagenD;
  
    

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String imagenD) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imagenD = imagenD;
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

    public String getImagenD() {
        return imagenD;
    }

    public void setImagenD(String imagenD) {
        this.imagenD = imagenD;
    }    
}
