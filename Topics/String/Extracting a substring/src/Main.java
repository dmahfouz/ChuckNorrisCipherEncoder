import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();
        int firstIdx = scanner.nextInt();
        int secondIdx = scanner.nextInt() + 1;

        String substring = text.substring(firstIdx, secondIdx);
        System.out.println(substring);
    }
}