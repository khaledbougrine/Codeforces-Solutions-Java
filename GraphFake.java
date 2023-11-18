import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphFake {

    static Scanner scanner = new Scanner(System.in);

    static Integer n;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static void readGraph() {
        n = scanner.nextInt();
        IntStream.range(0, n+1).forEach(x -> graph.put(x, readNeighborhood(x)));

    }

    static List<Integer> readNeighborhood(Integer i) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            Integer x = scanner.nextInt();
            if (x != -1) {
                list.add(x);
            } else return list;
        }
    }


    public static void main(String[] args) {
        readGraph();
        System.out.println(graph);
//        System.out.println();
        var result = getPath(8,2,solve(8));
        Collections.reverse(result);
        System.out.println(result);
    }

    public static Map<Integer, Integer> solve(Integer s) {
        List<Boolean> visited = IntStream.range(0, n+1).boxed().map(x -> {
            return Boolean.FALSE;
        }).collect(Collectors.toList());
        Map<Integer,Integer> resultMap  = new HashMap<>();
        IntStream.range(0,n+1).boxed().forEach(x->resultMap.put(x,null));
//        List<Object> result = IntStream.range(0, n).boxed().map(x -> {
//            return null;
//        }).collect(Collectors.toList());;

        Queue<Integer> qq = new LinkedList<>();
        qq.offer(s);
        visited.set(s,Boolean.TRUE);
        while (!qq.isEmpty()) {
            var item = qq.poll();
            var neighbs = graph.get(item);
            neighbs.forEach(x -> {
                if (!visited.get(x)) {
                    visited.set(x, Boolean.TRUE);
                    qq.offer(x);
                    resultMap.replace(x, item);
                }

            });


        }
        return resultMap;

    }
    public static List<Integer> getPath(Integer s, Integer e,Map<Integer,Integer> map){
        var result = new ArrayList<Integer>();
        var x = e;
        while (true){
            if(x==null) return result;
            result.add(x);
            x=map.get(x);
        }

    }


}
