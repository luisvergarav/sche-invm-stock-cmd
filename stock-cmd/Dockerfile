FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=/build/libs/stock-cmd-0.0.1.jar
COPY ${JAR_FILE} stock-cmd-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/stock-cmd-0.0.1.jar"]