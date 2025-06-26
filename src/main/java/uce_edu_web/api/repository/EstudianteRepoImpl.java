package uce_edu_web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce_edu_web.api.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo {

    @PersistenceContext
    private  EntityManager entityManager;
   

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }


    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return query.getResultList();
    }


    @Override
    public Estudiante insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
        return estudiante;
    }


    @Override
    public Estudiante actualizar(Estudiante estudiante) {
        return this.entityManager.merge(estudiante);
    }


    @Override
    public void eliminarPorId(Integer id) {
        Estudiante estudiante = this.entityManager.find(Estudiante.class, id);
        if (estudiante != null) {
            this.entityManager.remove(estudiante);
        }
    }


    @Override
    public Estudiante actualizarParcial(Estudiante estudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParcial'");
    }

    
}
