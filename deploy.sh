#!/bin/bash
sh ./mvnw clean package

java -jar ./target/profiler-0.0.1-SNAPSHOT.jar