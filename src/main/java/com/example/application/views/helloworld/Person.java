package com.example.application.views.helloworld;

import java.time.LocalDate;

public class Person {

    private LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
