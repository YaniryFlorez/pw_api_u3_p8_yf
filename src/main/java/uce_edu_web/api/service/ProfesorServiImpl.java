package uce_edu_web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.repository.IProfesorRepo;
import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.To.ProfesorTo;

@ApplicationScoped
public class ProfesorServiImpl implements IProfesorServi {

    @Inject
    private IProfesorRepo profesorRepo;

    @Override
    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo) {
        Profesor p1 = this.profesorRepo.seleccionarPorId(id);
        ProfesorTo p = new ProfesorTo(p1.getId(), p1.getNombre(), p1.getApellido(), p1.getGenero(),
                p1.getMateria(), p1.getFechaContrato(), uriInfo);
        return p;
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
