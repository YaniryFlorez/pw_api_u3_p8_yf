package uce_edu_web.api.service.To;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.controller.ProfesorController;


public class ProfesorTo {
    private Integer id;
    private String nombre;
    private String apellido;
    private String genero;
    private String materia;
    private LocalDateTime fechaContrato;
    private Map<String, String> _links = new HashMap<>();

    public ProfesorTo(Integer id, String nombre, String apellido, String genero, String materia, LocalDateTime fechaContrato, UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.materia = materia;
        this.fechaContrato = fechaContrato;
        URI todosHijos = uriInfo.getBaseUriBuilder()
                .path(ProfesorController.class)
                .path(ProfesorController.class, "obtenerHijosPorId")
                .build(id);
        _links.put("hijos", todosHijos.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDateTime fechaContrato) {
        this.fechaContrato = fechaContrato;
    }


}
