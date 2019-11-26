FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
COPY . /home/app/basic-app
WORKDIR /home/app/basic-app
RUN gu install native-image
RUN native-image --no-server --static -cp build/libs/basic-app-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/basic-app/basic-app /app/basic-app
ENTRYPOINT ["/app/basic-app"]
