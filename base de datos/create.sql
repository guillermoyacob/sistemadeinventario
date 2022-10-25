CREATE TABLE producto (
	id int auto_increment PRIMARY KEY,
	nombre varchar(50),
	descripcion varchar(50),
	unidades int,
	costo decimal(10, 2),
	precio decimal (10, 2),
	categoria varchar(50)
);