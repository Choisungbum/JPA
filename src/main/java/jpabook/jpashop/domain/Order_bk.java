package jpabook.jpashop.domain;

import hellojpa.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order_bk {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order") // One(현재 객체)ToMany(연관된 객체), mappedBy = order -> 연관관계에있는 객체에서 현재객체의 name
    private List<OrderItem_bk> orderItems = new ArrayList<>();

    // 편의 메서드
    private void addOrderItem(OrderItem_bk orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    private LocalDateTime orderdate;
    @Enumerated(EnumType.STRING)
    private OrderStatus_bk status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public LocalDateTime getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDateTime orderdate) {
        this.orderdate = orderdate;
    }

    public OrderStatus_bk getStatus() {
        return status;
    }

    public void setStatus(OrderStatus_bk status) {
        this.status = status;
    }
}
