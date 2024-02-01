package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_ex {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member_ex member = new Member_ex();
            member.setUsername("C");

            System.out.println("========================");
            em.persist(member);
            System.out.println("member.id = " + member.getId());
            System.out.println("========================");

            // 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);
            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());
            // 수정
//            findMember.setName("helloJPA");

            //객체를 생성한 상태(비영속)
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("회원1");

            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            // 1차캐시
//            Member findMember1 = em.find(Member.class, 100L);
//            Member findMember2 = em.find(Member.class, 100L);

            // 동일성 보장
//            System.out.println("result = " + (findMember1 == findMember2));

            // 트랜잭션을 지원하는 쓰기 지연
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("================================");

            // 변경감지
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            System.out.println("================================");



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
