import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean a = scanner.nextInt() > 0;
        boolean b = scanner.nextInt() > 0;
        boolean c = scanner.nextInt() > 0;

        boolean firstCase = a && !b && !c;
        boolean secondCase = !a && b && !c;
        boolean thirdCase = !a && !b && c;

        System.out.println(firstCase || secondCase || thirdCase);
    }
}