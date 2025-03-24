package com.notificationdunice.intensivgaponovl.sprin_boot_task.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("myTreadScope")
public class MyTreadScopeBean {
    private final long createdTime = System.nanoTime();



    public MyTreadScopeBean() {
        System.out.println("MyTreadScopeBean createdTime: " + createdTime);
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
