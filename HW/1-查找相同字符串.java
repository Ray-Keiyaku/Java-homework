import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入目标字符串: ");
        String s1 = scanner.nextLine();
        String[] s = new String[100];
        int i = 0;
        System.out.println("输入要匹配的字符串: ");
        while (scanner.hasNextLine()) {
            s[i] = scanner.nextLine();
            i++;
        }
        System.out.println("匹配的字符串有：");
        for (int j = 0; j < i; j++) {
            if (s[j].equals(s1)) {
                System.out.printf("%d号字符串与目标匹配！\n", j);
            }
        }
        System.out.println("END");
        scanner.close();
    }
}