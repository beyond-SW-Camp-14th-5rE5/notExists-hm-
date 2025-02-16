package com.nohm.cinema.run;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.aggregate.Member;
import com.nohm.cinema.aggregate.Movie;
import com.nohm.cinema.service.MemberService;
import com.nohm.cinema.service.MovieService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();
    private static final MovieService mvs = new MovieService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("==== 영화 예매 프로그램 ====");
            System.out.println("1. 상영 중인 영화 목록 조회");
            System.out.println("2. 장르별 영화 검색");

            System.out.println("3. 로그인");
            System.out.println("4. 회원 가입");

            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input){
                case 1: mvs.findAllMovies(); break;
                case 2: mvs.searchMovie(chooseGenre()); break;
                case 3:
                    boolean loginSuccess = ms.loginMember(login());
                    if(!loginSuccess) {
                        System.out.println("다시 로그인 해주세요.");
                        break;}
                    Member currentMember = ms.getLoggedMember();
                    System.out.println("현재 로그인한 사용자: " + currentMember.getId());
                    loggedInMenu();
                    break;
                case 4: ms.registMember(signUp()); break;
                case 0:
                    System.out.println("영화 예매 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static void loggedInMenu() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("===== 영화 예매 프로그램 =====");
            System.out.println("1. 상영 중인 영화 목록 조회");
            System.out.println("2. 장르별 영화 검색");
            System.out.println("3. 영화 예매");
            System.out.println("4. 영화 예매 내역 조회");
            System.out.println("5. 영화 예매 취소");

            System.out.println("6. 내 정보 조회");
            System.out.println("7. 내 정보 수정");
            System.out.println("8. 회원 탈퇴");
            System.out.println("9. 로그아웃");

            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch(input){
                case 1: mvs.findAllMovies(); break;
                case 2: mvs.searchMovie(chooseGenre()); break;
                case 3: mvs.reserveMovie(chooseMovie()); break;
                case 4:
                    mvs.findMemberForReservation(chooseMemNo());
                    break;
                case 5: mvs.cancelReserveMovie(); break;
                case 6: ms.findMyProfile(); break;
                case 7:
                    Member selected = ms.findMemberForMod(chooseMemNo());
                    if (selected == null) continue;
                    ms.modifyMyProfile(reform(selected));
                    break;
                case 8: ms.removeMember(chooseMemNo()); break;
                case 9: ms.logoutMember(); return;
                case 0:
                    System.out.println("영화 예매 프로그램을 종료합니다."); System.exit(0);
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");

            }
        }
    }

    private static Member login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine().trim();

        System.out.print("비밀번호를 입력하세요: ");
        String pwd = sc.nextLine().trim();

        return new Member(id, pwd );
    }

    private static Member reform(Member modifyMember) {
        return modifyMember;
    }

    private static Member signUp() {
        Member member = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.print("생년월일을 입력하세요(YYYYMMDD): ");
        String birth = sc.nextLine();
        while(birth.length() != 8){
            System.out.println("생년월일을 잘못입력하셨습니다.");
            System.out.print("생년월일을 입력하세요(YYYYMMDD): ");
            birth = sc.nextLine();
        }

        member = new Member(id, pwd, birth);

        return member;
    }

    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호를 입력하세요: ");
        return sc.nextInt();
    }

    private static Movie chooseMovie() {
        Movie movie = null;
        return movie;
    }

    private static Genre chooseGenre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[ COMEDY / ROMANCE / HORROR / SF / ACTION / FANTASY / THRILLER ");
        System.out.println("/ DOCUMENTARY / ANIMATION / MUSICAL / HISTORICAL / WAR ]");
        System.out.print("원하는 장르를 입력하세요: ");
        String genre = sc.nextLine().toUpperCase();
        Genre gr = null;
        switch (genre) {
            case "COMEDY": gr = Genre.COMEDY; break;
            case "ROMANCE":gr = Genre.ROMANCE; break;
            case "HORROR": gr = Genre.HORROR; break;
            case "SF": gr = Genre.SF; break;
            case "ACTION": gr = Genre.ACTION; break;
            case "FANTASY": gr = Genre.FANTASY; break;
            case "THRILLER": gr = Genre.THRILLER; break;
            case "DOCUMENTARY": gr = Genre.DOCUMENTARY; break;
            case "ANIMATION": gr = Genre.ANIMATION; break;
            case "MUSICAL": gr = Genre.MUSICAL; break;
            case "HISTORICAL": gr = Genre.HISTORICAL; break;
            case "WAR": gr = Genre.WAR; break;
        }
        return gr;
    }
}