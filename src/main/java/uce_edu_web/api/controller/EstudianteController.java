package uce_edu_web.api.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.IEstudianteServi;

@Path("/estudiantes") // recursos
public class EstudianteController {

    @Inject
    private IEstudianteServi estudianteService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id) {
        return Response.status(227).entity(this.estudianteService.buscarPorId(id)).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "consultar estudiante", description = "este end point permite registrar un nuevo estudiante")
    public Response consultarTodos(@QueryParam("genero") String genero,
            @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.OK).entity(this.estudianteService.buscarTodos(genero)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON) // ← Esto acepta JSON
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Guardar Estudiante", description = "Guarda un nuevo estudiante en el sistema")
    public Response guardarEstudiante(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
        return Response.status(Response.Status.CREATED).entity(estudiante).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Actualizar estudiante", description = "Actualiza por completo los datos de un estudiante según su ID")
    public Response actualizarPorId(@PathParam("id") Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        this.estudianteService.actualizarPorId(this.estudianteService.buscarPorId(id));
        return Response.status(Response.Status.OK).entity(estudiante).build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
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
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Eliminar estudiante", description = "Elimina un estudiante por ID")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.estudianteService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();
    }

}