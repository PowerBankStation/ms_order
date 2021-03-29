package com.powerstartion.ms_order.service;

import com.powerstartion.ms_order.dto.SubscriptionDTO;

public interface OrderService {
    void makeOrder(SubscriptionDTO  subscriptionDTO);
}
