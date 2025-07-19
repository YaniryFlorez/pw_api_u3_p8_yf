package uce_edu_web.api.controller;

import java.util.List;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.annotation.security.RolesAllowed;
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
import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.repository.modelo.Hijo;
import uce_edu_web.api.service.IEstudianteServi;
import uce_edu_web.api.service.IHijoServi;
import uce_edu_web.api.service.To.EstudianteTo;
import uce_edu_web.api.service.To.mapper.EstudianteMapper;

@Path("/estudiantes") // recursos
@Consumes(MediaType.APPLICATION_JSON) // ← Esto acepta JSON
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteController {

    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim("sub")
    ClaimValue<String> subject;

    @Inject
    private IEstudianteServi estudianteService;

    @Inject
    private IHijoServi hijoService;

   @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        EstudianteTo estu = EstudianteMapper.toTo(this.estudianteService.buscarPorId(id));
        estu.buildURI(uriInfo);
        return Response.status(227).entity(estu).build();
    }
 
    @GET
    @Path("")
    @Operation(
        summary = "consultar estudiante",
        description = "este end point permite registrar un nuevo estudiante"
    )
    public Response consultarTodos(@QueryParam("genero") String genero, @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        List<EstudianteTo> lista = this.estudianteService.buscarTodos(genero)
            .stream()
            .map(EstudianteMapper::toTo)
            .toList();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
 
    @POST
    @Path("")
    @Operation(
        summary = "guardar estudiante",
        description = "esta capacidad permite guardar en la ..."
    )
    public void guardar(@RequestBody EstudianteTo estudianteTo) {
        this.estudianteService.guardar(EstudianteMapper.toEntity(estudianteTo));
    }
 
    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, @RequestBody EstudianteTo estudianteTo) {
        var estudiante = EstudianteMapper.toEntity(estudianteTo);
        estudiante.setId(id);
        this.estudianteService.actualizarPorId(estudiante);
    }
 
    @PATCH
    @Path("/{id}")
    public void actualizarParcialPorId(@PathParam("id") Integer id, @RequestBody EstudianteTo estudianteTo) {
        estudianteTo.setId(id);
        Estudiante e = this.estudianteService.buscarPorId(id);
        if (estudianteTo.getNombre() != null) {
            e.setNombre(estudianteTo.getNombre());
        }
        if (estudianteTo.getApellido() != null) {
            e.setApellido(estudianteTo.getApellido());
        }
        if (estudianteTo.getFechaNacimiento() != null) {
            e.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        }
        if (estudianteTo.getGenero() != null) {
            e.setGenero(estudianteTo.getGenero());
        }
        this.estudianteService.actualizarParcial(e);
    }
 
  @DELETE
@Path("/{id}")
@Operation(summary = "Eliminar estudiante", description = "Elimina un estudiante por ID")
public Response borrarPorId(@PathParam("id") Integer id) {
    this.estudianteService.borrarPorId(id);
    return Response.status(Response.Status.OK).build();
}

 
    @GET
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id){
        return this.hijoService.buscarPorEstudianteId(id);
    }
}
 