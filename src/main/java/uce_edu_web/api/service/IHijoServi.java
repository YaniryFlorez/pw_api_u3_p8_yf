package uce_edu_web.api.service;

import java.util.List;

import uce_edu_web.api.repository.modelo.Hijo;

public interface IHijoServi {

 public List<Hijo> buscarPorEstudianteId(Integer id);
  public List<Hijo> buscarPorProfesorId(Integer id);

 
}
