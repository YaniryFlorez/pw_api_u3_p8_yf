package uce_edu_web.api.service;

import java.util.List;

import uce_edu_web.api.repository.modelo.Profesor;

public interface IProfesorServi {

    public Profesor buscarPorId(Integer id);

    public List<Profesor> buscarTodos();

    public List<Profesor> buscarPorGenero(String genero);

    public Profesor guardar(Profesor profesor);

    public void actualizar(Profesor profesor);

    public void borrarPorId(Integer id);

    public void actualizarParcial(Profesor profesor);
}
