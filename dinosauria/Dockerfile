FROM maven:3.6.3-adoptopenjdk-11-openj9 as build
WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn package

FROM openjdk:11.0.7-jre-slim

ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
