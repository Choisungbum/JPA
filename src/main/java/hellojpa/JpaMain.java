package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setName("hello");
            member.setHomeAddress(new Address("city", "street", "zipcode"));
            member.setWorkPeriod(new Period());

            em.persist(member);
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addCHild(child1);
//            parent.addCHild(child2);
//
//            //1.  모두 persist 해준다(Not CASECADE)
////            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//            // 2. CASECADE
////            em.persist(parent);
//            //3. 고아객체 제거 (orphanRemoval = true)
//            em.persist(parent);
//            em.flush();
//            em.clear();
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR : " + e);
            tx.rollback();
        } finally {
            // 실제 동장 코드 작성
            em.close();
        }

        // 실제 애플리케이션 종료시 매니저 팩토리 닫기
        emf.close();

    }
}
