/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Adriano
 * Created: 10/09/2018
 */

-- DROP TABLE tarefa CASCADE;
-- DROP TABLE tarefatempo CASCADE;
-- DROP TABLE usuario CASCADE;

-- Table: usuario

CREATE TABLE usuario
(
  id serial NOT NULL,
  username character varying(100) NOT NULL,
  senha character varying(100) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;

-- Table: tarefa

CREATE TABLE tarefa
(
  id serial NOT NULL,
  nome character varying(100) NOT NULL,
  tempoestimado numeric NOT NULL,
  temporealizado numeric,
  descricao text,
  usuario_id integer,
  CONSTRAINT tarefa_pkey PRIMARY KEY (id),
  CONSTRAINT tarefa_usuario_id_fkey FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tarefa
  OWNER TO postgres;

-- Table: tarefatempo

CREATE TABLE tarefatempo
(
  id serial NOT NULL,
  datainicial timestamp with time zone NOT NULL,
  datafinal timestamp with time zone,
  tarefa_id integer,
  CONSTRAINT tarefatempo_pkey PRIMARY KEY (id),
  CONSTRAINT tarefatempo_tarefa_id_fkey FOREIGN KEY (tarefa_id)
      REFERENCES tarefa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tarefatempo
  OWNER TO postgres;
