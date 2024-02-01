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

            // 값 타입과 불변객체//////////////////////////////////////
            Address address = new Address("city", "street", "zipcode");

            Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setName("member2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            member.getHomeAddress().setCity("newCity");

            // 불변객체 생성 -> 생성자로 값을 초기화한 후 수정불가 (set -> x)
            Member member3 = new Member();
            member3.setName("member3");
            member3.setHomeAddress(address);
            em.persist(member3);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member3.setHomeAddress(newAddress);

            ///////////////////////////////////////////////////////

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
