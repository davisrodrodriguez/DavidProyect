/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portofolio.david.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Proyecto {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @NotNull
     @Size (min = 1, max = 60, message = "error longitud caracteres" )
     private  String nombreP;
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String descripcionP;  
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String linkP;
     
     @NotNull
     @Size (min = 1, max = 255, message = "error longitud caracteres" )
     private String imagenP;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String linkP, String imagenP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.imagenP = imagenP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getlinkP() {
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
