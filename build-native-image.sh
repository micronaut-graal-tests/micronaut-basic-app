./gradlew assemble
native-image --no-server --class-path build/libs/basic-app-*.jar
