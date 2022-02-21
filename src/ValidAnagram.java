import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()==t.length()) {
            Map<String, Integer> map = new HashMap<>();
            for (String str : s.split("")) {
                if (map.keySet().contains(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            boolean answer = true;
            for (String str : map.keySet()) {
                if (t.chars().filter(c -> c == str.charAt(0)).count() != map.get(str)) {
                    answer = false;
                    break;
                }
            }
            return answer;
        }
        else {
            return false;
        }
    }
}
