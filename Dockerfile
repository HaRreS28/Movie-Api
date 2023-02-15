FROM  maven:3.8.7-eclipse-temurin-19-alpine as MAVEN_BUILD
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn clean package

FROM openjdk:19-slim-buster
EXPOSE 8080
COPY --from=MAVEN_BUILD target/MovieAPI-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]