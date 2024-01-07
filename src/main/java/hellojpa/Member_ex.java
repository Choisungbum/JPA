package hellojpa;

import javax.persistence.*;

// 처음 로딩될 떄 @Entity를 작성해줘야 JPA를 사용하는 클래스인지 알 수 있다.
@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class Member_ex {
    // DB PK와 패핑
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    // @Column(name = "name") : 테이블안의 컬럼명을 매핑
    @Column(name = "name", nullable = false)
    private String username;
//
//    private Integer age;
//    // @Enumerated(EnumType.STRING) : enum 타입으로 받을 수 있음
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    // @Temporal(TemporalType.TIMESTAMP) : DB는 Date, Time, Timestamp 세가지 날짜 형식을 가짐
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    // @Lob : CLOB,BLOB 등 크기가 큰 데이터를 다룬다 (문자 타입일 경우 기본 CLOB)
//    @Lob
//    private String description;
//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
