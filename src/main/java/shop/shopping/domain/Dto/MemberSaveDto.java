package shop.shopping.domain.Dto;


import lombok.Getter;
import shop.shopping.domain.Member;



@Getter
public class MemberSaveDto {

    private String m_pwd;

    private String m_name;

    private String m_birth;

    private String m_gender;

    private String m_email;
    private String m_phonenumber;

    private Member.USERTYPE m_utype;


    public Member toEntity(){
        Member member = new Member(m_pwd,m_name,m_birth,m_email,m_gender,m_phonenumber,m_utype);
        return member;
    }
}
