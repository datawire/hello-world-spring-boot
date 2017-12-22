# Hello, World (Java/Spring Boot)

This is a Java/Spring Boot template for building a microservice in Kubernetes and Docker. This template is designed for use with [Forge](https://forge.sh), [Telepresence](https://www.telepresence.io), and [Ambassador](https://www.getambassador.io).

# Repository structure

The main files in this repository are:

* `Dockerfile` specifies how the application is built and packaged
* `k8s/deployment.yaml` contains a templated Kubernetes manifest, with additional annotations for configuring Ambassador
* `service.yaml` contains values (typically configured by a developer) that will be instantiated into the Kubernetes manifest. This `service.yaml` has also been configured to support [fast incremental container builds with Forge](https://forge.sh/docs/reference/customize-container-builds#enabling-incremental-builds).
* `src/` contains the actual Java application

# Usage

* To deploy this service into Kubernetes from source, type `forge deploy`. If you want to expose this service automatically through an API Gateway, make sure you've installed Ambassador first
* To run this service locally via Telepresence:
  * Build a local dev environment: `docker build . -t spring-boot-dev-local`
  * Deploy into Kubernetes, if you haven't already ('forge deploy')
  * Run Telepresence: `telepresence --swap-deployment hello-spring-master --docker-run --rm -i -t spring-boot-dev-local`

# License

Licensed under Apache 2.0. Please see [LICENSE](LICENSE) for details.
