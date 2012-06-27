USE DATABASE dbmsys;

/* Tabla Clientes */
insert into Cliente values(1, 'Mariano', 'Velasco', 'Lopez', 'Campestre La Rosita', 'Torreon', 'Coahuila', 27260, 'Mexico', 'mariano@ejemplo.com', 'MARIOIFHF232', 0);
insert into Cliente values(2, 'Gerardo', 'Garcia', 'Perez', 'Las Fuentes', 'Torreon', 'Coahuila', 27230, 'Mexico', 'gerardo@ejemplo.com', 'GERIFHF23AS2', 0);
insert into Cliente values(3, 'Sonia', 'Cordoba', 'Hernandez', 'Amanecer', 'Torreon', 'Coahuila', 27264, 'Mexico', 'sonia@ejemplo.com', 'SONIFHF265', 0);


/* Tabla ClienteTels */
insert into ClienteTels values(1, 7204325);
insert into ClienteTels values(1, 7204216);
insert into ClienteTels values(2, 7201454);
insert into ClienteTels values(3, 7208811);


/* Tabla Empleados */
insert into Empleado values(1, 'Felipe', 'Mendoza', 'Mendoza', 'paseo del olimpo', 'Torreon', 'Coahuila', 27300, 'Mexico', 'admin', 'felipe@ejemplo.com', NULL, NULL, NULL, 'admin', 'admin', '1');
insert into Empleado values(2, 'Luis', 'Robles', 'Rodriguez', 'Rio Aguanaval', 'Torreon', 'Coahuila', 27210, 'Mexico', 'ventas', 'luis@ejemplo.com', NULL, NULL, NULL, 'luisRR', '123', '1');
insert into Empleado values(3, 'Sofia', 'Ibarra', 'Gidi', 'La Rosita', 'Torreon', 'Coahuila', 27100, 'Mexico', 'ventas', 'sofia@ejemplo.com', NULL, NULL, NULL, 'sofia', '123', '0');

/* Tabla Productos */
insert into Producto values(1, 'Metal', 10, '0', 5, 100, 'Metal Barato', 'Metal Varios');
insert into Producto values(2, 'Engranes', 20, '0', 10, 250, 'engrane normal', 'metal');
insert into Producto values(3, 'Metal2', 30, '1', 25, 320, 'metal tipo 2', 'Metal Varios');

 



