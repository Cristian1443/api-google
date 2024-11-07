package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model2.Estudiante;

@Repository
public class EstudianteDao implements IEstudianteDao {

	@Autowired 
	IEstudianteJpa jpa;
	@Override
	public Estudiante registerDato(Estudiante estudiante) {
		return jpa.save(estudiante);
	}

	@Override
	public List<Estudiante> allDatos() {
		return jpa.findAll() ;
	}

	@Override
	public Estudiante searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public void deleteEstud(int id) {
		jpa.deleteById(id);
		
	}

	

}
