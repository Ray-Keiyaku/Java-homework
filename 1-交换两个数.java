
// http://219.216.96.176/assignment/programList.jsp?proNum=1&courseID=2&assignID=133
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int t = 0;
        t = a;
        a = b;
        b = t;
        System.out.println(a);
        System.out.println(b);
        scanner.close();
    }
}