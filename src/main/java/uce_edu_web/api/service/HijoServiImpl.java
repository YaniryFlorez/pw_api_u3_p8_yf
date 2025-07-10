package uce_edu_web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce_edu_web.api.repository.HijoRepo;
import uce_edu_web.api.repository.modelo.Hijo;

@ApplicationScoped
public class HijoServiImpl implements IHijoServi {

     @Inject
     private HijoRepo hijoRepo;

    @Override
    public List<Hijo> buscarPorEstudianteId(Integer id) {
        return this.hijoRepo.buscarPorEstudianteId(id);
    }

}
