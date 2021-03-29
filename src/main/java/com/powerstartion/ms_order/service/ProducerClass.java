package com.powerstartion.ms_order.service;

import com.powerstation.commonlibrary.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerClass {
    private static final Logger logger = LoggerFactory.getLogger(ProducerClass.class);
    private static final String TOPIC = "BILLING";
    private KafkaTemplate<String, OrderMessage> kafkaTemplate;

            public ProducerClass(KafkaTemplate<String, OrderMessage> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(OrderMessage message) {
        logger.info("********* Producer send " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }


}
