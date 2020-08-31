# skywalking

## start backend and ui

linux:

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/startup.sh

windows:

D:/apache-skywalking-apm-8.1.0/apache-skywalking-apm-bin/bin/startup.bat

tail -fn 300 skywalking-oap-server.log
tail -fn 300 webapp.log

## start backend-setup

linux:

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/oapService.sh

windows:

D:/apache-skywalking-apm-8.1.0/apache-skywalking-apm-bin/bin/oapService.bat

## start ui-setup

linux:

/Users/rock/Downloads/apache-skywalking-apm-bin/bin/webappService.sh

windows:

D:/apache-skywalking-apm-8.1.0/apache-skywalking-apm-bin/bin/webappService.bat

UI默认地址：

localhost:8080

## set Backend storage for MySQL

将 mysql-connector-java-8.0.21.jar 放到 D:\apache-skywalking-apm-8.1.0\apache-skywalking-apm-bin\oap-libs 中

修改 D:\apache-skywalking-apm-8.1.0\apache-skywalking-apm-bin\config\application.yml

需事先建数据库 swtest

``````
storage:
  selector: ${SW_STORAGE:mysql}
  mysql:
    properties:
      jdbcUrl: ${SW_JDBC_URL:"jdbc:mysql://localhost:3306/swtest?serverTimezone=Asia/Shanghai"}
      dataSource.user: ${SW_DATA_SOURCE_USER:root}
      dataSource.password: ${SW_DATA_SOURCE_PASSWORD:root@1234}
      dataSource.cachePrepStmts: ${SW_DATA_SOURCE_CACHE_PREP_STMTS:true}
      dataSource.prepStmtCacheSize: ${SW_DATA_SOURCE_PREP_STMT_CACHE_SQL_SIZE:250}
      dataSource.prepStmtCacheSqlLimit: ${SW_DATA_SOURCE_PREP_STMT_CACHE_SQL_LIMIT:2048}
      dataSource.useServerPrepStmts: ${SW_DATA_SOURCE_USE_SERVER_PREP_STMTS:true}
    metadataQueryMaxSize: ${SW_STORAGE_MYSQL_QUERY_MAX_SIZE:5000}
``````

## Alarm

alarm rule definition file: config/alarm-settings.yml




