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

    public void loginMember() {
    }
}
