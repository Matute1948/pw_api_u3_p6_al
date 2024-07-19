package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import java.util.List;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.to.EstudianteTO;

public interface IEstudianteService {
        //Crud
    public Estudiante buscar(String cedula);
    public void actualizar(Estudiante estudiante);
    public void borrar(String cedula);
    public void guardar(Estudiante estudiante);
    public List<Estudiante> buscarByGenero(String genero);
    public EstudianteTO buscarPorID(String cedula);
    public List<Estudiante> seleccionarTodos();
}
