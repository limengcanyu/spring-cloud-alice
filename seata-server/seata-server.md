# seata-server

Usage: sh seata-server.sh(for linux and mac) or cmd seata-server.bat(for windows) [options]
  Options:
    --host, -h
      The host to bind.
      Default: 0.0.0.0
    --port, -p
      The port to listen.
      Default: 8091
    --storeMode, -m
      log store mode : file、db
      Default: file
    --help

e.g.

linux and mac

sh seata-server.sh -p 8091 -h 127.0.0.1 -m file

windows

E:
cd E:\WorkSpace\IdeaProjects\spring-cloud-alice\seata-server\seata-server-1.1.0\seata\bin
seata-server.bat
