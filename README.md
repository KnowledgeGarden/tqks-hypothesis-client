# tqks-hypothesis-client
Client for harvesting hypothes.is annotations<br/>
## Goals
In a knowledge garden ecosystem, we seek to support the use of _hypothes.is_ annotations and tags; the approach is to create private _groups_, work with those, then import them into the garden.

## Building
This is an Eclipse project; it self-builds. But, in terms of Maven building, this command line will build it:<br/>
```mvn clean install -DskipTests -Dgpg.skip``` 
## Persistence
There one database in play, PostgreSql

## Postgres
Pivots are stored in Postgres. Database names and schema are declared in /config/harvester-props-templaate.xml which must be renamed to harvester-props.xml and any "changeme" values set as needed. In fact, of crucial importance is the single group identifier for Hypothes.is, and a list of such groups, and the DeveloperToken.

A Postgres database is created with the name defined in harvester-props.xml -- "tagomizer_database" in the present case, encoding = "UTF-8", and that database is initialized with /config/hypothesis.sql

## Running
The system is now capable of harvesting from a list of Hypothes.is groups, as configured in /config/harvester-props.xml. It maintains the required *cursor* to know where to start harvesting each time it is booted. They are maingained in a JSON file called *Cursors.json* in the root directory.

## Roadmap
This codebase will soon add a Kafka producer client to allow it to live in a Kafka-based AI ecosystem.
