package com.linzzxz.emos.controller;

import com.linzzxz.emos.common.util.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "test web api")
public class TestController {
    @GetMapping("sayHello")
    @Operation(summary = "simple test method")
    public R sayhello() {
        return R.ok().put("msg", "Hello from the other side.");
    }
}
