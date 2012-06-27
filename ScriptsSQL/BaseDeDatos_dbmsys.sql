SET NAMES utf8;


/**** BASE DE DATOS ****/
CREATE DATABASE dbmsys;
USE dbmsys;


/**** TABLAS ****/

/* Clientes */
CREATE TABLE Cliente(
	NoCliente INT AUTO_INCREMENT NOT NULL, 
	Nombre VARCHAR(30) NOT NULL,
	ApellidoM VARCHAR(30) NOT NULL,
	ApellidoP VARCHAR(30) NOT NULL,
	Pais VARCHAR(20),
	Estado VARCHAR(20),
	Ciudad VARCHAR(20),
	Calle VARCHAR(30),
	CP INT,
	Email VARCHAR(50) UNIQUE NOT NULL,
	RFC VARCHAR(30),
	DescuentoCliente DECIMAL(8, 2) DEFAULT 0.0,
	TipoCliente CHAR,
	PRIMARY KEY CliPK (NoCliente)
);


CREATE TABLE ClienteTels(
	NoCliente INT NOT NULL, 
	Telefono DECIMAL(8, 2) UNIQUE NOT NULL,
	FOREIGN KEY CliTelsFK (NoCliente) REFERENCES Cliente(NoCliente),
	PRIMARY KEY CliTelsPK (NoCliente, Telefono)
);


/* Cliente Empresa */
CREATE TABLE ClienteEmpresa(
	NoCliente INT NOT NULL, 
	Cargo VARCHAR(20), 
	Compañia VARCHAR(20) NOT NULL,
	FOREIGN KEY CliEmFK (NoCliente) REFERENCES Cliente(NoCLiente),
	PRIMARY KEY CliEmPK (NoCliente, Compañia)
);


/* Empleados */
CREATE TABLE Empleado(
	NoEmpleado INT AUTO_INCREMENT NOT NULL, 
	Username VARCHAR(30) UNIQUE NOT NULL,
	Passwrd VARCHAR(30) NOT NULL,
	Nombre VARCHAR(20) NOT NULL, 
	ApellidoM VARCHAR(30) NOT NULL,
	ApellidoP VARCHAR(30) NOT NULL,
	Pais VARCHAR(20), 	
	Estado VARCHAR(10), 
	Ciudad VARCHAR(20), 
	Calle VARCHAR(30),
	CP INT, 	
	Cargo VARCHAR(20), 
	Email VARCHAR(20) UNIQUE NOT NULL, 
	Notas VARCHAR(100), 
	Imagen BLOB,
	PRIMARY KEY EmpPK (NoEmpleado)
);


CREATE TABLE EmpleadoTels(
	NoEmpleado INT NOT NULL, 
	Telefono DECIMAL(10, 2) UNIQUE NOT NULL,
	FOREIGN KEY EmpTelsFK (NoEmpleado) REFERENCES Empleado(NoEmpleado),
	PRIMARY KEY EmpTelsPK (NoEmpleado, Telefono)
);


CREATE TABLE EmpleadoAtiendeClientes(
	NoCliente INT NOT NULL,
	NoEmpleado INT NOT NULL,
	FechaAtendido DATE NOT NULL,
	FOREIGN KEY EmpACliFKCli (NoCliente) REFERENCES Cliente(NoCliente),
	FOREIGN KEY EmpACliFKEmp (NoEmpleado) REFERENCES Empleado(NoEmpleado),
	PRIMARY KEY EmpACliPK (NoCliente, FechaAtendido)
);


/* Proveedores */
CREATE TABLE Proveedor(
	NoProveedor INT AUTO_INCREMENT NOT NULL, 
	Nombre VARCHAR(20) NOT NULL, 
	ApellidoM VARCHAR(30) NOT NULL, 
	ApellidoP VARCHAR(30) NOT NULL,
	Pais VARCHAR(20),
	Estado VARCHAR(20), 
	Ciudad VARCHAR(20), 
	Calle VARCHAR(20), 
	CP INT,
	Email VARCHAR(50) UNIQUE NOT NULL, 
	Notas VARCHAR(100), 
	RFC VARCHAR(20), 
	PaginaWeb VARCHAR(20),
	TipoProv CHAR,
	PRIMARY KEY ProvPK (NoProveedor)
);


CREATE TABLE ProveedorTels(
	NoProveedor INT NOT NULL, 
	Telefono DECIMAL(10, 2) UNIQUE NOT NULL,
	FOREIGN KEY ProvTelsFK (NoProveedor) REFERENCES Proveedor(NoProveedor),
	PRIMARY KEY ProvTelsPK (NoProveedor, Telefono) 
);


