#!/bin/bash
app="fromscratch"
version="1.0-SNAPSHOT"
image="integrational/$app:$version"
docker run --rm --name $app -p 8080:8080 $image
