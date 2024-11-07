package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model2.Estudiante;

public interface IEstudianteDao {

	Estudiante registerDato(Estudiante estudiante);
	List<Estudiante> allDatos();
	Estudiante searchById(int id);
	
	//Delete
	void deleteEstud(int id);
	
	
}
