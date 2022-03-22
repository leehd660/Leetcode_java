public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }
    public static int search(int[] nums, int target) {
        int answer = -1;
        int start = 0;
        int fin = nums.length-1;
        while (start<=fin) {
            int mid = start + (fin-start)/2;
            if (nums[start] ==  target) {
                answer = start;
                break;
            }
            else if (nums[mid] == target) {
                answer = mid;
                break;
            }
            else if (nums[fin] == target) {
                answer = fin;
                break;
            }
            else {
                if (nums[start] < nums[mid] && nums[start]< target && nums[mid]>target) {
                    fin = mid-1;
                }
                else if (nums[start] > nums[mid] && (target<nums[mid] || target>nums[start])) {
                    fin = mid-1;
                }
                else if (nums[mid] < nums[fin] && target>nums[mid] && target<nums[fin]) {
                    start = mid+1;
                }
                else if (nums[mid] > nums[fin] && (target>nums[mid] || target<nums[fin])) {
                    start = mid+1;
                }
                else {
                    break;
                }
            }
        }
        return answer;
    }
}
