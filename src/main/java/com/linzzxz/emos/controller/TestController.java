package com.linzzxz.emos.controller;

import com.linzzxz.emos.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api("test web api")
public class TestController {
    @GetMapping("sayHello")
    @ApiOperation("simple test method")
    public R sayhello() {
        return R.ok().put("msg", "Hello from the other side.");
    }
}
