# 拼多商城

#### 介绍

1、目前业界主流的Spring Could微服务全家桶作为架构基础。

2、基于RabbitMQ可靠消息最终一致性实现分布式事务，实现订单流量削峰。

3、使用Elasticsearch实现商品的全文检索，提升检索的性能。

4、使用Docker+K8S实现开发运维一体化。


#### 软件架构

Spring Cloud + RabbitMQ + Docker + MyBatis + MySQL +  Elasticsearch + K8S


#### 流量削峰的业务实现

概述：引入 rabbitmq 消息队列，当购物系统产生订单后，生产者把订单数据发送到消息队列；而订单消费者应用从消息队列接收订单消息，并把订单保存到数据库。


##### 生产者-发送订单

1. pom.xml 添加依赖：spring-boot-starter-amqp

2. application.yml添加RabbitMQ的连接信息

3. 修改主程序，添加Queue实例

4. 修改 OrderServiceImpl

通过amqpTemplate实例的convertAndSend方法发送消息



##### 消费者-接收订单,并保存到数据库



0.  pd-web项目复制为pd-order-consumer

1.  修改 application.yml，把端口修改成 81

2.  新建 OrderConsumer：注入orderService，通过@RabbitListener(queues="orderQueue")从指定队列接收消息。

3.  修改 OrderServiceImpl 的 saveOrder() 方法，从RabbitMQ接收的订单数据中接收id

4.  application.yml中改为手动确认

5.  OrderConsumer添加hannel.basicAck(message.getMessageProperties().getDeliveryTag(), false);实现手动发送


#### Elasticsearch全文检索商品的实现

1. pom.xml 添加依赖：spring-boot-starter-amqp、spring-boot-starter-data-elasticsearch、lombok

2. 修改application.yml，添加elasticsearch配置信息

3. 创建Item的pojo

4. 定义ItemRepository 接口，其继承ElasticsearchRepository

5. 创建SearchService及其实现类

6. 添加SearchController，完成数据的封装和响应.




