import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.Integer.*;

public class CountTest {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        sc.nextLine();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        String st = null;
        for (int i = 0; i < n; i++) {
            st = sc.nextLine();
            var SYTRINS =st.split(" ");
            var x = parseInt(st.substring(2,st.indexOf(" ",2)+2));
            var y = parseInt(st.substring(4));
            Predicate<Map.Entry<Integer, Integer>> isFounded = entry -> (entry.getValue() == y) && (entry.getKey() == x);
            if (st.charAt(0) == '+') list.add(Map.entry(x, y));
            else{
                list.stream().filter(isFounded).findFirst().map(item->list.remove(item));
            }
            iFind(list);
        }


//        iFind(List.of(Map.entry(1,2),Map.entry(1,3),Map.entry(2,2)));


    }

    static void iFind(List<Map.Entry<Integer,Integer>> list){
        boolean JeTrouver = false;
        for (int j = 0; j < list.size()-1; j++) {
            var maptmp = list.get(j);
            for (int k = j + 1; k < list.size(); k++) {
                var test = max(maptmp.getKey(), maptmp.getValue()) < min(list.get(k).getKey(), list.get(k).getValue()) ||
                        min(maptmp.getKey(), maptmp.getValue()) > max(list.get(k).getKey(), list.get(k).getValue());
                if (test) {
                    JeTrouver = true;
                    break;
                }
            }
            if (JeTrouver == true) {
                System.out.println("YES");
                break;
            }
        }
        if (JeTrouver == false) System.out.println("NO");
    }
}

