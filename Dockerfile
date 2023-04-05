FROM maven:3.8-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true

FROM openjdk:19-jdk-alpine
COPY --from=build /usr/src/app/target/url-shortener-api-0.0.1-SNAPSHOT.jar /usr/src/app/url-shortener-api-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/url-shortener-api-0.0.1-SNAPSHOT.jar"]
