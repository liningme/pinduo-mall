package com.pd;

import com.pd.pojo.PdOrder;
import com.pd.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//从orderQueue队列获取订单消息
@RabbitListener(queues = "orderQueue")
@Component
public class OrderConsumer {
    @Autowired
    private OrderService orderService;

    // 配合RabbitListener 注解，指定处理消息的方法
    // RabbitHandler只能指定一个消息处理方法
    @RabbitHandler
    public void receive(PdOrder pdOrder) throws Exception {
        orderService.saveOrder(pdOrder);
        System.out.println("-------订单已经存储到数据库");
    }
}
