package com.notificationdunice.intensivgaponovl;

import com.notificationdunice.intensivgaponovl.sprin_boot_task.scope.DemoScopeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntensivGaponovLApplication implements CommandLineRunner {

    private final DemoScopeService demoScopeService;

    public IntensivGaponovLApplication(DemoScopeService demoScopeService) {
        this.demoScopeService = demoScopeService;
    }

    public static void main(String[] args) {

        SpringApplication.run(IntensivGaponovLApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        demoScopeService.runTreadScope();
    }
}
