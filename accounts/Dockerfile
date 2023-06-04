FROM openjdk:11-slim as build

MAINTAINER ANUJ

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts.jar

ENTRYPOINT ["java","-jar","/accounts.jar"]