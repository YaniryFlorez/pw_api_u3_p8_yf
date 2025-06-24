package uce_edu_web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce_edu_web.api.repository.IProfesorRepo;
import uce_edu_web.api.repository.modelo.Profesor;

@ApplicationScoped
public class ProfesorServiImpl implements IProfesorServi {

    @Inject
    private IProfesorRepo profesorRepo;

    @Override
    public Profesor buscarPorId(Integer id) {
        return this.profesorRepo.seleccionarPorId(id);
    }

}

