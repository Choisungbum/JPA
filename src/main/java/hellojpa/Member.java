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

    // 기간 Period
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    @Embedded // 둘 중 하나만 사용해도 됨
    private Period workPeriod;
    // 주소
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    // 주소 -> 같은 클래스로 만들 경우 Repeated column in mapping ... -> 에러발생
    // @AttributeOerrides 사용
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
    }
    )
    @Embedded
    private Address workAddress;

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

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    //    public Team getTeam() {
//        return team;
//    }


}
