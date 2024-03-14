CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.locals
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name character varying(255) NOT NULL,
    address character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    state character varying(255) NOT NULL,
    city character varying(255) NOT NULL
);