package uce_edu_web.api.service;

import java.util.List;

import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.To.EstudianteTo;

public interface IEstudianteServi {

    public Estudiante buscarPorId(Integer id);

    public List<Estudiante> buscarTodos(String genero);

    public Estudiante guardar(Estudiante estudiante);

    public void actualizarPorId(Estudiante estudiante);

    public void borrarPorId(Integer id);

    public void actualizarParcial(Estudiante estudiante);

}
