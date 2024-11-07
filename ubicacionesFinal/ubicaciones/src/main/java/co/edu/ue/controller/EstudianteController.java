package co.edu.ue.controller;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.locationtech.jts.geom.Point;
import co.edu.ue.model2.Estudiante;
import co.edu.ue.service.IEstudianteService;

@RestController
@RequestMapping(value="conexion")
@CrossOrigin(origins="*")
public class EstudianteController {

	@Autowired
	IEstudianteService service;
	@GetMapping(value="datos", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> getAllRegister(){
		//1 Enviar datos adicionales en la peticion del servicio
		//Cantidad de registros
		List<Estudiante> estu = service.allDatos();
		
		//2.Crear header para añadir la info adicional
		HttpHeaders headers = new HttpHeaders();
		headers.add("cantidad_datos", String.valueOf(estu.size()));
		headers.add("otro_dato", "datos");
		
		return new ResponseEntity<List<Estudiante>>(estu, headers, HttpStatus.OK); 
		
	}
	
	//Eliminar datos por id
		@DeleteMapping(value="datosE/{cod}")
		public ResponseEntity<Estudiante> deleteDato(@PathVariable("cod") int estuCedula) {
		    Estudiante estuEliminado = service.deleteEstud(estuCedula);
		    
		    if (estuEliminado != null) {
		        return new ResponseEntity<Estudiante>(estuEliminado, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);
		    }
		}
		
		/*
		@PostMapping(value="datosAG", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> saveDato(@RequestBody Estudiante estudiante){
			if(!service.registerDato(estudiante).equals(null)) {
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		*/
		@PostMapping(value = "datosAG", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> saveDato(@RequestBody Estudiante estudiante) {
		    GeometryFactory geometryFactory = new GeometryFactory();

		    // Verifica si las coordenadas están presentes en el cuerpo de la solicitud
		    if (estudiante.getEstuUbiResidencia() == null || estudiante.getEstuUbiTrabajo() == null) {
		        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Enviar un error si no hay coordenadas
		    }

		    // Convierte las coordenadas de residencia y trabajo a objetos Point
		    Point residencia = geometryFactory.createPoint(new Coordinate(
		        estudiante.getEstuUbiResidencia().getX(),  // Obtener longitud
		        estudiante.getEstuUbiResidencia().getY()   // Obtener latitud
		    ));
		    
		    Point trabajo = geometryFactory.createPoint(new Coordinate(
		        estudiante.getEstuUbiTrabajo().getX(),  // Obtener longitud
		        estudiante.getEstuUbiTrabajo().getY()   // Obtener latitud
		    ));
		    
		    estudiante.setEstuUbiResidencia(residencia);
		    estudiante.setEstuUbiTrabajo(trabajo);

		    // Registra el estudiante
		    if (service.registerDato(estudiante) != null) {
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		    }
		}


}
