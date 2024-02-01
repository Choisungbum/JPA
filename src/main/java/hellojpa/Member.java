package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

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
//    @Embedded // 둘 중 하나만 사용해도 됨
//    private Period workPeriod;
    // 주소
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    @ElementCollection // 값타입 컬렉션 지정
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
            @JoinColumn(name = "MEMBER_ID") // 외래키 지정
    ) // 테이블 지정
    @Column(name = "FOOD_NAME") // 타입이 String 하나기 때문에 컬럼 지정
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection // 값타입 컬렉션 지정
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID") // 외래키 지정
//    ) // 테이블 지정
//    private List<Address> addressHistory = new ArrayList<>();

    // 값 타입 컬렉션 대안
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();


    // 주소 -> 같은 클래스로 만들 경우 Repeated column in mapping ... -> 에러발생
    // @AttributeOerrides 사용
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    }
//    )
//    @Embedded
//    private Address workAddress;

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

//    public Period getWorkPeriod() {
//        return workPeriod;
//    }
//
//    public void setWorkPeriod(Period workPeriod) {
//        this.workPeriod = workPeriod;
//    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    //    public Team getTeam() {
//        return team;
//    }


    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Member member = (Member) o;
//        return Objects.equals(addressHistory, member.addressHistory);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(addressHistory);
//    }
//
//    public List<AddressEntity> getAddressEntitiy() {
//        return addressEntitiy;
//    }
//
//    public void setAddressEntitiy(List<AddressEntity> addressEntitiy) {
//        this.addressEntitiy = addressEntitiy;
//    }
}
