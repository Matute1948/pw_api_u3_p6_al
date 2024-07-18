package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;
import com.edu.ecu.pw.pw_api_u3_p6_al.repository.IEstudianteRepository;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.to.EstudianteTO;

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

    @Override
    public List<Estudiante> buscarByGenero(String genero) {
        // TODO Auto-generated method stub
        return this.estudianteRepository.seleccionarByGenero(genero);
    }
    
    public EstudianteTO convertir(Estudiante estu){
        EstudianteTO estTo= new EstudianteTO();
        estTo.setId(estu.getId());
        estTo.setNombre(estu.getNombre());
        estTo.setApellido(estu.getApellido());
        estTo.setFechaNacimiento(estu.getFechaNacimiento());
        estTo.setGenero(estu.getGenero());
        return estTo;
    }
    @Override
    public EstudianteTO buscarPorID(Integer id){
        Estudiante est = this.estudianteRepository.seleccionar(id);
        return this.convertir(est);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        return estudianteRepository.seleccionarTodos();
    }
    
}
