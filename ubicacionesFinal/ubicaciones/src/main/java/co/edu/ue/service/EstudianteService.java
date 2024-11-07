package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IEstudianteDao;
import co.edu.ue.model2.Estudiante;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	IEstudianteDao dao;
	public Estudiante registerDato(Estudiante estudiante) {
		if(!estudiante.equals(null))
			return dao.registerDato(estudiante);
		else
			return null;
	}

	@Override
	public List<Estudiante> allDatos() {
		return dao.allDatos();
	}

	@Override
	public Estudiante searchById(int id) {
		return dao.searchById(id) ;
		
	}

	@Override
	public Estudiante deleteEstud(int id) {
		// Buscar el estudiante por ID
	    Estudiante estud = dao.searchById(id);
	    
	    if (estud != null) {
	        // Eliminar si existe
	        dao.deleteEstud(id);
	        return estud;  // Retorna el administrador eliminado
	    } else {
	        return null;  // Si no existe, retorna null
	    }
	}

	
	

}
