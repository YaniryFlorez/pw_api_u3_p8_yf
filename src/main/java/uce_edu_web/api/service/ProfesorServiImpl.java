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
    public Profesor guardar(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public Profesor actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void borrarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPorId'");
    }

    @Override
    public Profesor actualizarParcial(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParcial'");
    }

}

