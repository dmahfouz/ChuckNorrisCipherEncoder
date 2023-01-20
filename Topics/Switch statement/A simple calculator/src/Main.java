import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long firstNum = scanner.nextLong();
        String operator = scanner.next();
        long secondNum = scanner.nextLong();

        switch (operator) {
            case "+" -> System.out.println(firstNum + secondNum);
            case "-" -> System.out.println(firstNum - secondNum);
            case "*" -> System.out.println(firstNum * secondNum);
            case "/" -> System.out.println(secondNum == 0 ? "Division by 0!" : firstNum / secondNum);
            default -> System.out.println("Unknown operator");
        }

    }
}