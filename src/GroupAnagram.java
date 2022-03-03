import java.util.ArrayList;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        int[][] table = new int[strs.length][26];
        for (int i=0; i< strs.length; i++) {
            for (String str : strs[i].split("")) {
                if (str.equals("")) {
                    continue;
                }
                else {
                    int index = str.charAt(0) - 'a';
                    table[i][index]++;
                }
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i=0; i< table.length; i++) {
            if (!visited[i]) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                visited[i] = true;
                for (int j=i+1; j<table.length; j++) {
                    if (!visited[j] && anagram(table, i,j)) {
                        list.add(strs[j]);
                        visited[j] = true;
                    }
                }
                answer.add(list);
            }
        }
        return answer;
    }
    static boolean anagram(int[][] table, int n1, int n2) {
        boolean answer = true;
        for (int i=0; i<26; i++) {
            if (table[n1][i] != table[n2][i]) {
                answer = false;
                break;
            }
        }
        return answer;
    }


//시간 초과 발생
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> answer = new ArrayList<>();
//        for (int i=0; i<strs.length; i++) {
//            if (answer.isEmpty()) {
//                List<String> list = new ArrayList<>();
//                list.add(strs[i]);
//                answer.add(list);
//            }
//            else {
//                //check가 false면 새로 리스트 만들기
//                boolean check = false;
//                for (List<String> list : answer) {
//                    if (anagram(list.get(0), strs[i])) {
//                        list.add(strs[i]);
//                        check = true;
//                        break;
//                    }
//                }
//                if (!check) {
//                    List<String> list = new ArrayList<>();
//                    list.add(strs[i]);
//                    answer.add(list);
//                }
//            }
//        }
//        return answer;
//    }
//    static boolean anagram (String str1, String str2) {
//        boolean answer = true;
//        Map<String, Integer> map1 = new HashMap<>();
//        for (String str : str1.split("")) {
//            if (!map1.keySet().contains(str)) {
//                map1.put(str, 1);
//            }
//            else {
//                map1.put(str, map1.get(str)+1);
//            }
//        }
//        for (String str : str2.split("")) {
//            if (!map1.keySet().contains(str)) {
//                answer = false;
//                break;
//            }
//            else {
//                map1.put(str, map1.get(str)-1);
//            }
//        }
//        for (String str : map1.keySet()) {
//            if (map1.get(str)!=0) {
//                answer = false;
//                break;
//            }
//        }
//        return answer;
//    }
}
