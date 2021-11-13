FROM adoptopenjdk/openjdk11:alpine-jre
# Refer to Maven build -> finalName
ARG JAR_FILE=target/purbashaqms.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/purbashaqms.jar /opt/app/app.jar
COPY ${JAR_FILE} application.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","application.jar"]