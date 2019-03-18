./gradlew assemble
native-image --no-server --class-path build/libs/basic-app-0.1-all.jar
