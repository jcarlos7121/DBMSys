package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("ble","nopresente"));
  }
  
  public static Result promociones(){
	return TODO;
	  
  }
  
  public static Result contacto(){
	return TODO;
  }
  
  public static Result acercade(){
	return TODO;
	  
  }
  
  public static Result terminos(){
	  return TODO;
  }
  
  public static Result poliza(){
	  return TODO;
  }
  
  
}