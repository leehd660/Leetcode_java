import java.util.*;

public class ThreeSum {
    private static int num;
    private static List<Integer> list;
    private static List<List<Integer>> answerList;
    private static Set<List<Integer>> set;

    public List<List<Integer>> threeSum(int[] nums) {
        num = nums.length;
        Arrays.sort(nums);
        set = new HashSet<>();
        answerList = new ArrayList<>();
        for (int i=0; i<num; i++) {
            if (nums[i]>0) break;
            else {
                for (int j=i+1; j<num; j++) {
                    if (nums[i] + nums[j] >0) break;
                    else {
                        for (int k=j+1; k<num; k++) {
                            if (nums[i]+nums[j]+nums[k] == 0) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                set.add(list);
                            }
                            else if (nums[i]+nums[j]+nums[k] > 0) break;
                        }
                    }
                }
            }
        }
        // list = new ArrayList<>();
        // DFS(-1, 0, nums);
        answerList.addAll(set);
        return answerList;
    }
    // static void DFS(int index, int sum, int[] nums) {
    //     if (list.size() == 3) {
    //         if (sum == 0) {
    //             List<Integer> innerList = new ArrayList<>();
    //             for (int n : list) {
    //                 innerList.add(n);
    //             }
    //             set.add(innerList);
    //         }
    //     }
    //     else {
    //         for (int i=index+1; i<num; i++) {
    //             list.add(nums[i]);
    //             DFS(i, sum+nums[i], nums);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
}
