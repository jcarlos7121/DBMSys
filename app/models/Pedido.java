package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Pedido extends Model {

	@Id
	public int Pedido_id;
	
	@ManyToOne
	public Usuario usuario;
	
	public Double total;
	
	public boolean pagado;
	
	public String horadecaducidad;
	
}
