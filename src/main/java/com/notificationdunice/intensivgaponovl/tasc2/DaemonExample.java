package com.notificationdunice.intensivgaponovl.tasc2;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Задача 2.3
 * Создайте демон-поток, который разблокируется каждый раз, когда вы вводите в консоль "ПОДЪЕМ", блокирует ваш поток,
 * отвечает "ОТБОЙ", отпускает ваш поток и блокируется. В остальное время он также должен быть заблокирован.
 * Используйте синхронизаторы.
 */

public class DaemonExample {
    public void demon() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    String command = queue.take();
                    if ("ПОДЪЕМ".equals(command)) {
                        System.out.println("ОТБОЙ");
                        synchronized (this) {
                            this.notifyAll();
                        }
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
                    queue.put(input);
                    synchronized (this) {
                        wait();
                    }
                }else if ("ВЫХОД".equals(input)) break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
