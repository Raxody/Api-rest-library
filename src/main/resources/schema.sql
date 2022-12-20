CREATE TABLE prestamo(
    idPrestamo INT AUTO_INCREMENT,
    isbn varchar (10) NOT NULL UNIQUE,
    usuario varchar(10) NOT NULL UNIQUE,
    tipoUsuario INT NOT NULL,
    fechaMaximaDevolucion date,
    PRIMARY KEY(idPrestamo)
);
