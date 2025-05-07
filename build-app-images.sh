#!/bin/bash

cd server
./mvnw clean spring-boot:build-image \
    -Dspring-boot.build-image.imageName=${IMG_PREFIX:-example/spring-ssl-bundles-demo}-server:1.0
cd ..

cd client
./mvnw clean spring-boot:build-image \
    -Dspring-boot.build-image.imageName=${IMG_PREFIX:-example/spring-ssl-bundles-demo}-client:1.0
cd ..
