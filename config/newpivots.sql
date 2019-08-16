DO
$do$
BEGIN
   IF NOT EXISTS (
      SELECT
      FROM   pg_catalog.pg_roles
      WHERE  rolname = 'tq_proxy') THEN

      CREATE ROLE tq_proxy INHERIT;
   END IF;
END
$do$;

--
-- Create a schema to hide the proxy tables from public view.
--
CREATE SCHEMA IF NOT EXISTS tq_tagomizer;
GRANT ALL ON schema tq_tagomizer TO tq_proxy;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA tq_tagomizer TO tq_proxy;
ALTER DEFAULT PRIVILEGES IN SCHEMA tq_tagomizer
    GRANT USAGE, SELECT ON SEQUENCES TO tq_proxy;
   
create table if not exists tq_tagomizer.huser  (
   id serial primary key,
   hyp_uid varchar not null
);

create unique index if not exists huser_uid_idx on tq_tagomizer.huser (hyp_uid);
GRANT ALL PRIVILEGES ON tq_tagomizer.huser TO tq_proxy;

create table if not exists tq_tagomizer.document  (
    id serial primary key,
   url varchar not null,
   title varchar
);

create unique index if not exists document_url_idx on tq_tagomizer.document (url);
GRANT ALL PRIVILEGES ON tq_tagomizer.document TO tq_proxy;

--
-- annotationId docId userid ??? user-docu reference
--
create table if not exists tq_tagomizer.reference  (
   hyp_id varchar primary key, 
   document_id integer not null REFERENCES  tq_tagomizer.document (id),
   user_id integer not null REFERENCES  tq_tagomizer.huser (id)
);
GRANT ALL PRIVILEGES ON tq_tagomizer.reference TO tq_proxy;

create table if not exists tq_tagomizer.tag  (
   id serial primary key,
   name varchar not null
);

create unique index if not exists tag_uid_idx on tq_tagomizer.tag (name);
GRANT ALL PRIVILEGES ON tq_tagomizer.tag TO tq_proxy;

--
-- tagId refid tag -ref pivot
--
create table if not exists tq_tagomizer.tag_ref  (
   tag_id integer references tq_tagomizer.tag (id),
   ref_id varchar references tq_tagomizer.reference (hyp_id),
   primary key (tag_id, ref_id)
);
GRANT ALL PRIVILEGES ON tq_tagomizer.tag_ref TO tq_proxy;
