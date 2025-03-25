package com.notificationdunice.intensivgaponovl.sprin_boot_task.reqst_interseper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

@Component
public class HeaderInjectFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {
            @Override
            public String getHeader(String name) {
                if ("My-Header".equalsIgnoreCase(name)) {
                    return "Привет";
                }
                return super.getHeader(name);
            }

            @Override
            public Enumeration<String> getHeaderNames() {
                List<String> names = Collections.list(super.getHeaderNames());
                names.add("My-Header");
                return Collections.enumeration(new HashSet<>(names));
            }

            @Override
            public Enumeration<String> getHeaders(String name) {
                if ("My-Header".equalsIgnoreCase(name)) {
                    return Collections.enumeration(List.of("Привет"));
                }
                return super.getHeaders(name);
            }
        };

        filterChain.doFilter(wrapper, response);
    }
}