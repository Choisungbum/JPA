package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //  default -> Entity 명, 자식에서 이 테이블에서 데이터를 넣었다는 것을 보여줌
public class Album extends Item {
    private String artist;
}
