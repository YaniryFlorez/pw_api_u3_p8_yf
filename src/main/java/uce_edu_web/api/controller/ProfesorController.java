package uce_edu_web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
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
}

