package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model2.Estudiante;

public interface IEstudianteJpa extends JpaRepository<Estudiante, Integer>{

	
}
