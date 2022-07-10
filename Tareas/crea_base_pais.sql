create database dbconector;
use dbconector;
drop table pais;

CREATE TABLE PAIS(
id_pais int PRIMARY KEY AUTO_INCREMENT,
nombre_pais VARCHAR(60) NOT NULL,
capital_pais VARCHAR(60) NOT NULL,
poblacion_pais BIGINT NOT NULL,
fecha_ingreso_pais DATE NOT null,
fecha_actualiza_pais DATE 
);

ALTER TABLE pais AUTO_INCREMENT = 20220000;

select id_pais,nombre_pais,capital_pais,poblacion_pais
from pais;

 INSERT INTO pais (nombre_pais,
                           capital_pais,
                           poblacion_pais,
                           fecha_ingreso_pais)
                           VALUES ( 'Guatemala', 'Guatemala', 4000,'2020/01/01' );
                                        
                                        select * from pais;






