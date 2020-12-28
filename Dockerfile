FROM gradle:6.7.1-jdk15

MAINTAINER Andrii Shumylo "shumylo.a@gmail.com"

RUN mkdir avenProject

RUN cd avenProject && git clone https://github.com/shumylo/AvenBot.git

COPY --chown=gradle:gradle . avenProject
WORKDIR avenProject
RUN gradle shadowJar --no-daemon

COPY ./build/libs/AvenBot-1.0-all.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "AvenBot-1.0-all.jar"]