package org.example.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Student {

    @NotNull(message = "IDが必須です。")
    private Integer id;

    @NotNull(message = "Nameが必須です。")
    @Pattern(regexp = "^.*さん$", message = "名前がサン終わりで記入必要です。")
    @Size(min = 4, max =8, message = "名前は4文字以上、8文字まで記入必要です。")
    private String name;

    @NotNull(message = "scoreが必須です。")
    @Positive(message = "点数が0以上を記入必要です。")
    @Range(min = 0, max = 100, message = "点数が0 - 100の間で記入必要です。")
    private Double score;

    @NotNull(message = "birthdayが必須です。")
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
