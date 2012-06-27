import java.sql.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author juancarlos
 * Clase donde manejamos la base de datos;
 *
 */
public class Bidi {

	
	Connection con;
	DefaultTableModel blop;
	private Statement st;
	private CallableStatement cs;

	public Bidi(String a, String b) throws ClassNotFoundException, SQLException {

//		String basedatos = "jdbc:postgresql://localhost:5432/dbmsys";
//		String driver = "org.postgresql.Driver";		

		String basedatos = "jdbc:mysql://localhost/dbmsys";
		String driver = "com.mysql.jdbc.Driver";

		Class.forName(driver);
		con = DriverManager.getConnection(basedatos, a, b);
		// DriverManager.registerDriver(new AppEngineDriver());

	};

	public String dameadmincontra(String a) throws SQLException {
		PreparedStatement steit = con
				.prepareStatement("select * from Empleado where Username = '"
						+ a + "';");
		ResultSet rs = steit.executeQuery();
		rs.next();
		String bli = rs.getString("Passwrd");
		rs.close();
		return bli;

	}

	public String damenombreusuario(String username) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement blo = con.prepareStatement("select * from Empleado where Username ='"
						+ username + "';");
		ResultSet rs = blo.executeQuery();
		rs.next();
		String bli = rs.getString("Nombre");

