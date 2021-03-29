package com.powerstartion.ms_order.enums;

public enum SubscriptionStatus {
    ACTIVE(0),
    BLOCKED(1),
    SUSPENDED(10);

    private int status;
    private SubscriptionStatus(int status){
        this.status = status;
    }

    public boolean equalsName(int otherStatus){
        return status == otherStatus;
    }

    @Override
    public String toString() {
        return "SubscriptionStatus{" +
                "status=" + status +
                '}';
    }
}
