CREATE DATABASE IF NOT EXISTS Manager_Products;

CREATE TABLE IF NOT EXISTS Manager_Products.Family(
    idFamily INTEGER NOT NULL AUTO_INCREMENT,
    nameFamily VARCHAR(20) NOT NULL,
    PRIMARY KEY(idFamily)
);

CREATE TABLE IF NOT EXISTS Manager_Products.Model(
    idModel INTEGER NOT NULL AUTO_INCREMENT,
    nameModel VARCHAR(20) NOT NULL,
    idFamily INTEGER,
    PRIMARY KEY(idModel),
	FOREIGN KEY(idFamily) REFERENCES Family(idFamily)
);

CREATE TABLE IF NOT EXISTS Manager_Products.Tablet(
    idTablet INTEGER NOT NULL AUTO_INCREMENT,
    screen VARCHAR(20) NOT NULL,
    idModel INTEGER NOT NULL,
    processor VARCHAR(20) NOT NULL,
	sensors VARCHAR(40) NOT NULL,
    dimension varchar(20) NOT NULL,
    stored INTEGER NOT NULL,
    colors VARCHAR(50) NOT NULL,
    PRIMARY KEY(idTablet),
	FOREIGN KEY(idModel) REFERENCES Model(idModel)
);

CREATE TABLE IF NOT EXISTS Manager_Products.Smartphone(
    idSmartphone INTEGER NOT NULL AUTO_INCREMENT,
    screen VARCHAR(20) NOT NULL,
    idModel INTEGER NOT NULL,
    processor VARCHAR(20) NOT NULL,
	sensors VARCHAR(40) NOT NULL,
    dimension varchar(20),
    stored INTEGER NOT NULL,
    colors VARCHAR(50),
    numberSIM INTEGER NOT NULL,
    PRIMARY KEY(idSmartphone),
	FOREIGN KEY(idModel) REFERENCES Model(idModel)
);

CREATE TABLE IF NOT EXISTS Manager_Products.Smartwatch(
    idSmartwatch INTEGER NOT NULL AUTO_INCREMENT,
    screen VARCHAR(20) NOT NULL,
    idModel INTEGER NOT NULL,
    processor VARCHAR(20) NOT NULL,
	sensors VARCHAR(40) NOT NULL,
    dimension varchar(20),
    stored INTEGER NOT NULL,
    PRIMARY KEY(idSmartwatch),
	FOREIGN KEY(idModel) REFERENCES Model(idModel)
);

CREATE TABLE IF NOT EXISTS Manager_Products.SmartTV(
    idSmartTV INTEGER NOT NULL AUTO_INCREMENT,
    screen VARCHAR(20) NOT NULL,
    idModel INTEGER NOT NULL,
    processor VARCHAR(20) NOT NULL,
	sensors VARCHAR(40) NOT NULL,
    dimension varchar(20),
    stored INTEGER NOT NULL,
    weightSmartTV FLOAT(6,2) NOT NULL,
    PRIMARY KEY(idSmartTV),
	FOREIGN KEY(idModel) REFERENCES Model(idModel)
);

CREATE TABLE IF NOT EXISTS Manager_Products.State(
	idState INTEGER NOT NULL,
	nameState VARCHAR(30) NOT NULL,
	PRIMARY KEY(idState)
);

CREATE TABLE IF NOT EXISTS Manager_Products.Inventory(
    idInventory INTEGER NOT NULL AUTO_INCREMENT,
    idState INTEGER NOT NULL,
    idSmartphone INTEGER,
    idSmartwatch INTEGER,
    idTablet INTEGER,
    idSmartTV INTEGER,
	price FLOAT(6,2) NOT NULL,
	factoryErrors VARCHAR(50) NOT NULL,
    PRIMARY KEY(idInventory),
	FOREIGN KEY(idState) REFERENCES State(idState)
);

/*

INSERT INTO `family` VALUES (1,'Galaxy S'),(2,'Galaxy M'),(3,'Galaxy A');


INSERT INTO `inventory` VALUES (1,1,0,0,2,0,1200.25,'[ panatalla rota ]'),(2,1,0,0,1,0,1500.25,'[ cargador defectuoso ]'),(3,2,1,0,0,0,5000.00,'[]'),(4,3,2,0,0,0,8000.00,'[ cargador defectuoso ]'),(5,1,0,1,0,0,8000.00,'[ cargador defectuoso ]'),(6,1,0,2,0,0,8000.00,'[ proximidad ]'),(7,4,0,0,0,1,9999.99,'[ Error de Cagador ]'),(8,4,0,0,0,2,9999.99,'[ Pantalla rota ]'),(9,1,1,0,0,0,6666.66,'[Pantalla rota, Error al iniciar]'),(10,1,1,0,0,0,6666.66,'[Pantalla rota, Error al iniciar]'),(11,1,1,0,0,0,6666.66,'[Pantalla rota, Error al iniciar]');


INSERT INTO `model` VALUES (1,'Folder',1),(2,'Plus',1),(3,'5G Plus',2),(4,'Pro',3);


INSERT INTO `smartphone` VALUES (1,'AMOLED',1,'AMD','[ Temperatura , Calor ]','[ 1.1 , 2.1 ]',500,'[ red , blue ]',2),(2,'QLED',2,'INTEL','[ Temperatura ]','[ 1.1 , 2.2 ]',120,'[ blue ]',1),(3,'AMOLED',1,'Intel','[Temperatura, Proximidad]','[0.23, 1.25, 1.58]',5,'[red, blue, dark]',2);


INSERT INTO `smarttv` VALUES (1,'SMATLED',3,'AMD','[ Temperatura , Movimiento ]','[ 1.8 , 10.9 ]',500,45.50),(2,'LED',2,'INTEL','[ Proximidad , Temperatura ]','[ 20.8 , 60.9 ]',120,70.85),(3,'AMOLED',1,'Intel','[Temperatura, Proximidad]','[0.23, 1.25, 1.58]',0,500.00),(4,'AMOLED',1,'Intel','[Temperatura, Proximidad]','[0.23, 1.25, 1.58]',5,0.00);


INSERT INTO `smartwatch` VALUES (1,'LED',3,'Smartdragon','[ Movimiento ]','[ 1.0 , 0.5 ]',240),(2,'SMATLED',2,'INTEL','[ Temperatura ]','[ 0.8 , 0.9 ]',50),(3,'AMOLED',1,'Intel','[Temperatura, Proximidad]','[0.23, 1.25, 1.58]',5);


INSERT INTO `state` VALUES (1,'Almacenado'),(2,'Devolución'),(3,'En Reparación'),(4,'Vendido');


INSERT INTO `tablet` VALUES (1,'AMOLED',1,'AMD','[ Temperatura , Calor ]','[ 1.1 , 2.1 ]',500,'[ red , blue ]'),(2,'QLED',2,'INTEL','[ Proximidad , Movimiento ]','[ 2.0 , 1.1 ]',120,'[ blue ]'),(3,'AMOLED',1,'Intel','[Temperatura, Proximidad]','[0.23, 1.25, 1.58]',5,'[red, blue, dark]');


*/