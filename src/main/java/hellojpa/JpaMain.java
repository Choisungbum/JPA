package hellojpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // JPQL/////// ////////////////////////////////////////

            // JPQL
            List<Member> result = em.createQuery("select m From Member m where m.name like '%kim%'"
                    , Member.class).getResultList();

            // Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
            //루트 클래스 (조회를 시작할 클래스)
            Root<Member> m = query.from(Member.class);
            //쿼리 생성
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();

            // NativeSQL
            em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER")
                    .getResultList();


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
