package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem_bk {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order_bk order;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")

    private Item_bk item;

    public Order_bk getOrder() {
        return order;
    }

    public void setOrder(Order_bk order) {
        this.order = order;
    }

    public Item_bk getItem() {
        return item;
    }

    public void setItem(Item_bk item) {
        this.item = item;
    }

    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
