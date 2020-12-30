FROM openjdk:15-jdk

MAINTAINER Andrii Shumylo "shumylo.a@gmail.com"

#install git
RUN apt-get install -y git
RUN git clone https://github.com/shumylo/AvenBot.git
#install gradle
RUN wget https://downloads.gradle-dn.com/distributions/gradle-6.7.1-bin.zip
RUN unzip gradle-6.7.1-bin.zip
ENV GRADLE_HOME /gradle-6.7.1
ENV PATH $PATH:/gradle-6.7.1/bin
#compile and run app
WORKDIR AvenBot
RUN gradle clean shadowJar --rerun-tasks --no-build-cache
ENTRYPOINT ["java", "-jar", "/AvenBot-1.0-SNAPSHOT-all.jar.jar"]
