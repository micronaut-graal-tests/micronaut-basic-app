FROM oracle/graalvm-ce:1.0.0-rc12 as graalvm
COPY . /home/app/basic-app
WORKDIR /home/app/basic-app
RUN ./build-native-image.sh

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/basic-app .
ENTRYPOINT ["./basic-app"]
