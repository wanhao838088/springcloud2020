## SpringCloud

* 目前SpringCloud技术栈 更新列表

|服务注册中心|服务调用|服务降级|服务网关|服务配置|服务总线|
|:-|:-:|-:|-:|-:|-:|
|Eureka 停更|Ribbon 更新中|Hystrix 停更|Zuul 停更|Config 停更|Bus 停更|
|Zookeeper 更新中|LoadBalancer 更新中|Sentienl 更新中|Zuul2 更新中|Nacos 更新中|Nacos 更新中|
|Consul 更新中|Feign 停更|Resilience4j 更新中|Gateway 更新中|||
|Nacos 更新中|Open Feign 更新中||||

**项目结构** 

```
cloud2020 父maven聚合工程 

├─cloud-api-commons     公共模块
├─cloud-provider-payment8001   eureka版 支付服务(服务提供者)
├─cloud-provider-payment8002   eureka版 支付服务(服务提供者)
├─cloud-provider-payment8004   zookeeper版 服务提供者
├─cloud-provider-consul-payment8006   consul版 服务提供者
├─cloud-consumer-order-80      eureka版 订单服务(消费者)
├─cloud-consumer-zookeeper-order80   zookeeper版 消费者
├─cloud-consumer-consul-order80   consul版 消费者
├─cloud-eureka-server7001      eureka 高可用服务注册中心
│─cloud-eureka-server7002      eureka 高可用服务注册中心
```


### host文件修改

- 127.0.0.1   eureka7001.com
- 127.0.0.1   eureka7002.com

### 软件需求
- JDK1.8
- MySQL5.7
- Maven3.5+
- Zookeeper 3.5.7
- Consul 1.7.1
