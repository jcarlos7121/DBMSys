package controllers;

import java.util.List;
import java.util.Map;

import models.Articulo;
import models.Funcion;
import models.Usuario;
import models.Pelicula;
import static play.libs.Json.toJson;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;

public class MovieController extends Controller {
	
	public static Result Peliculas(){
	
		List<Pelicula> peliculas = new Model.Finder(String.class, Pelicula.class).all();
		return ok(toJson(peliculas));	
		
	}
	
	public static Result Pelicula(){

		Map<String, String[]> mapaderequest = request().body().asFormUrlEncoded();
		String nombresin = mapaderequest.get("nombrepelicula")[0];
		Pelicula peliculaabuscar = (Pelicula) new Model.Finder(String.class, Pelicula.class).where().eq("nombre",nombresin).findUnique();
		System.out.println("La pelicula que buscas es: " + peliculaabuscar.nombre);
		List<Funcion> funciones = new Model.Finder(String.class, Funcion.class).where().eq("pelicula_movie_id", peliculaabuscar.MovieId).findList();
		
		System.out.println("Respuesta en json " + toJson(funciones));
		return ok(toJson(funciones));
		
	}
	
	public static Result registrarpelicula(){
		Map<String, String[]> a = request().body().asFormUrlEncoded();
		
		try{
		
			String nombre = a.get("nombre")[0];
			String categoria = a.get("categoria")[0];
			String duracion = a.get("duracion")[0];
			String sinopsis = a.get("sinopsis")[0];
			String imagen = a.get("imagen")[0];
			
			Pelicula nueva = new Pelicula();
			nueva.nombre = nombre;
			nueva.categoria = categoria;
			nueva.duracion = duracion;
			nueva.sinopsis = sinopsis;
			nueva.imagenurl = imagen;
			
			nueva.save();
			
			return ok();
		}catch(Exception e ){
			return badRequest();
		}
		
		
	}
	
	public static Result registrarfuncion(){
		
Map<String, String[]> a = request().body().asFormUrlEncoded();
		
		try{
		
			String sala = a.get("salafuncion")[0];
			String nombrep = a.get("nombrepelicula")[0];
			String horaini = a.get("horainicio")[0];
			String horatermino = a.get("horatermino")[0];
			String tipo = a.get("tiposala")[0];
			
			Pelicula peli =  (models.Pelicula) new Model.Finder(String.class, Pelicula.class).where().eq("nombre", nombrep).findUnique();
			
			Funcion fun = new Funcion();
			fun.pelicula = peli;
			fun.sala = sala;
			fun.Hora_inicio = horaini;
			fun.Hora_fin = horatermino;
			fun.tipo_sala = tipo;
			fun.save();
			
			Articulo art = new Articulo();
			art.funcion = fun;
			art.nombre = "Boleto" + tipo;
			
			if(art.nombre.equals("Boleto VIP")){
				art.preciounitario = 50.0;
			}else{
				art.preciounitario = 30.0;
			}
			art.save();
			
			return ok();
		}catch(Exception e ){
			return badRequest();
		}
		
		
	}

}
