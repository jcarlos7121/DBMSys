package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Compra extends Model {

	@Id()
	public int Id_Compra;
	
	@ManyToOne
	public Pedido Pedido;
	
	@ManyToOne
	public Articulo Articulo;
	
	public Double Cantidad;
	
	public Double Total;
}
