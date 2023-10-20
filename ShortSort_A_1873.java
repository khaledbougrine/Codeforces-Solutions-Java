import java.io.IOException;
import java.util.Scanner;

/**
 * Solution for Codeforces Problem - A. Short Sort
 * <p>
 * Problem Description:
 * There are three cards with letters a, b, c placed in a row in some order.
 * You can swap two cards at most once. Determine if it's possible to arrange
 * the cards in the order abc after at most one swap.
 * <p>
 * Input:
 * The first line contains a single integer t (1≤t≤6) — the number of test cases.
 * The only line of each test case contains a single string consisting of each
 * of the three characters a, b, and c exactly once, representing the cards.
 * <p>
 * Output:
 * For each test case, output "YES" if you can make the row abc with at most one operation, or "NO" otherwise.
 * The output can be in any case.
 */
public class ShortSort_A_1873 {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume the newline character after reading the integer

        for (int i = 0; i < t; i++) {
            var abc = scanner.nextLine(); // Input string representing the cards
            // Check if swapping a, b, c to their correct positions is possible with at most one operation
            if (abc.indexOf("a") == 0 || abc.indexOf("b") == 1 || abc.indexOf("c") == 2) {
                System.out.println("YES"); // Output YES if possible
            } else {
                System.out.println("NO"); // Output NO if not possible
            }
        }
    }
}
