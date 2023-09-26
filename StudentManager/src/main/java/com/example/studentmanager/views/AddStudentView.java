package com.example.studentmanager.views;

import com.example.studentmanager.model.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Add student")
@Route(value = "add-student")
public class AddStudentView extends VerticalLayout {

    private TextField age;
    private TextField zipCode;
    private TextField name;
    private TextField country;
    private ComboBox<Status> status;
    private LogoLayout image;
    private Button save;
    private Button close;

    public AddStudentView(){
        setAlignItems(Alignment.CENTER);
        createVariables();

        add(image);
        add(createFormLayout());
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(name, age, country, zipCode, status, createButtons());
        return formLayout;
    }

    private Component createButtons() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        return new HorizontalLayout(save, close);
    }

    private void createVariables() {
        age = new TextField("Age");
        name = new TextField("Name");
        country = new TextField("Country");
        zipCode = new TextField("Zip code");
        status = new ComboBox<Status>("Status");
        image = new LogoLayout();
        save = new Button("Save");
        close = new Button("Cancel");
    }

}
