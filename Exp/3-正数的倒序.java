import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String resu;
        Scanner scanner = new Scanner(System.in);
        resu = scanner.nextLine();
        scanner.close();
        int len = resu.length();
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(resu.charAt(i));
        }
    }
}