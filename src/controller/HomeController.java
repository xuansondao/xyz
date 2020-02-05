package controller;

public class HomeController {
    public static int lengthOfLongestSubstring(String s) {
        int[] flag = new int[127];
        int maxLengthSubString = -1;
        int count = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (flag[charArray[i]] == 0){
                charArray[i] = 1;
                count++;
            }
        }

        for (int i = 0; i < flag.length; i++) {
            System.out.print(flag[i] + " ");
        }

        return maxLengthSubString;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
}
