package controllers;

import java.util.List;
import java.util.Map;

import models.Pelicula;
import models.Usuario;

import play.mvc.Controller;
import play.mvc.Result;
import play.db.ebean.*;
import static play.libs.Json.toJson;
import views.html.*;

public class UsuarioController extends Controller{
	
	public static Result login(){
		
		Map<String, String[]> a = request().body().asFormUrlEncoded();
		
		if(a != null){
			String username = a.get("username")[0];
			String contra =  a.get("password")[0];
		
			System.out.println(username + " " + contra);
			
			
			if(username.equals("admin") && contra.equals("admin")){
				return ok(paneladmin.render("admin"));
			}
			
		Usuario usuario = (Usuario) new Model.Finder(String.class, Usuario.class).where().eq("email", username).findUnique();
		List<Pelicula> peliculas = new Model.Finder(String.class, Pelicula.class).all();
		
		
		try{
			if(contra.equals(usuario.password)){
				System.out.println("Wi");
				return ok(panel.render(usuario.email, peliculas));
			
			}else{
				System.out.println("Wii");
				return ok(index.render("ble","presente"));
			}
			
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Wiii");
			return ok(index.render("ble","presente"));
				
		}
		}
		
		System.out.println("Wiiii");
		 return ok(index.render("ble","presente"));
	}
	
	public static Result register(){
		return ok(register.render("Registrate!","x"));
	}
	
	public static Result createaccount(){
		Map<String, String[]> a = request().body().asFormUrlEncoded();
		Usuario nuevo = new Usuario();
		if(a != null){
			nuevo.nombre = a.get("user[full_name]")[0];
			nuevo.apellidop = a.get("user[paterno]")[0];
			nuevo.apellidom = a.get("user[materno]")[0];
			nuevo.email =  a.get("user[email]")[0];
			try{
			nuevo.telefono = Long.parseLong(a.get("telefono")[0]);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("paleteo el parseo a int");
				return ok(register.render("Registrate!","no"));
			}	
			String contra1 = a.get("user[password]")[0];
			String contra2 = a.get("user[password2]")[0];
			if(contra1.equals(contra2)){
				/* se recomienda agregar encryptación a md5*/
				nuevo.password = contra1;
				nuevo.save();
				return ok(register.render("Registrate!","si"));
			}else{
				System.out.println("paletearon las contras");
				return ok(register.render("Registrate!","no"));
			}
		}
		
		return ok(register.render("Registrate!","no"));
	}

	public static Result dameusers(){
		List<Usuario> usuarios = new Model.Finder(String.class, Usuario.class).all();
		return ok(toJson(usuarios));
	}
	
	public static Result logearmovil(){
		
		Map<String, String[]> a = request().body().asFormUrlEncoded();
		
		String username = a.get("username")[0];
		String password = a.get("password")[0];	
		
		try{
		Usuario usuario = (Usuario) new Model.Finder(String.class, Usuario.class).where().eq("email", username).findUnique();
		
		if(usuario.password.equals(password)){
			return ok();
		}
		
		}catch(Exception e){
			return badRequest();
		}
		
		return badRequest();
	}
	
}
