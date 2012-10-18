package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Articulo extends Model {
	
	@Id
	public int Articulo_id;
	
	public String nombre;
	
	@ManyToOne
	public Funcion funcion;

	public Double preciounitario; 
	
}
