FROM gradle:6.7.1-jdk15

MAINTAINER Andrii Shumylo "shumylo.a@gmail.com"

ENV APP_HOME=/var/app/

COPY . ${APP_HOME}
WORKDIR ${APP_HOME}
USER root
RUN gradle clean shadowJar --rerun-tasks --no-build-cache

ENV ARTIFACT_NAME=${APP_HOME}/build/libs/AvenBot-1.0-SNAPSHOT-all.jar

ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
