-- Table: public.pderrors

-- DROP TABLE public.pderrors;

CREATE TABLE public.pderrors
(
    country character varying COLLATE pg_catalog."default",
    messageid character varying COLLATE pg_catalog."default" NOT NULL,
    xmlmess text COLLATE pg_catalog."default",
    gcid character varying COLLATE pg_catalog."default",
    errortext text COLLATE pg_catalog."default",
    CONSTRAINT pd_errors_mess_pkey PRIMARY KEY (messageid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pderrors
    OWNER to neno;