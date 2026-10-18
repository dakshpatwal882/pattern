//chatgpt soln 

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store value and original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = arr[i][0] + arr[j][0];

            if (sum == target) {
                return new int[]{arr[i][1], arr[j][1]};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}
//my soln 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int sum = nums[i]+nums[j];
       while(i!=j){
        if (sum ==target){
            return new int[]{i,j} ;
        }
        else if (sum>target){
            j--;
        }
        else{
            i++;
        }
       }
       return new int[]{0,1};
    }
}