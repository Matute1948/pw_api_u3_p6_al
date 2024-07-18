package com.edu.ecu.pw.pw_api_u3_p6_al.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ecu.pw.pw_api_u3_p6_al.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudainteRepositoryImpl implements IEstudianteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.seleccionar(id));
        
    }

    @Override
    public void insertar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.persist(estudiante);
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> seleccionarByGenero(String genero) {
        // TODO Auto-generated method stub
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero =:genero",Estudiante.class);
        mQuery.setParameter("genero", genero);
        return mQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
        return mQuery.getResultList();
    }
    
}
