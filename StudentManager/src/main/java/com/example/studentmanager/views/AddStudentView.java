package com.example.studentmanager.views;

import com.example.studentmanager.model.Status;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.services.StatusService;
import com.example.studentmanager.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Add student")
@Route(value = "add-student")
public class AddStudentView extends VerticalLayout {

    private final StudentService studentService;

    private final StatusService statusService;

    private TextField age;
    private TextField zipCode;
    private TextField name;
    private TextField country;
    private ComboBox<Status> status;
    private LogoLayout image;
    private Button save;
    private Button close;
    private Student student;
    private Binder<Student> binder;

    public AddStudentView(StudentService studentService, StatusService statusService){
        this.studentService = studentService;
        this.statusService = statusService;

        setAlignItems(Alignment.CENTER);
        createVariables();
        createStatus();
        crateBinder();

        add(image);
        add(createFormLayout());
    }

    private void crateBinder() {
        student = new Student();
        binder = new BeanValidationBinder<>(Student.class);
        binder.bindInstanceFields(this);
    }

    private void createStatus() {
        List<Status> statusItems = statusService.findAll();
        status.setItems(statusItems);
        status.setValue(statusItems.get(0));
        status.setItemLabelGenerator(Status::getName);
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(name, age, country, zipCode, status, createButtons());
        return formLayout;
    }

    private Component createButtons() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        close.addClickListener(e -> closeView());
        save.addClickListener(e -> saveStudent());

        return new HorizontalLayout(save, close);
    }

    private void saveStudent() {
        try {
            binder.writeBean(student);
            studentService.save(student);
            clearFields();
            Notification notification = Notification.show("Student saved successfully");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.setPosition(Notification.Position.TOP_CENTER);
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields() {
        student = new Student();
        status.setValue(statusService.findAll().get(0));
        binder.getFields().forEach(HasValue::clear);
    }

    private void closeView() {
        getUI().ifPresent(ui -> ui.navigate(""));
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
