package uce_edu_web.api.controller;

import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.IProfesorServi;

@Path("/profesores")
public class ProfesorController {

    @Inject
    private IProfesorServi profesorService;

@GET
@Path("/consultar/{id}")
public Profesor consultarPorId(@PathParam("id") Integer id) {
    return this.profesorService.buscarPorId(id);
}
@GET
@Path("")
public List<Profesor> consultarTodos() {
    return this.profesorService.buscarTodos();
}
/*
@POST
@Path("")
public void guardarProfesor(@RequestBody Profesor profesor) {
    this.profesorService.guardar(profesor);
}
@PUT
@Path("/{id}")
public void actualizarPorId(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
    this.profesorService.actualizar(profesor);
}

@PATCH
@Path("/{id}")
public void actualizarParcialProfesor(@PathParam("id") Integer id, @RequestBody Profesor profesor) {
    this.profesorService.actualizarParcial(profesor);
}

@DELETE
@Path("/{id}")
public void borrarPorId(@PathParam("id") Integer id) {
    this.profesorService.borrarPorId(id);
}
     */

}

