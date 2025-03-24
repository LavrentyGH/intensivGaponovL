package com.notificationdunice.intensivgaponovl.sprin_boot_task.recursive_challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recursive")
public class RecursiveController {

    private final RecursiveTransactionService service;

    public RecursiveController(RecursiveTransactionService service) {
        this.service = service;
    }

    @GetMapping("/start")
    public ResponseEntity<String> startRecursion(@RequestParam(defaultValue = "5") int depth) {
        try {
            service.startRecursiveProcess(depth);
            return ResponseEntity.ok("Рекурсия завершена");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка: " + e.getMessage());
        }
    }
}
