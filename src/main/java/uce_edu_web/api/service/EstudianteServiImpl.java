package uce_edu_web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.repository.IEstudianteRepo;
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.To.EstudianteTo;

@ApplicationScoped
public class EstudianteServiImpl implements IEstudianteServi {

    @Inject
    private IEstudianteRepo estudianteRepo;

    @Override
    public EstudianteTo buscarPorId(Integer id, UriInfo uriInfo) {
        Estudiante e1 = this.estudianteRepo.seleccionarPorId(id);
        EstudianteTo e = new EstudianteTo(e1.getId(), e1.getNombre(), e1.getApellido(),e1.getFechaNacimiento(), e1.getGenero(), uriInfo);
        return e;
    }

    @Override
    public List<Estudiante> buscarTodos(String genero) {
        return this.estudianteRepo.seleccionarTodos(genero);
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
