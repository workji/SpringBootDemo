package org.example.controller;

import org.example.entity.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.example.entity.Result;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Test {

    @GetMapping("/ok01")
    public Result test01() {
        return new Result(0, "ok");
    }

    /*
        {
            "id": 1,
            "name": "gaaoさん",
            "score": 99,
            "birthday": "2023-10-10"
        }
     */
    @PostMapping("/ng01")
    public List<Result> test02(@RequestBody @Validated Student student, BindingResult bindingResult) {

        List<Result> result = new ArrayList<Result>();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getDefaultMessage());
                result.add(new Result(1, fieldError.getDefaultMessage()));
            }
        } else {
            result.add(new Result(0, "ok"));
        }

        return result;
    }
}
