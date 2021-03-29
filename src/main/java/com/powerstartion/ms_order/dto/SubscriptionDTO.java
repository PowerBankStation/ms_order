package com.powerstartion.ms_order.dto;

import com.powerstartion.ms_order.enums.SubscriptionStatus;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class SubscriptionDTO {

    private int id;
    private SubscriptionStatus status;
    private String username;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Instant creationDate;

}