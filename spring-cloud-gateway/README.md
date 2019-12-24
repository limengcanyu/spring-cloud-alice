# spring-cloud-gateway

## route auth

http://localhost:8780/security/auth/register

## route microservice1

https://localhost:8780/microservice1/echo/str
http://localhost:8780/microservice1/echo/str

http://localhost:8781/microservice1/echo/str
http://localhost:8782/microservice1/echo/str

http://localhost:8780/spring-cloud-microservice1/echo/str

服务启动3个实例，可以负载均衡

## route microservice2

http://localhost:8780/microservice2/

http://localhost:8780/spring-cloud-microservice2/

## see actuator

http://localhost:8780/actuator

## see actuator routes

https://localhost:8780/actuator/gateway/routes

输出:

[
	{
		"predicate": "Paths: [/spring-cloud-microservice2/**], match trailing slash: true",
		"route_id": "ReactiveCompositeDiscoveryClient_SPRING-CLOUD-MICROSERVICE2",
		"filters": [
			"[[RewritePath /spring-cloud-microservice2/(?<remaining>.*) = '/${remaining}'], order = 1]"
		],
		"uri": "lb://SPRING-CLOUD-MICROSERVICE2",
		"order": 0
	},
	{
		"predicate": "Paths: [/spring-cloud-microservice1/**], match trailing slash: true",
		"route_id": "ReactiveCompositeDiscoveryClient_SPRING-CLOUD-MICROSERVICE1",
		"filters": [
			"[[RewritePath /spring-cloud-microservice1/(?<remaining>.*) = '/${remaining}'], order = 1]"
		],
		"uri": "lb://SPRING-CLOUD-MICROSERVICE1",
		"order": 0
	},
	{
		"predicate": "Paths: [/spring-cloud-gateway/**], match trailing slash: true",
		"route_id": "ReactiveCompositeDiscoveryClient_SPRING-CLOUD-GATEWAY",
		"filters": [
			"[[RewritePath /spring-cloud-gateway/(?<remaining>.*) = '/${remaining}'], order = 1]"
		],
		"uri": "lb://SPRING-CLOUD-GATEWAY",
		"order": 0
	},
	{
		"predicate": "Paths: [/microservice1/**], match trailing slash: true",
		"route_id": "microservice1_route",
		"filters": [
			"[[StripPrefix parts = 1], order = 1]"
		],
		"uri": "lb://spring-cloud-microservice1",
		"order": 0
	},
	{
		"predicate": "Paths: [/microservice2/**], match trailing slash: true",
		"route_id": "microservice2_route",
		"filters": [
			"[[StripPrefix parts = 1], order = 1]"
		],
		"uri": "lb://spring-cloud-microservice2",
		"order": 0
	}
]

由输出可知，gateway的路由不仅可以通过指定配置的Paths，例如：/microservice1/**，还可以通过服务的Eureka实例名称，例如：/spring-cloud-microservice1/**
因此以下两种是相同效果：
http://localhost:8780/microservice1/echo/str
http://localhost:8780/spring-cloud-microservice1/echo/str

## delete routes using HTTP Method DELETE

https://localhost:8780/actuator/gateway/routes/microservice2_route

## 添加SSL配置

进入JDK bin目录，执行以下命令生成key文件 scg-keystore.p12

D:
cd D:\IdeaProjects-MyProjects\spring-cloud-alice\spring-cloud-gateway\src\main\resources
E:\Java\jdk1.8.0_202\bin\keytool -genkey -alias scg -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore scg-keystore.p12 -validity 3650

注：
https 访问后出现异常 javax.net.ssl.SSLException: Received fatal alert: certificate_unknown，原因是证书是非认证证书，需要申请认证证书

## GatewayAutoConfiguration 中定义了各种类型的 RouteDefinitionRepository
可以仿照 InMemoryRouteDefinitionRepository 构造自己的动态路由，路由信息从数据库中加载

### http 方式：

#### 新增路由

http://localhost:8780/route/save

{
    "id": "microservice2_route",
    "uri": "lb://spring-cloud-microservice2",
    "path": "Path=/microservice2/**",
}

#### 删除路由

http://localhost:8780/route/delete?routeId=microservice2_route

