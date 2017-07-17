--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- Name: clients; Type: TABLE; Schema: public; Owner: michaeldunlap
--

CREATE TABLE clients (
    id integer NOT NULL,
    firstname character varying,
    lastname character varying,
    email character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO michaeldunlap;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: michaeldunlap
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO michaeldunlap;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: michaeldunlap
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: michaeldunlap
--

CREATE TABLE stylists (
    id integer NOT NULL,
    firstname character varying,
    lastname character varying,
    email character varying,
    description text
);


ALTER TABLE stylists OWNER TO michaeldunlap;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: michaeldunlap
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO michaeldunlap;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: michaeldunlap
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: michaeldunlap
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: michaeldunlap
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: michaeldunlap
--

COPY clients (id, firstname, lastname, email, stylistid) FROM stdin;
15	Elysia	Nason	e@n.com	4
16	John	Harper	j@h.com	4
17	Madame	Butterfly	m@b.com	4
18	Tosca	Beaner	t@b.com	4
9	Micah	Beerstube	m@b.com	1
10	Flicka	Flacca	f@f.com	1
2	Michael	Smith	m@p.com	1
4	Michael	Smith	m@p.com	1
5	Chilly	Baggins	c@b.com	1
6	Debra	Winfeld	d@b.com	1
7	Marcia	Blank	m@b.com	1
24	Gradle	Winlock	g@w.com	1
11	Marv	Change	m@bc.com	4
12	Floosie	Winters	f@w.com	4
13	Inebra	Teetotaler	i@t.com	4
14	Debra	Arnswald	d@a.com	4
19	Chester	Walters	c@w.com	4
20	Charles	Charge	c@c.com	4
21	Wes	Anderson	w@a	4
22	Abby	Winters	a@w.com	4
23	Cheech	Rogers	c@r.com	4
26	Drudge	Manly	d@m.com	2
8	Joe	Flagenpuss	j@f.com	2
25	Mabel	Drybeans	m@b.com	2
27	Freebase	Compline	f@c.com	14
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: michaeldunlap
--

SELECT pg_catalog.setval('clients_id_seq', 28, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: michaeldunlap
--

COPY stylists (id, firstname, lastname, email, description) FROM stdin;
14	Greyjoy	Simperon	g@salon.com	Long description.
2	Famous	Female	m@salon.com	I edited this text carefully, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
4	Walteros	Frey	walter@salon.com	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
1	Harry	Styles	h@salon.com	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: michaeldunlap
--

SELECT pg_catalog.setval('stylists_id_seq', 14, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: michaeldunlap
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: michaeldunlap
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

