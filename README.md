# tqks-hypothesis-client
Client for harvesting hypothes.is annotations<br/>
## Goals
In a knowledge garden ecosystem, we seek to support the use of _hypothes.is_ annotations and tags; the approach is to create private _groups_, work with those, then import them into the garden.

## Building
This is an Eclipse project; it self-builds. But, in terms of Maven building, this command line will build it:<br/>
```mvn clean install -DskipTests -Dgpg.skip``` 
