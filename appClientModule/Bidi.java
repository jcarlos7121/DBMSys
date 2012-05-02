import java.sql.*;

import javax.swing.table.DefaultTableModel;

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
				.prepareStatement("select * from empleado;");
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
		String nombre = rss.getString("nombre");
		return nombre;
	}
	
	public String regresapellidop(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select apellidop from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String apellidop = rss.getString("apellidop");
		return apellidop;
	}

	public String regresapellidom(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select apellidom from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String apellidom = rss.getString("apellidom");
		return apellidom;
	}
	
	public String regresacalle(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select calle from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String calle = rss.getString("calle");
		return calle;
	}
	
	public String regresaciudad(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select ciudad from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String ciudad = rss.getString("ciudad");
		return ciudad;
	}
	public String regresaestado(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select estado from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String estado = rss.getString("estado");
		return estado;
	}
	public String regresacp(String aa) throws SQLException{
		PreparedStatement bloooo = conect.prepareStatement("select cp from empleado where noempleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		String cp = rss.getString("cp");
		return cp;
	}
	
}