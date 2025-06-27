package uce_edu_web.api.repository;

import java.util.List;

import uce_edu_web.api.repository.modelo.Estudiante;

public interface IEstudianteRepo {

public Estudiante seleccionarPorId(Integer id);
public List<Estudiante> seleccionarTodos();
public Estudiante insertar(Estudiante estudiante);
public void actualizarPorId(Estudiante estudiante);
public void actualizarParcial(Estudiante estudiante);
public void eliminarPorId(Integer id);  
}
