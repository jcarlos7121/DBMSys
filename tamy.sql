--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    nocliente integer NOT NULL,
    nombre character varying(20),
    apellidom character varying(30),
    apellidop character varying(30),
    calle character varying(20),
    ciudad character varying(10),
    estado character varying(10),
    cp integer,
    pais character varying(20),
    email character varying(50),
    rfc character varying(30),
    descuentocliente double precision
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: clienteempresa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clienteempresa (
    nocliente integer,
    cargo character varying(20),
    "compañia" character varying(20)
);


ALTER TABLE public.clienteempresa OWNER TO postgres;

--
-- Name: clientetels; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clientetels (
    nocliente integer,
    telefono numeric(10,0)
);


ALTER TABLE public.clientetels OWNER TO postgres;

--
-- Name: empleado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empleado_seq OWNER TO postgres;

--
-- Name: empleado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('empleado_seq', 15, true);


--
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empleado (
    noempleado integer DEFAULT nextval('empleado_seq'::regclass) NOT NULL,
    nombre character varying(20),
    apellidom character varying(30),
    apellidop character varying(30),
    calle character varying(30),
    ciudad character varying(20),
    estado character varying(10),
    cp integer,
    pais character varying(30),
    cargo character varying(30),
    email character varying(120),
    notas character varying(100),
    usuariofb character varying(30),
    aprobado integer,
    username character varying(10),
    password character varying(30)
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- Name: empleadoatiendeclientes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empleadoatiendeclientes (
    nocliente integer,
    noempleado integer,
    fechaatendido date
);


ALTER TABLE public.empleadoatiendeclientes OWNER TO postgres;

--
-- Name: empleadotels; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empleadotels (
    noempleado integer,
    telefono numeric(10,0)
);


ALTER TABLE public.empleadotels OWNER TO postgres;

--
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pedido (
    nopedido integer NOT NULL,
    fechapedido date,
    impuesto double precision,
    estado character varying(20),
    notas character varying(100),
    fechapago date,
    tipopago date,
    fecharecepcion date,
    fechaprevista date,
    fechatentativa date,
    proveedor_cliente character varying(20),
    nocliente integer,
    notransp numeric(20,0)
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- Name: proveedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedor (
    noproveedor integer NOT NULL,
    nombre character varying(20),
    apellidom character varying(30),
    apellidop character varying(30),
    calle character varying(20),
    ciudad character varying(20),
    estado character varying(20),
    cp integer,
    pais character varying(20),
    email character varying(50),
    notas character varying(100),
    rfc character varying(20),
    paginaweb character varying(20)
);


ALTER TABLE public.proveedor OWNER TO postgres;

--
-- Name: proveedorempresa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedorempresa (
    noproveedor integer,
    empresapersona character varying(20),
    cargo character varying(20),
    "compañia" character varying(20)
);


ALTER TABLE public.proveedorempresa OWNER TO postgres;

--
-- Name: proveedortels; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedortels (
    noproveedor integer,
    telefono numeric(10,0)
);


ALTER TABLE public.proveedortels OWNER TO postgres;

--
-- Name: proveligetransp; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveligetransp (
    noproveedor integer,
    notransp numeric(10,0),
    notas character varying(100)
);


ALTER TABLE public.proveligetransp OWNER TO postgres;

--
-- Name: transportista; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE transportista (
    notransp numeric(10,0) NOT NULL,
    nombre character varying(20),
    apellidom character varying(30),
    apellidop character varying(30),
    calle character varying(20),
    ciudad character varying(20),
    estado character varying(20),
    cp integer,
    pais character varying(20),
    cargo character varying(20),
    "compañia" character varying(20),
    email character varying(50),
    notas character varying(100),
    paginaweb character varying(30)
);


ALTER TABLE public.transportista OWNER TO postgres;

--
-- Name: transportistatels; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE transportistatels (
    notransportista numeric(10,0),
    telefono numeric(10,0)
);


ALTER TABLE public.transportistatels OWNER TO postgres;

--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (nocliente, nombre, apellidom, apellidop, calle, ciudad, estado, cp, pais, email, rfc, descuentocliente) FROM stdin;
1	Juan Carlos	Hinojo	Bañuelos	Monte Santo	Torreón	Coahuila	27298	Mexico	jchinojob7@gmail.com	REIFFM898	50
\.


--
-- Data for Name: clienteempresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clienteempresa (nocliente, cargo, "compañia") FROM stdin;
\.


--
-- Data for Name: clientetels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clientetels (nocliente, telefono) FROM stdin;
\.


--
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleado (noempleado, nombre, apellidom, apellidop, calle, ciudad, estado, cp, pais, cargo, email, notas, usuariofb, aprobado, username, password) FROM stdin;
12	Maria	iuhiuhd	iuhiuhd	oijoasd	oijoasd	oijod	123433	uiuhasd	\N	dasoij@hotm.com	\N	\N	1	maria	123
15	Guillermo	Almivar	Saldivar	No se	oij	oijo	87125	oj	\N	oij.com	\N	\N	1	memo	123
9	Juan Carlos	oijoi	oijoi	Holo	IQh	qwe	1234	oijo	\N	oijo	\N	\N	1	bass	peke
14	Juan Carlos	Bañuelos	Bañuelos	Monte Santo	Torreòn	Coahuila	27298	EUA	\N	jchinojob7@hotmail.com	\N	\N	1	jcharly2	123456
1	Felipe	Mendoza	Mendoza	juegaversus	spoof	mexico	78542	mexico	\N	felipe@juega.com	\N	\N	1	admin	123
\.


--
-- Data for Name: empleadoatiendeclientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleadoatiendeclientes (nocliente, noempleado, fechaatendido) FROM stdin;
\.


--
-- Data for Name: empleadotels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleadotels (noempleado, telefono) FROM stdin;
\.


--
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (nopedido, fechapedido, impuesto, estado, notas, fechapago, tipopago, fecharecepcion, fechaprevista, fechatentativa, proveedor_cliente, nocliente, notransp) FROM stdin;
\.


--
-- Data for Name: proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proveedor (noproveedor, nombre, apellidom, apellidop, calle, ciudad, estado, cp, pais, email, notas, rfc, paginaweb) FROM stdin;
2	andres	aaa	eqer	asoijo	oijoiasd	sdasd	238162	sasd	qweq	asdasd	asdasd	asdasd
1	Antonio	Bañuelos	Renteria	Ble	nose	y asi	1235	EL reino	toño@mail.com	oijoasd	KSJODI278	oijasdo
\.


--
-- Data for Name: proveedorempresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proveedorempresa (noproveedor, empresapersona, cargo, "compañia") FROM stdin;
1	Antonio	CIO	libreria sion
\.


--
-- Data for Name: proveedortels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proveedortels (noproveedor, telefono) FROM stdin;
1	726178
\.


--
-- Data for Name: proveligetransp; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proveligetransp (noproveedor, notransp, notas) FROM stdin;
\.


--
-- Data for Name: transportista; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY transportista (notransp, nombre, apellidom, apellidop, calle, ciudad, estado, cp, pais, cargo, "compañia", email, notas, paginaweb) FROM stdin;
\.


--
-- Data for Name: transportistatels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY transportistatels (notransportista, telefono) FROM stdin;
\.


--
-- Name: cliente_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_email_key UNIQUE (email);


--
-- Name: clientetels_telefono_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clientetels
    ADD CONSTRAINT clientetels_telefono_key UNIQUE (telefono);


--
-- Name: empleadotels_telefono_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY empleadotels
    ADD CONSTRAINT empleadotels_telefono_key UNIQUE (telefono);


--
-- Name: noclientepk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT noclientepk PRIMARY KEY (nocliente);


--
-- Name: nopedidopk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT nopedidopk PRIMARY KEY (nopedido);


--
-- Name: primarykeyy; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT primarykeyy PRIMARY KEY (noempleado);


--
-- Name: proveedor_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor
    ADD CONSTRAINT proveedor_email_key UNIQUE (email);


--
-- Name: proveedorpk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor
    ADD CONSTRAINT proveedorpk PRIMARY KEY (noproveedor);


--
-- Name: proveedortels_telefono_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedortels
    ADD CONSTRAINT proveedortels_telefono_key UNIQUE (telefono);


--
-- Name: transportista_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transportista
    ADD CONSTRAINT transportista_email_key UNIQUE (email);


--
-- Name: transportistapk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transportista
    ADD CONSTRAINT transportistapk PRIMARY KEY (notransp);


--
-- Name: transportistatels_telefono_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transportistatels
    ADD CONSTRAINT transportistatels_telefono_key UNIQUE (telefono);


--
-- Name: clientefk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clientetels
    ADD CONSTRAINT clientefk FOREIGN KEY (nocliente) REFERENCES cliente(nocliente);


--
-- Name: empleadoatiendeclientesfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleadoatiendeclientes
    ADD CONSTRAINT empleadoatiendeclientesfk FOREIGN KEY (nocliente) REFERENCES cliente(nocliente);


--
-- Name: empresafk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clienteempresa
    ADD CONSTRAINT empresafk FOREIGN KEY (nocliente) REFERENCES cliente(nocliente);


--
-- Name: nopedidoclientfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT nopedidoclientfk FOREIGN KEY (nocliente) REFERENCES cliente(nocliente);


--
-- Name: nopedidotransfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT nopedidotransfk FOREIGN KEY (notransp) REFERENCES transportista(notransp);


--
-- Name: proveedorempresafk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedorempresa
    ADD CONSTRAINT proveedorempresafk FOREIGN KEY (noproveedor) REFERENCES proveedor(noproveedor);


--
-- Name: proveedortelsfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedortels
    ADD CONSTRAINT proveedortelsfk FOREIGN KEY (noproveedor) REFERENCES proveedor(noproveedor);


--
-- Name: proveligetranspfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveligetransp
    ADD CONSTRAINT proveligetranspfk FOREIGN KEY (noproveedor) REFERENCES proveedor(noproveedor);


--
-- Name: transportistafk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transportistatels
    ADD CONSTRAINT transportistafk FOREIGN KEY (notransportista) REFERENCES transportista(notransp);


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

