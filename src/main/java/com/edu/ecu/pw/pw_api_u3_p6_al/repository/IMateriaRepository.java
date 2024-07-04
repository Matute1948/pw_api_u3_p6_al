package com.edu.ecu.pw.pw_api_u3_p6_al.repository;

import java.util.List;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Materia;

public interface IMateriaRepository {
    
    //Crud
    public Materia seleccionar(Integer id);
    public void actualizar(Materia materia);
    public void eliminar(Integer id);
    public void insertar(Materia materia);
    public List<Materia> seleccionarByCodigo(String codigo);
}
