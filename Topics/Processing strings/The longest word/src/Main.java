import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] words = input.split(" ");
        int maxLen = 0;
        int largestWordIdx = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            largestWordIdx = word.length() > maxLen ? i : largestWordIdx;
            maxLen = Math.max(word.length(), maxLen);

        }

        System.out.println(words[largestWordIdx]);

    }
}