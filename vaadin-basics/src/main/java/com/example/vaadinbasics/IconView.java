package com.example.vaadinbasics;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/icon")
@PageTitle(("Icon view"))
public class IconView extends VerticalLayout {

    public IconView() {
        Icon capIcon = new Icon("vaadin", "academy-cap");
        Icon userIcon = new Icon("vaadin", "user");

        TextField nameField = new TextField("Name of user");
        nameField.setPrefixComponent(new Icon("vaadin", "user"));

        TextField ageField = new TextField("Age of user");
        ageField.setSuffixComponent(new Icon("vaadin", "user"));

        Image image = new Image("images/algorithm-logo.jpg", "Logo");
        image.setWidth("250px");
        image.setHeight("250px");
        add(capIcon, userIcon, nameField, ageField, image);
    }
}
