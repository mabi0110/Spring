package com.example.studentmanager.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout {

    private Image image;

    public LogoLayout(){
        image = new Image("images/logo.png", "Logo image");
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(image);
    }
}
