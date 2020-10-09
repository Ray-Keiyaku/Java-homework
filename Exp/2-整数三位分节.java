import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        scanner.close();
        StringBuilder tmp = new StringBuilder();
        int len = num.length();
        if(len > 3){
            int first = len % 3;
            if (first == 0) {
                first = 3;
            }
            int i = 0;
            while (i < len - 2) {
                tmp.append(num.substring(i, first));
                tmp.append(",");
                i = first;
                first += 3;
            }
            tmp.deleteCharAt(tmp.length() - 1);
            System.out.println(tmp);
        }
        else{
            System.out.println(num);
        }
        
    }
}