package com.nohm.cinema.aggregate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

<<<<<<< HEAD
public class Member {
    private int memNo;
    private String id;
    private String pwd;
    private Date birth;
    private AccountStatus accountStatus;
=======
public class Member implements Serializable {
    private int memNo;                  //번호
    private String id;                  // 아이디
    private String pwd;                 // 비밀번호
    private LocalDate birth;            // 생년월일
    private AccountStatus acntStatus;   // 활성화 여부
>>>>>>> main

    public Member() {
    }

    public Member(int memNo, String id, String pwd, String birth, AccountStatus acntStatus) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.birth = LocalDate.parse(birth, DateTimeFormatter.BASIC_ISO_DATE);
        this.acntStatus = acntStatus;
    }

    public Member(String id, String pwd, String birth) {
        this.id = id;
        this.pwd = pwd;
        this.birth = LocalDate.parse(birth, DateTimeFormatter.BASIC_ISO_DATE);
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = LocalDate.parse(birth, DateTimeFormatter.BASIC_ISO_DATE);;
    }

    public AccountStatus getAcntStatus() {
        return acntStatus;
    }

    public void setAcntStatus(AccountStatus acntStatus) {
        this.acntStatus = acntStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNo=" + memNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birth=" + birth +
                ", acntStatus=" + acntStatus +
                '}';
    }
}
