# spring-cloud-zipkin-server

启动后访问以下地址，可看到UI
http://127.0.0.1:9411

zipkin-server

zipkin-server is a Spring Boot application, packaged as an executable jar. You need JRE 8+ to start zipkin-server.
Span storage and collectors are configurable. By default, storage is in-memory, the http collector (POST /api/v2/spans endpoint) is enabled, and the server listens on port 9411.
