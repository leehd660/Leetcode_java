import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        boolean[] dp = new boolean[s.length()];
        for (int i=1; i<=s.length(); i++) {
            for (int index : list) {
                if (wordDict.contains(s.substring(index,i))) {
                    dp[i-1] = true;
                    list.add(i);
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }



//    시간초과 발생
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        boolean answer = false;
//        //
//        boolean check = true;
//        Set<String> set = new HashSet<>();
//        for (String word : wordDict) {
//            for (String ss : word.split("")) {
//                set.add(ss);
//            }
//        }
//        for (String ss : s.split("")) {
//            if (!set.contains(ss)) {
//                check = false;
//                break;
//            }
//        }
//        //
//        if (check) {
//            for (int i = 1; i <= s.length(); i++) {
//                String word = s.substring(0, i);
//                if (wordDict.contains(word)) {
//                    answer = FindWord(s, i, wordDict);
//                }
//                if (answer) break;
//            }
//            return answer;
//        }
//        else {
//            return check;
//        }
//    }
//    static boolean FindWord (String s, int index, List<String> wordDict) {
//        boolean answer = false;
//        if (index==s.length()) {
//            answer = true;
//        }
//        else {
//            for (int i = index + 1; i<= s.length(); i++) {
//                String word = s.substring(index, i);
//                if (wordDict.contains(word)) {
//                    answer = FindWord(s, i, wordDict);
//                }
//                if (answer) break;
//            }
//        }
//        return answer;
//    }
}
