package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member_bk {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Embedded
    private Address_bk address;

    @OneToMany(mappedBy = "member")
    private List<Order_bk> orders = new ArrayList<>();

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

    public List<Order_bk> getOrders() {
        return orders;
    }

    public void setOrders(List<Order_bk> orders) {
        this.orders = orders;
    }
}
