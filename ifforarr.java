public class MovieChecker { // 클래스 선언: 프로그램의 기본 단위
    public static void main(String[] args) { // main 메서드: 자바 프로그램의 시작점

        // 영화 가격들을 저장한 배열
        int[] prices = {8000, 12000, 9500, 15000, 7000};

        // 비싸다고 판단할 기준 가격
        int threshold = 10000;

        // 배열에 들어있는 가격들을 하나씩 확인하기 위한 반복문
        for (int i = 0; i < prices.length; i++) {
            // 현재 영화의 번호와 가격을 출력
            System.out.print("영화 " + (i + 1) + "의 가격은 " + prices[i] + "원 → ");

            // 가격이 기준보다 크거나 같으면 "비쌈" 출력
            if (prices[i] >= threshold) {
                System.out.println("비쌈");
            } 
            // 기준보다 작으면 "적당함" 출력
            else {
                System.out.println("적당함");
            }
        }
    }
}
