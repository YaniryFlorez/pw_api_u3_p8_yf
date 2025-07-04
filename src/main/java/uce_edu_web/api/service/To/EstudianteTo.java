package uce_edu_web.api.service.To;
 
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
 
import jakarta.ws.rs.core.UriInfo;
import uce_edu_web.api.controller.EstudianteController;
 
public class EstudianteTo {
   
    private Integer id;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    public Map<String, String> _links=new HashMap<>();
 
    public EstudianteTo(Integer id, String nombre, String apellido, String genero, String fechaNacimiento,UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
 
        URI todosHijos= uriInfo.getBaseUriBuilder().path(EstudianteController.class)
        .path(EstudianteController.class,"obtenerHijosPorId").build(id);
   
   
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
 
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
 
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }  
 
 
}
 
 