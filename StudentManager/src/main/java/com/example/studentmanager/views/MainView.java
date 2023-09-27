package com.example.studentmanager.views;

import com.example.studentmanager.constants.Constants;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import org.yaml.snakeyaml.scanner.Constant;

import java.text.MessageFormat;
import java.util.List;

@Route(value = "")
@PageTitle(value = "Home")
public class MainView extends VerticalLayout {

    private final StudentService studentService;
    private LogoLayout logoLayout;
    private Grid<Student> grid;
    private TextField filterField;

    private Checkbox themeToggle;

    private static boolean isSelected;

    public MainView(StudentService studentService){
        this.studentService = studentService;

        setSizeFull();
        setAlignItems(Alignment.CENTER);

        createFieldVariables();
        configureGrid();

        add(logoLayout, createToolBar(), grid);

        loadStudents();
    }

    private Checkbox createToggle() {
        themeToggle = new Checkbox(Constants.DARK_MODE);
        themeToggle.setValue(isSelected);
        themeToggle.addValueChangeListener(e -> {
            MainView.isSelected = !isSelected;
            setTheme(isSelected);
        });

        return themeToggle;
    }

    private void setTheme(boolean dark) {
        String js = MessageFormat.format("""
                document.documentElement.setAttribute("theme", "{0}")
                """, dark ? Lumo.DARK : Lumo.LIGHT);
        getElement().executeJs(js);
    }

    private Component createToolBar() {
        filterField.setPlaceholder(Constants.FILTER_NAME);
        filterField.setClearButtonVisible(true);
        filterField.setValueChangeMode(ValueChangeMode.LAZY);
        filterField.addValidationStatusChangeListener(e -> updateStudents());
        Button addStudentButton = new Button(Constants.ADD_STUDENT);
        Button removeStudentButton = new Button(Constants.REMOVE_STUDENT);

        addStudentButton.addClickListener(e ->
                getUI().ifPresent(ui -> ui.navigate("add-student")));

        removeStudentButton.addClickListener(e ->
                getUI().ifPresent(ui -> ui.navigate("remove-student")));


        return new HorizontalLayout(filterField, addStudentButton, removeStudentButton, createToggle());
    }

    private void updateStudents() {
        grid.setItems(studentService.find(filterField.getValue()));
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("country", "zipCode");
        grid.addColumn(Student::getName).setHeader(Constants.NAME);
        grid.addColumn(Student::getAge).setHeader(Constants.AGE);
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
        }).setHeader(Constants.STATUS);
    }

    private void loadStudents() {
        List<Student> students = studentService.findAll();
        grid.setItems(students);
    }

    private void createFieldVariables() {
        logoLayout = new LogoLayout();
        grid = new Grid<>(Student.class);
        filterField = new TextField();
    }


}
