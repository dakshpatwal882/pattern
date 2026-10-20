import java.util.HashMap;

class Solution {
    public int longestkSubstr(String s, int k) {
        int left = 0;                 // left end of the window
        int maxLen = -1;              // -1 means no valid substring found yet
        HashMap<Character, Integer> freq = new HashMap<>();  // char -> count inside window

        for (int right = 0; right < s.length(); right++) {
            // Expand: add the new character at 'right' to the window
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink: too many distinct characters, so move 'left' forward
            while (freq.size() > k) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);   // remove one occurrence of the left char
                if (freq.get(l) == 0) {
                    freq.remove(l);             // count hit 0, so it is no longer distinct
                }
                left++;                         // shrink the window from the left
            }

            // Window has at most k distinct chars; record length only if exactly k
            if (freq.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // Stays -1 if no substring with exactly k distinct characters exists
        return maxLen;
    }
}