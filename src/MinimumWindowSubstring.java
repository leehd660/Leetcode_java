import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        //t가 가지고 있는 문자들에 대해서 종류와 수를 map으로 정리
        Map<String, Integer> map = new HashMap<>();
        for (String tStr : t.split("")) {
            if (map.keySet().contains(tStr)) {
                map.put(tStr, map.get(tStr)+1);
            }
            else {
                map.put(tStr,1);
            }
        }
        //compareMap을 만들어서 map과 비교하도록 만든다.
        Map<String, Integer> compareMap = new HashMap<>();
        String answer = "";
        String checkStr = "";
        for (String str : s.split("")) {
            checkStr += str;
            if (compareMap.keySet().contains(str)) {
                compareMap.put(str, compareMap.get(str)+1);
            }
            else {
                compareMap.put(str,1);
            }

            if (!mapCheck(map, compareMap)) {
                continue;
            }
            else {
                while (mapCheck(map, compareMap)) {
                    if (answer.equals("")) {
                        answer = checkStr;
                    }
                    else {
                        if (answer.length() > checkStr.length()) {
                            answer = checkStr;
                        }
                    }
                    compareMap.put(checkStr.substring(0,1),compareMap.get(checkStr.substring(0,1))-1);
                    checkStr = checkStr.substring(1);
                }
            }
        }
        return answer;
    }
    static boolean mapCheck(Map<String,Integer> map, Map<String, Integer> compareMap) {
        boolean answer = true;
        for (String str : map.keySet()) {
            if (!compareMap.keySet().contains(str)) {
                answer = false;
                break;
            }
            else if (compareMap.get(str) < map.get(str)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
