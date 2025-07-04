package uce_edu_web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.repository.modelo.Hijo;
import uce_edu_web.api.service.IEstudianteServi;
import uce_edu_web.api.service.To.EstudianteTo;

@Path("/estudiantes") // recursos
public class EstudianteController extends BaseControlador {

    @Inject
    private IEstudianteServi estudianteService;

    @GET
    @Path("/{id}")
    public Response consultarPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        EstudianteTo estu = this.estudianteService.buscarPorId(id, uriInfo);
        return Response.status(227).entity(estu).build();
    }

    @GET
    @Path("")
    @Operation(summary = "consultar estudiante", description = "este end point permite registrar un nuevo estudiante")
    public Response consultarTodos(@QueryParam("genero") String genero,
            @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.OK).entity(this.estudianteService.buscarTodos(genero)).build();
    }

    @POST
    @Path("")

    @Operation(summary = "Guardar Estudiante", description = "Guarda un nuevo estudiante en el sistema")
    public Response guardarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
        return Response.status(Response.Status.CREATED).entity(estudiante).build();
    }
/*

    @PATCH
    @Path("/{id}")
    @Operation(summary = "Actualizar estudiante parcialmente", description = "Actualiza parcialmente los datos de un estudiante según su ID")
    public Response actualizarParcialEstudiante(@PathParam("id") Integer id, @RequestBody Estudiante estudiante) {
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
        return Response.status(Response.Status.OK).entity(e).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar estudiante", description = "Elimina un estudiante por ID")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.estudianteService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();
    } */

    @GET
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {
        Hijo h1 = new Hijo();
        h1.setNombre("Pepito");
        Hijo h2 = new Hijo();
        h2.setNombre("Juanito");
        List<Hijo> hijos = new ArrayList<>();
        hijos.add(h1);
        hijos.add(h2);

        return hijos;
    }

}