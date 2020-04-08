# Sentinel

## 获取控制台

从 release 页面 下载最新版本的控制台 jar 包。

https://github.com/alibaba/Sentinel/releases

## 启动控制台

Sentinel 控制台是一个标准的 Spring Boot 应用，以 Spring Boot 的方式运行 jar 包即可。

``````
E:
cd E:\WorkSpace\IdeaProjects\spring-cloud-alice\sentinel
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.7.2.jar

``````

其中 -Dserver.port=8080 用于指定 Sentinel 控制台端口为 8080。

从 Sentinel 1.6.0 起，Sentinel 控制台引入基本的登录功能，默认用户名和密码都是 sentinel。可以参考 鉴权模块文档 配置用户名和密码。

## 配置控制台信息

``````
application.yml

spring:
  cloud:
    sentinel:
      transport:
        port: 8719
        dashboard: localhost:8080

``````

这里的 spring.cloud.sentinel.transport.port 端口配置会在应用对应的机器上启动一个 Http Server，该 Server 会与 Sentinel 控制台做交互。
比如 Sentinel 控制台添加了一个限流规则，会把规则数据 push 给这个 Http Server 接收，Http Server 再将规则注册到 Sentinel 中。
