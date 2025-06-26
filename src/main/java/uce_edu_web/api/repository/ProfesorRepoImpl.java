package uce_edu_web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce_edu_web.api.repository.modelo.Profesor;

@Transactional
@ApplicationScoped
public class ProfesorRepoImpl implements IProfesorRepo {

    @PersistenceContext
    private  EntityManager entityManager;
   

    @Override
    public Profesor seleccionarPorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }


    @Override
    public List<Profesor> seleccionarTodos() {
    TypedQuery<Profesor> myquery = this.entityManager.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return myquery.getResultList();
    }


    @Override
    public Profesor insertar(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }


    @Override
    public Profesor actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }


    @Override
    public void eliminarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorId'");
    }


    @Override
    public Profesor actualizarParcial(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParcial'");
    }

    
}
