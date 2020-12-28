FROM gradle:6.7.1-jdk15

MAINTAINER Andrii Shumylo "shumylo.a@gmail.com"

RUN cd /home/avenProject && git clone https://github.com/shumylo/AvenBot.git

COPY --chown=gradle:gradle . /home/avenProject
WORKDIR /home/avenProject
RUN gradle shadowJar --no-daemon

COPY ./build/libs/AvenBot-1.0-all.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "AvenBot-1.0-all.jar"]