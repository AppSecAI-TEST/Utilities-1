--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE client (
    id integer NOT NULL,
    name character varying,
    surname character varying,
    phone character varying
);


ALTER TABLE client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- Name: models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE models (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE models OWNER TO postgres;

--
-- Name: models_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE models_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE models_id_seq OWNER TO postgres;

--
-- Name: models_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE models_id_seq OWNED BY models.id;


--
-- Name: sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sale (
    id integer NOT NULL,
    sale_date date,
    amount integer,
    price numeric(12,2),
    client_id integer,
    model_id integer
);


ALTER TABLE sale OWNER TO postgres;

--
-- Name: sale_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sale_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sale_id_seq OWNER TO postgres;

--
-- Name: sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sale_id_seq OWNED BY sale.id;


--
-- Name: salon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE salon (
    id integer NOT NULL,
    name character varying,
    address character varying,
    phone character varying
);


ALTER TABLE salon OWNER TO postgres;

--
-- Name: salon_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE salon_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE salon_id_seq OWNER TO postgres;

--
-- Name: salon_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE salon_id_seq OWNED BY salon.id;


--
-- Name: salon_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE salon_models (
    id integer NOT NULL,
    id_salon integer,
    id_model integer
);


ALTER TABLE salon_models OWNER TO postgres;

--
-- Name: salon_models_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE salon_models_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE salon_models_id_seq OWNER TO postgres;

--
-- Name: salon_models_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE salon_models_id_seq OWNED BY salon_models.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY models ALTER COLUMN id SET DEFAULT nextval('models_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale ALTER COLUMN id SET DEFAULT nextval('sale_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salon ALTER COLUMN id SET DEFAULT nextval('salon_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salon_models ALTER COLUMN id SET DEFAULT nextval('salon_models_id_seq'::regclass);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO client (id, name, surname, phone) VALUES (1, 'Сергей', 'Иванов', '+79107891122');
INSERT INTO client (id, name, surname, phone) VALUES (2, 'Олег', 'Коробкин', '+79107891155');
INSERT INTO client (id, name, surname, phone) VALUES (3, 'Роман', 'Олейкин', '+79107891166');
INSERT INTO client (id, name, surname, phone) VALUES (4, 'Дмитрий', 'Семенов', '+79107891122');


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 4, true);


--
-- Data for Name: models; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO models (id, name) VALUES (1, 'BMW X3');
INSERT INTO models (id, name) VALUES (2, 'BMW X5');
INSERT INTO models (id, name) VALUES (3, 'BMW X6');
INSERT INTO models (id, name) VALUES (4, 'Audi Q3');
INSERT INTO models (id, name) VALUES (5, 'Audi Q5');
INSERT INTO models (id, name) VALUES (6, 'Audi Q6');


--
-- Name: models_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('models_id_seq', 6, true);


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (1, '2014-10-01', 1, 2000000.00, 1, 1);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (6, '2014-10-02', 2, 2000000.00, 2, 4);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (3, '2014-10-02', 2, 3500000.00, 2, 4);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (4, '2014-10-02', 1, 2000000.00, 3, 3);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (5, '2014-10-02', 1, 2000000.00, 2, 3);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (7, '2014-10-02', 3, 7800000.00, 3, 1);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (9, '2014-10-03', 1, 3000000.00, 1, 3);
INSERT INTO sale (id, sale_date, amount, price, client_id, model_id) VALUES (8, '2014-10-03', 4, 10000000.00, 4, 4);


--
-- Name: sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sale_id_seq', 22, true);


--
-- Data for Name: salon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO salon (id, name, address, phone) VALUES (1, ' BMW-Фаворит', 'Москва ул. Колчака д. 42', '+79105559966');
INSERT INTO salon (id, name, address, phone) VALUES (2, ' Audi-Фаворит', 'Москва ул. Колчака д. 43', '+79105559955');


--
-- Name: salon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('salon_id_seq', 1, true);


--
-- Data for Name: salon_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO salon_models (id, id_salon, id_model) VALUES (1, 1, 1);
INSERT INTO salon_models (id, id_salon, id_model) VALUES (2, 1, 2);
INSERT INTO salon_models (id, id_salon, id_model) VALUES (3, 1, 3);
INSERT INTO salon_models (id, id_salon, id_model) VALUES (4, 2, 4);
INSERT INTO salon_models (id, id_salon, id_model) VALUES (5, 2, 5);
INSERT INTO salon_models (id, id_salon, id_model) VALUES (6, 2, 6);


--
-- Name: salon_models_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('salon_models_id_seq', 6, true);


--
-- Name: id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT id_pk PRIMARY KEY (id);


--
-- Name: id_pk_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT id_pk_client PRIMARY KEY (id);


--
-- Name: id_pk_models; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY models
    ADD CONSTRAINT id_pk_models PRIMARY KEY (id);


--
-- Name: id_pk_salon; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salon
    ADD CONSTRAINT id_pk_salon PRIMARY KEY (id);


--
-- Name: id_pk_salon_models; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salon_models
    ADD CONSTRAINT id_pk_salon_models PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

