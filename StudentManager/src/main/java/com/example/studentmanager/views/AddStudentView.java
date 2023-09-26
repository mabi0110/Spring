package com.example.studentmanager.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Add student")
@Route(value = "add-student")
public class AddStudentView extends VerticalLayout {

    public AddStudentView(){
        add(new Button("Click me"));
    }

}
