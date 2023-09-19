package com.example.vaadinbasics;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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

        add(span, button, nameField, saveButton);
    }



}
