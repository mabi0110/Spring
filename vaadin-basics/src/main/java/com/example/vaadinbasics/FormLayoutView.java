package com.example.vaadinbasics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("/form")
@PageTitle("Form Layout")
public class FormLayoutView extends FormLayout {

    public FormLayoutView(){

        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        PasswordField confirm = new PasswordField("Confirm password");

        setResponsiveSteps(
                new ResponsiveStep("0px", 1),
                new ResponsiveStep("1500px", 2));

        // we stretch the username field component to 2 columns
        setColspan(userName, 2);

        add(firstName, lastName, userName, password, confirm);

    }

}
