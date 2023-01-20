package chucknorris;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {
    public static String stringToBinary(String s) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            String binary = Integer.toBinaryString(letter);
            binary = String.format("%07d", Integer.parseInt(binary));
            binaryString.append(binary);
        }
        return binaryString.toString();
    }

    public static String getFirstBlock(char c) {
        return c == '0' ? "00": "0";
    }

    public static String convertBinaryToChuckNorris(String binary) {
        StringBuilder chuckNorrisCypher = new StringBuilder();

        char prevBit = binary.charAt(0);
        chuckNorrisCypher.append(getFirstBlock(prevBit)).append(" ");

        for (int i = 0; i < binary.length(); i++) {
            final char bit = binary.charAt(i);
            if (bit != prevBit) {
                prevBit = bit;
                String nextBlock = " " + getFirstBlock(prevBit) + " " + "0";
                chuckNorrisCypher.append(nextBlock);
            } else {
                chuckNorrisCypher.append("0");
            }
        }
        return chuckNorrisCypher.toString();

    }

    public static String chuckNorrisToBinary(String enc) {
        String[] blocks = enc.split(" ");

        StringBuilder binary = new StringBuilder();
        String bit = blocks[0].equals("0") ? "1" : "0";

        for (int i = 0; i < blocks.length; i++) {

            if (i % 2 == 0) {
                bit = blocks[i].equals("0") ? "1" : "0";
            } else {
                int num = blocks[i].length();
                binary.append(bit.repeat(num));
            }
        }

        return binary.toString();

    }

    public static String[] splitBinary(String binary) {

        StringBuilder encoded = new StringBuilder();
        StringBuilder block = new StringBuilder();

        // split binary into blocks of 7
        int maxSize = 7;

        for (int i = 0; i < binary.length(); i++) {
            // System.out.println(i + ": " + binary.charAt(i));

            block.append(binary.charAt(i));

            if ((i+1) % maxSize == 0) {
                encoded.append(block.toString()).append(" ");
                block = new StringBuilder();
            }
        }

        return encoded.toString().trim().split(" ");
    }

    public static String binaryToString(String binary) {

        String[] encoded = splitBinary(binary);
        StringBuilder letters = new StringBuilder();

        for (String block : encoded) {

            // System.out.println(block);

            int binaryInt = Integer.parseInt(block, 2);
            byte binaryBytes = (byte) binaryInt;
            char letter = (char) binaryBytes;

            // System.out.println(letter);
            letters.append(letter);

        }

        return letters.toString();
    }

    public static boolean checkEncodedMessageIsValid(String encodedMessage, String decodedBinaryString) {
        // encoded message includes characters other than "0" or " "
        boolean hasValidChars = encodedMessage
                .replace("0", "")
                .replace(" ", "")
                .isEmpty();

        // encoded message starts with "0 " or "00 "
        boolean hasValidFirstBlock = encodedMessage.startsWith("0 ") ||
                encodedMessage.startsWith("00 ");

        // the number of blocks is odd
        boolean hasOddNumberOfBlocks =
                (encodedMessage.split(" ").length / 2) % 2 != 0;

        // length of decoded binary string is not a multiple of 7
        boolean decodedBinaryNotAMultipleOfSeven =
                decodedBinaryString.length() % 7 == 0;


        // System.out.println("input = " + encodedMessage);
        // System.out.println("binary = " + decodedBinaryString);
        // System.out.println("noOfBlocks = " + encodedMessage.split(" ").length);
        // System.out.println("binaryLength = " + decodedBinaryString.length());
        // System.out.println("hasValidChars = " + hasValidChars);
        // System.out.println("hasValidFirstBlock = " + hasValidFirstBlock);
        // System.out.println("hasOddNumberOfBlocks = " + hasOddNumberOfBlocks);
        // System.out.println("decodedBinaryNotAMultipleOfSeven = " + decodedBinaryNotAMultipleOfSeven);


        // combine all conditions to check if valid
        return hasValidChars &&
                hasValidFirstBlock &&
                hasOddNumberOfBlocks &&
                decodedBinaryNotAMultipleOfSeven;

    }

    public static void encode() {
        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // step #1: convert text to binary
        String binaryString = stringToBinary(input);

        // step #2: convert binary to Chuck Norris cypher
        String chuckNorrisCypher = convertBinaryToChuckNorris(binaryString);

        System.out.println("Encoded string:");
        System.out.println(chuckNorrisCypher.trim() + "\n");

    }

    public static void decode() {
        System.out.println("Input encoded string:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // step #1: convert Chuck Norris cypher to binary
        String binary = chuckNorrisToBinary(input);

        // step #2: check if input (+ decoded binary) are valid
        boolean isValid = checkEncodedMessageIsValid(input, binary);

        if (!isValid) {
            System.out.println("Encoded string is not valid.\n");

        } else {
            // step #3: convert binary to text
            String decoded = binaryToString(binary);
            System.out.println("Decoded string:");
            System.out.println(decoded.trim() + "\n");

        }
    }

    public static void exit() {
        System.out.println("Bye!");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("exit")) {

            System.out.println("Please input operation (encode/decode/exit):");
            choice = scanner.nextLine();

            switch(choice) {
                case "encode" -> encode();
                case "decode" -> decode();
                case "exit" -> exit();
                default -> System.out.println("There is no '" + choice + "' operation\n");
            }


        }

    }



}