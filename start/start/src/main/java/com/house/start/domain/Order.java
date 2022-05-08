package com.house.start.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime orderDate; // 주문 일시

    /*비즈니스로직*/
    
    private OrderStatus orderStatus; // 주문 상태 [카트, 주문, 취소, 완료]

    //==연관관계 편의 메서드==//
    public void setMember(Consumer consumer) {
        this.consumer = consumer;
        consumer.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //==생성 메서드==//

    /**
     *  주문 객체 생성
     */
    public static Order createOrder(Consumer consumer, Delivery delivery, OrderItem... orderItems) {

        // 현재 소비자 포인트 - 총 주문 포인트
        int totalOrderPoint = 0;

        Order order = new Order();
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
            totalOrderPoint += orderItem.getOrderPrice();
        }

        // 현재 소비자 포인트 - 총 주문 포인트
        int pointBeforeOrder = consumer.getPoint();
        int pointAfterOrder = pointBeforeOrder - totalOrderPoint; // 예외 처리 필요
        consumer.setPoint(pointAfterOrder);
        order.setConsumer(consumer);


        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

}
