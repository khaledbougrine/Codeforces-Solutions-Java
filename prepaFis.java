import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class prepaFis {

    public static void main(String[] args) {
        var list1 = List.of(5, 7, 12, 0, 1);
        var list2 = List.of(20, 1, 3, 10, 0);
        var k = 3;

        List<Map.Entry<Integer, Integer>> listmap = IntStream.range(0, list1.size()).boxed()
                .map(x -> Map.entry(x, list1.get(x) - list2.get(x))).collect(Collectors.toList());
        listmap.sort(Map.Entry.comparingByValue());
        Collections.reverse(listmap);

        List<Map.Entry<Integer, Integer>> listmap1 = IntStream.range(0, list1.size()).boxed()
                .map(x -> Map.entry(x, list2.get(x) - list1.get(x))).collect(Collectors.toList());
        listmap1.sort(Map.Entry.comparingByValue());
        Collections.reverse(listmap1);
        Integer s =0;
        for (int i = 0; i < k; i++) {
            var index = listmap.get(i).getKey();
            s=s+list1.get(index);
        }
        for (int i = 0; i < list1.size() -k; i++) {
            var index = listmap1.get(i).getKey();
            s=s+list2.get(index);
        }


        System.out.println(listmap);

        System.out.println(listmap1);
        System.out.println(s);
    }
}
