package com.notificationdunice.intensivgaponovl.sprin_boot_task.recursive_challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;

@Service
public class RecursiveTransactionService {
    private final RecursiveTransactionService self;

    @Autowired
    public RecursiveTransactionService(@Lazy RecursiveTransactionService self) {
        this.self = self;
    }

    public void startRecursiveProcess(int maxDepth) {
        System.out.println("Запуск рекурсии с глубиной " + maxDepth);
        self.recursiveMethod(1, maxDepth);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.SERIALIZABLE,
            rollbackFor = RuntimeException.class)
    public void recursiveMethod(int currentDepth, int maxDepth) {
        System.out.println("Транзакция на глубине: " + currentDepth);

        doBusinessLogic(currentDepth);

        if (currentDepth < maxDepth) {
            self.recursiveMethod(currentDepth + 1, maxDepth);
        } else {
            System.out.println("Достигнута максимальная глубина рекурсии: " + currentDepth);
        }
    }

    private void doBusinessLogic(int level) {
        System.out.println("Выполняется логика на уровне " + level);
        if (level == 3) {
            throw new RuntimeException("Искусственная ошибка " + level);
        }
    }
}
