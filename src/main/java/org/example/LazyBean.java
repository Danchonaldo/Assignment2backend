package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LazyBean {
    public LazyBean() {
        System.out.println("LazyBean initialized");
    }
}
