package org.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private Double score;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Student() {
    }

    public Student(Integer id, String name, Double score, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", birthday=" + birthday +
                '}';
    }
}
