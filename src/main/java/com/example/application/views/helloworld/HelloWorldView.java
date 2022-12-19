package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.time.LocalDate;

@PageTitle("Hello World")
@Route(value = "hello-world", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {
    public HelloWorldView() {
        setPadding(true);
        Binder<Person> binder = new Binder<>(Person.class);
        DatePicker datePicker1 = new DatePicker("Birthday (ref date 1.1.1920");
        datePicker1.setAutoOpen(false);
        binder.forField(datePicker1).bind("birthday1");
        DatePicker datePicker2 = new DatePicker("Birthday (ref date 1.1.1980");
        datePicker2.setAutoOpen(false);
        binder.forField(datePicker2).bind("birthday2");
        DatePicker datePicker3 = new DatePicker("Birthday (ref date 1.1.2040");
        datePicker3.setAutoOpen(false);
        binder.forField(datePicker3).bind("birthday2");
        setReferenceDate(datePicker1, 1920);
        setReferenceDate(datePicker2, 1980);
        setReferenceDate(datePicker3, 2040);
        Button validate = new Button("Validate", e -> {
            BinderValidationStatus<Person> status = binder.validate();
            Notification.show("validate.isOk() = " + status.isOk());
        });
        add(datePicker1, datePicker2, datePicker3, validate);
    }

    private static void setReferenceDate(DatePicker datePicker, int year) {
        DatePicker.DatePickerI18n datePickerI18n = new DatePicker.DatePickerI18n();
        datePickerI18n.setDateFormat("dd.MM.yy");
        datePickerI18n.setReferenceDate(LocalDate.of(year, 1, 1));
        datePicker.setI18n(datePickerI18n);
    }
}
