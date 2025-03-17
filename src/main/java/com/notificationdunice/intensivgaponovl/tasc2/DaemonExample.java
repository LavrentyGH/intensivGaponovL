package com.notificationdunice.intensivgaponovl.tasc2;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Задача 2.3
 * Создайте демон-поток, который разблокируется каждый раз, когда вы вводите в консоль "ПОДЪЕМ", блокирует ваш поток,
 * отвечает "ОТБОЙ", отпускает ваш поток и блокируется. В остальное время он также должен быть заблокирован.
 * Используйте синхронизаторы.
 */

public class DaemonExample {
    public void demon() {
        Exchanger<String> exchanger = new Exchanger<>();
        AtomicReference <CountDownLatch> countDownLatch = new AtomicReference<>(new CountDownLatch(1));

        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    String command = exchanger.exchange(null);
                    if ("ПОДЪЕМ".equals(command)) {
                        System.out.println("ОТБОЙ");
                        countDownLatch.get().countDown();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите команду: ");
                String input = scanner.nextLine();
                if ("ПОДЪЕМ".equals(input)) {
                    exchanger.exchange(input);
                    countDownLatch.get().await();
                    countDownLatch.set(new CountDownLatch(1));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
