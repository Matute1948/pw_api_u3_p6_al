package com.edu.ecu.pw.pw_api_u3_p6_al.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Materia;
import com.edu.ecu.pw.pw_api_u3_p6_al.repository.IMateriaRepository;
import com.edu.ecu.pw.pw_api_u3_p6_al.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private IMateriaRepository materiaRepository;
    
    @Override
    public Materia buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.materiaRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Materia materia) {
        // TODO Auto-generated method stub
        this.materiaRepository.actualizar(materia);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.materiaRepository.eliminar(id);
    }

    @Override
    public void guardar(Materia Materia) {
        // TODO Auto-generated method stub
        this.materiaRepository.insertar(Materia);
    }

    @Override
    public List<Materia> buscarByCodigo(String codigo) {
        // TODO Auto-generated method stub
        return this.materiaRepository.seleccionarByCodigo(codigo);
    }

    @Override
    public List<MateriaTO> buscarByEstudiante(Integer id) {
        // TODO Auto-generated method stub
        List<Materia> lista = this.materiaRepository.seleccionarByEstudiante(id);
        List<MateriaTO> listaFinal = new ArrayList<>();
        for(Materia mat : lista){
            listaFinal.add(this.convertir(mat));
        }
        return listaFinal;
    }

    private MateriaTO convertir(Materia mat){
        MateriaTO mateTO = new MateriaTO();
        mateTO.setId(mat.getId());
        mateTO.setNombre(mat.getNombre());
        mateTO.setNumeroCreditos(mat.getCupos());
        return mateTO;
    }
    
}
