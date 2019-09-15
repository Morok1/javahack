FROM  maven:3.6.0-jdk-11-slim AS build

WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/javahack-0.0.1-SNAPSHOT.jar /app/target/javahack.jar
ENTRYPOINT java -jar /app/target/javahack.jar