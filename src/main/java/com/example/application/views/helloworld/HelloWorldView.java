package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import java.time.LocalDate;

@PageTitle("Hello World")
@Route(value = "hello-world", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {
        setPadding(true);

        // Create a new calendar instance and attach it to our layout
        FullCalendar calendar = FullCalendarBuilder.create().build();
        calendar.setWidthFull();
        calendar.setHeight(500);

        Entry entry = new Entry();
        entry.setTitle("Some event");
        entry.setColor("#ff3333");

        entry.setStart(LocalDate.now().atTime(10, 0));
        entry.setEnd(entry.getStart().plusHours(2));

        calendar.addEntry(entry);

        add(calendar);
    }

}
