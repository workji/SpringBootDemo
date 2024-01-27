package org.example.controller;

import org.example.entity.Result;
import org.example.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @PostMapping("/test")
    public Result test01(@RequestBody @Validated Student student) {
        return new Result(0, "ok");
    }
}
