# add swagger-ui

添加依赖

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>

    <!-- com/google/common/base/Supplier.class 未定义异常添加依赖 -->
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>27.1-jre</version>
    </dependency>

swagger-ui 访问地址

    http://localhost:8771/swagger-ui.html

## skywalking

-javaagent:/Users/rock/IdeaProjects/spring-cloud-alice/skywalking-agent/agent/skywalking-agent.jar
-Dskywalking.agent.service_name=spring-cloud-microservice1
-Dskywalking.collector.backend_service=localhost:11800


### start skywalking

## start backend and ui

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/startup.sh

## backend-setup

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/oapService.sh

## ui-setup

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/webappService.sh

UI默认地址：localhost:8080

