package com.developerprofile.model;

/**
 *
 * @author Juan1
 */
public class Habilidad {
    private String nivel;
    private String id;
    private String habilidad;

    public Habilidad() {
    }

    public Habilidad(String id, String nivel, String habilidad) {
        this.nivel = nivel;
        this.id = id;
        this.habilidad = habilidad;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getNivel(){
        return nivel;
    }
    
    public void setNivel(String nivel){
        this.nivel = nivel;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
