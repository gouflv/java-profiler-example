FROM openjdk:8-oraclelinux7

ENV APP_HOME=/app
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME

# Install dependencies
COPY .mvn/ $APP_HOME/.mvn
COPY mvnw pom.xml docker/maven/settings.xml $APP_HOME/

RUN ./mvnw -s settings.xml dependency:go-offline

# Build & Run
COPY src $APP_HOME/src

CMD ["./mvnw", "package"]

CMD ["java -jar ./target/profiler-0.0.1-SNAPSHOT.jar"]