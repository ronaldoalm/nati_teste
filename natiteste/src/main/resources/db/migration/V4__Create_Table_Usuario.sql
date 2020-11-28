-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
    id SERIAL,
    matricula character varying(255) COLLATE pg_catalog."default",
    nome_completo character varying(255) COLLATE pg_catalog."default",
    senha character varying(255) COLLATE pg_catalog."default",
    access_token character varying(255) COLLATE pg_catalog."default",
    tipo_usuario character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;