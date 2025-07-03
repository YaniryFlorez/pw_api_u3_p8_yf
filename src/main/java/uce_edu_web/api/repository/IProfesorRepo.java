package uce_edu_web.api.repository;

import java.util.List;
import uce_edu_web.api.repository.modelo.Profesor;

public interface IProfesorRepo {

public  Profesor seleccionarPorId(Integer id);
public List<Profesor> seleccionarTodos();
public List<Profesor> seleccionarPorGenero(String genero);
public Profesor insertar(Profesor profesor);
public void actualizar(Profesor profesor);
public void eliminarPorId(Integer id);  
public void actualizarParcial(Profesor profesor);

}
