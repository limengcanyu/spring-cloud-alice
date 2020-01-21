# Zipkin

### 三种启动方式

#### Docker

The Docker Zipkin project is able to build docker images, provide scripts and a docker-compose.yml for launching pre-built images. The quickest start is to run the latest image directly:

````
docker run -d -p 9411:9411 openzipkin/zipkin

````

#### Java

````
D:
cd D:\IdeaProjects-MyProjects\spring-cloud-alice\zipkin-server
java -jar zipkin-server-2.19.2-exec.jar

````

#### Running from Source

````
# get the latest source
git clone https://github.com/openzipkin/zipkin

cd zipkin
# Build the server and also make its dependencies
./mvnw -DskipTests --also-make -pl zipkin-server clean install

# Run the server
java -jar ./zipkin-server/target/zipkin-server-*exec.jar

````
