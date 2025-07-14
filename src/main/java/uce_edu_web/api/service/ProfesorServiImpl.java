package uce_edu_web.api.service;

import java.util.List;

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

    @Override
    public List<Profesor> buscarTodos() {
        return this.profesorRepo.seleccionarTodos();
    }

    @Override
    public List<Profesor> buscarPorGenero(String genero) {
        return this.profesorRepo.seleccionarPorGenero(genero);
    }

    @Override
    public Profesor guardar(Profesor profesor) {
        return this.profesorRepo.insertar(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.profesorRepo.actualizar(profesor);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.profesorRepo.eliminarPorId(id);
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.profesorRepo.actualizarParcial(profesor);
    }

}
