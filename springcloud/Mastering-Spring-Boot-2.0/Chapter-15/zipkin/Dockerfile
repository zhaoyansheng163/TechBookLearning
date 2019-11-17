#This is a Dockerfile for a microservice application

# Use an official Java 8 runtime as a parent image
FROM maven:3.5-jdk-8-alpine

VOLUME /tmp

#Set maintainer email id
MAINTAINER admin@dineshonjava.com 

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Build and create jar using maven command
#RUN mvn package -DskipTests=true -Ddir=app

# Copy the current directory contents into the container at /app
ADD target/zipkin-0.0.1-SNAPSHOT.jar zipkin-0.0.1.jar

# Make port 8080 available to the world outside this container
EXPOSE 9411

# Define environment variable
ENV JAVA_OPTS=""

# Run accounts-microservice.jar when the container launches
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar zipkin-0.0.1.jar" ]