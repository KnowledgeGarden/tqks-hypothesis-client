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

create table if not exists tq_tagomizer.group  (
   id text UNIQUE,
   name text not null,
   PRIMARY KEY (id)
);

create index if not exists group_idx on tq_tagomizer.group (id);
GRANT ALL PRIVILEGES ON tq_tagomizer.group TO tq_proxy;

create table if not exists tq_tagomizer.user  (
   id text UNIQUE,
   PRIMARY KEY (id)
);

create index if not exists user_idx on tq_tagomizer.user (id);
GRANT ALL PRIVILEGES ON tq_tagomizer.user TO tq_proxy;

--
--	A document exists for each Hypothes.is URL within the context of a Group, and
--		Users in that Group. The document  row comes into being on the first user event.
--		Subsequent annotations can be with other users.
--	We pivot on URLs (resources)
--	document_id is the id given in a hypothesis document
-- 
-- OK
create table if not exists tq_tagomizer.document  (
    document_id text UNIQUE,
   	url text not null,
   	title text not null,
   	created text not null,
   	PRIMARY KEY (document_id)
);

create index if not exists document_url_idx on tq_tagomizer.document (url);
create index if not exists document_did on tq_tagomizer.document(document_id);
GRANT ALL PRIVILEGES ON tq_tagomizer.document TO tq_proxy;

--
--	A tag exists within the context of one or more documents.
--	We pivot on tags.
--
-- ok
create table if not exists tq_tagomizer.tag  (
   id text UNIQUE,
   name text not null,
   PRIMARY KEY (id)
);

create index if not exists tag_name on tq_tagomizer.tag (name);
create index if not exists tag_idx on tq_tagomizer.tag (id);
GRANT ALL PRIVILEGES ON tq_tagomizer.tag TO tq_proxy;


-- ok
create table if not exists tq_tagomizer.doc_tag_ref  (
   tag_id text not null REFERENCES  tq_tagomizer.tag (id),
   document_id text not null REFERENCES  tq_tagomizer.document (document_id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.doc_tag_ref TO tq_proxy;
create index if not exists dtr_tid on tq_tagomizer.doc_tag_ref (tag_id);
create index if not exists dtr_did on tq_tagomizer.doc_tag_ref (document_id);

-- ok
create table if not exists tq_tagomizer.user_tag_ref  (
   tag_id text not null REFERENCES  tq_tagomizer.tag (id),
   user_id text not null REFERENCES  tq_tagomizer.user (id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.user_tag_ref TO tq_proxy;
create index if not exists utr_tid on tq_tagomizer.user_tag_ref (tag_id);
create index if not exists utr_uid on tq_tagomizer.user_tag_ref (user_id);

create table if not exists tq_tagomizer.user_doc_ref  (
   document_id text not null REFERENCES  tq_tagomizer.document (document_id),
   user_id text not null REFERENCES  tq_tagomizer.user (id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.user_doc_ref TO tq_proxy;
create index if not exists udr_did on tq_tagomizer.user_doc_ref (document_id);
create index if not exists udr_uid on tq_tagomizer.user_doc_ref (user_id);

create table if not exists tq_tagomizer.group_doc_ref  (
   group_id text not null REFERENCES  tq_tagomizer.group (id),
   document_id text not null REFERENCES tq_tagomizer.document (document_id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.group_doc_ref TO tq_proxy;
create index if not exists gtr_did on tq_tagomizer.group_doc_ref (document_id);
create index if not exists gtr_uid on tq_tagomizer.group_doc_ref (group_id);

create table if not exists tq_tagomizer.group_user_ref  (
   group_id text not null REFERENCES  tq_tagomizer.group (id),
   user_id text not null REFERENCES tq_tagomizer.user (id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.group_user_ref TO tq_proxy;
create index if not exists gur_did on tq_tagomizer.group_user_ref (user_id);
create index if not exists gur_uid on tq_tagomizer.group_user_ref (group_id);


create table if not exists tq_tagomizer.group_tag_ref  (
   tag_id text not null REFERENCES  tq_tagomizer.tag (id),
   group_id text not null REFERENCES  tq_tagomizer.group (id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.group_tag_ref TO tq_proxy;
create index if not exists gttr_tid on tq_tagomizer.group_tag_ref (tag_id);
create index if not exists gttr_uid on tq_tagomizer.group_tag_ref (group_id);

--
--	Annotations are text objects, abstracts. They go with URLs - specific documents.
--	We do not pivot on Annotations; they are the content of a URL (resource) view
--  Both text and annnotations go into this table
--
create table if not exists tq_tagomizer.annotations  (
   document_id text not null REFERENCES  tq_tagomizer.document (document_id),
   text text not null,
   language varchar (3)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.annotations TO tq_proxy;
-- CREATE INDEX IF NOT EXISTS tsv_annot_en_idx ON tq_tagomizer.annotations USING gin(tsvecs);
CREATE INDEX IF NOT EXISTS tsv_annot_en_idx ON tq_tagomizer.annotations USING gin(to_tsvector('english', text)) WHERE language = 'en';
create index if not exists annotations_uid on tq_tagomizer.annotations (document_id);

create table if not exists tq_tagomizer.triples  (
    document_id text not null REFERENCES  tq_tagomizer.document (document_id),
   	subject text not null,
   	predicate text not null,
   	object text not null
);

GRANT ALL PRIVILEGES ON tq_tagomizer.triples TO tq_proxy;
