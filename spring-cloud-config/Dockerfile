FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/app.jar /usr/local/lib/app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

HEALTHCHECK --interval=5s --timeout=10s --retries=3 CMD curl -f http://localhost:8888/actuator/health || exit 1