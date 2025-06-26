package uce_edu_web.api.service;

import java.util.List;
import uce_edu_web.api.repository.modelo.Profesor;

public interface IProfesorServi {
public  Profesor buscarPorId(Integer id);
public List<Profesor> buscarTodos();
public Profesor guardar(Profesor profesor);
public Profesor actualizar(Profesor profesor);
public void borrarPorId(Integer id);  
public Profesor actualizarParcial(Profesor profesor);
}
