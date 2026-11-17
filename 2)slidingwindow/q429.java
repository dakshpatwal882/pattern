class Solution {
    public int characterReplacement(String s, int k) {

        // Left pointer of the sliding window
        int left = 0;

        // Maximum frequency of a single character in the window
        int maxFreq = 0;

        // Stores the maximum valid window length found so far
        int maxLength = 0;

        // Frequency array for 26 uppercase English letters (A-Z)
        int[] freq = new int[26];

        // Right pointer expands the sliding window one character at a time
        for (int right = 0; right < s.length(); right++) {

            // Get the current character
            char ch = s.charAt(right);

            // Increase the frequency of the current character
            // ch - 'A' converts the character into an index from 0 to 25
            freq[ch - 'A']++;

            // Update the highest frequency of any character seen so far
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Window length - maxFreq = minimum replacements required
            // If replacements needed exceed k, the window is invalid
            while ((right - left + 1) - maxFreq > k) {

                // Remove the leftmost character from the window's frequency count
                freq[s.charAt(left) - 'A']--;

                // Shrink the window by moving the left pointer forward
                left++;
            }

            // Calculate the current valid window length
            // Update maxLength if the current window is longer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the length of the longest valid substring
        return maxLength;
    }
}