import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    private static Map<Integer,List<Integer>> map;

    public static void main(String[] args) {
        int num = 3;
        int[][] arr = {{0,1},{1,2},{2,1}};
        System.out.println(canFinish(num,arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        //순환 아니면 true
        boolean answer = true;
        for (int i=0; i<prerequisites.length; i++) {
            int after = prerequisites[i][0];
            int before = prerequisites[i][1];
            if (before == after) {
                //당연히 안되는거니까 false
                answer = false;
                break;
            }
            else {
                if (!map.keySet().contains(before)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(after);
                    map.put(before,newList);
                    if (map.keySet().contains(after)) {
                        for (int subject : map.get(after)) {
                            if (!Check(subject,before)) {
                                answer = false;
                                break;
                            }
                            else {
                                answer = true;
                                continue;
                            }
                        }
                    }
                }
                else {
//                    List<Integer> list = map.get(before);
//                    list.add(after);
                    map.get(before).add(after);
//                    map.put(before,list);
                    if (map.keySet().contains(after)) {
                        for (int subject : map.get(after)) {
                            if (!Check(subject,before)) {
                                answer = false;
                                break;
                            }
                            else {
                                answer = true;
                            }
                        }
                    }
                }
            }
            if (!answer) {
                break;
            }
        }
        return answer;
    }

    static boolean Check (int subject, int find) {
        //true가 정답인거
        boolean answer = true;
        if (subject == find) {
            answer = false;
        }
        else {
            if (map.keySet().contains(subject)) {
                if (map.get(subject).contains(find)) {
                    answer = false;
                } else {
                    for (int nextSub : map.get(subject)) {
                        if (!Check(nextSub, find)) {
                            answer = false;
                            break;
                        } else {
                            answer = true;
                        }
                    }
                }
            } else {
                answer = true;
            }
        }
        return answer;
    }
}
