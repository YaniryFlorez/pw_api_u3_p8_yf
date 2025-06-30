package uce_edu_web.api.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.IEstudianteServi;

@Path("/estudiantes") // recursos
public class EstudianteController {

    @Inject
    private IEstudianteServi estudianteService;

    @GET
    @Path("/{id}")
    public Estudiante consultarPorId(@PathParam("id") Integer id) {
        return this.estudianteService.buscarPorId(id);
    }

    @GET
    @Path("")
    public List<Estudiante> consultarTodos() {
        return this.estudianteService.buscarTodos();
    }

    @POST
    @Path("")
    public void guardarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/{id}")
    public void actualizarPorId(@PathParam("id") Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        this.estudianteService.actualizarPorId(this.estudianteService.buscarPorId(id));
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcialEstudiante(@PathParam("id") Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        Estudiante e = this.estudianteService.buscarPorId(id);
        if (estudiante.getNombre() != null) {
            e.setNombre(estudiante.getNombre());
        }
        if (estudiante.getApellido() != null) {
            e.setApellido(estudiante.getApellido());
        }
        if (estudiante.getFechaNacimiento() != null) {
            e.setFechaNacimiento(estudiante.getFechaNacimiento());
        }

        this.estudianteService.actualizarParcial(e);

    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id) {
        this.estudianteService.borrarPorId(id);
    }
   
}