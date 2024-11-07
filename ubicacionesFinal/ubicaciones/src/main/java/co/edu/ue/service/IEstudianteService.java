package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model2.Estudiante;

public interface IEstudianteService {

	Estudiante registerDato(Estudiante estudiante);
	List<Estudiante> allDatos();
	Estudiante searchById(int id);
	
	//Delete
	Estudiante deleteEstud(int id);
	
	
}
