import java.util.Scanner;

public class MirrorintheString_B_1616 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            var size = scanner.nextInt();
            scanner.nextLine();
            var s = scanner.nextLine();
            String subString = null;
            var flag = false;
            for (int j = 0; j < size - 1; j++) {
                if (s.charAt(j) < s.charAt(j + 1) || (j!=0 &&s.charAt(j) == s.charAt(j + 1)&&s.charAt(0) == s.charAt(j+1))
                        ||(j==0 && s.charAt(j) == s.charAt(j + 1))) {
                    subString = s.substring(0, j+1);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                subString = s;
            }
            StringBuffer result = new StringBuffer(subString);
            for (int k = 0; k < subString.length(); k++) {
                result.append(subString.charAt(subString.length() - k-1));
            }
            System.out.println(result.toString());
        }

    }
}
