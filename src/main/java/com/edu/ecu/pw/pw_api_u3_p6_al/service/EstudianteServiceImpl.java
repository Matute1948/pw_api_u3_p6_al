package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepository estudianteRepository;
    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.estudianteRepository.seleccionar(id);
    
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.estudianteRepository.eliminar(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.insertar(estudiante);
    }
    
}
