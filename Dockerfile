FROM maven:3.8.5-openjdk-8-slim
#FROM 3.8.5-openjdk-18-slim

ENV APP_HOME=/app
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME

# Install dependencies
COPY docker/maven/settings.xml /usr/share/maven/ref/
COPY pom.xml .
RUN --mount=type=cache,target=/usr/share/maven/ref/repository \
    mvn -B \
      -f pom.xml \
      -s /usr/share/maven/ref/settings.xml \
      dependency:go-offline

# Build
COPY src/ ./src/
RUN mvn package -Dmaven.test.skip

# Copy assets
COPY tmp/ $APP_HOME/tmp 

# Run
CMD java -jar ./target/profiler-0.0.1-SNAPSHOT.jar