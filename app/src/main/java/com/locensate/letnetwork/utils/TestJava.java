package com.locensate.letnetwork.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * $String
 *
 * @author xiaobinghe
 */

public class TestJava {

    public static String longestPalindrome(String string) {
        int len = string.length();
        String longest = "";
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                String temp = string.substring(i, j);
                if (isPalindrome(temp)) {
                    if ((j - i) > longest.length()) {
                        longest = temp;
                    }
                }
            }
        }
        return longest;
    }

    private String toChinese(String string) {
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

        String result = "";

        int n = string.length();
        for (int i = 0; i < n; i++) {

            int num = string.charAt(i) - '0';
            String temp = String.valueOf(string.charAt(i));
            int ns = Integer.parseInt(temp);


            if (i != n - 1 && num != 0) {
                result += s1[num] + s2[n - 2 - i];
            } else {
                result += s1[num];
            }
            System.out.println("  " + result);
        }

        System.out.println("----------------");
        System.out.println(result);
        return result;

    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static Map<Integer, Integer[]> getIndex(int origin, int[] arr) {
        HashMap<Integer, Integer[]> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

            }
        }
        return null;
    }

    public static int[] getIndex(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        int[] index = new int[2];
        while (l < r) {
            mid = (l + r) >> 1;
            if (arr[mid] == target) {
                break;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int maxIndex = 0;
        if (arr[mid] == target) {
            maxIndex = mid;
        } else {
            maxIndex = l;
        }
        l = 0;
        r = maxIndex;
        while (l < r) {
            if ((arr[l] + arr[r]) < target) {
                r--;
            } else if ((arr[l] + arr[r]) > target) {
                l++;
            } else {
                index[0] = l;
                index[1] = r;
                break;
            }
        }
        return index;
    }

    public static int binarySearch(Integer[] srcArray, int des) {

        int low = 0;

        int high = srcArray.length - 1;


        while ((low <= high) && (low <= srcArray.length - 1) && (high <= srcArray.length - 1)) {

            int middle = low + ((high - low) >> 1);

            if (des == srcArray[middle]) {

                return middle;

            } else if (des < srcArray[middle]) {

                high = middle - 1;

            } else {

                low = middle + 1;

            }

        }

        return -1;

    }
}
