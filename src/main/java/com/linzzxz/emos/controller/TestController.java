package com.linzzxz.emos.controller;

import com.linzzxz.emos.common.util.R;
import com.linzzxz.emos.controller.form.TestSayHelloForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
@Tag(name = "test web api")
public class TestController {
    @PostMapping("sayHello")
    @Operation(summary = "simple test method")
    public R sayhello(@Valid @RequestBody TestSayHelloForm form) {
        return R.ok().put("message", "Hello from " + form.getName());
    }
}
