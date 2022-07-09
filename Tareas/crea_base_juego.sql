create database dbjuego;
use dbjuego;

create table tbl_tipo_usuario
(id_tipo_usuario int  PRIMARY KEY AUTO_INCREMENT,
nombre_tipo_usuario varchar(25),
descripcion_tipo_usuario varchar(50));

insert into tbl_tipo_usuario
(nombre_tipo_usuario,descripcion_tipo_usuario)
values
('Administrador','Administrador del Sistema');

insert into tbl_tipo_usuario
(nombre_tipo_usuario,descripcion_tipo_usuario)
values
('Principiante','Jugador Principiante');

insert into tbl_tipo_usuario
(nombre_tipo_usuario,descripcion_tipo_usuario)
values
('Intermedio','Jugador Intermedio');

insert into tbl_tipo_usuario
(nombre_tipo_usuario,descripcion_tipo_usuario)
values
('Avanzado','Jugador Avanzado');

select nombre_usuario,apellido_usuario,edad_usuario, 
b.nombre_tipo_usuario, c.punteo_score
from tbl_usuario as a
left join  tbl_tipo_usuario as b
on a.id_tipo_usuario_fk=b.id_tipo_usuario
left join tbl_score as c
on a.id_usuario=c.id_usuario_fk 
 
SELECT id_usuario,
                    nombre_usuario,
                    apellido_usuario,
                    edad_usuario,
                    user,
                    password,
                    estado,
                    id_tipo_usuario_fk 
			from tbl_usuario

create table tbl_usuario
(id_usuario int  PRIMARY KEY AUTO_INCREMENT,
nombre_usuario varchar(50),
apellido_usuario varchar(50),
edad_usuario int,
user varchar(15),
password varchar(50),
estado varchar(1),
id_tipo_usuario_fk int not null,
FOREIGN KEY (id_tipo_usuario_fk) REFERENCES tbl_tipo_usuario(id_tipo_usuario) );

drop table tbl_score;
create table tbl_score
(id_score int PRIMARY KEY AUTO_INCREMENT,
punteo_score int,
id_usuario_fk int not null,
FOREIGN KEY (id_usuario_fk) REFERENCES tbl_usuario(id_usuario) );

drop table tbl_pregunta;
create table tbl_pregunta
(
id_pregunta int  PRIMARY KEY AUTO_INCREMENT,
desc_pregunta varchar(80));

insert into tbl_pregunta
(desc_pregunta)
values
('Bajo que regimen fue la Creacion del Codigo de trabajo y el IGSS');

update tbl_pregunta
set desc_pregunta='Bajo que regimen fue la Creacion del Codigo de trabajo y el IGSS'
where id_pregunta=1;

insert into tbl_pregunta
(desc_pregunta)
values
('Libro sagrado maya quiche');

insert into tbl_pregunta
(desc_pregunta)
values
('Conquista de Guatemala por imperio español');

insert into tbl_pregunta
(desc_pregunta)
values
('Independencia del imperio español');

insert into tbl_pregunta
(desc_pregunta)
values
('Fecha de la Revolucion de Octubre');

drop table tbl_respuesta;
create table tbl_respuesta
(
id_respuesta int  PRIMARY KEY AUTO_INCREMENT,
desc_respuesta varchar(50),
punteo int ,
id_pregunta_fk int not null,
FOREIGN KEY (id_pregunta_fk) REFERENCES tbl_pregunta(id_pregunta) );
 
 insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Junta Mayor Francisco Javier Arana',
 0,1);
 
  insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Precidencia Federico Ponce Vides',
 0,1);
 
   insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Precidencia Juan Jose Arevalo Bermejo',
 1,1);
 
   insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Leyendas de Guatemala',
 0,2);
 
    insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Popol Wuj',
 1,2);
 
     insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('Cronicas de la historia Maya',
 0,2);
 
     insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1524',
 1,3);
 
      insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1821',
 0,3);
 
       insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1822',
 0,3);
 
       insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1824',
 0,4);
 
        insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1871',
 0,4);
 
         insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('1821',
 1,4);
 
          insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('15 de octubre 1940',
 0,5);
 
           insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('20 de octubre 1944',
 1,5);
																										
            insert into tbl_respuesta
 (desc_respuesta,punteo,id_pregunta_fk)
 values
 ('20 de octubre 1904',
 0,5);
 
 drop table tbl_traductor;
create table tbl_traductor
(
id_palabra  int  PRIMARY KEY AUTO_INCREMENT,
palabra_ingles varchar(25),
palabra_espaniol varchar(25),
punteo int
);

insert into tbl_traductor
(palabra_ingles,palabra_espaniol,punteo)
values
('SUNRISE','AMANECER',1);

insert into tbl_traductor
(palabra_ingles,palabra_espaniol,punteo)
values
('DETAIL','DETALLE',1);

insert into tbl_traductor
(palabra_ingles,palabra_espaniol,punteo)
values
('THIRSTY','SEDIENTO',1);


