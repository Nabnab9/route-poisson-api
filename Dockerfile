FROM openjdk:8-jdk-alpine
MAINTAINER nabnab.fr
COPY target/route-poisson-api-0.0.1-SNAPSHOT.jar route-poisson-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/route-poisson-api-0.0.1-SNAPSHOT.jar"]
