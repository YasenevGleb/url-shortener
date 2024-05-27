FROM openjdk:8
ADD target/urlshortener.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]