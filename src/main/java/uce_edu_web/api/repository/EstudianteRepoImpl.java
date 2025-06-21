package uce_edu_web.api.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import uce_edu_web.api.repository.modelo.Estudiante;

@Transactional
@TransactionScoped
public class EstudianteRepoImpl implements IEstudianteRepo {

    private  EntityManager entityManager;
   

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }



    
}
