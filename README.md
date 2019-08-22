# Housing Benefit Service (HBIS) Stub

[![Build Status](https://travis-ci.org/dwp/housing-benefit-service-stub.svg?branch=master)](https://travis-ci.org/dwp/housing-benefit-service-stub)

A very basic stub for the Housing Benefit External API. 

This stub allows those integrating with the Housing Benefit (HBIS) External API to test the validity of their requests.

The specification can be found in [src/main/resources/oas](src/main/resources/oas).

## Requirements

This stub requires [Java 11](https://adoptopenjdk.net/).

## Usage

Start stub with `./mvnw spring-boot:run`.

### Docker

The [Jib](https://github.com/GoogleContainerTools/jib) plugin is included to build [Docker](https://www.docker.com/) images.

To build to a local Docker daemon, use:

`./mvnw compile jib:dockerBuild`

Start the container:

`docker run -p 8080:8080 housing-benefit-service-stub:LATEST`

### Example requests

```
curl -H "Content-Type: application/json" \
     -H "correlationId: 12345678-1234-1234-1234-123456789012" \
     -H "apiKey: xQFmnA7KAO6705R52AmCVzH5JmklyaDf" \
     -d @src/test/resources/requests/claim-request-example-basic.json -v http://localhost:8080/housing-benefit/v1/external/claim
```

```
curl -H "Content-Type: application/json" \
     -H "correlationId: 12345678-1234-1234-1234-123456789012" \
     -H "apiKey: xQFmnA7KAO6705R52AmCVzH5JmklyaDf" \
     -d @src/test/resources/requests/claim-request-example-full.json -v http://localhost:8080/housing-benefit/v1/external/claim
```

Further example request bodies can be found in [src/main/resources/requests](src/test/resources/requests).

## Caveats

* Note that the error responses generated by this stub do not match those generated by the real service. See the specification for the format of error responses.

## References

* [OpenAPI Generator](https://openapi-generator.tech/)
* [OpenAPI Generator: Spring](https://openapi-generator.tech/docs/generators/spring)
* [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin)
* [Jib](https://github.com/GoogleContainerTools/jib)
