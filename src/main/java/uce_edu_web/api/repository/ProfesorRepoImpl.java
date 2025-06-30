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
    private EntityManager entityManager;

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
        this.entityManager.persist(profesor);
        return profesor;
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.entityManager.merge(profesor);

    }

    @Override
    public void eliminarPorId(Integer id) {
        Profesor profesor = this.entityManager.find(Profesor.class, id);
        if (profesor != null) {
            this.entityManager.remove(profesor);
        }
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

}
