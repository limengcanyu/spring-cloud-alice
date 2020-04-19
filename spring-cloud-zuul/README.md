# spring-cloud-zuul

## 调用 spring-cloud-zuul

localhost:8790/echo

## 调用 microservice1

localhost:8800/echo/123

localhost:8790/microservice1/echo/123

### upload

localhost:8790/zuul/uploadservice/upload

note:

add /zuul ，bypasses the Spring DispatcherServlet (to avoid multipart processing) . 

## 调用 microservice2

localhost:8790/microservice2/echo/123

## Management Endpoints

localhost:8790/actuator/health

By default, if you use @EnableZuulProxy with the Spring Boot Actuator, you enable two additional endpoints:

* Routes
* Filters

### Routes Endpoint

GET /routes

localhost:8790/actuator/routes

GET /routes/details

localhost:8790/actuator/routes?format=details

### Filters Endpoint

A GET to the filters endpoint at /filters returns a map of Zuul filters by type. For each filter type in the map, 
you get a list of all the filters of that type, along with their details.

localhost:8790/actuator/filters


