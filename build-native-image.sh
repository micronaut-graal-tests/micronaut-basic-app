./gradlew assemble
native-image --no-server --static --no-fallback --class-path build/libs/basic-app-*-all.jar
