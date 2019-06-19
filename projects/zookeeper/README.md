# [Github](https://github.com/apache/zookeeper)

# [稳定版下载](https://www-us.apache.org/dist/zookeeper/stable/)
- apache-zookeeper-[version].tar.gz
Contains all the source files which can be built by running:
```
mvn clean package/install -Dmaven.test.skip=true
```
To generate an aggregated apidocs for zookeeper-server and zookeeper-jute:
```
mvn javadoc:aggregate
```
    (generated files will be at target/site/apidocs)
- apache-zookeeper-[version]-bin.tar.gz
	Contains all the jar files required to run ZooKeeper
	Full documentation can also be found in the docs folder

# 问题
```
错误: 找不到或无法加载主类 org.apache.zookeeper.server.quorum.QuorumPeerMain
```
需要利用maven进行打包
```
mvn clean package/install -Dmaven.test.skip=true
```

- 注意：打包后Windows系统使用zkServer.cmd启动还是报错，使用CMDER集成的bash命令去启动。

```
cd zookeeper-server
mvn clean package -Dmaven.test.skip=true //打包
cd ..
./bin/zkServer.sh start

./bin/zkServer.sh status

./bin/zkCli.sh -server 127.0.0.1:2181
```
