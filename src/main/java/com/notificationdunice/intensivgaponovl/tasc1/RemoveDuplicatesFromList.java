package com.notificationdunice.intensivgaponovl.tasc1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 1.3
 * Напишите метод для удаления дубликатов из списка целых чисел без
 * изменения порядка следования элементов.
 */
public class RemoveDuplicatesFromList {
    public List<Integer> withoutChangingOrderElements(List<Integer> list) {
        Set<Integer> unique = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (unique.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
