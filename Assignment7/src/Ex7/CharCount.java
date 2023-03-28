package Ex7;

import java.io.IOException;

public class CharCount {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            try {
                int input = System.in.read();
                if (input == -1) {
                    break;
                }
                count++;
            } catch (IOException e) {
                System.err.println("Error reading input: " + e.getMessage());
                System.exit(1);
            }
        }
        System.out.println("Total characters entered: " + count);
    }
}