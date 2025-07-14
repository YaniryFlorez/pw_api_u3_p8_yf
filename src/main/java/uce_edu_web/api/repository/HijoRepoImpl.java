package uce_edu_web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce_edu_web.api.repository.modelo.Hijo;

@ApplicationScoped
@Transactional
public class HijoRepoImpl implements HijoRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hijo> buscarPorEstudianteId(Integer id) {
        TypedQuery<Hijo> myQuery = this.entityManager.createQuery("SELECT h FROM Hijo h WHERE h.estudiante.id =:id",
                Hijo.class);
        myQuery.setParameter("id", id);
        return myQuery.getResultList();
    }

    @Override
    public List<Hijo> buscarPorProfesorId(Integer id) {
        TypedQuery<Hijo> myQuery = this.entityManager.createQuery("SELECT h FROM Hijo h WHERE h.profesor.id =:id",
                Hijo.class);
        myQuery.setParameter("id", id);
        return myQuery.getResultList();
    }

}
