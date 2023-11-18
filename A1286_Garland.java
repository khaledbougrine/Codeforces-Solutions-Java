import java.util.Scanner;

public class A1286_Garland {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        scanner.nextLine();
        var s = scanner.nextLine();
        int variation = 0;
        var isODD = false;
        var isEven = false;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)!='0'&& !isEven && !isODD){
                isEven = Integer.parseInt(String.valueOf(s.charAt(i))) /2==0;

            }




        }

    }
}
