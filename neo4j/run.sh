#!/usr/bin/env bash

neo4j start &

echo "waiting for neo4j to start ..." \
&& sleep 15 \
&& echo "Executing init scripts ..." \
&& cypher-shell -u neo4j -p examplepw -f init.cql &

sleep 9999999 &

wait