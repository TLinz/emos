package com.linzzxz.emos.config.shiro;

import org.springframework.stereotype.Component;

// 在Filter和AOP切面之间传递数据的媒介类
@Component
public class ThreadLocalToken {
    private final ThreadLocal<String> local = new ThreadLocal<>();

    public void setToken(String token) {
        local.set(token);
    }

    public String getToken() {
        return local.get();
    }

    public void clear() {
        local.remove();
    }
}
