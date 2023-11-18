import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Make_it_Alternating_C_1879 {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var nn = scanner.nextInt();
        scanner.nextLine();
        IntStream.range(0, nn).forEach((p) -> {
                    var s = scanner.nextLine();
                    Predicate<Integer> canPass = i -> i < s.length() - 1;
                    var indexS = 0;
                    var list = new ArrayList<Integer>();
                    while (canPass.test(indexS)) {
                        var n = theSame(s, indexS);
                        list.add(n);
                        indexS = indexS + n;
                    }
                    System.out.println(list.stream().filter(val -> 1 != val).map(val -> val - 1).collect(Collectors.summingInt(Integer::intValue)));
                    var repVal =list.stream().filter(val -> 1 != val).map(Make_it_Alternating_C_1879::calculateFactorial).toList(); // Multiply each element by 2 and then sum
                    var result  = 1;
                    for (var val :repVal) {
                        result= (int) (result+val);
                    }
                    System.out.println(calculateFactorial(result)%998244353);
//                    if(repVal==0){
//                        System.out.println(1);
//                    }else System.out.println(repVal);

                }

        );

    }


    public static Integer theSame(String suS, Integer index) {
        var count = 0;
        var firstChar = suS.charAt(index);
        while (index < suS.length() && suS.charAt(index) == firstChar) {
            count++;
            index++;
        }
        return count;
    }

    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

}
