package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Funcion extends Model{

	@Id
	public int Funcion_id;

	public String sala;
	
	@ManyToOne
	public Pelicula pelicula;
	
	public String Hora_inicio;
	
	public String Hora_fin;
	
	public String tipo_sala;
	
}
