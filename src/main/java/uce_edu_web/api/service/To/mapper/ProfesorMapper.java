package uce_edu_web.api.service.To.mapper;

import uce_edu_web.api.repository.modelo.Profesor;
import uce_edu_web.api.service.To.ProfesorTo;

public class ProfesorMapper {

    public static ProfesorTo toTo(Profesor profesor) {
        ProfesorTo profesorTo = new ProfesorTo();
        profesorTo.setId(profesor.getId());
        profesorTo.setNombre(profesor.getNombre());
        profesorTo.setApellido(profesor.getApellido());
        profesorTo.setGenero(profesor.getGenero());
        profesorTo.setMateria(profesor.getMateria());
        profesorTo.setFechaContrato(profesor.getFechaContrato());
        return profesorTo;
    }

    public static Profesor toEntity(ProfesorTo profesorTo) {
        Profesor profesor = new Profesor();
        profesor.setId(profesorTo.getId());
        profesor.setNombre(profesorTo.getNombre());
        profesor.setApellido(profesorTo.getApellido());
        profesor.setGenero(profesorTo.getGenero());
        profesor.setMateria(profesorTo.getMateria());
        profesor.setFechaContrato(profesorTo.getFechaContrato());
        return profesor;
    }

}
