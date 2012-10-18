package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.validation.Email;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model{

	@Id
	public int Userid;
	
	public String password;
	
	public String nombre;
	
	public String apellidop;
	
	public String apellidom;
	
	public Long telefono;
	
	@Email
	public String email;
	
	public String facebookid;
	
	public boolean Admin;
	
}
