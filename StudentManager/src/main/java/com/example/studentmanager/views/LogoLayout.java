package com.example.studentmanager.views;

import com.example.studentmanager.constants.Constants;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout {

    private Image image;

    public LogoLayout(){
        image = new Image(Constants.LOGO_URL, "Logo image");
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(image);
    }
}
