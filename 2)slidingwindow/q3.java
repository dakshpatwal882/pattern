import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Store each character and its frequency in the current window
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;       // Starting index of the sliding window
        int maxLength = 0;  // Maximum length of a valid substring

        // Expand the window by moving right pointer
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character or increase its frequency
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If duplicates exist, shrink the window from the left
            // Window length > distinct character count means a duplicate exists
            while (map.size() < right - left + 1) {

                char leftChar = s.charAt(left);

                // Decrease frequency of the leftmost character
                map.put(leftChar, map.get(leftChar) - 1);

                // Remove character from map if its frequency becomes zero
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                // Move left pointer to shrink the window
                left++;
            }

            // Update maximum length of substring without repeating characters
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the longest valid substring length
        return maxLength;
    }
}