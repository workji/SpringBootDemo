package org.example.controller;

import org.example.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/return")
public class ReturnTest {

    @GetMapping("/string")
    public String returnString() {
        return "StringTest";
    }

    @GetMapping("/object")
    public Student returnObject() {
        Student student = new Student(1, "zhangsan", 99.99, LocalDate.now());
        return student;
    }

    @GetMapping("/list")
    public List<Student> returnList() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "zhang", 99.99, LocalDate.now()));
        students.add(new Student(2, "wang", 99.99, LocalDate.now()));
        students.add(new Student(3, "li", 99.99, LocalDate.now()));
        students.add(new Student(4, "gao", 99.99, LocalDate.now()));
        return students;
    }

    @GetMapping("/map")
    public Map<String, Student> returnMap() {
        Map<String, Student> studentMap = new HashMap<String, Student>();
        studentMap.put("zhang", new Student(1, "zhang", 99.99, LocalDate.now()));
        studentMap.put("wang", new Student(2, "wang", 99.99, LocalDate.now()));
        studentMap.put("gao", new Student(4, "gao", 99.99, LocalDate.now()));
        return studentMap;
    }

    @GetMapping("/object-map")
    public Map<String, Object> returnObjectMap() {
        Map<String, Object> studentMap = new HashMap<String, Object>();

        // String
        studentMap.put("stringName", "zhang");

        // Student
        studentMap.put("student", new Student(4, "gao", 99.99, LocalDate.now()));

        // list
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "zhang", 99.99, LocalDate.now()));
        students.add(new Student(2, "wang", 99.99, LocalDate.now()));
        students.add(new Student(3, "li", 99.99, LocalDate.now()));
        students.add(new Student(4, "gao", 99.99, LocalDate.now()));
        studentMap.put("list", students);

        return studentMap;
    }
}
