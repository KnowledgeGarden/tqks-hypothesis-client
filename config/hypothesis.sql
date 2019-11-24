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
   id text not_null,
   document_id text not null
   group_id text not null
);

create index if not exists huser_idx on tq_tagomizer.huser (id);
create index if not exists huser_dix on tq_tagomizer.huser (document_id);
create index if not exists huser_gid on tq_tagomizer.huser(group_id);
GRANT ALL PRIVILEGES ON tq_tagomizer.huser TO tq_proxy;

/*
	A document exists for each Hypothes.is URL within the context of a Group, and
		Users in that Group. The document  row comes into being on the first user event.
		Subsequent annotations can be with other users.
	We pivot on URLs (resources)
	document_id is the id given in a hypothesis document
*/
create table if not exists tq_tagomizer.document  (
    document_id text not null,
   	url text not null,
   	title text not null,
   	created text not null.
   	group_id text not null,
   	user_id text not null REFERENCES  tq_tagomizer.huser (id)
);

create unique index if not exists document_url_idx on tq_tagomizer.document (url);
create index if not exists document_did on tq_tagomizer.document(document_id);
GRANT ALL PRIVILEGES ON tq_tagomizer.document TO tq_proxy;

/*
	A tag exists within the context of one or more documents.
	We pivot on tags.
*/
create table if not exists tq_tagomizer.tag  (
   id text primary key,
   name text not null,
   group_id text not null
);

create unique index if not exists tag_uid_idx on tq_tagomizer.tag (name);
GRANT ALL PRIVILEGES ON tq_tagomizer.tag TO tq_proxy;

/*
	There can be many different Groups in this database. Many different documents and tags
	are created by varieties of users within groups.
	We pivot on Groups.
*/
create table if not exists tq_tagomizer.groups  (
   group_id text not null,
   document_id text not null REFERENCES  tq_tagomizer.document (document_id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.groups TO tq_proxy;
create index if not exists groups_gid on tq_tagomizer.groups(group_id);

/*
	Annotations are text objects, abstracts. They go with URLs - specific documents.
	We do not pivot on Annotations; they are the content of a URL (resource) view
*/
create table if not exists tq_tagomizer.annotations  (
   document_id text not null REFERENCES  tq_tagomizer.document (document_id),
   text text not null
}

GRANT ALL PRIVILEGES ON tq_tagomizer.annotations TO tq_proxy;
CREATE INDEX IF NOT EXISTS tsv_annot_en_idx ON tq_tagomizer.annotations USING gin(to_tsvector('english', label)) WHERE language = 'eng';

/*
	Texts are text objects, additional to abstracts. They go with URLs - specific documents.
	We do not pivot on Texts; they are the content of a URL (resource) view
	I decided: we will put everything in Annotations and drop texts
*/
create table if not exists tq_tagomizer.texts  (
   document_id text not null REFERENCES  tq_tagomizer.document (document_id),
   text text not null
}

GRANT ALL PRIVILEGES ON tq_tagomizer.texts TO tq_proxy;
CREATE INDEX IF NOT EXISTS tsv_texts_en_idx ON tq_tagomizer.texts USING gin(to_tsvector('english', label)) WHERE language = 'eng';

--
-- annotationId docId userid ??? user-docu reference
--
create table if not exists tq_tagomizer.reference  (
   document_id text not null REFERENCES  tq_tagomizer.document (id),
   user_id text not null REFERENCES  tq_tagomizer.huser (id)
);
GRANT ALL PRIVILEGES ON tq_tagomizer.reference TO tq_proxy;


/*
	TAG - Resource (URL) pivot
*/
--
create table if not exists tq_tagomizer.tag_ref  (
   tag_id text references tq_tagomizer.tag (id)REFERENCES tq_tagomizer.tag (id),
   document_id text references tq_tagomizer.reference (document_id) REFERENCES  tq_tagomizer.document (document_id),
   group_id text references tq_tagomizer.groups (group_id)
   primary key (tag_id, document_id)
);

GRANT ALL PRIVILEGES ON tq_tagomizer.tag_ref TO tq_proxy;
create index if not exists tagref_tid on tq_tagomizer.tag_ref(tag_id);
