-- Table: public.disciplina

-- DROP TABLE public.disciplina;

CREATE TABLE public.disciplina
(
    id SERIAL,
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT disciplina_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.disciplina
    OWNER to postgres;