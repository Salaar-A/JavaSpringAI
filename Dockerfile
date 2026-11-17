# Stage 1: build the JAR using Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /working
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: run it on a slim JRE
FROM eclipse-temurin:21-jre
WORKDIR /working
COPY --from=build /working/target/*.jar working.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "working.jar"]