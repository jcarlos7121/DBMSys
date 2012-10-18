package controllers;

import java.util.List;
import java.util.Map;

import com.avaje.ebean.annotation.Where;

import models.Articulo;
import models.Compra;
import models.Pedido;
import models.Usuario;

import static play.libs.Json.toJson;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;

public class PedidoController extends Controller {
	
	public static Result compras(){
		
		Map<String, String[]> a = request().body().asFormUrlEncoded();
		
		try{
			String funcion = a.get("funcionselect")[0];
			String username = a.get("user")[0];
			double cantidadboletos =Double.parseDouble(a.get("cantidadboletos")[0]);
			double cantidadpalomitas = Double.parseDouble(a.get("cantidadpalomitas")[0]);
			double cantidadrefresco = Double.parseDouble(a.get("cantidadrefresco")[0]);
			double cantidadnachos = Double.parseDouble(a.get("cantidadnachos")[0]);
			
			Usuario usuario = (Usuario) new Model.Finder(String.class, Usuario.class).where().eq("userid", username).findUnique();

			Articulo boleto = (Articulo) new Model.Finder(String.class, Articulo.class).where().eq("funcion_funcion_id", funcion).findUnique();
			Articulo palomitas = (Articulo) new Model.Finder(String.class,Articulo.class).where().eq("nombre", "Palomitas").findUnique();
			Articulo Refresco = (Articulo) new Model.Finder(String.class,Articulo.class).where().eq("nombre", "Refresco").findUnique();	
			Articulo Nachos = (Articulo) new Model.Finder(String.class,Articulo.class).where().eq("nombre", "Nachos").findUnique();

			Double total = (double) 0;
			
			Pedido pedido = new Pedido();
			pedido.usuario = usuario;
			pedido.pagado = false;
			
			if(cantidadboletos !=0){
				Compra compracoka = new Compra();
				compracoka.Articulo = boleto;
				compracoka.Pedido = pedido;
				compracoka.Cantidad = cantidadboletos;
				compracoka.Total = cantidadboletos * boleto.preciounitario;
				total = total + compracoka.Total;
				compracoka.save();
			}
			
			if(cantidadpalomitas != 0){
				Compra comprapalomas = new Compra();
				comprapalomas.Articulo = palomitas;
				comprapalomas.Pedido = pedido;
				comprapalomas.Cantidad = cantidadpalomitas;
				comprapalomas.Total = cantidadpalomitas * palomitas.preciounitario;
				total = total + comprapalomas.Total;
				comprapalomas.save();
			}
			
			if(cantidadnachos != 0){
				Compra compranachos = new Compra();
				compranachos.Articulo = Nachos;
				compranachos.Pedido = pedido;
				compranachos.Cantidad = cantidadnachos;
				compranachos.Total = cantidadnachos * Nachos.preciounitario;
				total = total + compranachos.Total;
				compranachos.save();
			}
			
			if(cantidadrefresco != 0){
				Compra comprarefresco = new Compra();
				comprarefresco.Articulo = Refresco;
				comprarefresco.Cantidad = cantidadrefresco;
				comprarefresco.Pedido = pedido;
				comprarefresco.Total = cantidadrefresco * Refresco.preciounitario;
				total = total + (cantidadrefresco * Refresco.preciounitario);
				comprarefresco.save();
			}
			
			pedido.total = total;
			pedido.save();
			return ok();
		}catch(Exception e){
			e.printStackTrace();
			return  badRequest();
		}
		
	}

	public static Result mispedidos(){
		Map<String, String[]> wi = request().body().asFormUrlEncoded();
		
		String user = wi.get("usuario")[0];
		
		Usuario ble = (Usuario) new Model.Finder(String.class, Usuario.class).where().eq("email", user).findUnique();
		List<Pedido> pedidos = new Model.Finder(String.class, Pedido.class).where().eq("usuario_userid ", ble.Userid).findList();

		return ok(toJson(pedidos));
	}
}
