package com.notificationdunice.intensivgaponovl.tasc1;

import java.util.List;

/**
 * Задача 1.4
 * Напишите метод для поиска наибольшего элемента в списке без использования методов max() и sort()
 */

public class FindMax {
    public void max(List<Integer> list) {
        int max = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(list.get(i)>max) {
                max = list.get(i);
            }
        }
        System.out.println("max = " +max);
    }
}
