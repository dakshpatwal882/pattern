import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen = 0;   // best (longest) valid window found so far
        int left = 0;     // left edge of the window

        // basket: fruit type -> how many of that type are inside the window
        Map<Integer, Integer> basket = new HashMap<>();

        // right = right edge of the window; it moves forward one step at a time
        for (int right = 0; right < fruits.length; right++) {

            // STEP 1: EXPAND
            // Add fruits[right] to the basket.
            // getOrDefault gives 0 if the type is new, then we add 1.
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // STEP 2: SHRINK
            // We only have 2 baskets, so more than 2 types means the window is invalid.
            // "while" keeps removing from the left until it is valid again.
            while (basket.size() > 2) {
                int leftfruit = fruits[left];                        // fruit leaving the window

                basket.put(leftfruit, basket.get(leftfruit) - 1);    // reduce its count by 1

                if (basket.get(leftfruit) == 0) {
                    basket.remove(leftfruit);                        // count is 0, so delete the type
                }                                                    // (this makes size() drop)

                left++;                                              // move the left edge forward
            }

            // STEP 3: UPDATE ANSWER
            // The window is valid here, so its length is right - left + 1
            // (+1 because indexes start at 0).
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;    // longest valid window seen
    }
}