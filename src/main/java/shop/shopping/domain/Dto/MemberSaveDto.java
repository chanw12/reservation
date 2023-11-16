package shop.shopping.domain.Dto;


import lombok.Getter;
import shop.shopping.domain.Member;

import jakarta.validation.constraints.Pattern;


@Getter
public class MemberSaveDto {

    private String muserid;
    private String m_pwd;

    private String m_name;

    private String m_birth;

    private String m_gender;

    private String m_email;
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "핸드폰 번호의 형식과 맞지 않습니다.")
    private String m_phonenumber;

    private Member.USERTYPE m_utype;


    public Member toEntity(){
        Member member = new Member(muserid,m_pwd,m_name,m_birth,m_email,m_gender,m_phonenumber,m_utype);
        return member;
    }
}
