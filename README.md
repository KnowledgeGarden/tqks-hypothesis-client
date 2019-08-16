# tqks-hypothesis-client
Client for harvesting hypothes.is annotations<br/>
## Goals
In a knowledge garden ecosystem, we seek to support the use of _hypothes.is_ annotations and tags; the approach is to create private _groups_, work with those, then import them into the garden.

## Building
This is an Eclipse project; it self-builds. But, in terms of Maven building, this command line will build it:<br/>
```mvn clean install -DskipTests -Dgpg.skip``` 
## Persistence
There are two databases in play.
### ElasticSearch
All processed annotations go into ElasticSearch.<br/>
We are running on ES 6.2.4. The index is controlled in config files in /config/ and mappings determined by mappings.json

## Postgres
Pivots are stored in Postgres. Database names and schema are declared in /config/harvester-props-templaate.xml which must be renamed to harvester-props.xml and any "changeme" values set as needed. In fact, of crucial importance is the single group identifier for Hypothes.is, or a list of such groups, and the DeveloperToken.

A Postgres database is created with the name defined in harvester-props.xml -- "tagomizer_database" in the present case, encoding = "UTF-8", and that database is initialized with /config/newpivots.sql

## Running
At this time, the codebase supports only a single groupId at a time. This is because, at present, it maintains a single *cursor* to know where to start harvesting each time it is booted.<br/>
The roadmap includes cursors for each group to be harvested, as well as a timer to schedule harvests. The cursor is maintained in a flat file called "cursor" in the root directory. That will change.