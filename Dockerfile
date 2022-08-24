FROM openjdk:11
EXPOSE 8080
COPY /target/spring-rest-caragency-0.0.1-SNAPSHOT.jar car-api.jar
ENTRYPOINT ["java","-jar","/car-api.jar"]