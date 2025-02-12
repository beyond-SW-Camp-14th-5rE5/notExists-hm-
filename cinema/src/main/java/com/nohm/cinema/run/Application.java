package com.nohm.cinema.run;

import com.nohm.cinema.aggregate.Genre;
import com.nohm.cinema.service.MemberService;
import com.nohm.cinema.service.MovieService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();
    private static final MovieService mvs = new MovieService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("===== 영화 예매 프로그램 =====");
            System.out.println("1. 상영 중인 영화 목록 조회");
            System.out.println("2. 장르별 영화 검색");
            System.out.println("3. 영화 예매");
            System.out.println("4. 영화 예매 내역 조회");
            System.out.println("5. 영화 예매 취소");

            System.out.println("6. 회원 가입");
            System.out.println("7. 내 정보 조회");
            System.out.println("8. 내 정보 수정");
            System.out.println("9. 회원 탈퇴");
            
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch(input){
                case 1: mvs.findAllMovies(); break;
                case 2: mvs.searchMovie(chooseGenre()); break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9:
                    System.out.println("영화 예매 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");

            }
        }
    }

    private static Genre chooseGenre() {
        return null;
    }
}