/*Proveedor Empresa */
CREATE TABLE ProveedorEmpresa(
	NoProveedor INT NOT NULL, 
	Cargo VARCHAR(20), 
	Compañia VARCHAR(20),
	FOREIGN KEY ProvEmpFK (NoProveedor) REFERENCES Proveedor(NoProveedor),
	PRIMARY KEY ProvEmpPK (NoProveedor, Compañia)
);


/* Transportistas */
CREATE TABLE Transportista(
	NoTransp INT AUTO_INCREMENT NOT NULL, 
	Nombre VARCHAR(30) NOT NULL, 
	ApellidoM VARCHAR(30) NOT NULL, 
	ApellidoP VARCHAR(30) NOT NULL, 
	Pais VARCHAR(20), 
	Estado VARCHAR(20), 
	Ciudad VARCHAR(20), 
	Calle VARCHAR(20),
	CP INT, 
	Cargo VARCHAR(20), 
	Compañia VARCHAR(20) NOT NULL, 
	Email VARCHAR(50) UNIQUE NOT NULL, 
	Notas VARCHAR(100), 
	PaginaWeb VARCHAR(30),
	PRIMARY KEY TranspPK (NoTransp)
);

CREATE TABLE TransportistaTels(
	NoTransp INT NOT NULL,
	Telefono DECIMAL(10) UNIQUE NOT NULL,
	FOREIGN KEY TranspTelsFK (NoTransp) REFERENCES Transportista(NoTransp),
	PRIMARY KEY TranspTelsPK (NoTransp, Telefono)
);


/* Transportista Proveedor */
CREATE TABLE ProvEligeTransp(
	NoProveedor INT NOT NULL, 
	NoTransp INT NOT NULL, 
	Notas VARCHAR(100),
	FOREIGN KEY ProvTranspFKprov (NoProveedor) REFERENCES Proveedor(NoProveedor),
	FOREIGN KEY ProvTranspFKtransp (NoTransp) REFERENCES Transportista(NoTransp),
	PRIMARY KEY ProvTranspPK (NoProveedor, NoTransp)
);


/* Pedidos */
CREATE TABLE Pedido(
	NoPedido INT AUTO_INCREMENT NOT NULL, 
	FechaPedido TIMESTAMP DEFAULT NOW(), 
	Estado VARCHAR(20) NOT NULL, 
	TipoPago VARCHAR(30),
	NoCliente INT,
	NoTransp INT,
	NoGuia VARCHAR(50),
	Impuesto DECIMAL(7, 2), 
	Total DECIMAL(7, 2),
	FechaPago DATE,
	Notas VARCHAR(100),
	FechaRecepcion DATE DEFAULT NULL, 
	FechaPrevista DATE DEFAULT NULL, 
	FechaTentativa DATE DEFAULT NULL,
	PRIMARY KEY PedPK (NoPedido),
	FOREIGN KEY PedFKcli (NoCliente) REFERENCES Cliente(NoCliente),
	FOREIGN KEY PedFKtrans (NoTransp) REFERENCES Transportista(NoTransp)
);


/* Productos */
CREATE TABLE Producto(
	NoProducto INT AUTO_INCREMENT NOT NULL,
	Nombre VARCHAR(30) NOT NULL,
	Cantidad INT NOT NULL,
	Descripcion VARCHAR(50),
	Costo DECIMAL(10, 2),
	Suspendido CHAR NOT NULL,
	Categoria VARCHAR(30) NOT NULL,
	PuntoPedido INT NOT NULL,
	NivelObjetivo INT,
	TipoProd CHAR,
	PRIMARY KEY ProdPK (NoProducto)
);


/* Producto Pedido */
CREATE TABLE ProductoPedido(
	NoProducto INT NOT NULL,
	NoPedido INT NOT NULL,
	Cantidad INT NOT NULL,
	Descuento DECIMAL(10, 2),
	FOREIGN KEY ProdPedFKprod (NoProducto) REFERENCES Producto(NoProducto),
	FOREIGN KEY ProdPedFKped (NoPedido) REFERENCES Pedido(NoPedido),
	PRIMARY KEY ProdPedPK (NoProducto, NoPedido)
);


/* Producto Proveedor */
CREATE TABLE ProductoProveedor(
	NoProducto INT NOT NULL,
	NoProveedor INT NOT NULL,
	Costo DECIMAL (10, 2) NOT NULL,
	Cantidad INT NOT NULL,
	Notas VARCHAR(50),
	FOREIGN KEY ProdProvFKprod (NoProducto) REFERENCES Producto(NoProducto),
	FOREIGN KEY ProdProvFKprov (NoProveedor) REFERENCES Proveedor(NoProveedor)
);



/**** STORED PROCEDURES ****/

/* Empleado - Usuario Contraseña */

