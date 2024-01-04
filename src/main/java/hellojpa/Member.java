package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 처음 로딩될 떄 @Entity를 작성해줘야 JPA를 사용하는 클래스인지 알 수 있다.
@Entity
//@Table(name = "USER") // 매핑할 테이블의 이름을 적어줌
public class Member {
    // DB PK와 패핑
    @Id
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
