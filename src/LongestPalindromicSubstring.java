public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbcccbbbcaa"));
    }
    public static String longestPalindrome(String s) {
        String answer = "";
        int len = s.length();
        if (len == 1) {
            answer = s;
        }
        else {
            boolean check = true;
            for (int i = len; i > 0; i--) {
                for (int j = 0; j <= len - i; j++) {
                    if (s.charAt(j) == s.charAt(j + i - 1)) {
                        if (i%2 == 0) {
                            for (int k =1; k<=i/2; k++) {
                                if (s.charAt(j+k) != s.charAt(j + i - 1 - k)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        else {
                            for (int k =1; k <i/2; k++) {
                                if (s.charAt(j+k) != s.charAt(j + i - 1 - k)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (check) {
                            answer = s.substring(j,i+j);
                            break;
                        }
                        else {
                            check = true;
                        }
                    }
                }
                if (check && !answer.equals("")) break;
            }
        }
        return answer;
    }
}