DELIMITER //
CREATE PROCEDURE VerifyUser(IN username VARCHAR(30), pass VARCHAR(30))
	BEGIN
		SELECT Username, Passwrd FROM Empleado
			WHERE Username = username && Passwrd = pass;
	END
// DELIMITER ;


/* Seleccionar todos los empleados */
DELIMITER //
CREATE PROCEDURE SelectAllEmps()
	BEGIN
		SELECT * FROM Empleado;
	END
// DELIMITER ;

/* Clientes */

DELIMITER //
CREATE PROCEDURE SelectAllClients()
	BEGIN
		SELECT * FROM Cliente;
	END
// DELIMITER ;
 

/* Insertar nuevo cliente */
DELIMITER //
CREATE PROCEDURE InsertClient(
	_Nombre VARCHAR(30),
	_ApellidoM VARCHAR(30),
	_ApellidoP VARCHAR(30),
	_Pais VARCHAR(20),
	_Estado VARCHAR(20),
	_Ciudad VARCHAR(20),
	_Calle VARCHAR(30),
	_CP INT(11),
	Email VARCHAR(50),
	RFC VARCHAR(30),
	DescuentoCliente DECIMAL(8, 2),
)
BEGIN
	INSERT INTO Cliente(Nombre, ApellidoM, ApellidoP, Pais, Estado, Ciudad, Calle, CP, Email, RFC, Descuento)
		VALUES(_Nombre, _ApellidoM, _ApellidoP, _Pais, _Estado, _Ciudad, _Calle, _CP, _Email, _RFC, _Descuento);
END //
DELIMITER ;


/* Modificar cliente existente */
DELIMITER //
CREATE PROCEDURE UpdateClient(
	_NoCliente INT(11),
	_Nombre VARCHAR(30),
	_ApellidoM VARCHAR(30),
	_ApellidoP VARCHAR(30),
	_Pais VARCHAR(20),
	_Estado VARCHAR(20),
	_Ciudad VARCHAR(20),
	_Calle VARCHAR(20),
	_CP INT(11),
	_Email VARCHAR(50),
	_RFC VARCHAR(30),
	_DescuentoCliente DECIMAL(8, 2)
)
BEGIN
	UPDATE Cliente SET Nombre=_Nombre, ApellidoM=_ApellidoM, ApellidoP=_ApellidoP, Pais=_Pais, Estado=_Estado, Ciudad=_Ciudad, 
					   Calle=_Ciudad, CP=_CP, Email=_Email, RFC=_RFC, DescuentoCliente=_DescuentoCliente	
						WHERE NoCliente=_NoCliente;
END //
DELIMITER ;


/* Borrar Cliente */
DELIMITER //
CREATE PROCEDURE DeleteClient(_NoCliente INT(11))
BEGIN
	DELETE FROM Cliente WHERE NoCliente=_NoCliente;
END //
DELIMITER ;



/* PRODUCTOS */
/* Seleccionar todos los productos */
DELIMITER //
CREATE PROCEDURE SelectAllProducts()
BEGIN
	SELECT * FROM Producto;
END //
DELIMITER :


/* Buscar Producto */
DELIMITER //
CREATE PROCEDURE SearchProduct(texto VARCHAR(30))
BEGIN
	SELECT * FROM Producto WHERE Nombre LIKE texto OR Cantidad LIKE texto
		OR Descripcion LIKE texto OR Costo LIKE texto OR Categoria LIKE texto ;
END //
DELIMITER ;

/* Seleccionar Producto */
DELIMITER //
CREATE PROCEDURE SelectProduct(_NoProducto INT(11))
BEGIN
	SELECT * FROM Producto WHERE NoProducto=_NoProducto;
END //
DELIMITER ;



/* PEDIDOS */
/* Seleccionar todos los Pedidos */
DELIMITER //
CREATE PROCEDURE SelectAllPedidos()
BEGIN
	SELECT p.NoPedido, p.Estado, p.TipoPago, c.Nombre, p.NoGuia, p.FechaPago
		FROM Pedido p JOIN Cliente c WHERE p.NoCliente = c.NoCliente;
END //
DELIMITER ;


/* PRODUCTO PEDIDO */
/* Seleccionar productos de un pedido */
DELIMITER //
CREATE PROCEDURE SelectProdsPedido(_NoPedido INT(11))
BEGIN
   SELECT b.NoProducto, b.Nombre, c.Cantidad, b.Descripcion, b.Costo FROM Pedido a JOIN Producto b JOIN ProductoPedido c
      WHERE a.NoPedido=c.NoPedido AND b.NoProducto=c.NoProducto AND a.NoPedido=_NoPedido;
END //
DELIMITER ;









