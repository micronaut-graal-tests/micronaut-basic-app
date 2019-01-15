./gradlew assemble
docker build . -t basic-app
docker run --network host basic-app
