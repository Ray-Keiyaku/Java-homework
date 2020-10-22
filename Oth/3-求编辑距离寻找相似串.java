import java.util.*;

class Main {
    public static void main(String[] args) {
        // 查找范围
        String[] range = new String[] { "6666666", "abcdefc", "acdefgh", "abce666", "abcdddd", "aabbccd", "acg6" };
        // 查找目标
        String target = new String("abcdefg");
        // 用于存储结果的键值对（Key：相似字符串，Value：编辑距离）
        List<Pair> resu = getAllDistance(range, target, 6);
        printList(resu);
    }

    // 获取所有符合要求的串并按EditDistance排序
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

    // 获取两个字符串间的编辑距离
    private static int getEditDistance(String current, String target) {
        int[][] dp = new int[current.length() + 1][target.length() + 1];
        // 初始化dp
        for (int i = 0; i < current.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < target.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < current.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                // 若两者相同则无需编辑
                if (current.charAt(i) == target.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 若两者不同则需要进行替换(i，j)，删除(i,j+1)或插入(i+1,j)操作，即找到最小编辑方法后+1
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[current.length()][target.length()];
    }

    // 打印排序后的查找结果
    private static void printList(List<Pair> item) {
        System.out.println("Sort by EditDistance: ");
        for (Pair it : item) {
            System.out.println("String: " + it.getKey() + "\tEditDistance: " + it.getValue());
        }
    }
}

// 定义Pair类并实现Comparable接口，用于存储字符串/编辑距离键值对，并对其排序
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