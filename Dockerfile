FROM openjdk:11
ADD ./target/a-control-0.0.1-SNAPSHOT.jar /app/
RUN mkdir /app/images
ENTRYPOINT ["java", "-jar", "/app/a-control-0.0.1-SNAPSHOT.jar"]
