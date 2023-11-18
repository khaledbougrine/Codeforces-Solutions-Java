import java.util.Scanner;
import java.util.stream.IntStream;

public class G_ABBCorBACB {

    static StringBuilder ab;
    static Integer firstvar;
    static Integer varNumber;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var testn = sc.nextInt();
        sc.nextLine();

        IntStream.range(0,testn).forEach(x->{
            ab = new StringBuilder(sc.nextLine());
            var abb = new StringBuilder(ab);
            var test1=oneCaseSolution(ab);
            abb.reverse();
            var tets2 = oneCaseSolution(abb);
            if(test1>tets2) System.out.println(test1);
            else System.out.println(tets2);
        });
    }
    static Integer oneCaseSolution(StringBuilder abtmp){
        var result = 0;

        while (true) {
            varfirst(abtmp) ;
            varNumber(abtmp);
            if(varNumber==0){
                return result;
            }else {
                var test =String.valueOf(abtmp.charAt(firstvar))+abtmp.charAt(firstvar+1);
                if(test.equals("AB")){
                    abtmp.setCharAt(firstvar,'B');
                    abtmp.setCharAt(firstvar+1,'C');
                    result=result+1;
                }
                else if((String.valueOf(abtmp.charAt(firstvar))+abtmp.charAt(firstvar+1)).equals("BA")){
                    abtmp.setCharAt(firstvar,'C');
                    abtmp.setCharAt(firstvar+1,'B');
                    result=result+1;
                }
            }

        }
    }

    static void varNumber(StringBuilder abtmp) {
        varNumber = 0;
        for (int i = 1; i < ab.length(); i++) {
            if ((abtmp.charAt(i) != abtmp.charAt(i - 1)) && (abtmp.charAt(i) !='C'&&abtmp.charAt(i-1) !='C')) {
                varNumber = varNumber + 1;
            }
        }
    }

    static void varfirst(StringBuilder abtmp) {
        for (int i = 1; i < ab.length(); i++) {
            if ((abtmp.charAt(i) != abtmp.charAt(i - 1)) && (abtmp.charAt(i) !='C'&&abtmp.charAt(i-1) !='C')) {
                firstvar = i -1;
                break;
            }
        }
    }
}
