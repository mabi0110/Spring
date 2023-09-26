package com.example.studentmanager.views;

import com.example.studentmanager.model.Status;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.services.StudentService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "")
@PageTitle(value = "Home")
public class MainView extends VerticalLayout {

    private final StudentService studentService;
    private LogoLayout logoLayout;
    private Grid<Student> grid;

    public MainView(StudentService studentService){
        this.studentService = studentService;

        setSizeFull();
        setAlignItems(Alignment.CENTER);

        createFieldVariables();
        configureGrid();

        add(logoLayout, grid);

        loadStudents();
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("country", "zipCode");
        grid.addColumn(Student::getName).setHeader("Name");
        grid.addColumn(Student::getAge).setHeader("Age");
        grid.addComponentColumn(s -> {
            Icon icon;

            if (s.getStatus().getName().equals("ACTIVE")) {
                icon = VaadinIcon.CIRCLE.create();
                icon.setColor("green");
            } else if (s.getStatus().getName().equals("NOT ACTIVE")) {
                icon = VaadinIcon.CLOSE_CIRCLE.create();
                icon.setColor("red");
            } else {
                icon = VaadinIcon.CHECK_CIRCLE.create();
                icon.setColor("orange");
            }
            return icon;
        }).setHeader("Status");
    }

    private void loadStudents() {
        List<Student> students = studentService.findAll();
        grid.setItems(students);
    }

    private void createFieldVariables() {
        logoLayout = new LogoLayout();
        grid = new Grid<>(Student.class);
    }


}
