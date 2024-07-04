package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import java.util.List;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Materia;

public interface IMateriaService {
    //Crud
    public Materia buscar(Integer id);
    public void actualizar(Materia materia);
    public void borrar(Integer id);
    public void guardar(Materia materia);
    public List<Materia> buscarByCodigo(String codigo);
}
