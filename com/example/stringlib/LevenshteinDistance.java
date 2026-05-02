package com.example.stringlib;
/**
 * Вычисляет редакционное расстояние (расстояние Левенштейна) между двумя строками.
 * Используется динамическое программирование, сложность O(n * m) по времени и
 * O(min(n, m)) по памяти (оптимизированная версия с двумя строками).
 */
public class LevenshteinDistance {
    /**
     * Возвращает минимальное количество операций вставки, удаления, замены символа,
     * необходимых для превращения строки a в b.
     */
    /**
     * Оптимизированная версия; также учтены исправлениям безопасности
     */
    public static int compute(CharSequence a, CharSequence b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Аргументы не должны быть null");

        int n = a.length();
        int m = b.length();

        // Оптимизация по памяти: храним только две строки
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // Инициализация первой строки
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                curr[j] = Math.min(prev[j] + 1,          // удаление
                          Math.min(curr[j - 1] + 1,      // вставка
                                   prev[j - 1] + cost)); // замена
            }
            // Обмен массивов для следующей итерации
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m];
    }
}
