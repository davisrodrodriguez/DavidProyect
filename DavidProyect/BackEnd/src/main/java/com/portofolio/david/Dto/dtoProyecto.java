/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portofolio.david.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author davis
 */
public class dtoProyecto {

     @NotBlank
     private  String nombreP;
     @NotBlank
     private String descripcionP;
     @NotBlank
     private String linkP;
     @NotBlank
     private String imagenP;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String linkP, String imagenP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.imagenP = imagenP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }
    
    
     
     
    
}  

