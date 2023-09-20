package com.example.vaadinbasics;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("/hello")
@PageTitle("Vaadin Title")
public class MainView extends VerticalLayout {

    public MainView(){
        add(new Text("Hello world from Vaadin"));
        add(new Text("This is a text"));

        // We can use HTML and CSS related code to customize
        Span span = new Span("This is a span");
        span.getElement().getStyle().set("font-size", "23px");
        span.getElement().getStyle().set("font-weight", "bold");

        Button button = new Button("Click me", event -> {
            add(new Text("Button has been clicked "));
        });

        TextField nameField = new TextField("Name");
        nameField.setMinLength(3);
        nameField.setMaxLength(10);
        nameField.addValueChangeListener(event-> {
            System.out.println("The value has been changed");
        });

        Person person = new Person();

        // data binding
        Binder<Person> binder = new Binder<>();
        binder.bind(nameField, Person::getName, Person::setName);

        Button saveButton = new Button("Save", event-> {
            try {
                binder.writeBean(person);
                System.out.println(person);
            }
            catch(ValidationException e) {
                throw new RuntimeException(e);
            }
            add(new Text(nameField.getValue()));
        });

        TextArea textArea = new TextArea();
        textArea.setLabel("Description");
        textArea.setValue("Demonstration");
        textArea.setMaxLength(20);
        textArea.setHeight("200px");
        textArea.setWidth("200px");

        textArea.setValueChangeMode(ValueChangeMode.EAGER);

        textArea.addValueChangeListener(event -> {
            // this is called every time there is a change in the text area
            System.out.println("Something has been changed");
        });

        Checkbox checkBox = new Checkbox();
        checkBox.setLabel("I agree");
        checkBox.setEnabled(false);

        checkBox.addValueChangeListener(event-> {
            System.out.println(checkBox.getValue());
        });

        CheckboxGroup<String> group = new CheckboxGroup<>();
        group.setLabel("Days");
        group.setItems("Monday", "Tuesday", "Wednesday");
        group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        group.addValueChangeListener(event -> {
            System.out.println(group.getValue());
        });

        ComboBox<String> box = new ComboBox<>("Employee");
        box.setItems("Kevin", "Adam", "Anna");

        box.addValueChangeListener(event->{
            System.out.println(box.getValue());
        });


        List<Person> list = new ArrayList<>();
        list.add(new Person("Adam", "adam@example.com", 21));
        list.add(new Person("Anna", "anna@example.com",45));
        list.add(new Person("Kevin", "kevin@example.com",24));

        ComboBox<Person> peopleBox = new ComboBox<>("Employee");
        peopleBox.setItems(list);
        peopleBox.setPlaceholder("Select an employee");

        // specify what we want to show in ComboBox
        peopleBox.setItemLabelGenerator(p -> p.getName() + " / " + p.getAge());

        peopleBox.addValueChangeListener(event->{
            System.out.println(peopleBox.getValue());
        });

        List<Person> employee = new ArrayList<>();
        employee.add(new Person("Adam", "adam@example.com", 21));
        employee.add(new Person("Anna", "anna@example.com",45));
        employee.add(new Person("Kevin", "kevin@example.com",24));

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(Person::getName).setHeader("Name").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);
        grid.addColumn(Person::getEmail).setHeader("Email").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);
        grid.addColumn(Person::getAge).setHeader("Age").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);

        grid.setAllRowsVisible(true);
        grid.setItems(employee);

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        Button removeButton = new Button("Remove");
        removeButton.addClickListener(event -> {
            System.out.println(grid.getSelectedItems());
            employee.removeAll(grid.getSelectedItems());
            // refresh the grid
            grid.getDataProvider().refreshAll();
        });

        add(span, button, nameField, saveButton, textArea, checkBox, group, box, peopleBox, grid, removeButton);
    }



}
