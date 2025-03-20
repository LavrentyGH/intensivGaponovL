package com.notificationdunice.intensivgaponovl.tasc2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;


/**
 * Задача 2.2
 * Запустите выполнение двух произвольных задач при помощи ForkJoinPool и параллельного стрима, полученные
 * результаты сложите в третьем потоке. Используйте CompletableFuture.
 */

public class ForkJoinExample {
    public void forkJoin () throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() ->
                forkJoinPool.invoke(new RecursiveTask<>() {
                    @Override
                    protected Integer compute() {
                        return IntStream.rangeClosed(1, 10_000).sum();
                    }
                })
        );
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() ->
                forkJoinPool.invoke(new RecursiveTask<>() {
                    @Override
                    protected Integer compute() {
                        return IntStream.rangeClosed(1, 1000).parallel().map(n -> n *n).sum();
                    }
                })
        );
        CompletableFuture<Integer> resultTask = task1.thenCombineAsync(task2, Integer::sum);
        System.out.println("Результат: " + resultTask.get());
        forkJoinPool.shutdown();
    }
}
