# spring-ssl-bundles-demo

These applications demonstrate how to use SSL Bundles feature to secure server and client side spring-boot applications for both simple TLS and mutual TLS communications.

Before SSL bundles features in spring-boot, one would have had to load in CA certs using `keytool` and possibly create `SSLContext` and `SSLConnectionFactory` objects in java code and configure the `RestTemplate` on the client side. It was even harder to configure mutual TLS where both client and the server expect/verify TLS certs that are presented/served.

With SSL bundles, this is a lot easier, especially when those certs were signed using a self-signed CA. There are some pre-requisites to run these examples:

- Java 21
- A docker daemon running with the ability to pull OCI images from public docker registries

1. Compile the applications first and bundle them as OCI images by running: `./build-app-images.sh`
2. Run `docker compose up` to start the applications
3. In a different terminal run `curl -s http://localhost:8080/work; echo` - you should get back a list of superheroes.

To experiment, you can run the apps with either of the following spring profile combos (changeable in the `docker-compose.yml` file):

|  Client Profiles  |  Server Profiles  | Description                                                                                                                                                                                   |
|:-----------------:|:-----------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|     `default`     |     `default`     | No TLS is involved                                                                                                                                                                            |
|       `tls`       |       `tls`       | TLS is enabled on the server, client validates the certificate presented by the server                                                                                                        |
|   `tls,mutual`    |   `tls,mutual`    | Mutual TLS is enabled on the server, client validates the certificate presented by the server. Client also serves a certificate of its own, the server validates it on receiving the request  |