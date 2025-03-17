package com.notificationdunice.intensivgaponovl.tasc2;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Задача 2.1
 * Создайте потокобезопасный сет из пакета java.util.concurrent из строк, заполните 32
 * произвольными строками. Также создайте переменную AtomicInteger со значением 0 и количество
 * потоков, равное числу элементов в сете, дайте им имена, соответственно равные элементам сета,
 * запустите их и заставьте main-поток ждать выполнения всех этих потоков. Каждый поток должен
 * запускать бесконечный цикл, внутри которого должен инкрементировать переменную AtomicInteger,
 * выводить в консоль "Работает имя потока", смотреть, есть ли в сете его имя (если есть, удалять
 * эту строку из сета и выводить в консоль "имя потока удаление выполнинл"), и проверять, пуст ли
 * сет (если пуст, прерывать цикл, иначе отдавать ресурсы другим потокам). После выхода из
 * ожидания main-поток должен выводить значение переменной AtomicInteger в формате "Количество
 * итераций потоков: значение".
 */

public class SetTreadSafeExam {
    public void ran() throws InterruptedException {
        Set<String> set = ConcurrentHashMap.newKeySet();

        for (int i = 1; i <= 32; i++) {
            set.add("Thread-" + i);
        }
        AtomicInteger iterationCounter = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(32);

        for (String threadName : set) {
            executorService.execute(() -> {
                Thread.currentThread().setName(threadName);
                while (true) {
                    iterationCounter.incrementAndGet();
                    System.out.println("Работает " + Thread.currentThread().getName());
                    if (set.remove(Thread.currentThread().getName())) {
                        System.out.println(Thread.currentThread().getName() + " удаление выполнено");
                    }
                    if (set.isEmpty()) {
                        break;
                    }
                    Thread.yield();
                }
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        System.out.println("Количество итераций потоков: " + iterationCounter.get());
    }
}
