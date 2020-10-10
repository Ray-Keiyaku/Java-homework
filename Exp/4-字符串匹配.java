import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
        if (strend(s, t)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean strend(String s, String t) {
        return s.lastIndexOf(t) == s.length() - t.length() ? true : false;
    }
}
