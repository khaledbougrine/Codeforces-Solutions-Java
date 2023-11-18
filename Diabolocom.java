import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Diabolocom {

    static List<Integer> etfol1;
    static List<Integer> etfol2;
    static Integer k;
    static Integer n;
    static Scanner sc = new Scanner(System.in);

    static void readData() {
        etfol1 = new ArrayList<>();
        etfol2 = new ArrayList<>();
        n = sc.nextInt();
        k = sc.nextInt();
        IntStream.range(0, n).forEach(x -> etfol1.add(sc.nextInt()));
        IntStream.range(0, n).forEach(x -> etfol2.add(sc.nextInt()));
    }

    public static void main(String[] args) {
        readData();
        System.out.println(solve());
    }

    static Integer solve() {
        Map<Integer, Integer> reba71 = new HashMap<>();
        Map<Integer, Integer> reba72 = new HashMap<>();

        IntStream.range(0, n).forEach(i -> reba71.put(i, etfol1.get(i) - etfol2.get(i)));
        IntStream.range(0, n).forEach(i -> reba72.put(i, etfol2.get(i) - etfol1.get(i)));

//        System.out.println(reba71);
//        System.out.println(reba72);

        // sort the two Map by value
//          (new ArrayList<>(reba71.entrySet())).sort(Map.Entry.comparingByValue());
        List<Map.Entry<Integer,Integer>> tmpList1 = new ArrayList<>(reba71.entrySet());
        List<Map.Entry<Integer,Integer>> tmpList2 = new ArrayList<>(reba72.entrySet());

        tmpList1.sort(Map.Entry.comparingByValue());
        tmpList2.sort(Map.Entry.comparingByValue());

        IntStream.range(0, n).forEach(i -> {
            reba71.replace(tmpList1.get(i).getKey(), tmpList1.get(i).getValue());
            reba72.replace(tmpList2.get(i).getKey(), tmpList2.get(i).getValue());
        });

//        System.out.println(tmpList1);
//        System.out.println(tmpList2);

        var reba7Etfol1 = IntStream.range(0,k).boxed().map(tmpList1::get).map(Map.Entry::getKey).map(etfol1::get).mapToInt(Integer::intValue).sum();
        var reba7Etfol2 = IntStream.range(0,n-k).boxed().map(tmpList2::get).map(Map.Entry::getKey).map(etfol2::get).mapToInt(Integer::intValue).sum();

        return reba7Etfol1+reba7Etfol2;

    }
}
