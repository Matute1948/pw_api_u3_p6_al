package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import java.util.List;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;

public interface IEstudianteService {
        //Crud
    public Estudiante buscar(Integer id);
    public void actualizar(Estudiante estudiante);
    public void borrar(Integer id);
    public void guardar(Estudiante estudiante);
    public List<Estudiante> buscarByGenero(String genero);
}
