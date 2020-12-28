FROM gradle:6.7.1-jdk15 AS TEMP_BUILD_IMAGE

MAINTAINER Andrii Shumylo "shumylo.a@gmail.com"

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle shadowJar

# actual container
FROM adoptopenjdk/openjdk15:alpine-jre
ENV ARTIFACT_NAME=AvenBot-1.0-all.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}