package uce_edu_web.api.service;

import java.util.List;

import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.To.ProfesorTo;

public interface IProfesorServi {

    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo);

    public List<Profesor> buscarTodos();

    public List<Profesor> buscarPorGenero(String genero);

    public Profesor guardar(Profesor profesor);

    public void actualizar(Profesor profesor);

    public void borrarPorId(Integer id);

    public void actualizarParcial(Profesor profesor);
}
