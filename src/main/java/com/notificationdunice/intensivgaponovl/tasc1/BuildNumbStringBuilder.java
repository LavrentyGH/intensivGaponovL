package com.notificationdunice.intensivgaponovl.tasc1;


/**
 * Задача 1.2
 * Напишите программу на Java, которая строит строку, содержащую числа от 1 до 100, разделенные
 * запятыми. Используйте StringBuilder для построения строки. Выведите результирующую строку.
 */
public class BuildNumbStringBuilder {
    public void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            sb.append(i);
            if (i < 100) {
                sb.append(",");
            }
        }

        System.out.println(sb);
    }
}
