package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.MaxLength;
import play.db.ebean.Model;

@Entity
public class Pelicula extends Model {

	@Id
	public int MovieId;
	
	public String nombre;
	
	public String categoria;
	
	public String duracion;
	
	@MaxLength(value = 100)
	public String sinopsis;
	
	public String youtube;
	
	public String imagenurl;
	
}
