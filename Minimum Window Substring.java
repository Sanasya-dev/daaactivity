class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int count = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map[rightChar] > 0) {
                count--;
            }
            map[rightChar]--;
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
