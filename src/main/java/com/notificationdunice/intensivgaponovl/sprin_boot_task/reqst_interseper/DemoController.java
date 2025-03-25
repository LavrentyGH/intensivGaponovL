package com.notificationdunice.intensivgaponovl.sprin_boot_task.reqst_interseper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final HeaderReadingService service;

    public DemoController(HeaderReadingService service) {
        this.service = service;
    }

    @GetMapping("/demo")
    public String demo() {
        service.printHeader();
        return "OK";
    }
}
