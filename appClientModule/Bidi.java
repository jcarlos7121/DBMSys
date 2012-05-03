import java.sql.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author juancarlos
 * Clase donde manejamos la base de datos;
 *
 */
public class Bidi {

	
	Connection conect;
	DefaultTableModel blop;

	public Bidi(String a, String b) throws ClassNotFoundException, SQLException {

		String basedatos = "jdbc:postgresql://localhost:5432/dbmsys";
		String driver = "org.postgresql.Driver";

		Class.forName(driver);
		conect = DriverManager.getConnection(basedatos, a, b);
		// DriverManager.registerDriver(new AppEngineDriver());

	};

	public String dameadmincontra(String a) throws SQLException {
		PreparedStatement steit = conect
				.prepareStatement("Select * from empleado where username = '"
						+ a + "';");
		ResultSet rs = steit.executeQuery();
		rs.next();
		String bli = rs.getString("password");
		rs.close();
		return bli;

	}

	public String damenombreusuario(String username) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement blo = conect.prepareStatement("select * from empleado where username ='"
						+ username + "';");
		ResultSet rs = blo.executeQuery();
		rs.next();
		String bli = rs.getString("nombre");

		return bli;
	};
	
	//Metodos para empleados

	public void borrarempleado(String numero) throws SQLException{
		PreparedStatement borrado = conect.prepareStatement("delete from empleado where noempleado ="+numero+";");
		borrado.execute();
	}
	
	public void insertarempleado(String nombre, String apellidom,
			String apellidop, String calle, String ciudad, String estado,
			String string2, String pais, String email, String aprobado,
			String username, String password) throws SQLException {
		PreparedStatement maton = conect
				.prepareStatement("insert into empleado(nombre,apellidom,apellidop,calle,ciudad,estado,cp,pais,email,aprobado,username,password) values('"
						+ nombre
						+ "','"
						+ apellidop
						+ "','"
						+ apellidom
						+ "','"
						+ calle
						+ "','"
						+ ciudad
						+ "','"
						+ estado
						+ "',"
						+ string2
						+ ",'"
						+ pais
						+ "','"
						+ email
						+ "',"
						+ aprobado + ",'" + username + "','" + password + "');");
		maton.execute();
	};

	public int regresatamaño() throws SQLException {
		PreparedStatement holo = conect
				.prepareStatement("select count(*) from empleado");
		ResultSet mm = holo.executeQuery();
		int conteo = mm.getInt("count");
		// int tamaño = mm.

		return conteo;
	};

	public DefaultTableModel regresamodelo() throws SQLException {
		PreparedStatement datines = conect
				.prepareStatement("select * from empleado order by noempleado;");
		ResultSet datiness = datines.executeQuery();
		ResultSetMetaData ble = datiness.getMetaData();
		blop = new DefaultTableModel();

		int columnas = ble.getColumnCount();
		String[] nombrecol = new String[columnas];
		for (int i = 1; i <= columnas; i++) {
			nombrecol[i - 1] = ble.getColumnName(i);
		}
		blop.setColumnIdentifiers(nombrecol);

		while (datiness.next()) {
			String[] rowData = new String[columnas];
			for (int i = 1; i <= columnas; i++) {
				rowData[i - 1] = datiness.getString(i);
			}
			blop.addRow(rowData);
		}
		datiness.close();
		

		return blop;

	}
	
	/**
	 * @return nombredelempleado
	 * apartir de esta parte cada metodo nos regresa cierto valor de cada empleado en particular.
	 * @throws SQLException 
	 */
	public String regresanombreempleado(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select nombre from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String nombre = rss.getString("nombre");
		return nombre;
	}
	
	public String regresapellidop(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select apellidop from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String apellidop = rss.getString("apellidop");
		return apellidop;
	}

	public String regresapellidom(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select apellidom from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String apellidom = rss.getString("apellidom");
		return apellidom;
	}
	
	public String regresacalle(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select calle from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String calle = rss.getString("calle");
		return calle;
	}
	
	public String regresaciudad(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select ciudad from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String ciudad = rss.getString("ciudad");
		return ciudad;
	}
	public String regresaestado(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select estado from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String estado = rss.getString("estado");
		return estado;
	}
	public String regresacp(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select cp from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String cp = rss.getString("cp");
		return cp;
	}
	
	public String regresapais(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select pais from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String cp = rss.getString("pais");
		return cp;
	}
	
	public String regresaemail(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select email from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String email = rss.getString("email");
		return email;
	}
	
	public String regresausuario(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select username from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String username = rss.getString("username");
		return username;
	}
	
	public String regresapassword(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select password from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String username = rss.getString("password");
		return username;
	}
	public String regresaprobacion(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select aprobado from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String aprobado = rss.getString("aprobado");
		return aprobado;
	}
	
	public String regresaprobadoo(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select aprobado from empleado where username = '"+aa+"';");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String aprobado = rss.getString("aprobado");
		return aprobado;
	}

	public void modificarempleado(String indice,String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String aprobado, String text10,
			String text11) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement actualizanombre = conect.prepareStatement("update empleado set nombre = '"+text+"' where noempleado ="+indice+";");
		actualizanombre.execute();
		PreparedStatement actualizapellidop = conect.prepareStatement("update empleado set apellidop = '"+text2+"' where noempleado ="+indice+";");
		actualizapellidop.execute();
		PreparedStatement actualizapellidom = conect.prepareStatement("update empleado set apellidop = '"+text3+"' where noempleado ="+indice+";");
		actualizapellidom.execute();
		PreparedStatement actualizacalle = conect.prepareStatement("update empleado set calle = '"+text4+"' where noempleado ="+indice+";");
		actualizacalle.execute();
		PreparedStatement actualizaciudad = conect.prepareStatement("update empleado set ciudad = '"+text5+"' where noempleado ="+indice+";");
		actualizaciudad.execute();
		PreparedStatement actualizaestado = conect.prepareStatement("update empleado set estado = '"+text6+"' where noempleado ="+indice+";");
		actualizaestado.execute();
		PreparedStatement actualizacp = conect.prepareStatement("update empleado set cp = "+text7+" where noempleado ="+indice+";");
		actualizacp.execute();
		PreparedStatement actualizapais = conect.prepareStatement("update empleado set pais = '"+text8+"' where noempleado ="+indice+";");
		actualizapais.execute();
		PreparedStatement actualizaemail = conect.prepareStatement("update empleado set email = '"+text9+"' where noempleado ="+indice+";");
		actualizaemail.execute();
		PreparedStatement actualizaprobado = conect.prepareStatement("update empleado set aprobado = "+aprobado+" where noempleado ="+indice+";");
		actualizaprobado.execute();
		PreparedStatement actualizausuario = conect.prepareStatement("update empleado set username = '"+text10+"' where noempleado ="+indice+";");
		actualizausuario.execute();
		PreparedStatement actualizacontraseña = conect.prepareStatement("update empleado set password = '"+text11+"' where noempleado ="+indice+";");
		actualizacontraseña.execute();
		
	}
	
	
	
	public DefaultTableModel regresabusqueda(String d) throws SQLException {
		PreparedStatement datines = conect
				.prepareStatement("select * from empleado where nombre = '"+d+"' order by noempleado;");
		ResultSet datiness = datines.executeQuery();
		ResultSetMetaData ble = datiness.getMetaData();
		blop = new DefaultTableModel();

		int columnas = ble.getColumnCount();
		String[] nombrecol = new String[columnas];
		for (int i = 1; i <= columnas; i++) {
			nombrecol[i - 1] = ble.getColumnName(i);
		}
		blop.setColumnIdentifiers(nombrecol);

		while (datiness.next()) {
			String[] rowData = new String[columnas];
			for (int i = 1; i <= columnas; i++) {
				rowData[i - 1] = datiness.getString(i);
			}
			blop.addRow(rowData);
		}
		datiness.close();
		

		return blop;

	}
	//Terminan Metodos para empleados
	
	//Comienzan Metodos para Proveedores...
	
	//Modelo de la tabla
	public DefaultTableModel regresamodeloproveedor() throws SQLException {
		PreparedStatement datines = conect
				.prepareStatement("select * from proveedor;");
		ResultSet datiness = datines.executeQuery();
		ResultSetMetaData ble = datiness.getMetaData();
		blop = new DefaultTableModel();

		int columnas = ble.getColumnCount();
		String[] nombrecol = new String[columnas];
		for (int i = 1; i <= columnas; i++) {
			nombrecol[i - 1] = ble.getColumnName(i);
		}
		blop.setColumnIdentifiers(nombrecol);

		while (datiness.next()) {
			String[] rowData = new String[columnas];
			for (int i = 1; i <= columnas; i++) {
				rowData[i - 1] = datiness.getString(i);
			}
			blop.addRow(rowData);
		}
		datiness.close();
		

		return blop;

	}

	public TableModel regresamodeloproveedortels() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement datines = conect
				.prepareStatement("select noproveedor,nombre,apellidop,apellidom,telefono from proveedortels natural join proveedor;");
		ResultSet datiness = datines.executeQuery();
		ResultSetMetaData ble = datiness.getMetaData();
		blop = new DefaultTableModel();

		int columnas = ble.getColumnCount();
		String[] nombrecol = new String[columnas];
		for (int i = 1; i <= columnas; i++) {
			nombrecol[i - 1] = ble.getColumnName(i);
		}
		blop.setColumnIdentifiers(nombrecol);

		while (datiness.next()) {
			String[] rowData = new String[columnas];
			for (int i = 1; i <= columnas; i++) {
				rowData[i - 1] = datiness.getString(i);
			}
			blop.addRow(rowData);
		}
		datiness.close();
		

		return blop;
	}
	public TableModel regresamodeloempresa() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement datines = conect
				.prepareStatement("select noproveedor,nombre,apellidop,apellidom,empresapersona,cargo,compañia from proveedorempresa natural join proveedor;");
		ResultSet datiness = datines.executeQuery();
		ResultSetMetaData ble = datiness.getMetaData();
		blop = new DefaultTableModel();

		int columnas = ble.getColumnCount();
		String[] nombrecol = new String[columnas];
		for (int i = 1; i <= columnas; i++) {
			nombrecol[i - 1] = ble.getColumnName(i);
		}
		blop.setColumnIdentifiers(nombrecol);

		while (datiness.next()) {
			String[] rowData = new String[columnas];
			for (int i = 1; i <= columnas; i++) {
				rowData[i - 1] = datiness.getString(i);
			}
			blop.addRow(rowData);
		}
		datiness.close();
		

		return blop;
	}
	//Termina la definiciòn de modelos del empleado
	//Metodos para inserciòn a base de datos de proveedores
	
}