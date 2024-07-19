package com.edu.ecu.pw.pw_api_u3_p6_al.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void actualizar(Materia materia) {
        // TODO Auto-generated method stub
        this.entityManager.merge(materia);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.seleccionar(id));
        
    }

    @Override
    public void insertar(Materia materia) {
        // TODO Auto-generated method stub
        this.entityManager.persist(materia);
    }

    @Override
    public Materia seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Materia.class, id);
    }

    @Override
    public List<Materia> seleccionarByCodigo(String codigo) {
        // TODO Auto-generated method stub
        TypedQuery<Materia> mQuery = this.entityManager.createQuery("SELECT a FROM Materia a WHERE a.codigo =:codigo",Materia.class);
        mQuery.setParameter("codigo", codigo);
        return mQuery.getResultList();
    }

    @Override
    public List<Materia> seleccionarByEstudiante(String cedula) {
        // TODO Auto-generated method stub
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =:cedula ", Materia.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getResultList();
    }
}