		return bli;
	};
	
	//Metodos para empleados

	public void borrarempleado(String numero) throws SQLException{
		PreparedStatement borrado = con.prepareStatement("delete from Empleado where NoEmpleado ="+numero+";");
		borrado.execute();
	}
	
	public void insertarempleado(String nombre, String apellidom,
			String apellidop, String calle, String ciudad, String estado,
			String string2, String pais, String email, String aprobado,
			String username, String password) throws SQLException {
		PreparedStatement maton = con
				.prepareStatement("insert into Empleado(Nombre,ApellidoM,ApellidoP,Calle,Ciudad,Estado,CP,Pais,Email,Aprobado,Username,Passwrd) values('"
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
		PreparedStatement holo = con
				.prepareStatement("select count(*) from empleado");
		ResultSet mm = holo.executeQuery();
		int conteo = mm.getInt("count");
		// int tamaño = mm.

		return conteo;
	};

	public DefaultTableModel regresamodelo() throws SQLException {
		PreparedStatement datines = con
				.prepareStatement("select * from Empleado order by NoEmpleado;");
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
		PreparedStatement bloooo = con.prepareStatement("select Nombre from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String nombre = rss.getString("Nombre");
		return nombre;
	}
	
	public String regresapellidop(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select ApellidoP from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String apellidop = rss.getString("ApellidoP");
		return apellidop;
	}

	public String regresapellidom(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select ApellidoM from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String apellidom = rss.getString("ApellidoM");
		return apellidom;
	}
	
	public String regresacalle(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Calle from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String calle = rss.getString("Calle");
		return calle;
	}
	
	public String regresaciudad(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Ciudad from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String ciudad = rss.getString("Ciudad");
		return ciudad;
	}
	public String regresaestado(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Estado from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String estado = rss.getString("Estado");
		return estado;
	}
	public String regresacp(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select CP from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String cp = rss.getString("CP");
		return cp;
	}
	
	public String regresapais(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Pais from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String cp = rss.getString("Pais");
		return cp;
	}
	
	public String regresaemail(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Email from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String email = rss.getString("Email");
		return email;
	}
	
	public String regresausuario(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Username from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String username = rss.getString("Username");
		return username;
	}
	
	public String regresapassword(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Passwrd from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String username = rss.getString("Passwrd");
		return username;
	}
	public String regresaprobacion(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Aprobado from Empleado where NoEmpleado = "+aa+";");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String aprobado = rss.getString("Aprobado");
		return aprobado;
	}
	
	public String regresaprobadoo(String aa) throws SQLException{
		PreparedStatement bloooo = con.prepareStatement("select Aprobado from Empleado where Username = '"+aa+"';");
		ResultSet rss = bloooo.executeQuery();
		rss.next();
		String aprobado = rss.getString("Aprobado");
		return aprobado;
	}

	public void modificarempleado(String indice,String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String aprobado, String text10,
			String text11) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement actualizanombre = con.prepareStatement("update Empleado set Nombre = '"+text+"' where NoEmpleado ="+indice+";");
		actualizanombre.execute();
		PreparedStatement actualizapellidop = con.prepareStatement("update Empleado set ApellidoP = '"+text2+"' where NoEmpleado ="+indice+";");
		actualizapellidop.execute();
		PreparedStatement actualizapellidom = con.prepareStatement("update Empleado set ApellidoP = '"+text3+"' where NoEmpleado ="+indice+";");
		actualizapellidom.execute();
		PreparedStatement actualizacalle = con.prepareStatement("update Empleado set Calle = '"+text4+"' where NoEmpleado ="+indice+";");
		actualizacalle.execute();
		PreparedStatement actualizaciudad = con.prepareStatement("update Empleado set Ciudad = '"+text5+"' where NoEmpleado ="+indice+";");
		actualizaciudad.execute();
		PreparedStatement actualizaestado = con.prepareStatement("update Empleado set Estado = '"+text6+"' where NoEmpleado ="+indice+";");
		actualizaestado.execute();
		PreparedStatement actualizacp = con.prepareStatement("update Empleado set CP = "+text7+" where NoEmpleado ="+indice+";");
		actualizacp.execute();
		PreparedStatement actualizapais = con.prepareStatement("update Empleado set Pais = '"+text8+"' where NoEmpleado ="+indice+";");
		actualizapais.execute();
		PreparedStatement actualizaemail = con.prepareStatement("update Empleado set Email = '"+text9+"' where NoEmpleado ="+indice+";");
		actualizaemail.execute();
		PreparedStatement actualizaprobado = con.prepareStatement("update Empleado set Aprobado = "+aprobado+" where NoEmpleado ="+indice+";");
		actualizaprobado.execute();
		PreparedStatement actualizausuario = con.prepareStatement("update Empleado set Username = '"+text10+"' where NoEmpleado ="+indice+";");
		actualizausuario.execute();
		PreparedStatement actualizacontraseña = con.prepareStatement("update Empleado set Passwrd = '"+text11+"' where NoEmpleado ="+indice+";");
		actualizacontraseña.execute();
		
	}
	
	
	
	public DefaultTableModel regresabusqueda(String d) throws SQLException {
		PreparedStatement datines = con
				.prepareStatement("select * from Empleado where Nombre = '"+d+"' order by NoEmpleado;");
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
		PreparedStatement datines = con
				.prepareStatement("select * from Proveedor order by NoProveedor;");
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
		PreparedStatement datines = con
				.prepareStatement("select NoProveedor,Nombre,ApellidoP,ApellidoM,Telefono from ProveedorTels natural join Proveedor order by NoProveedor;");
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
		PreparedStatement datines = con
				.prepareStatement("select NoProveedor,Nombre,ApellidoP,ApellidoM,Cargo,Compañia from ProveedorEmpresa natural join Proveedor order by NoProveedor;");
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
	
	public String insertaProveedor(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, char c) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("insert into Proveedor values("+string+",'"+string2+"','"+string3+"','"+string4+"','"+string5+"','"+string6+"','"+string7+"','"+string8+"',"+string9+",'"+string10+"','"+string11+"','"+string12+"','"+string13+"','1');");
		String ble = "insert into Proveedor values("+string+",'"+string2+"','"+string3+"','"+string4+"','"+string5+"','"+string6+"','"+string7+"',"+string8+",'"+string9+"','"+string10+"','"+string11+"','"+string12+"','"+string13+"');";
		insercion.execute();
		return ble;
	}

	public String insertaempresa(String text, String text3,
			String text4) throws SQLException {
				PreparedStatement insercion = con.prepareStatement("insert into ProveedorEmpresa values("+text+",'"+text3+"','"+text4+"');");
				String ejecucion = "insert into ProveedorEmpresa values("+text+",'"+text3+"','"+text4+"');";
				insercion.execute();
				return ejecucion;
		// TODO Auto-generated method stub
		
		
	}

	public String insertatelefono(String text, String text2) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement insercion = con.prepareStatement("insert into ProveedorTels values("+text+","+text2+");");
		String ejecucion = "insert into ProveedorTels values("+text+","+text2+");";
		insercion.execute();
		return ejecucion;
	}
	
	//comienzan los miles de metodos para regresar datos de proveedores para modificaciòn
	public String regresaID(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select NoProveedor from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("NoProveedor");
		return ble;
	}
	
	public String regresaPNombre(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Nombre from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Nombre");
		return ble;
	}
	
	public String regresaPApellidoP(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select ApellidoP from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("ApellidoP");
		return ble;
	}
	
	public String regresaPApellidoM(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select ApellidoM from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("ApellidoM");
		return ble;
	}
	
	public String regresaPCalle(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Calle from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Calle");
		return ble;
	}
	
	public String regresaPCiudad(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Ciudad from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Ciudad");
		return ble;
	}
	
	public String regresaPEstado(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Estado from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("estado");
		return ble;
	}
	
	public String regresaPCP(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("cp");
		return ble;
	}
	
	public String regresaPPais(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Pais");
		return ble;
	}
	
	public String regresaPEmail(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Email");
		return ble;
	}
	
	public String regresaPNotas(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Notas");
		return ble;
	}
	
	public String regresaPRFC(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("RFC");
		return ble;
	}
	
	public String regresaPPagina(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Proveedor where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("PaginaWeb");
		return ble;
	}
	
	public String regresaPTelefono(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from ProveedorTels where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Telefono");
		return ble;
	}
	
	public String regresaPCargo(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from ProveedorEmpresa where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Cargo");
		return ble;
	}
	
	public String regresaPEmpresa(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from ProveedorEmpresa where NoProveedor = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Compañia");
		return ble;
	}

	public void actualizaProveedor(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String text10, String text11,
			String text12, String text13, String indice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement actualizacion = con.prepareStatement("update Proveedor set NoProveedor = "+text+" where NoProveedor = "+indice+";");
		actualizacion.execute();
		PreparedStatement actualizacion2 = con.prepareStatement("update Proveedor set Nombre = '"+text2+"' where NoProveedor = "+indice+";");
		actualizacion2.execute();
		PreparedStatement actualizacion3 = con.prepareStatement("update Proveedor set ApellidoM = '"+text3+"' where NoProveedor = "+indice+";");
		actualizacion3.execute();
		PreparedStatement actualizacion4 = con.prepareStatement("update Proveedor set ApellidoP = '"+text4+"' where NoProveedor = "+indice+";");
		actualizacion4.execute();
		PreparedStatement actualizacion5 = con.prepareStatement("update Proveedor set Calle = '"+text5+"' where NoProveedor = "+indice+";");
		actualizacion5.execute();
		PreparedStatement actualizacion6 = con.prepareStatement("update Proveedor set Ciudad = '"+text6+"' where NoProveedor = "+indice+";");
		actualizacion6.execute();
		PreparedStatement actualizacion7 = con.prepareStatement("update Proveedor set Estado = '"+text7+"' where NoProveedor = "+indice+";");		
		actualizacion7.execute();
		PreparedStatement actualizacion8 = con.prepareStatement("update Proveedor set CP = "+text8+" where NoProveedor = "+indice+";");		
		actualizacion8.execute();
		PreparedStatement actualizacion9 = con.prepareStatement("update Proveedor set Pais = '"+text9+"' where NoProveedor = "+indice+";");		
		actualizacion9.execute();
		PreparedStatement actualizacion10 = con.prepareStatement("update Proveedor set Email = '"+text10+"' where NoProveedor = "+indice+";");		
		actualizacion10.execute();
		PreparedStatement actualizacion11 = con.prepareStatement("update Proveedor set Notas = '"+text11+"' where NoProveedor = "+indice+";");		
		actualizacion11.execute();
		PreparedStatement actualizacion12 = con.prepareStatement("update Proveedor set RFC = '"+text12+"' where NoProveedor = "+indice+";");		
		actualizacion12.execute();
		PreparedStatement actualizacion13 = con.prepareStatement("update Proveedor set PaginaWeb = '"+text13+"' where NoProveedor = "+indice+";");		
		actualizacion13.execute();
	}

	public void actualizaEmpresa(String text,String text3, String text4, String indice) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement actualizacion2 = con.prepareStatement("update ProveedorEmpresa set Cargo = '"+text3+"' where NoProveedor = "+indice+";");
		actualizacion2.execute();
		
		PreparedStatement actualizacion3 = con.prepareStatement("update ProveedorEmpresa set Compañia = '"+text4+"' where NoProveedor = "+indice+";");
		actualizacion3.execute();
		
		PreparedStatement actualizacion4 = con.prepareStatement("update ProveedorEmpresa set NoProveedor = "+text+" where NoProveedor = "+indice+";");
		actualizacion4.execute();
	}

	public void actualizatelefono(String text, String text2, String indice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement actualizacion = con.prepareStatement("update ProveedorTels set NoProveedor = "+text+" where NoProveedor = "+indice+";");
		actualizacion.execute();
		PreparedStatement actualizacion2 = con.prepareStatement("update ProveedorTels set Telefono = "+text2+" where NoProveedor = "+indice+";");
		actualizacion2.execute();
		
	}
	
	public void borrarProveedor(String a) throws SQLException{
		PreparedStatement borrado = con.prepareStatement("delete from Proveedor where NoProveedor="+a+";");
		borrado.execute();
		PreparedStatement borrado2 = con.prepareStatement("delete from ProveedorTels where NoProveedor="+a+";");
		borrado.execute();
		
	}
	
	public void borrarProveedorEmpresa(String a) throws SQLException{

		PreparedStatement borrado2 = con.prepareStatement("delete from ProveedorTels where NoProveedor="+a+";");
		borrado2.execute();
		PreparedStatement borrado3 = con.prepareStatement("delete from ProveedorEmpresa where NoProveedor="+a+";");
		borrado3.execute();
		PreparedStatement borrado = con.prepareStatement("delete from Proveedor where NoProveedor="+a+";");
		borrado.execute();
		
	}
	
	//Acaba los metodos para manejo de proveedores
	
	//Comienzan los metodos para manejo de clientes
	
	public DefaultTableModel regresamodelocliente() throws SQLException {
		PreparedStatement datines = con
				.prepareStatement("select nocliente,nombre,apellidom,apellidop,calle,ciudad,estado,cp,pais,email,rfc,descuentocliente,noempleado from empleadoatiendeclientes natural join cliente order by nocliente;");
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
	
	public DefaultTableModel regresamodelotransporte() throws SQLException {
		PreparedStatement datines = con
				.prepareStatement("select * from Transportista order by NoTransp;");
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

	public TableModel regresamodelotransportels() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement datines = con
				.prepareStatement("select * from TransportistaTels order by NoTransp;");
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
		

		return blop;	}

	public void insertatransporte(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String text10, String text11,
			String text12, String string, String string2, String string3) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement esteit = con.prepareStatement("insert into Transportista values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		int numerex = Integer.parseInt(text);
		esteit.setInt(1,numerex);
		esteit.setString(2,text2);
		esteit.setString(3, text3);
		esteit.setString(4, text4);
		esteit.setString(5, text5);
		esteit.setString(6, text6);
		esteit.setString(7, text7);
		esteit.setString(8, text8);
		int codiguex = Integer.parseInt(text9);
		esteit.setInt(9, codiguex);
		esteit.setString(10, text10);
		esteit.setString(11, text11);
		esteit.setString(12, text12);
		esteit.setString(13, string);
		esteit.setString(14, string2);
		esteit.setString(14, string3);
		esteit.execute();
		
	}

	public void insertatransportels(String text, String text2) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement esteit = con.prepareStatement("insert into TransportistaTels values(?,?);");
		int numerex = Integer.parseInt(text);
		esteit.setInt(1, numerex);
		int telefonex = Integer.parseInt(text2);
		esteit.setInt(2, telefonex);
		esteit.execute();
		
		
	}

	public String regresaCID(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select NoTransp from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("NoTransp");
		return ble;
	}
	
	public String regresaCNombre(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Nombre from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Nombre");
		return ble;
	}
	
	public String regresaCApellidoP(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select ApellidoP from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("ApellidoP");
		return ble;
	}
	
	public String regresaCApellidoM(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select ApellidoM from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("ApellidoM");
		return ble;
	}
	
	public String regresaCCalle(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Calle from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Calle");
		return ble;
	}
	
	public String regresaCCiudad(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Ciudad from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Ciudad");
		return ble;
	}
	
	public String regresaCEstado(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select Estado from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Estado");
		return ble;
	}
	
	public String regresaCCP(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("CP");
		return ble;
	}
	
	public String regresaCPais(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Pais");
		return ble;
	}
	
	public String regresaCEmail(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Email");
		return ble;
	}
	
	public String regresaCNotas(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Notas");
		return ble;
	}
	
	public String regresaCRFC(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("RFC");
		return ble;
	}
	
	public String regresaCPagina(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("PaginaWeb");
		return ble;
	}
	
	public String regresaCTelefono(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from TransportistaTels where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Telefono");
		return ble;
	}
	
	public String regresaCCargo(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Cargo");
		return ble;
	}
	
	public String regresaCEmpresa(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from Transportista where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Compañia");
		return ble;
	}
	
	public String regresaCTel(String indice) throws SQLException{
		PreparedStatement insercion = con.prepareStatement("select * from TransportistaTels where NoTransp = "+indice+";");
		ResultSet rs = insercion.executeQuery();
		rs.next();
		String ble = rs.getString("Telefono");
		return ble;
		
	}

	public void actualizaTransportista(String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String text10, String text11,
			String text12, String text13, String indice, String indice2) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement actualizanombre = con.prepareStatement("update Transportista set Nombre = '"+text2+"' where NoTransp ="+indice2+";");
		actualizanombre.execute();
		PreparedStatement actualizapellidop = con.prepareStatement("update Transportista set ApellidoP = '"+text3+"' where NoTransp ="+indice2+";");
		actualizapellidop.execute();
		PreparedStatement actualizapellidom = con.prepareStatement("update Transportista set ApellidoM = '"+text4+"' where NoTransp ="+indice2+";");
		actualizapellidom.execute();
		PreparedStatement actualizacalle = con.prepareStatement("update Transportista set Calle = '"+text5+"' where NoTransp ="+indice2+";");
		actualizacalle.execute();
		PreparedStatement actualizaciudad = con.prepareStatement("update Transportista set Ciudad = '"+text6+"' where NoTransp ="+indice2+";");
		actualizaciudad.execute();
		PreparedStatement actualizaestado = con.prepareStatement("update Transportista set Estado = '"+text7+"' where NoTransp ="+indice2+";");
		actualizaestado.execute();
		PreparedStatement actualizacp = con.prepareStatement("update Transportista set CP = "+text8+" where NoTransp ="+indice2+";");
		actualizacp.execute();
		PreparedStatement actualizapais = con.prepareStatement("update Transportista set Pais = '"+text9+"' where NoTransp ="+indice2+";");
		actualizapais.execute();
		PreparedStatement actualizaemail = con.prepareStatement("update Transportista set Cargo = '"+text10+"' where NoTransp ="+indice2+";");
		actualizaemail.execute();
		PreparedStatement actualizaprobado = con.prepareStatement("update Transportista set Compañia = '"+text11+"' where NoTransp ="+indice2+";");
		actualizaprobado.execute();
		PreparedStatement actualizausuario = con.prepareStatement("update Transportista set Email = '"+text12+"' where NoTransp ="+indice2+";");
		actualizausuario.execute();
		PreparedStatement actualizacontraseña = con.prepareStatement("update Transportista set Notas = '"+text13+"' where NoTransp ="+indice2+";");
		actualizacontraseña.execute();
		PreparedStatement actualizapagina = con.prepareStatement("update Transportista set PaginaWeb = '"+indice+"' where NoTransp ="+indice2+";");
		actualizapagina.execute();
	}

	public void actualizaTransportistatelefono(String text2,
			String indice) throws SQLException {
		// TODO Auto-generated method stubs
		PreparedStatement prr = con.prepareStatement("update TransportistaTels set Telefono = "+text2+" where NoTransp = "+indice+";");
		prr.execute();
		
	}

	public void borrarTransporte(String indice) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement prr = con.prepareStatement("delete from Transportista where NoTransp = "+indice+"");
		PreparedStatement prr1 = con.prepareStatement("delete from TransportistaTels where NoTransp = "+indice+"");
		prr.execute();
		prr1.execute();
		
	}
	
	public Statement getSt(){
		return st;
	}
	
	public ResultSet stNoParams(String st){
		try{
			cs = con.prepareCall("{call "+st+"}");
			ResultSet rs = cs.executeQuery();
			return rs;
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			return null;
		}
	}
	
	public int stClientParams(String st, String Nombre, String ApellidoM, String ApellidoP, String Pais, String Estado,
								String Ciudad, String Calle, int CP, String Email, String RFC, double Descuento){
		try{
			cs =con.prepareCall("{call "+st+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(1, Nombre);
			cs.setString(2, ApellidoM);
			cs.setString(3, ApellidoP);
			cs.setString(4, Pais);
			cs.setString(5, Estado);
			cs.setString(6, Ciudad);
			cs.setString(7, Calle);
			cs.setInt(8, CP);
			cs.setString(9, Email);
			cs.setString(10, RFC);
			cs.setDouble(11, Descuento);
			return cs.executeUpdate();
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public int stUpdateClient(String st,int NoCliente, String Nombre, String ApellidoM, String ApellidoP, String Pais, 
			String Estado,String Ciudad, String Calle, int CP, String Email, String RFC, double Descuento){
		try{
			cs =con.prepareCall("{call "+st+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setInt(1, NoCliente);
			cs.setString(2, Nombre);
			cs.setString(3, ApellidoM);
			cs.setString(4, ApellidoP);
			cs.setString(5, Pais);
			cs.setString(6, Estado);
			cs.setString(7, Ciudad);
			cs.setString(8, Calle);
			cs.setInt(9, CP);
			cs.setString(10, Email);
			cs.setString(11, RFC);
			cs.setDouble(12, Descuento);
			return cs.executeUpdate();
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}		
	}
	
	public int stDeleteClient(String st, int NoCliente){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setInt(1, NoCliente);
			return cs.executeUpdate();
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public ResultSet stSearchProduct(String st, String text){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setString(1, text);
			ResultSet rs = cs.executeQuery();
			return rs;
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return null;
		}
	}
	
	public ResultSet stSelectProduct(String st, int idProd){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setInt(1, idProd);
			ResultSet rs = cs.executeQuery();
			return rs;
		} catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return null;
		}
	}
	
	public int stInsertPedido(String st, String Estado, String TipoPago, int NoCliente, String NoGuia,
							Double Importe, Double Total, java.sql.Date FechaPago, String Notas, java.sql.Date FechaRecepcion, 
							java.sql.Date FechaPrevista, java.sql.Date FechaTentativa){
		try{
			cs = con.prepareCall("{call "+st+"( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(1, Estado);
			cs.setString(2, TipoPago);
			cs.setInt(3, NoCliente);
			cs.setString(4, NoGuia);
			cs.setDouble(5, Importe);
			cs.setDouble(6, Total);
			if(FechaPago == null){
				cs.setDate(7, null);
			} else {
				cs.setDate(7, FechaPago);
			}
			cs.setString(8, Notas);
			if(FechaRecepcion == null){
				cs.setDate(9, null);
			} else {
				cs.setDate(9, FechaRecepcion);
			}
			if(FechaPrevista == null){
				cs.setDate(10, null);
			} else {
				cs.setDate(10, FechaPrevista);
			}
			if(FechaTentativa == null){
				cs.setDate(11, null);
			} else {
				cs.setDate(11, (java.sql.Date)FechaTentativa);
			}
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public int stUpdatePedido(String st, int NoPedido, String Estado, String TipoPago, int NoCliente, String NoGuia, 
							Double Importe, Double Total, java.sql.Date FechaPago, String Notas, java.sql.Date FechaRecepcion, 
							java.sql.Date FechaPrevista, java.sql.Date FechaTentativa){
		try{
			cs = con.prepareCall("{call "+st+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setInt(1, NoPedido);
			cs.setString(2, Estado);
			cs.setString(3, TipoPago);
			cs.setInt(4, NoCliente);
			cs.setString(5, NoGuia);
			cs.setDouble(6, Importe);
			cs.setDouble(7, Total);
			if(FechaPago == null){
				cs.setDate(8, null);
			} else {
				cs.setDate(8, FechaPago);
			}
			cs.setString(9, Notas);
			if(FechaRecepcion == null){
				cs.setDate(10, null);
			} else {
				cs.setDate(10, FechaRecepcion);
			}
			if(FechaPrevista == null){
				cs.setDate(11, null);
			} else {
				cs.setDate(11, FechaPrevista);
			}
			if(FechaTentativa == null){
				cs.setDate(12, null);
			} else { 
				cs.setDate(12, FechaTentativa);
			}
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public int stDeletePedido(String st, int NoPedido){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setInt(1, NoPedido);
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public int stInsertProPedido(String st, int NoProducto, int NoPedido, int Cantidad, double Descuento){
		try{
			cs = con.prepareCall("{call "+st+"(?, ?, ?, ?)}");
			cs.setInt(1, NoProducto);
			cs.setInt(2, NoPedido);
			cs.setInt(3, Cantidad);
			cs.setDouble(4, Descuento);
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public int stDeleteAllProPedido(String st, int NoPedido){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setInt(1, NoPedido);
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
	public ResultSet stSelectLastPedido(String st){
		try{
			cs = con.prepareCall("{call "+st+"()}");
			return cs.executeQuery();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return null;
		}
	}
	
	public int stDeleteSpProdPedido(String st, int NoPedido){
		try{
			cs = con.prepareCall("{call "+st+"(?)}");
			cs.setInt(1, NoPedido);
			return cs.executeUpdate();
		}catch(SQLException sqlEx){
			sqlEx.getStackTrace();
			System.out.println(sqlEx.getCause());
			System.out.println(sqlEx.getMessage());
			return -1;
		}
	}
	
}