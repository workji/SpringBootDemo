package org.example.controller;

import org.example.entity.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/parameter")
public class ParameterTest {

    // http://localhost:8080/parameter/test01?name=good&score=100.00&birthday=2023-06-06&s_id=3
    @GetMapping("/test01")
    public Student test01(@RequestParam("s_id") Integer id, String name, Double score, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate birthday) {
        return new Student(id, name, score, birthday);
    }


    // http://localhost:8080/parameter/test02?name=good&score=100.00&birthday=2023-06-06&id=6
    @GetMapping("/test02")
    public Student test02(Student student) {
        return student;
    }

    /*
        Json Request

        {
            "name": "good",
            "score": 100.00,
            "birthday": "2023-06-06",
            "id": 3
        }
     */
    @GetMapping("/test03")
    public Map<String, Object> test03(@RequestBody Map<String, Object> map) {
        return map;
    }

    // http://localhost:8080/parameter/test04/1/zhang/M
    @GetMapping("/test04/{id}/{name}/{sex:M|F}")
    public String test04(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("sex") String sex) {
        return id + " " + name + " " + sex;
    }
}
