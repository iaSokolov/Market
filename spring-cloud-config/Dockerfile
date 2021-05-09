FROM openjdk:11.0.4-jre-slim

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-Xmx200m", "-jar", "/app.jar"]

HEALTHCHECK --interval=5s --timeout=10s --retries=3 CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888