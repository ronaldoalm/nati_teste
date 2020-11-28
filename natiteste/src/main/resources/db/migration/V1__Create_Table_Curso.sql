-- Table: public.curso

-- DROP TABLE public.curso;

CREATE TABLE public.curso
(
    id SERIAL,
    nome character varying(255) COLLATE pg_catalog."default",
    turno character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT curso_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.curso
    OWNER to postgres;