public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,1};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int init = 0;
        int middle = nums.length/2;
        int fin = nums.length-1;
        while (init < fin) {
            if (init+1==fin) {
                if(nums[init]>nums[fin]) {
                    init++;
                }
                break;
            }
//            int middle = (init+fin)/2;

            if (nums[init] < nums[middle] && nums[middle]>nums[fin]) {
                init = middle;
                middle = (middle+fin)/2;
            }
            else if (nums[init] > nums[middle] && nums[middle]<nums[fin]) {
                fin = middle;
                middle = (init+middle)/2;
            }
            else {
                fin = middle;
                middle = (init+middle)/2;
            }
        }
        return nums[init];
    }
}
