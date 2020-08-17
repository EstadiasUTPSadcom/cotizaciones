drop database if exists sadcom;

create database if not exists sadcom;

use sadcom;

create table usuario(
	usr varchar(30) not null,
    pass varchar(30) not null,
    constraint pk_id primary key (usr)
);

create table categoria(
	id int not null auto_increment,
    nombre varchar(30) not null,
    constraint pk_id primary key(id),
    constraint uq_nombre unique (nombre)
);


create table subcategoria(
	id int not null auto_increment,
    id_categoria int not null,
    nombre varchar(50) not null,
    constraint pk_id primary key(id),
    constraint fk_id_categoria_subcategoria foreign key (id_categoria) references categoria (id) on delete cascade on update cascade,
    constraint uq_id_cat_nombre unique (id_categoria, nombre)
);
 

create table producto(
	id int unsigned not null auto_increment,
    descripcion varchar (60) not null,	#Ver si hay descripcion de cliente y técnica
    precio double not null,
    imagen blob, 
    id_subcategoria int not null,
	constraint pk_id primary key(id), 
    constraint fk_id_subcategoria_producto foreign key(id_subcategoria) references subcategoria(id) on delete cascade on update cascade
);


create table paquete( 	#Also named KIT
	id int unsigned not null auto_increment, 
    descripcion varchar(60) not null,
    suma double not null default 0,
    descuento tinyint unsigned not null default 0,
    precio double not null default 0,
    constraint pk_id primary key (id)
    #descuento por dinero o por porcentaje?
);


create table empaquetado(
	id_producto int unsigned not null,
    id_paquete int unsigned not null,
    constraint fk_id_producto_empaquetado foreign key (id_producto) references producto(id) on delete cascade on update cascade,
    constraint fk_id_paquete_empaquetado foreign key (id_paquete) references paquete(id) on delete cascade on update cascade
);


create table cotizacion(
	id int unsigned not null auto_increment,
    descripcion varchar(60) not null,
    fecha date not null,  #Por defecto la fecha del sistema
    subtotal double not null default 0,
    total double not null default 0,
    lugar varchar(100) not null,
    comprado bool not null default false,
    constraint pk_id primary key(id)
);

create table cotiza_producto(
	id_producto int unsigned not null,
    id_cotizacion int unsigned not null,
    cantidad smallint unsigned not null, 		    
    constraint fk_id_producto_cotizacion_producto foreign key(id_producto) references producto(id) on delete cascade on update cascade,
    constraint fk_id_cotizacion_cotizacion_producto foreign key(id_cotizacion) references cotizacion (id) on delete cascade on update cascade
);

create table cotiza_paquete(
	id_paquete int unsigned not null,
    id_cotizacion int unsigned not null,
    cantidad smallint unsigned not null, 	
    constraint fk_id_paquete_cotizacion_paquete foreign key(id_paquete) references paquete(id) on delete cascade on update cascade,
    constraint fk_id_cotizacion_cotizacion_paquete foreign key(id_cotizacion) references cotizacion (id) on delete cascade on update cascade
);


insert into usuario values("admin", "admin");

/*select * from producto join subcategoria on producto.id_subcategoria = subcategoria.id where id_categoria = 1;

SELECT producto.id, descripcion, precio, imagen, id_subcategoria from producto join subcategoria on producto.id_subcategoria = subcategoria.id where id_categoria = 1; #Busca productos en una categoria
SELECT producto.id, descripcion, precio, imagen, id_subcategoria from producto join subcategoria on producto.id_subcategoria = subcategoria.id where id_categoria = 1 and descripcion like "%%"; #Busca productos en una categoria y like desc

SELECT * from producto 
where id_subcategoria = 1 and descripcion like "%%"; #Busca productos en una subcategoria y like desccrip

delete from paquete where descripcion = "nuevoTemporal123";

insert into producto values
(null, "SENSOR DE PUERTA", 260),
(null, "AUDIO DE CRISTAL", 572);
*/


