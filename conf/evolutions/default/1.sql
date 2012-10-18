# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table articulo (
  articulo_id               integer auto_increment not null,
  nombre                    varchar(255),
  funcion_funcion_id        integer,
  preciounitario            double,
  constraint pk_articulo primary key (articulo_id))
;

create table compra (
  id_compra                 integer auto_increment not null,
  pedido_pedido_id          integer,
  articulo_articulo_id      integer,
  cantidad                  double,
  total                     double,
  constraint pk_compra primary key (id_compra))
;

create table funcion (
  funcion_id                integer auto_increment not null,
  sala                      varchar(255),
  pelicula_movie_id         integer,
  hora_inicio               varchar(255),
  hora_fin                  varchar(255),
  tipo_sala                 varchar(255),
  constraint pk_funcion primary key (funcion_id))
;

create table pedido (
  pedido_id                 integer auto_increment not null,
  usuario_userid            integer,
  total                     double,
  pagado                    tinyint(1) default 0,
  horadecaducidad           varchar(255),
  constraint pk_pedido primary key (pedido_id))
;

create table pelicula (
  movie_id                  integer auto_increment not null,
  nombre                    varchar(255),
  categoria                 varchar(255),
  duracion                  varchar(255),
  sinopsis                  varchar(255),
  youtube                   varchar(255),
  imagenurl                 varchar(255),
  constraint pk_pelicula primary key (movie_id))
;

create table usuario (
  userid                    integer auto_increment not null,
  password                  varchar(255),
  nombre                    varchar(255),
  apellidop                 varchar(255),
  apellidom                 varchar(255),
  telefono                  bigint,
  email                     varchar(255),
  facebookid                varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_usuario primary key (userid))
;

alter table articulo add constraint fk_articulo_funcion_1 foreign key (funcion_funcion_id) references funcion (funcion_id) on delete restrict on update restrict;
create index ix_articulo_funcion_1 on articulo (funcion_funcion_id);
alter table compra add constraint fk_compra_Pedido_2 foreign key (pedido_pedido_id) references pedido (pedido_id) on delete restrict on update restrict;
create index ix_compra_Pedido_2 on compra (pedido_pedido_id);
alter table compra add constraint fk_compra_Articulo_3 foreign key (articulo_articulo_id) references articulo (articulo_id) on delete restrict on update restrict;
create index ix_compra_Articulo_3 on compra (articulo_articulo_id);
alter table funcion add constraint fk_funcion_pelicula_4 foreign key (pelicula_movie_id) references pelicula (movie_id) on delete restrict on update restrict;
create index ix_funcion_pelicula_4 on funcion (pelicula_movie_id);
alter table pedido add constraint fk_pedido_usuario_5 foreign key (usuario_userid) references usuario (userid) on delete restrict on update restrict;
create index ix_pedido_usuario_5 on pedido (usuario_userid);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table articulo;

drop table compra;

drop table funcion;

drop table pedido;

drop table pelicula;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

