import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A1819 {
    final static Scanner sc = new Scanner(System.in);
    static List<Integer> caseList;
    static Integer listSize = 0;

    public static void readData() {
        caseList = new ArrayList<>();
        listSize = sc.nextInt();
        IntStream.range(0, listSize).forEach(i -> caseList.add(sc.nextInt()));
    }

    static Integer MEX() {
        var sortList = caseList.stream().collect(Collectors.toSet()).stream().toList();
        for (Integer i = 0; i < sortList.size(); i++) {
            if (sortList.get(i) != i) {
                return i;
            }
        }
        return sortList.size();
    }

    public static void main(String[] args) {
        readData();
        var MEX = MEX();
        var indexOfNumberGreaterThanMex = IntStream.range(0, listSize).filter(x -> caseList.get(x) > MEX).boxed().toList();
        var result = "no";
        for (int i = 1; i < indexOfNumberGreaterThanMex.size(); i++) {
            if (indexOfNumberGreaterThanMex.get(i) - indexOfNumberGreaterThanMex.get(i - 1)!=1){
                result="yes";
                break;
            }
        }
        System.out.println(result);
    }
}
