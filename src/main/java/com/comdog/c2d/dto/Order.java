package com.comdog.c2d.dto; 

import java.time.LocalDateTime;

public class Order {

    private Long orderId;           // 주문 고유번호
    private Long memberId;          // 회원 고유번호
    private Integer totalAmount;    // 총 결제 금액
    private String orderStatus;     // 주문 상태
    private String paymentMethod;   // 결제 수단
    private String billingKey;      // 빌링 키
    private LocalDateTime createdAt; // 주문 일시

    // 기본 생성자 (MyBatis가 객체를 생성할 때 필요합니다)
    public Order() {
    }

    // 모든 필드를 초기화하는 생성자 (필요 시 사용)
    public Order(Long orderId, Long memberId, Integer totalAmount, String orderStatus, 
                 String paymentMethod, String billingKey, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.billingKey = billingKey;
        this.createdAt = createdAt;
    }

    // ================= Getter & Setter =================

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillingKey() {
        return billingKey;
    }

    public void setBillingKey(String billingKey) {
        this.billingKey = billingKey;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // 디버깅이나 로그 출력을 위해 toString()을 오버라이딩 해두면 편리합니다.
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", memberId=" + memberId +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", billingKey='" + billingKey + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}