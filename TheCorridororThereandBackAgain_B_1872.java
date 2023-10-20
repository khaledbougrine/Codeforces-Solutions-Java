import java.util.Scanner;
import java.util.TreeMap;

/**
 * Solution for Codeforces Problem - B. The Corridor or There and Back Again
 * <p>
 * Problem Description:
 * Given traps in different rooms with parameters (di, si), find the maximum value of k
 * that allows you to travel to room k and return to room 1 without encountering an active trap.
 * <p>
 * Input:
 * The first line of the input contains an integer t (1≤t≤1000) — the number of test cases.
 * For each test case:
 * - The first line contains an integer n (1≤n≤100) — the number of traps.
 * - The following n lines present two integers di and si (1≤di,si≤200) — parameters of a trap.
 * <p>
 * Output:
 * For each test case, print the maximum value of k that allows you to travel to room k and return to room 1
 * without encountering an active trap.
 */
public class TheCorridororThereandBackAgain_B_1872 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        for (int i = 0; i < anInt; i++) {
            int numberOfTraps = scanner.nextInt();
            TreeMap<Integer, Integer> trapMap = new TreeMap<>();
            for (int j = 0; j < numberOfTraps; j++) {
                var key = scanner.nextInt();
                var value = scanner.nextInt();
                if (!trapMap.containsKey(key) || trapMap.containsKey(key) && trapMap.get(key) > value) {
                    trapMap.put(key, value);
                }
            }
            var distList = trapMap.keySet().stream().map(x -> {
                return x + (trapMap.get(x) - 1) / 2;
            }).toList();
            var expectedResult = distList.stream().findFirst().get();
            for (int j = 1; j < distList.size(); j++) {
                if (expectedResult > distList.get(j)) {
                    expectedResult = distList.get(j);
                }

            }
            System.out.println(expectedResult);
        }
    }

}
