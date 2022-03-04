FROM openjdk:11-jdk-slim
FROM maven:3.8-openjdk-11
WORKDIR ./app
ADD ./target/elevators /app
RUN apt-get update && apt-get install -y libx11-dev && apt-get install -y libgl1-mesa-glx && apt-get install libgtk-3-0 -y && apt-get install -qqy x11-apps
WORKDIR ./bin
RUN chmod +x elevatorsfx
CMD ./elevatorsfx
