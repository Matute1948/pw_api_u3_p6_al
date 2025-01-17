package com.edu.ecu.pw.pw_api_u3_p6_al.repository;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;

public interface IEstudianteRepository {

    //Crud
    public Estudiante seleccionar(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);
    public void insertar(Estudiante estudiante);

} 
