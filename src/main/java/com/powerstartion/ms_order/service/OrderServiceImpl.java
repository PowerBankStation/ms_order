package com.powerstartion.ms_order.service;

import com.powerstartion.ms_order.dto.SubscriptionDTO;
import com.powerstation.commonlibrary.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ProducerClass producer;


    public OrderServiceImpl(ProducerClass producer){
        this.producer = producer;
    }

    @Override
    public void makeOrder(SubscriptionDTO subscriptionDTO) {
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setOrderId(1);
        orderMessage.setSubscriptionId(subscriptionDTO.getId());
        logger.info("MS_ORDER:  Order created "+orderMessage.toString());

        this.producer.sendMessage(orderMessage);
    }

}
