package com.notificationdunice.intensivgaponovl.sprin_boot_task.reqst_interseper;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class HeaderReadingService {
    public void printHeader() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            HttpServletRequest request = attrs.getRequest();
            String header = request.getHeader("My-Header");
            System.out.println("Получен заголовок: My-Header = " + header);
        }
    }
}
