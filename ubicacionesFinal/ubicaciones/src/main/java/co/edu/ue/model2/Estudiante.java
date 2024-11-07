package co.edu.ue.model2;

import java.io.Serializable;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import co.edu.ue.controller.PointDeserializer;
import jakarta.persistence.*;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@Entity
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name="estu_cedula")
	private int estuCedula;

	@Column(name="estu_apellidos")
	private String estuApellidos;

	@Column(name="estu_nombres")
	private String estuNombres;

	@Column(name="estu_residencia")
	private String estuResidencia;

	@Column(name="estu_trabajo")
	private String estuTrabajo;

	
	@JsonDeserialize(using = PointDeserializer.class)
	@Column(name="estu_ubi_residencia", columnDefinition = "geometry(Point, 4326)")
	private Point estuUbiResidencia;
	@JsonDeserialize(using = PointDeserializer.class)
	@Column(name="estu_ubi_trabajo", columnDefinition = "geometry(Point, 4326)")
	private Point estuUbiTrabajo;


	public Estudiante() {
	}

	public int getEstuCedula() {
		return this.estuCedula;
	}

	public void setEstuCedula(int estuCedula) {
		this.estuCedula = estuCedula;
	}

	public String getEstuApellidos() {
		return this.estuApellidos;
	}

	public void setEstuApellidos(String estuApellidos) {
		this.estuApellidos = estuApellidos;
	}

	public String getEstuNombres() {
		return this.estuNombres;
	}

	public void setEstuNombres(String estuNombres) {
		this.estuNombres = estuNombres;
	}

	public String getEstuResidencia() {
		return this.estuResidencia;
	}

	public void setEstuResidencia(String estuResidencia) {
		this.estuResidencia = estuResidencia;
	}

	public String getEstuTrabajo() {
		return this.estuTrabajo;
	}

	public void setEstuTrabajo(String estuTrabajo) {
		this.estuTrabajo = estuTrabajo;
	}

	 public Point getEstuUbiResidencia() {
	        return estuUbiResidencia;
	    }

	    public void setEstuUbiResidencia(Point estuUbiResidencia) {
	        this.estuUbiResidencia = estuUbiResidencia;
	    }

	    public Point getEstuUbiTrabajo() {
	        return estuUbiTrabajo;
	    }

	    public void setEstuUbiTrabajo(Point estuUbiTrabajo) {
	        this.estuUbiTrabajo = estuUbiTrabajo;
	    }
}