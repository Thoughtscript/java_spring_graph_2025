# java_spring_graph_2025

[![](https://img.shields.io/badge/Spring%20Boot-3.4.3-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Neo4J-5-blue.svg)](https://neo4j.com)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)
[![](https://img.shields.io/badge/Docker-blue.svg)](https://www.docker.com/) 

Having some fun with [Spring Boot 3.4.3](https://spring.io/projects/spring-boot), [Neo4J](https://neo4j.com/product/cypher-graph-query-language/), and **Graph Databases**.

**AWS** [defines](https://aws.amazon.com/nosql/graph/) **Graph Databases** as follows:

    "A graph database is a systematic collection of data that emphasizes the relationships 
    between the different data entities. The NoSQL database uses mathematical graph theory 
    to show data connections."

I've used **Graph-Theoretic** approaches in several ways:

1. **NoSQL** - relational aggregation (in leiu of **JOIN** statements, **JOIN** tables, **Map-Reduce** operations, and/or multiple **DBRef**s) - mostly a mix of **Mongo DB**, **Dynamo DB**.
2. **GraphQL**
3. A bit of **AWS Neptune** and **Neo4J** (but without standing up the DB's or configuring them).

**Neo4J Cypher** uses [ASCII Art Syntax](https://neo4j.com/docs/cypher-manual/5/introduction/cypher-overview/) for queries typified by the scheme: 
* `(nodes)-[:CONNECT_TO]→(otherNodes)`
* `(MyNode)-[:VERB_OR_RELATION_TO]→(MyOtherNode)`

## Use

### Docker Compose

```bash
docker-compose up

# If using Docker Compose Engine V2:
docker compose up
```

### SSL

```bash
keytool -genkey \
  -alias bootexample \
  -keystore bootexample.p12 \
  -storetype PKCS12 \
  -keyalg RSA \
  -storepass af3DF*34afefwefehu \
  -validity 730 \
  -keysize 4096
```

## Tests, Testing, and Queries

Exec into the `neo4j` instance:
```bash
cypher-shell -u neo4j -p examplepw

$ > Match (c:Course {name: "Art"}) - [r:HAS_STUDENT] -> (s:Student) RETURN c, collect(r), collect(s);

$ > MATCH (c:Course {name: $courseName}) RETURN c;
```

> Other **CQL** queries are available [here](./neo4j/init.cql).

> (Some) Acceptance and Live Integration Tests are available [here](./_acceptance/Java%20Spring%20Graph.postman_collection.json) through **Postman**.

## Neo4J

* Access to the built-in view [here](http://localhost:7474/db/data/) is now [deprecated](https://stackoverflow.com/questions/76221610/http-localhost7474-db-data-returns-a-404-after-login).
* Using the recommended `docker-compose.yml` [setting](https://neo4j.com/docs/operations-manual/current/docker/docker-compose-standalone/): `NEO4J_AUTH=neo4j/examplepw` doesn't appear to stick. One can still log in afterwards with `neo4j/neo4j` (the default, and it will request an immediate password change). 
  * As such, I've opted to use `neo4j-admin set-initial-password examplepw` in the [Dockerfile](./neo4j/dockerfile) instead.

## Resources and Links

1. https://docs.spring.io/spring-data/neo4j/reference/getting-started.html
2. https://neo4j.com/docs/cypher-manual/current/queries/concepts
3. https://aws.amazon.com/nosql/graph
4. https://www.liquidweb.com/blog/neo4j-graph-database-installing-neo4j-on-ubuntu-20-04/
5. https://github.com/neo4j-examples/movies-java-spring-data-neo4j/tree/main
6. https://www.baeldung.com/spring-data-neo4j-intro
7. https://neo4j.com/docs/operations-manual/current/docker/docker-compose-standalone/