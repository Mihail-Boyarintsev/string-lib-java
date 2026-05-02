package com.example.stringlib;
/**
 * Поиск наибольшей общей подстроки (Longest Common Substring) двух строк.
 * Реализован методом динамического программирования с оптимизацией до O(n * m)
 * по времени и O(min(n, m)) по памяти (две строки). Возвращает саму подстроку.
 */
public class LongestCommonSubstring {
    /**
     * Возвращает наибольшую общую подстроку строк a и b.
     * Если общих символов нет, возвращает пустую строку.
     */
    public static String find(String a, String b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Аргументы не должны быть null");

        int n = a.length();
        int m = b.length();
        if (n == 0 || m == 0) return "";

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        int maxLen = 0;
        int endPosA = 0; // конец подстроки в строке a (для извлечения)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    if (curr[j] > maxLen) {
                        maxLen = curr[j];
                        endPosA = i; // индекс окончания в a
                    }
                } else {
                    curr[j] = 0;
                }
            }
            // сдвиг строк
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return a.substring(endPosA - maxLen, endPosA);
    }
}
