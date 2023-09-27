package com.example.studentmanager.views;

import com.example.studentmanager.constants.Constants;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Set;

@PageTitle("Remove student")
@Route("remove-student")
public class RemoveStudentView extends VerticalLayout implements SelectionListener<Grid<Student>, Student> {


    private final StudentService studentService;
    private Grid<Student> grid;
    private Button remove;
    private Button cancel;
    private Set<Student> selected;

    public RemoveStudentView(StudentService studentService) {
        this.studentService = studentService;

        setSizeFull();
        setAlignItems(Alignment.CENTER);

        createFieldVariables();
        configureGrid();

        add(grid, createButtonLayout());

        loadStudents();
    }

    private void loadStudents() {
        grid.setItems(studentService.findAll());
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addSelectionListener(this);

    }

    private Component createButtonLayout() {
        remove.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        cancel.addClickListener(e -> closeView());
        remove.addClickListener(e -> removeSelected());
        return new HorizontalLayout(remove, cancel);
    }

    private void removeSelected() {
        selected.forEach(studentService::remove);
        Notification notification = Notification.show(Constants.STUDENT_REMOVED);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.TOP_CENTER);
        // remove the students from the grid (update the grid)
        grid.setItems(studentService.findAll());
    }


    private void closeView() {
        getUI().ifPresent(ui -> ui.navigate(""));
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

    private void createFieldVariables() {
        grid = new Grid<>(Student.class);
        remove = new Button(Constants.REMOVE);
        cancel = new Button(Constants.CANCEL);
    }

    @Override
    public void selectionChange(SelectionEvent<Grid<Student>, Student> selectionEvent) {
        selected = selectionEvent.getAllSelectedItems();
    }
}
