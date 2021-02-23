CREATE DATABASE vrteste
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
/
CREATE SEQUENCE public.alunos_cod_aluno_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.alunos_cod_aluno_seq
    OWNER TO postgres;
/	
CREATE TABLE public.alunos
(
    cod_aluno integer NOT NULL DEFAULT nextval('alunos_cod_aluno_seq'::regclass),
    doc_rg character varying COLLATE pg_catalog."default" NOT NULL,
    matricula character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    doc_cpf character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT alunos_pkey PRIMARY KEY (cod_aluno)
)
;

ALTER TABLE public.alunos
    OWNER to postgres;
/	