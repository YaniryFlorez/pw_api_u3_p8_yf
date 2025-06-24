package uce_edu_web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce_edu_web.api.repository.IEstudianteRepo;
import uce_edu_web.api.repository.modelo.Estudiante;

@ApplicationScoped
public class EstudianteServiImpl implements IEstudianteServi {

    @Inject
    private IEstudianteRepo estudianteRepo;

    @Override
    public Estudiante buscarPorId(Integer id) {
        return this.estudianteRepo.seleccionarPorId(id);
    }

}
