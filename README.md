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
├─cloud-provider-hystrix-payment8001   hystrix (服务提供者)
├─cloud-provider-payment8002   eureka版 支付服务(服务提供者)
├─cloud-provider-payment8004   zookeeper版 服务提供者
├─cloud-provider-consul-payment8006   consul版 服务提供者
├─cloud-consumer-order-80      eureka版 订单服务(消费者)
├─cloud-consumer-zookeeper-order80   zookeeper版 消费者
├─cloud-consumer-consul-order80   consul版 消费者
├─cloud-consumer-feign-order80   open feign版 消费者
├─cloud-consumer-feign-hystrix-order80   hystrix 消费者
├─cloud-eureka-server7001      eureka 高可用服务注册中心
│─cloud-eureka-server7002      eureka 高可用服务注册中心
│─cloud-config-center-3344      config 服务配置中心
│─cloud-config-client-3355      config 客户端
│─cloud-config-client-3366      config 客户端
│─cloud-consumer-hystrix-dashboard9001      hystrix dashboard
│─cloud-stream-rabbitmq-provider8801      stream rabbitmq 消息发送
│─cloud-stream-rabbitmq-consumer8802      stream rabbitmq 消息接收
│─cloud-stream-rabbitmq-consumer8803      stream rabbitmq 消息接收
│─cloudalibaba-provider-payment9001      nacos
│─cloudalibaba-provider-payment9002      nacos
│─cloudalibaba-provider-payment9003      nacos服务提供
│─cloudalibaba-provider-payment9004      nacos服务提供
│─cloudalibaba-consumer-nacos-order83      nacos消费者
│─cloudalibaba-config-nacos-client3377      nacos配置中心
│─cloudalibaba-sentinel-service8401      sentinel
│─cloudalibaba-consumer-nacos-order84      nacos消费者带熔断84
│─seata-order-service2001      seata分布式事务 订单模块
│─seata-account-service2003      seata分布式事务 账户操作模块
│─seata-storage-service2002      seata分布式事务 库存操作模块

```


### host文件修改

- 127.0.0.1   eureka7001.com
- 127.0.0.1   eureka7002.com

### 软件要求
- JDK1.8
- MySQL5.7
- Maven3.5+
- Zookeeper 3.5.7
- Consul 1.7.1
- RabbitMQ 3.7
- Seata 0.90+
- Nacos 1.1.0+
