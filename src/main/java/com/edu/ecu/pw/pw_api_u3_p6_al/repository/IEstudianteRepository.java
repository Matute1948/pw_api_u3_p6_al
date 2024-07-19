package com.edu.ecu.pw.pw_api_u3_p6_al.repository;

import java.util.List;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;

public interface IEstudianteRepository {

    //Crud
    public Estudiante seleccionar(String cedula);
    public void actualizar(Estudiante estudiante);
    public void eliminar(String cedula);
    public void insertar(Estudiante estudiante);
    public List<Estudiante> seleccionarByGenero(String genero);
    public List<Estudiante> seleccionarTodos();


} 
