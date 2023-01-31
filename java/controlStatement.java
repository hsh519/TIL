import java.util.Scanner;

public class controlStatement {
    public static void main(String[] args) {
//        example1();
//        example2();
//        example3();
//        example4();
        example5();

    }
    public static void example1() {
        // 1부터 100까지 수 중 3의 배수의 총합 구하기
        int result = 0;
        for (int i=1; i<101; i++) {
            if(i % 3 == 0) {
                result += i;
            }
        }
        System.out.println("3의 배수의 합: " + result);
        System.out.println();
    }
    public static void example2() {
        // 주사위를 두개를 굴려 두 눈의 합이 5면 실행을 멈추기
        while(true) {
            int num1 = (int)(Math.random()*6)+1;
            int num2 = (int)(Math.random()*6)+1;

            System.out.println("(" + num1 + ", " + num2 + ")");
            if(num1 + num2 == 5) {
                break;
            }
        }
        System.out.println();
    }
    public static void example3() {
        // 4x + 5y = 60 의 해 구하기 (x, y <= 10)
        for (int x=0; x<11; x++) {
            for (int y=0; y<11; y++) {
                if(4*x + 5*y == 60) {
                    System.out.println("(" + x + ", " + y + ")");
                }
            }
        }
        System.out.println();
    }
    public static void example4() {
        /*
        *
        **
        ***
        ****
        *****
        */
        for(int i=1; i<6; i++) {
            System.out.println("*".repeat(i));
        }
        System.out.println();
    }
    public static void example5() {
        // 예금, 출금, 조회, 종료 기능을 제공하는 코드 작성
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);

        while(run) {
            System.out.println("--------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("--------------------------------");
            System.out.print("선택 > ");

            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.print("예금액>");
                    int plusMoney = scanner.nextInt();
                    balance += plusMoney;
                    System.out.println();
                    break;
                case 2:
                    System.out.print("출금액>");
                    int minusMoney = scanner.nextInt();
                    balance -= minusMoney;
                    System.out.println();
                    break;
                case 3:
                    System.out.println("잔고>" + balance);
                    System.out.println();
                    break;
                case 4:
                    run = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("숫자를 다시 입력해주세요.");
                    break;

            }
        }
        System.out.println("프로그램 종료");
    }
}
