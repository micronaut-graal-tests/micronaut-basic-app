./gradlew assemble
native-image --no-fallback --class-path build/libs/basic-app-*-all.jar
