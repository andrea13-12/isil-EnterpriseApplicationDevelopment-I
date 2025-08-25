
USE 1567;
GO

CREATE TABLE Sucursal (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    estado VARCHAR(20) NOT NULL
);

INSERT INTO Sucursal (nombre, direccion, estado) VALUES
('Sucursal Lima Centro', 'Av. Arequipa 1234', 'Activo'),
('Sucursal Miraflores', 'Calle Schell 456', 'Activo'),
('Sucursal San Isidro', 'Av. Javier Prado 789', 'Inactivo');
