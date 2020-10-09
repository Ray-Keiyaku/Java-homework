import java.util.*;

class Main{
    // 字串需要顺延的长度
    private static Map<String, Integer> widthEve = new HashMap<>();
    // 每次切割中子串的出现次数
    private static Map<String, Integer> countEve = new HashMap<>();
    public static void main(String[] args) {
        String[] str = new String[] { "abcabcedf", "abeabeefg", "bcdbcabec", "abcabcabde"};
        List<List<String>> list = cutStrings(str, 3, 3);
        System.out.println(list);
    }

    // 处理字符数组
    private static List<List<String>> cutStrings(String[] target, int width, int count) {
        if (count <= 0) {
            return new ArrayList<List<String>>();
        }
        boolean isComplete = false;
        List<List<String>> result = new ArrayList<>();
        while(!isComplete)
        {
            countEve.clear();
            result.clear();
            // 按指定长度切割字符串
            for (var item : target) {
                result.add(cutString(item, width));
            }
            // 遍历countEve，将出现次数过大的字串顺延+1
            isComplete = true;
            for (var item : countEve.entrySet()) {
                if (item.getValue() > count) {
                    widthEveIncrease(item.getKey().substring(0, width));
                    isComplete = false;
                }
            }
        }
        return result;
    }

    // 切割字符串
    private static List<String> cutString(String str, int width) {
        List<String> result = new ArrayList<>();
        int index = 0;
        String strNow;
        while (index < str.length()) {
            // 如果到达结尾则切割到结尾
            if (index + width > str.length()) {
                strNow = str.substring(index);
            }
            else {
                strNow = str.substring(index, index + width);
            }
            // 判断是否需要顺延
            if (widthEve.get(strNow)!=null) {
                // 如果到达结尾则切割到结尾
                int extraWidth = widthEve.get(strNow);
                int tmp = index + width + extraWidth > str.length() ? str.length() : index + width + extraWidth;
                strNow = str.substring(index, tmp);
            }
            result.add(strNow);
            countEveIncrease(strNow);
            index += width;
        }
        return result;
    }

    // 统计字符串出现的次数
    private static void countEveIncrease(String str) {
        if (countEve.get(str) != null) {
            countEve.put(str, countEve.get(str) + 1);
        } else {
            countEve.put(str, 1);
        }
    }
 
    // 统计子串需要顺延的长度
    private static void widthEveIncrease(String str) {
        if (widthEve.get(str) != null) {
            widthEve.put(str, widthEve.get(str) + 1);
        } else {
            widthEve.put(str, 1);
        }
    }
}