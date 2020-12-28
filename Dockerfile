FROM openjdk:15-alpine
WORKDIR /root/avenBot
COPY /build/libs/AvenBot-1.0-all.jar /root/avenBot
RUN java -jar AvenBot-1.0-all.jar