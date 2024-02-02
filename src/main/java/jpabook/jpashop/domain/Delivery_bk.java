package jpabook.jpashop.domain;

import hellojpa.BaseEntity;

import javax.persistence.*;

@Entity
public class Delivery_bk extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address_bk address;
//    private

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order_bk order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address_bk getAddress() {
        return address;
    }

    public void setAddress(Address_bk address) {
        this.address = address;
    }

    public Order_bk getOrder() {
        return order;
    }

    public void setOrder(Order_bk order) {
        this.order = order;
    }
}

