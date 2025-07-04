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
import uce_edu_web.api.repository.modelo.Hijo;
import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.IProfesorServi;
import uce_edu_web.api.service.To.ProfesorTo;

@Path("/profesores")
public class ProfesorController extends BaseControlador {

    @Inject
    private IProfesorServi profesorService;

    @GET
    @Path("/{id}")
    public Response consultarPorId(@PathParam("id") Integer id,@Context UriInfo uriInfo) {
        ProfesorTo profe = this.profesorService.buscarPorId(id, uriInfo);
        return Response.status(Response.Status.OK).entity(profe).build();
    }

    @GET
    @Path("/todos")
    @Operation(summary = "consultar Profesor", description = "este end point permite buscar todos los Profesores")
    public Response consultarTodos() {
        return Response.status(Response.Status.OK).entity(this.profesorService.buscarTodos()).build();
    }

    @GET
    @Path("/")
    @Operation(summary = "consultar Profesor", description = "este end point permite buscar Profesores por género y provincia")
    public Response consultarPorGenero(@QueryParam("genero") String genero,
            @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.OK).entity(this.profesorService.buscarPorGenero(genero)).build();
    }

    @POST
    @Path("")
    public Response guardarProfesor(@RequestBody Profesor profesor) {
        this.profesorService.guardar(profesor);
        return Response.status(Response.Status.CREATED).entity(profesor).build();
    }
/* 
    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar Profesor", description = "Actualiza por completo los datos de un Profesor según su ID")
    public Response actualizarPorId(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        this.profesorService.actualizar(this.profesorService.buscarPorId(id));
        return Response.status(Response.Status.OK).entity(profesor).build();
    }

    @PATCH
    @Path("/{id}")
    @Operation(summary = "Actualizar Parcial Profesor", description = "Actualiza parcialmente los datos de un Profesor según su ID")
    public Response actualizarParcialProfesor(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        Profesor p = this.profesorService.buscarPorId(id);
        if (profesor.getNombre() != null) {
            p.setNombre(profesor.getNombre());
        }
        if (profesor.getApellido() != null) {
            p.setApellido(profesor.getApellido());
        }
        if (profesor.getFechaContrato() != null) {
            p.setFechaContrato(profesor.getFechaContrato());
        }
        if (profesor.getMateria() != null) {
            p.setMateria(profesor.getMateria());
        }

        this.profesorService.actualizarParcial(p);
        return Response.status(Response.Status.OK).entity(p).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Borrar Profesor", description = "Borra un Profesor según su ID")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.profesorService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();
    }
*/
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
