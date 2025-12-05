package com.developerprofile.model;

/**
 *
 * @author Juan1
 */
public class Habilidad {
    private Integer nivel;
    private String id;
    private String nombre;

    public Habilidad() {
    }

    public Habilidad(Integer nivel, String id, String nombre) {
        this.nivel = nivel;
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public void setNivel(Integer nivel){
        this.nivel = nivel;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
