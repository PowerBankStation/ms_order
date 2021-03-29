package com.powerstartion.ms_order.controller;


import com.powerstartion.ms_order.dto.SubscriptionDTO;
import com.powerstartion.ms_order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    RestTemplate restTemplate;
    OrderService orderService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public OrderController(RestTemplate restTemplate, OrderService orderService) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{boxID}")
    public void makeOrder(@RequestParam String username, @PathVariable String boxID) {

        String subscriptionResourceUrl = "http://POWERSTATION-SUBSCRIPTION/api/v1/subscriptions/" + username;
        ResponseEntity<SubscriptionDTO> responseEntity = restTemplate.getForEntity(subscriptionResourceUrl, SubscriptionDTO.class);
        logger.info("MS_ORDER:  Getting user... ");
        orderService.makeOrder(responseEntity.getBody());
    }

}
