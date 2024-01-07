package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    // Member 클래스의 team 객체랑 매핑
    // mappedBy 가 있으면 연관관계 주인이 아님
    // members는 조회만 가능하고 등록 수정은 안됨
    // 1 : N -> N 쪽을 연관관계 주인으로 잡자 (외래키를 갖고 있기 때문)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    // 편의메서드2
    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

}
