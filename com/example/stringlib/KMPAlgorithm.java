package com.example.stringlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация алгоритма Кнута–Мориса–Пратта (КМП) для поиска всех вхождений
 * образца в тексте. Сложность O(n + m), где n — длина текста, m — длина образца.
 */

public class KMPAlgorithm {
    // Префикс-функция для образца
    private static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                k = pi[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(q)) {
                k++;
            }
            pi[q] = k;
        }
        return pi;   
    }

    /**
     * Возвращает список индексов начала всех вхождений pattern в text.
     * Индексация с 0. Если вхождений нет, список пуст.
     */
    public static List<Integer> search(String text, String pattern) {
        if (text == null || pattern == null)
            throw new IllegalArgumentException("Аргументы не должны быть null");
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return occurrences;  // пустой образец – не ищем

        int[] pi = computePrefixFunction(pattern);
        int q = 0; // количество совпавших символов
        for (int i = 0; i < n; i++) {
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = pi[q - 1];
            }
            if (pattern.charAt(q) == text.charAt(i)) {
                q++;
            }
            if (q == m) {
                occurrences.add(i - m + 1);
                q = pi[q - 1]; // продолжение поиска
            }
        }
        return occurrences;
    }

    /**
     * Возвращает количество вхождений pattern в text.
     */
    public static int countOccurrences(String text, String pattern) {
        return search(text, pattern).size();
    }
}
