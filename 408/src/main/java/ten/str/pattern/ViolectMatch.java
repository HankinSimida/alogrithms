package ten.str.pattern;

/**
 * @author hankin
 * @date 2020/10/7 15:17
 */
public class ViolectMatch {
    public static void main(String[] args) {
        String str1 = "ACSSSSCSDSWASDODMA";
        String str2 = "ACS";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
    }

    private static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0; // i指向str1
        int j = 0; // j指向str2
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
