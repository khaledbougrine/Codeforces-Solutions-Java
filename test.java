import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {
    static Integer n;
    static List<Integer> list;
    static Map<Integer, Integer> map;
    static Integer maxVar;
    final static Scanner scanner = new Scanner(System.in);

    static Integer result;


    private static void readOneTest() {
        list = new ArrayList<>();
        map = new TreeMap<>();
        n = scanner.nextInt();
        IntStream.range(0, n).forEach(i -> list.add(scanner.nextInt()));
        maxVar = n + n - 1;
        result = 0;
    }

    static IntPredicate isPleasantPairs(Integer j) {
//        System.out.println("joujou"+j);


        return (val) -> {
            var test = map.get(val) * map.get(j) == val + j;
//            System.out.println((map.get(val) * map.get(j))+"test"+val + j);
            return test;
        };
    }

    static Function<Integer, Long> iterationAndCount = (i) -> {
        var test= IntStream.range(i + 1, n + 1).filter(isPleasantPairs(i)::test).count();
        return test;


    };

    static Function onetest = (ntest -> {
        readOneTest();
        IntStream.range(0, n).forEach(i -> map.put(i + 1, list.get(i)));

        var sum = map.keySet().stream().map(iterationAndCount::apply).collect(Collectors.summingInt(Long::intValue));
        System.out.println(sum);
        return null;
    });

    public static void main(String[] args) {
        var nTest = scanner.nextInt();
        IntStream.range(0, nTest).forEach(onetest::apply);
    }
}
