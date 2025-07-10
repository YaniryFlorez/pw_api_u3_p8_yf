package uce_edu_web.api.repository;

import java.util.List;

import uce_edu_web.api.repository.modelo.Hijo;

public interface HijoRepo {
 public List<Hijo> buscarPorEstudianteId(Integer id);
}
