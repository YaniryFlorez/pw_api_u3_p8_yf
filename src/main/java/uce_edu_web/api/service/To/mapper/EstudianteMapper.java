package uce_edu_web.api.service.To.mapper;

import uce_edu_web.api.repository.modelo.Estudiante;
import uce_edu_web.api.service.To.EstudianteTo;

public class EstudianteMapper {


    public static EstudianteTo toTo(Estudiante estudiante){
        EstudianteTo estudianteTo = new EstudianteTo();
        estudianteTo.setId(estudiante.getId());
        estudianteTo.setNombre(estudiante.getNombre());
        estudianteTo.setApellido(estudiante.getApellido());
        estudianteTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteTo.setGenero(estudiante.getGenero());
        return estudianteTo;
 
        // Aquí podrías agregar la lógica para convertir los hijos si es necesario
    }

     public static Estudiante toEntity(EstudianteTo estudianteTo){
        
        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteTo.getId());
        estudiante.setNombre(estudianteTo.getNombre());
        estudiante.setApellido(estudianteTo.getApellido());
        estudiante.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        estudiante.setGenero(estudianteTo.getGenero());

        // Aquí podrías agregar la lógica para convertir los hijos si es necesario
        return estudiante;
    }

}
