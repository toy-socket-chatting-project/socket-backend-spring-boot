FROM amazoncorretto:11-alpine3.18

WORKDIR /app

COPY . .
RUN ./gradlew clean build
RUN rm -rf build/libs/*-plain.jar

ENTRYPOINT java -jar build/libs/*.jar