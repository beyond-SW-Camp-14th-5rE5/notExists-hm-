package com.nohm.cinema.service;

import com.nohm.cinema.aggregate.AccountStatus;
import com.nohm.cinema.aggregate.Member;
import com.nohm.cinema.repository.MemberRepository;

public class MemberService {

    private final MemberRepository mr = new MemberRepository();
    private Member loggedMember = null;

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
                System.out.println("❌ 비밀번호가 일치하지 않습니다.");
                return false;
            }

            if(foundMember.getAcntStatus() == AccountStatus.DEACTIVATED) {
                System.out.println("❌ 해당 계정은 비활성화 되어 있습니다.");
                return false;
            }
        } else {
            System.out.println("❌ 해당 아이디는 존재하지 않습니다.");
            return false;
        }

        loggedMember = foundMember;
        System.out.println("✅ 로그인 성공!");
        return true;
    }

    public Member getLoggedMember() {
        return loggedMember;
    }

    public void logoutMember() {
        if(loggedMember != null) {
            System.out.println("✅ " + loggedMember.getId() + "님 로그아웃 되었습니다.");
            loggedMember = null;
        } else {
            System.out.println("❌ 로그인된 사용자가 없습니다.");
        }
    }
}
