package com.example.studentmanager.views;

import com.example.studentmanager.model.Status;
import com.example.studentmanager.model.Student;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "")
@PageTitle(value = "Home")
public class MainView extends VerticalLayout {

    private Grid<Student> grid;

    public MainView(){
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Adam", 23, 21123, "Poland", new Status("ACTIVE")));
        grid = new Grid<>(Student.class);
        grid.setItems(students);

        add(grid);
    }


}
