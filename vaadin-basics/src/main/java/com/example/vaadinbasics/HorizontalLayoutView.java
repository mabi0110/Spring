package com.example.vaadinbasics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("/horizontal")
@PageTitle("Horizontal Layout")
public class HorizontalLayoutView extends HorizontalLayout {

    public HorizontalLayoutView(){

        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));

        setHeight("100%");

        // vertical alignment
        setAlignItems(FlexComponent.Alignment.CENTER);

        // horizontal alignment
        setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);

    }

}
