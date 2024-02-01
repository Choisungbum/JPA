package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 값 타입 컬렉션 ////////////////////////////////////////
            Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(new Address("homeCity", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

//            member.getAddressHistory().add(new Address("old1", "street", "10000"));
//            member.getAddressHistory().add(new Address("old2", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));


            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("==========START==========");
            Member findMember = em.find(Member.class, member.getId());

            // homeCity -> newCity
            // findMember.getHomeAddreess().setCity("newCIty") -> x
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity",a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            // 해당 쿼리가 정상동작 하려면 equals가 제대로 정의되어 있어야한다
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));
            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

            // 값 타입 조회
//            System.out.println("==========지연로딩==========");
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

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
