package uce_edu_web.api.service;

import java.util.List;

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

    @Override
    public List<Estudiante> buscarTodos() {
        return this.estudianteRepo.seleccionarTodos();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return this.estudianteRepo.insertar(estudiante);
    }

    @Override
    public void actualizarPorId(Estudiante estudiante) {
         this.estudianteRepo.actualizarPorId(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.estudianteRepo.eliminarPorId(id);
    }

    @Override
    public void actualizarParcial(Estudiante estudiante) {
       this.estudianteRepo.actualizarParcial(estudiante);
    }



}
