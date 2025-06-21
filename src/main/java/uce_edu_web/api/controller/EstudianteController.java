package uce_edu_web.api.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.IEstudianteServi;

@Path("/estudiantes")
public class EstudianteController {
    private IEstudianteServi estudianteService;

@GET
@Path("/consultar/{id}")    
public Estudiante consultarPorId(@PathParam("id") Integer id){
return this.estudianteService.buscarPorId(id);

}
}
