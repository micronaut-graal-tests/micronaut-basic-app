# Micronaut basic app #

Test application for Micronaut and GraalVM that uses:

- "Hello world" controller that returns the name passed as parameter 
- Return a POJO wrapped in a reactive type (RxJava2 Single)
- Inject Service in a Controller
- CORS support enabled
- Return HTTP Response/HTTP Status with and without body

### Basic injection

```
curl localhost:8080/hello/Micronaut
```

### HTTP Status

```
curl -v localhost:8080/status/mutable-http-response-body
curl -v localhost:8080/status/http-response-body
curl -v localhost:8080/status/http-status
curl -v localhost:8080/status/annotation
```

### HTTP Client

```
curl -v localhost:8080/bintray/packages
curl -v localhost:8080/bintray/packages-lowlevel
```