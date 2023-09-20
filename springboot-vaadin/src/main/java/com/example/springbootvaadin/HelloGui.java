package com.example.springbootvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "hello")
@StyleSheet("/css/style.css")
public class HelloGui extends VerticalLayout {

    public HelloGui() {

        TextField textFieldName = new TextField("Input your name:");
        Button buttonHello = new Button("Hello", new Icon(VaadinIcon.ACADEMY_CAP));
        TextField textFieldHello = new TextField("Greetings");

        buttonHello.addClickListener(clickEvent -> {
            textFieldHello.setValue("Hello " + textFieldName.getValue());
            add(new Image("https://media.tenor.com/wiaZ6eyf11QAAAAM/hello-hi.gif", "Greeting image"));
        });

        add(textFieldName, buttonHello, textFieldHello);




    }


}
