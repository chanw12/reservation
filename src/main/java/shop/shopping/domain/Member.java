package shop.shopping.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@AllArgsConstructor
public class Member {
    public enum USERTYPE{
        MANAGER,USER
    }

    @Id
    @GeneratedValue(generator = "member_generator")
    @GenericGenerator(name = "member_generator",parameters = @org.hibernate.annotations.Parameter(name ="prefix",value="MB"),strategy =  "shop.shopping.domain.Generator.CustomGenerator")
    private String m_id;

    @Column(length = 1000,nullable = false)
    private String m_pwd;

    @Column
    private String m_name;

    @Column
    private String m_birth;

    @Column
    private String m_email;
    @Column
    private String m_gender;

    @Column  //가입일
    @CreatedDate
    private LocalDateTime m_sd;

    @Column
    private String m_phonenumber;

    @Column
    @Enumerated(EnumType.STRING)
    private USERTYPE m_utype;


    @OneToMany(mappedBy = "MEMBER")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Member(String m_pwd, String m_name, String m_birth, String m_email, String m_gender, String m_phonenumber, USERTYPE m_utype) {
        this.m_pwd = m_pwd;
        this.m_name = m_name;
        this.m_birth = m_birth;
        this.m_email = m_email;
        this.m_gender = m_gender;
        this.m_phonenumber = m_phonenumber;
        this.m_utype = m_utype;
    }
}
