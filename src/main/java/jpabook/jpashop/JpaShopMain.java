package jpabook.jpashop;
import jpabook.jpashop.domain.Order_bk;
import jpabook.jpashop.domain.OrderItem_bk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaShopMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Order_bk order = new Order_bk();
            em.persist(order);

            OrderItem_bk orderItem = new OrderItem_bk();
            orderItem.setOrder(order);
            em.persist(orderItem);
//            order.addOrderItem(order);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            // 실제 동장 코드 작성
            em.close();
        }

        // 실제 애플리케이션 종료시 매니저 팩토리 닫기
        emf.close();
    }
}
