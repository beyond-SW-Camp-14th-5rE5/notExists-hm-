package com.nohm.cinema.service;

import com.nohm.cinema.aggregate.AccountStatus;
import com.nohm.cinema.aggregate.Member;
import com.nohm.cinema.repository.MemberRepository;

public class MemberService {

    private final MemberRepository mr = new MemberRepository();

    public MemberService() {
    }

    public void registMember(Member member) {
        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);

        member.setAcntStatus(AccountStatus.ACTIVE);

        int result = mr.insertMember(member);
    }

    public void findMyProfile(int memNo) {
    }

    public Member findMemberForMod(int memNo) {
        return null;
    }

    public void modifyMyProfile(Object reform) {
    }

    public void removeMember(int memNo) {
    }

    public boolean loginMember(Member member) {
        Member foundMember = mr.findById(member.getId());

        if(foundMember != null) {
            if(!foundMember.getPwd().equals(member.getPwd())) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                return false;
            }

            if(foundMember.getAcntStatus() == AccountStatus.DEACTIVATED) {
                System.out.println("해당 계정은 비활성화 되어 있습니다.");
                return false;
            }
        } else {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return false;
        }

        System.out.println("로그인 성공!");
        return true;
    }
}
