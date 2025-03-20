package com.notificationdunice.intensivgaponovl.tasc1;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 1.3
 * Напишите метод для удаления дубликатов из списка целых чисел без
 * изменения порядка следования элементов.
 */
public class RemoveDuplicatesFromList {
    public Set<Integer> withoutChangingOrderElements(List<Integer> list) {
        return new LinkedHashSet<>(list);
    }
}
