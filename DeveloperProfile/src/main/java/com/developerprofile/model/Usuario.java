/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.developerprofile.model;

/**
 *
 * @author Juan1
 */
public class Usuario {

    private String nombre;
    private String bio;
    private String experiencia;
    private String contacto;

    public Usuario() {
    }

    public Usuario(String nombre, String bio, String experiencia, String contacto) {
        this.nombre = nombre;
        this.bio = bio;
        this.experiencia = experiencia;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
