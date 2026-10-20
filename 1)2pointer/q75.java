class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        // low: next position where a 0 should be placed (everything before it is 0)
        int low = 0;

        // mid: the element currently being examined
        int mid = 0;

        // high: next position where a 2 should be placed (everything after it is 2)
        int high = n - 1;

        // Elements from mid to high are still unprocessed
        while (mid <= high) {

            if (nums[mid] == 0) {
                // Case 0: move it to the front zone by swapping with nums[low]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // Grow the 0-zone, and move on. The value swapped into mid
                // came from the 1-zone (or is the same element), so it is safe to skip.
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                // Case 1: already in the correct middle zone, just move forward
                mid++;
            }
            else {
                // Case 2: move it to the back zone by swapping with nums[high]
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                // Shrink the unprocessed region from the right.
                // Do NOT move mid, because the value swapped in from high is
                // unknown and must be checked in the next iteration.
                high--;
            }
        }
        // Array is now sorted in place: all 0s, then 1s, then 2s
    }
}