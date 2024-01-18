package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // @Column(name = "TEAM_ID")
    // private Long teamId;
    @ManyToOne(fetch = FetchType.LAZY) //
    @JoinColumn(name = "TEAM_ID")
    private Team team;



    // 편의 메서드 1
//    public void setTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

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

//    public Team getTeam() {
//        return team;
//    }


}
