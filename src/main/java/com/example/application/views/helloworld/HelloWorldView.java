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
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

@PageTitle("Hello World")
@Route(value = "hello-world", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {
        setPadding(true);

        Binder<Person> binder = new Binder<>(Person.class);

        DatePicker datePicker = new DatePicker("Birthaday");
        datePicker.setAutoOpen(false);
        binder.forField(datePicker).bind("birthday");

        Button validate = new Button("Validate", e -> {
            BinderValidationStatus<Person> status = binder.validate();
            Notification.show("validate.isOk() = " + status.isOk());
        });

        FullCalendar calendar = FullCalendarBuilder.create().withScheduler().build();

        add(datePicker, validate, calendar);
    }

}
