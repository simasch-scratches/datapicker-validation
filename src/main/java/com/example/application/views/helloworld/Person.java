package com.example.application.views.helloworld;

import java.time.LocalDate;

public class Person {

    private LocalDate birthday1;
    private LocalDate birthday2;
    private LocalDate birthday3;

    public LocalDate getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(LocalDate birthday1) {
        this.birthday1 = birthday1;
    }

    public LocalDate getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(LocalDate birthday2) {
        this.birthday2 = birthday2;
    }

    public LocalDate getBirthday3() {
        return birthday3;
    }

    public void setBirthday3(LocalDate birthday3) {
        this.birthday3 = birthday3;
    }
}
