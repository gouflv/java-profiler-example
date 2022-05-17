# syntax=docker/dockerfile:1
FROM maven:3.8-openjdk-8-slim
# 
ENV APP_HOME=/app
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME

COPY .mvn/ $APP_HOME/.mvn
COPY mvnw pom.xml $APP_HOME/

RUN ./mvnw dependency:go-offline

# 
COPY src ./src

CMD ["./mvnw", "spring-boot:run"]