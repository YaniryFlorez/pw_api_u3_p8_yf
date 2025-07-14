package uce_edu_web.api.controller;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.repository.modelo.Hijo;
import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.IHijoServi;
import uce_edu_web.api.service.IProfesorServi;
import uce_edu_web.api.service.To.ProfesorTo;
import uce_edu_web.api.service.To.mapper.ProfesorMapper;

@Path("/profesores")

public class ProfesorController {

    @Inject
    private IProfesorServi profesorService;

    @Inject
    private IHijoServi hijoService;

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON) // ← Esto acepta JSON
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ProfesorTo profe = ProfesorMapper.toTo(this.profesorService.buscarPorId(id));
        profe.buildURI(uriInfo);
        return Response.status(Response.Status.OK).entity(profe).build();
    }

    @GET
    @Path("/todos")
    @Operation(summary = "Consultar profesores", description = "Este endpoint permite consultar todos los profesores, filtrando por género y provincia si se desea")
    public Response consultarProfesores(@QueryParam("genero") String genero,
            @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        List<ProfesorTo> lista = this.profesorService.buscarPorGenero(genero)
                .stream()
                .map(ProfesorMapper::toTo)
                .toList();
        return Response.status(Response.Status.OK).entity(lista).build();
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
    @Operation(summary = "Guardar Profesor", description = "Guarda un nuevo profesor en el sistema")
    public Response guardarProfesor(@RequestBody Profesor profesor) {
        this.profesorService.guardar(profesor);
        return Response.status(Response.Status.CREATED).entity(profesor).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar Profesor", description = "Actualiza por completo los datos de un Profesor según su ID")
    public Response actualizarPorId(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        this.profesorService.actualizar(profesor);
        return Response.status(Response.Status.OK).entity(profesor).build();
    }

    @PATCH
    @Path("/{id}")
    @Operation(summary = "Actualizar Parcial Profesor", description = "Actualiza parcialmente los datos de un Profesor según su ID")
    public Response actualizarParcialProfesor(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
        Profesor existente = this.profesorService.buscarPorId(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Profesor no encontrado").build();
        }

        if (profesor.getNombre() != null) {
            existente.setNombre(profesor.getNombre());
        }
        if (profesor.getApellido() != null) {
            existente.setApellido(profesor.getApellido());
        }
        if (profesor.getFechaContrato() != null) {
            existente.setFechaContrato(profesor.getFechaContrato());
        }
        if (profesor.getMateria() != null) {
            existente.setMateria(profesor.getMateria());
        }

        this.profesorService.actualizarParcial(existente);
        return Response.status(Response.Status.OK).entity(existente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Borrar Profesor", description = "Borra un Profesor según su ID")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.profesorService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}/hijos")
    @Operation(summary = "Obtener Hijos de Profesor", description = "Devuelve la lista ficticia de hijos asociada a un profesor")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {
       
        return this.hijoService.buscarPorProfesorId(id);
    }

}
