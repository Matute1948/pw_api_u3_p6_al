package com.edu.ecu.pw.pw_api_u3_p6_al.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;


public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable {

    private static final long serialVersionUID = 705562941894409723L;
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private String genero;
    private List<MateriaTO> materias;

    
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public List<MateriaTO> getMaterias() {
        return materias;
    }
    public void setMaterias(List<MateriaTO> materias) {
        this.materias = materias;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    


}
