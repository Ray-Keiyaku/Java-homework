import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] range = new String[] { "6666666", "abcdefc", "acdefgh", "abce666", "abcdddd", "aabbccd", "acg6" };
        String target = new String("abcdefg");
        List<Pair> resu = getAllDistance(range, target, 6);
        printList(resu);
    }

    private static List<Pair> getAllDistance(String[] range, String target, int maxDistance) {
        List<Pair> result = new ArrayList<>();
        for (String it : range) {
            if (Math.abs(it.length() - target.length()) <= maxDistance) {
                int distance;
                if ((distance = getEditDistance(it, target)) <= maxDistance) {
                    result.add(new Pair(it, distance));
                }
            }
        }
        result.sort(null);
        return result;
    }

    private static int getEditDistance(String current, String target) {
        int[][] dp = new int[current.length() + 1][target.length() + 1];
        for (int i = 0; i < current.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < target.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < current.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                if (current.charAt(i) == target.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[current.length()][target.length()];
    }

    private static void printList(List<Pair> item) {
        System.out.println("Sort by EditDistance: ");
        for (Pair it : item) {
            System.out.println("String: " + it.getKey() + "\tEditDistance: " + it.getValue());
        }
    }
}

class Pair implements Comparable<Pair> {
    private String key;
    private Integer value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public int compareTo(Pair arg0) {
        return this.value.compareTo(arg0.getValue());
    }
}