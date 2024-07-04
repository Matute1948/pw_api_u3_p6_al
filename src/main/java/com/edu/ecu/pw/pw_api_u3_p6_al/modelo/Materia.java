package com.edu.ecu.pw.pw_api_u3_p6_al.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Column(name = "mat_id")
    private Integer id;
    @Column(name = "mat_nombre")
    private String nombre;
    @Column(name = "mat_codigo")
    private String codigo;
    @Column(name = "mat_profesor")
    private String profesor;
    @Column(name = "mat_numero_horas")
    private Integer horas;
    @Column(name = "mat_numero_cupos")
    private Integer cupos;
    
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
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public Integer getHoras() {
        return horas;
    }
    public void setHoras(Integer horas) {
        this.horas = horas;
    }
    public Integer getCupos() {
        return cupos;
    }
    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }
    
}
