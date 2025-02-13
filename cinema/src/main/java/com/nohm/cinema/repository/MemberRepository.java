package com.nohm.cinema.repository;

import com.nohm.cinema.Stream.MyObjectOutput;
import com.nohm.cinema.aggregate.AccountStatus;
import com.nohm.cinema.aggregate.Member;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File memfile =
            new File("cinema/src/main/java/com/nohm/cinema/db/memberDB.dat");

    public MemberRepository() {

        if(!memfile.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1,"user01","pass01","19970628", AccountStatus.ACTIVE));
            defaultMembers.add(new Member(2,"user02","pass02","19970628", AccountStatus.ACTIVE));
            defaultMembers.add(new Member(3,"user03","pass03","19970628", AccountStatus.ACTIVE));
            defaultMembers.add(new Member(4,"user04","pass04","19970628", AccountStatus.ACTIVE));
            defaultMembers.add(new Member(5,"user05","pass05","19970628", AccountStatus.ACTIVE));

            saveMembers(defaultMembers);
        }

        loadMembers();
    }

    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(memfile)
                )
        )) {
            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch ( EOFException e) {
            System.out.println("회원 정보 다 읽음");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void saveMembers(ArrayList<Member> defaultMembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(memfile)
                    )
            );
            for (Member member : defaultMembers) {
                oos.writeObject(member);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int selectLastMemberNo() {
        Member lastMember = memberList.get(memberList.size()-1);
        return lastMember.getMemNo();
    }

    public int insertMember(Member member) {
        MyObjectOutput moo = null;
        int result = 0;

        try{
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream(memfile,true)
                    )
            );

            moo.writeObject(member);

            memberList.add(member);

            result = 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}




