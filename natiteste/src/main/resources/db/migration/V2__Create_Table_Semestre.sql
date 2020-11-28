-- Table: public.semestre

-- DROP TABLE public.semestre;

CREATE TABLE public.semestre
(
    id SERIAL,
    semestre character varying(255) COLLATE pg_catalog."default",
    curso_id bigint NOT NULL,
    CONSTRAINT semestre_pkey PRIMARY KEY (id),
    CONSTRAINT fkf2wd88ok7rwvv3cwcudc4ipls FOREIGN KEY (curso_id)
        REFERENCES public.curso (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.semestre
    OWNER to postgres;