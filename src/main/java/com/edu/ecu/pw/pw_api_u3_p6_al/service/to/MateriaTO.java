package com.edu.ecu.pw.pw_api_u3_p6_al.service.to;

import java.io.Serializable;

public class MateriaTO implements Serializable {
    
    private Integer id;
    private String nombre;
    private Integer numeroCreditos;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }
    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }
    
}
