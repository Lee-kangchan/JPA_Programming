package Prectice3.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) // 방언에 맞게 자동으로 hibernate가 직접 생성 ID값을 안넣어도 만들어줌
    private Long id;

    @Column(name = "USERNAME", nullable = false) // 속성이름을 USERNAME이고 not null 체크
    private String name;

    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

//    private LocalDateTime regDate;

    @Enumerated(EnumType.STRING) // ORDINAL 말고 현업에서는 STRING으로 왜냐하면 enum 순서가 바뀌면 큰일!
    private MemberType memberType;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}

