DROP DATABASE IF EXISTS banco;
CREATE DATABASE banco;
use banco;

CREATE TABLE IF NOT EXISTS CUENTAS (
	cuenta int (5) unsigned not null auto_increment PRIMARY KEY,
    nombre_cliente varchar(50) not null,
    saldo double (10,2) not null,
    tipo_cuenta ENUM('A', 'C') -- 'a' corresponde a caja de ahorro, 'c' a cuenta corriente
);
CREATE TABLE IF NOT EXISTS MOVIMIENTOS(
	nro_movimiento int(10) unsigned not null auto_increment PRIMARY KEY,
	cuenta int(5) unsigned not null,
    mov ENUM('D','E'),
    importe double (10,2) not null,
    FOREIGN KEY (cuenta) REFERENCES CUENTAS(cuenta) on delete restrict on update cascade

);

INSERT INTO CUENTAS (cuenta, nombre_cliente, saldo, tipo_cuenta) VALUES
(NULL, 'Juan Perez', 125000.00, 'A'),
(NULL, 'Maria Gomez', 84250.50, 'C'),
(NULL, 'Lucas Fernandez', 45200.75, 'A'),
(NULL, 'Sofia Martinez', 158900.00, 'C'),
(NULL, 'Carlos Lopez', 23000.00, 'A'),
(NULL, 'Ana Rojas', 50000.00, 'A'),
(NULL, 'Diego Torres', 125000.00, 'C'),
(NULL, 'Valentina Suarez', 78000.50, 'A'),
(NULL, 'Martin Gonzalez', 9000.00, 'C'),
(NULL, 'Laura Ramirez', 45000.00, 'A');

INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES
-- Cuenta 1 (Juan Perez) → saldo 125000
(1, 'E', 1500.00),
(1, 'D', 25000.00),

-- Cuenta 2 (Maria Gomez)
(2, 'E', 1000.50),
(2, 'D', 15750.00),

-- Cuenta 3 (Lucas Fernandez)
(3, 'E', 600.75),
(3, 'D', 14800.00),

-- Cuenta 4 (Sofia Martinez)
(4, 'E', 20000.00),
(4, 'D', 41100.00),

-- Cuenta 5 (Carlos Lopez)
(5, 'E', 300.00),
(5, 'D', 7000.00),

-- Cuenta 6 (Ana Rojas) 
(6, 'D', 60000.00),   
(6, 'E', 10000.00); 

-- Cuenta 7 (Diego Torres)
INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES
(7, 'D', 150000.00),
(7, 'E', 25000.00);

-- Cuenta 8 (Valentina Suarez)
INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES
(8, 'D', 80000.50),
(8, 'E', 2000.00);

-- Cuenta 9 (Martin Gonzalez)
INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES
(9, 'D', 10000.00),
(9, 'E', 1000.00);

-- Cuenta 10 (Laura Ramirez)
INSERT INTO MOVIMIENTOS (cuenta, mov, importe) VALUES
(10, 'D', 50000.00),
(10, 'E', 5000.00);
