import javax.management.QueryEval;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dijkstra {

    static Integer n;
    static Integer m;
    static Map<Integer, List<Node>> graph = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static void readData() {
        n = sc.nextInt();
        m = sc.nextInt();
        IntStream.range(1, n + 1).forEach(x -> graph.put(x, new ArrayList<>()));

        IntStream.range(0, m).forEach(x -> {
            Integer a = sc.nextInt();
            Integer b = sc.nextInt();
            Integer w = sc.nextInt();
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        });

    }

    public static void main(String[] args) {
        readData();
        var  result = getPath(1,n,solve(1));
        Collections.reverse(result);
        result.forEach(System.out::println);

    }
    public static List<Integer> getPath(Integer s, Integer e,Map<Integer,Integer> map) {
        if(map.get(e)==null) return List.of(-1);
        var result = new ArrayList<Integer>();
        var x = e;
        while (true) {
            if (x == null) return result;
            result.add(x);
            x = map.get(x);
        }


    }

    public static Map<Integer,Integer> solve(Integer s) {
//        List<Integer> result = Arrays.asList(new Integer[n]);
//        List<Integer> cost = Arrays.asList(new Integer[n]);

        Map<Integer,Integer> result = new HashMap<>();
        IntStream.range(1,n+1).boxed().forEach(i->result.put(i,null));

        Map<Integer,Integer> cost = new HashMap<>();
        IntStream.range(1,n+1).boxed().forEach(i->cost.put(i,null));

        List<Boolean> visted = IntStream.range(0,n).boxed().map(x->Boolean.FALSE).collect(Collectors.toList());
        Queue<Node> qq = new LinkedList<>();
        qq.offer(new Node(s, 0));
        cost.replace(s,0);
        while (!qq.isEmpty()) {
            var item = qq.poll();
            var neighborhoods = graph.get(item.x);
            neighborhoods.forEach(neighborhood-> {
                if(neighborhood.x!=item.x &&(cost.get(neighborhood.x) == null || cost.get(neighborhood.x)!=null&& cost.get(neighborhood.x) > neighborhood.cost+item.cost)) {
                    qq.offer(new Node(neighborhood.x, neighborhood.cost + item.cost));
                    result.replace(neighborhood.x, item.x);
                    cost.replace(neighborhood.x, neighborhood.cost + item.cost);
                }
            });

        }
        return result;
    }


    private static class Node {
        @Override
        public String toString() {
            return "x=" + x + " w=" + cost;
        }

        public Node(Integer x, Integer w) {
            this.x = x;
            this.cost = w;
        }
        Integer x;
        Integer cost;

    }
}
