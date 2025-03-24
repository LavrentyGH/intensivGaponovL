package com.notificationdunice.intensivgaponovl.sprin_boot_task.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoScopeService {

    private final ObjectFactory<MyTreadScopeBean> beanObjectFactory;

    public DemoScopeService(ObjectFactory<MyTreadScopeBean> beanObjectFactory) {
        this.beanObjectFactory = beanObjectFactory;
    }

    public void runTreadScope () {
        Runnable task = () -> {
            MyTreadScopeBean bean = beanObjectFactory.getObject();
            System.out.println("Внутри потока" + Thread.currentThread().getName() + " bean = " + bean.getCreatedTime());

        };
        new Thread(task).start();
        new Thread(task).start();
    }
}
